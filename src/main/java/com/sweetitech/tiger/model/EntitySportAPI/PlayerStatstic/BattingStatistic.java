package com.sweetitech.tiger.model.EntitySportAPI.PlayerStatstic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BattingStatistic {

    private BattingFormat test;

    private BattingFormat odi;

    private BattingFormat t20i;

    private BattingFormat t20;

    private BattingFormat lista;

    private BattingFormat firstclass;

    public BattingFormat getTest() {
        return test;
    }

    public void setTest(BattingFormat test) {
        this.test = test;
    }

    public BattingFormat getOdi() {
        return odi;
    }

    public void setOdi(BattingFormat odi) {
        this.odi = odi;
    }

    public BattingFormat getT20i() {
        return t20i;
    }

    public void setT20i(BattingFormat t20i) {
        this.t20i = t20i;
    }

    public BattingFormat getT20() {
        return t20;
    }

    public void setT20(BattingFormat t20) {
        this.t20 = t20;
    }

    public BattingFormat getLista() {
        return lista;
    }

    public void setLista(BattingFormat lista) {
        this.lista = lista;
    }

    public BattingFormat getFirstclass() {
        return firstclass;
    }

    public void setFirstclass(BattingFormat firstclass) {
        this.firstclass = firstclass;
    }

    @Override
    public String toString() {
        return "BattingStatistic{" +
                "test=" + test +
                ", odi=" + odi +
                ", t20i=" + t20i +
                ", t20=" + t20 +
                ", lista=" + lista +
                ", firstclass=" + firstclass +
                '}';
    }
}
