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
public class Imagen implements IImagen{
    private Comparable etiqueta;
    private String dato;
    private IImagen siguiente = null;
    
    public Imagen(Comparable id, String dato){
        this.etiqueta=id;
        this.dato=dato;
    }
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public INodo getSiguiente() {
        return this.siguiente;
    }
    
    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = (IImagen) nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return null;
    }
    
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.getEtiqueta());
    }

    @Override
    public boolean equals(INodo unNodo) {
        return this.getEtiqueta().equals((IImagen)unNodo.getEtiqueta());
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
