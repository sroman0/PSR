package Esercizio1;



class PrinterR implements Runnable{
	private String message;
	
	public PrinterR(String message) {
		this.message=message;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=100;i++) {
			System.out.println(i+" "+message);
		}
	}
	
}
public class PrinterTestRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread p1=new Thread(new PrinterR("Thread 1"));
		Thread p2=new Thread(new PrinterR("Thread 2"));
		p1.start();
		p2.start();
		System.out.println("Main terminated");
	}

}
