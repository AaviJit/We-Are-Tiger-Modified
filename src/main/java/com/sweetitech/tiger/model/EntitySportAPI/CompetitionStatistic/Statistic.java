package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStatistic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistic {

    private Integer matches;

    private Integer innings;

    private Integer notout;

    private Integer runs;

    private Integer balls;

    private String  highest;

    private Integer run100;

    private Integer run50;

    private Integer run4;

    private Integer run6;

    private String  average;

    private String  strike;

    private Integer catches;

    private Integer stumpings;

    private Date  updated;

    private Team team;

    private Player player;

    public Integer getMatches() {
        return matches;
    }

    public void setMatches(Integer matches) {
        this.matches = matches;
    }

    public Integer getInnings() {
        return innings;
    }

    public void setInnings(Integer innings) {
        this.innings = innings;
    }

    public Integer getNotout() {
        return notout;
    }

    public void setNotout(Integer notout) {
        this.notout = notout;
    }

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

    public String getHighest() {
        return highest;
    }

    public void setHighest(String highest) {
        this.highest = highest;
    }

    public Integer getRun100() {
        return run100;
    }

    public void setRun100(Integer run100) {
        this.run100 = run100;
    }

    public Integer getRun50() {
        return run50;
    }

    public void setRun50(Integer run50) {
        this.run50 = run50;
    }

    public Integer getRun4() {
        return run4;
    }

    public void setRun4(Integer run4) {
        this.run4 = run4;
    }

    public Integer getRun6() {
        return run6;
    }

    public void setRun6(Integer run6) {
        this.run6 = run6;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public Integer getCatches() {
        return catches;
    }

    public void setCatches(Integer catches) {
        this.catches = catches;
    }

    public Integer getStumpings() {
        return stumpings;
    }

    public void setStumpings(Integer stumpings) {
        this.stumpings = stumpings;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
