package demo.thread.pripority;

import static java.lang.System.out;

/**
 * @author Chris Wong
 *
 */
public class SleepExample extends Thread {
	String id;
	
	public SleepExample(String id){
		this.id = id;
	}
	
	@Override
	public void run(){
		for(int i = 0; i < 500; i++){
			out.format("%s Thread%n", this.id);
		}
		try {
			sleep(100);
		} catch (InterruptedException ie) {}
	}

	public static void main(String[] args){
		Thread thread1 = new SleepExample("Chris Wong");
		Thread thread2 = new SleepExample("Chris Wong is handsome");
		
		thread1.start();
		thread2.start();
	}
}
