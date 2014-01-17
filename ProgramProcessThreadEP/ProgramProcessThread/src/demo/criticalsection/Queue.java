package demo.criticalsection;

public class Queue {
    private Object[] data;
    private int size;
    private int head;
    private int tail;
    public Queue(int maxLen) {
        data = new Object[maxLen];
    }
    public synchronized Object deQueue() throws Exception {
        if (size == 0) {
            throw new Exception();
        }
        Object tmp = data[head];
        data[head] = null;
        head = (head+1)%data.length;
        size--;
        return tmp;
    }
    
    public synchronized void enQueue(Object c) throws Exception {
        if (size >= data.length) {
            throw new Exception();
        }
        data[tail++] = c;
        tail %= data.length;
        size++;
    }
    
}