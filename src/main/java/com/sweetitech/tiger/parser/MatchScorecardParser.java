//package com.sweetitech.tiger.parser;
//
//
//import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;
//import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
//import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;
//import com.sweetitech.tiger.model.EntitySportAPI.LiveMatch.LiveMatch;
//import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.Innings;
//import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.MatchScorecard;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class MatchScorecardParser {
//
//
//    MatchScorecard matchScorecard;// = new MatchScorecard(); //need to hit MatchScorecard api top get data
//
//    Innings innings1;
//    Innings innings2;
//    Innings innings3;
//    Innings innings4;
//
//
//    List<Player> innings1BatsmanList;
//    List<Player> innings2BatsmanList;
//    List<Player> innings3BatsmanList;
//    List<Player> innings4BatsmanList;
//
//
//    List<Player> innings1BowlerList;
//    List<Player> innings2BowlerList;
//    List<Player> innings3BowlerList;
//    List<Player> innings4BowlerList;
//
//
//    LiveMatch liveMatch;
//    Match matchForLiveMatch;
//
//    public MatchScorecardParser(MatchScorecard matchScorecard, LiveMatch liveMatch) {
//        this.matchScorecard = matchScorecard;
//        this.liveMatch = liveMatch;
//
//
//        initializeInningsProperty();
//        initializeRecentBatsman();
//        initializeAllInningsBowlers();
//        initializeMatchProperty();
//        initializeAllInningsBatsmans();
//
//
//    }
//
//    public void initializeInningsProperty()
//    {
//        if(matchScorecard.getResponse().getInnings().size() == 2)
//
//        {
//            innings1 = matchScorecard.getResponse().getInnings().get(0);
//            innings2 = matchScorecard.getResponse().getInnings().get(1);
//
//            innings1BatsmanList = innings1.getBatsmen();
//
//            innings2BatsmanList = innings2.getBatsmen();
//
//            innings1BowlerList = innings1.getBowlers();
//
//            innings2BowlerList = innings2.getBowlers();
//        }
//        else
//        {
//            // Condition for follow on
//
//            innings1 = matchScorecard.getResponse().getInnings().get(0);
//            innings2 = matchScorecard.getResponse().getInnings().get(1);
//            innings3 = matchScorecard.getResponse().getInnings().get(2);
//            innings4 = matchScorecard.getResponse().getInnings().get(3);
//
//            innings1BatsmanList = innings1.getBatsmanList();
//            innings2BatsmanList = innings2.getBatsmanList();
//            innings3BatsmanList = innings3.getBatsmanList();
//            innings4BatsmanList = innings4.getBatsmanList();
//
//            innings1BowlerList = innings1.getBowlerList();
//            innings2BowlerList = innings2.getBowlerList();
//            innings3BowlerList = innings3.getBowlerList();
//            innings4BowlerList = innings4.getBowlerList();
//        }
//
//      if(liveMatch.getMatch() !=null)
//      {
//          matchForLiveMatch = liveMatch.getMatch();
//      }
//      else
//      {
//          matchForLiveMatch = new Match();
//      }
//
//    }
//
//
//    //Recent Batsman variable
//    String latest_batsman_1_name = null;
//    String latest_batsman_1_strike_rate = null;
//    String latest_batsman_1_runs = null;
//    String latest_batsman_1_balls = null;
//    String latest_batsman_1_sixes = null;
//    String latest_batsman_1_fours = null;
//
//    String latest_batsman_2_name = null;
//    String latest_batsman_2_strike_rate = null;
//    String latest_batsman_2_runs = null;
//    String latest_batsman_2_balls = null;
//    String latest_batsman_2_sixes = null;
//    String latest_batsman_2_fours = null;
//
//    public void initializeRecentBatsman()
//    {
//        if(matchForLiveMatch != null)
//        {
//            try {
//                latest_batsman_1_name = matchForLiveMatch.getBatsmanList().get(0).getTitle();
//                latest_batsman_1_strike_rate = matchForLiveMatch.getBatsmanList().get(0).getStrike_rate();
//                latest_batsman_1_runs = matchForLiveMatch.getBatsmanList().get(0).getRuns().toString();
//                latest_batsman_1_balls = matchForLiveMatch.getBatsmanList().get(0).getBalls_faced().toString();
//                latest_batsman_1_sixes = matchForLiveMatch.getBatsmanList().get(0).getSixes().toString();
//                latest_batsman_1_fours = matchForLiveMatch.getBatsmanList().get(0).getFours().toString();
//
//                latest_batsman_2_name = matchForLiveMatch.getBatsmanList().get(1).getTitle();
//                latest_batsman_2_strike_rate = matchForLiveMatch.getBatsmanList().get(1).getStrike_rate();
//                latest_batsman_2_runs = matchForLiveMatch.getBatsmanList().get(1).getRuns().toString();
//                latest_batsman_2_balls = matchForLiveMatch.getBatsmanList().get(1).getBalls_faced().toString();
//                latest_batsman_2_sixes = matchForLiveMatch.getBatsmanList().get(1).getSixes().toString();
//                latest_batsman_2_fours = matchForLiveMatch.getBatsmanList().get(1).getFours().toString();
//            }
//            catch (Exception e)
//            {
//                System.out.println("Exception in initializeRecentBatsman");
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//
//    public String getLatest_batsman_1_name() {
//        return latest_batsman_1_name;
//    }
//
//    public void setLatest_batsman_1_name(String latest_batsman_1_name) {
//        this.latest_batsman_1_name = latest_batsman_1_name;
//    }
//
//    public String getLatest_batsman_1_strike_rate() {
//        return latest_batsman_1_strike_rate;
//    }
//
//    public void setLatest_batsman_1_strike_rate(String latest_batsman_1_strike_rate) {
//        this.latest_batsman_1_strike_rate = latest_batsman_1_strike_rate;
//    }
//
//    public String getLatest_batsman_1_runs() {
//        return latest_batsman_1_runs;
//    }
//
//    public void setLatest_batsman_1_runs(String latest_batsman_1_runs) {
//        this.latest_batsman_1_runs = latest_batsman_1_runs;
//    }
//
//    public String getLatest_batsman_1_balls() {
//        return latest_batsman_1_balls;
//    }
//
//    public void setLatest_batsman_1_balls(String latest_batsman_1_balls) {
//        this.latest_batsman_1_balls = latest_batsman_1_balls;
//    }
//
//    public String getLatest_batsman_1_sixes() {
//        return latest_batsman_1_sixes;
//    }
//
//    public void setLatest_batsman_1_sixes(String latest_batsman_1_sixes) {
//        this.latest_batsman_1_sixes = latest_batsman_1_sixes;
//    }
//
//    public String getLatest_batsman_1_fours() {
//        return latest_batsman_1_fours;
//    }
//
//    public void setLatest_batsman_1_fours(String latest_batsman_1_fours) {
//        this.latest_batsman_1_fours = latest_batsman_1_fours;
//    }
//
//    public String getLatest_batsman_2_name() {
//        return latest_batsman_2_name;
//    }
//
//    public void setLatest_batsman_2_name(String latest_batsman_2_name) {
//        this.latest_batsman_2_name = latest_batsman_2_name;
//    }
//
//    public String getLatest_batsman_2_strike_rate() {
//        return latest_batsman_2_strike_rate;
//    }
//
//    public void setLatest_batsman_2_strike_rate(String latest_batsman_2_strike_rate) {
//        this.latest_batsman_2_strike_rate = latest_batsman_2_strike_rate;
//    }
//
//    public String getLatest_batsman_2_runs() {
//        return latest_batsman_2_runs;
//    }
//
//    public void setLatest_batsman_2_runs(String latest_batsman_2_runs) {
//        this.latest_batsman_2_runs = latest_batsman_2_runs;
//    }
//
//    public String getLatest_batsman_2_balls() {
//        return latest_batsman_2_balls;
//    }
//
//    public void setLatest_batsman_2_balls(String latest_batsman_2_balls) {
//        this.latest_batsman_2_balls = latest_batsman_2_balls;
//    }
//
//    public String getLatest_batsman_2_sixes() {
//        return latest_batsman_2_sixes;
//    }
//
//    public void setLatest_batsman_2_sixes(String latest_batsman_2_sixes) {
//        this.latest_batsman_2_sixes = latest_batsman_2_sixes;
//    }
//
//    public String getLatest_batsman_2_fours() {
//        return latest_batsman_2_fours;
//    }
//
//    public void setLatest_batsman_2_fours(String latest_batsman_2_fours) {
//        this.latest_batsman_2_fours = latest_batsman_2_fours;
//    }
//
//    //All Innings Bowlers
//    String bowling_a_1_player_1_name = null;
//    String bowling_a_1_player_1_economy = null;
//    String bowling_a_1_player_1_runs = null;
//    String bowling_a_1_player_1_wickets = null;
//    String bowling_a_1_player_1_extras = null;
//    String bowling_a_1_player_1_maiden_overs = null;
//    String bowling_a_1_player_1_overs = null;
//
//    String bowling_a_2_player_1_name = null;
//    String bowling_a_2_player_1_economy = null;
//    String bowling_a_2_player_1_runs = null;
//    String bowling_a_2_player_1_wickets= null;
//    String bowling_a_2_player_1_extras= null;
//    String bowling_a_2_player_1_maiden_overs= null;
//    String bowling_a_2_player_1_overs= null;
//
//    String bowling_b_1_player_1_name = null;
//    String bowling_b_1_player_1_economy = null;
//    String bowling_b_1_player_1_runs = null;
//    String bowling_b_1_player_1_wickets = null;
//    String bowling_b_1_player_1_extras = null;
//    String bowling_b_1_player_1_maiden_overs = null;
//    String bowling_b_1_player_1_overs = null;
//
//    String bowling_b_2_player_1_name = null;
//    String bowling_b_2_player_1_economy = null;
//    String bowling_b_2_player_1_runs = null;
//    String bowling_b_2_player_1_wickets = null;
//    String bowling_b_2_player_1_extras = null;
//    String bowling_b_2_player_1_maiden_overs = null;
//    String bowling_b_2_player_1_overs = null;
//
//    //player 2
//    String bowling_a_1_player_2_name = null;
//    String bowling_a_1_player_2_economy = null;
//    String bowling_a_1_player_2_runs = null;
//    String bowling_a_1_player_2_wickets = null;
//    String bowling_a_1_player_2_extras = null;
//    String bowling_a_1_player_2_maiden_overs = null;
//    String bowling_a_1_player_2_overs = null;
//
//    String bowling_a_2_player_2_name = null;
//    String bowling_a_2_player_2_economy = null;
//    String bowling_a_2_player_2_runs = null;
//    String bowling_a_2_player_2_wickets = null;
//    String bowling_a_2_player_2_extras = null;
//    String bowling_a_2_player_2_maiden_overs = null;
//    String bowling_a_2_player_2_overs = null;
//
//    String bowling_b_1_player_2_name = null;
//    String bowling_b_1_player_2_economy = null;
//    String bowling_b_1_player_2_runs = null;
//    String bowling_b_1_player_2_wickets = null;
//    String bowling_b_1_player_2_extras = null;
//    String bowling_b_1_player_2_maiden_overs = null;
//    String bowling_b_1_player_2_overs = null;
//
//    String bowling_b_2_player_2_name = null;
//    String bowling_b_2_player_2_economy = null;
//    String bowling_b_2_player_2_runs = null;
//    String bowling_b_2_player_2_wickets = null;
//    String bowling_b_2_player_2_extras = null;
//    String bowling_b_2_player_2_maiden_overs = null;
//    String bowling_b_2_player_2_overs = null;
//
//    //player 3
//    String bowling_a_1_player_3_name = null;
//    String bowling_a_1_player_3_economy = null;
//    String bowling_a_1_player_3_runs = null;
//    String bowling_a_1_player_3_wickets = null;
//    String bowling_a_1_player_3_extras = null;
//    String bowling_a_1_player_3_maiden_overs = null;
//    String bowling_a_1_player_3_overs = null;
//
//    String bowling_a_2_player_3_name = null;
//    String bowling_a_2_player_3_economy = null;
//    String bowling_a_2_player_3_runs = null;
//    String bowling_a_2_player_3_wickets = null;
//    String bowling_a_2_player_3_extras = null;
//    String bowling_a_2_player_3_maiden_overs = null;
//    String bowling_a_2_player_3_overs = null;
//
//    String bowling_b_1_player_3_name = null;
//    String bowling_b_1_player_3_economy = null;
//    String bowling_b_1_player_3_runs = null;
//    String bowling_b_1_player_3_wickets = null;
//    String bowling_b_1_player_3_extras = null;
//    String bowling_b_1_player_3_maiden_overs = null;
//    String bowling_b_1_player_3_overs = null;
//
//    String bowling_b_2_player_3_name = null;
//    String bowling_b_2_player_3_economy = null;
//    String bowling_b_2_player_3_runs = null;
//    String bowling_b_2_player_3_wickets = null;
//    String bowling_b_2_player_3_extras = null;
//    String bowling_b_2_player_3_maiden_overs = null;
//    String bowling_b_2_player_3_overs = null;
//
//    //player 4
//    String bowling_a_1_player_4_name = null;
//    String bowling_a_1_player_4_economy = null;
//    String bowling_a_1_player_4_runs = null;
//    String bowling_a_1_player_4_wickets = null;
//    String bowling_a_1_player_4_extras = null;
//    String bowling_a_1_player_4_maiden_overs = null;
//    String bowling_a_1_player_4_overs = null;
//
//    String bowling_a_2_player_4_name = null;
//    String bowling_a_2_player_4_economy = null;
//    String bowling_a_2_player_4_runs = null;
//    String bowling_a_2_player_4_wickets = null;
//    String bowling_a_2_player_4_extras = null;
//    String bowling_a_2_player_4_maiden_overs = null;
//    String bowling_a_2_player_4_overs = null;
//
//    String bowling_b_1_player_4_name = null;
//    String bowling_b_1_player_4_economy = null;
//    String bowling_b_1_player_4_runs = null;
//    String bowling_b_1_player_4_wickets = null;
//    String bowling_b_1_player_4_extras = null;
//    String bowling_b_1_player_4_maiden_overs = null;
//    String bowling_b_1_player_4_overs = null;
//
//    String bowling_b_2_player_4_name = null;
//    String bowling_b_2_player_4_economy = null;
//    String bowling_b_2_player_4_runs = null;
//    String bowling_b_2_player_4_wickets = null;
//    String bowling_b_2_player_4_extras = null;
//    String bowling_b_2_player_4_maiden_overs = null;
//    String bowling_b_2_player_4_overs = null;
//
//    //player 5
//    String bowling_a_1_player_5_name = null;
//    String bowling_a_1_player_5_economy = null;
//    String bowling_a_1_player_5_runs = null;
//    String bowling_a_1_player_5_wickets = null;
//    String bowling_a_1_player_5_extras = null;
//    String bowling_a_1_player_5_maiden_overs = null;
//    String bowling_a_1_player_5_overs = null;
//
//    String bowling_a_2_player_5_name = null;
//    String bowling_a_2_player_5_economy = null;
//    String bowling_a_2_player_5_runs = null;
//    String bowling_a_2_player_5_wickets = null;
//    String bowling_a_2_player_5_extras = null;
//    String bowling_a_2_player_5_maiden_overs = null;
//    String bowling_a_2_player_5_overs = null;
//
//    String bowling_b_1_player_5_name = null;
//    String bowling_b_1_player_5_economy = null;
//    String bowling_b_1_player_5_runs = null;
//    String bowling_b_1_player_5_wickets = null;
//    String bowling_b_1_player_5_extras = null;
//    String bowling_b_1_player_5_maiden_overs = null;
//    String bowling_b_1_player_5_overs = null;
//
//    String bowling_b_2_player_5_name = null;
//    String bowling_b_2_player_5_economy = null;
//    String bowling_b_2_player_5_runs = null;
//    String bowling_b_2_player_5_wickets = null;
//    String bowling_b_2_player_5_extras = null;
//    String bowling_b_2_player_5_maiden_overs = null;
//    String bowling_b_2_player_5_overs = null;
//
//    //player 6
//    String bowling_a_1_player_6_name = null;
//    String bowling_a_1_player_6_economy = null;
//    String bowling_a_1_player_6_runs = null;
//    String bowling_a_1_player_6_wickets = null;
//    String bowling_a_1_player_6_extras = null;
//    String bowling_a_1_player_6_maiden_overs = null;
//    String bowling_a_1_player_6_overs = null;
//
//    String bowling_a_2_player_6_name = null;
//    String bowling_a_2_player_6_economy = null;
//    String bowling_a_2_player_6_runs = null;
//    String bowling_a_2_player_6_wickets = null;
//    String bowling_a_2_player_6_extras = null;
//    String bowling_a_2_player_6_maiden_overs = null;
//    String bowling_a_2_player_6_overs = null;
//
//    String bowling_b_1_player_6_name = null;
//    String bowling_b_1_player_6_economy = null;
//    String bowling_b_1_player_6_runs = null;
//    String bowling_b_1_player_6_wickets = null;
//    String bowling_b_1_player_6_extras = null;
//    String bowling_b_1_player_6_maiden_overs = null;
//    String bowling_b_1_player_6_overs = null;
//
//    String bowling_b_2_player_6_name = null;
//    String bowling_b_2_player_6_economy = null;
//    String bowling_b_2_player_6_runs = null;
//    String bowling_b_2_player_6_wickets = null;
//    String bowling_b_2_player_6_extras = null;
//    String bowling_b_2_player_6_maiden_overs = null;
//    String bowling_b_2_player_6_overs = null;
//
//    //player 7
//    String bowling_a_1_player_7_name = null;
//    String bowling_a_1_player_7_economy = null;
//    String bowling_a_1_player_7_runs = null;
//    String bowling_a_1_player_7_wickets = null;
//    String bowling_a_1_player_7_extras = null;
//    String bowling_a_1_player_7_maiden_overs = null;
//    String bowling_a_1_player_7_overs = null;
//
//    String bowling_a_2_player_7_name = null;
//    String bowling_a_2_player_7_economy = null;
//    String bowling_a_2_player_7_runs = null;
//    String bowling_a_2_player_7_wickets = null;
//    String bowling_a_2_player_7_extras = null;
//    String bowling_a_2_player_7_maiden_overs = null;
//    String bowling_a_2_player_7_overs = null;
//
//    String bowling_b_1_player_7_name = null;
//    String bowling_b_1_player_7_economy = null;
//    String bowling_b_1_player_7_runs = null;
//    String bowling_b_1_player_7_wickets = null;
//    String bowling_b_1_player_7_extras = null;
//    String bowling_b_1_player_7_maiden_overs = null;
//    String bowling_b_1_player_7_overs = null;
//
//    String bowling_b_2_player_7_name = null;
//    String bowling_b_2_player_7_economy = null;
//    String bowling_b_2_player_7_runs = null;
//    String bowling_b_2_player_7_wickets = null;
//    String bowling_b_2_player_7_extras = null;
//    String bowling_b_2_player_7_maiden_overs = null;
//    String bowling_b_2_player_7_overs = null;
//
//    //player 8
//    String bowling_a_1_player_8_name = null;
//    String bowling_a_1_player_8_economy  = null;
//    String bowling_a_1_player_8_runs = null;
//    String bowling_a_1_player_8_wickets = null;
//    String bowling_a_1_player_8_extras = null;
//    String bowling_a_1_player_8_maiden_overs = null;
//    String bowling_a_1_player_8_overs;
//
//    String bowling_a_2_player_8_name = null;
//    String bowling_a_2_player_8_economy = null;
//    String bowling_a_2_player_8_runs = null;
//    String bowling_a_2_player_8_wickets = null;
//    String bowling_a_2_player_8_extras = null;
//    String bowling_a_2_player_8_maiden_overs = null;
//    String bowling_a_2_player_8_overs = null;
//
//    String bowling_b_1_player_8_name = null;
//    String bowling_b_1_player_8_economy = null;
//    String bowling_b_1_player_8_runs = null;
//    String bowling_b_1_player_8_wickets = null;
//    String bowling_b_1_player_8_extras = null;
//    String bowling_b_1_player_8_maiden_overs = null;
//    String bowling_b_1_player_8_overs = null;
//
//    String bowling_b_2_player_8_name = null;
//    String bowling_b_2_player_8_economy = null;
//    String bowling_b_2_player_8_runs = null;
//    String bowling_b_2_player_8_wickets = null;
//    String bowling_b_2_player_8_extras = null;
//    String bowling_b_2_player_8_maiden_overs = null;
//    String bowling_b_2_player_8_overs = null;
//
//    //player 9
//    String bowling_a_1_player_9_name = null;
//    String bowling_a_1_player_9_economy = null;
//    String bowling_a_1_player_9_runs = null;
//    String bowling_a_1_player_9_wickets = null;
//    String bowling_a_1_player_9_extras = null;
//    String bowling_a_1_player_9_maiden_overs = null;
//    String bowling_a_1_player_9_overs = null;
//
//    String bowling_a_2_player_9_name = null;
//    String bowling_a_2_player_9_economy = null;
//    String bowling_a_2_player_9_runs = null;
//    String bowling_a_2_player_9_wickets = null;
//    String bowling_a_2_player_9_extras = null;
//    String bowling_a_2_player_9_maiden_overs = null;
//    String bowling_a_2_player_9_overs = null;
//
//    String bowling_b_1_player_9_name  = null;
//    String bowling_b_1_player_9_economy = null;
//    String bowling_b_1_player_9_runs  = null;
//    String bowling_b_1_player_9_wickets  = null;
//    String bowling_b_1_player_9_extras = null;
//    String bowling_b_1_player_9_maiden_overs = null;
//    String bowling_b_1_player_9_overs = null;
//
//    String bowling_b_2_player_9_name = null;
//    String bowling_b_2_player_9_economy = null;
//    String bowling_b_2_player_9_runs = null;
//    String bowling_b_2_player_9_wickets = null;
//    String bowling_b_2_player_9_extras = null;
//    String bowling_b_2_player_9_maiden_overs = null;
//    String bowling_b_2_player_9_overs = null;
//
//    //player 10
//    String bowling_a_1_player_10_name = null;
//    String bowling_a_1_player_10_economy = null;
//    String bowling_a_1_player_10_runs = null;
//    String bowling_a_1_player_10_wickets = null;
//    String bowling_a_1_player_10_extras = null;
//    String bowling_a_1_player_10_maiden_overs = null;
//    String bowling_a_1_player_10_overs = null;
//
//    String bowling_a_2_player_10_name = null;
//    String bowling_a_2_player_10_economy = null;
//    String bowling_a_2_player_10_runs = null;
//    String bowling_a_2_player_10_wickets = null;
//    String bowling_a_2_player_10_extras = null;
//    String bowling_a_2_player_10_maiden_overs = null;
//    String bowling_a_2_player_10_overs = null;
//
//    String bowling_b_1_player_10_name = null;
//    String bowling_b_1_player_10_economy = null;
//    String bowling_b_1_player_10_runs = null;
//    String bowling_b_1_player_10_wickets = null;
//    String bowling_b_1_player_10_extras = null;
//    String bowling_b_1_player_10_maiden_overs = null;
//    String bowling_b_1_player_10_overs = null;
//
//    String bowling_b_2_player_10_name = null;
//    String bowling_b_2_player_10_economy = null;
//    String bowling_b_2_player_10_runs = null;
//    String bowling_b_2_player_10_wickets = null;
//    String bowling_b_2_player_10_extras = null;
//    String bowling_b_2_player_10_maiden_overs = null;
//    String bowling_b_2_player_10_overs = null;
//
//    //player 11
//    String bowling_a_1_player_11_name = null;
//    String bowling_a_1_player_11_economy = null;
//    String bowling_a_1_player_11_runs = null;
//    String bowling_a_1_player_11_wickets = null;
//    String bowling_a_1_player_11_extras = null;
//    String bowling_a_1_player_11_maiden_overs = null;
//    String bowling_a_1_player_11_overs = null;
//
//    String bowling_a_2_player_11_name = null;
//    String bowling_a_2_player_11_economy  = null;
//    String bowling_a_2_player_11_runs = null;
//    String bowling_a_2_player_11_wickets = null;
//    String bowling_a_2_player_11_extras = null;
//    String bowling_a_2_player_11_maiden_overs = null;
//    String bowling_a_2_player_11_overs = null;
//
//    String bowling_b_1_player_11_name = null;
//    String bowling_b_1_player_11_economy = null;
//    String bowling_b_1_player_11_runs = null;
//    String bowling_b_1_player_11_wickets = null;
//    String bowling_b_1_player_11_extras = null;
//    String bowling_b_1_player_11_maiden_overs = null;
//    String bowling_b_1_player_11_overs = null;
//
//    String bowling_b_2_player_11_name = null;
//    String bowling_b_2_player_11_economy = null;
//    String bowling_b_2_player_11_runs = null;
//    String bowling_b_2_player_11_wickets = null;
//    String bowling_b_2_player_11_extras = null;
//    String bowling_b_2_player_11_maiden_overs = null;
//    String bowling_b_2_player_11_overs = null;
//
//    public void initializeAllInningsBowlers()
//    {
//        if(matchScorecard.getMatch().getInningsList().size() == 2)
//        {
//            //Innings 1 bowlwer list
//            //player 1
//            bowling_a_1_player_1_name = innings1BowlerList.get(0).getShort_name();
//            bowling_a_1_player_1_economy = innings1BowlerList.get(0).getEcon();
//            bowling_a_1_player_1_runs = innings1BowlerList.get(0).getRuns_conceded().toString();
//            bowling_a_1_player_1_wickets =innings1BowlerList.get(0).getWickets().toString();
//            bowling_a_1_player_1_extras = Integer.toString(innings1BowlerList.get(0).getWides()+innings1BowlerList.get(0).getNoballs());
//            bowling_a_1_player_1_maiden_overs = innings1BowlerList.get(0).getMaidens().toString();
//            bowling_a_1_player_1_overs = innings1BowlerList.get(0).getOvers();
//            //player 2
//            bowling_a_1_player_2_name = innings1BowlerList.get(1).getShort_name();
//            bowling_a_1_player_2_economy = innings1BowlerList.get(1).getEcon();
//            bowling_a_1_player_2_runs = innings1BowlerList.get(1).getRuns_conceded().toString();
//            bowling_a_1_player_2_wickets =innings1BowlerList.get(1).getWickets().toString();
//            bowling_a_1_player_2_extras = Integer.toString(innings1BowlerList.get(1).getWides()+innings1BowlerList.get(1).getNoballs());
//            bowling_a_1_player_2_maiden_overs = innings1BowlerList.get(1).getMaidens().toString();
//            bowling_a_1_player_2_overs = innings1BowlerList.get(1).getOvers();
//            //player 3
//            bowling_a_1_player_3_name = innings1BowlerList.get(2).getShort_name();
//            bowling_a_1_player_3_economy = innings1BowlerList.get(2).getEcon();
//            bowling_a_1_player_3_runs = innings1BowlerList.get(2).getRuns_conceded().toString();
//            bowling_a_1_player_3_wickets =innings1BowlerList.get(2).getWickets().toString();
//            bowling_a_1_player_3_extras = Integer.toString(innings1BowlerList.get(2).getWides()+innings1BowlerList.get(2).getNoballs());
//            bowling_a_1_player_3_maiden_overs = innings1BowlerList.get(2).getMaidens().toString();
//            bowling_a_1_player_3_overs = innings1BowlerList.get(2).getOvers();
//            //player 4
//            bowling_a_1_player_4_name = innings1BowlerList.get(3).getShort_name();
//            bowling_a_1_player_4_economy = innings1BowlerList.get(3).getEcon();
//            bowling_a_1_player_4_runs = innings1BowlerList.get(3).getRuns_conceded().toString();
//            bowling_a_1_player_4_wickets =innings1BowlerList.get(3).getWickets().toString();
//            bowling_a_1_player_4_extras = Integer.toString(innings1BowlerList.get(3).getWides()+innings1BowlerList.get(3).getNoballs());
//            bowling_a_1_player_4_maiden_overs = innings1BowlerList.get(3).getMaidens().toString();
//            bowling_a_1_player_4_overs = innings1BowlerList.get(3).getOvers();
//            //player 5
//            bowling_a_1_player_5_name = innings1BowlerList.get(4).getShort_name();
//            bowling_a_1_player_5_economy = innings1BowlerList.get(4).getEcon();
//            bowling_a_1_player_5_runs = innings1BowlerList.get(4).getRuns_conceded().toString();
//            bowling_a_1_player_5_wickets =innings1BowlerList.get(4).getWickets().toString();
//            bowling_a_1_player_5_extras = Integer.toString(innings1BowlerList.get(4).getWides()+innings1BowlerList.get(4).getNoballs());
//            bowling_a_1_player_5_maiden_overs = innings1BowlerList.get(4).getMaidens().toString();
//            bowling_a_1_player_5_overs = innings1BowlerList.get(4).getOvers();
//            //player 6
//            bowling_a_1_player_6_name = innings1BowlerList.get(5).getShort_name();
//            bowling_a_1_player_6_economy = innings1BowlerList.get(5).getEcon();
//            bowling_a_1_player_6_runs = innings1BowlerList.get(5).getRuns_conceded().toString();
//            bowling_a_1_player_6_wickets =innings1BowlerList.get(5).getWickets().toString();
//            bowling_a_1_player_6_extras = Integer.toString(innings1BowlerList.get(5).getWides()+innings1BowlerList.get(5).getNoballs());
//            bowling_a_1_player_6_maiden_overs = innings1BowlerList.get(5).getMaidens().toString();
//            bowling_a_1_player_6_overs = innings1BowlerList.get(5).getOvers();
//            //player 7
//            bowling_a_1_player_7_name = innings1BowlerList.get(6).getShort_name();
//            bowling_a_1_player_7_economy = innings1BowlerList.get(6).getEcon();
//            bowling_a_1_player_7_runs = innings1BowlerList.get(6).getRuns_conceded().toString();
//            bowling_a_1_player_7_wickets =innings1BowlerList.get(6).getWickets().toString();
//            bowling_a_1_player_7_extras = Integer.toString(innings1BowlerList.get(6).getWides()+innings1BowlerList.get(6).getNoballs());
//            bowling_a_1_player_7_maiden_overs = innings1BowlerList.get(6).getMaidens().toString();
//            bowling_a_1_player_7_overs = innings1BowlerList.get(6).getOvers();
//            //player 8
//            bowling_a_1_player_8_name = innings1BowlerList.get(7).getShort_name();
//            bowling_a_1_player_8_economy = innings1BowlerList.get(7).getEcon();
//            bowling_a_1_player_8_runs = innings1BowlerList.get(7).getRuns_conceded().toString();
//            bowling_a_1_player_8_wickets =innings1BowlerList.get(7).getWickets().toString();
//            bowling_a_1_player_8_extras = Integer.toString(innings1BowlerList.get(7).getWides()+innings1BowlerList.get(7).getNoballs());
//            bowling_a_1_player_8_maiden_overs = innings1BowlerList.get(7).getMaidens().toString();
//            bowling_a_1_player_8_overs = innings1BowlerList.get(7).getOvers();
//            //player 9
//            bowling_a_1_player_9_name = innings1BowlerList.get(8).getShort_name();
//            bowling_a_1_player_9_economy = innings1BowlerList.get(8).getEcon();
//            bowling_a_1_player_9_runs = innings1BowlerList.get(8).getRuns_conceded().toString();
//            bowling_a_1_player_9_wickets =innings1BowlerList.get(8).getWickets().toString();
//            bowling_a_1_player_9_extras = Integer.toString(innings1BowlerList.get(8).getWides()+innings1BowlerList.get(8).getNoballs());
//            bowling_a_1_player_9_maiden_overs = innings1BowlerList.get(8).getMaidens().toString();
//            bowling_a_1_player_9_overs = innings1BowlerList.get(8).getOvers();
//            //player 10
//            bowling_a_1_player_10_name = innings1BowlerList.get(9).getShort_name();
//            bowling_a_1_player_10_economy = innings1BowlerList.get(9).getEcon();
//            bowling_a_1_player_10_runs = innings1BowlerList.get(9).getRuns_conceded().toString();
//            bowling_a_1_player_10_wickets =innings1BowlerList.get(9).getWickets().toString();
//            bowling_a_1_player_10_extras = Integer.toString(innings1BowlerList.get(9).getWides()+innings1BowlerList.get(9).getNoballs());
//            bowling_a_1_player_10_maiden_overs = innings1BowlerList.get(9).getMaidens().toString();
//            bowling_a_1_player_10_overs = innings1BowlerList.get(9).getOvers();
//            //player 11
//            bowling_a_1_player_11_name = innings1BowlerList.get(10).getShort_name();
//            bowling_a_1_player_11_economy = innings1BowlerList.get(10).getEcon();
//            bowling_a_1_player_11_runs = innings1BowlerList.get(10).getRuns_conceded().toString();
//            bowling_a_1_player_11_wickets =innings1BowlerList.get(10).getWickets().toString();
//            bowling_a_1_player_11_extras = Integer.toString(innings1BowlerList.get(10).getWides()+innings1BowlerList.get(10).getNoballs());
//            bowling_a_1_player_11_maiden_overs = innings1BowlerList.get(10).getMaidens().toString();
//            bowling_a_1_player_11_overs = innings1BowlerList.get(10).getOvers();
//
//
//            //Innings 2 bowlwer list
//            //player 1
//            bowling_b_1_player_1_name = innings2BowlerList.get(0).getShort_name();
//            bowling_b_1_player_1_economy = innings2BowlerList.get(0).getEcon();
//            bowling_b_1_player_1_runs = innings2BowlerList.get(0).getRuns_conceded().toString();
//            bowling_b_1_player_1_wickets =innings2BowlerList.get(0).getWickets().toString();
//            bowling_b_1_player_1_extras = Integer.toString(innings2BowlerList.get(0).getWides()+innings2BowlerList.get(0).getNoballs());
//            bowling_b_1_player_1_maiden_overs = innings2BowlerList.get(0).getMaidens().toString();
//            bowling_b_1_player_1_overs = innings2BowlerList.get(0).getOvers();
//            //player 2
//            bowling_b_1_player_2_name = innings2BowlerList.get(1).getShort_name();
//            bowling_b_1_player_2_economy = innings2BowlerList.get(1).getEcon();
//            bowling_b_1_player_2_runs = innings2BowlerList.get(1).getRuns_conceded().toString();
//            bowling_b_1_player_2_wickets =innings2BowlerList.get(1).getWickets().toString();
//            bowling_b_1_player_2_extras = Integer.toString(innings2BowlerList.get(1).getWides()+innings2BowlerList.get(1).getNoballs());
//            bowling_b_1_player_2_maiden_overs = innings2BowlerList.get(1).getMaidens().toString();
//            bowling_b_1_player_2_overs = innings2BowlerList.get(1).getOvers();
//            //player 3
//            bowling_b_1_player_3_name = innings2BowlerList.get(2).getShort_name();
//            bowling_b_1_player_3_economy = innings2BowlerList.get(2).getEcon();
//            bowling_b_1_player_3_runs = innings2BowlerList.get(2).getRuns_conceded().toString();
//            bowling_b_1_player_3_wickets =innings2BowlerList.get(2).getWickets().toString();
//            bowling_b_1_player_3_extras = Integer.toString(innings2BowlerList.get(2).getWides()+innings2BowlerList.get(2).getNoballs());
//            bowling_b_1_player_3_maiden_overs = innings2BowlerList.get(2).getMaidens().toString();
//            bowling_b_1_player_3_overs = innings2BowlerList.get(2).getOvers();
//            //player 4
//            bowling_b_1_player_4_name = innings2BowlerList.get(3).getShort_name();
//            bowling_b_1_player_4_economy = innings2BowlerList.get(3).getEcon();
//            bowling_b_1_player_4_runs = innings2BowlerList.get(3).getRuns_conceded().toString();
//            bowling_b_1_player_4_wickets =innings2BowlerList.get(3).getWickets().toString();
//            bowling_b_1_player_4_extras = Integer.toString(innings2BowlerList.get(3).getWides()+innings2BowlerList.get(3).getNoballs());
//            bowling_b_1_player_4_maiden_overs = innings2BowlerList.get(3).getMaidens().toString();
//            bowling_b_1_player_4_overs = innings2BowlerList.get(3).getOvers();
//            //player 5
//            bowling_b_1_player_5_name = innings2BowlerList.get(4).getShort_name();
//            bowling_b_1_player_5_economy = innings2BowlerList.get(4).getEcon();
//            bowling_b_1_player_5_runs = innings2BowlerList.get(4).getRuns_conceded().toString();
//            bowling_b_1_player_5_wickets =innings2BowlerList.get(4).getWickets().toString();
//            bowling_b_1_player_5_extras = Integer.toString(innings2BowlerList.get(4).getWides()+innings2BowlerList.get(4).getNoballs());
//            bowling_b_1_player_5_maiden_overs = innings2BowlerList.get(4).getMaidens().toString();
//            bowling_b_1_player_5_overs = innings2BowlerList.get(4).getOvers();
//            //player 6
//            bowling_b_1_player_6_name = innings2BowlerList.get(5).getShort_name();
//            bowling_b_1_player_6_economy = innings2BowlerList.get(5).getEcon();
//            bowling_b_1_player_6_runs = innings2BowlerList.get(5).getRuns_conceded().toString();
//            bowling_b_1_player_6_wickets =innings2BowlerList.get(5).getWickets().toString();
//            bowling_b_1_player_6_extras = Integer.toString(innings2BowlerList.get(5).getWides()+innings2BowlerList.get(5).getNoballs());
//            bowling_b_1_player_6_maiden_overs = innings2BowlerList.get(5).getMaidens().toString();
//            bowling_b_1_player_6_overs = innings2BowlerList.get(5).getOvers();
//            //player 7
//            bowling_b_1_player_7_name = innings2BowlerList.get(6).getShort_name();
//            bowling_b_1_player_7_economy = innings2BowlerList.get(6).getEcon();
//            bowling_b_1_player_7_runs = innings2BowlerList.get(6).getRuns_conceded().toString();
//            bowling_b_1_player_7_wickets =innings2BowlerList.get(6).getWickets().toString();
//            bowling_b_1_player_7_extras = Integer.toString(innings2BowlerList.get(6).getWides()+innings2BowlerList.get(6).getNoballs());
//            bowling_b_1_player_7_maiden_overs = innings2BowlerList.get(6).getMaidens().toString();
//            bowling_b_1_player_7_overs = innings2BowlerList.get(6).getOvers();
//            //player 8
//            bowling_b_1_player_8_name = innings2BowlerList.get(7).getShort_name();
//            bowling_b_1_player_8_economy = innings2BowlerList.get(7).getEcon();
//            bowling_b_1_player_8_runs = innings2BowlerList.get(7).getRuns_conceded().toString();
//            bowling_b_1_player_8_wickets =innings2BowlerList.get(7).getWickets().toString();
//            bowling_b_1_player_8_extras = Integer.toString(innings2BowlerList.get(7).getWides()+innings2BowlerList.get(7).getNoballs());
//            bowling_b_1_player_8_maiden_overs = innings2BowlerList.get(7).getMaidens().toString();
//            bowling_b_1_player_8_overs = innings2BowlerList.get(7).getOvers();
//            //player 9
//            bowling_b_1_player_9_name = innings2BowlerList.get(8).getShort_name();
//            bowling_b_1_player_9_economy = innings2BowlerList.get(8).getEcon();
//            bowling_b_1_player_9_runs = innings2BowlerList.get(8).getRuns_conceded().toString();
//            bowling_b_1_player_9_wickets =innings2BowlerList.get(8).getWickets().toString();
//            bowling_b_1_player_9_extras = Integer.toString(innings2BowlerList.get(8).getWides()+innings2BowlerList.get(8).getNoballs());
//            bowling_b_1_player_9_maiden_overs = innings2BowlerList.get(8).getMaidens().toString();
//            bowling_b_1_player_9_overs = innings2BowlerList.get(8).getOvers();
//            //player 10
//            bowling_b_1_player_10_name = innings2BowlerList.get(9).getShort_name();
//            bowling_b_1_player_10_economy = innings2BowlerList.get(9).getEcon();
//            bowling_b_1_player_10_runs = innings2BowlerList.get(9).getRuns_conceded().toString();
//            bowling_b_1_player_10_wickets =innings2BowlerList.get(9).getWickets().toString();
//            bowling_b_1_player_10_extras = Integer.toString(innings2BowlerList.get(9).getWides()+innings2BowlerList.get(9).getNoballs());
//            bowling_b_1_player_10_maiden_overs = innings2BowlerList.get(9).getMaidens().toString();
//            bowling_b_1_player_10_overs = innings2BowlerList.get(9).getOvers();
//            //player 11
//            bowling_b_1_player_11_name = innings2BowlerList.get(10).getShort_name();
//            bowling_b_1_player_11_economy = innings2BowlerList.get(10).getEcon();
//            bowling_b_1_player_11_runs = innings2BowlerList.get(10).getRuns_conceded().toString();
//            bowling_b_1_player_11_wickets =innings2BowlerList.get(10).getWickets().toString();
//            bowling_b_1_player_11_extras = Integer.toString(innings2BowlerList.get(10).getWides()+innings2BowlerList.get(10).getNoballs());
//            bowling_b_1_player_11_maiden_overs = innings2BowlerList.get(10).getMaidens().toString();
//            bowling_b_1_player_11_overs = innings2BowlerList.get(10).getOvers();
//        }
//
//        else
//        {
//            //player 1
//            bowling_a_1_player_1_name = innings1BowlerList.get(0).getShort_name();
//            bowling_a_1_player_1_economy = innings1BowlerList.get(0).getEcon();
//            bowling_a_1_player_1_runs = innings1BowlerList.get(0).getRuns_conceded().toString();
//            bowling_a_1_player_1_wickets =innings1BowlerList.get(0).getWickets().toString();
//            bowling_a_1_player_1_extras = Integer.toString(innings1BowlerList.get(0).getWides()+innings1BowlerList.get(0).getNoballs());
//            bowling_a_1_player_1_maiden_overs = innings1BowlerList.get(0).getMaidens().toString();
//            bowling_a_1_player_1_overs = innings1BowlerList.get(0).getOvers();
//
//            bowling_a_2_player_1_name = innings3BowlerList.get(0).getShort_name();
//            bowling_a_2_player_1_economy = innings3BowlerList.get(0).getEcon();
//            bowling_a_2_player_1_runs = innings3BowlerList.get(0).getRuns_conceded().toString();
//            bowling_a_2_player_1_wickets =innings3BowlerList.get(0).getWickets().toString();
//            bowling_a_2_player_1_extras = Integer.toString(innings3BowlerList.get(0).getWides()+innings3BowlerList.get(0).getNoballs());
//            bowling_a_2_player_1_maiden_overs = innings3BowlerList.get(0).getMaidens().toString();
//            bowling_a_2_player_1_overs = innings3BowlerList.get(0).getOvers();
//
//            bowling_b_1_player_1_name = innings2BowlerList.get(0).getShort_name();
//            bowling_b_1_player_1_economy = innings2BowlerList.get(0).getEcon();
//            bowling_b_1_player_1_runs = innings2BowlerList.get(0).getRuns_conceded().toString();
//            bowling_b_1_player_1_wickets =innings2BowlerList.get(0).getWickets().toString();
//            bowling_b_1_player_1_extras = Integer.toString(innings2BowlerList.get(0).getWides()+innings2BowlerList.get(0).getNoballs());
//            bowling_b_1_player_1_maiden_overs = innings2BowlerList.get(0).getMaidens().toString();
//            bowling_b_1_player_1_overs = innings2BowlerList.get(0).getOvers();
//
//            bowling_b_2_player_1_name = innings4BowlerList.get(0).getShort_name();
//            bowling_b_2_player_1_economy = innings4BowlerList.get(0).getEcon();
//            bowling_b_2_player_1_runs = innings4BowlerList.get(0).getRuns_conceded().toString();
//            bowling_b_2_player_1_wickets =innings4BowlerList.get(0).getWickets().toString();
//            bowling_b_2_player_1_extras = Integer.toString(innings4BowlerList.get(0).getWides()+innings4BowlerList.get(0).getNoballs());
//            bowling_b_2_player_1_maiden_overs = innings4BowlerList.get(0).getMaidens().toString();
//            bowling_b_2_player_1_overs = innings4BowlerList.get(0).getOvers();
//
//            //player 2
//            bowling_a_1_player_2_name = innings1BowlerList.get(1).getShort_name();
//            bowling_a_1_player_2_economy = innings1BowlerList.get(1).getEcon();
//            bowling_a_1_player_2_runs = innings1BowlerList.get(1).getRuns_conceded().toString();
//            bowling_a_1_player_2_wickets =innings1BowlerList.get(1).getWickets().toString();
//            bowling_a_1_player_2_extras = Integer.toString(innings1BowlerList.get(1).getWides()+innings1BowlerList.get(1).getNoballs());
//            bowling_a_1_player_2_maiden_overs = innings1BowlerList.get(1).getMaidens().toString();
//            bowling_a_1_player_2_overs = innings1BowlerList.get(1).getOvers();
//
//            bowling_a_2_player_2_name = innings3BowlerList.get(1).getShort_name();
//            bowling_a_2_player_2_economy = innings3BowlerList.get(1).getEcon();
//            bowling_a_2_player_2_runs = innings3BowlerList.get(1).getRuns_conceded().toString();
//            bowling_a_2_player_2_wickets =innings3BowlerList.get(1).getWickets().toString();
//            bowling_a_2_player_2_extras = Integer.toString(innings3BowlerList.get(1).getWides()+innings3BowlerList.get(1).getNoballs());
//            bowling_a_2_player_2_maiden_overs = innings3BowlerList.get(1).getMaidens().toString();
//            bowling_a_2_player_2_overs = innings3BowlerList.get(1).getOvers();
//
//            bowling_b_1_player_2_name = innings2BowlerList.get(1).getShort_name();
//            bowling_b_1_player_2_economy = innings2BowlerList.get(1).getEcon();
//            bowling_b_1_player_2_runs = innings2BowlerList.get(1).getRuns_conceded().toString();
//            bowling_b_1_player_2_wickets =innings2BowlerList.get(1).getWickets().toString();
//            bowling_b_1_player_2_extras = Integer.toString(innings2BowlerList.get(1).getWides()+innings2BowlerList.get(1).getNoballs());
//            bowling_b_1_player_2_maiden_overs = innings2BowlerList.get(1).getMaidens().toString();
//            bowling_b_1_player_2_overs = innings2BowlerList.get(1).getOvers();
//
//            bowling_b_2_player_2_name = innings4BowlerList.get(1).getShort_name();
//            bowling_b_2_player_2_economy = innings4BowlerList.get(1).getEcon();
//            bowling_b_2_player_2_runs = innings4BowlerList.get(1).getRuns_conceded().toString();
//            bowling_b_2_player_2_wickets =innings4BowlerList.get(1).getWickets().toString();
//            bowling_b_2_player_2_extras = Integer.toString(innings4BowlerList.get(1).getWides()+innings4BowlerList.get(1).getNoballs());
//            bowling_b_2_player_2_maiden_overs = innings4BowlerList.get(1).getMaidens().toString();
//            bowling_b_2_player_2_overs = innings4BowlerList.get(1).getOvers();
//
//            //player 3
//            bowling_a_1_player_3_name = innings1BowlerList.get(2).getShort_name();
//            bowling_a_1_player_3_economy = innings1BowlerList.get(2).getEcon();
//            bowling_a_1_player_3_runs = innings1BowlerList.get(2).getRuns_conceded().toString();
//            bowling_a_1_player_3_wickets =innings1BowlerList.get(2).getWickets().toString();
//            bowling_a_1_player_3_extras = Integer.toString(innings1BowlerList.get(2).getWides()+innings1BowlerList.get(2).getNoballs());
//            bowling_a_1_player_3_maiden_overs = innings1BowlerList.get(2).getMaidens().toString();
//            bowling_a_1_player_3_overs = innings1BowlerList.get(2).getOvers();
//
//            bowling_a_2_player_3_name = innings3BowlerList.get(2).getShort_name();
//            bowling_a_2_player_3_economy = innings3BowlerList.get(2).getEcon();
//            bowling_a_2_player_3_runs = innings3BowlerList.get(2).getRuns_conceded().toString();
//            bowling_a_2_player_3_wickets =innings3BowlerList.get(2).getWickets().toString();
//            bowling_a_2_player_3_extras = Integer.toString(innings3BowlerList.get(2).getWides()+innings3BowlerList.get(2).getNoballs());
//            bowling_a_2_player_3_maiden_overs = innings3BowlerList.get(2).getMaidens().toString();
//            bowling_a_2_player_3_overs = innings3BowlerList.get(2).getOvers();
//
//            bowling_b_1_player_3_name = innings2BowlerList.get(2).getShort_name();
//            bowling_b_1_player_3_economy = innings2BowlerList.get(2).getEcon();
//            bowling_b_1_player_3_runs = innings2BowlerList.get(2).getRuns_conceded().toString();
//            bowling_b_1_player_3_wickets =innings2BowlerList.get(2).getWickets().toString();
//            bowling_b_1_player_3_extras = Integer.toString(innings2BowlerList.get(2).getWides()+innings2BowlerList.get(2).getNoballs());
//            bowling_b_1_player_3_maiden_overs = innings2BowlerList.get(2).getMaidens().toString();
//            bowling_b_1_player_3_overs = innings2BowlerList.get(2).getOvers();
//
//            bowling_b_2_player_3_name = innings4BowlerList.get(2).getShort_name();
//            bowling_b_2_player_3_economy = innings4BowlerList.get(2).getEcon();
//            bowling_b_2_player_3_runs = innings4BowlerList.get(2).getRuns_conceded().toString();
//            bowling_b_2_player_3_wickets =innings4BowlerList.get(2).getWickets().toString();
//            bowling_b_2_player_3_extras = Integer.toString(innings4BowlerList.get(2).getWides()+innings4BowlerList.get(2).getNoballs());
//            bowling_b_2_player_3_maiden_overs = innings4BowlerList.get(2).getMaidens().toString();
//            bowling_b_2_player_3_overs = innings4BowlerList.get(2).getOvers();
//
//            //player 4
//            bowling_a_1_player_4_name = innings1BowlerList.get(3).getShort_name();
//            bowling_a_1_player_4_economy = innings1BowlerList.get(3).getEcon();
//            bowling_a_1_player_4_runs = innings1BowlerList.get(3).getRuns_conceded().toString();
//            bowling_a_1_player_4_wickets =innings1BowlerList.get(3).getWickets().toString();
//            bowling_a_1_player_4_extras = Integer.toString(innings1BowlerList.get(3).getWides()+innings1BowlerList.get(3).getNoballs());
//            bowling_a_1_player_4_maiden_overs = innings1BowlerList.get(3).getMaidens().toString();
//            bowling_a_1_player_4_overs = innings1BowlerList.get(3).getOvers();
//
//            bowling_a_2_player_4_name = innings3BowlerList.get(3).getShort_name();
//            bowling_a_2_player_4_economy = innings3BowlerList.get(3).getEcon();
//            bowling_a_2_player_4_runs = innings3BowlerList.get(3).getRuns_conceded().toString();
//            bowling_a_2_player_4_wickets =innings3BowlerList.get(3).getWickets().toString();
//            bowling_a_2_player_4_extras = Integer.toString(innings3BowlerList.get(3).getWides()+innings3BowlerList.get(3).getNoballs());
//            bowling_a_2_player_4_maiden_overs = innings3BowlerList.get(3).getMaidens().toString();
//            bowling_a_2_player_4_overs = innings3BowlerList.get(3).getOvers();
//
//            bowling_b_1_player_4_name = innings2BowlerList.get(3).getShort_name();
//            bowling_b_1_player_4_economy = innings2BowlerList.get(3).getEcon();
//            bowling_b_1_player_4_runs = innings2BowlerList.get(3).getRuns_conceded().toString();
//            bowling_b_1_player_4_wickets =innings2BowlerList.get(3).getWickets().toString();
//            bowling_b_1_player_4_extras = Integer.toString(innings2BowlerList.get(3).getWides()+innings2BowlerList.get(3).getNoballs());
//            bowling_b_1_player_4_maiden_overs = innings2BowlerList.get(3).getMaidens().toString();
//            bowling_b_1_player_4_overs = innings2BowlerList.get(3).getOvers();
//
//            bowling_b_2_player_4_name = innings4BowlerList.get(3).getShort_name();
//            bowling_b_2_player_4_economy = innings4BowlerList.get(3).getEcon();
//            bowling_b_2_player_4_runs = innings4BowlerList.get(3).getRuns_conceded().toString();
//            bowling_b_2_player_4_wickets =innings4BowlerList.get(3).getWickets().toString();
//            bowling_b_2_player_4_extras = Integer.toString(innings4BowlerList.get(3).getWides()+innings4BowlerList.get(3).getNoballs());
//            bowling_b_2_player_4_maiden_overs = innings4BowlerList.get(3).getMaidens().toString();
//            bowling_b_2_player_4_overs = innings4BowlerList.get(3).getOvers();
//
//            //player 5
//            bowling_a_1_player_5_name = innings1BowlerList.get(4).getShort_name();
//            bowling_a_1_player_5_economy = innings1BowlerList.get(4).getEcon();
//            bowling_a_1_player_5_runs = innings1BowlerList.get(4).getRuns_conceded().toString();
//            bowling_a_1_player_5_wickets =innings1BowlerList.get(4).getWickets().toString();
//            bowling_a_1_player_5_extras = Integer.toString(innings1BowlerList.get(4).getWides()+innings1BowlerList.get(4).getNoballs());
//            bowling_a_1_player_5_maiden_overs = innings1BowlerList.get(4).getMaidens().toString();
//            bowling_a_1_player_5_overs = innings1BowlerList.get(4).getOvers();
//
//            bowling_a_2_player_5_name = innings3BowlerList.get(4).getShort_name();
//            bowling_a_2_player_5_economy = innings3BowlerList.get(4).getEcon();
//            bowling_a_2_player_5_runs = innings3BowlerList.get(4).getRuns_conceded().toString();
//            bowling_a_2_player_5_wickets =innings3BowlerList.get(4).getWickets().toString();
//            bowling_a_2_player_5_extras = Integer.toString(innings3BowlerList.get(4).getWides()+innings3BowlerList.get(4).getNoballs());
//            bowling_a_2_player_5_maiden_overs = innings3BowlerList.get(4).getMaidens().toString();
//            bowling_a_2_player_5_overs = innings3BowlerList.get(4).getOvers();
//
//            bowling_b_1_player_5_name = innings2BowlerList.get(4).getShort_name();
//            bowling_b_1_player_5_economy = innings2BowlerList.get(4).getEcon();
//            bowling_b_1_player_5_runs = innings2BowlerList.get(4).getRuns_conceded().toString();
//            bowling_b_1_player_5_wickets =innings2BowlerList.get(4).getWickets().toString();
//            bowling_b_1_player_5_extras = Integer.toString(innings2BowlerList.get(4).getWides()+innings2BowlerList.get(4).getNoballs());
//            bowling_b_1_player_5_maiden_overs = innings2BowlerList.get(4).getMaidens().toString();
//            bowling_b_1_player_5_overs = innings2BowlerList.get(4).getOvers();
//
//            bowling_b_2_player_5_name = innings4BowlerList.get(4).getShort_name();
//            bowling_b_2_player_5_economy = innings4BowlerList.get(4).getEcon();
//            bowling_b_2_player_5_runs = innings4BowlerList.get(4).getRuns_conceded().toString();
//            bowling_b_2_player_5_wickets =innings4BowlerList.get(4).getWickets().toString();
//            bowling_b_2_player_5_extras = Integer.toString(innings4BowlerList.get(4).getWides()+innings4BowlerList.get(4).getNoballs());
//            bowling_b_2_player_5_maiden_overs = innings4BowlerList.get(4).getMaidens().toString();
//            bowling_b_2_player_5_overs = innings4BowlerList.get(4).getOvers();
//
//            //player 6
//            bowling_a_1_player_6_name = innings1BowlerList.get(5).getShort_name();
//            bowling_a_1_player_6_economy = innings1BowlerList.get(5).getEcon();
//            bowling_a_1_player_6_runs = innings1BowlerList.get(5).getRuns_conceded().toString();
//            bowling_a_1_player_6_wickets =innings1BowlerList.get(5).getWickets().toString();
//            bowling_a_1_player_6_extras = Integer.toString(innings1BowlerList.get(5).getWides()+innings1BowlerList.get(5).getNoballs());
//            bowling_a_1_player_6_maiden_overs = innings1BowlerList.get(5).getMaidens().toString();
//            bowling_a_1_player_6_overs = innings1BowlerList.get(5).getOvers();
//
//            bowling_a_2_player_6_name = innings3BowlerList.get(5).getShort_name();
//            bowling_a_2_player_6_economy = innings3BowlerList.get(5).getEcon();
//            bowling_a_2_player_6_runs = innings3BowlerList.get(5).getRuns_conceded().toString();
//            bowling_a_2_player_6_wickets =innings3BowlerList.get(5).getWickets().toString();
//            bowling_a_2_player_6_extras = Integer.toString(innings3BowlerList.get(5).getWides()+innings3BowlerList.get(5).getNoballs());
//            bowling_a_2_player_6_maiden_overs = innings3BowlerList.get(5).getMaidens().toString();
//            bowling_a_2_player_6_overs = innings3BowlerList.get(5).getOvers();
//
//            bowling_b_1_player_6_name = innings2BowlerList.get(5).getShort_name();
//            bowling_b_1_player_6_economy = innings2BowlerList.get(5).getEcon();
//            bowling_b_1_player_6_runs = innings2BowlerList.get(5).getRuns_conceded().toString();
//            bowling_b_1_player_6_wickets =innings2BowlerList.get(5).getWickets().toString();
//            bowling_b_1_player_6_extras = Integer.toString(innings2BowlerList.get(5).getWides()+innings2BowlerList.get(5).getNoballs());
//            bowling_b_1_player_6_maiden_overs = innings2BowlerList.get(5).getMaidens().toString();
//            bowling_b_1_player_6_overs = innings2BowlerList.get(5).getOvers();
//
//            bowling_b_2_player_6_name = innings4BowlerList.get(5).getShort_name();
//            bowling_b_2_player_6_economy = innings4BowlerList.get(5).getEcon();
//            bowling_b_2_player_6_runs = innings4BowlerList.get(5).getRuns_conceded().toString();
//            bowling_b_2_player_6_wickets =innings4BowlerList.get(5).getWickets().toString();
//            bowling_b_2_player_6_extras = Integer.toString(innings4BowlerList.get(5).getWides()+innings4BowlerList.get(5).getNoballs());
//            bowling_b_2_player_6_maiden_overs = innings4BowlerList.get(5).getMaidens().toString();
//            bowling_b_2_player_6_overs = innings4BowlerList.get(5).getOvers();
//
//            //player 7
//            bowling_a_1_player_7_name = innings1BowlerList.get(6).getShort_name();
//            bowling_a_1_player_7_economy = innings1BowlerList.get(6).getEcon();
//            bowling_a_1_player_7_runs = innings1BowlerList.get(6).getRuns_conceded().toString();
//            bowling_a_1_player_7_wickets =innings1BowlerList.get(6).getWickets().toString();
//            bowling_a_1_player_7_extras = Integer.toString(innings1BowlerList.get(6).getWides()+innings1BowlerList.get(6).getNoballs());
//            bowling_a_1_player_7_maiden_overs = innings1BowlerList.get(6).getMaidens().toString();
//            bowling_a_1_player_7_overs = innings1BowlerList.get(6).getOvers();
//
//            bowling_a_2_player_7_name = innings3BowlerList.get(6).getShort_name();
//            bowling_a_2_player_7_economy = innings3BowlerList.get(6).getEcon();
//            bowling_a_2_player_7_runs = innings3BowlerList.get(6).getRuns_conceded().toString();
//            bowling_a_2_player_7_wickets =innings3BowlerList.get(6).getWickets().toString();
//            bowling_a_2_player_7_extras = Integer.toString(innings3BowlerList.get(6).getWides()+innings3BowlerList.get(6).getNoballs());
//            bowling_a_2_player_7_maiden_overs = innings3BowlerList.get(6).getMaidens().toString();
//            bowling_a_2_player_7_overs = innings3BowlerList.get(6).getOvers();
//
//            bowling_b_1_player_7_name = innings2BowlerList.get(6).getShort_name();
//            bowling_b_1_player_7_economy = innings2BowlerList.get(6).getEcon();
//            bowling_b_1_player_7_runs = innings2BowlerList.get(6).getRuns_conceded().toString();
//            bowling_b_1_player_7_wickets =innings2BowlerList.get(6).getWickets().toString();
//            bowling_b_1_player_7_extras = Integer.toString(innings2BowlerList.get(6).getWides()+innings2BowlerList.get(6).getNoballs());
//            bowling_b_1_player_7_maiden_overs = innings2BowlerList.get(6).getMaidens().toString();
//            bowling_b_1_player_7_overs = innings2BowlerList.get(6).getOvers();
//
//            bowling_b_2_player_7_name = innings4BowlerList.get(6).getShort_name();
//            bowling_b_2_player_7_economy = innings4BowlerList.get(6).getEcon();
//            bowling_b_2_player_7_runs = innings4BowlerList.get(6).getRuns_conceded().toString();
//            bowling_b_2_player_7_wickets =innings4BowlerList.get(6).getWickets().toString();
//            bowling_b_2_player_7_extras = Integer.toString(innings4BowlerList.get(6).getWides()+innings4BowlerList.get(6).getNoballs());
//            bowling_b_2_player_7_maiden_overs = innings4BowlerList.get(6).getMaidens().toString();
//            bowling_b_2_player_7_overs = innings4BowlerList.get(6).getOvers();
//
//            //player 8
//            bowling_a_1_player_8_name = innings1BowlerList.get(7).getShort_name();
//            bowling_a_1_player_8_economy = innings1BowlerList.get(7).getEcon();
//            bowling_a_1_player_8_runs = innings1BowlerList.get(7).getRuns_conceded().toString();
//            bowling_a_1_player_8_wickets =innings1BowlerList.get(7).getWickets().toString();
//            bowling_a_1_player_8_extras = Integer.toString(innings1BowlerList.get(7).getWides()+innings1BowlerList.get(7).getNoballs());
//            bowling_a_1_player_8_maiden_overs = innings1BowlerList.get(7).getMaidens().toString();
//            bowling_a_1_player_8_overs = innings1BowlerList.get(7).getOvers();
//
//            bowling_a_2_player_8_name = innings3BowlerList.get(7).getShort_name();
//            bowling_a_2_player_8_economy = innings3BowlerList.get(7).getEcon();
//            bowling_a_2_player_8_runs = innings3BowlerList.get(7).getRuns_conceded().toString();
//            bowling_a_2_player_8_wickets =innings3BowlerList.get(7).getWickets().toString();
//            bowling_a_2_player_8_extras = Integer.toString(innings3BowlerList.get(7).getWides()+innings3BowlerList.get(7).getNoballs());
//            bowling_a_2_player_8_maiden_overs = innings3BowlerList.get(7).getMaidens().toString();
//            bowling_a_2_player_8_overs = innings3BowlerList.get(7).getOvers();
//
//            bowling_b_1_player_8_name = innings2BowlerList.get(7).getShort_name();
//            bowling_b_1_player_8_economy = innings2BowlerList.get(7).getEcon();
//            bowling_b_1_player_8_runs = innings2BowlerList.get(7).getRuns_conceded().toString();
//            bowling_b_1_player_8_wickets =innings2BowlerList.get(7).getWickets().toString();
//            bowling_b_1_player_8_extras = Integer.toString(innings2BowlerList.get(7).getWides()+innings2BowlerList.get(7).getNoballs());
//            bowling_b_1_player_8_maiden_overs = innings2BowlerList.get(7).getMaidens().toString();
//            bowling_b_1_player_8_overs = innings2BowlerList.get(7).getOvers();
//
//            bowling_b_2_player_8_name = innings4BowlerList.get(7).getShort_name();
//            bowling_b_2_player_8_economy = innings4BowlerList.get(7).getEcon();
//            bowling_b_2_player_8_runs = innings4BowlerList.get(7).getRuns_conceded().toString();
//            bowling_b_2_player_8_wickets =innings4BowlerList.get(7).getWickets().toString();
//            bowling_b_2_player_8_extras = Integer.toString(innings4BowlerList.get(7).getWides()+innings4BowlerList.get(7).getNoballs());
//            bowling_b_2_player_8_maiden_overs = innings4BowlerList.get(7).getMaidens().toString();
//            bowling_b_2_player_8_overs = innings4BowlerList.get(7).getOvers();
//
//            //player 9
//            bowling_a_1_player_9_name = innings1BowlerList.get(8).getShort_name();
//            bowling_a_1_player_9_economy = innings1BowlerList.get(8).getEcon();
//            bowling_a_1_player_9_runs = innings1BowlerList.get(8).getRuns_conceded().toString();
//            bowling_a_1_player_9_wickets =innings1BowlerList.get(8).getWickets().toString();
//            bowling_a_1_player_9_extras = Integer.toString(innings1BowlerList.get(8).getWides()+innings1BowlerList.get(8).getNoballs());
//            bowling_a_1_player_9_maiden_overs = innings1BowlerList.get(8).getMaidens().toString();
//            bowling_a_1_player_9_overs = innings1BowlerList.get(8).getOvers();
//
//            bowling_a_2_player_9_name = innings3BowlerList.get(8).getShort_name();
//            bowling_a_2_player_9_economy = innings3BowlerList.get(8).getEcon();
//            bowling_a_2_player_9_runs = innings3BowlerList.get(8).getRuns_conceded().toString();
//            bowling_a_2_player_9_wickets =innings3BowlerList.get(8).getWickets().toString();
//            bowling_a_2_player_9_extras = Integer.toString(innings3BowlerList.get(8).getWides()+innings3BowlerList.get(8).getNoballs());
//            bowling_a_2_player_9_maiden_overs = innings3BowlerList.get(8).getMaidens().toString();
//            bowling_a_2_player_9_overs = innings3BowlerList.get(8).getOvers();
//
//            bowling_b_1_player_9_name = innings2BowlerList.get(8).getShort_name();
//            bowling_b_1_player_9_economy = innings2BowlerList.get(8).getEcon();
//            bowling_b_1_player_9_runs = innings2BowlerList.get(8).getRuns_conceded().toString();
//            bowling_b_1_player_9_wickets =innings2BowlerList.get(8).getWickets().toString();
//            bowling_b_1_player_9_extras = Integer.toString(innings2BowlerList.get(8).getWides()+innings2BowlerList.get(8).getNoballs());
//            bowling_b_1_player_9_maiden_overs = innings2BowlerList.get(8).getMaidens().toString();
//            bowling_b_1_player_9_overs = innings2BowlerList.get(8).getOvers();
//
//            bowling_b_2_player_9_name = innings4BowlerList.get(8).getShort_name();
//            bowling_b_2_player_9_economy = innings4BowlerList.get(8).getEcon();
//            bowling_b_2_player_9_runs = innings4BowlerList.get(8).getRuns_conceded().toString();
//            bowling_b_2_player_9_wickets =innings4BowlerList.get(8).getWickets().toString();
//            bowling_b_2_player_9_extras = Integer.toString(innings4BowlerList.get(8).getWides()+innings4BowlerList.get(8).getNoballs());
//            bowling_b_2_player_9_maiden_overs = innings4BowlerList.get(8).getMaidens().toString();
//            bowling_b_2_player_9_overs = innings4BowlerList.get(8).getOvers();
//
//            //player 10
//            bowling_a_1_player_10_name = innings1BowlerList.get(9).getShort_name();
//            bowling_a_1_player_10_economy = innings1BowlerList.get(9).getEcon();
//            bowling_a_1_player_10_runs = innings1BowlerList.get(9).getRuns_conceded().toString();
//            bowling_a_1_player_10_wickets =innings1BowlerList.get(9).getWickets().toString();
//            bowling_a_1_player_10_extras = Integer.toString(innings1BowlerList.get(9).getWides()+innings1BowlerList.get(9).getNoballs());
//            bowling_a_1_player_10_maiden_overs = innings1BowlerList.get(9).getMaidens().toString();
//            bowling_a_1_player_10_overs = innings1BowlerList.get(9).getOvers();
//
//            bowling_a_2_player_10_name = innings3BowlerList.get(9).getShort_name();
//            bowling_a_2_player_10_economy = innings3BowlerList.get(9).getEcon();
//            bowling_a_2_player_10_runs = innings3BowlerList.get(9).getRuns_conceded().toString();
//            bowling_a_2_player_10_wickets =innings3BowlerList.get(9).getWickets().toString();
//            bowling_a_2_player_10_extras = Integer.toString(innings3BowlerList.get(9).getWides()+innings3BowlerList.get(9).getNoballs());
//            bowling_a_2_player_10_maiden_overs = innings3BowlerList.get(9).getMaidens().toString();
//            bowling_a_2_player_10_overs = innings3BowlerList.get(9).getOvers();
//
//            bowling_b_1_player_10_name = innings2BowlerList.get(9).getShort_name();
//            bowling_b_1_player_10_economy = innings2BowlerList.get(9).getEcon();
//            bowling_b_1_player_10_runs = innings2BowlerList.get(9).getRuns_conceded().toString();
//            bowling_b_1_player_10_wickets =innings2BowlerList.get(9).getWickets().toString();
//            bowling_b_1_player_10_extras = Integer.toString(innings2BowlerList.get(9).getWides()+innings2BowlerList.get(9).getNoballs());
//            bowling_b_1_player_10_maiden_overs = innings2BowlerList.get(9).getMaidens().toString();
//            bowling_b_1_player_10_overs = innings2BowlerList.get(9).getOvers();
//
//            bowling_b_2_player_10_name = innings4BowlerList.get(9).getShort_name();
//            bowling_b_2_player_10_economy = innings4BowlerList.get(9).getEcon();
//            bowling_b_2_player_10_runs = innings4BowlerList.get(9).getRuns_conceded().toString();
//            bowling_b_2_player_10_wickets =innings4BowlerList.get(9).getWickets().toString();
//            bowling_b_2_player_10_extras = Integer.toString(innings4BowlerList.get(9).getWides()+innings4BowlerList.get(9).getNoballs());
//            bowling_b_2_player_10_maiden_overs = innings4BowlerList.get(9).getMaidens().toString();
//            bowling_b_2_player_10_overs = innings4BowlerList.get(9).getOvers();
//
//            //player 11
//            bowling_a_1_player_11_name = innings1BowlerList.get(10).getShort_name();
//            bowling_a_1_player_11_economy = innings1BowlerList.get(10).getEcon();
//            bowling_a_1_player_11_runs = innings1BowlerList.get(10).getRuns_conceded().toString();
//            bowling_a_1_player_11_wickets =innings1BowlerList.get(10).getWickets().toString();
//            bowling_a_1_player_11_extras = Integer.toString(innings1BowlerList.get(10).getWides()+innings1BowlerList.get(10).getNoballs());
//            bowling_a_1_player_11_maiden_overs = innings1BowlerList.get(10).getMaidens().toString();
//            bowling_a_1_player_11_overs = innings1BowlerList.get(10).getOvers();
//
//            bowling_a_2_player_11_name = innings3BowlerList.get(10).getShort_name();
//            bowling_a_2_player_11_economy = innings3BowlerList.get(10).getEcon();
//            bowling_a_2_player_11_runs = innings3BowlerList.get(10).getRuns_conceded().toString();
//            bowling_a_2_player_11_wickets =innings3BowlerList.get(10).getWickets().toString();
//            bowling_a_2_player_11_extras = Integer.toString(innings3BowlerList.get(10).getWides()+innings3BowlerList.get(10).getNoballs());
//            bowling_a_2_player_11_maiden_overs = innings3BowlerList.get(10).getMaidens().toString();
//            bowling_a_2_player_11_overs = innings3BowlerList.get(10).getOvers();
//
//            bowling_b_1_player_11_name = innings2BowlerList.get(10).getShort_name();
//            bowling_b_1_player_11_economy = innings2BowlerList.get(10).getEcon();
//            bowling_b_1_player_11_runs = innings2BowlerList.get(10).getRuns_conceded().toString();
//            bowling_b_1_player_11_wickets =innings2BowlerList.get(10).getWickets().toString();
//            bowling_b_1_player_11_extras = Integer.toString(innings2BowlerList.get(10).getWides()+innings2BowlerList.get(10).getNoballs());
//            bowling_b_1_player_11_maiden_overs = innings2BowlerList.get(10).getMaidens().toString();
//            bowling_b_1_player_11_overs = innings2BowlerList.get(10).getOvers();
//
//            bowling_b_2_player_11_name = innings4BowlerList.get(10).getShort_name();
//            bowling_b_2_player_11_economy = innings4BowlerList.get(10).getEcon();
//            bowling_b_2_player_11_runs = innings4BowlerList.get(10).getRuns_conceded().toString();
//            bowling_b_2_player_11_wickets =innings4BowlerList.get(10).getWickets().toString();
//            bowling_b_2_player_11_extras = Integer.toString(innings4BowlerList.get(10).getWides()+innings4BowlerList.get(10).getNoballs());
//            bowling_b_2_player_11_maiden_overs = innings4BowlerList.get(10).getMaidens().toString();
//            bowling_b_2_player_11_overs = innings4BowlerList.get(10).getOvers();
//        }
//    }
//
//
//
//
//
//
//    private String team_a = null;
//    private String team_b = null;
//    private String team_a_url = null;
//    private String team_b_url = null;
//
//
//    //didn't map these 3
//    private String related_name;
//    private String msgs_result;
//    private List<String> msgs_others;
//
//
//
//    private String toss_decision = null;
//    private String toss_won = null;
//    private String toss_str = null;
//    //didn't map
//    private String winner_team;
//
//
//
//
//    //innings -> A_1
//    private List<String> innings_A_1_batting_order  = null;
//    private int innings_A_1_runs;
//    //didn't map
//    private int innings_A_1_balls;
//    private List<String> innings_A_1_fall_of_wickets  = null;
//    private int innings_A_1_wide;
//    private String innings_A_1_run_rate  = null;
//
//    //didn't map
//    private int innings_A_1_fours;
//
//    private String innings_A_1_run_str  = null;
//    private int innings_A_1_wickets;
//
//    //didn't map
//    private List<String> innings_A_1_wicket_order;
//
//    private int innings_A_1_extras;
//    private List<String> innings_A_1_bowling_order  = null;
//
//    //didn't map
//    private String innings_A_1_key;
//
//    private int innings_A_1_noball;
//    //didn't map
//    private int innings_A_1_sixes;
//
//    private int innings_A_1_legbye;
//    private int innings_A_1_bye;
//    private String innings_A_1_overs  = null;
//
//    //didn't map
//    private int innings_A_1_dotballs;
//
//    //////////////////////////////////
//    /////B_1
//
//
//    private List<String> innings_B_1_batting_order  = null;
//
//    private int innings_B_1_runs;
//
//    private int innings_B_1_balls;
//
//    private List<String> innings_B_1_fall_of_wickets  = null;
//
//    private int innings_B_1_wide;
//
//    private String innings_B_1_run_rate  = null;
//
//    private int innings_B_1_fours;
//
//    private String innings_B_1_run_str  = null;
//
//    private int innings_B_1_wickets;
//
//    private List<String> innings_B_1_wicket_order  = null;
//
//    private int innings_B_1_extras;
//
//    private List<String> innings_B_1_bowling_order  = null;
//
//    private String innings_B_1_key  = null;
//
//    private int innings_B_1_noball;
//
//    private int innings_B_1_sixes;
//
//    private int innings_B_1_legbye;
//
//    private int innings_B_1_bye;
//
//    private String innings_B_1_overs  = null;
//
//    private int innings_B_1_dotballs;
//
//
//    ///////////////////////////
//
////A_2
//
//    private List<String> innings_A_2_batting_order  = null;
//
//    private int innings_A_2_runs;
//
//    private int innings_A_2_balls;
//
//    private List<String> innings_A_2_fall_of_wickets  = null;
//
//    private int innings_A_2_wide;
//
//    private String innings_A_2_run_rate  = null;
//
//    private int innings_A_2_fours;
//
//    private String innings_A_2_run_str  = null;
//
//    private int innings_A_2_wickets;
//
//    private List<String> innings_A_2_wicket_order = null;
//
//    private int innings_A_2_extras;
//
//    private List<String> innings_A_2_bowling_order  = null;
//
//    private String innings_A_2_key  = null;
//
//    private int innings_A_2_noball;
//
//    private int innings_A_2_sixes;
//
//    private int innings_A_2_legbye;
//
//    private int innings_A_2_bye;
//
//    private String innings_A_2_overs = null;
//
//    private int innings_A_2_dotballs;
//
//    //////////////////////////////////
//    /////B_2
//
//
//    private List<String> innings_B_2_batting_order = null;
//
//    private int innings_B_2_runs;
//
//    private int innings_B_2_balls;
//
//    private List<String> innings_B_2_fall_of_wickets = null;
//
//    private int innings_B_2_wide;
//
//    private String innings_B_2_run_rate = null;
//
//    private int innings_B_2_fours;
//
//    private String innings_B_2_run_str = null;
//
//    private int innings_B_2_wickets;
//
//    private List<String> innings_B_2_wicket_order = null;
//
//    private int innings_B_2_extras;
//
//    private List<String> innings_B_2_bowling_order = null;
//
//    private String innings_B_2_key;
//
//    private int innings_B_2_noball;
//
//    private int innings_B_2_sixes;
//
//    private int innings_B_2_legbye;
//
//    private int innings_B_2_bye;
//
//    private String innings_B_2_overs = null;
//
//    private int innings_B_2_dotballs;
//
//    public void initializeMatchProperty()
//    {
//        Team teamA = matchScorecard.getMatch().getTeama();
//        Team teamB = matchScorecard.getMatch().getTeamb();
//
//         team_a = teamA.getName();
//
//         team_a_url = teamA.getLogo_url();
//
//         team_b = teamB.getName();
//
//         team_b_url = teamB.getLogo_url();
//
//         toss_decision = matchScorecard.getMatch().getToss().getDecision().toString();
//
//         toss_won = matchScorecard.getMatch().getToss().getWinner().toString();
//
//         toss_str = matchScorecard.getMatch().getToss().getText();
//
//
//         if(matchScorecard.getMatch().getInningsList().size() == 2)
//         {
//             innings_A_1_batting_order = innings1.getBatsmanList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_1_runs = Integer.parseInt(innings1.getScores());
//
//             innings_A_1_fall_of_wickets = innings1.getFows().stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_1_wide = innings1.getExtraRuns().getWides();
//
//             innings_A_1_run_rate = innings1.getEquation().getRunrate();
//
//             innings_A_1_run_str = innings1.getScores_full();
//
//             innings_A_1_wickets = innings1.getEquation().getWickets();
//
//             innings_A_1_extras = innings1.getExtraRuns().getTotal();
//
//             innings_A_1_bowling_order = innings1.getBowlerList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_1_noball = innings1.getExtraRuns().getNoballs();
//
//             innings_A_1_legbye = innings1.getExtraRuns().getLegbyes();
//
//             innings_A_1_bye = innings1.getExtraRuns().getByes();
//
//             innings_A_1_overs = innings1.getEquation().getOvers();
//
//
//             //For Innings two
//             innings_B_1_batting_order = innings2.getBatsmanList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_1_runs = Integer.parseInt(innings2.getScores());
//
//             innings_B_1_fall_of_wickets = innings2.getFows().stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_1_wide = innings2.getExtraRuns().getWides();
//
//             innings_B_1_run_rate = innings2.getEquation().getRunrate();
//
//             innings_B_1_run_str = innings2.getScores_full();
//
//             innings_B_1_wickets = innings2.getEquation().getWickets();
//
//             innings_B_1_extras = innings2.getExtraRuns().getTotal();
//             innings_B_1_bowling_order = innings2.getBowlerList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_1_noball = innings2.getExtraRuns().getNoballs();
//
//             innings_B_1_legbye = innings2.getExtraRuns().getLegbyes();
//
//             innings_B_1_bye = innings2.getExtraRuns().getByes();
//
//             innings_B_1_overs = innings2.getEquation().getOvers();
//         }
//
//         else {
//
//             //For innings one
//             innings_A_1_batting_order = innings1.getBatsmanList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_1_runs = Integer.parseInt(innings1.getScores());
//
//             innings_A_1_fall_of_wickets = innings1.getFows().stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_1_wide = innings1.getExtraRuns().getWides();
//
//             innings_A_1_run_rate = innings1.getEquation().getRunrate();
//
//             innings_A_1_run_str = innings1.getScores_full();
//
//             innings_A_1_wickets = innings1.getEquation().getWickets();
//
//             innings_A_1_extras = innings1.getExtraRuns().getTotal();
//
//             innings_A_1_bowling_order = innings1.getBowlerList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_1_noball = innings1.getExtraRuns().getNoballs();
//
//             innings_A_1_legbye = innings1.getExtraRuns().getLegbyes();
//
//             innings_A_1_bye = innings1.getExtraRuns().getByes();
//
//             innings_A_1_overs = innings1.getEquation().getOvers();
//
//
//             //For Innings two
//             innings_B_1_batting_order = innings2.getBatsmanList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_1_runs = Integer.parseInt(innings2.getScores());
//
//             innings_B_1_fall_of_wickets = innings2.getFows().stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_1_wide = innings2.getExtraRuns().getWides();
//
//             innings_B_1_run_rate = innings2.getEquation().getRunrate();
//
//             innings_B_1_run_str = innings2.getScores_full();
//
//             innings_B_1_wickets = innings2.getEquation().getWickets();
//
//             innings_B_1_extras = innings2.getExtraRuns().getTotal();
//             innings_B_1_bowling_order = innings2.getBowlerList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_1_noball = innings2.getExtraRuns().getNoballs();
//
//             innings_B_1_legbye = innings2.getExtraRuns().getLegbyes();
//
//             innings_B_1_bye = innings2.getExtraRuns().getByes();
//
//             innings_B_1_overs = innings2.getEquation().getOvers();
//
//
//             //For Innings three
//             innings_A_2_batting_order = innings3.getBatsmanList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_2_runs = Integer.parseInt(innings3.getScores());
//
//             innings_A_2_fall_of_wickets = innings3.getFows().stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_2_wide = innings3.getExtraRuns().getWides();
//
//             innings_A_2_run_rate = innings3.getEquation().getRunrate();
//
//             innings_A_2_run_str = innings3.getScores_full();
//
//             innings_A_2_wickets = innings3.getEquation().getWickets();
//
//             innings_A_2_extras = innings3.getExtraRuns().getTotal();
//
//             innings_A_2_bowling_order = innings3.getBowlerList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_A_2_noball = innings3.getExtraRuns().getNoballs();
//
//             innings_A_2_legbye = innings3.getExtraRuns().getLegbyes();
//
//             innings_A_2_bye = innings3.getExtraRuns().getByes();
//
//             innings_A_2_overs = innings3.getEquation().getOvers();
//
//
//             //For Innings four
//             innings_B_2_batting_order = innings4.getBatsmanList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_2_runs = Integer.parseInt(innings4.getScores());
//
//             innings_B_2_fall_of_wickets = innings4.getFows().stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_2_wide = innings4.getExtraRuns().getWides();
//
//             innings_B_2_run_rate = innings4.getEquation().getRunrate();
//
//             innings_B_2_run_str = innings4.getScores_full();
//
//             innings_B_2_wickets = innings4.getEquation().getWickets();
//
//             innings_B_2_extras = innings4.getExtraRuns().getTotal();
//
//             innings_B_2_bowling_order = innings4.getBowlerList().
//                     stream().map(Player::getShort_name)
//                     .collect(Collectors.toList());
//
//             innings_B_2_noball = innings4.getExtraRuns().getNoballs();
//
//             innings_B_2_legbye = innings4.getExtraRuns().getLegbyes();
//
//             innings_B_2_bye = innings4.getExtraRuns().getByes();
//
//             innings_B_2_overs = innings4.getEquation().getOvers();
//         }
//
//
//        // private String title;
//         status = matchScorecard.getMatch().getStatus();
//         man_of_match = matchScorecard.getMatch().getMan_of_the_match().getTitle();
//         format = matchScorecard.getMatch().getFormat_str();
//         name = matchScorecard.getMatch().getTitle();
//         venue = matchScorecard.getMatch().getVenue().getName();
//         start_date_timestamp = matchScorecard.getMatch().getTimestamp_start();
//         start_date_str = matchScorecard.getMatch().getDate_start().toString();
//    }
//
//
//
//
//
//
//
//
//    //a_1
//
//    //player_1
//    private String innings_A_1_batting_player_1_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_1_innings_1_sixes = null;
//    private String innings_A_1_batting_player_1_innings_1_fours = null;
//    private String innings_A_1_batting_player_1_innings_1_balls = null;
//    private String innings_A_1_batting_player_1_innings_1_runs = null;
//    private String innings_A_1_batting_player_1_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_1_innings_1_strike_rate = null;
//    //didn't map
//    private String innings_A_1_bowling_player_1_innings_1_maiden_overs = null;
//
//    //innings 2
//    private String innings_A_1_batting_player_1_innings_2_sixes = null;
//    private String innings_A_1_batting_player_1_innings_2_fours = null;
//    private String innings_A_1_batting_player_1_innings_2_balls = null;
//    private String innings_A_1_batting_player_1_innings_2_runs = null;
//    private String innings_A_1_batting_player_1_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_1_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_1_innings_2_maiden_overs = null;
//
//
//
//
//    //player_2
//    private String innings_A_1_batting_player_2_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_2_innings_1_sixes = null;
//    private String innings_A_1_batting_player_2_innings_1_fours = null;
//    private String innings_A_1_batting_player_2_innings_1_balls = null;
//    private String innings_A_1_batting_player_2_innings_1_runs = null;
//    private String innings_A_1_batting_player_2_innings_1_out_comment = null;
//    private String innings_A_1_bowling_player_2_innings_1_maiden_overs = null;
//    private String innings_A_1_batting_player_2_innings_1_strike_rate = null;
//    //innings 2
//    private String innings_A_1_batting_player_2_innings_2_sixes = null;
//    private String innings_A_1_batting_player_2_innings_2_fours = null;
//    private String innings_A_1_batting_player_2_innings_2_balls = null;
//    private String innings_A_1_batting_player_2_innings_2_runs = null;
//    private String innings_A_1_batting_player_2_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_2_innings_2_strike_rate = null;
//    private String innings_A_1_bowling_player_2_innings_2_maiden_overs = null;
//
//
//
//    //player_3
//    private String innings_A_1_batting_player_3_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_3_innings_1_sixes = null;
//    private String innings_A_1_batting_player_3_innings_1_fours = null;
//    private String innings_A_1_batting_player_3_innings_1_balls = null;
//    private String innings_A_1_batting_player_3_innings_1_runs = null;
//    private String innings_A_1_batting_player_3_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_3_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_3_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_3_innings_2_sixes = null;
//    private String innings_A_1_batting_player_3_innings_2_fours = null;
//    private String innings_A_1_batting_player_3_innings_2_balls = null;
//    private String innings_A_1_batting_player_3_innings_2_runs = null;
//    private String innings_A_1_batting_player_3_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_3_innings_2_strike_rate = null;
//    private String innings_A_1_bowling_player_3_innings_2_maiden_overs = null;
//
//
//
//    //player_4
//    private String innings_A_1_batting_player_4_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_4_innings_1_sixes = null;
//    private String innings_A_1_batting_player_4_innings_1_fours = null;
//    private String innings_A_1_batting_player_4_innings_1_balls = null;
//    private String innings_A_1_batting_player_4_innings_1_runs = null;
//    private String innings_A_1_batting_player_4_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_4_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_4_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_4_innings_2_sixes = null;
//    private String innings_A_1_batting_player_4_innings_2_fours = null;
//    private String innings_A_1_batting_player_4_innings_2_balls = null;
//    private String innings_A_1_batting_player_4_innings_2_runs = null;
//    private String innings_A_1_batting_player_4_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_4_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_4_innings_2_maiden_overs = null;
//
//
//    //player_5
//    private String innings_A_1_batting_player_5_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_5_innings_1_sixes = null;
//    private String innings_A_1_batting_player_5_innings_1_fours = null;
//    private String innings_A_1_batting_player_5_innings_1_balls = null;
//    private String innings_A_1_batting_player_5_innings_1_runs = null;
//    private String innings_A_1_batting_player_5_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_5_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_5_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_5_innings_2_sixes = null;
//    private String innings_A_1_batting_player_5_innings_2_fours = null;
//    private String innings_A_1_batting_player_5_innings_2_balls = null;
//    private String innings_A_1_batting_player_5_innings_2_runs = null;
//    private String innings_A_1_batting_player_5_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_5_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_5_innings_2_maiden_overs = null;
//
//
//    //player_6
//    private String innings_A_1_batting_player_6_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_6_innings_1_sixes = null;
//    private String innings_A_1_batting_player_6_innings_1_fours = null;
//    private String innings_A_1_batting_player_6_innings_1_balls = null;
//    private String innings_A_1_batting_player_6_innings_1_runs = null;
//    private String innings_A_1_batting_player_6_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_6_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_6_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_6_innings_2_sixes = null;
//    private String innings_A_1_batting_player_6_innings_2_fours = null;
//    private String innings_A_1_batting_player_6_innings_2_balls = null;
//    private String innings_A_1_batting_player_6_innings_2_runs = null;
//    private String innings_A_1_batting_player_6_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_6_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_6_innings_2_maiden_overs = null;
//
//
//    //player_7
//    private String innings_A_1_batting_player_7_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_7_innings_1_sixes = null;
//    private String innings_A_1_batting_player_7_innings_1_fours = null;
//    private String innings_A_1_batting_player_7_innings_1_balls = null;
//    private String innings_A_1_batting_player_7_innings_1_runs = null;
//    private String innings_A_1_batting_player_7_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_7_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_7_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_7_innings_2_sixes = null;
//    private String innings_A_1_batting_player_7_innings_2_fours = null;
//    private String innings_A_1_batting_player_7_innings_2_balls = null;
//    private String innings_A_1_batting_player_7_innings_2_runs = null;
//    private String innings_A_1_batting_player_7_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_7_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_7_innings_2_maiden_overs = null;
//
//
//    //player_8
//    private String innings_A_1_batting_player_8_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_8_innings_1_sixes = null;
//    private String innings_A_1_batting_player_8_innings_1_fours = null;
//    private String innings_A_1_batting_player_8_innings_1_balls = null;
//    private String innings_A_1_batting_player_8_innings_1_runs = null;
//    private String innings_A_1_batting_player_8_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_8_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_8_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_8_innings_2_sixes = null;
//    private String innings_A_1_batting_player_8_innings_2_fours = null;
//    private String innings_A_1_batting_player_8_innings_2_balls = null;
//    private String innings_A_1_batting_player_8_innings_2_runs = null;
//    private String innings_A_1_batting_player_8_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_8_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_8_innings_2_maiden_overs = null;
//
//
//    //player_9
//    private String innings_A_1_batting_player_9_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_9_innings_1_sixes = null;
//    private String innings_A_1_batting_player_9_innings_1_fours = null;
//    private String innings_A_1_batting_player_9_innings_1_balls = null;
//    private String innings_A_1_batting_player_9_innings_1_runs = null;
//    private String innings_A_1_batting_player_9_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_9_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_9_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_9_innings_2_sixes = null;
//    private String innings_A_1_batting_player_9_innings_2_fours = null;
//    private String innings_A_1_batting_player_9_innings_2_balls = null;
//    private String innings_A_1_batting_player_9_innings_2_runs = null;
//    private String innings_A_1_batting_player_9_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_9_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_9_innings_2_maiden_overs = null;
//
//
//    //player_10
//    private String innings_A_1_batting_player_10_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_10_innings_1_sixes = null;
//    private String innings_A_1_batting_player_10_innings_1_fours = null;
//    private String innings_A_1_batting_player_10_innings_1_balls = null;
//    private String innings_A_1_batting_player_10_innings_1_runs = null;
//    private String innings_A_1_batting_player_10_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_10_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_10_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_10_innings_2_sixes = null;
//    private String innings_A_1_batting_player_10_innings_2_fours = null;
//    private String innings_A_1_batting_player_10_innings_2_balls = null;
//    private String innings_A_1_batting_player_10_innings_2_runs = null;
//    private String innings_A_1_batting_player_10_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_10_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_10_innings_2_maiden_overs = null;
//
//
//
//    //player_11
//    private String innings_A_1_batting_player_11_full_name = null;
//    //innings 1
//    private String innings_A_1_batting_player_11_innings_1_sixes = null;
//    private String innings_A_1_batting_player_11_innings_1_fours = null;
//    private String innings_A_1_batting_player_11_innings_1_balls = null;
//    private String innings_A_1_batting_player_11_innings_1_runs = null;
//    private String innings_A_1_batting_player_11_innings_1_out_comment = null;
//    private String innings_A_1_batting_player_11_innings_1_strike_rate = null;
//    private String innings_A_1_bowling_player_11_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_A_1_batting_player_11_innings_2_sixes = null;
//    private String innings_A_1_batting_player_11_innings_2_fours = null;
//    private String innings_A_1_batting_player_11_innings_2_balls = null;
//    private String innings_A_1_batting_player_11_innings_2_runs = null;
//    private String innings_A_1_batting_player_11_innings_2_out_comment = null;
//    private String innings_A_1_batting_player_11_innings_2_strike_rate = null;
//
//    private String innings_A_1_bowling_player_11_innings_2_maiden_overs = null;
//
//
//
//
//
//
//    ////////////////////////////////////////////////////////////////////////////
//
////b_1
//
//    //player_1
//    private String innings_B_1_batting_player_1_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_1_innings_1_sixes = null;
//    private String innings_B_1_batting_player_1_innings_1_fours = null;
//    private String innings_B_1_batting_player_1_innings_1_balls = null;
//    private String innings_B_1_batting_player_1_innings_1_runs = null;
//    private String innings_B_1_batting_player_1_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_1_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_1_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_1_innings_2_sixes = null;
//    private String innings_B_1_batting_player_1_innings_2_fours = null;
//    private String innings_B_1_batting_player_1_innings_2_balls = null;
//    private String innings_B_1_batting_player_1_innings_2_runs = null;
//    private String innings_B_1_batting_player_1_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_1_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_1_innings_2_maiden_overs = null;
//
//
//
//
//    //player_2
//    private String innings_B_1_batting_player_2_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_2_innings_1_sixes = null;
//    private String innings_B_1_batting_player_2_innings_1_fours = null;
//    private String innings_B_1_batting_player_2_innings_1_balls = null;
//    private String innings_B_1_batting_player_2_innings_1_runs = null;
//    private String innings_B_1_batting_player_2_innings_1_out_comment;
//    private String innings_B_1_batting_player_2_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_2_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_2_innings_2_sixes = null;
//    private String innings_B_1_batting_player_2_innings_2_fours = null;
//    private String innings_B_1_batting_player_2_innings_2_balls = null;
//    private String innings_B_1_batting_player_2_innings_2_runs = null;
//    private String innings_B_1_batting_player_2_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_2_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_2_innings_2_maiden_overs = null;
//
//
//
//    //player_3
//    private String innings_B_1_batting_player_3_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_3_innings_1_sixes = null;
//    private String innings_B_1_batting_player_3_innings_1_fours = null;
//    private String innings_B_1_batting_player_3_innings_1_balls = null;
//    private String innings_B_1_batting_player_3_innings_1_runs = null;
//    private String innings_B_1_batting_player_3_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_3_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_3_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_3_innings_2_sixes = null;
//    private String innings_B_1_batting_player_3_innings_2_fours = null;
//    private String innings_B_1_batting_player_3_innings_2_balls = null;
//    private String innings_B_1_batting_player_3_innings_2_runs = null;
//    private String innings_B_1_batting_player_3_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_3_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_3_innings_2_maiden_overs = null;
//
//
//
//    //player_4
//    private String innings_B_1_batting_player_4_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_4_innings_1_sixes = null;
//    private String innings_B_1_batting_player_4_innings_1_fours = null;
//    private String innings_B_1_batting_player_4_innings_1_balls = null;
//    private String innings_B_1_batting_player_4_innings_1_runs = null;
//    private String innings_B_1_batting_player_4_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_4_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_4_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_4_innings_2_sixes = null;
//    private String innings_B_1_batting_player_4_innings_2_fours = null;
//    private String innings_B_1_batting_player_4_innings_2_balls = null;
//    private String innings_B_1_batting_player_4_innings_2_runs = null;
//    private String innings_B_1_batting_player_4_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_4_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_4_innings_2_maiden_overs = null;
//
//
//    //player_5
//    private String innings_B_1_batting_player_5_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_5_innings_1_sixes = null;
//    private String innings_B_1_batting_player_5_innings_1_fours = null;
//    private String innings_B_1_batting_player_5_innings_1_balls = null;
//    private String innings_B_1_batting_player_5_innings_1_runs = null;
//    private String innings_B_1_batting_player_5_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_5_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_5_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_5_innings_2_sixes = null;
//    private String innings_B_1_batting_player_5_innings_2_fours = null;
//    private String innings_B_1_batting_player_5_innings_2_balls = null;
//    private String innings_B_1_batting_player_5_innings_2_runs = null;
//    private String innings_B_1_batting_player_5_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_5_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_5_innings_2_maiden_overs = null;
//
//
//    //player_6
//    private String innings_B_1_batting_player_6_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_6_innings_1_sixes = null;
//    private String innings_B_1_batting_player_6_innings_1_fours = null;
//    private String innings_B_1_batting_player_6_innings_1_balls = null;
//    private String innings_B_1_batting_player_6_innings_1_runs = null;
//    private String innings_B_1_batting_player_6_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_6_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_6_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_6_innings_2_sixes = null;
//    private String innings_B_1_batting_player_6_innings_2_fours = null;
//    private String innings_B_1_batting_player_6_innings_2_balls = null;
//    private String innings_B_1_batting_player_6_innings_2_runs = null;
//    private String innings_B_1_batting_player_6_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_6_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_6_innings_2_maiden_overs = null;
//
//
//    //player_7
//    private String innings_B_1_batting_player_7_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_7_innings_1_sixes = null;
//    private String innings_B_1_batting_player_7_innings_1_fours = null;
//    private String innings_B_1_batting_player_7_innings_1_balls = null;
//    private String innings_B_1_batting_player_7_innings_1_runs = null;
//    private String innings_B_1_batting_player_7_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_7_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_7_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_7_innings_2_sixes = null;
//    private String innings_B_1_batting_player_7_innings_2_fours = null;
//    private String innings_B_1_batting_player_7_innings_2_balls = null;
//    private String innings_B_1_batting_player_7_innings_2_runs = null;
//    private String innings_B_1_batting_player_7_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_7_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_7_innings_2_maiden_overs = null;
//
//
//    //player_8
//    private String innings_B_1_batting_player_8_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_8_innings_1_sixes = null;
//    private String innings_B_1_batting_player_8_innings_1_fours = null;
//    private String innings_B_1_batting_player_8_innings_1_balls = null;
//    private String innings_B_1_batting_player_8_innings_1_runs = null;
//    private String innings_B_1_batting_player_8_innings_1_strike_rate = null;
//    private String innings_B_1_batting_player_8_innings_1_out_comment = null;
//    private String innings_B_1_bowling_player_8_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_8_innings_2_sixes = null;
//    private String innings_B_1_batting_player_8_innings_2_fours = null;
//    private String innings_B_1_batting_player_8_innings_2_balls = null;
//    private String innings_B_1_batting_player_8_innings_2_runs = null;
//    private String innings_B_1_batting_player_8_innings_2_strike_rate = null;
//    private String innings_B_1_batting_player_8_innings_2_out_comment = null;
//
//    private String innings_B_1_bowling_player_8_innings_2_maiden_overs = null;
//
//
//    //player_9
//    private String innings_B_1_batting_player_9_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_9_innings_1_sixes = null;
//    private String innings_B_1_batting_player_9_innings_1_fours = null;
//    private String innings_B_1_batting_player_9_innings_1_balls = null;
//    private String innings_B_1_batting_player_9_innings_1_runs = null;
//    private String innings_B_1_batting_player_9_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_9_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_9_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_9_innings_2_sixes = null;
//    private String innings_B_1_batting_player_9_innings_2_fours = null;
//    private String innings_B_1_batting_player_9_innings_2_balls = null;
//    private String innings_B_1_batting_player_9_innings_2_runs = null;
//    private String innings_B_1_batting_player_9_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_9_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_9_innings_2_maiden_overs = null;
//
//
//    //player_10
//    private String innings_B_1_batting_player_10_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_10_innings_1_sixes = null;
//    private String innings_B_1_batting_player_10_innings_1_fours = null;
//    private String innings_B_1_batting_player_10_innings_1_balls = null;
//    private String innings_B_1_batting_player_10_innings_1_runs = null;
//    private String innings_B_1_batting_player_10_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_10_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_10_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_10_innings_2_sixes = null;
//    private String innings_B_1_batting_player_10_innings_2_fours = null;
//    private String innings_B_1_batting_player_10_innings_2_balls = null;
//    private String innings_B_1_batting_player_10_innings_2_runs = null;
//    private String innings_B_1_batting_player_10_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_10_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_10_innings_2_maiden_overs = null;
//
//
//
//    //player_11
//    private String innings_B_1_batting_player_11_full_name = null;
//    //innings 1
//    private String innings_B_1_batting_player_11_innings_1_sixes = null;
//    private String innings_B_1_batting_player_11_innings_1_fours = null;
//    private String innings_B_1_batting_player_11_innings_1_balls = null;
//    private String innings_B_1_batting_player_11_innings_1_runs = null;
//    private String innings_B_1_batting_player_11_innings_1_out_comment = null;
//    private String innings_B_1_batting_player_11_innings_1_strike_rate = null;
//    private String innings_B_1_bowling_player_11_innings_1_maiden_overs = null;
//    //innings 2
//    private String innings_B_1_batting_player_11_innings_2_sixes = null;
//    private String innings_B_1_batting_player_11_innings_2_fours = null;
//    private String innings_B_1_batting_player_11_innings_2_balls = null;
//    private String innings_B_1_batting_player_11_innings_2_runs = null;
//    private String innings_B_1_batting_player_11_innings_2_out_comment = null;
//    private String innings_B_1_batting_player_11_innings_2_strike_rate = null;
//
//    private String innings_B_1_bowling_player_11_innings_2_maiden_overs = null;
//
//
//     public void initializeAllInningsBatsmans() {
//
//         if (matchScorecard.getMatch().getInningsList().size() == 2) {
//             //For team A
//             //player_1
//
//             innings_A_1_batting_player_1_full_name = innings1BatsmanList.get(0).getTitle();
//             innings_A_1_batting_player_1_innings_1_sixes = innings1BatsmanList.get(0).getSixes().toString();
//             innings_A_1_batting_player_1_innings_1_fours = innings1BatsmanList.get(0).getFours().toString();
//             innings_A_1_batting_player_1_innings_1_balls = innings1BatsmanList.get(0).getBalls_faced().toString();
//             innings_A_1_batting_player_1_innings_1_runs = innings1BatsmanList.get(0).getRuns().toString();
//             innings_A_1_batting_player_1_innings_1_out_comment = innings1BatsmanList.get(0).getHow_out();
//             innings_A_1_batting_player_1_innings_1_strike_rate = innings1BatsmanList.get(0).getStrike_rate();
//
//             //player_2
//
//             innings_A_1_batting_player_2_full_name = innings1BatsmanList.get(1).getTitle();
//             innings_A_1_batting_player_2_innings_1_sixes = innings1BatsmanList.get(1).getSixes().toString();
//             innings_A_1_batting_player_2_innings_1_fours = innings1BatsmanList.get(1).getFours().toString();
//             innings_A_1_batting_player_2_innings_1_balls = innings1BatsmanList.get(1).getBalls_faced().toString();
//             innings_A_1_batting_player_2_innings_1_runs = innings1BatsmanList.get(1).getRuns().toString();
//             innings_A_1_batting_player_2_innings_1_out_comment = innings1BatsmanList.get(1).getHow_out();
//             innings_A_1_batting_player_2_innings_1_strike_rate = innings1BatsmanList.get(1).getStrike_rate();
//
//             //player_3
//             innings_A_1_batting_player_3_full_name = innings1BatsmanList.get(2).getTitle();
//             innings_A_1_batting_player_3_innings_1_sixes = innings1BatsmanList.get(2).getSixes().toString();
//             innings_A_1_batting_player_3_innings_1_fours = innings1BatsmanList.get(2).getFours().toString();
//             innings_A_1_batting_player_3_innings_1_balls = innings1BatsmanList.get(2).getBalls_faced().toString();
//             innings_A_1_batting_player_3_innings_1_runs = innings1BatsmanList.get(2).getRuns().toString();
//             innings_A_1_batting_player_3_innings_1_out_comment = innings1BatsmanList.get(2).getHow_out();
//             innings_A_1_batting_player_3_innings_1_strike_rate = innings1BatsmanList.get(2).getStrike_rate();
//
//
//             //player_4
//             innings_A_1_batting_player_4_full_name = innings1BatsmanList.get(3).getTitle();
//             innings_A_1_batting_player_4_innings_1_sixes = innings1BatsmanList.get(3).getSixes().toString();
//             innings_A_1_batting_player_4_innings_1_fours = innings1BatsmanList.get(3).getFours().toString();
//             innings_A_1_batting_player_4_innings_1_balls = innings1BatsmanList.get(3).getBalls_faced().toString();
//             innings_A_1_batting_player_4_innings_1_runs = innings1BatsmanList.get(3).getRuns().toString();
//             innings_A_1_batting_player_4_innings_1_out_comment = innings1BatsmanList.get(3).getHow_out();
//             innings_A_1_batting_player_4_innings_1_strike_rate = innings1BatsmanList.get(3).getStrike_rate();
//
//             //player_5
//             innings_A_1_batting_player_5_full_name = innings1BatsmanList.get(4).getTitle();
//             innings_A_1_batting_player_5_innings_1_sixes = innings1BatsmanList.get(4).getSixes().toString();
//             innings_A_1_batting_player_5_innings_1_fours = innings1BatsmanList.get(4).getFours().toString();
//             innings_A_1_batting_player_5_innings_1_balls = innings1BatsmanList.get(4).getBalls_faced().toString();
//             innings_A_1_batting_player_5_innings_1_runs = innings1BatsmanList.get(4).getRuns().toString();
//             innings_A_1_batting_player_5_innings_1_out_comment = innings1BatsmanList.get(4).getHow_out();
//             innings_A_1_batting_player_5_innings_1_strike_rate = innings1BatsmanList.get(4).getStrike_rate();
//
//             //player_6
//             innings_A_1_batting_player_6_full_name = innings1BatsmanList.get(5).getTitle();
//             innings_A_1_batting_player_6_innings_1_sixes = innings1BatsmanList.get(5).getSixes().toString();
//             innings_A_1_batting_player_6_innings_1_fours = innings1BatsmanList.get(5).getFours().toString();
//             innings_A_1_batting_player_6_innings_1_balls = innings1BatsmanList.get(5).getBalls_faced().toString();
//             innings_A_1_batting_player_6_innings_1_runs = innings1BatsmanList.get(5).getRuns().toString();
//             innings_A_1_batting_player_6_innings_1_out_comment = innings1BatsmanList.get(5).getHow_out();
//             innings_A_1_batting_player_6_innings_1_strike_rate = innings1BatsmanList.get(5).getStrike_rate();
//
//             //player_7
//             innings_A_1_batting_player_7_full_name = innings1BatsmanList.get(6).getTitle();
//             innings_A_1_batting_player_7_innings_1_sixes = innings1BatsmanList.get(6).getSixes().toString();
//             innings_A_1_batting_player_7_innings_1_fours = innings1BatsmanList.get(6).getFours().toString();
//             innings_A_1_batting_player_7_innings_1_balls = innings1BatsmanList.get(6).getBalls_faced().toString();
//             innings_A_1_batting_player_7_innings_1_runs = innings1BatsmanList.get(6).getRuns().toString();
//             innings_A_1_batting_player_7_innings_1_out_comment = innings1BatsmanList.get(6).getHow_out();
//             innings_A_1_batting_player_7_innings_1_strike_rate = innings1BatsmanList.get(6).getStrike_rate();
//
//             //player_8
//             innings_A_1_batting_player_8_full_name = innings1BatsmanList.get(7).getTitle();
//             innings_A_1_batting_player_8_innings_1_sixes = innings1BatsmanList.get(7).getSixes().toString();
//             innings_A_1_batting_player_8_innings_1_fours = innings1BatsmanList.get(7).getFours().toString();
//             innings_A_1_batting_player_8_innings_1_balls = innings1BatsmanList.get(7).getBalls_faced().toString();
//             innings_A_1_batting_player_8_innings_1_runs = innings1BatsmanList.get(7).getRuns().toString();
//             innings_A_1_batting_player_8_innings_1_out_comment = innings1BatsmanList.get(7).getHow_out();
//             innings_A_1_batting_player_8_innings_1_strike_rate = innings1BatsmanList.get(7).getStrike_rate();
//
//             //player_9
//             innings_A_1_batting_player_9_full_name = innings1BatsmanList.get(8).getTitle();
//             innings_A_1_batting_player_9_innings_1_sixes = innings1BatsmanList.get(8).getSixes().toString();
//             innings_A_1_batting_player_9_innings_1_fours = innings1BatsmanList.get(8).getFours().toString();
//             innings_A_1_batting_player_9_innings_1_balls = innings1BatsmanList.get(8).getBalls_faced().toString();
//             innings_A_1_batting_player_9_innings_1_runs = innings1BatsmanList.get(8).getRuns().toString();
//             innings_A_1_batting_player_9_innings_1_out_comment = innings1BatsmanList.get(8).getHow_out();
//             innings_A_1_batting_player_9_innings_1_strike_rate = innings1BatsmanList.get(8).getStrike_rate();
//
//             //player_10
//             innings_A_1_batting_player_10_full_name = innings1BatsmanList.get(9).getTitle();
//             innings_A_1_batting_player_10_innings_1_sixes = innings1BatsmanList.get(9).getSixes().toString();
//             innings_A_1_batting_player_10_innings_1_fours = innings1BatsmanList.get(9).getFours().toString();
//             innings_A_1_batting_player_10_innings_1_balls = innings1BatsmanList.get(9).getBalls_faced().toString();
//             innings_A_1_batting_player_10_innings_1_runs = innings1BatsmanList.get(9).getRuns().toString();
//             innings_A_1_batting_player_10_innings_1_out_comment = innings1BatsmanList.get(9).getHow_out();
//             innings_A_1_batting_player_10_innings_1_strike_rate = innings1BatsmanList.get(9).getStrike_rate();
//
//             //player_11
//             innings_A_1_batting_player_11_full_name = innings1BatsmanList.get(10).getTitle();
//             innings_A_1_batting_player_11_innings_1_sixes = innings1BatsmanList.get(10).getSixes().toString();
//             innings_A_1_batting_player_11_innings_1_fours = innings1BatsmanList.get(10).getFours().toString();
//             innings_A_1_batting_player_11_innings_1_balls = innings1BatsmanList.get(10).getBalls_faced().toString();
//             innings_A_1_batting_player_11_innings_1_runs = innings1BatsmanList.get(10).getRuns().toString();
//             innings_A_1_batting_player_11_innings_1_out_comment = innings1BatsmanList.get(10).getHow_out();
//             innings_A_1_batting_player_11_innings_1_strike_rate = innings1BatsmanList.get(10).getStrike_rate();
//
//             //For team B
//
//             //player 1
//             innings_B_1_batting_player_1_full_name = innings2BatsmanList.get(0).getTitle();
//             innings_B_1_batting_player_1_innings_1_sixes = innings2BatsmanList.get(0).getSixes().toString();
//             innings_B_1_batting_player_1_innings_1_fours = innings2BatsmanList.get(0).getFours().toString();
//             innings_B_1_batting_player_1_innings_1_balls = innings2BatsmanList.get(0).getBalls_faced().toString();
//             innings_B_1_batting_player_1_innings_1_runs = innings2BatsmanList.get(0).getRuns().toString();
//             innings_B_1_batting_player_1_innings_1_out_comment = innings2BatsmanList.get(0).getHow_out();
//             innings_B_1_batting_player_1_innings_1_strike_rate = innings2BatsmanList.get(0).getStrike_rate();
//
//
//             //player 2
//             innings_B_1_batting_player_2_full_name = innings2BatsmanList.get(1).getTitle();
//             innings_B_1_batting_player_2_innings_1_sixes = innings2BatsmanList.get(1).getSixes().toString();
//             innings_B_1_batting_player_2_innings_1_fours = innings2BatsmanList.get(1).getFours().toString();
//             innings_B_1_batting_player_2_innings_1_balls = innings2BatsmanList.get(1).getBalls_faced().toString();
//             innings_B_1_batting_player_2_innings_1_runs = innings2BatsmanList.get(1).getRuns().toString();
//             innings_B_1_batting_player_2_innings_1_out_comment = innings2BatsmanList.get(1).getHow_out();
//             innings_B_1_batting_player_2_innings_1_strike_rate = innings2BatsmanList.get(1).getStrike_rate();
//
//
//             //player 3
//             innings_B_1_batting_player_3_full_name = innings2BatsmanList.get(2).getTitle();
//             innings_B_1_batting_player_3_innings_1_sixes = innings2BatsmanList.get(2).getSixes().toString();
//             innings_B_1_batting_player_3_innings_1_fours = innings2BatsmanList.get(2).getFours().toString();
//             innings_B_1_batting_player_3_innings_1_balls = innings2BatsmanList.get(2).getBalls_faced().toString();
//             innings_B_1_batting_player_3_innings_1_runs = innings2BatsmanList.get(2).getRuns().toString();
//             innings_B_1_batting_player_3_innings_1_out_comment = innings2BatsmanList.get(2).getHow_out();
//             innings_B_1_batting_player_3_innings_1_strike_rate = innings2BatsmanList.get(2).getStrike_rate();
//
//             //player 4
//             innings_B_1_batting_player_4_full_name = innings2BatsmanList.get(3).getTitle();
//             innings_B_1_batting_player_4_innings_1_sixes = innings2BatsmanList.get(3).getSixes().toString();
//             innings_B_1_batting_player_4_innings_1_fours = innings2BatsmanList.get(3).getFours().toString();
//             innings_B_1_batting_player_4_innings_1_balls = innings2BatsmanList.get(3).getBalls_faced().toString();
//             innings_B_1_batting_player_4_innings_1_runs = innings2BatsmanList.get(3).getRuns().toString();
//             innings_B_1_batting_player_4_innings_1_out_comment = innings2BatsmanList.get(3).getHow_out();
//             innings_B_1_batting_player_4_innings_1_strike_rate = innings2BatsmanList.get(3).getStrike_rate();
//
//
//             //player 5
//             innings_B_1_batting_player_5_full_name = innings2BatsmanList.get(4).getTitle();
//             innings_B_1_batting_player_5_innings_1_sixes = innings2BatsmanList.get(4).getSixes().toString();
//             innings_B_1_batting_player_5_innings_1_fours = innings2BatsmanList.get(4).getFours().toString();
//             innings_B_1_batting_player_5_innings_1_balls = innings2BatsmanList.get(4).getBalls_faced().toString();
//             innings_B_1_batting_player_5_innings_1_runs = innings2BatsmanList.get(4).getRuns().toString();
//             innings_B_1_batting_player_5_innings_1_out_comment = innings2BatsmanList.get(4).getHow_out();
//             innings_B_1_batting_player_5_innings_1_strike_rate = innings2BatsmanList.get(4).getStrike_rate();
//
//
//             //player 6
//             innings_B_1_batting_player_6_full_name = innings2BatsmanList.get(5).getTitle();
//             innings_B_1_batting_player_6_innings_1_sixes = innings2BatsmanList.get(5).getSixes().toString();
//             innings_B_1_batting_player_6_innings_1_fours = innings2BatsmanList.get(5).getFours().toString();
//             innings_B_1_batting_player_6_innings_1_balls = innings2BatsmanList.get(5).getBalls_faced().toString();
//             innings_B_1_batting_player_6_innings_1_runs = innings2BatsmanList.get(5).getRuns().toString();
//             innings_B_1_batting_player_6_innings_1_out_comment = innings2BatsmanList.get(5).getHow_out();
//             innings_B_1_batting_player_6_innings_1_strike_rate = innings2BatsmanList.get(5).getStrike_rate();
//
//
//             //player 7
//             innings_B_1_batting_player_7_full_name = innings2BatsmanList.get(6).getTitle();
//             innings_B_1_batting_player_7_innings_1_sixes = innings2BatsmanList.get(6).getSixes().toString();
//             innings_B_1_batting_player_7_innings_1_fours = innings2BatsmanList.get(6).getFours().toString();
//             innings_B_1_batting_player_7_innings_1_balls = innings2BatsmanList.get(6).getBalls_faced().toString();
//             innings_B_1_batting_player_7_innings_1_runs = innings2BatsmanList.get(6).getRuns().toString();
//             innings_B_1_batting_player_7_innings_1_out_comment = innings2BatsmanList.get(6).getHow_out();
//             innings_B_1_batting_player_7_innings_1_strike_rate = innings2BatsmanList.get(6).getStrike_rate();
//
//
//             //player 8
//             innings_B_1_batting_player_8_full_name = innings2BatsmanList.get(7).getTitle();
//             innings_B_1_batting_player_8_innings_1_sixes = innings2BatsmanList.get(7).getSixes().toString();
//             innings_B_1_batting_player_8_innings_1_fours = innings2BatsmanList.get(7).getFours().toString();
//             innings_B_1_batting_player_8_innings_1_balls = innings2BatsmanList.get(7).getBalls_faced().toString();
//             innings_B_1_batting_player_8_innings_1_runs = innings2BatsmanList.get(7).getRuns().toString();
//             innings_B_1_batting_player_8_innings_1_out_comment = innings2BatsmanList.get(7).getHow_out();
//             innings_B_1_batting_player_8_innings_1_strike_rate = innings2BatsmanList.get(7).getStrike_rate();
//
//
//             //player 9
//
//             innings_B_1_batting_player_9_full_name = innings2BatsmanList.get(8).getTitle();
//             innings_B_1_batting_player_9_innings_1_sixes = innings2BatsmanList.get(8).getSixes().toString();
//             innings_B_1_batting_player_9_innings_1_fours = innings2BatsmanList.get(8).getFours().toString();
//             innings_B_1_batting_player_9_innings_1_balls = innings2BatsmanList.get(8).getBalls_faced().toString();
//             innings_B_1_batting_player_9_innings_1_runs = innings2BatsmanList.get(8).getRuns().toString();
//             innings_B_1_batting_player_9_innings_1_out_comment = innings2BatsmanList.get(8).getHow_out();
//             innings_B_1_batting_player_9_innings_1_strike_rate = innings2BatsmanList.get(8).getStrike_rate();
//
//
//             //player 10
//             innings_B_1_batting_player_10_full_name = innings2BatsmanList.get(9).getTitle();
//             innings_B_1_batting_player_10_innings_1_sixes = innings2BatsmanList.get(9).getSixes().toString();
//             innings_B_1_batting_player_10_innings_1_fours = innings2BatsmanList.get(9).getFours().toString();
//             innings_B_1_batting_player_10_innings_1_balls = innings2BatsmanList.get(9).getBalls_faced().toString();
//             innings_B_1_batting_player_10_innings_1_runs = innings2BatsmanList.get(9).getRuns().toString();
//             innings_B_1_batting_player_10_innings_1_out_comment = innings2BatsmanList.get(9).getHow_out();
//             innings_B_1_batting_player_10_innings_1_strike_rate = innings2BatsmanList.get(9).getStrike_rate();
//
//
//             //player 11
//
//             innings_B_1_batting_player_11_full_name = innings2BatsmanList.get(10).getTitle();
//             innings_B_1_batting_player_11_innings_1_sixes = innings2BatsmanList.get(10).getSixes().toString();
//             innings_B_1_batting_player_11_innings_1_fours = innings2BatsmanList.get(10).getFours().toString();
//             innings_B_1_batting_player_11_innings_1_balls = innings2BatsmanList.get(10).getBalls_faced().toString();
//             innings_B_1_batting_player_11_innings_1_runs = innings2BatsmanList.get(10).getRuns().toString();
//             innings_B_1_batting_player_11_innings_1_out_comment = innings2BatsmanList.get(10).getHow_out();
//             innings_B_1_batting_player_11_innings_1_strike_rate = innings2BatsmanList.get(10).getStrike_rate();
//
//         } else {
//
//             //For team A
//             //player_1
//
//             innings_A_1_batting_player_1_full_name = innings1BatsmanList.get(0).getTitle();
//             innings_A_1_batting_player_1_innings_1_sixes = innings1BatsmanList.get(0).getSixes().toString();
//             innings_A_1_batting_player_1_innings_1_fours = innings1BatsmanList.get(0).getFours().toString();
//             innings_A_1_batting_player_1_innings_1_balls = innings1BatsmanList.get(0).getBalls_faced().toString();
//             innings_A_1_batting_player_1_innings_1_runs = innings1BatsmanList.get(0).getRuns().toString();
//             innings_A_1_batting_player_1_innings_1_out_comment = innings1BatsmanList.get(0).getHow_out();
//             innings_A_1_batting_player_1_innings_1_strike_rate = innings1BatsmanList.get(0).getStrike_rate();
//
//             Player teamAplayer1 = innings3BatsmanList.stream().
//                     filter(p -> p.getTitle().equals(innings1BatsmanList.get(0).getTitle())).findFirst().orElse(null);
//
//             innings_A_1_batting_player_1_innings_2_sixes = teamAplayer1.getSixes().toString();
//             innings_A_1_batting_player_1_innings_2_fours = teamAplayer1.getFours().toString();
//             innings_A_1_batting_player_1_innings_2_balls = teamAplayer1.getBalls_faced().toString();
//             innings_A_1_batting_player_1_innings_2_runs = teamAplayer1.getRuns().toString();
//             innings_A_1_batting_player_1_innings_2_out_comment = teamAplayer1.getHow_out();
//             innings_A_1_batting_player_1_innings_2_strike_rate = teamAplayer1.getStrike_rate();
//
//             //player_2
//
//             innings_A_1_batting_player_2_full_name = innings1BatsmanList.get(1).getTitle();
//             innings_A_1_batting_player_2_innings_1_sixes = innings1BatsmanList.get(1).getSixes().toString();
//             innings_A_1_batting_player_2_innings_1_fours = innings1BatsmanList.get(1).getFours().toString();
//             innings_A_1_batting_player_2_innings_1_balls = innings1BatsmanList.get(1).getBalls_faced().toString();
//             innings_A_1_batting_player_2_innings_1_runs = innings1BatsmanList.get(1).getRuns().toString();
//             innings_A_1_batting_player_2_innings_1_out_comment = innings1BatsmanList.get(1).getHow_out();
//             innings_A_1_batting_player_2_innings_1_strike_rate = innings1BatsmanList.get(1).getStrike_rate();
//
//             Player teamAplayer2 = innings3BatsmanList.stream().filter(p -> p.getTitle().equals(innings1BatsmanList.get(1).getTitle())).findFirst().orElse(null);
//
//             innings_A_1_batting_player_2_innings_2_sixes = teamAplayer2.getSixes().toString();
//             innings_A_1_batting_player_2_innings_2_fours = teamAplayer2.getFours().toString();
//             innings_A_1_batting_player_2_innings_2_balls = teamAplayer2.getBalls_faced().toString();
//             innings_A_1_batting_player_2_innings_2_runs = teamAplayer2.getRuns().toString();
//             innings_A_1_batting_player_2_innings_2_out_comment = teamAplayer2.getHow_out();
//             innings_A_1_batting_player_2_innings_2_strike_rate = teamAplayer2.getStrike_rate();
//
//             //player_3
//             innings_A_1_batting_player_3_full_name = innings1BatsmanList.get(2).getTitle();
//             innings_A_1_batting_player_3_innings_1_sixes = innings1BatsmanList.get(2).getSixes().toString();
//             innings_A_1_batting_player_3_innings_1_fours = innings1BatsmanList.get(2).getFours().toString();
//             innings_A_1_batting_player_3_innings_1_balls = innings1BatsmanList.get(2).getBalls_faced().toString();
//             innings_A_1_batting_player_3_innings_1_runs = innings1BatsmanList.get(2).getRuns().toString();
//             innings_A_1_batting_player_3_innings_1_out_comment = innings1BatsmanList.get(2).getHow_out();
//             innings_A_1_batting_player_3_innings_1_strike_rate = innings1BatsmanList.get(2).getStrike_rate();
//
//             Player teamAplayer3 = innings3BatsmanList.stream().filter(p -> p.getTitle().equals(innings1BatsmanList.get(2).getTitle())).findFirst().orElse(null);
//             innings_A_1_batting_player_3_innings_2_sixes = teamAplayer3.getSixes().toString();
//             innings_A_1_batting_player_3_innings_2_fours = teamAplayer3.getFours().toString();
//             innings_A_1_batting_player_3_innings_2_balls = teamAplayer3.getBalls_faced().toString();
//             innings_A_1_batting_player_3_innings_2_runs = teamAplayer3.getRuns().toString();
//             innings_A_1_batting_player_3_innings_2_out_comment = teamAplayer3.getHow_out();
//             innings_A_1_batting_player_3_innings_2_strike_rate = teamAplayer3.getStrike_rate();
//
//             //player_4
//             innings_A_1_batting_player_4_full_name = innings1BatsmanList.get(3).getTitle();
//             innings_A_1_batting_player_4_innings_1_sixes = innings1BatsmanList.get(3).getSixes().toString();
//             innings_A_1_batting_player_4_innings_1_fours = innings1BatsmanList.get(3).getFours().toString();
//             innings_A_1_batting_player_4_innings_1_balls = innings1BatsmanList.get(3).getBalls_faced().toString();
//             innings_A_1_batting_player_4_innings_1_runs = innings1BatsmanList.get(3).getRuns().toString();
//             innings_A_1_batting_player_4_innings_1_out_comment = innings1BatsmanList.get(3).getHow_out();
//             innings_A_1_batting_player_4_innings_1_strike_rate = innings1BatsmanList.get(3).getStrike_rate();
//
//             Player teamAplayer4 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(3).getTitle())).
//                     findFirst().orElse(null);
//             innings_A_1_batting_player_4_innings_2_sixes = teamAplayer4.getSixes().toString();
//             innings_A_1_batting_player_4_innings_2_fours = teamAplayer4.getFours().toString();
//             innings_A_1_batting_player_4_innings_2_balls = teamAplayer4.getBalls_faced().toString();
//             innings_A_1_batting_player_4_innings_2_runs = teamAplayer4.getRuns().toString();
//             innings_A_1_batting_player_4_innings_2_out_comment = teamAplayer4.getHow_out();
//             innings_A_1_batting_player_4_innings_2_strike_rate = teamAplayer4.getStrike_rate();
//
//             //player_5
//             innings_A_1_batting_player_5_full_name = innings1BatsmanList.get(4).getTitle();
//             innings_A_1_batting_player_5_innings_1_sixes = innings1BatsmanList.get(4).getSixes().toString();
//             innings_A_1_batting_player_5_innings_1_fours = innings1BatsmanList.get(4).getFours().toString();
//             innings_A_1_batting_player_5_innings_1_balls = innings1BatsmanList.get(4).getBalls_faced().toString();
//             innings_A_1_batting_player_5_innings_1_runs = innings1BatsmanList.get(4).getRuns().toString();
//             innings_A_1_batting_player_5_innings_1_out_comment = innings1BatsmanList.get(4).getHow_out();
//             innings_A_1_batting_player_5_innings_1_strike_rate = innings1BatsmanList.get(4).getStrike_rate();
//
//             Player teamAplayer5 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(4).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_5_innings_2_sixes = teamAplayer5.getSixes().toString();
//             innings_A_1_batting_player_5_innings_2_fours = teamAplayer5.getFours().toString();
//             innings_A_1_batting_player_5_innings_2_balls = teamAplayer5.getBalls_faced().toString();
//             innings_A_1_batting_player_5_innings_2_runs = teamAplayer5.getRuns().toString();
//             innings_A_1_batting_player_5_innings_2_out_comment = teamAplayer5.getHow_out();
//             innings_A_1_batting_player_5_innings_2_strike_rate = teamAplayer5.getStrike_rate();
//
//
//             //player_6
//             innings_A_1_batting_player_6_full_name = innings1BatsmanList.get(5).getTitle();
//             innings_A_1_batting_player_6_innings_1_sixes = innings1BatsmanList.get(5).getSixes().toString();
//             innings_A_1_batting_player_6_innings_1_fours = innings1BatsmanList.get(5).getFours().toString();
//             innings_A_1_batting_player_6_innings_1_balls = innings1BatsmanList.get(5).getBalls_faced().toString();
//             innings_A_1_batting_player_6_innings_1_runs = innings1BatsmanList.get(5).getRuns().toString();
//             innings_A_1_batting_player_6_innings_1_out_comment = innings1BatsmanList.get(5).getHow_out();
//             innings_A_1_batting_player_6_innings_1_strike_rate = innings1BatsmanList.get(5).getStrike_rate();
//
//             Player teamAplayer6 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(5).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_6_innings_2_sixes = teamAplayer6.getSixes().toString();
//             innings_A_1_batting_player_6_innings_2_fours = teamAplayer6.getFours().toString();
//             innings_A_1_batting_player_6_innings_2_balls = teamAplayer6.getBalls_faced().toString();
//             innings_A_1_batting_player_6_innings_2_runs = teamAplayer6.getRuns().toString();
//             innings_A_1_batting_player_6_innings_2_out_comment = teamAplayer6.getHow_out();
//             innings_A_1_batting_player_6_innings_2_strike_rate = teamAplayer6.getStrike_rate();
//
//             //player_7
//             innings_A_1_batting_player_7_full_name = innings1BatsmanList.get(6).getTitle();
//             innings_A_1_batting_player_7_innings_1_sixes = innings1BatsmanList.get(6).getSixes().toString();
//             innings_A_1_batting_player_7_innings_1_fours = innings1BatsmanList.get(6).getFours().toString();
//             innings_A_1_batting_player_7_innings_1_balls = innings1BatsmanList.get(6).getBalls_faced().toString();
//             innings_A_1_batting_player_7_innings_1_runs = innings1BatsmanList.get(6).getRuns().toString();
//             innings_A_1_batting_player_7_innings_1_out_comment = innings1BatsmanList.get(6).getHow_out();
//             innings_A_1_batting_player_7_innings_1_strike_rate = innings1BatsmanList.get(6).getStrike_rate();
//
//             Player teamAplayer7 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(6).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_7_innings_2_sixes = teamAplayer7.getSixes().toString();
//             innings_A_1_batting_player_7_innings_2_fours = teamAplayer7.getFours().toString();
//             innings_A_1_batting_player_7_innings_2_balls = teamAplayer7.getBalls_faced().toString();
//             innings_A_1_batting_player_7_innings_2_runs = teamAplayer7.getRuns().toString();
//             innings_A_1_batting_player_7_innings_2_out_comment = teamAplayer7.getHow_out();
//             innings_A_1_batting_player_7_innings_2_strike_rate = teamAplayer7.getStrike_rate();
//
//             //player_8
//             innings_A_1_batting_player_8_full_name = innings1BatsmanList.get(7).getTitle();
//             innings_A_1_batting_player_8_innings_1_sixes = innings1BatsmanList.get(7).getSixes().toString();
//             innings_A_1_batting_player_8_innings_1_fours = innings1BatsmanList.get(7).getFours().toString();
//             innings_A_1_batting_player_8_innings_1_balls = innings1BatsmanList.get(7).getBalls_faced().toString();
//             innings_A_1_batting_player_8_innings_1_runs = innings1BatsmanList.get(7).getRuns().toString();
//             innings_A_1_batting_player_8_innings_1_out_comment = innings1BatsmanList.get(7).getHow_out();
//             innings_A_1_batting_player_8_innings_1_strike_rate = innings1BatsmanList.get(7).getStrike_rate();
//
//             Player teamAplayer8 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(7).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_8_innings_2_sixes = teamAplayer8.getSixes().toString();
//             innings_A_1_batting_player_8_innings_2_fours = teamAplayer8.getFours().toString();
//             innings_A_1_batting_player_8_innings_2_balls = teamAplayer8.getBalls_faced().toString();
//             innings_A_1_batting_player_8_innings_2_runs = teamAplayer8.getRuns().toString();
//             innings_A_1_batting_player_8_innings_2_out_comment = teamAplayer8.getHow_out();
//             innings_A_1_batting_player_8_innings_2_strike_rate = teamAplayer8.getStrike_rate();
//
//             //player_9
//             innings_A_1_batting_player_9_full_name = innings1BatsmanList.get(8).getTitle();
//             innings_A_1_batting_player_9_innings_1_sixes = innings1BatsmanList.get(8).getSixes().toString();
//             innings_A_1_batting_player_9_innings_1_fours = innings1BatsmanList.get(8).getFours().toString();
//             innings_A_1_batting_player_9_innings_1_balls = innings1BatsmanList.get(8).getBalls_faced().toString();
//             innings_A_1_batting_player_9_innings_1_runs = innings1BatsmanList.get(8).getRuns().toString();
//             innings_A_1_batting_player_9_innings_1_out_comment = innings1BatsmanList.get(8).getHow_out();
//             innings_A_1_batting_player_9_innings_1_strike_rate = innings1BatsmanList.get(8).getStrike_rate();
//
//             Player teamAplayer9 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(8).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_9_innings_2_sixes = teamAplayer9.getSixes().toString();
//             innings_A_1_batting_player_9_innings_2_fours = teamAplayer9.getFours().toString();
//             innings_A_1_batting_player_9_innings_2_balls = teamAplayer9.getBalls_faced().toString();
//             innings_A_1_batting_player_9_innings_2_runs = teamAplayer9.getRuns().toString();
//             innings_A_1_batting_player_9_innings_2_out_comment = teamAplayer9.getHow_out();
//             innings_A_1_batting_player_9_innings_2_strike_rate = teamAplayer9.getStrike_rate();
//
//             //player_10
//             innings_A_1_batting_player_10_full_name = innings1BatsmanList.get(9).getTitle();
//             innings_A_1_batting_player_10_innings_1_sixes = innings1BatsmanList.get(9).getSixes().toString();
//             innings_A_1_batting_player_10_innings_1_fours = innings1BatsmanList.get(9).getFours().toString();
//             innings_A_1_batting_player_10_innings_1_balls = innings1BatsmanList.get(9).getBalls_faced().toString();
//             innings_A_1_batting_player_10_innings_1_runs = innings1BatsmanList.get(9).getRuns().toString();
//             innings_A_1_batting_player_10_innings_1_out_comment = innings1BatsmanList.get(9).getHow_out();
//             innings_A_1_batting_player_10_innings_1_strike_rate = innings1BatsmanList.get(9).getStrike_rate();
//
//             Player teamAplayer10 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(9).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_10_innings_2_sixes = teamAplayer10.getSixes().toString();
//             innings_A_1_batting_player_10_innings_2_fours = teamAplayer10.getFours().toString();
//             innings_A_1_batting_player_10_innings_2_balls = teamAplayer10.getBalls_faced().toString();
//             innings_A_1_batting_player_10_innings_2_runs = teamAplayer10.getRuns().toString();
//             innings_A_1_batting_player_10_innings_2_out_comment = teamAplayer10.getHow_out();
//             innings_A_1_batting_player_10_innings_2_strike_rate = teamAplayer10.getStrike_rate();
//
//             //player_11
//             innings_A_1_batting_player_11_full_name = innings1BatsmanList.get(10).getTitle();
//             innings_A_1_batting_player_11_innings_1_sixes = innings1BatsmanList.get(10).getSixes().toString();
//             innings_A_1_batting_player_11_innings_1_fours = innings1BatsmanList.get(10).getFours().toString();
//             innings_A_1_batting_player_11_innings_1_balls = innings1BatsmanList.get(10).getBalls_faced().toString();
//             innings_A_1_batting_player_11_innings_1_runs = innings1BatsmanList.get(10).getRuns().toString();
//             innings_A_1_batting_player_11_innings_1_out_comment = innings1BatsmanList.get(10).getHow_out();
//             innings_A_1_batting_player_11_innings_1_strike_rate = innings1BatsmanList.get(10).getStrike_rate();
//
//             Player teamAplayer11 = innings3BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings1BatsmanList.get(10).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_A_1_batting_player_11_innings_2_sixes = teamAplayer11.getSixes().toString();
//             innings_A_1_batting_player_11_innings_2_fours = teamAplayer11.getFours().toString();
//             innings_A_1_batting_player_11_innings_2_balls = teamAplayer11.getBalls_faced().toString();
//             innings_A_1_batting_player_11_innings_2_runs = teamAplayer11.getRuns().toString();
//             innings_A_1_batting_player_11_innings_2_out_comment = teamAplayer11.getHow_out();
//             innings_A_1_batting_player_11_innings_2_strike_rate = teamAplayer11.getStrike_rate();
//
//
//             //For team B
//
//             //player 1
//             innings_B_1_batting_player_1_full_name = innings2BatsmanList.get(0).getTitle();
//             innings_B_1_batting_player_1_innings_1_sixes = innings2BatsmanList.get(0).getSixes().toString();
//             innings_B_1_batting_player_1_innings_1_fours = innings2BatsmanList.get(0).getFours().toString();
//             innings_B_1_batting_player_1_innings_1_balls = innings2BatsmanList.get(0).getBalls_faced().toString();
//             innings_B_1_batting_player_1_innings_1_runs = innings2BatsmanList.get(0).getRuns().toString();
//             innings_B_1_batting_player_1_innings_1_out_comment = innings2BatsmanList.get(0).getHow_out();
//             innings_B_1_batting_player_1_innings_1_strike_rate = innings2BatsmanList.get(0).getStrike_rate();
//
//             Player teamBplayer1 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(0).getTitle())).
//                     findFirst().orElse(null);
//             innings_B_1_batting_player_1_innings_2_sixes = teamBplayer1.getSixes().toString();
//             innings_B_1_batting_player_1_innings_2_fours = teamBplayer1.getFours().toString();
//             innings_B_1_batting_player_1_innings_2_balls = teamBplayer1.getBalls_faced().toString();
//             innings_B_1_batting_player_1_innings_2_runs = teamBplayer1.getRuns().toString();
//             innings_B_1_batting_player_1_innings_2_out_comment = teamBplayer1.getHow_out();
//             innings_B_1_batting_player_1_innings_2_strike_rate = teamBplayer1.getStrike_rate();
//
//             //player 2
//             innings_B_1_batting_player_2_full_name = innings2BatsmanList.get(1).getTitle();
//             innings_B_1_batting_player_2_innings_1_sixes = innings2BatsmanList.get(1).getSixes().toString();
//             innings_B_1_batting_player_2_innings_1_fours = innings2BatsmanList.get(1).getFours().toString();
//             innings_B_1_batting_player_2_innings_1_balls = innings2BatsmanList.get(1).getBalls_faced().toString();
//             innings_B_1_batting_player_2_innings_1_runs = innings2BatsmanList.get(1).getRuns().toString();
//             innings_B_1_batting_player_2_innings_1_out_comment = innings2BatsmanList.get(1).getHow_out();
//             innings_B_1_batting_player_2_innings_1_strike_rate = innings2BatsmanList.get(1).getStrike_rate();
//
//             Player teamBplayer2 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(1).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_2_innings_2_sixes = teamBplayer2.getSixes().toString();
//             innings_B_1_batting_player_2_innings_2_fours = teamBplayer2.getFours().toString();
//             innings_B_1_batting_player_2_innings_2_balls = teamBplayer2.getBalls_faced().toString();
//             innings_B_1_batting_player_2_innings_2_runs = teamBplayer2.getRuns().toString();
//             innings_B_1_batting_player_2_innings_2_out_comment = teamBplayer2.getHow_out();
//             innings_B_1_batting_player_2_innings_2_strike_rate = teamBplayer2.getStrike_rate();
//
//             //player 3
//             innings_B_1_batting_player_3_full_name = innings2BatsmanList.get(2).getTitle();
//             innings_B_1_batting_player_3_innings_1_sixes = innings2BatsmanList.get(2).getSixes().toString();
//             innings_B_1_batting_player_3_innings_1_fours = innings2BatsmanList.get(2).getFours().toString();
//             innings_B_1_batting_player_3_innings_1_balls = innings2BatsmanList.get(2).getBalls_faced().toString();
//             innings_B_1_batting_player_3_innings_1_runs = innings2BatsmanList.get(2).getRuns().toString();
//             innings_B_1_batting_player_3_innings_1_out_comment = innings2BatsmanList.get(2).getHow_out();
//             innings_B_1_batting_player_3_innings_1_strike_rate = innings2BatsmanList.get(2).getStrike_rate();
//
//             Player teamBplayer3 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(2).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_3_innings_2_sixes = teamBplayer3.getSixes().toString();
//             innings_B_1_batting_player_3_innings_2_fours = teamBplayer3.getFours().toString();
//             innings_B_1_batting_player_3_innings_2_balls = teamBplayer3.getBalls_faced().toString();
//             innings_B_1_batting_player_3_innings_2_runs = teamBplayer3.getRuns().toString();
//             innings_B_1_batting_player_3_innings_2_out_comment = teamBplayer3.getHow_out();
//             innings_B_1_batting_player_3_innings_2_strike_rate = teamBplayer3.getStrike_rate();
//
//             //player 4
//             innings_B_1_batting_player_4_full_name = innings2BatsmanList.get(3).getTitle();
//             innings_B_1_batting_player_4_innings_1_sixes = innings2BatsmanList.get(3).getSixes().toString();
//             innings_B_1_batting_player_4_innings_1_fours = innings2BatsmanList.get(3).getFours().toString();
//             innings_B_1_batting_player_4_innings_1_balls = innings2BatsmanList.get(3).getBalls_faced().toString();
//             innings_B_1_batting_player_4_innings_1_runs = innings2BatsmanList.get(3).getRuns().toString();
//             innings_B_1_batting_player_4_innings_1_out_comment = innings2BatsmanList.get(3).getHow_out();
//             innings_B_1_batting_player_4_innings_1_strike_rate = innings2BatsmanList.get(3).getStrike_rate();
//
//             Player teamBplayer4 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(3).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_4_innings_2_sixes = teamBplayer4.getSixes().toString();
//             innings_B_1_batting_player_4_innings_2_fours = teamBplayer4.getFours().toString();
//             innings_B_1_batting_player_4_innings_2_balls = teamBplayer4.getBalls_faced().toString();
//             innings_B_1_batting_player_4_innings_2_runs = teamBplayer4.getRuns().toString();
//             innings_B_1_batting_player_4_innings_2_out_comment = teamBplayer4.getHow_out();
//             innings_B_1_batting_player_4_innings_2_strike_rate = teamBplayer4.getStrike_rate();
//
//             //player 5
//             innings_B_1_batting_player_5_full_name = innings2BatsmanList.get(4).getTitle();
//             innings_B_1_batting_player_5_innings_1_sixes = innings2BatsmanList.get(4).getSixes().toString();
//             innings_B_1_batting_player_5_innings_1_fours = innings2BatsmanList.get(4).getFours().toString();
//             innings_B_1_batting_player_5_innings_1_balls = innings2BatsmanList.get(4).getBalls_faced().toString();
//             innings_B_1_batting_player_5_innings_1_runs = innings2BatsmanList.get(4).getRuns().toString();
//             innings_B_1_batting_player_5_innings_1_out_comment = innings2BatsmanList.get(4).getHow_out();
//             innings_B_1_batting_player_5_innings_1_strike_rate = innings2BatsmanList.get(4).getStrike_rate();
//
//             Player teamBplayer5 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(4).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_5_innings_2_sixes = teamBplayer5.getSixes().toString();
//             innings_B_1_batting_player_5_innings_2_fours = teamBplayer5.getFours().toString();
//             innings_B_1_batting_player_5_innings_2_balls = teamBplayer5.getBalls_faced().toString();
//             innings_B_1_batting_player_5_innings_2_runs = teamBplayer5.getRuns().toString();
//             innings_B_1_batting_player_5_innings_2_out_comment = teamBplayer5.getHow_out();
//             innings_B_1_batting_player_5_innings_2_strike_rate = teamBplayer5.getStrike_rate();
//
//             //player 6
//             innings_B_1_batting_player_6_full_name = innings2BatsmanList.get(5).getTitle();
//             innings_B_1_batting_player_6_innings_1_sixes = innings2BatsmanList.get(5).getSixes().toString();
//             innings_B_1_batting_player_6_innings_1_fours = innings2BatsmanList.get(5).getFours().toString();
//             innings_B_1_batting_player_6_innings_1_balls = innings2BatsmanList.get(5).getBalls_faced().toString();
//             innings_B_1_batting_player_6_innings_1_runs = innings2BatsmanList.get(5).getRuns().toString();
//             innings_B_1_batting_player_6_innings_1_out_comment = innings2BatsmanList.get(5).getHow_out();
//             innings_B_1_batting_player_6_innings_1_strike_rate = innings2BatsmanList.get(5).getStrike_rate();
//
//             Player teamBplayer6 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(5).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_6_innings_2_sixes = teamBplayer6.getSixes().toString();
//             innings_B_1_batting_player_6_innings_2_fours = teamBplayer6.getFours().toString();
//             innings_B_1_batting_player_6_innings_2_balls = teamBplayer6.getBalls_faced().toString();
//             innings_B_1_batting_player_6_innings_2_runs = teamBplayer6.getRuns().toString();
//             innings_B_1_batting_player_6_innings_2_out_comment = teamBplayer6.getHow_out();
//             innings_B_1_batting_player_6_innings_2_strike_rate = teamBplayer6.getStrike_rate();
//
//             //player 7
//             innings_B_1_batting_player_7_full_name = innings2BatsmanList.get(6).getTitle();
//             innings_B_1_batting_player_7_innings_1_sixes = innings2BatsmanList.get(6).getSixes().toString();
//             innings_B_1_batting_player_7_innings_1_fours = innings2BatsmanList.get(6).getFours().toString();
//             innings_B_1_batting_player_7_innings_1_balls = innings2BatsmanList.get(6).getBalls_faced().toString();
//             innings_B_1_batting_player_7_innings_1_runs = innings2BatsmanList.get(6).getRuns().toString();
//             innings_B_1_batting_player_7_innings_1_out_comment = innings2BatsmanList.get(6).getHow_out();
//             innings_B_1_batting_player_7_innings_1_strike_rate = innings2BatsmanList.get(6).getStrike_rate();
//
//             Player teamBplayer7 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(6).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_7_innings_2_sixes = teamBplayer7.getSixes().toString();
//             innings_B_1_batting_player_7_innings_2_fours = teamBplayer7.getFours().toString();
//             innings_B_1_batting_player_7_innings_2_balls = teamBplayer7.getBalls_faced().toString();
//             innings_B_1_batting_player_7_innings_2_runs = teamBplayer7.getRuns().toString();
//             innings_B_1_batting_player_7_innings_2_out_comment = teamBplayer7.getHow_out();
//             innings_B_1_batting_player_7_innings_2_strike_rate = teamBplayer7.getStrike_rate();
//
//             //player 8
//             innings_B_1_batting_player_8_full_name = innings2BatsmanList.get(7).getTitle();
//             innings_B_1_batting_player_8_innings_1_sixes = innings2BatsmanList.get(7).getSixes().toString();
//             innings_B_1_batting_player_8_innings_1_fours = innings2BatsmanList.get(7).getFours().toString();
//             innings_B_1_batting_player_8_innings_1_balls = innings2BatsmanList.get(7).getBalls_faced().toString();
//             innings_B_1_batting_player_8_innings_1_runs = innings2BatsmanList.get(7).getRuns().toString();
//             innings_B_1_batting_player_8_innings_1_out_comment = innings2BatsmanList.get(7).getHow_out();
//             innings_B_1_batting_player_8_innings_1_strike_rate = innings2BatsmanList.get(7).getStrike_rate();
//
//             Player teamBplayer8 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(7).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_8_innings_2_sixes = teamBplayer8.getSixes().toString();
//             innings_B_1_batting_player_8_innings_2_fours = teamBplayer8.getFours().toString();
//             innings_B_1_batting_player_8_innings_2_balls = teamBplayer8.getBalls_faced().toString();
//             innings_B_1_batting_player_8_innings_2_runs = teamBplayer8.getRuns().toString();
//             innings_B_1_batting_player_8_innings_2_out_comment = teamBplayer8.getHow_out();
//             innings_B_1_batting_player_8_innings_2_strike_rate = teamBplayer8.getStrike_rate();
//
//             //player 9
//
//             innings_B_1_batting_player_9_full_name = innings2BatsmanList.get(8).getTitle();
//             innings_B_1_batting_player_9_innings_1_sixes = innings2BatsmanList.get(8).getSixes().toString();
//             innings_B_1_batting_player_9_innings_1_fours = innings2BatsmanList.get(8).getFours().toString();
//             innings_B_1_batting_player_9_innings_1_balls = innings2BatsmanList.get(8).getBalls_faced().toString();
//             innings_B_1_batting_player_9_innings_1_runs = innings2BatsmanList.get(8).getRuns().toString();
//             innings_B_1_batting_player_9_innings_1_out_comment = innings2BatsmanList.get(8).getHow_out();
//             innings_B_1_batting_player_9_innings_1_strike_rate = innings2BatsmanList.get(8).getStrike_rate();
//
//
//             Player teamBplayer9 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(8).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_9_innings_2_sixes = teamBplayer9.getSixes().toString();
//             innings_B_1_batting_player_9_innings_2_fours = teamBplayer9.getFours().toString();
//             innings_B_1_batting_player_9_innings_2_balls = teamBplayer9.getBalls_faced().toString();
//             innings_B_1_batting_player_9_innings_2_runs = teamBplayer9.getRuns().toString();
//             innings_B_1_batting_player_9_innings_2_out_comment = teamBplayer9.getHow_out();
//             innings_B_1_batting_player_9_innings_2_strike_rate = teamBplayer9.getStrike_rate();
//
//             //player 10
//             innings_B_1_batting_player_10_full_name = innings2BatsmanList.get(9).getTitle();
//             innings_B_1_batting_player_10_innings_1_sixes = innings2BatsmanList.get(9).getSixes().toString();
//             innings_B_1_batting_player_10_innings_1_fours = innings2BatsmanList.get(9).getFours().toString();
//             innings_B_1_batting_player_10_innings_1_balls = innings2BatsmanList.get(9).getBalls_faced().toString();
//             innings_B_1_batting_player_10_innings_1_runs = innings2BatsmanList.get(9).getRuns().toString();
//             innings_B_1_batting_player_10_innings_1_out_comment = innings2BatsmanList.get(9).getHow_out();
//             innings_B_1_batting_player_10_innings_1_strike_rate = innings2BatsmanList.get(9).getStrike_rate();
//
//             Player teamBplayer10 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(9).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_10_innings_2_sixes = teamBplayer10.getSixes().toString();
//             innings_B_1_batting_player_10_innings_2_fours = teamBplayer10.getFours().toString();
//             innings_B_1_batting_player_10_innings_2_balls = teamBplayer10.getBalls_faced().toString();
//             innings_B_1_batting_player_10_innings_2_runs = teamBplayer10.getRuns().toString();
//             innings_B_1_batting_player_10_innings_2_out_comment = teamBplayer10.getHow_out();
//             innings_B_1_batting_player_10_innings_2_strike_rate = teamBplayer10.getStrike_rate();
//
//             //player 11
//
//             innings_B_1_batting_player_11_full_name = innings2BatsmanList.get(10).getTitle();
//             innings_B_1_batting_player_11_innings_1_sixes = innings2BatsmanList.get(10).getSixes().toString();
//             innings_B_1_batting_player_11_innings_1_fours = innings2BatsmanList.get(10).getFours().toString();
//             innings_B_1_batting_player_11_innings_1_balls = innings2BatsmanList.get(10).getBalls_faced().toString();
//             innings_B_1_batting_player_11_innings_1_runs = innings2BatsmanList.get(10).getRuns().toString();
//             innings_B_1_batting_player_11_innings_1_out_comment = innings2BatsmanList.get(10).getHow_out();
//             innings_B_1_batting_player_11_innings_1_strike_rate = innings2BatsmanList.get(10).getStrike_rate();
//
//             Player teamBplayer11 = innings4BatsmanList.stream().filter(p -> p.getTitle().
//                     equals(innings2BatsmanList.get(10).getTitle())).
//                     findFirst().orElse(null);
//
//             innings_B_1_batting_player_11_innings_2_sixes = teamBplayer11.getSixes().toString();
//             innings_B_1_batting_player_11_innings_2_fours = teamBplayer11.getFours().toString();
//             innings_B_1_batting_player_11_innings_2_balls = teamBplayer11.getBalls_faced().toString();
//             innings_B_1_batting_player_11_innings_2_runs = teamBplayer11.getRuns().toString();
//             innings_B_1_batting_player_11_innings_2_out_comment = teamBplayer11.getHow_out();
//             innings_B_1_batting_player_11_innings_2_strike_rate = teamBplayer11.getStrike_rate();
//         }
//     }
//
//
//
//
//
//
//
////    private String title;
//
//    //All are initialize inside initializeMatchProperty method
//
//    //didn't map
//    private boolean dl_applied;
//
//
//
//    private String status;
//
//    private String man_of_match;
//    //didn't map
//    private String description;
//    //didn't map
//    private String short_name;
//
//    private String format;
//
//
//    //didn't map
//    private String key;
//
//
//    //didn't map
//    private String day;
//
//
//
//    private String name;
//
//
//
//    private String venue;
//
//
//    private int start_date_timestamp;
//    //didn't map
//    private String start_date_iso;
//
//    private String start_date_str;
//
//
//    public String getBowling_a_1_player_1_name() {
//        return bowling_a_1_player_1_name;
//    }
//
//    public void setBowling_a_1_player_1_name(String bowling_a_1_player_1_name) {
//        this.bowling_a_1_player_1_name = bowling_a_1_player_1_name;
//    }
//
//    public String getBowling_a_1_player_1_economy() {
//        return bowling_a_1_player_1_economy;
//    }
//
//    public void setBowling_a_1_player_1_economy(String bowling_a_1_player_1_economy) {
//        this.bowling_a_1_player_1_economy = bowling_a_1_player_1_economy;
//    }
//
//    public String getBowling_a_1_player_1_runs() {
//        return bowling_a_1_player_1_runs;
//    }
//
//    public void setBowling_a_1_player_1_runs(String bowling_a_1_player_1_runs) {
//        this.bowling_a_1_player_1_runs = bowling_a_1_player_1_runs;
//    }
//
//    public String getBowling_a_1_player_1_wickets() {
//        return bowling_a_1_player_1_wickets;
//    }
//
//    public void setBowling_a_1_player_1_wickets(String bowling_a_1_player_1_wickets) {
//        this.bowling_a_1_player_1_wickets = bowling_a_1_player_1_wickets;
//    }
//
//    public String getBowling_a_1_player_1_extras() {
//        return bowling_a_1_player_1_extras;
//    }
//
//    public void setBowling_a_1_player_1_extras(String bowling_a_1_player_1_extras) {
//        this.bowling_a_1_player_1_extras = bowling_a_1_player_1_extras;
//    }
//
//    public String getBowling_a_1_player_1_maiden_overs() {
//        return bowling_a_1_player_1_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_1_maiden_overs(String bowling_a_1_player_1_maiden_overs) {
//        this.bowling_a_1_player_1_maiden_overs = bowling_a_1_player_1_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_1_overs() {
//        return bowling_a_1_player_1_overs;
//    }
//
//    public void setBowling_a_1_player_1_overs(String bowling_a_1_player_1_overs) {
//        this.bowling_a_1_player_1_overs = bowling_a_1_player_1_overs;
//    }
//
//    public String getBowling_a_2_player_1_name() {
//        return bowling_a_2_player_1_name;
//    }
//
//    public void setBowling_a_2_player_1_name(String bowling_a_2_player_1_name) {
//        this.bowling_a_2_player_1_name = bowling_a_2_player_1_name;
//    }
//
//    public String getBowling_a_2_player_1_economy() {
//        return bowling_a_2_player_1_economy;
//    }
//
//    public void setBowling_a_2_player_1_economy(String bowling_a_2_player_1_economy) {
//        this.bowling_a_2_player_1_economy = bowling_a_2_player_1_economy;
//    }
//
//    public String getBowling_a_2_player_1_runs() {
//        return bowling_a_2_player_1_runs;
//    }
//
//    public void setBowling_a_2_player_1_runs(String bowling_a_2_player_1_runs) {
//        this.bowling_a_2_player_1_runs = bowling_a_2_player_1_runs;
//    }
//
//    public String getBowling_a_2_player_1_wickets() {
//        return bowling_a_2_player_1_wickets;
//    }
//
//    public void setBowling_a_2_player_1_wickets(String bowling_a_2_player_1_wickets) {
//        this.bowling_a_2_player_1_wickets = bowling_a_2_player_1_wickets;
//    }
//
//    public String getBowling_a_2_player_1_extras() {
//        return bowling_a_2_player_1_extras;
//    }
//
//    public void setBowling_a_2_player_1_extras(String bowling_a_2_player_1_extras) {
//        this.bowling_a_2_player_1_extras = bowling_a_2_player_1_extras;
//    }
//
//    public String getBowling_a_2_player_1_maiden_overs() {
//        return bowling_a_2_player_1_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_1_maiden_overs(String bowling_a_2_player_1_maiden_overs) {
//        this.bowling_a_2_player_1_maiden_overs = bowling_a_2_player_1_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_1_overs() {
//        return bowling_a_2_player_1_overs;
//    }
//
//    public void setBowling_a_2_player_1_overs(String bowling_a_2_player_1_overs) {
//        this.bowling_a_2_player_1_overs = bowling_a_2_player_1_overs;
//    }
//
//    public String getBowling_b_1_player_1_name() {
//        return bowling_b_1_player_1_name;
//    }
//
//    public void setBowling_b_1_player_1_name(String bowling_b_1_player_1_name) {
//        this.bowling_b_1_player_1_name = bowling_b_1_player_1_name;
//    }
//
//    public String getBowling_b_1_player_1_economy() {
//        return bowling_b_1_player_1_economy;
//    }
//
//    public void setBowling_b_1_player_1_economy(String bowling_b_1_player_1_economy) {
//        this.bowling_b_1_player_1_economy = bowling_b_1_player_1_economy;
//    }
//
//    public String getBowling_b_1_player_1_runs() {
//        return bowling_b_1_player_1_runs;
//    }
//
//    public void setBowling_b_1_player_1_runs(String bowling_b_1_player_1_runs) {
//        this.bowling_b_1_player_1_runs = bowling_b_1_player_1_runs;
//    }
//
//    public String getBowling_b_1_player_1_wickets() {
//        return bowling_b_1_player_1_wickets;
//    }
//
//    public void setBowling_b_1_player_1_wickets(String bowling_b_1_player_1_wickets) {
//        this.bowling_b_1_player_1_wickets = bowling_b_1_player_1_wickets;
//    }
//
//    public String getBowling_b_1_player_1_extras() {
//        return bowling_b_1_player_1_extras;
//    }
//
//    public void setBowling_b_1_player_1_extras(String bowling_b_1_player_1_extras) {
//        this.bowling_b_1_player_1_extras = bowling_b_1_player_1_extras;
//    }
//
//    public String getBowling_b_1_player_1_maiden_overs() {
//        return bowling_b_1_player_1_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_1_maiden_overs(String bowling_b_1_player_1_maiden_overs) {
//        this.bowling_b_1_player_1_maiden_overs = bowling_b_1_player_1_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_1_overs() {
//        return bowling_b_1_player_1_overs;
//    }
//
//    public void setBowling_b_1_player_1_overs(String bowling_b_1_player_1_overs) {
//        this.bowling_b_1_player_1_overs = bowling_b_1_player_1_overs;
//    }
//
//    public String getBowling_b_2_player_1_name() {
//        return bowling_b_2_player_1_name;
//    }
//
//    public void setBowling_b_2_player_1_name(String bowling_b_2_player_1_name) {
//        this.bowling_b_2_player_1_name = bowling_b_2_player_1_name;
//    }
//
//    public String getBowling_b_2_player_1_economy() {
//        return bowling_b_2_player_1_economy;
//    }
//
//    public void setBowling_b_2_player_1_economy(String bowling_b_2_player_1_economy) {
//        this.bowling_b_2_player_1_economy = bowling_b_2_player_1_economy;
//    }
//
//    public String getBowling_b_2_player_1_runs() {
//        return bowling_b_2_player_1_runs;
//    }
//
//    public void setBowling_b_2_player_1_runs(String bowling_b_2_player_1_runs) {
//        this.bowling_b_2_player_1_runs = bowling_b_2_player_1_runs;
//    }
//
//    public String getBowling_b_2_player_1_wickets() {
//        return bowling_b_2_player_1_wickets;
//    }
//
//    public void setBowling_b_2_player_1_wickets(String bowling_b_2_player_1_wickets) {
//        this.bowling_b_2_player_1_wickets = bowling_b_2_player_1_wickets;
//    }
//
//    public String getBowling_b_2_player_1_extras() {
//        return bowling_b_2_player_1_extras;
//    }
//
//    public void setBowling_b_2_player_1_extras(String bowling_b_2_player_1_extras) {
//        this.bowling_b_2_player_1_extras = bowling_b_2_player_1_extras;
//    }
//
//    public String getBowling_b_2_player_1_maiden_overs() {
//        return bowling_b_2_player_1_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_1_maiden_overs(String bowling_b_2_player_1_maiden_overs) {
//        this.bowling_b_2_player_1_maiden_overs = bowling_b_2_player_1_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_1_overs() {
//        return bowling_b_2_player_1_overs;
//    }
//
//    public void setBowling_b_2_player_1_overs(String bowling_b_2_player_1_overs) {
//        this.bowling_b_2_player_1_overs = bowling_b_2_player_1_overs;
//    }
//
//    public String getBowling_a_1_player_2_name() {
//        return bowling_a_1_player_2_name;
//    }
//
//    public void setBowling_a_1_player_2_name(String bowling_a_1_player_2_name) {
//        this.bowling_a_1_player_2_name = bowling_a_1_player_2_name;
//    }
//
//    public String getBowling_a_1_player_2_economy() {
//        return bowling_a_1_player_2_economy;
//    }
//
//    public void setBowling_a_1_player_2_economy(String bowling_a_1_player_2_economy) {
//        this.bowling_a_1_player_2_economy = bowling_a_1_player_2_economy;
//    }
//
//    public String getBowling_a_1_player_2_runs() {
//        return bowling_a_1_player_2_runs;
//    }
//
//    public void setBowling_a_1_player_2_runs(String bowling_a_1_player_2_runs) {
//        this.bowling_a_1_player_2_runs = bowling_a_1_player_2_runs;
//    }
//
//    public String getBowling_a_1_player_2_wickets() {
//        return bowling_a_1_player_2_wickets;
//    }
//
//    public void setBowling_a_1_player_2_wickets(String bowling_a_1_player_2_wickets) {
//        this.bowling_a_1_player_2_wickets = bowling_a_1_player_2_wickets;
//    }
//
//    public String getBowling_a_1_player_2_extras() {
//        return bowling_a_1_player_2_extras;
//    }
//
//    public void setBowling_a_1_player_2_extras(String bowling_a_1_player_2_extras) {
//        this.bowling_a_1_player_2_extras = bowling_a_1_player_2_extras;
//    }
//
//    public String getBowling_a_1_player_2_maiden_overs() {
//        return bowling_a_1_player_2_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_2_maiden_overs(String bowling_a_1_player_2_maiden_overs) {
//        this.bowling_a_1_player_2_maiden_overs = bowling_a_1_player_2_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_2_overs() {
//        return bowling_a_1_player_2_overs;
//    }
//
//    public void setBowling_a_1_player_2_overs(String bowling_a_1_player_2_overs) {
//        this.bowling_a_1_player_2_overs = bowling_a_1_player_2_overs;
//    }
//
//    public String getBowling_a_2_player_2_name() {
//        return bowling_a_2_player_2_name;
//    }
//
//    public void setBowling_a_2_player_2_name(String bowling_a_2_player_2_name) {
//        this.bowling_a_2_player_2_name = bowling_a_2_player_2_name;
//    }
//
//    public String getBowling_a_2_player_2_economy() {
//        return bowling_a_2_player_2_economy;
//    }
//
//    public void setBowling_a_2_player_2_economy(String bowling_a_2_player_2_economy) {
//        this.bowling_a_2_player_2_economy = bowling_a_2_player_2_economy;
//    }
//
//    public String getBowling_a_2_player_2_runs() {
//        return bowling_a_2_player_2_runs;
//    }
//
//    public void setBowling_a_2_player_2_runs(String bowling_a_2_player_2_runs) {
//        this.bowling_a_2_player_2_runs = bowling_a_2_player_2_runs;
//    }
//
//    public String getBowling_a_2_player_2_wickets() {
//        return bowling_a_2_player_2_wickets;
//    }
//
//    public void setBowling_a_2_player_2_wickets(String bowling_a_2_player_2_wickets) {
//        this.bowling_a_2_player_2_wickets = bowling_a_2_player_2_wickets;
//    }
//
//    public String getBowling_a_2_player_2_extras() {
//        return bowling_a_2_player_2_extras;
//    }
//
//    public void setBowling_a_2_player_2_extras(String bowling_a_2_player_2_extras) {
//        this.bowling_a_2_player_2_extras = bowling_a_2_player_2_extras;
//    }
//
//    public String getBowling_a_2_player_2_maiden_overs() {
//        return bowling_a_2_player_2_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_2_maiden_overs(String bowling_a_2_player_2_maiden_overs) {
//        this.bowling_a_2_player_2_maiden_overs = bowling_a_2_player_2_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_2_overs() {
//        return bowling_a_2_player_2_overs;
//    }
//
//    public void setBowling_a_2_player_2_overs(String bowling_a_2_player_2_overs) {
//        this.bowling_a_2_player_2_overs = bowling_a_2_player_2_overs;
//    }
//
//    public String getBowling_b_1_player_2_name() {
//        return bowling_b_1_player_2_name;
//    }
//
//    public void setBowling_b_1_player_2_name(String bowling_b_1_player_2_name) {
//        this.bowling_b_1_player_2_name = bowling_b_1_player_2_name;
//    }
//
//    public String getBowling_b_1_player_2_economy() {
//        return bowling_b_1_player_2_economy;
//    }
//
//    public void setBowling_b_1_player_2_economy(String bowling_b_1_player_2_economy) {
//        this.bowling_b_1_player_2_economy = bowling_b_1_player_2_economy;
//    }
//
//    public String getBowling_b_1_player_2_runs() {
//        return bowling_b_1_player_2_runs;
//    }
//
//    public void setBowling_b_1_player_2_runs(String bowling_b_1_player_2_runs) {
//        this.bowling_b_1_player_2_runs = bowling_b_1_player_2_runs;
//    }
//
//    public String getBowling_b_1_player_2_wickets() {
//        return bowling_b_1_player_2_wickets;
//    }
//
//    public void setBowling_b_1_player_2_wickets(String bowling_b_1_player_2_wickets) {
//        this.bowling_b_1_player_2_wickets = bowling_b_1_player_2_wickets;
//    }
//
//    public String getBowling_b_1_player_2_extras() {
//        return bowling_b_1_player_2_extras;
//    }
//
//    public void setBowling_b_1_player_2_extras(String bowling_b_1_player_2_extras) {
//        this.bowling_b_1_player_2_extras = bowling_b_1_player_2_extras;
//    }
//
//    public String getBowling_b_1_player_2_maiden_overs() {
//        return bowling_b_1_player_2_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_2_maiden_overs(String bowling_b_1_player_2_maiden_overs) {
//        this.bowling_b_1_player_2_maiden_overs = bowling_b_1_player_2_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_2_overs() {
//        return bowling_b_1_player_2_overs;
//    }
//
//    public void setBowling_b_1_player_2_overs(String bowling_b_1_player_2_overs) {
//        this.bowling_b_1_player_2_overs = bowling_b_1_player_2_overs;
//    }
//
//    public String getBowling_b_2_player_2_name() {
//        return bowling_b_2_player_2_name;
//    }
//
//    public void setBowling_b_2_player_2_name(String bowling_b_2_player_2_name) {
//        this.bowling_b_2_player_2_name = bowling_b_2_player_2_name;
//    }
//
//    public String getBowling_b_2_player_2_economy() {
//        return bowling_b_2_player_2_economy;
//    }
//
//    public void setBowling_b_2_player_2_economy(String bowling_b_2_player_2_economy) {
//        this.bowling_b_2_player_2_economy = bowling_b_2_player_2_economy;
//    }
//
//    public String getBowling_b_2_player_2_runs() {
//        return bowling_b_2_player_2_runs;
//    }
//
//    public void setBowling_b_2_player_2_runs(String bowling_b_2_player_2_runs) {
//        this.bowling_b_2_player_2_runs = bowling_b_2_player_2_runs;
//    }
//
//    public String getBowling_b_2_player_2_wickets() {
//        return bowling_b_2_player_2_wickets;
//    }
//
//    public void setBowling_b_2_player_2_wickets(String bowling_b_2_player_2_wickets) {
//        this.bowling_b_2_player_2_wickets = bowling_b_2_player_2_wickets;
//    }
//
//    public String getBowling_b_2_player_2_extras() {
//        return bowling_b_2_player_2_extras;
//    }
//
//    public void setBowling_b_2_player_2_extras(String bowling_b_2_player_2_extras) {
//        this.bowling_b_2_player_2_extras = bowling_b_2_player_2_extras;
//    }
//
//    public String getBowling_b_2_player_2_maiden_overs() {
//        return bowling_b_2_player_2_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_2_maiden_overs(String bowling_b_2_player_2_maiden_overs) {
//        this.bowling_b_2_player_2_maiden_overs = bowling_b_2_player_2_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_2_overs() {
//        return bowling_b_2_player_2_overs;
//    }
//
//    public void setBowling_b_2_player_2_overs(String bowling_b_2_player_2_overs) {
//        this.bowling_b_2_player_2_overs = bowling_b_2_player_2_overs;
//    }
//
//    public String getBowling_a_1_player_3_name() {
//        return bowling_a_1_player_3_name;
//    }
//
//    public void setBowling_a_1_player_3_name(String bowling_a_1_player_3_name) {
//        this.bowling_a_1_player_3_name = bowling_a_1_player_3_name;
//    }
//
//    public String getBowling_a_1_player_3_economy() {
//        return bowling_a_1_player_3_economy;
//    }
//
//    public void setBowling_a_1_player_3_economy(String bowling_a_1_player_3_economy) {
//        this.bowling_a_1_player_3_economy = bowling_a_1_player_3_economy;
//    }
//
//    public String getBowling_a_1_player_3_runs() {
//        return bowling_a_1_player_3_runs;
//    }
//
//    public void setBowling_a_1_player_3_runs(String bowling_a_1_player_3_runs) {
//        this.bowling_a_1_player_3_runs = bowling_a_1_player_3_runs;
//    }
//
//    public String getBowling_a_1_player_3_wickets() {
//        return bowling_a_1_player_3_wickets;
//    }
//
//    public void setBowling_a_1_player_3_wickets(String bowling_a_1_player_3_wickets) {
//        this.bowling_a_1_player_3_wickets = bowling_a_1_player_3_wickets;
//    }
//
//    public String getBowling_a_1_player_3_extras() {
//        return bowling_a_1_player_3_extras;
//    }
//
//    public void setBowling_a_1_player_3_extras(String bowling_a_1_player_3_extras) {
//        this.bowling_a_1_player_3_extras = bowling_a_1_player_3_extras;
//    }
//
//    public String getBowling_a_1_player_3_maiden_overs() {
//        return bowling_a_1_player_3_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_3_maiden_overs(String bowling_a_1_player_3_maiden_overs) {
//        this.bowling_a_1_player_3_maiden_overs = bowling_a_1_player_3_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_3_overs() {
//        return bowling_a_1_player_3_overs;
//    }
//
//    public void setBowling_a_1_player_3_overs(String bowling_a_1_player_3_overs) {
//        this.bowling_a_1_player_3_overs = bowling_a_1_player_3_overs;
//    }
//
//    public String getBowling_a_2_player_3_name() {
//        return bowling_a_2_player_3_name;
//    }
//
//    public void setBowling_a_2_player_3_name(String bowling_a_2_player_3_name) {
//        this.bowling_a_2_player_3_name = bowling_a_2_player_3_name;
//    }
//
//    public String getBowling_a_2_player_3_economy() {
//        return bowling_a_2_player_3_economy;
//    }
//
//    public void setBowling_a_2_player_3_economy(String bowling_a_2_player_3_economy) {
//        this.bowling_a_2_player_3_economy = bowling_a_2_player_3_economy;
//    }
//
//    public String getBowling_a_2_player_3_runs() {
//        return bowling_a_2_player_3_runs;
//    }
//
//    public void setBowling_a_2_player_3_runs(String bowling_a_2_player_3_runs) {
//        this.bowling_a_2_player_3_runs = bowling_a_2_player_3_runs;
//    }
//
//    public String getBowling_a_2_player_3_wickets() {
//        return bowling_a_2_player_3_wickets;
//    }
//
//    public void setBowling_a_2_player_3_wickets(String bowling_a_2_player_3_wickets) {
//        this.bowling_a_2_player_3_wickets = bowling_a_2_player_3_wickets;
//    }
//
//    public String getBowling_a_2_player_3_extras() {
//        return bowling_a_2_player_3_extras;
//    }
//
//    public void setBowling_a_2_player_3_extras(String bowling_a_2_player_3_extras) {
//        this.bowling_a_2_player_3_extras = bowling_a_2_player_3_extras;
//    }
//
//    public String getBowling_a_2_player_3_maiden_overs() {
//        return bowling_a_2_player_3_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_3_maiden_overs(String bowling_a_2_player_3_maiden_overs) {
//        this.bowling_a_2_player_3_maiden_overs = bowling_a_2_player_3_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_3_overs() {
//        return bowling_a_2_player_3_overs;
//    }
//
//    public void setBowling_a_2_player_3_overs(String bowling_a_2_player_3_overs) {
//        this.bowling_a_2_player_3_overs = bowling_a_2_player_3_overs;
//    }
//
//    public String getBowling_b_1_player_3_name() {
//        return bowling_b_1_player_3_name;
//    }
//
//    public void setBowling_b_1_player_3_name(String bowling_b_1_player_3_name) {
//        this.bowling_b_1_player_3_name = bowling_b_1_player_3_name;
//    }
//
//    public String getBowling_b_1_player_3_economy() {
//        return bowling_b_1_player_3_economy;
//    }
//
//    public void setBowling_b_1_player_3_economy(String bowling_b_1_player_3_economy) {
//        this.bowling_b_1_player_3_economy = bowling_b_1_player_3_economy;
//    }
//
//    public String getBowling_b_1_player_3_runs() {
//        return bowling_b_1_player_3_runs;
//    }
//
//    public void setBowling_b_1_player_3_runs(String bowling_b_1_player_3_runs) {
//        this.bowling_b_1_player_3_runs = bowling_b_1_player_3_runs;
//    }
//
//    public String getBowling_b_1_player_3_wickets() {
//        return bowling_b_1_player_3_wickets;
//    }
//
//    public void setBowling_b_1_player_3_wickets(String bowling_b_1_player_3_wickets) {
//        this.bowling_b_1_player_3_wickets = bowling_b_1_player_3_wickets;
//    }
//
//    public String getBowling_b_1_player_3_extras() {
//        return bowling_b_1_player_3_extras;
//    }
//
//    public void setBowling_b_1_player_3_extras(String bowling_b_1_player_3_extras) {
//        this.bowling_b_1_player_3_extras = bowling_b_1_player_3_extras;
//    }
//
//    public String getBowling_b_1_player_3_maiden_overs() {
//        return bowling_b_1_player_3_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_3_maiden_overs(String bowling_b_1_player_3_maiden_overs) {
//        this.bowling_b_1_player_3_maiden_overs = bowling_b_1_player_3_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_3_overs() {
//        return bowling_b_1_player_3_overs;
//    }
//
//    public void setBowling_b_1_player_3_overs(String bowling_b_1_player_3_overs) {
//        this.bowling_b_1_player_3_overs = bowling_b_1_player_3_overs;
//    }
//
//    public String getBowling_b_2_player_3_name() {
//        return bowling_b_2_player_3_name;
//    }
//
//    public void setBowling_b_2_player_3_name(String bowling_b_2_player_3_name) {
//        this.bowling_b_2_player_3_name = bowling_b_2_player_3_name;
//    }
//
//    public String getBowling_b_2_player_3_economy() {
//        return bowling_b_2_player_3_economy;
//    }
//
//    public void setBowling_b_2_player_3_economy(String bowling_b_2_player_3_economy) {
//        this.bowling_b_2_player_3_economy = bowling_b_2_player_3_economy;
//    }
//
//    public String getBowling_b_2_player_3_runs() {
//        return bowling_b_2_player_3_runs;
//    }
//
//    public void setBowling_b_2_player_3_runs(String bowling_b_2_player_3_runs) {
//        this.bowling_b_2_player_3_runs = bowling_b_2_player_3_runs;
//    }
//
//    public String getBowling_b_2_player_3_wickets() {
//        return bowling_b_2_player_3_wickets;
//    }
//
//    public void setBowling_b_2_player_3_wickets(String bowling_b_2_player_3_wickets) {
//        this.bowling_b_2_player_3_wickets = bowling_b_2_player_3_wickets;
//    }
//
//    public String getBowling_b_2_player_3_extras() {
//        return bowling_b_2_player_3_extras;
//    }
//
//    public void setBowling_b_2_player_3_extras(String bowling_b_2_player_3_extras) {
//        this.bowling_b_2_player_3_extras = bowling_b_2_player_3_extras;
//    }
//
//    public String getBowling_b_2_player_3_maiden_overs() {
//        return bowling_b_2_player_3_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_3_maiden_overs(String bowling_b_2_player_3_maiden_overs) {
//        this.bowling_b_2_player_3_maiden_overs = bowling_b_2_player_3_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_3_overs() {
//        return bowling_b_2_player_3_overs;
//    }
//
//    public void setBowling_b_2_player_3_overs(String bowling_b_2_player_3_overs) {
//        this.bowling_b_2_player_3_overs = bowling_b_2_player_3_overs;
//    }
//
//    public String getBowling_a_1_player_4_name() {
//        return bowling_a_1_player_4_name;
//    }
//
//    public void setBowling_a_1_player_4_name(String bowling_a_1_player_4_name) {
//        this.bowling_a_1_player_4_name = bowling_a_1_player_4_name;
//    }
//
//    public String getBowling_a_1_player_4_economy() {
//        return bowling_a_1_player_4_economy;
//    }
//
//    public void setBowling_a_1_player_4_economy(String bowling_a_1_player_4_economy) {
//        this.bowling_a_1_player_4_economy = bowling_a_1_player_4_economy;
//    }
//
//    public String getBowling_a_1_player_4_runs() {
//        return bowling_a_1_player_4_runs;
//    }
//
//    public void setBowling_a_1_player_4_runs(String bowling_a_1_player_4_runs) {
//        this.bowling_a_1_player_4_runs = bowling_a_1_player_4_runs;
//    }
//
//    public String getBowling_a_1_player_4_wickets() {
//        return bowling_a_1_player_4_wickets;
//    }
//
//    public void setBowling_a_1_player_4_wickets(String bowling_a_1_player_4_wickets) {
//        this.bowling_a_1_player_4_wickets = bowling_a_1_player_4_wickets;
//    }
//
//    public String getBowling_a_1_player_4_extras() {
//        return bowling_a_1_player_4_extras;
//    }
//
//    public void setBowling_a_1_player_4_extras(String bowling_a_1_player_4_extras) {
//        this.bowling_a_1_player_4_extras = bowling_a_1_player_4_extras;
//    }
//
//    public String getBowling_a_1_player_4_maiden_overs() {
//        return bowling_a_1_player_4_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_4_maiden_overs(String bowling_a_1_player_4_maiden_overs) {
//        this.bowling_a_1_player_4_maiden_overs = bowling_a_1_player_4_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_4_overs() {
//        return bowling_a_1_player_4_overs;
//    }
//
//    public void setBowling_a_1_player_4_overs(String bowling_a_1_player_4_overs) {
//        this.bowling_a_1_player_4_overs = bowling_a_1_player_4_overs;
//    }
//
//    public String getBowling_a_2_player_4_name() {
//        return bowling_a_2_player_4_name;
//    }
//
//    public void setBowling_a_2_player_4_name(String bowling_a_2_player_4_name) {
//        this.bowling_a_2_player_4_name = bowling_a_2_player_4_name;
//    }
//
//    public String getBowling_a_2_player_4_economy() {
//        return bowling_a_2_player_4_economy;
//    }
//
//    public void setBowling_a_2_player_4_economy(String bowling_a_2_player_4_economy) {
//        this.bowling_a_2_player_4_economy = bowling_a_2_player_4_economy;
//    }
//
//    public String getBowling_a_2_player_4_runs() {
//        return bowling_a_2_player_4_runs;
//    }
//
//    public void setBowling_a_2_player_4_runs(String bowling_a_2_player_4_runs) {
//        this.bowling_a_2_player_4_runs = bowling_a_2_player_4_runs;
//    }
//
//    public String getBowling_a_2_player_4_wickets() {
//        return bowling_a_2_player_4_wickets;
//    }
//
//    public void setBowling_a_2_player_4_wickets(String bowling_a_2_player_4_wickets) {
//        this.bowling_a_2_player_4_wickets = bowling_a_2_player_4_wickets;
//    }
//
//    public String getBowling_a_2_player_4_extras() {
//        return bowling_a_2_player_4_extras;
//    }
//
//    public void setBowling_a_2_player_4_extras(String bowling_a_2_player_4_extras) {
//        this.bowling_a_2_player_4_extras = bowling_a_2_player_4_extras;
//    }
//
//    public String getBowling_a_2_player_4_maiden_overs() {
//        return bowling_a_2_player_4_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_4_maiden_overs(String bowling_a_2_player_4_maiden_overs) {
//        this.bowling_a_2_player_4_maiden_overs = bowling_a_2_player_4_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_4_overs() {
//        return bowling_a_2_player_4_overs;
//    }
//
//    public void setBowling_a_2_player_4_overs(String bowling_a_2_player_4_overs) {
//        this.bowling_a_2_player_4_overs = bowling_a_2_player_4_overs;
//    }
//
//    public String getBowling_b_1_player_4_name() {
//        return bowling_b_1_player_4_name;
//    }
//
//    public void setBowling_b_1_player_4_name(String bowling_b_1_player_4_name) {
//        this.bowling_b_1_player_4_name = bowling_b_1_player_4_name;
//    }
//
//    public String getBowling_b_1_player_4_economy() {
//        return bowling_b_1_player_4_economy;
//    }
//
//    public void setBowling_b_1_player_4_economy(String bowling_b_1_player_4_economy) {
//        this.bowling_b_1_player_4_economy = bowling_b_1_player_4_economy;
//    }
//
//    public String getBowling_b_1_player_4_runs() {
//        return bowling_b_1_player_4_runs;
//    }
//
//    public void setBowling_b_1_player_4_runs(String bowling_b_1_player_4_runs) {
//        this.bowling_b_1_player_4_runs = bowling_b_1_player_4_runs;
//    }
//
//    public String getBowling_b_1_player_4_wickets() {
//        return bowling_b_1_player_4_wickets;
//    }
//
//    public void setBowling_b_1_player_4_wickets(String bowling_b_1_player_4_wickets) {
//        this.bowling_b_1_player_4_wickets = bowling_b_1_player_4_wickets;
//    }
//
//    public String getBowling_b_1_player_4_extras() {
//        return bowling_b_1_player_4_extras;
//    }
//
//    public void setBowling_b_1_player_4_extras(String bowling_b_1_player_4_extras) {
//        this.bowling_b_1_player_4_extras = bowling_b_1_player_4_extras;
//    }
//
//    public String getBowling_b_1_player_4_maiden_overs() {
//        return bowling_b_1_player_4_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_4_maiden_overs(String bowling_b_1_player_4_maiden_overs) {
//        this.bowling_b_1_player_4_maiden_overs = bowling_b_1_player_4_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_4_overs() {
//        return bowling_b_1_player_4_overs;
//    }
//
//    public void setBowling_b_1_player_4_overs(String bowling_b_1_player_4_overs) {
//        this.bowling_b_1_player_4_overs = bowling_b_1_player_4_overs;
//    }
//
//    public String getBowling_b_2_player_4_name() {
//        return bowling_b_2_player_4_name;
//    }
//
//    public void setBowling_b_2_player_4_name(String bowling_b_2_player_4_name) {
//        this.bowling_b_2_player_4_name = bowling_b_2_player_4_name;
//    }
//
//    public String getBowling_b_2_player_4_economy() {
//        return bowling_b_2_player_4_economy;
//    }
//
//    public void setBowling_b_2_player_4_economy(String bowling_b_2_player_4_economy) {
//        this.bowling_b_2_player_4_economy = bowling_b_2_player_4_economy;
//    }
//
//    public String getBowling_b_2_player_4_runs() {
//        return bowling_b_2_player_4_runs;
//    }
//
//    public void setBowling_b_2_player_4_runs(String bowling_b_2_player_4_runs) {
//        this.bowling_b_2_player_4_runs = bowling_b_2_player_4_runs;
//    }
//
//    public String getBowling_b_2_player_4_wickets() {
//        return bowling_b_2_player_4_wickets;
//    }
//
//    public void setBowling_b_2_player_4_wickets(String bowling_b_2_player_4_wickets) {
//        this.bowling_b_2_player_4_wickets = bowling_b_2_player_4_wickets;
//    }
//
//    public String getBowling_b_2_player_4_extras() {
//        return bowling_b_2_player_4_extras;
//    }
//
//    public void setBowling_b_2_player_4_extras(String bowling_b_2_player_4_extras) {
//        this.bowling_b_2_player_4_extras = bowling_b_2_player_4_extras;
//    }
//
//    public String getBowling_b_2_player_4_maiden_overs() {
//        return bowling_b_2_player_4_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_4_maiden_overs(String bowling_b_2_player_4_maiden_overs) {
//        this.bowling_b_2_player_4_maiden_overs = bowling_b_2_player_4_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_4_overs() {
//        return bowling_b_2_player_4_overs;
//    }
//
//    public void setBowling_b_2_player_4_overs(String bowling_b_2_player_4_overs) {
//        this.bowling_b_2_player_4_overs = bowling_b_2_player_4_overs;
//    }
//
//    public String getBowling_a_1_player_5_name() {
//        return bowling_a_1_player_5_name;
//    }
//
//    public void setBowling_a_1_player_5_name(String bowling_a_1_player_5_name) {
//        this.bowling_a_1_player_5_name = bowling_a_1_player_5_name;
//    }
//
//    public String getBowling_a_1_player_5_economy() {
//        return bowling_a_1_player_5_economy;
//    }
//
//    public void setBowling_a_1_player_5_economy(String bowling_a_1_player_5_economy) {
//        this.bowling_a_1_player_5_economy = bowling_a_1_player_5_economy;
//    }
//
//    public String getBowling_a_1_player_5_runs() {
//        return bowling_a_1_player_5_runs;
//    }
//
//    public void setBowling_a_1_player_5_runs(String bowling_a_1_player_5_runs) {
//        this.bowling_a_1_player_5_runs = bowling_a_1_player_5_runs;
//    }
//
//    public String getBowling_a_1_player_5_wickets() {
//        return bowling_a_1_player_5_wickets;
//    }
//
//    public void setBowling_a_1_player_5_wickets(String bowling_a_1_player_5_wickets) {
//        this.bowling_a_1_player_5_wickets = bowling_a_1_player_5_wickets;
//    }
//
//    public String getBowling_a_1_player_5_extras() {
//        return bowling_a_1_player_5_extras;
//    }
//
//    public void setBowling_a_1_player_5_extras(String bowling_a_1_player_5_extras) {
//        this.bowling_a_1_player_5_extras = bowling_a_1_player_5_extras;
//    }
//
//    public String getBowling_a_1_player_5_maiden_overs() {
//        return bowling_a_1_player_5_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_5_maiden_overs(String bowling_a_1_player_5_maiden_overs) {
//        this.bowling_a_1_player_5_maiden_overs = bowling_a_1_player_5_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_5_overs() {
//        return bowling_a_1_player_5_overs;
//    }
//
//    public void setBowling_a_1_player_5_overs(String bowling_a_1_player_5_overs) {
//        this.bowling_a_1_player_5_overs = bowling_a_1_player_5_overs;
//    }
//
//    public String getBowling_a_2_player_5_name() {
//        return bowling_a_2_player_5_name;
//    }
//
//    public void setBowling_a_2_player_5_name(String bowling_a_2_player_5_name) {
//        this.bowling_a_2_player_5_name = bowling_a_2_player_5_name;
//    }
//
//    public String getBowling_a_2_player_5_economy() {
//        return bowling_a_2_player_5_economy;
//    }
//
//    public void setBowling_a_2_player_5_economy(String bowling_a_2_player_5_economy) {
//        this.bowling_a_2_player_5_economy = bowling_a_2_player_5_economy;
//    }
//
//    public String getBowling_a_2_player_5_runs() {
//        return bowling_a_2_player_5_runs;
//    }
//
//    public void setBowling_a_2_player_5_runs(String bowling_a_2_player_5_runs) {
//        this.bowling_a_2_player_5_runs = bowling_a_2_player_5_runs;
//    }
//
//    public String getBowling_a_2_player_5_wickets() {
//        return bowling_a_2_player_5_wickets;
//    }
//
//    public void setBowling_a_2_player_5_wickets(String bowling_a_2_player_5_wickets) {
//        this.bowling_a_2_player_5_wickets = bowling_a_2_player_5_wickets;
//    }
//
//    public String getBowling_a_2_player_5_extras() {
//        return bowling_a_2_player_5_extras;
//    }
//
//    public void setBowling_a_2_player_5_extras(String bowling_a_2_player_5_extras) {
//        this.bowling_a_2_player_5_extras = bowling_a_2_player_5_extras;
//    }
//
//    public String getBowling_a_2_player_5_maiden_overs() {
//        return bowling_a_2_player_5_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_5_maiden_overs(String bowling_a_2_player_5_maiden_overs) {
//        this.bowling_a_2_player_5_maiden_overs = bowling_a_2_player_5_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_5_overs() {
//        return bowling_a_2_player_5_overs;
//    }
//
//    public void setBowling_a_2_player_5_overs(String bowling_a_2_player_5_overs) {
//        this.bowling_a_2_player_5_overs = bowling_a_2_player_5_overs;
//    }
//
//    public String getBowling_b_1_player_5_name() {
//        return bowling_b_1_player_5_name;
//    }
//
//    public void setBowling_b_1_player_5_name(String bowling_b_1_player_5_name) {
//        this.bowling_b_1_player_5_name = bowling_b_1_player_5_name;
//    }
//
//    public String getBowling_b_1_player_5_economy() {
//        return bowling_b_1_player_5_economy;
//    }
//
//    public void setBowling_b_1_player_5_economy(String bowling_b_1_player_5_economy) {
//        this.bowling_b_1_player_5_economy = bowling_b_1_player_5_economy;
//    }
//
//    public String getBowling_b_1_player_5_runs() {
//        return bowling_b_1_player_5_runs;
//    }
//
//    public void setBowling_b_1_player_5_runs(String bowling_b_1_player_5_runs) {
//        this.bowling_b_1_player_5_runs = bowling_b_1_player_5_runs;
//    }
//
//    public String getBowling_b_1_player_5_wickets() {
//        return bowling_b_1_player_5_wickets;
//    }
//
//    public void setBowling_b_1_player_5_wickets(String bowling_b_1_player_5_wickets) {
//        this.bowling_b_1_player_5_wickets = bowling_b_1_player_5_wickets;
//    }
//
//    public String getBowling_b_1_player_5_extras() {
//        return bowling_b_1_player_5_extras;
//    }
//
//    public void setBowling_b_1_player_5_extras(String bowling_b_1_player_5_extras) {
//        this.bowling_b_1_player_5_extras = bowling_b_1_player_5_extras;
//    }
//
//    public String getBowling_b_1_player_5_maiden_overs() {
//        return bowling_b_1_player_5_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_5_maiden_overs(String bowling_b_1_player_5_maiden_overs) {
//        this.bowling_b_1_player_5_maiden_overs = bowling_b_1_player_5_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_5_overs() {
//        return bowling_b_1_player_5_overs;
//    }
//
//    public void setBowling_b_1_player_5_overs(String bowling_b_1_player_5_overs) {
//        this.bowling_b_1_player_5_overs = bowling_b_1_player_5_overs;
//    }
//
//    public String getBowling_b_2_player_5_name() {
//        return bowling_b_2_player_5_name;
//    }
//
//    public void setBowling_b_2_player_5_name(String bowling_b_2_player_5_name) {
//        this.bowling_b_2_player_5_name = bowling_b_2_player_5_name;
//    }
//
//    public String getBowling_b_2_player_5_economy() {
//        return bowling_b_2_player_5_economy;
//    }
//
//    public void setBowling_b_2_player_5_economy(String bowling_b_2_player_5_economy) {
//        this.bowling_b_2_player_5_economy = bowling_b_2_player_5_economy;
//    }
//
//    public String getBowling_b_2_player_5_runs() {
//        return bowling_b_2_player_5_runs;
//    }
//
//    public void setBowling_b_2_player_5_runs(String bowling_b_2_player_5_runs) {
//        this.bowling_b_2_player_5_runs = bowling_b_2_player_5_runs;
//    }
//
//    public String getBowling_b_2_player_5_wickets() {
//        return bowling_b_2_player_5_wickets;
//    }
//
//    public void setBowling_b_2_player_5_wickets(String bowling_b_2_player_5_wickets) {
//        this.bowling_b_2_player_5_wickets = bowling_b_2_player_5_wickets;
//    }
//
//    public String getBowling_b_2_player_5_extras() {
//        return bowling_b_2_player_5_extras;
//    }
//
//    public void setBowling_b_2_player_5_extras(String bowling_b_2_player_5_extras) {
//        this.bowling_b_2_player_5_extras = bowling_b_2_player_5_extras;
//    }
//
//    public String getBowling_b_2_player_5_maiden_overs() {
//        return bowling_b_2_player_5_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_5_maiden_overs(String bowling_b_2_player_5_maiden_overs) {
//        this.bowling_b_2_player_5_maiden_overs = bowling_b_2_player_5_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_5_overs() {
//        return bowling_b_2_player_5_overs;
//    }
//
//    public void setBowling_b_2_player_5_overs(String bowling_b_2_player_5_overs) {
//        this.bowling_b_2_player_5_overs = bowling_b_2_player_5_overs;
//    }
//
//    public String getBowling_a_1_player_6_name() {
//        return bowling_a_1_player_6_name;
//    }
//
//    public void setBowling_a_1_player_6_name(String bowling_a_1_player_6_name) {
//        this.bowling_a_1_player_6_name = bowling_a_1_player_6_name;
//    }
//
//    public String getBowling_a_1_player_6_economy() {
//        return bowling_a_1_player_6_economy;
//    }
//
//    public void setBowling_a_1_player_6_economy(String bowling_a_1_player_6_economy) {
//        this.bowling_a_1_player_6_economy = bowling_a_1_player_6_economy;
//    }
//
//    public String getBowling_a_1_player_6_runs() {
//        return bowling_a_1_player_6_runs;
//    }
//
//    public void setBowling_a_1_player_6_runs(String bowling_a_1_player_6_runs) {
//        this.bowling_a_1_player_6_runs = bowling_a_1_player_6_runs;
//    }
//
//    public String getBowling_a_1_player_6_wickets() {
//        return bowling_a_1_player_6_wickets;
//    }
//
//    public void setBowling_a_1_player_6_wickets(String bowling_a_1_player_6_wickets) {
//        this.bowling_a_1_player_6_wickets = bowling_a_1_player_6_wickets;
//    }
//
//    public String getBowling_a_1_player_6_extras() {
//        return bowling_a_1_player_6_extras;
//    }
//
//    public void setBowling_a_1_player_6_extras(String bowling_a_1_player_6_extras) {
//        this.bowling_a_1_player_6_extras = bowling_a_1_player_6_extras;
//    }
//
//    public String getBowling_a_1_player_6_maiden_overs() {
//        return bowling_a_1_player_6_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_6_maiden_overs(String bowling_a_1_player_6_maiden_overs) {
//        this.bowling_a_1_player_6_maiden_overs = bowling_a_1_player_6_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_6_overs() {
//        return bowling_a_1_player_6_overs;
//    }
//
//    public void setBowling_a_1_player_6_overs(String bowling_a_1_player_6_overs) {
//        this.bowling_a_1_player_6_overs = bowling_a_1_player_6_overs;
//    }
//
//    public String getBowling_a_2_player_6_name() {
//        return bowling_a_2_player_6_name;
//    }
//
//    public void setBowling_a_2_player_6_name(String bowling_a_2_player_6_name) {
//        this.bowling_a_2_player_6_name = bowling_a_2_player_6_name;
//    }
//
//    public String getBowling_a_2_player_6_economy() {
//        return bowling_a_2_player_6_economy;
//    }
//
//    public void setBowling_a_2_player_6_economy(String bowling_a_2_player_6_economy) {
//        this.bowling_a_2_player_6_economy = bowling_a_2_player_6_economy;
//    }
//
//    public String getBowling_a_2_player_6_runs() {
//        return bowling_a_2_player_6_runs;
//    }
//
//    public void setBowling_a_2_player_6_runs(String bowling_a_2_player_6_runs) {
//        this.bowling_a_2_player_6_runs = bowling_a_2_player_6_runs;
//    }
//
//    public String getBowling_a_2_player_6_wickets() {
//        return bowling_a_2_player_6_wickets;
//    }
//
//    public void setBowling_a_2_player_6_wickets(String bowling_a_2_player_6_wickets) {
//        this.bowling_a_2_player_6_wickets = bowling_a_2_player_6_wickets;
//    }
//
//    public String getBowling_a_2_player_6_extras() {
//        return bowling_a_2_player_6_extras;
//    }
//
//    public void setBowling_a_2_player_6_extras(String bowling_a_2_player_6_extras) {
//        this.bowling_a_2_player_6_extras = bowling_a_2_player_6_extras;
//    }
//
//    public String getBowling_a_2_player_6_maiden_overs() {
//        return bowling_a_2_player_6_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_6_maiden_overs(String bowling_a_2_player_6_maiden_overs) {
//        this.bowling_a_2_player_6_maiden_overs = bowling_a_2_player_6_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_6_overs() {
//        return bowling_a_2_player_6_overs;
//    }
//
//    public void setBowling_a_2_player_6_overs(String bowling_a_2_player_6_overs) {
//        this.bowling_a_2_player_6_overs = bowling_a_2_player_6_overs;
//    }
//
//    public String getBowling_b_1_player_6_name() {
//        return bowling_b_1_player_6_name;
//    }
//
//    public void setBowling_b_1_player_6_name(String bowling_b_1_player_6_name) {
//        this.bowling_b_1_player_6_name = bowling_b_1_player_6_name;
//    }
//
//    public String getBowling_b_1_player_6_economy() {
//        return bowling_b_1_player_6_economy;
//    }
//
//    public void setBowling_b_1_player_6_economy(String bowling_b_1_player_6_economy) {
//        this.bowling_b_1_player_6_economy = bowling_b_1_player_6_economy;
//    }
//
//    public String getBowling_b_1_player_6_runs() {
//        return bowling_b_1_player_6_runs;
//    }
//
//    public void setBowling_b_1_player_6_runs(String bowling_b_1_player_6_runs) {
//        this.bowling_b_1_player_6_runs = bowling_b_1_player_6_runs;
//    }
//
//    public String getBowling_b_1_player_6_wickets() {
//        return bowling_b_1_player_6_wickets;
//    }
//
//    public void setBowling_b_1_player_6_wickets(String bowling_b_1_player_6_wickets) {
//        this.bowling_b_1_player_6_wickets = bowling_b_1_player_6_wickets;
//    }
//
//    public String getBowling_b_1_player_6_extras() {
//        return bowling_b_1_player_6_extras;
//    }
//
//    public void setBowling_b_1_player_6_extras(String bowling_b_1_player_6_extras) {
//        this.bowling_b_1_player_6_extras = bowling_b_1_player_6_extras;
//    }
//
//    public String getBowling_b_1_player_6_maiden_overs() {
//        return bowling_b_1_player_6_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_6_maiden_overs(String bowling_b_1_player_6_maiden_overs) {
//        this.bowling_b_1_player_6_maiden_overs = bowling_b_1_player_6_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_6_overs() {
//        return bowling_b_1_player_6_overs;
//    }
//
//    public void setBowling_b_1_player_6_overs(String bowling_b_1_player_6_overs) {
//        this.bowling_b_1_player_6_overs = bowling_b_1_player_6_overs;
//    }
//
//    public String getBowling_b_2_player_6_name() {
//        return bowling_b_2_player_6_name;
//    }
//
//    public void setBowling_b_2_player_6_name(String bowling_b_2_player_6_name) {
//        this.bowling_b_2_player_6_name = bowling_b_2_player_6_name;
//    }
//
//    public String getBowling_b_2_player_6_economy() {
//        return bowling_b_2_player_6_economy;
//    }
//
//    public void setBowling_b_2_player_6_economy(String bowling_b_2_player_6_economy) {
//        this.bowling_b_2_player_6_economy = bowling_b_2_player_6_economy;
//    }
//
//    public String getBowling_b_2_player_6_runs() {
//        return bowling_b_2_player_6_runs;
//    }
//
//    public void setBowling_b_2_player_6_runs(String bowling_b_2_player_6_runs) {
//        this.bowling_b_2_player_6_runs = bowling_b_2_player_6_runs;
//    }
//
//    public String getBowling_b_2_player_6_wickets() {
//        return bowling_b_2_player_6_wickets;
//    }
//
//    public void setBowling_b_2_player_6_wickets(String bowling_b_2_player_6_wickets) {
//        this.bowling_b_2_player_6_wickets = bowling_b_2_player_6_wickets;
//    }
//
//    public String getBowling_b_2_player_6_extras() {
//        return bowling_b_2_player_6_extras;
//    }
//
//    public void setBowling_b_2_player_6_extras(String bowling_b_2_player_6_extras) {
//        this.bowling_b_2_player_6_extras = bowling_b_2_player_6_extras;
//    }
//
//    public String getBowling_b_2_player_6_maiden_overs() {
//        return bowling_b_2_player_6_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_6_maiden_overs(String bowling_b_2_player_6_maiden_overs) {
//        this.bowling_b_2_player_6_maiden_overs = bowling_b_2_player_6_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_6_overs() {
//        return bowling_b_2_player_6_overs;
//    }
//
//    public void setBowling_b_2_player_6_overs(String bowling_b_2_player_6_overs) {
//        this.bowling_b_2_player_6_overs = bowling_b_2_player_6_overs;
//    }
//
//    public String getBowling_a_1_player_7_name() {
//        return bowling_a_1_player_7_name;
//    }
//
//    public void setBowling_a_1_player_7_name(String bowling_a_1_player_7_name) {
//        this.bowling_a_1_player_7_name = bowling_a_1_player_7_name;
//    }
//
//    public String getBowling_a_1_player_7_economy() {
//        return bowling_a_1_player_7_economy;
//    }
//
//    public void setBowling_a_1_player_7_economy(String bowling_a_1_player_7_economy) {
//        this.bowling_a_1_player_7_economy = bowling_a_1_player_7_economy;
//    }
//
//    public String getBowling_a_1_player_7_runs() {
//        return bowling_a_1_player_7_runs;
//    }
//
//    public void setBowling_a_1_player_7_runs(String bowling_a_1_player_7_runs) {
//        this.bowling_a_1_player_7_runs = bowling_a_1_player_7_runs;
//    }
//
//    public String getBowling_a_1_player_7_wickets() {
//        return bowling_a_1_player_7_wickets;
//    }
//
//    public void setBowling_a_1_player_7_wickets(String bowling_a_1_player_7_wickets) {
//        this.bowling_a_1_player_7_wickets = bowling_a_1_player_7_wickets;
//    }
//
//    public String getBowling_a_1_player_7_extras() {
//        return bowling_a_1_player_7_extras;
//    }
//
//    public void setBowling_a_1_player_7_extras(String bowling_a_1_player_7_extras) {
//        this.bowling_a_1_player_7_extras = bowling_a_1_player_7_extras;
//    }
//
//    public String getBowling_a_1_player_7_maiden_overs() {
//        return bowling_a_1_player_7_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_7_maiden_overs(String bowling_a_1_player_7_maiden_overs) {
//        this.bowling_a_1_player_7_maiden_overs = bowling_a_1_player_7_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_7_overs() {
//        return bowling_a_1_player_7_overs;
//    }
//
//    public void setBowling_a_1_player_7_overs(String bowling_a_1_player_7_overs) {
//        this.bowling_a_1_player_7_overs = bowling_a_1_player_7_overs;
//    }
//
//    public String getBowling_a_2_player_7_name() {
//        return bowling_a_2_player_7_name;
//    }
//
//    public void setBowling_a_2_player_7_name(String bowling_a_2_player_7_name) {
//        this.bowling_a_2_player_7_name = bowling_a_2_player_7_name;
//    }
//
//    public String getBowling_a_2_player_7_economy() {
//        return bowling_a_2_player_7_economy;
//    }
//
//    public void setBowling_a_2_player_7_economy(String bowling_a_2_player_7_economy) {
//        this.bowling_a_2_player_7_economy = bowling_a_2_player_7_economy;
//    }
//
//    public String getBowling_a_2_player_7_runs() {
//        return bowling_a_2_player_7_runs;
//    }
//
//    public void setBowling_a_2_player_7_runs(String bowling_a_2_player_7_runs) {
//        this.bowling_a_2_player_7_runs = bowling_a_2_player_7_runs;
//    }
//
//    public String getBowling_a_2_player_7_wickets() {
//        return bowling_a_2_player_7_wickets;
//    }
//
//    public void setBowling_a_2_player_7_wickets(String bowling_a_2_player_7_wickets) {
//        this.bowling_a_2_player_7_wickets = bowling_a_2_player_7_wickets;
//    }
//
//    public String getBowling_a_2_player_7_extras() {
//        return bowling_a_2_player_7_extras;
//    }
//
//    public void setBowling_a_2_player_7_extras(String bowling_a_2_player_7_extras) {
//        this.bowling_a_2_player_7_extras = bowling_a_2_player_7_extras;
//    }
//
//    public String getBowling_a_2_player_7_maiden_overs() {
//        return bowling_a_2_player_7_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_7_maiden_overs(String bowling_a_2_player_7_maiden_overs) {
//        this.bowling_a_2_player_7_maiden_overs = bowling_a_2_player_7_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_7_overs() {
//        return bowling_a_2_player_7_overs;
//    }
//
//    public void setBowling_a_2_player_7_overs(String bowling_a_2_player_7_overs) {
//        this.bowling_a_2_player_7_overs = bowling_a_2_player_7_overs;
//    }
//
//    public String getBowling_b_1_player_7_name() {
//        return bowling_b_1_player_7_name;
//    }
//
//    public void setBowling_b_1_player_7_name(String bowling_b_1_player_7_name) {
//        this.bowling_b_1_player_7_name = bowling_b_1_player_7_name;
//    }
//
//    public String getBowling_b_1_player_7_economy() {
//        return bowling_b_1_player_7_economy;
//    }
//
//    public void setBowling_b_1_player_7_economy(String bowling_b_1_player_7_economy) {
//        this.bowling_b_1_player_7_economy = bowling_b_1_player_7_economy;
//    }
//
//    public String getBowling_b_1_player_7_runs() {
//        return bowling_b_1_player_7_runs;
//    }
//
//    public void setBowling_b_1_player_7_runs(String bowling_b_1_player_7_runs) {
//        this.bowling_b_1_player_7_runs = bowling_b_1_player_7_runs;
//    }
//
//    public String getBowling_b_1_player_7_wickets() {
//        return bowling_b_1_player_7_wickets;
//    }
//
//    public void setBowling_b_1_player_7_wickets(String bowling_b_1_player_7_wickets) {
//        this.bowling_b_1_player_7_wickets = bowling_b_1_player_7_wickets;
//    }
//
//    public String getBowling_b_1_player_7_extras() {
//        return bowling_b_1_player_7_extras;
//    }
//
//    public void setBowling_b_1_player_7_extras(String bowling_b_1_player_7_extras) {
//        this.bowling_b_1_player_7_extras = bowling_b_1_player_7_extras;
//    }
//
//    public String getBowling_b_1_player_7_maiden_overs() {
//        return bowling_b_1_player_7_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_7_maiden_overs(String bowling_b_1_player_7_maiden_overs) {
//        this.bowling_b_1_player_7_maiden_overs = bowling_b_1_player_7_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_7_overs() {
//        return bowling_b_1_player_7_overs;
//    }
//
//    public void setBowling_b_1_player_7_overs(String bowling_b_1_player_7_overs) {
//        this.bowling_b_1_player_7_overs = bowling_b_1_player_7_overs;
//    }
//
//    public String getBowling_b_2_player_7_name() {
//        return bowling_b_2_player_7_name;
//    }
//
//    public void setBowling_b_2_player_7_name(String bowling_b_2_player_7_name) {
//        this.bowling_b_2_player_7_name = bowling_b_2_player_7_name;
//    }
//
//    public String getBowling_b_2_player_7_economy() {
//        return bowling_b_2_player_7_economy;
//    }
//
//    public void setBowling_b_2_player_7_economy(String bowling_b_2_player_7_economy) {
//        this.bowling_b_2_player_7_economy = bowling_b_2_player_7_economy;
//    }
//
//    public String getBowling_b_2_player_7_runs() {
//        return bowling_b_2_player_7_runs;
//    }
//
//    public void setBowling_b_2_player_7_runs(String bowling_b_2_player_7_runs) {
//        this.bowling_b_2_player_7_runs = bowling_b_2_player_7_runs;
//    }
//
//    public String getBowling_b_2_player_7_wickets() {
//        return bowling_b_2_player_7_wickets;
//    }
//
//    public void setBowling_b_2_player_7_wickets(String bowling_b_2_player_7_wickets) {
//        this.bowling_b_2_player_7_wickets = bowling_b_2_player_7_wickets;
//    }
//
//    public String getBowling_b_2_player_7_extras() {
//        return bowling_b_2_player_7_extras;
//    }
//
//    public void setBowling_b_2_player_7_extras(String bowling_b_2_player_7_extras) {
//        this.bowling_b_2_player_7_extras = bowling_b_2_player_7_extras;
//    }
//
//    public String getBowling_b_2_player_7_maiden_overs() {
//        return bowling_b_2_player_7_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_7_maiden_overs(String bowling_b_2_player_7_maiden_overs) {
//        this.bowling_b_2_player_7_maiden_overs = bowling_b_2_player_7_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_7_overs() {
//        return bowling_b_2_player_7_overs;
//    }
//
//    public void setBowling_b_2_player_7_overs(String bowling_b_2_player_7_overs) {
//        this.bowling_b_2_player_7_overs = bowling_b_2_player_7_overs;
//    }
//
//    public String getBowling_a_1_player_8_name() {
//        return bowling_a_1_player_8_name;
//    }
//
//    public void setBowling_a_1_player_8_name(String bowling_a_1_player_8_name) {
//        this.bowling_a_1_player_8_name = bowling_a_1_player_8_name;
//    }
//
//    public String getBowling_a_1_player_8_economy() {
//        return bowling_a_1_player_8_economy;
//    }
//
//    public void setBowling_a_1_player_8_economy(String bowling_a_1_player_8_economy) {
//        this.bowling_a_1_player_8_economy = bowling_a_1_player_8_economy;
//    }
//
//    public String getBowling_a_1_player_8_runs() {
//        return bowling_a_1_player_8_runs;
//    }
//
//    public void setBowling_a_1_player_8_runs(String bowling_a_1_player_8_runs) {
//        this.bowling_a_1_player_8_runs = bowling_a_1_player_8_runs;
//    }
//
//    public String getBowling_a_1_player_8_wickets() {
//        return bowling_a_1_player_8_wickets;
//    }
//
//    public void setBowling_a_1_player_8_wickets(String bowling_a_1_player_8_wickets) {
//        this.bowling_a_1_player_8_wickets = bowling_a_1_player_8_wickets;
//    }
//
//    public String getBowling_a_1_player_8_extras() {
//        return bowling_a_1_player_8_extras;
//    }
//
//    public void setBowling_a_1_player_8_extras(String bowling_a_1_player_8_extras) {
//        this.bowling_a_1_player_8_extras = bowling_a_1_player_8_extras;
//    }
//
//    public String getBowling_a_1_player_8_maiden_overs() {
//        return bowling_a_1_player_8_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_8_maiden_overs(String bowling_a_1_player_8_maiden_overs) {
//        this.bowling_a_1_player_8_maiden_overs = bowling_a_1_player_8_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_8_overs() {
//        return bowling_a_1_player_8_overs;
//    }
//
//    public void setBowling_a_1_player_8_overs(String bowling_a_1_player_8_overs) {
//        this.bowling_a_1_player_8_overs = bowling_a_1_player_8_overs;
//    }
//
//    public String getBowling_a_2_player_8_name() {
//        return bowling_a_2_player_8_name;
//    }
//
//    public void setBowling_a_2_player_8_name(String bowling_a_2_player_8_name) {
//        this.bowling_a_2_player_8_name = bowling_a_2_player_8_name;
//    }
//
//    public String getBowling_a_2_player_8_economy() {
//        return bowling_a_2_player_8_economy;
//    }
//
//    public void setBowling_a_2_player_8_economy(String bowling_a_2_player_8_economy) {
//        this.bowling_a_2_player_8_economy = bowling_a_2_player_8_economy;
//    }
//
//    public String getBowling_a_2_player_8_runs() {
//        return bowling_a_2_player_8_runs;
//    }
//
//    public void setBowling_a_2_player_8_runs(String bowling_a_2_player_8_runs) {
//        this.bowling_a_2_player_8_runs = bowling_a_2_player_8_runs;
//    }
//
//    public String getBowling_a_2_player_8_wickets() {
//        return bowling_a_2_player_8_wickets;
//    }
//
//    public void setBowling_a_2_player_8_wickets(String bowling_a_2_player_8_wickets) {
//        this.bowling_a_2_player_8_wickets = bowling_a_2_player_8_wickets;
//    }
//
//    public String getBowling_a_2_player_8_extras() {
//        return bowling_a_2_player_8_extras;
//    }
//
//    public void setBowling_a_2_player_8_extras(String bowling_a_2_player_8_extras) {
//        this.bowling_a_2_player_8_extras = bowling_a_2_player_8_extras;
//    }
//
//    public String getBowling_a_2_player_8_maiden_overs() {
//        return bowling_a_2_player_8_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_8_maiden_overs(String bowling_a_2_player_8_maiden_overs) {
//        this.bowling_a_2_player_8_maiden_overs = bowling_a_2_player_8_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_8_overs() {
//        return bowling_a_2_player_8_overs;
//    }
//
//    public void setBowling_a_2_player_8_overs(String bowling_a_2_player_8_overs) {
//        this.bowling_a_2_player_8_overs = bowling_a_2_player_8_overs;
//    }
//
//    public String getBowling_b_1_player_8_name() {
//        return bowling_b_1_player_8_name;
//    }
//
//    public void setBowling_b_1_player_8_name(String bowling_b_1_player_8_name) {
//        this.bowling_b_1_player_8_name = bowling_b_1_player_8_name;
//    }
//
//    public String getBowling_b_1_player_8_economy() {
//        return bowling_b_1_player_8_economy;
//    }
//
//    public void setBowling_b_1_player_8_economy(String bowling_b_1_player_8_economy) {
//        this.bowling_b_1_player_8_economy = bowling_b_1_player_8_economy;
//    }
//
//    public String getBowling_b_1_player_8_runs() {
//        return bowling_b_1_player_8_runs;
//    }
//
//    public void setBowling_b_1_player_8_runs(String bowling_b_1_player_8_runs) {
//        this.bowling_b_1_player_8_runs = bowling_b_1_player_8_runs;
//    }
//
//    public String getBowling_b_1_player_8_wickets() {
//        return bowling_b_1_player_8_wickets;
//    }
//
//    public void setBowling_b_1_player_8_wickets(String bowling_b_1_player_8_wickets) {
//        this.bowling_b_1_player_8_wickets = bowling_b_1_player_8_wickets;
//    }
//
//    public String getBowling_b_1_player_8_extras() {
//        return bowling_b_1_player_8_extras;
//    }
//
//    public void setBowling_b_1_player_8_extras(String bowling_b_1_player_8_extras) {
//        this.bowling_b_1_player_8_extras = bowling_b_1_player_8_extras;
//    }
//
//    public String getBowling_b_1_player_8_maiden_overs() {
//        return bowling_b_1_player_8_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_8_maiden_overs(String bowling_b_1_player_8_maiden_overs) {
//        this.bowling_b_1_player_8_maiden_overs = bowling_b_1_player_8_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_8_overs() {
//        return bowling_b_1_player_8_overs;
//    }
//
//    public void setBowling_b_1_player_8_overs(String bowling_b_1_player_8_overs) {
//        this.bowling_b_1_player_8_overs = bowling_b_1_player_8_overs;
//    }
//
//    public String getBowling_b_2_player_8_name() {
//        return bowling_b_2_player_8_name;
//    }
//
//    public void setBowling_b_2_player_8_name(String bowling_b_2_player_8_name) {
//        this.bowling_b_2_player_8_name = bowling_b_2_player_8_name;
//    }
//
//    public String getBowling_b_2_player_8_economy() {
//        return bowling_b_2_player_8_economy;
//    }
//
//    public void setBowling_b_2_player_8_economy(String bowling_b_2_player_8_economy) {
//        this.bowling_b_2_player_8_economy = bowling_b_2_player_8_economy;
//    }
//
//    public String getBowling_b_2_player_8_runs() {
//        return bowling_b_2_player_8_runs;
//    }
//
//    public void setBowling_b_2_player_8_runs(String bowling_b_2_player_8_runs) {
//        this.bowling_b_2_player_8_runs = bowling_b_2_player_8_runs;
//    }
//
//    public String getBowling_b_2_player_8_wickets() {
//        return bowling_b_2_player_8_wickets;
//    }
//
//    public void setBowling_b_2_player_8_wickets(String bowling_b_2_player_8_wickets) {
//        this.bowling_b_2_player_8_wickets = bowling_b_2_player_8_wickets;
//    }
//
//    public String getBowling_b_2_player_8_extras() {
//        return bowling_b_2_player_8_extras;
//    }
//
//    public void setBowling_b_2_player_8_extras(String bowling_b_2_player_8_extras) {
//        this.bowling_b_2_player_8_extras = bowling_b_2_player_8_extras;
//    }
//
//    public String getBowling_b_2_player_8_maiden_overs() {
//        return bowling_b_2_player_8_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_8_maiden_overs(String bowling_b_2_player_8_maiden_overs) {
//        this.bowling_b_2_player_8_maiden_overs = bowling_b_2_player_8_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_8_overs() {
//        return bowling_b_2_player_8_overs;
//    }
//
//    public void setBowling_b_2_player_8_overs(String bowling_b_2_player_8_overs) {
//        this.bowling_b_2_player_8_overs = bowling_b_2_player_8_overs;
//    }
//
//    public String getBowling_a_1_player_9_name() {
//        return bowling_a_1_player_9_name;
//    }
//
//    public void setBowling_a_1_player_9_name(String bowling_a_1_player_9_name) {
//        this.bowling_a_1_player_9_name = bowling_a_1_player_9_name;
//    }
//
//    public String getBowling_a_1_player_9_economy() {
//        return bowling_a_1_player_9_economy;
//    }
//
//    public void setBowling_a_1_player_9_economy(String bowling_a_1_player_9_economy) {
//        this.bowling_a_1_player_9_economy = bowling_a_1_player_9_economy;
//    }
//
//    public String getBowling_a_1_player_9_runs() {
//        return bowling_a_1_player_9_runs;
//    }
//
//    public void setBowling_a_1_player_9_runs(String bowling_a_1_player_9_runs) {
//        this.bowling_a_1_player_9_runs = bowling_a_1_player_9_runs;
//    }
//
//    public String getBowling_a_1_player_9_wickets() {
//        return bowling_a_1_player_9_wickets;
//    }
//
//    public void setBowling_a_1_player_9_wickets(String bowling_a_1_player_9_wickets) {
//        this.bowling_a_1_player_9_wickets = bowling_a_1_player_9_wickets;
//    }
//
//    public String getBowling_a_1_player_9_extras() {
//        return bowling_a_1_player_9_extras;
//    }
//
//    public void setBowling_a_1_player_9_extras(String bowling_a_1_player_9_extras) {
//        this.bowling_a_1_player_9_extras = bowling_a_1_player_9_extras;
//    }
//
//    public String getBowling_a_1_player_9_maiden_overs() {
//        return bowling_a_1_player_9_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_9_maiden_overs(String bowling_a_1_player_9_maiden_overs) {
//        this.bowling_a_1_player_9_maiden_overs = bowling_a_1_player_9_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_9_overs() {
//        return bowling_a_1_player_9_overs;
//    }
//
//    public void setBowling_a_1_player_9_overs(String bowling_a_1_player_9_overs) {
//        this.bowling_a_1_player_9_overs = bowling_a_1_player_9_overs;
//    }
//
//    public String getBowling_a_2_player_9_name() {
//        return bowling_a_2_player_9_name;
//    }
//
//    public void setBowling_a_2_player_9_name(String bowling_a_2_player_9_name) {
//        this.bowling_a_2_player_9_name = bowling_a_2_player_9_name;
//    }
//
//    public String getBowling_a_2_player_9_economy() {
//        return bowling_a_2_player_9_economy;
//    }
//
//    public void setBowling_a_2_player_9_economy(String bowling_a_2_player_9_economy) {
//        this.bowling_a_2_player_9_economy = bowling_a_2_player_9_economy;
//    }
//
//    public String getBowling_a_2_player_9_runs() {
//        return bowling_a_2_player_9_runs;
//    }
//
//    public void setBowling_a_2_player_9_runs(String bowling_a_2_player_9_runs) {
//        this.bowling_a_2_player_9_runs = bowling_a_2_player_9_runs;
//    }
//
//    public String getBowling_a_2_player_9_wickets() {
//        return bowling_a_2_player_9_wickets;
//    }
//
//    public void setBowling_a_2_player_9_wickets(String bowling_a_2_player_9_wickets) {
//        this.bowling_a_2_player_9_wickets = bowling_a_2_player_9_wickets;
//    }
//
//    public String getBowling_a_2_player_9_extras() {
//        return bowling_a_2_player_9_extras;
//    }
//
//    public void setBowling_a_2_player_9_extras(String bowling_a_2_player_9_extras) {
//        this.bowling_a_2_player_9_extras = bowling_a_2_player_9_extras;
//    }
//
//    public String getBowling_a_2_player_9_maiden_overs() {
//        return bowling_a_2_player_9_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_9_maiden_overs(String bowling_a_2_player_9_maiden_overs) {
//        this.bowling_a_2_player_9_maiden_overs = bowling_a_2_player_9_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_9_overs() {
//        return bowling_a_2_player_9_overs;
//    }
//
//    public void setBowling_a_2_player_9_overs(String bowling_a_2_player_9_overs) {
//        this.bowling_a_2_player_9_overs = bowling_a_2_player_9_overs;
//    }
//
//    public String getBowling_b_1_player_9_name() {
//        return bowling_b_1_player_9_name;
//    }
//
//    public void setBowling_b_1_player_9_name(String bowling_b_1_player_9_name) {
//        this.bowling_b_1_player_9_name = bowling_b_1_player_9_name;
//    }
//
//    public String getBowling_b_1_player_9_economy() {
//        return bowling_b_1_player_9_economy;
//    }
//
//    public void setBowling_b_1_player_9_economy(String bowling_b_1_player_9_economy) {
//        this.bowling_b_1_player_9_economy = bowling_b_1_player_9_economy;
//    }
//
//    public String getBowling_b_1_player_9_runs() {
//        return bowling_b_1_player_9_runs;
//    }
//
//    public void setBowling_b_1_player_9_runs(String bowling_b_1_player_9_runs) {
//        this.bowling_b_1_player_9_runs = bowling_b_1_player_9_runs;
//    }
//
//    public String getBowling_b_1_player_9_wickets() {
//        return bowling_b_1_player_9_wickets;
//    }
//
//    public void setBowling_b_1_player_9_wickets(String bowling_b_1_player_9_wickets) {
//        this.bowling_b_1_player_9_wickets = bowling_b_1_player_9_wickets;
//    }
//
//    public String getBowling_b_1_player_9_extras() {
//        return bowling_b_1_player_9_extras;
//    }
//
//    public void setBowling_b_1_player_9_extras(String bowling_b_1_player_9_extras) {
//        this.bowling_b_1_player_9_extras = bowling_b_1_player_9_extras;
//    }
//
//    public String getBowling_b_1_player_9_maiden_overs() {
//        return bowling_b_1_player_9_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_9_maiden_overs(String bowling_b_1_player_9_maiden_overs) {
//        this.bowling_b_1_player_9_maiden_overs = bowling_b_1_player_9_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_9_overs() {
//        return bowling_b_1_player_9_overs;
//    }
//
//    public void setBowling_b_1_player_9_overs(String bowling_b_1_player_9_overs) {
//        this.bowling_b_1_player_9_overs = bowling_b_1_player_9_overs;
//    }
//
//    public String getBowling_b_2_player_9_name() {
//        return bowling_b_2_player_9_name;
//    }
//
//    public void setBowling_b_2_player_9_name(String bowling_b_2_player_9_name) {
//        this.bowling_b_2_player_9_name = bowling_b_2_player_9_name;
//    }
//
//    public String getBowling_b_2_player_9_economy() {
//        return bowling_b_2_player_9_economy;
//    }
//
//    public void setBowling_b_2_player_9_economy(String bowling_b_2_player_9_economy) {
//        this.bowling_b_2_player_9_economy = bowling_b_2_player_9_economy;
//    }
//
//    public String getBowling_b_2_player_9_runs() {
//        return bowling_b_2_player_9_runs;
//    }
//
//    public void setBowling_b_2_player_9_runs(String bowling_b_2_player_9_runs) {
//        this.bowling_b_2_player_9_runs = bowling_b_2_player_9_runs;
//    }
//
//    public String getBowling_b_2_player_9_wickets() {
//        return bowling_b_2_player_9_wickets;
//    }
//
//    public void setBowling_b_2_player_9_wickets(String bowling_b_2_player_9_wickets) {
//        this.bowling_b_2_player_9_wickets = bowling_b_2_player_9_wickets;
//    }
//
//    public String getBowling_b_2_player_9_extras() {
//        return bowling_b_2_player_9_extras;
//    }
//
//    public void setBowling_b_2_player_9_extras(String bowling_b_2_player_9_extras) {
//        this.bowling_b_2_player_9_extras = bowling_b_2_player_9_extras;
//    }
//
//    public String getBowling_b_2_player_9_maiden_overs() {
//        return bowling_b_2_player_9_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_9_maiden_overs(String bowling_b_2_player_9_maiden_overs) {
//        this.bowling_b_2_player_9_maiden_overs = bowling_b_2_player_9_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_9_overs() {
//        return bowling_b_2_player_9_overs;
//    }
//
//    public void setBowling_b_2_player_9_overs(String bowling_b_2_player_9_overs) {
//        this.bowling_b_2_player_9_overs = bowling_b_2_player_9_overs;
//    }
//
//    public String getBowling_a_1_player_10_name() {
//        return bowling_a_1_player_10_name;
//    }
//
//    public void setBowling_a_1_player_10_name(String bowling_a_1_player_10_name) {
//        this.bowling_a_1_player_10_name = bowling_a_1_player_10_name;
//    }
//
//    public String getBowling_a_1_player_10_economy() {
//        return bowling_a_1_player_10_economy;
//    }
//
//    public void setBowling_a_1_player_10_economy(String bowling_a_1_player_10_economy) {
//        this.bowling_a_1_player_10_economy = bowling_a_1_player_10_economy;
//    }
//
//    public String getBowling_a_1_player_10_runs() {
//        return bowling_a_1_player_10_runs;
//    }
//
//    public void setBowling_a_1_player_10_runs(String bowling_a_1_player_10_runs) {
//        this.bowling_a_1_player_10_runs = bowling_a_1_player_10_runs;
//    }
//
//    public String getBowling_a_1_player_10_wickets() {
//        return bowling_a_1_player_10_wickets;
//    }
//
//    public void setBowling_a_1_player_10_wickets(String bowling_a_1_player_10_wickets) {
//        this.bowling_a_1_player_10_wickets = bowling_a_1_player_10_wickets;
//    }
//
//    public String getBowling_a_1_player_10_extras() {
//        return bowling_a_1_player_10_extras;
//    }
//
//    public void setBowling_a_1_player_10_extras(String bowling_a_1_player_10_extras) {
//        this.bowling_a_1_player_10_extras = bowling_a_1_player_10_extras;
//    }
//
//    public String getBowling_a_1_player_10_maiden_overs() {
//        return bowling_a_1_player_10_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_10_maiden_overs(String bowling_a_1_player_10_maiden_overs) {
//        this.bowling_a_1_player_10_maiden_overs = bowling_a_1_player_10_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_10_overs() {
//        return bowling_a_1_player_10_overs;
//    }
//
//    public void setBowling_a_1_player_10_overs(String bowling_a_1_player_10_overs) {
//        this.bowling_a_1_player_10_overs = bowling_a_1_player_10_overs;
//    }
//
//    public String getBowling_a_2_player_10_name() {
//        return bowling_a_2_player_10_name;
//    }
//
//    public void setBowling_a_2_player_10_name(String bowling_a_2_player_10_name) {
//        this.bowling_a_2_player_10_name = bowling_a_2_player_10_name;
//    }
//
//    public String getBowling_a_2_player_10_economy() {
//        return bowling_a_2_player_10_economy;
//    }
//
//    public void setBowling_a_2_player_10_economy(String bowling_a_2_player_10_economy) {
//        this.bowling_a_2_player_10_economy = bowling_a_2_player_10_economy;
//    }
//
//    public String getBowling_a_2_player_10_runs() {
//        return bowling_a_2_player_10_runs;
//    }
//
//    public void setBowling_a_2_player_10_runs(String bowling_a_2_player_10_runs) {
//        this.bowling_a_2_player_10_runs = bowling_a_2_player_10_runs;
//    }
//
//    public String getBowling_a_2_player_10_wickets() {
//        return bowling_a_2_player_10_wickets;
//    }
//
//    public void setBowling_a_2_player_10_wickets(String bowling_a_2_player_10_wickets) {
//        this.bowling_a_2_player_10_wickets = bowling_a_2_player_10_wickets;
//    }
//
//    public String getBowling_a_2_player_10_extras() {
//        return bowling_a_2_player_10_extras;
//    }
//
//    public void setBowling_a_2_player_10_extras(String bowling_a_2_player_10_extras) {
//        this.bowling_a_2_player_10_extras = bowling_a_2_player_10_extras;
//    }
//
//    public String getBowling_a_2_player_10_maiden_overs() {
//        return bowling_a_2_player_10_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_10_maiden_overs(String bowling_a_2_player_10_maiden_overs) {
//        this.bowling_a_2_player_10_maiden_overs = bowling_a_2_player_10_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_10_overs() {
//        return bowling_a_2_player_10_overs;
//    }
//
//    public void setBowling_a_2_player_10_overs(String bowling_a_2_player_10_overs) {
//        this.bowling_a_2_player_10_overs = bowling_a_2_player_10_overs;
//    }
//
//    public String getBowling_b_1_player_10_name() {
//        return bowling_b_1_player_10_name;
//    }
//
//    public void setBowling_b_1_player_10_name(String bowling_b_1_player_10_name) {
//        this.bowling_b_1_player_10_name = bowling_b_1_player_10_name;
//    }
//
//    public String getBowling_b_1_player_10_economy() {
//        return bowling_b_1_player_10_economy;
//    }
//
//    public void setBowling_b_1_player_10_economy(String bowling_b_1_player_10_economy) {
//        this.bowling_b_1_player_10_economy = bowling_b_1_player_10_economy;
//    }
//
//    public String getBowling_b_1_player_10_runs() {
//        return bowling_b_1_player_10_runs;
//    }
//
//    public void setBowling_b_1_player_10_runs(String bowling_b_1_player_10_runs) {
//        this.bowling_b_1_player_10_runs = bowling_b_1_player_10_runs;
//    }
//
//    public String getBowling_b_1_player_10_wickets() {
//        return bowling_b_1_player_10_wickets;
//    }
//
//    public void setBowling_b_1_player_10_wickets(String bowling_b_1_player_10_wickets) {
//        this.bowling_b_1_player_10_wickets = bowling_b_1_player_10_wickets;
//    }
//
//    public String getBowling_b_1_player_10_extras() {
//        return bowling_b_1_player_10_extras;
//    }
//
//    public void setBowling_b_1_player_10_extras(String bowling_b_1_player_10_extras) {
//        this.bowling_b_1_player_10_extras = bowling_b_1_player_10_extras;
//    }
//
//    public String getBowling_b_1_player_10_maiden_overs() {
//        return bowling_b_1_player_10_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_10_maiden_overs(String bowling_b_1_player_10_maiden_overs) {
//        this.bowling_b_1_player_10_maiden_overs = bowling_b_1_player_10_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_10_overs() {
//        return bowling_b_1_player_10_overs;
//    }
//
//    public void setBowling_b_1_player_10_overs(String bowling_b_1_player_10_overs) {
//        this.bowling_b_1_player_10_overs = bowling_b_1_player_10_overs;
//    }
//
//    public String getBowling_b_2_player_10_name() {
//        return bowling_b_2_player_10_name;
//    }
//
//    public void setBowling_b_2_player_10_name(String bowling_b_2_player_10_name) {
//        this.bowling_b_2_player_10_name = bowling_b_2_player_10_name;
//    }
//
//    public String getBowling_b_2_player_10_economy() {
//        return bowling_b_2_player_10_economy;
//    }
//
//    public void setBowling_b_2_player_10_economy(String bowling_b_2_player_10_economy) {
//        this.bowling_b_2_player_10_economy = bowling_b_2_player_10_economy;
//    }
//
//    public String getBowling_b_2_player_10_runs() {
//        return bowling_b_2_player_10_runs;
//    }
//
//    public void setBowling_b_2_player_10_runs(String bowling_b_2_player_10_runs) {
//        this.bowling_b_2_player_10_runs = bowling_b_2_player_10_runs;
//    }
//
//    public String getBowling_b_2_player_10_wickets() {
//        return bowling_b_2_player_10_wickets;
//    }
//
//    public void setBowling_b_2_player_10_wickets(String bowling_b_2_player_10_wickets) {
//        this.bowling_b_2_player_10_wickets = bowling_b_2_player_10_wickets;
//    }
//
//    public String getBowling_b_2_player_10_extras() {
//        return bowling_b_2_player_10_extras;
//    }
//
//    public void setBowling_b_2_player_10_extras(String bowling_b_2_player_10_extras) {
//        this.bowling_b_2_player_10_extras = bowling_b_2_player_10_extras;
//    }
//
//    public String getBowling_b_2_player_10_maiden_overs() {
//        return bowling_b_2_player_10_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_10_maiden_overs(String bowling_b_2_player_10_maiden_overs) {
//        this.bowling_b_2_player_10_maiden_overs = bowling_b_2_player_10_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_10_overs() {
//        return bowling_b_2_player_10_overs;
//    }
//
//    public void setBowling_b_2_player_10_overs(String bowling_b_2_player_10_overs) {
//        this.bowling_b_2_player_10_overs = bowling_b_2_player_10_overs;
//    }
//
//    public String getBowling_a_1_player_11_name() {
//        return bowling_a_1_player_11_name;
//    }
//
//    public void setBowling_a_1_player_11_name(String bowling_a_1_player_11_name) {
//        this.bowling_a_1_player_11_name = bowling_a_1_player_11_name;
//    }
//
//    public String getBowling_a_1_player_11_economy() {
//        return bowling_a_1_player_11_economy;
//    }
//
//    public void setBowling_a_1_player_11_economy(String bowling_a_1_player_11_economy) {
//        this.bowling_a_1_player_11_economy = bowling_a_1_player_11_economy;
//    }
//
//    public String getBowling_a_1_player_11_runs() {
//        return bowling_a_1_player_11_runs;
//    }
//
//    public void setBowling_a_1_player_11_runs(String bowling_a_1_player_11_runs) {
//        this.bowling_a_1_player_11_runs = bowling_a_1_player_11_runs;
//    }
//
//    public String getBowling_a_1_player_11_wickets() {
//        return bowling_a_1_player_11_wickets;
//    }
//
//    public void setBowling_a_1_player_11_wickets(String bowling_a_1_player_11_wickets) {
//        this.bowling_a_1_player_11_wickets = bowling_a_1_player_11_wickets;
//    }
//
//    public String getBowling_a_1_player_11_extras() {
//        return bowling_a_1_player_11_extras;
//    }
//
//    public void setBowling_a_1_player_11_extras(String bowling_a_1_player_11_extras) {
//        this.bowling_a_1_player_11_extras = bowling_a_1_player_11_extras;
//    }
//
//    public String getBowling_a_1_player_11_maiden_overs() {
//        return bowling_a_1_player_11_maiden_overs;
//    }
//
//    public void setBowling_a_1_player_11_maiden_overs(String bowling_a_1_player_11_maiden_overs) {
//        this.bowling_a_1_player_11_maiden_overs = bowling_a_1_player_11_maiden_overs;
//    }
//
//    public String getBowling_a_1_player_11_overs() {
//        return bowling_a_1_player_11_overs;
//    }
//
//    public void setBowling_a_1_player_11_overs(String bowling_a_1_player_11_overs) {
//        this.bowling_a_1_player_11_overs = bowling_a_1_player_11_overs;
//    }
//
//    public String getBowling_a_2_player_11_name() {
//        return bowling_a_2_player_11_name;
//    }
//
//    public void setBowling_a_2_player_11_name(String bowling_a_2_player_11_name) {
//        this.bowling_a_2_player_11_name = bowling_a_2_player_11_name;
//    }
//
//    public String getBowling_a_2_player_11_economy() {
//        return bowling_a_2_player_11_economy;
//    }
//
//    public void setBowling_a_2_player_11_economy(String bowling_a_2_player_11_economy) {
//        this.bowling_a_2_player_11_economy = bowling_a_2_player_11_economy;
//    }
//
//    public String getBowling_a_2_player_11_runs() {
//        return bowling_a_2_player_11_runs;
//    }
//
//    public void setBowling_a_2_player_11_runs(String bowling_a_2_player_11_runs) {
//        this.bowling_a_2_player_11_runs = bowling_a_2_player_11_runs;
//    }
//
//    public String getBowling_a_2_player_11_wickets() {
//        return bowling_a_2_player_11_wickets;
//    }
//
//    public void setBowling_a_2_player_11_wickets(String bowling_a_2_player_11_wickets) {
//        this.bowling_a_2_player_11_wickets = bowling_a_2_player_11_wickets;
//    }
//
//    public String getBowling_a_2_player_11_extras() {
//        return bowling_a_2_player_11_extras;
//    }
//
//    public void setBowling_a_2_player_11_extras(String bowling_a_2_player_11_extras) {
//        this.bowling_a_2_player_11_extras = bowling_a_2_player_11_extras;
//    }
//
//    public String getBowling_a_2_player_11_maiden_overs() {
//        return bowling_a_2_player_11_maiden_overs;
//    }
//
//    public void setBowling_a_2_player_11_maiden_overs(String bowling_a_2_player_11_maiden_overs) {
//        this.bowling_a_2_player_11_maiden_overs = bowling_a_2_player_11_maiden_overs;
//    }
//
//    public String getBowling_a_2_player_11_overs() {
//        return bowling_a_2_player_11_overs;
//    }
//
//    public void setBowling_a_2_player_11_overs(String bowling_a_2_player_11_overs) {
//        this.bowling_a_2_player_11_overs = bowling_a_2_player_11_overs;
//    }
//
//    public String getBowling_b_1_player_11_name() {
//        return bowling_b_1_player_11_name;
//    }
//
//    public void setBowling_b_1_player_11_name(String bowling_b_1_player_11_name) {
//        this.bowling_b_1_player_11_name = bowling_b_1_player_11_name;
//    }
//
//    public String getBowling_b_1_player_11_economy() {
//        return bowling_b_1_player_11_economy;
//    }
//
//    public void setBowling_b_1_player_11_economy(String bowling_b_1_player_11_economy) {
//        this.bowling_b_1_player_11_economy = bowling_b_1_player_11_economy;
//    }
//
//    public String getBowling_b_1_player_11_runs() {
//        return bowling_b_1_player_11_runs;
//    }
//
//    public void setBowling_b_1_player_11_runs(String bowling_b_1_player_11_runs) {
//        this.bowling_b_1_player_11_runs = bowling_b_1_player_11_runs;
//    }
//
//    public String getBowling_b_1_player_11_wickets() {
//        return bowling_b_1_player_11_wickets;
//    }
//
//    public void setBowling_b_1_player_11_wickets(String bowling_b_1_player_11_wickets) {
//        this.bowling_b_1_player_11_wickets = bowling_b_1_player_11_wickets;
//    }
//
//    public String getBowling_b_1_player_11_extras() {
//        return bowling_b_1_player_11_extras;
//    }
//
//    public void setBowling_b_1_player_11_extras(String bowling_b_1_player_11_extras) {
//        this.bowling_b_1_player_11_extras = bowling_b_1_player_11_extras;
//    }
//
//    public String getBowling_b_1_player_11_maiden_overs() {
//        return bowling_b_1_player_11_maiden_overs;
//    }
//
//    public void setBowling_b_1_player_11_maiden_overs(String bowling_b_1_player_11_maiden_overs) {
//        this.bowling_b_1_player_11_maiden_overs = bowling_b_1_player_11_maiden_overs;
//    }
//
//    public String getBowling_b_1_player_11_overs() {
//        return bowling_b_1_player_11_overs;
//    }
//
//    public void setBowling_b_1_player_11_overs(String bowling_b_1_player_11_overs) {
//        this.bowling_b_1_player_11_overs = bowling_b_1_player_11_overs;
//    }
//
//    public String getBowling_b_2_player_11_name() {
//        return bowling_b_2_player_11_name;
//    }
//
//    public void setBowling_b_2_player_11_name(String bowling_b_2_player_11_name) {
//        this.bowling_b_2_player_11_name = bowling_b_2_player_11_name;
//    }
//
//    public String getBowling_b_2_player_11_economy() {
//        return bowling_b_2_player_11_economy;
//    }
//
//    public void setBowling_b_2_player_11_economy(String bowling_b_2_player_11_economy) {
//        this.bowling_b_2_player_11_economy = bowling_b_2_player_11_economy;
//    }
//
//    public String getBowling_b_2_player_11_runs() {
//        return bowling_b_2_player_11_runs;
//    }
//
//    public void setBowling_b_2_player_11_runs(String bowling_b_2_player_11_runs) {
//        this.bowling_b_2_player_11_runs = bowling_b_2_player_11_runs;
//    }
//
//    public String getBowling_b_2_player_11_wickets() {
//        return bowling_b_2_player_11_wickets;
//    }
//
//    public void setBowling_b_2_player_11_wickets(String bowling_b_2_player_11_wickets) {
//        this.bowling_b_2_player_11_wickets = bowling_b_2_player_11_wickets;
//    }
//
//    public String getBowling_b_2_player_11_extras() {
//        return bowling_b_2_player_11_extras;
//    }
//
//    public void setBowling_b_2_player_11_extras(String bowling_b_2_player_11_extras) {
//        this.bowling_b_2_player_11_extras = bowling_b_2_player_11_extras;
//    }
//
//    public String getBowling_b_2_player_11_maiden_overs() {
//        return bowling_b_2_player_11_maiden_overs;
//    }
//
//    public void setBowling_b_2_player_11_maiden_overs(String bowling_b_2_player_11_maiden_overs) {
//        this.bowling_b_2_player_11_maiden_overs = bowling_b_2_player_11_maiden_overs;
//    }
//
//    public String getBowling_b_2_player_11_overs() {
//        return bowling_b_2_player_11_overs;
//    }
//
//    public void setBowling_b_2_player_11_overs(String bowling_b_2_player_11_overs) {
//        this.bowling_b_2_player_11_overs = bowling_b_2_player_11_overs;
//    }
//
//    public String getTeam_a() {
//        return team_a;
//    }
//
//    public void setTeam_a(String team_a) {
//        this.team_a = team_a;
//    }
//
//    public String getTeam_b() {
//        return team_b;
//    }
//
//    public void setTeam_b(String team_b) {
//        this.team_b = team_b;
//    }
//
//    public String getTeam_a_url() {
//        return team_a_url;
//    }
//
//    public void setTeam_a_url(String team_a_url) {
//        this.team_a_url = team_a_url;
//    }
//
//    public String getTeam_b_url() {
//        return team_b_url;
//    }
//
//    public void setTeam_b_url(String team_b_url) {
//        this.team_b_url = team_b_url;
//    }
//
//    public String getRelated_name() {
//        return related_name;
//    }
//
//    public void setRelated_name(String related_name) {
//        this.related_name = related_name;
//    }
//
//    public String getMsgs_result() {
//        return msgs_result;
//    }
//
//    public void setMsgs_result(String msgs_result) {
//        this.msgs_result = msgs_result;
//    }
//
//    public List<String> getMsgs_others() {
//        return msgs_others;
//    }
//
//    public void setMsgs_others(List<String> msgs_others) {
//        this.msgs_others = msgs_others;
//    }
//
//    public String getToss_decision() {
//        return toss_decision;
//    }
//
//    public void setToss_decision(String toss_decision) {
//        this.toss_decision = toss_decision;
//    }
//
//    public String getToss_won() {
//        return toss_won;
//    }
//
//    public void setToss_won(String toss_won) {
//        this.toss_won = toss_won;
//    }
//
//    public String getToss_str() {
//        return toss_str;
//    }
//
//    public void setToss_str(String toss_str) {
//        this.toss_str = toss_str;
//    }
//
//    public String getWinner_team() {
//        return winner_team;
//    }
//
//    public void setWinner_team(String winner_team) {
//        this.winner_team = winner_team;
//    }
//
//    public List<String> getInnings_A_1_batting_order() {
//        return innings_A_1_batting_order;
//    }
//
//    public void setInnings_A_1_batting_order(List<String> innings_A_1_batting_order) {
//        this.innings_A_1_batting_order = innings_A_1_batting_order;
//    }
//
//    public int getInnings_A_1_runs() {
//        return innings_A_1_runs;
//    }
//
//    public void setInnings_A_1_runs(int innings_A_1_runs) {
//        this.innings_A_1_runs = innings_A_1_runs;
//    }
//
//    public int getInnings_A_1_balls() {
//        return innings_A_1_balls;
//    }
//
//    public void setInnings_A_1_balls(int innings_A_1_balls) {
//        this.innings_A_1_balls = innings_A_1_balls;
//    }
//
//    public List<String> getInnings_A_1_fall_of_wickets() {
//        return innings_A_1_fall_of_wickets;
//    }
//
//    public void setInnings_A_1_fall_of_wickets(List<String> innings_A_1_fall_of_wickets) {
//        this.innings_A_1_fall_of_wickets = innings_A_1_fall_of_wickets;
//    }
//
//    public int getInnings_A_1_wide() {
//        return innings_A_1_wide;
//    }
//
//    public void setInnings_A_1_wide(int innings_A_1_wide) {
//        this.innings_A_1_wide = innings_A_1_wide;
//    }
//
//    public String getInnings_A_1_run_rate() {
//        return innings_A_1_run_rate;
//    }
//
//    public void setInnings_A_1_run_rate(String innings_A_1_run_rate) {
//        this.innings_A_1_run_rate = innings_A_1_run_rate;
//    }
//
//    public int getInnings_A_1_fours() {
//        return innings_A_1_fours;
//    }
//
//    public void setInnings_A_1_fours(int innings_A_1_fours) {
//        this.innings_A_1_fours = innings_A_1_fours;
//    }
//
//    public String getInnings_A_1_run_str() {
//        return innings_A_1_run_str;
//    }
//
//    public void setInnings_A_1_run_str(String innings_A_1_run_str) {
//        this.innings_A_1_run_str = innings_A_1_run_str;
//    }
//
//    public int getInnings_A_1_wickets() {
//        return innings_A_1_wickets;
//    }
//
//    public void setInnings_A_1_wickets(int innings_A_1_wickets) {
//        this.innings_A_1_wickets = innings_A_1_wickets;
//    }
//
//    public List<String> getInnings_A_1_wicket_order() {
//        return innings_A_1_wicket_order;
//    }
//
//    public void setInnings_A_1_wicket_order(List<String> innings_A_1_wicket_order) {
//        this.innings_A_1_wicket_order = innings_A_1_wicket_order;
//    }
//
//    public int getInnings_A_1_extras() {
//        return innings_A_1_extras;
//    }
//
//    public void setInnings_A_1_extras(int innings_A_1_extras) {
//        this.innings_A_1_extras = innings_A_1_extras;
//    }
//
//    public List<String> getInnings_A_1_bowling_order() {
//        return innings_A_1_bowling_order;
//    }
//
//    public void setInnings_A_1_bowling_order(List<String> innings_A_1_bowling_order) {
//        this.innings_A_1_bowling_order = innings_A_1_bowling_order;
//    }
//
//    public String getInnings_A_1_key() {
//        return innings_A_1_key;
//    }
//
//    public void setInnings_A_1_key(String innings_A_1_key) {
//        this.innings_A_1_key = innings_A_1_key;
//    }
//
//    public int getInnings_A_1_noball() {
//        return innings_A_1_noball;
//    }
//
//    public void setInnings_A_1_noball(int innings_A_1_noball) {
//        this.innings_A_1_noball = innings_A_1_noball;
//    }
//
//    public int getInnings_A_1_sixes() {
//        return innings_A_1_sixes;
//    }
//
//    public void setInnings_A_1_sixes(int innings_A_1_sixes) {
//        this.innings_A_1_sixes = innings_A_1_sixes;
//    }
//
//    public int getInnings_A_1_legbye() {
//        return innings_A_1_legbye;
//    }
//
//    public void setInnings_A_1_legbye(int innings_A_1_legbye) {
//        this.innings_A_1_legbye = innings_A_1_legbye;
//    }
//
//    public int getInnings_A_1_bye() {
//        return innings_A_1_bye;
//    }
//
//    public void setInnings_A_1_bye(int innings_A_1_bye) {
//        this.innings_A_1_bye = innings_A_1_bye;
//    }
//
//    public String getInnings_A_1_overs() {
//        return innings_A_1_overs;
//    }
//
//    public void setInnings_A_1_overs(String innings_A_1_overs) {
//        this.innings_A_1_overs = innings_A_1_overs;
//    }
//
//    public int getInnings_A_1_dotballs() {
//        return innings_A_1_dotballs;
//    }
//
//    public void setInnings_A_1_dotballs(int innings_A_1_dotballs) {
//        this.innings_A_1_dotballs = innings_A_1_dotballs;
//    }
//
//    public List<String> getInnings_B_1_batting_order() {
//        return innings_B_1_batting_order;
//    }
//
//    public void setInnings_B_1_batting_order(List<String> innings_B_1_batting_order) {
//        this.innings_B_1_batting_order = innings_B_1_batting_order;
//    }
//
//    public int getInnings_B_1_runs() {
//        return innings_B_1_runs;
//    }
//
//    public void setInnings_B_1_runs(int innings_B_1_runs) {
//        this.innings_B_1_runs = innings_B_1_runs;
//    }
//
//    public int getInnings_B_1_balls() {
//        return innings_B_1_balls;
//    }
//
//    public void setInnings_B_1_balls(int innings_B_1_balls) {
//        this.innings_B_1_balls = innings_B_1_balls;
//    }
//
//    public List<String> getInnings_B_1_fall_of_wickets() {
//        return innings_B_1_fall_of_wickets;
//    }
//
//    public void setInnings_B_1_fall_of_wickets(List<String> innings_B_1_fall_of_wickets) {
//        this.innings_B_1_fall_of_wickets = innings_B_1_fall_of_wickets;
//    }
//
//    public int getInnings_B_1_wide() {
//        return innings_B_1_wide;
//    }
//
//    public void setInnings_B_1_wide(int innings_B_1_wide) {
//        this.innings_B_1_wide = innings_B_1_wide;
//    }
//
//    public String getInnings_B_1_run_rate() {
//        return innings_B_1_run_rate;
//    }
//
//    public void setInnings_B_1_run_rate(String innings_B_1_run_rate) {
//        this.innings_B_1_run_rate = innings_B_1_run_rate;
//    }
//
//    public int getInnings_B_1_fours() {
//        return innings_B_1_fours;
//    }
//
//    public void setInnings_B_1_fours(int innings_B_1_fours) {
//        this.innings_B_1_fours = innings_B_1_fours;
//    }
//
//    public String getInnings_B_1_run_str() {
//        return innings_B_1_run_str;
//    }
//
//    public void setInnings_B_1_run_str(String innings_B_1_run_str) {
//        this.innings_B_1_run_str = innings_B_1_run_str;
//    }
//
//    public int getInnings_B_1_wickets() {
//        return innings_B_1_wickets;
//    }
//
//    public void setInnings_B_1_wickets(int innings_B_1_wickets) {
//        this.innings_B_1_wickets = innings_B_1_wickets;
//    }
//
//    public List<String> getInnings_B_1_wicket_order() {
//        return innings_B_1_wicket_order;
//    }
//
//    public void setInnings_B_1_wicket_order(List<String> innings_B_1_wicket_order) {
//        this.innings_B_1_wicket_order = innings_B_1_wicket_order;
//    }
//
//    public int getInnings_B_1_extras() {
//        return innings_B_1_extras;
//    }
//
//    public void setInnings_B_1_extras(int innings_B_1_extras) {
//        this.innings_B_1_extras = innings_B_1_extras;
//    }
//
//    public List<String> getInnings_B_1_bowling_order() {
//        return innings_B_1_bowling_order;
//    }
//
//    public void setInnings_B_1_bowling_order(List<String> innings_B_1_bowling_order) {
//        this.innings_B_1_bowling_order = innings_B_1_bowling_order;
//    }
//
//    public String getInnings_B_1_key() {
//        return innings_B_1_key;
//    }
//
//    public void setInnings_B_1_key(String innings_B_1_key) {
//        this.innings_B_1_key = innings_B_1_key;
//    }
//
//    public int getInnings_B_1_noball() {
//        return innings_B_1_noball;
//    }
//
//    public void setInnings_B_1_noball(int innings_B_1_noball) {
//        this.innings_B_1_noball = innings_B_1_noball;
//    }
//
//    public int getInnings_B_1_sixes() {
//        return innings_B_1_sixes;
//    }
//
//    public void setInnings_B_1_sixes(int innings_B_1_sixes) {
//        this.innings_B_1_sixes = innings_B_1_sixes;
//    }
//
//    public int getInnings_B_1_legbye() {
//        return innings_B_1_legbye;
//    }
//
//    public void setInnings_B_1_legbye(int innings_B_1_legbye) {
//        this.innings_B_1_legbye = innings_B_1_legbye;
//    }
//
//    public int getInnings_B_1_bye() {
//        return innings_B_1_bye;
//    }
//
//    public void setInnings_B_1_bye(int innings_B_1_bye) {
//        this.innings_B_1_bye = innings_B_1_bye;
//    }
//
//    public String getInnings_B_1_overs() {
//        return innings_B_1_overs;
//    }
//
//    public void setInnings_B_1_overs(String innings_B_1_overs) {
//        this.innings_B_1_overs = innings_B_1_overs;
//    }
//
//    public int getInnings_B_1_dotballs() {
//        return innings_B_1_dotballs;
//    }
//
//    public void setInnings_B_1_dotballs(int innings_B_1_dotballs) {
//        this.innings_B_1_dotballs = innings_B_1_dotballs;
//    }
//
//    public List<String> getInnings_A_2_batting_order() {
//        return innings_A_2_batting_order;
//    }
//
//    public void setInnings_A_2_batting_order(List<String> innings_A_2_batting_order) {
//        this.innings_A_2_batting_order = innings_A_2_batting_order;
//    }
//
//    public int getInnings_A_2_runs() {
//        return innings_A_2_runs;
//    }
//
//    public void setInnings_A_2_runs(int innings_A_2_runs) {
//        this.innings_A_2_runs = innings_A_2_runs;
//    }
//
//    public int getInnings_A_2_balls() {
//        return innings_A_2_balls;
//    }
//
//    public void setInnings_A_2_balls(int innings_A_2_balls) {
//        this.innings_A_2_balls = innings_A_2_balls;
//    }
//
//    public List<String> getInnings_A_2_fall_of_wickets() {
//        return innings_A_2_fall_of_wickets;
//    }
//
//    public void setInnings_A_2_fall_of_wickets(List<String> innings_A_2_fall_of_wickets) {
//        this.innings_A_2_fall_of_wickets = innings_A_2_fall_of_wickets;
//    }
//
//    public int getInnings_A_2_wide() {
//        return innings_A_2_wide;
//    }
//
//    public void setInnings_A_2_wide(int innings_A_2_wide) {
//        this.innings_A_2_wide = innings_A_2_wide;
//    }
//
//    public String getInnings_A_2_run_rate() {
//        return innings_A_2_run_rate;
//    }
//
//    public void setInnings_A_2_run_rate(String innings_A_2_run_rate) {
//        this.innings_A_2_run_rate = innings_A_2_run_rate;
//    }
//
//    public int getInnings_A_2_fours() {
//        return innings_A_2_fours;
//    }
//
//    public void setInnings_A_2_fours(int innings_A_2_fours) {
//        this.innings_A_2_fours = innings_A_2_fours;
//    }
//
//    public String getInnings_A_2_run_str() {
//        return innings_A_2_run_str;
//    }
//
//    public void setInnings_A_2_run_str(String innings_A_2_run_str) {
//        this.innings_A_2_run_str = innings_A_2_run_str;
//    }
//
//    public int getInnings_A_2_wickets() {
//        return innings_A_2_wickets;
//    }
//
//    public void setInnings_A_2_wickets(int innings_A_2_wickets) {
//        this.innings_A_2_wickets = innings_A_2_wickets;
//    }
//
//    public List<String> getInnings_A_2_wicket_order() {
//        return innings_A_2_wicket_order;
//    }
//
//    public void setInnings_A_2_wicket_order(List<String> innings_A_2_wicket_order) {
//        this.innings_A_2_wicket_order = innings_A_2_wicket_order;
//    }
//
//    public int getInnings_A_2_extras() {
//        return innings_A_2_extras;
//    }
//
//    public void setInnings_A_2_extras(int innings_A_2_extras) {
//        this.innings_A_2_extras = innings_A_2_extras;
//    }
//
//    public List<String> getInnings_A_2_bowling_order() {
//        return innings_A_2_bowling_order;
//    }
//
//    public void setInnings_A_2_bowling_order(List<String> innings_A_2_bowling_order) {
//        this.innings_A_2_bowling_order = innings_A_2_bowling_order;
//    }
//
//    public String getInnings_A_2_key() {
//        return innings_A_2_key;
//    }
//
//    public void setInnings_A_2_key(String innings_A_2_key) {
//        this.innings_A_2_key = innings_A_2_key;
//    }
//
//    public int getInnings_A_2_noball() {
//        return innings_A_2_noball;
//    }
//
//    public void setInnings_A_2_noball(int innings_A_2_noball) {
//        this.innings_A_2_noball = innings_A_2_noball;
//    }
//
//    public int getInnings_A_2_sixes() {
//        return innings_A_2_sixes;
//    }
//
//    public void setInnings_A_2_sixes(int innings_A_2_sixes) {
//        this.innings_A_2_sixes = innings_A_2_sixes;
//    }
//
//    public int getInnings_A_2_legbye() {
//        return innings_A_2_legbye;
//    }
//
//    public void setInnings_A_2_legbye(int innings_A_2_legbye) {
//        this.innings_A_2_legbye = innings_A_2_legbye;
//    }
//
//    public int getInnings_A_2_bye() {
//        return innings_A_2_bye;
//    }
//
//    public void setInnings_A_2_bye(int innings_A_2_bye) {
//        this.innings_A_2_bye = innings_A_2_bye;
//    }
//
//    public String getInnings_A_2_overs() {
//        return innings_A_2_overs;
//    }
//
//    public void setInnings_A_2_overs(String innings_A_2_overs) {
//        this.innings_A_2_overs = innings_A_2_overs;
//    }
//
//    public int getInnings_A_2_dotballs() {
//        return innings_A_2_dotballs;
//    }
//
//    public void setInnings_A_2_dotballs(int innings_A_2_dotballs) {
//        this.innings_A_2_dotballs = innings_A_2_dotballs;
//    }
//
//    public List<String> getInnings_B_2_batting_order() {
//        return innings_B_2_batting_order;
//    }
//
//    public void setInnings_B_2_batting_order(List<String> innings_B_2_batting_order) {
//        this.innings_B_2_batting_order = innings_B_2_batting_order;
//    }
//
//    public int getInnings_B_2_runs() {
//        return innings_B_2_runs;
//    }
//
//    public void setInnings_B_2_runs(int innings_B_2_runs) {
//        this.innings_B_2_runs = innings_B_2_runs;
//    }
//
//    public int getInnings_B_2_balls() {
//        return innings_B_2_balls;
//    }
//
//    public void setInnings_B_2_balls(int innings_B_2_balls) {
//        this.innings_B_2_balls = innings_B_2_balls;
//    }
//
//    public List<String> getInnings_B_2_fall_of_wickets() {
//        return innings_B_2_fall_of_wickets;
//    }
//
//    public void setInnings_B_2_fall_of_wickets(List<String> innings_B_2_fall_of_wickets) {
//        this.innings_B_2_fall_of_wickets = innings_B_2_fall_of_wickets;
//    }
//
//    public int getInnings_B_2_wide() {
//        return innings_B_2_wide;
//    }
//
//    public void setInnings_B_2_wide(int innings_B_2_wide) {
//        this.innings_B_2_wide = innings_B_2_wide;
//    }
//
//    public String getInnings_B_2_run_rate() {
//        return innings_B_2_run_rate;
//    }
//
//    public void setInnings_B_2_run_rate(String innings_B_2_run_rate) {
//        this.innings_B_2_run_rate = innings_B_2_run_rate;
//    }
//
//    public int getInnings_B_2_fours() {
//        return innings_B_2_fours;
//    }
//
//    public void setInnings_B_2_fours(int innings_B_2_fours) {
//        this.innings_B_2_fours = innings_B_2_fours;
//    }
//
//    public String getInnings_B_2_run_str() {
//        return innings_B_2_run_str;
//    }
//
//    public void setInnings_B_2_run_str(String innings_B_2_run_str) {
//        this.innings_B_2_run_str = innings_B_2_run_str;
//    }
//
//    public int getInnings_B_2_wickets() {
//        return innings_B_2_wickets;
//    }
//
//    public void setInnings_B_2_wickets(int innings_B_2_wickets) {
//        this.innings_B_2_wickets = innings_B_2_wickets;
//    }
//
//    public List<String> getInnings_B_2_wicket_order() {
//        return innings_B_2_wicket_order;
//    }
//
//    public void setInnings_B_2_wicket_order(List<String> innings_B_2_wicket_order) {
//        this.innings_B_2_wicket_order = innings_B_2_wicket_order;
//    }
//
//    public int getInnings_B_2_extras() {
//        return innings_B_2_extras;
//    }
//
//    public void setInnings_B_2_extras(int innings_B_2_extras) {
//        this.innings_B_2_extras = innings_B_2_extras;
//    }
//
//    public List<String> getInnings_B_2_bowling_order() {
//        return innings_B_2_bowling_order;
//    }
//
//    public void setInnings_B_2_bowling_order(List<String> innings_B_2_bowling_order) {
//        this.innings_B_2_bowling_order = innings_B_2_bowling_order;
//    }
//
//    public String getInnings_B_2_key() {
//        return innings_B_2_key;
//    }
//
//    public void setInnings_B_2_key(String innings_B_2_key) {
//        this.innings_B_2_key = innings_B_2_key;
//    }
//
//    public int getInnings_B_2_noball() {
//        return innings_B_2_noball;
//    }
//
//    public void setInnings_B_2_noball(int innings_B_2_noball) {
//        this.innings_B_2_noball = innings_B_2_noball;
//    }
//
//    public int getInnings_B_2_sixes() {
//        return innings_B_2_sixes;
//    }
//
//    public void setInnings_B_2_sixes(int innings_B_2_sixes) {
//        this.innings_B_2_sixes = innings_B_2_sixes;
//    }
//
//    public int getInnings_B_2_legbye() {
//        return innings_B_2_legbye;
//    }
//
//    public void setInnings_B_2_legbye(int innings_B_2_legbye) {
//        this.innings_B_2_legbye = innings_B_2_legbye;
//    }
//
//    public int getInnings_B_2_bye() {
//        return innings_B_2_bye;
//    }
//
//    public void setInnings_B_2_bye(int innings_B_2_bye) {
//        this.innings_B_2_bye = innings_B_2_bye;
//    }
//
//    public String getInnings_B_2_overs() {
//        return innings_B_2_overs;
//    }
//
//    public void setInnings_B_2_overs(String innings_B_2_overs) {
//        this.innings_B_2_overs = innings_B_2_overs;
//    }
//
//    public int getInnings_B_2_dotballs() {
//        return innings_B_2_dotballs;
//    }
//
//    public void setInnings_B_2_dotballs(int innings_B_2_dotballs) {
//        this.innings_B_2_dotballs = innings_B_2_dotballs;
//    }
//
//    public String getInnings_A_1_batting_player_1_full_name() {
//        return innings_A_1_batting_player_1_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_1_full_name(String innings_A_1_batting_player_1_full_name) {
//        this.innings_A_1_batting_player_1_full_name = innings_A_1_batting_player_1_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_1_sixes() {
//        return innings_A_1_batting_player_1_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_1_sixes(String innings_A_1_batting_player_1_innings_1_sixes) {
//        this.innings_A_1_batting_player_1_innings_1_sixes = innings_A_1_batting_player_1_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_1_fours() {
//        return innings_A_1_batting_player_1_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_1_fours(String innings_A_1_batting_player_1_innings_1_fours) {
//        this.innings_A_1_batting_player_1_innings_1_fours = innings_A_1_batting_player_1_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_1_balls() {
//        return innings_A_1_batting_player_1_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_1_balls(String innings_A_1_batting_player_1_innings_1_balls) {
//        this.innings_A_1_batting_player_1_innings_1_balls = innings_A_1_batting_player_1_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_1_runs() {
//        return innings_A_1_batting_player_1_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_1_runs(String innings_A_1_batting_player_1_innings_1_runs) {
//        this.innings_A_1_batting_player_1_innings_1_runs = innings_A_1_batting_player_1_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_1_out_comment() {
//        return innings_A_1_batting_player_1_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_1_out_comment(String innings_A_1_batting_player_1_innings_1_out_comment) {
//        this.innings_A_1_batting_player_1_innings_1_out_comment = innings_A_1_batting_player_1_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_1_strike_rate() {
//        return innings_A_1_batting_player_1_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_1_strike_rate(String innings_A_1_batting_player_1_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_1_innings_1_strike_rate = innings_A_1_batting_player_1_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_1_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_1_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_1_innings_1_maiden_overs(String innings_A_1_bowling_player_1_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_1_innings_1_maiden_overs = innings_A_1_bowling_player_1_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_2_sixes() {
//        return innings_A_1_batting_player_1_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_2_sixes(String innings_A_1_batting_player_1_innings_2_sixes) {
//        this.innings_A_1_batting_player_1_innings_2_sixes = innings_A_1_batting_player_1_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_2_fours() {
//        return innings_A_1_batting_player_1_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_2_fours(String innings_A_1_batting_player_1_innings_2_fours) {
//        this.innings_A_1_batting_player_1_innings_2_fours = innings_A_1_batting_player_1_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_2_balls() {
//        return innings_A_1_batting_player_1_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_2_balls(String innings_A_1_batting_player_1_innings_2_balls) {
//        this.innings_A_1_batting_player_1_innings_2_balls = innings_A_1_batting_player_1_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_2_runs() {
//        return innings_A_1_batting_player_1_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_2_runs(String innings_A_1_batting_player_1_innings_2_runs) {
//        this.innings_A_1_batting_player_1_innings_2_runs = innings_A_1_batting_player_1_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_2_out_comment() {
//        return innings_A_1_batting_player_1_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_2_out_comment(String innings_A_1_batting_player_1_innings_2_out_comment) {
//        this.innings_A_1_batting_player_1_innings_2_out_comment = innings_A_1_batting_player_1_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_1_innings_2_strike_rate() {
//        return innings_A_1_batting_player_1_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_1_innings_2_strike_rate(String innings_A_1_batting_player_1_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_1_innings_2_strike_rate = innings_A_1_batting_player_1_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_1_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_1_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_1_innings_2_maiden_overs(String innings_A_1_bowling_player_1_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_1_innings_2_maiden_overs = innings_A_1_bowling_player_1_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_2_full_name() {
//        return innings_A_1_batting_player_2_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_2_full_name(String innings_A_1_batting_player_2_full_name) {
//        this.innings_A_1_batting_player_2_full_name = innings_A_1_batting_player_2_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_1_sixes() {
//        return innings_A_1_batting_player_2_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_1_sixes(String innings_A_1_batting_player_2_innings_1_sixes) {
//        this.innings_A_1_batting_player_2_innings_1_sixes = innings_A_1_batting_player_2_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_1_fours() {
//        return innings_A_1_batting_player_2_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_1_fours(String innings_A_1_batting_player_2_innings_1_fours) {
//        this.innings_A_1_batting_player_2_innings_1_fours = innings_A_1_batting_player_2_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_1_balls() {
//        return innings_A_1_batting_player_2_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_1_balls(String innings_A_1_batting_player_2_innings_1_balls) {
//        this.innings_A_1_batting_player_2_innings_1_balls = innings_A_1_batting_player_2_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_1_runs() {
//        return innings_A_1_batting_player_2_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_1_runs(String innings_A_1_batting_player_2_innings_1_runs) {
//        this.innings_A_1_batting_player_2_innings_1_runs = innings_A_1_batting_player_2_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_1_out_comment() {
//        return innings_A_1_batting_player_2_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_1_out_comment(String innings_A_1_batting_player_2_innings_1_out_comment) {
//        this.innings_A_1_batting_player_2_innings_1_out_comment = innings_A_1_batting_player_2_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_bowling_player_2_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_2_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_2_innings_1_maiden_overs(String innings_A_1_bowling_player_2_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_2_innings_1_maiden_overs = innings_A_1_bowling_player_2_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_1_strike_rate() {
//        return innings_A_1_batting_player_2_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_1_strike_rate(String innings_A_1_batting_player_2_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_2_innings_1_strike_rate = innings_A_1_batting_player_2_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_2_sixes() {
//        return innings_A_1_batting_player_2_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_2_sixes(String innings_A_1_batting_player_2_innings_2_sixes) {
//        this.innings_A_1_batting_player_2_innings_2_sixes = innings_A_1_batting_player_2_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_2_fours() {
//        return innings_A_1_batting_player_2_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_2_fours(String innings_A_1_batting_player_2_innings_2_fours) {
//        this.innings_A_1_batting_player_2_innings_2_fours = innings_A_1_batting_player_2_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_2_balls() {
//        return innings_A_1_batting_player_2_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_2_balls(String innings_A_1_batting_player_2_innings_2_balls) {
//        this.innings_A_1_batting_player_2_innings_2_balls = innings_A_1_batting_player_2_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_2_runs() {
//        return innings_A_1_batting_player_2_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_2_runs(String innings_A_1_batting_player_2_innings_2_runs) {
//        this.innings_A_1_batting_player_2_innings_2_runs = innings_A_1_batting_player_2_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_2_out_comment() {
//        return innings_A_1_batting_player_2_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_2_out_comment(String innings_A_1_batting_player_2_innings_2_out_comment) {
//        this.innings_A_1_batting_player_2_innings_2_out_comment = innings_A_1_batting_player_2_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_2_innings_2_strike_rate() {
//        return innings_A_1_batting_player_2_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_2_innings_2_strike_rate(String innings_A_1_batting_player_2_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_2_innings_2_strike_rate = innings_A_1_batting_player_2_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_2_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_2_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_2_innings_2_maiden_overs(String innings_A_1_bowling_player_2_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_2_innings_2_maiden_overs = innings_A_1_bowling_player_2_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_3_full_name() {
//        return innings_A_1_batting_player_3_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_3_full_name(String innings_A_1_batting_player_3_full_name) {
//        this.innings_A_1_batting_player_3_full_name = innings_A_1_batting_player_3_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_1_sixes() {
//        return innings_A_1_batting_player_3_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_1_sixes(String innings_A_1_batting_player_3_innings_1_sixes) {
//        this.innings_A_1_batting_player_3_innings_1_sixes = innings_A_1_batting_player_3_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_1_fours() {
//        return innings_A_1_batting_player_3_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_1_fours(String innings_A_1_batting_player_3_innings_1_fours) {
//        this.innings_A_1_batting_player_3_innings_1_fours = innings_A_1_batting_player_3_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_1_balls() {
//        return innings_A_1_batting_player_3_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_1_balls(String innings_A_1_batting_player_3_innings_1_balls) {
//        this.innings_A_1_batting_player_3_innings_1_balls = innings_A_1_batting_player_3_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_1_runs() {
//        return innings_A_1_batting_player_3_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_1_runs(String innings_A_1_batting_player_3_innings_1_runs) {
//        this.innings_A_1_batting_player_3_innings_1_runs = innings_A_1_batting_player_3_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_1_out_comment() {
//        return innings_A_1_batting_player_3_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_1_out_comment(String innings_A_1_batting_player_3_innings_1_out_comment) {
//        this.innings_A_1_batting_player_3_innings_1_out_comment = innings_A_1_batting_player_3_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_1_strike_rate() {
//        return innings_A_1_batting_player_3_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_1_strike_rate(String innings_A_1_batting_player_3_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_3_innings_1_strike_rate = innings_A_1_batting_player_3_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_3_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_3_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_3_innings_1_maiden_overs(String innings_A_1_bowling_player_3_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_3_innings_1_maiden_overs = innings_A_1_bowling_player_3_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_2_sixes() {
//        return innings_A_1_batting_player_3_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_2_sixes(String innings_A_1_batting_player_3_innings_2_sixes) {
//        this.innings_A_1_batting_player_3_innings_2_sixes = innings_A_1_batting_player_3_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_2_fours() {
//        return innings_A_1_batting_player_3_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_2_fours(String innings_A_1_batting_player_3_innings_2_fours) {
//        this.innings_A_1_batting_player_3_innings_2_fours = innings_A_1_batting_player_3_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_2_balls() {
//        return innings_A_1_batting_player_3_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_2_balls(String innings_A_1_batting_player_3_innings_2_balls) {
//        this.innings_A_1_batting_player_3_innings_2_balls = innings_A_1_batting_player_3_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_2_runs() {
//        return innings_A_1_batting_player_3_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_2_runs(String innings_A_1_batting_player_3_innings_2_runs) {
//        this.innings_A_1_batting_player_3_innings_2_runs = innings_A_1_batting_player_3_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_2_out_comment() {
//        return innings_A_1_batting_player_3_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_2_out_comment(String innings_A_1_batting_player_3_innings_2_out_comment) {
//        this.innings_A_1_batting_player_3_innings_2_out_comment = innings_A_1_batting_player_3_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_3_innings_2_strike_rate() {
//        return innings_A_1_batting_player_3_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_3_innings_2_strike_rate(String innings_A_1_batting_player_3_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_3_innings_2_strike_rate = innings_A_1_batting_player_3_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_3_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_3_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_3_innings_2_maiden_overs(String innings_A_1_bowling_player_3_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_3_innings_2_maiden_overs = innings_A_1_bowling_player_3_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_4_full_name() {
//        return innings_A_1_batting_player_4_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_4_full_name(String innings_A_1_batting_player_4_full_name) {
//        this.innings_A_1_batting_player_4_full_name = innings_A_1_batting_player_4_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_1_sixes() {
//        return innings_A_1_batting_player_4_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_1_sixes(String innings_A_1_batting_player_4_innings_1_sixes) {
//        this.innings_A_1_batting_player_4_innings_1_sixes = innings_A_1_batting_player_4_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_1_fours() {
//        return innings_A_1_batting_player_4_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_1_fours(String innings_A_1_batting_player_4_innings_1_fours) {
//        this.innings_A_1_batting_player_4_innings_1_fours = innings_A_1_batting_player_4_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_1_balls() {
//        return innings_A_1_batting_player_4_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_1_balls(String innings_A_1_batting_player_4_innings_1_balls) {
//        this.innings_A_1_batting_player_4_innings_1_balls = innings_A_1_batting_player_4_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_1_runs() {
//        return innings_A_1_batting_player_4_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_1_runs(String innings_A_1_batting_player_4_innings_1_runs) {
//        this.innings_A_1_batting_player_4_innings_1_runs = innings_A_1_batting_player_4_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_1_out_comment() {
//        return innings_A_1_batting_player_4_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_1_out_comment(String innings_A_1_batting_player_4_innings_1_out_comment) {
//        this.innings_A_1_batting_player_4_innings_1_out_comment = innings_A_1_batting_player_4_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_1_strike_rate() {
//        return innings_A_1_batting_player_4_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_1_strike_rate(String innings_A_1_batting_player_4_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_4_innings_1_strike_rate = innings_A_1_batting_player_4_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_4_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_4_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_4_innings_1_maiden_overs(String innings_A_1_bowling_player_4_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_4_innings_1_maiden_overs = innings_A_1_bowling_player_4_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_2_sixes() {
//        return innings_A_1_batting_player_4_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_2_sixes(String innings_A_1_batting_player_4_innings_2_sixes) {
//        this.innings_A_1_batting_player_4_innings_2_sixes = innings_A_1_batting_player_4_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_2_fours() {
//        return innings_A_1_batting_player_4_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_2_fours(String innings_A_1_batting_player_4_innings_2_fours) {
//        this.innings_A_1_batting_player_4_innings_2_fours = innings_A_1_batting_player_4_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_2_balls() {
//        return innings_A_1_batting_player_4_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_2_balls(String innings_A_1_batting_player_4_innings_2_balls) {
//        this.innings_A_1_batting_player_4_innings_2_balls = innings_A_1_batting_player_4_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_2_runs() {
//        return innings_A_1_batting_player_4_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_2_runs(String innings_A_1_batting_player_4_innings_2_runs) {
//        this.innings_A_1_batting_player_4_innings_2_runs = innings_A_1_batting_player_4_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_2_out_comment() {
//        return innings_A_1_batting_player_4_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_2_out_comment(String innings_A_1_batting_player_4_innings_2_out_comment) {
//        this.innings_A_1_batting_player_4_innings_2_out_comment = innings_A_1_batting_player_4_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_4_innings_2_strike_rate() {
//        return innings_A_1_batting_player_4_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_4_innings_2_strike_rate(String innings_A_1_batting_player_4_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_4_innings_2_strike_rate = innings_A_1_batting_player_4_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_4_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_4_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_4_innings_2_maiden_overs(String innings_A_1_bowling_player_4_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_4_innings_2_maiden_overs = innings_A_1_bowling_player_4_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_5_full_name() {
//        return innings_A_1_batting_player_5_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_5_full_name(String innings_A_1_batting_player_5_full_name) {
//        this.innings_A_1_batting_player_5_full_name = innings_A_1_batting_player_5_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_1_sixes() {
//        return innings_A_1_batting_player_5_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_1_sixes(String innings_A_1_batting_player_5_innings_1_sixes) {
//        this.innings_A_1_batting_player_5_innings_1_sixes = innings_A_1_batting_player_5_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_1_fours() {
//        return innings_A_1_batting_player_5_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_1_fours(String innings_A_1_batting_player_5_innings_1_fours) {
//        this.innings_A_1_batting_player_5_innings_1_fours = innings_A_1_batting_player_5_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_1_balls() {
//        return innings_A_1_batting_player_5_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_1_balls(String innings_A_1_batting_player_5_innings_1_balls) {
//        this.innings_A_1_batting_player_5_innings_1_balls = innings_A_1_batting_player_5_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_1_runs() {
//        return innings_A_1_batting_player_5_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_1_runs(String innings_A_1_batting_player_5_innings_1_runs) {
//        this.innings_A_1_batting_player_5_innings_1_runs = innings_A_1_batting_player_5_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_1_out_comment() {
//        return innings_A_1_batting_player_5_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_1_out_comment(String innings_A_1_batting_player_5_innings_1_out_comment) {
//        this.innings_A_1_batting_player_5_innings_1_out_comment = innings_A_1_batting_player_5_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_1_strike_rate() {
//        return innings_A_1_batting_player_5_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_1_strike_rate(String innings_A_1_batting_player_5_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_5_innings_1_strike_rate = innings_A_1_batting_player_5_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_5_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_5_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_5_innings_1_maiden_overs(String innings_A_1_bowling_player_5_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_5_innings_1_maiden_overs = innings_A_1_bowling_player_5_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_2_sixes() {
//        return innings_A_1_batting_player_5_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_2_sixes(String innings_A_1_batting_player_5_innings_2_sixes) {
//        this.innings_A_1_batting_player_5_innings_2_sixes = innings_A_1_batting_player_5_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_2_fours() {
//        return innings_A_1_batting_player_5_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_2_fours(String innings_A_1_batting_player_5_innings_2_fours) {
//        this.innings_A_1_batting_player_5_innings_2_fours = innings_A_1_batting_player_5_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_2_balls() {
//        return innings_A_1_batting_player_5_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_2_balls(String innings_A_1_batting_player_5_innings_2_balls) {
//        this.innings_A_1_batting_player_5_innings_2_balls = innings_A_1_batting_player_5_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_2_runs() {
//        return innings_A_1_batting_player_5_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_2_runs(String innings_A_1_batting_player_5_innings_2_runs) {
//        this.innings_A_1_batting_player_5_innings_2_runs = innings_A_1_batting_player_5_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_2_out_comment() {
//        return innings_A_1_batting_player_5_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_2_out_comment(String innings_A_1_batting_player_5_innings_2_out_comment) {
//        this.innings_A_1_batting_player_5_innings_2_out_comment = innings_A_1_batting_player_5_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_5_innings_2_strike_rate() {
//        return innings_A_1_batting_player_5_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_5_innings_2_strike_rate(String innings_A_1_batting_player_5_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_5_innings_2_strike_rate = innings_A_1_batting_player_5_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_5_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_5_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_5_innings_2_maiden_overs(String innings_A_1_bowling_player_5_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_5_innings_2_maiden_overs = innings_A_1_bowling_player_5_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_6_full_name() {
//        return innings_A_1_batting_player_6_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_6_full_name(String innings_A_1_batting_player_6_full_name) {
//        this.innings_A_1_batting_player_6_full_name = innings_A_1_batting_player_6_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_1_sixes() {
//        return innings_A_1_batting_player_6_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_1_sixes(String innings_A_1_batting_player_6_innings_1_sixes) {
//        this.innings_A_1_batting_player_6_innings_1_sixes = innings_A_1_batting_player_6_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_1_fours() {
//        return innings_A_1_batting_player_6_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_1_fours(String innings_A_1_batting_player_6_innings_1_fours) {
//        this.innings_A_1_batting_player_6_innings_1_fours = innings_A_1_batting_player_6_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_1_balls() {
//        return innings_A_1_batting_player_6_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_1_balls(String innings_A_1_batting_player_6_innings_1_balls) {
//        this.innings_A_1_batting_player_6_innings_1_balls = innings_A_1_batting_player_6_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_1_runs() {
//        return innings_A_1_batting_player_6_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_1_runs(String innings_A_1_batting_player_6_innings_1_runs) {
//        this.innings_A_1_batting_player_6_innings_1_runs = innings_A_1_batting_player_6_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_1_out_comment() {
//        return innings_A_1_batting_player_6_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_1_out_comment(String innings_A_1_batting_player_6_innings_1_out_comment) {
//        this.innings_A_1_batting_player_6_innings_1_out_comment = innings_A_1_batting_player_6_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_1_strike_rate() {
//        return innings_A_1_batting_player_6_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_1_strike_rate(String innings_A_1_batting_player_6_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_6_innings_1_strike_rate = innings_A_1_batting_player_6_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_6_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_6_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_6_innings_1_maiden_overs(String innings_A_1_bowling_player_6_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_6_innings_1_maiden_overs = innings_A_1_bowling_player_6_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_2_sixes() {
//        return innings_A_1_batting_player_6_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_2_sixes(String innings_A_1_batting_player_6_innings_2_sixes) {
//        this.innings_A_1_batting_player_6_innings_2_sixes = innings_A_1_batting_player_6_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_2_fours() {
//        return innings_A_1_batting_player_6_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_2_fours(String innings_A_1_batting_player_6_innings_2_fours) {
//        this.innings_A_1_batting_player_6_innings_2_fours = innings_A_1_batting_player_6_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_2_balls() {
//        return innings_A_1_batting_player_6_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_2_balls(String innings_A_1_batting_player_6_innings_2_balls) {
//        this.innings_A_1_batting_player_6_innings_2_balls = innings_A_1_batting_player_6_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_2_runs() {
//        return innings_A_1_batting_player_6_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_2_runs(String innings_A_1_batting_player_6_innings_2_runs) {
//        this.innings_A_1_batting_player_6_innings_2_runs = innings_A_1_batting_player_6_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_2_out_comment() {
//        return innings_A_1_batting_player_6_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_2_out_comment(String innings_A_1_batting_player_6_innings_2_out_comment) {
//        this.innings_A_1_batting_player_6_innings_2_out_comment = innings_A_1_batting_player_6_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_6_innings_2_strike_rate() {
//        return innings_A_1_batting_player_6_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_6_innings_2_strike_rate(String innings_A_1_batting_player_6_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_6_innings_2_strike_rate = innings_A_1_batting_player_6_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_6_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_6_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_6_innings_2_maiden_overs(String innings_A_1_bowling_player_6_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_6_innings_2_maiden_overs = innings_A_1_bowling_player_6_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_7_full_name() {
//        return innings_A_1_batting_player_7_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_7_full_name(String innings_A_1_batting_player_7_full_name) {
//        this.innings_A_1_batting_player_7_full_name = innings_A_1_batting_player_7_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_1_sixes() {
//        return innings_A_1_batting_player_7_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_1_sixes(String innings_A_1_batting_player_7_innings_1_sixes) {
//        this.innings_A_1_batting_player_7_innings_1_sixes = innings_A_1_batting_player_7_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_1_fours() {
//        return innings_A_1_batting_player_7_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_1_fours(String innings_A_1_batting_player_7_innings_1_fours) {
//        this.innings_A_1_batting_player_7_innings_1_fours = innings_A_1_batting_player_7_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_1_balls() {
//        return innings_A_1_batting_player_7_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_1_balls(String innings_A_1_batting_player_7_innings_1_balls) {
//        this.innings_A_1_batting_player_7_innings_1_balls = innings_A_1_batting_player_7_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_1_runs() {
//        return innings_A_1_batting_player_7_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_1_runs(String innings_A_1_batting_player_7_innings_1_runs) {
//        this.innings_A_1_batting_player_7_innings_1_runs = innings_A_1_batting_player_7_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_1_out_comment() {
//        return innings_A_1_batting_player_7_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_1_out_comment(String innings_A_1_batting_player_7_innings_1_out_comment) {
//        this.innings_A_1_batting_player_7_innings_1_out_comment = innings_A_1_batting_player_7_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_1_strike_rate() {
//        return innings_A_1_batting_player_7_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_1_strike_rate(String innings_A_1_batting_player_7_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_7_innings_1_strike_rate = innings_A_1_batting_player_7_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_7_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_7_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_7_innings_1_maiden_overs(String innings_A_1_bowling_player_7_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_7_innings_1_maiden_overs = innings_A_1_bowling_player_7_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_2_sixes() {
//        return innings_A_1_batting_player_7_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_2_sixes(String innings_A_1_batting_player_7_innings_2_sixes) {
//        this.innings_A_1_batting_player_7_innings_2_sixes = innings_A_1_batting_player_7_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_2_fours() {
//        return innings_A_1_batting_player_7_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_2_fours(String innings_A_1_batting_player_7_innings_2_fours) {
//        this.innings_A_1_batting_player_7_innings_2_fours = innings_A_1_batting_player_7_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_2_balls() {
//        return innings_A_1_batting_player_7_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_2_balls(String innings_A_1_batting_player_7_innings_2_balls) {
//        this.innings_A_1_batting_player_7_innings_2_balls = innings_A_1_batting_player_7_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_2_runs() {
//        return innings_A_1_batting_player_7_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_2_runs(String innings_A_1_batting_player_7_innings_2_runs) {
//        this.innings_A_1_batting_player_7_innings_2_runs = innings_A_1_batting_player_7_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_2_out_comment() {
//        return innings_A_1_batting_player_7_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_2_out_comment(String innings_A_1_batting_player_7_innings_2_out_comment) {
//        this.innings_A_1_batting_player_7_innings_2_out_comment = innings_A_1_batting_player_7_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_7_innings_2_strike_rate() {
//        return innings_A_1_batting_player_7_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_7_innings_2_strike_rate(String innings_A_1_batting_player_7_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_7_innings_2_strike_rate = innings_A_1_batting_player_7_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_7_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_7_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_7_innings_2_maiden_overs(String innings_A_1_bowling_player_7_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_7_innings_2_maiden_overs = innings_A_1_bowling_player_7_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_8_full_name() {
//        return innings_A_1_batting_player_8_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_8_full_name(String innings_A_1_batting_player_8_full_name) {
//        this.innings_A_1_batting_player_8_full_name = innings_A_1_batting_player_8_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_1_sixes() {
//        return innings_A_1_batting_player_8_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_1_sixes(String innings_A_1_batting_player_8_innings_1_sixes) {
//        this.innings_A_1_batting_player_8_innings_1_sixes = innings_A_1_batting_player_8_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_1_fours() {
//        return innings_A_1_batting_player_8_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_1_fours(String innings_A_1_batting_player_8_innings_1_fours) {
//        this.innings_A_1_batting_player_8_innings_1_fours = innings_A_1_batting_player_8_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_1_balls() {
//        return innings_A_1_batting_player_8_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_1_balls(String innings_A_1_batting_player_8_innings_1_balls) {
//        this.innings_A_1_batting_player_8_innings_1_balls = innings_A_1_batting_player_8_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_1_runs() {
//        return innings_A_1_batting_player_8_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_1_runs(String innings_A_1_batting_player_8_innings_1_runs) {
//        this.innings_A_1_batting_player_8_innings_1_runs = innings_A_1_batting_player_8_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_1_out_comment() {
//        return innings_A_1_batting_player_8_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_1_out_comment(String innings_A_1_batting_player_8_innings_1_out_comment) {
//        this.innings_A_1_batting_player_8_innings_1_out_comment = innings_A_1_batting_player_8_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_1_strike_rate() {
//        return innings_A_1_batting_player_8_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_1_strike_rate(String innings_A_1_batting_player_8_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_8_innings_1_strike_rate = innings_A_1_batting_player_8_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_8_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_8_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_8_innings_1_maiden_overs(String innings_A_1_bowling_player_8_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_8_innings_1_maiden_overs = innings_A_1_bowling_player_8_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_2_sixes() {
//        return innings_A_1_batting_player_8_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_2_sixes(String innings_A_1_batting_player_8_innings_2_sixes) {
//        this.innings_A_1_batting_player_8_innings_2_sixes = innings_A_1_batting_player_8_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_2_fours() {
//        return innings_A_1_batting_player_8_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_2_fours(String innings_A_1_batting_player_8_innings_2_fours) {
//        this.innings_A_1_batting_player_8_innings_2_fours = innings_A_1_batting_player_8_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_2_balls() {
//        return innings_A_1_batting_player_8_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_2_balls(String innings_A_1_batting_player_8_innings_2_balls) {
//        this.innings_A_1_batting_player_8_innings_2_balls = innings_A_1_batting_player_8_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_2_runs() {
//        return innings_A_1_batting_player_8_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_2_runs(String innings_A_1_batting_player_8_innings_2_runs) {
//        this.innings_A_1_batting_player_8_innings_2_runs = innings_A_1_batting_player_8_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_2_out_comment() {
//        return innings_A_1_batting_player_8_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_2_out_comment(String innings_A_1_batting_player_8_innings_2_out_comment) {
//        this.innings_A_1_batting_player_8_innings_2_out_comment = innings_A_1_batting_player_8_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_8_innings_2_strike_rate() {
//        return innings_A_1_batting_player_8_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_8_innings_2_strike_rate(String innings_A_1_batting_player_8_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_8_innings_2_strike_rate = innings_A_1_batting_player_8_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_8_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_8_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_8_innings_2_maiden_overs(String innings_A_1_bowling_player_8_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_8_innings_2_maiden_overs = innings_A_1_bowling_player_8_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_9_full_name() {
//        return innings_A_1_batting_player_9_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_9_full_name(String innings_A_1_batting_player_9_full_name) {
//        this.innings_A_1_batting_player_9_full_name = innings_A_1_batting_player_9_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_1_sixes() {
//        return innings_A_1_batting_player_9_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_1_sixes(String innings_A_1_batting_player_9_innings_1_sixes) {
//        this.innings_A_1_batting_player_9_innings_1_sixes = innings_A_1_batting_player_9_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_1_fours() {
//        return innings_A_1_batting_player_9_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_1_fours(String innings_A_1_batting_player_9_innings_1_fours) {
//        this.innings_A_1_batting_player_9_innings_1_fours = innings_A_1_batting_player_9_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_1_balls() {
//        return innings_A_1_batting_player_9_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_1_balls(String innings_A_1_batting_player_9_innings_1_balls) {
//        this.innings_A_1_batting_player_9_innings_1_balls = innings_A_1_batting_player_9_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_1_runs() {
//        return innings_A_1_batting_player_9_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_1_runs(String innings_A_1_batting_player_9_innings_1_runs) {
//        this.innings_A_1_batting_player_9_innings_1_runs = innings_A_1_batting_player_9_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_1_out_comment() {
//        return innings_A_1_batting_player_9_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_1_out_comment(String innings_A_1_batting_player_9_innings_1_out_comment) {
//        this.innings_A_1_batting_player_9_innings_1_out_comment = innings_A_1_batting_player_9_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_1_strike_rate() {
//        return innings_A_1_batting_player_9_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_1_strike_rate(String innings_A_1_batting_player_9_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_9_innings_1_strike_rate = innings_A_1_batting_player_9_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_9_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_9_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_9_innings_1_maiden_overs(String innings_A_1_bowling_player_9_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_9_innings_1_maiden_overs = innings_A_1_bowling_player_9_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_2_sixes() {
//        return innings_A_1_batting_player_9_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_2_sixes(String innings_A_1_batting_player_9_innings_2_sixes) {
//        this.innings_A_1_batting_player_9_innings_2_sixes = innings_A_1_batting_player_9_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_2_fours() {
//        return innings_A_1_batting_player_9_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_2_fours(String innings_A_1_batting_player_9_innings_2_fours) {
//        this.innings_A_1_batting_player_9_innings_2_fours = innings_A_1_batting_player_9_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_2_balls() {
//        return innings_A_1_batting_player_9_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_2_balls(String innings_A_1_batting_player_9_innings_2_balls) {
//        this.innings_A_1_batting_player_9_innings_2_balls = innings_A_1_batting_player_9_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_2_runs() {
//        return innings_A_1_batting_player_9_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_2_runs(String innings_A_1_batting_player_9_innings_2_runs) {
//        this.innings_A_1_batting_player_9_innings_2_runs = innings_A_1_batting_player_9_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_2_out_comment() {
//        return innings_A_1_batting_player_9_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_2_out_comment(String innings_A_1_batting_player_9_innings_2_out_comment) {
//        this.innings_A_1_batting_player_9_innings_2_out_comment = innings_A_1_batting_player_9_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_9_innings_2_strike_rate() {
//        return innings_A_1_batting_player_9_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_9_innings_2_strike_rate(String innings_A_1_batting_player_9_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_9_innings_2_strike_rate = innings_A_1_batting_player_9_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_9_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_9_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_9_innings_2_maiden_overs(String innings_A_1_bowling_player_9_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_9_innings_2_maiden_overs = innings_A_1_bowling_player_9_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_10_full_name() {
//        return innings_A_1_batting_player_10_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_10_full_name(String innings_A_1_batting_player_10_full_name) {
//        this.innings_A_1_batting_player_10_full_name = innings_A_1_batting_player_10_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_1_sixes() {
//        return innings_A_1_batting_player_10_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_1_sixes(String innings_A_1_batting_player_10_innings_1_sixes) {
//        this.innings_A_1_batting_player_10_innings_1_sixes = innings_A_1_batting_player_10_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_1_fours() {
//        return innings_A_1_batting_player_10_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_1_fours(String innings_A_1_batting_player_10_innings_1_fours) {
//        this.innings_A_1_batting_player_10_innings_1_fours = innings_A_1_batting_player_10_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_1_balls() {
//        return innings_A_1_batting_player_10_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_1_balls(String innings_A_1_batting_player_10_innings_1_balls) {
//        this.innings_A_1_batting_player_10_innings_1_balls = innings_A_1_batting_player_10_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_1_runs() {
//        return innings_A_1_batting_player_10_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_1_runs(String innings_A_1_batting_player_10_innings_1_runs) {
//        this.innings_A_1_batting_player_10_innings_1_runs = innings_A_1_batting_player_10_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_1_out_comment() {
//        return innings_A_1_batting_player_10_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_1_out_comment(String innings_A_1_batting_player_10_innings_1_out_comment) {
//        this.innings_A_1_batting_player_10_innings_1_out_comment = innings_A_1_batting_player_10_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_1_strike_rate() {
//        return innings_A_1_batting_player_10_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_1_strike_rate(String innings_A_1_batting_player_10_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_10_innings_1_strike_rate = innings_A_1_batting_player_10_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_10_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_10_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_10_innings_1_maiden_overs(String innings_A_1_bowling_player_10_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_10_innings_1_maiden_overs = innings_A_1_bowling_player_10_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_2_sixes() {
//        return innings_A_1_batting_player_10_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_2_sixes(String innings_A_1_batting_player_10_innings_2_sixes) {
//        this.innings_A_1_batting_player_10_innings_2_sixes = innings_A_1_batting_player_10_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_2_fours() {
//        return innings_A_1_batting_player_10_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_2_fours(String innings_A_1_batting_player_10_innings_2_fours) {
//        this.innings_A_1_batting_player_10_innings_2_fours = innings_A_1_batting_player_10_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_2_balls() {
//        return innings_A_1_batting_player_10_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_2_balls(String innings_A_1_batting_player_10_innings_2_balls) {
//        this.innings_A_1_batting_player_10_innings_2_balls = innings_A_1_batting_player_10_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_2_runs() {
//        return innings_A_1_batting_player_10_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_2_runs(String innings_A_1_batting_player_10_innings_2_runs) {
//        this.innings_A_1_batting_player_10_innings_2_runs = innings_A_1_batting_player_10_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_2_out_comment() {
//        return innings_A_1_batting_player_10_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_2_out_comment(String innings_A_1_batting_player_10_innings_2_out_comment) {
//        this.innings_A_1_batting_player_10_innings_2_out_comment = innings_A_1_batting_player_10_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_10_innings_2_strike_rate() {
//        return innings_A_1_batting_player_10_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_10_innings_2_strike_rate(String innings_A_1_batting_player_10_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_10_innings_2_strike_rate = innings_A_1_batting_player_10_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_10_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_10_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_10_innings_2_maiden_overs(String innings_A_1_bowling_player_10_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_10_innings_2_maiden_overs = innings_A_1_bowling_player_10_innings_2_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_11_full_name() {
//        return innings_A_1_batting_player_11_full_name;
//    }
//
//    public void setInnings_A_1_batting_player_11_full_name(String innings_A_1_batting_player_11_full_name) {
//        this.innings_A_1_batting_player_11_full_name = innings_A_1_batting_player_11_full_name;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_1_sixes() {
//        return innings_A_1_batting_player_11_innings_1_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_1_sixes(String innings_A_1_batting_player_11_innings_1_sixes) {
//        this.innings_A_1_batting_player_11_innings_1_sixes = innings_A_1_batting_player_11_innings_1_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_1_fours() {
//        return innings_A_1_batting_player_11_innings_1_fours;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_1_fours(String innings_A_1_batting_player_11_innings_1_fours) {
//        this.innings_A_1_batting_player_11_innings_1_fours = innings_A_1_batting_player_11_innings_1_fours;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_1_balls() {
//        return innings_A_1_batting_player_11_innings_1_balls;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_1_balls(String innings_A_1_batting_player_11_innings_1_balls) {
//        this.innings_A_1_batting_player_11_innings_1_balls = innings_A_1_batting_player_11_innings_1_balls;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_1_runs() {
//        return innings_A_1_batting_player_11_innings_1_runs;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_1_runs(String innings_A_1_batting_player_11_innings_1_runs) {
//        this.innings_A_1_batting_player_11_innings_1_runs = innings_A_1_batting_player_11_innings_1_runs;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_1_out_comment() {
//        return innings_A_1_batting_player_11_innings_1_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_1_out_comment(String innings_A_1_batting_player_11_innings_1_out_comment) {
//        this.innings_A_1_batting_player_11_innings_1_out_comment = innings_A_1_batting_player_11_innings_1_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_1_strike_rate() {
//        return innings_A_1_batting_player_11_innings_1_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_1_strike_rate(String innings_A_1_batting_player_11_innings_1_strike_rate) {
//        this.innings_A_1_batting_player_11_innings_1_strike_rate = innings_A_1_batting_player_11_innings_1_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_11_innings_1_maiden_overs() {
//        return innings_A_1_bowling_player_11_innings_1_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_11_innings_1_maiden_overs(String innings_A_1_bowling_player_11_innings_1_maiden_overs) {
//        this.innings_A_1_bowling_player_11_innings_1_maiden_overs = innings_A_1_bowling_player_11_innings_1_maiden_overs;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_2_sixes() {
//        return innings_A_1_batting_player_11_innings_2_sixes;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_2_sixes(String innings_A_1_batting_player_11_innings_2_sixes) {
//        this.innings_A_1_batting_player_11_innings_2_sixes = innings_A_1_batting_player_11_innings_2_sixes;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_2_fours() {
//        return innings_A_1_batting_player_11_innings_2_fours;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_2_fours(String innings_A_1_batting_player_11_innings_2_fours) {
//        this.innings_A_1_batting_player_11_innings_2_fours = innings_A_1_batting_player_11_innings_2_fours;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_2_balls() {
//        return innings_A_1_batting_player_11_innings_2_balls;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_2_balls(String innings_A_1_batting_player_11_innings_2_balls) {
//        this.innings_A_1_batting_player_11_innings_2_balls = innings_A_1_batting_player_11_innings_2_balls;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_2_runs() {
//        return innings_A_1_batting_player_11_innings_2_runs;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_2_runs(String innings_A_1_batting_player_11_innings_2_runs) {
//        this.innings_A_1_batting_player_11_innings_2_runs = innings_A_1_batting_player_11_innings_2_runs;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_2_out_comment() {
//        return innings_A_1_batting_player_11_innings_2_out_comment;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_2_out_comment(String innings_A_1_batting_player_11_innings_2_out_comment) {
//        this.innings_A_1_batting_player_11_innings_2_out_comment = innings_A_1_batting_player_11_innings_2_out_comment;
//    }
//
//    public String getInnings_A_1_batting_player_11_innings_2_strike_rate() {
//        return innings_A_1_batting_player_11_innings_2_strike_rate;
//    }
//
//    public void setInnings_A_1_batting_player_11_innings_2_strike_rate(String innings_A_1_batting_player_11_innings_2_strike_rate) {
//        this.innings_A_1_batting_player_11_innings_2_strike_rate = innings_A_1_batting_player_11_innings_2_strike_rate;
//    }
//
//    public String getInnings_A_1_bowling_player_11_innings_2_maiden_overs() {
//        return innings_A_1_bowling_player_11_innings_2_maiden_overs;
//    }
//
//    public void setInnings_A_1_bowling_player_11_innings_2_maiden_overs(String innings_A_1_bowling_player_11_innings_2_maiden_overs) {
//        this.innings_A_1_bowling_player_11_innings_2_maiden_overs = innings_A_1_bowling_player_11_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_1_full_name() {
//        return innings_B_1_batting_player_1_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_1_full_name(String innings_B_1_batting_player_1_full_name) {
//        this.innings_B_1_batting_player_1_full_name = innings_B_1_batting_player_1_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_1_sixes() {
//        return innings_B_1_batting_player_1_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_1_sixes(String innings_B_1_batting_player_1_innings_1_sixes) {
//        this.innings_B_1_batting_player_1_innings_1_sixes = innings_B_1_batting_player_1_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_1_fours() {
//        return innings_B_1_batting_player_1_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_1_fours(String innings_B_1_batting_player_1_innings_1_fours) {
//        this.innings_B_1_batting_player_1_innings_1_fours = innings_B_1_batting_player_1_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_1_balls() {
//        return innings_B_1_batting_player_1_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_1_balls(String innings_B_1_batting_player_1_innings_1_balls) {
//        this.innings_B_1_batting_player_1_innings_1_balls = innings_B_1_batting_player_1_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_1_runs() {
//        return innings_B_1_batting_player_1_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_1_runs(String innings_B_1_batting_player_1_innings_1_runs) {
//        this.innings_B_1_batting_player_1_innings_1_runs = innings_B_1_batting_player_1_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_1_out_comment() {
//        return innings_B_1_batting_player_1_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_1_out_comment(String innings_B_1_batting_player_1_innings_1_out_comment) {
//        this.innings_B_1_batting_player_1_innings_1_out_comment = innings_B_1_batting_player_1_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_1_strike_rate() {
//        return innings_B_1_batting_player_1_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_1_strike_rate(String innings_B_1_batting_player_1_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_1_innings_1_strike_rate = innings_B_1_batting_player_1_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_1_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_1_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_1_innings_1_maiden_overs(String innings_B_1_bowling_player_1_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_1_innings_1_maiden_overs = innings_B_1_bowling_player_1_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_2_sixes() {
//        return innings_B_1_batting_player_1_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_2_sixes(String innings_B_1_batting_player_1_innings_2_sixes) {
//        this.innings_B_1_batting_player_1_innings_2_sixes = innings_B_1_batting_player_1_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_2_fours() {
//        return innings_B_1_batting_player_1_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_2_fours(String innings_B_1_batting_player_1_innings_2_fours) {
//        this.innings_B_1_batting_player_1_innings_2_fours = innings_B_1_batting_player_1_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_2_balls() {
//        return innings_B_1_batting_player_1_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_2_balls(String innings_B_1_batting_player_1_innings_2_balls) {
//        this.innings_B_1_batting_player_1_innings_2_balls = innings_B_1_batting_player_1_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_2_runs() {
//        return innings_B_1_batting_player_1_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_2_runs(String innings_B_1_batting_player_1_innings_2_runs) {
//        this.innings_B_1_batting_player_1_innings_2_runs = innings_B_1_batting_player_1_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_2_out_comment() {
//        return innings_B_1_batting_player_1_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_2_out_comment(String innings_B_1_batting_player_1_innings_2_out_comment) {
//        this.innings_B_1_batting_player_1_innings_2_out_comment = innings_B_1_batting_player_1_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_1_innings_2_strike_rate() {
//        return innings_B_1_batting_player_1_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_1_innings_2_strike_rate(String innings_B_1_batting_player_1_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_1_innings_2_strike_rate = innings_B_1_batting_player_1_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_1_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_1_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_1_innings_2_maiden_overs(String innings_B_1_bowling_player_1_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_1_innings_2_maiden_overs = innings_B_1_bowling_player_1_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_2_full_name() {
//        return innings_B_1_batting_player_2_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_2_full_name(String innings_B_1_batting_player_2_full_name) {
//        this.innings_B_1_batting_player_2_full_name = innings_B_1_batting_player_2_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_1_sixes() {
//        return innings_B_1_batting_player_2_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_1_sixes(String innings_B_1_batting_player_2_innings_1_sixes) {
//        this.innings_B_1_batting_player_2_innings_1_sixes = innings_B_1_batting_player_2_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_1_fours() {
//        return innings_B_1_batting_player_2_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_1_fours(String innings_B_1_batting_player_2_innings_1_fours) {
//        this.innings_B_1_batting_player_2_innings_1_fours = innings_B_1_batting_player_2_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_1_balls() {
//        return innings_B_1_batting_player_2_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_1_balls(String innings_B_1_batting_player_2_innings_1_balls) {
//        this.innings_B_1_batting_player_2_innings_1_balls = innings_B_1_batting_player_2_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_1_runs() {
//        return innings_B_1_batting_player_2_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_1_runs(String innings_B_1_batting_player_2_innings_1_runs) {
//        this.innings_B_1_batting_player_2_innings_1_runs = innings_B_1_batting_player_2_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_1_out_comment() {
//        return innings_B_1_batting_player_2_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_1_out_comment(String innings_B_1_batting_player_2_innings_1_out_comment) {
//        this.innings_B_1_batting_player_2_innings_1_out_comment = innings_B_1_batting_player_2_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_1_strike_rate() {
//        return innings_B_1_batting_player_2_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_1_strike_rate(String innings_B_1_batting_player_2_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_2_innings_1_strike_rate = innings_B_1_batting_player_2_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_2_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_2_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_2_innings_1_maiden_overs(String innings_B_1_bowling_player_2_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_2_innings_1_maiden_overs = innings_B_1_bowling_player_2_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_2_sixes() {
//        return innings_B_1_batting_player_2_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_2_sixes(String innings_B_1_batting_player_2_innings_2_sixes) {
//        this.innings_B_1_batting_player_2_innings_2_sixes = innings_B_1_batting_player_2_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_2_fours() {
//        return innings_B_1_batting_player_2_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_2_fours(String innings_B_1_batting_player_2_innings_2_fours) {
//        this.innings_B_1_batting_player_2_innings_2_fours = innings_B_1_batting_player_2_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_2_balls() {
//        return innings_B_1_batting_player_2_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_2_balls(String innings_B_1_batting_player_2_innings_2_balls) {
//        this.innings_B_1_batting_player_2_innings_2_balls = innings_B_1_batting_player_2_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_2_runs() {
//        return innings_B_1_batting_player_2_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_2_runs(String innings_B_1_batting_player_2_innings_2_runs) {
//        this.innings_B_1_batting_player_2_innings_2_runs = innings_B_1_batting_player_2_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_2_out_comment() {
//        return innings_B_1_batting_player_2_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_2_out_comment(String innings_B_1_batting_player_2_innings_2_out_comment) {
//        this.innings_B_1_batting_player_2_innings_2_out_comment = innings_B_1_batting_player_2_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_2_innings_2_strike_rate() {
//        return innings_B_1_batting_player_2_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_2_innings_2_strike_rate(String innings_B_1_batting_player_2_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_2_innings_2_strike_rate = innings_B_1_batting_player_2_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_2_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_2_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_2_innings_2_maiden_overs(String innings_B_1_bowling_player_2_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_2_innings_2_maiden_overs = innings_B_1_bowling_player_2_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_3_full_name() {
//        return innings_B_1_batting_player_3_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_3_full_name(String innings_B_1_batting_player_3_full_name) {
//        this.innings_B_1_batting_player_3_full_name = innings_B_1_batting_player_3_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_1_sixes() {
//        return innings_B_1_batting_player_3_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_1_sixes(String innings_B_1_batting_player_3_innings_1_sixes) {
//        this.innings_B_1_batting_player_3_innings_1_sixes = innings_B_1_batting_player_3_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_1_fours() {
//        return innings_B_1_batting_player_3_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_1_fours(String innings_B_1_batting_player_3_innings_1_fours) {
//        this.innings_B_1_batting_player_3_innings_1_fours = innings_B_1_batting_player_3_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_1_balls() {
//        return innings_B_1_batting_player_3_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_1_balls(String innings_B_1_batting_player_3_innings_1_balls) {
//        this.innings_B_1_batting_player_3_innings_1_balls = innings_B_1_batting_player_3_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_1_runs() {
//        return innings_B_1_batting_player_3_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_1_runs(String innings_B_1_batting_player_3_innings_1_runs) {
//        this.innings_B_1_batting_player_3_innings_1_runs = innings_B_1_batting_player_3_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_1_out_comment() {
//        return innings_B_1_batting_player_3_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_1_out_comment(String innings_B_1_batting_player_3_innings_1_out_comment) {
//        this.innings_B_1_batting_player_3_innings_1_out_comment = innings_B_1_batting_player_3_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_1_strike_rate() {
//        return innings_B_1_batting_player_3_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_1_strike_rate(String innings_B_1_batting_player_3_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_3_innings_1_strike_rate = innings_B_1_batting_player_3_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_3_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_3_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_3_innings_1_maiden_overs(String innings_B_1_bowling_player_3_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_3_innings_1_maiden_overs = innings_B_1_bowling_player_3_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_2_sixes() {
//        return innings_B_1_batting_player_3_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_2_sixes(String innings_B_1_batting_player_3_innings_2_sixes) {
//        this.innings_B_1_batting_player_3_innings_2_sixes = innings_B_1_batting_player_3_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_2_fours() {
//        return innings_B_1_batting_player_3_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_2_fours(String innings_B_1_batting_player_3_innings_2_fours) {
//        this.innings_B_1_batting_player_3_innings_2_fours = innings_B_1_batting_player_3_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_2_balls() {
//        return innings_B_1_batting_player_3_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_2_balls(String innings_B_1_batting_player_3_innings_2_balls) {
//        this.innings_B_1_batting_player_3_innings_2_balls = innings_B_1_batting_player_3_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_2_runs() {
//        return innings_B_1_batting_player_3_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_2_runs(String innings_B_1_batting_player_3_innings_2_runs) {
//        this.innings_B_1_batting_player_3_innings_2_runs = innings_B_1_batting_player_3_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_2_out_comment() {
//        return innings_B_1_batting_player_3_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_2_out_comment(String innings_B_1_batting_player_3_innings_2_out_comment) {
//        this.innings_B_1_batting_player_3_innings_2_out_comment = innings_B_1_batting_player_3_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_3_innings_2_strike_rate() {
//        return innings_B_1_batting_player_3_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_3_innings_2_strike_rate(String innings_B_1_batting_player_3_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_3_innings_2_strike_rate = innings_B_1_batting_player_3_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_3_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_3_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_3_innings_2_maiden_overs(String innings_B_1_bowling_player_3_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_3_innings_2_maiden_overs = innings_B_1_bowling_player_3_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_4_full_name() {
//        return innings_B_1_batting_player_4_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_4_full_name(String innings_B_1_batting_player_4_full_name) {
//        this.innings_B_1_batting_player_4_full_name = innings_B_1_batting_player_4_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_1_sixes() {
//        return innings_B_1_batting_player_4_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_1_sixes(String innings_B_1_batting_player_4_innings_1_sixes) {
//        this.innings_B_1_batting_player_4_innings_1_sixes = innings_B_1_batting_player_4_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_1_fours() {
//        return innings_B_1_batting_player_4_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_1_fours(String innings_B_1_batting_player_4_innings_1_fours) {
//        this.innings_B_1_batting_player_4_innings_1_fours = innings_B_1_batting_player_4_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_1_balls() {
//        return innings_B_1_batting_player_4_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_1_balls(String innings_B_1_batting_player_4_innings_1_balls) {
//        this.innings_B_1_batting_player_4_innings_1_balls = innings_B_1_batting_player_4_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_1_runs() {
//        return innings_B_1_batting_player_4_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_1_runs(String innings_B_1_batting_player_4_innings_1_runs) {
//        this.innings_B_1_batting_player_4_innings_1_runs = innings_B_1_batting_player_4_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_1_out_comment() {
//        return innings_B_1_batting_player_4_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_1_out_comment(String innings_B_1_batting_player_4_innings_1_out_comment) {
//        this.innings_B_1_batting_player_4_innings_1_out_comment = innings_B_1_batting_player_4_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_1_strike_rate() {
//        return innings_B_1_batting_player_4_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_1_strike_rate(String innings_B_1_batting_player_4_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_4_innings_1_strike_rate = innings_B_1_batting_player_4_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_4_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_4_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_4_innings_1_maiden_overs(String innings_B_1_bowling_player_4_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_4_innings_1_maiden_overs = innings_B_1_bowling_player_4_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_2_sixes() {
//        return innings_B_1_batting_player_4_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_2_sixes(String innings_B_1_batting_player_4_innings_2_sixes) {
//        this.innings_B_1_batting_player_4_innings_2_sixes = innings_B_1_batting_player_4_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_2_fours() {
//        return innings_B_1_batting_player_4_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_2_fours(String innings_B_1_batting_player_4_innings_2_fours) {
//        this.innings_B_1_batting_player_4_innings_2_fours = innings_B_1_batting_player_4_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_2_balls() {
//        return innings_B_1_batting_player_4_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_2_balls(String innings_B_1_batting_player_4_innings_2_balls) {
//        this.innings_B_1_batting_player_4_innings_2_balls = innings_B_1_batting_player_4_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_2_runs() {
//        return innings_B_1_batting_player_4_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_2_runs(String innings_B_1_batting_player_4_innings_2_runs) {
//        this.innings_B_1_batting_player_4_innings_2_runs = innings_B_1_batting_player_4_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_2_out_comment() {
//        return innings_B_1_batting_player_4_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_2_out_comment(String innings_B_1_batting_player_4_innings_2_out_comment) {
//        this.innings_B_1_batting_player_4_innings_2_out_comment = innings_B_1_batting_player_4_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_4_innings_2_strike_rate() {
//        return innings_B_1_batting_player_4_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_4_innings_2_strike_rate(String innings_B_1_batting_player_4_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_4_innings_2_strike_rate = innings_B_1_batting_player_4_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_4_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_4_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_4_innings_2_maiden_overs(String innings_B_1_bowling_player_4_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_4_innings_2_maiden_overs = innings_B_1_bowling_player_4_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_5_full_name() {
//        return innings_B_1_batting_player_5_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_5_full_name(String innings_B_1_batting_player_5_full_name) {
//        this.innings_B_1_batting_player_5_full_name = innings_B_1_batting_player_5_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_1_sixes() {
//        return innings_B_1_batting_player_5_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_1_sixes(String innings_B_1_batting_player_5_innings_1_sixes) {
//        this.innings_B_1_batting_player_5_innings_1_sixes = innings_B_1_batting_player_5_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_1_fours() {
//        return innings_B_1_batting_player_5_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_1_fours(String innings_B_1_batting_player_5_innings_1_fours) {
//        this.innings_B_1_batting_player_5_innings_1_fours = innings_B_1_batting_player_5_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_1_balls() {
//        return innings_B_1_batting_player_5_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_1_balls(String innings_B_1_batting_player_5_innings_1_balls) {
//        this.innings_B_1_batting_player_5_innings_1_balls = innings_B_1_batting_player_5_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_1_runs() {
//        return innings_B_1_batting_player_5_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_1_runs(String innings_B_1_batting_player_5_innings_1_runs) {
//        this.innings_B_1_batting_player_5_innings_1_runs = innings_B_1_batting_player_5_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_1_out_comment() {
//        return innings_B_1_batting_player_5_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_1_out_comment(String innings_B_1_batting_player_5_innings_1_out_comment) {
//        this.innings_B_1_batting_player_5_innings_1_out_comment = innings_B_1_batting_player_5_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_1_strike_rate() {
//        return innings_B_1_batting_player_5_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_1_strike_rate(String innings_B_1_batting_player_5_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_5_innings_1_strike_rate = innings_B_1_batting_player_5_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_5_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_5_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_5_innings_1_maiden_overs(String innings_B_1_bowling_player_5_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_5_innings_1_maiden_overs = innings_B_1_bowling_player_5_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_2_sixes() {
//        return innings_B_1_batting_player_5_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_2_sixes(String innings_B_1_batting_player_5_innings_2_sixes) {
//        this.innings_B_1_batting_player_5_innings_2_sixes = innings_B_1_batting_player_5_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_2_fours() {
//        return innings_B_1_batting_player_5_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_2_fours(String innings_B_1_batting_player_5_innings_2_fours) {
//        this.innings_B_1_batting_player_5_innings_2_fours = innings_B_1_batting_player_5_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_2_balls() {
//        return innings_B_1_batting_player_5_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_2_balls(String innings_B_1_batting_player_5_innings_2_balls) {
//        this.innings_B_1_batting_player_5_innings_2_balls = innings_B_1_batting_player_5_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_2_runs() {
//        return innings_B_1_batting_player_5_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_2_runs(String innings_B_1_batting_player_5_innings_2_runs) {
//        this.innings_B_1_batting_player_5_innings_2_runs = innings_B_1_batting_player_5_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_2_out_comment() {
//        return innings_B_1_batting_player_5_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_2_out_comment(String innings_B_1_batting_player_5_innings_2_out_comment) {
//        this.innings_B_1_batting_player_5_innings_2_out_comment = innings_B_1_batting_player_5_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_5_innings_2_strike_rate() {
//        return innings_B_1_batting_player_5_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_5_innings_2_strike_rate(String innings_B_1_batting_player_5_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_5_innings_2_strike_rate = innings_B_1_batting_player_5_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_5_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_5_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_5_innings_2_maiden_overs(String innings_B_1_bowling_player_5_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_5_innings_2_maiden_overs = innings_B_1_bowling_player_5_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_6_full_name() {
//        return innings_B_1_batting_player_6_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_6_full_name(String innings_B_1_batting_player_6_full_name) {
//        this.innings_B_1_batting_player_6_full_name = innings_B_1_batting_player_6_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_1_sixes() {
//        return innings_B_1_batting_player_6_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_1_sixes(String innings_B_1_batting_player_6_innings_1_sixes) {
//        this.innings_B_1_batting_player_6_innings_1_sixes = innings_B_1_batting_player_6_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_1_fours() {
//        return innings_B_1_batting_player_6_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_1_fours(String innings_B_1_batting_player_6_innings_1_fours) {
//        this.innings_B_1_batting_player_6_innings_1_fours = innings_B_1_batting_player_6_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_1_balls() {
//        return innings_B_1_batting_player_6_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_1_balls(String innings_B_1_batting_player_6_innings_1_balls) {
//        this.innings_B_1_batting_player_6_innings_1_balls = innings_B_1_batting_player_6_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_1_runs() {
//        return innings_B_1_batting_player_6_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_1_runs(String innings_B_1_batting_player_6_innings_1_runs) {
//        this.innings_B_1_batting_player_6_innings_1_runs = innings_B_1_batting_player_6_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_1_out_comment() {
//        return innings_B_1_batting_player_6_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_1_out_comment(String innings_B_1_batting_player_6_innings_1_out_comment) {
//        this.innings_B_1_batting_player_6_innings_1_out_comment = innings_B_1_batting_player_6_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_1_strike_rate() {
//        return innings_B_1_batting_player_6_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_1_strike_rate(String innings_B_1_batting_player_6_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_6_innings_1_strike_rate = innings_B_1_batting_player_6_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_6_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_6_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_6_innings_1_maiden_overs(String innings_B_1_bowling_player_6_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_6_innings_1_maiden_overs = innings_B_1_bowling_player_6_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_2_sixes() {
//        return innings_B_1_batting_player_6_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_2_sixes(String innings_B_1_batting_player_6_innings_2_sixes) {
//        this.innings_B_1_batting_player_6_innings_2_sixes = innings_B_1_batting_player_6_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_2_fours() {
//        return innings_B_1_batting_player_6_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_2_fours(String innings_B_1_batting_player_6_innings_2_fours) {
//        this.innings_B_1_batting_player_6_innings_2_fours = innings_B_1_batting_player_6_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_2_balls() {
//        return innings_B_1_batting_player_6_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_2_balls(String innings_B_1_batting_player_6_innings_2_balls) {
//        this.innings_B_1_batting_player_6_innings_2_balls = innings_B_1_batting_player_6_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_2_runs() {
//        return innings_B_1_batting_player_6_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_2_runs(String innings_B_1_batting_player_6_innings_2_runs) {
//        this.innings_B_1_batting_player_6_innings_2_runs = innings_B_1_batting_player_6_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_2_out_comment() {
//        return innings_B_1_batting_player_6_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_2_out_comment(String innings_B_1_batting_player_6_innings_2_out_comment) {
//        this.innings_B_1_batting_player_6_innings_2_out_comment = innings_B_1_batting_player_6_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_6_innings_2_strike_rate() {
//        return innings_B_1_batting_player_6_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_6_innings_2_strike_rate(String innings_B_1_batting_player_6_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_6_innings_2_strike_rate = innings_B_1_batting_player_6_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_6_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_6_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_6_innings_2_maiden_overs(String innings_B_1_bowling_player_6_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_6_innings_2_maiden_overs = innings_B_1_bowling_player_6_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_7_full_name() {
//        return innings_B_1_batting_player_7_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_7_full_name(String innings_B_1_batting_player_7_full_name) {
//        this.innings_B_1_batting_player_7_full_name = innings_B_1_batting_player_7_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_1_sixes() {
//        return innings_B_1_batting_player_7_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_1_sixes(String innings_B_1_batting_player_7_innings_1_sixes) {
//        this.innings_B_1_batting_player_7_innings_1_sixes = innings_B_1_batting_player_7_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_1_fours() {
//        return innings_B_1_batting_player_7_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_1_fours(String innings_B_1_batting_player_7_innings_1_fours) {
//        this.innings_B_1_batting_player_7_innings_1_fours = innings_B_1_batting_player_7_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_1_balls() {
//        return innings_B_1_batting_player_7_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_1_balls(String innings_B_1_batting_player_7_innings_1_balls) {
//        this.innings_B_1_batting_player_7_innings_1_balls = innings_B_1_batting_player_7_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_1_runs() {
//        return innings_B_1_batting_player_7_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_1_runs(String innings_B_1_batting_player_7_innings_1_runs) {
//        this.innings_B_1_batting_player_7_innings_1_runs = innings_B_1_batting_player_7_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_1_out_comment() {
//        return innings_B_1_batting_player_7_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_1_out_comment(String innings_B_1_batting_player_7_innings_1_out_comment) {
//        this.innings_B_1_batting_player_7_innings_1_out_comment = innings_B_1_batting_player_7_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_1_strike_rate() {
//        return innings_B_1_batting_player_7_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_1_strike_rate(String innings_B_1_batting_player_7_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_7_innings_1_strike_rate = innings_B_1_batting_player_7_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_7_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_7_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_7_innings_1_maiden_overs(String innings_B_1_bowling_player_7_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_7_innings_1_maiden_overs = innings_B_1_bowling_player_7_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_2_sixes() {
//        return innings_B_1_batting_player_7_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_2_sixes(String innings_B_1_batting_player_7_innings_2_sixes) {
//        this.innings_B_1_batting_player_7_innings_2_sixes = innings_B_1_batting_player_7_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_2_fours() {
//        return innings_B_1_batting_player_7_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_2_fours(String innings_B_1_batting_player_7_innings_2_fours) {
//        this.innings_B_1_batting_player_7_innings_2_fours = innings_B_1_batting_player_7_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_2_balls() {
//        return innings_B_1_batting_player_7_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_2_balls(String innings_B_1_batting_player_7_innings_2_balls) {
//        this.innings_B_1_batting_player_7_innings_2_balls = innings_B_1_batting_player_7_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_2_runs() {
//        return innings_B_1_batting_player_7_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_2_runs(String innings_B_1_batting_player_7_innings_2_runs) {
//        this.innings_B_1_batting_player_7_innings_2_runs = innings_B_1_batting_player_7_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_2_out_comment() {
//        return innings_B_1_batting_player_7_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_2_out_comment(String innings_B_1_batting_player_7_innings_2_out_comment) {
//        this.innings_B_1_batting_player_7_innings_2_out_comment = innings_B_1_batting_player_7_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_7_innings_2_strike_rate() {
//        return innings_B_1_batting_player_7_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_7_innings_2_strike_rate(String innings_B_1_batting_player_7_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_7_innings_2_strike_rate = innings_B_1_batting_player_7_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_7_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_7_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_7_innings_2_maiden_overs(String innings_B_1_bowling_player_7_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_7_innings_2_maiden_overs = innings_B_1_bowling_player_7_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_8_full_name() {
//        return innings_B_1_batting_player_8_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_8_full_name(String innings_B_1_batting_player_8_full_name) {
//        this.innings_B_1_batting_player_8_full_name = innings_B_1_batting_player_8_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_1_sixes() {
//        return innings_B_1_batting_player_8_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_1_sixes(String innings_B_1_batting_player_8_innings_1_sixes) {
//        this.innings_B_1_batting_player_8_innings_1_sixes = innings_B_1_batting_player_8_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_1_fours() {
//        return innings_B_1_batting_player_8_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_1_fours(String innings_B_1_batting_player_8_innings_1_fours) {
//        this.innings_B_1_batting_player_8_innings_1_fours = innings_B_1_batting_player_8_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_1_balls() {
//        return innings_B_1_batting_player_8_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_1_balls(String innings_B_1_batting_player_8_innings_1_balls) {
//        this.innings_B_1_batting_player_8_innings_1_balls = innings_B_1_batting_player_8_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_1_runs() {
//        return innings_B_1_batting_player_8_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_1_runs(String innings_B_1_batting_player_8_innings_1_runs) {
//        this.innings_B_1_batting_player_8_innings_1_runs = innings_B_1_batting_player_8_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_1_strike_rate() {
//        return innings_B_1_batting_player_8_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_1_strike_rate(String innings_B_1_batting_player_8_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_8_innings_1_strike_rate = innings_B_1_batting_player_8_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_1_out_comment() {
//        return innings_B_1_batting_player_8_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_1_out_comment(String innings_B_1_batting_player_8_innings_1_out_comment) {
//        this.innings_B_1_batting_player_8_innings_1_out_comment = innings_B_1_batting_player_8_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_bowling_player_8_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_8_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_8_innings_1_maiden_overs(String innings_B_1_bowling_player_8_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_8_innings_1_maiden_overs = innings_B_1_bowling_player_8_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_2_sixes() {
//        return innings_B_1_batting_player_8_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_2_sixes(String innings_B_1_batting_player_8_innings_2_sixes) {
//        this.innings_B_1_batting_player_8_innings_2_sixes = innings_B_1_batting_player_8_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_2_fours() {
//        return innings_B_1_batting_player_8_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_2_fours(String innings_B_1_batting_player_8_innings_2_fours) {
//        this.innings_B_1_batting_player_8_innings_2_fours = innings_B_1_batting_player_8_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_2_balls() {
//        return innings_B_1_batting_player_8_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_2_balls(String innings_B_1_batting_player_8_innings_2_balls) {
//        this.innings_B_1_batting_player_8_innings_2_balls = innings_B_1_batting_player_8_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_2_runs() {
//        return innings_B_1_batting_player_8_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_2_runs(String innings_B_1_batting_player_8_innings_2_runs) {
//        this.innings_B_1_batting_player_8_innings_2_runs = innings_B_1_batting_player_8_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_2_strike_rate() {
//        return innings_B_1_batting_player_8_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_2_strike_rate(String innings_B_1_batting_player_8_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_8_innings_2_strike_rate = innings_B_1_batting_player_8_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_batting_player_8_innings_2_out_comment() {
//        return innings_B_1_batting_player_8_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_8_innings_2_out_comment(String innings_B_1_batting_player_8_innings_2_out_comment) {
//        this.innings_B_1_batting_player_8_innings_2_out_comment = innings_B_1_batting_player_8_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_bowling_player_8_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_8_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_8_innings_2_maiden_overs(String innings_B_1_bowling_player_8_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_8_innings_2_maiden_overs = innings_B_1_bowling_player_8_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_9_full_name() {
//        return innings_B_1_batting_player_9_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_9_full_name(String innings_B_1_batting_player_9_full_name) {
//        this.innings_B_1_batting_player_9_full_name = innings_B_1_batting_player_9_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_1_sixes() {
//        return innings_B_1_batting_player_9_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_1_sixes(String innings_B_1_batting_player_9_innings_1_sixes) {
//        this.innings_B_1_batting_player_9_innings_1_sixes = innings_B_1_batting_player_9_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_1_fours() {
//        return innings_B_1_batting_player_9_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_1_fours(String innings_B_1_batting_player_9_innings_1_fours) {
//        this.innings_B_1_batting_player_9_innings_1_fours = innings_B_1_batting_player_9_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_1_balls() {
//        return innings_B_1_batting_player_9_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_1_balls(String innings_B_1_batting_player_9_innings_1_balls) {
//        this.innings_B_1_batting_player_9_innings_1_balls = innings_B_1_batting_player_9_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_1_runs() {
//        return innings_B_1_batting_player_9_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_1_runs(String innings_B_1_batting_player_9_innings_1_runs) {
//        this.innings_B_1_batting_player_9_innings_1_runs = innings_B_1_batting_player_9_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_1_out_comment() {
//        return innings_B_1_batting_player_9_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_1_out_comment(String innings_B_1_batting_player_9_innings_1_out_comment) {
//        this.innings_B_1_batting_player_9_innings_1_out_comment = innings_B_1_batting_player_9_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_1_strike_rate() {
//        return innings_B_1_batting_player_9_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_1_strike_rate(String innings_B_1_batting_player_9_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_9_innings_1_strike_rate = innings_B_1_batting_player_9_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_9_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_9_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_9_innings_1_maiden_overs(String innings_B_1_bowling_player_9_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_9_innings_1_maiden_overs = innings_B_1_bowling_player_9_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_2_sixes() {
//        return innings_B_1_batting_player_9_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_2_sixes(String innings_B_1_batting_player_9_innings_2_sixes) {
//        this.innings_B_1_batting_player_9_innings_2_sixes = innings_B_1_batting_player_9_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_2_fours() {
//        return innings_B_1_batting_player_9_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_2_fours(String innings_B_1_batting_player_9_innings_2_fours) {
//        this.innings_B_1_batting_player_9_innings_2_fours = innings_B_1_batting_player_9_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_2_balls() {
//        return innings_B_1_batting_player_9_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_2_balls(String innings_B_1_batting_player_9_innings_2_balls) {
//        this.innings_B_1_batting_player_9_innings_2_balls = innings_B_1_batting_player_9_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_2_runs() {
//        return innings_B_1_batting_player_9_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_2_runs(String innings_B_1_batting_player_9_innings_2_runs) {
//        this.innings_B_1_batting_player_9_innings_2_runs = innings_B_1_batting_player_9_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_2_out_comment() {
//        return innings_B_1_batting_player_9_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_2_out_comment(String innings_B_1_batting_player_9_innings_2_out_comment) {
//        this.innings_B_1_batting_player_9_innings_2_out_comment = innings_B_1_batting_player_9_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_9_innings_2_strike_rate() {
//        return innings_B_1_batting_player_9_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_9_innings_2_strike_rate(String innings_B_1_batting_player_9_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_9_innings_2_strike_rate = innings_B_1_batting_player_9_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_9_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_9_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_9_innings_2_maiden_overs(String innings_B_1_bowling_player_9_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_9_innings_2_maiden_overs = innings_B_1_bowling_player_9_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_10_full_name() {
//        return innings_B_1_batting_player_10_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_10_full_name(String innings_B_1_batting_player_10_full_name) {
//        this.innings_B_1_batting_player_10_full_name = innings_B_1_batting_player_10_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_1_sixes() {
//        return innings_B_1_batting_player_10_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_1_sixes(String innings_B_1_batting_player_10_innings_1_sixes) {
//        this.innings_B_1_batting_player_10_innings_1_sixes = innings_B_1_batting_player_10_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_1_fours() {
//        return innings_B_1_batting_player_10_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_1_fours(String innings_B_1_batting_player_10_innings_1_fours) {
//        this.innings_B_1_batting_player_10_innings_1_fours = innings_B_1_batting_player_10_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_1_balls() {
//        return innings_B_1_batting_player_10_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_1_balls(String innings_B_1_batting_player_10_innings_1_balls) {
//        this.innings_B_1_batting_player_10_innings_1_balls = innings_B_1_batting_player_10_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_1_runs() {
//        return innings_B_1_batting_player_10_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_1_runs(String innings_B_1_batting_player_10_innings_1_runs) {
//        this.innings_B_1_batting_player_10_innings_1_runs = innings_B_1_batting_player_10_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_1_out_comment() {
//        return innings_B_1_batting_player_10_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_1_out_comment(String innings_B_1_batting_player_10_innings_1_out_comment) {
//        this.innings_B_1_batting_player_10_innings_1_out_comment = innings_B_1_batting_player_10_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_1_strike_rate() {
//        return innings_B_1_batting_player_10_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_1_strike_rate(String innings_B_1_batting_player_10_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_10_innings_1_strike_rate = innings_B_1_batting_player_10_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_10_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_10_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_10_innings_1_maiden_overs(String innings_B_1_bowling_player_10_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_10_innings_1_maiden_overs = innings_B_1_bowling_player_10_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_2_sixes() {
//        return innings_B_1_batting_player_10_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_2_sixes(String innings_B_1_batting_player_10_innings_2_sixes) {
//        this.innings_B_1_batting_player_10_innings_2_sixes = innings_B_1_batting_player_10_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_2_fours() {
//        return innings_B_1_batting_player_10_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_2_fours(String innings_B_1_batting_player_10_innings_2_fours) {
//        this.innings_B_1_batting_player_10_innings_2_fours = innings_B_1_batting_player_10_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_2_balls() {
//        return innings_B_1_batting_player_10_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_2_balls(String innings_B_1_batting_player_10_innings_2_balls) {
//        this.innings_B_1_batting_player_10_innings_2_balls = innings_B_1_batting_player_10_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_2_runs() {
//        return innings_B_1_batting_player_10_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_2_runs(String innings_B_1_batting_player_10_innings_2_runs) {
//        this.innings_B_1_batting_player_10_innings_2_runs = innings_B_1_batting_player_10_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_2_out_comment() {
//        return innings_B_1_batting_player_10_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_2_out_comment(String innings_B_1_batting_player_10_innings_2_out_comment) {
//        this.innings_B_1_batting_player_10_innings_2_out_comment = innings_B_1_batting_player_10_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_10_innings_2_strike_rate() {
//        return innings_B_1_batting_player_10_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_10_innings_2_strike_rate(String innings_B_1_batting_player_10_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_10_innings_2_strike_rate = innings_B_1_batting_player_10_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_10_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_10_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_10_innings_2_maiden_overs(String innings_B_1_bowling_player_10_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_10_innings_2_maiden_overs = innings_B_1_bowling_player_10_innings_2_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_11_full_name() {
//        return innings_B_1_batting_player_11_full_name;
//    }
//
//    public void setInnings_B_1_batting_player_11_full_name(String innings_B_1_batting_player_11_full_name) {
//        this.innings_B_1_batting_player_11_full_name = innings_B_1_batting_player_11_full_name;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_1_sixes() {
//        return innings_B_1_batting_player_11_innings_1_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_1_sixes(String innings_B_1_batting_player_11_innings_1_sixes) {
//        this.innings_B_1_batting_player_11_innings_1_sixes = innings_B_1_batting_player_11_innings_1_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_1_fours() {
//        return innings_B_1_batting_player_11_innings_1_fours;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_1_fours(String innings_B_1_batting_player_11_innings_1_fours) {
//        this.innings_B_1_batting_player_11_innings_1_fours = innings_B_1_batting_player_11_innings_1_fours;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_1_balls() {
//        return innings_B_1_batting_player_11_innings_1_balls;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_1_balls(String innings_B_1_batting_player_11_innings_1_balls) {
//        this.innings_B_1_batting_player_11_innings_1_balls = innings_B_1_batting_player_11_innings_1_balls;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_1_runs() {
//        return innings_B_1_batting_player_11_innings_1_runs;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_1_runs(String innings_B_1_batting_player_11_innings_1_runs) {
//        this.innings_B_1_batting_player_11_innings_1_runs = innings_B_1_batting_player_11_innings_1_runs;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_1_out_comment() {
//        return innings_B_1_batting_player_11_innings_1_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_1_out_comment(String innings_B_1_batting_player_11_innings_1_out_comment) {
//        this.innings_B_1_batting_player_11_innings_1_out_comment = innings_B_1_batting_player_11_innings_1_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_1_strike_rate() {
//        return innings_B_1_batting_player_11_innings_1_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_1_strike_rate(String innings_B_1_batting_player_11_innings_1_strike_rate) {
//        this.innings_B_1_batting_player_11_innings_1_strike_rate = innings_B_1_batting_player_11_innings_1_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_11_innings_1_maiden_overs() {
//        return innings_B_1_bowling_player_11_innings_1_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_11_innings_1_maiden_overs(String innings_B_1_bowling_player_11_innings_1_maiden_overs) {
//        this.innings_B_1_bowling_player_11_innings_1_maiden_overs = innings_B_1_bowling_player_11_innings_1_maiden_overs;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_2_sixes() {
//        return innings_B_1_batting_player_11_innings_2_sixes;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_2_sixes(String innings_B_1_batting_player_11_innings_2_sixes) {
//        this.innings_B_1_batting_player_11_innings_2_sixes = innings_B_1_batting_player_11_innings_2_sixes;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_2_fours() {
//        return innings_B_1_batting_player_11_innings_2_fours;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_2_fours(String innings_B_1_batting_player_11_innings_2_fours) {
//        this.innings_B_1_batting_player_11_innings_2_fours = innings_B_1_batting_player_11_innings_2_fours;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_2_balls() {
//        return innings_B_1_batting_player_11_innings_2_balls;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_2_balls(String innings_B_1_batting_player_11_innings_2_balls) {
//        this.innings_B_1_batting_player_11_innings_2_balls = innings_B_1_batting_player_11_innings_2_balls;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_2_runs() {
//        return innings_B_1_batting_player_11_innings_2_runs;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_2_runs(String innings_B_1_batting_player_11_innings_2_runs) {
//        this.innings_B_1_batting_player_11_innings_2_runs = innings_B_1_batting_player_11_innings_2_runs;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_2_out_comment() {
//        return innings_B_1_batting_player_11_innings_2_out_comment;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_2_out_comment(String innings_B_1_batting_player_11_innings_2_out_comment) {
//        this.innings_B_1_batting_player_11_innings_2_out_comment = innings_B_1_batting_player_11_innings_2_out_comment;
//    }
//
//    public String getInnings_B_1_batting_player_11_innings_2_strike_rate() {
//        return innings_B_1_batting_player_11_innings_2_strike_rate;
//    }
//
//    public void setInnings_B_1_batting_player_11_innings_2_strike_rate(String innings_B_1_batting_player_11_innings_2_strike_rate) {
//        this.innings_B_1_batting_player_11_innings_2_strike_rate = innings_B_1_batting_player_11_innings_2_strike_rate;
//    }
//
//    public String getInnings_B_1_bowling_player_11_innings_2_maiden_overs() {
//        return innings_B_1_bowling_player_11_innings_2_maiden_overs;
//    }
//
//    public void setInnings_B_1_bowling_player_11_innings_2_maiden_overs(String innings_B_1_bowling_player_11_innings_2_maiden_overs) {
//        this.innings_B_1_bowling_player_11_innings_2_maiden_overs = innings_B_1_bowling_player_11_innings_2_maiden_overs;
//    }
//
//    public boolean isDl_applied() {
//        return dl_applied;
//    }
//
//    public void setDl_applied(boolean dl_applied) {
//        this.dl_applied = dl_applied;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getMan_of_match() {
//        return man_of_match;
//    }
//
//    public void setMan_of_match(String man_of_match) {
//        this.man_of_match = man_of_match;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getShort_name() {
//        return short_name;
//    }
//
//    public void setShort_name(String short_name) {
//        this.short_name = short_name;
//    }
//
//    public String getFormat() {
//        return format;
//    }
//
//    public void setFormat(String format) {
//        this.format = format;
//    }
//
//    public String getKey() {
//        return key;
//    }
//
//    public void setKey(String key) {
//        this.key = key;
//    }
//
//    public String getDay() {
//        return day;
//    }
//
//    public void setDay(String day) {
//        this.day = day;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getVenue() {
//        return venue;
//    }
//
//    public void setVenue(String venue) {
//        this.venue = venue;
//    }
//
//    public int getStart_date_timestamp() {
//        return start_date_timestamp;
//    }
//
//    public void setStart_date_timestamp(int start_date_timestamp) {
//        this.start_date_timestamp = start_date_timestamp;
//    }
//
//    public String getStart_date_iso() {
//        return start_date_iso;
//    }
//
//    public void setStart_date_iso(String start_date_iso) {
//        this.start_date_iso = start_date_iso;
//    }
//
//    public String getStart_date_str() {
//        return start_date_str;
//    }
//
//    public void setStart_date_str(String start_date_str) {
//        this.start_date_str = start_date_str;
//    }
//}
