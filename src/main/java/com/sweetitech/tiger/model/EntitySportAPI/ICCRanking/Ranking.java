package com.sweetitech.tiger.model.EntitySportAPI.ICCRanking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ranking {

    private Player batsman;

    private Player bowler;

    private AllRounder allRounder;

    private TeamWithRank teamWithRank;

    public Player getBatsman() {
        return batsman;
    }

    public void setBatsman(Player batsman) {
        this.batsman = batsman;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public AllRounder getAllRounder() {
        return allRounder;
    }

    public void setAllRounder(AllRounder allRounder) {
        this.allRounder = allRounder;
    }

    public TeamWithRank getTeamWithRank() {
        return teamWithRank;
    }

    public void setTeamWithRank(TeamWithRank teamWithRank) {
        this.teamWithRank = teamWithRank;
    }
}
