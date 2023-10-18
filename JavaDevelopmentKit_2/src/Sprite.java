import java.awt.*;

public abstract class Sprite {
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeidht;

    protected float getLeft(){return x - halfWidth;}
    protected void setLeft(float left){x = left + halfWidth;}
    protected float getRight(){return x + halfWidth;}
    protected void setRight(float right){x = right - halfWidth;}
    protected float getTop(){return y - halfHeidht;}
    protected void setTop(float top){y = top + halfHeidht;}
    protected float getBottom(){return y + halfHeidht;}
    protected void setBottom(float bottom){ y = bottom - halfHeidht;}

    protected float getWidth(){return 2f * halfWidth;}
    protected float getHeidht(){return 2f * halfHeidht;}

    void update(MainConvas convas, float deltaTime){}
    void render(MainConvas convas, Graphics g){}
}





































































































