package de.telran;

public class Address {

    String street;
    int houseNumber;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public Address(String street, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }
}
