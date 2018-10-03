package com.sweetitech.tiger.model.EntitySportAPI.MatchInningsCommentary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.Innings;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private Match match;

    private Innings innings;

    private List<Commentary> commentaryList;

    private List<Team> teams;

    private List<Player> playerList;

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Innings getInnings() {
        return innings;
    }

    public void setInnings(Innings innings) {
        this.innings = innings;
    }

    public List<Commentary> getCommentaryList() {
        return commentaryList;
    }

    public void setCommentaryList(List<Commentary> commentaryList) {
        this.commentaryList = commentaryList;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
