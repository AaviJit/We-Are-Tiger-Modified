package com.sweetitech.tiger.service.EntitySportsService;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.PlayerStatstic.PlayerStatisticResponse;
import com.sweetitech.tiger.model.cricketapi.Card;
import com.sweetitech.tiger.model.cricketapi.CardCustomForOni;
import com.sweetitech.tiger.model.cricketapi.CustomOniObjectForShortCard;

import java.util.List;

public interface EntitySportsCricketApiService {

    public CardCustomForOni getMatchInfo(String matchKey);
    public List<Card> getRecentMatches();
    public List<Card> getCurrentMatches();
    public List<Card> getUpcomingMatchs();
    CustomOniObjectForShortCard getRecentMatchesShortCard();
    List<Player> playerList();

    PlayerStatisticResponse getPlayerInfo(Integer id);



}
