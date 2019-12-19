package com.beslan.lab.task8;

public class Brain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new newThread2());
        thread.start();
        thread.join();
//        wait();
//        notify();
//        notifyAll();
        new Thread(() -> {
            //run
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                //run
            }
        });
    }
}
