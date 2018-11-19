package com.jayboat.ego.utils;


import com.jayboat.ego.bean.Lyric;
import com.jayboat.ego.bean.SongList;
import com.jayboat.ego.bean.User;
import com.jayboat.ego.config.NetConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hosigus on 2018/7/21.
 */

public class NetUtils {
    private static Retrofit.Builder builder;

//    public static void loginByPhone(String phone, String pwd, Callback<User> loginPhoneCallback) {
//        NetConfig.LoginService service = getRetrofitBuilder().build().create(NetConfig.LoginService.class);
//        Call<User> call = service.loginByPhone(phone, pwd);
//        call.enqueue(loginPhoneCallback);
//    }

    public static void getLyric(long id, Callback<Lyric> getLyricCallBack) {
        NetConfig.GetMusicData getMusicData = getRetrofitBuilder().build().create(NetConfig.GetMusicData.class);
        Call<Lyric> call = getMusicData.getLyric(String.valueOf(id));
        call.enqueue(getLyricCallBack);
    }

    private static Retrofit.Builder getRetrofitBuilder() {
        return builder == null ? builder = new Retrofit.Builder()
                .baseUrl("http://music.moe.tn/")
                .addConverterFactory(GsonConverterFactory.create()) : builder;
    }

}
