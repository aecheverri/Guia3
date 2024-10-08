package codeoJava.integradores;

public class Hueco {
    private float ancho;
    private float largo;
    private float profundidad;
    
    
    
    public Hueco(float ancho, float largo, float profundidad) {
        this.ancho = ancho;
        this.largo = largo;
        this.profundidad = profundidad;
    }



    public boolean loTapa(Bloque b){
        boolean coincidenMedidas = getAncho()== b.getAncho()  &&  getLargo() == b.getLargo() && getProfundidad() == b.getProfundidad() ;
        return  coincidenMedidas;
    }
    
    public float getAncho() {
        return ancho;
    }
    
    public float getLargo() {
        return largo;
    }
    
    public float getProfundidad() {
        return profundidad;
    }



    @Override
    public String toString() {
        return "Hueco [ancho=" + ancho + ", largo=" + largo + ", profundidad=" + profundidad + "]";
    }

    
    
}