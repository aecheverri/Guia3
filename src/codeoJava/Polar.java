package codeoJava;
import codeoJava.ejer17.Punto;

public class Polar {
    private float radio;
    // angulo está entre [0,2Pi)
    private float angulo;
    
    public Polar(float radio, float angulo) {
        if (radio < 0) 
            throw new RuntimeException("El radio debe ser mayor o igual que 0");    
        if ( angulo < 0 || angulo > 2)
            throw new RuntimeException("El ángulo debe estar en [0,2Pi)");
        this.radio = radio;
        this.angulo = angulo;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        if(radio < 0)
            throw new RuntimeException("El radio debe ser mayor o igual que 0");
        this.radio = radio;
    }

    public float getAngulo() {
        return angulo;
    }

    public void setAngulo(float angulo) {
        if ( angulo < 0 || angulo > 2)
            throw new RuntimeException("El ángulo debe estar en [0,2Pi)");
        this.angulo = angulo;
    }

    public Punto PolaresACartesianas(){
            float x = radio * ( Math.round(Math.cos(angulo * Math.PI)*100) / 100f);
            float y = radio * ( Math.round(Math.sin(angulo * Math.PI)*100) / 100f);
        return new Punto(x,y);
    }

    public Polar sumarPolares(Polar pp){
        Punto a = PolaresACartesianas();
        Punto b = pp.PolaresACartesianas();
        Punto c = a.sumarPuntos(b);
        return CartesianasAPolares(c);
    }

    private Polar CartesianasAPolares(Punto p){
        float r = (float) Math.sqrt(Math.pow(p.getX(), 2) + Math.pow(p.getY(), 2));
        float theta = obtenerAngulo(p);
        return new Polar(r, theta);
    } 
    
    
     private float obtenerAngulo(Punto p){
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
    
}
