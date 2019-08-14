/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipaymentdua;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sipaymentdua.Deduct.JDBC_DRIVER;
import static sipaymentdua.Invoice.JDBC_DRIVER;
import static sipaymentdua.LoginForm.JDBC_DRIVER;

/**
 *
 * @author iozyo
 */
public class Create extends javax.swing.JFrame {
    
    // Menyiapkan paramter JDBC untuk koneksi ke datbase
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3307/karin_fengtay";
    static final String USER = "root";
    static final String PASS = "rahasiakudewe";

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    String[] columnNames = {"Invoice Number", "Invoice Date", "Invoice Amount", "Number AWB / BL"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    /**
     * Creates new form Create
     */
    public Create() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.input_date.setText(formatter.format(date).toString());
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyMM");
        this.prepared_by.setText(Session.getUserLogin());
        
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM data WHERE app_number like '" + formatter2.format(date).toString() +"%'";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            String lastid = "";
            while(rs.next()){
                count += 1;
                lastid = rs.getString("app_number");
            }
            
            if (count > 0) {
                int id = Integer.valueOf(lastid) + 1;
                this.app_number.setText(String.valueOf(id));
            }else{
                this.app_number.setText(formatter2.format(date).toString() + "001");
            }
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM invoice WHERE id_data = '" + app_number.getText() +"'";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            int total_amount_invoice = 0;
            while(rs.next()){
                String a = rs.getString("invoice_number");
                String b = rs.getString("invoice_date");
                String c = rs.getString("invoice_amount");
                String d = rs.getString("number_awb");

                // create a single array of one row's worth of data
                String[] data = { a, b, c, d } ;

                // and add this row of data into the table model
                tableModel.addRow(data);
                total_amount_invoice = total_amount_invoice + Integer.parseInt(rs.getString("invoice_amount"));
            }
            jTable1.setModel(tableModel);
            
            total_amount.setText(String.valueOf(total_amount_invoice));
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM deduct";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            int total_amount_ya = 0;
            while(rs.next()){
                String a = rs.getString("deduct_number");
                String b = rs.getString("date");
                String c = rs.getString("amount");
                String d = rs.getString("note");
                total_amount_ya = total_amount_ya + Integer.parseInt(rs.getString("amount"));
            }
            
            amount_deduct.setText(String.valueOf(total_amount_ya));
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Create(LoginForm aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        currency = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        payment_for = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        vendor_code = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        vendor_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bank_code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bank_name = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        account_number = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        app_number = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        total_amount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        amount_deduct = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        input_date = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        prepared_by = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Currency");

        jLabel2.setText("Payment For");

        jLabel3.setText("Vendor Code");

        jLabel4.setText("Vendor Name");

        vendor_name.setEditable(false);

        jLabel5.setText("Bank Code");

        jLabel6.setText("Bank Name");

        bank_name.setEditable(false);

        jLabel7.setText("Account Number");

        jLabel8.setText("Due Date");

        jLabel9.setText("App Number");

        app_number.setEditable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Invoice Number", "Invoice Date", "Invoice Amount", "Number AWB / BL"
            }
        ));
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        jLabel10.setText("Total Amount");

        total_amount.setEditable(false);
        total_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total_amountActionPerformed(evt);
            }
        });

        jLabel11.setText("Amount Deduct");

        amount_deduct.setEditable(false);
        amount_deduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount_deductActionPerformed(evt);
            }
        });

        jLabel12.setText("Input Date");

        input_date.setEditable(false);
        input_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_dateActionPerformed(evt);
            }
        });

        jLabel13.setText("Prepared By");

        prepared_by.setEditable(false);

        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Cek");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Cek");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton3.setText("Add Invoice");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton8.setText("Deduct");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currency))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(payment_for))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vendor_name))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vendor_code, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(9, 9, 9)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(account_number))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bank_name))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bank_code, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(app_number)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addContainerGap(32, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(amount_deduct, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(input_date, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(prepared_by, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(currency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bank_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(payment_for, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(bank_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(app_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(vendor_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(account_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(vendor_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(input_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(amount_deduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(prepared_by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (bank_name.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Pastikan Bank Name telah terisi.");
        }else if (vendor_name.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Pastikan Vendor Name telah terisi.");
        }else{
            Date date = new Date(jDateChooser1.getDate().getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            formatter.format(date).toString()
            try {
                // register driver yang akan dipakai
                Class.forName(JDBC_DRIVER);

                // buat koneksi ke database
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // buat objek statement
                stmt = conn.createStatement();

                // buat query ke database
                String sql = "INSERT INTO data (`app_number`, `currency`, `payment_for`, `vendor_code`, `vendor_name`, `bank_code`, `bank_name`, `account_number`, `due_date`, `total_amount`, `amount_deduct`, `input_date`, `prepared_by`, `hakakses`) VALUES ('" + app_number.getText() + "', '" + currency.getText() + "', '" + payment_for.getText() + "', '" + vendor_code.getText() + "', '" + vendor_name.getText() + "', '" + bank_code.getText() + "', '" + bank_name.getText() + "', '" + account_number.getText() + "', '" + formatter.format(date).toString() + "', '" + total_amount.getText() + "', '0', '" + input_date.getText() + "', '" + prepared_by.getText() + "', '" + Session.getHakAkses() + "')";

                // eksekusi query dan simpan hasilnya di obj ResultSet
                stmt.executeUpdate(sql);

                // tampilkan hasil query
                int count = 0;
                JOptionPane.showMessageDialog(rootPane,"Data Berhasil disimpan. ");
                this.dispose();
                this.setVisible(true);

                stmt.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM vendor WHERE vendor_code = '" + vendor_code.getText() +"'";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            while(rs.next()){
                vendor_name.setText(rs.getString("vendor_name"));
                count += 1;
            }
            
            if (count == 0) {
                JOptionPane.showMessageDialog(rootPane,"Vendor dengan Code tersebut tidak ditemukan.");
            }
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM bank WHERE bank_code = '" + bank_code.getText() +"'";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            while(rs.next()){
                bank_name.setText(rs.getString("bank_name"));
                count += 1;
            }
            
            if (count == 0) {
                JOptionPane.showMessageDialog(rootPane,"Bank dengan Code tersebut tidak ditemukan.");
            }
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (app_number.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Silahkan isi App Number terlebih dahulu.");
        }else{
            if (Session.getHakAkses().equals("Staff") ) {
//                try {
//                    // register driver yang akan dipakai
//                    Class.forName(JDBC_DRIVER);
//
//                    // buat koneksi ke database
//                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//                    // buat objek statement
//                    stmt = conn.createStatement();
//
//                    // buat query ke database
//                    String sql = "SELECT * FROM data WHERE app_number = '" + app_number.getText() +"'";
//
//                    // eksekusi query dan simpan hasilnya di obj ResultSet
//                    rs = stmt.executeQuery(sql);
//
//                    // tampilkan hasil query
//                    int count = 0;
//                    while(rs.next()){
//                        count += 1;
//                    }
//
//                    if (count == 0) {
//                        JOptionPane.showMessageDialog(rootPane,"App Number tidak ditemukan.");
//                    }else{
//                        
//                    }
//
//                    stmt.close();
//                    conn.close();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                Session.setApp_number(app_number.getText());
                new Invoice().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"Hak Akses tombol ini hanya untuk Staff.");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         currency.setText("");
         payment_for.setText("");
         vendor_code.setText("");
         vendor_name.setText("");
         bank_code.setText("");
         bank_name.setText("");
         account_number.setText("");
         jDateChooser1.setDate(null);
         jTable1.setModel(null);
         
        this.dispose();      
        this.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM invoice WHERE id_data = '" + app_number.getText() +"'";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            int total_amount_invoice = 0;
            
            tableModel.getDataVector().clear();
            jTable1.setModel(tableModel);
            
            while(rs.next()){
                String a = rs.getString("invoice_number");
                String b = rs.getString("invoice_date");
                String c = rs.getString("invoice_amount");
                String d = rs.getString("number_awb");

                // create a single array of one row's worth of data
                String[] data = { a, b, c, d } ;

                // and add this row of data into the table model
                tableModel.addRow(data);
                total_amount_invoice = total_amount_invoice + Integer.parseInt(rs.getString("invoice_amount"));
                count += 1;
            }
            if (count == 0) {
                this.dispose();
                new Create().setVisible(true);
            }else{
                jTable1.setModel(tableModel);
            }
            
            total_amount.setText(String.valueOf(total_amount_invoice));
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            
            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // buat objek statement
            stmt = conn.createStatement();
            
            // buat query ke database
            String sql = "SELECT * FROM deduct";
            
            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);
            
            // tampilkan hasil query
            int count = 0;
            int total_amount_ya = 0;
            
            tableModel.getDataVector().clear();
            jTable1.setModel(tableModel);
            
            while(rs.next()){
                String a = rs.getString("deduct_number");
                String b = rs.getString("date");
                String c = rs.getString("amount");
                String d = rs.getString("note");
                total_amount_ya = total_amount_ya + Integer.parseInt(rs.getString("amount"));
            }
            
            amount_deduct.setText(String.valueOf(total_amount_ya));
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if (app_number.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,"Silahkan isi App Number terlebih dahulu.");
        }else{
            if (Session.getHakAkses().equals("Staff") ) {
//                try {
//                    // register driver yang akan dipakai
//                    Class.forName(JDBC_DRIVER);
//
//                    // buat koneksi ke database
//                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//                    // buat objek statement
//                    stmt = conn.createStatement();
//
//                    // buat query ke database
//                    String sql = "SELECT * FROM data WHERE app_number = '" + app_number.getText() +"'";
//
//                    // eksekusi query dan simpan hasilnya di obj ResultSet
//                    rs = stmt.executeQuery(sql);
//
//                    // tampilkan hasil query
//                    int count = 0;
//                    while(rs.next()){
//                        count += 1;
//                    }
//
//                    if (count == 0) {
//                        JOptionPane.showMessageDialog(rootPane,"App Number tidak ditemukan.");
//                    }else{
//                        
//                    }
//
//                    stmt.close();
//                    conn.close();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                Session.setApp_number(app_number.getText());
                new Deduct().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(rootPane,"Hak Akses tombol ini hanya untuk Staff.");
            }
        } 
    }//GEN-LAST:event_jButton8ActionPerformed

    private void amount_deductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount_deductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amount_deductActionPerformed

    private void total_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total_amountActionPerformed

    private void input_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_dateActionPerformed

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
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField account_number;
    private javax.swing.JTextField amount_deduct;
    private javax.swing.JTextField app_number;
    private javax.swing.JTextField bank_code;
    private javax.swing.JTextField bank_name;
    private javax.swing.JTextField currency;
    private javax.swing.JTextField input_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField payment_for;
    public javax.swing.JTextField prepared_by;
    private javax.swing.JTextField total_amount;
    private javax.swing.JTextField vendor_code;
    private javax.swing.JTextField vendor_name;
    // End of variables declaration//GEN-END:variables
}
