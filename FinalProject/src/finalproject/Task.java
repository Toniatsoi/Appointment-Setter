package finalproject;

import java.io.File;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Task extends javax.swing.JFrame {
      File f = new File("");
      
        public Task() {
            initComponents();
            PanelView.setVisible(false);   
            connect();
            loadname();
            fetch();
        }
        
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
        public void connect(){
          try {
              Class.forName("com.mysql.jdbc.Driver");
              con =DriverManager.getConnection("jdbc:mysql://localhost/appointment","root","");
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        public void  loadname(){
          try {
              pst = con.prepareStatement("SELECT ID FROM booking");
              rs = pst.executeQuery();
              
              ID.removeAllItems();
              while(rs.next()){
                  ID.addItem(rs.getString(1));
              }
          } catch (SQLException ex) {
              Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        private void fetch(){
          try {
              int q;
              pst = con.prepareStatement("SELECT * FROM booking");
              rs = pst.executeQuery();
              ResultSetMetaData rss = rs.getMetaData();
              q = rss.getColumnCount();
              
              DefaultTableModel df = (DefaultTableModel)PanelSetView.getModel();
              df.setRowCount(0);
              
              while(rs.next()){
                  Vector v2 = new Vector();
                  for(int a = 1; a <= q; a++){
                      v2.add(rs.getString("Client"));
                      v2.add(rs.getString("Time"));
                      v2.add(rs.getString("Service"));
                      v2.add(rs.getString("Masseuse"));
                      v2.add(rs.getString("Year"));
                      v2.add(rs.getString("Month"));
                      v2.add(rs.getString("Date"));
                      v2.add(rs.getString("ID"));
                  }df.addRow(v2);
              }
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        SetPanel = new javax.swing.JPanel();
        Set = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        ViewPanel = new javax.swing.JPanel();
        View = new javax.swing.JLabel();
        PanelView = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelSetView = new javax.swing.JTable();
        PanelSet = new javax.swing.JPanel();
        NameField = new javax.swing.JTextField();
        FirstName = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        Time = new javax.swing.JLabel();
        Kind = new javax.swing.JLabel();
        Person = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Confirm = new javax.swing.JButton();
        Kinds = new javax.swing.JComboBox<>();
        PersonBox = new javax.swing.JComboBox<>();
        TimeField = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        Search = new javax.swing.JButton();
        FirstName1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ID = new javax.swing.JComboBox<>();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(0, 102, 102));
        MainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        SetPanel.setBackground(new java.awt.Color(204, 255, 255));
        SetPanel.setInheritsPopupMenu(true);
        SetPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetPanelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SetPanelMouseExited(evt);
            }
        });

        Set.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Set.setForeground(new java.awt.Color(0, 102, 102));
        Set.setText("Set Info");

        javax.swing.GroupLayout SetPanelLayout = new javax.swing.GroupLayout(SetPanel);
        SetPanel.setLayout(SetPanelLayout);
        SetPanelLayout.setHorizontalGroup(
            SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Set)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SetPanelLayout.setVerticalGroup(
            SetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SetPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Set)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        MenuPanel.setBackground(new java.awt.Color(204, 255, 255));
        MenuPanel.setInheritsPopupMenu(true);
        MenuPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuPanelMouseClicked(evt);
            }
        });

        Menu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Menu.setForeground(new java.awt.Color(0, 102, 102));
        Menu.setText("Log out");

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(Menu)
                .addContainerGap())
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Menu)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        ViewPanel.setBackground(new java.awt.Color(204, 255, 255));
        ViewPanel.setInheritsPopupMenu(true);
        ViewPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewPanelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ViewPanelMouseExited(evt);
            }
        });

        View.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        View.setForeground(new java.awt.Color(0, 102, 102));
        View.setText("View appointment");

        javax.swing.GroupLayout ViewPanelLayout = new javax.swing.GroupLayout(ViewPanel);
        ViewPanel.setLayout(ViewPanelLayout);
        ViewPanelLayout.setHorizontalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(View)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ViewPanelLayout.setVerticalGroup(
            ViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(View)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SetPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PanelView.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Appointment Schedules");

        PanelSetView.setBackground(new java.awt.Color(255, 255, 255));
        PanelSetView.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PanelSetView.setForeground(new java.awt.Color(0, 102, 102));
        PanelSetView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "First Name", "Time", "Kind of Service", "Person handles ", "Year", "Month", "Date", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanelSetView.setGridColor(new java.awt.Color(255, 255, 255));
        PanelSetView.setSelectionBackground(new java.awt.Color(255, 255, 255));
        PanelSetView.setSelectionForeground(new java.awt.Color(255, 255, 255));
        PanelSetView.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(PanelSetView);

        javax.swing.GroupLayout PanelViewLayout = new javax.swing.GroupLayout(PanelView);
        PanelView.setLayout(PanelViewLayout);
        PanelViewLayout.setHorizontalGroup(
            PanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelViewLayout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(jLabel3)
                .addContainerGap(295, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        PanelViewLayout.setVerticalGroup(
            PanelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelViewLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        PanelSet.setBackground(new java.awt.Color(204, 255, 255));
        PanelSet.setForeground(new java.awt.Color(0, 102, 102));

        NameField.setBackground(new java.awt.Color(0, 102, 102));
        NameField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        NameField.setForeground(new java.awt.Color(255, 255, 255));
        NameField.setBorder(null);
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        FirstName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FirstName.setForeground(new java.awt.Color(0, 102, 102));
        FirstName.setText("First Name");

        Date.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Date.setForeground(new java.awt.Color(0, 102, 102));
        Date.setText("Date: yyyy- mm- dd");

        Time.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Time.setForeground(new java.awt.Color(0, 102, 102));
        Time.setText("Time");

        Kind.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Kind.setForeground(new java.awt.Color(0, 102, 102));
        Kind.setText("Kind of Service");

        Person.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Person.setForeground(new java.awt.Color(0, 102, 102));
        Person.setText("Person to handle");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("We recommend that you check the view appointment menu first to check the availability of the time and date.");

        Confirm.setBackground(new java.awt.Color(0, 102, 102));
        Confirm.setForeground(new java.awt.Color(255, 255, 255));
        Confirm.setText("Confirm ");
        Confirm.setBorder(null);
        Confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmActionPerformed(evt);
            }
        });

        Kinds.setBackground(new java.awt.Color(0, 102, 102));
        Kinds.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Kinds.setForeground(new java.awt.Color(255, 255, 255));
        Kinds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Whole Body Massage", "Half Body Massage", "Foot Reflex", "Foot Reflex And Whole Body", "Foot Reflex And Half Body" }));
        Kinds.setBorder(null);
        Kinds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KindsActionPerformed(evt);
            }
        });

        PersonBox.setBackground(new java.awt.Color(0, 102, 102));
        PersonBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PersonBox.setForeground(new java.awt.Color(255, 255, 255));
        PersonBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "masseuse 1", "masseuse 2", "masseuse 3", "masseuse 4", "masseuse 5" }));
        PersonBox.setBorder(null);

        TimeField.setBackground(new java.awt.Color(0, 102, 102));
        TimeField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TimeField.setForeground(new java.awt.Color(255, 255, 255));
        TimeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1:00 PM", "2:00 PM", "3:00 PM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM", "9:00 PM", " ", " " }));
        TimeField.setBorder(null);
        TimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Book an Appointment");

        jComboBox1.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        jComboBox1.setBorder(null);

        jComboBox2.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February\t", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox2.setBorder(null);

        jComboBox3.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        jComboBox3.setBorder(null);
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        Search.setBackground(new java.awt.Color(0, 102, 102));
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search ");
        Search.setBorder(null);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        FirstName1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        FirstName1.setForeground(new java.awt.Color(0, 102, 102));
        FirstName1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Manage Appointment");

        ID.setBackground(new java.awt.Color(0, 102, 102));
        ID.setForeground(new java.awt.Color(255, 255, 255));
        ID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        ID.setBorder(null);

        Update.setBackground(new java.awt.Color(0, 102, 102));
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.setBorder(null);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setBackground(new java.awt.Color(0, 102, 102));
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Delete");
        Delete.setBorder(null);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSetLayout = new javax.swing.GroupLayout(PanelSet);
        PanelSet.setLayout(PanelSetLayout);
        PanelSetLayout.setHorizontalGroup(
            PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSetLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Time)
                        .addComponent(Date)
                        .addGroup(PanelSetLayout.createSequentialGroup()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jComboBox3, 0, 86, Short.MAX_VALUE))
                        .addComponent(TimeField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NameField))
                    .addComponent(FirstName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Person)
                    .addComponent(Kinds, 0, 253, Short.MAX_VALUE)
                    .addComponent(Kind)
                    .addComponent(PersonBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(114, 114, 114))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSetLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(136, 136, 136))
            .addGroup(PanelSetLayout.createSequentialGroup()
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirstName1)
                            .addGroup(PanelSetLayout.createSequentialGroup()
                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSetLayout.setVerticalGroup(
            PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSetLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Kind)
                    .addComponent(FirstName))
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(Kinds, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addComponent(Date)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Time))
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addComponent(Person)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PersonBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelSetLayout.createSequentialGroup()
                        .addComponent(Confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(FirstName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelSetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelSet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                    .addContainerGap(43, Short.MAX_VALUE)
                    .addComponent(PanelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuPanelMouseClicked
       int result = JOptionPane.showConfirmDialog(null, "Confirm Log out", "Log out?", JOptionPane.YES_NO_OPTION);
        
        if(result == JOptionPane.YES_OPTION){
            Menu m = new Menu();
            m.setVisible(true);
            m.setLocationRelativeTo(null);
            dispose();
        }
    }//GEN-LAST:event_MenuPanelMouseClicked

    private void SetPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetPanelMouseClicked
        SetPanel.setBackground(new Color(0, 153, 153));
        PanelView.setVisible(false);
        PanelSet.setVisible(true);
        
    }//GEN-LAST:event_SetPanelMouseClicked

    private void SetPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetPanelMouseExited
        SetPanel.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_SetPanelMouseExited

    private void ViewPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPanelMouseClicked
        ViewPanel.setBackground(new Color(0, 153, 153));
        PanelView.setVisible(true);
        PanelSet.setVisible(false);
    }//GEN-LAST:event_ViewPanelMouseClicked

    private void ViewPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewPanelMouseExited
        ViewPanel.setBackground(new Color(204,255,255));
    }//GEN-LAST:event_ViewPanelMouseExited

    private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameFieldActionPerformed

    }//GEN-LAST:event_NameFieldActionPerformed

    private void ConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
        try {                                        
            String client = NameField.getText();
            String oras = (String) TimeField.getSelectedItem();
            String service = (String) Kinds.getSelectedItem();
            String masseuse = (String) PersonBox.getSelectedItem();
            String Year = (String) jComboBox1.getSelectedItem();
            String Month = (String) jComboBox2.getSelectedItem();
            String Day = (String) jComboBox3.getSelectedItem();

            // Check for overlapping bookings
            pst = con.prepareStatement("SELECT * FROM booking WHERE Masseuse = ? AND Year = ? AND Month = ? AND Date = ? AND Time = ?");
            pst.setString(1, masseuse);
            pst.setString(2, Year);
            pst.setString(3, Month);
            pst.setString(4, Day);
            pst.setString(5, oras);

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                // Overlapping booking found, inform the user
                JOptionPane.showMessageDialog(null, "Person is already booked at the selected time. Please choose a different time.");
        } else {
            // No overlapping booking, proceed to insert the new booking
                pst = con.prepareStatement("INSERT INTO booking (Client, Year, Month, Date, Time, Service, Masseuse)VALUES(?, ?, ?, ?, ?, ?, ?)");
                pst.setString(1, client);
                pst.setString(2, Year);
                pst.setString(3, Month);
                pst.setString(4, Day);
                pst.setString(5, oras);
                pst.setString(6, service);
                pst.setString(7, masseuse);

                if (client.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill up clients name");
                } else {
                    int k = pst.executeUpdate();    
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Appointment Booked");
                        // Clear fields and update UI
                        NameField.setText("");
                        TimeField.setSelectedIndex(0);
                        Kinds.setSelectedIndex(0);
                        PersonBox.setSelectedIndex(0);
                        jComboBox1.setSelectedIndex(0);
                        jComboBox2.setSelectedIndex(0);
                        jComboBox3.setSelectedIndex(0);
                        fetch();
                        loadname();
                        NameField.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error Saving");
                    } 
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_ConfirmActionPerformed

    private void KindsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KindsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KindsActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void TimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFieldActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
          try {
              String pid = ID.getSelectedItem().toString();
             
              pst = con.prepareStatement("SELECT * FROM booking WHERE id=?");
              pst.setString(1,pid);
              rs = pst.executeQuery();
              
              if(rs.next() == true){
                NameField.setText(rs.getString(2));
                String selectedTime = rs.getString("Time");
                TimeField.setSelectedItem(selectedTime);

        
                String selectedService = rs.getString("Service");
                Kinds.setSelectedItem(selectedService);

        
                String selectedMasseuse = rs.getString("Masseuse");
                PersonBox.setSelectedItem(selectedMasseuse);

        
                String selectedYear = rs.getString("Year");
                jComboBox1.setSelectedItem(selectedYear);

                String selectedMonth = rs.getString("Month");
                jComboBox2.setSelectedItem(selectedMonth);
       
                int selectedDay = Integer.parseInt(rs.getString("Date")) - 1;
                jComboBox3.setSelectedIndex(selectedDay);
              }else{
                  JOptionPane.showMessageDialog(null, "Record not found");
              }
          } catch (SQLException ex) {
              Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }//GEN-LAST:event_SearchActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
          try {
                String cclient = NameField.getText();
                String ooras = (String) TimeField.getSelectedItem();
                String sservice = (String) Kinds.getSelectedItem();
                String mmasseuse = (String) PersonBox.getSelectedItem();
                String YYear = (String) jComboBox1.getSelectedItem();
                String MMonth = (String) jComboBox2.getSelectedItem();
                String DDay = (String) jComboBox3.getSelectedItem();
                String pid = (String) ID.getSelectedItem();

                // Check for overlapping bookings
                pst = con.prepareStatement("SELECT * FROM booking WHERE Masseuse = ? AND Year = ? AND Month = ? AND Date = ? AND Time = ? AND ID != ?");
                pst.setString(1, mmasseuse);
                pst.setString(2, YYear);
                pst.setString(3, MMonth);
                pst.setString(4, DDay);
                pst.setString(5, ooras);
                pst.setString(6, pid);

                ResultSet resultSet = pst.executeQuery();

                if (resultSet.next()) {
                    // Overlapping booking found, inform the user
                    JOptionPane.showMessageDialog(null, "Person is already booked at the selected time. Please choose a different time.");
                } else {
                    // No overlapping booking, proceed to update the booking
                    pst = con.prepareStatement("UPDATE booking SET Client=?, Year=?, Month=?, Date=?, Time=?, Service=?, Masseuse=? WHERE ID=?");
                    pst.setString(1, cclient);
                    pst.setString(2, YYear);
                    pst.setString(3, MMonth);
                    pst.setString(4, DDay);
                    pst.setString(5, ooras);
                    pst.setString(6, sservice);
                    pst.setString(7, mmasseuse);
                    pst.setString(8, pid);

                    if (cclient.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill up new name");
                    } else {
                        int k = pst.executeUpdate();    

            if (k == 1) {
                JOptionPane.showMessageDialog(null, "Appointment Updated");
                // Clear fields and update UI
                NameField.setText("");
                TimeField.setSelectedIndex(0);
                Kinds.setSelectedIndex(0);
                PersonBox.setSelectedIndex(0);
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);

                NameField.requestFocus();
                loadname();
                fetch();
            } else {
                JOptionPane.showMessageDialog(null, "Error Saving");
            } 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_UpdateActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
          try {
              String client = NameField.getText();
              String pid = (String) ID.getSelectedItem().toString();
              pst = con.prepareStatement("DELETE FROM booking WHERE id=?");
              pst.setString(1,pid);
                  
              
            if(client.isEmpty()){
                JOptionPane.showMessageDialog(null, "No clients name");
            }else{
                int k = pst.executeUpdate();    
                
                if(k ==1){
                    JOptionPane.showMessageDialog(null, "Appointment Deleted");
                        NameField.setText("");
                        TimeField.setSelectedIndex(0);
                        Kinds.setSelectedIndex(0);
                        PersonBox.setSelectedIndex(0);
                        jComboBox1.setSelectedIndex(0);
                        jComboBox2.setSelectedIndex(0);
                        jComboBox3.setSelectedIndex(0);
                        
                        NameField.requestFocus();
                        loadname();
                        fetch();
                        
                }else{
                    JOptionPane.showMessageDialog(null, "Error deleting");
                } 
            }
          } catch (SQLException ex) {
              Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
          }
             
    }//GEN-LAST:event_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Confirm;
    private javax.swing.JLabel Date;
    private javax.swing.JButton Delete;
    private javax.swing.JLabel FirstName;
    private javax.swing.JLabel FirstName1;
    private javax.swing.JComboBox<String> ID;
    private javax.swing.JLabel Kind;
    private javax.swing.JComboBox<String> Kinds;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Menu;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JTextField NameField;
    private javax.swing.JPanel PanelSet;
    private static javax.swing.JTable PanelSetView;
    private javax.swing.JPanel PanelView;
    private javax.swing.JLabel Person;
    private javax.swing.JComboBox<String> PersonBox;
    private javax.swing.JButton Search;
    private javax.swing.JLabel Set;
    private javax.swing.JPanel SetPanel;
    private javax.swing.JLabel Time;
    private javax.swing.JComboBox<String> TimeField;
    private javax.swing.JButton Update;
    private javax.swing.JLabel View;
    private javax.swing.JPanel ViewPanel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
