package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Root
{
    private String card_type;

    private Card card;

    public void setCard_type(String card_type){
        this.card_type = card_type;
    }
    public String getCard_type(){
        return this.card_type;
    }
    public void setCard(Card card){
        this.card = card;
    }
    public Card getCard(){
        return this.card;
    }
}