import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadClass4 {
	
	ThreadClass4(){
		ExecutorService es = Executors.newFixedThreadPool(1);
		//es.execute(new MyRunnable());
		es.execute(()->{System.out.println("child thread logic");});
		es.shutdown();
		
	}

	public static void main(String[] args) {
		// old approach of creating a thread
		
		new ThreadClass4(); // here as soon as object is created constructor will be called but child thread won't trigger until and unless main thread finish off or interrupted
		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread called....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
