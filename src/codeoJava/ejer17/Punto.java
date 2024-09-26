package codeoJava.ejer17;

import java.util.Objects;

public class Punto {
    private float x;
    private float y;
    

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Punto sumarPuntos(Punto q){
        return new Punto(x + q.x, y + q.y);
    }

    @Override
    public boolean equals(Object otro) {
        
        if (this == otro) {
            return true;
        }
    
        if (otro == null || this.getClass() != otro.getClass()) {
            return false;
        }
    
        Punto otro2 = (Punto) otro;   // Downcasting a Punto

        return Objects.equals(this.getX(), otro2.getX()) && Objects.equals(this.getY(), otro2.getY());
    }

    @Override
    public int hashCode() {
        
        return Objects.hash(x,y);
    }

    @Override
    public String toString() {
        return "Punto [x=" + x + ", y=" + y + "]";
    }

    

}
