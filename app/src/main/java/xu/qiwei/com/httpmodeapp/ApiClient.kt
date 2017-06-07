package xu.qiwei.com.httpmodeapp

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by xuqiwei on 17-6-5.
 */

interface ApiClient
{
    @GET("/api/{drug}/classify")
    fun reposForUser(
            @Path("drug") user: String
    ): Call<JsonElement>

    @POST("/api/Public/CheckUserIsValidWithCarInfo")
    fun login(@Body loginParam: LoginResult.LoginParams): Call<DataSource<LoginResult>>
    @GET("/api/MobileTransfer/GetTransferList")
    fun getTransFerList(transferParam: Transfer.TransferParam):Call<DataSource<List<Transfer>>>
}
