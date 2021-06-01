package 多线程;


import java.util.concurrent.CountDownLatch;


public class 三个线程顺序执行Ⅱ {

	// T1、T2、T3三个线程顺序执行
	public static void main(String[] args) {
		CountDownLatch c0 = new CountDownLatch(0); //计数器为0
		CountDownLatch c1 = new CountDownLatch(1); //计数器为1
		CountDownLatch c2 = new CountDownLatch(1); //计数器为1

		Thread t1 = new Thread(new Work(c0, c1));
		//c0为0，t1可以执行。t1的计数器减1

		Thread t2 = new Thread(new Work(c1, c2));
		//t1的计数器为0时，t2才能执行。t2的计数器c2减1

		Thread t3 = new Thread(new Work(c2, c2));
		//t2的计数器c2为0时，t3才能执行

		t1.start();
		t2.start();
		t3.start();
	}

	//定义Work线程类，需要传入开始和结束的CountDownLatch参数
	static class Work implements Runnable {

		CountDownLatch befor;

		CountDownLatch current;

		Work(CountDownLatch befor, CountDownLatch current) {
			this.befor = befor;
			this.current = current;
		}

		public void run() {
			try {
				befor.await();//前一线程为0才可以执行
				System.out.println("thread start:" + Thread.currentThread().getName());
				current.countDown();//本线程计数器减少
			} catch (InterruptedException e) {
			}
		}

	}

}
