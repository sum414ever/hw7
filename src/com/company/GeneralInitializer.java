package com.company;

public class GeneralInitializer {
    public void getInitial(int numberTopWords) {
        WordsEditor we = new WordsEditor();
        we.separateIntoWords();
        we.separateSwears();
        System.out.println(we.countOccurrences(numberTopWords));
    }
}
