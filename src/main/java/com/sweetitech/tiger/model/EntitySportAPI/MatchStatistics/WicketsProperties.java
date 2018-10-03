package com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics;

public class WicketsProperties {

    private String dismissal;

    private Integer amount;

    public String getDismissal() {
        return dismissal;
    }

    public void setDismissal(String dismissal) {
        this.dismissal = dismissal;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WicketsProperties{" +
                "dismissal='" + dismissal + '\'' +
                ", amount=" + amount +
                '}';
    }
}
