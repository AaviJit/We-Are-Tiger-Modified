package com.sweetitech.tiger.model.EntitySportAPI.PlayerProfile;

import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

public class Response {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Response{" +
                "player=" + player +
                '}';
    }
}
