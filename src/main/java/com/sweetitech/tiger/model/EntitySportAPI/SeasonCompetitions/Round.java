package com.sweetitech.tiger.model.EntitySportAPI.SeasonCompetitions;

import java.util.Date;

public class Round {

    private Integer rid;

    private Integer order;

    private String name;

    private String type;

    private String match_format;

    private String datestart;

    private String dateend;

    private String matches_url;

    private String teams_url;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public String getDateend() {
        return dateend;
    }

    public void setDateend(String dateend) {
        this.dateend = dateend;
    }


    public String getMatches_url() {
        return matches_url;
    }

    public void setMatches_url(String matches_url) {
        this.matches_url = matches_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatch_format() {
        return match_format;
    }

    public void setMatch_format(String match_format) {
        this.match_format = match_format;
    }

    @Override
    public String toString() {
        return "Round{" +
                "rid=" + rid +
                ", order=" + order +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", match_format='" + match_format + '\'' +
                ", datestart='" + datestart + '\'' +
                ", dateend='" + dateend + '\'' +
                ", matches_url='" + matches_url + '\'' +
                ", teams_url='" + teams_url + '\'' +
                '}';
    }
}