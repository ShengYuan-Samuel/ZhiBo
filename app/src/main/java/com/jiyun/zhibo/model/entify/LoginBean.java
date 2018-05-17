package com.jiyun.zhibo.model.entify;

public class LoginBean {

    /**
     * ext :
     * msg : 操作成功
     * code : 200
     * data : {"birthday":"2018-02-07","followerSize":0,"city":"110000","signature":null,"userNo":"410865805467582464","registerType":1,"cover":"http://art.nos-eastchina1.126.net/108.png","uid":"123456","password":"123456","character":12,"userLever":0,"tel":"15011541997","id":78,"state":0,"userBalance":100000,"userCharm":0,"nickName":"艺线1","sex":1,"avatar":"http://art.nos-eastchina1.126.net/108.png","upgradeDate":"2018-03-11 15:22:48","liveId":10011,"usableBalance":100000,"token":"429343148360073216","followNum":0,"ex":0,"userSig":"eJxFkF1vgjAUhv8LtyxLKW2B3U3EDDYczk*ISdNAZdXxkVoFsuy-iwSz2*c5J*d9z6*2*lg*s7oWGWWKmjLTXjSgPQ2Yt7WQnLKD4rLHBsYYAvCwVy7Poip7AYGBDWgC8C9FxkslDmJYRNAxkWmY0LIJgRARPE6dRd7r0ItdfzE9TlaTTRqw7KsJF8ADedPK-Ohf2LoqtgwXeoySoPgxYtL436*f8-aq70Ahw8h*04MuPenuVLzv5b6EG3fbRbMl93ZRLGsymyfJnT*OZic6FL5XQn1ky7YQHKUSBR*q9jEBcixn5CxNq0upqOpqPnzo7wa3oFyc","status":0}
     */

    private String ext;
    private String msg;
    private String code;
    private DataBean data;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * birthday : 2018-02-07
         * followerSize : 0
         * city : 110000
         * signature : null
         * userNo : 410865805467582464
         * registerType : 1
         * cover : http://art.nos-eastchina1.126.net/108.png
         * uid : 123456
         * password : 123456
         * character : 12
         * userLever : 0
         * tel : 15011541997
         * id : 78
         * state : 0
         * userBalance : 100000
         * userCharm : 0
         * nickName : 艺线1
         * sex : 1
         * avatar : http://art.nos-eastchina1.126.net/108.png
         * upgradeDate : 2018-03-11 15:22:48
         * liveId : 10011
         * usableBalance : 100000
         * token : 429343148360073216
         * followNum : 0
         * ex : 0
         * userSig : eJxFkF1vgjAUhv8LtyxLKW2B3U3EDDYczk*ISdNAZdXxkVoFsuy-iwSz2*c5J*d9z6*2*lg*s7oWGWWKmjLTXjSgPQ2Yt7WQnLKD4rLHBsYYAvCwVy7Poip7AYGBDWgC8C9FxkslDmJYRNAxkWmY0LIJgRARPE6dRd7r0ItdfzE9TlaTTRqw7KsJF8ADedPK-Ohf2LoqtgwXeoySoPgxYtL436*f8-aq70Ahw8h*04MuPenuVLzv5b6EG3fbRbMl93ZRLGsymyfJnT*OZic6FL5XQn1ky7YQHKUSBR*q9jEBcixn5CxNq0upqOpqPnzo7wa3oFyc
         * status : 0
         */

        private String birthday;
        private int followerSize;
        private String city;
        private Object signature;
        private String userNo;
        private int registerType;
        private String cover;
        private String uid;
        private String password;
        private int character;
        private int userLever;
        private String tel;
        private int id;
        private int state;
        private int userBalance;
        private int userCharm;
        private String nickName;
        private int sex;
        private String avatar;
        private String upgradeDate;
        private int liveId;
        private int usableBalance;
        private String token;
        private int followNum;
        private int ex;
        private String userSig;
        private int status;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getFollowerSize() {
            return followerSize;
        }

        public void setFollowerSize(int followerSize) {
            this.followerSize = followerSize;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getSignature() {
            return signature;
        }

        public void setSignature(Object signature) {
            this.signature = signature;
        }

        public String getUserNo() {
            return userNo;
        }

        public void setUserNo(String userNo) {
            this.userNo = userNo;
        }

        public int getRegisterType() {
            return registerType;
        }

        public void setRegisterType(int registerType) {
            this.registerType = registerType;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getCharacter() {
            return character;
        }

        public void setCharacter(int character) {
            this.character = character;
        }

        public int getUserLever() {
            return userLever;
        }

        public void setUserLever(int userLever) {
            this.userLever = userLever;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getUserBalance() {
            return userBalance;
        }

        public void setUserBalance(int userBalance) {
            this.userBalance = userBalance;
        }

        public int getUserCharm() {
            return userCharm;
        }

        public void setUserCharm(int userCharm) {
            this.userCharm = userCharm;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUpgradeDate() {
            return upgradeDate;
        }

        public void setUpgradeDate(String upgradeDate) {
            this.upgradeDate = upgradeDate;
        }

        public int getLiveId() {
            return liveId;
        }

        public void setLiveId(int liveId) {
            this.liveId = liveId;
        }

        public int getUsableBalance() {
            return usableBalance;
        }

        public void setUsableBalance(int usableBalance) {
            this.usableBalance = usableBalance;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getFollowNum() {
            return followNum;
        }

        public void setFollowNum(int followNum) {
            this.followNum = followNum;
        }

        public int getEx() {
            return ex;
        }

        public void setEx(int ex) {
            this.ex = ex;
        }

        public String getUserSig() {
            return userSig;
        }

        public void setUserSig(String userSig) {
            this.userSig = userSig;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
