package dz;

public class Fork extends Thread{
    private boolean condition;
    public Philosopher leftConnect, rightConnect;
    void setPriority(){
        leftConnect.setPriority(MIN_PRIORITY);
        rightConnect.setPriority(MAX_PRIORITY);
    }
    public boolean isCondition() {
        return condition;
    }
    public void setCondition(boolean condition) {
        this.condition = condition;
    }
    public Fork(){
        if (leftConnect != null && rightConnect != null) {
            this.setPriority();
        }
    }
}

