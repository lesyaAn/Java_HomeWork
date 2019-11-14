package de.telran;

public class Box {

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Box(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Box{" +
                "value=" + value +
                '}';
    }


}
