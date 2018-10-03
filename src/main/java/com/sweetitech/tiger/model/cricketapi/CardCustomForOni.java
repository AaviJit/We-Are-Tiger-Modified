package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;




@JsonIgnoreProperties(ignoreUnknown = true)
public class CardCustomForOni
{
   //Recent batsman on pitch
    private String latest_batsman_1_name;
    private String latest_batsman_1_strike_rate;
    private String latest_batsman_1_runs;
    private String latest_batsman_1_balls;
    //didn't map
    private String latest_batsman_1_overs;
    private String latest_batsman_1_sixes;
    private String latest_batsman_1_fours;
    //didn't map
    private String latest_batsman_1_dots;

    private String latest_batsman_2_name;
    private String latest_batsman_2_strike_rate;
    private String latest_batsman_2_runs;
    private String latest_batsman_2_balls;
    private String latest_batsman_2_overs;
    private String latest_batsman_2_sixes;
    private String latest_batsman_2_fours;
    private String latest_batsman_2_dots;

    private String latest_bowler_comment;

    //Recent Bowler bowling
    private String latest_bowler_1_name;
    private String latest_bowler_1_over;
    private String latest_bowler_1_maiden;
    private String latest_bowler_1_run;
    private String latest_bowler_1_wicket;
    private String latest_bowler_1_eco;

    private String latest_bowler_2_name;
    private String latest_bowler_2_over;
    private String latest_bowler_2_maiden;
    private String latest_bowler_2_run;
    private String latest_bowler_2_wicket;
    private String latest_bowler_2_eco;

    private String current_batting_team;
    private String current_runrate;







    //player 1
    private String bowling_a_1_player_1_name;
    private String bowling_a_1_player_1_economy;
    private String bowling_a_1_player_1_runs;
    //didn't map
    private String bowling_a_1_player_1_dots;
    //didn't map
    private String bowling_a_1_player_1_balls;
    private String bowling_a_1_player_1_wickets;
    private String bowling_a_1_player_1_extras;
    private String bowling_a_1_player_1_maiden_overs;
    private String bowling_a_1_player_1_overs;

    private String bowling_a_2_player_1_name;
    private String bowling_a_2_player_1_economy;
    private String bowling_a_2_player_1_runs;
    private String bowling_a_2_player_1_dots;
    private String bowling_a_2_player_1_balls;
    private String bowling_a_2_player_1_wickets;
    private String bowling_a_2_player_1_extras;
    private String bowling_a_2_player_1_maiden_overs;
    private String bowling_a_2_player_1_overs;

    private String bowling_b_1_player_1_name;
    private String bowling_b_1_player_1_economy;
    private String bowling_b_1_player_1_runs;
    private String bowling_b_1_player_1_dots;
    private String bowling_b_1_player_1_balls;
    private String bowling_b_1_player_1_wickets;
    private String bowling_b_1_player_1_extras;
    private String bowling_b_1_player_1_maiden_overs;
    private String bowling_b_1_player_1_overs;

    private String bowling_b_2_player_1_name;
    private String bowling_b_2_player_1_economy;
    private String bowling_b_2_player_1_runs;
    private String bowling_b_2_player_1_dots;
    private String bowling_b_2_player_1_balls;
    private String bowling_b_2_player_1_wickets;
    private String bowling_b_2_player_1_extras;
    private String bowling_b_2_player_1_maiden_overs;
    private String bowling_b_2_player_1_overs;


    //player 2
    private String bowling_a_1_player_2_name;
    private String bowling_a_1_player_2_economy;
    private String bowling_a_1_player_2_runs;
    private String bowling_a_1_player_2_dots;
    private String bowling_a_1_player_2_balls;
    private String bowling_a_1_player_2_wickets;
    private String bowling_a_1_player_2_extras;
    private String bowling_a_1_player_2_maiden_overs;
    private String bowling_a_1_player_2_overs;

    private String bowling_a_2_player_2_name;
    private String bowling_a_2_player_2_economy;
    private String bowling_a_2_player_2_runs;
    private String bowling_a_2_player_2_dots;
    private String bowling_a_2_player_2_balls;
    private String bowling_a_2_player_2_wickets;
    private String bowling_a_2_player_2_extras;
    private String bowling_a_2_player_2_maiden_overs;
    private String bowling_a_2_player_2_overs;

    private String bowling_b_1_player_2_name;
    private String bowling_b_1_player_2_economy;
    private String bowling_b_1_player_2_runs;
    private String bowling_b_1_player_2_dots;
    private String bowling_b_1_player_2_balls;
    private String bowling_b_1_player_2_wickets;
    private String bowling_b_1_player_2_extras;
    private String bowling_b_1_player_2_maiden_overs;
    private String bowling_b_1_player_2_overs;

    private String bowling_b_2_player_2_name;
    private String bowling_b_2_player_2_economy;
    private String bowling_b_2_player_2_runs;
    private String bowling_b_2_player_2_dots;
    private String bowling_b_2_player_2_balls;
    private String bowling_b_2_player_2_wickets;
    private String bowling_b_2_player_2_extras;
    private String bowling_b_2_player_2_maiden_overs;
    private String bowling_b_2_player_2_overs;

    //player 3
    private String bowling_a_1_player_3_name;
    private String bowling_a_1_player_3_economy;
    private String bowling_a_1_player_3_runs;
    private String bowling_a_1_player_3_dots;
    private String bowling_a_1_player_3_balls;
    private String bowling_a_1_player_3_wickets;
    private String bowling_a_1_player_3_extras;
    private String bowling_a_1_player_3_maiden_overs;
    private String bowling_a_1_player_3_overs;

    private String bowling_a_2_player_3_name;
    private String bowling_a_2_player_3_economy;
    private String bowling_a_2_player_3_runs;
    private String bowling_a_2_player_3_dots;
    private String bowling_a_2_player_3_balls;
    private String bowling_a_2_player_3_wickets;
    private String bowling_a_2_player_3_extras;
    private String bowling_a_2_player_3_maiden_overs;
    private String bowling_a_2_player_3_overs;

    private String bowling_b_1_player_3_name;
    private String bowling_b_1_player_3_economy;
    private String bowling_b_1_player_3_runs;
    private String bowling_b_1_player_3_dots;
    private String bowling_b_1_player_3_balls;
    private String bowling_b_1_player_3_wickets;
    private String bowling_b_1_player_3_extras;
    private String bowling_b_1_player_3_maiden_overs;
    private String bowling_b_1_player_3_overs;

    private String bowling_b_2_player_3_name;
    private String bowling_b_2_player_3_economy;
    private String bowling_b_2_player_3_runs;
    private String bowling_b_2_player_3_dots;
    private String bowling_b_2_player_3_balls;
    private String bowling_b_2_player_3_wickets;
    private String bowling_b_2_player_3_extras;
    private String bowling_b_2_player_3_maiden_overs;
    private String bowling_b_2_player_3_overs;

    //player 4
    private String bowling_a_1_player_4_name;
    private String bowling_a_1_player_4_economy;
    private String bowling_a_1_player_4_runs;
    private String bowling_a_1_player_4_dots;
    private String bowling_a_1_player_4_balls;
    private String bowling_a_1_player_4_wickets;
    private String bowling_a_1_player_4_extras;
    private String bowling_a_1_player_4_maiden_overs;
    private String bowling_a_1_player_4_overs;

    private String bowling_a_2_player_4_name;
    private String bowling_a_2_player_4_economy;
    private String bowling_a_2_player_4_runs;
    private String bowling_a_2_player_4_dots;
    private String bowling_a_2_player_4_balls;
    private String bowling_a_2_player_4_wickets;
    private String bowling_a_2_player_4_extras;
    private String bowling_a_2_player_4_maiden_overs;
    private String bowling_a_2_player_4_overs;

    private String bowling_b_1_player_4_name;
    private String bowling_b_1_player_4_economy;
    private String bowling_b_1_player_4_runs;
    private String bowling_b_1_player_4_dots;
    private String bowling_b_1_player_4_balls;
    private String bowling_b_1_player_4_wickets;
    private String bowling_b_1_player_4_extras;
    private String bowling_b_1_player_4_maiden_overs;
    private String bowling_b_1_player_4_overs;

    private String bowling_b_2_player_4_name;
    private String bowling_b_2_player_4_economy;
    private String bowling_b_2_player_4_runs;
    private String bowling_b_2_player_4_dots;
    private String bowling_b_2_player_4_balls;
    private String bowling_b_2_player_4_wickets;
    private String bowling_b_2_player_4_extras;
    private String bowling_b_2_player_4_maiden_overs;
    private String bowling_b_2_player_4_overs;

    //player 5
    private String bowling_a_1_player_5_name;
    private String bowling_a_1_player_5_economy;
    private String bowling_a_1_player_5_runs;
    private String bowling_a_1_player_5_dots;
    private String bowling_a_1_player_5_balls;
    private String bowling_a_1_player_5_wickets;
    private String bowling_a_1_player_5_extras;
    private String bowling_a_1_player_5_maiden_overs;
    private String bowling_a_1_player_5_overs;

    private String bowling_a_2_player_5_name;
    private String bowling_a_2_player_5_economy;
    private String bowling_a_2_player_5_runs;
    private String bowling_a_2_player_5_dots;
    private String bowling_a_2_player_5_balls;
    private String bowling_a_2_player_5_wickets;
    private String bowling_a_2_player_5_extras;
    private String bowling_a_2_player_5_maiden_overs;
    private String bowling_a_2_player_5_overs;

    private String bowling_b_1_player_5_name;
    private String bowling_b_1_player_5_economy;
    private String bowling_b_1_player_5_runs;
    private String bowling_b_1_player_5_dots;
    private String bowling_b_1_player_5_balls;
    private String bowling_b_1_player_5_wickets;
    private String bowling_b_1_player_5_extras;
    private String bowling_b_1_player_5_maiden_overs;
    private String bowling_b_1_player_5_overs;

    private String bowling_b_2_player_5_name;
    private String bowling_b_2_player_5_economy;
    private String bowling_b_2_player_5_runs;
    private String bowling_b_2_player_5_dots;
    private String bowling_b_2_player_5_balls;
    private String bowling_b_2_player_5_wickets;
    private String bowling_b_2_player_5_extras;
    private String bowling_b_2_player_5_maiden_overs;
    private String bowling_b_2_player_5_overs;

    //player 6
    private String bowling_a_1_player_6_name;
    private String bowling_a_1_player_6_economy;
    private String bowling_a_1_player_6_runs;
    private String bowling_a_1_player_6_dots;
    private String bowling_a_1_player_6_balls;
    private String bowling_a_1_player_6_wickets;
    private String bowling_a_1_player_6_extras;
    private String bowling_a_1_player_6_maiden_overs;
    private String bowling_a_1_player_6_overs;

    private String bowling_a_2_player_6_name;
    private String bowling_a_2_player_6_economy;
    private String bowling_a_2_player_6_runs;
    private String bowling_a_2_player_6_dots;
    private String bowling_a_2_player_6_balls;
    private String bowling_a_2_player_6_wickets;
    private String bowling_a_2_player_6_extras;
    private String bowling_a_2_player_6_maiden_overs;
    private String bowling_a_2_player_6_overs;

    private String bowling_b_1_player_6_name;
    private String bowling_b_1_player_6_economy;
    private String bowling_b_1_player_6_runs;
    private String bowling_b_1_player_6_dots;
    private String bowling_b_1_player_6_balls;
    private String bowling_b_1_player_6_wickets;
    private String bowling_b_1_player_6_extras;
    private String bowling_b_1_player_6_maiden_overs;
    private String bowling_b_1_player_6_overs;

    private String bowling_b_2_player_6_name;
    private String bowling_b_2_player_6_economy;
    private String bowling_b_2_player_6_runs;
    private String bowling_b_2_player_6_dots;
    private String bowling_b_2_player_6_balls;
    private String bowling_b_2_player_6_wickets;
    private String bowling_b_2_player_6_extras;
    private String bowling_b_2_player_6_maiden_overs;
    private String bowling_b_2_player_6_overs;

    //player 7
    private String bowling_a_1_player_7_name;
    private String bowling_a_1_player_7_economy;
    private String bowling_a_1_player_7_runs;
    private String bowling_a_1_player_7_dots;
    private String bowling_a_1_player_7_balls;
    private String bowling_a_1_player_7_wickets;
    private String bowling_a_1_player_7_extras;
    private String bowling_a_1_player_7_maiden_overs;
    private String bowling_a_1_player_7_overs;

    private String bowling_a_2_player_7_name;
    private String bowling_a_2_player_7_economy;
    private String bowling_a_2_player_7_runs;
    private String bowling_a_2_player_7_dots;
    private String bowling_a_2_player_7_balls;
    private String bowling_a_2_player_7_wickets;
    private String bowling_a_2_player_7_extras;
    private String bowling_a_2_player_7_maiden_overs;
    private String bowling_a_2_player_7_overs;

    private String bowling_b_1_player_7_name;
    private String bowling_b_1_player_7_economy;
    private String bowling_b_1_player_7_runs;
    private String bowling_b_1_player_7_dots;
    private String bowling_b_1_player_7_balls;
    private String bowling_b_1_player_7_wickets;
    private String bowling_b_1_player_7_extras;
    private String bowling_b_1_player_7_maiden_overs;
    private String bowling_b_1_player_7_overs;

    private String bowling_b_2_player_7_name;
    private String bowling_b_2_player_7_economy;
    private String bowling_b_2_player_7_runs;
    private String bowling_b_2_player_7_dots;
    private String bowling_b_2_player_7_balls;
    private String bowling_b_2_player_7_wickets;
    private String bowling_b_2_player_7_extras;
    private String bowling_b_2_player_7_maiden_overs;
    private String bowling_b_2_player_7_overs;

    //player 8
    private String bowling_a_1_player_8_name;
    private String bowling_a_1_player_8_economy;
    private String bowling_a_1_player_8_runs;
    private String bowling_a_1_player_8_dots;
    private String bowling_a_1_player_8_balls;
    private String bowling_a_1_player_8_wickets;
    private String bowling_a_1_player_8_extras;
    private String bowling_a_1_player_8_maiden_overs;
    private String bowling_a_1_player_8_overs;

    private String bowling_a_2_player_8_name;
    private String bowling_a_2_player_8_economy;
    private String bowling_a_2_player_8_runs;
    private String bowling_a_2_player_8_dots;
    private String bowling_a_2_player_8_balls;
    private String bowling_a_2_player_8_wickets;
    private String bowling_a_2_player_8_extras;
    private String bowling_a_2_player_8_maiden_overs;
    private String bowling_a_2_player_8_overs;

    private String bowling_b_1_player_8_name;
    private String bowling_b_1_player_8_economy;
    private String bowling_b_1_player_8_runs;
    private String bowling_b_1_player_8_dots;
    private String bowling_b_1_player_8_balls;
    private String bowling_b_1_player_8_wickets;
    private String bowling_b_1_player_8_extras;
    private String bowling_b_1_player_8_maiden_overs;
    private String bowling_b_1_player_8_overs;

    private String bowling_b_2_player_8_name;
    private String bowling_b_2_player_8_economy;
    private String bowling_b_2_player_8_runs;
    private String bowling_b_2_player_8_dots;
    private String bowling_b_2_player_8_balls;
    private String bowling_b_2_player_8_wickets;
    private String bowling_b_2_player_8_extras;
    private String bowling_b_2_player_8_maiden_overs;
    private String bowling_b_2_player_8_overs;

    //player 9
    private String bowling_a_1_player_9_name;
    private String bowling_a_1_player_9_economy;
    private String bowling_a_1_player_9_runs;
    private String bowling_a_1_player_9_dots;
    private String bowling_a_1_player_9_balls;
    private String bowling_a_1_player_9_wickets;
    private String bowling_a_1_player_9_extras;
    private String bowling_a_1_player_9_maiden_overs;
    private String bowling_a_1_player_9_overs;

    private String bowling_a_2_player_9_name;
    private String bowling_a_2_player_9_economy;
    private String bowling_a_2_player_9_runs;
    private String bowling_a_2_player_9_dots;
    private String bowling_a_2_player_9_balls;
    private String bowling_a_2_player_9_wickets;
    private String bowling_a_2_player_9_extras;
    private String bowling_a_2_player_9_maiden_overs;
    private String bowling_a_2_player_9_overs;

    private String bowling_b_1_player_9_name;
    private String bowling_b_1_player_9_economy;
    private String bowling_b_1_player_9_runs;
    private String bowling_b_1_player_9_dots;
    private String bowling_b_1_player_9_balls;
    private String bowling_b_1_player_9_wickets;
    private String bowling_b_1_player_9_extras;
    private String bowling_b_1_player_9_maiden_overs;
    private String bowling_b_1_player_9_overs;

    private String bowling_b_2_player_9_name;
    private String bowling_b_2_player_9_economy;
    private String bowling_b_2_player_9_runs;
    private String bowling_b_2_player_9_dots;
    private String bowling_b_2_player_9_balls;
    private String bowling_b_2_player_9_wickets;
    private String bowling_b_2_player_9_extras;
    private String bowling_b_2_player_9_maiden_overs;
    private String bowling_b_2_player_9_overs;

    //player 10

    private String bowling_a_1_player_10_name;
    private String bowling_a_1_player_10_economy;
    private String bowling_a_1_player_10_runs;
    private String bowling_a_1_player_10_dots;
    private String bowling_a_1_player_10_balls;
    private String bowling_a_1_player_10_wickets;
    private String bowling_a_1_player_10_extras;
    private String bowling_a_1_player_10_maiden_overs;
    private String bowling_a_1_player_10_overs;

    private String bowling_a_2_player_10_name;
    private String bowling_a_2_player_10_economy;
    private String bowling_a_2_player_10_runs;
    private String bowling_a_2_player_10_dots;
    private String bowling_a_2_player_10_balls;
    private String bowling_a_2_player_10_wickets;
    private String bowling_a_2_player_10_extras;
    private String bowling_a_2_player_10_maiden_overs;
    private String bowling_a_2_player_10_overs;

    private String bowling_b_1_player_10_name;
    private String bowling_b_1_player_10_economy;
    private String bowling_b_1_player_10_runs;
    private String bowling_b_1_player_10_dots;
    private String bowling_b_1_player_10_balls;
    private String bowling_b_1_player_10_wickets;
    private String bowling_b_1_player_10_extras;
    private String bowling_b_1_player_10_maiden_overs;
    private String bowling_b_1_player_10_overs;

    private String bowling_b_2_player_10_name;
    private String bowling_b_2_player_10_economy;
    private String bowling_b_2_player_10_runs;
    private String bowling_b_2_player_10_dots;
    private String bowling_b_2_player_10_balls;
    private String bowling_b_2_player_10_wickets;
    private String bowling_b_2_player_10_extras;
    private String bowling_b_2_player_10_maiden_overs;
    private String bowling_b_2_player_10_overs;

    //player 11
    private String bowling_a_1_player_11_name;
    private String bowling_a_1_player_11_economy;
    private String bowling_a_1_player_11_runs;
    private String bowling_a_1_player_11_dots;
    private String bowling_a_1_player_11_balls;
    private String bowling_a_1_player_11_wickets;
    private String bowling_a_1_player_11_extras;
    private String bowling_a_1_player_11_maiden_overs;
    private String bowling_a_1_player_11_overs;

    private String bowling_a_2_player_11_name;
    private String bowling_a_2_player_11_economy;
    private String bowling_a_2_player_11_runs;
    private String bowling_a_2_player_11_dots;
    private String bowling_a_2_player_11_balls;
    private String bowling_a_2_player_11_wickets;
    private String bowling_a_2_player_11_extras;
    private String bowling_a_2_player_11_maiden_overs;
    private String bowling_a_2_player_11_overs;

    private String bowling_b_1_player_11_name;
    private String bowling_b_1_player_11_economy;
    private String bowling_b_1_player_11_runs;
    private String bowling_b_1_player_11_dots;
    private String bowling_b_1_player_11_balls;
    private String bowling_b_1_player_11_wickets;
    private String bowling_b_1_player_11_extras;
    private String bowling_b_1_player_11_maiden_overs;
    private String bowling_b_1_player_11_overs;

    private String bowling_b_2_player_11_name;
    private String bowling_b_2_player_11_economy;
    private String bowling_b_2_player_11_runs;
    private String bowling_b_2_player_11_dots;
    private String bowling_b_2_player_11_balls;
    private String bowling_b_2_player_11_wickets;
    private String bowling_b_2_player_11_extras;
    private String bowling_b_2_player_11_maiden_overs;
    private String bowling_b_2_player_11_overs;

	//private Object players;

//    private List<Bowling> bowling_a_1;
//    private List<Bowling> bowling_b_1;
//    private List<Bowling> bowling_a_2;
//    private List<Bowling> bowling_b_2;


    private String team_a;
    private String team_a_full_name;
    private String team_a_full_score;
	private String team_b;
	private String team_b_full_name;
	private String team_b_full_score;
	private String team_a_url;
	private String team_b_url;


	//didn't map these 3
    private String related_name;
    private String msgs_result;
    private List<String> msgs_others;



    private String toss_decision;
    private String toss_won;
    private String toss_str;
    //didn't map
    private String winner_team;




    //innings -> A_1
    private String inning_1_batting_team;

    private List<String> innings_A_1_batting_order;
    private int innings_A_1_runs;
    private int innings_A_1_wickets;

    //didn't map
    private int innings_A_1_balls;
    private List<String> innings_A_1_fall_of_wickets;
    private int innings_A_1_wide;
    private String innings_A_1_run_rate;
    //didn't map
    private int innings_A_1_fours;

    private String innings_A_1_run_str;

    //didn't map
    private List<String> innings_A_1_wicket_order;
    private int innings_A_1_extras;
    private List<String> innings_A_1_bowling_order;

    //didn't map
    private String innings_A_1_key;

    private int innings_A_1_noball;
    //didn't map
    private int innings_A_1_sixes;

    private int innings_A_1_legbye;
    private int innings_A_1_bye;
    private String innings_A_1_overs;

    //didn't map
    private int innings_A_1_dotballs;

  //////////////////////////////////
    /////B_1
  private String inning_2_batting_team;

    private List<String> innings_B_1_batting_order;

    private int innings_B_1_runs;

    private int innings_B_1_wickets;

    private int innings_B_1_balls;

    private List<String> innings_B_1_fall_of_wickets;

    private int innings_B_1_wide;

    private String innings_B_1_run_rate;

    private int innings_B_1_fours;

    private String innings_B_1_run_str;



    private List<String> innings_B_1_wicket_order;

    private int innings_B_1_extras;

    private List<String> innings_B_1_bowling_order;

    private String innings_B_1_key;

    private int innings_B_1_noball;

    private int innings_B_1_sixes;

    private int innings_B_1_legbye;

    private int innings_B_1_bye;

    private String innings_B_1_overs;

    private int innings_B_1_dotballs;


    ///////////////////////////

//A_2
   private String inning_3_batting_team;

    private List<String> innings_A_2_batting_order;

    private int innings_A_2_runs;

    private int innings_A_2_balls;

    private List<String> innings_A_2_fall_of_wickets;

    private int innings_A_2_wide;

    private String innings_A_2_run_rate;

    private int innings_A_2_fours;

    private String innings_A_2_run_str;

    private int innings_A_2_wickets;

    private List<String> innings_A_2_wicket_order;

    private int innings_A_2_extras;

    private List<String> innings_A_2_bowling_order;

    private String innings_A_2_key;

    private int innings_A_2_noball;

    private int innings_A_2_sixes;

    private int innings_A_2_legbye;

    private int innings_A_2_bye;

    private String innings_A_2_overs;

    private int innings_A_2_dotballs;

    //////////////////////////////////
    /////B_2

  private String inning_4_batting_team;

    private List<String> innings_B_2_batting_order;

    private int innings_B_2_runs;

    private int innings_B_2_balls;

    private List<String> innings_B_2_fall_of_wickets;

    private int innings_B_2_wide;

    private String innings_B_2_run_rate;

    private int innings_B_2_fours;

    private String innings_B_2_run_str;

    private int innings_B_2_wickets;

    private List<String> innings_B_2_wicket_order;

    private int innings_B_2_extras;

    private List<String> innings_B_2_bowling_order;

    private String innings_B_2_key;

    private int innings_B_2_noball;

    private int innings_B_2_sixes;

    private int innings_B_2_legbye;

    private int innings_B_2_bye;

    private String innings_B_2_overs;

    private int innings_B_2_dotballs;





    //a_1

    //player_1
    private String innings_A_1_batting_player_1_full_name;
    //innings 1
    private String innings_A_1_batting_player_1_innings_1_sixes;
    private String innings_A_1_batting_player_1_innings_1_fours;
    private String innings_A_1_batting_player_1_innings_1_balls;
    private String innings_A_1_batting_player_1_innings_1_runs;
    private String innings_A_1_batting_player_1_innings_1_out_comment;
    private String innings_A_1_batting_player_1_innings_1_strike_rate;
    //didn't map
    private String innings_A_1_bowling_player_1_innings_1_maiden_overs;

    //innings 2
    private String innings_A_1_batting_player_1_innings_2_full_name;

    private String innings_A_1_batting_player_1_innings_2_sixes;
    private String innings_A_1_batting_player_1_innings_2_fours;
    private String innings_A_1_batting_player_1_innings_2_balls;
    private String innings_A_1_batting_player_1_innings_2_runs;
    private String innings_A_1_batting_player_1_innings_2_out_comment;
    private String innings_A_1_batting_player_1_innings_2_strike_rate;

    private String innings_A_1_bowling_player_1_innings_2_maiden_overs;




  //player_2
    private String innings_A_1_batting_player_2_full_name;
    //innings 1
    private String innings_A_1_batting_player_2_innings_1_sixes;
    private String innings_A_1_batting_player_2_innings_1_fours;
    private String innings_A_1_batting_player_2_innings_1_balls;
    private String innings_A_1_batting_player_2_innings_1_runs;
    private String innings_A_1_batting_player_2_innings_1_out_comment;
    private String innings_A_1_bowling_player_2_innings_1_maiden_overs;
    private String innings_A_1_batting_player_2_innings_1_strike_rate;
    //innings 2
    private String innings_A_1_batting_player_2_innings_2_full_name;
    private String innings_A_1_batting_player_2_innings_2_sixes;
    private String innings_A_1_batting_player_2_innings_2_fours;
    private String innings_A_1_batting_player_2_innings_2_balls;
    private String innings_A_1_batting_player_2_innings_2_runs;
    private String innings_A_1_batting_player_2_innings_2_out_comment;
    private String innings_A_1_batting_player_2_innings_2_strike_rate;
    private String innings_A_1_bowling_player_2_innings_2_maiden_overs;



  //player_3
    private String innings_A_1_batting_player_3_full_name;
    //innings 1
    private String innings_A_1_batting_player_3_innings_1_sixes;
    private String innings_A_1_batting_player_3_innings_1_fours;
    private String innings_A_1_batting_player_3_innings_1_balls;
    private String innings_A_1_batting_player_3_innings_1_runs;
    private String innings_A_1_batting_player_3_innings_1_out_comment;
    private String innings_A_1_batting_player_3_innings_1_strike_rate;
    private String innings_A_1_bowling_player_3_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_3_innings_2_full_name;
    private String innings_A_1_batting_player_3_innings_2_sixes;
    private String innings_A_1_batting_player_3_innings_2_fours;
    private String innings_A_1_batting_player_3_innings_2_balls;
    private String innings_A_1_batting_player_3_innings_2_runs;
    private String innings_A_1_batting_player_3_innings_2_out_comment;
    private String innings_A_1_batting_player_3_innings_2_strike_rate;
    private String innings_A_1_bowling_player_3_innings_2_maiden_overs;



  //player_4
    private String innings_A_1_batting_player_4_full_name;
    //innings 1
    private String innings_A_1_batting_player_4_innings_1_sixes;
    private String innings_A_1_batting_player_4_innings_1_fours;
    private String innings_A_1_batting_player_4_innings_1_balls;
    private String innings_A_1_batting_player_4_innings_1_runs;
    private String innings_A_1_batting_player_4_innings_1_out_comment;
    private String innings_A_1_batting_player_4_innings_1_strike_rate;
    private String innings_A_1_bowling_player_4_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_4_innings_2_full_name;
    private String innings_A_1_batting_player_4_innings_2_sixes;
    private String innings_A_1_batting_player_4_innings_2_fours;
    private String innings_A_1_batting_player_4_innings_2_balls;
    private String innings_A_1_batting_player_4_innings_2_runs;
    private String innings_A_1_batting_player_4_innings_2_out_comment;
    private String innings_A_1_batting_player_4_innings_2_strike_rate;

    private String innings_A_1_bowling_player_4_innings_2_maiden_overs;


  //player_5
    private String innings_A_1_batting_player_5_full_name;
    //innings 1
    private String innings_A_1_batting_player_5_innings_1_sixes;
    private String innings_A_1_batting_player_5_innings_1_fours;
    private String innings_A_1_batting_player_5_innings_1_balls;
    private String innings_A_1_batting_player_5_innings_1_runs;
    private String innings_A_1_batting_player_5_innings_1_out_comment;
    private String innings_A_1_batting_player_5_innings_1_strike_rate;
    private String innings_A_1_bowling_player_5_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_5_innings_2_full_name;
    private String innings_A_1_batting_player_5_innings_2_sixes;
    private String innings_A_1_batting_player_5_innings_2_fours;
    private String innings_A_1_batting_player_5_innings_2_balls;
    private String innings_A_1_batting_player_5_innings_2_runs;
    private String innings_A_1_batting_player_5_innings_2_out_comment;
    private String innings_A_1_batting_player_5_innings_2_strike_rate;

    private String innings_A_1_bowling_player_5_innings_2_maiden_overs;


  //player_6
    private String innings_A_1_batting_player_6_full_name;
    //innings 1
    private String innings_A_1_batting_player_6_innings_1_sixes;
    private String innings_A_1_batting_player_6_innings_1_fours;
    private String innings_A_1_batting_player_6_innings_1_balls;
    private String innings_A_1_batting_player_6_innings_1_runs;
    private String innings_A_1_batting_player_6_innings_1_out_comment;
    private String innings_A_1_batting_player_6_innings_1_strike_rate;
    private String innings_A_1_bowling_player_6_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_6_innings_2_full_name;
    private String innings_A_1_batting_player_6_innings_2_sixes;
    private String innings_A_1_batting_player_6_innings_2_fours;
    private String innings_A_1_batting_player_6_innings_2_balls;
    private String innings_A_1_batting_player_6_innings_2_runs;
    private String innings_A_1_batting_player_6_innings_2_out_comment;
    private String innings_A_1_batting_player_6_innings_2_strike_rate;

    private String innings_A_1_bowling_player_6_innings_2_maiden_overs;


  //player_7
    private String innings_A_1_batting_player_7_full_name;
    //innings 1
    private String innings_A_1_batting_player_7_innings_1_sixes;
    private String innings_A_1_batting_player_7_innings_1_fours;
    private String innings_A_1_batting_player_7_innings_1_balls;
    private String innings_A_1_batting_player_7_innings_1_runs;
    private String innings_A_1_batting_player_7_innings_1_out_comment;
    private String innings_A_1_batting_player_7_innings_1_strike_rate;
    private String innings_A_1_bowling_player_7_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_7_innings_2_full_name;
    private String innings_A_1_batting_player_7_innings_2_sixes;
    private String innings_A_1_batting_player_7_innings_2_fours;
    private String innings_A_1_batting_player_7_innings_2_balls;
    private String innings_A_1_batting_player_7_innings_2_runs;
    private String innings_A_1_batting_player_7_innings_2_out_comment;
    private String innings_A_1_batting_player_7_innings_2_strike_rate;

    private String innings_A_1_bowling_player_7_innings_2_maiden_overs;


  //player_8
    private String innings_A_1_batting_player_8_full_name;
    //innings 1
    private String innings_A_1_batting_player_8_innings_1_sixes;
    private String innings_A_1_batting_player_8_innings_1_fours;
    private String innings_A_1_batting_player_8_innings_1_balls;
    private String innings_A_1_batting_player_8_innings_1_runs;
    private String innings_A_1_batting_player_8_innings_1_out_comment;
    private String innings_A_1_batting_player_8_innings_1_strike_rate;
    private String innings_A_1_bowling_player_8_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_8_innings_2_full_name;
    private String innings_A_1_batting_player_8_innings_2_sixes;
    private String innings_A_1_batting_player_8_innings_2_fours;
    private String innings_A_1_batting_player_8_innings_2_balls;
    private String innings_A_1_batting_player_8_innings_2_runs;
    private String innings_A_1_batting_player_8_innings_2_out_comment;
    private String innings_A_1_batting_player_8_innings_2_strike_rate;

    private String innings_A_1_bowling_player_8_innings_2_maiden_overs;


  //player_9
    private String innings_A_1_batting_player_9_full_name;
    //innings 1
    private String innings_A_1_batting_player_9_innings_1_sixes;
    private String innings_A_1_batting_player_9_innings_1_fours;
    private String innings_A_1_batting_player_9_innings_1_balls;
    private String innings_A_1_batting_player_9_innings_1_runs;
    private String innings_A_1_batting_player_9_innings_1_out_comment;
    private String innings_A_1_batting_player_9_innings_1_strike_rate;
    private String innings_A_1_bowling_player_9_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_9_innings_2_full_name;
    private String innings_A_1_batting_player_9_innings_2_sixes;
    private String innings_A_1_batting_player_9_innings_2_fours;
    private String innings_A_1_batting_player_9_innings_2_balls;
    private String innings_A_1_batting_player_9_innings_2_runs;
    private String innings_A_1_batting_player_9_innings_2_out_comment;
    private String innings_A_1_batting_player_9_innings_2_strike_rate;

    private String innings_A_1_bowling_player_9_innings_2_maiden_overs;


  //player_10
    private String innings_A_1_batting_player_10_full_name;
    //innings 1
    private String innings_A_1_batting_player_10_innings_1_sixes;
    private String innings_A_1_batting_player_10_innings_1_fours;
    private String innings_A_1_batting_player_10_innings_1_balls;
    private String innings_A_1_batting_player_10_innings_1_runs;
    private String innings_A_1_batting_player_10_innings_1_out_comment;
    private String innings_A_1_batting_player_10_innings_1_strike_rate;
    private String innings_A_1_bowling_player_10_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_10_innings_2_full_name;
    private String innings_A_1_batting_player_10_innings_2_sixes;
    private String innings_A_1_batting_player_10_innings_2_fours;
    private String innings_A_1_batting_player_10_innings_2_balls;
    private String innings_A_1_batting_player_10_innings_2_runs;
    private String innings_A_1_batting_player_10_innings_2_out_comment;
    private String innings_A_1_batting_player_10_innings_2_strike_rate;

    private String innings_A_1_bowling_player_10_innings_2_maiden_overs;



  //player_11
    private String innings_A_1_batting_player_11_full_name;
    //innings 1
    private String innings_A_1_batting_player_11_innings_1_sixes;
    private String innings_A_1_batting_player_11_innings_1_fours;
    private String innings_A_1_batting_player_11_innings_1_balls;
    private String innings_A_1_batting_player_11_innings_1_runs;
    private String innings_A_1_batting_player_11_innings_1_out_comment;
    private String innings_A_1_batting_player_11_innings_1_strike_rate;
    private String innings_A_1_bowling_player_11_innings_1_maiden_overs;
    //innings 2
    private String innings_A_1_batting_player_11_innings_2_full_name;
    private String innings_A_1_batting_player_11_innings_2_sixes;
    private String innings_A_1_batting_player_11_innings_2_fours;
    private String innings_A_1_batting_player_11_innings_2_balls;
    private String innings_A_1_batting_player_11_innings_2_runs;
    private String innings_A_1_batting_player_11_innings_2_out_comment;
    private String innings_A_1_batting_player_11_innings_2_strike_rate;

    private String innings_A_1_bowling_player_11_innings_2_maiden_overs;






    ////////////////////////////////////////////////////////////////////////////

//b_1

    //player_1
    private String innings_B_1_batting_player_1_full_name;
    //innings 1
    private String innings_B_1_batting_player_1_innings_1_sixes;
    private String innings_B_1_batting_player_1_innings_1_fours;
    private String innings_B_1_batting_player_1_innings_1_balls;
    private String innings_B_1_batting_player_1_innings_1_runs;
    private String innings_B_1_batting_player_1_innings_1_out_comment;
    private String innings_B_1_batting_player_1_innings_1_strike_rate;
    private String innings_B_1_bowling_player_1_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_1_innings_2_full_name;
    private String innings_B_1_batting_player_1_innings_2_sixes;
    private String innings_B_1_batting_player_1_innings_2_fours;
    private String innings_B_1_batting_player_1_innings_2_balls;
    private String innings_B_1_batting_player_1_innings_2_runs;
    private String innings_B_1_batting_player_1_innings_2_out_comment;
    private String innings_B_1_batting_player_1_innings_2_strike_rate;

    private String innings_B_1_bowling_player_1_innings_2_maiden_overs;




  //player_2
    private String innings_B_1_batting_player_2_full_name;
    //innings 1
    private String innings_B_1_batting_player_2_innings_1_sixes;
    private String innings_B_1_batting_player_2_innings_1_fours;
    private String innings_B_1_batting_player_2_innings_1_balls;
    private String innings_B_1_batting_player_2_innings_1_runs;
    private String innings_B_1_batting_player_2_innings_1_out_comment;
    private String innings_B_1_batting_player_2_innings_1_strike_rate;
    private String innings_B_1_bowling_player_2_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_2_innings_2_full_name;
    private String innings_B_1_batting_player_2_innings_2_sixes;
    private String innings_B_1_batting_player_2_innings_2_fours;
    private String innings_B_1_batting_player_2_innings_2_balls;
    private String innings_B_1_batting_player_2_innings_2_runs;
    private String innings_B_1_batting_player_2_innings_2_out_comment;
    private String innings_B_1_batting_player_2_innings_2_strike_rate;

    private String innings_B_1_bowling_player_2_innings_2_maiden_overs;



  //player_3
    private String innings_B_1_batting_player_3_full_name;
    //innings 1
    private String innings_B_1_batting_player_3_innings_1_sixes;
    private String innings_B_1_batting_player_3_innings_1_fours;
    private String innings_B_1_batting_player_3_innings_1_balls;
    private String innings_B_1_batting_player_3_innings_1_runs;
    private String innings_B_1_batting_player_3_innings_1_out_comment;
    private String innings_B_1_batting_player_3_innings_1_strike_rate;
    private String innings_B_1_bowling_player_3_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_3_innings_2_full_name;
    private String innings_B_1_batting_player_3_innings_2_sixes;
    private String innings_B_1_batting_player_3_innings_2_fours;
    private String innings_B_1_batting_player_3_innings_2_balls;
    private String innings_B_1_batting_player_3_innings_2_runs;
    private String innings_B_1_batting_player_3_innings_2_out_comment;
    private String innings_B_1_batting_player_3_innings_2_strike_rate;

    private String innings_B_1_bowling_player_3_innings_2_maiden_overs;



  //player_4
    private String innings_B_1_batting_player_4_full_name;
    //innings 1
    private String innings_B_1_batting_player_4_innings_1_sixes;
    private String innings_B_1_batting_player_4_innings_1_fours;
    private String innings_B_1_batting_player_4_innings_1_balls;
    private String innings_B_1_batting_player_4_innings_1_runs;
    private String innings_B_1_batting_player_4_innings_1_out_comment;
    private String innings_B_1_batting_player_4_innings_1_strike_rate;
    private String innings_B_1_bowling_player_4_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_4_innings_2_full_name;
    private String innings_B_1_batting_player_4_innings_2_sixes;
    private String innings_B_1_batting_player_4_innings_2_fours;
    private String innings_B_1_batting_player_4_innings_2_balls;
    private String innings_B_1_batting_player_4_innings_2_runs;
    private String innings_B_1_batting_player_4_innings_2_out_comment;
    private String innings_B_1_batting_player_4_innings_2_strike_rate;

    private String innings_B_1_bowling_player_4_innings_2_maiden_overs;


  //player_5
    private String innings_B_1_batting_player_5_full_name;
    //innings 1
    private String innings_B_1_batting_player_5_innings_1_sixes;
    private String innings_B_1_batting_player_5_innings_1_fours;
    private String innings_B_1_batting_player_5_innings_1_balls;
    private String innings_B_1_batting_player_5_innings_1_runs;
    private String innings_B_1_batting_player_5_innings_1_out_comment;
    private String innings_B_1_batting_player_5_innings_1_strike_rate;
    private String innings_B_1_bowling_player_5_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_5_innings_2_full_name;
    private String innings_B_1_batting_player_5_innings_2_sixes;
    private String innings_B_1_batting_player_5_innings_2_fours;
    private String innings_B_1_batting_player_5_innings_2_balls;
    private String innings_B_1_batting_player_5_innings_2_runs;
    private String innings_B_1_batting_player_5_innings_2_out_comment;
    private String innings_B_1_batting_player_5_innings_2_strike_rate;

    private String innings_B_1_bowling_player_5_innings_2_maiden_overs;


  //player_6
    private String innings_B_1_batting_player_6_full_name;
    //innings 1
    private String innings_B_1_batting_player_6_innings_1_sixes;
    private String innings_B_1_batting_player_6_innings_1_fours;
    private String innings_B_1_batting_player_6_innings_1_balls;
    private String innings_B_1_batting_player_6_innings_1_runs;
    private String innings_B_1_batting_player_6_innings_1_out_comment;
    private String innings_B_1_batting_player_6_innings_1_strike_rate;
    private String innings_B_1_bowling_player_6_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_6_innings_2_full_name;
    private String innings_B_1_batting_player_6_innings_2_sixes;
    private String innings_B_1_batting_player_6_innings_2_fours;
    private String innings_B_1_batting_player_6_innings_2_balls;
    private String innings_B_1_batting_player_6_innings_2_runs;
    private String innings_B_1_batting_player_6_innings_2_out_comment;
    private String innings_B_1_batting_player_6_innings_2_strike_rate;

    private String innings_B_1_bowling_player_6_innings_2_maiden_overs;


  //player_7
    private String innings_B_1_batting_player_7_full_name;
    //innings 1
    private String innings_B_1_batting_player_7_innings_1_sixes;
    private String innings_B_1_batting_player_7_innings_1_fours;
    private String innings_B_1_batting_player_7_innings_1_balls;
    private String innings_B_1_batting_player_7_innings_1_runs;
    private String innings_B_1_batting_player_7_innings_1_out_comment;
    private String innings_B_1_batting_player_7_innings_1_strike_rate;
    private String innings_B_1_bowling_player_7_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_7_innings_2_full_name;
    private String innings_B_1_batting_player_7_innings_2_sixes;
    private String innings_B_1_batting_player_7_innings_2_fours;
    private String innings_B_1_batting_player_7_innings_2_balls;
    private String innings_B_1_batting_player_7_innings_2_runs;
    private String innings_B_1_batting_player_7_innings_2_out_comment;
    private String innings_B_1_batting_player_7_innings_2_strike_rate;

    private String innings_B_1_bowling_player_7_innings_2_maiden_overs;


  //player_8
    private String innings_B_1_batting_player_8_full_name;
    //innings 1
    private String innings_B_1_batting_player_8_innings_1_sixes;
    private String innings_B_1_batting_player_8_innings_1_fours;
    private String innings_B_1_batting_player_8_innings_1_balls;
    private String innings_B_1_batting_player_8_innings_1_runs;
    private String innings_B_1_batting_player_8_innings_1_strike_rate;
    private String innings_B_1_batting_player_8_innings_1_out_comment;
    private String innings_B_1_bowling_player_8_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_8_innings_2_full_name;
    private String innings_B_1_batting_player_8_innings_2_sixes;
    private String innings_B_1_batting_player_8_innings_2_fours;
    private String innings_B_1_batting_player_8_innings_2_balls;
    private String innings_B_1_batting_player_8_innings_2_runs;
    private String innings_B_1_batting_player_8_innings_2_strike_rate;
    private String innings_B_1_batting_player_8_innings_2_out_comment;

    private String innings_B_1_bowling_player_8_innings_2_maiden_overs;


  //player_9
    private String innings_B_1_batting_player_9_full_name;
    //innings 1
    private String innings_B_1_batting_player_9_innings_1_sixes;
    private String innings_B_1_batting_player_9_innings_1_fours;
    private String innings_B_1_batting_player_9_innings_1_balls;
    private String innings_B_1_batting_player_9_innings_1_runs;
    private String innings_B_1_batting_player_9_innings_1_out_comment;
    private String innings_B_1_batting_player_9_innings_1_strike_rate;
    private String innings_B_1_bowling_player_9_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_9_innings_2_full_name;
    private String innings_B_1_batting_player_9_innings_2_sixes;
    private String innings_B_1_batting_player_9_innings_2_fours;
    private String innings_B_1_batting_player_9_innings_2_balls;
    private String innings_B_1_batting_player_9_innings_2_runs;
    private String innings_B_1_batting_player_9_innings_2_out_comment;
    private String innings_B_1_batting_player_9_innings_2_strike_rate;

    private String innings_B_1_bowling_player_9_innings_2_maiden_overs;


  //player_10
    private String innings_B_1_batting_player_10_full_name;
    //innings 1
    private String innings_B_1_batting_player_10_innings_1_sixes;
    private String innings_B_1_batting_player_10_innings_1_fours;
    private String innings_B_1_batting_player_10_innings_1_balls;
    private String innings_B_1_batting_player_10_innings_1_runs;
    private String innings_B_1_batting_player_10_innings_1_out_comment;
    private String innings_B_1_batting_player_10_innings_1_strike_rate;
    private String innings_B_1_bowling_player_10_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_10_innings_2_full_name;
    private String innings_B_1_batting_player_10_innings_2_sixes;
    private String innings_B_1_batting_player_10_innings_2_fours;
    private String innings_B_1_batting_player_10_innings_2_balls;
    private String innings_B_1_batting_player_10_innings_2_runs;
    private String innings_B_1_batting_player_10_innings_2_out_comment;
    private String innings_B_1_batting_player_10_innings_2_strike_rate;

    private String innings_B_1_bowling_player_10_innings_2_maiden_overs;



  //player_11
    private String innings_B_1_batting_player_11_full_name;
    //innings 1
    private String innings_B_1_batting_player_11_innings_1_sixes;
    private String innings_B_1_batting_player_11_innings_1_fours;
    private String innings_B_1_batting_player_11_innings_1_balls;
    private String innings_B_1_batting_player_11_innings_1_runs;
    private String innings_B_1_batting_player_11_innings_1_out_comment;
    private String innings_B_1_batting_player_11_innings_1_strike_rate;
    private String innings_B_1_bowling_player_11_innings_1_maiden_overs;
    //innings 2
    private String innings_B_1_batting_player_11_innings_2_full_name;
    private String innings_B_1_batting_player_11_innings_2_sixes;
    private String innings_B_1_batting_player_11_innings_2_fours;
    private String innings_B_1_batting_player_11_innings_2_balls;
    private String innings_B_1_batting_player_11_innings_2_runs;
    private String innings_B_1_batting_player_11_innings_2_out_comment;
    private String innings_B_1_batting_player_11_innings_2_strike_rate;

    private String innings_B_1_bowling_player_11_innings_2_maiden_overs;

    //////////////////////////////////////////////






//    private String title;

    //didn't map
    private boolean dl_applied;



    private String status;

    private String man_of_match;
    //didn't map
    private String description;
    //didn't map
    private String short_name;

    private String format;

    private Integer format_code;


    //didn't map
    private String key;
    //didn't map
    private String day;

    private String name;

    private String venue;

    private int start_date_timestamp;
    //didn't map
    private String start_date_iso;

    private String start_date_str;


    private String date;
    private String time;


    private List<String> recent_over_summary;



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

    public void setRelated_name(String related_name){
        this.related_name = related_name;
    }
    public String getRelated_name(){
        return this.related_name;
    }


    public void setWinner_team(String winner_team){
        this.winner_team = winner_team;
    }
    public String getWinner_team(){
        return this.winner_team;
    }



    public void setDl_applied(boolean dl_applied){
        this.dl_applied = dl_applied;
    }
    public boolean getDl_applied(){
        return this.dl_applied;
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
	public List<String> getInnings_A_1_batting_order() {
		return innings_A_1_batting_order;
	}
	public void setInnings_A_1_batting_order(List<String> innings_A_1_batting_order) {
		this.innings_A_1_batting_order = innings_A_1_batting_order;
	}

 public String getInning_1_batting_team() {
  return inning_1_batting_team;
 }

 public void setInning_1_batting_team(String inning_1_batting_team) {
  this.inning_1_batting_team = inning_1_batting_team;
 }

 public String getInning_2_batting_team() {
  return inning_2_batting_team;
 }

 public void setInning_2_batting_team(String inning_2_batting_team) {
  this.inning_2_batting_team = inning_2_batting_team;
 }

 public String getInning_3_batting_team() {
  return inning_3_batting_team;
 }

 public void setInning_3_batting_team(String inning_3_batting_team) {
  this.inning_3_batting_team = inning_3_batting_team;
 }

 public String getInning_4_batting_team() {
  return inning_4_batting_team;
 }

 public void setInning_4_batting_team(String inning_4_batting_team) {
  this.inning_4_batting_team = inning_4_batting_team;
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
	public List<String> getInnings_A_1_fall_of_wickets() {
		return innings_A_1_fall_of_wickets;
	}
	public void setInnings_A_1_fall_of_wickets(List<String> innings_A_1_fall_of_wickets) {
		this.innings_A_1_fall_of_wickets = innings_A_1_fall_of_wickets;
	}
	public int getInnings_A_1_wide() {
		return innings_A_1_wide;
	}
	public void setInnings_A_1_wide(int innings_A_1_wide) {
		this.innings_A_1_wide = innings_A_1_wide;
	}
	public String getInnings_A_1_run_rate() {
		return innings_A_1_run_rate;
	}
	public void setInnings_A_1_run_rate(String innings_A_1_run_rate) {
		this.innings_A_1_run_rate = innings_A_1_run_rate;
	}
	public int getInnings_A_1_fours() {
		return innings_A_1_fours;
	}
	public void setInnings_A_1_fours(int innings_A_1_fours) {
		this.innings_A_1_fours = innings_A_1_fours;
	}
	public String getInnings_A_1_run_str() {
		return innings_A_1_run_str;
	}
	public void setInnings_A_1_run_str(String innings_A_1_run_str) {
		this.innings_A_1_run_str = innings_A_1_run_str;
	}
	public int getInnings_A_1_wickets() {
		return innings_A_1_wickets;
	}
	public void setInnings_A_1_wickets(int innings_A_1_wickets) {
		this.innings_A_1_wickets = innings_A_1_wickets;
	}
	public List<String> getInnings_A_1_wicket_order() {
		return innings_A_1_wicket_order;
	}
	public void setInnings_A_1_wicket_order(List<String> innings_A_1_wicket_order) {
		this.innings_A_1_wicket_order = innings_A_1_wicket_order;
	}
	public int getInnings_A_1_extras() {
		return innings_A_1_extras;
	}
	public void setInnings_A_1_extras(int innings_A_1_extras) {
		this.innings_A_1_extras = innings_A_1_extras;
	}
	public List<String> getInnings_A_1_bowling_order() {
		return innings_A_1_bowling_order;
	}
	public void setInnings_A_1_bowling_order(List<String> innings_A_1_bowling_order) {
		this.innings_A_1_bowling_order = innings_A_1_bowling_order;
	}
	public String getInnings_A_1_key() {
		return innings_A_1_key;
	}
	public void setInnings_A_1_key(String innings_A_1_key) {
		this.innings_A_1_key = innings_A_1_key;
	}
	public int getInnings_A_1_noball() {
		return innings_A_1_noball;
	}
	public void setInnings_A_1_noball(int innings_A_1_noball) {
		this.innings_A_1_noball = innings_A_1_noball;
	}
	public int getInnings_A_1_sixes() {
		return innings_A_1_sixes;
	}
	public void setInnings_A_1_sixes(int innings_A_1_sixes) {
		this.innings_A_1_sixes = innings_A_1_sixes;
	}
	public int getInnings_A_1_legbye() {
		return innings_A_1_legbye;
	}
	public void setInnings_A_1_legbye(int innings_A_1_legbye) {
		this.innings_A_1_legbye = innings_A_1_legbye;
	}
	public int getInnings_A_1_bye() {
		return innings_A_1_bye;
	}
	public void setInnings_A_1_bye(int innings_A_1_bye) {
		this.innings_A_1_bye = innings_A_1_bye;
	}
	public String getInnings_A_1_overs() {
		return innings_A_1_overs;
	}
	public void setInnings_A_1_overs(String innings_A_1_overs) {
		this.innings_A_1_overs = innings_A_1_overs;
	}
	public int getInnings_A_1_dotballs() {
		return innings_A_1_dotballs;
	}
	public void setInnings_A_1_dotballs(int innings_A_1_dotballs) {
		this.innings_A_1_dotballs = innings_A_1_dotballs;
	}
	public List<String> getInnings_B_1_batting_order() {
		return innings_B_1_batting_order;
	}
	public void setInnings_B_1_batting_order(List<String> innings_B_1_batting_order) {
		this.innings_B_1_batting_order = innings_B_1_batting_order;
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
	public List<String> getInnings_B_1_fall_of_wickets() {
		return innings_B_1_fall_of_wickets;
	}
	public void setInnings_B_1_fall_of_wickets(List<String> innings_B_1_fall_of_wickets) {
		this.innings_B_1_fall_of_wickets = innings_B_1_fall_of_wickets;
	}
	public int getInnings_B_1_wide() {
		return innings_B_1_wide;
	}
	public void setInnings_B_1_wide(int innings_B_1_wide) {
		this.innings_B_1_wide = innings_B_1_wide;
	}
	public String getInnings_B_1_run_rate() {
		return innings_B_1_run_rate;
	}
	public void setInnings_B_1_run_rate(String innings_B_1_run_rate) {
		this.innings_B_1_run_rate = innings_B_1_run_rate;
	}
	public int getInnings_B_1_fours() {
		return innings_B_1_fours;
	}
	public void setInnings_B_1_fours(int innings_B_1_fours) {
		this.innings_B_1_fours = innings_B_1_fours;
	}
	public String getInnings_B_1_run_str() {
		return innings_B_1_run_str;
	}
	public void setInnings_B_1_run_str(String innings_B_1_run_str) {
		this.innings_B_1_run_str = innings_B_1_run_str;
	}
	public int getInnings_B_1_wickets() {
		return innings_B_1_wickets;
	}
	public void setInnings_B_1_wickets(int innings_B_1_wickets) {
		this.innings_B_1_wickets = innings_B_1_wickets;
	}
	public List<String> getInnings_B_1_wicket_order() {
		return innings_B_1_wicket_order;
	}
	public void setInnings_B_1_wicket_order(List<String> innings_B_1_wicket_order) {
		this.innings_B_1_wicket_order = innings_B_1_wicket_order;
	}
	public int getInnings_B_1_extras() {
		return innings_B_1_extras;
	}
	public void setInnings_B_1_extras(int innings_B_1_extras) {
		this.innings_B_1_extras = innings_B_1_extras;
	}
	public List<String> getInnings_B_1_bowling_order() {
		return innings_B_1_bowling_order;
	}
	public void setInnings_B_1_bowling_order(List<String> innings_B_1_bowling_order) {
		this.innings_B_1_bowling_order = innings_B_1_bowling_order;
	}
	public String getInnings_B_1_key() {
		return innings_B_1_key;
	}
	public void setInnings_B_1_key(String innings_B_1_key) {
		this.innings_B_1_key = innings_B_1_key;
	}
	public int getInnings_B_1_noball() {
		return innings_B_1_noball;
	}
	public void setInnings_B_1_noball(int innings_B_1_noball) {
		this.innings_B_1_noball = innings_B_1_noball;
	}
	public int getInnings_B_1_sixes() {
		return innings_B_1_sixes;
	}
	public void setInnings_B_1_sixes(int innings_B_1_sixes) {
		this.innings_B_1_sixes = innings_B_1_sixes;
	}
	public int getInnings_B_1_legbye() {
		return innings_B_1_legbye;
	}
	public void setInnings_B_1_legbye(int innings_B_1_legbye) {
		this.innings_B_1_legbye = innings_B_1_legbye;
	}
	public int getInnings_B_1_bye() {
		return innings_B_1_bye;
	}
	public void setInnings_B_1_bye(int innings_B_1_bye) {
		this.innings_B_1_bye = innings_B_1_bye;
	}
	public String getInnings_B_1_overs() {
		return innings_B_1_overs;
	}
	public void setInnings_B_1_overs(String innings_B_1_overs) {
		this.innings_B_1_overs = innings_B_1_overs;
	}
	public int getInnings_B_1_dotballs() {
		return innings_B_1_dotballs;
	}
	public void setInnings_B_1_dotballs(int innings_B_1_dotballs) {
		this.innings_B_1_dotballs = innings_B_1_dotballs;
	}

	public String getInnings_A_1_batting_player_1_full_name() {
		return innings_A_1_batting_player_1_full_name;
	}
	public void setInnings_A_1_batting_player_1_full_name(String innings_A_1_batting_player_1_full_name) {
		this.innings_A_1_batting_player_1_full_name = innings_A_1_batting_player_1_full_name;
	}
	public String getInnings_A_1_batting_player_1_innings_1_sixes() {
		return innings_A_1_batting_player_1_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_1_innings_1_sixes(String innings_A_1_batting_player_1_innings_1_sixes) {
		this.innings_A_1_batting_player_1_innings_1_sixes = innings_A_1_batting_player_1_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_1_innings_1_fours() {
		return innings_A_1_batting_player_1_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_1_innings_1_fours(String innings_A_1_batting_player_1_innings_1_fours) {
		this.innings_A_1_batting_player_1_innings_1_fours = innings_A_1_batting_player_1_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_1_innings_1_balls() {
		return innings_A_1_batting_player_1_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_1_innings_1_balls(String innings_A_1_batting_player_1_innings_1_balls) {
		this.innings_A_1_batting_player_1_innings_1_balls = innings_A_1_batting_player_1_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_1_innings_1_runs() {
		return innings_A_1_batting_player_1_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_1_innings_1_runs(String innings_A_1_batting_player_1_innings_1_runs) {
		this.innings_A_1_batting_player_1_innings_1_runs = innings_A_1_batting_player_1_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_1_innings_1_out_comment() {
		return innings_A_1_batting_player_1_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_1_innings_1_out_comment(
			String innings_A_1_batting_player_1_innings_1_out_comment) {
		this.innings_A_1_batting_player_1_innings_1_out_comment = innings_A_1_batting_player_1_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_1_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_1_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_1_innings_1_maiden_overs(
			String innings_A_1_bowling_player_1_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_1_innings_1_maiden_overs = innings_A_1_bowling_player_1_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_1_innings_2_sixes() {
		return innings_A_1_batting_player_1_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_1_innings_2_sixes(String innings_A_1_batting_player_1_innings_2_sixes) {
		this.innings_A_1_batting_player_1_innings_2_sixes = innings_A_1_batting_player_1_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_1_innings_2_fours() {
		return innings_A_1_batting_player_1_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_1_innings_2_fours(String innings_A_1_batting_player_1_innings_2_fours) {
		this.innings_A_1_batting_player_1_innings_2_fours = innings_A_1_batting_player_1_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_1_innings_2_balls() {
		return innings_A_1_batting_player_1_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_1_innings_2_balls(String innings_A_1_batting_player_1_innings_2_balls) {
		this.innings_A_1_batting_player_1_innings_2_balls = innings_A_1_batting_player_1_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_1_innings_2_runs() {
		return innings_A_1_batting_player_1_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_1_innings_2_runs(String innings_A_1_batting_player_1_innings_2_runs) {
		this.innings_A_1_batting_player_1_innings_2_runs = innings_A_1_batting_player_1_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_1_innings_2_out_comment() {
		return innings_A_1_batting_player_1_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_1_innings_2_out_comment(
			String innings_A_1_batting_player_1_innings_2_out_comment) {
		this.innings_A_1_batting_player_1_innings_2_out_comment = innings_A_1_batting_player_1_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_1_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_1_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_1_innings_2_maiden_overs(
			String innings_A_1_bowling_player_1_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_1_innings_2_maiden_overs = innings_A_1_bowling_player_1_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_2_full_name() {
		return innings_A_1_batting_player_2_full_name;
	}
	public void setInnings_A_1_batting_player_2_full_name(String innings_A_1_batting_player_2_full_name) {
		this.innings_A_1_batting_player_2_full_name = innings_A_1_batting_player_2_full_name;
	}
	public String getInnings_A_1_batting_player_2_innings_1_sixes() {
		return innings_A_1_batting_player_2_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_2_innings_1_sixes(String innings_A_1_batting_player_2_innings_1_sixes) {
		this.innings_A_1_batting_player_2_innings_1_sixes = innings_A_1_batting_player_2_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_2_innings_1_fours() {
		return innings_A_1_batting_player_2_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_2_innings_1_fours(String innings_A_1_batting_player_2_innings_1_fours) {
		this.innings_A_1_batting_player_2_innings_1_fours = innings_A_1_batting_player_2_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_2_innings_1_balls() {
		return innings_A_1_batting_player_2_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_2_innings_1_balls(String innings_A_1_batting_player_2_innings_1_balls) {
		this.innings_A_1_batting_player_2_innings_1_balls = innings_A_1_batting_player_2_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_2_innings_1_runs() {
		return innings_A_1_batting_player_2_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_2_innings_1_runs(String innings_A_1_batting_player_2_innings_1_runs) {
		this.innings_A_1_batting_player_2_innings_1_runs = innings_A_1_batting_player_2_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_2_innings_1_out_comment() {
		return innings_A_1_batting_player_2_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_2_innings_1_out_comment(
			String innings_A_1_batting_player_2_innings_1_out_comment) {
		this.innings_A_1_batting_player_2_innings_1_out_comment = innings_A_1_batting_player_2_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_2_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_2_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_2_innings_1_maiden_overs(
			String innings_A_1_bowling_player_2_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_2_innings_1_maiden_overs = innings_A_1_bowling_player_2_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_2_innings_2_sixes() {
		return innings_A_1_batting_player_2_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_2_innings_2_sixes(String innings_A_1_batting_player_2_innings_2_sixes) {
		this.innings_A_1_batting_player_2_innings_2_sixes = innings_A_1_batting_player_2_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_2_innings_2_fours() {
		return innings_A_1_batting_player_2_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_2_innings_2_fours(String innings_A_1_batting_player_2_innings_2_fours) {
		this.innings_A_1_batting_player_2_innings_2_fours = innings_A_1_batting_player_2_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_2_innings_2_balls() {
		return innings_A_1_batting_player_2_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_2_innings_2_balls(String innings_A_1_batting_player_2_innings_2_balls) {
		this.innings_A_1_batting_player_2_innings_2_balls = innings_A_1_batting_player_2_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_2_innings_2_runs() {
		return innings_A_1_batting_player_2_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_2_innings_2_runs(String innings_A_1_batting_player_2_innings_2_runs) {
		this.innings_A_1_batting_player_2_innings_2_runs = innings_A_1_batting_player_2_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_2_innings_2_out_comment() {
		return innings_A_1_batting_player_2_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_2_innings_2_out_comment(
			String innings_A_1_batting_player_2_innings_2_out_comment) {
		this.innings_A_1_batting_player_2_innings_2_out_comment = innings_A_1_batting_player_2_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_2_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_2_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_2_innings_2_maiden_overs(
			String innings_A_1_bowling_player_2_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_2_innings_2_maiden_overs = innings_A_1_bowling_player_2_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_3_full_name() {
		return innings_A_1_batting_player_3_full_name;
	}
	public void setInnings_A_1_batting_player_3_full_name(String innings_A_1_batting_player_3_full_name) {
		this.innings_A_1_batting_player_3_full_name = innings_A_1_batting_player_3_full_name;
	}
	public String getInnings_A_1_batting_player_3_innings_1_sixes() {
		return innings_A_1_batting_player_3_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_3_innings_1_sixes(String innings_A_1_batting_player_3_innings_1_sixes) {
		this.innings_A_1_batting_player_3_innings_1_sixes = innings_A_1_batting_player_3_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_3_innings_1_fours() {
		return innings_A_1_batting_player_3_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_3_innings_1_fours(String innings_A_1_batting_player_3_innings_1_fours) {
		this.innings_A_1_batting_player_3_innings_1_fours = innings_A_1_batting_player_3_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_3_innings_1_balls() {
		return innings_A_1_batting_player_3_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_3_innings_1_balls(String innings_A_1_batting_player_3_innings_1_balls) {
		this.innings_A_1_batting_player_3_innings_1_balls = innings_A_1_batting_player_3_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_3_innings_1_runs() {
		return innings_A_1_batting_player_3_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_3_innings_1_runs(String innings_A_1_batting_player_3_innings_1_runs) {
		this.innings_A_1_batting_player_3_innings_1_runs = innings_A_1_batting_player_3_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_3_innings_1_out_comment() {
		return innings_A_1_batting_player_3_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_3_innings_1_out_comment(
			String innings_A_1_batting_player_3_innings_1_out_comment) {
		this.innings_A_1_batting_player_3_innings_1_out_comment = innings_A_1_batting_player_3_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_3_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_3_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_3_innings_1_maiden_overs(
			String innings_A_1_bowling_player_3_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_3_innings_1_maiden_overs = innings_A_1_bowling_player_3_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_3_innings_2_sixes() {
		return innings_A_1_batting_player_3_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_3_innings_2_sixes(String innings_A_1_batting_player_3_innings_2_sixes) {
		this.innings_A_1_batting_player_3_innings_2_sixes = innings_A_1_batting_player_3_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_3_innings_2_fours() {
		return innings_A_1_batting_player_3_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_3_innings_2_fours(String innings_A_1_batting_player_3_innings_2_fours) {
		this.innings_A_1_batting_player_3_innings_2_fours = innings_A_1_batting_player_3_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_3_innings_2_balls() {
		return innings_A_1_batting_player_3_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_3_innings_2_balls(String innings_A_1_batting_player_3_innings_2_balls) {
		this.innings_A_1_batting_player_3_innings_2_balls = innings_A_1_batting_player_3_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_3_innings_2_runs() {
		return innings_A_1_batting_player_3_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_3_innings_2_runs(String innings_A_1_batting_player_3_innings_2_runs) {
		this.innings_A_1_batting_player_3_innings_2_runs = innings_A_1_batting_player_3_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_3_innings_2_out_comment() {
		return innings_A_1_batting_player_3_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_3_innings_2_out_comment(
			String innings_A_1_batting_player_3_innings_2_out_comment) {
		this.innings_A_1_batting_player_3_innings_2_out_comment = innings_A_1_batting_player_3_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_3_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_3_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_3_innings_2_maiden_overs(
			String innings_A_1_bowling_player_3_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_3_innings_2_maiden_overs = innings_A_1_bowling_player_3_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_4_full_name() {
		return innings_A_1_batting_player_4_full_name;
	}
	public void setInnings_A_1_batting_player_4_full_name(String innings_A_1_batting_player_4_full_name) {
		this.innings_A_1_batting_player_4_full_name = innings_A_1_batting_player_4_full_name;
	}
	public String getInnings_A_1_batting_player_4_innings_1_sixes() {
		return innings_A_1_batting_player_4_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_4_innings_1_sixes(String innings_A_1_batting_player_4_innings_1_sixes) {
		this.innings_A_1_batting_player_4_innings_1_sixes = innings_A_1_batting_player_4_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_4_innings_1_fours() {
		return innings_A_1_batting_player_4_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_4_innings_1_fours(String innings_A_1_batting_player_4_innings_1_fours) {
		this.innings_A_1_batting_player_4_innings_1_fours = innings_A_1_batting_player_4_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_4_innings_1_balls() {
		return innings_A_1_batting_player_4_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_4_innings_1_balls(String innings_A_1_batting_player_4_innings_1_balls) {
		this.innings_A_1_batting_player_4_innings_1_balls = innings_A_1_batting_player_4_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_4_innings_1_runs() {
		return innings_A_1_batting_player_4_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_4_innings_1_runs(String innings_A_1_batting_player_4_innings_1_runs) {
		this.innings_A_1_batting_player_4_innings_1_runs = innings_A_1_batting_player_4_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_4_innings_1_out_comment() {
		return innings_A_1_batting_player_4_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_4_innings_1_out_comment(
			String innings_A_1_batting_player_4_innings_1_out_comment) {
		this.innings_A_1_batting_player_4_innings_1_out_comment = innings_A_1_batting_player_4_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_4_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_4_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_4_innings_1_maiden_overs(
			String innings_A_1_bowling_player_4_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_4_innings_1_maiden_overs = innings_A_1_bowling_player_4_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_4_innings_2_sixes() {
		return innings_A_1_batting_player_4_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_4_innings_2_sixes(String innings_A_1_batting_player_4_innings_2_sixes) {
		this.innings_A_1_batting_player_4_innings_2_sixes = innings_A_1_batting_player_4_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_4_innings_2_fours() {
		return innings_A_1_batting_player_4_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_4_innings_2_fours(String innings_A_1_batting_player_4_innings_2_fours) {
		this.innings_A_1_batting_player_4_innings_2_fours = innings_A_1_batting_player_4_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_4_innings_2_balls() {
		return innings_A_1_batting_player_4_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_4_innings_2_balls(String innings_A_1_batting_player_4_innings_2_balls) {
		this.innings_A_1_batting_player_4_innings_2_balls = innings_A_1_batting_player_4_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_4_innings_2_runs() {
		return innings_A_1_batting_player_4_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_4_innings_2_runs(String innings_A_1_batting_player_4_innings_2_runs) {
		this.innings_A_1_batting_player_4_innings_2_runs = innings_A_1_batting_player_4_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_4_innings_2_out_comment() {
		return innings_A_1_batting_player_4_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_4_innings_2_out_comment(
			String innings_A_1_batting_player_4_innings_2_out_comment) {
		this.innings_A_1_batting_player_4_innings_2_out_comment = innings_A_1_batting_player_4_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_4_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_4_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_4_innings_2_maiden_overs(
			String innings_A_1_bowling_player_4_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_4_innings_2_maiden_overs = innings_A_1_bowling_player_4_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_5_full_name() {
		return innings_A_1_batting_player_5_full_name;
	}
	public void setInnings_A_1_batting_player_5_full_name(String innings_A_1_batting_player_5_full_name) {
		this.innings_A_1_batting_player_5_full_name = innings_A_1_batting_player_5_full_name;
	}
	public String getInnings_A_1_batting_player_5_innings_1_sixes() {
		return innings_A_1_batting_player_5_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_5_innings_1_sixes(String innings_A_1_batting_player_5_innings_1_sixes) {
		this.innings_A_1_batting_player_5_innings_1_sixes = innings_A_1_batting_player_5_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_5_innings_1_fours() {
		return innings_A_1_batting_player_5_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_5_innings_1_fours(String innings_A_1_batting_player_5_innings_1_fours) {
		this.innings_A_1_batting_player_5_innings_1_fours = innings_A_1_batting_player_5_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_5_innings_1_balls() {
		return innings_A_1_batting_player_5_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_5_innings_1_balls(String innings_A_1_batting_player_5_innings_1_balls) {
		this.innings_A_1_batting_player_5_innings_1_balls = innings_A_1_batting_player_5_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_5_innings_1_runs() {
		return innings_A_1_batting_player_5_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_5_innings_1_runs(String innings_A_1_batting_player_5_innings_1_runs) {
		this.innings_A_1_batting_player_5_innings_1_runs = innings_A_1_batting_player_5_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_5_innings_1_out_comment() {
		return innings_A_1_batting_player_5_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_5_innings_1_out_comment(
			String innings_A_1_batting_player_5_innings_1_out_comment) {
		this.innings_A_1_batting_player_5_innings_1_out_comment = innings_A_1_batting_player_5_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_5_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_5_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_5_innings_1_maiden_overs(
			String innings_A_1_bowling_player_5_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_5_innings_1_maiden_overs = innings_A_1_bowling_player_5_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_5_innings_2_sixes() {
		return innings_A_1_batting_player_5_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_5_innings_2_sixes(String innings_A_1_batting_player_5_innings_2_sixes) {
		this.innings_A_1_batting_player_5_innings_2_sixes = innings_A_1_batting_player_5_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_5_innings_2_fours() {
		return innings_A_1_batting_player_5_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_5_innings_2_fours(String innings_A_1_batting_player_5_innings_2_fours) {
		this.innings_A_1_batting_player_5_innings_2_fours = innings_A_1_batting_player_5_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_5_innings_2_balls() {
		return innings_A_1_batting_player_5_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_5_innings_2_balls(String innings_A_1_batting_player_5_innings_2_balls) {
		this.innings_A_1_batting_player_5_innings_2_balls = innings_A_1_batting_player_5_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_5_innings_2_runs() {
		return innings_A_1_batting_player_5_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_5_innings_2_runs(String innings_A_1_batting_player_5_innings_2_runs) {
		this.innings_A_1_batting_player_5_innings_2_runs = innings_A_1_batting_player_5_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_5_innings_2_out_comment() {
		return innings_A_1_batting_player_5_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_5_innings_2_out_comment(
			String innings_A_1_batting_player_5_innings_2_out_comment) {
		this.innings_A_1_batting_player_5_innings_2_out_comment = innings_A_1_batting_player_5_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_5_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_5_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_5_innings_2_maiden_overs(
			String innings_A_1_bowling_player_5_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_5_innings_2_maiden_overs = innings_A_1_bowling_player_5_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_6_full_name() {
		return innings_A_1_batting_player_6_full_name;
	}
	public void setInnings_A_1_batting_player_6_full_name(String innings_A_1_batting_player_6_full_name) {
		this.innings_A_1_batting_player_6_full_name = innings_A_1_batting_player_6_full_name;
	}
	public String getInnings_A_1_batting_player_6_innings_1_sixes() {
		return innings_A_1_batting_player_6_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_6_innings_1_sixes(String innings_A_1_batting_player_6_innings_1_sixes) {
		this.innings_A_1_batting_player_6_innings_1_sixes = innings_A_1_batting_player_6_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_6_innings_1_fours() {
		return innings_A_1_batting_player_6_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_6_innings_1_fours(String innings_A_1_batting_player_6_innings_1_fours) {
		this.innings_A_1_batting_player_6_innings_1_fours = innings_A_1_batting_player_6_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_6_innings_1_balls() {
		return innings_A_1_batting_player_6_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_6_innings_1_balls(String innings_A_1_batting_player_6_innings_1_balls) {
		this.innings_A_1_batting_player_6_innings_1_balls = innings_A_1_batting_player_6_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_6_innings_1_runs() {
		return innings_A_1_batting_player_6_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_6_innings_1_runs(String innings_A_1_batting_player_6_innings_1_runs) {
		this.innings_A_1_batting_player_6_innings_1_runs = innings_A_1_batting_player_6_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_6_innings_1_out_comment() {
		return innings_A_1_batting_player_6_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_6_innings_1_out_comment(
			String innings_A_1_batting_player_6_innings_1_out_comment) {
		this.innings_A_1_batting_player_6_innings_1_out_comment = innings_A_1_batting_player_6_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_6_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_6_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_6_innings_1_maiden_overs(
			String innings_A_1_bowling_player_6_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_6_innings_1_maiden_overs = innings_A_1_bowling_player_6_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_6_innings_2_sixes() {
		return innings_A_1_batting_player_6_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_6_innings_2_sixes(String innings_A_1_batting_player_6_innings_2_sixes) {
		this.innings_A_1_batting_player_6_innings_2_sixes = innings_A_1_batting_player_6_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_6_innings_2_fours() {
		return innings_A_1_batting_player_6_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_6_innings_2_fours(String innings_A_1_batting_player_6_innings_2_fours) {
		this.innings_A_1_batting_player_6_innings_2_fours = innings_A_1_batting_player_6_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_6_innings_2_balls() {
		return innings_A_1_batting_player_6_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_6_innings_2_balls(String innings_A_1_batting_player_6_innings_2_balls) {
		this.innings_A_1_batting_player_6_innings_2_balls = innings_A_1_batting_player_6_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_6_innings_2_runs() {
		return innings_A_1_batting_player_6_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_6_innings_2_runs(String innings_A_1_batting_player_6_innings_2_runs) {
		this.innings_A_1_batting_player_6_innings_2_runs = innings_A_1_batting_player_6_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_6_innings_2_out_comment() {
		return innings_A_1_batting_player_6_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_6_innings_2_out_comment(
			String innings_A_1_batting_player_6_innings_2_out_comment) {
		this.innings_A_1_batting_player_6_innings_2_out_comment = innings_A_1_batting_player_6_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_6_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_6_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_6_innings_2_maiden_overs(
			String innings_A_1_bowling_player_6_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_6_innings_2_maiden_overs = innings_A_1_bowling_player_6_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_7_full_name() {
		return innings_A_1_batting_player_7_full_name;
	}
	public void setInnings_A_1_batting_player_7_full_name(String innings_A_1_batting_player_7_full_name) {
		this.innings_A_1_batting_player_7_full_name = innings_A_1_batting_player_7_full_name;
	}
	public String getInnings_A_1_batting_player_7_innings_1_sixes() {
		return innings_A_1_batting_player_7_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_7_innings_1_sixes(String innings_A_1_batting_player_7_innings_1_sixes) {
		this.innings_A_1_batting_player_7_innings_1_sixes = innings_A_1_batting_player_7_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_7_innings_1_fours() {
		return innings_A_1_batting_player_7_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_7_innings_1_fours(String innings_A_1_batting_player_7_innings_1_fours) {
		this.innings_A_1_batting_player_7_innings_1_fours = innings_A_1_batting_player_7_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_7_innings_1_balls() {
		return innings_A_1_batting_player_7_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_7_innings_1_balls(String innings_A_1_batting_player_7_innings_1_balls) {
		this.innings_A_1_batting_player_7_innings_1_balls = innings_A_1_batting_player_7_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_7_innings_1_runs() {
		return innings_A_1_batting_player_7_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_7_innings_1_runs(String innings_A_1_batting_player_7_innings_1_runs) {
		this.innings_A_1_batting_player_7_innings_1_runs = innings_A_1_batting_player_7_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_7_innings_1_out_comment() {
		return innings_A_1_batting_player_7_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_7_innings_1_out_comment(
			String innings_A_1_batting_player_7_innings_1_out_comment) {
		this.innings_A_1_batting_player_7_innings_1_out_comment = innings_A_1_batting_player_7_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_7_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_7_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_7_innings_1_maiden_overs(
			String innings_A_1_bowling_player_7_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_7_innings_1_maiden_overs = innings_A_1_bowling_player_7_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_7_innings_2_sixes() {
		return innings_A_1_batting_player_7_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_7_innings_2_sixes(String innings_A_1_batting_player_7_innings_2_sixes) {
		this.innings_A_1_batting_player_7_innings_2_sixes = innings_A_1_batting_player_7_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_7_innings_2_fours() {
		return innings_A_1_batting_player_7_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_7_innings_2_fours(String innings_A_1_batting_player_7_innings_2_fours) {
		this.innings_A_1_batting_player_7_innings_2_fours = innings_A_1_batting_player_7_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_7_innings_2_balls() {
		return innings_A_1_batting_player_7_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_7_innings_2_balls(String innings_A_1_batting_player_7_innings_2_balls) {
		this.innings_A_1_batting_player_7_innings_2_balls = innings_A_1_batting_player_7_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_7_innings_2_runs() {
		return innings_A_1_batting_player_7_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_7_innings_2_runs(String innings_A_1_batting_player_7_innings_2_runs) {
		this.innings_A_1_batting_player_7_innings_2_runs = innings_A_1_batting_player_7_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_7_innings_2_out_comment() {
		return innings_A_1_batting_player_7_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_7_innings_2_out_comment(
			String innings_A_1_batting_player_7_innings_2_out_comment) {
		this.innings_A_1_batting_player_7_innings_2_out_comment = innings_A_1_batting_player_7_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_7_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_7_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_7_innings_2_maiden_overs(
			String innings_A_1_bowling_player_7_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_7_innings_2_maiden_overs = innings_A_1_bowling_player_7_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_8_full_name() {
		return innings_A_1_batting_player_8_full_name;
	}
	public void setInnings_A_1_batting_player_8_full_name(String innings_A_1_batting_player_8_full_name) {
		this.innings_A_1_batting_player_8_full_name = innings_A_1_batting_player_8_full_name;
	}
	public String getInnings_A_1_batting_player_8_innings_1_sixes() {
		return innings_A_1_batting_player_8_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_8_innings_1_sixes(String innings_A_1_batting_player_8_innings_1_sixes) {
		this.innings_A_1_batting_player_8_innings_1_sixes = innings_A_1_batting_player_8_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_8_innings_1_fours() {
		return innings_A_1_batting_player_8_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_8_innings_1_fours(String innings_A_1_batting_player_8_innings_1_fours) {
		this.innings_A_1_batting_player_8_innings_1_fours = innings_A_1_batting_player_8_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_8_innings_1_balls() {
		return innings_A_1_batting_player_8_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_8_innings_1_balls(String innings_A_1_batting_player_8_innings_1_balls) {
		this.innings_A_1_batting_player_8_innings_1_balls = innings_A_1_batting_player_8_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_8_innings_1_runs() {
		return innings_A_1_batting_player_8_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_8_innings_1_runs(String innings_A_1_batting_player_8_innings_1_runs) {
		this.innings_A_1_batting_player_8_innings_1_runs = innings_A_1_batting_player_8_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_8_innings_1_out_comment() {
		return innings_A_1_batting_player_8_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_8_innings_1_out_comment(
			String innings_A_1_batting_player_8_innings_1_out_comment) {
		this.innings_A_1_batting_player_8_innings_1_out_comment = innings_A_1_batting_player_8_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_8_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_8_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_8_innings_1_maiden_overs(
			String innings_A_1_bowling_player_8_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_8_innings_1_maiden_overs = innings_A_1_bowling_player_8_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_8_innings_2_sixes() {
		return innings_A_1_batting_player_8_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_8_innings_2_sixes(String innings_A_1_batting_player_8_innings_2_sixes) {
		this.innings_A_1_batting_player_8_innings_2_sixes = innings_A_1_batting_player_8_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_8_innings_2_fours() {
		return innings_A_1_batting_player_8_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_8_innings_2_fours(String innings_A_1_batting_player_8_innings_2_fours) {
		this.innings_A_1_batting_player_8_innings_2_fours = innings_A_1_batting_player_8_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_8_innings_2_balls() {
		return innings_A_1_batting_player_8_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_8_innings_2_balls(String innings_A_1_batting_player_8_innings_2_balls) {
		this.innings_A_1_batting_player_8_innings_2_balls = innings_A_1_batting_player_8_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_8_innings_2_runs() {
		return innings_A_1_batting_player_8_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_8_innings_2_runs(String innings_A_1_batting_player_8_innings_2_runs) {
		this.innings_A_1_batting_player_8_innings_2_runs = innings_A_1_batting_player_8_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_8_innings_2_out_comment() {
		return innings_A_1_batting_player_8_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_8_innings_2_out_comment(
			String innings_A_1_batting_player_8_innings_2_out_comment) {
		this.innings_A_1_batting_player_8_innings_2_out_comment = innings_A_1_batting_player_8_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_8_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_8_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_8_innings_2_maiden_overs(
			String innings_A_1_bowling_player_8_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_8_innings_2_maiden_overs = innings_A_1_bowling_player_8_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_9_full_name() {
		return innings_A_1_batting_player_9_full_name;
	}
	public void setInnings_A_1_batting_player_9_full_name(String innings_A_1_batting_player_9_full_name) {
		this.innings_A_1_batting_player_9_full_name = innings_A_1_batting_player_9_full_name;
	}
	public String getInnings_A_1_batting_player_9_innings_1_sixes() {
		return innings_A_1_batting_player_9_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_9_innings_1_sixes(String innings_A_1_batting_player_9_innings_1_sixes) {
		this.innings_A_1_batting_player_9_innings_1_sixes = innings_A_1_batting_player_9_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_9_innings_1_fours() {
		return innings_A_1_batting_player_9_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_9_innings_1_fours(String innings_A_1_batting_player_9_innings_1_fours) {
		this.innings_A_1_batting_player_9_innings_1_fours = innings_A_1_batting_player_9_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_9_innings_1_balls() {
		return innings_A_1_batting_player_9_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_9_innings_1_balls(String innings_A_1_batting_player_9_innings_1_balls) {
		this.innings_A_1_batting_player_9_innings_1_balls = innings_A_1_batting_player_9_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_9_innings_1_runs() {
		return innings_A_1_batting_player_9_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_9_innings_1_runs(String innings_A_1_batting_player_9_innings_1_runs) {
		this.innings_A_1_batting_player_9_innings_1_runs = innings_A_1_batting_player_9_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_9_innings_1_out_comment() {
		return innings_A_1_batting_player_9_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_9_innings_1_out_comment(
			String innings_A_1_batting_player_9_innings_1_out_comment) {
		this.innings_A_1_batting_player_9_innings_1_out_comment = innings_A_1_batting_player_9_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_9_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_9_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_9_innings_1_maiden_overs(
			String innings_A_1_bowling_player_9_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_9_innings_1_maiden_overs = innings_A_1_bowling_player_9_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_9_innings_2_sixes() {
		return innings_A_1_batting_player_9_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_9_innings_2_sixes(String innings_A_1_batting_player_9_innings_2_sixes) {
		this.innings_A_1_batting_player_9_innings_2_sixes = innings_A_1_batting_player_9_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_9_innings_2_fours() {
		return innings_A_1_batting_player_9_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_9_innings_2_fours(String innings_A_1_batting_player_9_innings_2_fours) {
		this.innings_A_1_batting_player_9_innings_2_fours = innings_A_1_batting_player_9_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_9_innings_2_balls() {
		return innings_A_1_batting_player_9_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_9_innings_2_balls(String innings_A_1_batting_player_9_innings_2_balls) {
		this.innings_A_1_batting_player_9_innings_2_balls = innings_A_1_batting_player_9_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_9_innings_2_runs() {
		return innings_A_1_batting_player_9_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_9_innings_2_runs(String innings_A_1_batting_player_9_innings_2_runs) {
		this.innings_A_1_batting_player_9_innings_2_runs = innings_A_1_batting_player_9_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_9_innings_2_out_comment() {
		return innings_A_1_batting_player_9_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_9_innings_2_out_comment(
			String innings_A_1_batting_player_9_innings_2_out_comment) {
		this.innings_A_1_batting_player_9_innings_2_out_comment = innings_A_1_batting_player_9_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_9_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_9_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_9_innings_2_maiden_overs(
			String innings_A_1_bowling_player_9_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_9_innings_2_maiden_overs = innings_A_1_bowling_player_9_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_10_full_name() {
		return innings_A_1_batting_player_10_full_name;
	}
	public void setInnings_A_1_batting_player_10_full_name(String innings_A_1_batting_player_10_full_name) {
		this.innings_A_1_batting_player_10_full_name = innings_A_1_batting_player_10_full_name;
	}
	public String getInnings_A_1_batting_player_10_innings_1_sixes() {
		return innings_A_1_batting_player_10_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_10_innings_1_sixes(String innings_A_1_batting_player_10_innings_1_sixes) {
		this.innings_A_1_batting_player_10_innings_1_sixes = innings_A_1_batting_player_10_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_10_innings_1_fours() {
		return innings_A_1_batting_player_10_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_10_innings_1_fours(String innings_A_1_batting_player_10_innings_1_fours) {
		this.innings_A_1_batting_player_10_innings_1_fours = innings_A_1_batting_player_10_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_10_innings_1_balls() {
		return innings_A_1_batting_player_10_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_10_innings_1_balls(String innings_A_1_batting_player_10_innings_1_balls) {
		this.innings_A_1_batting_player_10_innings_1_balls = innings_A_1_batting_player_10_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_10_innings_1_runs() {
		return innings_A_1_batting_player_10_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_10_innings_1_runs(String innings_A_1_batting_player_10_innings_1_runs) {
		this.innings_A_1_batting_player_10_innings_1_runs = innings_A_1_batting_player_10_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_10_innings_1_out_comment() {
		return innings_A_1_batting_player_10_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_10_innings_1_out_comment(
			String innings_A_1_batting_player_10_innings_1_out_comment) {
		this.innings_A_1_batting_player_10_innings_1_out_comment = innings_A_1_batting_player_10_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_10_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_10_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_10_innings_1_maiden_overs(
			String innings_A_1_bowling_player_10_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_10_innings_1_maiden_overs = innings_A_1_bowling_player_10_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_10_innings_2_sixes() {
		return innings_A_1_batting_player_10_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_10_innings_2_sixes(String innings_A_1_batting_player_10_innings_2_sixes) {
		this.innings_A_1_batting_player_10_innings_2_sixes = innings_A_1_batting_player_10_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_10_innings_2_fours() {
		return innings_A_1_batting_player_10_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_10_innings_2_fours(String innings_A_1_batting_player_10_innings_2_fours) {
		this.innings_A_1_batting_player_10_innings_2_fours = innings_A_1_batting_player_10_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_10_innings_2_balls() {
		return innings_A_1_batting_player_10_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_10_innings_2_balls(String innings_A_1_batting_player_10_innings_2_balls) {
		this.innings_A_1_batting_player_10_innings_2_balls = innings_A_1_batting_player_10_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_10_innings_2_runs() {
		return innings_A_1_batting_player_10_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_10_innings_2_runs(String innings_A_1_batting_player_10_innings_2_runs) {
		this.innings_A_1_batting_player_10_innings_2_runs = innings_A_1_batting_player_10_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_10_innings_2_out_comment() {
		return innings_A_1_batting_player_10_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_10_innings_2_out_comment(
			String innings_A_1_batting_player_10_innings_2_out_comment) {
		this.innings_A_1_batting_player_10_innings_2_out_comment = innings_A_1_batting_player_10_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_10_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_10_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_10_innings_2_maiden_overs(
			String innings_A_1_bowling_player_10_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_10_innings_2_maiden_overs = innings_A_1_bowling_player_10_innings_2_maiden_overs;
	}
	public String getInnings_A_1_batting_player_11_full_name() {
		return innings_A_1_batting_player_11_full_name;
	}
	public void setInnings_A_1_batting_player_11_full_name(String innings_A_1_batting_player_11_full_name) {
		this.innings_A_1_batting_player_11_full_name = innings_A_1_batting_player_11_full_name;
	}
	public String getInnings_A_1_batting_player_11_innings_1_sixes() {
		return innings_A_1_batting_player_11_innings_1_sixes;
	}
	public void setInnings_A_1_batting_player_11_innings_1_sixes(String innings_A_1_batting_player_11_innings_1_sixes) {
		this.innings_A_1_batting_player_11_innings_1_sixes = innings_A_1_batting_player_11_innings_1_sixes;
	}
	public String getInnings_A_1_batting_player_11_innings_1_fours() {
		return innings_A_1_batting_player_11_innings_1_fours;
	}
	public void setInnings_A_1_batting_player_11_innings_1_fours(String innings_A_1_batting_player_11_innings_1_fours) {
		this.innings_A_1_batting_player_11_innings_1_fours = innings_A_1_batting_player_11_innings_1_fours;
	}
	public String getInnings_A_1_batting_player_11_innings_1_balls() {
		return innings_A_1_batting_player_11_innings_1_balls;
	}
	public void setInnings_A_1_batting_player_11_innings_1_balls(String innings_A_1_batting_player_11_innings_1_balls) {
		this.innings_A_1_batting_player_11_innings_1_balls = innings_A_1_batting_player_11_innings_1_balls;
	}
	public String getInnings_A_1_batting_player_11_innings_1_runs() {
		return innings_A_1_batting_player_11_innings_1_runs;
	}
	public void setInnings_A_1_batting_player_11_innings_1_runs(String innings_A_1_batting_player_11_innings_1_runs) {
		this.innings_A_1_batting_player_11_innings_1_runs = innings_A_1_batting_player_11_innings_1_runs;
	}
	public String getInnings_A_1_batting_player_11_innings_1_out_comment() {
		return innings_A_1_batting_player_11_innings_1_out_comment;
	}
	public void setInnings_A_1_batting_player_11_innings_1_out_comment(
			String innings_A_1_batting_player_11_innings_1_out_comment) {
		this.innings_A_1_batting_player_11_innings_1_out_comment = innings_A_1_batting_player_11_innings_1_out_comment;
	}
	public String getInnings_A_1_bowling_player_11_innings_1_maiden_overs() {
		return innings_A_1_bowling_player_11_innings_1_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_11_innings_1_maiden_overs(
			String innings_A_1_bowling_player_11_innings_1_maiden_overs) {
		this.innings_A_1_bowling_player_11_innings_1_maiden_overs = innings_A_1_bowling_player_11_innings_1_maiden_overs;
	}
	public String getInnings_A_1_batting_player_11_innings_2_sixes() {
		return innings_A_1_batting_player_11_innings_2_sixes;
	}
	public void setInnings_A_1_batting_player_11_innings_2_sixes(String innings_A_1_batting_player_11_innings_2_sixes) {
		this.innings_A_1_batting_player_11_innings_2_sixes = innings_A_1_batting_player_11_innings_2_sixes;
	}
	public String getInnings_A_1_batting_player_11_innings_2_fours() {
		return innings_A_1_batting_player_11_innings_2_fours;
	}
	public void setInnings_A_1_batting_player_11_innings_2_fours(String innings_A_1_batting_player_11_innings_2_fours) {
		this.innings_A_1_batting_player_11_innings_2_fours = innings_A_1_batting_player_11_innings_2_fours;
	}
	public String getInnings_A_1_batting_player_11_innings_2_balls() {
		return innings_A_1_batting_player_11_innings_2_balls;
	}
	public void setInnings_A_1_batting_player_11_innings_2_balls(String innings_A_1_batting_player_11_innings_2_balls) {
		this.innings_A_1_batting_player_11_innings_2_balls = innings_A_1_batting_player_11_innings_2_balls;
	}
	public String getInnings_A_1_batting_player_11_innings_2_runs() {
		return innings_A_1_batting_player_11_innings_2_runs;
	}
	public void setInnings_A_1_batting_player_11_innings_2_runs(String innings_A_1_batting_player_11_innings_2_runs) {
		this.innings_A_1_batting_player_11_innings_2_runs = innings_A_1_batting_player_11_innings_2_runs;
	}
	public String getInnings_A_1_batting_player_11_innings_2_out_comment() {
		return innings_A_1_batting_player_11_innings_2_out_comment;
	}
	public void setInnings_A_1_batting_player_11_innings_2_out_comment(
			String innings_A_1_batting_player_11_innings_2_out_comment) {
		this.innings_A_1_batting_player_11_innings_2_out_comment = innings_A_1_batting_player_11_innings_2_out_comment;
	}
	public String getInnings_A_1_bowling_player_11_innings_2_maiden_overs() {
		return innings_A_1_bowling_player_11_innings_2_maiden_overs;
	}
	public void setInnings_A_1_bowling_player_11_innings_2_maiden_overs(
			String innings_A_1_bowling_player_11_innings_2_maiden_overs) {
		this.innings_A_1_bowling_player_11_innings_2_maiden_overs = innings_A_1_bowling_player_11_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_1_full_name() {
		return innings_B_1_batting_player_1_full_name;
	}
	public void setInnings_B_1_batting_player_1_full_name(String innings_B_1_batting_player_1_full_name) {
		this.innings_B_1_batting_player_1_full_name = innings_B_1_batting_player_1_full_name;
	}
	public String getInnings_B_1_batting_player_1_innings_1_sixes() {
		return innings_B_1_batting_player_1_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_1_innings_1_sixes(String innings_B_1_batting_player_1_innings_1_sixes) {
		this.innings_B_1_batting_player_1_innings_1_sixes = innings_B_1_batting_player_1_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_1_innings_1_fours() {
		return innings_B_1_batting_player_1_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_1_innings_1_fours(String innings_B_1_batting_player_1_innings_1_fours) {
		this.innings_B_1_batting_player_1_innings_1_fours = innings_B_1_batting_player_1_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_1_innings_1_balls() {
		return innings_B_1_batting_player_1_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_1_innings_1_balls(String innings_B_1_batting_player_1_innings_1_balls) {
		this.innings_B_1_batting_player_1_innings_1_balls = innings_B_1_batting_player_1_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_1_innings_1_runs() {
		return innings_B_1_batting_player_1_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_1_innings_1_runs(String innings_B_1_batting_player_1_innings_1_runs) {
		this.innings_B_1_batting_player_1_innings_1_runs = innings_B_1_batting_player_1_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_1_innings_1_out_comment() {
		return innings_B_1_batting_player_1_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_1_innings_1_out_comment(
			String innings_B_1_batting_player_1_innings_1_out_comment) {
		this.innings_B_1_batting_player_1_innings_1_out_comment = innings_B_1_batting_player_1_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_1_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_1_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_1_innings_1_maiden_overs(
			String innings_B_1_bowling_player_1_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_1_innings_1_maiden_overs = innings_B_1_bowling_player_1_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_1_innings_2_sixes() {
		return innings_B_1_batting_player_1_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_1_innings_2_sixes(String innings_B_1_batting_player_1_innings_2_sixes) {
		this.innings_B_1_batting_player_1_innings_2_sixes = innings_B_1_batting_player_1_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_1_innings_2_fours() {
		return innings_B_1_batting_player_1_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_1_innings_2_fours(String innings_B_1_batting_player_1_innings_2_fours) {
		this.innings_B_1_batting_player_1_innings_2_fours = innings_B_1_batting_player_1_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_1_innings_2_balls() {
		return innings_B_1_batting_player_1_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_1_innings_2_balls(String innings_B_1_batting_player_1_innings_2_balls) {
		this.innings_B_1_batting_player_1_innings_2_balls = innings_B_1_batting_player_1_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_1_innings_2_runs() {
		return innings_B_1_batting_player_1_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_1_innings_2_runs(String innings_B_1_batting_player_1_innings_2_runs) {
		this.innings_B_1_batting_player_1_innings_2_runs = innings_B_1_batting_player_1_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_1_innings_2_out_comment() {
		return innings_B_1_batting_player_1_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_1_innings_2_out_comment(
			String innings_B_1_batting_player_1_innings_2_out_comment) {
		this.innings_B_1_batting_player_1_innings_2_out_comment = innings_B_1_batting_player_1_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_1_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_1_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_1_innings_2_maiden_overs(
			String innings_B_1_bowling_player_1_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_1_innings_2_maiden_overs = innings_B_1_bowling_player_1_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_2_full_name() {
		return innings_B_1_batting_player_2_full_name;
	}
	public void setInnings_B_1_batting_player_2_full_name(String innings_B_1_batting_player_2_full_name) {
		this.innings_B_1_batting_player_2_full_name = innings_B_1_batting_player_2_full_name;
	}
	public String getInnings_B_1_batting_player_2_innings_1_sixes() {
		return innings_B_1_batting_player_2_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_2_innings_1_sixes(String innings_B_1_batting_player_2_innings_1_sixes) {
		this.innings_B_1_batting_player_2_innings_1_sixes = innings_B_1_batting_player_2_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_2_innings_1_fours() {
		return innings_B_1_batting_player_2_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_2_innings_1_fours(String innings_B_1_batting_player_2_innings_1_fours) {
		this.innings_B_1_batting_player_2_innings_1_fours = innings_B_1_batting_player_2_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_2_innings_1_balls() {
		return innings_B_1_batting_player_2_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_2_innings_1_balls(String innings_B_1_batting_player_2_innings_1_balls) {
		this.innings_B_1_batting_player_2_innings_1_balls = innings_B_1_batting_player_2_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_2_innings_1_runs() {
		return innings_B_1_batting_player_2_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_2_innings_1_runs(String innings_B_1_batting_player_2_innings_1_runs) {
		this.innings_B_1_batting_player_2_innings_1_runs = innings_B_1_batting_player_2_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_2_innings_1_out_comment() {
		return innings_B_1_batting_player_2_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_2_innings_1_out_comment(
			String innings_B_1_batting_player_2_innings_1_out_comment) {
		this.innings_B_1_batting_player_2_innings_1_out_comment = innings_B_1_batting_player_2_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_2_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_2_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_2_innings_1_maiden_overs(
			String innings_B_1_bowling_player_2_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_2_innings_1_maiden_overs = innings_B_1_bowling_player_2_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_2_innings_2_sixes() {
		return innings_B_1_batting_player_2_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_2_innings_2_sixes(String innings_B_1_batting_player_2_innings_2_sixes) {
		this.innings_B_1_batting_player_2_innings_2_sixes = innings_B_1_batting_player_2_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_2_innings_2_fours() {
		return innings_B_1_batting_player_2_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_2_innings_2_fours(String innings_B_1_batting_player_2_innings_2_fours) {
		this.innings_B_1_batting_player_2_innings_2_fours = innings_B_1_batting_player_2_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_2_innings_2_balls() {
		return innings_B_1_batting_player_2_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_2_innings_2_balls(String innings_B_1_batting_player_2_innings_2_balls) {
		this.innings_B_1_batting_player_2_innings_2_balls = innings_B_1_batting_player_2_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_2_innings_2_runs() {
		return innings_B_1_batting_player_2_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_2_innings_2_runs(String innings_B_1_batting_player_2_innings_2_runs) {
		this.innings_B_1_batting_player_2_innings_2_runs = innings_B_1_batting_player_2_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_2_innings_2_out_comment() {
		return innings_B_1_batting_player_2_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_2_innings_2_out_comment(
			String innings_B_1_batting_player_2_innings_2_out_comment) {
		this.innings_B_1_batting_player_2_innings_2_out_comment = innings_B_1_batting_player_2_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_2_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_2_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_2_innings_2_maiden_overs(
			String innings_B_1_bowling_player_2_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_2_innings_2_maiden_overs = innings_B_1_bowling_player_2_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_3_full_name() {
		return innings_B_1_batting_player_3_full_name;
	}
	public void setInnings_B_1_batting_player_3_full_name(String innings_B_1_batting_player_3_full_name) {
		this.innings_B_1_batting_player_3_full_name = innings_B_1_batting_player_3_full_name;
	}
	public String getInnings_B_1_batting_player_3_innings_1_sixes() {
		return innings_B_1_batting_player_3_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_3_innings_1_sixes(String innings_B_1_batting_player_3_innings_1_sixes) {
		this.innings_B_1_batting_player_3_innings_1_sixes = innings_B_1_batting_player_3_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_3_innings_1_fours() {
		return innings_B_1_batting_player_3_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_3_innings_1_fours(String innings_B_1_batting_player_3_innings_1_fours) {
		this.innings_B_1_batting_player_3_innings_1_fours = innings_B_1_batting_player_3_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_3_innings_1_balls() {
		return innings_B_1_batting_player_3_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_3_innings_1_balls(String innings_B_1_batting_player_3_innings_1_balls) {
		this.innings_B_1_batting_player_3_innings_1_balls = innings_B_1_batting_player_3_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_3_innings_1_runs() {
		return innings_B_1_batting_player_3_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_3_innings_1_runs(String innings_B_1_batting_player_3_innings_1_runs) {
		this.innings_B_1_batting_player_3_innings_1_runs = innings_B_1_batting_player_3_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_3_innings_1_out_comment() {
		return innings_B_1_batting_player_3_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_3_innings_1_out_comment(
			String innings_B_1_batting_player_3_innings_1_out_comment) {
		this.innings_B_1_batting_player_3_innings_1_out_comment = innings_B_1_batting_player_3_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_3_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_3_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_3_innings_1_maiden_overs(
			String innings_B_1_bowling_player_3_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_3_innings_1_maiden_overs = innings_B_1_bowling_player_3_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_3_innings_2_sixes() {
		return innings_B_1_batting_player_3_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_3_innings_2_sixes(String innings_B_1_batting_player_3_innings_2_sixes) {
		this.innings_B_1_batting_player_3_innings_2_sixes = innings_B_1_batting_player_3_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_3_innings_2_fours() {
		return innings_B_1_batting_player_3_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_3_innings_2_fours(String innings_B_1_batting_player_3_innings_2_fours) {
		this.innings_B_1_batting_player_3_innings_2_fours = innings_B_1_batting_player_3_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_3_innings_2_balls() {
		return innings_B_1_batting_player_3_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_3_innings_2_balls(String innings_B_1_batting_player_3_innings_2_balls) {
		this.innings_B_1_batting_player_3_innings_2_balls = innings_B_1_batting_player_3_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_3_innings_2_runs() {
		return innings_B_1_batting_player_3_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_3_innings_2_runs(String innings_B_1_batting_player_3_innings_2_runs) {
		this.innings_B_1_batting_player_3_innings_2_runs = innings_B_1_batting_player_3_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_3_innings_2_out_comment() {
		return innings_B_1_batting_player_3_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_3_innings_2_out_comment(
			String innings_B_1_batting_player_3_innings_2_out_comment) {
		this.innings_B_1_batting_player_3_innings_2_out_comment = innings_B_1_batting_player_3_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_3_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_3_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_3_innings_2_maiden_overs(
			String innings_B_1_bowling_player_3_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_3_innings_2_maiden_overs = innings_B_1_bowling_player_3_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_4_full_name() {
		return innings_B_1_batting_player_4_full_name;
	}
	public void setInnings_B_1_batting_player_4_full_name(String innings_B_1_batting_player_4_full_name) {
		this.innings_B_1_batting_player_4_full_name = innings_B_1_batting_player_4_full_name;
	}
	public String getInnings_B_1_batting_player_4_innings_1_sixes() {
		return innings_B_1_batting_player_4_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_4_innings_1_sixes(String innings_B_1_batting_player_4_innings_1_sixes) {
		this.innings_B_1_batting_player_4_innings_1_sixes = innings_B_1_batting_player_4_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_4_innings_1_fours() {
		return innings_B_1_batting_player_4_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_4_innings_1_fours(String innings_B_1_batting_player_4_innings_1_fours) {
		this.innings_B_1_batting_player_4_innings_1_fours = innings_B_1_batting_player_4_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_4_innings_1_balls() {
		return innings_B_1_batting_player_4_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_4_innings_1_balls(String innings_B_1_batting_player_4_innings_1_balls) {
		this.innings_B_1_batting_player_4_innings_1_balls = innings_B_1_batting_player_4_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_4_innings_1_runs() {
		return innings_B_1_batting_player_4_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_4_innings_1_runs(String innings_B_1_batting_player_4_innings_1_runs) {
		this.innings_B_1_batting_player_4_innings_1_runs = innings_B_1_batting_player_4_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_4_innings_1_out_comment() {
		return innings_B_1_batting_player_4_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_4_innings_1_out_comment(
			String innings_B_1_batting_player_4_innings_1_out_comment) {
		this.innings_B_1_batting_player_4_innings_1_out_comment = innings_B_1_batting_player_4_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_4_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_4_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_4_innings_1_maiden_overs(
			String innings_B_1_bowling_player_4_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_4_innings_1_maiden_overs = innings_B_1_bowling_player_4_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_4_innings_2_sixes() {
		return innings_B_1_batting_player_4_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_4_innings_2_sixes(String innings_B_1_batting_player_4_innings_2_sixes) {
		this.innings_B_1_batting_player_4_innings_2_sixes = innings_B_1_batting_player_4_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_4_innings_2_fours() {
		return innings_B_1_batting_player_4_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_4_innings_2_fours(String innings_B_1_batting_player_4_innings_2_fours) {
		this.innings_B_1_batting_player_4_innings_2_fours = innings_B_1_batting_player_4_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_4_innings_2_balls() {
		return innings_B_1_batting_player_4_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_4_innings_2_balls(String innings_B_1_batting_player_4_innings_2_balls) {
		this.innings_B_1_batting_player_4_innings_2_balls = innings_B_1_batting_player_4_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_4_innings_2_runs() {
		return innings_B_1_batting_player_4_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_4_innings_2_runs(String innings_B_1_batting_player_4_innings_2_runs) {
		this.innings_B_1_batting_player_4_innings_2_runs = innings_B_1_batting_player_4_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_4_innings_2_out_comment() {
		return innings_B_1_batting_player_4_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_4_innings_2_out_comment(
			String innings_B_1_batting_player_4_innings_2_out_comment) {
		this.innings_B_1_batting_player_4_innings_2_out_comment = innings_B_1_batting_player_4_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_4_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_4_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_4_innings_2_maiden_overs(
			String innings_B_1_bowling_player_4_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_4_innings_2_maiden_overs = innings_B_1_bowling_player_4_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_5_full_name() {
		return innings_B_1_batting_player_5_full_name;
	}
	public void setInnings_B_1_batting_player_5_full_name(String innings_B_1_batting_player_5_full_name) {
		this.innings_B_1_batting_player_5_full_name = innings_B_1_batting_player_5_full_name;
	}
	public String getInnings_B_1_batting_player_5_innings_1_sixes() {
		return innings_B_1_batting_player_5_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_5_innings_1_sixes(String innings_B_1_batting_player_5_innings_1_sixes) {
		this.innings_B_1_batting_player_5_innings_1_sixes = innings_B_1_batting_player_5_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_5_innings_1_fours() {
		return innings_B_1_batting_player_5_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_5_innings_1_fours(String innings_B_1_batting_player_5_innings_1_fours) {
		this.innings_B_1_batting_player_5_innings_1_fours = innings_B_1_batting_player_5_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_5_innings_1_balls() {
		return innings_B_1_batting_player_5_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_5_innings_1_balls(String innings_B_1_batting_player_5_innings_1_balls) {
		this.innings_B_1_batting_player_5_innings_1_balls = innings_B_1_batting_player_5_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_5_innings_1_runs() {
		return innings_B_1_batting_player_5_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_5_innings_1_runs(String innings_B_1_batting_player_5_innings_1_runs) {
		this.innings_B_1_batting_player_5_innings_1_runs = innings_B_1_batting_player_5_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_5_innings_1_out_comment() {
		return innings_B_1_batting_player_5_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_5_innings_1_out_comment(
			String innings_B_1_batting_player_5_innings_1_out_comment) {
		this.innings_B_1_batting_player_5_innings_1_out_comment = innings_B_1_batting_player_5_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_5_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_5_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_5_innings_1_maiden_overs(
			String innings_B_1_bowling_player_5_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_5_innings_1_maiden_overs = innings_B_1_bowling_player_5_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_5_innings_2_sixes() {
		return innings_B_1_batting_player_5_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_5_innings_2_sixes(String innings_B_1_batting_player_5_innings_2_sixes) {
		this.innings_B_1_batting_player_5_innings_2_sixes = innings_B_1_batting_player_5_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_5_innings_2_fours() {
		return innings_B_1_batting_player_5_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_5_innings_2_fours(String innings_B_1_batting_player_5_innings_2_fours) {
		this.innings_B_1_batting_player_5_innings_2_fours = innings_B_1_batting_player_5_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_5_innings_2_balls() {
		return innings_B_1_batting_player_5_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_5_innings_2_balls(String innings_B_1_batting_player_5_innings_2_balls) {
		this.innings_B_1_batting_player_5_innings_2_balls = innings_B_1_batting_player_5_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_5_innings_2_runs() {
		return innings_B_1_batting_player_5_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_5_innings_2_runs(String innings_B_1_batting_player_5_innings_2_runs) {
		this.innings_B_1_batting_player_5_innings_2_runs = innings_B_1_batting_player_5_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_5_innings_2_out_comment() {
		return innings_B_1_batting_player_5_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_5_innings_2_out_comment(
			String innings_B_1_batting_player_5_innings_2_out_comment) {
		this.innings_B_1_batting_player_5_innings_2_out_comment = innings_B_1_batting_player_5_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_5_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_5_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_5_innings_2_maiden_overs(
			String innings_B_1_bowling_player_5_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_5_innings_2_maiden_overs = innings_B_1_bowling_player_5_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_6_full_name() {
		return innings_B_1_batting_player_6_full_name;
	}
	public void setInnings_B_1_batting_player_6_full_name(String innings_B_1_batting_player_6_full_name) {
		this.innings_B_1_batting_player_6_full_name = innings_B_1_batting_player_6_full_name;
	}
	public String getInnings_B_1_batting_player_6_innings_1_sixes() {
		return innings_B_1_batting_player_6_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_6_innings_1_sixes(String innings_B_1_batting_player_6_innings_1_sixes) {
		this.innings_B_1_batting_player_6_innings_1_sixes = innings_B_1_batting_player_6_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_6_innings_1_fours() {
		return innings_B_1_batting_player_6_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_6_innings_1_fours(String innings_B_1_batting_player_6_innings_1_fours) {
		this.innings_B_1_batting_player_6_innings_1_fours = innings_B_1_batting_player_6_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_6_innings_1_balls() {
		return innings_B_1_batting_player_6_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_6_innings_1_balls(String innings_B_1_batting_player_6_innings_1_balls) {
		this.innings_B_1_batting_player_6_innings_1_balls = innings_B_1_batting_player_6_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_6_innings_1_runs() {
		return innings_B_1_batting_player_6_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_6_innings_1_runs(String innings_B_1_batting_player_6_innings_1_runs) {
		this.innings_B_1_batting_player_6_innings_1_runs = innings_B_1_batting_player_6_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_6_innings_1_out_comment() {
		return innings_B_1_batting_player_6_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_6_innings_1_out_comment(
			String innings_B_1_batting_player_6_innings_1_out_comment) {
		this.innings_B_1_batting_player_6_innings_1_out_comment = innings_B_1_batting_player_6_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_6_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_6_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_6_innings_1_maiden_overs(
			String innings_B_1_bowling_player_6_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_6_innings_1_maiden_overs = innings_B_1_bowling_player_6_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_6_innings_2_sixes() {
		return innings_B_1_batting_player_6_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_6_innings_2_sixes(String innings_B_1_batting_player_6_innings_2_sixes) {
		this.innings_B_1_batting_player_6_innings_2_sixes = innings_B_1_batting_player_6_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_6_innings_2_fours() {
		return innings_B_1_batting_player_6_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_6_innings_2_fours(String innings_B_1_batting_player_6_innings_2_fours) {
		this.innings_B_1_batting_player_6_innings_2_fours = innings_B_1_batting_player_6_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_6_innings_2_balls() {
		return innings_B_1_batting_player_6_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_6_innings_2_balls(String innings_B_1_batting_player_6_innings_2_balls) {
		this.innings_B_1_batting_player_6_innings_2_balls = innings_B_1_batting_player_6_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_6_innings_2_runs() {
		return innings_B_1_batting_player_6_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_6_innings_2_runs(String innings_B_1_batting_player_6_innings_2_runs) {
		this.innings_B_1_batting_player_6_innings_2_runs = innings_B_1_batting_player_6_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_6_innings_2_out_comment() {
		return innings_B_1_batting_player_6_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_6_innings_2_out_comment(
			String innings_B_1_batting_player_6_innings_2_out_comment) {
		this.innings_B_1_batting_player_6_innings_2_out_comment = innings_B_1_batting_player_6_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_6_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_6_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_6_innings_2_maiden_overs(
			String innings_B_1_bowling_player_6_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_6_innings_2_maiden_overs = innings_B_1_bowling_player_6_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_7_full_name() {
		return innings_B_1_batting_player_7_full_name;
	}
	public void setInnings_B_1_batting_player_7_full_name(String innings_B_1_batting_player_7_full_name) {
		this.innings_B_1_batting_player_7_full_name = innings_B_1_batting_player_7_full_name;
	}
	public String getInnings_B_1_batting_player_7_innings_1_sixes() {
		return innings_B_1_batting_player_7_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_7_innings_1_sixes(String innings_B_1_batting_player_7_innings_1_sixes) {
		this.innings_B_1_batting_player_7_innings_1_sixes = innings_B_1_batting_player_7_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_7_innings_1_fours() {
		return innings_B_1_batting_player_7_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_7_innings_1_fours(String innings_B_1_batting_player_7_innings_1_fours) {
		this.innings_B_1_batting_player_7_innings_1_fours = innings_B_1_batting_player_7_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_7_innings_1_balls() {
		return innings_B_1_batting_player_7_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_7_innings_1_balls(String innings_B_1_batting_player_7_innings_1_balls) {
		this.innings_B_1_batting_player_7_innings_1_balls = innings_B_1_batting_player_7_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_7_innings_1_runs() {
		return innings_B_1_batting_player_7_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_7_innings_1_runs(String innings_B_1_batting_player_7_innings_1_runs) {
		this.innings_B_1_batting_player_7_innings_1_runs = innings_B_1_batting_player_7_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_7_innings_1_out_comment() {
		return innings_B_1_batting_player_7_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_7_innings_1_out_comment(
			String innings_B_1_batting_player_7_innings_1_out_comment) {
		this.innings_B_1_batting_player_7_innings_1_out_comment = innings_B_1_batting_player_7_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_7_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_7_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_7_innings_1_maiden_overs(
			String innings_B_1_bowling_player_7_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_7_innings_1_maiden_overs = innings_B_1_bowling_player_7_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_7_innings_2_sixes() {
		return innings_B_1_batting_player_7_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_7_innings_2_sixes(String innings_B_1_batting_player_7_innings_2_sixes) {
		this.innings_B_1_batting_player_7_innings_2_sixes = innings_B_1_batting_player_7_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_7_innings_2_fours() {
		return innings_B_1_batting_player_7_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_7_innings_2_fours(String innings_B_1_batting_player_7_innings_2_fours) {
		this.innings_B_1_batting_player_7_innings_2_fours = innings_B_1_batting_player_7_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_7_innings_2_balls() {
		return innings_B_1_batting_player_7_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_7_innings_2_balls(String innings_B_1_batting_player_7_innings_2_balls) {
		this.innings_B_1_batting_player_7_innings_2_balls = innings_B_1_batting_player_7_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_7_innings_2_runs() {
		return innings_B_1_batting_player_7_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_7_innings_2_runs(String innings_B_1_batting_player_7_innings_2_runs) {
		this.innings_B_1_batting_player_7_innings_2_runs = innings_B_1_batting_player_7_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_7_innings_2_out_comment() {
		return innings_B_1_batting_player_7_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_7_innings_2_out_comment(
			String innings_B_1_batting_player_7_innings_2_out_comment) {
		this.innings_B_1_batting_player_7_innings_2_out_comment = innings_B_1_batting_player_7_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_7_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_7_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_7_innings_2_maiden_overs(
			String innings_B_1_bowling_player_7_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_7_innings_2_maiden_overs = innings_B_1_bowling_player_7_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_8_full_name() {
		return innings_B_1_batting_player_8_full_name;
	}
	public void setInnings_B_1_batting_player_8_full_name(String innings_B_1_batting_player_8_full_name) {
		this.innings_B_1_batting_player_8_full_name = innings_B_1_batting_player_8_full_name;
	}
	public String getInnings_B_1_batting_player_8_innings_1_sixes() {
		return innings_B_1_batting_player_8_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_8_innings_1_sixes(String innings_B_1_batting_player_8_innings_1_sixes) {
		this.innings_B_1_batting_player_8_innings_1_sixes = innings_B_1_batting_player_8_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_8_innings_1_fours() {
		return innings_B_1_batting_player_8_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_8_innings_1_fours(String innings_B_1_batting_player_8_innings_1_fours) {
		this.innings_B_1_batting_player_8_innings_1_fours = innings_B_1_batting_player_8_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_8_innings_1_balls() {
		return innings_B_1_batting_player_8_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_8_innings_1_balls(String innings_B_1_batting_player_8_innings_1_balls) {
		this.innings_B_1_batting_player_8_innings_1_balls = innings_B_1_batting_player_8_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_8_innings_1_runs() {
		return innings_B_1_batting_player_8_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_8_innings_1_runs(String innings_B_1_batting_player_8_innings_1_runs) {
		this.innings_B_1_batting_player_8_innings_1_runs = innings_B_1_batting_player_8_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_8_innings_1_out_comment() {
		return innings_B_1_batting_player_8_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_8_innings_1_out_comment(
			String innings_B_1_batting_player_8_innings_1_out_comment) {
		this.innings_B_1_batting_player_8_innings_1_out_comment = innings_B_1_batting_player_8_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_8_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_8_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_8_innings_1_maiden_overs(
			String innings_B_1_bowling_player_8_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_8_innings_1_maiden_overs = innings_B_1_bowling_player_8_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_8_innings_2_sixes() {
		return innings_B_1_batting_player_8_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_8_innings_2_sixes(String innings_B_1_batting_player_8_innings_2_sixes) {
		this.innings_B_1_batting_player_8_innings_2_sixes = innings_B_1_batting_player_8_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_8_innings_2_fours() {
		return innings_B_1_batting_player_8_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_8_innings_2_fours(String innings_B_1_batting_player_8_innings_2_fours) {
		this.innings_B_1_batting_player_8_innings_2_fours = innings_B_1_batting_player_8_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_8_innings_2_balls() {
		return innings_B_1_batting_player_8_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_8_innings_2_balls(String innings_B_1_batting_player_8_innings_2_balls) {
		this.innings_B_1_batting_player_8_innings_2_balls = innings_B_1_batting_player_8_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_8_innings_2_runs() {
		return innings_B_1_batting_player_8_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_8_innings_2_runs(String innings_B_1_batting_player_8_innings_2_runs) {
		this.innings_B_1_batting_player_8_innings_2_runs = innings_B_1_batting_player_8_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_8_innings_2_out_comment() {
		return innings_B_1_batting_player_8_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_8_innings_2_out_comment(
			String innings_B_1_batting_player_8_innings_2_out_comment) {
		this.innings_B_1_batting_player_8_innings_2_out_comment = innings_B_1_batting_player_8_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_8_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_8_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_8_innings_2_maiden_overs(
			String innings_B_1_bowling_player_8_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_8_innings_2_maiden_overs = innings_B_1_bowling_player_8_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_9_full_name() {
		return innings_B_1_batting_player_9_full_name;
	}
	public void setInnings_B_1_batting_player_9_full_name(String innings_B_1_batting_player_9_full_name) {
		this.innings_B_1_batting_player_9_full_name = innings_B_1_batting_player_9_full_name;
	}
	public String getInnings_B_1_batting_player_9_innings_1_sixes() {
		return innings_B_1_batting_player_9_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_9_innings_1_sixes(String innings_B_1_batting_player_9_innings_1_sixes) {
		this.innings_B_1_batting_player_9_innings_1_sixes = innings_B_1_batting_player_9_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_9_innings_1_fours() {
		return innings_B_1_batting_player_9_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_9_innings_1_fours(String innings_B_1_batting_player_9_innings_1_fours) {
		this.innings_B_1_batting_player_9_innings_1_fours = innings_B_1_batting_player_9_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_9_innings_1_balls() {
		return innings_B_1_batting_player_9_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_9_innings_1_balls(String innings_B_1_batting_player_9_innings_1_balls) {
		this.innings_B_1_batting_player_9_innings_1_balls = innings_B_1_batting_player_9_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_9_innings_1_runs() {
		return innings_B_1_batting_player_9_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_9_innings_1_runs(String innings_B_1_batting_player_9_innings_1_runs) {
		this.innings_B_1_batting_player_9_innings_1_runs = innings_B_1_batting_player_9_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_9_innings_1_out_comment() {
		return innings_B_1_batting_player_9_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_9_innings_1_out_comment(
			String innings_B_1_batting_player_9_innings_1_out_comment) {
		this.innings_B_1_batting_player_9_innings_1_out_comment = innings_B_1_batting_player_9_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_9_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_9_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_9_innings_1_maiden_overs(
			String innings_B_1_bowling_player_9_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_9_innings_1_maiden_overs = innings_B_1_bowling_player_9_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_9_innings_2_sixes() {
		return innings_B_1_batting_player_9_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_9_innings_2_sixes(String innings_B_1_batting_player_9_innings_2_sixes) {
		this.innings_B_1_batting_player_9_innings_2_sixes = innings_B_1_batting_player_9_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_9_innings_2_fours() {
		return innings_B_1_batting_player_9_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_9_innings_2_fours(String innings_B_1_batting_player_9_innings_2_fours) {
		this.innings_B_1_batting_player_9_innings_2_fours = innings_B_1_batting_player_9_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_9_innings_2_balls() {
		return innings_B_1_batting_player_9_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_9_innings_2_balls(String innings_B_1_batting_player_9_innings_2_balls) {
		this.innings_B_1_batting_player_9_innings_2_balls = innings_B_1_batting_player_9_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_9_innings_2_runs() {
		return innings_B_1_batting_player_9_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_9_innings_2_runs(String innings_B_1_batting_player_9_innings_2_runs) {
		this.innings_B_1_batting_player_9_innings_2_runs = innings_B_1_batting_player_9_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_9_innings_2_out_comment() {
		return innings_B_1_batting_player_9_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_9_innings_2_out_comment(
			String innings_B_1_batting_player_9_innings_2_out_comment) {
		this.innings_B_1_batting_player_9_innings_2_out_comment = innings_B_1_batting_player_9_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_9_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_9_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_9_innings_2_maiden_overs(
			String innings_B_1_bowling_player_9_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_9_innings_2_maiden_overs = innings_B_1_bowling_player_9_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_10_full_name() {
		return innings_B_1_batting_player_10_full_name;
	}
	public void setInnings_B_1_batting_player_10_full_name(String innings_B_1_batting_player_10_full_name) {
		this.innings_B_1_batting_player_10_full_name = innings_B_1_batting_player_10_full_name;
	}
	public String getInnings_B_1_batting_player_10_innings_1_sixes() {
		return innings_B_1_batting_player_10_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_10_innings_1_sixes(String innings_B_1_batting_player_10_innings_1_sixes) {
		this.innings_B_1_batting_player_10_innings_1_sixes = innings_B_1_batting_player_10_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_10_innings_1_fours() {
		return innings_B_1_batting_player_10_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_10_innings_1_fours(String innings_B_1_batting_player_10_innings_1_fours) {
		this.innings_B_1_batting_player_10_innings_1_fours = innings_B_1_batting_player_10_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_10_innings_1_balls() {
		return innings_B_1_batting_player_10_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_10_innings_1_balls(String innings_B_1_batting_player_10_innings_1_balls) {
		this.innings_B_1_batting_player_10_innings_1_balls = innings_B_1_batting_player_10_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_10_innings_1_runs() {
		return innings_B_1_batting_player_10_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_10_innings_1_runs(String innings_B_1_batting_player_10_innings_1_runs) {
		this.innings_B_1_batting_player_10_innings_1_runs = innings_B_1_batting_player_10_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_10_innings_1_out_comment() {
		return innings_B_1_batting_player_10_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_10_innings_1_out_comment(
			String innings_B_1_batting_player_10_innings_1_out_comment) {
		this.innings_B_1_batting_player_10_innings_1_out_comment = innings_B_1_batting_player_10_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_10_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_10_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_10_innings_1_maiden_overs(
			String innings_B_1_bowling_player_10_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_10_innings_1_maiden_overs = innings_B_1_bowling_player_10_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_10_innings_2_sixes() {
		return innings_B_1_batting_player_10_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_10_innings_2_sixes(String innings_B_1_batting_player_10_innings_2_sixes) {
		this.innings_B_1_batting_player_10_innings_2_sixes = innings_B_1_batting_player_10_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_10_innings_2_fours() {
		return innings_B_1_batting_player_10_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_10_innings_2_fours(String innings_B_1_batting_player_10_innings_2_fours) {
		this.innings_B_1_batting_player_10_innings_2_fours = innings_B_1_batting_player_10_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_10_innings_2_balls() {
		return innings_B_1_batting_player_10_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_10_innings_2_balls(String innings_B_1_batting_player_10_innings_2_balls) {
		this.innings_B_1_batting_player_10_innings_2_balls = innings_B_1_batting_player_10_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_10_innings_2_runs() {
		return innings_B_1_batting_player_10_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_10_innings_2_runs(String innings_B_1_batting_player_10_innings_2_runs) {
		this.innings_B_1_batting_player_10_innings_2_runs = innings_B_1_batting_player_10_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_10_innings_2_out_comment() {
		return innings_B_1_batting_player_10_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_10_innings_2_out_comment(
			String innings_B_1_batting_player_10_innings_2_out_comment) {
		this.innings_B_1_batting_player_10_innings_2_out_comment = innings_B_1_batting_player_10_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_10_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_10_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_10_innings_2_maiden_overs(
			String innings_B_1_bowling_player_10_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_10_innings_2_maiden_overs = innings_B_1_bowling_player_10_innings_2_maiden_overs;
	}
	public String getInnings_B_1_batting_player_11_full_name() {
		return innings_B_1_batting_player_11_full_name;
	}
	public void setInnings_B_1_batting_player_11_full_name(String innings_B_1_batting_player_11_full_name) {
		this.innings_B_1_batting_player_11_full_name = innings_B_1_batting_player_11_full_name;
	}
	public String getInnings_B_1_batting_player_11_innings_1_sixes() {
		return innings_B_1_batting_player_11_innings_1_sixes;
	}
	public void setInnings_B_1_batting_player_11_innings_1_sixes(String innings_B_1_batting_player_11_innings_1_sixes) {
		this.innings_B_1_batting_player_11_innings_1_sixes = innings_B_1_batting_player_11_innings_1_sixes;
	}
	public String getInnings_B_1_batting_player_11_innings_1_fours() {
		return innings_B_1_batting_player_11_innings_1_fours;
	}
	public void setInnings_B_1_batting_player_11_innings_1_fours(String innings_B_1_batting_player_11_innings_1_fours) {
		this.innings_B_1_batting_player_11_innings_1_fours = innings_B_1_batting_player_11_innings_1_fours;
	}
	public String getInnings_B_1_batting_player_11_innings_1_balls() {
		return innings_B_1_batting_player_11_innings_1_balls;
	}
	public void setInnings_B_1_batting_player_11_innings_1_balls(String innings_B_1_batting_player_11_innings_1_balls) {
		this.innings_B_1_batting_player_11_innings_1_balls = innings_B_1_batting_player_11_innings_1_balls;
	}
	public String getInnings_B_1_batting_player_11_innings_1_runs() {
		return innings_B_1_batting_player_11_innings_1_runs;
	}
	public void setInnings_B_1_batting_player_11_innings_1_runs(String innings_B_1_batting_player_11_innings_1_runs) {
		this.innings_B_1_batting_player_11_innings_1_runs = innings_B_1_batting_player_11_innings_1_runs;
	}
	public String getInnings_B_1_batting_player_11_innings_1_out_comment() {
		return innings_B_1_batting_player_11_innings_1_out_comment;
	}
	public void setInnings_B_1_batting_player_11_innings_1_out_comment(
			String innings_B_1_batting_player_11_innings_1_out_comment) {
		this.innings_B_1_batting_player_11_innings_1_out_comment = innings_B_1_batting_player_11_innings_1_out_comment;
	}
	public String getInnings_B_1_bowling_player_11_innings_1_maiden_overs() {
		return innings_B_1_bowling_player_11_innings_1_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_11_innings_1_maiden_overs(
			String innings_B_1_bowling_player_11_innings_1_maiden_overs) {
		this.innings_B_1_bowling_player_11_innings_1_maiden_overs = innings_B_1_bowling_player_11_innings_1_maiden_overs;
	}
	public String getInnings_B_1_batting_player_11_innings_2_sixes() {
		return innings_B_1_batting_player_11_innings_2_sixes;
	}
	public void setInnings_B_1_batting_player_11_innings_2_sixes(String innings_B_1_batting_player_11_innings_2_sixes) {
		this.innings_B_1_batting_player_11_innings_2_sixes = innings_B_1_batting_player_11_innings_2_sixes;
	}
	public String getInnings_B_1_batting_player_11_innings_2_fours() {
		return innings_B_1_batting_player_11_innings_2_fours;
	}
	public void setInnings_B_1_batting_player_11_innings_2_fours(String innings_B_1_batting_player_11_innings_2_fours) {
		this.innings_B_1_batting_player_11_innings_2_fours = innings_B_1_batting_player_11_innings_2_fours;
	}
	public String getInnings_B_1_batting_player_11_innings_2_balls() {
		return innings_B_1_batting_player_11_innings_2_balls;
	}
	public void setInnings_B_1_batting_player_11_innings_2_balls(String innings_B_1_batting_player_11_innings_2_balls) {
		this.innings_B_1_batting_player_11_innings_2_balls = innings_B_1_batting_player_11_innings_2_balls;
	}
	public String getInnings_B_1_batting_player_11_innings_2_runs() {
		return innings_B_1_batting_player_11_innings_2_runs;
	}
	public void setInnings_B_1_batting_player_11_innings_2_runs(String innings_B_1_batting_player_11_innings_2_runs) {
		this.innings_B_1_batting_player_11_innings_2_runs = innings_B_1_batting_player_11_innings_2_runs;
	}
	public String getInnings_B_1_batting_player_11_innings_2_out_comment() {
		return innings_B_1_batting_player_11_innings_2_out_comment;
	}
	public void setInnings_B_1_batting_player_11_innings_2_out_comment(
			String innings_B_1_batting_player_11_innings_2_out_comment) {
		this.innings_B_1_batting_player_11_innings_2_out_comment = innings_B_1_batting_player_11_innings_2_out_comment;
	}
	public String getInnings_B_1_bowling_player_11_innings_2_maiden_overs() {
		return innings_B_1_bowling_player_11_innings_2_maiden_overs;
	}
	public void setInnings_B_1_bowling_player_11_innings_2_maiden_overs(
			String innings_B_1_bowling_player_11_innings_2_maiden_overs) {
		this.innings_B_1_bowling_player_11_innings_2_maiden_overs = innings_B_1_bowling_player_11_innings_2_maiden_overs;
	}

    public String getInnings_A_1_batting_player_1_innings_1_strike_rate() {
        return innings_A_1_batting_player_1_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_1_innings_1_strike_rate(String innings_A_1_batting_player_1_innings_1_strike_rate) {
        this.innings_A_1_batting_player_1_innings_1_strike_rate = innings_A_1_batting_player_1_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_1_innings_2_strike_rate() {
        return innings_A_1_batting_player_1_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_1_innings_2_strike_rate(String innings_A_1_batting_player_1_innings_2_strike_rate) {
        this.innings_A_1_batting_player_1_innings_2_strike_rate = innings_A_1_batting_player_1_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_2_innings_1_strike_rate() {
        return innings_A_1_batting_player_2_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_2_innings_1_strike_rate(String innings_A_1_batting_player_2_innings_1_strike_rate) {
        this.innings_A_1_batting_player_2_innings_1_strike_rate = innings_A_1_batting_player_2_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_2_innings_2_strike_rate() {
        return innings_A_1_batting_player_2_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_2_innings_2_strike_rate(String innings_A_1_batting_player_2_innings_2_strike_rate) {
        this.innings_A_1_batting_player_2_innings_2_strike_rate = innings_A_1_batting_player_2_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_3_innings_1_strike_rate() {
        return innings_A_1_batting_player_3_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_3_innings_1_strike_rate(String innings_A_1_batting_player_3_innings_1_strike_rate) {
        this.innings_A_1_batting_player_3_innings_1_strike_rate = innings_A_1_batting_player_3_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_3_innings_2_strike_rate() {
        return innings_A_1_batting_player_3_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_3_innings_2_strike_rate(String innings_A_1_batting_player_3_innings_2_strike_rate) {
        this.innings_A_1_batting_player_3_innings_2_strike_rate = innings_A_1_batting_player_3_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_4_innings_1_strike_rate() {
        return innings_A_1_batting_player_4_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_4_innings_1_strike_rate(String innings_A_1_batting_player_4_innings_1_strike_rate) {
        this.innings_A_1_batting_player_4_innings_1_strike_rate = innings_A_1_batting_player_4_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_4_innings_2_strike_rate() {
        return innings_A_1_batting_player_4_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_4_innings_2_strike_rate(String innings_A_1_batting_player_4_innings_2_strike_rate) {
        this.innings_A_1_batting_player_4_innings_2_strike_rate = innings_A_1_batting_player_4_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_5_innings_1_strike_rate() {
        return innings_A_1_batting_player_5_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_5_innings_1_strike_rate(String innings_A_1_batting_player_5_innings_1_strike_rate) {
        this.innings_A_1_batting_player_5_innings_1_strike_rate = innings_A_1_batting_player_5_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_5_innings_2_strike_rate() {
        return innings_A_1_batting_player_5_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_5_innings_2_strike_rate(String innings_A_1_batting_player_5_innings_2_strike_rate) {
        this.innings_A_1_batting_player_5_innings_2_strike_rate = innings_A_1_batting_player_5_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_6_innings_1_strike_rate() {
        return innings_A_1_batting_player_6_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_6_innings_1_strike_rate(String innings_A_1_batting_player_6_innings_1_strike_rate) {
        this.innings_A_1_batting_player_6_innings_1_strike_rate = innings_A_1_batting_player_6_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_6_innings_2_strike_rate() {
        return innings_A_1_batting_player_6_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_6_innings_2_strike_rate(String innings_A_1_batting_player_6_innings_2_strike_rate) {
        this.innings_A_1_batting_player_6_innings_2_strike_rate = innings_A_1_batting_player_6_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_7_innings_1_strike_rate() {
        return innings_A_1_batting_player_7_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_7_innings_1_strike_rate(String innings_A_1_batting_player_7_innings_1_strike_rate) {
        this.innings_A_1_batting_player_7_innings_1_strike_rate = innings_A_1_batting_player_7_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_7_innings_2_strike_rate() {
        return innings_A_1_batting_player_7_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_7_innings_2_strike_rate(String innings_A_1_batting_player_7_innings_2_strike_rate) {
        this.innings_A_1_batting_player_7_innings_2_strike_rate = innings_A_1_batting_player_7_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_8_innings_1_strike_rate() {
        return innings_A_1_batting_player_8_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_8_innings_1_strike_rate(String innings_A_1_batting_player_8_innings_1_strike_rate) {
        this.innings_A_1_batting_player_8_innings_1_strike_rate = innings_A_1_batting_player_8_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_8_innings_2_strike_rate() {
        return innings_A_1_batting_player_8_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_8_innings_2_strike_rate(String innings_A_1_batting_player_8_innings_2_strike_rate) {
        this.innings_A_1_batting_player_8_innings_2_strike_rate = innings_A_1_batting_player_8_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_9_innings_1_strike_rate() {
        return innings_A_1_batting_player_9_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_9_innings_1_strike_rate(String innings_A_1_batting_player_9_innings_1_strike_rate) {
        this.innings_A_1_batting_player_9_innings_1_strike_rate = innings_A_1_batting_player_9_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_9_innings_2_strike_rate() {
        return innings_A_1_batting_player_9_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_9_innings_2_strike_rate(String innings_A_1_batting_player_9_innings_2_strike_rate) {
        this.innings_A_1_batting_player_9_innings_2_strike_rate = innings_A_1_batting_player_9_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_10_innings_1_strike_rate() {
        return innings_A_1_batting_player_10_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_10_innings_1_strike_rate(String innings_A_1_batting_player_10_innings_1_strike_rate) {
        this.innings_A_1_batting_player_10_innings_1_strike_rate = innings_A_1_batting_player_10_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_10_innings_2_strike_rate() {
        return innings_A_1_batting_player_10_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_10_innings_2_strike_rate(String innings_A_1_batting_player_10_innings_2_strike_rate) {
        this.innings_A_1_batting_player_10_innings_2_strike_rate = innings_A_1_batting_player_10_innings_2_strike_rate;
    }

    public String getInnings_A_1_batting_player_11_innings_1_strike_rate() {
        return innings_A_1_batting_player_11_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_11_innings_1_strike_rate(String innings_A_1_batting_player_11_innings_1_strike_rate) {
        this.innings_A_1_batting_player_11_innings_1_strike_rate = innings_A_1_batting_player_11_innings_1_strike_rate;
    }

    public String getInnings_A_1_batting_player_11_innings_2_strike_rate() {
        return innings_A_1_batting_player_11_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_11_innings_2_strike_rate(String innings_A_1_batting_player_11_innings_2_strike_rate) {
        this.innings_A_1_batting_player_11_innings_2_strike_rate = innings_A_1_batting_player_11_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_1_innings_1_strike_rate() {
        return innings_B_1_batting_player_1_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_1_innings_1_strike_rate(String innings_B_1_batting_player_1_innings_1_strike_rate) {
        this.innings_B_1_batting_player_1_innings_1_strike_rate = innings_B_1_batting_player_1_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_1_innings_2_strike_rate() {
        return innings_B_1_batting_player_1_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_1_innings_2_strike_rate(String innings_B_1_batting_player_1_innings_2_strike_rate) {
        this.innings_B_1_batting_player_1_innings_2_strike_rate = innings_B_1_batting_player_1_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_2_innings_1_strike_rate() {
        return innings_B_1_batting_player_2_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_2_innings_1_strike_rate(String innings_B_1_batting_player_2_innings_1_strike_rate) {
        this.innings_B_1_batting_player_2_innings_1_strike_rate = innings_B_1_batting_player_2_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_2_innings_2_strike_rate() {
        return innings_B_1_batting_player_2_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_2_innings_2_strike_rate(String innings_B_1_batting_player_2_innings_2_strike_rate) {
        this.innings_B_1_batting_player_2_innings_2_strike_rate = innings_B_1_batting_player_2_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_3_innings_1_strike_rate() {
        return innings_B_1_batting_player_3_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_3_innings_1_strike_rate(String innings_B_1_batting_player_3_innings_1_strike_rate) {
        this.innings_B_1_batting_player_3_innings_1_strike_rate = innings_B_1_batting_player_3_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_3_innings_2_strike_rate() {
        return innings_B_1_batting_player_3_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_3_innings_2_strike_rate(String innings_B_1_batting_player_3_innings_2_strike_rate) {
        this.innings_B_1_batting_player_3_innings_2_strike_rate = innings_B_1_batting_player_3_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_4_innings_1_strike_rate() {
        return innings_B_1_batting_player_4_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_4_innings_1_strike_rate(String innings_B_1_batting_player_4_innings_1_strike_rate) {
        this.innings_B_1_batting_player_4_innings_1_strike_rate = innings_B_1_batting_player_4_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_4_innings_2_strike_rate() {
        return innings_B_1_batting_player_4_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_4_innings_2_strike_rate(String innings_B_1_batting_player_4_innings_2_strike_rate) {
        this.innings_B_1_batting_player_4_innings_2_strike_rate = innings_B_1_batting_player_4_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_5_innings_1_strike_rate() {
        return innings_B_1_batting_player_5_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_5_innings_1_strike_rate(String innings_B_1_batting_player_5_innings_1_strike_rate) {
        this.innings_B_1_batting_player_5_innings_1_strike_rate = innings_B_1_batting_player_5_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_5_innings_2_strike_rate() {
        return innings_B_1_batting_player_5_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_5_innings_2_strike_rate(String innings_B_1_batting_player_5_innings_2_strike_rate) {
        this.innings_B_1_batting_player_5_innings_2_strike_rate = innings_B_1_batting_player_5_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_6_innings_1_strike_rate() {
        return innings_B_1_batting_player_6_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_6_innings_1_strike_rate(String innings_B_1_batting_player_6_innings_1_strike_rate) {
        this.innings_B_1_batting_player_6_innings_1_strike_rate = innings_B_1_batting_player_6_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_6_innings_2_strike_rate() {
        return innings_B_1_batting_player_6_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_6_innings_2_strike_rate(String innings_B_1_batting_player_6_innings_2_strike_rate) {
        this.innings_B_1_batting_player_6_innings_2_strike_rate = innings_B_1_batting_player_6_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_7_innings_1_strike_rate() {
        return innings_B_1_batting_player_7_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_7_innings_1_strike_rate(String innings_B_1_batting_player_7_innings_1_strike_rate) {
        this.innings_B_1_batting_player_7_innings_1_strike_rate = innings_B_1_batting_player_7_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_7_innings_2_strike_rate() {
        return innings_B_1_batting_player_7_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_7_innings_2_strike_rate(String innings_B_1_batting_player_7_innings_2_strike_rate) {
        this.innings_B_1_batting_player_7_innings_2_strike_rate = innings_B_1_batting_player_7_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_8_innings_1_strike_rate() {
        return innings_B_1_batting_player_8_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_8_innings_1_strike_rate(String innings_B_1_batting_player_8_innings_1_strike_rate) {
        this.innings_B_1_batting_player_8_innings_1_strike_rate = innings_B_1_batting_player_8_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_8_innings_2_strike_rate() {
        return innings_B_1_batting_player_8_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_8_innings_2_strike_rate(String innings_B_1_batting_player_8_innings_2_strike_rate) {
        this.innings_B_1_batting_player_8_innings_2_strike_rate = innings_B_1_batting_player_8_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_9_innings_1_strike_rate() {
        return innings_B_1_batting_player_9_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_9_innings_1_strike_rate(String innings_B_1_batting_player_9_innings_1_strike_rate) {
        this.innings_B_1_batting_player_9_innings_1_strike_rate = innings_B_1_batting_player_9_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_9_innings_2_strike_rate() {
        return innings_B_1_batting_player_9_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_9_innings_2_strike_rate(String innings_B_1_batting_player_9_innings_2_strike_rate) {
        this.innings_B_1_batting_player_9_innings_2_strike_rate = innings_B_1_batting_player_9_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_10_innings_1_strike_rate() {
        return innings_B_1_batting_player_10_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_10_innings_1_strike_rate(String innings_B_1_batting_player_10_innings_1_strike_rate) {
        this.innings_B_1_batting_player_10_innings_1_strike_rate = innings_B_1_batting_player_10_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_10_innings_2_strike_rate() {
        return innings_B_1_batting_player_10_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_10_innings_2_strike_rate(String innings_B_1_batting_player_10_innings_2_strike_rate) {
        this.innings_B_1_batting_player_10_innings_2_strike_rate = innings_B_1_batting_player_10_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_11_innings_1_strike_rate() {
        return innings_B_1_batting_player_11_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_11_innings_1_strike_rate(String innings_B_1_batting_player_11_innings_1_strike_rate) {
        this.innings_B_1_batting_player_11_innings_1_strike_rate = innings_B_1_batting_player_11_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_11_innings_2_strike_rate() {
        return innings_B_1_batting_player_11_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_11_innings_2_strike_rate(String innings_B_1_batting_player_11_innings_2_strike_rate) {
        this.innings_B_1_batting_player_11_innings_2_strike_rate = innings_B_1_batting_player_11_innings_2_strike_rate;
    }

    public boolean isDl_applied() {
        return dl_applied;
    }
//
//    public List<Bowling> getBowling_a_1() {
//        return bowling_a_1;
//    }
//
//    public void setBowling_a_1(List<Bowling> bowling_a_1) {
//        this.bowling_a_1 = bowling_a_1;
//    }
//
//    public List<Bowling> getBowling_b_1() {
//        return bowling_b_1;
//    }
//
//    public void setBowling_b_1(List<Bowling> bowling_b_1) {
//        this.bowling_b_1 = bowling_b_1;
//    }
//
//    public List<Bowling> getBowling_a_2() {
//        return bowling_a_2;
//    }
//
//    public void setBowling_a_2(List<Bowling> bowling_a_2) {
//        this.bowling_a_2 = bowling_a_2;
//    }
//
//    public List<Bowling> getBowling_b_2() {
//        return bowling_b_2;
//    }
//
//    public void setBowling_b_2(List<Bowling> bowling_b_2) {
//        this.bowling_b_2 = bowling_b_2;
//    }


    public String getBowling_a_1_player_1_name() {
        return bowling_a_1_player_1_name;
    }

    public void setBowling_a_1_player_1_name(String bowling_a_1_player_1_name) {
        this.bowling_a_1_player_1_name = bowling_a_1_player_1_name;
    }

    public String getBowling_a_1_player_1_economy() {
        return bowling_a_1_player_1_economy;
    }

    public void setBowling_a_1_player_1_economy(String bowling_a_1_player_1_economy) {
        this.bowling_a_1_player_1_economy = bowling_a_1_player_1_economy;
    }

    public String getBowling_a_1_player_1_runs() {
        return bowling_a_1_player_1_runs;
    }

    public void setBowling_a_1_player_1_runs(String bowling_a_1_player_1_runs) {
        this.bowling_a_1_player_1_runs = bowling_a_1_player_1_runs;
    }

    public String getBowling_a_1_player_1_dots() {
        return bowling_a_1_player_1_dots;
    }

    public void setBowling_a_1_player_1_dots(String bowling_a_1_player_1_dots) {
        this.bowling_a_1_player_1_dots = bowling_a_1_player_1_dots;
    }

    public String getBowling_a_1_player_1_balls() {
        return bowling_a_1_player_1_balls;
    }

    public void setBowling_a_1_player_1_balls(String bowling_a_1_player_1_balls) {
        this.bowling_a_1_player_1_balls = bowling_a_1_player_1_balls;
    }

    public String getBowling_a_1_player_1_wickets() {
        return bowling_a_1_player_1_wickets;
    }

    public void setBowling_a_1_player_1_wickets(String bowling_a_1_player_1_wickets) {
        this.bowling_a_1_player_1_wickets = bowling_a_1_player_1_wickets;
    }

    public String getBowling_a_1_player_1_extras() {
        return bowling_a_1_player_1_extras;
    }

    public void setBowling_a_1_player_1_extras(String bowling_a_1_player_1_extras) {
        this.bowling_a_1_player_1_extras = bowling_a_1_player_1_extras;
    }

    public String getBowling_a_1_player_1_maiden_overs() {
        return bowling_a_1_player_1_maiden_overs;
    }

    public void setBowling_a_1_player_1_maiden_overs(String bowling_a_1_player_1_maiden_overs) {
        this.bowling_a_1_player_1_maiden_overs = bowling_a_1_player_1_maiden_overs;
    }

    public String getBowling_a_1_player_1_overs() {
        return bowling_a_1_player_1_overs;
    }

    public void setBowling_a_1_player_1_overs(String bowling_a_1_player_1_overs) {
        this.bowling_a_1_player_1_overs = bowling_a_1_player_1_overs;
    }

    public String getBowling_a_2_player_1_name() {
        return bowling_a_2_player_1_name;
    }

    public void setBowling_a_2_player_1_name(String bowling_a_2_player_1_name) {
        this.bowling_a_2_player_1_name = bowling_a_2_player_1_name;
    }

    public String getBowling_a_2_player_1_economy() {
        return bowling_a_2_player_1_economy;
    }

    public void setBowling_a_2_player_1_economy(String bowling_a_2_player_1_economy) {
        this.bowling_a_2_player_1_economy = bowling_a_2_player_1_economy;
    }

    public String getBowling_a_2_player_1_runs() {
        return bowling_a_2_player_1_runs;
    }

    public void setBowling_a_2_player_1_runs(String bowling_a_2_player_1_runs) {
        this.bowling_a_2_player_1_runs = bowling_a_2_player_1_runs;
    }

    public String getBowling_a_2_player_1_dots() {
        return bowling_a_2_player_1_dots;
    }

    public void setBowling_a_2_player_1_dots(String bowling_a_2_player_1_dots) {
        this.bowling_a_2_player_1_dots = bowling_a_2_player_1_dots;
    }

    public String getBowling_a_2_player_1_balls() {
        return bowling_a_2_player_1_balls;
    }

    public void setBowling_a_2_player_1_balls(String bowling_a_2_player_1_balls) {
        this.bowling_a_2_player_1_balls = bowling_a_2_player_1_balls;
    }

    public String getBowling_a_2_player_1_wickets() {
        return bowling_a_2_player_1_wickets;
    }

    public void setBowling_a_2_player_1_wickets(String bowling_a_2_player_1_wickets) {
        this.bowling_a_2_player_1_wickets = bowling_a_2_player_1_wickets;
    }

    public String getBowling_a_2_player_1_extras() {
        return bowling_a_2_player_1_extras;
    }

    public void setBowling_a_2_player_1_extras(String bowling_a_2_player_1_extras) {
        this.bowling_a_2_player_1_extras = bowling_a_2_player_1_extras;
    }

    public String getBowling_a_2_player_1_maiden_overs() {
        return bowling_a_2_player_1_maiden_overs;
    }

    public void setBowling_a_2_player_1_maiden_overs(String bowling_a_2_player_1_maiden_overs) {
        this.bowling_a_2_player_1_maiden_overs = bowling_a_2_player_1_maiden_overs;
    }

    public String getBowling_a_2_player_1_overs() {
        return bowling_a_2_player_1_overs;
    }

    public void setBowling_a_2_player_1_overs(String bowling_a_2_player_1_overs) {
        this.bowling_a_2_player_1_overs = bowling_a_2_player_1_overs;
    }

    public String getBowling_b_1_player_1_name() {
        return bowling_b_1_player_1_name;
    }

    public void setBowling_b_1_player_1_name(String bowling_b_1_player_1_name) {
        this.bowling_b_1_player_1_name = bowling_b_1_player_1_name;
    }

    public String getBowling_b_1_player_1_economy() {
        return bowling_b_1_player_1_economy;
    }

    public void setBowling_b_1_player_1_economy(String bowling_b_1_player_1_economy) {
        this.bowling_b_1_player_1_economy = bowling_b_1_player_1_economy;
    }

    public String getBowling_b_1_player_1_runs() {
        return bowling_b_1_player_1_runs;
    }

    public void setBowling_b_1_player_1_runs(String bowling_b_1_player_1_runs) {
        this.bowling_b_1_player_1_runs = bowling_b_1_player_1_runs;
    }

    public String getBowling_b_1_player_1_dots() {
        return bowling_b_1_player_1_dots;
    }

    public void setBowling_b_1_player_1_dots(String bowling_b_1_player_1_dots) {
        this.bowling_b_1_player_1_dots = bowling_b_1_player_1_dots;
    }

    public String getBowling_b_1_player_1_balls() {
        return bowling_b_1_player_1_balls;
    }

    public void setBowling_b_1_player_1_balls(String bowling_b_1_player_1_balls) {
        this.bowling_b_1_player_1_balls = bowling_b_1_player_1_balls;
    }

    public String getBowling_b_1_player_1_wickets() {
        return bowling_b_1_player_1_wickets;
    }

    public void setBowling_b_1_player_1_wickets(String bowling_b_1_player_1_wickets) {
        this.bowling_b_1_player_1_wickets = bowling_b_1_player_1_wickets;
    }

    public String getBowling_b_1_player_1_extras() {
        return bowling_b_1_player_1_extras;
    }

    public void setBowling_b_1_player_1_extras(String bowling_b_1_player_1_extras) {
        this.bowling_b_1_player_1_extras = bowling_b_1_player_1_extras;
    }

    public String getBowling_b_1_player_1_maiden_overs() {
        return bowling_b_1_player_1_maiden_overs;
    }

    public void setBowling_b_1_player_1_maiden_overs(String bowling_b_1_player_1_maiden_overs) {
        this.bowling_b_1_player_1_maiden_overs = bowling_b_1_player_1_maiden_overs;
    }

    public String getBowling_b_1_player_1_overs() {
        return bowling_b_1_player_1_overs;
    }

    public void setBowling_b_1_player_1_overs(String bowling_b_1_player_1_overs) {
        this.bowling_b_1_player_1_overs = bowling_b_1_player_1_overs;
    }

    public String getBowling_b_2_player_1_name() {
        return bowling_b_2_player_1_name;
    }

    public void setBowling_b_2_player_1_name(String bowling_b_2_player_1_name) {
        this.bowling_b_2_player_1_name = bowling_b_2_player_1_name;
    }

    public String getBowling_b_2_player_1_economy() {
        return bowling_b_2_player_1_economy;
    }

    public void setBowling_b_2_player_1_economy(String bowling_b_2_player_1_economy) {
        this.bowling_b_2_player_1_economy = bowling_b_2_player_1_economy;
    }

    public String getBowling_b_2_player_1_runs() {
        return bowling_b_2_player_1_runs;
    }

    public void setBowling_b_2_player_1_runs(String bowling_b_2_player_1_runs) {
        this.bowling_b_2_player_1_runs = bowling_b_2_player_1_runs;
    }

    public String getBowling_b_2_player_1_dots() {
        return bowling_b_2_player_1_dots;
    }

    public void setBowling_b_2_player_1_dots(String bowling_b_2_player_1_dots) {
        this.bowling_b_2_player_1_dots = bowling_b_2_player_1_dots;
    }

    public String getBowling_b_2_player_1_balls() {
        return bowling_b_2_player_1_balls;
    }

    public void setBowling_b_2_player_1_balls(String bowling_b_2_player_1_balls) {
        this.bowling_b_2_player_1_balls = bowling_b_2_player_1_balls;
    }

    public String getBowling_b_2_player_1_wickets() {
        return bowling_b_2_player_1_wickets;
    }

    public void setBowling_b_2_player_1_wickets(String bowling_b_2_player_1_wickets) {
        this.bowling_b_2_player_1_wickets = bowling_b_2_player_1_wickets;
    }

    public String getBowling_b_2_player_1_extras() {
        return bowling_b_2_player_1_extras;
    }

    public void setBowling_b_2_player_1_extras(String bowling_b_2_player_1_extras) {
        this.bowling_b_2_player_1_extras = bowling_b_2_player_1_extras;
    }

    public String getBowling_b_2_player_1_maiden_overs() {
        return bowling_b_2_player_1_maiden_overs;
    }

    public void setBowling_b_2_player_1_maiden_overs(String bowling_b_2_player_1_maiden_overs) {
        this.bowling_b_2_player_1_maiden_overs = bowling_b_2_player_1_maiden_overs;
    }

    public String getBowling_b_2_player_1_overs() {
        return bowling_b_2_player_1_overs;
    }

    public void setBowling_b_2_player_1_overs(String bowling_b_2_player_1_overs) {
        this.bowling_b_2_player_1_overs = bowling_b_2_player_1_overs;
    }


    public String getBowling_a_1_player_2_name() {
        return bowling_a_1_player_2_name;
    }

    public void setBowling_a_1_player_2_name(String bowling_a_1_player_2_name) {
        this.bowling_a_1_player_2_name = bowling_a_1_player_2_name;
    }

    public String getBowling_a_1_player_2_economy() {
        return bowling_a_1_player_2_economy;
    }

    public void setBowling_a_1_player_2_economy(String bowling_a_1_player_2_economy) {
        this.bowling_a_1_player_2_economy = bowling_a_1_player_2_economy;
    }

    public String getBowling_a_1_player_2_runs() {
        return bowling_a_1_player_2_runs;
    }

    public void setBowling_a_1_player_2_runs(String bowling_a_1_player_2_runs) {
        this.bowling_a_1_player_2_runs = bowling_a_1_player_2_runs;
    }

    public String getBowling_a_1_player_2_dots() {
        return bowling_a_1_player_2_dots;
    }

    public void setBowling_a_1_player_2_dots(String bowling_a_1_player_2_dots) {
        this.bowling_a_1_player_2_dots = bowling_a_1_player_2_dots;
    }

    public String getBowling_a_1_player_2_balls() {
        return bowling_a_1_player_2_balls;
    }

    public void setBowling_a_1_player_2_balls(String bowling_a_1_player_2_balls) {
        this.bowling_a_1_player_2_balls = bowling_a_1_player_2_balls;
    }

    public String getBowling_a_1_player_2_wickets() {
        return bowling_a_1_player_2_wickets;
    }

    public void setBowling_a_1_player_2_wickets(String bowling_a_1_player_2_wickets) {
        this.bowling_a_1_player_2_wickets = bowling_a_1_player_2_wickets;
    }

    public String getBowling_a_1_player_2_extras() {
        return bowling_a_1_player_2_extras;
    }

    public void setBowling_a_1_player_2_extras(String bowling_a_1_player_2_extras) {
        this.bowling_a_1_player_2_extras = bowling_a_1_player_2_extras;
    }

    public String getBowling_a_1_player_2_maiden_overs() {
        return bowling_a_1_player_2_maiden_overs;
    }

    public void setBowling_a_1_player_2_maiden_overs(String bowling_a_1_player_2_maiden_overs) {
        this.bowling_a_1_player_2_maiden_overs = bowling_a_1_player_2_maiden_overs;
    }

    public String getBowling_a_1_player_2_overs() {
        return bowling_a_1_player_2_overs;
    }

    public void setBowling_a_1_player_2_overs(String bowling_a_1_player_2_overs) {
        this.bowling_a_1_player_2_overs = bowling_a_1_player_2_overs;
    }

    public String getBowling_a_2_player_2_name() {
        return bowling_a_2_player_2_name;
    }

    public void setBowling_a_2_player_2_name(String bowling_a_2_player_2_name) {
        this.bowling_a_2_player_2_name = bowling_a_2_player_2_name;
    }

    public String getBowling_a_2_player_2_economy() {
        return bowling_a_2_player_2_economy;
    }

    public void setBowling_a_2_player_2_economy(String bowling_a_2_player_2_economy) {
        this.bowling_a_2_player_2_economy = bowling_a_2_player_2_economy;
    }

    public String getBowling_a_2_player_2_runs() {
        return bowling_a_2_player_2_runs;
    }

    public void setBowling_a_2_player_2_runs(String bowling_a_2_player_2_runs) {
        this.bowling_a_2_player_2_runs = bowling_a_2_player_2_runs;
    }

    public String getBowling_a_2_player_2_dots() {
        return bowling_a_2_player_2_dots;
    }

    public void setBowling_a_2_player_2_dots(String bowling_a_2_player_2_dots) {
        this.bowling_a_2_player_2_dots = bowling_a_2_player_2_dots;
    }

    public String getBowling_a_2_player_2_balls() {
        return bowling_a_2_player_2_balls;
    }

    public void setBowling_a_2_player_2_balls(String bowling_a_2_player_2_balls) {
        this.bowling_a_2_player_2_balls = bowling_a_2_player_2_balls;
    }

    public String getBowling_a_2_player_2_wickets() {
        return bowling_a_2_player_2_wickets;
    }

    public void setBowling_a_2_player_2_wickets(String bowling_a_2_player_2_wickets) {
        this.bowling_a_2_player_2_wickets = bowling_a_2_player_2_wickets;
    }

    public String getBowling_a_2_player_2_extras() {
        return bowling_a_2_player_2_extras;
    }

    public void setBowling_a_2_player_2_extras(String bowling_a_2_player_2_extras) {
        this.bowling_a_2_player_2_extras = bowling_a_2_player_2_extras;
    }

    public String getBowling_a_2_player_2_maiden_overs() {
        return bowling_a_2_player_2_maiden_overs;
    }

    public void setBowling_a_2_player_2_maiden_overs(String bowling_a_2_player_2_maiden_overs) {
        this.bowling_a_2_player_2_maiden_overs = bowling_a_2_player_2_maiden_overs;
    }

    public String getBowling_a_2_player_2_overs() {
        return bowling_a_2_player_2_overs;
    }

    public void setBowling_a_2_player_2_overs(String bowling_a_2_player_2_overs) {
        this.bowling_a_2_player_2_overs = bowling_a_2_player_2_overs;
    }

    public String getBowling_b_1_player_2_name() {
        return bowling_b_1_player_2_name;
    }

    public void setBowling_b_1_player_2_name(String bowling_b_1_player_2_name) {
        this.bowling_b_1_player_2_name = bowling_b_1_player_2_name;
    }

    public String getBowling_b_1_player_2_economy() {
        return bowling_b_1_player_2_economy;
    }

    public void setBowling_b_1_player_2_economy(String bowling_b_1_player_2_economy) {
        this.bowling_b_1_player_2_economy = bowling_b_1_player_2_economy;
    }

    public String getBowling_b_1_player_2_runs() {
        return bowling_b_1_player_2_runs;
    }

    public void setBowling_b_1_player_2_runs(String bowling_b_1_player_2_runs) {
        this.bowling_b_1_player_2_runs = bowling_b_1_player_2_runs;
    }

    public String getBowling_b_1_player_2_dots() {
        return bowling_b_1_player_2_dots;
    }

    public void setBowling_b_1_player_2_dots(String bowling_b_1_player_2_dots) {
        this.bowling_b_1_player_2_dots = bowling_b_1_player_2_dots;
    }

    public String getBowling_b_1_player_2_balls() {
        return bowling_b_1_player_2_balls;
    }

    public void setBowling_b_1_player_2_balls(String bowling_b_1_player_2_balls) {
        this.bowling_b_1_player_2_balls = bowling_b_1_player_2_balls;
    }

    public String getBowling_b_1_player_2_wickets() {
        return bowling_b_1_player_2_wickets;
    }

    public void setBowling_b_1_player_2_wickets(String bowling_b_1_player_2_wickets) {
        this.bowling_b_1_player_2_wickets = bowling_b_1_player_2_wickets;
    }

    public String getBowling_b_1_player_2_extras() {
        return bowling_b_1_player_2_extras;
    }

    public void setBowling_b_1_player_2_extras(String bowling_b_1_player_2_extras) {
        this.bowling_b_1_player_2_extras = bowling_b_1_player_2_extras;
    }

    public String getBowling_b_1_player_2_maiden_overs() {
        return bowling_b_1_player_2_maiden_overs;
    }

    public void setBowling_b_1_player_2_maiden_overs(String bowling_b_1_player_2_maiden_overs) {
        this.bowling_b_1_player_2_maiden_overs = bowling_b_1_player_2_maiden_overs;
    }

    public String getBowling_b_1_player_2_overs() {
        return bowling_b_1_player_2_overs;
    }

    public void setBowling_b_1_player_2_overs(String bowling_b_1_player_2_overs) {
        this.bowling_b_1_player_2_overs = bowling_b_1_player_2_overs;
    }

    public String getBowling_b_2_player_2_name() {
        return bowling_b_2_player_2_name;
    }

    public void setBowling_b_2_player_2_name(String bowling_b_2_player_2_name) {
        this.bowling_b_2_player_2_name = bowling_b_2_player_2_name;
    }

    public String getBowling_b_2_player_2_economy() {
        return bowling_b_2_player_2_economy;
    }

    public void setBowling_b_2_player_2_economy(String bowling_b_2_player_2_economy) {
        this.bowling_b_2_player_2_economy = bowling_b_2_player_2_economy;
    }

    public String getBowling_b_2_player_2_runs() {
        return bowling_b_2_player_2_runs;
    }

    public void setBowling_b_2_player_2_runs(String bowling_b_2_player_2_runs) {
        this.bowling_b_2_player_2_runs = bowling_b_2_player_2_runs;
    }

    public String getBowling_b_2_player_2_dots() {
        return bowling_b_2_player_2_dots;
    }

    public void setBowling_b_2_player_2_dots(String bowling_b_2_player_2_dots) {
        this.bowling_b_2_player_2_dots = bowling_b_2_player_2_dots;
    }

    public String getBowling_b_2_player_2_balls() {
        return bowling_b_2_player_2_balls;
    }

    public void setBowling_b_2_player_2_balls(String bowling_b_2_player_2_balls) {
        this.bowling_b_2_player_2_balls = bowling_b_2_player_2_balls;
    }

    public String getBowling_b_2_player_2_wickets() {
        return bowling_b_2_player_2_wickets;
    }

    public void setBowling_b_2_player_2_wickets(String bowling_b_2_player_2_wickets) {
        this.bowling_b_2_player_2_wickets = bowling_b_2_player_2_wickets;
    }

    public String getBowling_b_2_player_2_extras() {
        return bowling_b_2_player_2_extras;
    }

    public void setBowling_b_2_player_2_extras(String bowling_b_2_player_2_extras) {
        this.bowling_b_2_player_2_extras = bowling_b_2_player_2_extras;
    }

    public String getBowling_b_2_player_2_maiden_overs() {
        return bowling_b_2_player_2_maiden_overs;
    }

    public void setBowling_b_2_player_2_maiden_overs(String bowling_b_2_player_2_maiden_overs) {
        this.bowling_b_2_player_2_maiden_overs = bowling_b_2_player_2_maiden_overs;
    }

    public String getBowling_b_2_player_2_overs() {
        return bowling_b_2_player_2_overs;
    }

    public void setBowling_b_2_player_2_overs(String bowling_b_2_player_2_overs) {
        this.bowling_b_2_player_2_overs = bowling_b_2_player_2_overs;
    }

    public String getBowling_a_1_player_3_name() {
        return bowling_a_1_player_3_name;
    }

    public void setBowling_a_1_player_3_name(String bowling_a_1_player_3_name) {
        this.bowling_a_1_player_3_name = bowling_a_1_player_3_name;
    }

    public String getBowling_a_1_player_3_economy() {
        return bowling_a_1_player_3_economy;
    }

    public void setBowling_a_1_player_3_economy(String bowling_a_1_player_3_economy) {
        this.bowling_a_1_player_3_economy = bowling_a_1_player_3_economy;
    }

    public String getBowling_a_1_player_3_runs() {
        return bowling_a_1_player_3_runs;
    }

    public void setBowling_a_1_player_3_runs(String bowling_a_1_player_3_runs) {
        this.bowling_a_1_player_3_runs = bowling_a_1_player_3_runs;
    }

    public String getBowling_a_1_player_3_dots() {
        return bowling_a_1_player_3_dots;
    }

    public void setBowling_a_1_player_3_dots(String bowling_a_1_player_3_dots) {
        this.bowling_a_1_player_3_dots = bowling_a_1_player_3_dots;
    }

    public String getBowling_a_1_player_3_balls() {
        return bowling_a_1_player_3_balls;
    }

    public void setBowling_a_1_player_3_balls(String bowling_a_1_player_3_balls) {
        this.bowling_a_1_player_3_balls = bowling_a_1_player_3_balls;
    }

    public String getBowling_a_1_player_3_wickets() {
        return bowling_a_1_player_3_wickets;
    }

    public void setBowling_a_1_player_3_wickets(String bowling_a_1_player_3_wickets) {
        this.bowling_a_1_player_3_wickets = bowling_a_1_player_3_wickets;
    }

    public String getBowling_a_1_player_3_extras() {
        return bowling_a_1_player_3_extras;
    }

    public void setBowling_a_1_player_3_extras(String bowling_a_1_player_3_extras) {
        this.bowling_a_1_player_3_extras = bowling_a_1_player_3_extras;
    }

    public String getBowling_a_1_player_3_maiden_overs() {
        return bowling_a_1_player_3_maiden_overs;
    }

    public void setBowling_a_1_player_3_maiden_overs(String bowling_a_1_player_3_maiden_overs) {
        this.bowling_a_1_player_3_maiden_overs = bowling_a_1_player_3_maiden_overs;
    }

    public String getBowling_a_1_player_3_overs() {
        return bowling_a_1_player_3_overs;
    }

    public void setBowling_a_1_player_3_overs(String bowling_a_1_player_3_overs) {
        this.bowling_a_1_player_3_overs = bowling_a_1_player_3_overs;
    }

    public String getBowling_a_2_player_3_name() {
        return bowling_a_2_player_3_name;
    }

    public void setBowling_a_2_player_3_name(String bowling_a_2_player_3_name) {
        this.bowling_a_2_player_3_name = bowling_a_2_player_3_name;
    }

    public String getBowling_a_2_player_3_economy() {
        return bowling_a_2_player_3_economy;
    }

    public void setBowling_a_2_player_3_economy(String bowling_a_2_player_3_economy) {
        this.bowling_a_2_player_3_economy = bowling_a_2_player_3_economy;
    }

    public String getBowling_a_2_player_3_runs() {
        return bowling_a_2_player_3_runs;
    }

    public void setBowling_a_2_player_3_runs(String bowling_a_2_player_3_runs) {
        this.bowling_a_2_player_3_runs = bowling_a_2_player_3_runs;
    }

    public String getBowling_a_2_player_3_dots() {
        return bowling_a_2_player_3_dots;
    }

    public void setBowling_a_2_player_3_dots(String bowling_a_2_player_3_dots) {
        this.bowling_a_2_player_3_dots = bowling_a_2_player_3_dots;
    }

    public String getBowling_a_2_player_3_balls() {
        return bowling_a_2_player_3_balls;
    }

    public void setBowling_a_2_player_3_balls(String bowling_a_2_player_3_balls) {
        this.bowling_a_2_player_3_balls = bowling_a_2_player_3_balls;
    }

    public String getBowling_a_2_player_3_wickets() {
        return bowling_a_2_player_3_wickets;
    }

    public void setBowling_a_2_player_3_wickets(String bowling_a_2_player_3_wickets) {
        this.bowling_a_2_player_3_wickets = bowling_a_2_player_3_wickets;
    }

    public String getBowling_a_2_player_3_extras() {
        return bowling_a_2_player_3_extras;
    }

    public void setBowling_a_2_player_3_extras(String bowling_a_2_player_3_extras) {
        this.bowling_a_2_player_3_extras = bowling_a_2_player_3_extras;
    }

    public String getBowling_a_2_player_3_maiden_overs() {
        return bowling_a_2_player_3_maiden_overs;
    }

    public void setBowling_a_2_player_3_maiden_overs(String bowling_a_2_player_3_maiden_overs) {
        this.bowling_a_2_player_3_maiden_overs = bowling_a_2_player_3_maiden_overs;
    }

    public String getBowling_a_2_player_3_overs() {
        return bowling_a_2_player_3_overs;
    }

    public void setBowling_a_2_player_3_overs(String bowling_a_2_player_3_overs) {
        this.bowling_a_2_player_3_overs = bowling_a_2_player_3_overs;
    }

    public String getBowling_b_1_player_3_name() {
        return bowling_b_1_player_3_name;
    }

    public void setBowling_b_1_player_3_name(String bowling_b_1_player_3_name) {
        this.bowling_b_1_player_3_name = bowling_b_1_player_3_name;
    }

    public String getBowling_b_1_player_3_economy() {
        return bowling_b_1_player_3_economy;
    }

    public void setBowling_b_1_player_3_economy(String bowling_b_1_player_3_economy) {
        this.bowling_b_1_player_3_economy = bowling_b_1_player_3_economy;
    }

    public String getBowling_b_1_player_3_runs() {
        return bowling_b_1_player_3_runs;
    }

    public void setBowling_b_1_player_3_runs(String bowling_b_1_player_3_runs) {
        this.bowling_b_1_player_3_runs = bowling_b_1_player_3_runs;
    }

    public String getBowling_b_1_player_3_dots() {
        return bowling_b_1_player_3_dots;
    }

    public void setBowling_b_1_player_3_dots(String bowling_b_1_player_3_dots) {
        this.bowling_b_1_player_3_dots = bowling_b_1_player_3_dots;
    }

    public String getBowling_b_1_player_3_balls() {
        return bowling_b_1_player_3_balls;
    }

    public void setBowling_b_1_player_3_balls(String bowling_b_1_player_3_balls) {
        this.bowling_b_1_player_3_balls = bowling_b_1_player_3_balls;
    }

    public String getBowling_b_1_player_3_wickets() {
        return bowling_b_1_player_3_wickets;
    }

    public void setBowling_b_1_player_3_wickets(String bowling_b_1_player_3_wickets) {
        this.bowling_b_1_player_3_wickets = bowling_b_1_player_3_wickets;
    }

    public String getBowling_b_1_player_3_extras() {
        return bowling_b_1_player_3_extras;
    }

    public void setBowling_b_1_player_3_extras(String bowling_b_1_player_3_extras) {
        this.bowling_b_1_player_3_extras = bowling_b_1_player_3_extras;
    }

    public String getBowling_b_1_player_3_maiden_overs() {
        return bowling_b_1_player_3_maiden_overs;
    }

    public void setBowling_b_1_player_3_maiden_overs(String bowling_b_1_player_3_maiden_overs) {
        this.bowling_b_1_player_3_maiden_overs = bowling_b_1_player_3_maiden_overs;
    }

    public String getBowling_b_1_player_3_overs() {
        return bowling_b_1_player_3_overs;
    }

    public void setBowling_b_1_player_3_overs(String bowling_b_1_player_3_overs) {
        this.bowling_b_1_player_3_overs = bowling_b_1_player_3_overs;
    }

    public String getBowling_b_2_player_3_name() {
        return bowling_b_2_player_3_name;
    }

    public void setBowling_b_2_player_3_name(String bowling_b_2_player_3_name) {
        this.bowling_b_2_player_3_name = bowling_b_2_player_3_name;
    }

    public String getBowling_b_2_player_3_economy() {
        return bowling_b_2_player_3_economy;
    }

    public void setBowling_b_2_player_3_economy(String bowling_b_2_player_3_economy) {
        this.bowling_b_2_player_3_economy = bowling_b_2_player_3_economy;
    }

    public String getBowling_b_2_player_3_runs() {
        return bowling_b_2_player_3_runs;
    }

    public void setBowling_b_2_player_3_runs(String bowling_b_2_player_3_runs) {
        this.bowling_b_2_player_3_runs = bowling_b_2_player_3_runs;
    }

    public String getBowling_b_2_player_3_dots() {
        return bowling_b_2_player_3_dots;
    }

    public void setBowling_b_2_player_3_dots(String bowling_b_2_player_3_dots) {
        this.bowling_b_2_player_3_dots = bowling_b_2_player_3_dots;
    }

    public String getBowling_b_2_player_3_balls() {
        return bowling_b_2_player_3_balls;
    }

    public void setBowling_b_2_player_3_balls(String bowling_b_2_player_3_balls) {
        this.bowling_b_2_player_3_balls = bowling_b_2_player_3_balls;
    }

    public String getBowling_b_2_player_3_wickets() {
        return bowling_b_2_player_3_wickets;
    }

    public void setBowling_b_2_player_3_wickets(String bowling_b_2_player_3_wickets) {
        this.bowling_b_2_player_3_wickets = bowling_b_2_player_3_wickets;
    }

    public String getBowling_b_2_player_3_extras() {
        return bowling_b_2_player_3_extras;
    }

    public void setBowling_b_2_player_3_extras(String bowling_b_2_player_3_extras) {
        this.bowling_b_2_player_3_extras = bowling_b_2_player_3_extras;
    }

    public String getBowling_b_2_player_3_maiden_overs() {
        return bowling_b_2_player_3_maiden_overs;
    }

    public void setBowling_b_2_player_3_maiden_overs(String bowling_b_2_player_3_maiden_overs) {
        this.bowling_b_2_player_3_maiden_overs = bowling_b_2_player_3_maiden_overs;
    }

    public String getBowling_b_2_player_3_overs() {
        return bowling_b_2_player_3_overs;
    }

    public void setBowling_b_2_player_3_overs(String bowling_b_2_player_3_overs) {
        this.bowling_b_2_player_3_overs = bowling_b_2_player_3_overs;
    }

    public String getBowling_a_1_player_4_name() {
        return bowling_a_1_player_4_name;
    }

    public void setBowling_a_1_player_4_name(String bowling_a_1_player_4_name) {
        this.bowling_a_1_player_4_name = bowling_a_1_player_4_name;
    }

    public String getBowling_a_1_player_4_economy() {
        return bowling_a_1_player_4_economy;
    }

    public void setBowling_a_1_player_4_economy(String bowling_a_1_player_4_economy) {
        this.bowling_a_1_player_4_economy = bowling_a_1_player_4_economy;
    }

    public String getBowling_a_1_player_4_runs() {
        return bowling_a_1_player_4_runs;
    }

    public void setBowling_a_1_player_4_runs(String bowling_a_1_player_4_runs) {
        this.bowling_a_1_player_4_runs = bowling_a_1_player_4_runs;
    }

    public String getBowling_a_1_player_4_dots() {
        return bowling_a_1_player_4_dots;
    }

    public void setBowling_a_1_player_4_dots(String bowling_a_1_player_4_dots) {
        this.bowling_a_1_player_4_dots = bowling_a_1_player_4_dots;
    }

    public String getBowling_a_1_player_4_balls() {
        return bowling_a_1_player_4_balls;
    }

    public void setBowling_a_1_player_4_balls(String bowling_a_1_player_4_balls) {
        this.bowling_a_1_player_4_balls = bowling_a_1_player_4_balls;
    }

    public String getBowling_a_1_player_4_wickets() {
        return bowling_a_1_player_4_wickets;
    }

    public void setBowling_a_1_player_4_wickets(String bowling_a_1_player_4_wickets) {
        this.bowling_a_1_player_4_wickets = bowling_a_1_player_4_wickets;
    }

    public String getBowling_a_1_player_4_extras() {
        return bowling_a_1_player_4_extras;
    }

    public void setBowling_a_1_player_4_extras(String bowling_a_1_player_4_extras) {
        this.bowling_a_1_player_4_extras = bowling_a_1_player_4_extras;
    }

    public String getBowling_a_1_player_4_maiden_overs() {
        return bowling_a_1_player_4_maiden_overs;
    }

    public void setBowling_a_1_player_4_maiden_overs(String bowling_a_1_player_4_maiden_overs) {
        this.bowling_a_1_player_4_maiden_overs = bowling_a_1_player_4_maiden_overs;
    }

    public String getBowling_a_1_player_4_overs() {
        return bowling_a_1_player_4_overs;
    }

    public void setBowling_a_1_player_4_overs(String bowling_a_1_player_4_overs) {
        this.bowling_a_1_player_4_overs = bowling_a_1_player_4_overs;
    }

    public String getBowling_a_2_player_4_name() {
        return bowling_a_2_player_4_name;
    }

    public void setBowling_a_2_player_4_name(String bowling_a_2_player_4_name) {
        this.bowling_a_2_player_4_name = bowling_a_2_player_4_name;
    }

    public String getBowling_a_2_player_4_economy() {
        return bowling_a_2_player_4_economy;
    }

    public void setBowling_a_2_player_4_economy(String bowling_a_2_player_4_economy) {
        this.bowling_a_2_player_4_economy = bowling_a_2_player_4_economy;
    }

    public String getBowling_a_2_player_4_runs() {
        return bowling_a_2_player_4_runs;
    }

    public void setBowling_a_2_player_4_runs(String bowling_a_2_player_4_runs) {
        this.bowling_a_2_player_4_runs = bowling_a_2_player_4_runs;
    }

    public String getBowling_a_2_player_4_dots() {
        return bowling_a_2_player_4_dots;
    }

    public void setBowling_a_2_player_4_dots(String bowling_a_2_player_4_dots) {
        this.bowling_a_2_player_4_dots = bowling_a_2_player_4_dots;
    }

    public String getBowling_a_2_player_4_balls() {
        return bowling_a_2_player_4_balls;
    }

    public void setBowling_a_2_player_4_balls(String bowling_a_2_player_4_balls) {
        this.bowling_a_2_player_4_balls = bowling_a_2_player_4_balls;
    }

    public String getBowling_a_2_player_4_wickets() {
        return bowling_a_2_player_4_wickets;
    }

    public void setBowling_a_2_player_4_wickets(String bowling_a_2_player_4_wickets) {
        this.bowling_a_2_player_4_wickets = bowling_a_2_player_4_wickets;
    }

    public String getBowling_a_2_player_4_extras() {
        return bowling_a_2_player_4_extras;
    }

    public void setBowling_a_2_player_4_extras(String bowling_a_2_player_4_extras) {
        this.bowling_a_2_player_4_extras = bowling_a_2_player_4_extras;
    }

    public String getBowling_a_2_player_4_maiden_overs() {
        return bowling_a_2_player_4_maiden_overs;
    }

    public void setBowling_a_2_player_4_maiden_overs(String bowling_a_2_player_4_maiden_overs) {
        this.bowling_a_2_player_4_maiden_overs = bowling_a_2_player_4_maiden_overs;
    }

    public String getBowling_a_2_player_4_overs() {
        return bowling_a_2_player_4_overs;
    }

    public void setBowling_a_2_player_4_overs(String bowling_a_2_player_4_overs) {
        this.bowling_a_2_player_4_overs = bowling_a_2_player_4_overs;
    }

    public String getBowling_b_1_player_4_name() {
        return bowling_b_1_player_4_name;
    }

    public void setBowling_b_1_player_4_name(String bowling_b_1_player_4_name) {
        this.bowling_b_1_player_4_name = bowling_b_1_player_4_name;
    }

    public String getBowling_b_1_player_4_economy() {
        return bowling_b_1_player_4_economy;
    }

    public void setBowling_b_1_player_4_economy(String bowling_b_1_player_4_economy) {
        this.bowling_b_1_player_4_economy = bowling_b_1_player_4_economy;
    }

    public String getBowling_b_1_player_4_runs() {
        return bowling_b_1_player_4_runs;
    }

    public void setBowling_b_1_player_4_runs(String bowling_b_1_player_4_runs) {
        this.bowling_b_1_player_4_runs = bowling_b_1_player_4_runs;
    }

    public String getBowling_b_1_player_4_dots() {
        return bowling_b_1_player_4_dots;
    }

    public void setBowling_b_1_player_4_dots(String bowling_b_1_player_4_dots) {
        this.bowling_b_1_player_4_dots = bowling_b_1_player_4_dots;
    }

    public String getBowling_b_1_player_4_balls() {
        return bowling_b_1_player_4_balls;
    }

    public void setBowling_b_1_player_4_balls(String bowling_b_1_player_4_balls) {
        this.bowling_b_1_player_4_balls = bowling_b_1_player_4_balls;
    }

    public String getBowling_b_1_player_4_wickets() {
        return bowling_b_1_player_4_wickets;
    }

    public void setBowling_b_1_player_4_wickets(String bowling_b_1_player_4_wickets) {
        this.bowling_b_1_player_4_wickets = bowling_b_1_player_4_wickets;
    }

    public String getBowling_b_1_player_4_extras() {
        return bowling_b_1_player_4_extras;
    }

    public void setBowling_b_1_player_4_extras(String bowling_b_1_player_4_extras) {
        this.bowling_b_1_player_4_extras = bowling_b_1_player_4_extras;
    }

    public String getBowling_b_1_player_4_maiden_overs() {
        return bowling_b_1_player_4_maiden_overs;
    }

    public void setBowling_b_1_player_4_maiden_overs(String bowling_b_1_player_4_maiden_overs) {
        this.bowling_b_1_player_4_maiden_overs = bowling_b_1_player_4_maiden_overs;
    }

    public String getBowling_b_1_player_4_overs() {
        return bowling_b_1_player_4_overs;
    }

    public void setBowling_b_1_player_4_overs(String bowling_b_1_player_4_overs) {
        this.bowling_b_1_player_4_overs = bowling_b_1_player_4_overs;
    }

    public String getBowling_b_2_player_4_name() {
        return bowling_b_2_player_4_name;
    }

    public void setBowling_b_2_player_4_name(String bowling_b_2_player_4_name) {
        this.bowling_b_2_player_4_name = bowling_b_2_player_4_name;
    }

    public String getBowling_b_2_player_4_economy() {
        return bowling_b_2_player_4_economy;
    }

    public void setBowling_b_2_player_4_economy(String bowling_b_2_player_4_economy) {
        this.bowling_b_2_player_4_economy = bowling_b_2_player_4_economy;
    }

    public String getBowling_b_2_player_4_runs() {
        return bowling_b_2_player_4_runs;
    }

    public void setBowling_b_2_player_4_runs(String bowling_b_2_player_4_runs) {
        this.bowling_b_2_player_4_runs = bowling_b_2_player_4_runs;
    }

    public String getBowling_b_2_player_4_dots() {
        return bowling_b_2_player_4_dots;
    }

    public void setBowling_b_2_player_4_dots(String bowling_b_2_player_4_dots) {
        this.bowling_b_2_player_4_dots = bowling_b_2_player_4_dots;
    }

    public String getBowling_b_2_player_4_balls() {
        return bowling_b_2_player_4_balls;
    }

    public void setBowling_b_2_player_4_balls(String bowling_b_2_player_4_balls) {
        this.bowling_b_2_player_4_balls = bowling_b_2_player_4_balls;
    }

    public String getBowling_b_2_player_4_wickets() {
        return bowling_b_2_player_4_wickets;
    }

    public void setBowling_b_2_player_4_wickets(String bowling_b_2_player_4_wickets) {
        this.bowling_b_2_player_4_wickets = bowling_b_2_player_4_wickets;
    }

    public String getBowling_b_2_player_4_extras() {
        return bowling_b_2_player_4_extras;
    }

    public void setBowling_b_2_player_4_extras(String bowling_b_2_player_4_extras) {
        this.bowling_b_2_player_4_extras = bowling_b_2_player_4_extras;
    }

    public String getBowling_b_2_player_4_maiden_overs() {
        return bowling_b_2_player_4_maiden_overs;
    }

    public void setBowling_b_2_player_4_maiden_overs(String bowling_b_2_player_4_maiden_overs) {
        this.bowling_b_2_player_4_maiden_overs = bowling_b_2_player_4_maiden_overs;
    }

    public String getBowling_b_2_player_4_overs() {
        return bowling_b_2_player_4_overs;
    }

    public void setBowling_b_2_player_4_overs(String bowling_b_2_player_4_overs) {
        this.bowling_b_2_player_4_overs = bowling_b_2_player_4_overs;
    }

    public String getBowling_a_1_player_5_name() {
        return bowling_a_1_player_5_name;
    }

    public void setBowling_a_1_player_5_name(String bowling_a_1_player_5_name) {
        this.bowling_a_1_player_5_name = bowling_a_1_player_5_name;
    }

    public String getBowling_a_1_player_5_economy() {
        return bowling_a_1_player_5_economy;
    }

    public void setBowling_a_1_player_5_economy(String bowling_a_1_player_5_economy) {
        this.bowling_a_1_player_5_economy = bowling_a_1_player_5_economy;
    }

    public String getBowling_a_1_player_5_runs() {
        return bowling_a_1_player_5_runs;
    }

    public void setBowling_a_1_player_5_runs(String bowling_a_1_player_5_runs) {
        this.bowling_a_1_player_5_runs = bowling_a_1_player_5_runs;
    }

    public String getBowling_a_1_player_5_dots() {
        return bowling_a_1_player_5_dots;
    }

    public void setBowling_a_1_player_5_dots(String bowling_a_1_player_5_dots) {
        this.bowling_a_1_player_5_dots = bowling_a_1_player_5_dots;
    }

    public String getBowling_a_1_player_5_balls() {
        return bowling_a_1_player_5_balls;
    }

    public void setBowling_a_1_player_5_balls(String bowling_a_1_player_5_balls) {
        this.bowling_a_1_player_5_balls = bowling_a_1_player_5_balls;
    }

    public String getBowling_a_1_player_5_wickets() {
        return bowling_a_1_player_5_wickets;
    }

    public void setBowling_a_1_player_5_wickets(String bowling_a_1_player_5_wickets) {
        this.bowling_a_1_player_5_wickets = bowling_a_1_player_5_wickets;
    }

    public String getBowling_a_1_player_5_extras() {
        return bowling_a_1_player_5_extras;
    }

    public void setBowling_a_1_player_5_extras(String bowling_a_1_player_5_extras) {
        this.bowling_a_1_player_5_extras = bowling_a_1_player_5_extras;
    }

    public String getBowling_a_1_player_5_maiden_overs() {
        return bowling_a_1_player_5_maiden_overs;
    }

    public void setBowling_a_1_player_5_maiden_overs(String bowling_a_1_player_5_maiden_overs) {
        this.bowling_a_1_player_5_maiden_overs = bowling_a_1_player_5_maiden_overs;
    }

    public String getBowling_a_1_player_5_overs() {
        return bowling_a_1_player_5_overs;
    }

    public void setBowling_a_1_player_5_overs(String bowling_a_1_player_5_overs) {
        this.bowling_a_1_player_5_overs = bowling_a_1_player_5_overs;
    }

    public String getBowling_a_2_player_5_name() {
        return bowling_a_2_player_5_name;
    }

    public void setBowling_a_2_player_5_name(String bowling_a_2_player_5_name) {
        this.bowling_a_2_player_5_name = bowling_a_2_player_5_name;
    }

    public String getBowling_a_2_player_5_economy() {
        return bowling_a_2_player_5_economy;
    }

    public void setBowling_a_2_player_5_economy(String bowling_a_2_player_5_economy) {
        this.bowling_a_2_player_5_economy = bowling_a_2_player_5_economy;
    }

    public String getBowling_a_2_player_5_runs() {
        return bowling_a_2_player_5_runs;
    }

    public void setBowling_a_2_player_5_runs(String bowling_a_2_player_5_runs) {
        this.bowling_a_2_player_5_runs = bowling_a_2_player_5_runs;
    }

    public String getBowling_a_2_player_5_dots() {
        return bowling_a_2_player_5_dots;
    }

    public void setBowling_a_2_player_5_dots(String bowling_a_2_player_5_dots) {
        this.bowling_a_2_player_5_dots = bowling_a_2_player_5_dots;
    }

    public String getBowling_a_2_player_5_balls() {
        return bowling_a_2_player_5_balls;
    }

    public void setBowling_a_2_player_5_balls(String bowling_a_2_player_5_balls) {
        this.bowling_a_2_player_5_balls = bowling_a_2_player_5_balls;
    }

    public String getBowling_a_2_player_5_wickets() {
        return bowling_a_2_player_5_wickets;
    }

    public void setBowling_a_2_player_5_wickets(String bowling_a_2_player_5_wickets) {
        this.bowling_a_2_player_5_wickets = bowling_a_2_player_5_wickets;
    }

    public String getBowling_a_2_player_5_extras() {
        return bowling_a_2_player_5_extras;
    }

    public void setBowling_a_2_player_5_extras(String bowling_a_2_player_5_extras) {
        this.bowling_a_2_player_5_extras = bowling_a_2_player_5_extras;
    }

    public String getBowling_a_2_player_5_maiden_overs() {
        return bowling_a_2_player_5_maiden_overs;
    }

    public void setBowling_a_2_player_5_maiden_overs(String bowling_a_2_player_5_maiden_overs) {
        this.bowling_a_2_player_5_maiden_overs = bowling_a_2_player_5_maiden_overs;
    }

    public String getBowling_a_2_player_5_overs() {
        return bowling_a_2_player_5_overs;
    }

    public void setBowling_a_2_player_5_overs(String bowling_a_2_player_5_overs) {
        this.bowling_a_2_player_5_overs = bowling_a_2_player_5_overs;
    }

    public String getBowling_b_1_player_5_name() {
        return bowling_b_1_player_5_name;
    }

    public void setBowling_b_1_player_5_name(String bowling_b_1_player_5_name) {
        this.bowling_b_1_player_5_name = bowling_b_1_player_5_name;
    }

    public String getBowling_b_1_player_5_economy() {
        return bowling_b_1_player_5_economy;
    }

    public void setBowling_b_1_player_5_economy(String bowling_b_1_player_5_economy) {
        this.bowling_b_1_player_5_economy = bowling_b_1_player_5_economy;
    }

    public String getBowling_b_1_player_5_runs() {
        return bowling_b_1_player_5_runs;
    }

    public void setBowling_b_1_player_5_runs(String bowling_b_1_player_5_runs) {
        this.bowling_b_1_player_5_runs = bowling_b_1_player_5_runs;
    }

    public String getBowling_b_1_player_5_dots() {
        return bowling_b_1_player_5_dots;
    }

    public void setBowling_b_1_player_5_dots(String bowling_b_1_player_5_dots) {
        this.bowling_b_1_player_5_dots = bowling_b_1_player_5_dots;
    }

    public String getBowling_b_1_player_5_balls() {
        return bowling_b_1_player_5_balls;
    }

    public void setBowling_b_1_player_5_balls(String bowling_b_1_player_5_balls) {
        this.bowling_b_1_player_5_balls = bowling_b_1_player_5_balls;
    }

    public String getBowling_b_1_player_5_wickets() {
        return bowling_b_1_player_5_wickets;
    }

    public void setBowling_b_1_player_5_wickets(String bowling_b_1_player_5_wickets) {
        this.bowling_b_1_player_5_wickets = bowling_b_1_player_5_wickets;
    }

    public String getBowling_b_1_player_5_extras() {
        return bowling_b_1_player_5_extras;
    }

    public void setBowling_b_1_player_5_extras(String bowling_b_1_player_5_extras) {
        this.bowling_b_1_player_5_extras = bowling_b_1_player_5_extras;
    }

    public String getBowling_b_1_player_5_maiden_overs() {
        return bowling_b_1_player_5_maiden_overs;
    }

    public void setBowling_b_1_player_5_maiden_overs(String bowling_b_1_player_5_maiden_overs) {
        this.bowling_b_1_player_5_maiden_overs = bowling_b_1_player_5_maiden_overs;
    }

    public String getBowling_b_1_player_5_overs() {
        return bowling_b_1_player_5_overs;
    }

    public void setBowling_b_1_player_5_overs(String bowling_b_1_player_5_overs) {
        this.bowling_b_1_player_5_overs = bowling_b_1_player_5_overs;
    }

    public String getBowling_b_2_player_5_name() {
        return bowling_b_2_player_5_name;
    }

    public void setBowling_b_2_player_5_name(String bowling_b_2_player_5_name) {
        this.bowling_b_2_player_5_name = bowling_b_2_player_5_name;
    }

    public String getBowling_b_2_player_5_economy() {
        return bowling_b_2_player_5_economy;
    }

    public void setBowling_b_2_player_5_economy(String bowling_b_2_player_5_economy) {
        this.bowling_b_2_player_5_economy = bowling_b_2_player_5_economy;
    }

    public String getBowling_b_2_player_5_runs() {
        return bowling_b_2_player_5_runs;
    }

    public void setBowling_b_2_player_5_runs(String bowling_b_2_player_5_runs) {
        this.bowling_b_2_player_5_runs = bowling_b_2_player_5_runs;
    }

    public String getBowling_b_2_player_5_dots() {
        return bowling_b_2_player_5_dots;
    }

    public void setBowling_b_2_player_5_dots(String bowling_b_2_player_5_dots) {
        this.bowling_b_2_player_5_dots = bowling_b_2_player_5_dots;
    }

    public String getBowling_b_2_player_5_balls() {
        return bowling_b_2_player_5_balls;
    }

    public void setBowling_b_2_player_5_balls(String bowling_b_2_player_5_balls) {
        this.bowling_b_2_player_5_balls = bowling_b_2_player_5_balls;
    }

    public String getBowling_b_2_player_5_wickets() {
        return bowling_b_2_player_5_wickets;
    }

    public void setBowling_b_2_player_5_wickets(String bowling_b_2_player_5_wickets) {
        this.bowling_b_2_player_5_wickets = bowling_b_2_player_5_wickets;
    }

    public String getBowling_b_2_player_5_extras() {
        return bowling_b_2_player_5_extras;
    }

    public void setBowling_b_2_player_5_extras(String bowling_b_2_player_5_extras) {
        this.bowling_b_2_player_5_extras = bowling_b_2_player_5_extras;
    }

    public String getBowling_b_2_player_5_maiden_overs() {
        return bowling_b_2_player_5_maiden_overs;
    }

    public void setBowling_b_2_player_5_maiden_overs(String bowling_b_2_player_5_maiden_overs) {
        this.bowling_b_2_player_5_maiden_overs = bowling_b_2_player_5_maiden_overs;
    }

    public String getBowling_b_2_player_5_overs() {
        return bowling_b_2_player_5_overs;
    }

    public void setBowling_b_2_player_5_overs(String bowling_b_2_player_5_overs) {
        this.bowling_b_2_player_5_overs = bowling_b_2_player_5_overs;
    }

    public String getBowling_a_1_player_6_name() {
        return bowling_a_1_player_6_name;
    }

    public void setBowling_a_1_player_6_name(String bowling_a_1_player_6_name) {
        this.bowling_a_1_player_6_name = bowling_a_1_player_6_name;
    }

    public String getBowling_a_1_player_6_economy() {
        return bowling_a_1_player_6_economy;
    }

    public void setBowling_a_1_player_6_economy(String bowling_a_1_player_6_economy) {
        this.bowling_a_1_player_6_economy = bowling_a_1_player_6_economy;
    }

    public String getBowling_a_1_player_6_runs() {
        return bowling_a_1_player_6_runs;
    }

    public void setBowling_a_1_player_6_runs(String bowling_a_1_player_6_runs) {
        this.bowling_a_1_player_6_runs = bowling_a_1_player_6_runs;
    }

    public String getBowling_a_1_player_6_dots() {
        return bowling_a_1_player_6_dots;
    }

    public void setBowling_a_1_player_6_dots(String bowling_a_1_player_6_dots) {
        this.bowling_a_1_player_6_dots = bowling_a_1_player_6_dots;
    }

    public String getBowling_a_1_player_6_balls() {
        return bowling_a_1_player_6_balls;
    }

    public void setBowling_a_1_player_6_balls(String bowling_a_1_player_6_balls) {
        this.bowling_a_1_player_6_balls = bowling_a_1_player_6_balls;
    }

    public String getBowling_a_1_player_6_wickets() {
        return bowling_a_1_player_6_wickets;
    }

    public void setBowling_a_1_player_6_wickets(String bowling_a_1_player_6_wickets) {
        this.bowling_a_1_player_6_wickets = bowling_a_1_player_6_wickets;
    }

    public String getBowling_a_1_player_6_extras() {
        return bowling_a_1_player_6_extras;
    }

    public void setBowling_a_1_player_6_extras(String bowling_a_1_player_6_extras) {
        this.bowling_a_1_player_6_extras = bowling_a_1_player_6_extras;
    }

    public String getBowling_a_1_player_6_maiden_overs() {
        return bowling_a_1_player_6_maiden_overs;
    }

    public void setBowling_a_1_player_6_maiden_overs(String bowling_a_1_player_6_maiden_overs) {
        this.bowling_a_1_player_6_maiden_overs = bowling_a_1_player_6_maiden_overs;
    }

    public String getBowling_a_1_player_6_overs() {
        return bowling_a_1_player_6_overs;
    }

    public void setBowling_a_1_player_6_overs(String bowling_a_1_player_6_overs) {
        this.bowling_a_1_player_6_overs = bowling_a_1_player_6_overs;
    }

    public String getBowling_a_2_player_6_name() {
        return bowling_a_2_player_6_name;
    }

    public void setBowling_a_2_player_6_name(String bowling_a_2_player_6_name) {
        this.bowling_a_2_player_6_name = bowling_a_2_player_6_name;
    }

    public String getBowling_a_2_player_6_economy() {
        return bowling_a_2_player_6_economy;
    }

    public void setBowling_a_2_player_6_economy(String bowling_a_2_player_6_economy) {
        this.bowling_a_2_player_6_economy = bowling_a_2_player_6_economy;
    }

    public String getBowling_a_2_player_6_runs() {
        return bowling_a_2_player_6_runs;
    }

    public void setBowling_a_2_player_6_runs(String bowling_a_2_player_6_runs) {
        this.bowling_a_2_player_6_runs = bowling_a_2_player_6_runs;
    }

    public String getBowling_a_2_player_6_dots() {
        return bowling_a_2_player_6_dots;
    }

    public void setBowling_a_2_player_6_dots(String bowling_a_2_player_6_dots) {
        this.bowling_a_2_player_6_dots = bowling_a_2_player_6_dots;
    }

    public String getBowling_a_2_player_6_balls() {
        return bowling_a_2_player_6_balls;
    }

    public void setBowling_a_2_player_6_balls(String bowling_a_2_player_6_balls) {
        this.bowling_a_2_player_6_balls = bowling_a_2_player_6_balls;
    }

    public String getBowling_a_2_player_6_wickets() {
        return bowling_a_2_player_6_wickets;
    }

    public void setBowling_a_2_player_6_wickets(String bowling_a_2_player_6_wickets) {
        this.bowling_a_2_player_6_wickets = bowling_a_2_player_6_wickets;
    }

    public String getBowling_a_2_player_6_extras() {
        return bowling_a_2_player_6_extras;
    }

    public void setBowling_a_2_player_6_extras(String bowling_a_2_player_6_extras) {
        this.bowling_a_2_player_6_extras = bowling_a_2_player_6_extras;
    }

    public String getBowling_a_2_player_6_maiden_overs() {
        return bowling_a_2_player_6_maiden_overs;
    }

    public void setBowling_a_2_player_6_maiden_overs(String bowling_a_2_player_6_maiden_overs) {
        this.bowling_a_2_player_6_maiden_overs = bowling_a_2_player_6_maiden_overs;
    }

    public String getBowling_a_2_player_6_overs() {
        return bowling_a_2_player_6_overs;
    }

    public void setBowling_a_2_player_6_overs(String bowling_a_2_player_6_overs) {
        this.bowling_a_2_player_6_overs = bowling_a_2_player_6_overs;
    }

    public String getBowling_b_1_player_6_name() {
        return bowling_b_1_player_6_name;
    }

    public void setBowling_b_1_player_6_name(String bowling_b_1_player_6_name) {
        this.bowling_b_1_player_6_name = bowling_b_1_player_6_name;
    }

    public String getBowling_b_1_player_6_economy() {
        return bowling_b_1_player_6_economy;
    }

    public void setBowling_b_1_player_6_economy(String bowling_b_1_player_6_economy) {
        this.bowling_b_1_player_6_economy = bowling_b_1_player_6_economy;
    }

    public String getBowling_b_1_player_6_runs() {
        return bowling_b_1_player_6_runs;
    }

    public void setBowling_b_1_player_6_runs(String bowling_b_1_player_6_runs) {
        this.bowling_b_1_player_6_runs = bowling_b_1_player_6_runs;
    }

    public String getBowling_b_1_player_6_dots() {
        return bowling_b_1_player_6_dots;
    }

    public void setBowling_b_1_player_6_dots(String bowling_b_1_player_6_dots) {
        this.bowling_b_1_player_6_dots = bowling_b_1_player_6_dots;
    }

    public String getBowling_b_1_player_6_balls() {
        return bowling_b_1_player_6_balls;
    }

    public void setBowling_b_1_player_6_balls(String bowling_b_1_player_6_balls) {
        this.bowling_b_1_player_6_balls = bowling_b_1_player_6_balls;
    }

    public String getBowling_b_1_player_6_wickets() {
        return bowling_b_1_player_6_wickets;
    }

    public void setBowling_b_1_player_6_wickets(String bowling_b_1_player_6_wickets) {
        this.bowling_b_1_player_6_wickets = bowling_b_1_player_6_wickets;
    }

    public String getBowling_b_1_player_6_extras() {
        return bowling_b_1_player_6_extras;
    }

    public void setBowling_b_1_player_6_extras(String bowling_b_1_player_6_extras) {
        this.bowling_b_1_player_6_extras = bowling_b_1_player_6_extras;
    }

    public String getBowling_b_1_player_6_maiden_overs() {
        return bowling_b_1_player_6_maiden_overs;
    }

    public void setBowling_b_1_player_6_maiden_overs(String bowling_b_1_player_6_maiden_overs) {
        this.bowling_b_1_player_6_maiden_overs = bowling_b_1_player_6_maiden_overs;
    }

    public String getBowling_b_1_player_6_overs() {
        return bowling_b_1_player_6_overs;
    }

    public void setBowling_b_1_player_6_overs(String bowling_b_1_player_6_overs) {
        this.bowling_b_1_player_6_overs = bowling_b_1_player_6_overs;
    }

    public String getBowling_b_2_player_6_name() {
        return bowling_b_2_player_6_name;
    }

    public void setBowling_b_2_player_6_name(String bowling_b_2_player_6_name) {
        this.bowling_b_2_player_6_name = bowling_b_2_player_6_name;
    }

    public String getBowling_b_2_player_6_economy() {
        return bowling_b_2_player_6_economy;
    }

    public void setBowling_b_2_player_6_economy(String bowling_b_2_player_6_economy) {
        this.bowling_b_2_player_6_economy = bowling_b_2_player_6_economy;
    }

    public String getBowling_b_2_player_6_runs() {
        return bowling_b_2_player_6_runs;
    }

    public void setBowling_b_2_player_6_runs(String bowling_b_2_player_6_runs) {
        this.bowling_b_2_player_6_runs = bowling_b_2_player_6_runs;
    }

    public String getBowling_b_2_player_6_dots() {
        return bowling_b_2_player_6_dots;
    }

    public void setBowling_b_2_player_6_dots(String bowling_b_2_player_6_dots) {
        this.bowling_b_2_player_6_dots = bowling_b_2_player_6_dots;
    }

    public String getBowling_b_2_player_6_balls() {
        return bowling_b_2_player_6_balls;
    }

    public void setBowling_b_2_player_6_balls(String bowling_b_2_player_6_balls) {
        this.bowling_b_2_player_6_balls = bowling_b_2_player_6_balls;
    }

    public String getBowling_b_2_player_6_wickets() {
        return bowling_b_2_player_6_wickets;
    }

    public void setBowling_b_2_player_6_wickets(String bowling_b_2_player_6_wickets) {
        this.bowling_b_2_player_6_wickets = bowling_b_2_player_6_wickets;
    }

    public String getBowling_b_2_player_6_extras() {
        return bowling_b_2_player_6_extras;
    }

    public void setBowling_b_2_player_6_extras(String bowling_b_2_player_6_extras) {
        this.bowling_b_2_player_6_extras = bowling_b_2_player_6_extras;
    }

    public String getBowling_b_2_player_6_maiden_overs() {
        return bowling_b_2_player_6_maiden_overs;
    }

    public void setBowling_b_2_player_6_maiden_overs(String bowling_b_2_player_6_maiden_overs) {
        this.bowling_b_2_player_6_maiden_overs = bowling_b_2_player_6_maiden_overs;
    }

    public String getBowling_b_2_player_6_overs() {
        return bowling_b_2_player_6_overs;
    }

    public void setBowling_b_2_player_6_overs(String bowling_b_2_player_6_overs) {
        this.bowling_b_2_player_6_overs = bowling_b_2_player_6_overs;
    }

    public String getBowling_a_1_player_7_name() {
        return bowling_a_1_player_7_name;
    }

    public void setBowling_a_1_player_7_name(String bowling_a_1_player_7_name) {
        this.bowling_a_1_player_7_name = bowling_a_1_player_7_name;
    }

    public String getBowling_a_1_player_7_economy() {
        return bowling_a_1_player_7_economy;
    }

    public void setBowling_a_1_player_7_economy(String bowling_a_1_player_7_economy) {
        this.bowling_a_1_player_7_economy = bowling_a_1_player_7_economy;
    }

    public String getBowling_a_1_player_7_runs() {
        return bowling_a_1_player_7_runs;
    }

    public void setBowling_a_1_player_7_runs(String bowling_a_1_player_7_runs) {
        this.bowling_a_1_player_7_runs = bowling_a_1_player_7_runs;
    }

    public String getBowling_a_1_player_7_dots() {
        return bowling_a_1_player_7_dots;
    }

    public void setBowling_a_1_player_7_dots(String bowling_a_1_player_7_dots) {
        this.bowling_a_1_player_7_dots = bowling_a_1_player_7_dots;
    }

    public String getBowling_a_1_player_7_balls() {
        return bowling_a_1_player_7_balls;
    }

    public void setBowling_a_1_player_7_balls(String bowling_a_1_player_7_balls) {
        this.bowling_a_1_player_7_balls = bowling_a_1_player_7_balls;
    }

    public String getBowling_a_1_player_7_wickets() {
        return bowling_a_1_player_7_wickets;
    }

    public void setBowling_a_1_player_7_wickets(String bowling_a_1_player_7_wickets) {
        this.bowling_a_1_player_7_wickets = bowling_a_1_player_7_wickets;
    }

    public String getBowling_a_1_player_7_extras() {
        return bowling_a_1_player_7_extras;
    }

    public void setBowling_a_1_player_7_extras(String bowling_a_1_player_7_extras) {
        this.bowling_a_1_player_7_extras = bowling_a_1_player_7_extras;
    }

    public String getBowling_a_1_player_7_maiden_overs() {
        return bowling_a_1_player_7_maiden_overs;
    }

    public void setBowling_a_1_player_7_maiden_overs(String bowling_a_1_player_7_maiden_overs) {
        this.bowling_a_1_player_7_maiden_overs = bowling_a_1_player_7_maiden_overs;
    }

    public String getBowling_a_1_player_7_overs() {
        return bowling_a_1_player_7_overs;
    }

    public void setBowling_a_1_player_7_overs(String bowling_a_1_player_7_overs) {
        this.bowling_a_1_player_7_overs = bowling_a_1_player_7_overs;
    }

    public String getBowling_a_2_player_7_name() {
        return bowling_a_2_player_7_name;
    }

    public void setBowling_a_2_player_7_name(String bowling_a_2_player_7_name) {
        this.bowling_a_2_player_7_name = bowling_a_2_player_7_name;
    }

    public String getBowling_a_2_player_7_economy() {
        return bowling_a_2_player_7_economy;
    }

    public void setBowling_a_2_player_7_economy(String bowling_a_2_player_7_economy) {
        this.bowling_a_2_player_7_economy = bowling_a_2_player_7_economy;
    }

    public String getBowling_a_2_player_7_runs() {
        return bowling_a_2_player_7_runs;
    }

    public void setBowling_a_2_player_7_runs(String bowling_a_2_player_7_runs) {
        this.bowling_a_2_player_7_runs = bowling_a_2_player_7_runs;
    }

    public String getBowling_a_2_player_7_dots() {
        return bowling_a_2_player_7_dots;
    }

    public void setBowling_a_2_player_7_dots(String bowling_a_2_player_7_dots) {
        this.bowling_a_2_player_7_dots = bowling_a_2_player_7_dots;
    }

    public String getBowling_a_2_player_7_balls() {
        return bowling_a_2_player_7_balls;
    }

    public void setBowling_a_2_player_7_balls(String bowling_a_2_player_7_balls) {
        this.bowling_a_2_player_7_balls = bowling_a_2_player_7_balls;
    }

    public String getBowling_a_2_player_7_wickets() {
        return bowling_a_2_player_7_wickets;
    }

    public void setBowling_a_2_player_7_wickets(String bowling_a_2_player_7_wickets) {
        this.bowling_a_2_player_7_wickets = bowling_a_2_player_7_wickets;
    }

    public String getBowling_a_2_player_7_extras() {
        return bowling_a_2_player_7_extras;
    }

    public void setBowling_a_2_player_7_extras(String bowling_a_2_player_7_extras) {
        this.bowling_a_2_player_7_extras = bowling_a_2_player_7_extras;
    }

    public String getBowling_a_2_player_7_maiden_overs() {
        return bowling_a_2_player_7_maiden_overs;
    }

    public void setBowling_a_2_player_7_maiden_overs(String bowling_a_2_player_7_maiden_overs) {
        this.bowling_a_2_player_7_maiden_overs = bowling_a_2_player_7_maiden_overs;
    }

    public String getBowling_a_2_player_7_overs() {
        return bowling_a_2_player_7_overs;
    }

    public void setBowling_a_2_player_7_overs(String bowling_a_2_player_7_overs) {
        this.bowling_a_2_player_7_overs = bowling_a_2_player_7_overs;
    }

    public String getBowling_b_1_player_7_name() {
        return bowling_b_1_player_7_name;
    }

    public void setBowling_b_1_player_7_name(String bowling_b_1_player_7_name) {
        this.bowling_b_1_player_7_name = bowling_b_1_player_7_name;
    }

    public String getBowling_b_1_player_7_economy() {
        return bowling_b_1_player_7_economy;
    }

    public void setBowling_b_1_player_7_economy(String bowling_b_1_player_7_economy) {
        this.bowling_b_1_player_7_economy = bowling_b_1_player_7_economy;
    }

    public String getBowling_b_1_player_7_runs() {
        return bowling_b_1_player_7_runs;
    }

    public void setBowling_b_1_player_7_runs(String bowling_b_1_player_7_runs) {
        this.bowling_b_1_player_7_runs = bowling_b_1_player_7_runs;
    }

    public String getBowling_b_1_player_7_dots() {
        return bowling_b_1_player_7_dots;
    }

    public void setBowling_b_1_player_7_dots(String bowling_b_1_player_7_dots) {
        this.bowling_b_1_player_7_dots = bowling_b_1_player_7_dots;
    }

    public String getBowling_b_1_player_7_balls() {
        return bowling_b_1_player_7_balls;
    }

    public void setBowling_b_1_player_7_balls(String bowling_b_1_player_7_balls) {
        this.bowling_b_1_player_7_balls = bowling_b_1_player_7_balls;
    }

    public String getBowling_b_1_player_7_wickets() {
        return bowling_b_1_player_7_wickets;
    }

    public void setBowling_b_1_player_7_wickets(String bowling_b_1_player_7_wickets) {
        this.bowling_b_1_player_7_wickets = bowling_b_1_player_7_wickets;
    }

    public String getBowling_b_1_player_7_extras() {
        return bowling_b_1_player_7_extras;
    }

    public void setBowling_b_1_player_7_extras(String bowling_b_1_player_7_extras) {
        this.bowling_b_1_player_7_extras = bowling_b_1_player_7_extras;
    }

    public String getBowling_b_1_player_7_maiden_overs() {
        return bowling_b_1_player_7_maiden_overs;
    }

    public void setBowling_b_1_player_7_maiden_overs(String bowling_b_1_player_7_maiden_overs) {
        this.bowling_b_1_player_7_maiden_overs = bowling_b_1_player_7_maiden_overs;
    }

    public String getBowling_b_1_player_7_overs() {
        return bowling_b_1_player_7_overs;
    }

    public void setBowling_b_1_player_7_overs(String bowling_b_1_player_7_overs) {
        this.bowling_b_1_player_7_overs = bowling_b_1_player_7_overs;
    }

    public String getBowling_b_2_player_7_name() {
        return bowling_b_2_player_7_name;
    }

    public void setBowling_b_2_player_7_name(String bowling_b_2_player_7_name) {
        this.bowling_b_2_player_7_name = bowling_b_2_player_7_name;
    }

    public String getBowling_b_2_player_7_economy() {
        return bowling_b_2_player_7_economy;
    }

    public void setBowling_b_2_player_7_economy(String bowling_b_2_player_7_economy) {
        this.bowling_b_2_player_7_economy = bowling_b_2_player_7_economy;
    }

    public String getBowling_b_2_player_7_runs() {
        return bowling_b_2_player_7_runs;
    }

    public void setBowling_b_2_player_7_runs(String bowling_b_2_player_7_runs) {
        this.bowling_b_2_player_7_runs = bowling_b_2_player_7_runs;
    }

    public String getBowling_b_2_player_7_dots() {
        return bowling_b_2_player_7_dots;
    }

    public void setBowling_b_2_player_7_dots(String bowling_b_2_player_7_dots) {
        this.bowling_b_2_player_7_dots = bowling_b_2_player_7_dots;
    }

    public String getBowling_b_2_player_7_balls() {
        return bowling_b_2_player_7_balls;
    }

    public void setBowling_b_2_player_7_balls(String bowling_b_2_player_7_balls) {
        this.bowling_b_2_player_7_balls = bowling_b_2_player_7_balls;
    }

    public String getBowling_b_2_player_7_wickets() {
        return bowling_b_2_player_7_wickets;
    }

    public void setBowling_b_2_player_7_wickets(String bowling_b_2_player_7_wickets) {
        this.bowling_b_2_player_7_wickets = bowling_b_2_player_7_wickets;
    }

    public String getBowling_b_2_player_7_extras() {
        return bowling_b_2_player_7_extras;
    }

    public void setBowling_b_2_player_7_extras(String bowling_b_2_player_7_extras) {
        this.bowling_b_2_player_7_extras = bowling_b_2_player_7_extras;
    }

    public String getBowling_b_2_player_7_maiden_overs() {
        return bowling_b_2_player_7_maiden_overs;
    }

    public void setBowling_b_2_player_7_maiden_overs(String bowling_b_2_player_7_maiden_overs) {
        this.bowling_b_2_player_7_maiden_overs = bowling_b_2_player_7_maiden_overs;
    }

    public String getBowling_b_2_player_7_overs() {
        return bowling_b_2_player_7_overs;
    }

    public void setBowling_b_2_player_7_overs(String bowling_b_2_player_7_overs) {
        this.bowling_b_2_player_7_overs = bowling_b_2_player_7_overs;
    }

    public String getBowling_a_1_player_8_name() {
        return bowling_a_1_player_8_name;
    }

    public void setBowling_a_1_player_8_name(String bowling_a_1_player_8_name) {
        this.bowling_a_1_player_8_name = bowling_a_1_player_8_name;
    }

    public String getBowling_a_1_player_8_economy() {
        return bowling_a_1_player_8_economy;
    }

    public void setBowling_a_1_player_8_economy(String bowling_a_1_player_8_economy) {
        this.bowling_a_1_player_8_economy = bowling_a_1_player_8_economy;
    }

    public String getBowling_a_1_player_8_runs() {
        return bowling_a_1_player_8_runs;
    }

    public void setBowling_a_1_player_8_runs(String bowling_a_1_player_8_runs) {
        this.bowling_a_1_player_8_runs = bowling_a_1_player_8_runs;
    }

    public String getBowling_a_1_player_8_dots() {
        return bowling_a_1_player_8_dots;
    }

    public void setBowling_a_1_player_8_dots(String bowling_a_1_player_8_dots) {
        this.bowling_a_1_player_8_dots = bowling_a_1_player_8_dots;
    }

    public String getBowling_a_1_player_8_balls() {
        return bowling_a_1_player_8_balls;
    }

    public void setBowling_a_1_player_8_balls(String bowling_a_1_player_8_balls) {
        this.bowling_a_1_player_8_balls = bowling_a_1_player_8_balls;
    }

    public String getBowling_a_1_player_8_wickets() {
        return bowling_a_1_player_8_wickets;
    }

    public void setBowling_a_1_player_8_wickets(String bowling_a_1_player_8_wickets) {
        this.bowling_a_1_player_8_wickets = bowling_a_1_player_8_wickets;
    }

    public String getBowling_a_1_player_8_extras() {
        return bowling_a_1_player_8_extras;
    }

    public void setBowling_a_1_player_8_extras(String bowling_a_1_player_8_extras) {
        this.bowling_a_1_player_8_extras = bowling_a_1_player_8_extras;
    }

    public String getBowling_a_1_player_8_maiden_overs() {
        return bowling_a_1_player_8_maiden_overs;
    }

    public void setBowling_a_1_player_8_maiden_overs(String bowling_a_1_player_8_maiden_overs) {
        this.bowling_a_1_player_8_maiden_overs = bowling_a_1_player_8_maiden_overs;
    }

    public String getBowling_a_1_player_8_overs() {
        return bowling_a_1_player_8_overs;
    }

    public void setBowling_a_1_player_8_overs(String bowling_a_1_player_8_overs) {
        this.bowling_a_1_player_8_overs = bowling_a_1_player_8_overs;
    }

    public String getBowling_a_2_player_8_name() {
        return bowling_a_2_player_8_name;
    }

    public void setBowling_a_2_player_8_name(String bowling_a_2_player_8_name) {
        this.bowling_a_2_player_8_name = bowling_a_2_player_8_name;
    }

    public String getBowling_a_2_player_8_economy() {
        return bowling_a_2_player_8_economy;
    }

    public void setBowling_a_2_player_8_economy(String bowling_a_2_player_8_economy) {
        this.bowling_a_2_player_8_economy = bowling_a_2_player_8_economy;
    }

    public String getBowling_a_2_player_8_runs() {
        return bowling_a_2_player_8_runs;
    }

    public void setBowling_a_2_player_8_runs(String bowling_a_2_player_8_runs) {
        this.bowling_a_2_player_8_runs = bowling_a_2_player_8_runs;
    }

    public String getBowling_a_2_player_8_dots() {
        return bowling_a_2_player_8_dots;
    }

    public void setBowling_a_2_player_8_dots(String bowling_a_2_player_8_dots) {
        this.bowling_a_2_player_8_dots = bowling_a_2_player_8_dots;
    }

    public String getBowling_a_2_player_8_balls() {
        return bowling_a_2_player_8_balls;
    }

    public void setBowling_a_2_player_8_balls(String bowling_a_2_player_8_balls) {
        this.bowling_a_2_player_8_balls = bowling_a_2_player_8_balls;
    }

    public String getBowling_a_2_player_8_wickets() {
        return bowling_a_2_player_8_wickets;
    }

    public void setBowling_a_2_player_8_wickets(String bowling_a_2_player_8_wickets) {
        this.bowling_a_2_player_8_wickets = bowling_a_2_player_8_wickets;
    }

    public String getBowling_a_2_player_8_extras() {
        return bowling_a_2_player_8_extras;
    }

    public void setBowling_a_2_player_8_extras(String bowling_a_2_player_8_extras) {
        this.bowling_a_2_player_8_extras = bowling_a_2_player_8_extras;
    }

    public String getBowling_a_2_player_8_maiden_overs() {
        return bowling_a_2_player_8_maiden_overs;
    }

    public void setBowling_a_2_player_8_maiden_overs(String bowling_a_2_player_8_maiden_overs) {
        this.bowling_a_2_player_8_maiden_overs = bowling_a_2_player_8_maiden_overs;
    }

    public String getBowling_a_2_player_8_overs() {
        return bowling_a_2_player_8_overs;
    }

    public void setBowling_a_2_player_8_overs(String bowling_a_2_player_8_overs) {
        this.bowling_a_2_player_8_overs = bowling_a_2_player_8_overs;
    }

    public String getBowling_b_1_player_8_name() {
        return bowling_b_1_player_8_name;
    }

    public void setBowling_b_1_player_8_name(String bowling_b_1_player_8_name) {
        this.bowling_b_1_player_8_name = bowling_b_1_player_8_name;
    }

    public String getBowling_b_1_player_8_economy() {
        return bowling_b_1_player_8_economy;
    }

    public void setBowling_b_1_player_8_economy(String bowling_b_1_player_8_economy) {
        this.bowling_b_1_player_8_economy = bowling_b_1_player_8_economy;
    }

    public String getBowling_b_1_player_8_runs() {
        return bowling_b_1_player_8_runs;
    }

    public void setBowling_b_1_player_8_runs(String bowling_b_1_player_8_runs) {
        this.bowling_b_1_player_8_runs = bowling_b_1_player_8_runs;
    }

    public String getBowling_b_1_player_8_dots() {
        return bowling_b_1_player_8_dots;
    }

    public void setBowling_b_1_player_8_dots(String bowling_b_1_player_8_dots) {
        this.bowling_b_1_player_8_dots = bowling_b_1_player_8_dots;
    }

    public String getBowling_b_1_player_8_balls() {
        return bowling_b_1_player_8_balls;
    }

    public void setBowling_b_1_player_8_balls(String bowling_b_1_player_8_balls) {
        this.bowling_b_1_player_8_balls = bowling_b_1_player_8_balls;
    }

    public String getBowling_b_1_player_8_wickets() {
        return bowling_b_1_player_8_wickets;
    }

    public void setBowling_b_1_player_8_wickets(String bowling_b_1_player_8_wickets) {
        this.bowling_b_1_player_8_wickets = bowling_b_1_player_8_wickets;
    }

    public String getBowling_b_1_player_8_extras() {
        return bowling_b_1_player_8_extras;
    }

    public void setBowling_b_1_player_8_extras(String bowling_b_1_player_8_extras) {
        this.bowling_b_1_player_8_extras = bowling_b_1_player_8_extras;
    }

    public String getBowling_b_1_player_8_maiden_overs() {
        return bowling_b_1_player_8_maiden_overs;
    }

    public void setBowling_b_1_player_8_maiden_overs(String bowling_b_1_player_8_maiden_overs) {
        this.bowling_b_1_player_8_maiden_overs = bowling_b_1_player_8_maiden_overs;
    }

    public String getBowling_b_1_player_8_overs() {
        return bowling_b_1_player_8_overs;
    }

    public void setBowling_b_1_player_8_overs(String bowling_b_1_player_8_overs) {
        this.bowling_b_1_player_8_overs = bowling_b_1_player_8_overs;
    }

    public String getBowling_b_2_player_8_name() {
        return bowling_b_2_player_8_name;
    }

    public void setBowling_b_2_player_8_name(String bowling_b_2_player_8_name) {
        this.bowling_b_2_player_8_name = bowling_b_2_player_8_name;
    }

    public String getBowling_b_2_player_8_economy() {
        return bowling_b_2_player_8_economy;
    }

    public void setBowling_b_2_player_8_economy(String bowling_b_2_player_8_economy) {
        this.bowling_b_2_player_8_economy = bowling_b_2_player_8_economy;
    }

    public String getBowling_b_2_player_8_runs() {
        return bowling_b_2_player_8_runs;
    }

    public void setBowling_b_2_player_8_runs(String bowling_b_2_player_8_runs) {
        this.bowling_b_2_player_8_runs = bowling_b_2_player_8_runs;
    }

    public String getBowling_b_2_player_8_dots() {
        return bowling_b_2_player_8_dots;
    }

    public void setBowling_b_2_player_8_dots(String bowling_b_2_player_8_dots) {
        this.bowling_b_2_player_8_dots = bowling_b_2_player_8_dots;
    }

    public String getBowling_b_2_player_8_balls() {
        return bowling_b_2_player_8_balls;
    }

    public void setBowling_b_2_player_8_balls(String bowling_b_2_player_8_balls) {
        this.bowling_b_2_player_8_balls = bowling_b_2_player_8_balls;
    }

    public String getBowling_b_2_player_8_wickets() {
        return bowling_b_2_player_8_wickets;
    }

    public void setBowling_b_2_player_8_wickets(String bowling_b_2_player_8_wickets) {
        this.bowling_b_2_player_8_wickets = bowling_b_2_player_8_wickets;
    }

    public String getBowling_b_2_player_8_extras() {
        return bowling_b_2_player_8_extras;
    }

    public void setBowling_b_2_player_8_extras(String bowling_b_2_player_8_extras) {
        this.bowling_b_2_player_8_extras = bowling_b_2_player_8_extras;
    }

    public String getBowling_b_2_player_8_maiden_overs() {
        return bowling_b_2_player_8_maiden_overs;
    }

    public void setBowling_b_2_player_8_maiden_overs(String bowling_b_2_player_8_maiden_overs) {
        this.bowling_b_2_player_8_maiden_overs = bowling_b_2_player_8_maiden_overs;
    }

    public String getBowling_b_2_player_8_overs() {
        return bowling_b_2_player_8_overs;
    }

    public void setBowling_b_2_player_8_overs(String bowling_b_2_player_8_overs) {
        this.bowling_b_2_player_8_overs = bowling_b_2_player_8_overs;
    }

    public String getBowling_a_1_player_9_name() {
        return bowling_a_1_player_9_name;
    }

    public void setBowling_a_1_player_9_name(String bowling_a_1_player_9_name) {
        this.bowling_a_1_player_9_name = bowling_a_1_player_9_name;
    }

    public String getBowling_a_1_player_9_economy() {
        return bowling_a_1_player_9_economy;
    }

    public void setBowling_a_1_player_9_economy(String bowling_a_1_player_9_economy) {
        this.bowling_a_1_player_9_economy = bowling_a_1_player_9_economy;
    }

    public String getBowling_a_1_player_9_runs() {
        return bowling_a_1_player_9_runs;
    }

    public void setBowling_a_1_player_9_runs(String bowling_a_1_player_9_runs) {
        this.bowling_a_1_player_9_runs = bowling_a_1_player_9_runs;
    }

    public String getBowling_a_1_player_9_dots() {
        return bowling_a_1_player_9_dots;
    }

    public void setBowling_a_1_player_9_dots(String bowling_a_1_player_9_dots) {
        this.bowling_a_1_player_9_dots = bowling_a_1_player_9_dots;
    }

    public String getBowling_a_1_player_9_balls() {
        return bowling_a_1_player_9_balls;
    }

    public void setBowling_a_1_player_9_balls(String bowling_a_1_player_9_balls) {
        this.bowling_a_1_player_9_balls = bowling_a_1_player_9_balls;
    }

    public String getBowling_a_1_player_9_wickets() {
        return bowling_a_1_player_9_wickets;
    }

    public void setBowling_a_1_player_9_wickets(String bowling_a_1_player_9_wickets) {
        this.bowling_a_1_player_9_wickets = bowling_a_1_player_9_wickets;
    }

    public String getBowling_a_1_player_9_extras() {
        return bowling_a_1_player_9_extras;
    }

    public void setBowling_a_1_player_9_extras(String bowling_a_1_player_9_extras) {
        this.bowling_a_1_player_9_extras = bowling_a_1_player_9_extras;
    }

    public String getBowling_a_1_player_9_maiden_overs() {
        return bowling_a_1_player_9_maiden_overs;
    }

    public void setBowling_a_1_player_9_maiden_overs(String bowling_a_1_player_9_maiden_overs) {
        this.bowling_a_1_player_9_maiden_overs = bowling_a_1_player_9_maiden_overs;
    }

    public String getBowling_a_1_player_9_overs() {
        return bowling_a_1_player_9_overs;
    }

    public void setBowling_a_1_player_9_overs(String bowling_a_1_player_9_overs) {
        this.bowling_a_1_player_9_overs = bowling_a_1_player_9_overs;
    }

    public String getBowling_a_2_player_9_name() {
        return bowling_a_2_player_9_name;
    }

    public void setBowling_a_2_player_9_name(String bowling_a_2_player_9_name) {
        this.bowling_a_2_player_9_name = bowling_a_2_player_9_name;
    }

    public String getBowling_a_2_player_9_economy() {
        return bowling_a_2_player_9_economy;
    }

    public void setBowling_a_2_player_9_economy(String bowling_a_2_player_9_economy) {
        this.bowling_a_2_player_9_economy = bowling_a_2_player_9_economy;
    }

    public String getBowling_a_2_player_9_runs() {
        return bowling_a_2_player_9_runs;
    }

    public void setBowling_a_2_player_9_runs(String bowling_a_2_player_9_runs) {
        this.bowling_a_2_player_9_runs = bowling_a_2_player_9_runs;
    }

    public String getBowling_a_2_player_9_dots() {
        return bowling_a_2_player_9_dots;
    }

    public void setBowling_a_2_player_9_dots(String bowling_a_2_player_9_dots) {
        this.bowling_a_2_player_9_dots = bowling_a_2_player_9_dots;
    }

    public String getBowling_a_2_player_9_balls() {
        return bowling_a_2_player_9_balls;
    }

    public void setBowling_a_2_player_9_balls(String bowling_a_2_player_9_balls) {
        this.bowling_a_2_player_9_balls = bowling_a_2_player_9_balls;
    }

    public String getBowling_a_2_player_9_wickets() {
        return bowling_a_2_player_9_wickets;
    }

    public void setBowling_a_2_player_9_wickets(String bowling_a_2_player_9_wickets) {
        this.bowling_a_2_player_9_wickets = bowling_a_2_player_9_wickets;
    }

    public String getBowling_a_2_player_9_extras() {
        return bowling_a_2_player_9_extras;
    }

    public void setBowling_a_2_player_9_extras(String bowling_a_2_player_9_extras) {
        this.bowling_a_2_player_9_extras = bowling_a_2_player_9_extras;
    }

    public String getBowling_a_2_player_9_maiden_overs() {
        return bowling_a_2_player_9_maiden_overs;
    }

    public void setBowling_a_2_player_9_maiden_overs(String bowling_a_2_player_9_maiden_overs) {
        this.bowling_a_2_player_9_maiden_overs = bowling_a_2_player_9_maiden_overs;
    }

    public String getBowling_a_2_player_9_overs() {
        return bowling_a_2_player_9_overs;
    }

    public void setBowling_a_2_player_9_overs(String bowling_a_2_player_9_overs) {
        this.bowling_a_2_player_9_overs = bowling_a_2_player_9_overs;
    }

    public String getBowling_b_1_player_9_name() {
        return bowling_b_1_player_9_name;
    }

    public void setBowling_b_1_player_9_name(String bowling_b_1_player_9_name) {
        this.bowling_b_1_player_9_name = bowling_b_1_player_9_name;
    }

    public String getBowling_b_1_player_9_economy() {
        return bowling_b_1_player_9_economy;
    }

    public void setBowling_b_1_player_9_economy(String bowling_b_1_player_9_economy) {
        this.bowling_b_1_player_9_economy = bowling_b_1_player_9_economy;
    }

    public String getBowling_b_1_player_9_runs() {
        return bowling_b_1_player_9_runs;
    }

    public void setBowling_b_1_player_9_runs(String bowling_b_1_player_9_runs) {
        this.bowling_b_1_player_9_runs = bowling_b_1_player_9_runs;
    }

    public String getBowling_b_1_player_9_dots() {
        return bowling_b_1_player_9_dots;
    }

    public void setBowling_b_1_player_9_dots(String bowling_b_1_player_9_dots) {
        this.bowling_b_1_player_9_dots = bowling_b_1_player_9_dots;
    }

    public String getBowling_b_1_player_9_balls() {
        return bowling_b_1_player_9_balls;
    }

    public void setBowling_b_1_player_9_balls(String bowling_b_1_player_9_balls) {
        this.bowling_b_1_player_9_balls = bowling_b_1_player_9_balls;
    }

    public String getBowling_b_1_player_9_wickets() {
        return bowling_b_1_player_9_wickets;
    }

    public void setBowling_b_1_player_9_wickets(String bowling_b_1_player_9_wickets) {
        this.bowling_b_1_player_9_wickets = bowling_b_1_player_9_wickets;
    }

    public String getBowling_b_1_player_9_extras() {
        return bowling_b_1_player_9_extras;
    }

    public void setBowling_b_1_player_9_extras(String bowling_b_1_player_9_extras) {
        this.bowling_b_1_player_9_extras = bowling_b_1_player_9_extras;
    }

    public String getBowling_b_1_player_9_maiden_overs() {
        return bowling_b_1_player_9_maiden_overs;
    }

    public void setBowling_b_1_player_9_maiden_overs(String bowling_b_1_player_9_maiden_overs) {
        this.bowling_b_1_player_9_maiden_overs = bowling_b_1_player_9_maiden_overs;
    }

    public String getBowling_b_1_player_9_overs() {
        return bowling_b_1_player_9_overs;
    }

    public void setBowling_b_1_player_9_overs(String bowling_b_1_player_9_overs) {
        this.bowling_b_1_player_9_overs = bowling_b_1_player_9_overs;
    }

    public String getBowling_b_2_player_9_name() {
        return bowling_b_2_player_9_name;
    }

    public void setBowling_b_2_player_9_name(String bowling_b_2_player_9_name) {
        this.bowling_b_2_player_9_name = bowling_b_2_player_9_name;
    }

    public String getBowling_b_2_player_9_economy() {
        return bowling_b_2_player_9_economy;
    }

    public void setBowling_b_2_player_9_economy(String bowling_b_2_player_9_economy) {
        this.bowling_b_2_player_9_economy = bowling_b_2_player_9_economy;
    }

    public String getBowling_b_2_player_9_runs() {
        return bowling_b_2_player_9_runs;
    }

    public void setBowling_b_2_player_9_runs(String bowling_b_2_player_9_runs) {
        this.bowling_b_2_player_9_runs = bowling_b_2_player_9_runs;
    }

    public String getBowling_b_2_player_9_dots() {
        return bowling_b_2_player_9_dots;
    }

    public void setBowling_b_2_player_9_dots(String bowling_b_2_player_9_dots) {
        this.bowling_b_2_player_9_dots = bowling_b_2_player_9_dots;
    }

    public String getBowling_b_2_player_9_balls() {
        return bowling_b_2_player_9_balls;
    }

    public void setBowling_b_2_player_9_balls(String bowling_b_2_player_9_balls) {
        this.bowling_b_2_player_9_balls = bowling_b_2_player_9_balls;
    }

    public String getBowling_b_2_player_9_wickets() {
        return bowling_b_2_player_9_wickets;
    }

    public void setBowling_b_2_player_9_wickets(String bowling_b_2_player_9_wickets) {
        this.bowling_b_2_player_9_wickets = bowling_b_2_player_9_wickets;
    }

    public String getBowling_b_2_player_9_extras() {
        return bowling_b_2_player_9_extras;
    }

    public void setBowling_b_2_player_9_extras(String bowling_b_2_player_9_extras) {
        this.bowling_b_2_player_9_extras = bowling_b_2_player_9_extras;
    }

    public String getBowling_b_2_player_9_maiden_overs() {
        return bowling_b_2_player_9_maiden_overs;
    }

    public void setBowling_b_2_player_9_maiden_overs(String bowling_b_2_player_9_maiden_overs) {
        this.bowling_b_2_player_9_maiden_overs = bowling_b_2_player_9_maiden_overs;
    }

    public String getBowling_b_2_player_9_overs() {
        return bowling_b_2_player_9_overs;
    }

    public void setBowling_b_2_player_9_overs(String bowling_b_2_player_9_overs) {
        this.bowling_b_2_player_9_overs = bowling_b_2_player_9_overs;
    }

    public String getBowling_a_1_player_10_name() {
        return bowling_a_1_player_10_name;
    }

    public void setBowling_a_1_player_10_name(String bowling_a_1_player_10_name) {
        this.bowling_a_1_player_10_name = bowling_a_1_player_10_name;
    }

    public String getBowling_a_1_player_10_economy() {
        return bowling_a_1_player_10_economy;
    }

    public void setBowling_a_1_player_10_economy(String bowling_a_1_player_10_economy) {
        this.bowling_a_1_player_10_economy = bowling_a_1_player_10_economy;
    }

    public String getBowling_a_1_player_10_runs() {
        return bowling_a_1_player_10_runs;
    }

    public void setBowling_a_1_player_10_runs(String bowling_a_1_player_10_runs) {
        this.bowling_a_1_player_10_runs = bowling_a_1_player_10_runs;
    }

    public String getBowling_a_1_player_10_dots() {
        return bowling_a_1_player_10_dots;
    }

    public void setBowling_a_1_player_10_dots(String bowling_a_1_player_10_dots) {
        this.bowling_a_1_player_10_dots = bowling_a_1_player_10_dots;
    }

    public String getBowling_a_1_player_10_balls() {
        return bowling_a_1_player_10_balls;
    }

    public void setBowling_a_1_player_10_balls(String bowling_a_1_player_10_balls) {
        this.bowling_a_1_player_10_balls = bowling_a_1_player_10_balls;
    }

    public String getBowling_a_1_player_10_wickets() {
        return bowling_a_1_player_10_wickets;
    }

    public void setBowling_a_1_player_10_wickets(String bowling_a_1_player_10_wickets) {
        this.bowling_a_1_player_10_wickets = bowling_a_1_player_10_wickets;
    }

    public String getBowling_a_1_player_10_extras() {
        return bowling_a_1_player_10_extras;
    }

    public void setBowling_a_1_player_10_extras(String bowling_a_1_player_10_extras) {
        this.bowling_a_1_player_10_extras = bowling_a_1_player_10_extras;
    }

    public String getBowling_a_1_player_10_maiden_overs() {
        return bowling_a_1_player_10_maiden_overs;
    }

    public void setBowling_a_1_player_10_maiden_overs(String bowling_a_1_player_10_maiden_overs) {
        this.bowling_a_1_player_10_maiden_overs = bowling_a_1_player_10_maiden_overs;
    }

    public String getBowling_a_1_player_10_overs() {
        return bowling_a_1_player_10_overs;
    }

    public void setBowling_a_1_player_10_overs(String bowling_a_1_player_10_overs) {
        this.bowling_a_1_player_10_overs = bowling_a_1_player_10_overs;
    }

    public String getBowling_a_2_player_10_name() {
        return bowling_a_2_player_10_name;
    }

    public void setBowling_a_2_player_10_name(String bowling_a_2_player_10_name) {
        this.bowling_a_2_player_10_name = bowling_a_2_player_10_name;
    }

    public String getBowling_a_2_player_10_economy() {
        return bowling_a_2_player_10_economy;
    }

    public void setBowling_a_2_player_10_economy(String bowling_a_2_player_10_economy) {
        this.bowling_a_2_player_10_economy = bowling_a_2_player_10_economy;
    }

    public String getBowling_a_2_player_10_runs() {
        return bowling_a_2_player_10_runs;
    }

    public void setBowling_a_2_player_10_runs(String bowling_a_2_player_10_runs) {
        this.bowling_a_2_player_10_runs = bowling_a_2_player_10_runs;
    }

    public String getBowling_a_2_player_10_dots() {
        return bowling_a_2_player_10_dots;
    }

    public void setBowling_a_2_player_10_dots(String bowling_a_2_player_10_dots) {
        this.bowling_a_2_player_10_dots = bowling_a_2_player_10_dots;
    }

    public String getBowling_a_2_player_10_balls() {
        return bowling_a_2_player_10_balls;
    }

    public void setBowling_a_2_player_10_balls(String bowling_a_2_player_10_balls) {
        this.bowling_a_2_player_10_balls = bowling_a_2_player_10_balls;
    }

    public String getBowling_a_2_player_10_wickets() {
        return bowling_a_2_player_10_wickets;
    }

    public void setBowling_a_2_player_10_wickets(String bowling_a_2_player_10_wickets) {
        this.bowling_a_2_player_10_wickets = bowling_a_2_player_10_wickets;
    }

    public String getBowling_a_2_player_10_extras() {
        return bowling_a_2_player_10_extras;
    }

    public void setBowling_a_2_player_10_extras(String bowling_a_2_player_10_extras) {
        this.bowling_a_2_player_10_extras = bowling_a_2_player_10_extras;
    }

    public String getBowling_a_2_player_10_maiden_overs() {
        return bowling_a_2_player_10_maiden_overs;
    }

    public void setBowling_a_2_player_10_maiden_overs(String bowling_a_2_player_10_maiden_overs) {
        this.bowling_a_2_player_10_maiden_overs = bowling_a_2_player_10_maiden_overs;
    }

    public String getBowling_a_2_player_10_overs() {
        return bowling_a_2_player_10_overs;
    }

    public void setBowling_a_2_player_10_overs(String bowling_a_2_player_10_overs) {
        this.bowling_a_2_player_10_overs = bowling_a_2_player_10_overs;
    }

    public String getBowling_b_1_player_10_name() {
        return bowling_b_1_player_10_name;
    }

    public void setBowling_b_1_player_10_name(String bowling_b_1_player_10_name) {
        this.bowling_b_1_player_10_name = bowling_b_1_player_10_name;
    }

    public String getBowling_b_1_player_10_economy() {
        return bowling_b_1_player_10_economy;
    }

    public void setBowling_b_1_player_10_economy(String bowling_b_1_player_10_economy) {
        this.bowling_b_1_player_10_economy = bowling_b_1_player_10_economy;
    }

    public String getBowling_b_1_player_10_runs() {
        return bowling_b_1_player_10_runs;
    }

    public void setBowling_b_1_player_10_runs(String bowling_b_1_player_10_runs) {
        this.bowling_b_1_player_10_runs = bowling_b_1_player_10_runs;
    }

    public String getBowling_b_1_player_10_dots() {
        return bowling_b_1_player_10_dots;
    }

    public void setBowling_b_1_player_10_dots(String bowling_b_1_player_10_dots) {
        this.bowling_b_1_player_10_dots = bowling_b_1_player_10_dots;
    }

    public String getBowling_b_1_player_10_balls() {
        return bowling_b_1_player_10_balls;
    }

    public void setBowling_b_1_player_10_balls(String bowling_b_1_player_10_balls) {
        this.bowling_b_1_player_10_balls = bowling_b_1_player_10_balls;
    }

    public String getBowling_b_1_player_10_wickets() {
        return bowling_b_1_player_10_wickets;
    }

    public void setBowling_b_1_player_10_wickets(String bowling_b_1_player_10_wickets) {
        this.bowling_b_1_player_10_wickets = bowling_b_1_player_10_wickets;
    }

    public String getBowling_b_1_player_10_extras() {
        return bowling_b_1_player_10_extras;
    }

    public void setBowling_b_1_player_10_extras(String bowling_b_1_player_10_extras) {
        this.bowling_b_1_player_10_extras = bowling_b_1_player_10_extras;
    }

    public String getBowling_b_1_player_10_maiden_overs() {
        return bowling_b_1_player_10_maiden_overs;
    }

    public void setBowling_b_1_player_10_maiden_overs(String bowling_b_1_player_10_maiden_overs) {
        this.bowling_b_1_player_10_maiden_overs = bowling_b_1_player_10_maiden_overs;
    }

    public String getBowling_b_1_player_10_overs() {
        return bowling_b_1_player_10_overs;
    }

    public void setBowling_b_1_player_10_overs(String bowling_b_1_player_10_overs) {
        this.bowling_b_1_player_10_overs = bowling_b_1_player_10_overs;
    }

    public String getBowling_b_2_player_10_name() {
        return bowling_b_2_player_10_name;
    }

    public void setBowling_b_2_player_10_name(String bowling_b_2_player_10_name) {
        this.bowling_b_2_player_10_name = bowling_b_2_player_10_name;
    }

    public String getBowling_b_2_player_10_economy() {
        return bowling_b_2_player_10_economy;
    }

    public void setBowling_b_2_player_10_economy(String bowling_b_2_player_10_economy) {
        this.bowling_b_2_player_10_economy = bowling_b_2_player_10_economy;
    }

    public String getBowling_b_2_player_10_runs() {
        return bowling_b_2_player_10_runs;
    }

    public void setBowling_b_2_player_10_runs(String bowling_b_2_player_10_runs) {
        this.bowling_b_2_player_10_runs = bowling_b_2_player_10_runs;
    }

    public String getBowling_b_2_player_10_dots() {
        return bowling_b_2_player_10_dots;
    }

    public void setBowling_b_2_player_10_dots(String bowling_b_2_player_10_dots) {
        this.bowling_b_2_player_10_dots = bowling_b_2_player_10_dots;
    }

    public String getBowling_b_2_player_10_balls() {
        return bowling_b_2_player_10_balls;
    }

    public void setBowling_b_2_player_10_balls(String bowling_b_2_player_10_balls) {
        this.bowling_b_2_player_10_balls = bowling_b_2_player_10_balls;
    }

    public String getBowling_b_2_player_10_wickets() {
        return bowling_b_2_player_10_wickets;
    }

    public void setBowling_b_2_player_10_wickets(String bowling_b_2_player_10_wickets) {
        this.bowling_b_2_player_10_wickets = bowling_b_2_player_10_wickets;
    }

    public String getBowling_b_2_player_10_extras() {
        return bowling_b_2_player_10_extras;
    }

    public void setBowling_b_2_player_10_extras(String bowling_b_2_player_10_extras) {
        this.bowling_b_2_player_10_extras = bowling_b_2_player_10_extras;
    }

    public String getBowling_b_2_player_10_maiden_overs() {
        return bowling_b_2_player_10_maiden_overs;
    }

    public void setBowling_b_2_player_10_maiden_overs(String bowling_b_2_player_10_maiden_overs) {
        this.bowling_b_2_player_10_maiden_overs = bowling_b_2_player_10_maiden_overs;
    }

    public String getBowling_b_2_player_10_overs() {
        return bowling_b_2_player_10_overs;
    }

    public void setBowling_b_2_player_10_overs(String bowling_b_2_player_10_overs) {
        this.bowling_b_2_player_10_overs = bowling_b_2_player_10_overs;
    }

    public String getBowling_a_1_player_11_name() {
        return bowling_a_1_player_11_name;
    }

    public void setBowling_a_1_player_11_name(String bowling_a_1_player_11_name) {
        this.bowling_a_1_player_11_name = bowling_a_1_player_11_name;
    }

    public String getBowling_a_1_player_11_economy() {
        return bowling_a_1_player_11_economy;
    }

    public void setBowling_a_1_player_11_economy(String bowling_a_1_player_11_economy) {
        this.bowling_a_1_player_11_economy = bowling_a_1_player_11_economy;
    }

    public String getBowling_a_1_player_11_runs() {
        return bowling_a_1_player_11_runs;
    }

    public void setBowling_a_1_player_11_runs(String bowling_a_1_player_11_runs) {
        this.bowling_a_1_player_11_runs = bowling_a_1_player_11_runs;
    }

    public String getBowling_a_1_player_11_dots() {
        return bowling_a_1_player_11_dots;
    }

    public void setBowling_a_1_player_11_dots(String bowling_a_1_player_11_dots) {
        this.bowling_a_1_player_11_dots = bowling_a_1_player_11_dots;
    }

    public String getBowling_a_1_player_11_balls() {
        return bowling_a_1_player_11_balls;
    }

    public void setBowling_a_1_player_11_balls(String bowling_a_1_player_11_balls) {
        this.bowling_a_1_player_11_balls = bowling_a_1_player_11_balls;
    }

    public String getBowling_a_1_player_11_wickets() {
        return bowling_a_1_player_11_wickets;
    }

    public void setBowling_a_1_player_11_wickets(String bowling_a_1_player_11_wickets) {
        this.bowling_a_1_player_11_wickets = bowling_a_1_player_11_wickets;
    }

    public String getBowling_a_1_player_11_extras() {
        return bowling_a_1_player_11_extras;
    }

    public void setBowling_a_1_player_11_extras(String bowling_a_1_player_11_extras) {
        this.bowling_a_1_player_11_extras = bowling_a_1_player_11_extras;
    }

    public String getBowling_a_1_player_11_maiden_overs() {
        return bowling_a_1_player_11_maiden_overs;
    }

    public void setBowling_a_1_player_11_maiden_overs(String bowling_a_1_player_11_maiden_overs) {
        this.bowling_a_1_player_11_maiden_overs = bowling_a_1_player_11_maiden_overs;
    }

    public String getBowling_a_1_player_11_overs() {
        return bowling_a_1_player_11_overs;
    }

    public void setBowling_a_1_player_11_overs(String bowling_a_1_player_11_overs) {
        this.bowling_a_1_player_11_overs = bowling_a_1_player_11_overs;
    }

    public String getBowling_a_2_player_11_name() {
        return bowling_a_2_player_11_name;
    }

    public void setBowling_a_2_player_11_name(String bowling_a_2_player_11_name) {
        this.bowling_a_2_player_11_name = bowling_a_2_player_11_name;
    }

    public String getBowling_a_2_player_11_economy() {
        return bowling_a_2_player_11_economy;
    }

    public void setBowling_a_2_player_11_economy(String bowling_a_2_player_11_economy) {
        this.bowling_a_2_player_11_economy = bowling_a_2_player_11_economy;
    }

    public String getBowling_a_2_player_11_runs() {
        return bowling_a_2_player_11_runs;
    }

    public void setBowling_a_2_player_11_runs(String bowling_a_2_player_11_runs) {
        this.bowling_a_2_player_11_runs = bowling_a_2_player_11_runs;
    }

    public String getBowling_a_2_player_11_dots() {
        return bowling_a_2_player_11_dots;
    }

    public void setBowling_a_2_player_11_dots(String bowling_a_2_player_11_dots) {
        this.bowling_a_2_player_11_dots = bowling_a_2_player_11_dots;
    }

    public String getBowling_a_2_player_11_balls() {
        return bowling_a_2_player_11_balls;
    }

    public void setBowling_a_2_player_11_balls(String bowling_a_2_player_11_balls) {
        this.bowling_a_2_player_11_balls = bowling_a_2_player_11_balls;
    }

    public String getBowling_a_2_player_11_wickets() {
        return bowling_a_2_player_11_wickets;
    }

    public void setBowling_a_2_player_11_wickets(String bowling_a_2_player_11_wickets) {
        this.bowling_a_2_player_11_wickets = bowling_a_2_player_11_wickets;
    }

    public String getBowling_a_2_player_11_extras() {
        return bowling_a_2_player_11_extras;
    }

    public void setBowling_a_2_player_11_extras(String bowling_a_2_player_11_extras) {
        this.bowling_a_2_player_11_extras = bowling_a_2_player_11_extras;
    }

    public String getBowling_a_2_player_11_maiden_overs() {
        return bowling_a_2_player_11_maiden_overs;
    }

    public void setBowling_a_2_player_11_maiden_overs(String bowling_a_2_player_11_maiden_overs) {
        this.bowling_a_2_player_11_maiden_overs = bowling_a_2_player_11_maiden_overs;
    }

    public String getBowling_a_2_player_11_overs() {
        return bowling_a_2_player_11_overs;
    }

    public void setBowling_a_2_player_11_overs(String bowling_a_2_player_11_overs) {
        this.bowling_a_2_player_11_overs = bowling_a_2_player_11_overs;
    }

    public String getBowling_b_1_player_11_name() {
        return bowling_b_1_player_11_name;
    }

    public void setBowling_b_1_player_11_name(String bowling_b_1_player_11_name) {
        this.bowling_b_1_player_11_name = bowling_b_1_player_11_name;
    }

    public String getBowling_b_1_player_11_economy() {
        return bowling_b_1_player_11_economy;
    }

    public void setBowling_b_1_player_11_economy(String bowling_b_1_player_11_economy) {
        this.bowling_b_1_player_11_economy = bowling_b_1_player_11_economy;
    }

    public String getBowling_b_1_player_11_runs() {
        return bowling_b_1_player_11_runs;
    }

    public void setBowling_b_1_player_11_runs(String bowling_b_1_player_11_runs) {
        this.bowling_b_1_player_11_runs = bowling_b_1_player_11_runs;
    }

    public String getBowling_b_1_player_11_dots() {
        return bowling_b_1_player_11_dots;
    }

    public void setBowling_b_1_player_11_dots(String bowling_b_1_player_11_dots) {
        this.bowling_b_1_player_11_dots = bowling_b_1_player_11_dots;
    }

    public String getBowling_b_1_player_11_balls() {
        return bowling_b_1_player_11_balls;
    }

    public void setBowling_b_1_player_11_balls(String bowling_b_1_player_11_balls) {
        this.bowling_b_1_player_11_balls = bowling_b_1_player_11_balls;
    }

    public String getBowling_b_1_player_11_wickets() {
        return bowling_b_1_player_11_wickets;
    }

    public void setBowling_b_1_player_11_wickets(String bowling_b_1_player_11_wickets) {
        this.bowling_b_1_player_11_wickets = bowling_b_1_player_11_wickets;
    }

    public String getBowling_b_1_player_11_extras() {
        return bowling_b_1_player_11_extras;
    }

    public void setBowling_b_1_player_11_extras(String bowling_b_1_player_11_extras) {
        this.bowling_b_1_player_11_extras = bowling_b_1_player_11_extras;
    }

    public String getBowling_b_1_player_11_maiden_overs() {
        return bowling_b_1_player_11_maiden_overs;
    }

    public void setBowling_b_1_player_11_maiden_overs(String bowling_b_1_player_11_maiden_overs) {
        this.bowling_b_1_player_11_maiden_overs = bowling_b_1_player_11_maiden_overs;
    }

    public String getBowling_b_1_player_11_overs() {
        return bowling_b_1_player_11_overs;
    }

    public void setBowling_b_1_player_11_overs(String bowling_b_1_player_11_overs) {
        this.bowling_b_1_player_11_overs = bowling_b_1_player_11_overs;
    }

    public String getBowling_b_2_player_11_name() {
        return bowling_b_2_player_11_name;
    }

    public void setBowling_b_2_player_11_name(String bowling_b_2_player_11_name) {
        this.bowling_b_2_player_11_name = bowling_b_2_player_11_name;
    }

    public String getBowling_b_2_player_11_economy() {
        return bowling_b_2_player_11_economy;
    }

    public void setBowling_b_2_player_11_economy(String bowling_b_2_player_11_economy) {
        this.bowling_b_2_player_11_economy = bowling_b_2_player_11_economy;
    }

    public String getBowling_b_2_player_11_runs() {
        return bowling_b_2_player_11_runs;
    }

    public void setBowling_b_2_player_11_runs(String bowling_b_2_player_11_runs) {
        this.bowling_b_2_player_11_runs = bowling_b_2_player_11_runs;
    }

    public String getBowling_b_2_player_11_dots() {
        return bowling_b_2_player_11_dots;
    }

    public void setBowling_b_2_player_11_dots(String bowling_b_2_player_11_dots) {
        this.bowling_b_2_player_11_dots = bowling_b_2_player_11_dots;
    }

    public String getBowling_b_2_player_11_balls() {
        return bowling_b_2_player_11_balls;
    }

    public void setBowling_b_2_player_11_balls(String bowling_b_2_player_11_balls) {
        this.bowling_b_2_player_11_balls = bowling_b_2_player_11_balls;
    }

    public String getBowling_b_2_player_11_wickets() {
        return bowling_b_2_player_11_wickets;
    }

    public void setBowling_b_2_player_11_wickets(String bowling_b_2_player_11_wickets) {
        this.bowling_b_2_player_11_wickets = bowling_b_2_player_11_wickets;
    }

    public String getBowling_b_2_player_11_extras() {
        return bowling_b_2_player_11_extras;
    }

    public void setBowling_b_2_player_11_extras(String bowling_b_2_player_11_extras) {
        this.bowling_b_2_player_11_extras = bowling_b_2_player_11_extras;
    }

    public String getBowling_b_2_player_11_maiden_overs() {
        return bowling_b_2_player_11_maiden_overs;
    }

    public void setBowling_b_2_player_11_maiden_overs(String bowling_b_2_player_11_maiden_overs) {
        this.bowling_b_2_player_11_maiden_overs = bowling_b_2_player_11_maiden_overs;
    }

    public String getBowling_b_2_player_11_overs() {
        return bowling_b_2_player_11_overs;
    }

    public void setBowling_b_2_player_11_overs(String bowling_b_2_player_11_overs) {
        this.bowling_b_2_player_11_overs = bowling_b_2_player_11_overs;
    }

    public List<String> getInnings_B_2_bowling_order() {
        return innings_B_2_bowling_order;
    }

    public void setInnings_B_2_bowling_order(List<String> innings_B_2_bowling_order) {
        this.innings_B_2_bowling_order = innings_B_2_bowling_order;
    }

    public List<String> getInnings_A_2_bowling_order() {
        return innings_A_2_bowling_order;
    }

    public void setInnings_A_2_bowling_order(List<String> innings_A_2_bowling_order) {
        this.innings_A_2_bowling_order = innings_A_2_bowling_order;
    }

    public String getLatest_batsman_1_name() {
        return latest_batsman_1_name;
    }

    public void setLatest_batsman_1_name(String latest_batsman_1_name) {
        this.latest_batsman_1_name = latest_batsman_1_name;
    }

    public String getLatest_batsman_1_strike_rate() {
        return latest_batsman_1_strike_rate;
    }

    public void setLatest_batsman_1_strike_rate(String latest_batsman_1_strike_rate) {
        this.latest_batsman_1_strike_rate = latest_batsman_1_strike_rate;
    }

    public String getLatest_batsman_1_runs() {
        return latest_batsman_1_runs;
    }

    public void setLatest_batsman_1_runs(String latest_batsman_1_runs) {
        this.latest_batsman_1_runs = latest_batsman_1_runs;
    }

    public String getLatest_batsman_1_balls() {
        return latest_batsman_1_balls;
    }

    public void setLatest_batsman_1_balls(String latest_batsman_1_balls) {
        this.latest_batsman_1_balls = latest_batsman_1_balls;
    }

    public String getLatest_batsman_1_overs() {
        return latest_batsman_1_overs;
    }

    public void setLatest_batsman_1_overs(String latest_batsman_1_overs) {
        this.latest_batsman_1_overs = latest_batsman_1_overs;
    }

    public String getLatest_batsman_1_sixes() {
        return latest_batsman_1_sixes;
    }

    public void setLatest_batsman_1_sixes(String latest_batsman_1_sixes) {
        this.latest_batsman_1_sixes = latest_batsman_1_sixes;
    }

    public String getLatest_batsman_1_fours() {
        return latest_batsman_1_fours;
    }

    public void setLatest_batsman_1_fours(String latest_batsman_1_fours) {
        this.latest_batsman_1_fours = latest_batsman_1_fours;
    }

    public String getLatest_batsman_1_dots() {
        return latest_batsman_1_dots;
    }

    public void setLatest_batsman_1_dots(String latest_batsman_1_dots) {
        this.latest_batsman_1_dots = latest_batsman_1_dots;
    }

    public String getLatest_batsman_2_name() {
        return latest_batsman_2_name;
    }

    public void setLatest_batsman_2_name(String latest_batsman_2_name) {
        this.latest_batsman_2_name = latest_batsman_2_name;
    }

    public String getLatest_batsman_2_strike_rate() {
        return latest_batsman_2_strike_rate;
    }

    public void setLatest_batsman_2_strike_rate(String latest_batsman_2_strike_rate) {
        this.latest_batsman_2_strike_rate = latest_batsman_2_strike_rate;
    }

    public String getLatest_batsman_2_runs() {
        return latest_batsman_2_runs;
    }

    public void setLatest_batsman_2_runs(String latest_batsman_2_runs) {
        this.latest_batsman_2_runs = latest_batsman_2_runs;
    }

    public String getLatest_batsman_2_balls() {
        return latest_batsman_2_balls;
    }

    public void setLatest_batsman_2_balls(String latest_batsman_2_balls) {
        this.latest_batsman_2_balls = latest_batsman_2_balls;
    }

    public String getLatest_batsman_2_overs() {
        return latest_batsman_2_overs;
    }

    public void setLatest_batsman_2_overs(String latest_batsman_2_overs) {
        this.latest_batsman_2_overs = latest_batsman_2_overs;
    }

    public String getLatest_batsman_2_sixes() {
        return latest_batsman_2_sixes;
    }

    public void setLatest_batsman_2_sixes(String latest_batsman_2_sixes) {
        this.latest_batsman_2_sixes = latest_batsman_2_sixes;
    }

    public String getLatest_batsman_2_fours() {
        return latest_batsman_2_fours;
    }

    public void setLatest_batsman_2_fours(String latest_batsman_2_fours) {
        this.latest_batsman_2_fours = latest_batsman_2_fours;
    }

    public String getLatest_batsman_2_dots() {
        return latest_batsman_2_dots;
    }

    public void setLatest_batsman_2_dots(String latest_batsman_2_dots) {
        this.latest_batsman_2_dots = latest_batsman_2_dots;
    }

    public String getLatest_bowler_comment() {
        return latest_bowler_comment;
    }

    public void setLatest_bowler_comment(String latest_bowler_comment) {
        this.latest_bowler_comment = latest_bowler_comment;
    }

    public List<String> getInnings_A_2_batting_order() {
        return innings_A_2_batting_order;
    }

    public void setInnings_A_2_batting_order(List<String> innings_A_2_batting_order) {
        this.innings_A_2_batting_order = innings_A_2_batting_order;
    }

    public int getInnings_A_2_runs() {
        return innings_A_2_runs;
    }

    public void setInnings_A_2_runs(int innings_A_2_runs) {
        this.innings_A_2_runs = innings_A_2_runs;
    }

    public int getInnings_A_2_balls() {
        return innings_A_2_balls;
    }

    public void setInnings_A_2_balls(int innings_A_2_balls) {
        this.innings_A_2_balls = innings_A_2_balls;
    }

    public List<String> getInnings_A_2_fall_of_wickets() {
        return innings_A_2_fall_of_wickets;
    }

    public void setInnings_A_2_fall_of_wickets(List<String> innings_A_2_fall_of_wickets) {
        this.innings_A_2_fall_of_wickets = innings_A_2_fall_of_wickets;
    }

    public int getInnings_A_2_wide() {
        return innings_A_2_wide;
    }

    public void setInnings_A_2_wide(int innings_A_2_wide) {
        this.innings_A_2_wide = innings_A_2_wide;
    }

    public String getInnings_A_2_run_rate() {
        return innings_A_2_run_rate;
    }

    public void setInnings_A_2_run_rate(String innings_A_2_run_rate) {
        this.innings_A_2_run_rate = innings_A_2_run_rate;
    }

    public int getInnings_A_2_fours() {
        return innings_A_2_fours;
    }

    public void setInnings_A_2_fours(int innings_A_2_fours) {
        this.innings_A_2_fours = innings_A_2_fours;
    }

    public String getInnings_A_2_run_str() {
        return innings_A_2_run_str;
    }

    public void setInnings_A_2_run_str(String innings_A_2_run_str) {
        this.innings_A_2_run_str = innings_A_2_run_str;
    }

    public int getInnings_A_2_wickets() {
        return innings_A_2_wickets;
    }

    public void setInnings_A_2_wickets(int innings_A_2_wickets) {
        this.innings_A_2_wickets = innings_A_2_wickets;
    }

    public List<String> getInnings_A_2_wicket_order() {
        return innings_A_2_wicket_order;
    }

    public void setInnings_A_2_wicket_order(List<String> innings_A_2_wicket_order) {
        this.innings_A_2_wicket_order = innings_A_2_wicket_order;
    }

    public int getInnings_A_2_extras() {
        return innings_A_2_extras;
    }

    public void setInnings_A_2_extras(int innings_A_2_extras) {
        this.innings_A_2_extras = innings_A_2_extras;
    }

    public String getInnings_A_2_key() {
        return innings_A_2_key;
    }

    public void setInnings_A_2_key(String innings_A_2_key) {
        this.innings_A_2_key = innings_A_2_key;
    }

    public int getInnings_A_2_noball() {
        return innings_A_2_noball;
    }

    public void setInnings_A_2_noball(int innings_A_2_noball) {
        this.innings_A_2_noball = innings_A_2_noball;
    }

    public int getInnings_A_2_sixes() {
        return innings_A_2_sixes;
    }

    public void setInnings_A_2_sixes(int innings_A_2_sixes) {
        this.innings_A_2_sixes = innings_A_2_sixes;
    }

    public int getInnings_A_2_legbye() {
        return innings_A_2_legbye;
    }

    public void setInnings_A_2_legbye(int innings_A_2_legbye) {
        this.innings_A_2_legbye = innings_A_2_legbye;
    }

    public int getInnings_A_2_bye() {
        return innings_A_2_bye;
    }

    public void setInnings_A_2_bye(int innings_A_2_bye) {
        this.innings_A_2_bye = innings_A_2_bye;
    }

    public String getInnings_A_2_overs() {
        return innings_A_2_overs;
    }

    public void setInnings_A_2_overs(String innings_A_2_overs) {
        this.innings_A_2_overs = innings_A_2_overs;
    }

    public int getInnings_A_2_dotballs() {
        return innings_A_2_dotballs;
    }

    public void setInnings_A_2_dotballs(int innings_A_2_dotballs) {
        this.innings_A_2_dotballs = innings_A_2_dotballs;
    }

    public List<String> getInnings_B_2_batting_order() {
        return innings_B_2_batting_order;
    }

    public void setInnings_B_2_batting_order(List<String> innings_B_2_batting_order) {
        this.innings_B_2_batting_order = innings_B_2_batting_order;
    }

    public int getInnings_B_2_runs() {
        return innings_B_2_runs;
    }

    public void setInnings_B_2_runs(int innings_B_2_runs) {
        this.innings_B_2_runs = innings_B_2_runs;
    }

    public int getInnings_B_2_balls() {
        return innings_B_2_balls;
    }

    public void setInnings_B_2_balls(int innings_B_2_balls) {
        this.innings_B_2_balls = innings_B_2_balls;
    }

    public List<String> getInnings_B_2_fall_of_wickets() {
        return innings_B_2_fall_of_wickets;
    }

    public void setInnings_B_2_fall_of_wickets(List<String> innings_B_2_fall_of_wickets) {
        this.innings_B_2_fall_of_wickets = innings_B_2_fall_of_wickets;
    }

    public int getInnings_B_2_wide() {
        return innings_B_2_wide;
    }

    public void setInnings_B_2_wide(int innings_B_2_wide) {
        this.innings_B_2_wide = innings_B_2_wide;
    }

    public String getInnings_B_2_run_rate() {
        return innings_B_2_run_rate;
    }

    public void setInnings_B_2_run_rate(String innings_B_2_run_rate) {
        this.innings_B_2_run_rate = innings_B_2_run_rate;
    }

    public int getInnings_B_2_fours() {
        return innings_B_2_fours;
    }

    public void setInnings_B_2_fours(int innings_B_2_fours) {
        this.innings_B_2_fours = innings_B_2_fours;
    }

    public String getInnings_B_2_run_str() {
        return innings_B_2_run_str;
    }

    public void setInnings_B_2_run_str(String innings_B_2_run_str) {
        this.innings_B_2_run_str = innings_B_2_run_str;
    }

    public int getInnings_B_2_wickets() {
        return innings_B_2_wickets;
    }

    public void setInnings_B_2_wickets(int innings_B_2_wickets) {
        this.innings_B_2_wickets = innings_B_2_wickets;
    }

    public List<String> getInnings_B_2_wicket_order() {
        return innings_B_2_wicket_order;
    }

    public void setInnings_B_2_wicket_order(List<String> innings_B_2_wicket_order) {
        this.innings_B_2_wicket_order = innings_B_2_wicket_order;
    }

    public int getInnings_B_2_extras() {
        return innings_B_2_extras;
    }

    public void setInnings_B_2_extras(int innings_B_2_extras) {
        this.innings_B_2_extras = innings_B_2_extras;
    }

    public String getInnings_B_2_key() {
        return innings_B_2_key;
    }

    public void setInnings_B_2_key(String innings_B_2_key) {
        this.innings_B_2_key = innings_B_2_key;
    }

    public int getInnings_B_2_noball() {
        return innings_B_2_noball;
    }

    public void setInnings_B_2_noball(int innings_B_2_noball) {
        this.innings_B_2_noball = innings_B_2_noball;
    }

    public int getInnings_B_2_sixes() {
        return innings_B_2_sixes;
    }

    public void setInnings_B_2_sixes(int innings_B_2_sixes) {
        this.innings_B_2_sixes = innings_B_2_sixes;
    }

    public int getInnings_B_2_legbye() {
        return innings_B_2_legbye;
    }

    public void setInnings_B_2_legbye(int innings_B_2_legbye) {
        this.innings_B_2_legbye = innings_B_2_legbye;
    }

    public int getInnings_B_2_bye() {
        return innings_B_2_bye;
    }

    public void setInnings_B_2_bye(int innings_B_2_bye) {
        this.innings_B_2_bye = innings_B_2_bye;
    }

    public String getInnings_B_2_overs() {
        return innings_B_2_overs;
    }

    public void setInnings_B_2_overs(String innings_B_2_overs) {
        this.innings_B_2_overs = innings_B_2_overs;
    }

    public int getInnings_B_2_dotballs() {
        return innings_B_2_dotballs;
    }

    public void setInnings_B_2_dotballs(int innings_B_2_dotballs) {
        this.innings_B_2_dotballs = innings_B_2_dotballs;
    }

    public String getLatest_bowler_1_name() {
        return latest_bowler_1_name;
    }

    public void setLatest_bowler_1_name(String latest_bowler_1_name) {
        this.latest_bowler_1_name = latest_bowler_1_name;
    }

    public String getLatest_bowler_1_over() {
        return latest_bowler_1_over;
    }

    public void setLatest_bowler_1_over(String latest_bowler_1_over) {
        this.latest_bowler_1_over = latest_bowler_1_over;
    }

    public String getLatest_bowler_1_maiden() {
        return latest_bowler_1_maiden;
    }

    public void setLatest_bowler_1_maiden(String latest_bowler_1_maiden) {
        this.latest_bowler_1_maiden = latest_bowler_1_maiden;
    }

    public String getLatest_bowler_1_run() {
        return latest_bowler_1_run;
    }

    public void setLatest_bowler_1_run(String latest_bowler_1_run) {
        this.latest_bowler_1_run = latest_bowler_1_run;
    }

    public String getLatest_bowler_1_wicket() {
        return latest_bowler_1_wicket;
    }

    public void setLatest_bowler_1_wicket(String latest_bowler_1_wicket) {
        this.latest_bowler_1_wicket = latest_bowler_1_wicket;
    }

    public String getLatest_bowler_1_eco() {
        return latest_bowler_1_eco;
    }

    public void setLatest_bowler_1_eco(String latest_bowler_1_eco) {
        this.latest_bowler_1_eco = latest_bowler_1_eco;
    }

    public String getLatest_bowler_2_name() {
        return latest_bowler_2_name;
    }

    public void setLatest_bowler_2_name(String latest_bowler_2_name) {
        this.latest_bowler_2_name = latest_bowler_2_name;
    }

    public String getLatest_bowler_2_over() {
        return latest_bowler_2_over;
    }

    public void setLatest_bowler_2_over(String latest_bowler_2_over) {
        this.latest_bowler_2_over = latest_bowler_2_over;
    }

    public String getLatest_bowler_2_maiden() {
        return latest_bowler_2_maiden;
    }

    public void setLatest_bowler_2_maiden(String latest_bowler_2_maiden) {
        this.latest_bowler_2_maiden = latest_bowler_2_maiden;
    }

    public String getLatest_bowler_2_run() {
        return latest_bowler_2_run;
    }

    public void setLatest_bowler_2_run(String latest_bowler_2_run) {
        this.latest_bowler_2_run = latest_bowler_2_run;
    }

    public String getLatest_bowler_2_wicket() {
        return latest_bowler_2_wicket;
    }

    public void setLatest_bowler_2_wicket(String latest_bowler_2_wicket) {
        this.latest_bowler_2_wicket = latest_bowler_2_wicket;
    }

    public String getLatest_bowler_2_eco() {
        return latest_bowler_2_eco;
    }

    public void setLatest_bowler_2_eco(String latest_bowler_2_eco) {
        this.latest_bowler_2_eco = latest_bowler_2_eco;
    }

 public String getCurrent_batting_team() {
  return current_batting_team;
 }

 public void setCurrent_batting_team(String current_batting_team) {
  this.current_batting_team = current_batting_team;
 }

 public String getCurrent_runrate() {
  return current_runrate;
 }

 public void setCurrent_runrate(String current_runrate) {
  this.current_runrate = current_runrate;
 }

 public String getTeam_a_full_name() {
  return team_a_full_name;
 }

 public void setTeam_a_full_name(String team_a_full_name) {
  this.team_a_full_name = team_a_full_name;
 }

 public String getTeam_b_full_name() {
  return team_b_full_name;
 }

 public void setTeam_b_full_name(String team_b_full_name) {
  this.team_b_full_name = team_b_full_name;
 }

 public List<String> getRecent_over_summary() {
  return recent_over_summary;
 }

 public void setRecent_over_summary(List<String> recent_over_summary) {
  this.recent_over_summary = recent_over_summary;
 }

 public Integer getFormat_code() {
  return format_code;
 }

 public void setFormat_code(Integer format_code) {
  this.format_code = format_code;
 }

 public String getTeam_a_full_score() {
  return team_a_full_score;
 }

 public void setTeam_a_full_score(String team_a_full_score) {
  this.team_a_full_score = team_a_full_score;
 }

 public String getTeam_b_full_score() {
  return team_b_full_score;
 }

 public void setTeam_b_full_score(String team_b_full_score) {
  this.team_b_full_score = team_b_full_score;
 }

 public String getInnings_A_1_batting_player_1_innings_2_full_name() {
  return innings_A_1_batting_player_1_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_1_innings_2_full_name(String innings_A_1_batting_player_1_innings_2_full_name) {
  this.innings_A_1_batting_player_1_innings_2_full_name = innings_A_1_batting_player_1_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_2_innings_2_full_name() {
  return innings_A_1_batting_player_2_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_2_innings_2_full_name(String innings_A_1_batting_player_2_innings_2_full_name) {
  this.innings_A_1_batting_player_2_innings_2_full_name = innings_A_1_batting_player_2_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_3_innings_2_full_name() {
  return innings_A_1_batting_player_3_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_3_innings_2_full_name(String innings_A_1_batting_player_3_innings_2_full_name) {
  this.innings_A_1_batting_player_3_innings_2_full_name = innings_A_1_batting_player_3_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_4_innings_2_full_name() {
  return innings_A_1_batting_player_4_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_4_innings_2_full_name(String innings_A_1_batting_player_4_innings_2_full_name) {
  this.innings_A_1_batting_player_4_innings_2_full_name = innings_A_1_batting_player_4_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_5_innings_2_full_name() {
  return innings_A_1_batting_player_5_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_5_innings_2_full_name(String innings_A_1_batting_player_5_innings_2_full_name) {
  this.innings_A_1_batting_player_5_innings_2_full_name = innings_A_1_batting_player_5_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_6_innings_2_full_name() {
  return innings_A_1_batting_player_6_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_6_innings_2_full_name(String innings_A_1_batting_player_6_innings_2_full_name) {
  this.innings_A_1_batting_player_6_innings_2_full_name = innings_A_1_batting_player_6_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_7_innings_2_full_name() {
  return innings_A_1_batting_player_7_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_7_innings_2_full_name(String innings_A_1_batting_player_7_innings_2_full_name) {
  this.innings_A_1_batting_player_7_innings_2_full_name = innings_A_1_batting_player_7_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_8_innings_2_full_name() {
  return innings_A_1_batting_player_8_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_8_innings_2_full_name(String innings_A_1_batting_player_8_innings_2_full_name) {
  this.innings_A_1_batting_player_8_innings_2_full_name = innings_A_1_batting_player_8_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_9_innings_2_full_name() {
  return innings_A_1_batting_player_9_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_9_innings_2_full_name(String innings_A_1_batting_player_9_innings_2_full_name) {
  this.innings_A_1_batting_player_9_innings_2_full_name = innings_A_1_batting_player_9_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_10_innings_2_full_name() {
  return innings_A_1_batting_player_10_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_10_innings_2_full_name(String innings_A_1_batting_player_10_innings_2_full_name) {
  this.innings_A_1_batting_player_10_innings_2_full_name = innings_A_1_batting_player_10_innings_2_full_name;
 }

 public String getInnings_A_1_batting_player_11_innings_2_full_name() {
  return innings_A_1_batting_player_11_innings_2_full_name;
 }

 public void setInnings_A_1_batting_player_11_innings_2_full_name(String innings_A_1_batting_player_11_innings_2_full_name) {
  this.innings_A_1_batting_player_11_innings_2_full_name = innings_A_1_batting_player_11_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_1_innings_2_full_name() {
  return innings_B_1_batting_player_1_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_1_innings_2_full_name(String innings_B_1_batting_player_1_innings_2_full_name) {
  this.innings_B_1_batting_player_1_innings_2_full_name = innings_B_1_batting_player_1_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_2_innings_2_full_name() {
  return innings_B_1_batting_player_2_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_2_innings_2_full_name(String innings_B_1_batting_player_2_innings_2_full_name) {
  this.innings_B_1_batting_player_2_innings_2_full_name = innings_B_1_batting_player_2_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_3_innings_2_full_name() {
  return innings_B_1_batting_player_3_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_3_innings_2_full_name(String innings_B_1_batting_player_3_innings_2_full_name) {
  this.innings_B_1_batting_player_3_innings_2_full_name = innings_B_1_batting_player_3_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_4_innings_2_full_name() {
  return innings_B_1_batting_player_4_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_4_innings_2_full_name(String innings_B_1_batting_player_4_innings_2_full_name) {
  this.innings_B_1_batting_player_4_innings_2_full_name = innings_B_1_batting_player_4_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_5_innings_2_full_name() {
  return innings_B_1_batting_player_5_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_5_innings_2_full_name(String innings_B_1_batting_player_5_innings_2_full_name) {
  this.innings_B_1_batting_player_5_innings_2_full_name = innings_B_1_batting_player_5_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_6_innings_2_full_name() {
  return innings_B_1_batting_player_6_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_6_innings_2_full_name(String innings_B_1_batting_player_6_innings_2_full_name) {
  this.innings_B_1_batting_player_6_innings_2_full_name = innings_B_1_batting_player_6_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_7_innings_2_full_name() {
  return innings_B_1_batting_player_7_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_7_innings_2_full_name(String innings_B_1_batting_player_7_innings_2_full_name) {
  this.innings_B_1_batting_player_7_innings_2_full_name = innings_B_1_batting_player_7_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_8_innings_2_full_name() {
  return innings_B_1_batting_player_8_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_8_innings_2_full_name(String innings_B_1_batting_player_8_innings_2_full_name) {
  this.innings_B_1_batting_player_8_innings_2_full_name = innings_B_1_batting_player_8_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_9_innings_2_full_name() {
  return innings_B_1_batting_player_9_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_9_innings_2_full_name(String innings_B_1_batting_player_9_innings_2_full_name) {
  this.innings_B_1_batting_player_9_innings_2_full_name = innings_B_1_batting_player_9_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_10_innings_2_full_name() {
  return innings_B_1_batting_player_10_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_10_innings_2_full_name(String innings_B_1_batting_player_10_innings_2_full_name) {
  this.innings_B_1_batting_player_10_innings_2_full_name = innings_B_1_batting_player_10_innings_2_full_name;
 }

 public String getInnings_B_1_batting_player_11_innings_2_full_name() {
  return innings_B_1_batting_player_11_innings_2_full_name;
 }

 public void setInnings_B_1_batting_player_11_innings_2_full_name(String innings_B_1_batting_player_11_innings_2_full_name) {
  this.innings_B_1_batting_player_11_innings_2_full_name = innings_B_1_batting_player_11_innings_2_full_name;
 }


}
