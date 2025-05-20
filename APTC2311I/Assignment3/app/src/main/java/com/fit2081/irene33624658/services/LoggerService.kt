package com.fit2081.irene33624658.services
import android.util.Log

class LoggerService private constructor() {
    companion object {
        private const val DEFAULT_TAG = "AppLogger"

        fun debug(message: String, tag: String = DEFAULT_TAG, throwable: Throwable? = null) {
            if (throwable != null) Log.d(tag, message, throwable)
            else                   Log.d(tag, message)
        }

        fun info(message: String, tag: String = DEFAULT_TAG, throwable: Throwable? = null) {
            if (throwable != null) Log.i(tag, message, throwable)
            else                   Log.i(tag, message)
        }

        fun warning(message: String, tag: String = DEFAULT_TAG, throwable: Throwable? = null) {
            if (throwable != null) Log.w(tag, message, throwable)
            else                   Log.w(tag, message)
        }

        fun error(message: String, tag: String = DEFAULT_TAG, throwable: Throwable? = null) {
            if (throwable != null) Log.e(tag, message, throwable)
            else                   Log.e(tag, message)
        }

        fun fatal(message: String, tag: String = DEFAULT_TAG, throwable: Throwable? = null) {
            if (throwable != null) Log.wtf(tag, message, throwable)
            else                   Log.wtf(tag, message)
        }
    }
}
