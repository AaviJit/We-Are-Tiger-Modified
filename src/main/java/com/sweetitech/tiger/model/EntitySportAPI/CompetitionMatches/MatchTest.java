package com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatchTest {

    private Integer match_id;

    private String title;

    private String subtitle;

    private Integer format;

    public Integer getMatch_id() {
        return match_id;
    }

    public void setMatch_id(Integer match_id) {
        this.match_id = match_id;
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

    @Override
    public String toString() {
        return "MatchTest{" +
                "match_id=" + match_id +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", format=" + format +
                '}';
    }
}
