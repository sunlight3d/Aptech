package com.fit2081.irene33624658.services

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import java.lang.ref.WeakReference

object ToastService {
    private const val MIN_TOAST_INTERVAL_MS = 3000L

    private var contextRef: WeakReference<Context>? = null
    private val recentToasts = mutableMapOf<String, Long>()
    private val handler = Handler(Looper.getMainLooper())

    enum class Duration(val value: Int) {
        SHORT(Toast.LENGTH_SHORT),
        LONG(Toast.LENGTH_LONG)
    }

    /**
     * Initialize once with your Application context.
     * Using a WeakReference ensures we don’t leak if someone accidentally
     * passes an Activity or other Context subclass.
     */
    fun init(appContext: Context) {
        contextRef = WeakReference(appContext.applicationContext)
    }

    /** Core show method */
    fun show(
        message: String,
        duration: Duration = Duration.SHORT,
        throttle: Boolean = true
    ) {
        val ctx = contextRef?.get()
            ?: throw IllegalStateException("ToastService not initialized. Call init() in Application.onCreate()")

        val now = System.currentTimeMillis()
        if (throttle) {
            recentToasts[message]?.let { last ->
                if (now - last < MIN_TOAST_INTERVAL_MS) return
            }
        }

        recentToasts[message] = now
        handler.postDelayed({
            val cutoff = System.currentTimeMillis() - MIN_TOAST_INTERVAL_MS
            recentToasts.entries.removeIf { it.value < cutoff }
        }, MIN_TOAST_INTERVAL_MS)

        handler.post {
            Toast.makeText(ctx, message, duration.value).show()
        }
    }

    /** Convenience wrappers */
    fun showShort(message: String) = show(message, Duration.SHORT)
    fun showLong(message: String)  = show(message, Duration.LONG)
    fun showSuccess(message: String) = show("✔️ $message", Duration.SHORT)
    fun showError(message: String)   = show("❌ $message", Duration.LONG)
    fun showDebug(message: String)   = show("🐛 $message", Duration.SHORT, throttle = false)
}
