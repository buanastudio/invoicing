/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipaymentdua;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Administrator
 */
public class ReportInvoice {
    
    Connection conn;
    Statement st;
    ResultSet rs;
                
                public ReportInvoice() {
                    String isDatabase = "si_fengtay";
                    String isDatabaseUser = "root";
                    String isDatabasePassword = "";
                    String strConn = "jdbc:mysql://localhost/"+ isDatabase +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
                    try {
                        conn = DriverManager.getConnection(strConn, isDatabaseUser,isDatabasePassword);
                        st = conn.createStatement();
                    } catch (SQLException ex) {
                        System.err.println("Error : " + ex);
                    }
                }
                
                
                public void viewReportShowForm(String strTitleForm, String strQuery, String strReportFileLocation) {
                try {
                    rs = st.executeQuery(strQuery);
                    JasperPrint jasperPrint;       
                    JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);        
                    JasperReport jasperReport = JasperCompileManager.compileReport(strReportFileLocation);          
                    jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrRS);
                    JRViewer aViewer = new JRViewer(jasperPrint);                  
                    JDialog viewer = new JDialog();
                    viewer.setTitle(strTitleForm);
                    viewer.setAlwaysOnTop(true);
                    viewer.getContentPane().add(aViewer);                  
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
                    viewer.setBounds(0,0,screenSize.width, screenSize.height);
                    viewer.setVisible(true);   
                    
                } catch (HeadlessException | SecurityException | SQLException | JRException e) {}
            }
    
}
