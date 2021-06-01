package 多线程;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


// 启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10。直到75
public class 打印递增的数字 {

	private static int value = 1;

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition conA = lock.newCondition();
		Condition conB = lock.newCondition();
		Condition conC = lock.newCondition();

		// A
		new Thread(() -> {
			try {
				lock.lock();
				while (value<=75){
					for (int i = 0; i < 5; i++) {
						System.out.print(value++ + " ");
					}
					conB.signal();
					conA.await();
				}
				conB.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}, "A").start();

		// A
		new Thread(() -> {
			try {
				lock.lock();
				while (value<=75){
					for (int i = 0; i < 5; i++) {
						System.out.print(value++ + " ");
					}
					conC.signal();
					conB.await();
				}
				conC.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}, "B").start();

		// C
		new Thread(() -> {
			try {
				lock.lock();
				while (value<=75){
					for (int i = 0; i < 5; i++) {
						System.out.print(value++ + " ");
					}
					conA.signal();
					conC.await();
				}
				conA.signal();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}, "C").start();
	}

}
