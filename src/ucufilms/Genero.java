/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucufilms;

/**
 *
 * @author nplaceres
 */
public class Genero implements IGenero{
    private String nombre;
     private IGenero siguiente = null;
    public Genero(String nom){
        this.nombre=nom;
        
    }
     public String getNombre() {
        return this.nombre;
    }

    @Override
    public Object getDato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDato(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSiguiente(INodo nodo) {
         this.siguiente = (IGenero) nodo;
    }

    @Override
    public INodo getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public void imprimirEtiqueta() {
       System.out.println(this.getEtiqueta());
    }

    @Override
    public boolean equals(INodo unNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable getEtiqueta() {
       return this.getEtiqueta().compareTo(nombre);
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
