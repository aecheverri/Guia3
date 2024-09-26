package codeoJava.ejer17;

public class TestPunto {
    public static void main(String[] args) {
        Punto p = new Punto(0f,0f);
        Punto q = new Punto(-1.40f,2.40f);
        Punto t = new Punto(-1.40f,2.40f);
        
        System.out.println(p.sumarPuntos(q).toString());
        System.out.println(q.equals(t));
        

    }
}
