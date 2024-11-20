
package asesoriacompensar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class AsesoriaCompensar {

    private Queue<String> turnos = new LinkedList<>();  // Cola para los turnos
    private Stack<String> HistorialTurnos = new Stack<>(); // Pila para el historial de turnos atendidos
    private int ContadorTurnos= 1;
    
    
    //Generar y asignar nuevo turno
public void GenerarTurno (){   
   String CodigoTurno = "Turno # "+ ContadorTurnos++; // Creamos una variable con el contador de los turnos
   turnos.add (CodigoTurno);  //Agregamos el codigoTurno a la cola
   System.out.println("<---- Turno Nuevo Generado " + CodigoTurno+" ---->");

 }

    
    //Asignar el turno a un operario 
public void AsignarTurno (){
    if (!turnos.isEmpty()){
        System.out.println("<---- Turno Asignado al Operario: " + turnos.peek()+" ---->");
    } else {
        System.out.println("<---- No hay turnos asignados en la lista ---->");
    }
}

     //Eliminar turno ya atendido
public void EliminarTurno (){
    if (!turnos.isEmpty()){
        String TurnoAtendido = turnos.poll();
        HistorialTurnos.push(TurnoAtendido); //Agregamos el ultimo turno atendido a la pila
        System.out.println("<---- El Turno: " +TurnoAtendido+" Ha sido Atendido y Eliminado ---->");
    }   else {
        System.out.println("<---- No hay Turnos Para Eliminar ---->");
    }
}
 
    //Ver ultimo turno atendido usando la pila

public void VerUltimoTurno(){
    if (!HistorialTurnos.isEmpty()){
        System.out.println("El Ultimo Turno Atendido fue el: "+ HistorialTurnos.peek());
    } else {
        System.out.println("No hay Historial de Turnos en el Historial");
    }
}

    //MENU

public void Menu (){
    Scanner sc = new Scanner (System.in);
    int opcion;
    
    do{
        System.out.println("<---- BIENVENIDO A COMPENSAR ---->");
        System.out.println("1. Generar un nuevo Turno: ");
        System.out.println("2. Asignar Turno al Operado: ");
        System.out.println("3. Eliminar Turno Ya Atendido: ");
        System.out.println("4. Ver Ultimo Turno Atendido: ");
        System.out.println("5. Salir: ");
        System.out.print("Por favor seleccione una opcion: ");
        opcion = sc.nextInt();
        
        
        switch (opcion){    //Creamos el menu
            case 1: GenerarTurno();
            break;
            case 2: AsignarTurno();
            break;
            case 3: EliminarTurno();
            break;
            case 4: VerUltimoTurno ();
            break;
            case 5: System.out.println("Saliendo del Sistema....");
            break;
            default: System.out.println("Opcion no valida");
            break;
        }
    } while (opcion != 5);
    sc.close();
}

    public static void main(String[] args) {
        AsesoriaCompensar ControlT = new AsesoriaCompensar ();
        ControlT.Menu();
    }
    
}
