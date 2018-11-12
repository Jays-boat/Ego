package com.jayboat.ego.utils;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.jayboat.ego.App;


/**
 * Created by Hosigus on 2018/5/5.
 *
 */

public class ToastUtils {
    private static Toast mToast;

    private ToastUtils() {throw new UnsupportedOperationException("cannot be instantiated");}

    public static void show(String text) {
        show(text, Toast.LENGTH_SHORT);
    }

    @SuppressLint("ShowToast")
    public static void show(String text, int time) {
        if (time != Toast.LENGTH_SHORT && time != Toast.LENGTH_LONG) {
            return;
        }

        if (mToast == null) {
            mToast = Toast.makeText(App.getAppContext(), text, time);
        } else {
            mToast.setText(text);
        }

        mToast.show();
    }

    /**
     * 异步操作时，调用此函数更新主线程UI
     * @param text text
     */
    public static void asyncShow(final String text) {
        ThreadUtils.getInstance().post(new Runnable() {
            @Override
            public void run() {
                show(text);
            }
        });
    }
    /**
     * 异步操作时，调用此函数更新主线程UI
     * @param text text
     */
    public static void asyncShow(final String text, final int time) {
        ThreadUtils.getInstance().post(new Runnable() {
            @Override
            public void run() {
                show(text,time);
            }
        });
    }

}
