package xu.qiwei.com.httpmodeapp

import okhttp3.Headers
import xu.qiwei.com.httpmodel.HttpRequest

/**
 * Created by xuqiwei on 17-6-5.
 */

object HttpRequestInstance {
    var httpRequest: HttpRequest
    var httpRequestForTG: HttpRequest

//    http://www.tngou.net/api/drug/classify

    init {
        val headers = Headers.Builder().add("Authorization", "Basic TWRzZC5QaGVwLkFwaTptZHNkLnBoZXAuYXBpLjIwMDUk")
                .add("UserName", "amp6eDE=")
                .add("LoginName", "amp6eDE=")
                .add("RequestSource", "VmVoaWNsZUFwcA==").build()
        httpRequest = HttpRequest.Companion.Builder()
                .setBaseUrlVoid("http://172.16.23.14:4500")
                .setHeadersVoid(headers)
                .build()
        httpRequestForTG = HttpRequest.Companion.Builder().setBaseUrlVoid("http://www.tngou.net/").build()

    }

    fun getInstance(): HttpRequestInstance {
        return this

    }

    fun createClient(): ApiClient {
        return httpRequest.createClient(ApiClient::class.java)
    }

}
