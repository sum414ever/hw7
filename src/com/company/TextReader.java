package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
    static List<String> song = new ArrayList<>();
    public void readText() {
        String url = this.getClass().getResource("data.txt").getPath();
        try (
                BufferedReader br = new BufferedReader(new FileReader(url))) {
            String s;
            while ((s = br.readLine()) != null) {
                song.add(s);
            }
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
