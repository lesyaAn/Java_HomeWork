package de.telran;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void testOneAttemptHappyEnd(){
        int attempt = 1;
        int secret = 5;
        NumberSource s = () -> 5;
        TestOutput out = new TestOutput();

        String expected = "You win!";
        Game game = new Game(attempt, secret, s, out);
        game.play();

        String actual = out.value;

        assertEquals(expected, actual);
    }

    @Test
    public void testOneAttemptNonHappyEnd() {
        int attempt = 1;
        int secret = 5;
        NumberSource s = () -> 3;
        TestOutput out = new TestOutput();

        String expected = "You lost!";
        Game game = new Game(attempt, secret, s, out);
        game.play();

        String actual = out.value;

        assertEquals(expected, actual);

    }
    @Test
    public void testTwoAttemptHappyEnd() {
        int attempt = 2;
        int secret = 5;
        NumberSource s = () -> 5;
        TestOutput out = new TestOutput();

        String expected = "You win!";
        Game game = new Game(attempt, secret, s, out);
        game.play();

        String actual = out.value;

        assertEquals(expected, actual);
    }

    @Test
    public void testTwoAttemptNonHappyEnd() {
        int attempt = 2;
        int secret = 5;
        NumberSource s = () -> 9;
        TestOutput out = new TestOutput();

        String expected = "You win!";
        Game game = new Game(attempt, secret, s, out);
        game.play();

        String actual = out.value;

        assertEquals(expected, actual);
    }

}
