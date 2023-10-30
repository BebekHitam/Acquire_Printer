package com.FBPopulateData;

public class FBDataModelPrinter {
    private String name;
    private String image;
    private double price;
    private String city;

    public FBDataModelPrinter(String name, String image, double price, String city) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.city = city;
    }

    //ini masih meragukan coba lagi nanti
    public FBDataModelPrinter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image){
        this.image=image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
