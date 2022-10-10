package com.Thread;

public class thread {
    public static void main(String[] args) {
        sellTicket sellTicket = new sellTicket();

        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();

        System.out.println("main结束");
    }
}

class sellTicket implements Runnable{

    private  static int  ticketNumber=100;

    @Override
    public void run() {
        while (true){
            if (ticketNumber <= 0){
                System.out.println("线程结束");
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"售出一张票剩余票数"+(--ticketNumber));

        }
    }
}
