package com.zc.bar.domain;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PutTogetherProcedure {

    /**
     * 零件个数
     */
    private static final Integer QUANTITY_OF_COMPONENT = 6;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(QUANTITY_OF_COMPONENT);
        CountDownLatch countDownLatch = new CountDownLatch(QUANTITY_OF_COMPONENT);
        for (int i = 0; i < QUANTITY_OF_COMPONENT; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    System.out.println("组装第" + finalI + "个零件");
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("chair sale");
    }

}
