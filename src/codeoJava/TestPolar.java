package codeoJava;

public class TestPolar {
    
    public Polar sumarPuntosPolares(Polar p){
        
        return new Polar(0, 0);
    }


    
    public static void main(String[] args) {
       float radio1 = 2;
       float angulo1 =  0.5f;
       Polar pp = new Polar(radio1,angulo1);
       System.out.println(pp.PolaresACartesianas()); 
    }
}
