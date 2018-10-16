package com.sweetitech.tiger.service.EntitySportsService.EntitySportsServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sweetitech.tiger.mapper.MapToCardCustomForOni;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.LiveMatch.LiveMatch;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.MatchScorecard;
import com.sweetitech.tiger.model.EntitySportAPI.PlayerProfile.PlayerProfile;
import com.sweetitech.tiger.model.EntitySportAPI.PlayerSearch.PlayerSearch;
import com.sweetitech.tiger.model.EntitySportAPI.RecentMatches.RecentMatches;
import com.sweetitech.tiger.model.cricketapi.*;
import com.sweetitech.tiger.parser.sampleMatchScorecardParser;
import com.sweetitech.tiger.service.EntitySportsService.EntitySportsCricketApiService;
import com.sweetitech.tiger.util.TimeFormatter;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
public class EntitySportsCricketApiServiceImpl implements EntitySportsCricketApiService {

    OkHttpClient client;
    CardCustomForOni cardCustomForOni;
    ObjectMapper objectMapper = new ObjectMapper();
    

    @Override
    public CardCustomForOni getMatchInfo(String matchKey) {


        String baseUrl ="https://rest.entitysport.com/v2/matches";
        client = new OkHttpClient();


        Request scorecardRequest = new Request.Builder()
                .url(HttpUrl.parse(baseUrl).newBuilder()
                        .addPathSegment(matchKey)
                        .addPathSegment("scorecard")
                        .addQueryParameter("token", "43783fd83d60570454356f7ab61317c1").toString())
                .get().build();


        System.out.println("url is : "+scorecardRequest.url().toString());



   /*     //Testing start
        String test ="https://rest.entitysport.com/v2/matches";
        String number = "36237";
        Request testurl = new Request.Builder().
                url(HttpUrl.parse(test).newBuilder()
                        .addPathSegment(number)
                        .addPathSegment("scorecard")
                        .addQueryParameter("token", "43783fd83d60570454356f7ab61317c1")
                        .toString()).get().build();


        System.out.println("test url is "+testurl.url().toString());
        //testing end*/





        Request liveMatchRequest = new Request.Builder()
                .url(HttpUrl.parse(baseUrl).newBuilder()
                        .addPathSegment(matchKey)
                        .addPathSegment("live")
                        .addQueryParameter("token", "43783fd83d60570454356f7ab61317c1").toString())
                .get().build();



        try{

            URL matchScorecardurl = new URL(scorecardRequest.url().toString());
            MatchScorecard matchScorecard = objectMapper.readValue(matchScorecardurl, MatchScorecard.class);


            URL liveMatchurl =  new URL(liveMatchRequest.url().toString());
            LiveMatch liveMatchObj = objectMapper.readValue(liveMatchurl, LiveMatch.class);

            sampleMatchScorecardParser sampleMatchScorecardParser = new sampleMatchScorecardParser(matchScorecard,liveMatchObj);
            MapToCardCustomForOni mapToCardCustomForOni = new MapToCardCustomForOni();
            cardCustomForOni =  mapToCardCustomForOni.map(sampleMatchScorecardParser);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

       return cardCustomForOni;
    }

    @Override
    public List<Card> getRecentMatches() {

        List<Card> recentMatchList = new ArrayList<>();

        try{
            URL recentMatchUrl = new URL("https://rest.entitysport.com/v2/matches/?" +
                    "status=2&token=43783fd83d60570454356f7ab61317c1&per_page=3&&paged=1");
           RecentMatches recentMatches = objectMapper.readValue(recentMatchUrl, RecentMatches.class);
           List<Match> matchList = recentMatches.getResponse().getItems();
           for(int i=0;i<3;i++)
           {
               Card card = new Card();
               card.setKey(matchList.get(i).getMatch_id().toString());
               card.setTeam_a(matchList.get(i).getTeama().getShort_name());
               card.setTeam_b(matchList.get(i).getTeamb().getShort_name());
               card.setTeam_a_url(matchList.get(i).getTeama().getLogo_url());
               card.setTeam_b_url(matchList.get(i).getTeamb().getLogo_url());
               card.setRelated_name(matchList.get(i).getCompetition().getTitle());
               Msgs msgs = new Msgs();
               msgs.setResult(matchList.get(i).getStatus_note());
               card.setMsgs(msgs);
               card.setTeamAScore(matchList.get(i).getTeama().getScores_full());
               card.setTeamBScore(matchList.get(i).getTeamb().getScores_full());
               Toss toss = new Toss();
               toss.setDecision(matchList.get(i).getToss().getText());
               card.setToss(toss);
               if(matchList.get(i).getWinning_team_id().equals(matchList.get(i).getTeama().getTeam_id()))
               {
                   card.setWinner_team(matchList.get(i).getTeama().getName());
               }
               else
               {
                   card.setWinner_team(matchList.get(i).getTeamb().getName());
               }
               Start_date start_date = new Start_date();

               start_date.setStr(TimeFormatter.gmtTimeformatter(matchList.get(i).getDate_start()));

               start_date.setTimestamp(matchList.get(i).getTimestamp_start());
               card.setStart_date(start_date);
               card.setTitle(matchList.get(i).getTitle());
               card.setStatus(matchList.get(i).getStatus_str());
               card.setShort_name(matchList.get(i).getCompetition().getAbbr());
               card.setFormat(matchList.get(i).getCompetition().getMatch_format());
               card.setExpires(matchList.get(i).getDate_end());
               card.setVenue(matchList.get(i).getVenue().getName()+" ,"+matchList.get(i).getVenue().getLocation());



               String[] datetime = matchList.get(i).getDate_start().split(" ");
               card.setDate(datetime[0]);
               card.setTime(datetime[1]);


               recentMatchList.add(card);
           }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return recentMatchList;
    }

    @Override
    public List<Card> getUpcomingMatchs() {

        List<Card> upcommingMatchList = new ArrayList<>();
        try {

            URL upcommingMatchUrl = new URL("https://rest.entitysport.com/v2/matches/?" +
                    "status=1&token=43783fd83d60570454356f7ab61317c1&per_page=3&&paged=1");
            RecentMatches recentMatches = objectMapper.readValue(upcommingMatchUrl, RecentMatches.class);
            List<Match> matchList = recentMatches.getResponse().getItems();
            for(int i=0;i<3;i++) {
                Card card = new Card();
                card.setKey(matchList.get(i).getMatch_id().toString());
                card.setTeam_a(matchList.get(i).getTeama().getShort_name());
                card.setTeam_b(matchList.get(i).getTeamb().getShort_name());
                card.setTeam_a_url(matchList.get(i).getTeama().getLogo_url());
                card.setTeam_b_url(matchList.get(i).getTeamb().getLogo_url());
                card.setRelated_name(matchList.get(i).getCompetition().getTitle());
                card.setTitle(matchList.get(i).getTitle());
                card.setStatus(matchList.get(i).getStatus_str());
                card.setShort_name(matchList.get(i).getCompetition().getAbbr());
                card.setFormat(matchList.get(i).getCompetition().getMatch_format());

                Start_date start_date = new Start_date();

                start_date.setStr(TimeFormatter.gmtTimeformatter(matchList.get(i).getDate_start()));

                start_date.setTimestamp(matchList.get(i).getTimestamp_start());
                card.setStart_date(start_date);

                Season season = new Season();
                season.setName(matchList.get(i).getCompetition().getTitle());
                card.setSeason(season);
                card.setDescription(matchList.get(i).getStatus_note());
                card.setVenue(matchList.get(i).getVenue().getName()+", "+matchList.get(i).getVenue().getLocation());




                String[] datetime = matchList.get(i).getDate_start().split(" ");
                card.setDate(datetime[0]);
                card.setTime(datetime[1]);




                upcommingMatchList.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return upcommingMatchList;
    }

    @Override
    public List<Card> getCurrentMatches() {


        List<Card> currentMatchList = new ArrayList<>();
        try{
            URL currentMatchUrl = new URL("https://rest.entitysport.com/v2/matches/?" +
                    "status=3&token=43783fd83d60570454356f7ab61317c1&per_page=3&&paged=1");
            RecentMatches recentMatches = objectMapper.readValue(currentMatchUrl, RecentMatches.class);
            List<Match> matchList = recentMatches.getResponse().getItems();

            for(int i=0;i<matchList.size()&&i<3;i++)
            {
                try{
                    Card card = new Card();
                    card.setKey(matchList.get(i).getMatch_id().toString());
                    card.setTeam_a(matchList.get(i).getTeama().getShort_name());
                    card.setTeam_b(matchList.get(i).getTeamb().getShort_name());
                    card.setTeam_a_url(matchList.get(i).getTeama().getLogo_url());
                    card.setTeam_b_url(matchList.get(i).getTeamb().getLogo_url());
                    card.setRelated_name(matchList.get(i).getCompetition().getTitle());
                    card.setTitle(matchList.get(i).getTitle());
                    card.setStatus(matchList.get(i).getStatus_str());
                    card.setShort_name(matchList.get(i).getCompetition().getAbbr());
                    card.setFormat(matchList.get(i).getCompetition().getMatch_format());
                    card.setTeamAScore(matchList.get(i).getTeama().getScores_full());
                    card.setTeamBScore(matchList.get(i).getTeamb().getScores_full());


                    Start_date start_date = new Start_date();

                    start_date.setStr(TimeFormatter.gmtTimeformatter(matchList.get(i).getDate_start()));

                    start_date.setTimestamp(matchList.get(i).getTimestamp_start());
                    card.setStart_date(start_date);
                    Toss toss = new Toss();
                    toss.setDecision(matchList.get(i).getToss().getText());
                    card.setToss(toss);
                    card.setDescription(matchList.get(i).getStatus_note());
                    card.setVenue(matchList.get(i).getVenue().getName()+", "+matchList.get(i).getVenue().getLocation());




                    String[] datetime = matchList.get(i).getDate_start().split(" ");
                    card.setDate(datetime[0]);
                    card.setTime(datetime[1]);




                    currentMatchList.add(card);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e)
        {
         e.printStackTrace();
        }
        return currentMatchList;
    }

    @Override
    public CustomOniObjectForShortCard getRecentMatchesShortCard() {

        List<CardCustomForOniHome> recentMatchList = new ArrayList<>();

        try {
            URL recentMatchUrl = new URL("https://rest.entitysport.com/v2/matches/?" +
                    "status=2&token=43783fd83d60570454356f7ab61317c1&per_page=3&&paged=1");
            RecentMatches recentMatches = objectMapper.readValue(recentMatchUrl, RecentMatches.class);
            List<Match> matchList = recentMatches.getResponse().getItems();


            for(int i=0;i<3;i++)
            {
                CardCustomForOniHome card = new CardCustomForOniHome();

                card.setKey(matchList.get(i).getMatch_id().toString());
                card.setTeam_a(matchList.get(i).getTeama().getShort_name());
                card.setTeam_b(matchList.get(i).getTeamb().getShort_name());
                card.setTeam_a_url(matchList.get(i).getTeama().getLogo_url());
                card.setTeam_b_url(matchList.get(i).getTeamb().getLogo_url());
                card.setRelated_name(matchList.get(i).getCompetition().getTitle());
                card.setMsgs_result(matchList.get(i).getStatus_note());

                card.setToss_str(matchList.get(i).getToss().getText());
                if(matchList.get(i).getWinning_team_id().equals(matchList.get(i).getTeama().getTeam_id()))
                {
                    card.setWinner_team(matchList.get(i).getTeama().getName());
                }
                else
                {
                    card.setWinner_team(matchList.get(i).getTeamb().getName());
                }

                card.setTeamAScore(matchList.get(i).getTeama().getScores_full());
                card.setInnings_A_1_overs(matchList.get(i).getTeama().getOvers());
                card.setTeamBScore(matchList.get(i).getTeamb().getScores_full());
                card.setInnings_B_1_overs(matchList.get(i).getTeamb().getOvers());
                card.setStatus(matchList.get(i).getStatus_str());
                card.setDescription(matchList.get(i).getStatus_note());
                card.setShort_name(matchList.get(i).getCompetition().getAbbr());
                card.setFormat(matchList.get(i).getCompetition().getMatch_format());
                card.setName(matchList.get(i).getCompetition().getTitle());
                card.setVenue(matchList.get(i).getVenue().getName()+", "+matchList.get(i).getVenue().getLocation());
                card.setStart_date_timestamp(matchList.get(i).getTimestamp_start());


                card.setStart_date_str(TimeFormatter.gmtTimeformatter(matchList.get(i).getDate_start()));




                String[] datetime = matchList.get(i).getDate_start().split(" ");
                card.setDate(datetime[0]);
                card.setTime(datetime[1]);



                recentMatchList.add(card);
            }

            CustomOniObjectForShortCard c = new CustomOniObjectForShortCard();
            c.setData(recentMatchList);
            return c;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Player> playerList() {

        List<Player> playerList = new ArrayList<>();

        try
        {
            URL urlMashrafe = new URL("https://rest.entitysport.com/v2/players/354?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile mashrafe = objectMapper.readValue(urlMashrafe, PlayerProfile.class);
            mashrafe.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/01/mashrafe-mortaza-150x150.jpg");
            playerList.add(mashrafe.getResponse().getPlayer());

            URL urlTamim = new URL("https://rest.entitysport.com/v2/players/342?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile tamim = objectMapper.readValue(urlTamim, PlayerProfile.class);
            tamim.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/01/tamim-iqbal-150x150.jpg");
            playerList.add(tamim.getResponse().getPlayer());

            URL urlShakib = new URL("https://rest.entitysport.com/v2/players/348?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile shakib = objectMapper.readValue(urlShakib, PlayerProfile.class);
            shakib.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/01/shakib-al-hasan-150x150.jpg");
            playerList.add(shakib.getResponse().getPlayer());

            URL urlMahmudullah = new URL("https://rest.entitysport.com/v2/players/346?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile mahmudullah = objectMapper.readValue(urlMahmudullah, PlayerProfile.class);
            mahmudullah.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/01/mahmudullah-150x150.jpg");
            playerList.add(mahmudullah.getResponse().getPlayer());

            URL urlMushfiq = new URL("https://rest.entitysport.com/v2/players/350?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile mushfiq = objectMapper.readValue(urlMushfiq, PlayerProfile.class);
            mushfiq.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/01/mushfiqur-rahim-150x150.jpg");
            playerList.add(mushfiq.getResponse().getPlayer());

            URL urlLiton = new URL("https://rest.entitysport.com/v2/players/37360?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile liton = objectMapper.readValue(urlLiton, PlayerProfile.class);
            liton.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/03/liton-das-150x150.jpg");
            playerList.add(liton.getResponse().getPlayer());

            URL urlMustafiz = new URL("https://rest.entitysport.com/v2/players/1745?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile mustafiz = objectMapper.readValue(urlMustafiz, PlayerProfile.class);
            mustafiz.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/02/mustafizur-rahman-1-150x150.jpg");
            playerList.add(mustafiz.getResponse().getPlayer());

            URL urlRubel = new URL("https://rest.entitysport.com/v2/players/358?token=43783fd83d60570454356f7ab61317c1");
            PlayerProfile rubel = objectMapper.readValue(urlRubel, PlayerProfile.class);
            rubel.getResponse().getPlayer().setLogo_url("https://cricket.entitysport.com/assets/uploads/2016/01/rubel-hossain-150x150.jpg");
            playerList.add(rubel.getResponse().getPlayer());


            URL playersUrl = new URL("https://rest.entitysport.com/v2/players?country=bd&paged=1&per_page=30&token=43783fd83d60570454356f7ab61317c1");
            PlayerSearch playerSearch = objectMapper.readValue(playersUrl,PlayerSearch.class);
            List<Player> list = playerSearch.getResponse().getItems();

            for(Player player : list)
            {
                playerList.add(player);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return playerList;
    }

    @Override
    public Player getPlayerInfo(Integer id) {
        Player player = null;

        String url = "https://rest.entitysport.com/v2/players/"+id+"?token=43783fd83d60570454356f7ab61317c1";
        try{
            URL playerUrl = new URL(url.toString());
            PlayerProfile playerProfile = objectMapper.readValue(playerUrl, PlayerProfile.class);
            player = playerProfile.getResponse().getPlayer();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
       return player;
    }
}
