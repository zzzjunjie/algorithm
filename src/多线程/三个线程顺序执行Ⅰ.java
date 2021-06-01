package 多线程;

// 如何确保三个线程顺序执行
public class 三个线程顺序执行Ⅰ {

	public static void main(String[] args) {
		Thread t1 =new Thread(new Work(null));
		Thread t2 =new Thread(new Work(t1));
		Thread t3 =new Thread(new Work(t2));

		t1.start();
		t2.start();
		t3.start();
	}

static class Work implements Runnable{

	private Thread beforThread;
	public Work(Thread beforThread){
		this.beforThread = beforThread;
	}

	@Override
	public void run() {
		if (beforThread!=null){
			try {
				beforThread.join();
				System.out.println("Thread start:"+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("Thread start:"+Thread.currentThread().getName());
		}
	}

}
}
