package demo.criticalsection;

import static java.lang.System.out;

public class Getter extends Thread {
    Queue q;
    public Getter(Queue q) {
        this.q = q;
    }
    public void run() {
        for (;;) {
            try {
                Object data = q.deQueue();
                // processing
                out.format("data:%s %n", data);
            } catch(Exception e) {
                // if we try to sleep here, user may feel slow response
                // if we do not sleep, CPU will be wasted
            }
        }
    }
}