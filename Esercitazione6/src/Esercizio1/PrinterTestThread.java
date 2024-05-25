/**
 * 
 */
package Esercizio1;

/**
 * 
 */
class Printer extends Thread{
	private String message;
	
	public Printer(String message) {
		this.message=message;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			System.out.println(i + " " + message);
		}
	}
}
public class PrinterTestThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Printer p1=new Printer("Thread 1");
			Printer p2=new Printer("Thread 2");
			p1.start();
			p2.start();
			System.out.println("Main terminated");
	}

}
