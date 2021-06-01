package 多线程;

// 一个多线程的问题，用三个线程，顺序打印字母A-Z，输出结果是1A 2B 3C 1D 2E…打印完毕最后输出一个Ok。
public class ABCD {

	private static char c = 'A';
	private static int i = 0;

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				synchronized (this){
					int id = Integer.parseInt(Thread.currentThread().getName());
					while (i < 26){
						if (i % 3 == id - 1){
							System.out.println(id+""+c++);
							i++;
							notifyAll();
						}else{
							try {
								wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};

		new Thread(runnable,"1").start();
		new Thread(runnable,"2").start();
		new Thread(runnable,"3").start();
	}
}
