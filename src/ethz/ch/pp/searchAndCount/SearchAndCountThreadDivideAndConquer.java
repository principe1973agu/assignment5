package ethz.ch.pp.searchAndCount;

import ethz.ch.pp.util.Workload;

import java.util.concurrent.Callable;

public class SearchAndCountThreadDivideAndConquer {
	
	public static int countNoAppearances(int[] input, Workload.Type wt, int cutOff, int numThreads)  {
		//TODO implement

		ThreadCounter threadCounter = new ThreadCounter(0);
		ShareCounter shareCounter=new ShareCounter(0);


		ThreadDivideAndConquer threadDivideAndConquer=new ThreadDivideAndConquer(input,wt,threadCounter,shareCounter);
		threadCounter.increasecounter();

		threadDivideAndConquer.start();

		try {
			threadDivideAndConquer.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		//int x=shareCounter.getCounter();

		return 0;
	}

}