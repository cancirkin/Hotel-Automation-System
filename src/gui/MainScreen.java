package gui;

import gui.settings.IRegulator;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.ParseException;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author hsync
 */
public class MainScreen extends javax.swing.JFrame implements IRegulator {

    public MainScreen() {
        initComponents();
        connect();
        getAutoRoomId();
        getEdits();
        loadRoom();
        getAutoResarvationId();
        RoomTypeL();
        RoomNo();
        BedType();
        loadReservation();
        
    }

    Connection con;
    PreparedStatement pst;
    DefaultTableModel table;
    ResultSet res;
    
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

    public void getAutoRoomId() { //Odaların id'si primary olduğu için Rxxx şeklinde room olduğunu belirten R harfini başına ekleyip o düzende artış olmasını sağlıyoruz.
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(roomId) from room");
            rs.next();
            rs.getString("MAX(roomId)");

            if (rs.getString("MAX(roomId)") == null) {
                txtRoomNo.setText("R001");
            } else {
                long id = Long.parseLong(rs.getString("MAX(roomId)").substring(2, rs.getString("MAX(roomId)").length()));
                id++;
                txtRoomNo.setText("R" + String.format("%03d", id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override //Bir interface oluşturup getEdits metodu içerisinde düzenlemeleri yapıyoruz.
    public void getEdits() {
        this.txtRoomNo.setEnabled(false);
         setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("hotel.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRoom = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRoomNo = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        btnRoomSave = new javax.swing.JButton();
        btnRoomUpdate = new javax.swing.JButton();
        btnRoomDelete = new javax.swing.JButton();
        btnRoomClear = new javax.swing.JButton();
        cmbBed = new javax.swing.JComboBox<>();
        cmbRoomType = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservation = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtTelNo = new javax.swing.JTextField();
        txtTcNo = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbResRoomType = new javax.swing.JComboBox<>();
        cmbResRoomNo = new javax.swing.JComboBox<>();
        cmbResBedType = new javax.swing.JComboBox<>();
        btnResSave = new javax.swing.JButton();
        btnResUpdate = new javax.swing.JButton();
        btnResDelete = new javax.swing.JButton();
        btnResClean = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtResAmount = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        lblReservationId = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnYukari = new javax.swing.JButton();
        btnAsagi = new javax.swing.JButton();
        txtCheckIn = new com.toedter.calendar.JDateChooser();
        txtCheckOut = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 220, 233));

        tableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Oda No", "Oda Tipi", "Yatak Sayısı", "Fiyat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRoomMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableRoom);
        if (tableRoom.getColumnModel().getColumnCount() > 0) {
            tableRoom.getColumnModel().getColumn(0).setResizable(false);
            tableRoom.getColumnModel().getColumn(1).setResizable(false);
            tableRoom.getColumnModel().getColumn(2).setResizable(false);
            tableRoom.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Oda No");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Oda Tipi");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Yatak Sayısı");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fiyat");

        txtRoomNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtAmount.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnRoomSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRoomSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/floppy-disk (2).png"))); // NOI18N
        btnRoomSave.setText("  Kaydet");
        btnRoomSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomSaveActionPerformed(evt);
            }
        });

        btnRoomUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRoomUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_restart_24px.png"))); // NOI18N
        btnRoomUpdate.setText(" Güncelle");
        btnRoomUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomUpdateActionPerformed(evt);
            }
        });

        btnRoomDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRoomDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_delete_bin_24px.png"))); // NOI18N
        btnRoomDelete.setText("Sil");
        btnRoomDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomDeleteActionPerformed(evt);
            }
        });

        btnRoomClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRoomClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_broom_24px.png"))); // NOI18N
        btnRoomClear.setText("Temizle");
        btnRoomClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoomClearActionPerformed(evt);
            }
        });

        cmbBed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbBed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        cmbRoomType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GOLD", "SILVER", "BRONZE" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRoomSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnRoomUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnRoomDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnRoomClear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)))))
                .addGap(238, 238, 238))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbBed, cmbRoomType, txtRoomNo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRoomSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRoomUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRoomDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRoomClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbBed, cmbRoomType, jLabel1, txtAmount, txtRoomNo});

        jTabbedPane1.addTab("Oda İşlemleri", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 220, 233));

        tblReservation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ad Soyad", "T.C. No", "Tel No", "Mail", "Adres", "Check-In", "Check-Out", "Oda Tipi", "Oda No", "Yatak", "Fiyat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReservation);
        if (tblReservation.getColumnModel().getColumnCount() > 0) {
            tblReservation.getColumnModel().getColumn(0).setMinWidth(50);
            tblReservation.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblReservation.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Ad Soyad");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("T.C No");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Telefon");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Mail");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Check-In");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Adres");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Check-Out");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Oda Tipi");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Oda No");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Yatak Sayısı");

        btnResSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/floppy-disk (2).png"))); // NOI18N
        btnResSave.setText("Kaydet");
        btnResSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResSaveActionPerformed(evt);
            }
        });

        btnResUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_restart_24px.png"))); // NOI18N
        btnResUpdate.setText("Güncelle");
        btnResUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResUpdateActionPerformed(evt);
            }
        });

        btnResDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_delete_bin_24px.png"))); // NOI18N
        btnResDelete.setText("Sil");
        btnResDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResDeleteActionPerformed(evt);
            }
        });

        btnResClean.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnResClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/icons/icons8_broom_24px.png"))); // NOI18N
        btnResClean.setText("Temizle");
        btnResClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResCleanActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Fiyat");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Ara:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Rezervasyon No");

        lblReservationId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout.setText("Çıkış Yap");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnYukari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnYukari.setText("YUKARI");
        btnYukari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYukariActionPerformed(evt);
            }
        });

        btnAsagi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAsagi.setText("AŞAĞI");
        btnAsagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsagiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(4, 4, 4)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addComponent(jLabel8))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(4, 4, 4)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addComponent(jLabel12))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(30, 30, 30)
                                            .addComponent(jLabel14))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel10)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel15))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel16)))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtResAmount)
                                    .addComponent(cmbResBedType, 0, 170, Short.MAX_VALUE)
                                    .addComponent(txtTcNo)
                                    .addComponent(txtTelNo)
                                    .addComponent(txtMail)
                                    .addComponent(txtAddress)
                                    .addComponent(cmbResRoomType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbResRoomNo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnResSave)
                            .addComponent(btnResDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResClean, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnResUpdate))
                        .addGap(24, 24, 24)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnYukari)
                                .addGap(18, 18, 18)
                                .addComponent(btnAsagi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblReservationId)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(251, 251, 251))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnResClean, btnResDelete, btnResSave, btnResUpdate});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAsagi, btnYukari});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addGap(10, 10, 10)
                .addComponent(lblReservationId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6))
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnYukari)
                        .addComponent(btnAsagi)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel8)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel9)
                                .addGap(60, 60, 60)
                                .addComponent(jLabel11)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txtTelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbResRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbResRoomNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cmbResBedType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtResAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResSave)
                            .addComponent(btnResUpdate))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnResDelete)
                            .addComponent(btnResClean))
                        .addGap(26, 26, 26))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbResBedType, cmbResRoomNo, cmbResRoomType});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnResClean, btnResDelete, btnResSave});

        jTabbedPane1.addTab("Rezervasyon İşlemleri", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnResSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResSaveActionPerformed
        String reservationNo = lblReservationId.getText(); //Rezervasyon işlemleri için verileri değişkenlere atıyoruz.
        String name = txtName.getText();
        String tcNo = txtTcNo.getText();
        String address = txtAddress.getText();
        String telNo = txtTelNo.getText();
        String mail = txtMail.getText();
        String amount = txtResAmount.getText();
        // Check in ve Check out işlemlerimiz için tarihleri SimpleDateFormat şeklinde alıyoruz.
        SimpleDateFormat d1 = new SimpleDateFormat("dd-MM--yyyy");
        String checkIn = d1.format(txtCheckIn.getDate());

        SimpleDateFormat d2 = new SimpleDateFormat("dd-MM--yyyy");
        String checkOut = d2.format(txtCheckOut.getDate());

        String roomType = cmbResRoomType.getSelectedItem().toString();
        String bedType = cmbResBedType.getSelectedItem().toString();
        String roomNo = cmbResRoomNo.getSelectedItem().toString();

        try {
            pst = con.prepareStatement("insert into reservation (reservationId,nameSurname,tcNo,telNo,mail,address,checkIn,checkOut,roomType,roomNo,bedType,amount)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, reservationNo);
            pst.setString(2, name);
            pst.setString(3, tcNo);
            pst.setString(4, telNo);
            pst.setString(5, mail);
            pst.setString(6, address);
            pst.setString(7, checkIn);
            pst.setString(8, checkOut);
            pst.setString(9, roomType);
            pst.setString(10, roomNo);
            pst.setString(11, bedType);
            pst.setString(12, amount);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rezervasyon başarıyla yapıldı.");

            txtName.setText("");
            txtTcNo.setText("");
            txtTelNo.setText("");
            txtMail.setText("");
            txtAddress.setText("");
            cmbResBedType.setSelectedIndex(-1);
            cmbResRoomNo.setSelectedIndex(-1);
            cmbResRoomType.setSelectedIndex(-1);
            txtAmount.setText("");
            loadReservation();

            getAutoResarvationId();
            //loadRoom();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResSaveActionPerformed

    private void btnRoomSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomSaveActionPerformed
        //Oda ekleme butonunun altında textfield ve combobox'taki değerleri değişkenlere atıyoruz.
        String roomNo = txtRoomNo.getText();
        String roomType = cmbRoomType.getSelectedItem().toString();
        String bedType = cmbBed.getSelectedItem().toString();
        String amount = txtAmount.getText();

        try {
            pst = con.prepareStatement("insert into room (roomId,roomType,bedType,amount) values (?,?,?,?)");
            pst.setString(1, roomNo);
            pst.setString(2, roomType);
            pst.setString(3, bedType);
            pst.setString(4, amount);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Oda başarıyla eklendi.");
            cmbRoomType.setSelectedIndex(-1);
            cmbBed.setSelectedIndex(-1);
            txtAmount.setText("");
            getAutoRoomId();
            loadRoom();
            RoomTypeL();
            RoomNo();
            BedType();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRoomSaveActionPerformed

    private void tableRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRoomMouseClicked
        table = (DefaultTableModel) tableRoom.getModel(); //Room table'ında bulunan verileri textfield'ların içine doldurma işlemi.
        int selectedIndex = tableRoom.getSelectedRow();

        txtRoomNo.setText(table.getValueAt(selectedIndex, 0).toString());
        cmbRoomType.setSelectedItem(table.getValueAt(selectedIndex, 1).toString());
        cmbBed.setSelectedItem(table.getValueAt(selectedIndex, 2).toString());
        txtAmount.setText(table.getValueAt(selectedIndex, 3).toString());
        btnRoomSave.setEnabled(false);
    }//GEN-LAST:event_tableRoomMouseClicked

    private void btnRoomUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomUpdateActionPerformed
        String roomNo = txtRoomNo.getText(); //Oda güncelleme işlemleri
        String roomType = cmbRoomType.getSelectedItem().toString();
        String bedType = cmbBed.getSelectedItem().toString();
        String amount = txtAmount.getText();

        try {
            pst = con.prepareStatement("update room set roomType=?,bedType=?,amount=? where roomId=?");
            pst.setString(1, roomType);
            pst.setString(2, bedType);
            pst.setString(3, amount);
            pst.setString(4, roomNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Oda bilgileri başarıyla güncellendi.");

            cmbRoomType.setSelectedIndex(-1);
            cmbBed.setSelectedIndex(-1);
            txtAmount.setText("");
            getAutoRoomId();
            loadRoom();
            btnRoomSave.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRoomUpdateActionPerformed

    private void btnRoomClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomClearActionPerformed
        cmbRoomType.setSelectedIndex(-1); // Oda ekle menüsündeki kutucukların temizlenmesi
        cmbBed.setSelectedIndex(-1);
        txtAmount.setText("");
        getAutoRoomId();
        loadRoom();
        btnRoomSave.setEnabled(true);
    }//GEN-LAST:event_btnRoomClearActionPerformed

    private void btnRoomDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoomDeleteActionPerformed
        String roomNo = txtRoomNo.getText(); //Oda silme işlemleri
        try {
            pst = con.prepareStatement("delete from room where roomId=?");
            pst.setString(1, roomNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Oda Silindi.");

            cmbRoomType.setSelectedIndex(-1);
            cmbBed.setSelectedIndex(-1);
            txtAmount.setText("");
            getAutoRoomId();
            loadRoom();
            btnRoomSave.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRoomDeleteActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginScreen l = new LoginScreen();
        this.setVisible(false);
        l.setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tblReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservationMouseClicked
        try { //Burada rezervasyon tablosundaki verileri textfieldların içine çekiyorum. Table'da bulunan date'i date formatında geri çekebilmek için try catch içine aldım.
            table = (DefaultTableModel) tblReservation.getModel();
            int selectedIndex = tblReservation.getSelectedRow();
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse((String) table.getValueAt(selectedIndex, 6));
            txtCheckIn.setDate(date);
            Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse((String) table.getValueAt(selectedIndex, 7));
            txtCheckOut.setDate(date2);
            txtName.setText(table.getValueAt(selectedIndex, 1).toString());
            txtTcNo.setText(table.getValueAt(selectedIndex, 2).toString());
            cmbResRoomType.setSelectedItem(table.getValueAt(selectedIndex, 8).toString());
            cmbResBedType.setSelectedItem(table.getValueAt(selectedIndex, 10).toString());
            cmbResRoomNo.setSelectedItem(table.getValueAt(selectedIndex, 9).toString());
            txtTelNo.setText(table.getValueAt(selectedIndex, 3).toString());
            txtMail.setText(table.getValueAt(selectedIndex, 4).toString());
            txtAddress.setText(table.getValueAt(selectedIndex, 5).toString());

            // txtCheckOut.setText(table.getValueAt(selectedIndex, 7).toString());
            txtResAmount.setText(table.getValueAt(selectedIndex, 11).toString());
            lblReservationId.setText(table.getValueAt(selectedIndex, 0).toString());

            btnResSave.setEnabled(false);
        } catch (ParseException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblReservationMouseClicked

    private void btnResUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResUpdateActionPerformed
        String reservationNo = lblReservationId.getText(); //REZERVASYON GÜNCELLEME İŞLEMLERİ
        String name = txtName.getText();
        String tcNo = txtTcNo.getText();
        String address = txtAddress.getText();
        String telNo = txtTelNo.getText();
        String mail = txtMail.getText();
        String amount = txtResAmount.getText();
        // Check in ve Check out işlemlerimiz için tarihleri SimpleDateFormat şeklinde alıyoruz.
        SimpleDateFormat d1 = new SimpleDateFormat("dd-MM--yyyy");
        String checkIn = d1.format(txtCheckIn.getDate());

        SimpleDateFormat d2 = new SimpleDateFormat("dd-MM--yyyy");
        String checkOut = d2.format(txtCheckOut.getDate());

        String roomType = cmbResRoomType.getSelectedItem().toString();
        String bedType = cmbResBedType.getSelectedItem().toString();
        String roomNo = cmbResRoomNo.getSelectedItem().toString();

        try {
            pst = con.prepareStatement("update reservation set nameSurname=?,tcNo=?,telNo=?,mail=?,address=?,checkIn=?,checkOut=?,roomType=?,roomNo=?,bedType=?,amount=? where reservationId=?");

            pst.setString(1, name);
            pst.setString(2, tcNo);
            pst.setString(3, telNo);
            pst.setString(4, mail);
            pst.setString(5, address);
            pst.setString(6, checkIn);
            pst.setString(7, checkOut);
            pst.setString(8, roomType);
            pst.setString(9, roomNo);
            pst.setString(10, bedType);
            pst.setString(11, amount);
            pst.setString(12, reservationNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rezervasyon bilgileri güncellendi.");

            txtName.setText("");
            txtTcNo.setText("");
            txtTelNo.setText("");
            txtMail.setText("");
            txtAddress.setText("");
            cmbResBedType.setSelectedIndex(-1);
            cmbResRoomNo.setSelectedIndex(-1);
            cmbResRoomType.setSelectedIndex(-1);
            txtAmount.setText("");
            loadReservation();
            getAutoResarvationId();
            //loadRoom();
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResUpdateActionPerformed

    private void btnResDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResDeleteActionPerformed
        String reservationNo = lblReservationId.getText(); //Rezervasyon silme işlemleri
        try {
            pst = con.prepareStatement("delete from reservation where reservationId=?");
            pst.setString(1, reservationNo);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Rezervasyon Silindi.");

            txtName.setText("");
            txtTcNo.setText("");
            txtTelNo.setText("");
            txtMail.setText("");
            txtAddress.setText("");
            cmbResBedType.setSelectedIndex(-1);
            cmbResRoomNo.setSelectedIndex(-1);
            cmbResRoomType.setSelectedIndex(-1);
            txtResAmount.setText("");
            txtCheckIn.setDate(null);
            txtCheckOut.setDate(null);
            getAutoResarvationId();
            loadReservation();
            btnResSave.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResDeleteActionPerformed

    private void btnResCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResCleanActionPerformed
        txtName.setText(""); //Tüm textfield'ları temizleme işlemi
        txtTcNo.setText("");
        txtTelNo.setText("");
        txtMail.setText("");
        txtAddress.setText("");
        cmbResBedType.setSelectedIndex(-1);
        cmbResRoomNo.setSelectedIndex(-1);
        cmbResRoomType.setSelectedIndex(-1);
        txtResAmount.setText("");
        txtCheckIn.setDate(null);
        txtCheckOut.setDate(null);
        btnResSave.setEnabled(true);
    }//GEN-LAST:event_btnResCleanActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey = txtSearch.getText(); //Table içinde arama yapmak için TableRowSorter'dan faydalandık.
        TableRowSorter<DefaultTableModel> tableRowSorter
                = new TableRowSorter<DefaultTableModel>(table);
        tblReservation.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(searchKey));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnYukariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYukariActionPerformed
        kayitGetir("geri");
    }//GEN-LAST:event_btnYukariActionPerformed

    private void btnAsagiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsagiActionPerformed
        kayitGetir("ileri");
        
    }//GEN-LAST:event_btnAsagiActionPerformed
    public void kayitGetir(String yon){
        int index;
        index = tblReservation.getSelectedRow();
        try{
            if (yon.equals("ileri")) {
            if(index < table.getRowCount()){
            table.moveRow(index, index, index +1);
            tblReservation.setRowSelectionInterval(index +1, index +1);
        }
            } else if (yon.equals("geri")) {
                if(index < table.getRowCount()){
            table.moveRow(index, index, index -1);
            tblReservation.setRowSelectionInterval(index -1, index -1);
        }
            } else if (yon.equals("ilk")) {
                
                index = tblReservation.getSelectedRow();
                
                
            } else if (yon.equals("son")) {
                res.last();
            }
            
      /*  
        if(index > 0){
            table.moveRow(index, index, index-1);
            tblReservation.setRowSelectionInterval(index -1, index -1);
        }
            */
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
        
    }
    

    public void loadRoom() { //Odaları table'ın içine çekme işlemini yapıyoruz.
        int c;
        try {
            pst = con.prepareStatement("select * from room");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            table = (DefaultTableModel) tableRoom.getModel();
            table.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("roomId"));
                    v2.add(rs.getString("roomType"));
                    v2.add(rs.getString("bedType"));
                    v2.add(rs.getString("amount"));
                }
                table.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //----------------------------------------------RESERVATION------------------------------------------------------------------------------------------------
    //----------------------------------------------RESERVATION------------------------------------------------------------------------------------------------
    //----------------------------------------------RESERVATION------------------------------------------------------------------------------------------------
    //----------------------------------------------RESERVATION------------------------------------------------------------------------------------------------

    public void getAutoResarvationId() { //Odaların id'si primary olduğu için Rxxx şeklinde room olduğunu belirten R harfini başına ekleyip o düzende artış olmasını sağlıyoruz.
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(reservationId) from reservation");
            rs.next();
            rs.getString("MAX(reservationId)");

            if (rs.getString("MAX(reservationId)") == null) {
                lblReservationId.setText("RE001");
            } else {
                long id = Long.parseLong(rs.getString("MAX(reservationId)").substring(2, rs.getString("MAX(reservationId)").length()));
                id++;
                lblReservationId.setText("RE" + String.format("%03d", id));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void RoomTypeL() { //Oda ekleme kısmındaki bilgileri rezervasyon ekranındaki combo box'ların içine çekiyoruz.
        try {
            pst = con.prepareStatement("select Distinct roomType from room");
            ResultSet rs = pst.executeQuery();
            cmbResRoomType.removeAllItems();
            while (rs.next()) {
                cmbResRoomType.addItem(rs.getString("roomType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void RoomNo() { //Oda ekleme kısmındaki bilgileri rezervasyon ekranındaki combo box'ların içine çekiyoruz.
        try {
            pst = con.prepareStatement("select Distinct roomId from room");
            ResultSet rs = pst.executeQuery();
            cmbResRoomNo.removeAllItems();
            while (rs.next()) {
                cmbResRoomNo.addItem(rs.getString("roomId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void BedType() { //Oda ekleme kısmındaki bilgileri rezervasyon ekranındaki combo box'ların içine çekiyoruz.
        try {
            pst = con.prepareStatement("select Distinct bedType from room");
            ResultSet rs = pst.executeQuery();
            cmbResBedType.removeAllItems();
            while (rs.next()) {
                cmbResBedType.addItem(rs.getString("bedType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadReservation() { //Rezervasyonları database'den table'a çekiyoruz.
        int c;
        try {
            pst = con.prepareStatement("select * from reservation");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            table = (DefaultTableModel) tblReservation.getModel();
            table.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("reservationId"));
                    v2.add(rs.getString("nameSurname"));
                    v2.add(rs.getString("tcNo"));
                    v2.add(rs.getString("telNo"));
                    v2.add(rs.getString("mail"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("checkIn"));
                    v2.add(rs.getString("checkOut"));
                    v2.add(rs.getString("roomType"));
                    v2.add(rs.getString("roomNo"));
                    v2.add(rs.getString("bedType"));
                    v2.add(rs.getString("amount"));
                }
                table.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
    ----YAPILACAKLAR----
    3-PERSONEL İŞLEMLERİ
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);

            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsagi;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnResClean;
    private javax.swing.JButton btnResDelete;
    private javax.swing.JButton btnResSave;
    private javax.swing.JButton btnResUpdate;
    private javax.swing.JButton btnRoomClear;
    private javax.swing.JButton btnRoomDelete;
    private javax.swing.JButton btnRoomSave;
    private javax.swing.JButton btnRoomUpdate;
    private javax.swing.JButton btnYukari;
    private javax.swing.JComboBox<String> cmbBed;
    private javax.swing.JComboBox<String> cmbResBedType;
    private javax.swing.JComboBox<String> cmbResRoomNo;
    private javax.swing.JComboBox<String> cmbResRoomType;
    private javax.swing.JComboBox<String> cmbRoomType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblReservationId;
    private javax.swing.JTable tableRoom;
    private javax.swing.JTable tblReservation;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAmount;
    private com.toedter.calendar.JDateChooser txtCheckIn;
    private com.toedter.calendar.JDateChooser txtCheckOut;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtResAmount;
    private javax.swing.JTextField txtRoomNo;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTcNo;
    private javax.swing.JTextField txtTelNo;
    // End of variables declaration//GEN-END:variables
}
