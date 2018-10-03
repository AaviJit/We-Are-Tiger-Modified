package com.sweetitech.tiger.parser;

import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;
import com.sweetitech.tiger.model.EntitySportAPI.LiveMatch.LiveMatch;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.Innings;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.MatchScorecard;
import com.sweetitech.tiger.service.EntitySportsService.EntitySportsCricketApiService;
import com.sweetitech.tiger.util.TimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class sampleMatchScorecardParser {

    MatchScorecard matchScorecard;

    Innings innings1;
    Innings innings2;
    Innings innings3;
    Innings innings4;

    List<Player> teamAinnings1BatsmanList;
    List<Player> teamAinnings2BatsmanList;
    List<Player> teamBinnings1BatsmanList;
    List<Player> teamBinnings2BatsmanList;

    List<Player> teamBinnings1BowlerList;
    List<Player> teamBinnings2BowlerList;
    List<Player> teamAinnings1BowlerList;
    List<Player> teamAinnings2BowlerList;


    LiveMatch liveMatch;
    Match matchForLiveMatch;
    List<Player> playerListForScorecard;

    public sampleMatchScorecardParser(MatchScorecard matchScorecard, LiveMatch liveMatch) {
        this.matchScorecard = matchScorecard;
        this.liveMatch = liveMatch;
        this.matchForLiveMatch = liveMatch.getResponse();


        initializeInningsProperty();
        initializeRecentBatsmanAndBowler();
        initializeAllInningsBowlers();
        initializeMatchProperty();
        initializeAllInningsBatsmans();
    }


    private String inning_1_batting_team = null;
    private String inning_2_batting_team = null;
    private String inning_3_batting_team = null;
    private String inning_4_batting_team = null;
    private String team_a_full_score = null;
    private String team_b_full_score =null;
    public void initializeInningsProperty()
    {
        try {
            if (matchScorecard.getResponse().getInnings().get(0).getBatting_team_id().equals(matchScorecard.getResponse().getTeamb().getTeam_id()))
            {
                  Team teamA = matchScorecard.getResponse().getTeamb();
                  Team teamB = matchScorecard.getResponse().getTeama();
                  team_a = teamA.getShort_name();
                  team_a_full_name = teamA.getName();
                  team_a_full_score = teamA.getScores_full();


                  team_b = teamB.getShort_name();
                  team_b_full_name = teamB.getName();
                  team_a_url = teamA.getLogo_url();
                  team_b_url = teamB.getLogo_url();
                  team_b_full_score = teamB.getScores_full();
            }
            else
            {
                Team teamA = matchScorecard.getResponse().getTeama();
                Team teamB = matchScorecard.getResponse().getTeamb();
                team_a =teamA.getShort_name();
                team_a_full_name = teamA.getName();
                team_a_full_score =teamA.getScores_full();

                team_b = teamB.getShort_name();
                team_b_full_name = teamB.getName();
                team_a_url = teamA.getLogo_url();
                team_b_url =  teamB.getLogo_url();
                team_b_full_score =teamB.getScores_full();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
            if (matchScorecard.getResponse().getInnings().size() >= 1)
            {
                inning_1_batting_team = matchScorecard.getResponse().getInnings().get(0).getName();
                innings1 = matchScorecard.getResponse().getInnings().get(0);
                teamAinnings1BatsmanList = innings1.getBatsmen();
                teamBinnings1BowlerList = innings1.getBowlers();
            }
            if (matchScorecard.getResponse().getInnings().size() >= 2)
            {
                inning_2_batting_team = matchScorecard.getResponse().getInnings().get(1).getName();
                innings2 = matchScorecard.getResponse().getInnings().get(1);
                teamBinnings1BatsmanList = innings2.getBatsmen();
                teamAinnings1BowlerList = innings2.getBowlers();
            }

            if (matchScorecard.getResponse().getInnings().size() >= 3)
            {
                inning_3_batting_team = matchScorecard.getResponse().getInnings().get(2).getName();
                innings3 = matchScorecard.getResponse().getInnings().get(2);
                teamAinnings2BatsmanList = innings3.getBatsmen();
                teamBinnings2BowlerList = innings3.getBowlers();
            }
            if (matchScorecard.getResponse().getInnings().size() >= 4)
            {
                inning_4_batting_team = matchScorecard.getResponse().getInnings().get(3).getName();
                innings4 = matchScorecard.getResponse().getInnings().get(3);
                teamBinnings2BatsmanList = innings4.getBatsmen();
                teamAinnings2BowlerList = innings4.getBowlers();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /*Recent Batsman variable*/
    private String latest_batsman_1_name = null;
    private String latest_batsman_1_strike_rate = null;
    private String latest_batsman_1_runs = null;
    private String latest_batsman_1_balls = null;
    private String latest_batsman_1_sixes = null;
    private String latest_batsman_1_fours = null;

    private String latest_batsman_2_name = null;
    private String latest_batsman_2_strike_rate = null;
    private String latest_batsman_2_runs = null;
    private String latest_batsman_2_balls = null;
    private String latest_batsman_2_sixes = null;
    private String latest_batsman_2_fours = null;

    private String latest_bowler_1_name = null;
    private String latest_bowler_1_over  = null;
    private String latest_bowler_1_maiden = null;
    private String latest_bowler_1_run = null;
    private String latest_bowler_1_wicket = null;
    private String latest_bowler_1_eco = null;

    private String latest_bowler_2_name = null;
    private String latest_bowler_2_over = null;
    private String latest_bowler_2_maiden = null;
    private String latest_bowler_2_run = null;
    private String latest_bowler_2_wicket = null;
    private String latest_bowler_2_eco = null;
    private List<String> recent_over_summary = null;


    @Autowired
    EntitySportsCricketApiService entitySportsCricketApiService;


    public void initializeRecentBatsmanAndBowler()
    {
        if(matchForLiveMatch != null)
        {
            try {
               //Recent batsman
                List<Player> playerListForLiveMatch = matchForLiveMatch.getPlayers();

                //filtered playerlist of livematch to find player with recent batsman id to get player name
                latest_batsman_1_name = playerListForLiveMatch.stream().filter(p -> p.getPid().
                        equals(matchForLiveMatch.getBatsmen().get(0).getBatsman_id())).
                        findFirst().orElse(null).getTitle();

                latest_batsman_1_strike_rate = matchForLiveMatch.getBatsmen().get(0).getStrike_rate();
                latest_batsman_1_runs = matchForLiveMatch.getBatsmen().get(0).getRuns().toString();
                latest_batsman_1_balls = matchForLiveMatch.getBatsmen().get(0).getBalls_faced().toString();
                latest_batsman_1_sixes = matchForLiveMatch.getBatsmen().get(0).getSixes().toString();
                latest_batsman_1_fours = matchForLiveMatch.getBatsmen().get(0).getFours().toString();

                latest_batsman_2_name = playerListForLiveMatch.stream().filter(p -> p.getPid().
                        equals(matchForLiveMatch.getBatsmen().get(1).getBatsman_id())).
                        findFirst().orElse(null).getTitle();

                latest_batsman_2_strike_rate = matchForLiveMatch.getBatsmen().get(1).getStrike_rate();
                latest_batsman_2_runs = matchForLiveMatch.getBatsmen().get(1).getRuns().toString();
                latest_batsman_2_balls = matchForLiveMatch.getBatsmen().get(1).getBalls_faced().toString();
                latest_batsman_2_sixes = matchForLiveMatch.getBatsmen().get(1).getSixes().toString();
                latest_batsman_2_fours = matchForLiveMatch.getBatsmen().get(1).getFours().toString();


                //Recent Bowler
                if(matchForLiveMatch.getBowlers().size()>=1) {
                    latest_bowler_1_name = playerListForLiveMatch.stream().filter(p -> p.getPid().
                            equals(matchForLiveMatch.getBowlers().get(0).getBowler_id())).
                            findFirst().orElse(null).getTitle();

                    latest_bowler_1_over = matchForLiveMatch.getBowlers().get(0).getOvers();
                    latest_bowler_1_maiden = matchForLiveMatch.getBowlers().get(0).getMaidens().toString();
                    latest_bowler_1_run = matchForLiveMatch.getBowlers().get(0).getRuns_conceded().toString();
                    latest_bowler_1_wicket = matchForLiveMatch.getBowlers().get(0).getWickets().toString();
                    latest_bowler_1_eco = matchForLiveMatch.getBowlers().get(0).getEcon();
                }
                if(matchForLiveMatch.getBowlers().size()>=2) {
                    latest_bowler_2_name = playerListForLiveMatch.stream().filter(p -> p.getPid().
                            equals(matchForLiveMatch.getBowlers().get(1).getBowler_id())).
                            findFirst().orElse(null).getTitle();
                    latest_bowler_2_over = matchForLiveMatch.getBowlers().get(1).getOvers();
                    latest_bowler_2_maiden = matchForLiveMatch.getBowlers().get(1).getMaidens().toString();
                    latest_bowler_2_run = matchForLiveMatch.getBowlers().get(1).getRuns_conceded().toString();
                    latest_bowler_2_wicket = matchForLiveMatch.getBowlers().get(1).getWickets().toString();
                    latest_bowler_2_eco = matchForLiveMatch.getBowlers().get(1).getEcon();
                }

                current_batting_team = matchForLiveMatch.getLive_inning().getName();
                current_runrate = matchForLiveMatch.getLive_score().getRunrate();

                recent_over_summary = Arrays.asList(matchForLiveMatch.getLive_inning().getRecent_scores().split(","));
            }
            catch (Exception e)
            {
                System.out.println("Exception in initializeRecentBatsman");
                e.printStackTrace();
            }
        }

    }




    /*All Innings Bowlers*/
    private String bowling_a_1_player_1_name = null;
    private String bowling_a_1_player_1_economy = null;
    private String bowling_a_1_player_1_runs = null;
    private String bowling_a_1_player_1_wickets = null;
    private String bowling_a_1_player_1_extras = null;
    private String bowling_a_1_player_1_maiden_overs = null;
    private String bowling_a_1_player_1_overs = null;

    private String bowling_a_2_player_1_name = null;
    private String bowling_a_2_player_1_economy = null;
    private String bowling_a_2_player_1_runs = null;
    private String bowling_a_2_player_1_wickets= null;
    private String bowling_a_2_player_1_extras= null;
    private String bowling_a_2_player_1_maiden_overs= null;
    private String bowling_a_2_player_1_overs= null;

    private String bowling_b_1_player_1_name = null;
    private String bowling_b_1_player_1_economy = null;
    private String bowling_b_1_player_1_runs = null;
    private String bowling_b_1_player_1_wickets = null;
    private String bowling_b_1_player_1_extras = null;
    private String bowling_b_1_player_1_maiden_overs = null;
    private String bowling_b_1_player_1_overs = null;

    private String bowling_b_2_player_1_name = null;
    private String bowling_b_2_player_1_economy = null;
    private String bowling_b_2_player_1_runs = null;
    private String bowling_b_2_player_1_wickets = null;
    private String bowling_b_2_player_1_extras = null;
    private String bowling_b_2_player_1_maiden_overs = null;
    private String bowling_b_2_player_1_overs = null;

    //player 2
    private String bowling_a_1_player_2_name = null;
    private String bowling_a_1_player_2_economy = null;
    private String bowling_a_1_player_2_runs = null;
    private String bowling_a_1_player_2_wickets = null;
    private String bowling_a_1_player_2_extras = null;
    private String bowling_a_1_player_2_maiden_overs = null;
    private String bowling_a_1_player_2_overs = null;

    private String bowling_a_2_player_2_name = null;
    private String bowling_a_2_player_2_economy = null;
    private String bowling_a_2_player_2_runs = null;
    private String bowling_a_2_player_2_wickets = null;
    private String bowling_a_2_player_2_extras = null;
    private String bowling_a_2_player_2_maiden_overs = null;
    private String bowling_a_2_player_2_overs = null;

    private String bowling_b_1_player_2_name = null;
    private String bowling_b_1_player_2_economy = null;
    private String bowling_b_1_player_2_runs = null;
    private String bowling_b_1_player_2_wickets = null;
    private String bowling_b_1_player_2_extras = null;
    private String bowling_b_1_player_2_maiden_overs = null;
    private String bowling_b_1_player_2_overs = null;

    private String bowling_b_2_player_2_name = null;
    private String bowling_b_2_player_2_economy = null;
    private String bowling_b_2_player_2_runs = null;
    private String bowling_b_2_player_2_wickets = null;
    private String bowling_b_2_player_2_extras = null;
    private String bowling_b_2_player_2_maiden_overs = null;
    private String bowling_b_2_player_2_overs = null;

    //player 3
    private String bowling_a_1_player_3_name = null;
    private String bowling_a_1_player_3_economy = null;
    private String bowling_a_1_player_3_runs = null;
    private String bowling_a_1_player_3_wickets = null;
    private String bowling_a_1_player_3_extras = null;
    private String bowling_a_1_player_3_maiden_overs = null;
    private String bowling_a_1_player_3_overs = null;

    private String bowling_a_2_player_3_name = null;
    private String bowling_a_2_player_3_economy = null;
    private String bowling_a_2_player_3_runs = null;
    private String bowling_a_2_player_3_wickets = null;
    private String bowling_a_2_player_3_extras = null;
    private String bowling_a_2_player_3_maiden_overs = null;
    private String bowling_a_2_player_3_overs = null;

    private String bowling_b_1_player_3_name = null;
    private String bowling_b_1_player_3_economy = null;
    private String bowling_b_1_player_3_runs = null;
    private String bowling_b_1_player_3_wickets = null;
    private String bowling_b_1_player_3_extras = null;
    private String bowling_b_1_player_3_maiden_overs = null;
    private String bowling_b_1_player_3_overs = null;

    private String bowling_b_2_player_3_name = null;
    private String bowling_b_2_player_3_economy = null;
    private String bowling_b_2_player_3_runs = null;
    private String bowling_b_2_player_3_wickets = null;
    private String bowling_b_2_player_3_extras = null;
    private String bowling_b_2_player_3_maiden_overs = null;
    private String bowling_b_2_player_3_overs = null;

    //player 4
    private String bowling_a_1_player_4_name = null;
    private String bowling_a_1_player_4_economy = null;
    private String bowling_a_1_player_4_runs = null;
    private String bowling_a_1_player_4_wickets = null;
    private String bowling_a_1_player_4_extras = null;
    private String bowling_a_1_player_4_maiden_overs = null;
    private String bowling_a_1_player_4_overs = null;

    private String bowling_a_2_player_4_name = null;
    private String bowling_a_2_player_4_economy = null;
    private String bowling_a_2_player_4_runs = null;
    private String bowling_a_2_player_4_wickets = null;
    private String bowling_a_2_player_4_extras = null;
    private String bowling_a_2_player_4_maiden_overs = null;
    private String bowling_a_2_player_4_overs = null;

    private String bowling_b_1_player_4_name = null;
    private String bowling_b_1_player_4_economy = null;
    private String bowling_b_1_player_4_runs = null;
    private String bowling_b_1_player_4_wickets = null;
    private String bowling_b_1_player_4_extras = null;
    private String bowling_b_1_player_4_maiden_overs = null;
    private String bowling_b_1_player_4_overs = null;

    private String bowling_b_2_player_4_name = null;
    private String bowling_b_2_player_4_economy = null;
    private String bowling_b_2_player_4_runs = null;
    private String bowling_b_2_player_4_wickets = null;
    private String bowling_b_2_player_4_extras = null;
    private String bowling_b_2_player_4_maiden_overs = null;
    private String bowling_b_2_player_4_overs = null;

    //player 5
    private String bowling_a_1_player_5_name = null;
    private String bowling_a_1_player_5_economy = null;
    private String bowling_a_1_player_5_runs = null;
    private String bowling_a_1_player_5_wickets = null;
    private String bowling_a_1_player_5_extras = null;
    private String bowling_a_1_player_5_maiden_overs = null;
    private String bowling_a_1_player_5_overs = null;

    private String bowling_a_2_player_5_name = null;
    private String bowling_a_2_player_5_economy = null;
    private String bowling_a_2_player_5_runs = null;
    private String bowling_a_2_player_5_wickets = null;
    private String bowling_a_2_player_5_extras = null;
    private String bowling_a_2_player_5_maiden_overs = null;
    private String bowling_a_2_player_5_overs = null;

    private String bowling_b_1_player_5_name = null;
    private String bowling_b_1_player_5_economy = null;
    private String bowling_b_1_player_5_runs = null;
    private String bowling_b_1_player_5_wickets = null;
    private String bowling_b_1_player_5_extras = null;
    private String bowling_b_1_player_5_maiden_overs = null;
    private String bowling_b_1_player_5_overs = null;

    private String bowling_b_2_player_5_name = null;
    private String bowling_b_2_player_5_economy = null;
    private String bowling_b_2_player_5_runs = null;
    private String bowling_b_2_player_5_wickets = null;
    private String bowling_b_2_player_5_extras = null;
    private String bowling_b_2_player_5_maiden_overs = null;
    private String bowling_b_2_player_5_overs = null;

    //player 6
    private String bowling_a_1_player_6_name = null;
    private String bowling_a_1_player_6_economy = null;
    private String bowling_a_1_player_6_runs = null;
    private String bowling_a_1_player_6_wickets = null;
    private String bowling_a_1_player_6_extras = null;
    private String bowling_a_1_player_6_maiden_overs = null;
    private String bowling_a_1_player_6_overs = null;

    private String bowling_a_2_player_6_name = null;
    private String bowling_a_2_player_6_economy = null;
    private String bowling_a_2_player_6_runs = null;
    private String bowling_a_2_player_6_wickets = null;
    private String bowling_a_2_player_6_extras = null;
    private String bowling_a_2_player_6_maiden_overs = null;
    private String bowling_a_2_player_6_overs = null;

    private String bowling_b_1_player_6_name = null;
    private String bowling_b_1_player_6_economy = null;
    private String bowling_b_1_player_6_runs = null;
    private String bowling_b_1_player_6_wickets = null;
    private String bowling_b_1_player_6_extras = null;
    private String bowling_b_1_player_6_maiden_overs = null;
    private String bowling_b_1_player_6_overs = null;

    private String bowling_b_2_player_6_name = null;
    private String bowling_b_2_player_6_economy = null;
    private String bowling_b_2_player_6_runs = null;
    private String bowling_b_2_player_6_wickets = null;
    private String bowling_b_2_player_6_extras = null;
    private String bowling_b_2_player_6_maiden_overs = null;
    private String bowling_b_2_player_6_overs = null;

    //player 7
    private String bowling_a_1_player_7_name = null;
    private String bowling_a_1_player_7_economy = null;
    private String bowling_a_1_player_7_runs = null;
    private String bowling_a_1_player_7_wickets = null;
    private String bowling_a_1_player_7_extras = null;
    private String bowling_a_1_player_7_maiden_overs = null;
    private String bowling_a_1_player_7_overs = null;

    private String bowling_a_2_player_7_name = null;
    private String bowling_a_2_player_7_economy = null;
    private String bowling_a_2_player_7_runs = null;
    private String bowling_a_2_player_7_wickets = null;
    private String bowling_a_2_player_7_extras = null;
    private String bowling_a_2_player_7_maiden_overs = null;
    private String bowling_a_2_player_7_overs = null;

    private String bowling_b_1_player_7_name = null;
    private String bowling_b_1_player_7_economy = null;
    private String bowling_b_1_player_7_runs = null;
    private String bowling_b_1_player_7_wickets = null;
    private String bowling_b_1_player_7_extras = null;
    private String bowling_b_1_player_7_maiden_overs = null;
    private String bowling_b_1_player_7_overs = null;

    private String bowling_b_2_player_7_name = null;
    private String bowling_b_2_player_7_economy = null;
    private String bowling_b_2_player_7_runs = null;
    private String bowling_b_2_player_7_wickets = null;
    private String bowling_b_2_player_7_extras = null;
    private String bowling_b_2_player_7_maiden_overs = null;
    private String bowling_b_2_player_7_overs = null;

    //player 8
    private String bowling_a_1_player_8_name = null;
    private String bowling_a_1_player_8_economy  = null;
    private String bowling_a_1_player_8_runs = null;
    private String bowling_a_1_player_8_wickets = null;
    private String bowling_a_1_player_8_extras = null;
    private String bowling_a_1_player_8_maiden_overs = null;
    private String bowling_a_1_player_8_overs;

    private String bowling_a_2_player_8_name = null;
    private String bowling_a_2_player_8_economy = null;
    private String bowling_a_2_player_8_runs = null;
    private String bowling_a_2_player_8_wickets = null;
    private String bowling_a_2_player_8_extras = null;
    private String bowling_a_2_player_8_maiden_overs = null;
    private String bowling_a_2_player_8_overs = null;

    private String bowling_b_1_player_8_name = null;
    private String bowling_b_1_player_8_economy = null;
    private String bowling_b_1_player_8_runs = null;
    private String bowling_b_1_player_8_wickets = null;
    private String bowling_b_1_player_8_extras = null;
    private String bowling_b_1_player_8_maiden_overs = null;
    private String bowling_b_1_player_8_overs = null;

    private String bowling_b_2_player_8_name = null;
    private String bowling_b_2_player_8_economy = null;
    private String bowling_b_2_player_8_runs = null;
    private String bowling_b_2_player_8_wickets = null;
    private String bowling_b_2_player_8_extras = null;
    private String bowling_b_2_player_8_maiden_overs = null;
    private String bowling_b_2_player_8_overs = null;

    //player 9
    private String bowling_a_1_player_9_name = null;
    private String bowling_a_1_player_9_economy = null;
    private String bowling_a_1_player_9_runs = null;
    private String bowling_a_1_player_9_wickets = null;
    private String bowling_a_1_player_9_extras = null;
    private String bowling_a_1_player_9_maiden_overs = null;
    private String bowling_a_1_player_9_overs = null;

    private String bowling_a_2_player_9_name = null;
    private String bowling_a_2_player_9_economy = null;
    private String bowling_a_2_player_9_runs = null;
    private String bowling_a_2_player_9_wickets = null;
    private String bowling_a_2_player_9_extras = null;
    private String bowling_a_2_player_9_maiden_overs = null;
    private String bowling_a_2_player_9_overs = null;

    private String bowling_b_1_player_9_name  = null;
    private String bowling_b_1_player_9_economy = null;
    private String bowling_b_1_player_9_runs  = null;
    private String bowling_b_1_player_9_wickets  = null;
    private String bowling_b_1_player_9_extras = null;
    private String bowling_b_1_player_9_maiden_overs = null;
    private String bowling_b_1_player_9_overs = null;

    private String bowling_b_2_player_9_name = null;
    private String bowling_b_2_player_9_economy = null;
    private String bowling_b_2_player_9_runs = null;
    private String bowling_b_2_player_9_wickets = null;
    private String bowling_b_2_player_9_extras = null;
    private String bowling_b_2_player_9_maiden_overs = null;
    private String bowling_b_2_player_9_overs = null;

    //player 10
    private String bowling_a_1_player_10_name = null;
    private String bowling_a_1_player_10_economy = null;
    private String bowling_a_1_player_10_runs = null;
    private String bowling_a_1_player_10_wickets = null;
    private String bowling_a_1_player_10_extras = null;
    private String bowling_a_1_player_10_maiden_overs = null;
    private String bowling_a_1_player_10_overs = null;

    private String bowling_a_2_player_10_name = null;
    private String bowling_a_2_player_10_economy = null;
    private String bowling_a_2_player_10_runs = null;
    private String bowling_a_2_player_10_wickets = null;
    private String bowling_a_2_player_10_extras = null;
    private String bowling_a_2_player_10_maiden_overs = null;
    private String bowling_a_2_player_10_overs = null;

    private String bowling_b_1_player_10_name = null;
    private String bowling_b_1_player_10_economy = null;
    private String bowling_b_1_player_10_runs = null;
    private String bowling_b_1_player_10_wickets = null;
    private String bowling_b_1_player_10_extras = null;
    private String bowling_b_1_player_10_maiden_overs = null;
    private String bowling_b_1_player_10_overs = null;

    private String bowling_b_2_player_10_name = null;
    private String bowling_b_2_player_10_economy = null;
    private String bowling_b_2_player_10_runs = null;
    private String bowling_b_2_player_10_wickets = null;
    private String bowling_b_2_player_10_extras = null;
    private String bowling_b_2_player_10_maiden_overs = null;
    private String bowling_b_2_player_10_overs = null;

    //player 11
    private String bowling_a_1_player_11_name = null;
    private String bowling_a_1_player_11_economy = null;
    private String bowling_a_1_player_11_runs = null;
    private String bowling_a_1_player_11_wickets = null;
    private String bowling_a_1_player_11_extras = null;
    private String bowling_a_1_player_11_maiden_overs = null;
    private String bowling_a_1_player_11_overs = null;

    private String bowling_a_2_player_11_name = null;
    private String bowling_a_2_player_11_economy  = null;
    private String bowling_a_2_player_11_runs = null;
    private String bowling_a_2_player_11_wickets = null;
    private String bowling_a_2_player_11_extras = null;
    private String bowling_a_2_player_11_maiden_overs = null;
    private String bowling_a_2_player_11_overs = null;

    private String bowling_b_1_player_11_name = null;
    private String bowling_b_1_player_11_economy = null;
    private String bowling_b_1_player_11_runs = null;
    private String bowling_b_1_player_11_wickets = null;
    private String bowling_b_1_player_11_extras = null;
    private String bowling_b_1_player_11_maiden_overs = null;
    private String bowling_b_1_player_11_overs = null;

    private String bowling_b_2_player_11_name = null;
    private String bowling_b_2_player_11_economy = null;
    private String bowling_b_2_player_11_runs = null;
    private String bowling_b_2_player_11_wickets = null;
    private String bowling_b_2_player_11_extras = null;
    private String bowling_b_2_player_11_maiden_overs = null;
    private String bowling_b_2_player_11_overs = null;



    public void initializeAllInningsBowlers()
    {
        try
        {
           playerListForScorecard = matchScorecard.getResponse().getPlayers();

            /*Initialize Innings 1 bowler list*/
            if(matchScorecard.getResponse().getInnings().size() >= 1)
            {
                try{
                    //player 1
                    if(teamBinnings1BowlerList.size()>=1)
                    {
                        /*Filtered playerlist with bowlerid to get bowler name*/
                        bowling_b_1_player_1_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(0)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();

                        bowling_b_1_player_1_economy = teamBinnings1BowlerList.get(0).getEcon();
                        bowling_b_1_player_1_runs = teamBinnings1BowlerList.get(0).getRuns_conceded().toString();
                        bowling_b_1_player_1_wickets =teamBinnings1BowlerList.get(0).getWickets().toString();
                        bowling_b_1_player_1_extras = Integer.toString(teamBinnings1BowlerList.get(0).getWides()+teamBinnings1BowlerList.get(0).getNoballs());
                        bowling_b_1_player_1_maiden_overs = teamBinnings1BowlerList.get(0).getMaidens().toString();
                        bowling_b_1_player_1_overs = teamBinnings1BowlerList.get(0).getOvers();
                    }
                    //player 2
                    if(teamBinnings1BowlerList.size()>=2)
                    {
                        bowling_b_1_player_2_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(1)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_2_economy = teamBinnings1BowlerList.get(1).getEcon();
                        bowling_b_1_player_2_runs = teamBinnings1BowlerList.get(1).getRuns_conceded().toString();
                        bowling_b_1_player_2_wickets =teamBinnings1BowlerList.get(1).getWickets().toString();
                        bowling_b_1_player_2_extras = Integer.toString(teamBinnings1BowlerList.get(1).getWides()+teamBinnings1BowlerList.get(1).getNoballs());
                        bowling_b_1_player_2_maiden_overs = teamBinnings1BowlerList.get(1).getMaidens().toString();
                        bowling_b_1_player_2_overs = teamBinnings1BowlerList.get(1).getOvers();
                    }
                    //player 3
                    if(teamBinnings1BowlerList.size()>=3)
                    {
                        bowling_b_1_player_3_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(2)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_3_economy = teamBinnings1BowlerList.get(2).getEcon();
                        bowling_b_1_player_3_runs = teamBinnings1BowlerList.get(2).getRuns_conceded().toString();
                        bowling_b_1_player_3_wickets =teamBinnings1BowlerList.get(2).getWickets().toString();
                        bowling_b_1_player_3_extras = Integer.toString(teamBinnings1BowlerList.get(2).getWides()+teamBinnings1BowlerList.get(2).getNoballs());
                        bowling_b_1_player_3_maiden_overs = teamBinnings1BowlerList.get(2).getMaidens().toString();
                        bowling_b_1_player_3_overs = teamBinnings1BowlerList.get(2).getOvers();
                    }
                    //player 4
                    if(teamBinnings1BowlerList.size()>=4)
                    {
                        bowling_b_1_player_4_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(3)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_4_economy = teamBinnings1BowlerList.get(3).getEcon();
                        bowling_b_1_player_4_runs = teamBinnings1BowlerList.get(3).getRuns_conceded().toString();
                        bowling_b_1_player_4_wickets =teamBinnings1BowlerList.get(3).getWickets().toString();
                        bowling_b_1_player_4_extras = Integer.toString(teamBinnings1BowlerList.get(3).getWides()+teamBinnings1BowlerList.get(3).getNoballs());
                        bowling_b_1_player_4_maiden_overs = teamBinnings1BowlerList.get(3).getMaidens().toString();
                        bowling_b_1_player_4_overs = teamBinnings1BowlerList.get(3).getOvers();
                    }

                    //player 5
                    if(teamBinnings1BowlerList.size()>=5)
                    {
                        bowling_b_1_player_5_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(4)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_5_economy = teamBinnings1BowlerList.get(4).getEcon();
                        bowling_b_1_player_5_runs = teamBinnings1BowlerList.get(4).getRuns_conceded().toString();
                        bowling_b_1_player_5_wickets =teamBinnings1BowlerList.get(4).getWickets().toString();
                        bowling_b_1_player_5_extras = Integer.toString(teamBinnings1BowlerList.get(4).getWides()+teamBinnings1BowlerList.get(4).getNoballs());
                        bowling_b_1_player_5_maiden_overs = teamBinnings1BowlerList.get(4).getMaidens().toString();
                        bowling_b_1_player_5_overs = teamBinnings1BowlerList.get(4).getOvers();
                    }
                    //player 6
                    if(teamBinnings1BowlerList.size()>=6)
                    {
                        bowling_b_1_player_6_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(5)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_6_economy = teamBinnings1BowlerList.get(5).getEcon();
                        bowling_b_1_player_6_runs = teamBinnings1BowlerList.get(5).getRuns_conceded().toString();
                        bowling_b_1_player_6_wickets =teamBinnings1BowlerList.get(5).getWickets().toString();
                        bowling_b_1_player_6_extras = Integer.toString(teamBinnings1BowlerList.get(5).getWides()+teamBinnings1BowlerList.get(5).getNoballs());
                        bowling_b_1_player_6_maiden_overs = teamBinnings1BowlerList.get(5).getMaidens().toString();
                        bowling_b_1_player_6_overs = teamBinnings1BowlerList.get(5).getOvers();
                    }
                    //player 7
                    if(teamBinnings1BowlerList.size()>=7)
                    {
                        bowling_b_1_player_7_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(6)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_7_economy = teamBinnings1BowlerList.get(6).getEcon();
                        bowling_b_1_player_7_runs = teamBinnings1BowlerList.get(6).getRuns_conceded().toString();
                        bowling_b_1_player_7_wickets =teamBinnings1BowlerList.get(6).getWickets().toString();
                        bowling_b_1_player_7_extras = Integer.toString(teamBinnings1BowlerList.get(6).getWides()+teamBinnings1BowlerList.get(6).getNoballs());
                        bowling_b_1_player_7_maiden_overs = teamBinnings1BowlerList.get(6).getMaidens().toString();
                        bowling_b_1_player_7_overs = teamBinnings1BowlerList.get(6).getOvers();
                    }
                    //player 8
                    if(teamBinnings1BowlerList.size()>=8)
                    {
                        bowling_b_1_player_8_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(7)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_8_economy = teamBinnings1BowlerList.get(7).getEcon();
                        bowling_b_1_player_8_runs = teamBinnings1BowlerList.get(7).getRuns_conceded().toString();
                        bowling_b_1_player_8_wickets =teamBinnings1BowlerList.get(7).getWickets().toString();
                        bowling_b_1_player_8_extras = Integer.toString(teamBinnings1BowlerList.get(7).getWides()+teamBinnings1BowlerList.get(7).getNoballs());
                        bowling_b_1_player_8_maiden_overs = teamBinnings1BowlerList.get(7).getMaidens().toString();
                        bowling_b_1_player_8_overs = teamBinnings1BowlerList.get(7).getOvers();
                    }
                    //player 9
                    if(teamBinnings1BowlerList.size()>=9)
                    {
                        bowling_b_1_player_9_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(8)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_9_economy = teamBinnings1BowlerList.get(8).getEcon();
                        bowling_b_1_player_9_runs = teamBinnings1BowlerList.get(8).getRuns_conceded().toString();
                        bowling_b_1_player_9_wickets =teamBinnings1BowlerList.get(8).getWickets().toString();
                        bowling_b_1_player_9_extras = Integer.toString(teamBinnings1BowlerList.get(8).getWides()+teamBinnings1BowlerList.get(8).getNoballs());
                        bowling_b_1_player_9_maiden_overs = teamBinnings1BowlerList.get(8).getMaidens().toString();
                        bowling_b_1_player_9_overs = teamBinnings1BowlerList.get(8).getOvers();
                    }
                    //player 10
                    if(teamBinnings1BowlerList.size()>=10)
                    {
                        bowling_b_1_player_10_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(9)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_10_economy = teamBinnings1BowlerList.get(9).getEcon();
                        bowling_b_1_player_10_runs = teamBinnings1BowlerList.get(9).getRuns_conceded().toString();
                        bowling_b_1_player_10_wickets =teamBinnings1BowlerList.get(9).getWickets().toString();
                        bowling_b_1_player_10_extras = Integer.toString(teamBinnings1BowlerList.get(9).getWides()+teamBinnings1BowlerList.get(9).getNoballs());
                        bowling_b_1_player_10_maiden_overs = teamBinnings1BowlerList.get(9).getMaidens().toString();
                        bowling_b_1_player_10_overs = teamBinnings1BowlerList.get(9).getOvers();
                    }
                    //player 10
                    if(teamBinnings1BowlerList.size()>=11)
                    {
                        bowling_b_1_player_11_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BowlerList.get(10)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_1_player_11_economy = teamBinnings1BowlerList.get(10).getEcon();
                        bowling_b_1_player_11_runs = teamBinnings1BowlerList.get(10).getRuns_conceded().toString();
                        bowling_b_1_player_11_wickets =teamBinnings1BowlerList.get(10).getWickets().toString();
                        bowling_b_1_player_11_extras = Integer.toString(teamBinnings1BowlerList.get(10).getWides()+teamBinnings1BowlerList.get(10).getNoballs());
                        bowling_b_1_player_11_maiden_overs = teamBinnings1BowlerList.get(10).getMaidens().toString();
                        bowling_b_1_player_11_overs = teamBinnings1BowlerList.get(10).getOvers();
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

           /* Initialize Innings 2 bowler list*/
            if(matchScorecard.getResponse().getInnings().size() >= 2)
            {
                try{
                    //player 1
                    if(teamAinnings1BowlerList.size()>=1)
                    {
                        bowling_a_1_player_1_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(0)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_1_economy = teamAinnings1BowlerList.get(0).getEcon();
                        bowling_a_1_player_1_runs = teamAinnings1BowlerList.get(0).getRuns_conceded().toString();
                        bowling_a_1_player_1_wickets =teamAinnings1BowlerList.get(0).getWickets().toString();
                        bowling_a_1_player_1_extras = Integer.toString(teamAinnings1BowlerList.get(0).getWides()+teamAinnings1BowlerList.get(0).getNoballs());
                        bowling_a_1_player_1_maiden_overs = teamAinnings1BowlerList.get(0).getMaidens().toString();
                        bowling_a_1_player_1_overs = teamAinnings1BowlerList.get(0).getOvers();
                    }
                    //player 2
                    if(teamAinnings1BowlerList.size()>=2)
                    {
                        bowling_a_1_player_2_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(1)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_2_economy = teamAinnings1BowlerList.get(1).getEcon();
                        bowling_a_1_player_2_runs = teamAinnings1BowlerList.get(1).getRuns_conceded().toString();
                        bowling_a_1_player_2_wickets =teamAinnings1BowlerList.get(1).getWickets().toString();
                        bowling_a_1_player_2_extras = Integer.toString(teamAinnings1BowlerList.get(1).getWides()+teamAinnings1BowlerList.get(1).getNoballs());
                        bowling_a_1_player_2_maiden_overs = teamAinnings1BowlerList.get(1).getMaidens().toString();
                        bowling_a_1_player_2_overs = teamAinnings1BowlerList.get(1).getOvers();
                    }
                    //player 3
                    if(teamAinnings1BowlerList.size()>=3)
                    {
                        bowling_a_1_player_3_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(2)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_3_economy = teamAinnings1BowlerList.get(2).getEcon();
                        bowling_a_1_player_3_runs = teamAinnings1BowlerList.get(2).getRuns_conceded().toString();
                        bowling_a_1_player_3_wickets =teamAinnings1BowlerList.get(2).getWickets().toString();
                        bowling_a_1_player_3_extras = Integer.toString(teamAinnings1BowlerList.get(2).getWides()+teamAinnings1BowlerList.get(2).getNoballs());
                        bowling_a_1_player_3_maiden_overs = teamAinnings1BowlerList.get(2).getMaidens().toString();
                        bowling_a_1_player_3_overs = teamAinnings1BowlerList.get(2).getOvers();
                    }
                    //player 4
                    if(teamAinnings1BowlerList.size()>=4)
                    {
                        bowling_a_1_player_4_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(3)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_4_economy = teamAinnings1BowlerList.get(3).getEcon();
                        bowling_a_1_player_4_runs = teamAinnings1BowlerList.get(3).getRuns_conceded().toString();
                        bowling_a_1_player_4_wickets =teamAinnings1BowlerList.get(3).getWickets().toString();
                        bowling_a_1_player_4_extras = Integer.toString(teamAinnings1BowlerList.get(3).getWides()+teamAinnings1BowlerList.get(3).getNoballs());
                        bowling_a_1_player_4_maiden_overs = teamAinnings1BowlerList.get(3).getMaidens().toString();
                        bowling_a_1_player_4_overs = teamAinnings1BowlerList.get(3).getOvers();
                    }
                    //player 5
                    if(teamAinnings1BowlerList.size()>=5)
                    {
                        bowling_a_1_player_5_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(4)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_5_economy = teamAinnings1BowlerList.get(4).getEcon();
                        bowling_a_1_player_5_runs = teamAinnings1BowlerList.get(4).getRuns_conceded().toString();
                        bowling_a_1_player_5_wickets =teamAinnings1BowlerList.get(4).getWickets().toString();
                        bowling_a_1_player_5_extras = Integer.toString(teamAinnings1BowlerList.get(4).getWides()+teamAinnings1BowlerList.get(4).getNoballs());
                        bowling_a_1_player_5_maiden_overs = teamAinnings1BowlerList.get(4).getMaidens().toString();
                        bowling_a_1_player_5_overs = teamAinnings1BowlerList.get(4).getOvers();
                    }
                    //player 6
                    if(teamAinnings1BowlerList.size()>=6)
                    {
                        bowling_a_1_player_6_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(5)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_6_economy = teamAinnings1BowlerList.get(5).getEcon();
                        bowling_a_1_player_6_runs = teamAinnings1BowlerList.get(5).getRuns_conceded().toString();
                        bowling_a_1_player_6_wickets =teamAinnings1BowlerList.get(5).getWickets().toString();
                        bowling_a_1_player_6_extras = Integer.toString(teamAinnings1BowlerList.get(5).getWides()+teamAinnings1BowlerList.get(5).getNoballs());
                        bowling_a_1_player_6_maiden_overs = teamAinnings1BowlerList.get(5).getMaidens().toString();
                        bowling_a_1_player_6_overs = teamAinnings1BowlerList.get(5).getOvers();
                    }
                    //player 7
                    if(teamAinnings1BowlerList.size()>=7)
                    {
                        bowling_a_1_player_7_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(6)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_7_economy = teamAinnings1BowlerList.get(6).getEcon();
                        bowling_a_1_player_7_runs = teamAinnings1BowlerList.get(6).getRuns_conceded().toString();
                        bowling_a_1_player_7_wickets =teamAinnings1BowlerList.get(6).getWickets().toString();
                        bowling_a_1_player_7_extras = Integer.toString(teamAinnings1BowlerList.get(6).getWides()+teamAinnings1BowlerList.get(6).getNoballs());
                        bowling_a_1_player_7_maiden_overs = teamAinnings1BowlerList.get(6).getMaidens().toString();
                        bowling_a_1_player_7_overs = teamAinnings1BowlerList.get(6).getOvers();

                    }
                    //player 8
                    if(teamAinnings1BowlerList.size()>=8)
                    {
                        bowling_a_1_player_8_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(7)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_8_economy = teamAinnings1BowlerList.get(7).getEcon();
                        bowling_a_1_player_8_runs = teamAinnings1BowlerList.get(7).getRuns_conceded().toString();
                        bowling_a_1_player_8_wickets =teamAinnings1BowlerList.get(7).getWickets().toString();
                        bowling_a_1_player_8_extras = Integer.toString(teamAinnings1BowlerList.get(7).getWides()+teamAinnings1BowlerList.get(7).getNoballs());
                        bowling_a_1_player_8_maiden_overs = teamAinnings1BowlerList.get(7).getMaidens().toString();
                        bowling_a_1_player_8_overs = teamAinnings1BowlerList.get(7).getOvers();
                    }
                    //player 9
                    if(teamAinnings1BowlerList.size()>=9)
                    {
                        bowling_a_1_player_9_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(8)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_9_economy = teamAinnings1BowlerList.get(8).getEcon();
                        bowling_a_1_player_9_runs = teamAinnings1BowlerList.get(8).getRuns_conceded().toString();
                        bowling_a_1_player_9_wickets =teamAinnings1BowlerList.get(8).getWickets().toString();
                        bowling_a_1_player_9_extras = Integer.toString(teamAinnings1BowlerList.get(8).getWides()+teamAinnings1BowlerList.get(8).getNoballs());
                        bowling_a_1_player_9_maiden_overs = teamAinnings1BowlerList.get(8).getMaidens().toString();
                        bowling_a_1_player_9_overs = teamAinnings1BowlerList.get(8).getOvers();
                    }
                    //player 10
                    if(teamAinnings1BowlerList.size()>=10)
                    {
                        bowling_a_1_player_10_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(9)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_10_economy = teamAinnings1BowlerList.get(9).getEcon();
                        bowling_a_1_player_10_runs = teamAinnings1BowlerList.get(9).getRuns_conceded().toString();
                        bowling_a_1_player_10_wickets =teamAinnings1BowlerList.get(9).getWickets().toString();
                        bowling_a_1_player_10_extras = Integer.toString(teamAinnings1BowlerList.get(9).getWides()+teamAinnings1BowlerList.get(9).getNoballs());
                        bowling_a_1_player_10_maiden_overs = teamAinnings1BowlerList.get(9).getMaidens().toString();
                        bowling_a_1_player_10_overs = teamAinnings1BowlerList.get(9).getOvers();
                    }
                    //player 11
                    if(teamAinnings1BowlerList.size()>=11)
                    {
                        bowling_a_1_player_11_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BowlerList.get(10)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_1_player_11_economy = teamAinnings1BowlerList.get(10).getEcon();
                        bowling_a_1_player_11_runs = teamAinnings1BowlerList.get(10).getRuns_conceded().toString();
                        bowling_a_1_player_11_wickets =teamAinnings1BowlerList.get(10).getWickets().toString();
                        bowling_a_1_player_11_extras = Integer.toString(teamAinnings1BowlerList.get(10).getWides()+teamAinnings1BowlerList.get(10).getNoballs());
                        bowling_a_1_player_11_maiden_overs = teamAinnings1BowlerList.get(10).getMaidens().toString();
                        bowling_a_1_player_11_overs = teamAinnings1BowlerList.get(10).getOvers();
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            /*Initialize Innings 3 bowler list*/
            if(matchScorecard.getResponse().getInnings().size() >= 3)
            {
                try{
                    //player 1
                    if(teamBinnings2BowlerList.size()>=1)
                    {
                        bowling_b_2_player_1_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(0)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_1_economy = teamBinnings2BowlerList.get(0).getEcon();
                        bowling_b_2_player_1_runs = teamBinnings2BowlerList.get(0).getRuns_conceded().toString();
                        bowling_b_2_player_1_wickets =teamBinnings2BowlerList.get(0).getWickets().toString();
                        bowling_b_2_player_1_extras = Integer.toString(teamBinnings2BowlerList.get(0).getWides()+teamBinnings2BowlerList.get(0).getNoballs());
                        bowling_b_2_player_1_maiden_overs = teamBinnings2BowlerList.get(0).getMaidens().toString();
                        bowling_b_2_player_1_overs = teamBinnings2BowlerList.get(0).getOvers();
                    }
                    //player 2
                    if(teamBinnings2BowlerList.size()>=2)
                    {
                        bowling_b_2_player_2_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(1)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_2_economy = teamBinnings2BowlerList.get(1).getEcon();
                        bowling_b_2_player_2_runs = teamBinnings2BowlerList.get(1).getRuns_conceded().toString();
                        bowling_b_2_player_2_wickets =teamBinnings2BowlerList.get(1).getWickets().toString();
                        bowling_b_2_player_2_extras = Integer.toString(teamBinnings2BowlerList.get(1).getWides()+teamBinnings2BowlerList.get(1).getNoballs());
                        bowling_b_2_player_2_maiden_overs = teamBinnings2BowlerList.get(1).getMaidens().toString();
                        bowling_b_2_player_2_overs = teamBinnings2BowlerList.get(1).getOvers();

                    }
                    //player 3
                    if(teamBinnings2BowlerList.size()>=3)
                    {
                        bowling_b_2_player_3_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(2)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_3_economy = teamBinnings2BowlerList.get(2).getEcon();
                        bowling_b_2_player_3_runs = teamBinnings2BowlerList.get(2).getRuns_conceded().toString();
                        bowling_b_2_player_3_wickets =teamBinnings2BowlerList.get(2).getWickets().toString();
                        bowling_b_2_player_3_extras = Integer.toString(teamBinnings2BowlerList.get(2).getWides()+teamBinnings2BowlerList.get(2).getNoballs());
                        bowling_b_2_player_3_maiden_overs = teamBinnings2BowlerList.get(2).getMaidens().toString();
                        bowling_b_2_player_3_overs = teamBinnings2BowlerList.get(2).getOvers();
                    }
                    //player 4
                    if(teamBinnings2BowlerList.size()>=4)
                    {
                        bowling_b_2_player_4_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(3)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_4_economy = teamBinnings2BowlerList.get(3).getEcon();
                        bowling_b_2_player_4_runs = teamBinnings2BowlerList.get(3).getRuns_conceded().toString();
                        bowling_b_2_player_4_wickets =teamBinnings2BowlerList.get(3).getWickets().toString();
                        bowling_b_2_player_4_extras = Integer.toString(teamBinnings2BowlerList.get(3).getWides()+teamBinnings2BowlerList.get(3).getNoballs());
                        bowling_b_2_player_4_maiden_overs = teamBinnings2BowlerList.get(3).getMaidens().toString();
                        bowling_b_2_player_4_overs = teamBinnings2BowlerList.get(3).getOvers();
                    }
                    //player 5
                    if(teamBinnings2BowlerList.size()>=5)
                    {
                        bowling_b_2_player_5_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(4)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_5_economy = teamBinnings2BowlerList.get(4).getEcon();
                        bowling_b_2_player_5_runs = teamBinnings2BowlerList.get(4).getRuns_conceded().toString();
                        bowling_b_2_player_5_wickets =teamBinnings2BowlerList.get(4).getWickets().toString();
                        bowling_b_2_player_5_extras = Integer.toString(teamBinnings2BowlerList.get(4).getWides()+teamBinnings2BowlerList.get(4).getNoballs());
                        bowling_b_2_player_5_maiden_overs = teamBinnings2BowlerList.get(4).getMaidens().toString();
                        bowling_b_2_player_5_overs = teamBinnings2BowlerList.get(4).getOvers();
                    }
                    //player 6
                    if(teamBinnings2BowlerList.size()>=6)
                    {
                        bowling_b_2_player_6_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(5)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_6_economy = teamBinnings2BowlerList.get(5).getEcon();
                        bowling_b_2_player_6_runs = teamBinnings2BowlerList.get(5).getRuns_conceded().toString();
                        bowling_b_2_player_6_wickets =teamBinnings2BowlerList.get(5).getWickets().toString();
                        bowling_b_2_player_6_extras = Integer.toString(teamBinnings2BowlerList.get(5).getWides()+teamBinnings2BowlerList.get(5).getNoballs());
                        bowling_b_2_player_6_maiden_overs = teamBinnings2BowlerList.get(5).getMaidens().toString();
                        bowling_b_2_player_6_overs = teamBinnings2BowlerList.get(5).getOvers();
                    }
                    //player 7
                    if(teamBinnings2BowlerList.size()>=7)
                    {
                        bowling_b_2_player_7_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(6)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_7_economy = teamBinnings2BowlerList.get(6).getEcon();
                        bowling_b_2_player_7_runs = teamBinnings2BowlerList.get(6).getRuns_conceded().toString();
                        bowling_b_2_player_7_wickets =teamBinnings2BowlerList.get(6).getWickets().toString();
                        bowling_b_2_player_7_extras = Integer.toString(teamBinnings2BowlerList.get(6).getWides()+teamBinnings2BowlerList.get(6).getNoballs());
                        bowling_b_2_player_7_maiden_overs = teamBinnings2BowlerList.get(6).getMaidens().toString();
                        bowling_b_2_player_7_overs = teamBinnings2BowlerList.get(6).getOvers();
                    }
                    //player 8
                    if(teamBinnings2BowlerList.size()>=8)
                    {
                        bowling_b_2_player_8_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(7)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_8_economy = teamBinnings2BowlerList.get(7).getEcon();
                        bowling_b_2_player_8_runs = teamBinnings2BowlerList.get(7).getRuns_conceded().toString();
                        bowling_b_2_player_8_wickets =teamBinnings2BowlerList.get(7).getWickets().toString();
                        bowling_b_2_player_8_extras = Integer.toString(teamBinnings2BowlerList.get(7).getWides()+teamBinnings2BowlerList.get(7).getNoballs());
                        bowling_b_2_player_8_maiden_overs = teamBinnings2BowlerList.get(7).getMaidens().toString();
                        bowling_b_2_player_8_overs = teamBinnings2BowlerList.get(7).getOvers();
                    }
                    //player 9
                    if(teamBinnings2BowlerList.size()>=9)
                    {
                        bowling_b_2_player_9_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(8)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_9_economy = teamBinnings2BowlerList.get(8).getEcon();
                        bowling_b_2_player_9_runs = teamBinnings2BowlerList.get(8).getRuns_conceded().toString();
                        bowling_b_2_player_9_wickets =teamBinnings2BowlerList.get(8).getWickets().toString();
                        bowling_b_2_player_9_extras = Integer.toString(teamBinnings2BowlerList.get(8).getWides()+teamBinnings2BowlerList.get(8).getNoballs());
                        bowling_b_2_player_9_maiden_overs = teamBinnings2BowlerList.get(8).getMaidens().toString();
                        bowling_b_2_player_9_overs = teamBinnings2BowlerList.get(8).getOvers();
                    }
                    //player 10
                    if(teamBinnings2BowlerList.size()>=10)
                    {
                        bowling_b_2_player_10_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(9)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_10_economy = teamBinnings2BowlerList.get(9).getEcon();
                        bowling_b_2_player_10_runs = teamBinnings2BowlerList.get(9).getRuns_conceded().toString();
                        bowling_b_2_player_10_wickets =teamBinnings2BowlerList.get(9).getWickets().toString();
                        bowling_b_2_player_10_extras = Integer.toString(teamBinnings2BowlerList.get(9).getWides()+teamBinnings2BowlerList.get(9).getNoballs());
                        bowling_b_2_player_10_maiden_overs = teamBinnings2BowlerList.get(9).getMaidens().toString();
                        bowling_b_2_player_10_overs = teamBinnings2BowlerList.get(9).getOvers();
                    }
                    //player 11
                    if(teamBinnings2BowlerList.size()>=11)
                    {
                        bowling_b_2_player_11_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BowlerList.get(10)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_b_2_player_11_economy = teamBinnings2BowlerList.get(10).getEcon();
                        bowling_b_2_player_11_runs = teamBinnings2BowlerList.get(10).getRuns_conceded().toString();
                        bowling_b_2_player_11_wickets =teamBinnings2BowlerList.get(10).getWickets().toString();
                        bowling_b_2_player_11_extras = Integer.toString(teamBinnings2BowlerList.get(10).getWides()+teamBinnings2BowlerList.get(10).getNoballs());
                        bowling_b_2_player_11_maiden_overs = teamBinnings2BowlerList.get(10).getMaidens().toString();
                        bowling_b_2_player_11_overs = teamBinnings2BowlerList.get(10).getOvers();
                    }

                }
                catch(Exception e)
                {e.printStackTrace();}

            }
            /*Initialize Innings 4 bowler list*/
            if(matchScorecard.getResponse().getInnings().size() >= 4)
            {
                try{
                    //player 1
                    if(teamAinnings2BowlerList.size()>=1)
                    {

                           bowling_a_2_player_1_name =   playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(0)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_1_economy = teamAinnings2BowlerList.get(0).getEcon();
                        bowling_a_2_player_1_runs = teamAinnings2BowlerList.get(0).getRuns_conceded().toString();
                        bowling_a_2_player_1_wickets =teamAinnings2BowlerList.get(0).getWickets().toString();
                        bowling_a_2_player_1_extras = Integer.toString(teamAinnings2BowlerList.get(0).getWides()+teamAinnings2BowlerList.get(0).getNoballs());
                        bowling_a_2_player_1_maiden_overs = teamAinnings2BowlerList.get(0).getMaidens().toString();
                        bowling_a_2_player_1_overs = teamAinnings2BowlerList.get(0).getOvers();
                    }
                    //player 2
                    if(teamAinnings2BowlerList.size()>=2)
                    {
                        bowling_a_2_player_2_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(1)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();

                        bowling_a_2_player_2_economy = teamAinnings2BowlerList.get(1).getEcon();
                        bowling_a_2_player_2_runs = teamAinnings2BowlerList.get(1).getRuns_conceded().toString();
                        bowling_a_2_player_2_wickets =teamAinnings2BowlerList.get(1).getWickets().toString();
                        bowling_a_2_player_2_extras = Integer.toString(teamAinnings2BowlerList.get(1).getWides()+teamAinnings2BowlerList.get(1).getNoballs());
                        bowling_a_2_player_2_maiden_overs = teamAinnings2BowlerList.get(1).getMaidens().toString();
                        bowling_a_2_player_2_overs = teamAinnings2BowlerList.get(1).getOvers();
                    }
                    //player 3
                    if(teamAinnings2BowlerList.size()>=3)
                    {
                        bowling_a_2_player_3_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(2)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_3_economy = teamAinnings2BowlerList.get(2).getEcon();
                        bowling_a_2_player_3_runs = teamAinnings2BowlerList.get(2).getRuns_conceded().toString();
                        bowling_a_2_player_3_wickets =teamAinnings2BowlerList.get(2).getWickets().toString();
                        bowling_a_2_player_3_extras = Integer.toString(teamAinnings2BowlerList.get(2).getWides()+teamAinnings2BowlerList.get(2).getNoballs());
                        bowling_a_2_player_3_maiden_overs = teamAinnings2BowlerList.get(2).getMaidens().toString();
                        bowling_a_2_player_3_overs = teamAinnings2BowlerList.get(2).getOvers();
                    }
                    //player 4
                    if(teamAinnings2BowlerList.size()>=4)
                    {
                        bowling_a_2_player_4_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(3)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_4_economy = teamAinnings2BowlerList.get(3).getEcon();
                        bowling_a_2_player_4_runs = teamAinnings2BowlerList.get(3).getRuns_conceded().toString();
                        bowling_a_2_player_4_wickets =teamAinnings2BowlerList.get(3).getWickets().toString();
                        bowling_a_2_player_4_extras = Integer.toString(teamAinnings2BowlerList.get(3).getWides()+teamAinnings2BowlerList.get(3).getNoballs());
                        bowling_a_2_player_4_maiden_overs = teamAinnings2BowlerList.get(3).getMaidens().toString();
                        bowling_a_2_player_4_overs = teamAinnings2BowlerList.get(3).getOvers();
                    }
                    //player 5
                    if(teamAinnings2BowlerList.size()>=5)
                    {
                        bowling_a_2_player_5_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(4)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_5_economy = teamAinnings2BowlerList.get(4).getEcon();
                        bowling_a_2_player_5_runs = teamAinnings2BowlerList.get(4).getRuns_conceded().toString();
                        bowling_a_2_player_5_wickets =teamAinnings2BowlerList.get(4).getWickets().toString();
                        bowling_a_2_player_5_extras = Integer.toString(teamAinnings2BowlerList.get(4).getWides()+teamAinnings2BowlerList.get(4).getNoballs());
                        bowling_a_2_player_5_maiden_overs = teamAinnings2BowlerList.get(4).getMaidens().toString();
                        bowling_a_2_player_5_overs = teamAinnings2BowlerList.get(4).getOvers();
                    }
                    //player 6
                    if(teamAinnings2BowlerList.size()>=6)
                    {
                        bowling_a_2_player_6_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(5)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();;
                        bowling_a_2_player_6_economy = teamAinnings2BowlerList.get(5).getEcon();
                        bowling_a_2_player_6_runs = teamAinnings2BowlerList.get(5).getRuns_conceded().toString();
                        bowling_a_2_player_6_wickets =teamAinnings2BowlerList.get(5).getWickets().toString();
                        bowling_a_2_player_6_extras = Integer.toString(teamAinnings2BowlerList.get(5).getWides()+teamAinnings2BowlerList.get(5).getNoballs());
                        bowling_a_2_player_6_maiden_overs = teamAinnings2BowlerList.get(5).getMaidens().toString();
                        bowling_a_2_player_6_overs = teamAinnings2BowlerList.get(5).getOvers();
                    }
                    //player 7
                    if(teamAinnings2BowlerList.size()>=7)
                    {
                        bowling_a_2_player_7_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(6)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_7_economy = teamAinnings2BowlerList.get(6).getEcon();
                        bowling_a_2_player_7_runs = teamAinnings2BowlerList.get(6).getRuns_conceded().toString();
                        bowling_a_2_player_7_wickets =teamAinnings2BowlerList.get(6).getWickets().toString();
                        bowling_a_2_player_7_extras = Integer.toString(teamAinnings2BowlerList.get(6).getWides()+teamAinnings2BowlerList.get(6).getNoballs());
                        bowling_a_2_player_7_maiden_overs = teamAinnings2BowlerList.get(6).getMaidens().toString();
                        bowling_a_2_player_7_overs = teamAinnings2BowlerList.get(6).getOvers();
                    }
                    //player 8
                    if(teamAinnings2BowlerList.size()>=8)
                    {
                        bowling_a_2_player_8_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(7)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_8_economy = teamAinnings2BowlerList.get(7).getEcon();
                        bowling_a_2_player_8_runs = teamAinnings2BowlerList.get(7).getRuns_conceded().toString();
                        bowling_a_2_player_8_wickets =teamAinnings2BowlerList.get(7).getWickets().toString();
                        bowling_a_2_player_8_extras = Integer.toString(teamAinnings2BowlerList.get(7).getWides()+teamAinnings2BowlerList.get(7).getNoballs());
                        bowling_a_2_player_8_maiden_overs = teamAinnings2BowlerList.get(7).getMaidens().toString();
                        bowling_a_2_player_8_overs = teamAinnings2BowlerList.get(7).getOvers();
                    }
                    //player 9
                    if(teamAinnings2BowlerList.size()>=9)
                    {
                        bowling_a_2_player_9_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(8)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_9_economy = teamAinnings2BowlerList.get(8).getEcon();
                        bowling_a_2_player_9_runs = teamAinnings2BowlerList.get(8).getRuns_conceded().toString();
                        bowling_a_2_player_9_wickets =teamAinnings2BowlerList.get(8).getWickets().toString();
                        bowling_a_2_player_9_extras = Integer.toString(teamAinnings2BowlerList.get(8).getWides()+teamAinnings2BowlerList.get(8).getNoballs());
                        bowling_a_2_player_9_maiden_overs = teamAinnings2BowlerList.get(8).getMaidens().toString();
                        bowling_a_2_player_9_overs = teamAinnings2BowlerList.get(8).getOvers();
                    }
                    //player 10
                    if(teamAinnings2BowlerList.size()>=10)
                    {
                        bowling_a_2_player_10_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(9)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_10_economy = teamAinnings2BowlerList.get(9).getEcon();
                        bowling_a_2_player_10_runs = teamAinnings2BowlerList.get(9).getRuns_conceded().toString();
                        bowling_a_2_player_10_wickets =teamAinnings2BowlerList.get(9).getWickets().toString();
                        bowling_a_2_player_10_extras = Integer.toString(teamAinnings2BowlerList.get(9).getWides()+teamAinnings2BowlerList.get(9).getNoballs());
                        bowling_a_2_player_10_maiden_overs = teamAinnings2BowlerList.get(9).getMaidens().toString();
                        bowling_a_2_player_10_overs = teamAinnings2BowlerList.get(9).getOvers();
                    }
                    //player 11
                    if(teamAinnings2BowlerList.size()>=11)
                    {
                        bowling_a_2_player_11_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BowlerList.get(10)
                                        .getBowler_id())).findFirst()
                                .orElse(null).getTitle();
                        bowling_a_2_player_11_economy = teamAinnings2BowlerList.get(10).getEcon();
                        bowling_a_2_player_11_runs = teamAinnings2BowlerList.get(10).getRuns_conceded().toString();
                        bowling_a_2_player_11_wickets =teamAinnings2BowlerList.get(10).getWickets().toString();
                        bowling_a_2_player_11_extras = Integer.toString(teamAinnings2BowlerList.get(10).getWides()+teamAinnings2BowlerList.get(10).getNoballs());
                        bowling_a_2_player_11_maiden_overs = teamAinnings2BowlerList.get(10).getMaidens().toString();
                        bowling_a_2_player_11_overs = teamAinnings2BowlerList.get(10).getOvers();
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }




    private String team_a = null;
    private String team_a_full_name = null;

    private String team_b = null;
    private String team_b_full_name = null;
    private String team_a_url = null;
    private String team_b_url = null;


    /*didn't map these 3*/
    private String related_name;
    private String msgs_result;
    private List<String> msgs_others;



    private String toss_decision = null;
    private String toss_won = null;
    private String toss_str = null;
   /* didn't map*/
    private String winner_team;




    //innings -> A_1
    private List<String> innings_A_1_batting_order  = null;
    private int innings_A_1_runs;
    //didn't map
    private int innings_A_1_balls;
    private List<String> innings_A_1_fall_of_wickets  = null;
    private int innings_A_1_wide;
    private String innings_A_1_run_rate  = null;

    //didn't map
    private int innings_A_1_fours;

    private String innings_A_1_run_str  = null;
    private int innings_A_1_wickets;

    //didn't map
    private List<String> innings_A_1_wicket_order;

    private int innings_A_1_extras;
    private List<String> innings_A_1_bowling_order  = null;

    //didn't map
    private String innings_A_1_key;

    private int innings_A_1_noball;
    //didn't map
    private int innings_A_1_sixes;

    private int innings_A_1_legbye;
    private int innings_A_1_bye;
    private String innings_A_1_overs  = null;

    //didn't map
    private int innings_A_1_dotballs;

    //////////////////////////////////
    /////B_1


    private List<String> innings_B_1_batting_order  = null;

    private int innings_B_1_runs;

    private int innings_B_1_balls;

    private List<String> innings_B_1_fall_of_wickets  = null;

    private int innings_B_1_wide;

    private String innings_B_1_run_rate  = null;

    private int innings_B_1_fours;

    private String innings_B_1_run_str  = null;

    private int innings_B_1_wickets;

    private List<String> innings_B_1_wicket_order  = null;

    private int innings_B_1_extras;

    private List<String> innings_B_1_bowling_order  = null;

    private String innings_B_1_key  = null;

    private int innings_B_1_noball;

    private int innings_B_1_sixes;

    private int innings_B_1_legbye;

    private int innings_B_1_bye;

    private String innings_B_1_overs  = null;

    private int innings_B_1_dotballs;


    ///////////////////////////

//A_2

    private List<String> innings_A_2_batting_order  = null;

    private int innings_A_2_runs;

    private int innings_A_2_balls;

    private List<String> innings_A_2_fall_of_wickets  = null;

    private int innings_A_2_wide;

    private String innings_A_2_run_rate  = null;

    private int innings_A_2_fours;

    private String innings_A_2_run_str  = null;

    private int innings_A_2_wickets;

    private List<String> innings_A_2_wicket_order = null;

    private int innings_A_2_extras;

    private List<String> innings_A_2_bowling_order  = null;

    private String innings_A_2_key  = null;

    private int innings_A_2_noball;

    private int innings_A_2_sixes;

    private int innings_A_2_legbye;

    private int innings_A_2_bye;

    private String innings_A_2_overs = null;

    private int innings_A_2_dotballs;

    //////////////////////////////////
    /////B_2


    private List<String> innings_B_2_batting_order = null;

    private int innings_B_2_runs;

    private int innings_B_2_balls;

    private List<String> innings_B_2_fall_of_wickets = null;

    private int innings_B_2_wide;

    private String innings_B_2_run_rate = null;

    private int innings_B_2_fours;

    private String innings_B_2_run_str = null;

    private int innings_B_2_wickets;

    private List<String> innings_B_2_wicket_order = null;

    private int innings_B_2_extras;

    private List<String> innings_B_2_bowling_order = null;

    private String innings_B_2_key;

    private int innings_B_2_noball;

    private int innings_B_2_sixes;

    private int innings_B_2_legbye;

    private int innings_B_2_bye;

    private String innings_B_2_overs = null;

    private int innings_B_2_dotballs;



   /*others properties*/
    private boolean dl_applied;

    private String status;

    private String man_of_match;
    //didn't map
    private String description;

    private String short_name;

    private String format;

    private Integer format_code;

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

    private String current_batting_team;
    private String current_runrate;




    /*Initializing Match properties*/
    public void initializeMatchProperty()
    {
        key = matchScorecard.getResponse().getMatch_id().toString();

        short_name = matchScorecard.getResponse().getCompetition().getTitle();

        related_name = matchScorecard.getResponse().getTitle();


        try{

            format = matchScorecard.getResponse().getFormat_str();
            format_code =matchScorecard.getResponse().getFormat();

            name = matchScorecard.getResponse().getTitle();
            venue = matchScorecard.getResponse().getVenue().getName()+", "+matchScorecard.getResponse().getVenue().getLocation();
            toss_decision = matchScorecard.getResponse().getToss().getDecision().toString();
            toss_won = matchScorecard.getResponse().getToss().getWinner().toString();
            toss_str = matchScorecard.getResponse().getToss().getText();

            try{

                /*Initializing Matchs first innings properties*/
                if(matchScorecard.getResponse().getInnings().size() >= 1)
                {

                   /* matching innings1.getBatsmen() list with  playerListForScorecard list by batsman_id and made a list of player*/
                    List<Player> innings1battingOrderList = innings1.getBatsmen().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                   /* matching innings1.getFows() list with  playerListForScorecard list by batsman_id and made a list of player*/
                    List<Player> innings1Fow = innings1.getFows().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    /*getting bowler list from list of player matching with id */
                    List<Player>innings1BowlingOrder = innings1.getBowlers().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBowler_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    /*spliting score with "/" */
                    String[] scoreArr = innings1.getScores().split("/");


                        innings_A_1_batting_order = innings1battingOrderList.stream()
                                .map(Player::getTitle)
                                .collect(Collectors.toList());
                        innings_A_1_runs = Integer.parseInt(scoreArr[0]);
                        innings_A_1_fall_of_wickets = innings1Fow.stream().map(Player::getTitle)
                                .collect(Collectors.toList());
                        innings_A_1_wide = innings1.getExtra_runs().getWides();
                        innings_A_1_run_rate = innings1.getEquations().getRunrate();
                        innings_A_1_run_str = innings1.getScores_full();
                        innings_A_1_wickets = innings1.getEquations().getWickets();
                        innings_A_1_extras = innings1.getExtra_runs().getTotal();


                        innings_A_1_bowling_order = innings1BowlingOrder.
                                stream().map(Player::getTitle)
                                .collect(Collectors.toList());

                        innings_A_1_noball = innings1.getExtra_runs().getNoballs();
                        innings_A_1_legbye = innings1.getExtra_runs().getLegbyes();
                        innings_A_1_bye = innings1.getExtra_runs().getByes();
                        innings_A_1_overs = innings1.getEquations().getOvers();
                }


                /*Initializing Matchs second innings properties*/
                if(matchScorecard.getResponse().getInnings().size() >= 2)
                {
                   /*matching innings1.getBatsmen() list with  playerListForScorecard list by batsman_id and made a list of player*/
                    List<Player> innings2battingOrderList = innings2.getBatsmen().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    /*matching innings1.getFows() list with  playerListForScorecard list by batsman_id and made a list of player*/
                    List<Player> innings2Fow = innings2.getFows().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    /*matching innings1.getFows() list with  playerListForScorecard list by batsman_id and made a list of player*/
                    List<Player>innings2BowlingOrder = innings2.getBowlers().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBowler_id().equals(y.getPid()))).
                            collect(Collectors.toList());
                    /*spliting score with "/"*/
                    String[] scoreArr = innings2.getScores().split("/");

                        innings_B_1_batting_order = innings2battingOrderList.
                                stream().map(Player::getTitle)
                                .collect(Collectors.toList());
                        innings_B_1_runs = Integer.parseInt(scoreArr[0]);
                        innings_B_1_fall_of_wickets = innings2Fow.stream().map(Player::getTitle)
                                .collect(Collectors.toList());
                        innings_B_1_wide = innings2.getExtra_runs().getWides();
                        innings_B_1_run_rate = innings2.getEquations().getRunrate();
                        innings_B_1_run_str = innings2.getScores_full();
                        innings_B_1_wickets = innings2.getEquations().getWickets();
                        innings_B_1_extras = innings2.getExtra_runs().getTotal();

                       /* I know that here will be a problem*/
                        innings_B_1_bowling_order = innings2BowlingOrder.
                                stream().map(Player::getTitle)
                                .collect(Collectors.toList());
                        innings_B_1_noball = innings2.getExtra_runs().getNoballs();
                        innings_B_1_legbye = innings2.getExtra_runs().getLegbyes();
                        innings_B_1_bye = innings2.getExtra_runs().getByes();
                        innings_B_1_overs = innings2.getEquations().getOvers();
                }

               /* Initializing Matchs third innings properties*/
                if(matchScorecard.getResponse().getInnings().size() >= 3)
                {

                    List<Player> innings3battingOrderList = innings3.getBatsmen().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    innings_A_2_batting_order = innings3battingOrderList.
                            stream().map(Player::getTitle)
                            .collect(Collectors.toList());

                    String[] scoreArr = innings3.getScores().split("/");

                    innings_A_2_runs = Integer.parseInt(scoreArr[0]);

                    List<Player> innings3Fow = innings3.getFows().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());



                    innings_A_2_fall_of_wickets =innings3Fow.stream().map(Player::getTitle)
                            .collect(Collectors.toList());

                    innings_A_2_wide = innings3.getExtra_runs().getWides();

                    innings_A_2_run_rate = innings3.getEquations().getRunrate();

                    innings_A_2_run_str = innings3.getScores_full();

                    innings_A_2_wickets = innings3.getEquations().getWickets();

                    innings_A_2_extras = innings3.getExtra_runs().getTotal();

                    List<Player>innings3BowlingOrder = innings3.getBowlers().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBowler_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    innings_A_2_bowling_order = innings3BowlingOrder.
                            stream().map(Player::getTitle)
                            .collect(Collectors.toList());

                    innings_A_2_noball = innings3.getExtra_runs().getNoballs();

                    innings_A_2_legbye = innings3.getExtra_runs().getLegbyes();

                    innings_A_2_bye = innings3.getExtra_runs().getByes();

                    innings_A_2_overs = innings3.getEquations().getOvers();
                }

                /*Initializing Matchs forth innings properties*/
                if(matchScorecard.getResponse().getInnings().size() >= 4)
                {
                    List<Player> innings4battingOrderList = innings4.getBatsmen().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    innings_B_2_batting_order = innings4battingOrderList.
                            stream().map(Player::getTitle)
                            .collect(Collectors.toList());

                    String[] scoreArr = innings4.getScores().split("/");
                    innings_B_2_runs = Integer.parseInt(scoreArr[0]);

                    List<Player> innings4Fow = innings4.getFows().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBatsman_id().equals(y.getPid()))).
                            collect(Collectors.toList());


                    innings_B_2_fall_of_wickets = innings4Fow.stream().map(Player::getTitle)
                            .collect(Collectors.toList());

                    innings_B_2_wide = innings4.getExtra_runs().getWides();

                    innings_B_2_run_rate = innings4.getEquations().getRunrate();

                    innings_B_2_run_str = innings4.getScores_full();

                    innings_B_2_wickets = innings4.getEquations().getWickets();

                    innings_B_2_extras = innings4.getExtra_runs().getTotal();

                    List<Player>innings4BowlingOrder = innings4.getBowlers().stream().
                            flatMap(x->playerListForScorecard.stream().
                                    filter(y->x.getBowler_id().equals(y.getPid()))).
                            collect(Collectors.toList());

                    innings_B_2_bowling_order = innings4BowlingOrder.
                            stream().map(Player::getTitle)
                            .collect(Collectors.toList());

                    innings_B_2_noball = innings4.getExtra_runs().getNoballs();

                    innings_B_2_legbye = innings4.getExtra_runs().getLegbyes();

                    innings_B_2_bye = innings4.getExtra_runs().getByes();

                    innings_B_2_overs = innings4.getEquations().getOvers();
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            status = matchScorecard.getResponse().getStatus();

            start_date_timestamp = matchScorecard.getResponse().getTimestamp_start();

            start_date_str = TimeFormatter.gmtTimeformatter(matchScorecard.getResponse().getDate_start().toString());

            String[] dateTime = matchScorecard.getResponse().getDate_start().split(" ");

            date = dateTime[0];
            time = dateTime[1];
            msgs_result = matchScorecard.getResponse().getStatus_note();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }


    //a_1

    //player_1
    private String innings_A_1_batting_player_1_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_1_innings_1_sixes = null;
    private String innings_A_1_batting_player_1_innings_1_fours = null;
    private String innings_A_1_batting_player_1_innings_1_balls = null;
    private String innings_A_1_batting_player_1_innings_1_runs = null;
    private String innings_A_1_batting_player_1_innings_1_out_comment = null;
    private String innings_A_1_batting_player_1_innings_1_strike_rate = null;
    //didn't map
    private String innings_A_1_bowling_player_1_innings_1_maiden_overs = null;

    //innings 2
    private String innings_A_1_batting_player_1_innings_2_full_name=null;
    private String innings_A_1_batting_player_1_innings_2_sixes = null;
    private String innings_A_1_batting_player_1_innings_2_fours = null;
    private String innings_A_1_batting_player_1_innings_2_balls = null;
    private String innings_A_1_batting_player_1_innings_2_runs = null;
    private String innings_A_1_batting_player_1_innings_2_out_comment = null;
    private String innings_A_1_batting_player_1_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_1_innings_2_maiden_overs = null;


    //player_2
    private String innings_A_1_batting_player_2_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_2_innings_1_sixes = null;
    private String innings_A_1_batting_player_2_innings_1_fours = null;
    private String innings_A_1_batting_player_2_innings_1_balls = null;
    private String innings_A_1_batting_player_2_innings_1_runs = null;
    private String innings_A_1_batting_player_2_innings_1_out_comment = null;
    private String innings_A_1_bowling_player_2_innings_1_maiden_overs = null;
    private String innings_A_1_batting_player_2_innings_1_strike_rate = null;
    //innings 2
    private String innings_A_1_batting_player_2_innings_2_full_name=null;
    private String innings_A_1_batting_player_2_innings_2_sixes = null;
    private String innings_A_1_batting_player_2_innings_2_fours = null;
    private String innings_A_1_batting_player_2_innings_2_balls = null;
    private String innings_A_1_batting_player_2_innings_2_runs = null;
    private String innings_A_1_batting_player_2_innings_2_out_comment = null;
    private String innings_A_1_batting_player_2_innings_2_strike_rate = null;
    private String innings_A_1_bowling_player_2_innings_2_maiden_overs = null;


    //player_3
    private String innings_A_1_batting_player_3_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_3_innings_1_sixes = null;
    private String innings_A_1_batting_player_3_innings_1_fours = null;
    private String innings_A_1_batting_player_3_innings_1_balls = null;
    private String innings_A_1_batting_player_3_innings_1_runs = null;
    private String innings_A_1_batting_player_3_innings_1_out_comment = null;
    private String innings_A_1_batting_player_3_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_3_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_3_innings_2_full_name;
    private String innings_A_1_batting_player_3_innings_2_sixes = null;
    private String innings_A_1_batting_player_3_innings_2_fours = null;
    private String innings_A_1_batting_player_3_innings_2_balls = null;
    private String innings_A_1_batting_player_3_innings_2_runs = null;
    private String innings_A_1_batting_player_3_innings_2_out_comment = null;
    private String innings_A_1_batting_player_3_innings_2_strike_rate = null;
    private String innings_A_1_bowling_player_3_innings_2_maiden_overs = null;


    //player_4
    private String innings_A_1_batting_player_4_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_4_innings_1_sixes = null;
    private String innings_A_1_batting_player_4_innings_1_fours = null;
    private String innings_A_1_batting_player_4_innings_1_balls = null;
    private String innings_A_1_batting_player_4_innings_1_runs = null;
    private String innings_A_1_batting_player_4_innings_1_out_comment = null;
    private String innings_A_1_batting_player_4_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_4_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_4_innings_2_full_name;
    private String innings_A_1_batting_player_4_innings_2_sixes = null;
    private String innings_A_1_batting_player_4_innings_2_fours = null;
    private String innings_A_1_batting_player_4_innings_2_balls = null;
    private String innings_A_1_batting_player_4_innings_2_runs = null;
    private String innings_A_1_batting_player_4_innings_2_out_comment = null;
    private String innings_A_1_batting_player_4_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_4_innings_2_maiden_overs = null;


    //player_5
    private String innings_A_1_batting_player_5_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_5_innings_1_sixes = null;
    private String innings_A_1_batting_player_5_innings_1_fours = null;
    private String innings_A_1_batting_player_5_innings_1_balls = null;
    private String innings_A_1_batting_player_5_innings_1_runs = null;
    private String innings_A_1_batting_player_5_innings_1_out_comment = null;
    private String innings_A_1_batting_player_5_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_5_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_5_innings_2_full_name;
    private String innings_A_1_batting_player_5_innings_2_sixes = null;
    private String innings_A_1_batting_player_5_innings_2_fours = null;
    private String innings_A_1_batting_player_5_innings_2_balls = null;
    private String innings_A_1_batting_player_5_innings_2_runs = null;
    private String innings_A_1_batting_player_5_innings_2_out_comment = null;
    private String innings_A_1_batting_player_5_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_5_innings_2_maiden_overs = null;


    //player_6
    private String innings_A_1_batting_player_6_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_6_innings_1_sixes = null;
    private String innings_A_1_batting_player_6_innings_1_fours = null;
    private String innings_A_1_batting_player_6_innings_1_balls = null;
    private String innings_A_1_batting_player_6_innings_1_runs = null;
    private String innings_A_1_batting_player_6_innings_1_out_comment = null;
    private String innings_A_1_batting_player_6_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_6_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_6_innings_2_full_name;
    private String innings_A_1_batting_player_6_innings_2_sixes = null;
    private String innings_A_1_batting_player_6_innings_2_fours = null;
    private String innings_A_1_batting_player_6_innings_2_balls = null;
    private String innings_A_1_batting_player_6_innings_2_runs = null;
    private String innings_A_1_batting_player_6_innings_2_out_comment = null;
    private String innings_A_1_batting_player_6_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_6_innings_2_maiden_overs = null;


    //player_7
    private String innings_A_1_batting_player_7_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_7_innings_1_sixes = null;
    private String innings_A_1_batting_player_7_innings_1_fours = null;
    private String innings_A_1_batting_player_7_innings_1_balls = null;
    private String innings_A_1_batting_player_7_innings_1_runs = null;
    private String innings_A_1_batting_player_7_innings_1_out_comment = null;
    private String innings_A_1_batting_player_7_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_7_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_7_innings_2_full_name;
    private String innings_A_1_batting_player_7_innings_2_sixes = null;
    private String innings_A_1_batting_player_7_innings_2_fours = null;
    private String innings_A_1_batting_player_7_innings_2_balls = null;
    private String innings_A_1_batting_player_7_innings_2_runs = null;
    private String innings_A_1_batting_player_7_innings_2_out_comment = null;
    private String innings_A_1_batting_player_7_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_7_innings_2_maiden_overs = null;


    //player_8
    private String innings_A_1_batting_player_8_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_8_innings_1_sixes = null;
    private String innings_A_1_batting_player_8_innings_1_fours = null;
    private String innings_A_1_batting_player_8_innings_1_balls = null;
    private String innings_A_1_batting_player_8_innings_1_runs = null;
    private String innings_A_1_batting_player_8_innings_1_out_comment = null;
    private String innings_A_1_batting_player_8_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_8_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_8_innings_2_full_name;
    private String innings_A_1_batting_player_8_innings_2_sixes = null;
    private String innings_A_1_batting_player_8_innings_2_fours = null;
    private String innings_A_1_batting_player_8_innings_2_balls = null;
    private String innings_A_1_batting_player_8_innings_2_runs = null;
    private String innings_A_1_batting_player_8_innings_2_out_comment = null;
    private String innings_A_1_batting_player_8_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_8_innings_2_maiden_overs = null;


    //player_9
    private String innings_A_1_batting_player_9_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_9_innings_1_sixes = null;
    private String innings_A_1_batting_player_9_innings_1_fours = null;
    private String innings_A_1_batting_player_9_innings_1_balls = null;
    private String innings_A_1_batting_player_9_innings_1_runs = null;
    private String innings_A_1_batting_player_9_innings_1_out_comment = null;
    private String innings_A_1_batting_player_9_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_9_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_9_innings_2_full_name;
    private String innings_A_1_batting_player_9_innings_2_sixes = null;
    private String innings_A_1_batting_player_9_innings_2_fours = null;
    private String innings_A_1_batting_player_9_innings_2_balls = null;
    private String innings_A_1_batting_player_9_innings_2_runs = null;
    private String innings_A_1_batting_player_9_innings_2_out_comment = null;
    private String innings_A_1_batting_player_9_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_9_innings_2_maiden_overs = null;


    //player_10
    private String innings_A_1_batting_player_10_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_10_innings_1_sixes = null;
    private String innings_A_1_batting_player_10_innings_1_fours = null;
    private String innings_A_1_batting_player_10_innings_1_balls = null;
    private String innings_A_1_batting_player_10_innings_1_runs = null;
    private String innings_A_1_batting_player_10_innings_1_out_comment = null;
    private String innings_A_1_batting_player_10_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_10_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_10_innings_2_full_name;
    private String innings_A_1_batting_player_10_innings_2_sixes = null;
    private String innings_A_1_batting_player_10_innings_2_fours = null;
    private String innings_A_1_batting_player_10_innings_2_balls = null;
    private String innings_A_1_batting_player_10_innings_2_runs = null;
    private String innings_A_1_batting_player_10_innings_2_out_comment = null;
    private String innings_A_1_batting_player_10_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_10_innings_2_maiden_overs = null;



    //player_11
    private String innings_A_1_batting_player_11_full_name = null;
    //innings 1
    private String innings_A_1_batting_player_11_innings_1_sixes = null;
    private String innings_A_1_batting_player_11_innings_1_fours = null;
    private String innings_A_1_batting_player_11_innings_1_balls = null;
    private String innings_A_1_batting_player_11_innings_1_runs = null;
    private String innings_A_1_batting_player_11_innings_1_out_comment = null;
    private String innings_A_1_batting_player_11_innings_1_strike_rate = null;
    private String innings_A_1_bowling_player_11_innings_1_maiden_overs = null;
    //innings 2
    private String innings_A_1_batting_player_11_innings_2_full_name;
    private String innings_A_1_batting_player_11_innings_2_sixes = null;
    private String innings_A_1_batting_player_11_innings_2_fours = null;
    private String innings_A_1_batting_player_11_innings_2_balls = null;
    private String innings_A_1_batting_player_11_innings_2_runs = null;
    private String innings_A_1_batting_player_11_innings_2_out_comment = null;
    private String innings_A_1_batting_player_11_innings_2_strike_rate = null;

    private String innings_A_1_bowling_player_11_innings_2_maiden_overs = null;


    ////////////////////////////////////////////////////////////////////////////

    //b_1

    //player_1
    private String innings_B_1_batting_player_1_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_1_innings_1_sixes = null;
    private String innings_B_1_batting_player_1_innings_1_fours = null;
    private String innings_B_1_batting_player_1_innings_1_balls = null;
    private String innings_B_1_batting_player_1_innings_1_runs = null;
    private String innings_B_1_batting_player_1_innings_1_out_comment = null;
    private String innings_B_1_batting_player_1_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_1_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_1_innings_2_full_name;
    private String innings_B_1_batting_player_1_innings_2_sixes = null;
    private String innings_B_1_batting_player_1_innings_2_fours = null;
    private String innings_B_1_batting_player_1_innings_2_balls = null;
    private String innings_B_1_batting_player_1_innings_2_runs = null;
    private String innings_B_1_batting_player_1_innings_2_out_comment = null;
    private String innings_B_1_batting_player_1_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_1_innings_2_maiden_overs = null;


    //player_2
    private String innings_B_1_batting_player_2_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_2_innings_1_sixes = null;
    private String innings_B_1_batting_player_2_innings_1_fours = null;
    private String innings_B_1_batting_player_2_innings_1_balls = null;
    private String innings_B_1_batting_player_2_innings_1_runs = null;
    private String innings_B_1_batting_player_2_innings_1_out_comment;
    private String innings_B_1_batting_player_2_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_2_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_2_innings_2_full_name;
    private String innings_B_1_batting_player_2_innings_2_sixes = null;
    private String innings_B_1_batting_player_2_innings_2_fours = null;
    private String innings_B_1_batting_player_2_innings_2_balls = null;
    private String innings_B_1_batting_player_2_innings_2_runs = null;
    private String innings_B_1_batting_player_2_innings_2_out_comment = null;
    private String innings_B_1_batting_player_2_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_2_innings_2_maiden_overs = null;

    //player_3
    private String innings_B_1_batting_player_3_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_3_innings_1_sixes = null;
    private String innings_B_1_batting_player_3_innings_1_fours = null;
    private String innings_B_1_batting_player_3_innings_1_balls = null;
    private String innings_B_1_batting_player_3_innings_1_runs = null;
    private String innings_B_1_batting_player_3_innings_1_out_comment = null;
    private String innings_B_1_batting_player_3_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_3_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_3_innings_2_full_name;
    private String innings_B_1_batting_player_3_innings_2_sixes = null;
    private String innings_B_1_batting_player_3_innings_2_fours = null;
    private String innings_B_1_batting_player_3_innings_2_balls = null;
    private String innings_B_1_batting_player_3_innings_2_runs = null;
    private String innings_B_1_batting_player_3_innings_2_out_comment = null;
    private String innings_B_1_batting_player_3_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_3_innings_2_maiden_overs = null;


    //player_4
    private String innings_B_1_batting_player_4_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_4_innings_1_sixes = null;
    private String innings_B_1_batting_player_4_innings_1_fours = null;
    private String innings_B_1_batting_player_4_innings_1_balls = null;
    private String innings_B_1_batting_player_4_innings_1_runs = null;
    private String innings_B_1_batting_player_4_innings_1_out_comment = null;
    private String innings_B_1_batting_player_4_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_4_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_4_innings_2_full_name;
    private String innings_B_1_batting_player_4_innings_2_sixes = null;
    private String innings_B_1_batting_player_4_innings_2_fours = null;
    private String innings_B_1_batting_player_4_innings_2_balls = null;
    private String innings_B_1_batting_player_4_innings_2_runs = null;
    private String innings_B_1_batting_player_4_innings_2_out_comment = null;
    private String innings_B_1_batting_player_4_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_4_innings_2_maiden_overs = null;

    //player_5
    private String innings_B_1_batting_player_5_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_5_innings_1_sixes = null;
    private String innings_B_1_batting_player_5_innings_1_fours = null;
    private String innings_B_1_batting_player_5_innings_1_balls = null;
    private String innings_B_1_batting_player_5_innings_1_runs = null;
    private String innings_B_1_batting_player_5_innings_1_out_comment = null;
    private String innings_B_1_batting_player_5_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_5_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_5_innings_2_full_name;
    private String innings_B_1_batting_player_5_innings_2_sixes = null;
    private String innings_B_1_batting_player_5_innings_2_fours = null;
    private String innings_B_1_batting_player_5_innings_2_balls = null;
    private String innings_B_1_batting_player_5_innings_2_runs = null;
    private String innings_B_1_batting_player_5_innings_2_out_comment = null;
    private String innings_B_1_batting_player_5_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_5_innings_2_maiden_overs = null;

    //player_6
    private String innings_B_1_batting_player_6_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_6_innings_1_sixes = null;
    private String innings_B_1_batting_player_6_innings_1_fours = null;
    private String innings_B_1_batting_player_6_innings_1_balls = null;
    private String innings_B_1_batting_player_6_innings_1_runs = null;
    private String innings_B_1_batting_player_6_innings_1_out_comment = null;
    private String innings_B_1_batting_player_6_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_6_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_6_innings_2_full_name;
    private String innings_B_1_batting_player_6_innings_2_sixes = null;
    private String innings_B_1_batting_player_6_innings_2_fours = null;
    private String innings_B_1_batting_player_6_innings_2_balls = null;
    private String innings_B_1_batting_player_6_innings_2_runs = null;
    private String innings_B_1_batting_player_6_innings_2_out_comment = null;
    private String innings_B_1_batting_player_6_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_6_innings_2_maiden_overs = null;

    //player_7
    private String innings_B_1_batting_player_7_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_7_innings_1_sixes = null;
    private String innings_B_1_batting_player_7_innings_1_fours = null;
    private String innings_B_1_batting_player_7_innings_1_balls = null;
    private String innings_B_1_batting_player_7_innings_1_runs = null;
    private String innings_B_1_batting_player_7_innings_1_out_comment = null;
    private String innings_B_1_batting_player_7_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_7_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_7_innings_2_full_name;
    private String innings_B_1_batting_player_7_innings_2_sixes = null;
    private String innings_B_1_batting_player_7_innings_2_fours = null;
    private String innings_B_1_batting_player_7_innings_2_balls = null;
    private String innings_B_1_batting_player_7_innings_2_runs = null;
    private String innings_B_1_batting_player_7_innings_2_out_comment = null;
    private String innings_B_1_batting_player_7_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_7_innings_2_maiden_overs = null;

    //player_8
    private String innings_B_1_batting_player_8_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_8_innings_1_sixes = null;
    private String innings_B_1_batting_player_8_innings_1_fours = null;
    private String innings_B_1_batting_player_8_innings_1_balls = null;
    private String innings_B_1_batting_player_8_innings_1_runs = null;
    private String innings_B_1_batting_player_8_innings_1_strike_rate = null;
    private String innings_B_1_batting_player_8_innings_1_out_comment = null;
    private String innings_B_1_bowling_player_8_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_8_innings_2_full_name;
    private String innings_B_1_batting_player_8_innings_2_sixes = null;
    private String innings_B_1_batting_player_8_innings_2_fours = null;
    private String innings_B_1_batting_player_8_innings_2_balls = null;
    private String innings_B_1_batting_player_8_innings_2_runs = null;
    private String innings_B_1_batting_player_8_innings_2_strike_rate = null;
    private String innings_B_1_batting_player_8_innings_2_out_comment = null;

    private String innings_B_1_bowling_player_8_innings_2_maiden_overs = null;

    //player_9
    private String innings_B_1_batting_player_9_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_9_innings_1_sixes = null;
    private String innings_B_1_batting_player_9_innings_1_fours = null;
    private String innings_B_1_batting_player_9_innings_1_balls = null;
    private String innings_B_1_batting_player_9_innings_1_runs = null;
    private String innings_B_1_batting_player_9_innings_1_out_comment = null;
    private String innings_B_1_batting_player_9_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_9_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_9_innings_2_full_name;
    private String innings_B_1_batting_player_9_innings_2_sixes = null;
    private String innings_B_1_batting_player_9_innings_2_fours = null;
    private String innings_B_1_batting_player_9_innings_2_balls = null;
    private String innings_B_1_batting_player_9_innings_2_runs = null;
    private String innings_B_1_batting_player_9_innings_2_out_comment = null;
    private String innings_B_1_batting_player_9_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_9_innings_2_maiden_overs = null;

    //player_10
    private String innings_B_1_batting_player_10_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_10_innings_1_sixes = null;
    private String innings_B_1_batting_player_10_innings_1_fours = null;
    private String innings_B_1_batting_player_10_innings_1_balls = null;
    private String innings_B_1_batting_player_10_innings_1_runs = null;
    private String innings_B_1_batting_player_10_innings_1_out_comment = null;
    private String innings_B_1_batting_player_10_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_10_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_10_innings_2_full_name;
    private String innings_B_1_batting_player_10_innings_2_sixes = null;
    private String innings_B_1_batting_player_10_innings_2_fours = null;
    private String innings_B_1_batting_player_10_innings_2_balls = null;
    private String innings_B_1_batting_player_10_innings_2_runs = null;
    private String innings_B_1_batting_player_10_innings_2_out_comment = null;
    private String innings_B_1_batting_player_10_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_10_innings_2_maiden_overs = null;

    //player_11
    private String innings_B_1_batting_player_11_full_name = null;
    //innings 1
    private String innings_B_1_batting_player_11_innings_1_sixes = null;
    private String innings_B_1_batting_player_11_innings_1_fours = null;
    private String innings_B_1_batting_player_11_innings_1_balls = null;
    private String innings_B_1_batting_player_11_innings_1_runs = null;
    private String innings_B_1_batting_player_11_innings_1_out_comment = null;
    private String innings_B_1_batting_player_11_innings_1_strike_rate = null;
    private String innings_B_1_bowling_player_11_innings_1_maiden_overs = null;
    //innings 2
    private String innings_B_1_batting_player_11_innings_2_full_name;
    private String innings_B_1_batting_player_11_innings_2_sixes = null;
    private String innings_B_1_batting_player_11_innings_2_fours = null;
    private String innings_B_1_batting_player_11_innings_2_balls = null;
    private String innings_B_1_batting_player_11_innings_2_runs = null;
    private String innings_B_1_batting_player_11_innings_2_out_comment = null;
    private String innings_B_1_batting_player_11_innings_2_strike_rate = null;

    private String innings_B_1_bowling_player_11_innings_2_maiden_overs = null;




    public void initializeAllInningsBatsmans()
    {
        try{
            /*Initializing first innings batsman*/
            if (matchScorecard.getResponse().getInnings().size() >= 1)
            {
                try{
                    //batsman 1
                    if(teamAinnings1BatsmanList.size()>=1)
                    {
                        /*filtering playerListForScorecard with batsman id to get batsman name*/
                        innings_A_1_batting_player_1_full_name =   playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(0)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_1_innings_1_sixes = teamAinnings1BatsmanList.get(0).getSixes().toString();
                        innings_A_1_batting_player_1_innings_1_fours = teamAinnings1BatsmanList.get(0).getFours().toString();
                        innings_A_1_batting_player_1_innings_1_balls = teamAinnings1BatsmanList.get(0).getBalls_faced().toString();
                        innings_A_1_batting_player_1_innings_1_runs = teamAinnings1BatsmanList.get(0).getRuns().toString();
                        innings_A_1_batting_player_1_innings_1_out_comment = teamAinnings1BatsmanList.get(0).getHow_out();
                        innings_A_1_batting_player_1_innings_1_strike_rate = teamAinnings1BatsmanList.get(0).getStrike_rate();
                    }
                    //batsman 2
                    if(teamAinnings1BatsmanList.size()>=2)
                    {
                        innings_A_1_batting_player_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(1)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_2_innings_1_sixes = teamAinnings1BatsmanList.get(1).getSixes().toString();
                        innings_A_1_batting_player_2_innings_1_fours = teamAinnings1BatsmanList.get(1).getFours().toString();
                        innings_A_1_batting_player_2_innings_1_balls = teamAinnings1BatsmanList.get(1).getBalls_faced().toString();
                        innings_A_1_batting_player_2_innings_1_runs = teamAinnings1BatsmanList.get(1).getRuns().toString();
                        innings_A_1_batting_player_2_innings_1_out_comment = teamAinnings1BatsmanList.get(1).getHow_out();
                        innings_A_1_batting_player_2_innings_1_strike_rate = teamAinnings1BatsmanList.get(1).getStrike_rate();
                    }
                    //batsman 3
                    if(teamAinnings1BatsmanList.size()>=3)
                    {
                        innings_A_1_batting_player_3_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(2)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_3_innings_1_sixes = teamAinnings1BatsmanList.get(2).getSixes().toString();
                        innings_A_1_batting_player_3_innings_1_fours = teamAinnings1BatsmanList.get(2).getFours().toString();
                        innings_A_1_batting_player_3_innings_1_balls = teamAinnings1BatsmanList.get(2).getBalls_faced().toString();
                        innings_A_1_batting_player_3_innings_1_runs = teamAinnings1BatsmanList.get(2).getRuns().toString();
                        innings_A_1_batting_player_3_innings_1_out_comment = teamAinnings1BatsmanList.get(2).getHow_out();
                        innings_A_1_batting_player_3_innings_1_strike_rate = teamAinnings1BatsmanList.get(2).getStrike_rate();
                    }
                    //batsman 4
                    if(teamAinnings1BatsmanList.size()>=4)
                    {
                        innings_A_1_batting_player_4_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(3)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_4_innings_1_sixes = teamAinnings1BatsmanList.get(3).getSixes().toString();
                        innings_A_1_batting_player_4_innings_1_fours = teamAinnings1BatsmanList.get(3).getFours().toString();
                        innings_A_1_batting_player_4_innings_1_balls = teamAinnings1BatsmanList.get(3).getBalls_faced().toString();
                        innings_A_1_batting_player_4_innings_1_runs = teamAinnings1BatsmanList.get(3).getRuns().toString();
                        innings_A_1_batting_player_4_innings_1_out_comment = teamAinnings1BatsmanList.get(3).getHow_out();
                        innings_A_1_batting_player_4_innings_1_strike_rate = teamAinnings1BatsmanList.get(3).getStrike_rate();

                    }
                    //batsman 5
                    if(teamAinnings1BatsmanList.size()>=5)
                    {
                        innings_A_1_batting_player_5_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(4)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_5_innings_1_sixes = teamAinnings1BatsmanList.get(4).getSixes().toString();
                        innings_A_1_batting_player_5_innings_1_fours = teamAinnings1BatsmanList.get(4).getFours().toString();
                        innings_A_1_batting_player_5_innings_1_balls = teamAinnings1BatsmanList.get(4).getBalls_faced().toString();
                        innings_A_1_batting_player_5_innings_1_runs = teamAinnings1BatsmanList.get(4).getRuns().toString();
                        innings_A_1_batting_player_5_innings_1_out_comment = teamAinnings1BatsmanList.get(4).getHow_out();
                        innings_A_1_batting_player_5_innings_1_strike_rate = teamAinnings1BatsmanList.get(4).getStrike_rate();

                    }
                    //batsman 6
                    if(teamAinnings1BatsmanList.size()>=6)
                    {
                        innings_A_1_batting_player_6_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(5)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_6_innings_1_sixes = teamAinnings1BatsmanList.get(5).getSixes().toString();
                        innings_A_1_batting_player_6_innings_1_fours = teamAinnings1BatsmanList.get(5).getFours().toString();
                        innings_A_1_batting_player_6_innings_1_balls = teamAinnings1BatsmanList.get(5).getBalls_faced().toString();
                        innings_A_1_batting_player_6_innings_1_runs = teamAinnings1BatsmanList.get(5).getRuns().toString();
                        innings_A_1_batting_player_6_innings_1_out_comment = teamAinnings1BatsmanList.get(5).getHow_out();
                        innings_A_1_batting_player_6_innings_1_strike_rate = teamAinnings1BatsmanList.get(5).getStrike_rate();
                    }
                    //batsman 7
                    if(teamAinnings1BatsmanList.size()>=7)
                    {
                        innings_A_1_batting_player_7_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(6)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_7_innings_1_sixes = teamAinnings1BatsmanList.get(6).getSixes().toString();
                        innings_A_1_batting_player_7_innings_1_fours = teamAinnings1BatsmanList.get(6).getFours().toString();
                        innings_A_1_batting_player_7_innings_1_balls = teamAinnings1BatsmanList.get(6).getBalls_faced().toString();
                        innings_A_1_batting_player_7_innings_1_runs = teamAinnings1BatsmanList.get(6).getRuns().toString();
                        innings_A_1_batting_player_7_innings_1_out_comment = teamAinnings1BatsmanList.get(6).getHow_out();
                        innings_A_1_batting_player_7_innings_1_strike_rate = teamAinnings1BatsmanList.get(6).getStrike_rate();
                    }
                    //batsman 8
                    if(teamAinnings1BatsmanList.size()>=8)
                    {
                        innings_A_1_batting_player_8_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(7)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_8_innings_1_sixes = teamAinnings1BatsmanList.get(7).getSixes().toString();
                        innings_A_1_batting_player_8_innings_1_fours = teamAinnings1BatsmanList.get(7).getFours().toString();
                        innings_A_1_batting_player_8_innings_1_balls = teamAinnings1BatsmanList.get(7).getBalls_faced().toString();
                        innings_A_1_batting_player_8_innings_1_runs = teamAinnings1BatsmanList.get(7).getRuns().toString();
                        innings_A_1_batting_player_8_innings_1_out_comment = teamAinnings1BatsmanList.get(7).getHow_out();
                        innings_A_1_batting_player_8_innings_1_strike_rate = teamAinnings1BatsmanList.get(7).getStrike_rate();

                    }
                    //batsman 9
                    if(teamAinnings1BatsmanList.size()>=9)
                    {
                        innings_A_1_batting_player_9_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(8)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_9_innings_1_sixes = teamAinnings1BatsmanList.get(8).getSixes().toString();
                        innings_A_1_batting_player_9_innings_1_fours = teamAinnings1BatsmanList.get(8).getFours().toString();
                        innings_A_1_batting_player_9_innings_1_balls = teamAinnings1BatsmanList.get(8).getBalls_faced().toString();
                        innings_A_1_batting_player_9_innings_1_runs = teamAinnings1BatsmanList.get(8).getRuns().toString();
                        innings_A_1_batting_player_9_innings_1_out_comment = teamAinnings1BatsmanList.get(8).getHow_out();
                        innings_A_1_batting_player_9_innings_1_strike_rate = teamAinnings1BatsmanList.get(8).getStrike_rate();

                    }
                    //batsman 10
                    if(teamAinnings1BatsmanList.size()>=10)
                    {
                        innings_A_1_batting_player_10_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(9)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_10_innings_1_sixes = teamAinnings1BatsmanList.get(9).getSixes().toString();
                        innings_A_1_batting_player_10_innings_1_fours = teamAinnings1BatsmanList.get(9).getFours().toString();
                        innings_A_1_batting_player_10_innings_1_balls = teamAinnings1BatsmanList.get(9).getBalls_faced().toString();
                        innings_A_1_batting_player_10_innings_1_runs = teamAinnings1BatsmanList.get(9).getRuns().toString();
                        innings_A_1_batting_player_10_innings_1_out_comment = teamAinnings1BatsmanList.get(9).getHow_out();
                        innings_A_1_batting_player_10_innings_1_strike_rate = teamAinnings1BatsmanList.get(9).getStrike_rate();

                    }
                    //batsman 11
                    if(teamAinnings1BatsmanList.size()>=11)
                    {
                        innings_A_1_batting_player_11_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings1BatsmanList.get(10)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_A_1_batting_player_11_innings_1_sixes = teamAinnings1BatsmanList.get(10).getSixes().toString();
                        innings_A_1_batting_player_11_innings_1_fours = teamAinnings1BatsmanList.get(10).getFours().toString();
                        innings_A_1_batting_player_11_innings_1_balls = teamAinnings1BatsmanList.get(10).getBalls_faced().toString();
                        innings_A_1_batting_player_11_innings_1_runs = teamAinnings1BatsmanList.get(10).getRuns().toString();
                        innings_A_1_batting_player_11_innings_1_out_comment = teamAinnings1BatsmanList.get(10).getHow_out();
                        innings_A_1_batting_player_11_innings_1_strike_rate = teamAinnings1BatsmanList.get(10).getStrike_rate();

                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

            }


            /*Initializing second innings batsman*/
            if (matchScorecard.getResponse().getInnings().size() >= 2)
            {

                try{
                    //batsman 1
                    if(teamBinnings1BatsmanList.size()>=1)
                    {
                        innings_B_1_batting_player_1_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(0)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_1_innings_1_sixes = teamBinnings1BatsmanList.get(0).getSixes().toString();
                        innings_B_1_batting_player_1_innings_1_fours = teamBinnings1BatsmanList.get(0).getFours().toString();
                        innings_B_1_batting_player_1_innings_1_balls = teamBinnings1BatsmanList.get(0).getBalls_faced().toString();
                        innings_B_1_batting_player_1_innings_1_runs = teamBinnings1BatsmanList.get(0).getRuns().toString();
                        innings_B_1_batting_player_1_innings_1_out_comment = teamBinnings1BatsmanList.get(0).getHow_out();
                        innings_B_1_batting_player_1_innings_1_strike_rate = teamBinnings1BatsmanList.get(0).getStrike_rate();
                    }
                    //batsman 2
                    if(teamBinnings1BatsmanList.size()>=2)
                    {
                        innings_B_1_batting_player_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(1)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_2_innings_1_sixes = teamBinnings1BatsmanList.get(1).getSixes().toString();
                        innings_B_1_batting_player_2_innings_1_fours = teamBinnings1BatsmanList.get(1).getFours().toString();
                        innings_B_1_batting_player_2_innings_1_balls = teamBinnings1BatsmanList.get(1).getBalls_faced().toString();
                        innings_B_1_batting_player_2_innings_1_runs = teamBinnings1BatsmanList.get(1).getRuns().toString();
                        innings_B_1_batting_player_2_innings_1_out_comment = teamBinnings1BatsmanList.get(1).getHow_out();
                        innings_B_1_batting_player_2_innings_1_strike_rate = teamBinnings1BatsmanList.get(1).getStrike_rate();


                    }
                    //batsman 3
                    if(teamBinnings1BatsmanList.size()>=3)
                    {
                        innings_B_1_batting_player_3_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(2)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_3_innings_1_sixes = teamBinnings1BatsmanList.get(2).getSixes().toString();
                        innings_B_1_batting_player_3_innings_1_fours = teamBinnings1BatsmanList.get(2).getFours().toString();
                        innings_B_1_batting_player_3_innings_1_balls = teamBinnings1BatsmanList.get(2).getBalls_faced().toString();
                        innings_B_1_batting_player_3_innings_1_runs = teamBinnings1BatsmanList.get(2).getRuns().toString();
                        innings_B_1_batting_player_3_innings_1_out_comment = teamBinnings1BatsmanList.get(2).getHow_out();
                        innings_B_1_batting_player_3_innings_1_strike_rate = teamBinnings1BatsmanList.get(2).getStrike_rate();

                    }
                    //batsman 4
                    if(teamBinnings1BatsmanList.size()>=4)
                    {
                        innings_B_1_batting_player_4_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(3)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_4_innings_1_sixes = teamBinnings1BatsmanList.get(3).getSixes().toString();
                        innings_B_1_batting_player_4_innings_1_fours = teamBinnings1BatsmanList.get(3).getFours().toString();
                        innings_B_1_batting_player_4_innings_1_balls = teamBinnings1BatsmanList.get(3).getBalls_faced().toString();
                        innings_B_1_batting_player_4_innings_1_runs = teamBinnings1BatsmanList.get(3).getRuns().toString();
                        innings_B_1_batting_player_4_innings_1_out_comment = teamBinnings1BatsmanList.get(3).getHow_out();
                        innings_B_1_batting_player_4_innings_1_strike_rate = teamBinnings1BatsmanList.get(3).getStrike_rate();

                    }
                    //batsman 5
                    if(teamBinnings1BatsmanList.size()>=5)
                    {
                        innings_B_1_batting_player_5_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(4)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_5_innings_1_sixes = teamBinnings1BatsmanList.get(4).getSixes().toString();
                        innings_B_1_batting_player_5_innings_1_fours = teamBinnings1BatsmanList.get(4).getFours().toString();
                        innings_B_1_batting_player_5_innings_1_balls = teamBinnings1BatsmanList.get(4).getBalls_faced().toString();
                        innings_B_1_batting_player_5_innings_1_runs = teamBinnings1BatsmanList.get(4).getRuns().toString();
                        innings_B_1_batting_player_5_innings_1_out_comment = teamBinnings1BatsmanList.get(4).getHow_out();
                        innings_B_1_batting_player_5_innings_1_strike_rate = teamBinnings1BatsmanList.get(4).getStrike_rate();

                    }
                    //batsman 6
                    if(teamBinnings1BatsmanList.size()>=6)
                    {
                        innings_B_1_batting_player_6_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(5)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_6_innings_1_sixes = teamBinnings1BatsmanList.get(5).getSixes().toString();
                        innings_B_1_batting_player_6_innings_1_fours = teamBinnings1BatsmanList.get(5).getFours().toString();
                        innings_B_1_batting_player_6_innings_1_balls = teamBinnings1BatsmanList.get(5).getBalls_faced().toString();
                        innings_B_1_batting_player_6_innings_1_runs = teamBinnings1BatsmanList.get(5).getRuns().toString();
                        innings_B_1_batting_player_6_innings_1_out_comment = teamBinnings1BatsmanList.get(5).getHow_out();
                        innings_B_1_batting_player_6_innings_1_strike_rate = teamBinnings1BatsmanList.get(5).getStrike_rate();

                    }
                    //batsman 7
                    if(teamBinnings1BatsmanList.size()>=7)
                    {
                        innings_B_1_batting_player_7_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(6)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_7_innings_1_sixes = teamBinnings1BatsmanList.get(6).getSixes().toString();
                        innings_B_1_batting_player_7_innings_1_fours = teamBinnings1BatsmanList.get(6).getFours().toString();
                        innings_B_1_batting_player_7_innings_1_balls = teamBinnings1BatsmanList.get(6).getBalls_faced().toString();
                        innings_B_1_batting_player_7_innings_1_runs = teamBinnings1BatsmanList.get(6).getRuns().toString();
                        innings_B_1_batting_player_7_innings_1_out_comment = teamBinnings1BatsmanList.get(6).getHow_out();
                        innings_B_1_batting_player_7_innings_1_strike_rate = teamBinnings1BatsmanList.get(6).getStrike_rate();

                    }
                    //batsman 8
                    if(teamBinnings1BatsmanList.size()>=8)
                    {
                        innings_B_1_batting_player_8_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(7)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_8_innings_1_sixes = teamBinnings1BatsmanList.get(7).getSixes().toString();
                        innings_B_1_batting_player_8_innings_1_fours = teamBinnings1BatsmanList.get(7).getFours().toString();
                        innings_B_1_batting_player_8_innings_1_balls = teamBinnings1BatsmanList.get(7).getBalls_faced().toString();
                        innings_B_1_batting_player_8_innings_1_runs = teamBinnings1BatsmanList.get(7).getRuns().toString();
                        innings_B_1_batting_player_8_innings_1_out_comment = teamBinnings1BatsmanList.get(7).getHow_out();
                        innings_B_1_batting_player_8_innings_1_strike_rate = teamBinnings1BatsmanList.get(7).getStrike_rate();

                    }
                    //batsman 9
                    if(teamBinnings1BatsmanList.size()>=9)
                    {
                        innings_B_1_batting_player_9_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(8)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_9_innings_1_sixes = teamBinnings1BatsmanList.get(8).getSixes().toString();
                        innings_B_1_batting_player_9_innings_1_fours = teamBinnings1BatsmanList.get(8).getFours().toString();
                        innings_B_1_batting_player_9_innings_1_balls = teamBinnings1BatsmanList.get(8).getBalls_faced().toString();
                        innings_B_1_batting_player_9_innings_1_runs = teamBinnings1BatsmanList.get(8).getRuns().toString();
                        innings_B_1_batting_player_9_innings_1_out_comment = teamBinnings1BatsmanList.get(8).getHow_out();
                        innings_B_1_batting_player_9_innings_1_strike_rate = teamBinnings1BatsmanList.get(8).getStrike_rate();

                    }
                    //batsman 10
                    if(teamBinnings1BatsmanList.size()>=10)
                    {
                        innings_B_1_batting_player_10_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(9)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_10_innings_1_sixes = teamBinnings1BatsmanList.get(9).getSixes().toString();
                        innings_B_1_batting_player_10_innings_1_fours = teamBinnings1BatsmanList.get(9).getFours().toString();
                        innings_B_1_batting_player_10_innings_1_balls = teamBinnings1BatsmanList.get(9).getBalls_faced().toString();
                        innings_B_1_batting_player_10_innings_1_runs = teamBinnings1BatsmanList.get(9).getRuns().toString();
                        innings_B_1_batting_player_10_innings_1_out_comment = teamBinnings1BatsmanList.get(9).getHow_out();
                        innings_B_1_batting_player_10_innings_1_strike_rate = teamBinnings1BatsmanList.get(9).getStrike_rate();

                    }
                    //batsman 11
                    if(teamBinnings1BatsmanList.size()>=11)
                    {
                        innings_B_1_batting_player_11_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings1BatsmanList.get(10)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_11_innings_1_sixes = teamBinnings1BatsmanList.get(10).getSixes().toString();
                        innings_B_1_batting_player_11_innings_1_fours = teamBinnings1BatsmanList.get(10).getFours().toString();
                        innings_B_1_batting_player_11_innings_1_balls = teamBinnings1BatsmanList.get(10).getBalls_faced().toString();
                        innings_B_1_batting_player_11_innings_1_runs = teamBinnings1BatsmanList.get(10).getRuns().toString();
                        innings_B_1_batting_player_11_innings_1_out_comment = teamBinnings1BatsmanList.get(10).getHow_out();
                        innings_B_1_batting_player_11_innings_1_strike_rate = teamBinnings1BatsmanList.get(10).getStrike_rate();

                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            /*Initializing third innings batsman*/
            if (matchScorecard.getResponse().getInnings().size() >= 3)
            {

                try{
                    //batsman 1
                    if(teamAinnings2BatsmanList.size()>=1)
                    {
                        innings_A_1_batting_player_1_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(0)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_1_innings_2_sixes = teamAinnings2BatsmanList.get(0).getSixes().toString();
                        innings_A_1_batting_player_1_innings_2_fours = teamAinnings2BatsmanList.get(0).getFours().toString();
                        innings_A_1_batting_player_1_innings_2_balls = teamAinnings2BatsmanList.get(0).getBalls_faced().toString();
                        innings_A_1_batting_player_1_innings_2_runs = teamAinnings2BatsmanList.get(0).getRuns().toString();
                        innings_A_1_batting_player_1_innings_2_out_comment = teamAinnings2BatsmanList.get(0).getHow_out();
                        innings_A_1_batting_player_1_innings_2_strike_rate = teamAinnings2BatsmanList.get(0).getStrike_rate();

                      /*  Player teamAplayer1 = teamAinnings2BatsmanList.stream().
                                filter(p -> p.getBatsman_id().equals(teamAinnings1BatsmanList.
                                        get(0).getBatsman_id())).findFirst().orElse(null);
                        innings_A_1_batting_player_1_innings_2_sixes = teamAplayer1.getSixes().toString();
                        innings_A_1_batting_player_1_innings_2_fours = teamAplayer1.getFours().toString();
                        innings_A_1_batting_player_1_innings_2_balls = teamAplayer1.getBalls_faced().toString();
                        innings_A_1_batting_player_1_innings_2_runs = teamAplayer1.getRuns().toString();
                        innings_A_1_batting_player_1_innings_2_out_comment = teamAplayer1.getHow_out();
                        innings_A_1_batting_player_1_innings_2_strike_rate = teamAplayer1.getStrike_rate();*/
                    }
                    //batsman 2
                    if(teamAinnings2BatsmanList.size()>=2)
                    {
                        innings_A_1_batting_player_2_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(1)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_2_innings_2_sixes = teamAinnings2BatsmanList.get(1).getSixes().toString();
                        innings_A_1_batting_player_2_innings_2_fours = teamAinnings2BatsmanList.get(1).getFours().toString();
                        innings_A_1_batting_player_2_innings_2_balls = teamAinnings2BatsmanList.get(1).getBalls_faced().toString();
                        innings_A_1_batting_player_2_innings_2_runs = teamAinnings2BatsmanList.get(1).getRuns().toString();
                        innings_A_1_batting_player_2_innings_2_out_comment = teamAinnings2BatsmanList.get(1).getHow_out();
                        innings_A_1_batting_player_2_innings_2_strike_rate = teamAinnings2BatsmanList.get(1).getStrike_rate();

                        /*Player teamAplayer2 = teamAinnings2BatsmanList.stream().
                                filter(p -> p.getBatsman_id().equals(teamAinnings1BatsmanList.
                                        get(1).getBatsman_id())).findFirst().orElse(null);
                        innings_A_1_batting_player_2_innings_2_sixes = teamAplayer2.getSixes().toString();
                        innings_A_1_batting_player_2_innings_2_fours = teamAplayer2.getFours().toString();
                        innings_A_1_batting_player_2_innings_2_balls = teamAplayer2.getBalls_faced().toString();
                        innings_A_1_batting_player_2_innings_2_runs = teamAplayer2.getRuns().toString();
                        innings_A_1_batting_player_2_innings_2_out_comment = teamAplayer2.getHow_out();
                        innings_A_1_batting_player_2_innings_2_strike_rate = teamAplayer2.getStrike_rate();*/
                    }
                    //batsman 3
                    if(teamAinnings2BatsmanList.size()>=3)
                    {
                        innings_A_1_batting_player_3_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(2)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_3_innings_2_sixes = teamAinnings2BatsmanList.get(2).getSixes().toString();
                        innings_A_1_batting_player_3_innings_2_fours = teamAinnings2BatsmanList.get(2).getFours().toString();
                        innings_A_1_batting_player_3_innings_2_balls = teamAinnings2BatsmanList.get(2).getBalls_faced().toString();
                        innings_A_1_batting_player_3_innings_2_runs = teamAinnings2BatsmanList.get(2).getRuns().toString();
                        innings_A_1_batting_player_3_innings_2_out_comment = teamAinnings2BatsmanList.get(2).getHow_out();
                        innings_A_1_batting_player_3_innings_2_strike_rate = teamAinnings2BatsmanList.get(2).getStrike_rate();



                       /* Player teamAplayer3 = teamAinnings2BatsmanList.stream().
                                filter(p -> p.getBatsman_id().equals(teamAinnings1BatsmanList.
                                        get(2).getBatsman_id())).findFirst().orElse(null);
                        innings_A_1_batting_player_3_innings_2_sixes = teamAplayer3.getSixes().toString();
                        innings_A_1_batting_player_3_innings_2_fours = teamAplayer3.getFours().toString();
                        innings_A_1_batting_player_3_innings_2_balls = teamAplayer3.getBalls_faced().toString();
                        innings_A_1_batting_player_3_innings_2_runs = teamAplayer3.getRuns().toString();
                        innings_A_1_batting_player_3_innings_2_out_comment = teamAplayer3.getHow_out();
                        innings_A_1_batting_player_3_innings_2_strike_rate = teamAplayer3.getStrike_rate();*/
                    }
                    //batsman 4
                    if(teamAinnings2BatsmanList.size()>=4)
                    {
                        innings_A_1_batting_player_4_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(3)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_4_innings_2_sixes = teamAinnings2BatsmanList.get(3).getSixes().toString();
                        innings_A_1_batting_player_4_innings_2_fours = teamAinnings2BatsmanList.get(3).getFours().toString();
                        innings_A_1_batting_player_4_innings_2_balls = teamAinnings2BatsmanList.get(3).getBalls_faced().toString();
                        innings_A_1_batting_player_4_innings_2_runs = teamAinnings2BatsmanList.get(3).getRuns().toString();
                        innings_A_1_batting_player_4_innings_2_out_comment = teamAinnings2BatsmanList.get(3).getHow_out();
                        innings_A_1_batting_player_4_innings_2_strike_rate = teamAinnings2BatsmanList.get(3).getStrike_rate();


                       /* Player teamAplayer4 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(3).getBatsman_id())).
                                findFirst().orElse(null);
                        innings_A_1_batting_player_4_innings_2_sixes = teamAplayer4.getSixes().toString();
                        innings_A_1_batting_player_4_innings_2_fours = teamAplayer4.getFours().toString();
                        innings_A_1_batting_player_4_innings_2_balls = teamAplayer4.getBalls_faced().toString();
                        innings_A_1_batting_player_4_innings_2_runs = teamAplayer4.getRuns().toString();
                        innings_A_1_batting_player_4_innings_2_out_comment = teamAplayer4.getHow_out();
                        innings_A_1_batting_player_4_innings_2_strike_rate = teamAplayer4.getStrike_rate();*/
                    }
                    //batsman 5
                    if(teamAinnings2BatsmanList.size()>=5)
                    {
                        innings_A_1_batting_player_5_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(4)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_5_innings_2_sixes = teamAinnings2BatsmanList.get(4).getSixes().toString();
                        innings_A_1_batting_player_5_innings_2_fours = teamAinnings2BatsmanList.get(4).getFours().toString();
                        innings_A_1_batting_player_5_innings_2_balls = teamAinnings2BatsmanList.get(4).getBalls_faced().toString();
                        innings_A_1_batting_player_5_innings_2_runs = teamAinnings2BatsmanList.get(4).getRuns().toString();
                        innings_A_1_batting_player_5_innings_2_out_comment = teamAinnings2BatsmanList.get(4).getHow_out();
                        innings_A_1_batting_player_5_innings_2_strike_rate = teamAinnings2BatsmanList.get(4).getStrike_rate();

                        /*
                        Player teamAplayer5 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(4).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_5_innings_2_sixes = teamAplayer5.getSixes().toString();
                        innings_A_1_batting_player_5_innings_2_fours = teamAplayer5.getFours().toString();
                        innings_A_1_batting_player_5_innings_2_balls = teamAplayer5.getBalls_faced().toString();
                        innings_A_1_batting_player_5_innings_2_runs = teamAplayer5.getRuns().toString();
                        innings_A_1_batting_player_5_innings_2_out_comment = teamAplayer5.getHow_out();
                        innings_A_1_batting_player_5_innings_2_strike_rate = teamAplayer5.getStrike_rate();*/
                    }
                    //batsman 6
                    if(teamAinnings2BatsmanList.size()>=6)
                    {
                        innings_A_1_batting_player_6_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(5)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_6_innings_2_sixes = teamAinnings2BatsmanList.get(5).getSixes().toString();
                        innings_A_1_batting_player_6_innings_2_fours = teamAinnings2BatsmanList.get(5).getFours().toString();
                        innings_A_1_batting_player_6_innings_2_balls = teamAinnings2BatsmanList.get(5).getBalls_faced().toString();
                        innings_A_1_batting_player_6_innings_2_runs = teamAinnings2BatsmanList.get(5).getRuns().toString();
                        innings_A_1_batting_player_6_innings_2_out_comment = teamAinnings2BatsmanList.get(5).getHow_out();
                        innings_A_1_batting_player_6_innings_2_strike_rate = teamAinnings2BatsmanList.get(5).getStrike_rate();





                        /*Player teamAplayer6 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(5).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_6_innings_2_sixes = teamAplayer6.getSixes().toString();
                        innings_A_1_batting_player_6_innings_2_fours = teamAplayer6.getFours().toString();
                        innings_A_1_batting_player_6_innings_2_balls = teamAplayer6.getBalls_faced().toString();
                        innings_A_1_batting_player_6_innings_2_runs = teamAplayer6.getRuns().toString();
                        innings_A_1_batting_player_6_innings_2_out_comment = teamAplayer6.getHow_out();
                        innings_A_1_batting_player_6_innings_2_strike_rate = teamAplayer6.getStrike_rate();*/
                    }
                    //batsman 7
                    if(teamAinnings2BatsmanList.size()>=7)
                    {
                        innings_A_1_batting_player_7_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(6)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_7_innings_2_sixes = teamAinnings2BatsmanList.get(6).getSixes().toString();
                        innings_A_1_batting_player_7_innings_2_fours = teamAinnings2BatsmanList.get(6).getFours().toString();
                        innings_A_1_batting_player_7_innings_2_balls = teamAinnings2BatsmanList.get(6).getBalls_faced().toString();
                        innings_A_1_batting_player_7_innings_2_runs = teamAinnings2BatsmanList.get(6).getRuns().toString();
                        innings_A_1_batting_player_7_innings_2_out_comment = teamAinnings2BatsmanList.get(6).getHow_out();
                        innings_A_1_batting_player_7_innings_2_strike_rate = teamAinnings2BatsmanList.get(6).getStrike_rate();


                        /*Player teamAplayer7 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(6).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_7_innings_2_sixes = teamAplayer7.getSixes().toString();
                        innings_A_1_batting_player_7_innings_2_fours = teamAplayer7.getFours().toString();
                        innings_A_1_batting_player_7_innings_2_balls = teamAplayer7.getBalls_faced().toString();
                        innings_A_1_batting_player_7_innings_2_runs = teamAplayer7.getRuns().toString();
                        innings_A_1_batting_player_7_innings_2_out_comment = teamAplayer7.getHow_out();
                        innings_A_1_batting_player_7_innings_2_strike_rate = teamAplayer7.getStrike_rate();*/
                    }
                    //batsman 8
                    if(teamAinnings2BatsmanList.size()>=8)
                    {
                        innings_A_1_batting_player_8_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(7)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_8_innings_2_sixes = teamAinnings2BatsmanList.get(7).getSixes().toString();
                        innings_A_1_batting_player_8_innings_2_fours = teamAinnings2BatsmanList.get(7).getFours().toString();
                        innings_A_1_batting_player_8_innings_2_balls = teamAinnings2BatsmanList.get(7).getBalls_faced().toString();
                        innings_A_1_batting_player_8_innings_2_runs = teamAinnings2BatsmanList.get(7).getRuns().toString();
                        innings_A_1_batting_player_8_innings_2_out_comment = teamAinnings2BatsmanList.get(7).getHow_out();
                        innings_A_1_batting_player_8_innings_2_strike_rate = teamAinnings2BatsmanList.get(7).getStrike_rate();


                        /*Player teamAplayer8 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(7).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_8_innings_2_sixes = teamAplayer8.getSixes().toString();
                        innings_A_1_batting_player_8_innings_2_fours = teamAplayer8.getFours().toString();
                        innings_A_1_batting_player_8_innings_2_balls = teamAplayer8.getBalls_faced().toString();
                        innings_A_1_batting_player_8_innings_2_runs = teamAplayer8.getRuns().toString();
                        innings_A_1_batting_player_8_innings_2_out_comment = teamAplayer8.getHow_out();
                        innings_A_1_batting_player_8_innings_2_strike_rate = teamAplayer8.getStrike_rate();*/
                    }
                    //batsman 9
                    if(teamAinnings2BatsmanList.size()>=9)
                    {innings_A_1_batting_player_9_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                            .equals(teamAinnings2BatsmanList.get(8)
                                    .getBatsman_id())).findFirst()
                            .orElse(null).getTitle();

                        innings_A_1_batting_player_9_innings_2_sixes = teamAinnings2BatsmanList.get(8).getSixes().toString();
                        innings_A_1_batting_player_9_innings_2_fours = teamAinnings2BatsmanList.get(8).getFours().toString();
                        innings_A_1_batting_player_9_innings_2_balls = teamAinnings2BatsmanList.get(8).getBalls_faced().toString();
                        innings_A_1_batting_player_9_innings_2_runs = teamAinnings2BatsmanList.get(8).getRuns().toString();
                        innings_A_1_batting_player_9_innings_2_out_comment = teamAinnings2BatsmanList.get(8).getHow_out();
                        innings_A_1_batting_player_9_innings_2_strike_rate = teamAinnings2BatsmanList.get(8).getStrike_rate();



                        /*Player teamAplayer9 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(8).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_9_innings_2_sixes = teamAplayer9.getSixes().toString();
                        innings_A_1_batting_player_9_innings_2_fours = teamAplayer9.getFours().toString();
                        innings_A_1_batting_player_9_innings_2_balls = teamAplayer9.getBalls_faced().toString();
                        innings_A_1_batting_player_9_innings_2_runs = teamAplayer9.getRuns().toString();
                        innings_A_1_batting_player_9_innings_2_out_comment = teamAplayer9.getHow_out();
                        innings_A_1_batting_player_9_innings_2_strike_rate = teamAplayer9.getStrike_rate();*/
                    }
                    //batsman 10
                    if(teamAinnings2BatsmanList.size()>=10)
                    {
                        innings_A_1_batting_player_10_innings_2_full_name= playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(9)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_10_innings_2_sixes = teamAinnings2BatsmanList.get(9).getSixes().toString();
                        innings_A_1_batting_player_10_innings_2_fours = teamAinnings2BatsmanList.get(9).getFours().toString();
                        innings_A_1_batting_player_10_innings_2_balls = teamAinnings2BatsmanList.get(9).getBalls_faced().toString();
                        innings_A_1_batting_player_10_innings_2_runs = teamAinnings2BatsmanList.get(9).getRuns().toString();
                        innings_A_1_batting_player_10_innings_2_out_comment = teamAinnings2BatsmanList.get(9).getHow_out();
                        innings_A_1_batting_player_10_innings_2_strike_rate = teamAinnings2BatsmanList.get(9).getStrike_rate();



                        /*Player teamAplayer10 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(9).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_10_innings_2_sixes = teamAplayer10.getSixes().toString();
                        innings_A_1_batting_player_10_innings_2_fours = teamAplayer10.getFours().toString();
                        innings_A_1_batting_player_10_innings_2_balls = teamAplayer10.getBalls_faced().toString();
                        innings_A_1_batting_player_10_innings_2_runs = teamAplayer10.getRuns().toString();
                        innings_A_1_batting_player_10_innings_2_out_comment = teamAplayer10.getHow_out();
                        innings_A_1_batting_player_10_innings_2_strike_rate = teamAplayer10.getStrike_rate();*/
                    }
                    //batsman 11
                    if(teamAinnings2BatsmanList.size()>=11)
                    {
                        innings_A_1_batting_player_11_innings_2_full_name =  playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamAinnings2BatsmanList.get(10)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_A_1_batting_player_11_innings_2_sixes = teamAinnings2BatsmanList.get(10).getSixes().toString();
                        innings_A_1_batting_player_11_innings_2_fours = teamAinnings2BatsmanList.get(10).getFours().toString();
                        innings_A_1_batting_player_11_innings_2_balls = teamAinnings2BatsmanList.get(10).getBalls_faced().toString();
                        innings_A_1_batting_player_11_innings_2_runs = teamAinnings2BatsmanList.get(10).getRuns().toString();
                        innings_A_1_batting_player_11_innings_2_out_comment = teamAinnings2BatsmanList.get(10).getHow_out();
                        innings_A_1_batting_player_11_innings_2_strike_rate = teamAinnings2BatsmanList.get(10).getStrike_rate();

                       /* Player teamAplayer11 = teamAinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamAinnings1BatsmanList.get(10).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_A_1_batting_player_11_innings_2_sixes = teamAplayer11.getSixes().toString();
                        innings_A_1_batting_player_11_innings_2_fours = teamAplayer11.getFours().toString();
                        innings_A_1_batting_player_11_innings_2_balls = teamAplayer11.getBalls_faced().toString();
                        innings_A_1_batting_player_11_innings_2_runs = teamAplayer11.getRuns().toString();
                        innings_A_1_batting_player_11_innings_2_out_comment = teamAplayer11.getHow_out();
                        innings_A_1_batting_player_11_innings_2_strike_rate = teamAplayer11.getStrike_rate();*/

                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

            /*Initializing forth innings batsman*/
            if (matchScorecard.getResponse().getInnings().size() >= 4)
            {

                try{
                    //batsman 1
                    if(teamBinnings2BatsmanList.size()>=1)
                    {
                        innings_B_1_batting_player_1_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(0)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_B_1_batting_player_1_innings_2_sixes = teamBinnings2BatsmanList.get(0).getSixes().toString();
                        innings_B_1_batting_player_1_innings_2_fours = teamBinnings2BatsmanList.get(0).getFours().toString();
                        innings_B_1_batting_player_1_innings_2_balls = teamBinnings2BatsmanList.get(0).getBalls_faced().toString();
                        innings_B_1_batting_player_1_innings_2_runs = teamBinnings2BatsmanList.get(0).getRuns().toString();
                        innings_B_1_batting_player_1_innings_2_out_comment = teamBinnings2BatsmanList.get(0).getHow_out();
                        innings_B_1_batting_player_1_innings_2_strike_rate = teamBinnings2BatsmanList.get(0).getStrike_rate();


                        /*Player teamBplayer1 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(0).getBatsman_id())).
                                findFirst().orElse(null);
                        innings_B_1_batting_player_1_innings_2_sixes = teamBplayer1.getSixes().toString();
                        innings_B_1_batting_player_1_innings_2_fours = teamBplayer1.getFours().toString();
                        innings_B_1_batting_player_1_innings_2_balls = teamBplayer1.getBalls_faced().toString();
                        innings_B_1_batting_player_1_innings_2_runs = teamBplayer1.getRuns().toString();
                        innings_B_1_batting_player_1_innings_2_out_comment = teamBplayer1.getHow_out();
                        innings_B_1_batting_player_1_innings_2_strike_rate = teamBplayer1.getStrike_rate();*/
                    }
                    //batsman 2
                    if(teamBinnings2BatsmanList.size()>=2)
                    {
                        innings_B_1_batting_player_2_innings_2_full_name =playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(1)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_2_innings_2_sixes = teamBinnings2BatsmanList.get(1).getSixes().toString();
                        innings_B_1_batting_player_2_innings_2_fours = teamBinnings2BatsmanList.get(1).getFours().toString();
                        innings_B_1_batting_player_2_innings_2_balls = teamBinnings2BatsmanList.get(1).getBalls_faced().toString();
                        innings_B_1_batting_player_2_innings_2_runs = teamBinnings2BatsmanList.get(1).getRuns().toString();
                        innings_B_1_batting_player_2_innings_2_out_comment = teamBinnings2BatsmanList.get(1).getHow_out();
                        innings_B_1_batting_player_2_innings_2_strike_rate = teamBinnings2BatsmanList.get(1).getStrike_rate();



                        /*Player teamBplayer2 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(1).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_2_innings_2_sixes = teamBplayer2.getSixes().toString();
                        innings_B_1_batting_player_2_innings_2_fours = teamBplayer2.getFours().toString();
                        innings_B_1_batting_player_2_innings_2_balls = teamBplayer2.getBalls_faced().toString();
                        innings_B_1_batting_player_2_innings_2_runs = teamBplayer2.getRuns().toString();
                        innings_B_1_batting_player_2_innings_2_out_comment = teamBplayer2.getHow_out();
                        innings_B_1_batting_player_2_innings_2_strike_rate = teamBplayer2.getStrike_rate();*/
                    }
                    //batsman 3
                    if(teamBinnings2BatsmanList.size()>=3)
                    {
                        innings_B_1_batting_player_3_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(2)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();

                        innings_B_1_batting_player_3_innings_2_sixes = teamBinnings2BatsmanList.get(2).getSixes().toString();
                        innings_B_1_batting_player_3_innings_2_fours = teamBinnings2BatsmanList.get(2).getFours().toString();
                        innings_B_1_batting_player_3_innings_2_balls = teamBinnings2BatsmanList.get(2).getBalls_faced().toString();
                        innings_B_1_batting_player_3_innings_2_runs = teamBinnings2BatsmanList.get(2).getRuns().toString();
                        innings_B_1_batting_player_3_innings_2_out_comment = teamBinnings2BatsmanList.get(2).getHow_out();
                        innings_B_1_batting_player_3_innings_2_strike_rate = teamBinnings2BatsmanList.get(2).getStrike_rate();


                        /*Player teamBplayer3 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(2).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_3_innings_2_sixes = teamBplayer3.getSixes().toString();
                        innings_B_1_batting_player_3_innings_2_fours = teamBplayer3.getFours().toString();
                        innings_B_1_batting_player_3_innings_2_balls = teamBplayer3.getBalls_faced().toString();
                        innings_B_1_batting_player_3_innings_2_runs = teamBplayer3.getRuns().toString();
                        innings_B_1_batting_player_3_innings_2_out_comment = teamBplayer3.getHow_out();
                        innings_B_1_batting_player_3_innings_2_strike_rate = teamBplayer3.getStrike_rate();*/
                    }
                    //batsman 4
                    if(teamBinnings2BatsmanList.size()>=4)
                    {
                        innings_B_1_batting_player_4_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(3)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_4_innings_2_sixes = teamBinnings2BatsmanList.get(3).getSixes().toString();
                        innings_B_1_batting_player_4_innings_2_fours = teamBinnings2BatsmanList.get(3).getFours().toString();
                        innings_B_1_batting_player_4_innings_2_balls = teamBinnings2BatsmanList.get(3).getBalls_faced().toString();
                        innings_B_1_batting_player_4_innings_2_runs = teamBinnings2BatsmanList.get(3).getRuns().toString();
                        innings_B_1_batting_player_4_innings_2_out_comment = teamBinnings2BatsmanList.get(3).getHow_out();
                        innings_B_1_batting_player_4_innings_2_strike_rate = teamBinnings2BatsmanList.get(3).getStrike_rate();

                    /*    Player teamBplayer4 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(3).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_4_innings_2_sixes = teamBplayer4.getSixes().toString();
                        innings_B_1_batting_player_4_innings_2_fours = teamBplayer4.getFours().toString();
                        innings_B_1_batting_player_4_innings_2_balls = teamBplayer4.getBalls_faced().toString();
                        innings_B_1_batting_player_4_innings_2_runs = teamBplayer4.getRuns().toString();
                        innings_B_1_batting_player_4_innings_2_out_comment = teamBplayer4.getHow_out();
                        innings_B_1_batting_player_4_innings_2_strike_rate = teamBplayer4.getStrike_rate();*/
                    }
                    //batsman 5
                    if(teamBinnings2BatsmanList.size()>=5)
                    {
                        innings_B_1_batting_player_5_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(4)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_5_innings_2_sixes = teamBinnings2BatsmanList.get(4).getSixes().toString();
                        innings_B_1_batting_player_5_innings_2_fours = teamBinnings2BatsmanList.get(4).getFours().toString();
                        innings_B_1_batting_player_5_innings_2_balls = teamBinnings2BatsmanList.get(4).getBalls_faced().toString();
                        innings_B_1_batting_player_5_innings_2_runs = teamBinnings2BatsmanList.get(4).getRuns().toString();
                        innings_B_1_batting_player_5_innings_2_out_comment = teamBinnings2BatsmanList.get(4).getHow_out();
                        innings_B_1_batting_player_5_innings_2_strike_rate = teamBinnings2BatsmanList.get(4).getStrike_rate();



                        /*Player teamBplayer5 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(4).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_5_innings_2_sixes = teamBplayer5.getSixes().toString();
                        innings_B_1_batting_player_5_innings_2_fours = teamBplayer5.getFours().toString();
                        innings_B_1_batting_player_5_innings_2_balls = teamBplayer5.getBalls_faced().toString();
                        innings_B_1_batting_player_5_innings_2_runs = teamBplayer5.getRuns().toString();
                        innings_B_1_batting_player_5_innings_2_out_comment = teamBplayer5.getHow_out();
                        innings_B_1_batting_player_5_innings_2_strike_rate = teamBplayer5.getStrike_rate();*/
                    }
                    //batsman 6
                    if(teamBinnings2BatsmanList.size()>=6)
                    {
                        innings_B_1_batting_player_6_innings_2_full_name= playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(5)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_6_innings_2_sixes = teamBinnings2BatsmanList.get(5).getSixes().toString();
                        innings_B_1_batting_player_6_innings_2_fours = teamBinnings2BatsmanList.get(5).getFours().toString();
                        innings_B_1_batting_player_6_innings_2_balls = teamBinnings2BatsmanList.get(5).getBalls_faced().toString();
                        innings_B_1_batting_player_6_innings_2_runs = teamBinnings2BatsmanList.get(5).getRuns().toString();
                        innings_B_1_batting_player_6_innings_2_out_comment = teamBinnings2BatsmanList.get(5).getHow_out();
                        innings_B_1_batting_player_6_innings_2_strike_rate = teamBinnings2BatsmanList.get(5).getStrike_rate();



                       /* Player teamBplayer6 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(5).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_6_innings_2_sixes = teamBplayer6.getSixes().toString();
                        innings_B_1_batting_player_6_innings_2_fours = teamBplayer6.getFours().toString();
                        innings_B_1_batting_player_6_innings_2_balls = teamBplayer6.getBalls_faced().toString();
                        innings_B_1_batting_player_6_innings_2_runs = teamBplayer6.getRuns().toString();
                        innings_B_1_batting_player_6_innings_2_out_comment = teamBplayer6.getHow_out();
                        innings_B_1_batting_player_6_innings_2_strike_rate = teamBplayer6.getStrike_rate();*/
                    }
                    //batsman 7
                    if(teamBinnings2BatsmanList.size()>=7)
                    {
                        innings_B_1_batting_player_7_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(6)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_7_innings_2_sixes = teamBinnings2BatsmanList.get(6).getSixes().toString();
                        innings_B_1_batting_player_7_innings_2_fours = teamBinnings2BatsmanList.get(6).getFours().toString();
                        innings_B_1_batting_player_7_innings_2_balls = teamBinnings2BatsmanList.get(6).getBalls_faced().toString();
                        innings_B_1_batting_player_7_innings_2_runs = teamBinnings2BatsmanList.get(6).getRuns().toString();
                        innings_B_1_batting_player_7_innings_2_out_comment = teamBinnings2BatsmanList.get(6).getHow_out();
                        innings_B_1_batting_player_7_innings_2_strike_rate = teamBinnings2BatsmanList.get(6).getStrike_rate();


                        /*Player teamBplayer7 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(6).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_7_innings_2_sixes = teamBplayer7.getSixes().toString();
                        innings_B_1_batting_player_7_innings_2_fours = teamBplayer7.getFours().toString();
                        innings_B_1_batting_player_7_innings_2_balls = teamBplayer7.getBalls_faced().toString();
                        innings_B_1_batting_player_7_innings_2_runs = teamBplayer7.getRuns().toString();
                        innings_B_1_batting_player_7_innings_2_out_comment = teamBplayer7.getHow_out();
                        innings_B_1_batting_player_7_innings_2_strike_rate = teamBplayer7.getStrike_rate();*/
                    }
                    //batsman 8
                    if(teamBinnings2BatsmanList.size()>=8)
                    {
                        innings_B_1_batting_player_8_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(7)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_8_innings_2_sixes = teamBinnings2BatsmanList.get(7).getSixes().toString();
                        innings_B_1_batting_player_8_innings_2_fours = teamBinnings2BatsmanList.get(7).getFours().toString();
                        innings_B_1_batting_player_8_innings_2_balls = teamBinnings2BatsmanList.get(7).getBalls_faced().toString();
                        innings_B_1_batting_player_8_innings_2_runs = teamBinnings2BatsmanList.get(7).getRuns().toString();
                        innings_B_1_batting_player_8_innings_2_out_comment = teamBinnings2BatsmanList.get(7).getHow_out();
                        innings_B_1_batting_player_8_innings_2_strike_rate = teamBinnings2BatsmanList.get(7).getStrike_rate();



                        /*Player teamBplayer8 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(7).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_8_innings_2_sixes = teamBplayer8.getSixes().toString();
                        innings_B_1_batting_player_8_innings_2_fours = teamBplayer8.getFours().toString();
                        innings_B_1_batting_player_8_innings_2_balls = teamBplayer8.getBalls_faced().toString();
                        innings_B_1_batting_player_8_innings_2_runs = teamBplayer8.getRuns().toString();
                        innings_B_1_batting_player_8_innings_2_out_comment = teamBplayer8.getHow_out();
                        innings_B_1_batting_player_8_innings_2_strike_rate = teamBplayer8.getStrike_rate();*/
                    }
                    //batsman 9
                    if(teamBinnings2BatsmanList.size()>=9)
                    {
                        innings_B_1_batting_player_9_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(8)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_9_innings_2_sixes = teamBinnings2BatsmanList.get(8).getSixes().toString();
                        innings_B_1_batting_player_9_innings_2_fours = teamBinnings2BatsmanList.get(8).getFours().toString();
                        innings_B_1_batting_player_9_innings_2_balls = teamBinnings2BatsmanList.get(8).getBalls_faced().toString();
                        innings_B_1_batting_player_9_innings_2_runs = teamBinnings2BatsmanList.get(8).getRuns().toString();
                        innings_B_1_batting_player_9_innings_2_out_comment = teamBinnings2BatsmanList.get(8).getHow_out();
                        innings_B_1_batting_player_9_innings_2_strike_rate = teamBinnings2BatsmanList.get(8).getStrike_rate();

                        /*Player teamBplayer9 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(8).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_9_innings_2_sixes = teamBplayer9.getSixes().toString();
                        innings_B_1_batting_player_9_innings_2_fours = teamBplayer9.getFours().toString();
                        innings_B_1_batting_player_9_innings_2_balls = teamBplayer9.getBalls_faced().toString();
                        innings_B_1_batting_player_9_innings_2_runs = teamBplayer9.getRuns().toString();
                        innings_B_1_batting_player_9_innings_2_out_comment = teamBplayer9.getHow_out();
                        innings_B_1_batting_player_9_innings_2_strike_rate = teamBplayer9.getStrike_rate();*/
                    }
                    //batsman 10
                    if(teamBinnings2BatsmanList.size()>=10)
                    {
                        innings_B_1_batting_player_10_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(9)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_10_innings_2_sixes = teamBinnings2BatsmanList.get(9).getSixes().toString();
                        innings_B_1_batting_player_10_innings_2_fours = teamBinnings2BatsmanList.get(9).getFours().toString();
                        innings_B_1_batting_player_10_innings_2_balls = teamBinnings2BatsmanList.get(9).getBalls_faced().toString();
                        innings_B_1_batting_player_10_innings_2_runs = teamBinnings2BatsmanList.get(9).getRuns().toString();
                        innings_B_1_batting_player_10_innings_2_out_comment = teamBinnings2BatsmanList.get(9).getHow_out();
                        innings_B_1_batting_player_10_innings_2_strike_rate = teamBinnings2BatsmanList.get(9).getStrike_rate();



                        /*Player teamBplayer10 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(9).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_10_innings_2_sixes = teamBplayer10.getSixes().toString();
                        innings_B_1_batting_player_10_innings_2_fours = teamBplayer10.getFours().toString();
                        innings_B_1_batting_player_10_innings_2_balls = teamBplayer10.getBalls_faced().toString();
                        innings_B_1_batting_player_10_innings_2_runs = teamBplayer10.getRuns().toString();
                        innings_B_1_batting_player_10_innings_2_out_comment = teamBplayer10.getHow_out();
                        innings_B_1_batting_player_10_innings_2_strike_rate = teamBplayer10.getStrike_rate();*/
                    }
                    //batsman 11
                    if(teamBinnings2BatsmanList.size()>=11)
                    {
                        innings_B_1_batting_player_11_innings_2_full_name = playerListForScorecard.stream().filter(p->p.getPid()
                                .equals(teamBinnings2BatsmanList.get(10)
                                        .getBatsman_id())).findFirst()
                                .orElse(null).getTitle();
                        innings_B_1_batting_player_11_innings_2_sixes = teamBinnings2BatsmanList.get(10).getSixes().toString();
                        innings_B_1_batting_player_11_innings_2_fours = teamBinnings2BatsmanList.get(10).getFours().toString();
                        innings_B_1_batting_player_11_innings_2_balls = teamBinnings2BatsmanList.get(10).getBalls_faced().toString();
                        innings_B_1_batting_player_11_innings_2_runs = teamBinnings2BatsmanList.get(10).getRuns().toString();
                        innings_B_1_batting_player_11_innings_2_out_comment = teamBinnings2BatsmanList.get(10).getHow_out();
                        innings_B_1_batting_player_11_innings_2_strike_rate = teamBinnings2BatsmanList.get(10).getStrike_rate();


                        /*Player teamBplayer11 = teamBinnings2BatsmanList.stream().filter(p -> p.getBatsman_id().
                                equals(teamBinnings1BatsmanList.get(10).getBatsman_id())).
                                findFirst().orElse(null);

                        innings_B_1_batting_player_11_innings_2_sixes = teamBplayer11.getSixes().toString();
                        innings_B_1_batting_player_11_innings_2_fours = teamBplayer11.getFours().toString();
                        innings_B_1_batting_player_11_innings_2_balls = teamBplayer11.getBalls_faced().toString();
                        innings_B_1_batting_player_11_innings_2_runs = teamBplayer11.getRuns().toString();
                        innings_B_1_batting_player_11_innings_2_out_comment = teamBplayer11.getHow_out();
                        innings_B_1_batting_player_11_innings_2_strike_rate = teamBplayer11.getStrike_rate();*/
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public List<Player> getTeamAinnings1BatsmanList() {
        return teamAinnings1BatsmanList;
    }

    public void setTeamAinnings1BatsmanList(List<Player> teamAinnings1BatsmanList) {
        this.teamAinnings1BatsmanList = teamAinnings1BatsmanList;
    }

    public List<Player> getTeamAinnings2BatsmanList() {
        return teamAinnings2BatsmanList;
    }

    public void setTeamAinnings2BatsmanList(List<Player> teamAinnings2BatsmanList) {
        this.teamAinnings2BatsmanList = teamAinnings2BatsmanList;
    }

    public List<Player> getTeamBinnings1BatsmanList() {
        return teamBinnings1BatsmanList;
    }

    public void setTeamBinnings1BatsmanList(List<Player> teamBinnings1BatsmanList) {
        this.teamBinnings1BatsmanList = teamBinnings1BatsmanList;
    }

    public List<Player> getTeamBinnings2BatsmanList() {
        return teamBinnings2BatsmanList;
    }

    public void setTeamBinnings2BatsmanList(List<Player> teamBinnings2BatsmanList) {
        this.teamBinnings2BatsmanList = teamBinnings2BatsmanList;
    }

    public List<Player> getTeamBinnings1BowlerList() {
        return teamBinnings1BowlerList;
    }

    public void setTeamBinnings1BowlerList(List<Player> teamBinnings1BowlerList) {
        this.teamBinnings1BowlerList = teamBinnings1BowlerList;
    }

    public List<Player> getTeamBinnings2BowlerList() {
        return teamBinnings2BowlerList;
    }

    public void setTeamBinnings2BowlerList(List<Player> teamBinnings2BowlerList) {
        this.teamBinnings2BowlerList = teamBinnings2BowlerList;
    }

    public List<Player> getTeamAinnings1BowlerList() {
        return teamAinnings1BowlerList;
    }

    public void setTeamAinnings1BowlerList(List<Player> teamAinnings1BowlerList) {
        this.teamAinnings1BowlerList = teamAinnings1BowlerList;
    }

    public List<Player> getTeamAinnings2BowlerList() {
        return teamAinnings2BowlerList;
    }

    public void setTeamAinnings2BowlerList(List<Player> teamAinnings2BowlerList) {
        this.teamAinnings2BowlerList = teamAinnings2BowlerList;
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

    public List<String> getInnings_A_1_batting_order() {
        return innings_A_1_batting_order;
    }

    public void setInnings_A_1_batting_order(List<String> innings_A_1_batting_order) {
        this.innings_A_1_batting_order = innings_A_1_batting_order;
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

    public List<String> getInnings_A_2_bowling_order() {
        return innings_A_2_bowling_order;
    }

    public void setInnings_A_2_bowling_order(List<String> innings_A_2_bowling_order) {
        this.innings_A_2_bowling_order = innings_A_2_bowling_order;
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

    public List<String> getInnings_B_2_bowling_order() {
        return innings_B_2_bowling_order;
    }

    public void setInnings_B_2_bowling_order(List<String> innings_B_2_bowling_order) {
        this.innings_B_2_bowling_order = innings_B_2_bowling_order;
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

    public void setInnings_A_1_batting_player_1_innings_1_out_comment(String innings_A_1_batting_player_1_innings_1_out_comment) {
        this.innings_A_1_batting_player_1_innings_1_out_comment = innings_A_1_batting_player_1_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_1_innings_1_strike_rate() {
        return innings_A_1_batting_player_1_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_1_innings_1_strike_rate(String innings_A_1_batting_player_1_innings_1_strike_rate) {
        this.innings_A_1_batting_player_1_innings_1_strike_rate = innings_A_1_batting_player_1_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_1_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_1_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_1_innings_1_maiden_overs(String innings_A_1_bowling_player_1_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_1_innings_2_out_comment(String innings_A_1_batting_player_1_innings_2_out_comment) {
        this.innings_A_1_batting_player_1_innings_2_out_comment = innings_A_1_batting_player_1_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_1_innings_2_strike_rate() {
        return innings_A_1_batting_player_1_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_1_innings_2_strike_rate(String innings_A_1_batting_player_1_innings_2_strike_rate) {
        this.innings_A_1_batting_player_1_innings_2_strike_rate = innings_A_1_batting_player_1_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_1_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_1_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_1_innings_2_maiden_overs(String innings_A_1_bowling_player_1_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_2_innings_1_out_comment(String innings_A_1_batting_player_2_innings_1_out_comment) {
        this.innings_A_1_batting_player_2_innings_1_out_comment = innings_A_1_batting_player_2_innings_1_out_comment;
    }

    public String getInnings_A_1_bowling_player_2_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_2_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_2_innings_1_maiden_overs(String innings_A_1_bowling_player_2_innings_1_maiden_overs) {
        this.innings_A_1_bowling_player_2_innings_1_maiden_overs = innings_A_1_bowling_player_2_innings_1_maiden_overs;
    }

    public String getInnings_A_1_batting_player_2_innings_1_strike_rate() {
        return innings_A_1_batting_player_2_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_2_innings_1_strike_rate(String innings_A_1_batting_player_2_innings_1_strike_rate) {
        this.innings_A_1_batting_player_2_innings_1_strike_rate = innings_A_1_batting_player_2_innings_1_strike_rate;
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

    public void setInnings_A_1_batting_player_2_innings_2_out_comment(String innings_A_1_batting_player_2_innings_2_out_comment) {
        this.innings_A_1_batting_player_2_innings_2_out_comment = innings_A_1_batting_player_2_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_2_innings_2_strike_rate() {
        return innings_A_1_batting_player_2_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_2_innings_2_strike_rate(String innings_A_1_batting_player_2_innings_2_strike_rate) {
        this.innings_A_1_batting_player_2_innings_2_strike_rate = innings_A_1_batting_player_2_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_2_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_2_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_2_innings_2_maiden_overs(String innings_A_1_bowling_player_2_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_3_innings_1_out_comment(String innings_A_1_batting_player_3_innings_1_out_comment) {
        this.innings_A_1_batting_player_3_innings_1_out_comment = innings_A_1_batting_player_3_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_3_innings_1_strike_rate() {
        return innings_A_1_batting_player_3_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_3_innings_1_strike_rate(String innings_A_1_batting_player_3_innings_1_strike_rate) {
        this.innings_A_1_batting_player_3_innings_1_strike_rate = innings_A_1_batting_player_3_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_3_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_3_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_3_innings_1_maiden_overs(String innings_A_1_bowling_player_3_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_3_innings_2_out_comment(String innings_A_1_batting_player_3_innings_2_out_comment) {
        this.innings_A_1_batting_player_3_innings_2_out_comment = innings_A_1_batting_player_3_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_3_innings_2_strike_rate() {
        return innings_A_1_batting_player_3_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_3_innings_2_strike_rate(String innings_A_1_batting_player_3_innings_2_strike_rate) {
        this.innings_A_1_batting_player_3_innings_2_strike_rate = innings_A_1_batting_player_3_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_3_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_3_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_3_innings_2_maiden_overs(String innings_A_1_bowling_player_3_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_4_innings_1_out_comment(String innings_A_1_batting_player_4_innings_1_out_comment) {
        this.innings_A_1_batting_player_4_innings_1_out_comment = innings_A_1_batting_player_4_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_4_innings_1_strike_rate() {
        return innings_A_1_batting_player_4_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_4_innings_1_strike_rate(String innings_A_1_batting_player_4_innings_1_strike_rate) {
        this.innings_A_1_batting_player_4_innings_1_strike_rate = innings_A_1_batting_player_4_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_4_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_4_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_4_innings_1_maiden_overs(String innings_A_1_bowling_player_4_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_4_innings_2_out_comment(String innings_A_1_batting_player_4_innings_2_out_comment) {
        this.innings_A_1_batting_player_4_innings_2_out_comment = innings_A_1_batting_player_4_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_4_innings_2_strike_rate() {
        return innings_A_1_batting_player_4_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_4_innings_2_strike_rate(String innings_A_1_batting_player_4_innings_2_strike_rate) {
        this.innings_A_1_batting_player_4_innings_2_strike_rate = innings_A_1_batting_player_4_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_4_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_4_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_4_innings_2_maiden_overs(String innings_A_1_bowling_player_4_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_5_innings_1_out_comment(String innings_A_1_batting_player_5_innings_1_out_comment) {
        this.innings_A_1_batting_player_5_innings_1_out_comment = innings_A_1_batting_player_5_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_5_innings_1_strike_rate() {
        return innings_A_1_batting_player_5_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_5_innings_1_strike_rate(String innings_A_1_batting_player_5_innings_1_strike_rate) {
        this.innings_A_1_batting_player_5_innings_1_strike_rate = innings_A_1_batting_player_5_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_5_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_5_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_5_innings_1_maiden_overs(String innings_A_1_bowling_player_5_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_5_innings_2_out_comment(String innings_A_1_batting_player_5_innings_2_out_comment) {
        this.innings_A_1_batting_player_5_innings_2_out_comment = innings_A_1_batting_player_5_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_5_innings_2_strike_rate() {
        return innings_A_1_batting_player_5_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_5_innings_2_strike_rate(String innings_A_1_batting_player_5_innings_2_strike_rate) {
        this.innings_A_1_batting_player_5_innings_2_strike_rate = innings_A_1_batting_player_5_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_5_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_5_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_5_innings_2_maiden_overs(String innings_A_1_bowling_player_5_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_6_innings_1_out_comment(String innings_A_1_batting_player_6_innings_1_out_comment) {
        this.innings_A_1_batting_player_6_innings_1_out_comment = innings_A_1_batting_player_6_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_6_innings_1_strike_rate() {
        return innings_A_1_batting_player_6_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_6_innings_1_strike_rate(String innings_A_1_batting_player_6_innings_1_strike_rate) {
        this.innings_A_1_batting_player_6_innings_1_strike_rate = innings_A_1_batting_player_6_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_6_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_6_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_6_innings_1_maiden_overs(String innings_A_1_bowling_player_6_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_6_innings_2_out_comment(String innings_A_1_batting_player_6_innings_2_out_comment) {
        this.innings_A_1_batting_player_6_innings_2_out_comment = innings_A_1_batting_player_6_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_6_innings_2_strike_rate() {
        return innings_A_1_batting_player_6_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_6_innings_2_strike_rate(String innings_A_1_batting_player_6_innings_2_strike_rate) {
        this.innings_A_1_batting_player_6_innings_2_strike_rate = innings_A_1_batting_player_6_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_6_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_6_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_6_innings_2_maiden_overs(String innings_A_1_bowling_player_6_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_7_innings_1_out_comment(String innings_A_1_batting_player_7_innings_1_out_comment) {
        this.innings_A_1_batting_player_7_innings_1_out_comment = innings_A_1_batting_player_7_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_7_innings_1_strike_rate() {
        return innings_A_1_batting_player_7_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_7_innings_1_strike_rate(String innings_A_1_batting_player_7_innings_1_strike_rate) {
        this.innings_A_1_batting_player_7_innings_1_strike_rate = innings_A_1_batting_player_7_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_7_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_7_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_7_innings_1_maiden_overs(String innings_A_1_bowling_player_7_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_7_innings_2_out_comment(String innings_A_1_batting_player_7_innings_2_out_comment) {
        this.innings_A_1_batting_player_7_innings_2_out_comment = innings_A_1_batting_player_7_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_7_innings_2_strike_rate() {
        return innings_A_1_batting_player_7_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_7_innings_2_strike_rate(String innings_A_1_batting_player_7_innings_2_strike_rate) {
        this.innings_A_1_batting_player_7_innings_2_strike_rate = innings_A_1_batting_player_7_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_7_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_7_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_7_innings_2_maiden_overs(String innings_A_1_bowling_player_7_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_8_innings_1_out_comment(String innings_A_1_batting_player_8_innings_1_out_comment) {
        this.innings_A_1_batting_player_8_innings_1_out_comment = innings_A_1_batting_player_8_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_8_innings_1_strike_rate() {
        return innings_A_1_batting_player_8_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_8_innings_1_strike_rate(String innings_A_1_batting_player_8_innings_1_strike_rate) {
        this.innings_A_1_batting_player_8_innings_1_strike_rate = innings_A_1_batting_player_8_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_8_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_8_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_8_innings_1_maiden_overs(String innings_A_1_bowling_player_8_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_8_innings_2_out_comment(String innings_A_1_batting_player_8_innings_2_out_comment) {
        this.innings_A_1_batting_player_8_innings_2_out_comment = innings_A_1_batting_player_8_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_8_innings_2_strike_rate() {
        return innings_A_1_batting_player_8_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_8_innings_2_strike_rate(String innings_A_1_batting_player_8_innings_2_strike_rate) {
        this.innings_A_1_batting_player_8_innings_2_strike_rate = innings_A_1_batting_player_8_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_8_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_8_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_8_innings_2_maiden_overs(String innings_A_1_bowling_player_8_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_9_innings_1_out_comment(String innings_A_1_batting_player_9_innings_1_out_comment) {
        this.innings_A_1_batting_player_9_innings_1_out_comment = innings_A_1_batting_player_9_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_9_innings_1_strike_rate() {
        return innings_A_1_batting_player_9_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_9_innings_1_strike_rate(String innings_A_1_batting_player_9_innings_1_strike_rate) {
        this.innings_A_1_batting_player_9_innings_1_strike_rate = innings_A_1_batting_player_9_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_9_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_9_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_9_innings_1_maiden_overs(String innings_A_1_bowling_player_9_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_9_innings_2_out_comment(String innings_A_1_batting_player_9_innings_2_out_comment) {
        this.innings_A_1_batting_player_9_innings_2_out_comment = innings_A_1_batting_player_9_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_9_innings_2_strike_rate() {
        return innings_A_1_batting_player_9_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_9_innings_2_strike_rate(String innings_A_1_batting_player_9_innings_2_strike_rate) {
        this.innings_A_1_batting_player_9_innings_2_strike_rate = innings_A_1_batting_player_9_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_9_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_9_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_9_innings_2_maiden_overs(String innings_A_1_bowling_player_9_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_10_innings_1_out_comment(String innings_A_1_batting_player_10_innings_1_out_comment) {
        this.innings_A_1_batting_player_10_innings_1_out_comment = innings_A_1_batting_player_10_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_10_innings_1_strike_rate() {
        return innings_A_1_batting_player_10_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_10_innings_1_strike_rate(String innings_A_1_batting_player_10_innings_1_strike_rate) {
        this.innings_A_1_batting_player_10_innings_1_strike_rate = innings_A_1_batting_player_10_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_10_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_10_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_10_innings_1_maiden_overs(String innings_A_1_bowling_player_10_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_10_innings_2_out_comment(String innings_A_1_batting_player_10_innings_2_out_comment) {
        this.innings_A_1_batting_player_10_innings_2_out_comment = innings_A_1_batting_player_10_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_10_innings_2_strike_rate() {
        return innings_A_1_batting_player_10_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_10_innings_2_strike_rate(String innings_A_1_batting_player_10_innings_2_strike_rate) {
        this.innings_A_1_batting_player_10_innings_2_strike_rate = innings_A_1_batting_player_10_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_10_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_10_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_10_innings_2_maiden_overs(String innings_A_1_bowling_player_10_innings_2_maiden_overs) {
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

    public void setInnings_A_1_batting_player_11_innings_1_out_comment(String innings_A_1_batting_player_11_innings_1_out_comment) {
        this.innings_A_1_batting_player_11_innings_1_out_comment = innings_A_1_batting_player_11_innings_1_out_comment;
    }

    public String getInnings_A_1_batting_player_11_innings_1_strike_rate() {
        return innings_A_1_batting_player_11_innings_1_strike_rate;
    }

    public void setInnings_A_1_batting_player_11_innings_1_strike_rate(String innings_A_1_batting_player_11_innings_1_strike_rate) {
        this.innings_A_1_batting_player_11_innings_1_strike_rate = innings_A_1_batting_player_11_innings_1_strike_rate;
    }

    public String getInnings_A_1_bowling_player_11_innings_1_maiden_overs() {
        return innings_A_1_bowling_player_11_innings_1_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_11_innings_1_maiden_overs(String innings_A_1_bowling_player_11_innings_1_maiden_overs) {
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

    public void setInnings_A_1_batting_player_11_innings_2_out_comment(String innings_A_1_batting_player_11_innings_2_out_comment) {
        this.innings_A_1_batting_player_11_innings_2_out_comment = innings_A_1_batting_player_11_innings_2_out_comment;
    }

    public String getInnings_A_1_batting_player_11_innings_2_strike_rate() {
        return innings_A_1_batting_player_11_innings_2_strike_rate;
    }

    public void setInnings_A_1_batting_player_11_innings_2_strike_rate(String innings_A_1_batting_player_11_innings_2_strike_rate) {
        this.innings_A_1_batting_player_11_innings_2_strike_rate = innings_A_1_batting_player_11_innings_2_strike_rate;
    }

    public String getInnings_A_1_bowling_player_11_innings_2_maiden_overs() {
        return innings_A_1_bowling_player_11_innings_2_maiden_overs;
    }

    public void setInnings_A_1_bowling_player_11_innings_2_maiden_overs(String innings_A_1_bowling_player_11_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_1_innings_1_out_comment(String innings_B_1_batting_player_1_innings_1_out_comment) {
        this.innings_B_1_batting_player_1_innings_1_out_comment = innings_B_1_batting_player_1_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_1_innings_1_strike_rate() {
        return innings_B_1_batting_player_1_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_1_innings_1_strike_rate(String innings_B_1_batting_player_1_innings_1_strike_rate) {
        this.innings_B_1_batting_player_1_innings_1_strike_rate = innings_B_1_batting_player_1_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_1_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_1_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_1_innings_1_maiden_overs(String innings_B_1_bowling_player_1_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_1_innings_2_out_comment(String innings_B_1_batting_player_1_innings_2_out_comment) {
        this.innings_B_1_batting_player_1_innings_2_out_comment = innings_B_1_batting_player_1_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_1_innings_2_strike_rate() {
        return innings_B_1_batting_player_1_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_1_innings_2_strike_rate(String innings_B_1_batting_player_1_innings_2_strike_rate) {
        this.innings_B_1_batting_player_1_innings_2_strike_rate = innings_B_1_batting_player_1_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_1_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_1_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_1_innings_2_maiden_overs(String innings_B_1_bowling_player_1_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_2_innings_1_out_comment(String innings_B_1_batting_player_2_innings_1_out_comment) {
        this.innings_B_1_batting_player_2_innings_1_out_comment = innings_B_1_batting_player_2_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_2_innings_1_strike_rate() {
        return innings_B_1_batting_player_2_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_2_innings_1_strike_rate(String innings_B_1_batting_player_2_innings_1_strike_rate) {
        this.innings_B_1_batting_player_2_innings_1_strike_rate = innings_B_1_batting_player_2_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_2_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_2_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_2_innings_1_maiden_overs(String innings_B_1_bowling_player_2_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_2_innings_2_out_comment(String innings_B_1_batting_player_2_innings_2_out_comment) {
        this.innings_B_1_batting_player_2_innings_2_out_comment = innings_B_1_batting_player_2_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_2_innings_2_strike_rate() {
        return innings_B_1_batting_player_2_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_2_innings_2_strike_rate(String innings_B_1_batting_player_2_innings_2_strike_rate) {
        this.innings_B_1_batting_player_2_innings_2_strike_rate = innings_B_1_batting_player_2_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_2_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_2_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_2_innings_2_maiden_overs(String innings_B_1_bowling_player_2_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_3_innings_1_out_comment(String innings_B_1_batting_player_3_innings_1_out_comment) {
        this.innings_B_1_batting_player_3_innings_1_out_comment = innings_B_1_batting_player_3_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_3_innings_1_strike_rate() {
        return innings_B_1_batting_player_3_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_3_innings_1_strike_rate(String innings_B_1_batting_player_3_innings_1_strike_rate) {
        this.innings_B_1_batting_player_3_innings_1_strike_rate = innings_B_1_batting_player_3_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_3_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_3_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_3_innings_1_maiden_overs(String innings_B_1_bowling_player_3_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_3_innings_2_out_comment(String innings_B_1_batting_player_3_innings_2_out_comment) {
        this.innings_B_1_batting_player_3_innings_2_out_comment = innings_B_1_batting_player_3_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_3_innings_2_strike_rate() {
        return innings_B_1_batting_player_3_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_3_innings_2_strike_rate(String innings_B_1_batting_player_3_innings_2_strike_rate) {
        this.innings_B_1_batting_player_3_innings_2_strike_rate = innings_B_1_batting_player_3_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_3_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_3_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_3_innings_2_maiden_overs(String innings_B_1_bowling_player_3_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_4_innings_1_out_comment(String innings_B_1_batting_player_4_innings_1_out_comment) {
        this.innings_B_1_batting_player_4_innings_1_out_comment = innings_B_1_batting_player_4_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_4_innings_1_strike_rate() {
        return innings_B_1_batting_player_4_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_4_innings_1_strike_rate(String innings_B_1_batting_player_4_innings_1_strike_rate) {
        this.innings_B_1_batting_player_4_innings_1_strike_rate = innings_B_1_batting_player_4_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_4_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_4_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_4_innings_1_maiden_overs(String innings_B_1_bowling_player_4_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_4_innings_2_out_comment(String innings_B_1_batting_player_4_innings_2_out_comment) {
        this.innings_B_1_batting_player_4_innings_2_out_comment = innings_B_1_batting_player_4_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_4_innings_2_strike_rate() {
        return innings_B_1_batting_player_4_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_4_innings_2_strike_rate(String innings_B_1_batting_player_4_innings_2_strike_rate) {
        this.innings_B_1_batting_player_4_innings_2_strike_rate = innings_B_1_batting_player_4_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_4_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_4_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_4_innings_2_maiden_overs(String innings_B_1_bowling_player_4_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_5_innings_1_out_comment(String innings_B_1_batting_player_5_innings_1_out_comment) {
        this.innings_B_1_batting_player_5_innings_1_out_comment = innings_B_1_batting_player_5_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_5_innings_1_strike_rate() {
        return innings_B_1_batting_player_5_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_5_innings_1_strike_rate(String innings_B_1_batting_player_5_innings_1_strike_rate) {
        this.innings_B_1_batting_player_5_innings_1_strike_rate = innings_B_1_batting_player_5_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_5_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_5_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_5_innings_1_maiden_overs(String innings_B_1_bowling_player_5_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_5_innings_2_out_comment(String innings_B_1_batting_player_5_innings_2_out_comment) {
        this.innings_B_1_batting_player_5_innings_2_out_comment = innings_B_1_batting_player_5_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_5_innings_2_strike_rate() {
        return innings_B_1_batting_player_5_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_5_innings_2_strike_rate(String innings_B_1_batting_player_5_innings_2_strike_rate) {
        this.innings_B_1_batting_player_5_innings_2_strike_rate = innings_B_1_batting_player_5_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_5_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_5_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_5_innings_2_maiden_overs(String innings_B_1_bowling_player_5_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_6_innings_1_out_comment(String innings_B_1_batting_player_6_innings_1_out_comment) {
        this.innings_B_1_batting_player_6_innings_1_out_comment = innings_B_1_batting_player_6_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_6_innings_1_strike_rate() {
        return innings_B_1_batting_player_6_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_6_innings_1_strike_rate(String innings_B_1_batting_player_6_innings_1_strike_rate) {
        this.innings_B_1_batting_player_6_innings_1_strike_rate = innings_B_1_batting_player_6_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_6_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_6_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_6_innings_1_maiden_overs(String innings_B_1_bowling_player_6_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_6_innings_2_out_comment(String innings_B_1_batting_player_6_innings_2_out_comment) {
        this.innings_B_1_batting_player_6_innings_2_out_comment = innings_B_1_batting_player_6_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_6_innings_2_strike_rate() {
        return innings_B_1_batting_player_6_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_6_innings_2_strike_rate(String innings_B_1_batting_player_6_innings_2_strike_rate) {
        this.innings_B_1_batting_player_6_innings_2_strike_rate = innings_B_1_batting_player_6_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_6_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_6_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_6_innings_2_maiden_overs(String innings_B_1_bowling_player_6_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_7_innings_1_out_comment(String innings_B_1_batting_player_7_innings_1_out_comment) {
        this.innings_B_1_batting_player_7_innings_1_out_comment = innings_B_1_batting_player_7_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_7_innings_1_strike_rate() {
        return innings_B_1_batting_player_7_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_7_innings_1_strike_rate(String innings_B_1_batting_player_7_innings_1_strike_rate) {
        this.innings_B_1_batting_player_7_innings_1_strike_rate = innings_B_1_batting_player_7_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_7_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_7_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_7_innings_1_maiden_overs(String innings_B_1_bowling_player_7_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_7_innings_2_out_comment(String innings_B_1_batting_player_7_innings_2_out_comment) {
        this.innings_B_1_batting_player_7_innings_2_out_comment = innings_B_1_batting_player_7_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_7_innings_2_strike_rate() {
        return innings_B_1_batting_player_7_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_7_innings_2_strike_rate(String innings_B_1_batting_player_7_innings_2_strike_rate) {
        this.innings_B_1_batting_player_7_innings_2_strike_rate = innings_B_1_batting_player_7_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_7_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_7_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_7_innings_2_maiden_overs(String innings_B_1_bowling_player_7_innings_2_maiden_overs) {
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

    public String getInnings_B_1_batting_player_8_innings_1_strike_rate() {
        return innings_B_1_batting_player_8_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_8_innings_1_strike_rate(String innings_B_1_batting_player_8_innings_1_strike_rate) {
        this.innings_B_1_batting_player_8_innings_1_strike_rate = innings_B_1_batting_player_8_innings_1_strike_rate;
    }

    public String getInnings_B_1_batting_player_8_innings_1_out_comment() {
        return innings_B_1_batting_player_8_innings_1_out_comment;
    }

    public void setInnings_B_1_batting_player_8_innings_1_out_comment(String innings_B_1_batting_player_8_innings_1_out_comment) {
        this.innings_B_1_batting_player_8_innings_1_out_comment = innings_B_1_batting_player_8_innings_1_out_comment;
    }

    public String getInnings_B_1_bowling_player_8_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_8_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_8_innings_1_maiden_overs(String innings_B_1_bowling_player_8_innings_1_maiden_overs) {
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

    public String getInnings_B_1_batting_player_8_innings_2_strike_rate() {
        return innings_B_1_batting_player_8_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_8_innings_2_strike_rate(String innings_B_1_batting_player_8_innings_2_strike_rate) {
        this.innings_B_1_batting_player_8_innings_2_strike_rate = innings_B_1_batting_player_8_innings_2_strike_rate;
    }

    public String getInnings_B_1_batting_player_8_innings_2_out_comment() {
        return innings_B_1_batting_player_8_innings_2_out_comment;
    }

    public void setInnings_B_1_batting_player_8_innings_2_out_comment(String innings_B_1_batting_player_8_innings_2_out_comment) {
        this.innings_B_1_batting_player_8_innings_2_out_comment = innings_B_1_batting_player_8_innings_2_out_comment;
    }

    public String getInnings_B_1_bowling_player_8_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_8_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_8_innings_2_maiden_overs(String innings_B_1_bowling_player_8_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_9_innings_1_out_comment(String innings_B_1_batting_player_9_innings_1_out_comment) {
        this.innings_B_1_batting_player_9_innings_1_out_comment = innings_B_1_batting_player_9_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_9_innings_1_strike_rate() {
        return innings_B_1_batting_player_9_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_9_innings_1_strike_rate(String innings_B_1_batting_player_9_innings_1_strike_rate) {
        this.innings_B_1_batting_player_9_innings_1_strike_rate = innings_B_1_batting_player_9_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_9_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_9_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_9_innings_1_maiden_overs(String innings_B_1_bowling_player_9_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_9_innings_2_out_comment(String innings_B_1_batting_player_9_innings_2_out_comment) {
        this.innings_B_1_batting_player_9_innings_2_out_comment = innings_B_1_batting_player_9_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_9_innings_2_strike_rate() {
        return innings_B_1_batting_player_9_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_9_innings_2_strike_rate(String innings_B_1_batting_player_9_innings_2_strike_rate) {
        this.innings_B_1_batting_player_9_innings_2_strike_rate = innings_B_1_batting_player_9_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_9_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_9_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_9_innings_2_maiden_overs(String innings_B_1_bowling_player_9_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_10_innings_1_out_comment(String innings_B_1_batting_player_10_innings_1_out_comment) {
        this.innings_B_1_batting_player_10_innings_1_out_comment = innings_B_1_batting_player_10_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_10_innings_1_strike_rate() {
        return innings_B_1_batting_player_10_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_10_innings_1_strike_rate(String innings_B_1_batting_player_10_innings_1_strike_rate) {
        this.innings_B_1_batting_player_10_innings_1_strike_rate = innings_B_1_batting_player_10_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_10_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_10_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_10_innings_1_maiden_overs(String innings_B_1_bowling_player_10_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_10_innings_2_out_comment(String innings_B_1_batting_player_10_innings_2_out_comment) {
        this.innings_B_1_batting_player_10_innings_2_out_comment = innings_B_1_batting_player_10_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_10_innings_2_strike_rate() {
        return innings_B_1_batting_player_10_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_10_innings_2_strike_rate(String innings_B_1_batting_player_10_innings_2_strike_rate) {
        this.innings_B_1_batting_player_10_innings_2_strike_rate = innings_B_1_batting_player_10_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_10_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_10_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_10_innings_2_maiden_overs(String innings_B_1_bowling_player_10_innings_2_maiden_overs) {
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

    public void setInnings_B_1_batting_player_11_innings_1_out_comment(String innings_B_1_batting_player_11_innings_1_out_comment) {
        this.innings_B_1_batting_player_11_innings_1_out_comment = innings_B_1_batting_player_11_innings_1_out_comment;
    }

    public String getInnings_B_1_batting_player_11_innings_1_strike_rate() {
        return innings_B_1_batting_player_11_innings_1_strike_rate;
    }

    public void setInnings_B_1_batting_player_11_innings_1_strike_rate(String innings_B_1_batting_player_11_innings_1_strike_rate) {
        this.innings_B_1_batting_player_11_innings_1_strike_rate = innings_B_1_batting_player_11_innings_1_strike_rate;
    }

    public String getInnings_B_1_bowling_player_11_innings_1_maiden_overs() {
        return innings_B_1_bowling_player_11_innings_1_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_11_innings_1_maiden_overs(String innings_B_1_bowling_player_11_innings_1_maiden_overs) {
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

    public void setInnings_B_1_batting_player_11_innings_2_out_comment(String innings_B_1_batting_player_11_innings_2_out_comment) {
        this.innings_B_1_batting_player_11_innings_2_out_comment = innings_B_1_batting_player_11_innings_2_out_comment;
    }

    public String getInnings_B_1_batting_player_11_innings_2_strike_rate() {
        return innings_B_1_batting_player_11_innings_2_strike_rate;
    }

    public void setInnings_B_1_batting_player_11_innings_2_strike_rate(String innings_B_1_batting_player_11_innings_2_strike_rate) {
        this.innings_B_1_batting_player_11_innings_2_strike_rate = innings_B_1_batting_player_11_innings_2_strike_rate;
    }

    public String getInnings_B_1_bowling_player_11_innings_2_maiden_overs() {
        return innings_B_1_bowling_player_11_innings_2_maiden_overs;
    }

    public void setInnings_B_1_bowling_player_11_innings_2_maiden_overs(String innings_B_1_bowling_player_11_innings_2_maiden_overs) {
        this.innings_B_1_bowling_player_11_innings_2_maiden_overs = innings_B_1_bowling_player_11_innings_2_maiden_overs;
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
