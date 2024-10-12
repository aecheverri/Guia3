package codeoJava.integradores;

import java.util.List;
import java.util.Objects;

public class Capitulo {
    private String nombre;
    private List<Pagina> paginas;
    
    public Capitulo(String nombre, int Inicial, int Final) {
        this.nombre = nombre;
        if (Inicial <= 0 || Final <= 0){
            throw new IllegalArgumentException("La página inicial y la final deben ser números naturales");
        }
        if (Final <= Inicial){
            throw new IllegalArgumentException("La página inicial debe ser menor que la final");
        }
        this.paginaInicial = Inicial;
        this.paginaFinal = Final;
    }

    public int cantidadPaginasCapitulo(){
        return paginaFinal - paginaInicial + 1;
    }

    public String Nombre() {
        return new String(nombre);
    }

    public int PaginaInicial() {
        return paginaInicial;
    }

    public int PaginaFinal() {
        return paginaFinal;
    }

    public void definirPaginaInicial(int paginaInicial){
        this.paginaInicial = paginaInicial;
    }

    public void definirPaginaFinal(int paginaFinal){
        this.paginaFinal = paginaFinal;
    }

    

    @Override
    public boolean equals(Object otro) {
      if (this == otro){
        return true;
      }
      if (otro == null || this.getClass() != otro.getClass()) {
        return false;
      }

      Capitulo otro2 = (Capitulo) otro;

      return Objects.equals(this.nombre, otro2.nombre) &&
             this.paginaInicial == otro2.paginaInicial &&
             this.paginaFinal == otro2.paginaFinal; 
    

    }

     @Override
    public int hashCode() {
        return Objects.hash(nombre,paginaInicial, paginaFinal);
    }



    @Override
    public String toString() {
        return "Capitulo: " + nombre + "\n" + "paginaInicial= " + paginaInicial + ", paginaFinal= " + paginaFinal;
    }

    

    
}
