import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadClass6 {

	public static void main(String[] args) throws Exception {
	  System.out.println("Main thread is running....");
	  
	  ExecutorService es  = Executors.newFixedThreadPool(2);
	  
	  // runnable - no need to expect result 
	  
	  es.execute(()->{new Worker().eating();});
	  
	  
	  //callable method - used to get return value
	  
	  Future<String> ft = es.submit(()->{
		  try {Thread.sleep(3000);}catch(Exception e) {}
		  return new Accountant().reportToMe();});
	  
	  String str = ft.get();
	  
	  System.out.println(str);
	  
	  es.shutdown();
	  
	  System.out.println("Main thread is still running....");
	  
	}
}


class Worker{
	public void eating() {
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("Worker is eating his breakfast");
	}
}

class Accountant{
	public String reportToMe() {
		return "No open bils to be closed....";
	}
}