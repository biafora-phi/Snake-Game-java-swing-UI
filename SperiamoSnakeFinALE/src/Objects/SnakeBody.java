package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SnakeBody {

    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private Image img, head;

    public SnakeBody(int xCoordinate, int yCoordinate, int tileSize) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = tileSize;
        this.height = tileSize;

        try {
            img = ImageIO.read(new File("images/body.png"));
            Image scaled = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
            img = scaled;
            head = ImageIO.read(new File("images/head1.png"));
            Image scaled1 = head.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
            head = scaled1;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void tick() {

    }


    public void drawBodyPart(Graphics graphics, boolean b) { // Draw the body part onto the screen
        if(!b)
            graphics.drawImage(img, xCoordinate * width, yCoordinate * height, null);
        else{
            graphics.setColor(Color.RED);
            graphics.fillRect(xCoordinate*width, yCoordinate*height, 10,10);
        }
    }


    public void drawHeadPart(Graphics graphics, boolean b) { // Draw the body part onto the screen
        if(!b)
            graphics.drawImage(head, xCoordinate * width, yCoordinate * height,10, 10, null);
        else{
            graphics.setColor(Color.RED);
            graphics.fillRect(xCoordinate*width, yCoordinate*height, 10,10);
        }
    }


    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
