package GUI;

import Controller.KeyController;
import Objects.SnakeApple;
import Objects.SnakeBody;
import Objects.SnakeEnemy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GameSnake extends JPanel implements Runnable {
    public static final int PANEL_WIDTH = 700; // The game panel width
    public static final int PANEL_HEIGHT = 700; // The game panel height


    public static boolean up = false;
    public static boolean right = true;
    public static boolean down = false;
    public static boolean left = false;


    private Thread t; // A private thread instance
    private JLabel scoreLabel;
    private Date data;
    private String utente;

    private SnakeBody b; // A link to the snake body
    private SnakeApple a; // Like to the snake apples
    private SnakeEnemy e;
    private String color, aCapo = "\n";

    private ArrayList<SnakeBody> body; // ArrayList to store a list of body parts
    private ArrayList<SnakeApple> apples; // An Array list of game apples for the snake to eat.
    private ArrayList<SnakeEnemy> enemy;
    private Random r; // Random instance to generate random apples

    private int x = 10;
    private int y = 10;
    private int cont = 0;
    private int vitality;
    private int score;
    private int contApples = 0;

    private int size = 5;
    private int ticks = 0;

    private Main main;
    private Image heart;
    private Image s;

    public GameSnake(Main main, String color) { // Constructor
        this.color = color;
        setLayout(null);
        vitality = 5;
        data = new Date(System.currentTimeMillis());
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        addKeyListener(new KeyController(main)); // Add the key listener.
        setFocusable(true);

        try {
            if(color == "blue") {
                s = ImageIO.read(new File("images/ok.jpg"));
                heart = ImageIO.read(new File("images/heart.png"));
            }
            if (color == "red") {
                s = ImageIO.read(new File("images/oki.jpg"));
                heart = ImageIO.read(new File("images/heart.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        this.body = new ArrayList<>(); // Create the new array list of body parts
        this.apples = new ArrayList<>();
        this.enemy = new ArrayList<>();
        r = new Random();
        this.main = main;

        score = 0;
        scoreLabel = new JLabel(String.valueOf(score));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("sansserif",Font.BOLD,28));
        scoreLabel.setBounds(600, 10, 50, 70);
        add(scoreLabel);
        setVisible(true);
    }



    public void win() { // Routine to start the game.
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String data = format.format( new Date()   );
        main.getGestione().scriviSuFile(utente+"  "+String.valueOf(score) +"   "+ data+ aCapo);
        //System.out.println(String.valueOf(score) + data);
        ((ScorePanel) main.getScore()).addLastScoreLabel(utente+"  "+String.valueOf(score) +"   "+ data);
        main.swicthPanel(main.getWin());
    }


    public void endGame() { // Routine to end the game.
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String data = format.format( new Date()   );
        main.getGestione().scriviSuFile(utente+"  "+String.valueOf(score) +"   "+ data+ aCapo);
        //System.out.println(String.valueOf(score) + data);
        ((ScorePanel) main.getScore()).addLastScoreLabel(utente+"  "+String.valueOf(score) +"   "+ data);
        main.swicthPanel(main.getGameOver());
    }


    public void tick() {

        cont++;
        if(cont % 10000000 == 0){
            int c = r.nextInt(27);
            int c1 = r.nextInt(27);
            enemy.remove(enemy.size()-1);
            e = new SnakeEnemy(c, c1);
            enemy.add(e);
        }

        // Create a new snake body and add it to the array list.
        if(body.size() == 0) {
            b = new SnakeBody(x, y, 10);
            body.add(b);
        }

        if(enemy.size() == 0){
            int c, c1;
            do {
                c = r.nextInt(27); // Create apples to display on the screen
                c1 = r.nextInt(27);///change here
            }while(c < 0 || c > 67 || c1 > 67 || c1 < 5);

            e = new SnakeEnemy(c, c1);
            enemy.add(e);
        }

        ticks++;
        if(ticks > 230000) {
            if(right) { // If the right button is hit
                x++; // Increment x Coordinate
            }
            if(left) { // If the snake is going in the left direction
                x--; // Decrement the x Coordinate values
            }
            if(up) {
                y--;
            }
            if(down) { // If the snake is going in the down direction
                y++; // Increment the y coordinate
            }
            ticks = 0;
            b = new SnakeBody(x, y, 10); // Create a new snake body instance to store the coordinates
            body.add(b);
            if(body.size() > size) { // If the body parts array size is greater than 0
                body.remove(0); // remove the 1st index.
            }


            collision();
            collisionEnemy();


            if(apples.size() == 0) { // If there are no apples
                int xCoordinate, yCoordinate;

                do {
                     xCoordinate = r.nextInt(67); // Create 49 apples to display on the screen
                     yCoordinate = r.nextInt(60);///cambia qui
                }while(xCoordinate < 0 || xCoordinate > 67 || yCoordinate > 60 || yCoordinate < 5);

                a = new SnakeApple(xCoordinate, yCoordinate, 10);
                apples.add(a); // Add the apples to the array list of apples.
                //System.out.println("Riempi" + apples.size());
            }


            if(x < 0 || x > 67 || y < 5 || y > 63) { // If the snake goes out of bounds
                if(x < 0)
                    x = 67;//cambia qui
                if(x > 67)
                    x = 0;
                if(y < 5)
                    y = 63;
                if(y > 63)
                    y = 5;
            }
        }
    }


    private void collision() {

        if(apples.size() != 0) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (x == apples.get(0).getxCoordinate() + j && y == apples.get(0).getyCoordinate() + k) {
                        size++;
                        contApples++;
                        scoreLabel.setText(String.valueOf(score += 10));
                        apples.remove(0);
                        return;
                    }
                }
            }
        }

    }



    private void collisionEnemy(){

        for(int j = 0; j < 4; j++){
            for(int k = 0; k < 4; k++) {
                if (x == enemy.get(0).getX() + j && y == enemy.get(0).getY() + k) {
                    vitality--;
                    //System.out.println(vitality);
                    score -= 2;
                    if(score < 0)
                        score = 0;
                    scoreLabel.setText(String.valueOf(score));
                    enemy.remove(0);
                    return;
                }
            }
        }

    }



    public void setUtente(String a) {
        utente = a;
    }



    @Override
    public void paintComponent(Graphics graphics) { // Routine to draw the body parts & apples.
        super.paintComponent(graphics);
        graphics.drawImage(s,0,0, 700, 700, this);

        if(color == "red"){
            for(int i = 0; i < body.size(); i++) {
                if(i == body.size()-1) {
                    body.get(i).drawHeadPart(graphics, true);
                } else
                    body.get(i).drawBodyPart(graphics, true);
            }
        }


        if(color == "blue") {
            for (int i = 0; i < body.size(); i++) {
                if (i == body.size() - 1) {
                    body.get(i).drawHeadPart(graphics, false);
                } else
                    body.get(i).drawBodyPart(graphics, false);
            }
        }



        for(int i = 0; i < apples.size(); i++) {
            apples.get(i).drawApple(graphics);
        }


        for(int i = 0; i < vitality; i++){
            graphics.drawImage(heart, i*10, 0, this);
        }


        for(int i = 0; i < enemy.size(); i++){
            enemy.get(i).drawEnemy(graphics);
        }

    }


    @Override
    public void run() { // Routine that runs the thread.
        String name = JOptionPane.showInputDialog("Inserisci nome player");
        setUtente(name);

        while(true) { // While the game is active loop
            tick();

            if(contApples == 10){
                win();
                break;
            }

            if(vitality == 0){
                endGame();
                //t.stop();
                break;
            }

            repaint(); // Paint the graphics on the screen
        }
    }


}
