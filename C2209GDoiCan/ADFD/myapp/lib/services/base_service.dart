import 'package:http/http.dart' as http;

class BaseService {
  final String baseURL;
  final http.Client httpClient;

  const BaseService({required this.baseURL, required this.httpClient});
}
