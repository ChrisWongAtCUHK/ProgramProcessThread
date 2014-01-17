package demo.criticalsection;

import static java.lang.System.out;

/**
 * @author Chris Wong
 *
 */
public class Transfer extends Thread {
	public static Object lock = new Object();
	public static int A = 1000;
	public static int B = 0;
	private int amount;
	
	public Transfer(int amount){
		this.amount = amount;
	}

	@Override
	public void run(){
		synchronized (lock) {	// get the lock, if other thread have got it, the current thread will wait until the lock is released
			if(A >= this.amount){
				A -= this.amount;
				B += this.amount;
			}
			out.format("A = %d %n", A);
			out.format("B = %d %n", B);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread1 = new Transfer(100);
		Thread thread2 = new Transfer(200);
		
		thread1.start();
		thread2.start();
	}

}
