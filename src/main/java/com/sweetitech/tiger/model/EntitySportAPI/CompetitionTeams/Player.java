package com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.ICCRanking.RankingProperties;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {


    private List<String> primary_team;

    private Integer pid;

    private String name;

    private String title;

    private String short_name;

    private String first_name;

    private String last_name;

    private String middle_name;

    private String birthdate;

    private String birthplace;

    private String country;

    private String thumb_url;

    private String logo_url;

    private String playing_role;

    private String role;

    private String role_str;

    private String batting_style;

    private String bowling_style;

    private String fielding_position;

    private Integer recent_match;

    private Integer recent_appearance;


    //for batting properties
    private Integer batsman_id;

    private Integer runs;

    private Integer balls_faced;

    private Integer balls;

    private Integer fours;

    private Integer sixes;

    private String how_out;

    private String dismissal;

    private String strike_rate;

    private Integer bowler_id;

    private Integer first_fielder_id;

    private Integer second_fielder_id;

    private Integer third_fielder_id;

    private Integer score_at_dismissal;

    private String  overs_at_dismissal;

    private List<RankingProperties> odis;

    private List<RankingProperties> tests;

    private List<RankingProperties> t20s;

    private Integer number;


    //for bowling properties
    private String overs;

    private Integer maidens;

    private Integer runs_conceded;

    private Integer wickets;

    private Integer noballs;

    private Integer wides;

    private String econ;


    public List<String> getPrimary_team() {
        return primary_team;
    }

    public void setPrimary_team(List<String> primary_team) {
        this.primary_team = primary_team;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getPlaying_role() {
        return playing_role;
    }

    public void setPlaying_role(String playing_role) {
        this.playing_role = playing_role;
    }

    public String getBatting_style() {
        return batting_style;
    }

    public void setBatting_style(String batting_style) {
        this.batting_style = batting_style;
    }

    public String getBowling_style() {
        return bowling_style;
    }

    public void setBowling_style(String bowling_style) {
        this.bowling_style = bowling_style;
    }

    public String getFielding_position() {
        return fielding_position;
    }

    public void setFielding_position(String fielding_position) {
        this.fielding_position = fielding_position;
    }

    public Integer getRecent_match() {
        return recent_match;
    }

    public void setRecent_match(Integer recent_match) {
        this.recent_match = recent_match;
    }

    public Integer getRecent_appearance() {
        return recent_appearance;
    }

    public void setRecent_appearance(Integer recent_appearance) {
        this.recent_appearance = recent_appearance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole_str() {
        return role_str;
    }

    public void setRole_str(String role_str) {
        this.role_str = role_str;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Integer getBalls_faced() {
        return balls_faced;
    }

    public void setBalls_faced(Integer balls_faced) {
        this.balls_faced = balls_faced;
    }

    public Integer getFours() {
        return fours;
    }

    public void setFours(Integer fours) {
        this.fours = fours;
    }

    public Integer getSixes() {
        return sixes;
    }

    public void setSixes(Integer sixes) {
        this.sixes = sixes;
    }

    public String getHow_out() {
        return how_out;
    }

    public void setHow_out(String how_out) {
        this.how_out = how_out;
    }

    public String getDismissal() {
        return dismissal;
    }

    public void setDismissal(String dismissal) {
        this.dismissal = dismissal;
    }

    public String getStrike_rate() {
        return strike_rate;
    }

    public void setStrike_rate(String strike_rate) {
        this.strike_rate = strike_rate;
    }

    public Integer getBowler_id() {
        return bowler_id;
    }

    public void setBowler_id(Integer bowler_id) {
        this.bowler_id = bowler_id;
    }

    public Integer getFirst_fielder_id() {
        return first_fielder_id;
    }

    public void setFirst_fielder_id(Integer first_fielder_id) {
        this.first_fielder_id = first_fielder_id;
    }

    public Integer getSecond_fielder_id() {
        return second_fielder_id;
    }

    public void setSecond_fielder_id(Integer second_fielder_id) {
        this.second_fielder_id = second_fielder_id;
    }

    public Integer getThird_fielder_id() {
        return third_fielder_id;
    }

    public void setThird_fielder_id(Integer third_fielder_id) {
        this.third_fielder_id = third_fielder_id;
    }

    public Integer getScore_at_dismissal() {
        return score_at_dismissal;
    }

    public void setScore_at_dismissal(Integer score_at_dismissal) {
        this.score_at_dismissal = score_at_dismissal;
    }

    public String getOvers_at_dismissal() {
        return overs_at_dismissal;
    }

    public void setOvers_at_dismissal(String overs_at_dismissal) {
        this.overs_at_dismissal = overs_at_dismissal;
    }

    public List<RankingProperties> getOdis() {
        return odis;
    }

    public void setOdis(List<RankingProperties> odis) {
        this.odis = odis;
    }

    public List<RankingProperties> getTests() {
        return tests;
    }

    public void setTests(List<RankingProperties> tests) {
        this.tests = tests;
    }

    public List<RankingProperties> getT20s() {
        return t20s;
    }

    public void setT20s(List<RankingProperties> t20s) {
        this.t20s = t20s;
    }

    public String getOvers() {
        return overs;
    }

    public void setOvers(String overs) {
        this.overs = overs;
    }

    public Integer getMaidens() {
        return maidens;
    }

    public void setMaidens(Integer maidens) {
        this.maidens = maidens;
    }

    public Integer getRuns_conceded() {
        return runs_conceded;
    }

    public void setRuns_conceded(Integer runs_conceded) {
        this.runs_conceded = runs_conceded;
    }

    public Integer getWickets() {
        return wickets;
    }

    public void setWickets(Integer wickets) {
        this.wickets = wickets;
    }

    public Integer getNoballs() {
        return noballs;
    }

    public void setNoballs(Integer noballs) {
        this.noballs = noballs;
    }

    public Integer getWides() {
        return wides;
    }

    public void setWides(Integer wides) {
        this.wides = wides;
    }

    public String getEcon() {
        return econ;
    }

    public void setEcon(String econ) {
        this.econ = econ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBatsman_id() {
        return batsman_id;
    }

    public void setBatsman_id(Integer batsman_id) {
        this.batsman_id = batsman_id;
    }

    public Integer getBalls() {
        return balls;
    }

    public void setBalls(Integer balls) {
        this.balls = balls;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Player{" +
                "primary_team=" + primary_team +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", short_name='" + short_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", country='" + country + '\'' +
                ", thumb_url='" + thumb_url + '\'' +
                ", logo_url='" + logo_url + '\'' +
                ", playing_role='" + playing_role + '\'' +
                ", role='" + role + '\'' +
                ", role_str='" + role_str + '\'' +
                ", batting_style='" + batting_style + '\'' +
                ", bowling_style='" + bowling_style + '\'' +
                ", fielding_position='" + fielding_position + '\'' +
                ", recent_match=" + recent_match +
                ", recent_appearance=" + recent_appearance +
                ", batsman_id=" + batsman_id +
                ", runs=" + runs +
                ", balls_faced=" + balls_faced +
                ", balls=" + balls +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", how_out='" + how_out + '\'' +
                ", dismissal='" + dismissal + '\'' +
                ", strike_rate='" + strike_rate + '\'' +
                ", bowler_id=" + bowler_id +
                ", first_fielder_id=" + first_fielder_id +
                ", second_fielder_id=" + second_fielder_id +
                ", third_fielder_id=" + third_fielder_id +
                ", score_at_dismissal=" + score_at_dismissal +
                ", overs_at_dismissal='" + overs_at_dismissal + '\'' +
                ", odis=" + odis +
                ", tests=" + tests +
                ", t20s=" + t20s +
                ", number=" + number +
                ", overs='" + overs + '\'' +
                ", maidens=" + maidens +
                ", runs_conceded=" + runs_conceded +
                ", wickets=" + wickets +
                ", noballs=" + noballs +
                ", wides=" + wides +
                ", econ='" + econ + '\'' +
                '}';
    }
}
