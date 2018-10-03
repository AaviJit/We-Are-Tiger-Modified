package com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtraRuns {

    private Integer byes;

    private Integer legbyes;

    private Integer wides;

    private Integer noballs;

    private Integer penalty;

    private Integer total;



    public Integer getByes() {
        return byes;
    }

    public void setByes(Integer byes) {
        this.byes = byes;
    }

    public Integer getLegbyes() {
        return legbyes;
    }

    public void setLegbyes(Integer legbyes) {
        this.legbyes = legbyes;
    }

    public Integer getWides() {
        return wides;
    }

    public void setWides(Integer wides) {
        this.wides = wides;
    }

    public Integer getNoballs() {
        return noballs;
    }

    public void setNoballs(Integer noballs) {
        this.noballs = noballs;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ExtraRuns{" +
                "byes=" + byes +
                ", legbyes=" + legbyes +
                ", wides=" + wides +
                ", noballs=" + noballs +
                ", penalty=" + penalty +
                ", total=" + total +
                '}';
    }
}
