import javax.swing.*;
import java.awt.*;

public class heart extends brick{

        int heartXPos[] = {200,250,850,900,1050};

        int heartYPos[] = {50,50,200,250,100};

        int heartON[] = new int[5];

        private ImageIcon heartImage;

        public heart()
        {

            heartImage=new ImageIcon("assets/heartbrick.png");


            for(int i=0; i< heartON.length;i++)
            {
                heartON[i] = 1;
            }
        }

        @Override
        public void draw(Component c, Graphics g)
        {
            for(int i=0; i< heartON.length;i++)
            {
                if(heartON[i]==1)
                {
                    heartImage.paintIcon(c, g, heartXPos[i],heartYPos[i]);
                }
            }
        }


        public boolean checkheartCollision(int x, int y)
        {
            boolean collided = false;
            for(int i=0; i< heartON.length;i++)
            {
                if(heartON[i]==1)
                {
                    if(new Rectangle(x, y, 10, 10).intersects(new Rectangle(heartXPos[i], heartYPos[i], 50, 50)))
                    {
                        heartON[i] = 0;
                        collided = true;
                        break;
                    }
                }
            }

            return collided;
        }

}