package com.beslan.lab.task2;

public class test {
    public static void main(String[] args) {
        Book book = new Book("Lermontov");
        book.out_(book.author);
        WordCounter wordcounter = new WordCounter("mom rick rick2  mom   mom dad  did  rick    rock  dad ");
        wordcounter.Count();
    }
}
