package View;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import View.Panneau;

public class FrameBox extends JFrame{

    public FrameBox(String $title, int $larg, int $long){
        this.setTitle($title);
        this.setSize($larg, $long);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Box container = Box.createVerticalBox();

        Box b1 = Box.createHorizontalBox();
        b1.add(new JButton("Bouton 1"));
        container.add(b1);
        
        b1 = Box.createHorizontalBox();
        b1.add(new JButton("Bouton 2"));
        b1.add(new JButton("Bouton 3"));
        container.add(b1);

        b1 = Box.createHorizontalBox();
        b1.add(new JButton("Bouton 4"));
        b1.add(new JButton("Bouton 5"));
        b1.add(new JButton("Bouton 6"));
        container.add(b1);

        b1 = Box.createHorizontalBox();
        b1.add(new JButton("Bouton 7"));
        b1.add(new JButton("Bouton 8"));
        b1.add(new JButton("Bouton 9"));
        b1.add(new JButton("Bouton 10"));
        container.add(b1);

        this.getContentPane().add(container);
        this.setVisible(true);
    }
}
