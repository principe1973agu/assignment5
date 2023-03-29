package ethz.ch.pp.searchAndCount;

public class VersuchThread extends Thread{
ShareCounter shareCounter;
    public VersuchThread(ShareCounter shareCounter){
        this.shareCounter=shareCounter;
    }

    @Override
    public void run() {

        shareCounter.increasecounter();
        System.out.println("Numbrer is: "+shareCounter.getCounter());

    }
}
