package com.beslan.lab.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestWordCounter {
    @Test
    public void TestCount(){
//------------------
        WordCounter test_words_count = new WordCounter("mom rick rick2  mom   mom dad  did  rick    rock  dad ");
        test_words_count.Count();
        Assertions.assertEquals(3,test_words_count.words_col.get("mom"));
        Assertions.assertEquals(2,test_words_count.words_col.get("rick"));
        Assertions.assertEquals(1,test_words_count.words_col.get("rick2"));
        Assertions.assertEquals(2,test_words_count.words_col.get("dad"));
        Assertions.assertEquals(1,test_words_count.words_col.get("did"));
        Assertions.assertEquals(1,test_words_count.words_col.get("rock"));
//-------------------
        WordCounter test2_words_count = new WordCounter("dad");
        test2_words_count.Count();
        Assertions.assertEquals(null,test2_words_count.words_col.get("mom"));
        Assertions.assertEquals(null,test2_words_count.words_col.get("rick"));
        Assertions.assertEquals(null,test2_words_count.words_col.get("rick2"));
        Assertions.assertEquals(1,test2_words_count.words_col.get("dad"));
        Assertions.assertEquals(null,test2_words_count.words_col.get("did"));
        Assertions.assertEquals(null,test2_words_count.words_col.get("rock"));
//-------------------
        WordCounter test3_words_count = new WordCounter("doDDo Azart  Port   QuiZ");
        test3_words_count.Count();
        Assertions.assertEquals(null,test3_words_count.words_col.get("doddo"));
        Assertions.assertEquals(1,test3_words_count.words_col.get("doDDo"));
        Assertions.assertEquals(null,test3_words_count.words_col.get("Quiz"));
    }
}
