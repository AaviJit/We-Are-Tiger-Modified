package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match
{
    private Innings innings;

    public void setInnings(Innings innings){
        this.innings = innings;
    }
    public Innings getInnings(){
        return this.innings;
    }
}
