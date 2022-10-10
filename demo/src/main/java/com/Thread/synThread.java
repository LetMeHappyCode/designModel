package com.Thread;

public class synThread {
    public static void main(String[] args) throws InterruptedException {
        AddThread addThread = new AddThread();
        DecThread decThread = new DecThread();

        addThread.start();
        decThread.start();

        addThread.join();
        decThread.join();

        System.out.println(Count.counte);
    }
}

class Count{
    public static int counte = 0;
    public static final Object lock =new Object();
}

class AddThread extends Thread{
    public void run(){
        for (int i=0;i<1000;i++){
            synchronized (Count.lock){
                Count.counte +=1;
            }

        }
    }
}

class DecThread extends Thread{
    public void run(){
        for (int i=0;i<1000;i++){
            synchronized (Count.lock){
                Count.counte -= 1;
            }

        }
    }
}