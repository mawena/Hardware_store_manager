/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.JPanels;

import Controllers.StockController;
import Models.Entities.Product;
import Models.Entities.Stock;
import Models.EntitiesManagers.StockManager;
import Models.EntitiesManagers.ProductsManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mawena
 */
public class OrderPanel extends javax.swing.JPanel {

    /**
     * Creates new form StockPanel
     */
    public OrderPanel() {
        initComponents();
        ArrayList<Stock> stockList = StockManager.getAll();
        Table.setModel(StockManager.toTableModel(stockList));
        productId.removeAllItems();
        productId.addItem("Tout");
        for (Product product : ProductsManager.getAll()) {
            productId.addItem(Integer.toString(product.getId()));
        }
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        changeDateEntry(currentDate);
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
        productId = new javax.swing.JComboBox<>();
        Quantity = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        DateEntry = new com.toedter.calendar.JDateChooser();
        Illustration = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        Table.setBackground(new java.awt.Color(255, 255, 255));
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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        tab.setViewportView(Table);

        productId.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        productId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        productId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Numéro produit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        productId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                productIdItemStateChanged(evt);
            }
        });

        Quantity.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Quantity.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        Quantity.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setForeground(new java.awt.Color(34, 67, 128));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/add-min.png"))); // NOI18N
        addButton.setText("Ajouter");
        addButton.setBorder(null);
        addButton.setBorderPainted(false);
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
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

        deleteButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteButton.setForeground(new java.awt.Color(34, 67, 128));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete-min.png"))); // NOI18N
        deleteButton.setText("Suprimer");
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        DateEntry.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date d'entrée", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        DateEntry.setForeground(new java.awt.Color(34, 67, 128));
        DateEntry.setDateFormatString("yyyy-MM-dd");
        DateEntry.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                DateEntryInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                DateEntryCaretPositionChanged(evt);
            }
        });

        Illustration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Commands.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DateEntry, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(Quantity, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(productId, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Illustration))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(productId)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateEntry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Illustration))
            .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void disableButton() {
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
    }

    public boolean good() {
        if (productId.getSelectedItem().toString().equals("Tout")) {
                JOptionPane.showMessageDialog(null, "Veuillez selectionner un numéro de produit valide!");
                return false;
            } else{
            try {
                Date dateTmp = new SimpleDateFormat("yyyy-MM-dd").parse(((JTextField) DateEntry.getDateEditor().getUiComponent()).getText());
                LocalDate currentDate = LocalDate.now();
                LocalDate date = dateTmp.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if (currentDate.isBefore(date)) {
                    JOptionPane.showMessageDialog(null, "La date ne peut dépasser le jour actuelle: " + currentDate);
                    return false;
                } else {
                    return true;
                }
            } catch (ParseException ex) {
                return false;
            }
        }
        
    }

    public void changeDateEntry(String dateEntry) {
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateEntry);   //On formatte correctement la date
            DateEntry.setDate(date);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "La date est invalide");
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if (StockController.destroy(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), model.getValueAt(myIndex, 3).toString())) {
                Table.setModel(StockManager.toTableModel(StockManager.getAll()));
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        deleteButton.setVisible(true);
        updateButton.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int myIndex = Table.getSelectedRow();
        productId.setSelectedItem(model.getValueAt(myIndex, 0).toString());
        Quantity.setValue(Integer.parseInt(model.getValueAt(myIndex, 2).toString()));
        changeDateEntry(model.getValueAt(myIndex, 3).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        disableButton();
        if (good()) {
            if (StockController.store(new Stock(Integer.parseInt(productId.getSelectedItem().toString()), ((JTextField) DateEntry.getDateEditor().getUiComponent()).getText(), (int) Quantity.getValue()))) {
                Table.setModel(StockManager.toTableModel(StockManager.getAll()));
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void productIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_productIdItemStateChanged
        if (productId.getItemCount() != 0) {
            String value = productId.getSelectedItem().toString();
            if (value.equals("Tout")) {
                Table.setModel(StockManager.toTableModel(StockManager.getAll()));
            } else {
                Table.setModel(StockManager.toTableModel(StockManager.getByProduct(Integer.parseInt(value))));
            }
        }
    }//GEN-LAST:event_productIdItemStateChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if (good()) {
                if (StockController.update(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), model.getValueAt(myIndex, 3).toString(), new Stock(Integer.parseInt(productId.getSelectedItem().toString()), ((JTextField) DateEntry.getDateEditor().getUiComponent()).getText(), (int) Quantity.getValue()))) {
                    Table.setModel(StockManager.toTableModel(StockManager.getAll()));
                }
            }

        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void DateEntryInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_DateEntryInputMethodTextChanged
        
    }//GEN-LAST:event_DateEntryInputMethodTextChanged

    private void DateEntryCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_DateEntryCaretPositionChanged

    }//GEN-LAST:event_DateEntryCaretPositionChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateEntry;
    private javax.swing.JLabel Illustration;
    private javax.swing.JSpinner Quantity;
    private javax.swing.JTable Table;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> productId;
    private javax.swing.JScrollPane tab;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
