package codeoJava;

public class TestComplejo {
    
    public int suma(int a, int b){
        return a + b;
    }
    
    public float suma(float  a, float b){
        return a + b;
    }

    public Complejo suma(Complejo a, Complejo b){
        return new Complejo(a.getParteReal() + b.getParteReal(), a.getParteImaginaria() + b.getParteImaginaria());
    }

    public static void main(String[] args) {
        Complejo a = new Complejo(3f, 4f);
        Complejo b = new Complejo(2f, -5f);
        /*
         * Cuando intentas llamar a suma(a, b), 
         * necesitas hacerlo a través de una instancia de TestComplejo
         *  porque suma no es un método estático.
         */
        TestComplejo test = new TestComplejo();
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(test.suma(a,b));

        Complejo c = a.multiplicar(b);
        System.out.println(c);

        
    }
}
