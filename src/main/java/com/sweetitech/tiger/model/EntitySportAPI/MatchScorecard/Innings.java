package com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics.StatisticProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonIgnoreProperties({"last_wicket"})*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Innings {

    private Integer iid;

    private Integer number;

    private String name;

    private String short_name;

    private Integer status;

    private Integer result;

    private Integer batting_team_id;

    private Integer fielding_team_id;

    private String scores;

    private String scores_full;

    private List<Player> batsmen;

    private List<Player> bowlers;

    private List<Player> fows;  //fows= Fall of wickets

    private StatisticProperty statisticProperty;

/*    private Player last_wicket;*/

    private ExtraRuns extra_runs;

    private Equation equations;

    private CurrentPartnership current_partnership;

    private String recent_scores;

    private String last_five_overs;

    private String last_ten_overs;

    private List<Player> players;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getBatting_team_id() {
        return batting_team_id;
    }

    public void setBatting_team_id(Integer batting_team_id) {
        this.batting_team_id = batting_team_id;
    }

    public Integer getFielding_team_id() {
        return fielding_team_id;
    }

    public void setFielding_team_id(Integer fielding_team_id) {
        this.fielding_team_id = fielding_team_id;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public String getScores_full() {
        return scores_full;
    }

    public void setScores_full(String scores_full) {
        this.scores_full = scores_full;
    }

    public List<Player> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(List<Player> batsmen) {
        this.batsmen = batsmen;
    }

    public List<Player> getBowlers() {
        return bowlers;
    }

    public void setBowlers(List<Player> bowlers) {
        this.bowlers = bowlers;
    }

    public List<Player> getFows() {
        return fows;
    }

    public void setFows(List<Player> fows) {
        this.fows = fows;
    }

    public StatisticProperty getStatisticProperty() {
        return statisticProperty;
    }

    public void setStatisticProperty(StatisticProperty statisticProperty) {
        this.statisticProperty = statisticProperty;
    }

    public ExtraRuns getExtra_runs() {
        return extra_runs;
    }

    public void setExtra_runs(ExtraRuns extra_runs) {
        this.extra_runs = extra_runs;
    }

    public Equation getEquations() {
        return equations;
    }

    public void setEquations(Equation equations) {
        this.equations = equations;
    }

    public CurrentPartnership getCurrent_partnership() {
        return current_partnership;
    }

    public void setCurrent_partnership(CurrentPartnership current_partnership) {
        this.current_partnership = current_partnership;
    }

    public String getRecent_scores() {
        return recent_scores;
    }

    public void setRecent_scores(String recent_scores) {
        this.recent_scores = recent_scores;
    }

    public String getLast_five_overs() {
        return last_five_overs;
    }

    public void setLast_five_overs(String last_five_overs) {
        this.last_five_overs = last_five_overs;
    }

    public String getLast_ten_overs() {
        return last_ten_overs;
    }

    public void setLast_ten_overs(String last_ten_overs) {
        this.last_ten_overs = last_ten_overs;
    }

    @Override
    public String toString() {
        return "Innings{" +
                "iid=" + iid +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", short_name='" + short_name + '\'' +
                ", status=" + status +
                ", result=" + result +
                ", batting_team_id=" + batting_team_id +
                ", fielding_team_id=" + fielding_team_id +
                ", scores='" + scores + '\'' +
                ", scores_full='" + scores_full + '\'' +
                ", batsmen=" + batsmen +
                ", bowlers=" + bowlers +
                ", fows=" + fows +
                ", statisticProperty=" + statisticProperty +
                ", extra_runs=" + extra_runs +
                ", equations=" + equations +
                ", current_partnership=" + current_partnership +
                ", recent_scores='" + recent_scores + '\'' +
                ", last_five_overs='" + last_five_overs + '\'' +
                ", last_ten_overs='" + last_ten_overs + '\'' +
                '}';
    }
}
