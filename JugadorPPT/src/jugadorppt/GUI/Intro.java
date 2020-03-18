/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugadorppt.GUI;

import com.sun.glass.events.KeyEvent;
import jugadorppt.audio.Efectos;

/**
 *
 * @author andres
 */
public class Intro extends javax.swing.JDialog {

     private Efectos efectos;
     private Menu menu;
    /**
     * Creates new form Intro
     * @param parent
     * @param modal
     * @param m
     */
    public Intro(java.awt.Frame parent, boolean modal, Menu m) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        efectos = new Efectos();
        efectos.reproducirSonidoIntro();
        this.menu = m;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jugadorppt/gif/intro3.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            //efectos.reproducirSonidoSeleccionar();
            this.efectos.detenerSonidoIntro();
            this.efectos.reproducirSonidoFondo();
            Login login = new Login(menu,true,menu,efectos);
            this.setVisible(false);
            this.dispose();
            login.setVisible(true);
            
            
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_Q) {
            
            System.exit(0);
            
        }
    }//GEN-LAST:event_formKeyPressed

    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}