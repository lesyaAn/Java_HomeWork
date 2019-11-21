import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherForecast {
    private String name;
    private List<WeatherInfo> weather;
    private TempInfo main;
    private int visibility;


    public WeatherForecast() {
    }

    public WeatherForecast(String name, List<WeatherInfo> weather, TempInfo main, int visibility) {
        this.name = name;
        this.weather = weather;
        this.main = main;
        this.visibility = visibility;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }

    public void setMain(TempInfo main) {
        this.main = main;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "name='" + name + '\'' +
                ", weather=" + weather +
                ", main=" + main +
                ", visibility=" + visibility +
                '}';
    }
}
