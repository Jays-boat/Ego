import android.view.View
import android.view.View.*
import com.jayboat.ego.App


/*
 * Create by Cchanges on 2018/11/7
 */

const val happyId = 2091355034L
const val excitingId = 93073411L
const val unhappyId = 772031667L
const val clamId = 102563603L

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