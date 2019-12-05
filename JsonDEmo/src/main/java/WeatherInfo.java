public class WeatherInfo {
    private String main;
    private String description;
    private int id;
    private String icon;

    public WeatherInfo() {
    }

    public WeatherInfo(String main, String description, int id, String icon) {
        this.main = main;
        this.description = description;
        this.id = id;
        this.icon = icon;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", icon='" + icon + '\'' +
                '}';
    }
}
