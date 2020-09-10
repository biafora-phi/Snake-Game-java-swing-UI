package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ScorePanel extends JPanel {

    private Icon img;
    private Main main;
    private JButton indietro;
    private static ArrayList<Label> l = new ArrayList<Label>();
    private BufferedReader scoreReader;
    private Box b;


    public ScorePanel(Main main) {
        this.main = main;
        this.setLayout(new BorderLayout());
        indietro = new JButton("Indietro");
        img = new ImageIcon("images/score.gif");
        //letturaFile();

        b = Box.createVerticalBox();
        indietro = new JButton("Indietro");
        b.add(indietro);
        b.add(Box.createRigidArea(new Dimension(10, 70)));
        letturaFile();
        for(int  i = 0; i < l.size(); i++){
            l.get(i).setBounds(0, 0, 0, 30);
            b.add(l.get(i));
        }
        this.add(b, BorderLayout.NORTH);
        
        this.addListener(this);
        
        this.setVisible(true);
        
    }
    
    
    private void addListener(ScorePanel scorePanel) {
        this.indietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.swicthPanel(main.getMenuPanel());
            }
        });
    }

    public void letturaFile(){

        //BufferedReader scoreReader = null;
    	
        try {
        	System.out.println("scoreeeeeeeeeeeeeee");
            scoreReader = new BufferedReader(new FileReader("src/ef.txt"));
            String s;
            while ((s = scoreReader.readLine()) != null) {
                l.add(new Label(s));
            	System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img.paintIcon(this, g, 0, 0);
    }


	public void addLastScoreLabel(String s) {
		l.add(new Label(s));
		b.add(l.get(l.size()-1));
	}
}
