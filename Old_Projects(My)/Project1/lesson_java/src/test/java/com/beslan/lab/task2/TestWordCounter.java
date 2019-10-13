package com.beslan.lab.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestWordCounter {
    @Test
    public void TestCount(){
        WordCounter test_words_count = new WordCounter("mom rick rick2  mom   mom dad  did  rick    rock  dad ");
        test_words_count.Count();
        Assertions.assertEquals(3,test_words_count.words_col.get("mom"));
    }
}
