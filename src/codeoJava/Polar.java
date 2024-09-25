package codeoJava;
import codeoJava.ejer17.Punto;

public class Polar {
    private Float radio;
    private Float angulo;
    
    public Polar(float radio, float angulo) {
        this.radio = radio;
        this.angulo = angulo;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public float getAngulo() {
        return angulo;
    }

    public void setAngulo(float angulo) {
        this.angulo = angulo;
    }

    public Punto PolaresACartesianas(){
        return new Punto( Float.valueOf((float)(radio * Math.cos(angulo))), Float.valueOf((float)(radio * Math.sin(angulo))));
    }
    
}
