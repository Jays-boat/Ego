package com.jayboat.ego.config;


import com.jayboat.ego.bean.AlbumList;
import com.jayboat.ego.bean.Lyric;
import com.jayboat.ego.bean.SongList;
import com.jayboat.ego.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hosigus on 2018/7/21.
 */

public class NetConfig {
    public interface LoginService {
        @GET("login/cellphone")
        Call<User> loginByPhone(@Query("phone") String phone, @Query("password") String pwd);
    }

    public interface GetMusicData {
        @GET("user/playlist")
        Call<AlbumList> getAlbumList(@Query("uid") String id);

        @GET("playlist/detail")
        Call<SongList> getSongList(@Query("id") String albumListId);

        @GET("/lyric")
        Call<Lyric> getLyric(@Query("id") String musicId);
    }
}
