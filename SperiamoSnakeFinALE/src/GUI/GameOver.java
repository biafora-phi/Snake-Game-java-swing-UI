package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GameOver extends JPanel {

    private Icon img;
    private Main main;
    private JButton indietro;

    public GameOver(Main main) {
        this.main = main;
        img = new ImageIcon("images/lose.jpg");
        Box b = Box.createHorizontalBox();
        indietro = new JButton("Indietro");
        b.add(indietro);
        this.add(b, BorderLayout.NORTH);
        this.addListener(this);
    }

    private void addListener(final JPanel win){

        this.indietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.swicthPanel(main.getMenuPanel());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,700, 700);
        img.paintIcon(this, g, 30, 30);
    }
}
