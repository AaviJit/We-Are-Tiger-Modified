package com.sweetitech.tiger.mapper;

import com.sweetitech.tiger.model.cricketapi.CardCustomForOni;
import com.sweetitech.tiger.parser.sampleMatchScorecardParser;
import org.springframework.stereotype.Service;

@Service
public class MapToCardCustomForOni {

    /**
     * @param matchScorecardParser
     * @return cardCustomForOni
     */

    public CardCustomForOni map(sampleMatchScorecardParser matchScorecardParser) throws Exception {

        CardCustomForOni cardCustomForOni = new CardCustomForOni();

        //Latest batsman
        cardCustomForOni.setLatest_batsman_1_name(matchScorecardParser.getLatest_batsman_1_name());
        cardCustomForOni.setLatest_batsman_1_strike_rate(matchScorecardParser.getLatest_batsman_1_strike_rate());
        cardCustomForOni.setLatest_batsman_1_runs(matchScorecardParser.getLatest_batsman_1_runs());
        cardCustomForOni.setLatest_batsman_1_balls(matchScorecardParser.getLatest_batsman_1_balls());
        cardCustomForOni.setLatest_batsman_1_sixes(matchScorecardParser.getLatest_batsman_1_sixes());
        cardCustomForOni.setLatest_batsman_1_fours(matchScorecardParser.getLatest_batsman_1_fours());

        cardCustomForOni.setLatest_batsman_2_name(matchScorecardParser.getLatest_batsman_2_name());
        cardCustomForOni.setLatest_batsman_2_strike_rate(matchScorecardParser.getLatest_batsman_2_strike_rate());
        cardCustomForOni.setLatest_batsman_2_runs(matchScorecardParser.getLatest_batsman_2_runs());
        cardCustomForOni.setLatest_batsman_2_balls(matchScorecardParser.getLatest_batsman_2_balls());
        cardCustomForOni.setLatest_batsman_2_sixes(matchScorecardParser.getLatest_batsman_2_sixes());
        cardCustomForOni.setLatest_batsman_2_fours(matchScorecardParser.getLatest_batsman_2_fours());

        //latest bowlers
        cardCustomForOni.setLatest_bowler_1_name(matchScorecardParser.getLatest_bowler_1_name());
        cardCustomForOni.setLatest_bowler_1_over(matchScorecardParser.getLatest_bowler_1_over());
        cardCustomForOni.setLatest_bowler_1_maiden(matchScorecardParser.getLatest_bowler_1_maiden());
        cardCustomForOni.setLatest_bowler_1_run(matchScorecardParser.getLatest_bowler_1_run());
        cardCustomForOni.setLatest_bowler_1_wicket(matchScorecardParser.getLatest_bowler_1_wicket());
        cardCustomForOni.setLatest_bowler_1_eco(matchScorecardParser.getLatest_bowler_1_eco());

        cardCustomForOni.setLatest_bowler_2_name(matchScorecardParser.getLatest_bowler_2_name());
        cardCustomForOni.setLatest_bowler_2_over(matchScorecardParser.getLatest_bowler_2_over());
        cardCustomForOni.setLatest_bowler_2_maiden(matchScorecardParser.getLatest_bowler_2_maiden());
        cardCustomForOni.setLatest_bowler_2_run(matchScorecardParser.getLatest_bowler_2_run());
        cardCustomForOni.setLatest_bowler_2_wicket(matchScorecardParser.getLatest_bowler_2_wicket());
        cardCustomForOni.setLatest_bowler_2_eco(matchScorecardParser.getLatest_bowler_2_eco());

        cardCustomForOni.setRecent_over_summary(matchScorecardParser.getRecent_over_summary());







        //All Innings Bowlers
        //player 1
        cardCustomForOni.setBowling_a_1_player_1_name(matchScorecardParser.getBowling_a_1_player_1_name());
        cardCustomForOni.setBowling_a_1_player_1_economy(matchScorecardParser.getBowling_a_1_player_1_economy());
        cardCustomForOni.setBowling_a_1_player_1_runs(matchScorecardParser.getBowling_a_1_player_1_runs());
        cardCustomForOni.setBowling_a_1_player_1_wickets(matchScorecardParser.getBowling_a_1_player_1_wickets());
        cardCustomForOni.setBowling_a_1_player_1_extras(matchScorecardParser.getBowling_a_1_player_1_extras());
        cardCustomForOni.setBowling_a_1_player_1_maiden_overs(matchScorecardParser.getBowling_a_1_player_1_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_1_overs(matchScorecardParser.getBowling_a_1_player_1_overs());

        cardCustomForOni.setBowling_a_2_player_1_name(matchScorecardParser.getBowling_a_2_player_1_name());
        cardCustomForOni.setBowling_a_2_player_1_economy(matchScorecardParser.getBowling_a_2_player_1_economy());
        cardCustomForOni.setBowling_a_2_player_1_runs(matchScorecardParser.getBowling_a_2_player_1_runs());
        cardCustomForOni.setBowling_a_2_player_1_wickets(matchScorecardParser.getBowling_a_2_player_1_wickets());
        cardCustomForOni.setBowling_a_2_player_1_extras(matchScorecardParser.getBowling_a_2_player_1_extras());
        cardCustomForOni.setBowling_a_2_player_1_maiden_overs(matchScorecardParser.getBowling_a_2_player_1_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_1_overs(matchScorecardParser.getBowling_a_2_player_1_overs());


        cardCustomForOni.setBowling_b_1_player_1_name(matchScorecardParser.getBowling_b_1_player_1_name());
        cardCustomForOni.setBowling_b_1_player_1_economy(matchScorecardParser.getBowling_b_1_player_1_economy());
        cardCustomForOni.setBowling_b_1_player_1_runs(matchScorecardParser.getBowling_b_1_player_1_runs());
        cardCustomForOni.setBowling_b_1_player_1_wickets(matchScorecardParser.getBowling_b_1_player_1_wickets());
        cardCustomForOni.setBowling_b_1_player_1_extras(matchScorecardParser.getBowling_b_1_player_1_extras());
        cardCustomForOni.setBowling_b_1_player_1_maiden_overs(matchScorecardParser.getBowling_b_1_player_1_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_1_overs(matchScorecardParser.getBowling_b_1_player_1_overs());

        cardCustomForOni.setBowling_b_2_player_1_name(matchScorecardParser.getBowling_b_2_player_1_name());
        cardCustomForOni.setBowling_b_2_player_1_economy(matchScorecardParser.getBowling_b_2_player_1_economy());
        cardCustomForOni.setBowling_b_2_player_1_runs(matchScorecardParser.getBowling_b_2_player_1_runs());
        cardCustomForOni.setBowling_b_2_player_1_wickets(matchScorecardParser.getBowling_b_2_player_1_wickets());
        cardCustomForOni.setBowling_b_2_player_1_extras(matchScorecardParser.getBowling_b_2_player_1_extras());
        cardCustomForOni.setBowling_b_2_player_1_maiden_overs(matchScorecardParser.getBowling_b_2_player_1_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_1_overs(matchScorecardParser.getBowling_b_2_player_1_overs());

        //player 2
        cardCustomForOni.setBowling_a_1_player_2_name(matchScorecardParser.getBowling_a_1_player_2_name());
        cardCustomForOni.setBowling_a_1_player_2_economy(matchScorecardParser.getBowling_a_1_player_2_economy());
        cardCustomForOni.setBowling_a_1_player_2_runs(matchScorecardParser.getBowling_a_1_player_2_runs());
        cardCustomForOni.setBowling_a_1_player_2_wickets(matchScorecardParser.getBowling_a_1_player_2_wickets());
        cardCustomForOni.setBowling_a_1_player_2_extras(matchScorecardParser.getBowling_a_1_player_2_extras());
        cardCustomForOni.setBowling_a_1_player_2_maiden_overs(matchScorecardParser.getBowling_a_1_player_2_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_2_overs(matchScorecardParser.getBowling_a_1_player_2_overs());

        cardCustomForOni.setBowling_a_2_player_2_name(matchScorecardParser.getBowling_a_2_player_2_name());
        cardCustomForOni.setBowling_a_2_player_2_economy(matchScorecardParser.getBowling_a_2_player_2_economy());
        cardCustomForOni.setBowling_a_2_player_2_runs(matchScorecardParser.getBowling_a_2_player_2_runs());
        cardCustomForOni.setBowling_a_2_player_2_wickets(matchScorecardParser.getBowling_a_2_player_2_wickets());
        cardCustomForOni.setBowling_a_2_player_2_extras(matchScorecardParser.getBowling_a_2_player_2_extras());
        cardCustomForOni.setBowling_a_2_player_2_maiden_overs(matchScorecardParser.getBowling_a_2_player_2_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_2_overs(matchScorecardParser.getBowling_a_2_player_2_overs());


        cardCustomForOni.setBowling_b_1_player_2_name(matchScorecardParser.getBowling_b_1_player_2_name());
        cardCustomForOni.setBowling_b_1_player_2_economy(matchScorecardParser.getBowling_b_1_player_2_economy());
        cardCustomForOni.setBowling_b_1_player_2_runs(matchScorecardParser.getBowling_b_1_player_2_runs());
        cardCustomForOni.setBowling_b_1_player_2_wickets(matchScorecardParser.getBowling_b_1_player_2_wickets());
        cardCustomForOni.setBowling_b_1_player_2_extras(matchScorecardParser.getBowling_b_1_player_2_extras());
        cardCustomForOni.setBowling_b_1_player_2_maiden_overs(matchScorecardParser.getBowling_b_1_player_2_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_2_overs(matchScorecardParser.getBowling_b_1_player_2_overs());

        cardCustomForOni.setBowling_b_2_player_2_name(matchScorecardParser.getBowling_b_2_player_2_name());
        cardCustomForOni.setBowling_b_2_player_2_economy(matchScorecardParser.getBowling_b_2_player_2_economy());
        cardCustomForOni.setBowling_b_2_player_2_runs(matchScorecardParser.getBowling_b_2_player_2_runs());
        cardCustomForOni.setBowling_b_2_player_2_wickets(matchScorecardParser.getBowling_b_2_player_2_wickets());
        cardCustomForOni.setBowling_b_2_player_2_extras(matchScorecardParser.getBowling_b_2_player_2_extras());
        cardCustomForOni.setBowling_b_2_player_2_maiden_overs(matchScorecardParser.getBowling_b_2_player_2_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_2_overs(matchScorecardParser.getBowling_b_2_player_2_overs());

        //player 3
        cardCustomForOni.setBowling_a_1_player_3_name(matchScorecardParser.getBowling_a_1_player_3_name());
        cardCustomForOni.setBowling_a_1_player_3_economy(matchScorecardParser.getBowling_a_1_player_3_economy());
        cardCustomForOni.setBowling_a_1_player_3_runs(matchScorecardParser.getBowling_a_1_player_3_runs());
        cardCustomForOni.setBowling_a_1_player_3_wickets(matchScorecardParser.getBowling_a_1_player_3_wickets());
        cardCustomForOni.setBowling_a_1_player_3_extras(matchScorecardParser.getBowling_a_1_player_3_extras());
        cardCustomForOni.setBowling_a_1_player_3_maiden_overs(matchScorecardParser.getBowling_a_1_player_3_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_3_overs(matchScorecardParser.getBowling_a_1_player_3_overs());

        cardCustomForOni.setBowling_a_2_player_3_name(matchScorecardParser.getBowling_a_2_player_3_name());
        cardCustomForOni.setBowling_a_2_player_3_economy(matchScorecardParser.getBowling_a_2_player_3_economy());
        cardCustomForOni.setBowling_a_2_player_3_runs(matchScorecardParser.getBowling_a_2_player_3_runs());
        cardCustomForOni.setBowling_a_2_player_3_wickets(matchScorecardParser.getBowling_a_2_player_3_wickets());
        cardCustomForOni.setBowling_a_2_player_3_extras(matchScorecardParser.getBowling_a_2_player_3_extras());
        cardCustomForOni.setBowling_a_2_player_3_maiden_overs(matchScorecardParser.getBowling_a_2_player_3_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_3_overs(matchScorecardParser.getBowling_a_2_player_3_overs());


        cardCustomForOni.setBowling_b_1_player_3_name(matchScorecardParser.getBowling_b_1_player_3_name());
        cardCustomForOni.setBowling_b_1_player_3_economy(matchScorecardParser.getBowling_b_1_player_3_economy());
        cardCustomForOni.setBowling_b_1_player_3_runs(matchScorecardParser.getBowling_b_1_player_3_runs());
        cardCustomForOni.setBowling_b_1_player_3_wickets(matchScorecardParser.getBowling_b_1_player_3_wickets());
        cardCustomForOni.setBowling_b_1_player_3_extras(matchScorecardParser.getBowling_b_1_player_3_extras());
        cardCustomForOni.setBowling_b_1_player_3_maiden_overs(matchScorecardParser.getBowling_b_1_player_3_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_3_overs(matchScorecardParser.getBowling_b_1_player_3_overs());

        cardCustomForOni.setBowling_b_2_player_3_name(matchScorecardParser.getBowling_b_2_player_3_name());
        cardCustomForOni.setBowling_b_2_player_3_economy(matchScorecardParser.getBowling_b_2_player_3_economy());
        cardCustomForOni.setBowling_b_2_player_3_runs(matchScorecardParser.getBowling_b_2_player_3_runs());
        cardCustomForOni.setBowling_b_2_player_3_wickets(matchScorecardParser.getBowling_b_2_player_3_wickets());
        cardCustomForOni.setBowling_b_2_player_3_extras(matchScorecardParser.getBowling_b_2_player_3_extras());
        cardCustomForOni.setBowling_b_2_player_3_maiden_overs(matchScorecardParser.getBowling_b_2_player_3_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_3_overs(matchScorecardParser.getBowling_b_2_player_3_overs());

        //player 4
        cardCustomForOni.setBowling_a_1_player_4_name(matchScorecardParser.getBowling_a_1_player_4_name());
        cardCustomForOni.setBowling_a_1_player_4_economy(matchScorecardParser.getBowling_a_1_player_4_economy());
        cardCustomForOni.setBowling_a_1_player_4_runs(matchScorecardParser.getBowling_a_1_player_4_runs());
        cardCustomForOni.setBowling_a_1_player_4_wickets(matchScorecardParser.getBowling_a_1_player_4_wickets());
        cardCustomForOni.setBowling_a_1_player_4_extras(matchScorecardParser.getBowling_a_1_player_4_extras());
        cardCustomForOni.setBowling_a_1_player_4_maiden_overs(matchScorecardParser.getBowling_a_1_player_4_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_4_overs(matchScorecardParser.getBowling_a_1_player_4_overs());

        cardCustomForOni.setBowling_a_2_player_4_name(matchScorecardParser.getBowling_a_2_player_4_name());
        cardCustomForOni.setBowling_a_2_player_4_economy(matchScorecardParser.getBowling_a_2_player_4_economy());
        cardCustomForOni.setBowling_a_2_player_4_runs(matchScorecardParser.getBowling_a_2_player_4_runs());
        cardCustomForOni.setBowling_a_2_player_4_wickets(matchScorecardParser.getBowling_a_2_player_4_wickets());
        cardCustomForOni.setBowling_a_2_player_4_extras(matchScorecardParser.getBowling_a_2_player_4_extras());
        cardCustomForOni.setBowling_a_2_player_4_maiden_overs(matchScorecardParser.getBowling_a_2_player_4_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_4_overs(matchScorecardParser.getBowling_a_2_player_4_overs());


        cardCustomForOni.setBowling_b_1_player_4_name(matchScorecardParser.getBowling_b_1_player_4_name());
        cardCustomForOni.setBowling_b_1_player_4_economy(matchScorecardParser.getBowling_b_1_player_4_economy());
        cardCustomForOni.setBowling_b_1_player_4_runs(matchScorecardParser.getBowling_b_1_player_4_runs());
        cardCustomForOni.setBowling_b_1_player_4_wickets(matchScorecardParser.getBowling_b_1_player_4_wickets());
        cardCustomForOni.setBowling_b_1_player_4_extras(matchScorecardParser.getBowling_b_1_player_4_extras());
        cardCustomForOni.setBowling_b_1_player_4_maiden_overs(matchScorecardParser.getBowling_b_1_player_4_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_4_overs(matchScorecardParser.getBowling_b_1_player_4_overs());

        cardCustomForOni.setBowling_b_2_player_4_name(matchScorecardParser.getBowling_b_2_player_4_name());
        cardCustomForOni.setBowling_b_2_player_4_economy(matchScorecardParser.getBowling_b_2_player_4_economy());
        cardCustomForOni.setBowling_b_2_player_4_runs(matchScorecardParser.getBowling_b_2_player_4_runs());
        cardCustomForOni.setBowling_b_2_player_4_wickets(matchScorecardParser.getBowling_b_2_player_4_wickets());
        cardCustomForOni.setBowling_b_2_player_4_extras(matchScorecardParser.getBowling_b_2_player_4_extras());
        cardCustomForOni.setBowling_b_2_player_4_maiden_overs(matchScorecardParser.getBowling_b_2_player_4_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_4_overs(matchScorecardParser.getBowling_b_2_player_4_overs());


        //player 5
        cardCustomForOni.setBowling_a_1_player_5_name(matchScorecardParser.getBowling_a_1_player_5_name());
        cardCustomForOni.setBowling_a_1_player_5_economy(matchScorecardParser.getBowling_a_1_player_5_economy());
        cardCustomForOni.setBowling_a_1_player_5_runs(matchScorecardParser.getBowling_a_1_player_5_runs());
        cardCustomForOni.setBowling_a_1_player_5_wickets(matchScorecardParser.getBowling_a_1_player_5_wickets());
        cardCustomForOni.setBowling_a_1_player_5_extras(matchScorecardParser.getBowling_a_1_player_5_extras());
        cardCustomForOni.setBowling_a_1_player_5_maiden_overs(matchScorecardParser.getBowling_a_1_player_5_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_5_overs(matchScorecardParser.getBowling_a_1_player_5_overs());

        cardCustomForOni.setBowling_a_2_player_5_name(matchScorecardParser.getBowling_a_2_player_5_name());
        cardCustomForOni.setBowling_a_2_player_5_economy(matchScorecardParser.getBowling_a_2_player_5_economy());
        cardCustomForOni.setBowling_a_2_player_5_runs(matchScorecardParser.getBowling_a_2_player_5_runs());
        cardCustomForOni.setBowling_a_2_player_5_wickets(matchScorecardParser.getBowling_a_2_player_5_wickets());
        cardCustomForOni.setBowling_a_2_player_5_extras(matchScorecardParser.getBowling_a_2_player_5_extras());
        cardCustomForOni.setBowling_a_2_player_5_maiden_overs(matchScorecardParser.getBowling_a_2_player_5_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_5_overs(matchScorecardParser.getBowling_a_2_player_5_overs());


        cardCustomForOni.setBowling_b_1_player_5_name(matchScorecardParser.getBowling_b_1_player_5_name());
        cardCustomForOni.setBowling_b_1_player_5_economy(matchScorecardParser.getBowling_b_1_player_5_economy());
        cardCustomForOni.setBowling_b_1_player_5_runs(matchScorecardParser.getBowling_b_1_player_5_runs());
        cardCustomForOni.setBowling_b_1_player_5_wickets(matchScorecardParser.getBowling_b_1_player_5_wickets());
        cardCustomForOni.setBowling_b_1_player_5_extras(matchScorecardParser.getBowling_b_1_player_5_extras());
        cardCustomForOni.setBowling_b_1_player_5_maiden_overs(matchScorecardParser.getBowling_b_1_player_5_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_5_overs(matchScorecardParser.getBowling_b_1_player_5_overs());

        cardCustomForOni.setBowling_b_2_player_5_name(matchScorecardParser.getBowling_b_2_player_5_name());
        cardCustomForOni.setBowling_b_2_player_5_economy(matchScorecardParser.getBowling_b_2_player_5_economy());
        cardCustomForOni.setBowling_b_2_player_5_runs(matchScorecardParser.getBowling_b_2_player_5_runs());
        cardCustomForOni.setBowling_b_2_player_5_wickets(matchScorecardParser.getBowling_b_2_player_5_wickets());
        cardCustomForOni.setBowling_b_2_player_5_extras(matchScorecardParser.getBowling_b_2_player_5_extras());
        cardCustomForOni.setBowling_b_2_player_5_maiden_overs(matchScorecardParser.getBowling_b_2_player_5_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_5_overs(matchScorecardParser.getBowling_b_2_player_5_overs());

        //player 6

        cardCustomForOni.setBowling_a_1_player_6_name(matchScorecardParser.getBowling_a_1_player_6_name());
        cardCustomForOni.setBowling_a_1_player_6_economy(matchScorecardParser.getBowling_a_1_player_6_economy());
        cardCustomForOni.setBowling_a_1_player_6_runs(matchScorecardParser.getBowling_a_1_player_6_runs());
        cardCustomForOni.setBowling_a_1_player_6_wickets(matchScorecardParser.getBowling_a_1_player_6_wickets());
        cardCustomForOni.setBowling_a_1_player_6_extras(matchScorecardParser.getBowling_a_1_player_6_extras());
        cardCustomForOni.setBowling_a_1_player_6_maiden_overs(matchScorecardParser.getBowling_a_1_player_6_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_6_overs(matchScorecardParser.getBowling_a_1_player_6_overs());

        cardCustomForOni.setBowling_a_2_player_6_name(matchScorecardParser.getBowling_a_2_player_6_name());
        cardCustomForOni.setBowling_a_2_player_6_economy(matchScorecardParser.getBowling_a_2_player_6_economy());
        cardCustomForOni.setBowling_a_2_player_6_runs(matchScorecardParser.getBowling_a_2_player_6_runs());
        cardCustomForOni.setBowling_a_2_player_6_wickets(matchScorecardParser.getBowling_a_2_player_6_wickets());
        cardCustomForOni.setBowling_a_2_player_6_extras(matchScorecardParser.getBowling_a_2_player_6_extras());
        cardCustomForOni.setBowling_a_2_player_6_maiden_overs(matchScorecardParser.getBowling_a_2_player_6_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_6_overs(matchScorecardParser.getBowling_a_2_player_6_overs());


        cardCustomForOni.setBowling_b_1_player_6_name(matchScorecardParser.getBowling_b_1_player_6_name());
        cardCustomForOni.setBowling_b_1_player_6_economy(matchScorecardParser.getBowling_b_1_player_6_economy());
        cardCustomForOni.setBowling_b_1_player_6_runs(matchScorecardParser.getBowling_b_1_player_6_runs());
        cardCustomForOni.setBowling_b_1_player_6_wickets(matchScorecardParser.getBowling_b_1_player_6_wickets());
        cardCustomForOni.setBowling_b_1_player_6_extras(matchScorecardParser.getBowling_b_1_player_6_extras());
        cardCustomForOni.setBowling_b_1_player_6_maiden_overs(matchScorecardParser.getBowling_b_1_player_6_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_6_overs(matchScorecardParser.getBowling_b_1_player_6_overs());

        cardCustomForOni.setBowling_b_2_player_6_name(matchScorecardParser.getBowling_b_2_player_6_name());
        cardCustomForOni.setBowling_b_2_player_6_economy(matchScorecardParser.getBowling_b_2_player_6_economy());
        cardCustomForOni.setBowling_b_2_player_6_runs(matchScorecardParser.getBowling_b_2_player_6_runs());
        cardCustomForOni.setBowling_b_2_player_6_wickets(matchScorecardParser.getBowling_b_2_player_6_wickets());
        cardCustomForOni.setBowling_b_2_player_6_extras(matchScorecardParser.getBowling_b_2_player_6_extras());
        cardCustomForOni.setBowling_b_2_player_6_maiden_overs(matchScorecardParser.getBowling_b_2_player_6_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_6_overs(matchScorecardParser.getBowling_b_2_player_6_overs());

        //player 7
        cardCustomForOni.setBowling_a_1_player_7_name(matchScorecardParser.getBowling_a_1_player_7_name());
        cardCustomForOni.setBowling_a_1_player_7_economy(matchScorecardParser.getBowling_a_1_player_7_economy());
        cardCustomForOni.setBowling_a_1_player_7_runs(matchScorecardParser.getBowling_a_1_player_7_runs());
        cardCustomForOni.setBowling_a_1_player_7_wickets(matchScorecardParser.getBowling_a_1_player_7_wickets());
        cardCustomForOni.setBowling_a_1_player_7_extras(matchScorecardParser.getBowling_a_1_player_7_extras());
        cardCustomForOni.setBowling_a_1_player_7_maiden_overs(matchScorecardParser.getBowling_a_1_player_7_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_7_overs(matchScorecardParser.getBowling_a_1_player_7_overs());

        cardCustomForOni.setBowling_a_2_player_7_name(matchScorecardParser.getBowling_a_2_player_7_name());
        cardCustomForOni.setBowling_a_2_player_7_economy(matchScorecardParser.getBowling_a_2_player_7_economy());
        cardCustomForOni.setBowling_a_2_player_7_runs(matchScorecardParser.getBowling_a_2_player_7_runs());
        cardCustomForOni.setBowling_a_2_player_7_wickets(matchScorecardParser.getBowling_a_2_player_7_wickets());
        cardCustomForOni.setBowling_a_2_player_7_extras(matchScorecardParser.getBowling_a_2_player_7_extras());
        cardCustomForOni.setBowling_a_2_player_7_maiden_overs(matchScorecardParser.getBowling_a_2_player_7_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_7_overs(matchScorecardParser.getBowling_a_2_player_7_overs());


        cardCustomForOni.setBowling_b_1_player_7_name(matchScorecardParser.getBowling_b_1_player_7_name());
        cardCustomForOni.setBowling_b_1_player_7_economy(matchScorecardParser.getBowling_b_1_player_7_economy());
        cardCustomForOni.setBowling_b_1_player_7_runs(matchScorecardParser.getBowling_b_1_player_7_runs());
        cardCustomForOni.setBowling_b_1_player_7_wickets(matchScorecardParser.getBowling_b_1_player_7_wickets());
        cardCustomForOni.setBowling_b_1_player_7_extras(matchScorecardParser.getBowling_b_1_player_7_extras());
        cardCustomForOni.setBowling_b_1_player_7_maiden_overs(matchScorecardParser.getBowling_b_1_player_7_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_7_overs(matchScorecardParser.getBowling_b_1_player_7_overs());

        cardCustomForOni.setBowling_b_2_player_7_name(matchScorecardParser.getBowling_b_2_player_7_name());
        cardCustomForOni.setBowling_b_2_player_7_economy(matchScorecardParser.getBowling_b_2_player_7_economy());
        cardCustomForOni.setBowling_b_2_player_7_runs(matchScorecardParser.getBowling_b_2_player_7_runs());
        cardCustomForOni.setBowling_b_2_player_7_wickets(matchScorecardParser.getBowling_b_2_player_7_wickets());
        cardCustomForOni.setBowling_b_2_player_7_extras(matchScorecardParser.getBowling_b_2_player_7_extras());
        cardCustomForOni.setBowling_b_2_player_7_maiden_overs(matchScorecardParser.getBowling_b_2_player_7_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_7_overs(matchScorecardParser.getBowling_b_2_player_7_overs());

        //player 8
        cardCustomForOni.setBowling_a_1_player_8_name(matchScorecardParser.getBowling_a_1_player_8_name());
        cardCustomForOni.setBowling_a_1_player_8_economy(matchScorecardParser.getBowling_a_1_player_8_economy());
        cardCustomForOni.setBowling_a_1_player_8_runs(matchScorecardParser.getBowling_a_1_player_8_runs());
        cardCustomForOni.setBowling_a_1_player_8_wickets(matchScorecardParser.getBowling_a_1_player_8_wickets());
        cardCustomForOni.setBowling_a_1_player_8_extras(matchScorecardParser.getBowling_a_1_player_8_extras());
        cardCustomForOni.setBowling_a_1_player_8_maiden_overs(matchScorecardParser.getBowling_a_1_player_8_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_8_overs(matchScorecardParser.getBowling_a_1_player_8_overs());

        cardCustomForOni.setBowling_a_2_player_8_name(matchScorecardParser.getBowling_a_2_player_8_name());
        cardCustomForOni.setBowling_a_2_player_8_economy(matchScorecardParser.getBowling_a_2_player_8_economy());
        cardCustomForOni.setBowling_a_2_player_8_runs(matchScorecardParser.getBowling_a_2_player_8_runs());
        cardCustomForOni.setBowling_a_2_player_8_wickets(matchScorecardParser.getBowling_a_2_player_8_wickets());
        cardCustomForOni.setBowling_a_2_player_8_extras(matchScorecardParser.getBowling_a_2_player_8_extras());
        cardCustomForOni.setBowling_a_2_player_8_maiden_overs(matchScorecardParser.getBowling_a_2_player_8_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_8_overs(matchScorecardParser.getBowling_a_2_player_8_overs());


        cardCustomForOni.setBowling_b_1_player_8_name(matchScorecardParser.getBowling_b_1_player_8_name());
        cardCustomForOni.setBowling_b_1_player_8_economy(matchScorecardParser.getBowling_b_1_player_8_economy());
        cardCustomForOni.setBowling_b_1_player_8_runs(matchScorecardParser.getBowling_b_1_player_8_runs());
        cardCustomForOni.setBowling_b_1_player_8_wickets(matchScorecardParser.getBowling_b_1_player_8_wickets());
        cardCustomForOni.setBowling_b_1_player_8_extras(matchScorecardParser.getBowling_b_1_player_8_extras());
        cardCustomForOni.setBowling_b_1_player_8_maiden_overs(matchScorecardParser.getBowling_b_1_player_8_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_8_overs(matchScorecardParser.getBowling_b_1_player_8_overs());

        cardCustomForOni.setBowling_b_2_player_8_name(matchScorecardParser.getBowling_b_2_player_8_name());
        cardCustomForOni.setBowling_b_2_player_8_economy(matchScorecardParser.getBowling_b_2_player_8_economy());
        cardCustomForOni.setBowling_b_2_player_8_runs(matchScorecardParser.getBowling_b_2_player_8_runs());
        cardCustomForOni.setBowling_b_2_player_8_wickets(matchScorecardParser.getBowling_b_2_player_8_wickets());
        cardCustomForOni.setBowling_b_2_player_8_extras(matchScorecardParser.getBowling_b_2_player_8_extras());
        cardCustomForOni.setBowling_b_2_player_8_maiden_overs(matchScorecardParser.getBowling_b_2_player_8_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_8_overs(matchScorecardParser.getBowling_b_2_player_8_overs());


        //player 9
        cardCustomForOni.setBowling_a_1_player_9_name(matchScorecardParser.getBowling_a_1_player_9_name());
        cardCustomForOni.setBowling_a_1_player_9_economy(matchScorecardParser.getBowling_a_1_player_9_economy());
        cardCustomForOni.setBowling_a_1_player_9_runs(matchScorecardParser.getBowling_a_1_player_9_runs());
        cardCustomForOni.setBowling_a_1_player_9_wickets(matchScorecardParser.getBowling_a_1_player_9_wickets());
        cardCustomForOni.setBowling_a_1_player_9_extras(matchScorecardParser.getBowling_a_1_player_9_extras());
        cardCustomForOni.setBowling_a_1_player_9_maiden_overs(matchScorecardParser.getBowling_a_1_player_9_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_9_overs(matchScorecardParser.getBowling_a_1_player_9_overs());

        cardCustomForOni.setBowling_a_2_player_9_name(matchScorecardParser.getBowling_a_2_player_9_name());
        cardCustomForOni.setBowling_a_2_player_9_economy(matchScorecardParser.getBowling_a_2_player_9_economy());
        cardCustomForOni.setBowling_a_2_player_9_runs(matchScorecardParser.getBowling_a_2_player_9_runs());
        cardCustomForOni.setBowling_a_2_player_9_wickets(matchScorecardParser.getBowling_a_2_player_9_wickets());
        cardCustomForOni.setBowling_a_2_player_9_extras(matchScorecardParser.getBowling_a_2_player_9_extras());
        cardCustomForOni.setBowling_a_2_player_9_maiden_overs(matchScorecardParser.getBowling_a_2_player_9_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_9_overs(matchScorecardParser.getBowling_a_2_player_9_overs());


        cardCustomForOni.setBowling_b_1_player_9_name(matchScorecardParser.getBowling_b_1_player_9_name());
        cardCustomForOni.setBowling_b_1_player_9_economy(matchScorecardParser.getBowling_b_1_player_9_economy());
        cardCustomForOni.setBowling_b_1_player_9_runs(matchScorecardParser.getBowling_b_1_player_9_runs());
        cardCustomForOni.setBowling_b_1_player_9_wickets(matchScorecardParser.getBowling_b_1_player_9_wickets());
        cardCustomForOni.setBowling_b_1_player_9_extras(matchScorecardParser.getBowling_b_1_player_9_extras());
        cardCustomForOni.setBowling_b_1_player_9_maiden_overs(matchScorecardParser.getBowling_b_1_player_9_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_9_overs(matchScorecardParser.getBowling_b_1_player_9_overs());

        cardCustomForOni.setBowling_b_2_player_9_name(matchScorecardParser.getBowling_b_2_player_9_name());
        cardCustomForOni.setBowling_b_2_player_9_economy(matchScorecardParser.getBowling_b_2_player_9_economy());
        cardCustomForOni.setBowling_b_2_player_9_runs(matchScorecardParser.getBowling_b_2_player_9_runs());
        cardCustomForOni.setBowling_b_2_player_9_wickets(matchScorecardParser.getBowling_b_2_player_9_wickets());
        cardCustomForOni.setBowling_b_2_player_9_extras(matchScorecardParser.getBowling_b_2_player_9_extras());
        cardCustomForOni.setBowling_b_2_player_9_maiden_overs(matchScorecardParser.getBowling_b_2_player_9_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_9_overs(matchScorecardParser.getBowling_b_2_player_9_overs());

        //player 10
        cardCustomForOni.setBowling_a_1_player_10_name(matchScorecardParser.getBowling_a_1_player_10_name());
        cardCustomForOni.setBowling_a_1_player_10_economy(matchScorecardParser.getBowling_a_1_player_10_economy());
        cardCustomForOni.setBowling_a_1_player_10_runs(matchScorecardParser.getBowling_a_1_player_10_runs());
        cardCustomForOni.setBowling_a_1_player_10_wickets(matchScorecardParser.getBowling_a_1_player_10_wickets());
        cardCustomForOni.setBowling_a_1_player_10_extras(matchScorecardParser.getBowling_a_1_player_10_extras());
        cardCustomForOni.setBowling_a_1_player_10_maiden_overs(matchScorecardParser.getBowling_a_1_player_10_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_10_overs(matchScorecardParser.getBowling_a_1_player_10_overs());

        cardCustomForOni.setBowling_a_2_player_10_name(matchScorecardParser.getBowling_a_2_player_10_name());
        cardCustomForOni.setBowling_a_2_player_10_economy(matchScorecardParser.getBowling_a_2_player_10_economy());
        cardCustomForOni.setBowling_a_2_player_10_runs(matchScorecardParser.getBowling_a_2_player_10_runs());
        cardCustomForOni.setBowling_a_2_player_10_wickets(matchScorecardParser.getBowling_a_2_player_10_wickets());
        cardCustomForOni.setBowling_a_2_player_10_extras(matchScorecardParser.getBowling_a_2_player_10_extras());
        cardCustomForOni.setBowling_a_2_player_10_maiden_overs(matchScorecardParser.getBowling_a_2_player_10_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_10_overs(matchScorecardParser.getBowling_a_2_player_10_overs());


        cardCustomForOni.setBowling_b_1_player_10_name(matchScorecardParser.getBowling_b_1_player_10_name());
        cardCustomForOni.setBowling_b_1_player_10_economy(matchScorecardParser.getBowling_b_1_player_10_economy());
        cardCustomForOni.setBowling_b_1_player_10_runs(matchScorecardParser.getBowling_b_1_player_10_runs());
        cardCustomForOni.setBowling_b_1_player_10_wickets(matchScorecardParser.getBowling_b_1_player_10_wickets());
        cardCustomForOni.setBowling_b_1_player_10_extras(matchScorecardParser.getBowling_b_1_player_10_extras());
        cardCustomForOni.setBowling_b_1_player_10_maiden_overs(matchScorecardParser.getBowling_b_1_player_10_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_10_overs(matchScorecardParser.getBowling_b_1_player_10_overs());

        cardCustomForOni.setBowling_b_2_player_10_name(matchScorecardParser.getBowling_b_2_player_10_name());
        cardCustomForOni.setBowling_b_2_player_10_economy(matchScorecardParser.getBowling_b_2_player_10_economy());
        cardCustomForOni.setBowling_b_2_player_10_runs(matchScorecardParser.getBowling_b_2_player_10_runs());
        cardCustomForOni.setBowling_b_2_player_10_wickets(matchScorecardParser.getBowling_b_2_player_10_wickets());
        cardCustomForOni.setBowling_b_2_player_10_extras(matchScorecardParser.getBowling_b_2_player_10_extras());
        cardCustomForOni.setBowling_b_2_player_10_maiden_overs(matchScorecardParser.getBowling_b_2_player_10_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_10_overs(matchScorecardParser.getBowling_b_2_player_10_overs());


        //player 11
        cardCustomForOni.setBowling_a_1_player_11_name(matchScorecardParser.getBowling_a_1_player_11_name());
        cardCustomForOni.setBowling_a_1_player_11_economy(matchScorecardParser.getBowling_a_1_player_11_economy());
        cardCustomForOni.setBowling_a_1_player_11_runs(matchScorecardParser.getBowling_a_1_player_11_runs());
        cardCustomForOni.setBowling_a_1_player_11_wickets(matchScorecardParser.getBowling_a_1_player_11_wickets());
        cardCustomForOni.setBowling_a_1_player_11_extras(matchScorecardParser.getBowling_a_1_player_11_extras());
        cardCustomForOni.setBowling_a_1_player_11_maiden_overs(matchScorecardParser.getBowling_a_1_player_11_maiden_overs());
        cardCustomForOni.setBowling_a_1_player_11_overs(matchScorecardParser.getBowling_a_1_player_11_overs());

        cardCustomForOni.setBowling_a_2_player_11_name(matchScorecardParser.getBowling_a_2_player_11_name());
        cardCustomForOni.setBowling_a_2_player_11_economy(matchScorecardParser.getBowling_a_2_player_11_economy());
        cardCustomForOni.setBowling_a_2_player_11_runs(matchScorecardParser.getBowling_a_2_player_11_runs());
        cardCustomForOni.setBowling_a_2_player_11_wickets(matchScorecardParser.getBowling_a_2_player_11_wickets());
        cardCustomForOni.setBowling_a_2_player_11_extras(matchScorecardParser.getBowling_a_2_player_11_extras());
        cardCustomForOni.setBowling_a_2_player_11_maiden_overs(matchScorecardParser.getBowling_a_2_player_11_maiden_overs());
        cardCustomForOni.setBowling_a_2_player_11_overs(matchScorecardParser.getBowling_a_2_player_11_overs());


        cardCustomForOni.setBowling_b_1_player_11_name(matchScorecardParser.getBowling_b_1_player_11_name());
        cardCustomForOni.setBowling_b_1_player_11_economy(matchScorecardParser.getBowling_b_1_player_11_economy());
        cardCustomForOni.setBowling_b_1_player_11_runs(matchScorecardParser.getBowling_b_1_player_11_runs());
        cardCustomForOni.setBowling_b_1_player_11_wickets(matchScorecardParser.getBowling_b_1_player_11_wickets());
        cardCustomForOni.setBowling_b_1_player_11_extras(matchScorecardParser.getBowling_b_1_player_11_extras());
        cardCustomForOni.setBowling_b_1_player_11_maiden_overs(matchScorecardParser.getBowling_b_1_player_11_maiden_overs());
        cardCustomForOni.setBowling_b_1_player_11_overs(matchScorecardParser.getBowling_b_1_player_11_overs());

        cardCustomForOni.setBowling_b_2_player_11_name(matchScorecardParser.getBowling_b_2_player_11_name());
        cardCustomForOni.setBowling_b_2_player_11_economy(matchScorecardParser.getBowling_b_2_player_11_economy());
        cardCustomForOni.setBowling_b_2_player_11_runs(matchScorecardParser.getBowling_b_2_player_11_runs());
        cardCustomForOni.setBowling_b_2_player_11_wickets(matchScorecardParser.getBowling_b_2_player_11_wickets());
        cardCustomForOni.setBowling_b_2_player_11_extras(matchScorecardParser.getBowling_b_2_player_11_extras());
        cardCustomForOni.setBowling_b_2_player_11_maiden_overs(matchScorecardParser.getBowling_b_2_player_11_maiden_overs());
        cardCustomForOni.setBowling_b_2_player_11_overs(matchScorecardParser.getBowling_b_2_player_11_overs());


        //match property
        cardCustomForOni.setTeam_a(matchScorecardParser.getTeam_a());
        cardCustomForOni.setTeam_a_full_name(matchScorecardParser.getTeam_a_full_name());
        cardCustomForOni.setTeam_b(matchScorecardParser.getTeam_b());
        cardCustomForOni.setTeam_b_full_name(matchScorecardParser.getTeam_b_full_name());
        cardCustomForOni.setTeam_a_url(matchScorecardParser.getTeam_a_url());
        cardCustomForOni.setTeam_b_url(matchScorecardParser.getTeam_b_url());

        cardCustomForOni.setToss_decision(matchScorecardParser.getToss_decision());
        cardCustomForOni.setToss_won(matchScorecardParser.getToss_won());
        cardCustomForOni.setToss_str(matchScorecardParser.getToss_str());

        //innings -> A_1
        cardCustomForOni.setInnings_A_1_batting_order(matchScorecardParser.getInnings_A_1_batting_order());
        cardCustomForOni.setInnings_A_1_runs(matchScorecardParser.getInnings_A_1_runs());
        cardCustomForOni.setInnings_A_1_fall_of_wickets(matchScorecardParser.getInnings_A_1_fall_of_wickets());
        cardCustomForOni.setInnings_A_1_wide(matchScorecardParser.getInnings_A_1_wide());
        cardCustomForOni.setInnings_A_1_run_rate(matchScorecardParser.getInnings_A_1_run_rate());
        cardCustomForOni.setInnings_A_1_run_str(matchScorecardParser.getInnings_A_1_run_str());
        cardCustomForOni.setInnings_A_1_wickets(matchScorecardParser.getInnings_A_1_wickets());
        cardCustomForOni.setInnings_A_1_extras(matchScorecardParser.getInnings_A_1_extras());
        cardCustomForOni.setInnings_A_1_bowling_order(matchScorecardParser.getInnings_A_1_bowling_order());
        cardCustomForOni.setInnings_A_1_noball(matchScorecardParser.getInnings_A_1_noball());
        cardCustomForOni.setInnings_A_1_legbye(matchScorecardParser.getInnings_A_1_legbye());
        cardCustomForOni.setInnings_A_1_bye(matchScorecardParser.getInnings_A_1_bye());
        cardCustomForOni.setInnings_A_1_overs(matchScorecardParser.getInnings_A_1_overs());

        //////////////////////////////////
        /////B_1
        cardCustomForOni.setInnings_B_1_batting_order(matchScorecardParser.getInnings_B_1_batting_order());
        cardCustomForOni.setInnings_B_1_runs(matchScorecardParser.getInnings_B_1_runs());
        cardCustomForOni.setInnings_B_1_fall_of_wickets(matchScorecardParser.getInnings_B_1_fall_of_wickets());
        cardCustomForOni.setInnings_B_1_wide(matchScorecardParser.getInnings_B_1_wide());
        cardCustomForOni.setInnings_B_1_run_rate(matchScorecardParser.getInnings_B_1_run_rate());
        cardCustomForOni.setInnings_B_1_run_str(matchScorecardParser.getInnings_B_1_run_str());
        cardCustomForOni.setInnings_B_1_wickets(matchScorecardParser.getInnings_B_1_wickets());
        cardCustomForOni.setInnings_B_1_extras(matchScorecardParser.getInnings_B_1_extras());
        cardCustomForOni.setInnings_B_1_bowling_order(matchScorecardParser.getInnings_B_1_bowling_order());
        cardCustomForOni.setInnings_B_1_noball(matchScorecardParser.getInnings_B_1_noball());
        cardCustomForOni.setInnings_B_1_legbye(matchScorecardParser.getInnings_B_1_legbye());
        cardCustomForOni.setInnings_B_1_bye(matchScorecardParser.getInnings_B_1_bye());
        cardCustomForOni.setInnings_B_1_overs(matchScorecardParser.getInnings_B_1_overs());

        //innings -> A_2
        cardCustomForOni.setInnings_A_2_batting_order(matchScorecardParser.getInnings_A_2_batting_order());
        cardCustomForOni.setInnings_A_2_runs(matchScorecardParser.getInnings_A_2_runs());
        cardCustomForOni.setInnings_A_2_fall_of_wickets(matchScorecardParser.getInnings_A_2_fall_of_wickets());
        cardCustomForOni.setInnings_A_2_wide(matchScorecardParser.getInnings_A_2_wide());
        cardCustomForOni.setInnings_A_2_run_rate(matchScorecardParser.getInnings_A_2_run_rate());
        cardCustomForOni.setInnings_A_2_run_str(matchScorecardParser.getInnings_A_2_run_str());
        cardCustomForOni.setInnings_A_2_wickets(matchScorecardParser.getInnings_A_2_wickets());
        cardCustomForOni.setInnings_A_2_extras(matchScorecardParser.getInnings_A_2_extras());
        cardCustomForOni.setInnings_A_2_bowling_order(matchScorecardParser.getInnings_A_2_bowling_order());
        cardCustomForOni.setInnings_A_2_noball(matchScorecardParser.getInnings_A_2_noball());
        cardCustomForOni.setInnings_A_2_legbye(matchScorecardParser.getInnings_A_2_legbye());
        cardCustomForOni.setInnings_A_2_bye(matchScorecardParser.getInnings_A_2_bye());
        cardCustomForOni.setInnings_A_2_overs(matchScorecardParser.getInnings_A_2_overs());

        //////////////////////////////////
        /////B_2
        cardCustomForOni.setInnings_B_2_batting_order(matchScorecardParser.getInnings_B_2_batting_order());
        cardCustomForOni.setInnings_B_2_runs(matchScorecardParser.getInnings_B_2_runs());
        cardCustomForOni.setInnings_B_2_fall_of_wickets(matchScorecardParser.getInnings_B_2_fall_of_wickets());
        cardCustomForOni.setInnings_B_2_wide(matchScorecardParser.getInnings_B_2_wide());
        cardCustomForOni.setInnings_B_2_run_rate(matchScorecardParser.getInnings_B_2_run_rate());
        cardCustomForOni.setInnings_B_2_run_str(matchScorecardParser.getInnings_B_2_run_str());
        cardCustomForOni.setInnings_B_2_wickets(matchScorecardParser.getInnings_B_2_wickets());
        cardCustomForOni.setInnings_B_2_extras(matchScorecardParser.getInnings_B_2_extras());
        cardCustomForOni.setInnings_B_2_bowling_order(matchScorecardParser.getInnings_B_2_bowling_order());
        cardCustomForOni.setInnings_B_2_noball(matchScorecardParser.getInnings_B_2_noball());
        cardCustomForOni.setInnings_B_2_legbye(matchScorecardParser.getInnings_B_2_legbye());
        cardCustomForOni.setInnings_B_2_bye(matchScorecardParser.getInnings_B_2_bye());
        cardCustomForOni.setInnings_B_2_overs(matchScorecardParser.getInnings_B_2_overs());


        //a_1

        //player_1
        cardCustomForOni.setInnings_A_1_batting_player_1_full_name(matchScorecardParser.getInnings_A_1_batting_player_1_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_1_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_1_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_1_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_1_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_1_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_1_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_1_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_1_innings_2_strike_rate());


        //player_2
        cardCustomForOni.setInnings_A_1_batting_player_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_2_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_2_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_2_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_2_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_2_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_2_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_2_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_2_innings_2_strike_rate());


        //player_3
        cardCustomForOni.setInnings_A_1_batting_player_3_full_name(matchScorecardParser.getInnings_A_1_batting_player_3_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_3_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_3_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_3_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_3_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_3_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_3_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_3_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_3_innings_2_strike_rate());


        //player_4
        cardCustomForOni.setInnings_A_1_batting_player_4_full_name(matchScorecardParser.getInnings_A_1_batting_player_4_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_4_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_4_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_4_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_4_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_4_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_4_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_4_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_4_innings_2_strike_rate());


        //player_5
        cardCustomForOni.setInnings_A_1_batting_player_5_full_name(matchScorecardParser.getInnings_A_1_batting_player_5_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_5_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_5_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_5_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_5_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_5_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_5_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_5_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_5_innings_2_strike_rate());


        //player_6
        cardCustomForOni.setInnings_A_1_batting_player_6_full_name(matchScorecardParser.getInnings_A_1_batting_player_6_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_6_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_6_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_6_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_6_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_6_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_6_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_6_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_6_innings_2_strike_rate());


        //player_7
        cardCustomForOni.setInnings_A_1_batting_player_7_full_name(matchScorecardParser.getInnings_A_1_batting_player_7_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_7_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_7_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_7_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_7_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_7_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_7_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_7_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_7_innings_2_strike_rate());


        //player_8
        cardCustomForOni.setInnings_A_1_batting_player_8_full_name(matchScorecardParser.getInnings_A_1_batting_player_8_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_8_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_8_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_8_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_8_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_8_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_8_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_8_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_8_innings_2_strike_rate());


        //player_9
        cardCustomForOni.setInnings_A_1_batting_player_9_full_name(matchScorecardParser.getInnings_A_1_batting_player_9_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_9_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_9_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_9_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_9_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_9_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_9_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_9_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_9_innings_2_strike_rate());

        //player_10
        cardCustomForOni.setInnings_A_1_batting_player_10_full_name(matchScorecardParser.getInnings_A_1_batting_player_10_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_10_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_10_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_10_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_10_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_10_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_10_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_10_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_10_innings_2_strike_rate());

        //player_11
        cardCustomForOni.setInnings_A_1_batting_player_11_full_name(matchScorecardParser.getInnings_A_1_batting_player_11_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_1_sixes(matchScorecardParser.getInnings_A_1_batting_player_11_innings_1_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_1_fours(matchScorecardParser.getInnings_A_1_batting_player_11_innings_1_fours());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_1_balls(matchScorecardParser.getInnings_A_1_batting_player_11_innings_1_balls());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_1_runs(matchScorecardParser.getInnings_A_1_batting_player_11_innings_1_runs());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_1_out_comment(matchScorecardParser.getInnings_A_1_batting_player_11_innings_1_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_1_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_11_innings_1_strike_rate());

        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_full_name(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_full_name());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_sixes(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_sixes());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_fours(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_fours());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_balls(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_balls());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_runs(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_runs());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_out_comment(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_out_comment());
        cardCustomForOni.setInnings_A_1_batting_player_11_innings_2_strike_rate(matchScorecardParser.getInnings_A_1_batting_player_11_innings_2_strike_rate());


        //b_1
        //player_1
        cardCustomForOni.setInnings_B_1_batting_player_1_full_name(matchScorecardParser.getInnings_B_1_batting_player_1_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_1_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_1_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_1_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_1_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_1_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_1_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_1_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_1_innings_2_strike_rate());


        //player_2
        cardCustomForOni.setInnings_B_1_batting_player_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_2_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_2_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_2_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_2_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_2_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_2_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_2_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_2_innings_2_strike_rate());


        //player_3
        cardCustomForOni.setInnings_B_1_batting_player_3_full_name(matchScorecardParser.getInnings_B_1_batting_player_3_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_3_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_3_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_3_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_3_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_3_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_3_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_3_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_3_innings_2_strike_rate());


        //player_4
        cardCustomForOni.setInnings_B_1_batting_player_4_full_name(matchScorecardParser.getInnings_B_1_batting_player_4_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_4_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_4_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_4_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_4_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_4_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_4_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_4_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_4_innings_2_strike_rate());


        //player_5
        cardCustomForOni.setInnings_B_1_batting_player_5_full_name(matchScorecardParser.getInnings_B_1_batting_player_5_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_5_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_5_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_5_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_5_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_5_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_5_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_5_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_5_innings_2_strike_rate());


        //player_6
        cardCustomForOni.setInnings_B_1_batting_player_6_full_name(matchScorecardParser.getInnings_B_1_batting_player_6_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_6_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_6_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_6_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_6_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_6_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_6_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_6_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_6_innings_2_strike_rate());


        //player_7
        cardCustomForOni.setInnings_B_1_batting_player_7_full_name(matchScorecardParser.getInnings_B_1_batting_player_7_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_7_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_7_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_7_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_7_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_7_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_7_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_7_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_7_innings_2_strike_rate());


        //player_8
        cardCustomForOni.setInnings_B_1_batting_player_8_full_name(matchScorecardParser.getInnings_B_1_batting_player_8_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_8_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_8_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_8_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_8_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_8_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_8_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_8_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_8_innings_2_strike_rate());


        //player_9
        cardCustomForOni.setInnings_B_1_batting_player_9_full_name(matchScorecardParser.getInnings_B_1_batting_player_9_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_9_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_9_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_9_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_9_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_9_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_9_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_9_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_9_innings_2_strike_rate());

        //player_10
        cardCustomForOni.setInnings_B_1_batting_player_10_full_name(matchScorecardParser.getInnings_B_1_batting_player_10_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_10_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_10_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_10_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_10_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_10_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_10_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_10_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_10_innings_2_strike_rate());

        //player_11
        cardCustomForOni.setInnings_B_1_batting_player_11_full_name(matchScorecardParser.getInnings_B_1_batting_player_11_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_1_sixes(matchScorecardParser.getInnings_B_1_batting_player_11_innings_1_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_1_fours(matchScorecardParser.getInnings_B_1_batting_player_11_innings_1_fours());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_1_balls(matchScorecardParser.getInnings_B_1_batting_player_11_innings_1_balls());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_1_runs(matchScorecardParser.getInnings_B_1_batting_player_11_innings_1_runs());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_1_out_comment(matchScorecardParser.getInnings_B_1_batting_player_11_innings_1_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_1_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_11_innings_1_strike_rate());

        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_full_name(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_full_name());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_sixes(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_sixes());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_fours(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_fours());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_balls(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_balls());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_runs(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_runs());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_out_comment(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_out_comment());
        cardCustomForOni.setInnings_B_1_batting_player_11_innings_2_strike_rate(matchScorecardParser.getInnings_B_1_batting_player_11_innings_2_strike_rate());


        cardCustomForOni.setStatus(matchScorecardParser.getStatus());
        cardCustomForOni.setFormat(matchScorecardParser.getFormat());
        cardCustomForOni.setFormat_code(matchScorecardParser.getFormat_code());
        cardCustomForOni.setName(matchScorecardParser.getName());
        cardCustomForOni.setVenue(matchScorecardParser.getVenue());
        cardCustomForOni.setStart_date_timestamp(matchScorecardParser.getStart_date_timestamp());
        cardCustomForOni.setStart_date_str(matchScorecardParser.getStart_date_str());
        cardCustomForOni.setKey(matchScorecardParser.getKey());
        cardCustomForOni.setShort_name(matchScorecardParser.getShort_name());
        cardCustomForOni.setRelated_name(matchScorecardParser.getRelated_name());

        cardCustomForOni.setDate(matchScorecardParser.getDate());
        cardCustomForOni.setTime(matchScorecardParser.getTime());
        cardCustomForOni.setMsgs_result(matchScorecardParser.getMsgs_result());
        cardCustomForOni.setCurrent_batting_team(matchScorecardParser.getCurrent_batting_team());
        cardCustomForOni.setCurrent_runrate(matchScorecardParser.getCurrent_runrate());

        cardCustomForOni.setInning_1_batting_team(matchScorecardParser.getInning_1_batting_team());
        cardCustomForOni.setInning_2_batting_team(matchScorecardParser.getInning_2_batting_team());
        cardCustomForOni.setInning_3_batting_team(matchScorecardParser.getInning_3_batting_team());
        cardCustomForOni.setInning_4_batting_team(matchScorecardParser.getInning_4_batting_team());

        cardCustomForOni.setTeam_a_full_score(matchScorecardParser.getTeam_a_full_score());
        cardCustomForOni.setTeam_b_full_score(matchScorecardParser.getTeam_b_full_score());



        return cardCustomForOni;


    }


}
