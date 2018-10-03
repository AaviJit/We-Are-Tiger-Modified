package com.sweetitech.tiger.model.EntitySportAPI.ICCRanking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

    private String teams;

    private String  batsmen;

    private String  bowlers;

    private String all_rounders;

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(String batsmen) {
        this.batsmen = batsmen;
    }

    public String getBowlers() {
        return bowlers;
    }

    public void setBowlers(String bowlers) {
        this.bowlers = bowlers;
    }

    public String getAll_rounders() {
        return all_rounders;
    }

    public void setAll_rounders(String all_rounders) {
        this.all_rounders = all_rounders;
    }
}
