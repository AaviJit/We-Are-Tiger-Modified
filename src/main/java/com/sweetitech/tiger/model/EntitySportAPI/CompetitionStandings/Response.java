package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private String standing_type;
    private List<Standings> standingsList;

    public String getStanding_type() {
        return standing_type;
    }

    public void setStanding_type(String standing_type) {
        this.standing_type = standing_type;
    }

    public List<Standings> getStandingsList() {
        return standingsList;
    }

    public void setStandingsList(List<Standings> standingsList) {
        this.standingsList = standingsList;
    }
}
