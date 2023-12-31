package dz;

import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread{
    private final String NAME;
    private int portion;
    private boolean pause;
    private CountDownLatch cdl;
    public Fork rightFork, leftFork;
    private final int satiety = 3;
    public Philosopher(String name, CountDownLatch cdl) {
        this.NAME = name;
        this.cdl = cdl;
    }
    public synchronized void distributionOfActions(){
        if (!rightFork.isCondition() && !leftFork.isCondition() && !pause){
            eating();
        }else {
            thinking();
        }
    }
    public void eating(){
        rightFork.setCondition(true);
        leftFork.setCondition(true);
        System.out.println(NAME + " - ест");
        portion++;
        pause = true;
        if (this.portion == satiety){
            cdl.countDown();
        }
    }
    public void thinking(){
        rightFork.setCondition(false);
        leftFork.setCondition(false);
        pause = false;
        System.out.println(NAME + " - размышляет");
    }
    @Override
    public String toString() {
        return NAME;
    }
    @Override
    public void run() {
        while (cdl.getCount() != 0){
            if (this.portion != satiety){
                distributionOfActions();
            }else {
                thinking();
            }
            try { sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

