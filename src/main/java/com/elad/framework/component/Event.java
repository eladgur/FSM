package com.elad.framework.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Event {

    private String id;
    private Date date;

    public Event(String id) {
        this.id = id;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getCreatedTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/ HH:mm:ss");

        return dateFormat.format(date); //2016/11/16 12:08:43
    }
}