package com.jayboat.ego.bean;

import java.util.List;

public class AlbumList {

    /**
     * more : false
     * playlist : [{"subscribers":[],"subscribed":false,"creator":{"defaultAvatar":false,"province":500000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/iZDBPSkEHB5_KGBtMC09SA==/109951163400737238.jpg","accountStatus":0,"gender":2,"city":500101,"birthday":931017600000,"userId":114919437,"userType":0,"nickname":"清夏海巷","signature":"Addition.","description":"","detailDescription":"","avatarImgId":109951163400737238,"backgroundImgId":109951162968506958,"backgroundUrl":"http://p1.music.126.net/pcPghvW1_0kU0PwXadehJg==/109951162968506958.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163400737238","backgroundImgIdStr":"109951162968506958","avatarImgId_str":"109951163400737238"},"artists":null,"tracks":null,"ordered":false,"userId":114919437,"trackCount":124,"anonimous":false,"specialType":5,"privacy":0,"newImported":false,"coverImgId":3422779698817209,"createTime":1450517847035,"updateTime":1531812073941,"highQuality":false,"totalDuration":0,"commentThreadId":"A_PL_0_141618906","trackUpdateTime":1531816049460,"coverImgUrl":"http://p4.music.126.net/JpBJUNOXqGtVxRUxF5Y0eg==/3422779698817209.jpg","playCount":5278,"description":null,"tags":[],"status":0,"trackNumberUpdateTime":1531812073941,"adType":0,"subscribedCount":0,"cloudTrackCount":0,"name":"清夏海巷喜欢的音乐","id":141618906}]
     * code : 200
     */

    private boolean more;
    private int code;
    private List<PlaylistBean> playlist;

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<PlaylistBean> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<PlaylistBean> playlist) {
        this.playlist = playlist;
    }
}
