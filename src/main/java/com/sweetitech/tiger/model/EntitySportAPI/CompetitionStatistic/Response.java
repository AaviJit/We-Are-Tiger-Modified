package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStatistic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionStatisticType.StatisticWithType;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private List<Statistic> statisticList;

    private Integer total_items;

    private Integer total_pages;

    private List<String>formats;

    private List<StatisticWithType> statisticWithTypes;

    private String format;

    private List<Team> teams;

    public List<Statistic> getStatisticList() {
        return statisticList;
    }

    public void setStatisticList(List<Statistic> statisticList) {
        this.statisticList = statisticList;
    }

    public Integer getTotal_items() {
        return total_items;
    }

    public void setTotal_items(Integer total_items) {
        this.total_items = total_items;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }

    public List<StatisticWithType> getStatisticWithTypes() {
        return statisticWithTypes;
    }

    public void setStatisticWithTypes(List<StatisticWithType> statisticWithTypes) {
        this.statisticWithTypes = statisticWithTypes;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
