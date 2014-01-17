package demo.criticalsection;

public class Putter extends Thread {
    Queue q;
    private int data;
    public Putter(Queue q) {
        this.q = q;
        data = 0;
    }
    public void run() {
        for (;;) {
            try {
                Object data = this.data;
                // get user request
                 q.enQueue(data);
                 
                 this.data = (this.data + 1) % 100;
            } catch(Exception e) {
                // if we try to sleep here, user may feel slow response
                // if we do not sleep, CPU will be wasted
            }
        }
    }
}