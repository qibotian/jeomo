package com.jeomo.mem.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: qbt
 * @Date: 2020/2/28 16:20
 * @Version 1.0
 */
@Service
public class OrderInitServer {
    private static final Logger log = LoggerFactory.getLogger(OrderInitServer.class);

    public static final int THREAD_NUM = 50;

    private static int mobile = 181000000;

    public void generateMultiThread() {
        log.info("开始初始化线程数");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i = 0; i < THREAD_NUM; i++) {
            new Thread(new RunThread(countDownLatch)).start();
        }
        countDownLatch.countDown();
    }

    @Autowired
    private CommonMqService commonMqService;

    private class RunThread implements Runnable {

        private  CountDownLatch latch;

        RunThread(CountDownLatch latch) {
            super();
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
                mobile += 1;
                commonMqService.sendRabbitMsg(String.valueOf(mobile));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
