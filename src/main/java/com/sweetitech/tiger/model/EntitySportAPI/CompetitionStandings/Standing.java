package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStandings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standing {

    private Integer team_id;

    private Integer played;

    private Integer win;

    private Integer draw;

    private Integer loss;

    private Integer nr;   //total number of no result matches

    private String overfor;

    private Integer runfor;

    private String overagainst;

    private Integer runagainst;

    private String netrr;

    private Integer points;

    private Team teams;

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public Integer getPlayed() {
        return played;
    }

    public void setPlayed(Integer played) {
        this.played = played;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLoss() {
        return loss;
    }

    public void setLoss(Integer loss) {
        this.loss = loss;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }

    public String getOverfor() {
        return overfor;
    }

    public void setOverfor(String overfor) {
        this.overfor = overfor;
    }

    public Integer getRunfor() {
        return runfor;
    }

    public void setRunfor(Integer runfor) {
        this.runfor = runfor;
    }

    public String getOveragainst() {
        return overagainst;
    }

    public void setOveragainst(String overagainst) {
        this.overagainst = overagainst;
    }

    public Integer getRunagainst() {
        return runagainst;
    }

    public void setRunagainst(Integer runagainst) {
        this.runagainst = runagainst;
    }

    public String getNetrr() {
        return netrr;
    }

    public void setNetrr(String netrr) {
        this.netrr = netrr;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Team getTeams() {
        return teams;
    }

    public void setTeams(Team teams) {
        this.teams = teams;
    }
}
