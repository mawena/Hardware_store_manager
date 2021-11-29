package View;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel {
    protected int posX = -50;
    protected int posY = -50;

    public Panneau() {

    }

    public Panneau(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * @param g
     */
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.red);
        g.fillOval(this.posX, this.posY, 50, 50);
    }

    /**
     * @return int
     */
    public int getPosX() {
        return this.posX;
    }

    /**
     * @param x
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return int
     */
    public int getPosY() {
        return this.posY;
    }

    /**
     * @param posY
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

}
