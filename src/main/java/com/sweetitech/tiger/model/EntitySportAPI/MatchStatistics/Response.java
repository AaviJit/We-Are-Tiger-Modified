package com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics;

import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.Innings;

import java.util.List;

public class Response {

    private List<Innings> inningsList;

    private List<Team> teamList;

    private List<Player> playerList;

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

    public List<Innings> getInningsList() {
        return inningsList;
    }

    public void setInningsList(List<Innings> inningsList) {
        this.inningsList = inningsList;
    }
}
