package com.example.mad_2nd_year_2nd_semester;

public class Booking {

    private int id;
    private String ticketClass;
    private int availableTickets;
    private String fullName;
    private String date;
    private String mobileNo;
    private String showTime;
    private String center;
    private int ticketCount;

    public Booking() {
        this.id = 0;
        this.ticketClass = "";
        this.availableTickets = 0;
        this.fullName = "";
        this.date = "";
        this.mobileNo = "";
        this.showTime = "";
        this.center = "";
        this.ticketCount = 0;
    }

    public Booking(String ticketClass, String fullName, String date, String mobileNo, String showTime, String center, int ticketCount) {
        this.ticketClass = ticketClass;
        this.fullName = fullName;
        this.date = date;
        this.mobileNo = mobileNo;
        this.showTime = showTime;
        this.center = center;
        this.ticketCount = ticketCount;
    }

    public Booking(int id, String ticketClass, String fullName, String date, String mobileNo, String showTime, String center, int ticketCount) {
        this.id = id;
        this.ticketClass = ticketClass;
        this.fullName = fullName;
        this.date = date;
        this.mobileNo = mobileNo;
        this.showTime = showTime;
        this.center = center;
        this.ticketCount = ticketCount;
    }

    public int getId() {
        return id;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDate() {
        return date;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getCenter() {
        return center;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setAvailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}
