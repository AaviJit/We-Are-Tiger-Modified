package com.sweetitech.tiger.model.EntitySportAPI.SeasonCompetitions;

import java.util.Date;
import java.util.List;

public class Competition {

    private Integer cid;

    private String game_format;

    private String table;

    private String title;

    private String abbr;

    private String season;

    private String datestart;

    private String dateend;

    private Integer total_matches;

    private Integer total_rounds;

    private Integer total_teams;

    private String category;

    private String match_format;

    private String status;

    private String country;

    private String type;

    private String matches_url;

    private String teams_url;

    private String standings_url;

    private List<Round> rounds;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public String getDateend() {
        return dateend;
    }

    public void setDateend(String dateend) {
        this.dateend = dateend;
    }

    public Integer getTotal_matches() {
        return total_matches;
    }

    public void setTotal_matches(Integer total_matches) {
        this.total_matches = total_matches;
    }

    public Integer getTotal_rounds() {
        return total_rounds;
    }

    public void setTotal_rounds(Integer total_rounds) {
        this.total_rounds = total_rounds;
    }

    public Integer getTotal_teams() {
        return total_teams;
    }

    public void setTotal_teams(Integer total_teams) {
        this.total_teams = total_teams;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGame_format() {
        return game_format;
    }

    public void setGame_format(String game_format) {
        this.game_format = game_format;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getMatch_format() {
        return match_format;
    }

    public void setMatch_format(String match_format) {
        this.match_format = match_format;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMatches_url() {
        return matches_url;
    }

    public void setMatches_url(String matches_url) {
        this.matches_url = matches_url;
    }

    public String getTeams_url() {
        return teams_url;
    }

    public void setTeams_url(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getStandings_url() {
        return standings_url;
    }

    public void setStandings_url(String standings_url) {
        this.standings_url = standings_url;
    }

    public List<Round> getRounds() {
        return rounds;
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "cid=" + cid +
                ", game_format='" + game_format + '\'' +
                ", table='" + table + '\'' +
                ", title='" + title + '\'' +
                ", abbr='" + abbr + '\'' +
                ", season='" + season + '\'' +
                ", datestart='" + datestart + '\'' +
                ", dateend='" + dateend + '\'' +
                ", total_matches=" + total_matches +
                ", total_rounds=" + total_rounds +
                ", total_teams=" + total_teams +
                ", category='" + category + '\'' +
                ", match_format='" + match_format + '\'' +
                ", status='" + status + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", matches_url='" + matches_url + '\'' +
                ", teams_url='" + teams_url + '\'' +
                ", standings_url='" + standings_url + '\'' +
                ", rounds=" + rounds +
                '}';
    }
}