package MultiThread;

public class TestRunnable {
	public static void main(String... args) {
		FirstTask4 p1 = new FirstTask4();
		FirstTask5 p2 = new FirstTask5();
		FirstTask6 p3 = new FirstTask6();
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		t1.start();
		t2.start();
		t3.start();

	}

}
