package com.sweetitech.tiger.model.EntitySportAPI.LiveMatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveScore {

    private Integer runs;

    private String overs;

    private Integer wickets;

    private Integer target;

    private String runrate;

    private String required_runrate;


    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getRunrate() {
        return runrate;
    }

    public void setRunrate(String runrate) {
        this.runrate = runrate;
    }

    public String getRequired_runrate() {
        return required_runrate;
    }

    public void setRequired_runrate(String required_runrate) {
        this.required_runrate = required_runrate;
    }

    @Override
    public String toString() {
        return "LiveScore{" +
                "runs=" + runs +
                ", overs='" + overs + '\'' +
                ", wickets=" + wickets +
                ", target=" + target +
                ", runrate='" + runrate + '\'' +
                '}';
    }
}
