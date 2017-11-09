package com.hodzi.stackviewer

import android.content.Context
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.lang.ref.WeakReference

class RequestHandler(context: Context) {
    private val contextWeakRef: WeakReference<Context> = WeakReference(context)

    private val responses: HashMap<String, String> = HashMap()

    init {
        responses.put("/answers?", "answers.json")
        responses.put("/questions?", "questions.json")
        responses.put("/tags?", "tags.json")
        responses.put("/users?", "users.json")
    }


    fun intercept(path: String): Boolean = responses.keys.any { path.contains(it) }

    fun proceed(request: Request, path: String): Response? {
        responses.keys.filter { path.contains(it) }
            .forEach { return createResponseFromAssets(request, responses[it]) }
        return null
    }

    private fun createResponseFromAssets(request: Request, assetPath: String?): Response {
        return try {
            val stream = contextWeakRef.get()?.assets?.open(assetPath)

            stream.use { inputStream ->
                if (inputStream != null) {
                    OkHttpResponse.success(request, inputStream)
                } else {
                    OkHttpResponse.error(request, 500, "null stream")
                }
            }
        } catch (e: IOException) {
            OkHttpResponse.error(request, 500, e.message!!)
        }
    }
}