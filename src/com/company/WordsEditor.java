package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class WordsEditor {
    List<String> shortWordsAndSwears = new ArrayList<>();
    List<String> longWords = new ArrayList<>();
    static int wordsCounter;

    TextReader tr = new TextReader();

    public void separateIntoWords() {
        tr.readText();

        for (String word : TextReader.song) {
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

    public void separateSwears() {
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

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> sortedEntriesByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                (e1, e2) -> {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1;
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;

    }
    public List countOccurrences(int topUsefulWords) {
        System.out.println("The " + topUsefulWords + " frequently used words is: ");
        Map<String, Integer> wordFrequency = new TreeMap<>();
        for (String key : longWords) {
            if (wordFrequency.containsKey(key)) {
                wordFrequency.put(key, wordFrequency.get(key) + 1);
            } else
                wordFrequency.put(key, 1);
        }
        return sortedEntriesByValues(wordFrequency).stream().limit(topUsefulWords).collect(Collectors.toList());
    }
}
