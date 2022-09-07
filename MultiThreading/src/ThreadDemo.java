import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadDemo {
     
	  public static void main(String[] args) {
		new MakeBriyani().makeBriyani();
	}

}

class MakeBriyani{
	
	void makeBriyani () {
		  ExecutorService es = Executors.newFixedThreadPool(3);
		  es.execute(()->{
			 Thread.currentThread().setName("Master"); 
			 new CookRice().cookrice();
			 new MixAndMakeBriyani().mixing();
		  });
		  es.execute(()->{
				 Thread.currentThread().setName("labour 1"); 
				 new CutVeg().cutveg();
			  });
		  es.execute(()->{
				 Thread.currentThread().setName("labour 2"); 
				 new CookCurry().curry();
			  });
		  es.shutdown();
		
		
	}
}

class CutVeg{
	public void cutveg() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name + " is inside the kitchen to cut vegetables ");
		try {
			Thread.sleep(7000);
		}catch(Exception e) {}
		System.out.println(name + " left the kitchen --- Vegetables ready ");
	}
}

class CookRice{
	public void cookrice() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name + " is inside the kitchen to boil rice ");
		try {
			Thread.sleep(8000);
		}catch(Exception e) {}
		System.out.println(name + " left the kitchen --- briyani rice ready ");
	}
}
class CookCurry{
	public void curry() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name + "is inside the kitchen to make briyani curry ");
		try {
			Thread.sleep(9000);
		}catch(Exception e) {}
		System.out.println(name + " left the kitchen --- curry ready ");
	}
}

class MixAndMakeBriyani{
	public void mixing() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		try {
			Thread.sleep(15000);
		}catch(Exception e) {}
		System.out.println(name + " is inside the kitchen to mix ");
		
		System.out.println(name + " left the kitchen --- briyani ready ");
	}
}