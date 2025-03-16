package MultiThread;

public class FirstTask2 extends Thread {
	@Override
	
	public void run() {
		for (int i = 0;i<1000;i++) {
			System.out.print( i+"$ ");
		}
		System.out.printf("\n %s task complete",Thread.currentThread().getName());
	}
	

}
