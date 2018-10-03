package com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Toss {


private String text;


private Integer winner;

private Integer decision;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Integer getDecision() {
        return decision;
    }

    public void setDecision(Integer decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "Toss{" +
                "text='" + text + '\'' +
                ", winner=" + winner +
                ", decision=" + decision +
                '}';
    }
}