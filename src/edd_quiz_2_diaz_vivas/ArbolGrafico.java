/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_quiz_2_diaz_vivas;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ArbolGrafico extends JFrame {

    private JPanel contentPane;
    public ArbolAVL arbol;
    public DibujarArbol dibujar;

    /** Constructor de la clase. **/
    public ArbolGrafico(ArbolAVL arbol) {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(0, 0, 1280, 900); // Inicia la ventana del arbol en una posicion predeterminada (centrada y tamanio completo).

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setBackground(Color.black);
        dibujar = new DibujarArbol(arbol);

        contentPane.add(dibujar);
        this.setLayout(new BorderLayout());
        setContentPane(contentPane);
        this.arbol = arbol;
        setVisible(true);
    }
}
