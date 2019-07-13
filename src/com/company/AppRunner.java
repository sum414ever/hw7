package com.company;

public class AppRunner {
    public void getInitial(int numberTopWords) {
        WordsCounter we = new WordsCounter();
        we.separateIntoWords();
        we.separateSwears();
        we.countOccurrences(numberTopWords);
    }
}
