import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadClass3 {
	
	ThreadClass3(){
		ExecutorService es = Executors.newFixedThreadPool(1);
		//es.execute(new MyRunnable());
		es.execute(()->{System.out.println("child thread logic");});
		es.shutdown();
		
	}

	public static void main(String[] args) {
		// old approach of creating a thread
		
		new ThreadClass3(); // here as soon as object is created constructor will be called but child thread won't trigger until and unless main thread finish off or interrupted
		
		System.out.println("Main thread called....");

	}

}
