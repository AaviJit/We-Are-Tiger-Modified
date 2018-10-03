package com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Equation {

    private Integer runs;

    private Integer wickets;

    private String overs;

    private Integer bowlers_used;

    private String runrate;

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

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public Integer getBowlers_used() {
        return bowlers_used;
    }

    public void setBowlers_used(Integer bowlers_used) {
        this.bowlers_used = bowlers_used;
    }

    public String getRunrate() {
        return runrate;
    }

    public void setRunrate(String runrate) {
        this.runrate = runrate;
    }

    @Override
    public String toString() {
        return "Equation{" +
                "runs=" + runs +
                ", wickets=" + wickets +
                ", overs='" + overs + '\'' +
                ", bowlers_used=" + bowlers_used +
                ", runrate='" + runrate + '\'' +
                '}';
    }
}
