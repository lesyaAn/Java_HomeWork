package de.telran;

public class BankAccount {

    String IBAN;
    Person owner;

    @Override
    public String toString() {
        return "BankAccount{" +
                "IBAN='" + IBAN + '\'' +
                ", owner=" + owner +
                '}';
    }

    public String getIBAN() {
        return IBAN;
    }

    public Person getOwner() {
        return owner;
    }

    public BankAccount(String IBAN, Person owner) {
        this.IBAN = IBAN;
        this.owner = owner;
    }
}
