/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

/**
 *
 * @author cristiano pc
 */
public interface InterfaceVetor<T> {
    public abstract boolean add(T elemento);
    public abstract void add(T elemento, int posicao);
    public abstract void addInicio(T elemento);
    public abstract void addFim(T elemento);
    
    public abstract void limpar();
    
    public abstract boolean contains(T elemento);
    public abstract T get(int posicao);
    public abstract int indexOf(T elemento);
    public abstract int lastIndexOf(T elemento);
    
    public abstract boolean isEmpty();
    
    
    public abstract T remover(int posicao);
    public abstract T removerNoInicio();
    public abstract T removerNoFim();
    
    public abstract int size();
    public abstract void resize(int length);
    
}