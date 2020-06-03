package com.example.misfitcoders;

public class Card {
    private String name;
    private String members;
    private int seats;
    private String destination;
    private String time;
    private String phoneNo;

    public Card() {
        //empty constructor needed
    }
    public Card(String name, String members, int seats,String destination,String time,String phoneNo) {
        this.name = name;
        this.members = members;
        this.seats = seats;
        this.destination = destination;
        this.time = time;
        this.phoneNo = phoneNo;

    }
    public String getName() {
        return name;
    }
    public String getMembers() {
        return members;
    }
    public int getSeats() {
        return seats;
    }
    public String getDestination(){
        return destination;
    }
    public String getTime(){
        return time;
    }
    public String getPhoneNo(){
        return phoneNo;
    }

}
