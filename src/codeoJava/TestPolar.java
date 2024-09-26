package codeoJava;

import codeoJava.ejer17.Punto;

public class TestPolar {
    
    public static Polar CartesianasAPolares(Punto p){
        float r = (float) Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
        float theta = obtenerAngulo(p);
        return new Polar(r, theta);
    } 
    
    
     private static float obtenerAngulo(Punto p){
        float valorX = p.getX();
        float valorY = p.getY();
        float anguloConEjeX = (float) Math.atan2(valorX, valorY);
        
        if ( valorX < 0){
            anguloConEjeX += 1f;
        }
        else if(valorX == 0){
            if(valorY > 0){
                anguloConEjeX = 0.5f;
            }else{
                anguloConEjeX = -0.5f;
            }
        }
        return anguloConEjeX;
     }

     public static Polar sumarPolares(Polar p1, Polar p2){
        Punto a = p1.PolaresACartesianas();
        Punto b = p2.PolaresACartesianas();
        Punto c = a.sumarPuntos(b);
        return CartesianasAPolares(c);
    }



    
    public static void main(String[] args) {
       float radio1 = 2;
       float angulo1 =  0.5f;
       Polar pp = new Polar(radio1,angulo1);
       System.out.println(pp.PolaresACartesianas());
       
    }
}
