package com.beslan.lab.task6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

abstract class InputStream1 {
    public abstract int read();

    public static void main(String[] args) {
//        new LogTimeInputStream(new LogTimeInputStream(new FileInputStream("t.txt")));
        try {
            InputStream in = new FileInputStream("1.txt");
            while (in.available() > 0){
                System.out.println(in.read());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        finally {

        }
    }
}
