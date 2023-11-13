package com.stall;

import java.io.Serializable;


//kelas ini digunakan untuk getter data stall, dan kamu bisa mengirimkannya ke
public class DataStall implements Serializable {
    public String iydi;
    public String itemName;
//    public int imageId;
    public String imageUrl;
    public int price;
    public String city;

    public DataStall( String itemName, String imageUrl, int price, String city){

        this.itemName=itemName;
        this.imageUrl=imageUrl;
        this.price=price;
        this.city = city;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price){this.price=price;}

    public String getImageUrl() {
        return imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setImageId(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCity(){return city;}
    public void setCity(String city){
        this.city=city;
    }

}
