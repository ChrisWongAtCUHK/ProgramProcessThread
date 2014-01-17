package demo.thread;

import static java.lang.System.out;

/**
 * @author Chris Wong
 *
 */
public class ThreadExample1 extends Thread {
	@Override
	public void run(){
		out.format("Here is the starting point of Thread.%n");
		for(;;){	// infinite loop to print message
			out.format("Chris Wong Created Thread.%n");
		}
	}
	
	public static void main(String[] args){
		Thread thread = new ThreadExample1();
		thread.start();
		for(;;){
			out.format("Main Thread is running...%n");
		}
	}
}
