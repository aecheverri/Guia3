package codeoJava;


/* 
Guía 3 
Ejercicio 12 
*/

public class Prueba{
    public static void main(String[] args) {
        Punto p = new Punto(25);
        System.out.println("x = " + p.x + " y = " + p.y);
    }    
}

/*
 Se crea un punto en donde la primer y la segunda coordenada son = .
 El problema es que se rompe el encapsulamiento, al poner los atributos x e y
 de la clase Punto.
 */