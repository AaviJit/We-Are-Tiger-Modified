package com.sweetitech.tiger.model.EntitySportAPI.PlayerSearch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private String status;

    private List<Player> items;

    private String total_items;

    private Integer total_pages;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Player> getItems() {
        return items;
    }

    public void setItems(List<Player> items) {
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
}
