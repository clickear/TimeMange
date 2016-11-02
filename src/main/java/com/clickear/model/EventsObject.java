package com.clickear.model;

/**
* Created by Administrator on 2016/10/20.
*/

import java.util.Date;

public class EventsObject {
    private Integer eventsid;
    private String title;
    private Date start;
    private  Date end;
    private String description;
    private Integer state;

    public Integer getEventsid() {
        return eventsid;
    }

    public void setEventsid(Integer eventsid) {
        this.eventsid = eventsid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
