import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		met1();
//		met2();
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(()->{met2();});
		es.shutdown();
		met3();
	}
	
	static void met1() {
		System.out.println("met1 called...");
	}
	static void met2() {
		System.out.println("met2 called...");
		try {
			Thread.sleep(5000); //5seconds delay
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	static void met3() {
		System.out.println("met3 called...");
	}
}
