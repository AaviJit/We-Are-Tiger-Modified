package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Innings
{
    private B_1 b_1;

    private A_1 a_1;

    private B_2 b_2;

    private A_2 a_2;

    public void setB_1(B_1 b_1){
        this.b_1 = b_1;
    }
    public B_1 getB_1(){
        return this.b_1;
    }
    public void setA_1(A_1 a_1){
        this.a_1 = a_1;
    }
    public A_1 getA_1(){
        return this.a_1;
    }

    public B_2 getB_2() {
        return b_2;
    }

    public void setB_2(B_2 b_2) {
        this.b_2 = b_2;
    }

    public A_2 getA_2() {
        return a_2;
    }

    public void setA_2(A_2 a_2) {
        this.a_2 = a_2;
    }
}