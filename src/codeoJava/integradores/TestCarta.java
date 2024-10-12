package codeoJava.integradores;

public class TestCarta {
    public static void main(String[] args) {
        Carta c1 = new Carta("Pica", 12);
        Carta c2 = new Carta("Corazón", 11);
        Carta c3 = new Carta("Corazón", 13);

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.getPalo());

        System.out.println(c3.toString());

        System.out.println(c3.getNumero());
            
    }
}
