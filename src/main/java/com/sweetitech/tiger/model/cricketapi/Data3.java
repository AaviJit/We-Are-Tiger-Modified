package com.sweetitech.tiger.model.cricketapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data3 {
	
	String card_type;
	
//	CardBackUp card ;//= new ArrayList<Card>();
	List<CardCustomForOniHome> cards ;
	
	public String getCard_type() {
		return card_type;
	}
	
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public List<CardCustomForOniHome> getCards() {
		return cards;
	}

	public void setCards(List<CardCustomForOniHome> cards) {
		this.cards = cards;
	}

	
	
}