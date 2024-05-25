package Esercizio1;

public class ConsumerNotCoordinated extends Thread {
	 private SimpleBufferNotCoordinated sbuf;
	    private int id;

	    public ConsumerNotCoordinated(SimpleBufferNotCoordinated sb, int id) {
	        sbuf = sb;
	        this.id = id;
	    }

	    public void run() {
	        int value = 0;
	        for (int i = 0; i < 10; i++) {
	            value = sbuf.get();
	            System.out.println("Consumer #" + this.id + " got: " + value);
	            try { sleep((int)(Math.random() * 100)); } catch (InterruptedException e) { }
	        }
	    }  
}
