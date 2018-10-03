package com.sweetitech.tiger.model.EntitySportAPI.MatchStatistics;

import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.CurrentPartnership;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.ExtraRuns;

import java.util.List;

public class StatisticProperty {

    private List<Property> manhattan;

    private List<Property> worm;

    private List<Property> runrates;

    private List<CurrentPartnership> partnershipList;

    private List<RunTypeProperties> runTypePropertiesList;

    private List<WicketsProperties> wicketsPropertiesList;

    private List<PlayerVsPlayerProperties> playerVsPlayerProperties;

    private ExtraRuns extra;



    public List<Property> getManhattan() {
        return manhattan;
    }

    public void setManhattan(List<Property> manhattan) {
        this.manhattan = manhattan;
    }

    public List<Property> getWorm() {
        return worm;
    }

    public void setWorm(List<Property> worm) {
        this.worm = worm;
    }

    public List<Property> getRunrates() {
        return runrates;
    }

    public void setRunrates(List<Property> runrates) {
        this.runrates = runrates;
    }

    public List<CurrentPartnership> getPartnershipList() {
        return partnershipList;
    }

    public void setPartnershipList(List<CurrentPartnership> partnershipList) {
        this.partnershipList = partnershipList;
    }

    public List<RunTypeProperties> getRunTypePropertiesList() {
        return runTypePropertiesList;
    }

    public void setRunTypePropertiesList(List<RunTypeProperties> runTypePropertiesList) {
        this.runTypePropertiesList = runTypePropertiesList;
    }

    public List<WicketsProperties> getWicketsPropertiesList() {
        return wicketsPropertiesList;
    }

    public void setWicketsPropertiesList(List<WicketsProperties> wicketsPropertiesList) {
        this.wicketsPropertiesList = wicketsPropertiesList;
    }

    public List<PlayerVsPlayerProperties> getPlayerVsPlayerProperties() {
        return playerVsPlayerProperties;
    }

    public void setPlayerVsPlayerProperties(List<PlayerVsPlayerProperties> playerVsPlayerProperties) {
        this.playerVsPlayerProperties = playerVsPlayerProperties;
    }

    public ExtraRuns getExtra() {
        return extra;
    }

    public void setExtra(ExtraRuns extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "StatisticProperty{" +
                "manhattan=" + manhattan +
                ", worm=" + worm +
                ", runrates=" + runrates +
                ", partnershipList=" + partnershipList +
                ", runTypePropertiesList=" + runTypePropertiesList +
                ", wicketsPropertiesList=" + wicketsPropertiesList +
                ", playerVsPlayerProperties=" + playerVsPlayerProperties +
                ", extra=" + extra +
                '}';
    }
}
