package xu.qiwei.com.httpmodeapp

import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

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
    fun getTransFerList(@QueryMap map: Map<String,String>):Call<DataSource<List<Transfer>>>
    @FormUrlEncoded
    @POST("/api/Public/CheckUserIsValidWithCarInfo")
    fun loginV2(@Field("LoginName") LoginName:String,
                @Field("Password") Password:String,
                @Field("PlateNumber")PlateNumber:String
    ):Observable<Response<JsonElement>>
    @POST("/api/Public/CheckUserIsValidWithCarInfo")
    fun loginV3(@Body loginParam: LoginResult.LoginParams):Observable<JsonElement>
    /*private String AppId = "PreHospitalCare";
        private String LoginName = "pad";
        private String Password = "202CB962AC59075B964B07152D234B70";
        private String PlateNumber = "6IuPRSAwQTEyNQ==";*/
}
