package ethz.ch.pp.searchAndCount;

import ethz.ch.pp.util.Workload;

public class ThreadDivideAndConquer extends Thread {
    int[] input;
    Workload.Type wt;

    ThreadCounter threadCounter;
    ShareCounter shareCounter;


    public ThreadDivideAndConquer(int[] input, Workload.Type wt, ThreadCounter threadCounter, ShareCounter shareCounter) {
        this.input = input;
        this.wt = wt;

        this.threadCounter = threadCounter;
        this.shareCounter = shareCounter;


    }


    @Override
    public void run() {


        if ((input.length == 500)) {

                if (Workload.doWork(input[0], wt)) {
                    shareCounter.increasecounter();


            }

        } else {
            int middle = (int) input.length / 2;
            int[] firsthalf = new int[middle];
            int[] secondhalf = new int[middle];

            for (int i = 0; i < middle; i++) firsthalf[i] = input[i];
            int counterver = 0;
            for (int i = middle; i < input.length; i++) {
                secondhalf[counterver] = input[i];
                counterver++;
            }


            if (threadCounter.getCounter() < 5) {
                ThreadDivideAndConquer threadDivideAndConquer1 = new ThreadDivideAndConquer(firsthalf, wt, threadCounter, shareCounter);
                ThreadDivideAndConquer threadDivideAndConquer2 = new ThreadDivideAndConquer(secondhalf, wt, threadCounter, shareCounter);
                threadCounter.increasecounter();
                threadDivideAndConquer1.start();
                threadDivideAndConquer2.start();

                try {
                    threadDivideAndConquer1.join();
                    threadDivideAndConquer2.join();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            } else {
                ThreadDivideAndConquer threadDivideAndConquer1 = new ThreadDivideAndConquer(firsthalf, wt, threadCounter, shareCounter);
                ThreadDivideAndConquer threadDivideAndConquer2 = new ThreadDivideAndConquer(secondhalf, wt, threadCounter, shareCounter);
                threadDivideAndConquer1.start();
                threadCounter.increasecounter();

                try {
                    threadDivideAndConquer1.join();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                threadDivideAndConquer2.run();

            }

        }
    }
}
