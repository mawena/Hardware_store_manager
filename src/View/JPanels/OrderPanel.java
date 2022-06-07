/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.JPanels;

import Controllers.OrdersController;
import Main.Main;
import Models.Entities.Client;
import Models.Entities.Employer;
import Models.Entities.Order;
import Models.EntitiesManagers.ClientsManager;
import Models.EntitiesManagers.EmployersManager;
import Models.EntitiesManagers.OrdersManager;
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
        ArrayList<Order> orderList = OrdersManager.getAll();
        Table.setModel(OrdersManager.toTableModel(orderList));
        ClientName.removeAllItems();
        for (Client client : ClientsManager.getAll()) {
            ClientName.addItem(client.getLastName() + " " + client.getFirstName());
        }
        EmployerName.removeAllItems();
        for (Employer employer : EmployersManager.getAll()) {
            EmployerName.addItem(employer.getLastName() + " " + employer.getFirstName());
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
        ClientName = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        DateOrder = new com.toedter.calendar.JDateChooser();
        Illustration = new javax.swing.JLabel();
        EmployerName = new javax.swing.JComboBox<>();
        moreDetails = new javax.swing.JButton();

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TableKeyTyped(evt);
            }
        });
        tab.setViewportView(Table);

        ClientName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        ClientName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        ClientName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ClientNameItemStateChanged(evt);
            }
        });

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
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/delete-min-new.png"))); // NOI18N
        deleteButton.setText("Suprimer");
        deleteButton.setBorder(null);
        deleteButton.setBorderPainted(false);
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        DateOrder.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date commande", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        DateOrder.setForeground(new java.awt.Color(34, 67, 128));
        DateOrder.setDateFormatString("yyyy-MM-dd");
        DateOrder.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                DateOrderInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                DateOrderCaretPositionChanged(evt);
            }
        });

        Illustration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Commands.png"))); // NOI18N

        EmployerName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        EmployerName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        EmployerName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                EmployerNameItemStateChanged(evt);
            }
        });

        moreDetails.setBackground(new java.awt.Color(255, 255, 255));
        moreDetails.setForeground(new java.awt.Color(34, 67, 128));
        moreDetails.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/icons/more-new.png"))); // NOI18N
        moreDetails.setText("Plus de details");
        moreDetails.setBorder(null);
        moreDetails.setBorderPainted(false);
        moreDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClientName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmployerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Illustration)
                    .addComponent(moreDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmployerName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(moreDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(Illustration, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void disableButton() {
        updateButton.setVisible(false);
        moreDetails.setVisible(false);
        deleteButton.setVisible(false);
    }

    public boolean good() {
        if (ClientName.getSelectedItem().toString().equals("Tout")) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un numéro de client valide!");
            return false;
        } else if (EmployerName.getSelectedItem().toString().equals("Tout")) {
            JOptionPane.showMessageDialog(null, "Veuillez selectionner un numéro d'employer valide!");
            return false;
        } else {
            try {
                Date dateTmp = new SimpleDateFormat("yyyy-MM-dd").parse(((JTextField) DateOrder.getDateEditor().getUiComponent()).getText());
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
            DateOrder.setDate(date);
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
            if (OrdersController.destroy(Integer.parseInt(model.getValueAt(myIndex, 0).toString()))) {
                Table.setModel(OrdersManager.toTableModel(OrdersManager.getAll()));
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        deleteButton.setVisible(true);
        updateButton.setVisible(true);
        moreDetails.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        int myIndex = Table.getSelectedRow();
        ClientName.setSelectedItem(model.getValueAt(myIndex, 1).toString());
        EmployerName.setSelectedItem(model.getValueAt(myIndex, 2).toString());
        changeDateEntry(model.getValueAt(myIndex, 3).toString());
    }//GEN-LAST:event_TableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        disableButton();
        if (good()) {
            Client client = ClientsManager.getByName(ClientName.getSelectedItem().toString());
            Employer employer = EmployersManager.getByName(EmployerName.getSelectedItem().toString());
            if (OrdersController.store(new Order(client.getId(), employer.getId(), ((JTextField) DateOrder.getDateEditor().getUiComponent()).getText() ))) {
                Table.setModel(OrdersManager.toTableModel(OrdersManager.getAll()));
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void ClientNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ClientNameItemStateChanged
        /*if (ClientId.getItemCount() != 0 && EmployerId.getItemCount() != 0) {
            String clientId = ClientId.getSelectedItem().toString();
            String employerId = EmployerId.getSelectedItem().toString();
            if (clientId.equals("Tout")) {
                if (employerId.equals("Tout")) {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getAll()));
                } else {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getByEmployer(Integer.parseInt(EmployerId.getSelectedItem().toString()))));
                }
            } else {
                if (employerId.equals("Tout")) {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getByClient(Integer.parseInt(ClientId.getSelectedItem().toString()))));
                } else {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getByClientEmployer(Integer.parseInt(ClientId.getSelectedItem().toString()), Integer.parseInt(EmployerId.getSelectedItem().toString()))));
                }
            }
        }*/
    }//GEN-LAST:event_ClientNameItemStateChanged

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if (good()) {
                Client client = ClientsManager.getByName(ClientName.getSelectedItem().toString());
                Employer employer = EmployersManager.getByName(EmployerName.getSelectedItem().toString());
                if (OrdersController.update(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), new Order(client.getId(), employer.getId(), ((JTextField) DateOrder.getDateEditor().getUiComponent()).getText()))) {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getAll()));
                }
            }

        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void DateOrderInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_DateOrderInputMethodTextChanged

    }//GEN-LAST:event_DateOrderInputMethodTextChanged

    private void DateOrderCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_DateOrderCaretPositionChanged

    }//GEN-LAST:event_DateOrderCaretPositionChanged

    private void EmployerNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_EmployerNameItemStateChanged
        /*if (ClientId.getItemCount() != 0 && EmployerId.getItemCount() != 0) {
            String clientId = ClientId.getSelectedItem().toString();
            String employerId = EmployerId.getSelectedItem().toString();
            if (clientId.equals("Tout")) {
                if (employerId.equals("Tout")) {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getAll()));
                } else {
                    JOptionPane.showMessageDialog(null, OrdersManager.getByEmployer(Integer.parseInt(EmployerId.getSelectedItem().toString())));
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getByEmployer(Integer.parseInt(EmployerId.getSelectedItem().toString()))));
                }
            } else {
                if (employerId.equals("Tout")) {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getByClient(Integer.parseInt(ClientId.getSelectedItem().toString()))));
                } else {
                    Table.setModel(OrdersManager.toTableModel(OrdersManager.getByClientEmployer(Integer.parseInt(ClientId.getSelectedItem().toString()), Integer.parseInt(EmployerId.getSelectedItem().toString()))));
                }
            }
        }*/
    }//GEN-LAST:event_EmployerNameItemStateChanged

    private void moreDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreDetailsActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            Main.showOrderDetails(Integer.parseInt(model.getValueAt(myIndex, 0).toString()));
        }
    }//GEN-LAST:event_moreDetailsActionPerformed

    private void TableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyTyped
        moreDetailsActionPerformed(null);
    }//GEN-LAST:event_TableKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ClientName;
    private com.toedter.calendar.JDateChooser DateOrder;
    private javax.swing.JComboBox<String> EmployerName;
    private javax.swing.JLabel Illustration;
    private javax.swing.JTable Table;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton moreDetails;
    private javax.swing.JScrollPane tab;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
