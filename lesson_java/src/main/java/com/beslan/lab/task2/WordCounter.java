package com.beslan.lab.task2;

import java.util.*;

public class WordCounter {

    private String text;
    private String[] words;
    private Map<String,Integer> words_col = new HashMap<>();


    public WordCounter(String text){
        this.text = text;
        Count();
    }

    public Integer col(String word){
        return words_col.get(word);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> pair : words_col.entrySet()) {
            builder.append(pair.getKey() + " : " + pair.getValue()).append("\n");
        }
        return builder.toString();
    }

    private void Count(){
        words = text.split("\\s+");
        for(String s: words){
            int count = words_col.containsKey(s) ? words_col.get(s) : 0;
            words_col.put(s,count+1);
        }
//        for(Map.Entry<String,Integer> pair: words_col.entrySet())
//            System.out.println(pair.getKey() + " : " + pair.getValue());
    }
}
