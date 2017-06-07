package xu.qiwei.com.httpmodeapp;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by xuqiwei on 17-6-7.
 */

public class DataCallBack<T> implements Callback<DataSource<T>>{
    private HttpCallBack<T> httpCallBack;

    public DataCallBack(HttpCallBack<T> httpCallBack) {
        this.httpCallBack = httpCallBack;
    }
    @Override
    public void onResponse(Call<DataSource<T>> call, Response<DataSource<T>> response) {
        T t = response.body().getData();
        String resultCode = response.body().getResultCode();
        if (resultCode.equals("1000")) {
            httpCallBack.onSuccess(t);
        }else
        {
            String errorMsg = response.body().getMessage();
            httpCallBack.onServerError(errorMsg);
        }
        netEnd(true,resultCode);

    }

    @Override
    public void onFailure(Call<DataSource<T>> call, Throwable t) {
        String netError = t.getMessage();
        if (netError==null) {
            netError = "网络错误，原因不详";
        }
        httpCallBack.onNetError(netError);
        netEnd(false,netError);
    }
    private void netEnd(boolean isNetSuccess,String code){
        httpCallBack.onNetFinish(isNetSuccess,code);
        Log.e("netstatus===","isNetSuccess:"+isNetSuccess+"==code:"+code);
    }
    public interface HttpCallBack<T>{
         void onSuccess(T t);
         void onNetError(String msg);
         void onServerError(String msg);
         void onNetFinish(boolean isSuccess,String code);
    }
    public static abstract class HttpCallBackImpl<T> implements HttpCallBack<T>{
        @Override
        public void onSuccess(T t) {
        }

        @Override
        public void onNetError(String msg) {

        }

        @Override
        public void onServerError(String msg) {

        }

        @Override
        public void onNetFinish(boolean isSuccess, String code) {

        }
    }
}
