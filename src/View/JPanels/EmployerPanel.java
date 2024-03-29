/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.JPanels;

import Controllers.EmployersController;
import Models.Entities.Employer;
import Models.EntitiesManagers.EmployersManager;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mawena
 */
public class EmployerPanel extends javax.swing.JPanel {

    /**
     * Creates new form StockPanel
     */
    String selectedImgPath = "";

    public EmployerPanel() {
        initComponents();
        Table.setModel(EmployersManager.toTableModel(EmployersManager.getAll()));
        //updateButton.setEnabled(false);
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        changeBirthDate(currentDate);
        disableButton();
    }

    public void changeBirthDate(String birthDate) {
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(birthDate);   //On formatte correctement la date
            BirthDate.setDate(date);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "La date est invalide");
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
        Table = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        LastName = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        Tel = new javax.swing.JTextField();
        Illustration = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        Search = new javax.swing.JTextField();
        Function = new javax.swing.JTextField();
        BirthDate = new com.toedter.calendar.JDateChooser();
        Sex = new javax.swing.JComboBox<>();
        Photo = new javax.swing.JLabel();
        photoButton = new javax.swing.JButton();

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

        LastName.setBackground(new java.awt.Color(255, 255, 255));
        LastName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        LastName.setForeground(new java.awt.Color(34, 67, 128));
        LastName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nom", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        FirstName.setBackground(new java.awt.Color(255, 255, 255));
        FirstName.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        FirstName.setForeground(new java.awt.Color(34, 67, 128));
        FirstName.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prénoms", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });

        Tel.setBackground(new java.awt.Color(255, 255, 255));
        Tel.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Tel.setForeground(new java.awt.Color(34, 67, 128));
        Tel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        Illustration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Images/Employers.png"))); // NOI18N

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
        clearButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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

        Function.setBackground(new java.awt.Color(255, 255, 255));
        Function.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        Function.setForeground(new java.awt.Color(34, 67, 128));
        Function.setText("Gerant");
        Function.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fonction", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N

        BirthDate.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date naissance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(34, 67, 128)), "Date Naisson", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(34, 67, 128))); // NOI18N
        BirthDate.setDateFormatString("yyyy-MM-dd");

        Sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        photoButton.setBackground(new java.awt.Color(255, 255, 255));
        photoButton.setForeground(new java.awt.Color(34, 67, 128));
        photoButton.setText("Ajouter Photo");
        photoButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        photoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Illustration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Sex, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BirthDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(FirstName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Function)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(photoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Search)
                    .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(photoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Sex, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Tel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Illustration, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tab)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearForm() {
        LastName.setText("");
        FirstName.setText("");
        Tel.setText("");
    }

    private void disableButton() {
        updateButton.setVisible(false);
        deleteButton.setVisible(false);
    }

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        disableButton();
        if (selectedImgPath == null) {
            JOptionPane.showMessageDialog(null, "La photo est manquante!");
        } else {
            if (selectedImgPath.equals("")) {
                JOptionPane.showMessageDialog(null, "La photo est manquante!");
            } else {
                if (EmployersController.store(new Employer(LastName.getText(), FirstName.getText(), ((JTextField) BirthDate.getDateEditor().getUiComponent()).getText(), Sex.getSelectedItem().toString(), Function.getText(), Tel.getText(), selectedImgPath))) {
                    clearForm();
                    Table.setModel(EmployersManager.toTableModel(EmployersManager.getAll()));
                }
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
            if (EmployersController.destroy(Integer.parseInt(model.getValueAt(myIndex, 0).toString()))) {
                clearForm();
                Table.setModel(EmployersManager.toTableModel(EmployersManager.getAll()));
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
        LastName.setText(model.getValueAt(myIndex, 1).toString());
        FirstName.setText(model.getValueAt(myIndex, 2).toString());
        Sex.setSelectedItem(model.getValueAt(myIndex, 4).toString());
        Function.setText(model.getValueAt(myIndex, 5).toString());
        Tel.setText(model.getValueAt(myIndex, 6).toString());
        
        Employer employer = EmployersManager.get(Integer.parseInt(model.getValueAt(myIndex, 0).toString()));
        selectedImgPath = employer.getPhoto();
        ImageIcon imgIC = new ImageIcon(selectedImgPath);
        Image image = imgIC.getImage().getScaledInstance(Photo.getWidth(), Photo.getHeight(), Image.SCALE_SMOOTH);
        Photo.setIcon(new ImageIcon(image));
    }//GEN-LAST:event_TableMouseClicked

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        disableButton();
        Table.setModel(EmployersManager.toTableModel(EmployersManager.search(Search.getText())));
    }//GEN-LAST:event_SearchKeyReleased

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        disableButton();
        int myIndex = Table.getSelectedRow();
        if (myIndex == -1) {
            JOptionPane.showMessageDialog(null, "Aucune ligne du tableau n'est sélectionné");
        } else {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            if (selectedImgPath.equals("")) {
                JOptionPane.showMessageDialog(null, "La photo est manquante!");
            } else {
                if (EmployersController.update(Integer.parseInt(model.getValueAt(myIndex, 0).toString()), new Employer(LastName.getText(), FirstName.getText(), ((JTextField) BirthDate.getDateEditor().getUiComponent()).getText(), Sex.getSelectedItem().toString(), Function.getText(), Tel.getText(), selectedImgPath))) {
                    clearForm();
                    Table.setModel(EmployersManager.toTableModel(EmployersManager.getAll()));
                }
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void TableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_TableMouseReleased

    private void photoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photoButtonActionPerformed
        JFileChooser browserImageFile = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browserImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browserImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browserImageFile.getSelectedFile();
            selectedImgPath = selectedImageFile.getAbsolutePath();
            //JOptionPane.showMessageDialog(null, selectedImagePath);

            ImageIcon imgIC = new ImageIcon(selectedImgPath);

            Image image = imgIC.getImage().getScaledInstance(Photo.getWidth(), Photo.getHeight(), Image.SCALE_SMOOTH);

            Photo.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_photoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser BirthDate;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField Function;
    private javax.swing.JLabel Illustration;
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel Photo;
    private javax.swing.JTextField Search;
    private javax.swing.JComboBox<String> Sex;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton photoButton;
    private javax.swing.JScrollPane tab;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
