import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Sprite[] sprites = new Sprite[10];
    public MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Circles");
        for (int i = 0; i < sprites.length; i++){
            sprites[i] = new Ball();
        }
        MainConvas convas = new MainConvas(this);
        add(convas);
        setVisible(true);
    }
    public void onDrawFrame(MainConvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }
    public void update(MainConvas convas, float deltaTime){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].update(convas, deltaTime);
        }
    }
    public void render(MainConvas convas, Graphics g){
        for (int i = 0; i < sprites.length; i++){
            sprites[i].render(convas, g);
        }
    }

}











































