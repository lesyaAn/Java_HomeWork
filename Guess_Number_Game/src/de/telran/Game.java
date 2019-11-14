package de.telran;

import java.util.Scanner;

public class Game {

    private int numberOfAttempts = 3;
    private  int secretNumber = 2;
    private NumberSource source;
    private ResultOutput output;

    static Scanner s = new Scanner(System.in);


    public static void main(String[] args) {
       NumberSource s = new NumberSource() {
           private Scanner s = new Scanner(System.in);
           @Override
           public int getNumber() {
               return 0;
           }
       };
        ResultOutput out = System.out::println;
        Game game = new Game(3, 5, s , out  );
        game.play();
    }

    public Game(int numberOfAttempts, int secretNumber,
                NumberSource source,
                ResultOutput output){
        this.numberOfAttempts = numberOfAttempts;
        this.secretNumber = secretNumber;
        this.source = source;
        this.output = output;


    }

    public void play(){
        print("Welcome!");
        boolean result = guessNumber();
        if(result){
            print("You win!");
        }else{
            print("You lost!");
        }

    }

    public  boolean guessNumber() {
        while(numberOfAttempts != 0){
            System.out.println("number: ");
            int number = getNumber();
            if(number == secretNumber){
                return true;
            }
            numberOfAttempts --;
        }
        return false;
    }

    private void print (String s) { output.print(s); }

    private int getNumber() { return source.getNumber(); }
}
