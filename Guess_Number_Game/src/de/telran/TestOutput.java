package de.telran;

public class TestOutput implements  ResultOutput {

    public String value;
    @Override
    public void print(String s) {
        this.value = s;

    }
}
