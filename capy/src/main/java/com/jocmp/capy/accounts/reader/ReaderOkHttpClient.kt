package com.jocmp.capy.accounts.reader

import com.jocmp.capy.AccountPreferences
import com.jocmp.capy.accounts.BasicAuthInterceptor
import com.jocmp.capy.accounts.httpClientBuilder
import okhttp3.OkHttpClient
import java.net.URI

internal object ReaderOkHttpClient {
    fun forAccount(path: URI, preferences: AccountPreferences): OkHttpClient {
        return httpClientBuilder(cachePath = path)
            .addInterceptor(
                BasicAuthInterceptor {
                    val username = preferences.username.get()
                    val password = preferences.password.get()

                    val secret = if (username.isEmpty() && password.isEmpty()) {
                        ""
                    } else {
                        password
                    }

                    "GoogleLogin auth=${secret}"
                }
            )
            .build()
    }
}
