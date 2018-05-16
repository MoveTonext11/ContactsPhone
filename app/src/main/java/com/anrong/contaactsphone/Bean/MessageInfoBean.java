package com.anrong.contaactsphone.Bean;

/**
 * Created by Administrator on 2018/5/14.
 */

public class MessageInfoBean {
    private String name;
    private String PoleceNum;
    private String PhoneNum;
    private String ImageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoleceNum() {
        return PoleceNum;
    }

    public void setPoleceNum(String poleceNum) {
        PoleceNum = poleceNum;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MessageInfoBean{" +
                "name='" + name + '\'' +
                ", PoleceNum='" + PoleceNum + '\'' +
                ", PhoneNum='" + PhoneNum + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                '}';
    }
}
