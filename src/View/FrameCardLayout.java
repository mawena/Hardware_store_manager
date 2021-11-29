package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FrameCardLayout extends JFrame {
    private CardLayout cl = new CardLayout();
    private JPanel container = new JPanel();
    private String[] listContent = { "blue", "red", "green", "yellow" };
    private int id = 0;

    public FrameCardLayout(String $title, int $larg, int $long) {
        this.setTitle($title);
        this.setSize($larg, $long);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel ButtonPane = new JPanel();
        JButton button = new JButton("Contenu suivant");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                cl.next(container);
            }
        });
        ButtonPane.add(button);
        button = new JButton("Contenu par indice");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (++id >= listContent.length)
                    id = 0;

                cl.show(container, listContent[id]);
            }
        });
        ButtonPane.add(button);

        this.container.setLayout(cl);
        JPanel card = new JPanel();
        card.setBackground(Color.blue);
        this.container.add(card, listContent[0]);
        card = new JPanel();
        card.setBackground(Color.red);
        this.container.add(card, listContent[1]);
        card = new JPanel();
        card.setBackground(Color.green);
        this.container.add(card, listContent[2]);
        card = new JPanel();
        card.setBackground(Color.yellow);
        this.container.add(card, listContent[3]);

        this.getContentPane().add(ButtonPane, BorderLayout.NORTH);
        this.getContentPane().add(container, BorderLayout.CENTER);

        this.setVisible(true);
    }
}