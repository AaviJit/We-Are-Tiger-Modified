package com.sweetitech.tiger.model.EntitySportAPI.PlayerStatstic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BowlingStatistic {

    private BowlingFormat test;

    private BowlingFormat odi;

    private BowlingFormat t20i;

    private BowlingFormat t20;

    private BowlingFormat lista;

    private BowlingFormat firstclass;

    public BowlingFormat getTest() {
        return test;
    }

    public void setTest(BowlingFormat test) {
        this.test = test;
    }

    public BowlingFormat getOdi() {
        return odi;
    }

    public void setOdi(BowlingFormat odi) {
        this.odi = odi;
    }

    public BowlingFormat getT20i() {
        return t20i;
    }

    public void setT20i(BowlingFormat t20i) {
        this.t20i = t20i;
    }

    public BowlingFormat getT20() {
        return t20;
    }

    public void setT20(BowlingFormat t20) {
        this.t20 = t20;
    }

    public BowlingFormat getLista() {
        return lista;
    }

    public void setLista(BowlingFormat lista) {
        this.lista = lista;
    }

    public BowlingFormat getFirstclass() {
        return firstclass;
    }

    public void setFirstclass(BowlingFormat firstclass) {
        this.firstclass = firstclass;
    }
}
