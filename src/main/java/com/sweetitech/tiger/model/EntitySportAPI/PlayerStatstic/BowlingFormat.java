package com.sweetitech.tiger.model.EntitySportAPI.PlayerStatstic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BowlingFormat {

    private Integer match_id;

    private Integer inning_id;

    private Integer matches;

    private Integer innings;

    private Integer balls;

    private Integer overs;

    private Integer runs;

    private Integer wickets;

    private String bestinning;

    private String bestmatch;

    private String econ;

    private String average;

    private String strike;

    private Integer wicket4i;

    private Integer wicket5i;

    private Integer wicket10m;

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getInning_id() {
        return inning_id;
    }

    public void setInning_id(Integer inning_id) {
        this.inning_id = inning_id;
    }

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

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getOvers() {
        return overs;
    }

    public void setOvers(Integer overs) {
        this.overs = overs;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public String getBestinning() {
        return bestinning;
    }

    public void setBestinning(String bestinning) {
        this.bestinning = bestinning;
    }

    public String getBestmatch() {
        return bestmatch;
    }

    public void setBestmatch(String bestmatch) {
        this.bestmatch = bestmatch;
    }

    public String getEcon() {
        return econ;
    }

    public void setEcon(String econ) {
        this.econ = econ;
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

    public Integer getWicket4i() {
        return wicket4i;
    }

    public void setWicket4i(Integer wicket4i) {
        this.wicket4i = wicket4i;
    }

    public Integer getWicket5i() {
        return wicket5i;
    }

    public void setWicket5i(Integer wicket5i) {
        this.wicket5i = wicket5i;
    }

    public Integer getWicket10m() {
        return wicket10m;
    }

    public void setWicket10m(Integer wicket10m) {
        this.wicket10m = wicket10m;
    }
}
