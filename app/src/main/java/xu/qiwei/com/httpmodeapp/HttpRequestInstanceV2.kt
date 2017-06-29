package xu.qiwei.com.httpmodeapp

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by xuqiwei on 17-6-29.
 */

class HttpRequestInstanceV2 {

    //    companion object {
//        val instance:HttpRequestInstanceV2 by lazy {
//            HttpRequestInstanceV2()
//        }
//    }
    companion object {
        val retrofit: Retrofit by lazy {
            initBaseRetrofit()
        }
        val tngouRetorfit: Retrofit by lazy {
            initTnGouRetrofit()
        }

        private fun initTnGouRetrofit(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl("http://www.tngou.net")
                    .build()
        }

        private fun initBaseRetrofit(): Retrofit {
            val headers = Headers.Builder().add("Authorization", "Basic TWRzZC5QaGVwLkFwaTptZHNkLnBoZXAuYXBpLjIwMDUk")
                    .add("UserName", "amp6eDE=")
                    .add("LoginName", "amp6eDE=")
                    .add("RequestSource", "VmVoaWNsZUFwcA==").build()
            val builder = OkHttpClient.Builder()
            builder.addInterceptor({
                chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()
                val reqBody: RequestBody? = original.body()
//                添加统一的请求头
                val url: HttpUrl = originalHttpUrl
                        .newBuilder()
                        .addQueryParameter("AppId", "PreHospitalCare")
                        .addQueryParameter("PlateNumber", "6IuPRSAwQTEyNQ==").build()
                val request = original.newBuilder().headers(headers).url(url)
                if (reqBody != null && reqBody is FormBody) {
                    var formBuilder = FormBody.Builder().add("AppId", "PreHospitalCare")
                    (0..reqBody.size() - 1).forEach { formBuilder.add(reqBody.name(it), reqBody.value(it)) }
                    request.method(original.method(), formBuilder.build())
                }
                chain.proceed(request.build())
            })
            builder.connectTimeout(5, TimeUnit.SECONDS)

            return Retrofit.Builder()
                    .client(builder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("http://172.16.23.14:4500")
                    .build()
        }


    }


}
