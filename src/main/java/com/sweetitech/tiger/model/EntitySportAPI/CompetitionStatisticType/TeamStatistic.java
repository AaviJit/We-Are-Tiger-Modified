package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStatisticType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatistic {

    private String batting_most_runs;
    private String batting_most_runs_innings;
    private String batting_highest_strikerate;
    private String batting_highest_strikerate_innings;
    private String batting_highest_average;
    private String batting_most_run100;
    private String batting_most_run50;
    private String batting_most_run6;
    private String batting_most_run6_innings;
    private String batting_most_run4;
    private String batting_most_run4_innings;

    private String bowling_top_wicket_takers;
    private String bowling_best_economy_rates;
    private String bowling_best_economy_rates_innings;
    private String bowling_best_bowling_figures;
    private String bowling_best_strike_rates;
    private String bowling_best_strike_rates_innings;
    private String bowling_best_averages;
    private String bowling_most_runs_conceded_innings;
    private String bowling_four_wickets;
    private String bowling_five_wickets;
    private String bowling_maidens;

    private String team_total_runs;
    private String team_total_run100;
    private String team_total_run50;
    private String team_total_wickets;

    public String getBatting_most_runs() {
        return batting_most_runs;
    }

    public void setBatting_most_runs(String batting_most_runs) {
        this.batting_most_runs = batting_most_runs;
    }

    public String getBatting_most_runs_innings() {
        return batting_most_runs_innings;
    }

    public void setBatting_most_runs_innings(String batting_most_runs_innings) {
        this.batting_most_runs_innings = batting_most_runs_innings;
    }

    public String getBatting_highest_strikerate() {
        return batting_highest_strikerate;
    }

    public void setBatting_highest_strikerate(String batting_highest_strikerate) {
        this.batting_highest_strikerate = batting_highest_strikerate;
    }

    public String getBatting_highest_strikerate_innings() {
        return batting_highest_strikerate_innings;
    }

    public void setBatting_highest_strikerate_innings(String batting_highest_strikerate_innings) {
        this.batting_highest_strikerate_innings = batting_highest_strikerate_innings;
    }

    public String getBatting_highest_average() {
        return batting_highest_average;
    }

    public void setBatting_highest_average(String batting_highest_average) {
        this.batting_highest_average = batting_highest_average;
    }

    public String getBatting_most_run100() {
        return batting_most_run100;
    }

    public void setBatting_most_run100(String batting_most_run100) {
        this.batting_most_run100 = batting_most_run100;
    }

    public String getBatting_most_run50() {
        return batting_most_run50;
    }

    public void setBatting_most_run50(String batting_most_run50) {
        this.batting_most_run50 = batting_most_run50;
    }

    public String getBatting_most_run6() {
        return batting_most_run6;
    }

    public void setBatting_most_run6(String batting_most_run6) {
        this.batting_most_run6 = batting_most_run6;
    }

    public String getBatting_most_run6_innings() {
        return batting_most_run6_innings;
    }

    public void setBatting_most_run6_innings(String batting_most_run6_innings) {
        this.batting_most_run6_innings = batting_most_run6_innings;
    }

    public String getBatting_most_run4() {
        return batting_most_run4;
    }

    public void setBatting_most_run4(String batting_most_run4) {
        this.batting_most_run4 = batting_most_run4;
    }

    public String getBatting_most_run4_innings() {
        return batting_most_run4_innings;
    }

    public void setBatting_most_run4_innings(String batting_most_run4_innings) {
        this.batting_most_run4_innings = batting_most_run4_innings;
    }

    public String getBowling_top_wicket_takers() {
        return bowling_top_wicket_takers;
    }

    public void setBowling_top_wicket_takers(String bowling_top_wicket_takers) {
        this.bowling_top_wicket_takers = bowling_top_wicket_takers;
    }

    public String getBowling_best_economy_rates() {
        return bowling_best_economy_rates;
    }

    public void setBowling_best_economy_rates(String bowling_best_economy_rates) {
        this.bowling_best_economy_rates = bowling_best_economy_rates;
    }

    public String getBowling_best_economy_rates_innings() {
        return bowling_best_economy_rates_innings;
    }

    public void setBowling_best_economy_rates_innings(String bowling_best_economy_rates_innings) {
        this.bowling_best_economy_rates_innings = bowling_best_economy_rates_innings;
    }

    public String getBowling_best_bowling_figures() {
        return bowling_best_bowling_figures;
    }

    public void setBowling_best_bowling_figures(String bowling_best_bowling_figures) {
        this.bowling_best_bowling_figures = bowling_best_bowling_figures;
    }

    public String getBowling_best_strike_rates() {
        return bowling_best_strike_rates;
    }

    public void setBowling_best_strike_rates(String bowling_best_strike_rates) {
        this.bowling_best_strike_rates = bowling_best_strike_rates;
    }

    public String getBowling_best_strike_rates_innings() {
        return bowling_best_strike_rates_innings;
    }

    public void setBowling_best_strike_rates_innings(String bowling_best_strike_rates_innings) {
        this.bowling_best_strike_rates_innings = bowling_best_strike_rates_innings;
    }

    public String getBowling_best_averages() {
        return bowling_best_averages;
    }

    public void setBowling_best_averages(String bowling_best_averages) {
        this.bowling_best_averages = bowling_best_averages;
    }

    public String getBowling_most_runs_conceded_innings() {
        return bowling_most_runs_conceded_innings;
    }

    public void setBowling_most_runs_conceded_innings(String bowling_most_runs_conceded_innings) {
        this.bowling_most_runs_conceded_innings = bowling_most_runs_conceded_innings;
    }

    public String getBowling_four_wickets() {
        return bowling_four_wickets;
    }

    public void setBowling_four_wickets(String bowling_four_wickets) {
        this.bowling_four_wickets = bowling_four_wickets;
    }

    public String getBowling_five_wickets() {
        return bowling_five_wickets;
    }

    public void setBowling_five_wickets(String bowling_five_wickets) {
        this.bowling_five_wickets = bowling_five_wickets;
    }

    public String getBowling_maidens() {
        return bowling_maidens;
    }

    public void setBowling_maidens(String bowling_maidens) {
        this.bowling_maidens = bowling_maidens;
    }

    public String getTeam_total_runs() {
        return team_total_runs;
    }

    public void setTeam_total_runs(String team_total_runs) {
        this.team_total_runs = team_total_runs;
    }

    public String getTeam_total_run100() {
        return team_total_run100;
    }

    public void setTeam_total_run100(String team_total_run100) {
        this.team_total_run100 = team_total_run100;
    }

    public String getTeam_total_run50() {
        return team_total_run50;
    }

    public void setTeam_total_run50(String team_total_run50) {
        this.team_total_run50 = team_total_run50;
    }

    public String getTeam_total_wickets() {
        return team_total_wickets;
    }

    public void setTeam_total_wickets(String team_total_wickets) {
        this.team_total_wickets = team_total_wickets;
    }
}