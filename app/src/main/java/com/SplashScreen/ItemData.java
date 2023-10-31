package com.SplashScreen;

public class ItemData {
    private int imageResourceId;
    private String text;

    public ItemData(int imageResourceId, String text) {
        this.imageResourceId = imageResourceId;
        this.text = text;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getText() {
        return text;
    }
}
