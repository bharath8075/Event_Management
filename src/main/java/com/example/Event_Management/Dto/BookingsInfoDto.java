package com.example.Event_Management.Dto;

import java.util.List;

public class BookingsInfoDto {
    private long userId;
    private String username;
    private List<String> eventname;

    public BookingsInfoDto(long userId, String username, List<String> eventname) {
        this.userId = userId;
        this.username = username;
        this.eventname = eventname;
    }

    public BookingsInfoDto() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getEventname() {
        return eventname;
    }

    public void setEventname(List<String> eventname) {
        this.eventname = eventname;
    }
}
