package com.sweetitech.tiger.model.EntitySportAPI.PlayerProfile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
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
