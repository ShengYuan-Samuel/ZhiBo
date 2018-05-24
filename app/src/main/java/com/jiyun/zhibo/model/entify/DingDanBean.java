package com.jiyun.zhibo.model.entify;

public class DingDanBean {

    /**
     * ext :
     * msg : 操作成功
     * code : 200
     * data : {"orderNo":448415651355164672,"orderShow":1526952272,"finalAmount":1,"userNo":433954098379751424,"remark":"金币-10个","extendNo":1,"type":0}
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
         * orderNo : 448415651355164672
         * orderShow : 1526952272
         * finalAmount : 1
         * userNo : 433954098379751424
         * remark : 金币-10个
         * extendNo : 1
         * type : 0
         */

        private long orderNo;
        private int orderShow;
        private int finalAmount;
        private long userNo;
        private String remark;
        private int extendNo;
        private int type;

        public long getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(long orderNo) {
            this.orderNo = orderNo;
        }

        public int getOrderShow() {
            return orderShow;
        }

        public void setOrderShow(int orderShow) {
            this.orderShow = orderShow;
        }

        public int getFinalAmount() {
            return finalAmount;
        }

        public void setFinalAmount(int finalAmount) {
            this.finalAmount = finalAmount;
        }

        public long getUserNo() {
            return userNo;
        }

        public void setUserNo(long userNo) {
            this.userNo = userNo;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getExtendNo() {
            return extendNo;
        }

        public void setExtendNo(int extendNo) {
            this.extendNo = extendNo;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
