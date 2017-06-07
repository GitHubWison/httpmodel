package xu.qiwei.com.httpmodeapp

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by xuqiwei on 17-6-5.
 */

interface GitHubClient {
    @GET("/api/{drug}/classify")
    fun reposForUser(
            @Path("drug") user: String
    ): Call<JsonElement>

}
