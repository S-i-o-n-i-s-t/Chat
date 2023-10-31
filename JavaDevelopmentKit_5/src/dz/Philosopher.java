package dz;

public class Philosopher extends Thread{
    private final String name;
    private int portion;
    private boolean pause;
    public Fork right, left;
    private final int satiety = 3;
    public Philosopher(String name) {
        this.name = name;
    }
    public void thinking(){
        right.setCondition(true);
        left.setCondition(true);
        System.out.println(name + " - ест");
        portion++;
        pause = true;
    }
    public void eating(){
        right.setCondition(false);
        left.setCondition(false);
        pause = false;
        System.out.println(name + " - размышляет");
    }

    @Override
    public String toString() {
        return name;
    }
    @Override
    public void run() {
        while (this.portion != satiety){
            if (!right.isCondition() && !left.isCondition() && !this.pause){
                thinking();
            }
            else {eating();}
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
