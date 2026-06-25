/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen;

import javax.swing.JOptionPane;

/**
 *
 * @author dilsh
 */
public class parte1 {

    public static int CalcularSuma(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 10) + CalcularSuma(n / 10);
    }

    public static void SumaDigitos() {
        int numero =  Integer.parseInt(JOptionPane.showInputDialog("Digite un valor entero y positivo: "));
       
                
                if (numero>0) {
                    int suma=CalcularSuma(numero);
                    JOptionPane.showMessageDialog(null,"la suma del numero digitado "+numero+" es:  " +suma);
                }else{
                    
                JOptionPane.showMessageDialog(null, "numero negativo no se puede usar ");
                
                }
                
                
                
                
                
                        
            }
        }

    


