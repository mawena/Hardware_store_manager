/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.JPanels;

import Models.EntitiesManagers.StockManager;
import javax.swing.*;
import java.awt.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mawena
 */
public class StockPanel extends javax.swing.JPanel {

    /**
     * Creates new form StockPanel
     */
    public StockPanel() {
        initComponents();
        tabjTable.setModel(StockManager.toTableModel(StockManager.getAll()));
    }
    
     private static final long serialVersionUID = -6350324456764768311L;

    private Image image;

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }
    public void setImage(String path) throws IOException {
        try {
            this.image = ImageIO.read(new File(path));
            repaint();
        } 
        catch (IOException e) {
            throw new IOException(path+" introuvable", e);
        }
    }

    public Image getImage() {
        return image;
    }
    
    @Override
    public void paintComponent(Graphics g){
        try {
            this.setImage("/home/mawena/Work/Java/UCAO/APOO/hardware_store_manager/src/View/Images/Barcode-bro-ill.jpg");
        } catch (IOException ex) {
            Logger.getLogger(StockPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(image!=null){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JScrollPane();
        tabjTable = new javax.swing.JTable();
        productId = new javax.swing.JComboBox<>();
        productQuantity = new javax.swing.JSpinner();
        productDateEntry = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tabjTable.setBackground(new java.awt.Color(255, 255, 255));
        tabjTable.setForeground(new java.awt.Color(34, 67, 128));
        tabjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tab.setViewportView(tabjTable);

        productId.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        productId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numéro produit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        productQuantity.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        productQuantity.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        productQuantity.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        productDateEntry.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        productDateEntry.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.ERA));
        productDateEntry.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date d'entrée", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setForeground(new java.awt.Color(34, 67, 128));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/add-product.png"))); // NOI18N
        addButton.setText("Ajouter");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setForeground(new java.awt.Color(34, 67, 128));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/update-product.png"))); // NOI18N
        updateButton.setText("Mettre à jour");
        updateButton.setBorder(null);
        updateButton.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productDateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productDateEntry))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(updateButton))
                    .addComponent(productQuantity))
                .addContainerGap(455, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JSpinner productDateEntry;
    private javax.swing.JComboBox<String> productId;
    private javax.swing.JSpinner productQuantity;
    private javax.swing.JScrollPane tab;
    private javax.swing.JTable tabjTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}