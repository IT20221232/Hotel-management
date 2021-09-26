package com.example.foodordering;

public class MyFoodData {

    private String foodname;
    private String quantity;
    private int foodimage;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String number;



    public MyFoodData(String foodname, String quantity, int foodimage,String number) {
        this.foodname = foodname;
        this.quantity = quantity;
        this.foodimage = foodimage;
       this.number=number;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getFoodimage() {
        return foodimage;
    }

    public void setFoodimage(int foodimage) {
        this.foodimage = foodimage;
    }


}
