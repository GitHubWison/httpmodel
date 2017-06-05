package xu.qiwei.com.httpmodeapp

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by xuqiwei on 17-6-5.
 */

class Test {
    init {
        val objectType = object : TypeToken<DataSource<LoginResult>>() {

        }.type
        Gson().fromJson<Any>("", objectType)
    }
}
