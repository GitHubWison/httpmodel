package xu.qiwei.com.httpmodeapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//http://www.tngou.net/api/drug/classify
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
//        refreshData()
    }

    private fun initViews() {
        var testTextview = findViewById(R.id.test_textview) as TextView
        testTextview.setOnClickListener { _ ->
            getDrugClassify()
        }
    }

    private fun getDrugClassify() {
//获得天狗药品分类
        HttpRequestInstance.getInstance().createTGClient().getDrugClassify("drug")
                .enqueue(TGCallback())
        /*object : Callback<TGDataSource<List<DrugClassify>>> {
                    override fun onFailure(call: Call<TGDataSource<List<DrugClassify>>>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<TGDataSource<List<DrugClassify>>>?, response: Response<TGDataSource<List<DrugClassify>>>?) {
                        if (response!=null) {
                            var  body = response.body()
                            if (body!=null) {
                                var data = body.tngou
                                if (data!=null) {
                                    Log.e("datasize",data.size.toString())
                                }
                            }
                        }
                    }
                }*/
    }

    private fun refreshData() {
        HttpRequestInstance.getInstance().createClient().login(LoginParam()).enqueue(object : Callback<DataSource<LoginResult>> {
            override fun onFailure(call: Call<DataSource<LoginResult>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DataSource<LoginResult>>?, response: Response<DataSource<LoginResult>>?) {
                if (response != null) {
                    val body = response.body()
                    if (body != null) {
                        val hosName = body.data?.hospitalName
                        Log.e("hosName", hosName)
                    }

                }
            }

        })
    }
    /*object : Callback<JsonElement> {
            override fun onFailure(call: Call<JsonElement>?, t: Throwable?) {
                if (t != null) {
                    Log.e("enqueue==", "onFailure" + t.message)
                }
            }
            override fun onResponse(call: Call<JsonElement>?, response: Response<JsonElement>?) {
                if (response != null) {

                    val loginResult  =
                            Gson().fromJson(response.body(),DataSource::class.java).data
                    val str = loginResult.toString()
                    val resultClass = Gson().fromJson(str,LoginResult::class.java)
//                    Log.e("enqueue==", loginResult.hospitalName)
                    Log.e("","")
                }
            }

        }*/
}
