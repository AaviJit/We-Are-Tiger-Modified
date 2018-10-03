package com.sweetitech.tiger.model.EntitySportAPI.CompetitionMatches;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

private String name;
private String location;
private String timezone;

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getLocation() {
return location;
}

public void setLocation(String location) {
this.location = location;
}

public String getTimezone() {
return timezone;
}

public void setTimezone(String timezone) {
this.timezone = timezone;
}

    @Override
    public String toString() {
        return "Venue{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}