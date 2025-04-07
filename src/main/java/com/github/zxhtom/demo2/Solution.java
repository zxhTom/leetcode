package com.github.zxhtom.demo2;

/**
 * TODO
 *
 * @author zxhtom
 * 2025/4/2
 */

public class Solution {

    private final int maxCount; // 最大数字
    private static int num =1 ;
    private static final Object lock = new Object();
    public Solution(int maxCount) {
        this.maxCount = maxCount;
    }

    // 开启两个线程分别打印奇数和偶数
    public void start() throws InterruptedException {
        // 线程 OddThread 调用 printOdd();
        Thread oddThread = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "OddThread");

        // 线程 EvenThread 调用 printEven();
        Thread evenThread = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "EvenThread");

        // 启动两个线程
        oddThread.start();
        evenThread.start();

        // 等待子线程执行完成
        oddThread.join();
        evenThread.join();
    }

    public void printOdd() throws InterruptedException {
        synchronized (lock) {
            while (num <= maxCount) {
                if (num % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() +"-"+ num++);
                    lock.notify();
                } else {
                    lock.wait();
                }
            }
        }

    }

    public void printEven() throws InterruptedException {
        synchronized (lock) {
            while (num <= maxCount) {
                if (num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() +"-"+ num++);
                    lock.notify();
                } else {
                    lock.wait();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution(10);
        solution.start();
    }
}
