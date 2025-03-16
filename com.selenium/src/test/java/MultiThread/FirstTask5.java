package MultiThread;

public class FirstTask5 implements Runnable {
	@Override
	public void run() {
		for (int i = 0;i<1000;i++) {
			System.out.print(i+"d ");
		}
		System.out.printf("\n %s task complete",Thread.currentThread().getName());
	}
	

}
