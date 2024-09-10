package codeoJava;

/*
Guía 3
Ejercicio 11
 */

public class Archivo {
    String nombre;
    int longreg;
    
    void init (int r) {
        longreg = r;
    }
    
    public static void main(String[] args) throws Exception {
        Archivo f = new Archivo();
        // cambio el valor del atributo longreg
        f.init(80);
        
    }
}
