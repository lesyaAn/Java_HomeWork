import com.fasterxml.jackson.annotation.JsonProperty;

public class Phones {
    private String countryCode;
    private int phoneNumber;

    public Phones() {
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Phones(String countryCode, int phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "countryCode='" + countryCode + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
