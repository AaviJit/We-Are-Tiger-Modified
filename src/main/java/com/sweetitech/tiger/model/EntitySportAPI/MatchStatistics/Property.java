package com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics;

public class Property {

    private String over;

    private Integer runs;

    private String runrate;

    public String getOver() {
        return over;
    }

    public void setOver(String over) {
        this.over = over;
    }

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public String getRunrate() {
        return runrate;
    }

    public void setRunrate(String runrate) {
        this.runrate = runrate;
    }

    @Override
    public String toString() {
        return "Property{" +
                "over='" + over + '\'' +
                ", runs=" + runs +
                ", runrate='" + runrate + '\'' +
                '}';
    }
}
