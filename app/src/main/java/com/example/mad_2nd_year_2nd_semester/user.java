package com.example.mad_2nd_year_2nd_semester;

public class user {

    private  int id;
    private  String name;
    private  String email;
    private  String birthday;
    private  String phone;
    private  String password;

    public user() {
        id = 0;
        name="";
        email="";
        birthday="";
        phone="";
        password="";
    }

    public user(int id, String name, String email, String birthday, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday= birthday;
        this.phone = phoneNumber;
        this.password = password;
    }
    public user(String name, String email, String birthday, String phoneNumber, String password) {

        this.name = name;
        this.email = email;
        this.birthday= birthday;
        this.phone = phoneNumber;
        this.password = password;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthday() { return birthday;}

    public String getPhoneNumber() { return phone;}

    public String getPassword() { return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}





