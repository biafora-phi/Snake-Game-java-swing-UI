package Controller;

import GUI.GameSnake;
import GUI.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyController implements KeyListener {

    private Main p;

    public KeyController(Main p) {
        this.p = p;
    }

    public Main getP() {
        return p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) { // Routine that checks the key pressed on the keyboard
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_RIGHT && !GameSnake.left) { // If the right key is pressed and the snake is not going in the left direction
            GameSnake.right = true; // Set right direction flag to true.
            GameSnake.up = false; // Not going up.
            GameSnake.down = false; // Not going down
        }

        if(keyCode == KeyEvent.VK_LEFT && !GameSnake.right) {
            GameSnake.left = true;
            GameSnake.up = false;
            GameSnake.down = false;
        }

        if(keyCode == KeyEvent.VK_UP && !GameSnake.down) { // If the UP key is pressed and not the down key
            GameSnake.up = true; // Up is true
            GameSnake.left= false; // Left is false
            GameSnake.right = false; // Right is false
        }

        if(keyCode == KeyEvent.VK_DOWN && !GameSnake.up) {
            GameSnake.down = true;
            GameSnake.left = false;
            GameSnake.right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
