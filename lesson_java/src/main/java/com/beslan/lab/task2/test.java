package com.beslan.lab.task2;

public class test {
    public static void main(String[] args) {
        Book book = new Book("Lermontov");
        book.out_(book.author);
        WordCounter wordcounter = new WordCounter("aa bbb aa bbb cdf bbb cdf a kl a");
        wordcounter.Count();
    }
}
