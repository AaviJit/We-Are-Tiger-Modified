package com.sweetitech.tiger.model.cricketapi;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Msgs
{
    private String result;

    private List<String> others;

    public void setResult(String result){
        this.result = result;
    }
    public String getResult(){
        return this.result;
    }
    public void setOthers(List<String> others){
        this.others = others;
    }
    public List<String> getOthers(){
        return this.others;
    }
}