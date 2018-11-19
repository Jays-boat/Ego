import android.view.View
import android.view.View.*
import com.jayboat.ego.App
import com.jayboat.ego.utils.ToastUtils
import io.reactivex.Observable
import io.reactivex.disposables.Disposable


/*
 * Create by Cchanges on 2018/11/7
 */


val screenWidth: Int
    get() = App.getAppContext().resources.displayMetrics.widthPixels

val screenHeight: Int
    get() = App.getAppContext().resources.displayMetrics.heightPixels

fun View.gone() {
    visibility = GONE
}

fun View.visible() {
    visibility = VISIBLE
}

fun View.invisible() {
    visibility = INVISIBLE
}

fun <T> Observable<T>.safeSubscribeBy(
        onError: (Throwable) -> Unit = {
            ToastUtils.asyncShow("服务器地址已更换，请更新到最新版本")
            it.printStackTrace()
        },
        onComplete: () -> Unit = {},
        onNext: (T) -> Unit = {}
): Disposable = subscribe(onNext, onError, onComplete)