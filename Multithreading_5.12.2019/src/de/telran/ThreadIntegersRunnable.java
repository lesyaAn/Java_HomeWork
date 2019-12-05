package de.telran;

public class ThreadIntegersRunnable implements Runnable {
    Counter counter;

    public ThreadIntegersRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            counter.decrement();
        }
    }

    public int getCounter() {
        return counter.getValue();
    }

}
