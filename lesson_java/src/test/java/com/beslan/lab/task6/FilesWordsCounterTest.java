package com.beslan.lab.task6;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FilesWordsCounterTest {
    @Test
    void FilesWordsCounterTest1() throws IOException {
        FilesWordsCounter filesWordsCounter1 = new FilesWordsCounter("src/main/resources/test1/");
        assertEquals(filesWordsCounter1.col("Hello"), (Integer) 4);
        assertEquals(filesWordsCounter1.col("Good"), (Integer) 1);
        assertEquals(filesWordsCounter1.col("-"), (Integer) 1);
        assertEquals(filesWordsCounter1.col("Конец."), (Integer) 1);
        assertEquals(filesWordsCounter1.col("Еще"), (Integer) 3);
        assertEquals(filesWordsCounter1.col("одна"), (Integer) 3);
        assertEquals(filesWordsCounter1.col("строка"), (Integer) 3);
        assertEquals(filesWordsCounter1.col("текста."), (Integer) 3);
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