package com.jiyun.zhibo.model.entify;

import java.util.List;

public class RenQiBean {

    /**
     * ext :
     * msg : 操作成功
     * code : 200
     * data : {"totalRow":1,"pageNumber":1,"firstPage":true,"lastPage":true,"totalPage":1,"pageSize":10,"list":[{"birthday":"2018-05-09","hlsPullUrl":"http://22048.liveplay.myqcloud.com/live/22048_443711617465581568.flv","rtmpPullUrl":"rtmp://22048.liveplay.myqcloud.com/live/22048_443711617465581568","nickName":"亦欢","liveNo":"447823245199015936","userNo":"443711617465581568","sex":1,"avatar":"http://art.nos-eastchina1.126.net/108.png","liveId":10106,"roomid":443711617465581568,"cover":"http://art.nos-eastchina1.126.net/img-e63775e206763c4a6e11fd35a7027afc.jpg","httpPullUrl":"http://22048.liveplay.myqcloud.com/live/22048_443711617465581568.m3u8","viewNum":0,"pushUrl":"rtmp://22048.livepush.myqcloud.com/live/22048_443711617465581568?bizid=22048&txSecret=4b319534ee1878d5925ed0915e78586b&txTime=5B01D605&liveNo=447823245199015936","name":"游戏","position":"宿迁市"}]}
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
         * totalRow : 1
         * pageNumber : 1
         * firstPage : true
         * lastPage : true
         * totalPage : 1
         * pageSize : 10
         * list : [{"birthday":"2018-05-09","hlsPullUrl":"http://22048.liveplay.myqcloud.com/live/22048_443711617465581568.flv","rtmpPullUrl":"rtmp://22048.liveplay.myqcloud.com/live/22048_443711617465581568","nickName":"亦欢","liveNo":"447823245199015936","userNo":"443711617465581568","sex":1,"avatar":"http://art.nos-eastchina1.126.net/108.png","liveId":10106,"roomid":443711617465581568,"cover":"http://art.nos-eastchina1.126.net/img-e63775e206763c4a6e11fd35a7027afc.jpg","httpPullUrl":"http://22048.liveplay.myqcloud.com/live/22048_443711617465581568.m3u8","viewNum":0,"pushUrl":"rtmp://22048.livepush.myqcloud.com/live/22048_443711617465581568?bizid=22048&txSecret=4b319534ee1878d5925ed0915e78586b&txTime=5B01D605&liveNo=447823245199015936","name":"游戏","position":"宿迁市"}]
         */

        private int totalRow;
        private int pageNumber;
        private boolean firstPage;
        private boolean lastPage;
        private int totalPage;
        private int pageSize;
        private List<ListBean> list;

        public int getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(int totalRow) {
            this.totalRow = totalRow;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }

        public boolean isFirstPage() {
            return firstPage;
        }

        public void setFirstPage(boolean firstPage) {
            this.firstPage = firstPage;
        }

        public boolean isLastPage() {
            return lastPage;
        }

        public void setLastPage(boolean lastPage) {
            this.lastPage = lastPage;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * birthday : 2018-05-09
             * hlsPullUrl : http://22048.liveplay.myqcloud.com/live/22048_443711617465581568.flv
             * rtmpPullUrl : rtmp://22048.liveplay.myqcloud.com/live/22048_443711617465581568
             * nickName : 亦欢
             * liveNo : 447823245199015936
             * userNo : 443711617465581568
             * sex : 1
             * avatar : http://art.nos-eastchina1.126.net/108.png
             * liveId : 10106
             * roomid : 443711617465581568
             * cover : http://art.nos-eastchina1.126.net/img-e63775e206763c4a6e11fd35a7027afc.jpg
             * httpPullUrl : http://22048.liveplay.myqcloud.com/live/22048_443711617465581568.m3u8
             * viewNum : 0
             * pushUrl : rtmp://22048.livepush.myqcloud.com/live/22048_443711617465581568?bizid=22048&txSecret=4b319534ee1878d5925ed0915e78586b&txTime=5B01D605&liveNo=447823245199015936
             * name : 游戏
             * position : 宿迁市
             */

            private String birthday;
            private String hlsPullUrl;
            private String rtmpPullUrl;
            private String nickName;
            private String liveNo;
            private String userNo;
            private int sex;
            private String avatar;
            private int liveId;
            private long roomid;
            private String cover;
            private String httpPullUrl;
            private int viewNum;
            private String pushUrl;
            private String name;
            private String position;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getHlsPullUrl() {
                return hlsPullUrl;
            }

            public void setHlsPullUrl(String hlsPullUrl) {
                this.hlsPullUrl = hlsPullUrl;
            }

            public String getRtmpPullUrl() {
                return rtmpPullUrl;
            }

            public void setRtmpPullUrl(String rtmpPullUrl) {
                this.rtmpPullUrl = rtmpPullUrl;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getLiveNo() {
                return liveNo;
            }

            public void setLiveNo(String liveNo) {
                this.liveNo = liveNo;
            }

            public String getUserNo() {
                return userNo;
            }

            public void setUserNo(String userNo) {
                this.userNo = userNo;
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

            public int getLiveId() {
                return liveId;
            }

            public void setLiveId(int liveId) {
                this.liveId = liveId;
            }

            public long getRoomid() {
                return roomid;
            }

            public void setRoomid(long roomid) {
                this.roomid = roomid;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getHttpPullUrl() {
                return httpPullUrl;
            }

            public void setHttpPullUrl(String httpPullUrl) {
                this.httpPullUrl = httpPullUrl;
            }

            public int getViewNum() {
                return viewNum;
            }

            public void setViewNum(int viewNum) {
                this.viewNum = viewNum;
            }

            public String getPushUrl() {
                return pushUrl;
            }

            public void setPushUrl(String pushUrl) {
                this.pushUrl = pushUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }
        }
    }
}
