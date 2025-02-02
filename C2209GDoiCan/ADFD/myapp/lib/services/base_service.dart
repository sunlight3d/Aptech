import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;
import 'package:myapp/config.dart';
import 'package:myapp/repositories/local_storage_repository.dart';


enum HttpMethod { GET, POST, PUT, DELETE }

class ApiResponse {
  final dynamic data;
  final String message;

  ApiResponse({required this.data, required this.message});

  factory ApiResponse.fromJson(Map<String, dynamic> json) {
    return ApiResponse(
      data: json['data'],
      message: json['message'] ?? '',
    );
  }
}

class CustomException implements Exception {
  final int statusCode;
  final String message;

  static const int INTERNAL_SERVER_ERROR = 500;

  CustomException({required this.statusCode, required this.message});

  @override
  String toString() => 'Error: $message (Status: $statusCode)';
}

class BaseService {
  // Các giá trị mặc định, chỉ khởi tạo một lần
  static const String _defaultBaseURL = API_BASE_URL;
  static final http.Client _defaultHttpClient = http.Client();
  static final LocalStorageRepository _defaultLocalStorageRepository =
  LocalStorageRepository();

  final String baseURL;
  final http.Client httpClient;
  final LocalStorageRepository localStorageRepository;

  BaseService({
    String? baseURL,
    http.Client? httpClient,
    LocalStorageRepository? localStorageRepository,
  })  : baseURL = baseURL ?? _defaultBaseURL,
        httpClient = httpClient ?? _defaultHttpClient,
        localStorageRepository =
            localStorageRepository ?? _defaultLocalStorageRepository;

  /// 🔹 Hàm xử lý request API chung
  Future<ApiResponse> request({
    required String endpoint,
    required HttpMethod method,
    Map<String, dynamic>? requestData,
    String? token,
  }) async {
    int errorStatusCode = 200;
    try {
      late http.Response response;
      final headers = {
        'Content-Type': 'application/json; charset=UTF-8',
      };

      // Thêm token nếu có
      if (token != null) {
        headers['Authorization'] = 'Bearer $token';
      }

      // Xử lý request dựa trên phương thức HTTP
      Uri uri = Uri.parse('$baseURL/$endpoint');
      if (method == HttpMethod.GET && requestData != null) {
        uri = uri.replace(
          queryParameters:
          requestData.map((key, value) => MapEntry(key, value.toString())),
        );
      }

      switch (method) {
        case HttpMethod.GET:
          response = await httpClient.get(uri, headers: headers);
          break;
        case HttpMethod.POST:
          response = await httpClient.post(uri,
              headers: headers, body: jsonEncode(requestData));
          break;
        case HttpMethod.PUT:
          response = await httpClient.put(uri,
              headers: headers, body: jsonEncode(requestData));
          break;
        case HttpMethod.DELETE:
          response = await httpClient.delete(uri, headers: headers);
          break;
      }

      if (response.statusCode == 200) {
        return ApiResponse.fromJson(jsonDecode(response.body));
      } else {
        errorStatusCode = response.statusCode;
        throw CustomException(
          statusCode: errorStatusCode,
          message: jsonDecode(response.body)['message'] ?? 'Lỗi không xác định',
        );
      }
    } catch (e) {
      throw CustomException(
        statusCode: (e is CustomException && e.statusCode == errorStatusCode)
            ? errorStatusCode
            : CustomException.INTERNAL_SERVER_ERROR,
        message: e.toString(),
      );
    }
  }
}
