

package censof;

import java.util.Scanner;
import javax.swing.*;


public class CensoF {

    
    
       public static void main(String[] args) {
        Scanner Teclado = new Scanner(System.in);
                

        // Solicitar la cantidad de familias
        System.out.print("Ingrese la cantidad de familias: ");
        int CantFamilias = Teclado.nextInt();
        Teclado.nextLine(); // Consumir el salto de línea pendiente

        // Arreglos para almacenar los valores
        double[] Agua = new double[CantFamilias];
        double[] Luz = new double[CantFamilias];
        double[] Gas = new double[CantFamilias];
        int[] Estrato = new int[CantFamilias];

        // Ingresar los datos de cada familia
        for (int i = 0; i < CantFamilias; i++) {
            System.out.println("\nDatos de la familia N. " + (i + 1) + ":");

            System.out.print("Ingrese el valor del servicio de agua: ");
            Agua[i] = Teclado.nextDouble();

            System.out.print("Ingrese el valor del servicio de luz: ");
            Luz[i] = Teclado.nextDouble();

            System.out.print("Ingrese el valor del servicio de gas: ");
            Gas[i] = Teclado.nextDouble();

            System.out.print("Ingrese el estrato de la familia (1, 2, 3 o más): ");
            Estrato[i] = Teclado.nextInt();
        }

        
        System.out.println("\n--- Totales a Pagar por Familia ---");
        for (int i = 0; i < CantFamilias; i++) {
            double descuentoAgua = aplicarDescuento(Agua[i], Estrato[i]);
            double descuentoLuz = aplicarDescuento(Luz[i], Estrato[i]);
            double descuentoGas = aplicarDescuento(Gas[i], Estrato[i]);

            System.out.println("\nFamilia N. " + (i + 1) + ":");
            System.out.printf("Total Agua: %.2f\n", descuentoAgua);
            System.out.printf("Total Luz: %.2f\n", descuentoLuz);
            System.out.printf("Total Gas: %.2f\n", descuentoGas);
        }

        Teclado.close(); 
    }

    
    public static double aplicarDescuento(double valor, int estrato) {
        double descuento;

        if (estrato == 1) {
            descuento = valor * 0.20; 
        } else if (estrato == 2) {
            descuento = valor * 0.15; 
        } else {
            descuento = valor * 0.09; 
        }

        return valor - descuento;
    }
}
    

