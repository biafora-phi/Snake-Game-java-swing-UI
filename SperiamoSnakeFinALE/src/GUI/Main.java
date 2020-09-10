package GUI;

import Controller.AudioController;
import Controller.GestioneFile;
import Controller.KeyController;

import javax.swing.*;

public class Main extends JFrame {

    private JPanel menuPanel = new MenuPanel(this);
    private JPanel scelta = new SceltaPersonaggio(this);
    private JPanel gameBlue = new GameSnake(this, "blue");
    private JPanel gameRed = new GameSnake(this, "red");
    private JPanel help = new HelpPanel(this);
    private JPanel score = new ScorePanel(this);
    private JPanel gameOver = new GameOver(this);
    private KeyController k =  new KeyController( this);
    private JPanel win = new WinPanel(this);
    private AudioController audio = new AudioController("Song/songs.wav");
    private GestioneFile gestioneFile = new GestioneFile();

    public Main(){
        setLayout(null);
        setTitle("SNAKE MIO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 20, 700, 700); ///cambia qui
        setContentPane(menuPanel);

        setResizable(false);
        audio.play();
    }

    public AudioController getAudio() {
        return audio;
    }

    public JPanel getGameOver() {
        return gameOver;
    }

    public JPanel getWin() {
        return win;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JPanel getScelta() {
        return scelta;
    }

    public JPanel getGameRed() {
        return gameRed;
    }

    public JPanel getGameBlue() {
        return gameBlue;
    }

    public Main getMainFrame(){
        return this;
    }

    public JPanel getHelp() {
        return help;
    }

    public JPanel getScore() {
        return score;
    }


    public GestioneFile getGestione() {
        return gestioneFile;
    }

    public void swicthPanel(JPanel panel){
        this.setContentPane(panel);
        this.invalidate();
        this.validate();
        panel.requestFocusInWindow();
    }

    public static void main(String[] args) {

        JFrame snake = new Main();
        snake.setVisible(true);

    }

	public GestioneFile getGestioneFile() {
		return gestioneFile;
	}



}
