package com.chatOke;

public class UserChatData {
    private int userIDImage;
    private String UserName;
    private String konten;
    private String timeNow;
    public UserChatData(int UserImage, String UserNawa, String konten, String timeNow){
        this.userIDImage = UserImage;
        this.UserName = UserNawa;
        this.konten = konten;
        this.timeNow = timeNow;
    }


    public int getUserIDImage() {
        return userIDImage;
    }

    public String getUserName() {
        return UserName;
    }

    public String getKonten() {
        return konten;
    }

    public String getTimeNow() {
        return timeNow;
    }

    public void setUserIDImage(int userIDImage) {
        this.userIDImage = userIDImage;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public void setTimeNow(String timeNow) {
        this.timeNow = timeNow;
    }
}
