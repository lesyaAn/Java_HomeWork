public class TempInfo {
    private int temp;
    private int pressure;
    private int humidity;
    private int temp_min;
    private int temp_max;




    public TempInfo() {

    }

    public TempInfo(int temp, int pressure, int humidity, int temp_min, int temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    @Override
    public String toString() {
        return "TempInfo{" +
                "temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                '}';
    }
}
