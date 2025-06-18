package com.zc.bar.domain;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 泡完6杯咖啡后吃午餐
 */
public class CoffeeMake {

    /**
     * 人数
     */
    private static final Integer STUFF_COUNT = 3;

    /**
     * 泡一杯咖啡需要的步骤
     */
    private static final Integer STEP_COUNT = 3;

    /**
     * 6杯咖啡
     */
    private static final Integer COFFEE_COUNT = 6;

    public static void main(String[] args) throws InterruptedException {
        // 工作总量
        int workNums = STEP_COUNT * COFFEE_COUNT;
        ExecutorService executorService = Executors.newFixedThreadPool(workNums);
        Semaphore semaphore = new Semaphore(STUFF_COUNT);
        CountDownLatch countDownLatch = new CountDownLatch(workNums);
        for (int i = 0; i < workNums; i++) {
            final int workIndex = i;
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("店员开始第" + workIndex + "part任务！");
                    Thread.sleep((long)(Math.random() * 1000));
                    System.out.println("店员完成了第" + workIndex + "part任务！");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("店员在享受午餐");
    }
}
