package com.example.mad_2nd_year_2nd_semester;

public class Payment {

    private int id;
    private String card_holder;
    private String card_number;
    private String expire_date;

    public Payment() {
        id = 0;
        card_holder="";
        card_number="";
        expire_date="";
    }

    public Payment(int id, String card_holder, String card_number, String expire_date) {
        this.id = id;
        this.card_holder = card_holder;
        this.card_number = card_number;
        this.expire_date = expire_date;
    }

    public Payment(String card_holder, String card_number, String expire_date) {
        this.card_holder = card_holder;
        this.card_number = card_number;
        this.expire_date = expire_date;
    }

    public int getId() {
        return id;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getExpire_date() {
        return expire_date;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }


}
