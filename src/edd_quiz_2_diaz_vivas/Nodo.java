package edd_quiz_2_diaz_vivas;

/**
 *
 * @author Maria Diaz y Sebastian Vivas
 */
public class Nodo {

    private int valor, altura;
    private Nodo hijoIzq, hijoDer;

    /** Constructor de la clase *
    @Params: int valor: numero a introducir en el arbol. 
     */
    public Nodo(int valor) {
        this.valor = valor;
        this.altura = 0;
        this.hijoDer = null;
        this.hijoIzq = null;
    }


    /** Getters y Setters **/
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getHijoIzq() {
        return this.hijoIzq;
    }

    public void setHijoIzq(Nodo hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Nodo getHijoDer() {
        return this.hijoDer;
    }

    public void setHijoDer(Nodo hijoDer) {
        this.hijoDer = hijoDer;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
