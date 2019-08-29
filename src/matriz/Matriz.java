/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;
/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class Matriz<T> {
    private final int qtdLinhas;
    private final Vetor[] matriz;
    
    
    public Matriz(int qtdLinhas){
    this.qtdLinhas = qtdLinhas;
    this.matriz = new Vetor[10];
    this.createMatriz();
    }
    
    private void createMatriz(){
        for(int i=0; i<qtdLinhas; i++){
            matriz[i] = new Vetor();
        }
    }
    
    public boolean add(int linha, T elemento){
        if (linha < this.qtdLinhas){
            matriz[linha].add(elemento);
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public void remove(int linha, int coluna){
        matriz[linha].remover(coluna);
    }
    
    public T get(int linha, int coluna){
        return (T) matriz[linha].get(coluna);
    }
    
    public Vetor getLinha(int linha){
        return matriz[linha];
    }
    
    public boolean contains(T elemento){
        for(int i=0; i<qtdLinhas; i++){
            for(int j=0; j<matriz[i].size(); j++){
                if (this.get(i, j).equals(elemento)){
                    return true;
                }  
            }

        }
        return false;
    }
    

    
      
}