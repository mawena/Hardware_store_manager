package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameGridBagLayout extends JFrame {
    public FrameGridBagLayout(String $title, int $larg, int $long) {
        this.setTitle($title);
        this.setSize($larg, $long);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel cel11 = new JPanel();
        cel11.setBackground(Color.yellow);
        cel11.setPreferredSize(new Dimension(60, 40));

        JPanel cel12 = new JPanel();
        cel12.setBackground(Color.red);
        cel12.setPreferredSize(new Dimension(60, 40));

        JPanel cel13 = new JPanel();
        cel13.setBackground(Color.green);
        cel13.setPreferredSize(new Dimension(60, 40));

        JPanel cel14 = new JPanel();
        cel14.setBackground(Color.black);
        cel14.setPreferredSize(new Dimension(60, 40));

        JPanel cel15 = new JPanel();
        cel15.setBackground(Color.cyan);
        cel15.setPreferredSize(new Dimension(60, 40));

        JPanel cel16 = new JPanel();
        cel16.setBackground(Color.blue);
        cel16.setPreferredSize(new Dimension(60, 40));

        JPanel cel17 = new JPanel();
        cel17.setBackground(Color.orange);
        cel17.setPreferredSize(new Dimension(60, 40));

        JPanel cel18 = new JPanel();
        cel18.setBackground(Color.darkGray);
        cel18.setPreferredSize(new Dimension(60, 40));

        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(300, 120));
        container.setBackground(Color.white);

        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        
        container.add(cel11, gbc);
        
        gbc.gridx = 1;
        container.add(cel12, gbc);
        
        gbc.gridx = 2;
        container.add(cel13, gbc);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 3;
        container.add(cel14, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        container.add(cel15, gbc);
        
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        container.add(cel16, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        container.add(cel17, gbc);

        gbc.gridx = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        container.add(cel18, gbc);

        this.getContentPane().add(container);

        this.setVisible(true);
    }
}
