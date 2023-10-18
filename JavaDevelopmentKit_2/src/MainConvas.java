import javax.swing.*;
import java.awt.*;

public class MainConvas extends JFrame {
    private final MainWindow controller;
    private long lastFrameTime;
    MainConvas(MainWindow controller){
        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }
    @Override
    public void paintComponents(Graphics g) {// do
        super.paintComponents(g);    // something
        //controller.onDrawFrame();    // useful
        try {                        // sleep
            Thread.sleep(16);  // 16 ms
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();
        repaint();                   // while (true)
    }
    public int getLeft(){
        return 0;
    }
    public int getRight(){
        return getWidth() - 1;
    }
    public int getTop(){
        return 0;
    }
    public int getBottom(){
        return getHeight() - 1;
    }
}
