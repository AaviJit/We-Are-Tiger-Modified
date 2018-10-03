package com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;

@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchScorecardTest {

    private String status;

    private Object response;

    private String etag;

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private String modified;

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private String datetime;

    private String api_version;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getMatch() {
        return response;
    }

    public void setMatch(Object match) {
        this.response = match;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getApiVersion() {
        return api_version;
    }

    public void setApiVersion(String apiVersion) {
        this.api_version = apiVersion;
    }

    @Override
    public String toString() {
        return "MatchScorecard{" +
                "status='" + status + '\'' +
                ", response=" + response +
                ", etag='" + etag + '\'' +
                ", modified=" + modified +
                ", datetime=" + datetime +
                ", apiVersion='" + api_version + '\'' +
                '}';
    }
}