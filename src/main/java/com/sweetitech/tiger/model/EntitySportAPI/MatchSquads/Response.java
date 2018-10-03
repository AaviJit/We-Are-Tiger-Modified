package com.sweetitech.tiger.model.EntitySportAPI.MatchSquads;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private Team teama;

    private Team teamb;

    private List<Team> teamList;

    private List<Player> playerList;

    public Team getTeama() {
        return teama;
    }

    public void setTeama(Team teama) {
        this.teama = teama;
    }

    public Team getTeamb() {
        return teamb;
    }

    public void setTeamb(Team teamb) {
        this.teamb = teamb;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}
