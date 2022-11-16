package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Lock lock = new ReentrantLock();
    private int max = 100;
    private int thred = 5;
    private int value;

    public void CounterStart(){
        List<Thread> threadList = new ArrayList<>();
        for(int i=0; i< thred; i++){
            Thread thread = new Thread((new Runnable() {
                @Override
                public void run() {
                    for(int i = 0; i < max; i++){
                        lock.lock();
                        value++;
                        lock.unlock();
                    }
                }
            }));
            threadList.add(thread);
        }
        for(Thread thread : threadList)
            thread.start();

        for(Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int getValue(){
        return value;
    }
}
