package com.jiyun.zhibo.model.entify;

public class ImageBean {
    private int photo;
    private int selectPhoto;

    public ImageBean(int photo, int selectPhoto) {
        this.photo = photo;
        this.selectPhoto = selectPhoto;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getSelectPhoto() {
        return selectPhoto;
    }

    public void setSelectPhoto(int selectPhoto) {
        this.selectPhoto = selectPhoto;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "photo=" + photo +
                ", selectPhoto=" + selectPhoto +
                '}';
    }
}
