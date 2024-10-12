package codeoJava.integradores;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private List<Capitulo> capitulos;
    private List<Pagina> paginas;
    
    public Libro(List<Capitulo> caps) {
        capitulos = new ArrayList<>(caps);
        paginas = new ArrayList<>();
    }

    public List<String> nombresDeLosCapitulos(){
        List <String> nombresCapitulos = new ArrayList<>();
        for (Capitulo cap: capitulos){
            nombresCapitulos.add(cap.Nombre());
        } 
        return nombresCapitulos;
    }

    public int cantidadPaginasTotalesCapitulo(Capitulo capitulo){
        return capitulo.cantidadPaginasCapitulo();
    }


    public int cantidadPaginasTotales(){
        int cantPaginasLibro = 0;
        for (Capitulo cap: capitulos){
            cantPaginasLibro+= cap.cantidadPaginasCapitulo();
        } 
        return cantPaginasLibro;
    }

    public Pagina verPaginaInicial(Capitulo capitulo){
        int nroPaginaInicialCapitulo = capitulo.PaginaInicial(); 
        return new Pagina(paginas.get(nroPaginaInicialCapitulo - 1));
    }

    public Pagina verPaginaFinal(Capitulo capitulo){
        int nroPaginaFinalCapitulo = capitulo.PaginaFinal(); 
        return new Pagina(paginas.get(nroPaginaFinalCapitulo-1));
    }


    public int cantidadPalabrasCapitulo(Capitulo capitulo){
        int cantidadPalabras = 0;
        int inicio = capitulo.PaginaInicial();
        int fin  = capitulo.PaginaFinal();

        for(int i = inicio ; i <= fin ; i++){
            cantidadPalabras += paginas.get(i-1).contarPalabras();
        }
        return cantidadPalabras;
    }

    public int cantidadPalabras(){

        int cantidadPalabras = 0;
        for(int i = 0; i < paginas.size(); i++){
            cantidadPalabras += paginas.get(i-1).contarPalabras();
        }
        return cantidadPalabras;
    }

    private List<Integer> numerosDePaginaEnCapitulo(Capitulo cap){
        List<Integer> pags = new ArrayList<>();
        Integer pagInicio = cap.PaginaInicial();
        Integer pagFin = cap.PaginaFinal();
        for(int paginaActual = pagInicio; paginaActual <= pagFin; paginaActual++){
            pags.add(paginaActual);
        }
        return pags;
    }

    private boolean esUltimoCapitulo(Capitulo cap){
        return cap.equals(capitulos.get(capitulos.size() - 1));
    }

    public void agregarPaginaEnCapitulo(Pagina pag, Capitulo cap){
        if (esUltimoCapitulo(cap)){
            cap.definirPaginaFinal(cap.PaginaFinal() + 1);
            
        }
    }

    public void definirCapitulo(Capitulo nuevoCapitulo){
        capitulos.add(nuevoCapitulo);
    }

    

    




    

}


