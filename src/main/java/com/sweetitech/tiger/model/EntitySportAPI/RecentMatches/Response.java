package com.sweetitech.tiger.model.EntitySportAPI.RecentMatches;

import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;

import java.util.List;

public class Response {

    private List<Match> items;
    private String total_items;
    private Integer total_pages;

    public List<Match> getItems() {
        return items;
    }

    public void setItems(List<Match> items) {
        this.items = items;
    }

    public String getTotal_items() {
        return total_items;
    }

    public void setTotal_items(String total_items) {
        this.total_items = total_items;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "Response{" +
                "items=" + items +
                ", total_items='" + total_items + '\'' +
                ", total_pages=" + total_pages +
                '}';
    }
}
