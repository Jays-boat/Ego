import android.view.View
import android.view.View.*
import com.jayboat.ego.App


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