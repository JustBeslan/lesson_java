package com.beslan.lab.task3;


import com.beslan.lab.task3.Operations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class testOperations {
    @Test
    public void twoPlustwoTest(){
        Assertions.assertEquals(4, Operations.f(2,2));
    }
}
