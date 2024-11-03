
package biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class Biblioteca {

    static String[][] libros = new String[100][5];
    static int contadorLibros = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int opcion; //Aqui se guarda la opcion del usuario
        do {
            System.out.println("\n-----BIENVENIDOS A LA BIBLIOTECA COMPENSAR----");
            System.out.println("1. Registrar un nuevo libro");
            System.out.println("2. Actualizar libro");
            System.out.println("3. Eliminar libro");
            System.out.println("4. Buscar libro");
            System.out.println("5. Ordenar libros");
            System.out.println("6. Salir");
            System.out.println("\n--Por favor seleccione una opcion--");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea
            
            switch (opcion) {
                case 1: RegistrarLibro (sc);
                break;
                case 2: ActualizarLibro (sc);
                break;
                case 3: EliminarLibro (sc);
                break;
                case 4: BuscarLibro (sc);
                break;
                case 5: OrdenarLibros (sc);
                break;
                case 6: System.out.println("Saliendo del programa");
                break;
                default : System.out.println("Opcion no valida");
            }
            
        } while (opcion != 6); //el ciclo funcionara mientras que la opcion sea 6
    }
    
    
    //METODO PARA REGISTRAR UN LIBRO NUEVO
    public static void RegistrarLibro(Scanner sc){
        if (contadorLibros >= libros.length){
            System.out.println("No hay mas espacio para registrar libros");
            return;
        }
        
        System.out.print("Ingrese el codigo del libro: ");
        libros[contadorLibros][0] = sc.nextLine();
        System.out.print("Ingrese el nombre del libro: ");
        libros[contadorLibros][1] = sc.nextLine();
        System.out.print("Ingrese el Autor del libro: ");
        libros[contadorLibros][2] = sc.nextLine();
        System.out.print("Ingrese la materia del libro: ");
        libros[contadorLibros][3] = sc.nextLine();
        System.out.print("Ingrese las paginas del libro: ");
        libros[contadorLibros][4] = sc.nextLine();
        
        contadorLibros++;
        System.out.println("El libro se ha guardado exitosamente");
    }
    
    //METODO PARA ACTUALIZAR UN LIBRO EXISTENTE
    public static void ActualizarLibro(Scanner sc){
        System.out.println("Ingrese el codigo del libro que vas a actualizar: ");
        String Codigo = sc.nextLine();
        int index = BuscarLibroSecuencial(Codigo);
        
        if (index == -1){
            System.out.println("Libro no encontrado");
            return;
        }
        System.out.print("Ingrese nuevo codigo del libro: ");
        libros[index][0] = sc.nextLine();
        System.out.print("Ingrese nuevo nombre del libro: ");
        libros[index][1] = sc.nextLine();
        System.out.print("Ingrese nuevo autor del libro: ");
        libros[index][2] = sc.nextLine();
        System.out.print("Ingrese nueva materia del libro: ");
        libros[index][3] = sc.nextLine();
        System.out.print("Ingrese el numero de paginas del libro: ");
        libros[index][4] = sc.nextLine();
        
        System.out.println("SE HA ACTUALIZADO EL LIBRO EXITOSAMENTE");
    }
    
    //METODO PARA ELIMINAR UN LIBRO
    public static void EliminarLibro (Scanner sc){
        System.out.println("Ingrese el codigo del libro para eliminarlo: ");
        String Codigo = sc.nextLine();
        int index = BuscarLibroSecuencial (Codigo);
        
         if (index == -1) {
            System.out.println("Libro no encontrado.");
            return;
         }
        for (int i = index; i < contadorLibros - 1; i++) {
            libros[i] = libros[i + 1];
        }
        libros[contadorLibros - 1] = new String[5]; // Limpiar el último registro
        contadorLibros--;
        
        System.out.println("EL LIBRO HA SIDO ELIMINADO");
    }
    
    //METODO PARA BUSCAR UN LIBRO 
    public static void BuscarLibro (Scanner sc){
        System.out.println("Seleccione el metodo de busqueda: ");
        System.out.println("1. Busqueda secuencial");
        System.out.println("2. Busqueda binaria (Requiere ordenacion previa)");
        System.out.println("Opcion: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el codigo del libro: ");
        String Codigo = sc.nextLine();
        
        int index = (opcion == 1) ? BuscarLibroSecuencial (Codigo) : BuscarLibroBinario (Codigo);
        
        if (index == - 1){
            System.out.println("No se pudo encontrar el libro");   
        } else {
            System.out.println("Libro Encontrado "+ String.join(",", libros[index]));
        }
    }
    
    //METODO BUSQUEDA SECUENCIAL
    public static int BuscarLibroSecuencial (String Codido){
        for (int i = 0; i < contadorLibros; i++){
            if (libros[i][0].equals(Codido)){
                return i;
            }
        }
        return -1;
    }
    
    //METODO BUSQUEDA BINARIA (Los libros deben estar ordenados por codigo)
    public static int BuscarLibroBinario (String Codigo){
        int inicio = 0, fin = contadorLibros -1;
        
         while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            int comparacion = libros[medio][0].compareTo(Codigo);

            if (comparacion == 0) {
                return medio;
            } else if (comparacion < 0) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }
    
    //METODO PARA ORDENAR LOS LIBROS
    public static void OrdenarLibros (Scanner sc){
        System.out.println("Elija el campo o espacio para ordenar");
        System.out.println("0. Codigo");
        System.out.println("1. Nombre");
        System.out.println("2. Autor");
        System.out.println("Opcion: ");
        int espacio = sc.nextInt();
        
        System.out.println("Ahora, Seleccione el metodo de Ordenamiento");
        System.out.println("1. Burbuja");
        System.out.println("2. Selección");
        System.out.println("Opcion: ");
        int MetodoBusqueda = sc.nextInt();
        
        if (MetodoBusqueda == 1){
            Burbuja (espacio);
        } else 
              {Seleccion (espacio);
        }
        System.out.println("Los Libros Se Han Ordenado Exitosamente");
        }
    
    //METODO BURBUJA
    public static void Burbuja(int espacio) {
        for (int i = 0; i < contadorLibros - 1; i++) {
            for (int j = 0; j < contadorLibros - 1 - i; j++) {
                if (libros[j][espacio].compareTo(libros[j + 1][espacio]) > 0) {
                    String[] temp = libros[j];
                    libros[j] = libros[j + 1];
                    libros[j + 1] = temp;
                }
            }
        }
    }
    
    
    //METODO SELECCION 
    public static void Seleccion(int campo) {
        for (int i = 0; i < contadorLibros - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < contadorLibros; j++) {
                if (libros[j][campo].compareTo(libros[minIndex][campo]) < 0) {
                    minIndex = j;
                }
            }
            String[] temp = libros[i];
            libros[i] = libros[minIndex];
            libros[minIndex] = temp;
        }
    }
    
    }
    
   

         
         
         

    

