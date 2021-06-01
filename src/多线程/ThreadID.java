package 多线程;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


// 每个线程把自己的ID在屏幕上打印10遍，要求输出结果必须按ABC的顺序显示
public class ThreadID {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition conA = lock.newCondition();
		Condition conB = lock.newCondition();
		Condition conC = lock.newCondition();

		// A
		new Thread(()->{
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					System.out.print(Thread.currentThread().getName());
					conB.signal();
					conA.await();
				}
				conB.signal();
			}catch (Exception e){

			}finally {
				lock.unlock();
			}
		},"A").start();

		// B
		new Thread(()->{
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					System.out.print(Thread.currentThread().getName());
					conC.signal();
					conB.await();
				}
				conC.signal();
			}catch (Exception e){

			}finally {
				lock.unlock();
			}
		},"B").start();

		// C
		new Thread(()->{
			try {
				lock.lock();
				for (int i = 0; i < 10; i++) {
					System.out.print(Thread.currentThread().getName());
					conA.signal();
					conC.await();
				}
				conA.signal();
			}catch (Exception e){

			}finally {
				lock.unlock();
			}
		},"C").start();
	}
}
