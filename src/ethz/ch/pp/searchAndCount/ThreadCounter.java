package ethz.ch.pp.searchAndCount;

public class ThreadCounter {
    private int counter=0;
    public ThreadCounter(int counter){this.counter=counter;}


    public synchronized int getCounter(){
        return counter;
    }
    public synchronized void increasecounter(){

        counter++;
    }

}
