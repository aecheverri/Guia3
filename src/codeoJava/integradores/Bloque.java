package codeoJava.integradores;

public class Bloque {
    private float ancho;
    private float largo;
    private float profundidad;
    
    
    

    public Bloque(float ancho, float largo, float profundidad) {
        this.largo = largo;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }

    public float getProfundidad() {
        return profundidad;
    }

    public float getLargo() {
        return largo;
    }

    public float getAncho() {
        return ancho;
    }

    @Override
    public String toString() {
        return "Bloque [largo=" + largo + ", ancho=" + ancho + ", profundidad=" + profundidad + "]";
    }

    


}
