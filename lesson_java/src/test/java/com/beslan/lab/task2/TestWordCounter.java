package com.beslan.lab.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestWordCounter {
    @Test
    public void TestCount(){
//------------------
        WordCounter counter = new WordCounter("mom rick rick2  mom   mom dad  did  rick    rock  dad ");
        Assertions.assertEquals(3,counter.col("mom"));
        Assertions.assertEquals(2,counter.col("rick"));
        Assertions.assertEquals(1,counter.col("rick2"));
        Assertions.assertEquals(2,counter.col("dad"));
        Assertions.assertEquals(1,counter.col("did"));
        Assertions.assertEquals(1,counter.col("rock"));
        System.out.println(counter);
//-------------------
        counter = new WordCounter("dad");
        Assertions.assertEquals((Integer) null,counter.col("mom"));
        Assertions.assertEquals((Integer) null,counter.col("mom"));
        Assertions.assertEquals((Integer) null,counter.col("rick"));
        Assertions.assertEquals((Integer) null,counter.col("rick2"));
        Assertions.assertEquals(1,counter.col("dad"));
        Assertions.assertEquals((Integer) null,counter.col("did"));
        Assertions.assertEquals((Integer) null,counter.col("rock"));
//-------------------
        counter = new WordCounter("doDDo Azart  Port   QuiZ");
        Assertions.assertEquals((Integer) null,counter.col("doddo"));
        Assertions.assertEquals(1,counter.col("doDDo"));
        Assertions.assertEquals((Integer) null,counter.col("Quiz"));
    }
}
