package codeoJava.integradores;

import java.util.List;
import java.util.ArrayList;



public class Pagina {
    private String contenido;
    private List<String> referencias;

    public Pagina(String contenido, List<String> referencias) {
        this.contenido = contenido;
        
        if (referencias == null){
            this.referencias = new ArrayList<>();    
        }else{
            this.referencias = new ArrayList<>(referencias);
        }
        
    }

    public Pagina(Pagina p){
        this.contenido = new String(p.contenido);
        this.referencias = new ArrayList<>(p.referencias);
    }




    public int contarCaracteres(){
        return contenido == null ? 0 : contenido.length();
    }

    public int contarPalabras(){
        return contenido == null ? 0 : contenido.split(" ").length;
    }

    public List<String> verRefencias(){
        return new ArrayList<>(referencias);
    }


    public String verContenido(){
        return new String(contenido);
    }

    public void agregarReferencia(String ref){
        this.referencias.add(ref);
    }

    @Override
    public String toString() {
        String salida = "********************************************\n";
        salida += ("Contenido: " + contenido + "\n");
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
