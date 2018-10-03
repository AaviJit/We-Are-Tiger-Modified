package com.sweetitech.tiger.model.EntitySportAPI.PlayerStatstic;

import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

public class Response {

    private Player player;

    private BattingStatistic battingStatistic;

    private BowlingStatistic bowlingStatistic;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BattingStatistic getBattingStatistic() {
        return battingStatistic;
    }

    public void setBattingStatistic(BattingStatistic battingStatistic) {
        this.battingStatistic = battingStatistic;
    }

    public BowlingStatistic getBowlingStatistic() {
        return bowlingStatistic;
    }

    public void setBowlingStatistic(BowlingStatistic bowlingStatistic) {
        this.bowlingStatistic = bowlingStatistic;
    }
}
