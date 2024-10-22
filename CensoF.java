
package censof;

import java.util.Scanner;
import javax.swing.*;


public class CensoF {

    
    
       public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "CONSULTA DE SERVICIOS SEGUN SU ESTRATO");

       //Solicito la cantidad de Familias
        int CantFamilias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese La cantidad de familias a registrar: "));
       

        // Arreglos para almacenar los valores
        double[] Agua = new double[CantFamilias];
        double[] Luz = new double[CantFamilias];
        double[] Gas = new double[CantFamilias];
        int[] Estrato = new int[CantFamilias];

        // Ingresar los datos de cada familia
        for (int i = 0; i < CantFamilias; i++) {
            JOptionPane.showMessageDialog(null,"\nDatos de la familia N. " + (i + 1) + ":");

            Agua[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del servicio de agua: "));
            Luz[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del servicio de la luz: "));
            Gas[i] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del servicio del gas: "));
            Estrato[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estrato de la familia (1, 2, 3 o más): "));
        }

        
        JOptionPane.showMessageDialog(null,"\n--- Totales a Pagar por Familia ---");
        for (int i = 0; i < CantFamilias; i++) {
            double descuentoAgua = aplicarDescuento(Agua[i], Estrato[i]);
            double descuentoLuz = aplicarDescuento(Luz[i], Estrato[i]);
            double descuentoGas = aplicarDescuento(Gas[i], Estrato[i]);

            
            JOptionPane.showMessageDialog(null,"\nFamilia N. " + (i + 1) + ":"+"\n"+
            "Total Agua: " + Agua[i] + "Total con descuento: " + descuentoAgua + "\n" +
            "Total Luz: " + Luz[i] + "Total con descuento: " + descuentoLuz + "\n" +
            "Total Gas: " + Gas[i] + "Total con descuento: " + descuentoGas);
        }

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
    
    

