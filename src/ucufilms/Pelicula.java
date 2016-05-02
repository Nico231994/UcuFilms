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
public class Pelicula implements IPelicula {
    
    private Comparable id;
    private String nombre;
    private Comparable año;
    private float puntaje;
    private String reseña;
    
    private IPelicula siguiente = null;
    private String[] generos;
    private Lista<Actor> actores;
    private Lista<Director> directores;
    private Lista<Productor> productores;
    
    public Pelicula(Comparable id, String nombre, Comparable año, float puntaje,
            String reseña, String[] generos, Lista<Actor> ac, Lista<Director> dir, Lista<Productor> pro) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
        this.puntaje = puntaje;
        this.reseña = reseña;
        this.generos = generos;
        this.actores = ac;
        this.directores = dir;
        this.productores = pro;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return this.id;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public Comparable getAño() {
        return this.año;
    }
    
    public float getPuntaje() {
        return this.puntaje;
    }
    
    public String getReseña() {
        return this.reseña;
    }
    
    public String[] getGeneros() {
        return this.generos;
    }
    
    public Lista<Actor> getActores() {
        return this.actores;
    }
    
    public Lista<Director> getDirectores() {
        return this.directores;
    }
    
    public Lista<Productor> getProductores() {
        return this.productores;
    }
    
    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = (IPelicula) nodo;
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
    public String toString() {
        return ("Nombre: " + this.getNombre() + "\n"+
                "Puntaje: "+ this.getPuntaje()+"\n"+
                "Año: " + this.getAño()+ "\n"+
                "Reseña: "+this.getReseña()+"\n"+
                "Actores: " + this.getActores()+"\n"+
                "Directories: " + this.getDirectores()+"\n"+
                "Productores: " + this.getProductores()+"\n"
                
                );
    }
    
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.getEtiqueta());
    }

    @Override
    public boolean equals(INodo unNodo) {
        return this.getEtiqueta().equals((IPelicula)unNodo.getEtiqueta());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.getEtiqueta().compareTo(etiqueta);
    }
    
    @Override
    public Object getDato() {
        return this.getDato();
        
    }

    @Override
    public void setDato(Object dato) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
