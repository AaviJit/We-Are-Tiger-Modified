package com.sweetitech.tiger.model.EntitySportAPI.TeamMatches;

import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;

import java.util.List;

public class Response {

    private List<Match> matchList;

    private Integer total_items;

    private Integer  total_pages;

    public List<Match> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
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
}
