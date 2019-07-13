package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    private List<String> song = new ArrayList<>();
    private final String URL = this.getClass().getClassLoader().getResource("data.txt").getFile();

    public List<String> readText() {
        try (BufferedReader br = new BufferedReader(new FileReader(URL))) {
            String s;
            while ((s = br.readLine()) != null) {
                song.add(s);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    return song;}
}
