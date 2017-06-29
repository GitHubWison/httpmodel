package xu.qiwei.com.httpmodeapp

import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.Response

/**
 * Created by xuqiwei on 17-6-29.
 */
 class  MyObserver<T : Response<R>> : Observer<T> {
    override fun onComplete() {

    }

    override fun onNext(value: T) {
        value.body()
    }

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onError(e: Throwable?) {
    }

}
//public interface MyList <T>{
//
//}