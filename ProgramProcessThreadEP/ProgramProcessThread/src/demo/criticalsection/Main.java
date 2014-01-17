package demo.criticalsection;

public class Main {
    public static void main(String[] argv) {
        Queue q = new Queue(10);
        Getter r1 = new Getter(q);
        Getter r2 = new Getter(q);
        Putter w1 = new Putter(q);
        Putter w2 = new Putter(q);
        r1.start();
        r2.start();
        w1.start();
        w2.start();
    }
}