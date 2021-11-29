package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import View.MakedJButton;

public class FrameAnimation extends JFrame {
    private Panneau pan = new Panneau();
    private MakedJButton button = new MakedJButton("My Button");
    private JPanel container = new JPanel();

    FrameAnimation(String $title, int $larg, int $long) {
        this.setTitle($title);
        this.setSize($larg, $long);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        container.setBackground(Color.white);
        container.setLayout(new BorderLayout());
        container.add(pan, BorderLayout.CENTER);
        container.add(button, BorderLayout.SOUTH);
        this.setContentPane(container);

        this.setVisible(true);
        this.go();
    }

    public void go() {
        int x = pan.getPosX(), y = pan.getPosY();
        boolean backX = false, backY = false;

        while (true) {
            if (x < 1)
                backX = false;
            if (x > pan.getWidth() - 50)
                backX = true;

            if (y < 1)
                backY = false;
            if (y > pan.getHeight() - 50)
                backY = true;

            if(backX)
                pan.setPosX(--x);
            else
                pan.setPosX(++x);

            if(backY)
                pan.setPosY(--y);
            else
                pan.setPosY(++y);

            pan.repaint();

            try{
                Thread.sleep(3);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
