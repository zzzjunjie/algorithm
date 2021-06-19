import java.lang.reflect.Method;
import java.util.concurrent.*;


public class CallMethod {

	static ExecutorService executorService = Executors.newSingleThreadExecutor();

	/***
	 * 方法参数说明
	 * @param target 调用方法的当前对象
	 * @param methodName 方法名称
	 * @param parameterTypes 调用方法的参数类型
	 * @param params 参数  可以传递多个参数
	 *
	 * */
	public static Object callMethod(final Object target, final String methodName, final Class<?>[] parameterTypes, final Object[] params) {

		FutureTask<String> future = new FutureTask<>(() -> {
			String value = null;
			try {
				Method method = null;
				method = target.getClass().getDeclaredMethod(methodName, parameterTypes);

				Object returnValue = method.invoke(target, params);
				value = returnValue != null ? returnValue.toString() : null;
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return value;
		});

		executorService.execute(future);
		String result = null;
		try {
			/**获取方法返回值 并设定方法执行的时间为10秒*/
			result = future.get(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			future.cancel(true);
			System.out.println("方法执行中断");
		} catch (ExecutionException e) {
			future.cancel(true);
			System.out.println("Excuti on异常");
		} catch (TimeoutException e) {
			future.cancel(true);
			System.out.println("invoke timeout");
		}
		// executorService.shutdownNow();
		return result;
	}

	public Object call(Integer id) {
		try {
			Thread.sleep(11111);
		} catch (Exception e) {
		}
		return id;
	}

	public Object call2(Integer id) {
		try {
			Thread.sleep(1);
		} catch (Exception e) {
		}
		return id;
	}

	public static void main(String[] args) {
		System.out.println(callMethod(new CallMethod(), "call", new Class<?>[] { Integer.class }, new Object[] { 1523 }));
		System.out.println(callMethod(new CallMethod(), "call2", new Class<?>[] { Integer.class }, new Object[] { 1523 }));
	}

}
