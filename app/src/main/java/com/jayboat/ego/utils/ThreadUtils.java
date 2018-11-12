package com.jayboat.ego.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Hosigus on 2018/5/5.
 */

public class ThreadUtils {

    private ExecutorService mExecutor;
    private Handler mainHandle;

    private static ThreadUtils mInstance = new ThreadUtils();

    private ThreadUtils() {
        mExecutor = Executors.newCachedThreadPool();
        mainHandle = new Handler(Looper.getMainLooper());
    }

    public static ThreadUtils getInstance(){
        return mInstance;
    }

    public void execute(@NonNull Runnable command) {
        mExecutor.execute(command);
    }

    public <T> void submit(@NonNull Callable<T> task) {
        mExecutor.submit(task);
    }

    public <T> void submit(@NonNull Runnable task, T result) {
        mExecutor.submit(task,result);
    }

    public void post(@NonNull Runnable r) {
        mainHandle.post(r);
    }

    public void postDelay(@NonNull Runnable r, long delayMillis) {
        mainHandle.postDelayed(r, delayMillis);
    }

}
