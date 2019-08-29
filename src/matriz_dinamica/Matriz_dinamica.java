/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_dinamica;

import matriz.Matriz;


/**
 *
 * @author cristiano pc
 */
public class Matriz_dinamica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Matriz matriz_teste = new Matriz(5);
       matriz_teste.add(0, 10);
       matriz_teste.add(1, 12); 
       matriz_teste.add(1, 100);
       matriz_teste.add(2, 102); 
       matriz_teste.add(2, 200);
       matriz_teste.add(2, 202);
       matriz_teste.add(3, 100);
       matriz_teste.add(3, 102);
       matriz_teste.add(3, 100);
       matriz_teste.add(3, 102);
       
       for (int i=0; i<5; i++){
           for (int j=0; j< matriz_teste.getLinha(i).size(); j++){
               System.out.println(matriz_teste.getLinha(i).get(j));
            }
        }
       matriz_teste.remove(3, 1);
        for (int i=0; i<5; i++){
            for (int j=0; j< matriz_teste.getLinha(i).size(); j++){
                System.out.println(matriz_teste.getLinha(i).get(j));
            }
        }
        
        System.out.println("Contem o valor 200: "+matriz_teste.contains(200));
        
        
    }
}