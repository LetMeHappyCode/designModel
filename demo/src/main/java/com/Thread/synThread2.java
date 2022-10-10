package com.Thread;

public class synThread2 {
    public static void main(String[] args) throws InterruptedException {
//        Thread[] threads = {
//                new AddTeacherThread(),
//                new DesTeacherThread()};


        Counter counter = new Counter();

        Counter counter1 = new Counter();
        long startTime = System.currentTimeMillis();
        AddStudentThread addStudentThread = new AddStudentThread(counter);
        DesStudentThread desStudentThread = new DesStudentThread(counter);
        AddTeacherThread addTeacherThread = new AddTeacherThread(counter);
        DesTeacherThread desTeacherThread = new DesTeacherThread(counter);

        Thread thread1 = new Thread(addStudentThread);
        Thread thread2 = new Thread(desStudentThread);
        Thread thread3 = new Thread(addTeacherThread);
        Thread thread4 = new Thread(desTeacherThread);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

//        for (Thread thread:threads){
//            thread.start();
//        }
//
//        for (Thread thread:threads){
//            thread.join();
//        }

        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);


        long overTime = System.currentTimeMillis();      //获取结束时间
        System.out.println("程序运行时间为："+(overTime-startTime)+"毫秒");


    }


}

class Counter{
    public static final Object lock =new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;

    public void addStudent(){
        synchronized (this){
            studentCount+=1;
            System.out.println("addStudent"+studentCount);
        }
    }

    public void desStudent(){
        synchronized (this){
            studentCount-=1;
            System.out.println("desStudent"+studentCount);
        }
    }

    public void addTeacher(){
        synchronized (this){
            teacherCount+=1;
            System.out.println("addTeacher"+teacherCount);
        }
    }

    public void desTeacher(){
        synchronized (this){
            teacherCount-=1;
            System.out.println("desStudent"+teacherCount);
        }
    }

}

class AddStudentThread implements Runnable{

    Counter counter;

    AddStudentThread(Counter counter){
        this.counter = counter;
    }

    AddStudentThread(){

    }

    public void run(){
        for (int i=0;i<100000;i++){
            synchronized (this){
                counter.addStudent();
            }
        }
    }
}

class DesStudentThread implements Runnable{

    Counter counter;

    DesStudentThread(){

    }

    DesStudentThread(Counter counter){
        this.counter = counter;
    }

    public void run(){
        for (int i=0;i<100000;i++){
            counter.desStudent();
        }
    }
}

class DesTeacherThread implements Runnable{

    Counter counter;

    DesTeacherThread(){

    }

    DesTeacherThread(Counter counter){
        this.counter = counter;
    }

    public void run(){
        for (int i=0;i<100000;i++){
            synchronized (this){
                counter.desTeacher();
            }
        }
    }
}

class AddTeacherThread implements Runnable{
    Counter counter;

    AddTeacherThread(){

    }

    AddTeacherThread(Counter counter){
        this.counter = counter;
    }

    public void run(){
        for (int i=0;i<100000;i++){
            synchronized (this){
                counter.addTeacher();
            }
        }
    }
}