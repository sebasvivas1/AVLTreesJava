/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import edd_quiz_2_diaz_vivas.ArbolAVL;
import edd_quiz_2_diaz_vivas.ArbolGrafico;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Vivas y Maria Diaz
 */
public class Ventana extends javax.swing.JFrame {

    ArbolAVL arbol;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        arbol = new ArbolAVL();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SALIR = new javax.swing.JToggleButton();
        VACIAR = new javax.swing.JButton();
        INSERTAR = new javax.swing.JButton();
        ELIMINARCLAVE = new javax.swing.JButton();
        VISUALIZAR = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SALIR.setBackground(new java.awt.Color(255, 102, 102));
        SALIR.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 36)); // NOI18N
        SALIR.setForeground(new java.awt.Color(51, 51, 51));
        SALIR.setText("X");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });
        getContentPane().add(SALIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 80, 40));

        VACIAR.setBackground(new java.awt.Color(204, 255, 204));
        VACIAR.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        VACIAR.setForeground(new java.awt.Color(51, 51, 51));
        VACIAR.setText("VACIAR ??RBOL");
        VACIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VACIARActionPerformed(evt);
            }
        });
        getContentPane().add(VACIAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 250, 60));

        INSERTAR.setBackground(new java.awt.Color(204, 255, 204));
        INSERTAR.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        INSERTAR.setForeground(new java.awt.Color(51, 51, 51));
        INSERTAR.setText("INSERTAR CLAVE");
        INSERTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTARActionPerformed(evt);
            }
        });
        getContentPane().add(INSERTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 60));

        ELIMINARCLAVE.setBackground(new java.awt.Color(204, 255, 204));
        ELIMINARCLAVE.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        ELIMINARCLAVE.setForeground(new java.awt.Color(51, 51, 51));
        ELIMINARCLAVE.setText("ELIMINAR CLAVE");
        ELIMINARCLAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ELIMINARCLAVEActionPerformed(evt);
            }
        });
        getContentPane().add(ELIMINARCLAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 260, 60));

        VISUALIZAR.setBackground(new java.awt.Color(204, 255, 204));
        VISUALIZAR.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        VISUALIZAR.setForeground(new java.awt.Color(51, 51, 51));
        VISUALIZAR.setText("MOSTRAR ??RBOL");
        VISUALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VISUALIZARActionPerformed(evt);
            }
        });
        getContentPane().add(VISUALIZAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 250, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/resumen-superficie-agua-piscina-fondo-reflejo-luz-sol_74190-8510.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ELIMINARCLAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ELIMINARCLAVEActionPerformed

        try {

            if (arbol.getRaiz() == null) {
                JOptionPane.showMessageDialog(null, "El arbol sigue vacio!.", "Error!", 2);
            } else {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el elemento que desea eliminar: ", "Eliminar elemento", 3));

                if (arbol.buscarElemento(valor) != null) {
                    arbol.deleteKey(valor);
                    JOptionPane.showMessageDialog(null, "El numero eliminado fue: " + valor, "Valor eliminado con exito", 1);

                } else {
                    JOptionPane.showMessageDialog(null, "El elemento no existe.", "Error!", 2);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese solo valores numericos enteros.", "Error!", 2);
        }


    }//GEN-LAST:event_ELIMINARCLAVEActionPerformed

    private void INSERTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTARActionPerformed

        try {

            int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el elemento que desea insertar: ", "Agregar elemento", 3));

            if (arbol.buscarElemento(valor) == null) {
                arbol.insertar(valor);
                JOptionPane.showMessageDialog(null, "El numero insertado fue: " + valor, "Valor agregado con exito", 1);

            } else {
                JOptionPane.showMessageDialog(null, "El elemento ya existe.", "Error!", 2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese solo valores numericos enteros.", "Error!", 2);
        }

    }//GEN-LAST:event_INSERTARActionPerformed

    private void VACIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VACIARActionPerformed
        if (arbol.getRaiz() == null) {
            JOptionPane.showMessageDialog(null, "El arbol ya esta vacio.", "Error!", 2);
            return;
        }
        arbol.eliminarArbol();
        JOptionPane.showMessageDialog(null, "Se ha vaciado el arbol correctamente.", "Arbol vaciado con exito", 1);
    }//GEN-LAST:event_VACIARActionPerformed

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SALIRActionPerformed

    private void VISUALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VISUALIZARActionPerformed
        // TODO add your handling code here:
        if (arbol.getRaiz() != null) {
            ArbolGrafico gui = new ArbolGrafico(arbol);
        } else {
            JOptionPane.showMessageDialog(null, "El arbol esta vacio y no se puede mostrar", "Error!", 2);
        }
    }//GEN-LAST:event_VISUALIZARActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ELIMINARCLAVE;
    private javax.swing.JButton INSERTAR;
    private javax.swing.JToggleButton SALIR;
    private javax.swing.JButton VACIAR;
    private javax.swing.JButton VISUALIZAR;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
