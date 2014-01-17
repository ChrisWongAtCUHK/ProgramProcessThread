package demo.thread.pripority;

import static java.lang.System.out;

public class JoinExample extends Thread {
	String id;
	
	/**
	 * Constructor 
	 * @param id instance id
	 */
	public JoinExample(String id){
		this.id = id;
	}
	
	@Override
	public void run(){
		out.format("Here is the starting point of Thread.%n");
		for(int i=0; i < 500; i++){	// finite loop to print message
			out.format("%s Thread.%n", this.id);
		}
	}
	
	public static void main(String[] args){
		Thread thread1 = new JoinExample("Chris Wong");
		Thread thread2 = new JoinExample("Chris Wong is handsome");
		
		thread1.start();
		thread2.start();
		
		try{
			thread1.join();	// wait until thread1 ends
			thread2.join();	// wait until thread2 ends
		}catch (InterruptedException exception) {}
		
		for(int i = 0 ; i < 5; i++){
			out.format("Main Thread is running...%n");
		}
	}
}
