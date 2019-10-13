package com.beslan.lab.task2;

import java.util.*;

public class WordCounter {

    public String text;
    public String[] words;
    Map<String,Integer> words_col = new HashMap<String ,Integer>();

    WordCounter(String text){
        this.text = text;
    }

    public void Count(){
        words = text.split("\\s+");
        for(String s: words){
            int count = words_col.containsKey(s) ? words_col.get(s) : 0;
            words_col.put(s,count+1);
        }
        for(Map.Entry<String,Integer> pair: words_col.entrySet())
            System.out.println(pair.getKey() + " : " + pair.getValue());
    }
}
