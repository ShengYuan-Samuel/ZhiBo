package com.jiyun.zhibo.model.entify;

public class  Data {


    private int giftNo;
    private int giftNum;
    private String giftName;
    private String giftPic;
    private SendUser sendUser;
    private ReceiveUser receiveUser;

    public Data(int giftNo, int giftNum, String giftName, String giftPic, SendUser sendUser, ReceiveUser receiveUser) {
        this.giftNo = giftNo;
        this.giftNum = giftNum;
        this.giftName = giftName;
        this.giftPic = giftPic;
        this.sendUser = sendUser;
        this.receiveUser = receiveUser;
    }

    public int getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(int giftNum) {
        this.giftNum = giftNum;
    }

    public int getGiftNo() {
        return giftNo;
    }

    public void setGiftNo(int giftNo) {
        this.giftNo = giftNo;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public String getGiftPic() {
        return giftPic;
    }

    public void setGiftPic(String giftPic) {
        this.giftPic = giftPic;
    }

    public SendUser getSendUser() {
        return sendUser;
    }

    public void setSendUser(SendUser sendUser) {
        this.sendUser = sendUser;
    }

    public ReceiveUser getReceiveUser() {
        return receiveUser;
    }

    public void setReceiveUser(ReceiveUser receiveUser) {
        this.receiveUser = receiveUser;
    }
}