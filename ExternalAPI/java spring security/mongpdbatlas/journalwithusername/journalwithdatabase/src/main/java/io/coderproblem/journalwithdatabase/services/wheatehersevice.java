package io.coderproblem.journalwithdatabase.services;

import io.coderproblem.journalwithdatabase.api.reponse.WheatherResponse;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Configuration

@Getter
@Setter
@Service
public class wheatehersevice {





    private final String apiTokenKey = "185833d163b583e01b01bd7b6e0da188";
    private final String API = "http://api.weatherstack.com/current?access_key=%s&query=%s";

//    public  String apitokenkey="185833d163b583e01b01bd7b6e0da188";
//    public String API="http://api.weatherstack.com/current" + "    ? access_key = apitokenkey" + "    & query = CITY";

//public String newapi="https://api.weatherstack.com/" +
//        "current?access_key=185833d163b583e01b01bd7b6e0da188&query=New%20York";

    @Autowired
    RestTemplate restTemplate;

    public  WheatherResponse getexternelapi(String city){
//        String finalapipath= API.replace("CITY",city).replace("apitokenkey",apitokenkey);
//        ResponseEntity<WheatherResponse> reponse = restTemplate.exchange(finalapipath, HttpMethod.GET, null,WheatherResponse.class);
//
//        reponse.getStatusCode();
//        WheatherResponse wheatherbody = reponse.getBody();
//        System.out.println(reponse.getBody().toString());
//
//        return wheatherbody;

        String finalApiPath = String.format(API, apiTokenKey, city);

        ResponseEntity<WheatherResponse> response = restTemplate.exchange(finalApiPath, HttpMethod.GET, null, WheatherResponse.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            System.out.println(response.getBody());
            return response.getBody();
        } else {
            System.out.println("API Response Failed: " + response.getStatusCode());
            return null;
        }
    }
}
