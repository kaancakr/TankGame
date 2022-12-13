import java.awt.Color;
import java.awt.*;

public class Player2Bullet extends Gameplay{
    private double x, y;

    public Player2Bullet(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void move(String face)
    {
        if(face.equals("right"))
            x += 5;
        else if(face.equals("left"))
            x -= 5;
        else if(face.equals("up"))
            y -= 5;
        else
            y +=5;
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.fillOval((int) x, (int) y, 10, 10);
    }

    public int getX()
    {
        return (int)x;
    }
    public int getY()
    {
        return (int)y;
    }

}

