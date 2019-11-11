package test.java.moderate;

import algorithms.moderate.word_frequency.WordFrequency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class WordFrequencyTest {

    WordFrequency wordFrequency = new WordFrequency();
    
    @Test
    public void wordFrequency_Test() {
        String paragraph = "Hello world, what a wonderful world to say hello on a day like this in this world.";
        paragraph = paragraph.replaceAll("\\p{P}", "");
        String[] book = paragraph.split(" ");
        Assertions.assertEquals(3, wordFrequency.getFrequency(book, "world"));
        HashMap<String, Integer> table = wordFrequency.setupDictionary(book);
        Assertions.assertEquals(3, wordFrequency.getFrequency(table, "world"));
    }
}
