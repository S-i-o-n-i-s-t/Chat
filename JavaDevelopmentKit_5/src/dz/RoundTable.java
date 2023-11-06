package dz;

import java.util.concurrent.CountDownLatch;

public class RoundTable extends Thread{
    private final String[] NAMES = {"1 Философ Василий","2 Философ Игорь","3 Философ Павел","4 Философ Максим","5 Философ Анатолий"};
    private final int NUMBER_PERSONS = 5;
    private final CountDownLatch CDL = new CountDownLatch(NUMBER_PERSONS);
    private Philosopher philosopherHead;
    private Philosopher philosopherTail;
    private Fork forkHead;
    public RoundTable() {
    }
    public void addPhilosopher(String name){
        if (philosopherHead != null){
            Philosopher philosopherTail = philosopherHead;
            Fork fork = forkHead;
            philosopherHead = new Philosopher(name, CDL);
            forkHead = new Fork();
            philosopherTail.rightFork = fork;
            philosopherHead.leftFork = fork;
            philosopherHead.rightFork = forkHead;
            fork.rightConnect = philosopherHead;
            fork.leftConnect = philosopherTail;
            forkHead.leftConnect = philosopherHead;
        }
        else {
            philosopherHead = new Philosopher(name, CDL);
            forkHead = new Fork();
            philosopherHead.rightFork = forkHead;
            forkHead.leftConnect = philosopherHead;
            philosopherTail = philosopherHead;
        }
    }
    public void generateTable(){
        for (int i = 0; i < NUMBER_PERSONS; i++){
            addPhilosopher(NAMES[i]);
            if (i % 2 == 0){
                philosopherHead.setPriority(MIN_PRIORITY);
            }
            else {
                philosopherHead.setPriority(MAX_PRIORITY);
            }
        }
        philosopherTail.setPriority(NORM_PRIORITY);
        round();
    }
    public void round(){
        forkHead.rightConnect = philosopherTail;
        philosopherTail.leftFork = forkHead;
    }
    public synchronized void goReuod(){
        for (int i = 0; i < NUMBER_PERSONS; i++){
            philosopherHead.start();
            philosopherHead = forkHead.rightConnect;
            forkHead = philosopherHead.rightFork;
        }
    }
}
