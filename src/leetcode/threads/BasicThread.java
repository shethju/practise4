package leetcode.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasicThread {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// java thread <-> creates system os thread hence its expensive. So instead of creating thousand
		// threads, we create threadpool and submit tasks to it
		for (int i=0; i < 10; i++) {
			Thread t1 = new Thread(new Task());
			t1.start();
		}
		// more better method. Threadpool uses blocking queue since it is thread safe.
		// How many threads we should have. Number of cpu core = number of threads since each java thread
		// is a OS level thread. If give more threads, it will create timeslicing which is more ineffficient.
		// this logic is good for cpu intensive tasks. If OS is running other applications, we may still not
		// get access to all cores.
		// IO intensive calls - db calls, http calls, network calls, then can have large thread pool since.
		// Too many threads increases memory consumption
		int coreCount = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		ExecutorService service2 = Executors.newCachedThreadPool();// Note it doesnt take no of threds since
		// we dont control it.
		for (int i=0; i < 10; i++) {
			service.execute(new Task());
		}
		System.out.println("threadname: " + Thread.currentThread().getName());
		
		// Using future/callable
		Future<Integer> future = service.submit(new Task2());
		try {
			Integer result = future.get(); // Note this is a blocking call. Till future has a value we will wait
			future.get(100, TimeUnit.MILLISECONDS); // throws timeoutexception if cant get result in simulated time
			/*
			 * Other options:
			 * future.cancel(false); // cancel the task. doesnt cancel if started
			 * 	future.isCancelled(); // if class is cancelled or not
			 *  future.isDone();// task completed successfully or otherwise
			 */
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Task implements Runnable {
	// put the code that you want to run asynchronously
	public void run() {
		System.out.println("threadname: " + Thread.currentThread().getName());
	}
}

class Task2 implements Callable<Integer> {
	public Integer call() throws Exception {
		return new Integer(1);
	}
}

/*
 * Types of thread pool
 * 1. fixedthreadpool - has fixed threads and has a queue to hold the tasks
 * 2. cachedthreadpool - only 1 task is submitted. if all threads are busy it creates new thread and adds to pool
 *                       for 60s if thread is idle for 60s the thread is killed
 * 3. scheduledthreadpool - schedule, scheduleatfixedinterval
 * 4. singlethreadexecutor - single thread. thread gets recreated if killed. used if want to run tasks sequentially
 */ 
