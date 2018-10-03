package com.sweetitech.tiger.model.cricketapi;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
	
	String card_type;
	
	List<Card> cards ;//= new ArrayList<Card>();
	
	public String getCard_type() {
		return card_type;
	}
	
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	
	

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Data [card_type=" + card_type + ", cards=" + cards + "]";
	}
	
	
	
}