package com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentPartnership {

    private Integer runs;
    private Integer  balls;
    private String overs;
    private List<Player> batsmen;

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public List<Player> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(List<Player> batsmen) {
        this.batsmen = batsmen;
    }

    @Override
    public String toString() {
        return "CurrentPartnership{" +
                "runs=" + runs +
                ", balls=" + balls +
                ", overs='" + overs + '\'' +
                ", batsmen=" + batsmen +
                '}';
    }
}
