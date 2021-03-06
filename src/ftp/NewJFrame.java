/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

import it.sauronsoftware.ftp4j.FTPClient;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.net.*;
import java.io.*;

        

/**
 *
 * @author Administrador
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jBFtp = new javax.swing.JButton();
        txtImagen = new javax.swing.JLabel();
        jBLocal = new javax.swing.JButton();
        jBPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Conecctar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jBFtp.setText("Descargar desde FTP");
        jBFtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBFtpActionPerformed(evt);
            }
        });

        txtImagen.setToolTipText("");

        jBLocal.setText("Ver directamente");
        jBLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLocalActionPerformed(evt);
            }
        });

        jBPdf.setText("Ver PDF desde FTP");
        jBPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBFtp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jBPdf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addGap(12, 12, 12)
                        .addComponent(jBFtp)
                        .addGap(18, 18, 18)
                        .addComponent(jBLocal)
                        .addGap(18, 18, 18)
                        .addComponent(jBPdf))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            FTPClient client = new FTPClient();

            client.connect("sirh.dyndns.org", 21);

            client.login("anonymous", ""); //users and password

            //** Upload
            client.upload(new File("archivo.txt"),new  MyTransferListener());

            client.disconnect(true);

            System.out.println("FTP Successfully");

        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBFtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBFtpActionPerformed
        // TODO add your handling code here:
        try {
            
            File file = new File("00014.JPG");
            
            FTPClient client = new FTPClient();

            client.connect("sirh.dyndns.org", 21);

            client.login("anonymous", ""); //users and password

            //** Upload
            client.download("/Trabajadores/00014.JPG",file,new  MyTransferListener());

            client.disconnect(true);
            
            System.out.println("FTP Successfully");
            
            String lugarImagen="00014.JPG";
            
            Image icon= new javax.swing.ImageIcon(lugarImagen).getImage().getScaledInstance(txtImagen.getWidth(), txtImagen.getWidth(), Image.SCALE_DEFAULT);
            Icon imagen=new ImageIcon(icon);
            txtImagen.setIcon(imagen);

        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_jBFtpActionPerformed

    private void jBLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLocalActionPerformed
        // TODO add your handling code here:
        try {
            
            
            String lugarImagen="ftp://sirh.dyndns.org/Trabajadores/00014.JPG";
            
            Image icon= new javax.swing.ImageIcon(new URL(lugarImagen)).getImage().getScaledInstance(txtImagen.getWidth(), txtImagen.getWidth(), Image.SCALE_DEFAULT);
            Icon imagen=new ImageIcon(icon);
            txtImagen.setIcon(imagen);

        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_jBLocalActionPerformed

    private void jBPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPdfActionPerformed
        // TODO add your handling code here:
        try{
            
            String lugarImagen="ftp://sirh.dyndns.org/ManualUsuarioGR.pdf";
            
            URL url1= new URL(lugarImagen);
            
            byte[] ba1 = new byte[1024];
            int baLength;
            File pdfFile =new File("ManualUsuarioGR.pdf");
            FileOutputStream fos1 = new FileOutputStream(pdfFile);
            
            URLConnection urlConn = url1.openConnection();
            
            InputStream is1 = url1.openStream();
            while ((baLength = is1.read(ba1)) != -1) {
                fos1.write(ba1, 0, baLength);
            }
            fos1.flush();
            fos1.close();
            is1.close();
            
            
            if (pdfFile.exists()) {
                
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Awt Desktop is not supported!");
                }
                
            } else {
                System.out.println("The file does't exists!");
            }
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jBPdfActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBFtp;
    private javax.swing.JButton jBLocal;
    private javax.swing.JButton jBPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel txtImagen;
    // End of variables declaration//GEN-END:variables
}
