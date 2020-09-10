package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpPanel extends JPanel {

    private JLabel l;
    private JButton indietro = new JButton("Indietro");
    private Main main;
    private Icon img;
    private String s = "<HTML>Il nostro caro amico Snake, dopo aver vissuto per molto tempo sulla terra ed aver divorato tutte le mele <BR>esistenti, ha deciso di farsi un piccolo viaggio nello spazio. Il nostro povero piccolo amico<BR>non è al corrente dell'esistenza di esseri di origine extraterrestre.<BR>Riuscirà il nostro caro amico a fare rifornimento di mele prima che venga catturato dai nemici?<BR>Ti ricordo che nella galassia le cose non funzionano come sulla terra e la fisica è diversa.<BR><BR>REGOLE DI GIOCO: con le frecce bisogna muovere il serpente nelle varie direzioni (solo orizzontale e verticale, NO diagonale).<BR>Arriva a 10 mele così il nostro amico può tornare subito a casa. <BR>Ed attenzione ai nemici, hai solo 5 vite dall'inizio del gioco, non sprecarle tutte!!</HTML>";

    public HelpPanel(Main main) {

        img = new ImageIcon("images/help.gif");
        l = new JLabel(s);
        this.main = main;
        this.setLayout(new BorderLayout());

        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        b.add(this.indietro);
        b.add(Box.createRigidArea(new Dimension(1, 20)));
        b1.add(Box.createRigidArea(new Dimension(10, 50)));
        l.setBounds(0, 0, 0, 30);
        l.setForeground(Color.WHITE);
        b1.add(this.l);

        this.add(b, "North");
        this.add(b1, "Center");
        this.addListener(this);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        img.paintIcon(this, g, 0, 0);
    }

    private void addListener(final JPanel p) {
        this.indietro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Indietro Help");
                main.swicthPanel(main.getMenuPanel());
            }
        });
    }
}
