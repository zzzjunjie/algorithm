package 多线程;

import java.util.concurrent.CountDownLatch;

public class main {
    public static void main(String[] args) {
        Foo foo = new Foo();
        CountDownLatch c1 = new CountDownLatch(0);
        CountDownLatch c2 = new CountDownLatch(1);
        CountDownLatch c3 = new CountDownLatch(1);

        new Thread(() -> {
            try {
                c1.await();
                foo.first();
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "A").start();

        new Thread(() -> {
            try {
                c2.await();
                foo.second();
                c3.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                c3.await();
                foo.third();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C").start();
    }
}
