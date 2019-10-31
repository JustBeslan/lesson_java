package com.beslan.lab.task6;

import java.io.IOException;

public class Brain {
    public static void main(String[] args) throws IOException {
        FilesWordsCounter filesWordsCounter = new FilesWordsCounter("C:/Project_Java/lesson_java/src/main/resources/");
        System.out.println(filesWordsCounter.getWordsStatistic());
    }
}
