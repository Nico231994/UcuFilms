/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucufilms;

/**
 *
 * @author Nico
 */
class Productor implements IProductor {
    
    private Comparable id;
    private String nombre;
    private IProductor siguiente = null;
    
    public Productor(Comparable i, String n) {
        this.id = i;
        this.nombre = n;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public INodo getSiguiente() {
        return this.siguiente;
    }
    
    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = (IProductor) nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return ("Id: " + this.getEtiqueta() + " Nombre: " + this.getNombre());
    }
    
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.getEtiqueta());
    }

    @Override
    public boolean equals(INodo unNodo) {
        return this.getEtiqueta().equals((IActor)unNodo.getEtiqueta());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.getEtiqueta().compareTo(etiqueta);
    }

    @Override
    public Object getDato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDato(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
