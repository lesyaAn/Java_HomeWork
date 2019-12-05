package de.telran;

public class ThreadIntegersThread extends Thread {

    Counter counter;

    public ThreadIntegersThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }

    public int getCounter() {
        return counter.getValue();
    }
}
