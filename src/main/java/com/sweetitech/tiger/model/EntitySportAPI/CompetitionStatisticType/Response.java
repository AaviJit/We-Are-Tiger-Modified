package com.sweetitech.tiger.model.EntitySportAPI.CompetitionStatisticType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    private List<String> formats;
    private List<StatisticWithType> statisticWithTypes;

    public List<String> getFormats() {
        return formats;
    }

    public void setFormats(List<String> formats) {
        this.formats = formats;
    }

    public List<StatisticWithType> getStatisticWithTypes() {
        return statisticWithTypes;
    }

    public void setStatisticWithTypes(List<StatisticWithType> statisticWithTypes) {
        this.statisticWithTypes = statisticWithTypes;
    }
}
