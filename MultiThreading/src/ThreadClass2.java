
public class ThreadClass2 {
	
	ThreadClass2(){
		Thread t = new Thread(new MyRunnable()); // creating a new thread and associating a job to that thread
		t.start();
	}

	public static void main(String[] args) {
		// old approach of creating a thread
		
		new ThreadClass2(); // here as soon as object is created constructor will be called but child thread won't trigger until and unless main thread finish off or interrupted
		
		System.out.println("Main thread called....");

	}

}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("job of child thread is called...");
	}
}