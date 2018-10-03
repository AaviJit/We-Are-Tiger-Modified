package com.sweetitech.tiger.model.EntitySportAPI.SeasonCompetitions;

import java.util.List;

public class Response {

    private List<Competition> competitions;
    private Integer total_items;
    private Integer total_pages;

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<Competition> competitions) {
        this.competitions = competitions;
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