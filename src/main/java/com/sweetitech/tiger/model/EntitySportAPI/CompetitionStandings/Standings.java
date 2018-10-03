package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.SeasonCompetitions.Round;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standings {

    private Round round;
    private List<Standing> standingList;

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public List<Standing> getStandingList() {
        return standingList;
    }

    public void setStandingList(List<Standing> standingList) {
        this.standingList = standingList;
    }
}
