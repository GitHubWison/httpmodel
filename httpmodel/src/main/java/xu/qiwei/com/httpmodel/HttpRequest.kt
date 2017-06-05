package xu.qiwei.com.httpmodel

import okhttp3.Headers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by xuqiwei on 17-6-5.
 */

class HttpRequest() {
    var headers: Headers = Headers.of(mutableMapOf())
    var baseUrl: String = ""
    var retrofit: Retrofit? = null

    constructor(builder: HttpRequest.Companion.Builder) : this() {
        headers = builder.headers
        baseUrl = builder.baseUrl
        retrofit = builder.retrofit
    }

    fun <T> createClient(t: Class<T>): T {
        return retrofit?.create(t) as T

    }

    //    init {
//        val okhttpBuilder: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor({
//            chain ->
//            val original = chain.request()
//
//            val request = original.newBuilder().headers(headers).build()
//            chain.proceed(request)
//        })
//        val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//        retrofit = retrofitBuilder.client(okhttpBuilder.build()).build()
//    }
//    fun build(){
//
//    }
    companion object {


        class Builder {
            var headers: Headers = Headers.of(mutableMapOf())
            var baseUrl: String = ""
            var retrofit: Retrofit? = null
            fun setHeadersVoid(headersParam: Headers): Builder {
                headers = headersParam
                return this
            }

            fun setBaseUrlVoid(baseUrlParam: String): Builder {
                baseUrl = baseUrlParam
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
                retrofit = retrofitBuilder.client(okhttpBuilder.build()).build()
                return HttpRequest(this)
            }
        }
    }


//    fun <T> createClient(t: Class<T>): T {
//        return retrofit.create(t)
//
//    }


}

