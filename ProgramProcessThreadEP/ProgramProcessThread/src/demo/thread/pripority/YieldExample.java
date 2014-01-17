package demo.thread.pripority;

import static java.lang.System.out;

/**
 * @author Chris Wong
 *
 */
public class YieldExample extends Thread {
	@Override
	public void run(){
		out.format("Here is the starting point of Thread.%n");
		for(;;){	// infinite loop to print message
			out.format("Chris Wong Created Thread.%n");
			yield();
		}
	}
	
	public static void main(String[] args){
		Thread thread = new YieldExample();
		thread.start();
		for(;;){
			out.format("Main Thread is runnng...%n");
			yield();
		}
	}

}
