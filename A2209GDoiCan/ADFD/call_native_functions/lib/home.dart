import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  static const _channel = MethodChannel('call_native_functions');
  Map<String, dynamic>? _nativeData;

  Future<void> _callNative() async {
    try {
      final Map<String, dynamic> params = {
        'message': 'Hello from Flutter',
        'value': 123,
      };
      // invokeMapMethod trả về Map<String, dynamic> hoặc null
      final result = await _channel.invokeMapMethod<String, dynamic>(
        'getNativeMap',
        params,
      );
      setState(() {
        _nativeData = result;
      });
    } on PlatformException catch (e) {
      setState(() {
        _nativeData = {
          'error': e.message ?? 'Unknown error',
        };
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Call Native Functions')),
      body: Center(
        child: _nativeData == null
            ? const Text('Chưa gọi tới native')
            : SingleChildScrollView(
          padding: const EdgeInsets.all(16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: _nativeData!.entries.map((entry) {
              return Text(
                '${entry.key}: ${entry.value}',
                style: const TextStyle(fontSize: 16),
              );
            }).toList(),
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _callNative,
        child: const Icon(Icons.play_arrow),
      ),
    );
  }
}