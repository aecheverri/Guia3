package codeoJava;

public class Complejo {
    private Float parteReal;
    private Float parteImaginaria;
    
    
    
    
    public Complejo(Float parteReal, Float parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public Complejo(){
        parteReal = 0f;
        parteImaginaria = 0f;
    }

    

    public Complejo multiplicar(Complejo b){
        float parteRealMultiplicacion = parteReal * b.parteReal - parteImaginaria * b.parteImaginaria;
        float parteImaginariaMultiplicacion = parteReal * b.parteImaginaria  + parteImaginaria * b.parteReal;
        
        return new Complejo(parteRealMultiplicacion, parteImaginariaMultiplicacion);
    }

    public Float getParteReal() {
        return parteReal;
    }

    public void setParteReal(Float parteReal) {
        this.parteReal = parteReal;
    }

    public Float getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(Float parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    @Override
    public String toString() {
        return "Complejo [parteReal= " + parteReal + ", parteImaginaria= " + parteImaginaria + "]";
    }

    

    
}
