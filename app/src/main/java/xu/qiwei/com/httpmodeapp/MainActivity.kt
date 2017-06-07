package xu.qiwei.com.httpmodeapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

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
        HttpRequestInstance.getInstance().createClient().getTransFerList(Transfer.TransferParam().generateMap())
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
                }))
    }

    private fun netResult(msg: String) {
        Log.e("MainActivitylog", msg + "")
    }

}
