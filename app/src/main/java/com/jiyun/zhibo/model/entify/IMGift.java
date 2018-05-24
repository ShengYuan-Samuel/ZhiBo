package com.jiyun.zhibo.model.entify;

public class IMGift {

    private int msgType;
    private long ts;
    private Data data;

    public IMGift(int msgType, long ts, Data data) {
        this.msgType = msgType;
        this.ts = ts;
        this.data = data;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }











}
