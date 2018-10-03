package com.sweetitech.tiger.model.EntitySportAPI.MatchInningsCommentary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commentary {

    private String event;

    private Integer batsman_id;

    private Integer bowler_id;

    private String over;

    private String ball;

    private String score;

    private Integer runs;

    private String commentary;

    private List<Player> bats;

    private List<Player> bowls;

    private Integer wicket_batsman_id;

    private String how_out;

    private Integer batsman_runs;

    private Integer batsman_balls;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

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

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public String getBall() {
        return ball;
    }

    public void setBall(String ball) {
        this.ball = ball;
    }

    //    public Integer getBall() {
//        return ball;
//    }
//
//    public void setBall(Integer ball) {
//        this.ball = ball;
//    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public List<Player> getBats() {
        return bats;
    }

    public void setBats(List<Player> bats) {
        this.bats = bats;
    }

    public List<Player> getBowls() {
        return bowls;
    }

    public void setBowls(List<Player> bowls) {
        this.bowls = bowls;
    }

    public Integer getWicket_batsman_id() {
        return wicket_batsman_id;
    }

    public void setWicket_batsman_id(Integer wicket_batsman_id) {
        this.wicket_batsman_id = wicket_batsman_id;
    }

    public String getHow_out() {
        return how_out;
    }

    public void setHow_out(String how_out) {
        this.how_out = how_out;
    }

    public Integer getBatsman_runs() {
        return batsman_runs;
    }

    public void setBatsman_runs(Integer batsman_runs) {
        this.batsman_runs = batsman_runs;
    }

    public Integer getBatsman_balls() {
        return batsman_balls;
    }

    public void setBatsman_balls(Integer batsman_balls) {
        this.batsman_balls = batsman_balls;
    }

    @Override
    public String toString() {
        return "Commentary{" +
                "event='" + event + '\'' +
                ", batsman_id=" + batsman_id +
                ", bowler_id=" + bowler_id +
                ", over='" + over + '\'' +
                ", ball=" + ball +
                ", score='" + score + '\'' +
                ", runs=" + runs +
                ", commentary='" + commentary + '\'' +
                ", bats=" + bats +
                ", bowls=" + bowls +
                ", wicket_batsman_id=" + wicket_batsman_id +
                ", how_out='" + how_out + '\'' +
                ", batsman_runs=" + batsman_runs +
                ", batsman_balls=" + batsman_balls +
                '}';
    }
}
