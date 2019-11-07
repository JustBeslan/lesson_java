package com.beslan.lab.task6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FilesWordsCounterTest {
    @Test
    void FilesWordsCounterTest1() throws IOException {
        FilesWordsCounter filesWordsCounter1 = new FilesWordsCounter("src/main/resources/test1/");
        assertEquals(filesWordsCounter1.col("Hello"),4);
        assertEquals(filesWordsCounter1.col("Good"),1);
        assertEquals(filesWordsCounter1.col("-"),1);
        assertEquals(filesWordsCounter1.col("Конец."),1);
        assertEquals(filesWordsCounter1.col("Еще"),3);
        assertEquals(filesWordsCounter1.col("одна"),3);
        assertEquals(filesWordsCounter1.col("строка"),3);
        assertEquals(filesWordsCounter1.col("текста."),3);
        assertNull(filesWordsCounter1.col("Слово"));
    }
    @Test
    void FilesWordsCounterTest2() throws IOException {
        FilesWordsCounter filesWordsCounter2 = new FilesWordsCounter("src/main/resources/test2/");
        assertNull(filesWordsCounter2.col("Hello"));
        assertNull(filesWordsCounter2.col("Good"));
        assertNull(filesWordsCounter2.col("-"));
        assertNull(filesWordsCounter2.col("Конец."));
        assertNull(filesWordsCounter2.col("Слово"));
    }

}