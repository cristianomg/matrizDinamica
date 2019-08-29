/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  matriz;

/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class Vetor<T> implements InterfaceVetor<T>{
    private T[] vetor;
    private int tamanhoVetor;
    private int size; //numero de elementos inseridos 
    private int incremento;
    private boolean duplicado;
    private boolean contains;

    
    @Override
    //adiicona um elemento ao final da lista
    public boolean add(T elemento) {
            if (duplicado){
            this.resize(this.incremento);
            vetor[size] = elemento;
            size ++;
            return true;
    }
        else{
            if (this.contains(elemento)){
                return false;
            }
            else{
            this.resize(this.incremento);
            vetor[size] = elemento;
            size ++;
            return true;       
            
        }
    }
    }

    @Override
    //adiciona um elemento a partir de uma posicao
    public void add(T elemento, int posicao) {
        this.resize(this.incremento);
        if (duplicado){
            if (posicao == size){
                this.add(elemento);
            }
            else if (posicao < size){
                T [] varVetor = (T[]) new Object[tamanhoVetor];
                for(int i=0; i<posicao; i++){
                    varVetor[i] = vetor[i];
                }
                varVetor[posicao] = elemento;
                for(int i=posicao; i<size; i++){
                    varVetor[i+1]= vetor[i];
                }
                vetor = varVetor;
                size++;
            }
        }
        else{
            if (this.contains(elemento)){
                System.out.println("O elemento já está contido no Vetor!!!"); 
           }
            else{
                if (posicao == size){
                    this.add(elemento);
                }
                else if (posicao < size){
                    T [] varVetor = (T[]) new Object[tamanhoVetor];
                    for(int i=0; i<posicao; i++){
                        varVetor[i] = vetor[i];
                    }
                    varVetor[posicao] = elemento;
                    for(int i=posicao; i<size; i++){
                        varVetor[i+1]= vetor[i];
                    }
                    vetor = varVetor;
                    size++;
                }
            }
        }
    }

    
    @Override
    //adiciona um elemento no inicio da lista
    public void addInicio(T elemento) {
        this.resize(this.incremento);
        if(duplicado){
            T [] varVetor = (T[]) new Object[tamanhoVetor];
            varVetor[0] = elemento;
            System.arraycopy(vetor, 0, varVetor, 1, size);
            vetor = varVetor;
            size++;
          }
        else{
            if(this.contains(elemento)){
                System.out.println("O elemento já está contido no Vetor!!!");
            }
            else{
                T [] varVetor = (T[]) new Object[tamanhoVetor];
                varVetor[0] = elemento;
                System.arraycopy(vetor, 0, varVetor, 1, size);
                vetor = varVetor;
                size++;
            }
        }
    }

    @Override
    //adiciona um elemento no final da lista
    public void addFim(T elemento) {
        if (duplicado){
            vetor[size]= elemento;
            size++;
        }
        else{
            if(this.contains(elemento)){
                System.out.println("O elemento já está contido no Vetor!!!");
            }
            else{
                vetor[size]= elemento;
                size++;
            }
        }
    }

    @Override
    //limpa o vetor
    public void limpar() {
        T[] vetorVar = (T[]) new Object[tamanhoVetor];
        vetor = vetorVar;
        size = 0;
    }

    @Override
    // verifica se existe um elemento na lista
    public boolean contains(T elemento) {
               for (int i = 0; i< size; i++){
            if (vetor[i] == elemento){
                return true;
            }
        }
        return false;
    }

    @Override
    //retorna o elemento de uma posicao
    public T get(int posicao) {
        return vetor[posicao];
    }

    @Override
    //retorna o primeiro indice de um elemento na lista
    public int indexOf(T elemento) {
        for (int i=0; i<size; i++){
            if (vetor[i]==elemento){
                return i;
            }
        }
        return -1;
    }

    @Override
    //retorna o ultimo indice de um elemento na lista
    public int lastIndexOf(T elemento) {
        int result = -1;
        for (int i=0; i<size; i++){
            if(vetor[i]==elemento){
                result = i;
            }
        }
        return result;
    }

    @Override
    //retorna true se o vetor n é vasio
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    //remove um elemento em uma posição especifica entre os adicionados
    public T remover(int posicao) {
        T result = null;
        if (posicao ==0){
            result = this.removerNoInicio();
        }
        else if (posicao == size-1){
            result = this.removerNoFim();
        }
        else if (posicao < size-1){
            result = vetor[posicao];
            T[] vetorVar = (T[]) new Object[tamanhoVetor];
            System.arraycopy(vetor, 0, vetorVar, 0, posicao);
            System.arraycopy(vetor, posicao+1, vetorVar, posicao, size);
            vetor = vetorVar;
            size--;
            }
        return result;
        }

    @Override
    //remove o primeiro elemento da lista
    public T removerNoInicio() {
        T result = vetor[0];
        T[] vetorVar = (T[]) new Object[tamanhoVetor];
        System.arraycopy(vetor, 1, vetorVar, 0, size);
        vetor = vetorVar;
        size --;
        return result;
    }

    @Override
    //remove o ultimo elemento da lista
    public T removerNoFim() {
        T result = vetor[size-1];
        vetor[size-1] = null;
        size --;
        return result;
    }

    @Override
    // retorna o numero de elementos da lista
    public int size() {
        return size;
    }

    @Override
    // aumenta o vetor em length posicoes
    public void resize(int length) {
        if (vetor[tamanhoVetor-1] != null) {
            tamanhoVetor += length;
            T[] vetorVar = (T[]) new Object[tamanhoVetor];
            System.arraycopy(vetor, 0, vetorVar, 0, vetor.length);
            this.vetor = vetorVar;
        }
    }
    
    
    public Vetor(){
        this.vetor = (T[]) new Object[10];
        this.tamanhoVetor = 10;
        this.incremento = tamanhoVetor;
        this.size = 0;
        this.duplicado = true;
        
    }
    
    public Vetor(int tamanhoInicial){
        this.vetor = (T[]) new Object[tamanhoInicial];
        this.tamanhoVetor = tamanhoInicial;
        this.incremento = tamanhoVetor;
        this.size = 0;
        this.duplicado = true;
    }
    
    public Vetor(boolean duplicados){
        this.vetor = (T[]) new Object[10];
        this.tamanhoVetor = 10;
        this.incremento = tamanhoVetor;
        this.size = 0;
        this.duplicado = false;
    }
    
}
 