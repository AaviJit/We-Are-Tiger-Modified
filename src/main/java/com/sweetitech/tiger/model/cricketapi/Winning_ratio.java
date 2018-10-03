package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Winning_ratio
{
    private int a;

    private int b;

    public void setA(int a){
        this.a = a;
    }
    public int getA(){
        return this.a;
    }
    public void setB(int b){
        this.b = b;
    }
    public int getB(){
        return this.b;
    }
}