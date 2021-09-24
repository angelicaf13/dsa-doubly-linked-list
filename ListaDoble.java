/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos6;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abril 10, 2018
 * La clase ListaDoble, se utiliza para representar un estructura 
 * de datos en la cual se sigue el principio y funcionamiento de 
 * las listas doblemente ligadas. Esta clase tiene como atributos
 * dos nodos dobles; inicio y fin.
 */
public class ListaDoble <T> {
    
    private NodoDoble inicio;
    private NodoDoble fin;

    /**
     * Método constructor sin parametros
     */
    public ListaDoble() {
    }

    /**
     * Método constructor parametrizado
     * @param inicio el inicio de la lista doble
     * @param fin el fin de la lista doble
     */
    public ListaDoble(NodoDoble inicio, NodoDoble fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    /**
     * Método para obtener el inicio de la lista doble
     * @return el inicio de la lista
     */
    public NodoDoble getInicio() {
        return inicio;
    }

    /**
     * Método para asignar el inicio de la lista doble
     * @param inicio el inicio de la lista
     */
    public void setInicio(NodoDoble inicio) {
        this.inicio = inicio;
    }

    /**
     * Método para obtener el fin de la lista doble
     * @return el fin de la lista doble
     */
    public NodoDoble getFin() {
        return fin;
    }

    /**
     * Método para asignar el fin de la lista
     * @param fin el fin de la lista
     */
    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }
    
    /**
     * Método para insertar informacion al inicio de la lista doble
     * @param dato la información que se almacenara
     */
    public void insertaInicio(T dato){
        NodoDoble n = new NodoDoble();
        n.setInfo(dato);
        if(inicio == null){//no hay nada
            n.setSig(null);
            n.setAnt(null);
            inicio = fin = n;
        }else{
            n.setSig(inicio);
            n.setAnt(null);
            inicio.setAnt(n);
            inicio = n;
        }
    }
    
    /**
     * Método para insertar informacion al final de la lista doble
     * @param dato la informacion que se almacenara
     */
    public void insertaFin(T dato){
        NodoDoble n = new NodoDoble();
        n.setInfo(dato);
        //n.setSig(null);
        if(inicio == null){//no hay nada
            n.setAnt(null);
            n.setSig(null);
            inicio = fin = n;
        } else {//ya hay nodos
            NodoDoble r = inicio;
            while(r.getSig() != null){
                r = r.getSig();
            }
            r.setSig(n);
            n.setAnt(r);
            fin = n;
        }
    }
    
    /**
     * Método para eliminar la informacion al inicio de la lista doble
     * @return la informacion al inicio de la lista
     */
    public T eliminaInicio(){
        T dato = null;
        if(inicio == null){
            System.out.println("Lista vacia");
        } else {
            if(inicio.getSig() == null){//solo hay uno
                dato = (T) inicio.getInfo();
                inicio = fin = null;
            } else {
                dato = (T) inicio.getInfo();
                inicio = inicio.getSig();
                inicio.setAnt(null);
            }
        }
        return dato;
    }
    
    /**
     * Método para eliminar la informacion al final de la lista doble
     * @return la informacion al final de la lista
     */
    public T eliminaFin(){
        T dato =  null;
        if(inicio == null){
            System.out.println("Lista vacia");
        } else {
            if(inicio.getSig() == null){//solo hay uno
                dato = (T) inicio.getInfo();
                inicio = fin = null;
            } else {
                dato = (T) fin.getInfo();
                fin = fin.getAnt();
                fin.setSig(null);
            }
        }
        return dato;
    }
    
    public String mostarIterativo(){
        String info = "";
        if(inicio == null){
            return "Lista vacia";
        }else{
            NodoDoble a = inicio;
            while(a != null){
                info += a.getInfo() + ", ";
                a = a.getSig();
            }
        }
        return info;
    }
    
    /**
     * Método para mostrar el contenido en la lista doble
     * @param r el inicio de la lista
     * @return una cadena con la informacion en la lista doble
     */
    public String mostrarRecursivo(NodoDoble r){
        if(r == null){
            return "";
        } else {
            return "" + r.getInfo() + "\n" + mostrarRecursivo(r.getSig());
        }
    }
    
    /**
     * Método para mostrar el contenido de la lista desde el nodo indicado hasta el inicio
     * @param r el nodo donde se inicia el recorrido
     * @return una cadena con la informacion
     */
    public String mostrarRecursivoRevez(NodoDoble r){
        if(r == null){
            return "";
        } else {
            return "" + r.getInfo() + "\n" + mostrarRecursivoRevez(r.getAnt());
        }
    }
    
    /**
     * Método para realizar una busqueda en la lista desde el inicio
     * @param estado el estado que se buscara
     * @return el nodo doble donde se encontro el estado
     */
    public NodoDoble buscarDesdeInicio(String estado){
        NodoDoble r = inicio;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getSig() != null && !p.getEstado().matches(estado)){
            r = r.getSig();
            p = (Poblacion)r.getInfo();
        }
        return r;
    }
    
    /**
     * Método para realizar una busqueda en la lista desde el fin
     * @param estado el estado que se buscara
     * @return el nodo doble donde se encontro el estado
     */
    public NodoDoble buscarDesdeFin(String estado){
        NodoDoble r = fin;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getAnt() != null && !p.getEstado().matches(estado)){
            r = r.getAnt();
            p = (Poblacion)r.getInfo();
        }
        return r;
    }
    
    /**
     * Método para mostrar el contenido de la lista desde el estado indicado hasta el inicio
     * @param estado el estado donde se inicia el recorrido
     */
    public void mostrarDesdePosicionHastaInicio(String estado){
        NodoDoble r = fin;
        Poblacion i = (Poblacion) inicio.getInfo();
        Poblacion f = (Poblacion) fin.getInfo();
        if(estado.matches(i.getEstado())){
            System.out.println(inicio.getInfo().toString());
        }else if(estado.matches(f.getEstado())){
            System.out.println(mostrarRecursivoRevez(fin));
        } else {
            NodoDoble m = fin;
            Poblacion p = (Poblacion)m.getInfo();
            while (m.getAnt() != null && !p.getEstado().matches(estado)) {
                m = m.getAnt();
                p = (Poblacion) m.getInfo();
            }
            System.out.println(mostrarRecursivoRevez(m));
        }
        
    }

    
//    public String mostrarDesdePosicionHastaFin(String estado){
//        if(r == null){
//            return "";
//        } else {
//            return "" + r.getInfo() + "\n" + mostrarDesdePosicionHastaFin(r.getSig());
//        }
//    }
    
    public T eliminaX(T x){
        T dato = null;
        NodoDoble r = inicio;
        while(r.getSig() != null && x.hashCode() != r.getInfo().hashCode()){//recorrer para buscar info
            r = r.getSig();
        }
        if(x.hashCode() == r.getInfo().hashCode()){
            if(r == inicio && r == fin){//solo hay un elemento
                dato = (T) r.getInfo();
                inicio = null;
                fin = null;
            } else {
                if(r == inicio){//es el primero
                    dato = (T) eliminaInicio();
                } else if(r == fin){//es el ultimo
                    dato = (T) eliminaFin();
                } else {//esta enmedio
                    dato = (T) r.getInfo();
                        NodoDoble n = r.getAnt();
                        NodoDoble a = r.getSig();
                        n.setSig(a);
                        a.setAnt(n);
                }
            }
        }
        return dato;
    }
    
    public int buscar(T x){
        int index = 0;
        if(inicio == null){
            System.out.println("Lista vacia");
            index = -1;
        }else{
            NodoDoble r = inicio;
            while(r.getSig() != null && r.getInfo().hashCode() != x.hashCode()){
                r = r.getSig();
                index++;
            }
            if(r.getSig() == null && r.getInfo().hashCode() != x.hashCode()){
                index = -1;
            }
        }
        return index;
    }
    
    /**
     * Método para eliminar un elemento de la lista que coincida con la 
     * informacion especificada.
     * @param estado el estado de la poblacion
     * @param sexo el sexo de la poblacion
     * @return la informacion que se eliminara
     */
    public T eliminarPorEstadoYSexo(String estado, String sexo){
        T dato = null;
        NodoDoble r = inicio;
        Poblacion p = new Poblacion();
        p.setEstado(estado);
        p.setSexo(sexo);
        Poblacion e = (Poblacion)r.getInfo();
        while((r.getSig() != null && !p.getEstado().matches(e.getEstado()) && !p.getSexo().matches(e.getSexo()) )
                || (r.getSig() != null && p.getEstado().matches(e.getEstado()) && !p.getSexo().matches(e.getSexo()))
                || (r.getSig() != null && !p.getEstado().matches(e.getEstado()) && p.getSexo().matches(e.getSexo()))){//recorrer para buscar info
                
            r = r.getSig();
            e = (Poblacion)r.getInfo();
        }
        if(e.getEstado().matches(p.getEstado()) && e.getSexo().matches(p.getSexo())){//si si lo encontro
            if(r == inicio && r == fin){//solo hay un elemento
                dato = (T) r.getInfo();
                inicio = null;
                fin = null;
            } else {
                if(r == inicio){//es el primero
                    dato = (T) eliminaInicio();
                } else if(r == fin){//es el ultimo
                    dato = (T) eliminaFin();
                } else {//esta enmedio
                        dato = (T)r.getInfo();
                        NodoDoble n = r.getAnt();
                        NodoDoble a = r.getSig();
                        n.setSig(a);
                        a.setAnt(n);    
                }
            }
        }
        return dato;
    }
    
    public T eliminaPosicion(int posicion) {//aqui te quedaste
        T dato = null;
        if (inicio == null) {
            System.out.println("Lista vacia");
        } else if (posicion == 0) {//si es el primero
            dato = (T) eliminaInicio();
        } else {
            int contador = 0;
            NodoDoble r = inicio;
            while (r.getSig() != null && contador != posicion) {
                r = r.getSig();
                contador++;
            }
            if (contador == posicion) {//si si lo encontro
                if (r.getSig() != null && r != fin) {//si esta en medio
                    dato = (T) r.getInfo();
                    NodoDoble n = r.getAnt();
                    NodoDoble a = r.getSig();
                    n.setSig(a);
                    a.setAnt(n);
                } else if (r == fin) {//si es el ultimo
                    dato = (T) eliminaFin();
                }
            }
        }
        return dato;
    }
    
    public void ordenaLista(){
        if(inicio == null){//esta vacia
            System.out.println("Lista vacia");
        }else if(inicio.getSig() == null){
            //no hace nada porque solo hay un elemento
        }else{
            NodoDoble r = inicio;
            NodoDoble a = inicio.getSig();
            T aux;
            while(r.getSig() != null){
                while(a != null){
                    if(r.getInfo().hashCode() > a.getInfo().hashCode()){
                        aux =  (T) r.getInfo();
                        r.setInfo(a.getInfo());
                        a.setInfo(aux);
                    }
                    a= a.getSig();
                }
                r = r.getSig();
                a = r.getSig();
            }
        }
    }
    
    public void insertaEnPosicion(T dato, int posicion){
        if(posicion < 0){
            //posicion invalida
        }else if(posicion == 0){
            insertaInicio(dato);
        }else{

            int contador = 0;
            NodoDoble r = inicio;
            while(r != fin && contador != posicion){
                r = r.getSig();
                contador++;
            }
            if (contador == posicion){
                NodoDoble n = new NodoDoble();
                n.setInfo(dato);
                NodoDoble a = r.getAnt();
                n.setSig(r);
                n.setAnt(a);
                r.setAnt(n);
                a.setSig(n);
            }
        }
    }
    
    /**
     * Método para saber si la lista esta vacia
     * @return true si la lista esta vacia o
     * false en caso de tener elementos
     */
    public boolean estaVacia(){
        return inicio == null;
    }
    
    /**
     * Método para corregir el estado de un nodo en la lista
     * @param estadoViejo el estado que se cambiara
     * @param estadoNuevo el estado nuevo que se asignara
     */
    public void corregirEstado(String estadoViejo, String estadoNuevo){
        NodoDoble r = inicio;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getSig() != null){//recorrido hasta el final de la lista
            if(p.getEstado().matches(estadoViejo)){
                p.setEstado(estadoNuevo);
            }
            r = r.getSig();
            p = (Poblacion)r.getInfo();
        }
        if(r.getSig() == null){//cuando llega al final
          if(p.getEstado().matches(estadoViejo)){
                p.setEstado(estadoNuevo);
            }  
        }
    }
    
    /**
     * Método para corregir el sexo de una poblacion
     * @param sexoViejo el sexo que se cambiara
     * @param sexoNuevo el sexo que se asignara
     * @param estado el estado donde se realizaran los cambios
     */
    public void corregirSexo(String sexoViejo, String sexoNuevo, String estado){
        NodoDoble r = inicio;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getSig() != null ){
            if(p.getEstado().matches(estado) && p.getSexo().matches(sexoViejo)){
                p.setSexo(sexoNuevo);
            }
            r = r.getSig();
            p = (Poblacion)r.getInfo();
        }
        if(r.getSig() == null){
            if(p.getEstado().matches(estado) && p.getSexo().matches(sexoViejo)){
                p.setSexo(sexoNuevo);
            }
        }
    }
    
    /**
     * Método para corregir la poblacion de un estado
     * @param estado el estado donde se realizaran los cambios
     * @param sexo el sexo al que se le aplicaran los cambios
     * @param nuevaPoblacion la nueva poblacion que se asignara
     */
    public void corregirPoblacion(String estado, String sexo, String nuevaPoblacion){
        NodoDoble r = inicio;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getSig() != null){
            if(p.getEstado().matches(estado) && p.getSexo().matches(sexo)){
                p.setPoblacion(nuevaPoblacion);
            }
            r = r.getSig();
            p = (Poblacion)r.getInfo();
        }
        if(r.getSig() == null){
            if(p.getEstado().matches(estado) && p.getSexo().matches(sexo)){
                p.setPoblacion(nuevaPoblacion);
            }
        }
    }
    
    /**
     * Método para saber si un estado y sexo se encuentran en la lista
     * @param estado el estado que se buscara
     * @param sexo el sexo que se buscara
     * @return true si se encuentra en la lista
     */
    public boolean estaEnLaLista(String estado, String sexo){
        boolean esta = false;
        NodoDoble r = inicio;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getSig() != null){
            if(p.getEstado().matches(estado) && p.getSexo().matches(sexo)){
                esta = true;
                break;
            }
            r = r.getSig();
            p = (Poblacion)r.getInfo();
        }
        if(r.getSig() == null){
            if(p.getEstado().matches(estado) && p.getSexo().matches(sexo)){
                esta = true;
            }
        }
        return esta;
    }
    
    /**
     * Método para saber si un estado se encuentra en la lista
     * @param estado el estado que se buscara
     * @return true si el estado se encuentra en la lista
     */
    public boolean estaEnLaLista(String estado){
        boolean esta = false;
        NodoDoble r = inicio;
        Poblacion p = (Poblacion)r.getInfo();
        while(r.getSig() != null){
            if(p.getEstado().matches(estado)){
                esta = true;
                break;
            }
            r = r.getSig();
            p = (Poblacion)r.getInfo();
        }
        if(r.getSig() == null){
            if(p.getEstado().matches(estado)){
                esta = true;
            }
        }
        return esta;
    }
}
