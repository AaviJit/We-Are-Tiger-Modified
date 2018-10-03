package com.sweetitech.tiger.model.cricketapi;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@JsonIgnoreProperties(ignoreUnknown = true)
public class CardCustomForOniHome
{
	private String team_a;
	
	private String team_b;
	
	private String team_a_url;
	
	private String team_b_url;
	
	
    private String related_name;


    private String msgs_result;

    private List<String> msgs_others;

    private String toss_decision;

    private String toss_won;

    private String toss_str;

    

    private String winner_team;


   
    
    //innings -> A_1
    

    private int innings_A_1_runs;

    private int innings_A_1_balls;

    private int innings_A_1_wickets;

    private String innings_A_1_overs;


    private String teamAScore;

    
  //////////////////////////////////
    /////B_!
    

    private int innings_B_1_runs;

    private int innings_B_1_balls;


    private int innings_B_1_wickets;
    
    private String innings_B_1_overs;


	private String teamBScore;



    
    
    ///////////////////////////

//    private String title;

    private boolean dl_applied;

   

    private String status;

    //didn't map
    private String man_of_match;

    private String description;

    private String short_name;

    private String format;

    private String key;


	//didn't map
    private String day;

    private String name;

    private String venue;

    private int start_date_timestamp;

    private String start_date_iso;

    private String start_date_str;



    private String date;

    private String time;



	public String getTeam_a() {
		return team_a;
	}

	public void setTeam_a(String team_a) {
		this.team_a = team_a;
	}

	public String getTeam_b() {
		return team_b;
	}

	public void setTeam_b(String team_b) {
		this.team_b = team_b;
	}

	public String getTeam_a_url() {
		return team_a_url;
	}

	public void setTeam_a_url(String team_a_url) {
		this.team_a_url = team_a_url;
	}

	public String getTeam_b_url() {
		return team_b_url;
	}

	public void setTeam_b_url(String team_b_url) {
		this.team_b_url = team_b_url;
	}

	public String getRelated_name() {
		return related_name;
	}

	public void setRelated_name(String related_name) {
		this.related_name = related_name;
	}

	public String getMsgs_result() {
		return msgs_result;
	}

	public void setMsgs_result(String msgs_result) {
		this.msgs_result = msgs_result;
	}

	public List<String> getMsgs_others() {
		return msgs_others;
	}

	public void setMsgs_others(List<String> msgs_others) {
		this.msgs_others = msgs_others;
	}

	public String getToss_decision() {
		return toss_decision;
	}

	public void setToss_decision(String toss_decision) {
		this.toss_decision = toss_decision;
	}

	public String getToss_won() {
		return toss_won;
	}

	public void setToss_won(String toss_won) {
		this.toss_won = toss_won;
	}

	public String getToss_str() {
		return toss_str;
	}

	public void setToss_str(String toss_str) {
		this.toss_str = toss_str;
	}

	public String getWinner_team() {
		return winner_team;
	}

	public void setWinner_team(String winner_team) {
		this.winner_team = winner_team;
	}

	public int getInnings_A_1_runs() {
		return innings_A_1_runs;
	}

	public void setInnings_A_1_runs(int innings_A_1_runs) {
		this.innings_A_1_runs = innings_A_1_runs;
	}

	public int getInnings_A_1_balls() {
		return innings_A_1_balls;
	}

	public void setInnings_A_1_balls(int innings_A_1_balls) {
		this.innings_A_1_balls = innings_A_1_balls;
	}

	public int getInnings_A_1_wickets() {
		return innings_A_1_wickets;
	}

	public void setInnings_A_1_wickets(int innings_A_1_wickets) {
		this.innings_A_1_wickets = innings_A_1_wickets;
	}

	public String getInnings_A_1_overs() {
		return innings_A_1_overs;
	}

	public void setInnings_A_1_overs(String innings_A_1_overs) {
		this.innings_A_1_overs = innings_A_1_overs;
	}

	public int getInnings_B_1_runs() {
		return innings_B_1_runs;
	}

	public void setInnings_B_1_runs(int innings_B_1_runs) {
		this.innings_B_1_runs = innings_B_1_runs;
	}

	public int getInnings_B_1_balls() {
		return innings_B_1_balls;
	}

	public void setInnings_B_1_balls(int innings_B_1_balls) {
		this.innings_B_1_balls = innings_B_1_balls;
	}

	public int getInnings_B_1_wickets() {
		return innings_B_1_wickets;
	}

	public void setInnings_B_1_wickets(int innings_B_1_wickets) {
		this.innings_B_1_wickets = innings_B_1_wickets;
	}

	public String getInnings_B_1_overs() {
		return innings_B_1_overs;
	}

	public void setInnings_B_1_overs(String innings_B_1_overs) {
		this.innings_B_1_overs = innings_B_1_overs;
	}

	public boolean isDl_applied() {
		return dl_applied;
	}

	public void setDl_applied(boolean dl_applied) {
		this.dl_applied = dl_applied;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMan_of_match() {
		return man_of_match;
	}

	public void setMan_of_match(String man_of_match) {
		this.man_of_match = man_of_match;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getStart_date_timestamp() {
		return start_date_timestamp;
	}

	public void setStart_date_timestamp(int start_date_timestamp) {
		this.start_date_timestamp = start_date_timestamp;
	}

	public String getStart_date_iso() {
		return start_date_iso;
	}

	public void setStart_date_iso(String start_date_iso) {
		this.start_date_iso = start_date_iso;
	}

	public String getStart_date_str() {
		return start_date_str;
	}

	public void setStart_date_str(String start_date_str) {
		this.start_date_str = start_date_str;
	}

	public String getTeamAScore() {
		return teamAScore;
	}

	public void setTeamAScore(String teamAScore) {
		this.teamAScore = teamAScore;
	}

	public String getTeamBScore() {
		return teamBScore;
	}

	public void setTeamBScore(String teamBScore) {
		this.teamBScore = teamBScore;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
