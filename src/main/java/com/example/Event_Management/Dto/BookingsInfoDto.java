package com.example.Event_Management.Dto;

public class BookingsInfoDto {
    private String username;
    private String eventname;

    public BookingsInfoDto(String username, String eventname) {
        this.username = username;
        this.eventname = eventname;
    }

    public BookingsInfoDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }
}
