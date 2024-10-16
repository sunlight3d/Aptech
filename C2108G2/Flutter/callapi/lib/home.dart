import 'package:flutter/cupertino.dart';
import 'package:http/http.dart' as http;

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  void initState() {
    super.initState();
    fetchHealthStatus();
  }
  Future<void> fetchHealthStatus() async {
    try {
      final response = await http.get(
        Uri.parse('http://10.0.3.138:8099/api/v1/actuator/health'),
      );
      if (response.statusCode == 200) {
        print('haha');
      } else {
        print('Failed to fetch health status. Error: ${response.statusCode}');
      }
    } catch (e) {
      print('Failed to fetch health status. Exception: $e');
    }
  }
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Text('haha'),
    );
  }
}
