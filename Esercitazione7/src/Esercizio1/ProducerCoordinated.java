package Esercizio1;

public class ProducerCoordinated extends Thread {
	 private SimpleBufferCoordinated sbuf; 
	  private int id; 

	  public ProducerCoordinated(SimpleBufferCoordinated sb, int id) {
	       sbuf = sb;
	       this.id = id;
	   } 
	  
	  public void run(){
	      for (int i = 0; i < 10; i++) { 
	         try {
				sbuf.put(i);
			} catch (InterruptedException e1) {}
	         System.out.println("Producer #" + this.id + " put: " + i);
	         try { sleep((int)(Math.random() * 100)); } catch (InterruptedException e) {} 
	      }   
	  }
}
