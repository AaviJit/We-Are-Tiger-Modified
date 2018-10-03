package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Batting
{
    private boolean dismissed;

    public void setDismissed(boolean dismissed){
        this.dismissed = dismissed;
    }
    public boolean getDismissed(){
        return this.dismissed;
    }
}