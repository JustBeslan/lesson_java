package com.beslan.lab.task2;

public class Book {
    public String author;
    private static String name_library;
    public int number;
    public String name;
    public short col_page;

    Book(String author){
        this.author = author;
    }

    public void out_(String s){
        System.out.println(s);
    }

}
