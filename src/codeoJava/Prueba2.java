package codeoJava;

/*
 Guía 3

 Ejercicio 13
 */

public class Prueba2 {
    private int num;
    public Prueba2() {num = 0;}
    public Prueba2(int n) {num = n;}
    public int valor() {return num;}


public static void main(String[] args) throws Exception {
    // Llamando al constructor por defecto
    Prueba2 prueba = new Prueba2();
    System.out.println(prueba.valor());
    
}

}


   