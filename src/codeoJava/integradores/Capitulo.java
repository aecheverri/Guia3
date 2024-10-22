package codeoJava.integradores;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Capitulo {
    private String nombre;
    private List<Pagina> paginas;
    
    public Capitulo(String nombre, Pagina pagInicial) {
        this.nombre = nombre;
        this.paginas = new ArrayList<>();
        paginas.add(pagInicial);
        
    }

    public List<Pagina> paginasCapitulo(){
        return paginas;
    }

    public int cantidadPaginasCapitulo(){
        return paginas.size();
    }

    public int cantidadPalabrasCapitulo(){
        int cantPalabras = 0;
        for(Pagina p: paginas){
            cantPalabras += p.contarPalabras();
        }
        return cantPalabras;
    }

    public int cantidadCaracteresCapitulo(){
        int cantCaracteres = 0;
        for(Pagina p: paginas){
            cantCaracteres += p.contarCaracteres();
        }
        return cantCaracteres;
    }

    public String nombre() {
        return nombre;
    }

    public Pagina paginaInicial() {
        return paginas.get(0);
    }

    public Pagina paginaFinal() {
        int cantidadPaginas = paginas.size();
        return paginas.get(cantidadPaginas - 1);
    }


    public void agregarPagina(Pagina p){
        if(p.verNumeroPagina() < paginaInicial().verNumeroPagina() || p.verNumeroPagina() > paginaFinal().verNumeroPagina() + 1){
            throw new BusinessException("No se puede agregar esa página");
        }
        int posicionNuevaPagina = paginas.indexOf(p);
        if (posicionNuevaPagina >= 0){
            paginas.add(posicionNuevaPagina, p);
            incrementarNumerosPaginasSiguientes(posicionNuevaPagina);
        }
        else
            paginas.add(p);

    }

    public void borrarPagina(Pagina p){
        if(p.verNumeroPagina() < paginaInicial().verNumeroPagina() || p.verNumeroPagina() > paginaFinal().verNumeroPagina()){
            throw new BusinessException("No se puede borrar esa página");
        }
        int posicionPagina = paginas.indexOf(p);
        paginas.remove(posicionPagina);
        decrementarNumerosPaginasSiguientes( posicionPagina);

    }
    
    private void decrementarNumerosPaginasSiguientes(int posicionPagina) {
        for(int i = posicionPagina; i < paginas.size(); i++){
            int nroPagina = paginas.get(i).verNumeroPagina();
            paginas.get(i).cambiarNumeroPagina(nroPagina - 1);
        }
    }

    private void incrementarNumerosPaginasSiguientes(int posicionPagina) {
        for(int i = posicionPagina + 1; i < paginas.size(); i++){
            int nroPagina = paginas.get(i).verNumeroPagina();
            paginas.get(i).cambiarNumeroPagina(nroPagina + 1);
        }
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
             Objects.equals(this.paginas, otro2.paginas);    

    }

     @Override
    public int hashCode() {
        return Objects.hash(nombre,paginas);
    }



    @Override
    public String toString() {
        String salida = "Capítulo: " + nombre+ "\n";
        for(Pagina p: paginas){
            salida += p.toString();
        }
        return salida;
    }

    

    
}
