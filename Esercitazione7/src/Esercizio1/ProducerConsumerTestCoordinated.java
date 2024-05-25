package Esercizio1;

public class ProducerConsumerTestCoordinated {
	public static void main(String[] args) {
        SimpleBufferCoordinated sb = new SimpleBufferCoordinated();
        ProducerCoordinated p1 = new ProducerCoordinated(sb, 1);
        ConsumerCoordinated c1 = new ConsumerCoordinated(sb, 1);
        p1.start();
        c1.start();
    }  
}
