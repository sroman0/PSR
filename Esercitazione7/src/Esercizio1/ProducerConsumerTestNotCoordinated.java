package Esercizio1;

public class ProducerConsumerTestNotCoordinated {
	public static void main(String[] args) {
        SimpleBufferNotCoordinated sb = new SimpleBufferNotCoordinated();
        ProducerNotCoordinated p1 = new ProducerNotCoordinated(sb, 1);
        ConsumerNotCoordinated c1 = new ConsumerNotCoordinated(sb, 1);
        p1.start();
        c1.start();
    }  
}
