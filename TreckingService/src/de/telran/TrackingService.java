package de.telran;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackingService {
    private int total;
    private int goal;
    private List<HistoryItem> history = new ArrayList<>();
    private int historyId = 0;




    public void addCalories (int amount) throws MaxNumberExceededException{
        total += amount;
        history.add(new HistoryItem(historyId++, amount, "add", total));


    }

    public void  removeCalories(int amount){
        total -= amount;
        if(total < 0) total = 0;
        history.add(new HistoryItem(historyId++, amount, "remove", total));

    }

    public int getTotal() {
        return total;
    }

    public int getGoal() {
        return goal;
    }

    public List<HistoryItem> getHistory() {
        return history;
    }

    public boolean isGoalMet(){
        return total >= goal;
    }
}
