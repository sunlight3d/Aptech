package com.aptech.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "vnpay_payment"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "startVNPAYPayment") {
                val paymentUrl = call.argument<String>("paymentUrl")
                if (paymentUrl != null) {
                    startVNPAY(paymentUrl, result)
                } else {
                    result.error("INVALID_ARGUMENT", "Payment URL is required", null)
                }
            } else {
                result.notImplemented()
            }
        }
    }

    private fun startVNPAY(paymentUrl: String, result: MethodChannel.Result) {
        try {
            val intent = Intent(this, VNPAYPaymentActivity::class.java)
            intent.putExtra("paymentUrl", paymentUrl)
            startActivity(intent)
            result.success("VNPAY started successfully")
        } catch (e: Exception) {
            Log.e("VNPAY", "Error starting VNPAY", e)
            result.error("VNPAY_ERROR", "Failed to start VNPAY", null)
        }
    }
}