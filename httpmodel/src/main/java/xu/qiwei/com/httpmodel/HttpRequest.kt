package xu.qiwei.com.httpmodel

import okhttp3.Headers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by xuqiwei on 17-6-5.
 */

class HttpRequest() {
    var headers: Headers = Headers.of(mutableMapOf())
    var baseUrl: String = ""
    var retrofit: Retrofit? = null
    var timeout:Long = 8

    constructor(builder: HttpRequest.Companion.Builder) : this() {
        headers = builder.headers
        baseUrl = builder.baseUrl
        retrofit = builder.retrofit
        timeout = builder.timeout
    }

    fun <T> createClient(t: Class<T>): T {
        return retrofit?.create(t) as T
    }

    companion object {
        class Builder {
            var headers: Headers = Headers.of(mutableMapOf())
            var baseUrl: String = ""
            var retrofit: Retrofit? = null
            var timeout:Long=8
            fun setHeadersVoid(headersParam: Headers): Builder {
                headers = headersParam
                return this
            }

            fun setBaseUrlVoid(baseUrlParam: String): Builder {
                baseUrl = baseUrlParam
                return this
            }
            fun setTimeOutVoid(timeoutParam:Long): Builder{
                timeout = timeoutParam
                return this
            }

            fun build(): HttpRequest {
                val okhttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor({
                    chain ->
                    val original = chain.request()

                    val request = original.newBuilder().headers(headers).build()
                    chain.proceed(request)
                })
                val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                var okhttpClient:OkHttpClient = okhttpBuilder.connectTimeout(timeout,TimeUnit.SECONDS)
                        .build()
                retrofit = retrofitBuilder.client(okhttpClient).build()
                return HttpRequest(this)
            }
        }
    }


}

