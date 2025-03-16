package MultiThread;

public class TestThread {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		FirstTask t1 = new FirstTask();
		FirstTask2 t2 = new FirstTask2();
		FirstTask3 t3 = new FirstTask3();
		t1.start();
		t2.start();
		t3.start();
		long endTime = System.currentTimeMillis();
		System.out.printf("\n %s total time taken %d",Thread.currentThread().getName(),(startTime - endTime));

	}

}
