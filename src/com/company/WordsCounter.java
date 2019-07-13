package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class WordsCounter {
    private List<String> shortWordsAndSwears = new ArrayList<>();
    private List<String> longWords = new ArrayList<>();
    private int wordsCounter;

    TextReader tr = new TextReader();

    protected void separateIntoWords() {

        for (String word : tr.readText()) {
            List<String> oneByOne = Arrays.asList(word.split("['\\s]"));
            for (String oneWord : oneByOne) {
                wordsCounter++;
                if (oneWord.length() < 3) {
                    shortWordsAndSwears.add(oneWord);
                } else longWords.add(oneWord);
            }
        }
        System.out.println("That song have " + wordsCounter + " words");
    }

    protected void separateSwears() {
        for (int i = 0; i < Swears.swears.size(); i++) {
            for (int j = 0; j < longWords.size(); j++) {
                if (Swears.swears.get(i).equalsIgnoreCase(longWords.get(j))) {
                    shortWordsAndSwears.add(Swears.swears.get(i));
                    longWords.remove(Swears.swears.get(i));
                }
            }
        }
        System.out.println("Total number short words and swears is " + shortWordsAndSwears.size());
        System.out.println("Total number words without short words and swears is " + longWords.size());
    }

    private SortedSet<Map.Entry<String, Integer>> sortedEntriesByValues(Map<String, Integer> map) {
        SortedSet<Map.Entry<String, Integer>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;

    }

    protected void countOccurrences(int topUsefulWords) {
        System.out.println("The " + topUsefulWords + " frequently used words is: ");
        Map<String, Integer> wordFrequency = new TreeMap<>();
        for (String key : longWords) {
            if (wordFrequency.containsKey(key)) {
                wordFrequency.put(key, wordFrequency.get(key) + 1);
            } else
                wordFrequency.put(key, 1);
        }
        System.out.println(sortedEntriesByValues(wordFrequency).stream()
                .limit(topUsefulWords)
                .collect(Collectors.toList()));
    }
}
