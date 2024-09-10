package codeoJava;

/* 
Guía 3 
Ejercicio 10 
*/

public class Lamparita {
    boolean apagada;

    
    public Lamparita(){
        apagada = true;
    }


    public void prender(){
        if (lamparita_prendida())
            throw new RuntimeException("La lamparita está prendida");
        apagada = false;
        System.out.println("Lamparita prendida");
    }

    public void apagar(){
        if (!lamparita_prendida())
            throw new RuntimeException("La lamparita está apagada");
        apagada = true;
        System.out.println("Lamparita apagada");
    }

    public boolean lamparita_prendida(){
        return !apagada;
    }

    
    public static void main(String[] args) throws Exception {
        Lamparita l1 = new Lamparita();
        System.out.println("Está apagada? " + l1.lamparita_prendida());
        l1.prender();
        System.out.println("Está prendida? " + l1.lamparita_prendida());
        l1.apagar(); 
        System.out.println("Está apagada? " + l1.lamparita_prendida());
    }
}
