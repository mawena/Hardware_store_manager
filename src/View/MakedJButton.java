package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.imageio.ImageIO;

public class MakedJButton extends JButton implements MouseListener {
    private String name;
    private Image img;

    public MakedJButton(String $label) {
        super($label);
        this.name = $label;
        try {
            this.img = ImageIO.read(new File("Images/blue.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.white);
        g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 2 / 4), (this.getHeight() / 2) + 5);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            this.img = ImageIO.read(new File("Images/red.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        try {
            this.img = ImageIO.read(new File("Images/yellow.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        try {
            this.img = ImageIO.read(new File("Images/green.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
