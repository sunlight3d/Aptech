package com.example.call_native_functions

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "call_native_functions"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->
            if (call.method == "getNativeMap") {
                // Nhận Map từ Flutter
                val args = call.arguments as? Map<String, Any>
                // Xử lý và trả về Map
                val response = mapOf(
                    "status" to "ok",
                    "received" to args,
                    "androidTime" to System.currentTimeMillis()
                )
                result.success(response)
            } else {
                result.notImplemented()
            }
        }
    }
}
