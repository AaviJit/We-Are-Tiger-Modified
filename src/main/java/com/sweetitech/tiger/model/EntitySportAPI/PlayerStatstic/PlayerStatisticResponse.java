package com.sweetitech.tiger.model.EntitySportAPI.PlayerStatstic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatisticResponse {

    private Player player;

    private BattingStatistic batting;

    private BowlingStatistic bowling;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BattingStatistic getBatting() {
        return batting;
    }

    public void setBatting(BattingStatistic batting) {
        this.batting = batting;
    }

    public BowlingStatistic getBowling() {
        return bowling;
    }

    public void setBowling(BowlingStatistic bowling) {
        this.bowling = bowling;
    }
}
