package com.sweetitech.tiger.model.EntitySportAPI.ICCRanking;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamWithRank {

    private List<RankingProperties> odis;

    private List<RankingProperties> tests;

    private List<RankingProperties> t20s;

    public List<RankingProperties> getOdis() {
        return odis;
    }

    public void setOdis(List<RankingProperties> odis) {
        this.odis = odis;
    }

    public List<RankingProperties> getTests() {
        return tests;
    }

    public void setTests(List<RankingProperties> tests) {
        this.tests = tests;
    }

    public List<RankingProperties> getT20s() {
        return t20s;
    }

    public void setT20s(List<RankingProperties> t20s) {
        this.t20s = t20s;
    }
}
