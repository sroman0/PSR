package Esercizio1;

public class ProducerNotCoordinated extends Thread {
	private SimpleBufferNotCoordinated sbuf; 
	  private int id; 

	  public ProducerNotCoordinated(SimpleBufferNotCoordinated sb, int id) {
	       sbuf = sb;
	       this.id = id;
	   } 
	  
	  public void run() {
	      for (int i = 0; i < 10; i++) { 
	         sbuf.put(i);
	         System.out.println("Producer #" + this.id + " put: " + i);
	         try { sleep((int)(Math.random() * 100)); } catch (InterruptedException e) {} 
	      }   
	  }

}
