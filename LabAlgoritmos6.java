/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labalgoritmos6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Angelica Figueroa Muñiz
 * Abril 10, 2018
 * Clase main, en la cual se contiene el menu 
 * principal con las opciones diponibles para
 * realizar. Dentro de esta clase se utiliza una lista doble
 * para almacenar informacion de la poblacion de México,
 * almacenando objetos de tipo Poblacion.
 */
public class LabAlgoritmos6 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        ListaDoble <Poblacion> entidades = new ListaDoble();
        Scanner lector = new Scanner(System.in);
        Scanner input = new Scanner(new File("poblacion.txt"));//archivo con info
        input.useDelimiter("-|\n");//delimitador para el scanner
        String estado;
        String sexo;
        String poblacion;
        String opcion; 
        
        do{//menu principal    
        System.out.println("✦✦✦✦✦✦✦✦✦✦✦✦ Población de México 2015 ✦✦✦✦✦✦✦✦✦✦✦✦");
        System.out.println("1.Registrar desde teclado      2.Registrar desde archivo");
        System.out.println("3.Eliminar un estado           4.Corregir estado");
        System.out.println("5.Corregir sexo                6.Corregir cantidad de poblacion");
        System.out.println("7.Mostrar información         8.Mostrar último");
        System.out.println("9.Mostrar primero             10.Mostrar de posicion a inicio");
        System.out.println("11.Mostrar de posicion a fin  12.Salir");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Ingrese una opcion: ");//se pide una opcion al usuario
        opcion = lector.nextLine();
        System.out.println("-------------------------------------------------------------");
        
        switch (opcion) {//switch para cada una de las opciones
            case "1"://registro desde teclado
                System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧ Registro desde teclado ✧✧✧✧✧✧✧✧✧✧✧✧✧");
                System.out.println("Ingrese la siguiente información...");//se pide la informacion
                System.out.print("Estado: ");
                estado = lector.nextLine();
                for(int i = 0; i < 2; i++){
                System.out.print("Sexo: ");
                sexo = lector.nextLine();
                System.out.print("Poblacion: ");
                poblacion = lector.nextLine();
                Poblacion p = new Poblacion(estado, sexo, poblacion);//se crea un objeto de tipo Poblacion con la informacion
                entidades.insertaFin(p);//se inserta el objeto en la lista
                }
                System.out.println("-------------------------------------------------------------");
                System.out.println("Se ha registrado la información exitosamente");
                System.out.println("-------------------------------------------------------------");
                break;
            case "2"://registro desde archivo
                System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧ Registro desde archivo ✧✧✧✧✧✧✧✧✧✧✧✧✧");
                System.out.print("Ingrese la cantidad de registros que desea realizar: ");//se pide la cantidad de registros que se realizaran
                int cantidad = lector.nextInt();
                lector.nextLine();
                int contador = 0;
                while (input.hasNextLine() && contador < cantidad) {//se lee la info del archivo
                    estado = input.next();
                    sexo = input.next();
                    poblacion = input.next();
                    Poblacion p2 = new Poblacion(estado, sexo, poblacion);//se crea un objeto Poblacion con la info obtenida
                    entidades.insertaFin(p2);//se inserta el objeto en la lista
                    contador++;
                }
                System.out.println("-------------------------------------------------------------");
                System.out.println("Se ha registrado la información exitosamente");
                System.out.println("-------------------------------------------------------------");
                break;
            case "3"://eliminar estado ligado con sexo
                if (entidades.estaVacia()) {//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                } else {//si no esta vacia
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Eliminar estado ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.println("Ingrese la siguiente información...");//se pide la info necesaria
                    System.out.print("Estado: ");
                    String estadoEliminar = lector.nextLine();
                    System.out.print("Sexo: ");
                    String sexoEliminar = lector.nextLine();
                    if(entidades.estaEnLaLista(estadoEliminar, sexoEliminar)){//se verifica que el estado y sexo se encuentren en la lista
                    System.out.println("--- Estado eliminado ---\n" + entidades.eliminarPorEstadoYSexo(estadoEliminar, sexoEliminar));//se elimina el estado y sexo
                    }else{//si no se encuentra el estado y sexo en la lista
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("No se encontro un registro con la info. ingresada");
                    System.out.println("-------------------------------------------------------------");
                    }
                }
                break;
            case "4"://corregir estado
                if(entidades.estaVacia()){//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                }else{//si no esta vacia
                    System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Corregir estado ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.print("Ingrese el estado que desea corregir: ");//se pide el estado que se va a corregir
                    String estadoViejo = lector.nextLine();
                    System.out.print("Ingrese el nuevo estado: ");//se pide el nuevo estado
                    String estadoNuevo = lector.nextLine();
                    if(entidades.estaEnLaLista(estadoViejo)){//si el estado esta en la lista
                    entidades.corregirEstado(estadoViejo, estadoNuevo);//se realiza la correcion
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Se ha actualizado la información exitosamente");
                    System.out.println("-------------------------------------------------------------");
                    }else{//si no se encontro el estado en la lista
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("No se encontro un registro con la info. ingresada");
                    System.out.println("-------------------------------------------------------------");    
                    }
                }
                break;
            case "5"://corregir sexo
                if(entidades.estaVacia()){//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                }else{//si no esta vacia
                   System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Corregir sexo ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                    System.out.print("Ingrese el sexo que desea corregir: ");//se pide el sexo que se cambiara
                    String sexoCorregir = lector.nextLine();
                    System.out.print("Ingrese la correccion que se asignara: ");//se pide el sexo que se asiganara
                    String sexoNuevo = lector.nextLine();
                    System.out.print("Ingrese el estado al que se aplicaran los cambios: ");//se pide el estado donde se realizaran los cambios
                    String estadoCorregir = lector.nextLine();
                    if(entidades.estaEnLaLista(estadoCorregir, sexoCorregir)){//se revisa que el estado y sexo esten en la lista
                    entidades.corregirSexo(sexoCorregir, sexoNuevo, estadoCorregir);//se realiza el cambio
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Se ha actualizado la información exitosamente");
                    System.out.println("-------------------------------------------------------------");
                    }else{//si no se encuentran el estado y sexo en la lista
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("No se encontro un registro con la info. ingresada");
                    System.out.println("-------------------------------------------------------------");
                    }
                }
                break;
            case "6"://corregir cantidad de poblacion
                if(entidades.estaVacia()){//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                }else{//si no esta vacia
                System.out.println("✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧ Corregir población ✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧✧");
                System.out.print("Ingrese el estado al que se aplicaran los cambios: ");//se pide el estado donde se realizaran los cambios
                String estadoPoblacion = lector.nextLine();
                System.out.print("Ingrese el sexo al se modificara la población: ");//se pide el sexo donde se aplicaran los cambios
                String sexoPoblacion = lector.nextLine();
                System.out.print("Ingrese la nueva población: ");//se pide la nueva poblacion
                String nuevaPoblacion = lector.nextLine();
                if(entidades.estaEnLaLista(estadoPoblacion, sexoPoblacion)){//se revisa que la lista contengo el estado y sexo con la info ingresada
                entidades.corregirPoblacion(estadoPoblacion, sexoPoblacion, nuevaPoblacion);//se realizan los cambios
                System.out.println("-------------------------------------------------------------");
                System.out.println("Se ha actualizado la información exitosamente");
                System.out.println("-------------------------------------------------------------");
                }else{//si no se encuentran el estado y sexo en la lista
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("No se encontro un registro con la info. ingresada");
                    System.out.println("-------------------------------------------------------------");
                }
                }
                break;
            case "7"://mostrar toda la informacion
                if(entidades.estaVacia()){//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                }else{//si no esta vacia se muestra toda la informacion
                    System.out.println(entidades.mostrarRecursivo(entidades.getInicio()));
                }
                break;
            case "8"://mostrar último
                if (entidades.estaVacia()) {//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                } else {//si no esta vacia se muestra la informacion del ultimo
                    System.out.println(entidades.getFin().getInfo());
                    System.out.println("-------------------------------------------------------------");
                }
                break;
            case "9"://mostrar primero
                if (entidades.estaVacia()) {//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                } else {//si no esta vacia se muestra la informacion del primero
                    System.out.println(entidades.getInicio().getInfo());
                    System.out.println("-------------------------------------------------------------");
                }
                break;
            case "10"://mostrar desde posicion hasta inicio
                if (entidades.estaVacia()) {//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                } else {//si no esta vacia
                    System.out.println("Ingrese el estado desde el que se mostrara la información: ");//se pide el estado desde donde se iniciara el recorrido
                    String estadoMostrar = lector.nextLine();
                    if (entidades.estaEnLaLista(estadoMostrar)) {//se revisa que el estado se encuentre en la lista
                        NodoDoble r = entidades.buscarDesdeFin(estadoMostrar);
                        System.out.println(entidades.mostrarRecursivoRevez(r));//se muestra la informacion
                    } else {//si el estado no se encontro en la lista
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("No se encontro el estado ingresado");
                        System.out.println("-------------------------------------------------------------");
                    }
                }
                break;
            case "11"://mostrar desde posicion hasta fin
                if (entidades.estaVacia()) {//se revisa si la lista esta vacia
                    System.out.println("No hay información en el registro");
                    System.out.println("-------------------------------------------------------------");
                } else {//si no esta vacia
                    System.out.println("Ingrese el estado desde el que se mostrara la información: ");//se pide el estado desde donde se iniciara el recorrido
                    String estadoMostrar = lector.nextLine();
                    if (entidades.estaEnLaLista(estadoMostrar)) {//se revisa que el estado se encuentre en la lista
                        NodoDoble r = entidades.buscarDesdeInicio(estadoMostrar);//se muestra la informacion
                        System.out.println(entidades.mostrarRecursivo(r));
                    } else {//si el estado no se encontro en la lista
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("No se encontro el estado ingresado");
                        System.out.println("-------------------------------------------------------------");
                    }
                }
                break;
            case "12"://salir
                System.out.println("¡Adios!");
                System.exit(0);//se termina la ejecucion
                break;
            default:
                System.out.println("Opción invalida");
        }//fin del switch
        }while(!opcion.matches("12"));//se repite el ciclo mientras que no se ingrese "12"

    }
    
}//fin de la clase
