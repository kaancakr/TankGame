import javax.swing.*;
import java.awt.*;

public class brokeBricks {

        int brokebricksXPos[] = {50,350,450,550,50,300,350,450,550,150,150,450,550,
                250,50,100,150,550,250,350,450,550,50,250,350,550,
                50,150,250,300,350,550,50,150,250,350,450,550,50,
                250,350,550,600,400,350,350,300,200,150,100,450,700,
                700,700,700,700,650,650,700,700,750,750,800,850,850,800,850,900,950,1000,900,900,850};

        int brokebricksYPos[] = {50,50,50,50,100,100,100,100,100,150,200,200,200,250,
                300,300,300,300,350,350,350,350,400,400,400,400,450,
                450,450,450,450,450,500,500,500,500,500,500,550,550,
                550,550,650,650,650,600,650,650,650,650,250,250,200,
                150,100,50,350,400,500,550,100,300,300,300,450,650,650,650,600,550,450,400,350};

        int brokeON[] = new int[73];

        private ImageIcon brokeBrickImage;

        public brokeBricks()
        {

            brokeBrickImage=new ImageIcon("assets/broke_brick.png");


            for(int i=0; i< brokeON.length;i++)
            {
                brokeON[i] = 1;
            }
        }

        public void drawBrokes(Component c, Graphics g)
        {
            for(int i=0; i< brokeON.length;i++)
            {
                if(brokeON[i]==1)
                {
                    brokeBrickImage.paintIcon(c, g, brokebricksXPos[i],brokebricksYPos[i]);
                }
            }
        }


        public boolean checkbrokeCollision(int x, int y)
        {
            boolean collided = false;
            for(int i=0; i< brokeON.length;i++)
            {
                if(brokeON[i]==1)
                {
                    if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(brokebricksXPos[i], brokebricksYPos[i], 50, 50)))
                    {
                        brokeON[i] = 0;
                        collided = true;
                        break;
                    }
                }
            }

            return collided;
        }
    }


