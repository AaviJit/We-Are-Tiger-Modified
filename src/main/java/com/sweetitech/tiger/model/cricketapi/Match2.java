package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match2
{
    private Object innings;

    public void setInnings(Object innings){
        this.innings = innings;
    }
    public Object getInnings(){
        return this.innings;
    }
}
