/*
 * Login.java
 *
 * Created on 31 de agosto de 2008, 22:51
 */

package com.micropakito.uwclient.formularios;

import com.micropakito.uwclient.objetos.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.micropakito.compartido.*;
import com.micropakito.compartido.definiciones.UserLogin;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author  Administrador
 */
public class Login extends javax.swing.JFrame {
    Socket s;
             
    /** Creates new form Login */
    public Login() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de Login");

        jButton1.setText("Login");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 10));
        jButton3.setText("ES");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 80, Short.MAX_VALUE)
                        .add(jButton3))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtUser)
                            .add(txtPass, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(txtUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtPass, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2)
                    .add(jButton3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        try {
            // TODO add your handling code here:
            System.out.println("pulsando el botón");

            s = new Socket("127.0.0.1", 22222);
            
            ObjectOutputStream salida;
            salida = new ObjectOutputStream( s.getOutputStream() );
            //PrintWriter output = new PrintWriter(s.getOutputStream());
            UserLogin ul = new UserLogin(txtUser.getText(), txtPass.getText());
            
            Message envioMensaje = new Message(1000,
                                               "Logar",
                                               Class.forName("com.micropakito.compartido.definiciones.UserLogin"),
                                               ul );
            salida.writeObject(envioMensaje);
            salida.flush();
//            output.writeObject();
//            output.print(envioMensaje);
//
//            output.flush();
            System.out.println("enviado");
            
//            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
//
//            String linea= input.readLine();
//
//            //while(linea!=null) {
//            System.out.println(linea);
//            linea= input.readLine();
               
           // } 
            
           // System.out.println("Recibido cliente:" + input.readLine() );
            System.out.println("respuesta:");
            
            ObjectInputStream in  = new ObjectInputStream(s.getInputStream());
            String messageObject = (String)in.readObject();

            System.out.println("mensaje recibido:" + messageObject) ;


            
        } catch (Exception ex) {
          System.out.println("Error:" + ex.getMessage());
        } 
        
        
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
       try {
           PrintWriter output = new PrintWriter(s.getOutputStream());
           output.println("\\about");
           output.flush(); 
           
           BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
           String linea= input.readLine(); 
            
           while(linea!="\\n") { 
                System.out.println(linea); 
                linea= input.readLine(); 
               if (linea==null){
                System.out.println("Es nulo");
               }
            } 
                
       }
       catch (Exception ex){
           System.out.println(ex.getMessage());
       }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
    
}