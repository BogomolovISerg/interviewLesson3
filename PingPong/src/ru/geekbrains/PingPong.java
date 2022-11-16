package ru.geekbrains;

    public class PingPong implements Runnable{
        private String name;
        private Object lock;


        public PingPong(Object lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while(true) {
                    System.out.println(name);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();

                    try {
                        lock.wait(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

