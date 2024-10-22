package codeoJava.integradores;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;



public class Pagina {
    private int numero;
    private String contenido;
    private List<String> referencias;

    public Pagina(int numeroPagina, String contenido) {
        if (numeroPagina < 1)
            throw new BusinessException("Las páginas se enumeran desde 1");
        this.numero = numeroPagina;
        this.contenido = contenido;
        this.referencias = new ArrayList<>();

    }

    public Pagina(Pagina p){
        this.numero = p.numero;
        this.contenido =p.contenido;
        this.referencias = new ArrayList<>(p.referencias);
    }


    

    public int contarCaracteres(){
        return contenido == null ? 0 : contenido.length();
    }

    public int contarPalabras(){
        return contenido == null ? 0 : contenido.split(" ").length;
    }


    public int verNumeroPagina() {
        return numero;
    }

    public List<String> verRefencias(){
        return new ArrayList<>(referencias);
    }


    public String verContenido(){
        return contenido;
    }

    public void agregarReferencia(String ref){
        this.referencias.add(ref);
    }

    public void cambiarNumeroPagina(int n){
        this.numero = n;
    }
    

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pagina other = (Pagina) obj;
        return this.numero == other.numero;
    }

    @Override
    public String toString() {
        String salida = "********************************************\n";
        salida += "Número de página: " + numero + "\n";
        salida += "Contenido: " + contenido + "\n";
        salida += "********************************************\n";
        salida += "Referencias: \n";
        if (referencias.isEmpty()){
            salida += "No tiene referencias\n";
        }else{
            for(String ref: referencias){
                salida += ref +"\n";
            }
        }
        salida += "********************************************\n";
        
        
       return salida;
    }


    

}
