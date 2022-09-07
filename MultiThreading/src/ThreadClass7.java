import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadClass7 {
   
	 public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Building lic = new Building();
		es.execute(()->{
			Thread.currentThread().setName("Raju");
			//object lock
			synchronized (lic.rc) {
				lic.rc.useToilet();
			}
			
		});
		es.execute(()->{
			Thread.currentThread().setName("Saju");
			synchronized (lic.rc) {
				lic.rc.useToilet();
			}
		});
		es.shutdown();
	}
	
}

class Building{
	RestRoom rc = new RestRoom();
}
class RestRoom{
	public void useToilet() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name+" is inside the toilet...");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(name+" left the toilet");
		
	}
}