package com.beslan.lab.task6;

import static java.time.LocalDateTime.now;

public class LogTimeInputStream extends InputStream1 {
    InputStream1 in;
    LogTimeInputStream(InputStream1 in){
        this.in = in;
    }
    @Override
    public int read() {
        System.out.println(now());
        in.read();
        System.out.println(now());
        return 0;
    }
}
