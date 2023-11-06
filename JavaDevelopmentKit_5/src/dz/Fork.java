package dz;

public class Fork{
    private boolean condition;
    public Philosopher leftConnect, rightConnect;
    public boolean isCondition() {
        return condition;
    }
    public void setCondition(boolean condition) {
        this.condition = condition;
    }
    public Fork(){
    }
}

