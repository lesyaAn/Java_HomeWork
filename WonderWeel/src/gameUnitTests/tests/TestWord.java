package gameUnitTests.tests;

import gameUnitTests.Word;
import gameUnitTests.WrongWordLengthException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestWord {
    @Test
    public void testGetWordWithStars(){
        Word word = new Word ("apple", "some description");

        word.openLetter('p');
        assertEquals("*pp**", word.getWordWithStars());
    }

    @Test
    public void testOpenWordValid() throws WrongWordLengthException {
        Word word = new Word ("apple", "some description");

        word.openWord("apple");
        assertEquals("apple",  word.getWordWithStars());
    }

    @Test
    public void testOpenWordNotValid() throws WrongWordLengthException {
        Word word = new Word ("apple", "some description");

        word.openWord("orange");
        assertEquals("*****", word.getWordWithStars());
    }

    @Test
    public void testOpenLetterWithValidChar() {
        Word word = new Word ("apple", "some description");

        word.openLetter('p');
        assertEquals("*pp**", word.getWordWithStars());

        word.openLetter('t');
        assertEquals("*pp**", word.getWordWithStars());

        word.openLetter('l');
        assertEquals("*ppl*", word.getWordWithStars());
    }

    @Test
    public void testOpenLetterWithInvalidChar() {
        Word word = new Word("apple", "some description");

        word.openLetter('!');
        assertEquals("*****", word.getWordWithStars());

        word.openLetter('@');
        assertEquals("*****", word.getWordWithStars());

        word.openLetter('A');
        assertEquals("*****", word.getWordWithStars());

        word.openLetter('M');
        assertEquals("*****", word.getWordWithStars());

    }

    @Test
    public void testOpenWordInvalidLength() throws WrongWordLengthException{

        Word word = new Word("apple", "some description");

        word.openWord("aapple");
        assertEquals("*****", word.getWordWithStars());
    }



}
