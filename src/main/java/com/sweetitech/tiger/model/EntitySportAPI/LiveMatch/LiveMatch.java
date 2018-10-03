package com.sweetitech.tiger.model.EntitySportAPI.LiveMatch;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches.Match;

import java.util.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveMatch {

    private String status;

    private Match response;

    private String etag;

    private String modified;

    private String datetime;

    private String api_version;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Match getResponse() {
        return response;
    }

    public void setResponse(Match response) {
        this.response = response;
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

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    @Override
    public String toString() {
        return "LiveMatch{" +
                "status='" + status + '\'' +
                ", response=" + response +
                ", etag='" + etag + '\'' +
                ", modified='" + modified + '\'' +
                ", datetime='" + datetime + '\'' +
                ", api_version='" + api_version + '\'' +
                '}';
    }
}
