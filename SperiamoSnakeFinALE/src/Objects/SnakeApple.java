package Objects;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observer;

public class SnakeApple {
    private int xCoordinate;
    private int yCoordinate;
    private int width;
    private int height;
    private Image img;

    public SnakeApple(int xCoordinate, int yCoordinate, int tileSize) {

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.width = tileSize;
        this.height = tileSize;

        try {
            img = ImageIO.read(new File("images/food1.png"));
            Image scaled = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
            img = scaled;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void tick() {

    }


    public void drawApple(Graphics graphics) { // Draw the body part onto the screen

        graphics.drawImage(img, xCoordinate * width, yCoordinate * height, 20, 20,null);
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
