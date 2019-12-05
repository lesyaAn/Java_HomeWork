import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Demo {
    public static  void main (String[] args) throws IOException {
/*
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(new File("persons.json"), Person.class);
        System.out.println(person);
*/
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=0e2441af1b772fa31363023705b6351c";
        ObjectMapper mapper = new ObjectMapper();
        WeatherForecast weatherForecast = mapper.readValue(new URL(url), WeatherForecast.class);
        System.out.println(weatherForecast);
    }
}
