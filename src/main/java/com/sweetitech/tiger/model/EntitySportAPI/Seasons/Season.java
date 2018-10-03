package com.sweetitech.tiger.model.EntitySportAPI.Seasons;

public class Season {

    private int sid;
    private String name;
    private String competitions_url;


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompetitions_url() {
        return competitions_url;
    }

    public void setCompetitions_url(String competitions_url) {
        this.competitions_url = competitions_url;
    }
}