package Esercizio1;

public class SimpleBufferNotCoordinated {
	 private int buf;
	   
	   public int get() {
	       return buf;
	   }
	   public void put (int value) {
	       buf = value;
	   }
}
