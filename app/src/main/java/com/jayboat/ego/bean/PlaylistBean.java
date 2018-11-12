package com.jayboat.ego.bean;

import java.util.List;

public class PlaylistBean {
    /**
     * subscribers : []
     * subscribed : false
     * creator : {"defaultAvatar":false,"province":500000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/iZDBPSkEHB5_KGBtMC09SA==/109951163400737238.jpg","accountStatus":0,"gender":2,"city":500101,"birthday":931017600000,"userId":114919437,"userType":0,"nickname":"清夏海巷","signature":"Addition.","description":"","detailDescription":"","avatarImgId":109951163400737238,"backgroundImgId":109951162968506958,"backgroundUrl":"http://p1.music.126.net/pcPghvW1_0kU0PwXadehJg==/109951162968506958.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163400737238","backgroundImgIdStr":"109951162968506958","avatarImgId_str":"109951163400737238"}
     * artists : null
     * tracks : null
     * ordered : false
     * userId : 114919437
     * trackCount : 124
     * anonimous : false
     * specialType : 5
     * privacy : 0
     * newImported : false
     * coverImgId : 3422779698817209
     * createTime : 1450517847035
     * updateTime : 1531812073941
     * highQuality : false
     * totalDuration : 0
     * commentThreadId : A_PL_0_141618906
     * trackUpdateTime : 1531816049460
     * coverImgUrl : http://p4.music.126.net/JpBJUNOXqGtVxRUxF5Y0eg==/3422779698817209.jpg
     * playCount : 5278
     * description : null
     * tags : []
     * status : 0
     * trackNumberUpdateTime : 1531812073941
     * adType : 0
     * subscribedCount : 0
     * cloudTrackCount : 0
     * name : 清夏海巷喜欢的音乐
     * id : 141618906
     * coverImgId_str : 109951163072672197
     */

    private boolean subscribed;
    private CreatorBean creator;
    private Object artists;
    private Object tracks;
    private boolean ordered;
    private long userId;
    private int trackCount;
    private boolean anonimous;
    private int specialType;
    private int privacy;
    private boolean newImported;
    private long coverImgId;
    private long createTime;
    private long updateTime;
    private boolean highQuality;
    private int totalDuration;
    private String commentThreadId;
    private long trackUpdateTime;
    private String coverImgUrl;
    private int playCount;
    private Object description;
    private int status;
    private long trackNumberUpdateTime;
    private int adType;
    private int subscribedCount;
    private int cloudTrackCount;
    private String name;
    private long id;
    private String coverImgId_str;
    private List<String> subscribers;
    private List<String> tags;

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public CreatorBean getCreator() {
        return creator;
    }

    public void setCreator(CreatorBean creator) {
        this.creator = creator;
    }

    public Object getArtists() {
        return artists;
    }

    public void setArtists(Object artists) {
        this.artists = artists;
    }

    public Object getTracks() {
        return tracks;
    }

    public void setTracks(Object tracks) {
        this.tracks = tracks;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public boolean isAnonimous() {
        return anonimous;
    }

    public void setAnonimous(boolean anonimous) {
        this.anonimous = anonimous;
    }

    public int getSpecialType() {
        return specialType;
    }

    public void setSpecialType(int specialType) {
        this.specialType = specialType;
    }

    public int getPrivacy() {
        return privacy;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    public boolean isNewImported() {
        return newImported;
    }

    public void setNewImported(boolean newImported) {
        this.newImported = newImported;
    }

    public long getCoverImgId() {
        return coverImgId;
    }

    public void setCoverImgId(long coverImgId) {
        this.coverImgId = coverImgId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isHighQuality() {
        return highQuality;
    }

    public void setHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getCommentThreadId() {
        return commentThreadId;
    }

    public void setCommentThreadId(String commentThreadId) {
        this.commentThreadId = commentThreadId;
    }

    public long getTrackUpdateTime() {
        return trackUpdateTime;
    }

    public void setTrackUpdateTime(long trackUpdateTime) {
        this.trackUpdateTime = trackUpdateTime;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTrackNumberUpdateTime() {
        return trackNumberUpdateTime;
    }

    public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
        this.trackNumberUpdateTime = trackNumberUpdateTime;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getSubscribedCount() {
        return subscribedCount;
    }

    public void setSubscribedCount(int subscribedCount) {
        this.subscribedCount = subscribedCount;
    }

    public int getCloudTrackCount() {
        return cloudTrackCount;
    }

    public void setCloudTrackCount(int cloudTrackCount) {
        this.cloudTrackCount = cloudTrackCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoverImgId_str() {
        return coverImgId_str;
    }

    public void setCoverImgId_str(String coverImgId_str) {
        this.coverImgId_str = coverImgId_str;
    }

    public List<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
