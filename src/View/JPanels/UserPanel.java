/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.JPanels;

import Controllers.UsersController;
import Models.Entities.User;
import Models.EntitiesManagers.UsersManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mawena
 */
public class UserPanel extends javax.swing.JPanel {

    /**
     * Creates new form StockPanel
     */
    public UserPanel() {
        initComponents();
        tabJTable.setModel(UsersManager.toTableModel(UsersManager.getAll()));
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
        tabJTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        Username = new javax.swing.JTextField();
        Illustration = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        Type = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        tabJTable.setBackground(new java.awt.Color(255, 255, 255));
        tabJTable.setForeground(new java.awt.Color(34, 67, 128));
        tabJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tabJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabJTableMouseClicked(evt);
            }
        });
        tab.setViewportView(tabJTable);

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setForeground(new java.awt.Color(34, 67, 128));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/add-min.png"))); // NOI18N
        addButton.setText("Ajouter");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        Username.setBackground(new java.awt.Color(255, 255, 255));
        Username.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Username.setForeground(new java.awt.Color(34, 67, 128));
        Username.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nom d'utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        Illustration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Users.png"))); // NOI18N

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setForeground(new java.awt.Color(34, 67, 128));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete-min.png"))); // NOI18N
        deleteButton.setText("Suprimer");
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
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

        Password.setBackground(new java.awt.Color(255, 255, 255));
        Password.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Password.setForeground(new java.awt.Color(34, 67, 128));
        Password.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mot de passe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        Type.setBackground(new java.awt.Color(255, 255, 255));
        Type.setForeground(new java.awt.Color(34, 67, 128));
        Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerant", "Comptable" }));
        Type.setBorder(javax.swing.BorderFactory.createTitledBorder("Type"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(Illustration, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addComponent(Search)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(deleteButton)
                            .addComponent(updateButton)))
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Illustration))
            .addGroup(layout.createSequentialGroup()
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearForm(){
        Username.setText("");
        Password.setText("");
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(UsersController.store(new User(Username.getText(), Password.getText(), Type.getSelectedItem().toString()))){
            clearForm();
            tabJTable.setModel(UsersManager.toTableModel(UsersManager.getAll()));
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(UsersController.destroy(Username.getText())){
            clearForm();
            tabJTable.setModel(UsersManager.toTableModel(UsersManager.getAll()));
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        clearForm();
    }//GEN-LAST:event_clearButtonActionPerformed
    
    private void tabJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabJTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)  tabJTable.getModel();
        int myIndex =  tabJTable.getSelectedRow();
        Username.setText(model.getValueAt(myIndex, 1).toString());
        Password.setText(model.getValueAt(myIndex, 2).toString());
        Type.setSelectedItem(model.getValueAt(myIndex, 3).toString());
    }//GEN-LAST:event_tabJTableMouseClicked

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        tabJTable.setModel(UsersManager.toTableModel(UsersManager.search(Search.getText())));
    }//GEN-LAST:event_SearchKeyReleased

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Illustration;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> Type;
    private javax.swing.JTextField Username;
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane tab;
    private javax.swing.JTable tabJTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
