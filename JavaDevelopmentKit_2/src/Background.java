import java.awt.*;

public class Background extends Sprite{
    public float time;
    public static final float AMPLITUDE = 255f / 2f;
    private Color color;

    @Override
    void update(MainConvas convas, float deltaTime) {
        time += deltaTime;
        int red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        int green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time *32f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        color = new Color(red, green, blue);
    }

    @Override
    void render(MainConvas convas, Graphics g) {
        convas.setBackground(color);
    }
}
