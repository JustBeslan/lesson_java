package com.beslan.lab.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestWordCounter {
    @Test
    void TestCount(){
//------------------
        WordCounter counter = new WordCounter("mom rick rick2  mom   mom dad  did  rick    rock  dad ");
        Assertions.assertEquals((Integer) 3, counter.col("mom"));
        Assertions.assertEquals((Integer) 2, counter.col("rick"));
        Assertions.assertEquals((Integer) 1, counter.col("rick2"));
        Assertions.assertEquals((Integer) 2, counter.col("dad"));
        Assertions.assertEquals((Integer) 1, counter.col("did"));
        Assertions.assertEquals((Integer) 1, counter.col("rock"));
        System.out.println(counter);
//-------------------
        counter = new WordCounter("dad");
        Assertions.assertEquals(null, counter.col("mom"));
        Assertions.assertEquals(null, counter.col("mom"));
        Assertions.assertEquals(null, counter.col("rick"));
        Assertions.assertEquals(null, counter.col("rick2"));
        Assertions.assertEquals((Integer) 1, counter.col("dad"));
        Assertions.assertEquals(null, counter.col("did"));
        Assertions.assertEquals(null, counter.col("rock"));
//-------------------
        counter = new WordCounter("doDDo Azart  Port   QuiZ");
        Assertions.assertEquals(null, counter.col("doddo"));
        Assertions.assertEquals((Integer) 1, counter.col("doDDo"));
        Assertions.assertEquals(null, counter.col("Quiz"));
    }
}
