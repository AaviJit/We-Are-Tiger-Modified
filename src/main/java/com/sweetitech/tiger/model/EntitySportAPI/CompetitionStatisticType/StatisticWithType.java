package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStatisticType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatisticWithType {
    private String group_title;
    private TeamStatistic teamStatistic;

    public String getGroup_title() {
        return group_title;
    }

    public void setGroup_title(String group_title) {
        this.group_title = group_title;
    }

    public TeamStatistic getTeamStatistic() {
        return teamStatistic;
    }

    public void setTeamStatistic(TeamStatistic teamStatistic) {
        this.teamStatistic = teamStatistic;
    }
}
