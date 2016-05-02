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
public class UcuFilms {

    private Lista<Actor> actores;
    private Lista<Pelicula> peliculas;
    private Lista<Director> directores;
    private Lista<Productor> productores;
    public Lista<Imagen> imagenes;
    
    public Lista<Actor> getActores() {
        return this.actores;
    }
    
    public Lista<Director> getDirectores() {
        return this.directores;
    }
    public Lista<Imagen> getImagenes(){
        return this.imagenes;
    }
    
    public Lista<Productor> getProductores() {
        return this.productores;
    }
            
    public Lista<Pelicula> getPeliculas() {
        return this.peliculas;
    }
    
    public void cargarDatos() {
        this.peliculas = obtenerPeliculas();
        this.actores = obtenerActores();
        this.directores = obtenerDirectores();
        this.productores = obtenerProductores();
        this.imagenes = mostrarImagenes();
        this.cargarListas();
    }
    
    public Lista<Actor> obtenerActores() {
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-Actores.txt", true);   
        Lista<Actor> ac = new Lista<>();
        for (String actor: archivo) {
            String[] elemento = actor.split("\\|");
            Comparable clave = elemento[0];
            String nombre = elemento[1];
            ac.insertar(new Actor(clave, nombre));
        }
        return ac;
    }
    
    public Lista<Director> obtenerDirectores(){
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-Directores.txt", true);   
        Lista<Director> dir = new Lista<>();
        for (String director: archivo) {
            String[] elemento = director.split("\\|");
            Comparable clave = elemento[0];
            String nombre = elemento[1];
            dir.insertar(new Director(clave, nombre));
        }
        return dir;
    }
    
    public Lista<Productor> obtenerProductores(){
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-Productores.txt", true);   
        Lista<Productor> pro = new Lista<>();
        for (String productor: archivo) {
            String[] elemento = productor.split("\\|");
            Comparable clave = elemento[0];
            String nombre = elemento[1];
            pro.insertar(new Productor(clave, nombre));
        }
        return pro;
    }
    
    
    
    public void imprimirActores() {
        Actor actor = (Actor) this.getActores().getPrimero();
        while (actor != null) {
            System.out.println(actor);
            actor = (Actor) actor.getSiguiente();
        }
    }
    
    public void imprimirDirectores() {
        Director director = (Director) this.getDirectores().getPrimero();
        while (director != null) {
            System.out.println(director);
            director = (Director) director.getSiguiente();
        }
    }
    
    public void imprimirProductores() {
        Productor productor = (Productor) this.getProductores().getPrimero();
        while (productor != null) {
            System.out.println(productor);
            productor = (Productor) productor.getSiguiente();
        }
    }
    
    public Lista<Pelicula> obtenerPeliculas() {
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-Peliculas.txt", true);   
        Lista<Pelicula> pe = new Lista<>();
        for (String pelicula: archivo) {
            String[] elemento = pelicula.split("\\|");
            Comparable clave = elemento[0];
            String nombre = elemento[1];
            Comparable año = elemento[2];
            float puntaje = Float.parseFloat(elemento[3]);
            String reseña = elemento[4];
            String[] generos = elemento[5].split("-");
            pe.insertar(new Pelicula(clave, nombre, año, puntaje, reseña, generos, new Lista<>(), new Lista<>(), new Lista<>()));
        }
        return pe;
    }
    
    public void cargarListas() {
        String[] peliculasActores = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-PeliculasActores.txt", true);
        String[] peliculasDirectores = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-PeliculasDirectores.txt", true);
        String[] peliculasProductores = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-PeliculasProductores.txt", true);
        for (String pa: peliculasActores) {
            String[] elemento = pa.split("\\|");
            Pelicula pe = (Pelicula) this.getPeliculas().buscar(elemento[0]);
            Actor ac = (Actor) this.getActores().buscar(elemento[1]);
          
            if (pe != null && ac != null/* && pe.getActores().buscar(ac.getEtiqueta()) == null*/) {
                
                pe.getActores().insertar(new Actor(ac.getEtiqueta(), ac.getNombre()));
            }
        }
        for (String pd: peliculasDirectores) {
            String[] elemento = pd.split("\\|");
            Pelicula pe = (Pelicula) this.getPeliculas().buscar(elemento[0]);
            Director di = (Director) this.getDirectores().buscar(elemento[1]);
            if (pe != null && di != null && pe.getDirectores().buscar(di.getEtiqueta()) == null) {
                pe.getDirectores().insertar(new Director(di.getEtiqueta(), di.getNombre()));
                  System.out.println(pe + "       " + di.getNombre() + " " + di.getEtiqueta() ) ;
            }
        }
        for (String pp: peliculasProductores) {
            String[] elemento = pp.split("\\|");
            Pelicula pe = (Pelicula) this.getPeliculas().buscar(elemento[0]);
            Productor pr = (Productor) this.getProductores().buscar(elemento[1]);
            if (pe != null && pr != null && pe.getProductores().buscar(pr.getEtiqueta()) == null) {
                pe.getProductores().insertar(new Productor(pr.getNombre(), pr.getNombre()));
                
            }
        }
    }
    
    public void imprimirPeliculas() {
        Pelicula pelicula = (Pelicula) this.getPeliculas().getPrimero();
        while (pelicula != null) {
            System.out.println(pelicula);
            pelicula = (Pelicula) pelicula.getSiguiente();
        }
    }
    
    public static Lista<Imagen> mostrarImagenes() {
        String[] archivo = ManejadorArchivosGenerico.leerArchivo("src\\ucufilms\\Small-Imagenes.txt", true);   
        Lista<Imagen> pe = new Lista<>();
        for(String imagen: archivo){
            String[] elemento = imagen.split("\\|");
            Comparable clave = elemento[0];
            String datoHex = elemento[1];
            //byte[] datoIm = ImageUtils.hexStringToBytes(datoHex);
            pe.insertar(new Imagen(clave, datoHex));
           // ImageUtils.bytesToHex(datoIm);
           // ImageUtils.bytesToImage(datoHex, clave, "jpg");
            
        }
        return pe;
    }
}
