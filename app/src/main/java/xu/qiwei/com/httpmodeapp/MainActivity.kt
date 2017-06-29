package xu.qiwei.com.httpmodeapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.google.gson.JsonElement
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

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
            //            getDrugClassify()
            refreshData()
        }
    }

    private fun getDrugClassify() {
    }

    private fun refreshData() {
//                        .loginV2("pad", "202CB962AC59075B964B07152D234B70","6IuPRSAwQTEyNQ==")
//               .loginV3(LoginResult.LoginParams())
        HttpRequestInstanceV2
                .retrofit
                .create(ApiClient::class.java)
                .loginV2("pad", "202CB962AC59075B964B07152D234B70","6IuPRSAwQTEyNQ==")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<JsonElement> {
                    override fun onSubscribe(d: Disposable) {
                        "onSubscribe".printLog()
                    }

                    override fun onNext(list: JsonElement) {
                        list.toString().printLog()
                    }

                    override fun onError(e: Throwable) {
                        "onError".printLog()
                    }

                    override fun onComplete() {
                        "onComplete".printLog()
                    }
                })

//  Log.e("listleng=",it.size.toString())
//        HttpRequestInstance.getInstance().createClient().login(LoginResult.LoginParams())
//                .enqueue(DataCallBack(object : DataCallBack.HttpCallBackImpl<LoginResult>(){
//                    override fun onSuccess(t: LoginResult?) {
//                        super.onSuccess(t)
//                        Log.e("onSuccess","onSuccess")
////                        if (t != null) {
////                            netResult(t.size.toString()+"")
////                        }
//                    }
//
//                    override fun onServerError(msg: String?) {
//                        super.onServerError(msg)
//                        if (msg != null) {
//                            netResult(msg)
//                        }
//                    }
//                }))
        /*HttpRequestInstance.getInstance().createClient().getTransFerList(Transfer.TransferParam().generateMap())
                .enqueue(DataCallBack(object : DataCallBack.HttpCallBackImpl<List<Transfer>>(){
                    override fun onSuccess(t: List<Transfer>?) {
                        super.onSuccess(t)
                        if (t != null) {
                            netResult(t.size.toString()+"")
                        }
                    }

                    override fun onServerError(msg: String?) {
                        super.onServerError(msg)
                        if (msg != null) {
                            netResult(msg)
                        }
                    }
                }))*/
    }

    private fun netResult(msg: String) {
        Log.e("MainActivitylog", msg + "")
    }

}
