package com.sweetitech.tiger.model.EntitySportAPI.ICCRanking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RankingProperties {

    private String rank;

    private String player;

    private String team;

    private String rating;

    private String points;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "RankingProperties{" +
                "rank='" + rank + '\'' +
                ", player='" + player + '\'' +
                ", team='" + team + '\'' +
                ", rating='" + rating + '\'' +
                ", points='" + points + '\'' +
                '}';
    }
}
