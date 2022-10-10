package com.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        //周末3人聚会，需要等待3个人全部到齐餐厅后才能开始吃饭
        CyclicBarrier cb = new CyclicBarrier(3);
        System.out.println("初始化：有" + (3 - cb.getNumberWaiting()) + "个人正在赶来餐厅");
        for (int i = 0; i < 3; i++) {   //定义3个任务，即3个人从家里赶到餐厅
            //设置用户的编号
            final int person = i;
            executor.execute(() -> {    //lambda表达式
                try {
                    //此处睡眠，模拟3个人从家里来到餐厅所花费的时间
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println(Thread.currentThread().getName() + "---用户" + person + "即将达到餐厅," +
                            "用户" + person + "到达餐厅了。" + "当前已有" + (cb.getNumberWaiting() + 1) + "个人到达餐厅");
                    cb.await();
                    System.out.println("三个人都到到餐厅啦，" + Thread.currentThread().getName() + "开始吃饭了");
                    //todo 吃完饭后想去网吧开黑  这里具体代码我就不写啦  留给小伙伴自己实现 >.<
                    //再次wait(),等待3个人全部到达网吧  cb是可以复用的！
                    cb.await();
                    //3个人都到达网吧了，开始玩游戏 playGame()...
                    System.out.println(Thread.currentThread().getName() + "---用户" + person + "即将达到餐厅," +
                            "用户" + person + "到达餐厅了。" + "当前已有" + (cb.getNumberWaiting() + 1) + "开始玩游戏");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();    //关闭线程池
    }
}

