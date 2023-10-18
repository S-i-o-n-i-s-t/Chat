import java.awt.*;
import java.util.Random;

public class Ball extends Sprite{
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    public Ball() {
        halfHeidht = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeidht;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    @Override
    void render(MainConvas convas, Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeidht());
    }

    @Override
    void update(MainConvas convas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if (getLeft() < convas.getRight()){
            setLeft(convas.getLeft());
            vX = -vX;
        }
        if (getRight() > convas.getRight()){
            setRight(convas.getRight());
            vX = -vX;
        }
        if (getTop() < convas.getTop()){
            setTop(convas.getTop());
            vY = -vY;
        }
        if (getBottom() > convas.getBottom()){
            setBottom(convas.getBottom());
            vY = -vY;
        }


    }
}
