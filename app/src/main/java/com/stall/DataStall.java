package com.stall;

import java.io.Serializable;

//kelas ini digunakan untuk getter data stall, dan kamu bisa mengirimkannya ke
public class DataStall implements Serializable {
    public String itemName;
    public int imageId;
    public int price;
    public String city;

    public DataStall(String itemName, int imageId, int price, String city){
        this.itemName=itemName;
        this.imageId=imageId;
        this.price=price;
        this.city = city;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price){this.price=price;}

    public int getImageId() {
        return imageId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCity(){return city;}
    public void setCity(String city){
        this.city=city;
    }

}
