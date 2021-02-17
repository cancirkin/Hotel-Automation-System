
package gui;

import gui.settings.ActionSettings;
import gui.settings.IRegulator;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PersonelSettings extends javax.swing.JFrame implements IRegulator {

    @Override
    public void getEdits() {
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("hotel.png")));
    }

    
    public PersonelSettings() {
        initComponents();
        connect();
        loadPersonel();
        getEdits();
    }
    Connection con;
    PreparedStatement pst;
    DefaultTableModel table;

    public void connect() { //Database bağlantısını yapıyoruz
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/otel", "root", "can1192123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadPersonel() { //Personelleri table'ın içine çekme işlemini yapıyoruz.
        int c;
        try {
            pst = con.prepareStatement("select * from user");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            table = (DefaultTableModel) tblPersonel.getModel();
            table.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("userId"));
                    v2.add(rs.getString("personelName"));
                    v2.add(rs.getString("personelTcNo"));
                    v2.add(rs.getString("personelTelNo"));
                    v2.add(rs.getString("personelMail"));
                    v2.add(rs.getString("personelMaas"));
                    v2.add(rs.getString("personelAddress"));
                    v2.add(rs.getString("username"));
                    v2.add(rs.getString("password"));
                }
                table.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtPersonelName = new javax.swing.JTextField();
        txtPersonelTel = new javax.swing.JTextField();
        txtPersonelTc = new javax.swing.JTextField();
        txtPersonelMail = new javax.swing.JTextField();
        txtPersonelAddress = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPersonel = new javax.swing.JTable();
        txtPersonelMaas = new javax.swing.JTextField();
        txtPersonelUsername = new javax.swing.JTextField();
        txtPersonelPassword = new javax.swing.JTextField();
        btnAddPersonel = new javax.swing.JButton();
        btnPersonelDelete = new javax.swing.JButton();
        btnPersonelUpdate = new javax.swing.JButton();
        btnPersonelClean = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        lblPersonelID = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Mail");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Adres");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("T.C No");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Telefon");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Ad Soyad");

        txtPersonelName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPersonelTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPersonelTc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPersonelMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPersonelAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Maaş");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Kullanıcı Adı");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Şifre");

        tblPersonel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Ad Soyad", "Tc No", "Telefon", "Mail", "Maaş", "Adres", "Kullanıcı Adı", "Şifre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPersonel.setGridColor(new java.awt.Color(0, 0, 0));
        tblPersonel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPersonel);

        txtPersonelMaas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPersonelUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPersonelPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAddPersonel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddPersonel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/floppy-disk (2).png"))); // NOI18N
        btnAddPersonel.setText("Ekle");
        btnAddPersonel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPersonelActionPerformed(evt);
            }
        });

        btnPersonelDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPersonelDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_delete_bin_24px.png"))); // NOI18N
        btnPersonelDelete.setText("Sil");
        btnPersonelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonelDeleteActionPerformed(evt);
            }
        });

        btnPersonelUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPersonelUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_restart_24px.png"))); // NOI18N
        btnPersonelUpdate.setText("Güncelle");
        btnPersonelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonelUpdateActionPerformed(evt);
            }
        });

        btnPersonelClean.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPersonelClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_broom_24px.png"))); // NOI18N
        btnPersonelClean.setText("Temizle");
        btnPersonelClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonelCleanActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Personel ID");

        lblPersonelID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/back.png"))); // NOI18N
        lblBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnPersonelUpdate)
                        .addGap(46, 46, 46)
                        .addComponent(btnPersonelDelete)
                        .addGap(43, 43, 43)
                        .addComponent(btnPersonelClean)
                        .addGap(527, 527, 527))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPersonelName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPersonelMail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPersonelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(228, 228, 228)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPersonelTc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPersonelMaas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(136, 136, 136)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPersonelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPersonelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPersonelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(122, 122, 122)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblPersonelID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblBack)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddPersonel, btnPersonelClean, btnPersonelDelete, btnPersonelUpdate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPersonelName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPersonelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPersonelMail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addGap(52, 52, 52)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtPersonelTel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPersonelTc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel25)
                                                .addComponent(txtPersonelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtPersonelMaas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel23))
                                                .addGap(52, 52, 52)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnPersonelClean)
                                            .addComponent(btnPersonelUpdate)
                                            .addComponent(btnAddPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnPersonelDelete)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel19))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(txtPersonelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(jLabel27))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblPersonelID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddPersonel, btnPersonelClean, btnPersonelDelete, btnPersonelUpdate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPersonelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonelMouseClicked
        table = (DefaultTableModel) tblPersonel.getModel(); //Personel tablosundaki verileri tıklandığında textfield'ların içine atmak.
        int selectedIndex = tblPersonel.getSelectedRow();

        lblPersonelID.setText(table.getValueAt(selectedIndex, 0).toString());
        txtPersonelName.setText(table.getValueAt(selectedIndex, 1).toString());
        txtPersonelTc.setText(table.getValueAt(selectedIndex, 2).toString());
        txtPersonelTel.setText(table.getValueAt(selectedIndex, 3).toString());
        txtPersonelMail.setText(table.getValueAt(selectedIndex, 4).toString());
        txtPersonelAddress.setText(table.getValueAt(selectedIndex, 6).toString());
        txtPersonelMaas.setText(table.getValueAt(selectedIndex, 5).toString());
        txtPersonelUsername.setText(table.getValueAt(selectedIndex, 7).toString());
        txtPersonelPassword.setText(table.getValueAt(selectedIndex, 8).toString());

        btnAddPersonel.setEnabled(false);
    }//GEN-LAST:event_tblPersonelMouseClicked

    private void btnAddPersonelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPersonelActionPerformed
        String personelId = lblPersonelID.getText(); //PERSONEL EKLEME İŞLEMLERİ
        String personelName = txtPersonelName.getText();
        String personelTc = txtPersonelTc.getText();
        String personelTel = txtPersonelTel.getText();
        String personelMail = txtPersonelMail.getText();
        String personelAddress = txtPersonelAddress.getText();
        String personelMaas = txtPersonelMaas.getText();
        String personelUsername = txtPersonelUsername.getText();
        String personelPassword = txtPersonelPassword.getText();

        try {
            pst = con.prepareStatement("insert into user (personelName,personelTcNo,personelTelNo,personelMail,personelMaas,personelAddress,username,password) VALUES"
                + "(?,?,?,?,?,?,?,?)");

            pst.setString(1, personelName);
            pst.setString(2, personelTc);
            pst.setString(3, personelTel);
            pst.setString(4, personelMail);
            pst.setString(5, personelMaas);
            pst.setString(6, personelAddress);
            pst.setString(7, personelUsername);
            pst.setString(8, personelPassword);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Personel başarıyla eklendi.");
            loadPersonel();

            lblPersonelID.setText("");
            txtPersonelName.setText("");
            txtPersonelTc.setText("");
            txtPersonelTel.setText("");
            txtPersonelMail.setText("");
            txtPersonelAddress.setText("");
            txtPersonelMaas.setText("");
            txtPersonelUsername.setText("");
            txtPersonelPassword.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddPersonelActionPerformed

    private void btnPersonelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonelDeleteActionPerformed
        String personelId = lblPersonelID.getText(); //Personel silme işlemleri
        try {
            pst = con.prepareStatement("delete from user where userId=?");
            pst.setString(1, personelId);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Personel Silindi.");

            lblPersonelID.setText("");
            txtPersonelName.setText("");
            txtPersonelTc.setText("");
            txtPersonelTel.setText("");
            txtPersonelMail.setText("");
            txtPersonelAddress.setText("");
            txtPersonelMaas.setText("");
            txtPersonelUsername.setText("");
            txtPersonelPassword.setText("");

            loadPersonel();
            btnAddPersonel.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPersonelDeleteActionPerformed

    private void btnPersonelUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonelUpdateActionPerformed
        String personelId = lblPersonelID.getText(); //PERSONEL GÜNCELLEME İŞLEMİ
        String personelName = txtPersonelName.getText();
        String personelTc = txtPersonelTc.getText();
        String personelTel = txtPersonelTel.getText();
        String personelMail = txtPersonelMail.getText();
        String personelAddress = txtPersonelAddress.getText();
        String personelMaas = txtPersonelMaas.getText();
        String personelUsername = txtPersonelUsername.getText();
        String personelPassword = txtPersonelPassword.getText();

        try {
            pst = con.prepareStatement("update user set personelName=?, personelTcNo=?, personelTelNo=?, personelMail=?, personelMaas=?, personelAddress=?, username=?, password=? where userId=?");

            pst.setString(1, personelName);
            pst.setString(2, personelTc);
            pst.setString(3, personelTel);
            pst.setString(4, personelMail);
            pst.setString(5, personelMaas);
            pst.setString(6, personelAddress);
            pst.setString(7, personelUsername);
            pst.setString(8, personelPassword);
            pst.setString(9, personelId);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Personel bilgileri başarıyla\n güncellendi");
            loadPersonel();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPersonelUpdateActionPerformed

    private void btnPersonelCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonelCleanActionPerformed
        lblPersonelID.setText(""); //Textfield'ların içini boşaltma işlemi
        txtPersonelName.setText("");
        txtPersonelTc.setText("");
        txtPersonelTel.setText("");
        txtPersonelMail.setText("");
        txtPersonelAddress.setText("");
        txtPersonelMaas.setText("");
        txtPersonelUsername.setText("");
        txtPersonelPassword.setText("");

        btnAddPersonel.setEnabled(true);
    }//GEN-LAST:event_btnPersonelCleanActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        ActionSettings.setVisible(this, new AdminScreen());
    }//GEN-LAST:event_lblBackMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersonelSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonelSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonelSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonelSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersonelSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPersonel;
    private javax.swing.JButton btnPersonelClean;
    private javax.swing.JButton btnPersonelDelete;
    private javax.swing.JButton btnPersonelUpdate;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblPersonelID;
    private javax.swing.JTable tblPersonel;
    private javax.swing.JTextField txtPersonelAddress;
    private javax.swing.JTextField txtPersonelMaas;
    private javax.swing.JTextField txtPersonelMail;
    private javax.swing.JTextField txtPersonelName;
    private javax.swing.JTextField txtPersonelPassword;
    private javax.swing.JTextField txtPersonelTc;
    private javax.swing.JTextField txtPersonelTel;
    private javax.swing.JTextField txtPersonelUsername;
    // End of variables declaration//GEN-END:variables
}
