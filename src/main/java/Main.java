public class Main {

    public static void main(String[] args) throws InterruptedException {
	    Field field = new Field(7);
        field.setAlive(0,3);
        field.setAlive(1,3);
        field.setAlive(2,3);
        field.setAlive(2,2);
        field.setAlive(1,1);
        field.liveAndOutput(10,1,System.out,Thread.currentThread());
    }
}
