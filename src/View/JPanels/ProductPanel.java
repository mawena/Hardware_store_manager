/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.JPanels;

import Controllers.ProductsController;
import Models.Entities.Product;
import Models.EntitiesManagers.ProductsManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mawena
 */
public class ProductPanel extends javax.swing.JPanel {

    /**
     * Creates new form StockPanel
     */
    public ProductPanel() {
        initComponents();
        Table.setModel(ProductsManager.toTableModel(ProductsManager.getAll()));
        //updateButton.setEnabled(false);
        disableButton();
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
        Table = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        Designation = new javax.swing.JTextField();
        Description = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Illustration = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        Search = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        Table.setFont(new java.awt.Font("Liberation Mono", 3, 18)); // NOI18N
        Table.setForeground(new java.awt.Color(34, 67, 128));
        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                TableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        tab.setViewportView(Table);

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setForeground(new java.awt.Color(34, 67, 128));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/add-min-new.png"))); // NOI18N
        addButton.setText("Ajouter");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        Designation.setBackground(new java.awt.Color(255, 255, 255));
        Designation.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Designation.setForeground(new java.awt.Color(34, 67, 128));
        Designation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Designation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        Description.setBackground(new java.awt.Color(255, 255, 255));
        Description.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Description.setForeground(new java.awt.Color(34, 67, 128));
        Description.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        Description.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionActionPerformed(evt);
            }
        });

        Price.setBackground(new java.awt.Color(255, 255, 255));
        Price.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Price.setForeground(new java.awt.Color(34, 67, 128));
        Price.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prix", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        Illustration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Products.png"))); // NOI18N

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setForeground(new java.awt.Color(34, 67, 128));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete-min-new.png"))); // NOI18N
        deleteButton.setText("Suprimer");
        deleteButton.setAutoscrolls(true);
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setForeground(new java.awt.Color(34, 67, 128));
        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/update-min.png"))); // NOI18N
        updateButton.setText("Mettre à jour");
        updateButton.setBorder(null);
        updateButton.setBorderPainted(false);
        updateButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(255, 255, 255));
        clearButton.setForeground(new java.awt.Color(34, 67, 128));
        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/clear-min.png"))); // NOI18N
        clearButton.setText("Effacer");
        clearButton.setBorder(null);
        clearButton.setBorderPainted(false);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        Search.setBackground(new java.awt.Color(255, 255, 255));
        Search.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Search.setForeground(new java.awt.Color(34, 67, 128));
        Search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Designation, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(clearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Illustration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                    .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Designation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Description, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Illustration, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearForm() {
        Designation.setText("");
        Description.setText("");
        Price.setText("");
    }

    private void disableButton() {
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
    }

    public boolean good() {
        try {
            Double.parseDouble(Price.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Le prix doit être un chiffre!");
            return false;
        }
    }

    private void DescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        disableButton();
        if (good()) {
            if (ProductsController.store(new Product(Designation.getText(), Description.getText(), Double.valueOf(Price.getText())))) {
                clearForm();
                Table.setModel(ProductsManager.toTableModel(ProductsManager.getAll()));
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if (ProductsController.destroy(Integer.parseInt(model.getValueAt(myIndex, 0).toString()))) {
                clearForm();
                Table.setModel(ProductsManager.toTableModel(ProductsManager.getAll()));
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        disableButton();
        clearForm();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        updateButton.setVisible(true);
        deleteButton.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int myIndex = Table.getSelectedRow();
        Designation.setText(model.getValueAt(myIndex, 1).toString());
        Description.setText(model.getValueAt(myIndex, 2).toString());
        Price.setText(model.getValueAt(myIndex, 3).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        disableButton();
        Table.setModel(ProductsManager.toTableModel(ProductsManager.search(Search.getText())));
    }//GEN-LAST:event_SearchKeyReleased

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if (good()) {
                if (ProductsController.update(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), new Product(Designation.getText(), Description.getText(), Double.valueOf(Price.getText())))) {
                    clearForm();
                    Table.setModel(ProductsManager.toTableModel(ProductsManager.getAll()));
                }
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Description;
    private javax.swing.JTextField Designation;
    private javax.swing.JLabel Illustration;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField Search;
    private javax.swing.JTable Table;
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane tab;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
