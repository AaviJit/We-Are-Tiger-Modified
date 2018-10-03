package com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private Integer tid;

    private String title;

    private String abbr;

    private String thumb_url;

    private String logo_url;

    private String type;

    private String country;

    private String alt_name;

    private List<Player> players;

    private Integer team_id;

    private String name;

    private String short_name;

    private String scores_full;

    private String scores;

    private String overs;

    private String country_iso;






    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAlt_name() {
        return alt_name;
    }

    public void setAlt_name(String alt_name) {
        this.alt_name = alt_name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getScores_full() {
        return scores_full;
    }

    public void setScores_full(String scores_full) {
        this.scores_full = scores_full;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public String getCountry_iso() {
        return country_iso;
    }

    public void setCountry_iso(String country_iso) {
        this.country_iso = country_iso;
    }

    @Override
    public String toString() {
        return "Team{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", abbr='" + abbr + '\'' +
                ", thumb_url='" + thumb_url + '\'' +
                ", logo_url='" + logo_url + '\'' +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", alt_name='" + alt_name + '\'' +
                ", players=" + players +
                ", team_id=" + team_id +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", scores_full='" + scores_full + '\'' +
                ", scores='" + scores + '\'' +
                ", overs='" + overs + '\'' +
                ", country_iso='" + country_iso + '\'' +
                '}';
    }
}