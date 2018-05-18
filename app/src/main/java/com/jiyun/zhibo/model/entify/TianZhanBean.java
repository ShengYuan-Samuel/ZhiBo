package com.jiyun.zhibo.model.entify;

public class TianZhanBean {

    private int photo;
    private String title;
    private String content;

    public TianZhanBean(int photo, String title, String content) {
        this.photo = photo;
        this.title = title;
        this.content = content;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TianZhanBean{" +
                "photo=" + photo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
