package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SceltaPersonaggio extends JPanel {

    private Icon s1;
    private Image p1;
    private Image p2;

    private JButton indietro;
    private JButton personaggio1;
    private JButton personaggio2;

    private Main main;


    public SceltaPersonaggio(Main main) {

        s1 = new ImageIcon("images/choose.gif");
        try {
            p1 = ImageIO.read(new File("images/snakeBlu.png"));
            p2 = ImageIO.read(new File("images/snakeRosso.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.main = main;
        this.setLayout(new BorderLayout());

        Box b = Box.createHorizontalBox();
        indietro = new JButton("Indietro");
        b.add(indietro);
        this.add(b, BorderLayout.NORTH);

        Box b2 = Box.createHorizontalBox();
        personaggio1 = new JButton("Blue Snake");
        personaggio2 = new JButton("Red Snake");
        b2.add(Box.createRigidArea(new Dimension(100, 550)));
        b2.add(personaggio1);
        b2.add(Box.createRigidArea(new Dimension(270, 550)));
        b2.add(personaggio2);

        this.add(b2, BorderLayout.SOUTH);
        this.addListener(this);
        setFocusable(true);
    }


    private void addListener(final JPanel sceltaPersonaggio) {

        this.personaggio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread((Runnable)main.getGameBlue()).start();
                main.swicthPanel(main.getGameBlue());
            }
        });

        this.personaggio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread((Runnable)main.getGameRed()).start();
                main.swicthPanel(main.getGameRed());
            }
        });

        this.indietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Indietro scelta");
                main.swicthPanel(main.getMenuPanel());
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        s1.paintIcon(this, g, 0, 0);
        g.drawImage(p1, 60, 160, 180, 200, this);
        g.drawImage(p2, 430, 160,180, 200,  this);
    }
}
