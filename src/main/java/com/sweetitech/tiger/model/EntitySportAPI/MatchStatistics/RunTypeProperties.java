package com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics;

public class RunTypeProperties {

    private Integer run;

    private Integer  amount;

    public Integer getRun() {
        return run;
    }

    public void setRun(Integer run) {
        this.run = run;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RunTypeProperties{" +
                "run=" + run +
                ", amount=" + amount +
                '}';
    }
}
