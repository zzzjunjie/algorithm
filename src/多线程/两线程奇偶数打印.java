package 多线程;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


// 两线程奇偶数打印
public class 两线程奇偶数打印 {
	private static int value = 0;
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition con1 = lock.newCondition();
		Condition con2 = lock.newCondition();

		// A
		new Thread(()->{
			try {
				lock.lock();
				while (value<=100){
					System.out.println(Thread.currentThread().getName()+" "+value++);
					con2.signal();
					con1.await();
				}
				con2.signal();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		},"A").start();

		// B
		new Thread(()->{
			try {
				lock.lock();
				while (value<=100){
					System.out.println(Thread.currentThread().getName()+" "+value++);
					con1.signal();
					con2.await();
				}
				con1.signal();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		},"B").start();
	}
}
