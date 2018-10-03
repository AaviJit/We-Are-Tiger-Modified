package com.sweetitech.tiger.model.EntitySportAPI.CompetitionSquads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private Integer total_teams;
    private List<Team> teams;

    public Integer getTotal_teams() {
        return total_teams;
    }

    public void setTotal_teams(Integer total_teams) {
        this.total_teams = total_teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
