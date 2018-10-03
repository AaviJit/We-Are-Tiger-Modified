package com.sweetitech.tiger.service.interfaces;

import java.util.List;

import com.sweetitech.tiger.model.cricketapi.Card;
import com.sweetitech.tiger.model.cricketapi.CardBackUp;
import com.sweetitech.tiger.model.cricketapi.CardCustomForOni;
import com.sweetitech.tiger.model.cricketapi.CardCustomForOniHome;
import com.sweetitech.tiger.model.cricketapi.CustomOniObjectForShortCard;
import com.sweetitech.tiger.model.cricketapi.Data;
import com.sweetitech.tiger.model.cricketapi.Yo2;

public interface ICricketApiService {
	//public CricketApiLogin logIn();
	
	public Data getMatchById(String matchId);
	
	public List<Card> getRecentMatches();
	public List<Card> getCurrentMatches();
	public List<Card> getUpcomingMatchs();

	List<Card> getPastAndFuture();
	
	Card getMatchSummary(String key);
	CardCustomForOni getMatchSummaryCardCustomForOni(String key);
	
	
	public List<CardCustomForOniHome> getLiveMatchesShortCard();
	public CustomOniObjectForShortCard getRecentMatchesShortCard();
	public List<CardCustomForOniHome> getUpcomingMatchesShortCard();
	
}
