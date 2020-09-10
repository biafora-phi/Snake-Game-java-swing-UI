package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel{

    private Icon s1;
    private JButton start = new JButton("Start");
    private JButton help = new JButton("help");
    private JButton opzioni = new JButton("musica on/off");
    private JButton score = new JButton("Score");
    private boolean startT = false;
    private Main main;


    public MenuPanel(Main main) {

        s1 = new ImageIcon("images/gif22.gif");

        this.main = main;
        setFocusable(true);
        this.setLayout(new BorderLayout());

        Box b = Box.createVerticalBox();
        b.add(Box.createRigidArea(new Dimension(10, 80)));
        Dimension d = new Dimension(130, 50);
        start.setMaximumSize(d);
        b.add(start);
        b.add(Box.createRigidArea(new Dimension(10, 100)));
        score.setMaximumSize(d);
        b.add(score);
        b.add(Box.createRigidArea(new Dimension(10, 100)));
        opzioni.setMaximumSize(d);
        b.add(opzioni);
        b.add(Box.createRigidArea(new Dimension(400, 100)));
        b.add(Box.createRigidArea(new Dimension(400, 40)));

        Box b1 = Box.createHorizontalBox();
        b1.add(help);

        this.add(b, BorderLayout.EAST);
        this.add(b1, BorderLayout.SOUTH);
        this.addListener(this);
    }

    private void addListener(final JPanel p) {

        this.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Start");
                main.swicthPanel(main.getScelta());
            }
        });

        this.score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("SCORE");
                main.swicthPanel(main.getScore());
            }
        });


        this.opzioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("OPZIONI");
                //main.swicthPanel(main.getOption());
                main.getAudio().onOff();
            }
        });

        this.help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Help");
                main.swicthPanel(main.getHelp());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        s1.paintIcon(this, g, -200 , -10);

    }
}
