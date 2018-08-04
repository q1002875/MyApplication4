package com.example.user.myapplication4;

public class UpCart {


    private String Size;
    private String Amount;
    private String Money;

    public UpCart() {


    }
    public  UpCart(String size, String amount,String money) {

        Size = size;
        Amount = amount;
        Money= money;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }
}
