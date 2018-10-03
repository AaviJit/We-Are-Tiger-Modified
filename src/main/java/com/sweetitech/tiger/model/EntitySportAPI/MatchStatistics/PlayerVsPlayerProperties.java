package com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerVsPlayerProperties {

    private Integer batsman_id;

    private Integer bowler_id;

    private Integer runs;

    private Integer balls;

    private Integer run4;

    private Integer run6;

    private Integer run0;

    private Integer run1;

    private Integer run2;

    private Integer run3;

    private Integer run5;

    private Integer run6p;

    public Integer getBatsman_id() {
        return batsman_id;
    }

    public void setBatsman_id(Integer batsman_id) {
        this.batsman_id = batsman_id;
    }

    public Integer getBowler_id() {
        return bowler_id;
    }

    public void setBowler_id(Integer bowler_id) {
        this.bowler_id = bowler_id;
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

    public Integer getRun0() {
        return run0;
    }

    public void setRun0(Integer run0) {
        this.run0 = run0;
    }

    public Integer getRun1() {
        return run1;
    }

    public void setRun1(Integer run1) {
        this.run1 = run1;
    }

    public Integer getRun2() {
        return run2;
    }

    public void setRun2(Integer run2) {
        this.run2 = run2;
    }

    public Integer getRun3() {
        return run3;
    }

    public void setRun3(Integer run3) {
        this.run3 = run3;
    }

    public Integer getRun5() {
        return run5;
    }

    public void setRun5(Integer run5) {
        this.run5 = run5;
    }

    public Integer getRun6p() {
        return run6p;
    }

    public void setRun6p(Integer run6p) {
        this.run6p = run6p;
    }

    @Override
    public String toString() {
        return "PlayerVsPlayerProperties{" +
                "batsman_id=" + batsman_id +
                ", bowler_id=" + bowler_id +
                ", runs=" + runs +
                ", balls=" + balls +
                ", run4=" + run4 +
                ", run6=" + run6 +
                ", run0=" + run0 +
                ", run1=" + run1 +
                ", run2=" + run2 +
                ", run3=" + run3 +
                ", run5=" + run5 +
                ", run6p=" + run6p +
                '}';
    }
}
