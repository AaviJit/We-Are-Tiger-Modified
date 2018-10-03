package com.sweetitech.tiger.model.EntitySportAPI.ICCRanking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Format {

    private String odis;

    private String tests;

    private String t20s;

    public String getOdis() {
        return odis;
    }

    public void setOdis(String odis) {
        this.odis = odis;
    }

    public String getTests() {
        return tests;
    }

    public void setTests(String tests) {
        this.tests = tests;
    }

    public String getT20s() {
        return t20s;
    }

    public void setT20s(String t20s) {
        this.t20s = t20s;
    }
}
