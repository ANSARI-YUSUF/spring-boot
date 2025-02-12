package io.coderproblem.journalwithdatabase.api.reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

 import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
 import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class WheatherResponse {
    public Request request;
    public Location location;
    public Current current;

    @Data
    @NoArgsConstructor
    public class Current{
        @JsonProperty("observation_time")
        public String observationTime;
        public int temperature;
        public int weather_code;
        public ArrayList<String> weather_icons;
        public ArrayList<String> weather_descriptions;
        public int wind_speed;
        public int wind_degree;
        public String wind_dir;
        public int pressure;
        public int precip;
        public int humidity;
        public int cloudcover;
        public int feelslike;
        public int uv_index;
        public int visibility;
        public String is_day;
    }
    @Data
    @NoArgsConstructor
    public class Location{
        public String name;
        public String country;
        public String region;
        public String lat;
        public String lon;
        public String timezone_id;
        public String localtime;
        public int localtime_epoch;
        public String utc_offset;
    }
    @Data
    @NoArgsConstructor
    public class Request{
        public String type;
        public String query;
        public String language;
        public String unit;
    }
}
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


//public class Root{
//    public Request request;
//    public Location location;
//    public Current current;
//}

