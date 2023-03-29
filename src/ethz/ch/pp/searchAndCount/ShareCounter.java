package ethz.ch.pp.searchAndCount;

public class ShareCounter {
    private int counteramount;

    public ShareCounter(int counter){
        this.counteramount=counter;
    }

    public synchronized int getCounter(){

        return counteramount;
    }
    public synchronized void increasecounter(){


        counteramount++;
    }

}
