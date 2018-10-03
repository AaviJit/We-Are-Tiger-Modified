package com.sweetitech.tiger.model.cricketapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Partnership {
	private String player_b;

    private String player_a;

    private String innings;

    private String player_b_six;

    private String six;

    private String balls;

    private String player_b_runs;

    private String last_ball;

    private String four;

    private String dismissed;

    private String index;

    private String player_b_balls;

    private String end_over;

    private String team;

    private String run_rate;

    private String player_a_balls;

    private String overs_balls;

    private String start_over;

    private String player_a_runs;

    private String first_ball;

    private String player_a_four;

    private String runs;

    private String match;

    private String player_b_four;

    private String player_a_six;

    public String getPlayer_b ()
    {
        return player_b;
    }

    public void setPlayer_b (String player_b)
    {
        this.player_b = player_b;
    }

    public String getPlayer_a ()
    {
        return player_a;
    }

    public void setPlayer_a (String player_a)
    {
        this.player_a = player_a;
    }

    public String getInnings ()
    {
        return innings;
    }

    public void setInnings (String innings)
    {
        this.innings = innings;
    }

    public String getPlayer_b_six ()
    {
        return player_b_six;
    }

    public void setPlayer_b_six (String player_b_six)
    {
        this.player_b_six = player_b_six;
    }

    public String getSix ()
    {
        return six;
    }

    public void setSix (String six)
    {
        this.six = six;
    }

    public String getBalls ()
    {
        return balls;
    }

    public void setBalls (String balls)
    {
        this.balls = balls;
    }

    public String getPlayer_b_runs ()
    {
        return player_b_runs;
    }

    public void setPlayer_b_runs (String player_b_runs)
    {
        this.player_b_runs = player_b_runs;
    }

    public String getLast_ball ()
    {
        return last_ball;
    }

    public void setLast_ball (String last_ball)
    {
        this.last_ball = last_ball;
    }

    public String getFour ()
    {
        return four;
    }

    public void setFour (String four)
    {
        this.four = four;
    }

    public String getDismissed ()
    {
        return dismissed;
    }

    public void setDismissed (String dismissed)
    {
        this.dismissed = dismissed;
    }

    public String getIndex ()
    {
        return index;
    }

    public void setIndex (String index)
    {
        this.index = index;
    }

    public String getPlayer_b_balls ()
    {
        return player_b_balls;
    }

    public void setPlayer_b_balls (String player_b_balls)
    {
        this.player_b_balls = player_b_balls;
    }

    public String getEnd_over ()
    {
        return end_over;
    }

    public void setEnd_over (String end_over)
    {
        this.end_over = end_over;
    }

    public String getTeam ()
    {
        return team;
    }

    public void setTeam (String team)
    {
        this.team = team;
    }

    public String getRun_rate ()
    {
        return run_rate;
    }

    public void setRun_rate (String run_rate)
    {
        this.run_rate = run_rate;
    }

    public String getPlayer_a_balls ()
    {
        return player_a_balls;
    }

    public void setPlayer_a_balls (String player_a_balls)
    {
        this.player_a_balls = player_a_balls;
    }

    public String getOvers_balls ()
    {
        return overs_balls;
    }

    public void setOvers_balls (String overs_balls)
    {
        this.overs_balls = overs_balls;
    }

    public String getStart_over ()
    {
        return start_over;
    }

    public void setStart_over (String start_over)
    {
        this.start_over = start_over;
    }

    public String getPlayer_a_runs ()
    {
        return player_a_runs;
    }

    public void setPlayer_a_runs (String player_a_runs)
    {
        this.player_a_runs = player_a_runs;
    }

    public String getFirst_ball ()
    {
        return first_ball;
    }

    public void setFirst_ball (String first_ball)
    {
        this.first_ball = first_ball;
    }

    public String getPlayer_a_four ()
    {
        return player_a_four;
    }

    public void setPlayer_a_four (String player_a_four)
    {
        this.player_a_four = player_a_four;
    }

    public String getRuns ()
    {
        return runs;
    }

    public void setRuns (String runs)
    {
        this.runs = runs;
    }

    public String getMatch ()
    {
        return match;
    }

    public void setMatch (String match)
    {
        this.match = match;
    }

    public String getPlayer_b_four ()
    {
        return player_b_four;
    }

    public void setPlayer_b_four (String player_b_four)
    {
        this.player_b_four = player_b_four;
    }

    public String getPlayer_a_six ()
    {
        return player_a_six;
    }

    public void setPlayer_a_six (String player_a_six)
    {
        this.player_a_six = player_a_six;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [player_b = "+player_b+", player_a = "+player_a+", innings = "+innings+", player_b_six = "+player_b_six+", six = "+six+", balls = "+balls+", player_b_runs = "+player_b_runs+", last_ball = "+last_ball+", four = "+four+", dismissed = "+dismissed+", index = "+index+", player_b_balls = "+player_b_balls+", end_over = "+end_over+", team = "+team+", run_rate = "+run_rate+", player_a_balls = "+player_a_balls+", overs_balls = "+overs_balls+", start_over = "+start_over+", player_a_runs = "+player_a_runs+", first_ball = "+first_ball+", player_a_four = "+player_a_four+", runs = "+runs+", match = "+match+", player_b_four = "+player_b_four+", player_a_six = "+player_a_six+"]";
    }
}
