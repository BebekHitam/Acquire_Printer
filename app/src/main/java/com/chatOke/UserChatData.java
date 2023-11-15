package com.chatOke;

public class UserChatData {
    private int userIDImage;
    private String UserName;
    private String konten;
    public UserChatData(int UserImage, String UserNawa, String konten){
        this.userIDImage = UserImage;
        this.UserName = UserNawa;
        this.konten = konten;
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

    public void setUserIDImage(int userIDImage) {
        this.userIDImage = userIDImage;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }
}
