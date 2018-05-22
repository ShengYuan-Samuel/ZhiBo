package com.jiyun.zhibo.model.entify;

public class PayInFoData {


    /**
     * msg : 操作成功
     * ext :
     * code : 200
     * data : {"userCharm":1260086,"character":12,"userBalance":0,"usableBalance":0}
     */

    private String msg;
    private String ext;
    private String code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
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
         * userCharm : 1260086
         * character : 12
         * userBalance : 0
         * usableBalance : 0
         */

        private int userCharm;
        private int character;
        private int userBalance;
        private int usableBalance;

        public int getUserCharm() {
            return userCharm;
        }

        public void setUserCharm(int userCharm) {
            this.userCharm = userCharm;
        }

        public int getCharacter() {
            return character;
        }

        public void setCharacter(int character) {
            this.character = character;
        }

        public int getUserBalance() {
            return userBalance;
        }

        public void setUserBalance(int userBalance) {
            this.userBalance = userBalance;
        }

        public int getUsableBalance() {
            return usableBalance;
        }

        public void setUsableBalance(int usableBalance) {
            this.usableBalance = usableBalance;
        }
    }
}
