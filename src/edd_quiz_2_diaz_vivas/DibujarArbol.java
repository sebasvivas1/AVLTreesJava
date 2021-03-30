/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_quiz_2_diaz_vivas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

class DibujarArbol extends JPanel {

    public ArbolAVL arbol;

    public DibujarArbol(ArbolAVL arbol) {
        this.arbol = arbol;
        setBackground(Color.green); // Se modifica el color de los numeros del arbol.

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(getBackground());

        Draw(g, 0, getWidth(), 0, getHeight() / arbol.getheight(arbol.raiz), arbol.raiz);

    }
 
    /** Metodo encargado de "dibujar" el arbol.**/
    public void Draw(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, Nodo nodo) {
        String data = String.valueOf(nodo.getValor());
        g.setFont(new Font("Arial", Font.BOLD, 18));

        FontMetrics fm = g.getFontMetrics();
        int dataWidth = fm.stringWidth(data);
        g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);
        if (nodo.getHijoIzq() != null) {
            Draw(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, nodo.getHijoIzq());
        }

        if (nodo.getHijoDer() != null) {
            Draw(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, nodo.getHijoDer());
        }

    }

}
