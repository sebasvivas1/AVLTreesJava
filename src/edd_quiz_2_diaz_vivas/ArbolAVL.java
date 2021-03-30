package edd_quiz_2_diaz_vivas;

/**
 *
 * @author Maria Diaz y Sebastian Vivas
 */
public class ArbolAVL {

    Nodo raiz;
    private int tamanio;

    /** Constructor de la clase. */
    public ArbolAVL() {
        this.raiz = null;
        tamanio = 0;

    }

    /** Metodos primitivos de la clase ArbolAVL */
    /** Verifica si el arbol esta vacio. 
    @Returns raiz: null 
    */
    public boolean esVacio() {
        return raiz == null;
    }

    /** Elimina todo el contenido del arbol */
    public void eliminarArbol() {
        raiz = null;
    }

    /** Obtiene la altura del nodo requerido.
    @Params: nodo: nodo a evaluar 
    @Returns: retorna -1 si el nodo es nulo. 
    @Returns: Si no es nulo, retorna la altura del nodo.
    */
    public int altura(Nodo nodo) {
        return nodo == null ? -1 : nodo.getAltura();
    }

    /** Evalua cual es la altura mayor del arbol, comparando la altura del lado 
    izquierdo con la del lado derecho. 
    @Params: raiz: nodo raiz.
    @Returns: 0 si la raiz es null.
    @Returns: int: el mayor tamanio del arbol.
    
    */
    public int getheight(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return Math.max(getheight(raiz.getHijoIzq()), getheight(raiz.getHijoDer())) + 1;

    }

    /** Verifica si la altura izquierda es mayor que la altura derecha.
    @Params: int: tamanio de cada lado del arbol. 
    @Returns: int: retorna el tamanio de la altura izq si izq > der
    @Returns: int: retorna el tamanio de la altura der si izq <= der
    */
    public int max(int alturaIzq, int alturaDer) {
        return alturaIzq > alturaDer ? alturaIzq : alturaDer;
    }

    /** Actualiza la altura de cada lado luego de hacer una rotacion.
    @Params: ra: el nodo raiz o la raiz del subarbol.
    **/
    public void actualizarAltura(Nodo ra) {
        ra.setAltura(max(altura(ra.getHijoIzq()), altura(ra.getHijoDer())) + 1);
    }

    /** Calcula la diferencia de tamanio de ambos lados del arbol.
    @Params: ra: raiz del arbol o del subarbol para decidir cual rotacion se
    ejecutara.
    @Returns: int: Retorna 0 si la raiz es null.
    @Returns: int: Retorna el numero resultante de la resta de la altura der - izq.
    **/
    public int balance(Nodo ra) {
        return (ra == null) ? 0 : altura(ra.getHijoDer()) - altura(ra.getHijoIzq());
    }

    /** Llama a la funcion insertar.
    @Params: valor: el numero que se desea insertar.
    **/
    public void insertar(int valor) {
        raiz = insertar(valor, raiz);
        tamanio++;
    }

    /** Funcion encargada de realizar la insercion y evaluacion del balance del 
    arbol para el mantenimiento y rotaciones necesarias. 
    @Params: valor: entero que se desea introducir.
    @Params: ra: Nodo raiz.
    @Returns: ra: retorna el nodo raiz actualizado en caso de haber realizado
    alguna rotacion de mantenimiento.
    **/
    public Nodo insertar(int valor, Nodo ra) {
        if (ra == null) {
            ra = new Nodo(valor);

        } else if (valor < ra.getValor()) {
            ra.setHijoIzq(insertar(valor, ra.getHijoIzq()));

            if (altura(ra.getHijoIzq()) - altura(ra.getHijoDer()) == 2) {
                if (valor < ra.getHijoIzq().getValor()) {
                    ra = rotarDer(ra);
                } else {
                    ra = rotarDerIzq(ra);
                }
            }

        } else if (valor > ra.getValor()) {
            ra.setHijoDer(insertar(valor, ra.getHijoDer()));

            if (altura(ra.getHijoDer()) - altura(ra.getHijoIzq()) == 2) {
                if (valor > ra.getHijoDer().getValor()) {
                    ra = rotarIzq(ra);
                } else {
                    ra = rotarIzqDer(ra);
                }
            }
        } else 
                ; // si ya existe no inserta
        actualizarAltura(ra);
        return ra;
    }

    /** Rota a la izquierda el nodo abuelo.
    @Params: aRotar: nodo que debe rotarse. (abuelo).
    @Returns: temp: la nueva raiz del subarbol.
   
    **/
    public Nodo rotarIzq(Nodo aRotar) {
        Nodo temp = aRotar.getHijoDer();

        aRotar.setHijoDer(temp.getHijoIzq());

        temp.setHijoIzq(aRotar);

        // actualizar las alturas IMPORTANTE 
        aRotar.setAltura(max(altura(aRotar.getHijoIzq()), altura(aRotar.getHijoDer())) + 1);

        temp.setAltura(max(altura(temp.getHijoIzq()), altura(temp.getHijoDer())) + 1);

        return temp;
    }

    /** Rota a la derecha el nodo abuelo.
    @Params: aRotar: nodo que debe rotarse. (abuelo).
    @Returns: temp: la nueva raiz del subarbol.
   
    **/
    public Nodo rotarDer(Nodo aRotar) {
        Nodo temp = aRotar.getHijoIzq();

        aRotar.setHijoIzq(temp.getHijoDer());

        temp.setHijoDer(aRotar);

        // actualizar las alturas
        aRotar.setAltura(max(altura(aRotar.getHijoIzq()), altura(aRotar.getHijoDer())) + 1);

        temp.setAltura(max(altura(temp.getHijoIzq()), altura(temp.getHijoDer())) + 1);

        return temp;
    }

    /** Realiza una doble rotacion. Primero se rota a la izquierda el nodo intermedio
    y seguidamente se rota a la derecha el nodo abuelo.
    @Params: aRotar: nodo que debe rotarse. (abuelo).
    @Returns: temp: la nueva raiz del subarbol.
   
    **/
    public Nodo rotarIzqDer(Nodo aRotar) {
        aRotar.setHijoDer(rotarDer(aRotar.getHijoDer()));

        return rotarIzq(aRotar);
    }

    /** Realiza una doble rotacion. Primero se rota a la derecha el nodo intermedio
    y seguidamente se rota a la izquierda el nodo abuelo.
    @Params: aRotar: nodo que debe rotarse. (abuelo).
    @Returns: temp: la nueva raiz del subarbol.
   
    **/
    public Nodo rotarDerIzq(Nodo aRotar) {
        aRotar.setHijoIzq(rotarIzq(aRotar.getHijoIzq()));

        return rotarDer(aRotar);
    }

    /** Llama al procedimiento eliminar.
    @Params: valor: El valor que se desea eliminar.
    **/
    public void deleteKey(int valor) {

        raiz = Delete(valor, raiz);
        tamanio--;

    }

    /** Elimina el elemento y realiza el mantenimiento del arbol en caso de ser
    necesario.
    @Params: Elem: Elemento a eliminar y su nodo. 
    @Returns: resp: Nodo raiz.
    **/
    public Nodo Delete(int Elem, Nodo nodo) {
        Nodo resp = nodo;

        // Verifica si el valor a eliminar es menor que el valor de la raiz del arbol
        // para recorrer el lado izquierdo.
        if (Elem < nodo.getValor()) {
            nodo.setHijoIzq(Delete(Elem, nodo.getHijoIzq()));
        } else {

            // Verifica si el valor a eliminar es mayor que el valor de la raiz del arbol
            // para recorrer el lado derecho.
            if (Elem > nodo.getValor()) {
                nodo.setHijoDer(Delete(Elem, nodo.getHijoDer()));
            } else {

                // Se evalua el caso en el que el nodo a eliminar tiene hijos en ambos lados.
                if (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
                    Nodo temp = nodo;
                    Nodo Max_Izq = Max(nodo.getHijoIzq());
                    nodo.setValor(Max_Izq.getValor());
                    temp.setHijoIzq(Delete(Max_Izq.getValor(), temp.getHijoIzq()));
                } else {

                    // Se evalua el caso en el que el nodo a eliminar solo tiene un hijo (lado izquierdo).
                    if (nodo.getHijoIzq() != null) {
                        resp = nodo.getHijoIzq();
                    } else {

                        // Se evalua el caso en el que el nodo a eliminar solo tiene un hijo (lado derecho).
                        if (nodo.getHijoDer() != null) {
                            resp = nodo.getHijoDer();
                        } else {
                            resp = null;
                        }
                    }
                }
            }
        }
        if (nodo != null) {
            nodo = rebalancearEliminar(nodo);
        }
        return resp;
    }

    /** Busca el hijo mayor del arbol. (El elemento mas a la derecha).
    @Params: n: raiz del arbol.
    @Retorna: El nodo cuyo elemento es el mayor en el arbol.
    **/
    public Nodo Max(Nodo n) {
        if (n.getHijoDer() == null) {
            return n;
        } else {
            return Max(n.getHijoDer());
        }
    }

    /** Balancea el arbol luego de haber eliminado un nodo y se haya desbalanceado
    @Params: Nodo: Nodo raiz del arbol.
    @Returns: nodo: Nueva raiz del arbol.
    **/
    public Nodo rebalancearEliminar(Nodo nodo) {
        actualizarAltura(nodo);
        int balanceado = balance(nodo);
        if (balanceado == 2) {
            if (altura(nodo.getHijoDer().getHijoDer()) > altura(nodo.getHijoIzq().getHijoIzq())) {
                nodo = rotarIzq(nodo);
            } else {
                nodo.setHijoDer(rotarDer(nodo.getHijoDer()));
                nodo = rotarIzq(nodo);

            }
        } else if (balanceado == -2) {
            if (altura(nodo.getHijoIzq().getHijoIzq()) > altura(nodo.getHijoIzq().getHijoDer())) {
                nodo = rotarDer(nodo);

            } else {
                nodo.setHijoIzq(rotarIzq(nodo.getHijoIzq()));
                nodo = rotarDer(nodo);

            }
        }
        return nodo;
    }

    /** Llama a la funcion buscarElemento
    @Params: valor: valor a buscar en el arbol.
    @Returns: retorna el nodo donde se encuentra el elemento.
    **/
    public Nodo buscarElemento(int valor) {
        Nodo encontrado = buscarElemento(raiz, valor);
        return encontrado;
    }

    /** Busca un elemento dentro del arbol.
    @Params: n: nodo raiz.
    @Params: valor: elemento a buscar en el arbol.
    @Returns: retorna null si el elemento no se encuentra en el arbol.
    @Returns: retorna el nodo en el que se encuentra el elemento.
    **/
    public Nodo buscarElemento(Nodo n, int valor) {
        Nodo result = null;
        if (n == null) {
            return null;
        }
        if (n.getValor() == valor) {
            return n;
        }
        if (n.getHijoIzq() != null) {
            result = buscarElemento(n.getHijoIzq(), valor);
        }
        if (result == null) {
            result = buscarElemento(n.getHijoDer(), valor);
        }
        return result;
    }

    /** Getters y Setters */
    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

}
