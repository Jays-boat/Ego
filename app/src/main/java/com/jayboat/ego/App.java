package com.jayboat.ego;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Base64;

import com.danikula.videocache.HttpProxyCacheServer;
import com.jayboat.ego.bean.User;
import com.jayboat.ego.utils.NetUtils;
import com.jayboat.ego.utils.SQLHelper;
import com.jayboat.ego.utils.ToastUtils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hosigus on 2018/7/20.
 */

public class App extends Application {

    private static Context appContext;
    private static SQLiteDatabase database;
    private static HttpProxyCacheServer proxy;

    public static Context getAppContext() {
        return appContext;
    }

    public static HttpProxyCacheServer getProxy() {
        return proxy == null ? (proxy = new HttpProxyCacheServer(appContext)) : proxy;
    }

    public static SQLiteDatabase getDatabase() {
        return database;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();

        database = new SQLHelper().getWritableDatabase();

        /*
        preferences = getSharedPreferences("login", MODE_PRIVATE);

        readData();

        if (phone != null) {
            autoLoginByPhone();
        }
    }

    private static User user;
    private static SharedPreferences preferences;
    private static String phone;
    private static String pwd;
    public static boolean isLoginSuccessful = false;

    private void readData() {
        phone = preferences.getString("lastPhone", null);
        if (phone != null) {
            pwd = preferences.getString(phone, "");
        }

        String userStr = preferences.getString("user", "");
        if (userStr.isEmpty()) {
            return;
        }
        byte[] newsBytes = Base64.decode(userStr.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(newsBytes);
            ois = new ObjectInputStream(bais);
            user = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bais != null)
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (ois != null)
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void autoLoginByPhone() {
        NetUtils.loginByPhone(phone, pwd, new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.body() != null && response.body().getCode() == 200) {
                    App.loginSuccessful(response.body());
                } else {
                    ToastUtils.show("用户名或密码错误");
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                ToastUtils.show("密码已更改!");
            }
        });
    }

    public static void loginSuccessful(@Nullable User user) {
        isLoginSuccessful = true;
        App.user = user;
        String userStr = null;
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(user);
            userStr = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null)
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (oos != null)
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        preferences.edit().putString("user", userStr).apply();
    }

    public static void loginSuccessfulByPhone(@Nullable User user, String phone, String pwd) {
        App.phone = phone;
        App.pwd = pwd;
        preferences.edit().putString("lastPhone", phone).putString(phone, pwd).apply();
        loginSuccessful(user);
    }

    public static boolean existUserInfo() {
        return getUser() != null;
    }

    public static User getUser() {
        return user;*/
    }

}
