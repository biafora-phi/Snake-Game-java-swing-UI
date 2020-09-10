package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SnakeEnemy {

    private int x, y;
    private Image img;

    public SnakeEnemy(int x, int y){
        this.x = x;
        this.y = y;

        try {
            img = ImageIO.read(new File("images/ufo.png"));
            Image scaled = img.getScaledInstance(22, 20, Image.SCALE_SMOOTH);
            img = scaled;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void drawEnemy(Graphics g){
        g.setColor(Color.WHITE);
        g.drawImage(img, x*10, y*10,40,40, null);

    }

}
