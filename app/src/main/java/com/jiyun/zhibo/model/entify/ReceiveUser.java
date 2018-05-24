package com.jiyun.zhibo.model.entify;

public class ReceiveUser {
            public ReceiveUser(String userNo, String nickName, String avatar) {
                this.userNo = userNo;
                this.nickName = nickName;
                this.avatar = avatar;
            }

            private String userNo;
            private String nickName;
            private String avatar;

            public String getUserNo() {
                return userNo;
            }

            public void setUserNo(String userNo) {
                this.userNo = userNo;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            @Override
            public String toString() {
                return "ReceiveUser{" +
                        "userNo='" + userNo + '\'' +
                        ", nickName='" + nickName + '\'' +
                        ", avatar='" + avatar + '\'' +
                        '}';
            }
        }