package com.jayboat.ego.bean;

import java.io.Serializable;
import java.util.List;

/**
 * hint : some type of ArrayList is "?"
 * (cause it do not know what kind type it belongs ?
 * when find what kind of it , remember change the type of "?"
 */

public class SongList implements Serializable {

    private ResultBean result;
    private int code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResultBean implements Serializable {
        /**
         * subscribers : []
         * subscribed : false
         * creator : {"defaultAvatar":false,"province":500000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/iZDBPSkEHB5_KGBtMC09SA==/109951163400737238.jpg","accountStatus":0,"gender":2,"city":500101,"birthday":931017600000,"userId":114919437,"userType":0,"nickname":"清夏海巷","signature":"你们所期望的，永远都没有的","description":"","detailDescription":"","avatarImgId":109951163400737238,"backgroundImgId":109951162968506958,"backgroundUrl":"http://p1.music.126.net/pcPghvW1_0kU0PwXadehJg==/109951162968506958.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"backgroundImgIdStr":"109951162968506958","avatarImgIdStr":"109951163400737238","avatarImgId_str":"109951163400737238"}
         * artists : null
         * tracks : [{"name":"可惜没如果","id":29814898,"position":1,"alias":["If Only\u2026"],"status":0,"fee":8,"copyrightId":7002,"disc":"1","no":7,"artists":[{"n
         * ame":"林俊杰","id":3684,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"album":{"name":"新地球","id":3056951,"type":"专辑","size":13,"picId":3238061746556733,"blurPicUrl":"http://p1.music.126.net/X0EDfXzxMQJiQ-71JFGdZw==/3238061746556733.jpg","companyId":0,"pic":3238061746556733,"picUrl":"http://p1.music.126.net/X0EDfXzxMQJiQ-71JFGdZw==/3238061746556733.jpg","publishTime":1419609600007,"description":"","tags":"","company":"华纳音乐","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":3,"copyrightId":7002,"commentThreadId":"R_AL_3_3056951","artists":[{"name":"林俊杰","id":3684,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":"录音室版"},"starred":false,"popularity":100,"score":100,"starredNum":0,"duration":298276,"playedNum":0,"dayPlays":0,"hearTime":0,"ringtone":null,"crbt":null,"audition":null,"copyFrom":"","commentThreadId":"R_SO_4_29814898","rtUrl":null,"ftype":0,"rtUrls":[],"copyright":1,"hMusic":{"name":null,"id":1186554092,"size":11933822,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":298276,"volumeDelta":-3.78},"mMusic":{"name":null,"id":1186554093,"size":5966933,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":160000,"playTime":298276,"volumeDelta":-3.34},"lMusic":{"name":null,"id":1186554094,"size":3580177,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":96000,"playTime":298276,"volumeDelta":-3.38},"bMusic":{"name":null,"id":1186554094,"size":3580177,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":96000,"playTime":298276,"volumeDelta":-3.38},"mp3Url":null,"rtype":0,"rurl":null,"mvid":375130},{"name":"Not You","id":520525422,"position":11,"alias":[],"status":0,"fee":8,"copyrightId":7001,"disc":"1","no":11,"artists":[{"name":"Matt Terry","id":12214141,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"album":{"name":"Trouble","id":36827686,"type":"专辑","size":14,"picId":18855524904837653,"blurPicUrl":"http://p1.music.126.net/ccPBFCYB9GVxfE26QyxxZw==/18855524904837653.jpg","companyId":0,"pic":18855524904837653,"picUrl":"http://p1.music.126.net/ccPBFCYB9GVxfE26QyxxZw==/18855524904837653.jpg","publishTime":1511452800007,"description":"","tags":"","company":"索尼音乐","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":3,"copyrightId":7001,"commentThreadId":"R_AL_3_36827686","artists":[{"name":"Matt Terry","id":12214141,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":null,"picId_str":"18855524904837653"},"starred":false,"popularity":95,"score":95,"starredNum":0,"duration":190693,"playedNum":0,"dayPlays":0,"hearTime":0,"ringtone":null,"crbt":null,"audition":null,"copyFrom":"","commentThreadId":"R_SO_4_520525422","rtUrl":null,"ftype":0,"rtUrls":[],"copyright":1,"hMusic":{"name":"","id":1390690837,"size":7627799,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":190693,"volumeDelta":-2},"mMusic":{"name":"","id":1390690838,"size":4576697,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":192000,"playTime":190693,"volumeDelta":-2},"lMusic":{"name":"","id":1390690839,"size":3051146,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":190693,"volumeDelta":-1},"bMusic":{"name":"","id":1390690839,"size":3051146,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":128000,"playTime":190693,"volumeDelta":-1},"mp3Url":null,"rtype":0,"rurl":null,"mvid":0}]
         * ordered : false
         * status : 0
         * trackCount : 2
         * playCount : 0
         * coverImgUrl : http://p3.music.126.net/kKz2B9Lxu5Cy6hbo1MLWfw==/109951163423804373.jpg
         * specialType : 0
         * anonimous : false
         * userId : 114919437
         * trackUpdateTime : 1532448634547
         * coverImgId : 109951163423804373
         * createTime : 1532448502712
         * updateTime : 1532448740115
         * privacy : 10
         * newImported : false
         * highQuality : false
         * totalDuration : 0
         * commentThreadId : A_PL_0_2330887406
         * adType : 0
         * trackNumberUpdateTime : 1532448631396
         * description : null
         * tags : []
         * cloudTrackCount : 0
         * subscribedCount : 0
         * name : temp
         * id : 2330887406
         * shareCount : 0
         * coverImgId_str : 109951163423804373
         * commentCount : 0
         */

        private CreatorBean creator;
        private Object artists;
        private int trackCount;
        private int playCount;
        private String coverImgUrl;
        private int specialType;
        private int userId;
        private long trackUpdateTime;
        private long coverImgId;
        private long createTime;
        private long updateTime;
        private int totalDuration;
        private String commentThreadId;
        private long trackNumberUpdateTime;
        private Object description;
        private int cloudTrackCount;
        private int subscribedCount;
        private String name;
        private long id;
        private int shareCount;
        private String coverImgId_str;
        private int commentCount;
        private List<TracksBean> tracks;
        private List<String> tags;

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

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
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

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
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

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getCoverImgId_str() {
            return coverImgId_str;
        }

        public void setCoverImgId_str(String coverImgId_str) {
            this.coverImgId_str = coverImgId_str;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<TracksBean> getTracks() {
            return tracks;
        }

        public void setTracks(List<TracksBean> tracks) {
            this.tracks = tracks;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class CreatorBean implements Serializable {
            /**
             * defaultAvatar : false
             * province : 500000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/iZDBPSkEHB5_KGBtMC09SA==/109951163400737238.jpg
             * accountStatus : 0
             * gender : 2
             * city : 500101
             * birthday : 931017600000
             * userId : 114919437
             * userType : 0
             * nickname : 清夏海巷
             * signature : 你们所期望的，永远都没有的
             * description :
             * detailDescription :
             * avatarImgId : 109951163400737238
             * backgroundImgId : 109951162968506958
             * backgroundUrl : http://p1.music.126.net/pcPghvW1_0kU0PwXadehJg==/109951162968506958.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * backgroundImgIdStr : 109951162968506958
             * avatarImgIdStr : 109951163400737238
             * avatarImgId_str : 109951163400737238
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String backgroundImgIdStr;
            private String avatarImgIdStr;
            private String avatarImgId_str;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }

        public static class TracksBean implements Serializable {
            /**
             * name : 可惜没如果
             * id : 29814898
             * position : 1
             * alias : ["If Only\u2026"]
             * status : 0
             * fee : 8
             * copyrightId : 7002
             * disc : 1
             * no : 7
             * artists : [{"name":"林俊杰","id":3684,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
             * album : {"name":"新地球","id":3056951,"type":"专辑","size":13,"picId":3238061746556733,"blurPicUrl":"http://p1.music.126.net/X0EDfXzxMQJiQ-71JFGdZw==/3238061746556733.jpg","companyId":0,"pic":3238061746556733,"picUrl":"http://p1.music.126.net/X0EDfXzxMQJiQ-71JFGdZw==/3238061746556733.jpg","publishTime":1419609600007,"description":"","tags":"","company":"华纳音乐","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":3,"copyrightId":7002,"commentThreadId":"R_AL_3_3056951","artists":[{"name":"林俊杰","id":3684,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"subType":"录音室版"}
             * starred : false
             * popularity : 100
             * score : 100
             * starredNum : 0
             * duration : 298276
             * playedNum : 0
             * dayPlays : 0
             * hearTime : 0
             * ringtone : null
             * crbt : null
             * audition : null
             * copyFrom :
             * commentThreadId : R_SO_4_29814898
             * rtUrl : null
             * ftype : 0
             * rtUrls : []
             * copyright : 1
             * hMusic : {"name":null,"id":1186554092,"size":11933822,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":320000,"playTime":298276,"volumeDelta":-3.78}
             * mMusic : {"name":null,"id":1186554093,"size":5966933,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":160000,"playTime":298276,"volumeDelta":-3.34}
             * lMusic : {"name":null,"id":1186554094,"size":3580177,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":96000,"playTime":298276,"volumeDelta":-3.38}
             * bMusic : {"name":null,"id":1186554094,"size":3580177,"extension":"mp3","sr":44100,"dfsId":0,"bitrate":96000,"playTime":298276,"volumeDelta":-3.38}
             * mp3Url : null
             * rtype : 0
             * rurl : null
             * mvid : 375130
             */

            private String name;
            private long id;
            private int position;
            private int copyrightId;
            private String disc;
            private int no;
            private AlbumBean album;
            private boolean starred;
            private int popularity;
            private int score;
            private int starredNum;
            private int duration;
            private int playedNum;
            private int dayPlays;
            private int hearTime;
            private Object ringtone;
            private Object crbt;
            private Object audition;
            private String copyFrom;
            private String commentThreadId;
            private Object rtUrl;
            private int ftype;
            private int copyright;
            private HMusicBean hMusic;
            private MMusicBean mMusic;
            private LMusicBean lMusic;
            private BMusicBean bMusic;
            private Object mp3Url;
            private int rtype;
            private Object rurl;
            private int mvid;
            private List<String> alias;
            private List<ArtistsBeanX> artists;

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

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getDisc() {
                return disc;
            }

            public void setDisc(String disc) {
                this.disc = disc;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public boolean isStarred() {
                return starred;
            }

            public void setStarred(boolean starred) {
                this.starred = starred;
            }

            public int getPopularity() {
                return popularity;
            }

            public void setPopularity(int popularity) {
                this.popularity = popularity;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getStarredNum() {
                return starredNum;
            }

            public void setStarredNum(int starredNum) {
                this.starredNum = starredNum;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlayedNum() {
                return playedNum;
            }

            public void setPlayedNum(int playedNum) {
                this.playedNum = playedNum;
            }

            public int getDayPlays() {
                return dayPlays;
            }

            public void setDayPlays(int dayPlays) {
                this.dayPlays = dayPlays;
            }

            public int getHearTime() {
                return hearTime;
            }

            public void setHearTime(int hearTime) {
                this.hearTime = hearTime;
            }

            public Object getRingtone() {
                return ringtone;
            }

            public void setRingtone(Object ringtone) {
                this.ringtone = ringtone;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public Object getAudition() {
                return audition;
            }

            public void setAudition(Object audition) {
                this.audition = audition;
            }

            public String getCopyFrom() {
                return copyFrom;
            }

            public void setCopyFrom(String copyFrom) {
                this.copyFrom = copyFrom;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getCopyright() {
                return copyright;
            }

            public void setCopyright(int copyright) {
                this.copyright = copyright;
            }

            public HMusicBean getHMusic() {
                return hMusic;
            }

            public void setHMusic(HMusicBean hMusic) {
                this.hMusic = hMusic;
            }

            public MMusicBean getMMusic() {
                return mMusic;
            }

            public void setMMusic(MMusicBean mMusic) {
                this.mMusic = mMusic;
            }

            public LMusicBean getLMusic() {
                return lMusic;
            }

            public void setLMusic(LMusicBean lMusic) {
                this.lMusic = lMusic;
            }

            public BMusicBean getBMusic() {
                return bMusic;
            }

            public void setBMusic(BMusicBean bMusic) {
                this.bMusic = bMusic;
            }

            public Object getMp3Url() {
                return mp3Url;
            }

            public void setMp3Url(Object mp3Url) {
                this.mp3Url = mp3Url;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public List<String> getAlias() {
                return alias;
            }

            public void setAlias(List<String> alias) {
                this.alias = alias;
            }

            public List<ArtistsBeanX> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBeanX> artists) {
                this.artists = artists;
            }

            public static class AlbumBean implements Serializable {

                /**
                 * name : 新地球
                 * id : 3056951
                 * type : 专辑
                 * size : 13
                 * picId : 3238061746556733
                 * blurPicUrl : http://p1.music.126.net/X0EDfXzxMQJiQ-71JFGdZw==/3238061746556733.jpg
                 * companyId : 0
                 * pic : 3238061746556733
                 * picUrl : http://p1.music.126.net/X0EDfXzxMQJiQ-71JFGdZw==/3238061746556733.jpg
                 * publishTime : 1419609600007
                 * description :
                 * tags :
                 * company : 华纳音乐
                 * briefDesc :
                 * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}
                 * songs : []
                 * alias : []
                 * status : 3
                 * copyrightId : 7002
                 * commentThreadId : R_AL_3_3056951
                 * artists : [{"name":"林俊杰","id":3684,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
                 * subType : 录音室版
                 */

                private String name;
                private long id;
                private String type;
                private int size;
                private long picId;
                private String blurPicUrl;
                private int companyId;
                private long pic;
                private String picUrl;
                private long publishTime;
                private String description;
                private String tags;
                private String company;
                private String briefDesc;
                private ArtistBean artist;
                private int status;
                private int copyrightId;
                private String commentThreadId;
                private String subType;
                private List<ArtistsBean> artists;

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

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public String getBlurPicUrl() {
                    return blurPicUrl;
                }

                public void setBlurPicUrl(String blurPicUrl) {
                    this.blurPicUrl = blurPicUrl;
                }

                public int getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(int companyId) {
                    this.companyId = companyId;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTags() {
                    return tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public ArtistBean getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBean artist) {
                    this.artist = artist;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public String getCommentThreadId() {
                    return commentThreadId;
                }

                public void setCommentThreadId(String commentThreadId) {
                    this.commentThreadId = commentThreadId;
                }

                public String getSubType() {
                    return subType;
                }

                public void setSubType(String subType) {
                    this.subType = subType;
                }

                public List<ArtistsBean> getArtists() {
                    return artists;
                }

                public void setArtists(List<ArtistsBean> artists) {
                    this.artists = artists;
                }

                public static class ArtistBean implements Serializable {
                    /**
                     * name :
                     * id : 0
                     * picId : 0
                     * img1v1Id : 0
                     * briefDesc :
                     * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * albumSize : 0
                     * alias : []
                     * trans :
                     * musicSize : 0
                     */

                    private String name;
                    private long id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private String trans;
                    private int musicSize;
                    private List<?> alias;

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

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }

                public static class ArtistsBean implements Serializable {
                    /**
                     * name : 林俊杰
                     * id : 3684
                     * picId : 0
                     * img1v1Id : 0
                     * briefDesc :
                     * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * albumSize : 0
                     * alias : []
                     * trans :
                     * musicSize : 0
                     */

                    private String name;
                    private long id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private String trans;
                    private int musicSize;
                    private List<?> alias;

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

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }
            }

            public static class HMusicBean implements Serializable {
                /**
                 * name : null
                 * id : 1186554092
                 * size : 11933822
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 320000
                 * playTime : 298276
                 * volumeDelta : -3.78
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class MMusicBean implements Serializable {
                /**
                 * name : null
                 * id : 1186554093
                 * size : 5966933
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 160000
                 * playTime : 298276
                 * volumeDelta : -3.34
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class LMusicBean implements Serializable {
                /**
                 * name : null
                 * id : 1186554094
                 * size : 3580177
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 96000
                 * playTime : 298276
                 * volumeDelta : -3.38
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class BMusicBean implements Serializable {

                /**
                 * name : null
                 * id : 1186554094
                 * size : 3580177
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 0
                 * bitrate : 96000
                 * playTime : 298276
                 * volumeDelta : -3.38
                 */

                private Object name;
                private long id;
                private int size;
                private String extension;
                private int sr;
                private int dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public long getId() {
                    return id;
                }

                public void setId(long id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public int getDfsId() {
                    return dfsId;
                }

                public void setDfsId(int dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }
            }

            public static class ArtistsBeanX implements Serializable {
                /**
                 * name : 林俊杰
                 * id : 3684
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 */

                private String name;
                private long id;
                private long picId;
                private long img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
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

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public long getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(long img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
                }
            }
        }
    }
}
