package com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Player;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionTeams.Team;
import com.sweetitech.tiger.model.EntitySportAPI.LiveMatch.LiveScore;
import com.sweetitech.tiger.model.EntitySportAPI.MatchInningsCommentary.Commentary;
import com.sweetitech.tiger.model.EntitySportAPI.MatchScorecard.Innings;
import com.sweetitech.tiger.model.EntitySportAPI.SeasonCompetitions.Competition;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonIgnoreProperties({"man_of_the_match","man_of_the_series"})*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {

    private Integer match_id;

    private Integer mid;

    private String title;

    private String domestic;

    private String subtitle;

    private Integer format;

    private String format_str;

    private String status;

    private String status_str;

    private String status_note;

    private String game_state;

    private String game_state_str;

    private Competition competition;

    private Team teama;

    private Team teamb;

    private String date_start;

    private String date_end;

    private Integer timestamp_start;

    private Integer timestamp_end;

    private Venue venue;

    private String umpires;

    private String referee;

    private String equation;

    private String result;

    private String live;

    private String win_margin;

    private Integer commentary;

    private Integer wagon;

    private Integer latest_inning_number;

    private Toss toss;

    private String current_over;

    private String previous_over;

   /* private Player man_of_the_match;
    @JsonProperty("man_of_the_series")
    private String man_of_the_series;
*/


    private Integer is_followon;

    private String team_batting_first;

    private String team_batting_second;




    private String last_five_overs;

    private Integer live_inning_number;

    private List<Innings> innings;

    private List<Player> players;

    private Innings live_inning;

    private List<Team> teamList;

    private String team_batting;

    private String team_bowling;

    private LiveScore live_score;

    private List<Player> batsmen;

    private List<Player> bowlers;

    private List<Commentary> commentaries;

    private Integer winning_team_id;

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getFormat() {
        return format;
    }

    public void setFormat(Integer format) {
        this.format = format;
    }

    public String getFormat_str() {
        return format_str;
    }

    public void setFormat_str(String format_str) {
        this.format_str = format_str;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_str() {
        return status_str;
    }

    public void setStatus_str(String status_str) {
        this.status_str = status_str;
    }

    public String getStatus_note() {
        return status_note;
    }

    public void setStatus_note(String status_note) {
        this.status_note = status_note;
    }

    public String getGame_state() {
        return game_state;
    }

    public void setGame_state(String game_state) {
        this.game_state = game_state;
    }

    public String getGame_state_str() {
        return game_state_str;
    }

    public void setGame_state_str(String game_state_str) {
        this.game_state_str = game_state_str;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Team getTeama() {
        return teama;
    }

    public void setTeama(Team teama) {
        this.teama = teama;
    }

    public Team getTeamb() {
        return teamb;
    }

    public void setTeamb(Team teamb) {
        this.teamb = teamb;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public Integer getTimestamp_start() {
        return timestamp_start;
    }

    public void setTimestamp_start(Integer timestamp_start) {
        this.timestamp_start = timestamp_start;
    }

    public Integer getTimestamp_end() {
        return timestamp_end;
    }

    public void setTimestamp_end(Integer timestamp_end) {
        this.timestamp_end = timestamp_end;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getUmpires() {
        return umpires;
    }

    public void setUmpires(String umpires) {
        this.umpires = umpires;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getWin_margin() {
        return win_margin;
    }

    public void setWin_margin(String win_margin) {
        this.win_margin = win_margin;
    }

    public Integer getCommentary() {
        return commentary;
    }

    public void setCommentary(Integer commentary) {
        this.commentary = commentary;
    }

    public Integer getWagon() {
        return wagon;
    }

    public void setWagon(Integer wagon) {
        this.wagon = wagon;
    }

    public Integer getLatest_inning_number() {
        return latest_inning_number;
    }

    public void setLatest_inning_number(Integer latest_inning_number) {
        this.latest_inning_number = latest_inning_number;
    }

    public Toss getToss() {
        return toss;
    }

    public void setToss(Toss toss) {
        this.toss = toss;
    }

    public String getCurrent_over() {
        return current_over;
    }

    public void setCurrent_over(String current_over) {
        this.current_over = current_over;
    }

    public String getPrevious_over() {
        return previous_over;
    }

    public void setPrevious_over(String previous_over) {
        this.previous_over = previous_over;
    }

    public Integer getIs_followon() {
        return is_followon;
    }

    public void setIs_followon(Integer is_followon) {
        this.is_followon = is_followon;
    }

    public String getTeam_batting_first() {
        return team_batting_first;
    }

    public void setTeam_batting_first(String team_batting_first) {
        this.team_batting_first = team_batting_first;
    }

    public String getTeam_batting_second() {
        return team_batting_second;
    }

    public void setTeam_batting_second(String team_batting_second) {
        this.team_batting_second = team_batting_second;
    }

    public String getLast_five_overs() {
        return last_five_overs;
    }

    public void setLast_five_overs(String last_five_overs) {
        this.last_five_overs = last_five_overs;
    }

    public Integer getLive_inning_number() {
        return live_inning_number;
    }

    public void setLive_inning_number(Integer live_inning_number) {
        this.live_inning_number = live_inning_number;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    public void setInnings(List<Innings> innings) {
        this.innings = innings;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Innings getLive_inning() {
        return live_inning;
    }

    public void setLive_inning(Innings live_inning) {
        this.live_inning = live_inning;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public String getTeam_batting() {
        return team_batting;
    }

    public void setTeam_batting(String team_batting) {
        this.team_batting = team_batting;
    }

    public String getTeam_bowling() {
        return team_bowling;
    }

    public void setTeam_bowling(String team_bowling) {
        this.team_bowling = team_bowling;
    }

    public LiveScore getLive_score() {
        return live_score;
    }

    public void setLive_score(LiveScore live_score) {
        this.live_score = live_score;
    }

    public List<Player> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(List<Player> batsmen) {
        this.batsmen = batsmen;
    }

    public List<Player> getBowlers() {
        return bowlers;
    }

    public void setBowlers(List<Player> bowlers) {
        this.bowlers = bowlers;
    }

    public List<Commentary> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(List<Commentary> commentaries) {
        this.commentaries = commentaries;
    }

    public Integer getWinning_team_id() {
        return winning_team_id;
    }

    public void setWinning_team_id(Integer winning_team_id) {
        this.winning_team_id = winning_team_id;
    }

    public String getDomestic() {
        return domestic;
    }

    public void setDomestic(String domestic) {
        this.domestic = domestic;
    }

    @Override
    public String toString() {
        return "Match{" +
                "match_id=" + match_id +
                ", mid=" + mid +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", format=" + format +
                ", format_str='" + format_str + '\'' +
                ", status='" + status + '\'' +
                ", status_str='" + status_str + '\'' +
                ", status_note='" + status_note + '\'' +
                ", game_state='" + game_state + '\'' +
                ", game_state_str='" + game_state_str + '\'' +
                ", competition=" + competition +
                ", teama=" + teama +
                ", teamb=" + teamb +
                ", date_start='" + date_start + '\'' +
                ", date_end='" + date_end + '\'' +
                ", timestamp_start=" + timestamp_start +
                ", timestamp_end=" + timestamp_end +
                ", venue=" + venue +
                ", umpires='" + umpires + '\'' +
                ", referee='" + referee + '\'' +
                ", equation='" + equation + '\'' +
                ", result='" + result + '\'' +
                ", live='" + live + '\'' +
                ", win_margin='" + win_margin + '\'' +
                ", commentary=" + commentary +
                ", wagon=" + wagon +
                ", latest_inning_number=" + latest_inning_number +
                ", toss=" + toss +
                ", current_over='" + current_over + '\'' +
                ", previous_over='" + previous_over + '\'' +
                ", is_followon=" + is_followon +
                ", team_batting_first='" + team_batting_first + '\'' +
                ", team_batting_second='" + team_batting_second + '\'' +
                ", last_five_overs='" + last_five_overs + '\'' +
                ", live_inning_number=" + live_inning_number +
                ", innings=" + innings +
                ", players=" + players +
                ", live_inning=" + live_inning +
                ", teamList=" + teamList +
                ", team_batting='" + team_batting + '\'' +
                ", team_bowling='" + team_bowling + '\'' +
                ", live_score=" + live_score +
                ", batsmen=" + batsmen +
                ", bowlers=" + bowlers +
                ", commentaries=" + commentaries +
                ", winning_team_id=" + winning_team_id +
                '}';
    }
}
