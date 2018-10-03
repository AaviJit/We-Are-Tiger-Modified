package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class CardSimplifiedBackup
{
	
	private Object players;
	
	
	private String team_a;
	
	private String team_b;
	
	private String team_a_url;
	
	private String team_b_url;
	
	
    private String related_name;


    private Msgs msgs;

  

    private Toss toss;

    private String winner_team;

   


    private Innings innings;

//    private String title;

    private boolean dl_applied;

    private Start_date start_date;

    private String status;

    private String man_of_match;

    private String description;

    private String short_name;

    private String format;

   

    private String key;

   

    private String day;

   

    private String name;

    

    private String venue;

   
    public void setRelated_name(String related_name){
        this.related_name = related_name;
    }
    public String getRelated_name(){
        return this.related_name;
    }
    
    public void setMsgs(Msgs msgs){
        this.msgs = msgs;
    }
    public Msgs getMsgs(){
        return this.msgs;
    }
    
    public void setToss(Toss toss){
        this.toss = toss;
    }
    public Toss getToss(){
        return this.toss;
    }
    public void setWinner_team(String winner_team){
        this.winner_team = winner_team;
    }
    public String getWinner_team(){
        return this.winner_team;
    }
    
    public void setInnings(Innings innings){
        this.innings = innings;
    }
    public Innings getInnings(){
        return this.innings;
    }
    
    public void setDl_applied(boolean dl_applied){
        this.dl_applied = dl_applied;
    }
    public boolean getDl_applied(){
        return this.dl_applied;
    }
    public void setStart_date(Start_date start_date){
        this.start_date = start_date;
    }
    public Start_date getStart_date(){
        return this.start_date;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setMan_of_match(String man_of_match){
        this.man_of_match = man_of_match;
    }
    public String getMan_of_match(){
        return this.man_of_match;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setShort_name(String short_name){
        this.short_name = short_name;
    }
    public String getShort_name(){
        return this.short_name;
    }
    public void setFormat(String format){
        this.format = format;
    }
    public String getFormat(){
        return this.format;
    }
   
 
    public void setKey(String key){
        this.key = key;
    }
    public String getKey(){
        return this.key;
    }
 
    public void setDay(String day){
        this.day = day;
    }
    public String getDay(){
        return this.day;
    }
   
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
  
    public void setVenue(String venue){
        this.venue = venue;
    }
    public String getVenue(){
        return this.venue;
    }
   
    

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
	public Object getPlayers() {
		return players;
	}
	public void setPlayers(Object players) {
		this.players = players;
	}
    
    
}
