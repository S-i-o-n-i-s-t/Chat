package dz;

public class RoundTable extends Thread{
    private final String[] names = {"1 Философ Василий","2 Философ Игорь","3 Философ Павел","4 Философ Максим","5 Философ Анатолий"};
    private final int numberPersons = 5;
    private Philosopher philosopherHead;
    private Philosopher start;
    private Fork forkHead;
    public RoundTable() {
    }
    public void addPhilosopher(String name){
        if (philosopherHead != null){
            Philosopher philosopherTail = philosopherHead;
            Fork fork = forkHead;
            philosopherHead = new Philosopher(name);
            forkHead = new Fork();
            philosopherTail.right = fork;
            philosopherHead.left = fork;
            philosopherHead.right = forkHead;
            fork.rightConnect = philosopherHead;
            fork.leftConnect = philosopherTail;
            forkHead.leftConnect = philosopherHead;
        }
        else {
            philosopherHead = new Philosopher(name);
            forkHead = new Fork();
            philosopherHead.right = forkHead;
            forkHead.leftConnect = philosopherHead;
            start = philosopherHead;
        }
    }
    public void generateTable(){
        for (int i = 0; i < numberPersons ; i++){
            addPhilosopher(names[i]);
        }
        round();
    }
    public void round(){
        forkHead.rightConnect = start;
        start.left = forkHead;
    }
    public synchronized void goReuod(){
        for (int i = 0; i < numberPersons ; i++){
            philosopherHead.start();
            philosopherHead = forkHead.rightConnect;
            forkHead = philosopherHead.right;
        }
    }
}
