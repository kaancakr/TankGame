import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class brick {
    int bricksXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
                        250,50,100,150,550,250,350,450,550,50,250,350,550,
                        50,150,250,300,350,550,50,150,250,350,450,550,50,
                        250,350,550,600,400,350,350,300,200,150,100,450,700,
                        700,700,700,700,650,650,700,700,750,750,800,850,850,800,850,900,950,1000,900,900,850};

    int bricksYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
                        300,300,300,300,350,350,350,350,400,400,400,400,450,
                        450,450,450,450,450,500,500,500,500,500,500,550,550,
                        550,550,650,650,650,600,650,650,650,650,250,250,200,
                        150,100,50,350,400,500,550,100,300,300,300,450,650,650,650,600,550,450,400,350};

    int solidBricksXPos[] = {150,350,150,500,450,300,600,400,350,200,0,200,
            500,600,300,300,300,550,500,250,250,350,700,700,650,800,850,850,850,850,900,750,800,850,700,750};

    int solidBricksYPos[] = {0,0,50,100,150,200,200,250,300,350,400,400,450,
            550,600,550,500,650,650,650,600,250,300,350,550,100,0,50,100,250,200,500,500,500,600,650};

    int brickON[] = new int[73];

    private ImageIcon breakBrickImage;
    private ImageIcon solidBrickImage;
  


    public brick()
    {
        breakBrickImage=new ImageIcon("assets/break_brick.jpg");
        solidBrickImage=new ImageIcon("assets/solid_brick.jpg");


        for(int i=0; i< brickON.length;i++)
        {
            brickON[i] = 1;
        }
    }

    public void draw(Component c, Graphics g)
    {
        for(int i=0; i< brickON.length;i++)
        {
            if(brickON[i]==1)
            {
                breakBrickImage.paintIcon(c, g, bricksXPos[i],bricksYPos[i]);
            }
        }
    }

    public void drawSolids(Component c, Graphics g)
    {
        for(int i=0; i< solidBricksXPos.length;i++)
        {
            solidBrickImage.paintIcon(c, g, solidBricksXPos[i],solidBricksYPos[i]);
        }
    }


    public boolean checkCollision(int x, int y)
    {
        boolean collided = false;
        for(int i=0; i< brickON.length;i++)
        {
            if(brickON[i]==1)
            {
                if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(bricksXPos[i], bricksYPos[i], 50, 50)))
                {
                    brickON[i] = 0;
                    collided = true;
                    break;
                }
            }
        }

        return collided;
    }

    public boolean checkSolidCollision(int x, int y)
    {
        boolean collided = false;
        for(int i=0; i< solidBricksXPos.length;i++)
        {
            if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(solidBricksXPos[i], solidBricksYPos[i], 50, 50)))
            {
                collided = true;
                break;
            }
        }

        return collided;
    }


}


