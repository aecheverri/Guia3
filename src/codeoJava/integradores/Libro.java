package codeoJava.integradores;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private List<Capitulo> capitulos;

    public Libro() {
        capitulos = new ArrayList<>();
    }

    public List<String> nombresDeLosCapitulos(){
        List <String> nombresCapitulos = new ArrayList<>();
        for (Capitulo cap: capitulos){
            nombresCapitulos.add(cap.nombre());
        } 
        return nombresCapitulos;
    }

    private int buscarPosCap(String nombreCap){
        int i = 0;
        boolean capHallado = false;
        while( i < capitulos.size() && !capHallado){
            capHallado = nombreCap.equals(capitulos.get(i).nombre());
            if (!capHallado)
                i++;
        }
        if (i == capitulos.size())
            i = -1;
        return i;
    }

    public int cantidadPaginasTotalesCapitulo(String nombreCap){
        int ubicacion = buscarPosCap(nombreCap);
        if (ubicacion == -1){
            throw new BusinessException("El capítulo buscado no existe");
        }
        return capitulos.get(ubicacion).cantidadPaginasCapitulo();
    }


    public int cantidadPaginasTotales(){
        int cantPaginasLibro = 0;
        for (Capitulo cap: capitulos){
            cantPaginasLibro+= cap.cantidadPaginasCapitulo();
        } 
        return cantPaginasLibro;
    }

    public Pagina verPaginaInicial(String nombreCap){
        int ubicacion = buscarPosCap(nombreCap);
        if (ubicacion == -1){
            throw new BusinessException("El capítulo buscado no existe");
        }
        return capitulos.get(ubicacion).paginaInicial();
    }

    public Pagina verPaginaFinal(String nombreCap){
        int ubicacion = buscarPosCap(nombreCap);
        if (ubicacion == -1){
            throw new BusinessException("El capítulo buscado no existe");
        }
        return capitulos.get(ubicacion).paginaFinal(); 
    }

    

    public int cantidadPalabrasCapitulo(String nombreCap){
        int ubicacion = buscarPosCap(nombreCap);
        if (ubicacion == -1){
            throw new BusinessException("El capítulo buscado no existe");
        }

        return capitulos.get(ubicacion).cantidadPalabrasCapitulo();
    }

    public int cantidadPalabras(){
        int cantidadPalabras = 0;
        for (Capitulo c: capitulos){
            cantidadPalabras += c.cantidadPalabrasCapitulo();
        }
        return cantidadPalabras;
    }

    public int cantidadCaracteresCapitulo(String nombreCap){
        int ubicacion = buscarPosCap(nombreCap);
        if (ubicacion == -1){
            throw new BusinessException("El capítulo buscado no existe");
        }
        return capitulos.get(ubicacion).cantidadCaracteresCapitulo();
    }

    public int cantidadCaracteres(){
        int cantidadCaracteres = 0;
        for (Capitulo c: capitulos){
            cantidadCaracteres += c.cantidadCaracteresCapitulo();
        }
        return cantidadCaracteres;
    }

    

    public void definirCapitulo(String nombreCap, Pagina p){
        if (buscarPosCap(nombreCap) == - 1){
            if (capitulos.size() == 0)
            p.cambiarNumeroPagina(1);
            else{
                int ultimaPaginaUltimoCap = capitulos.getLast().paginaInicial().verNumeroPagina();
                p.cambiarNumeroPagina(ultimaPaginaUltimoCap+1);
            }

            Capitulo nuevoCap = new Capitulo(nombreCap, p);
            capitulos.add(nuevoCap);
        }else{
            throw new BusinessException("El capítulo fue ingresado");
        }
       
    }

    public void leerPagina(int nroPagina ){
        if (nroPagina <= 0 || nroPagina > cantidadPaginasTotales())
            throw new BusinessException("Esa página no existe");
        boolean estaEnCap = false;
        int nroCap = 0;
        while (nroCap < capitulos.size() && !estaEnCap){
            estaEnCap = nroPagina >= capitulos.get(nroCap).paginaInicial().verNumeroPagina() 
                         && nroPagina <= capitulos.get(nroCap).paginaFinal().verNumeroPagina();
            if (!estaEnCap)
                nroCap++;
        }

        int j = 0;
        boolean pagHallada = false;
        List<Pagina> pagsDelCapitulo = capitulos.get(nroCap).paginasCapitulo(); 
        while( j < pagsDelCapitulo.size() && !pagHallada){
            pagHallada = nroCap == pagsDelCapitulo.get(j).verNumeroPagina();
            if (!pagHallada)
                j++;
        }
        System.out.println(pagsDelCapitulo.get(j).verContenido());

        
    }

    private List<Capitulo> capitulosSiguientes(Capitulo c){
        int indiceCap = capitulos.indexOf(c);
        List<Capitulo> capsProximos = new ArrayList<>();
        for(int i = indiceCap + 1; i < capitulos.size();i++){
            capsProximos.add(capitulos.get(indiceCap));
        }
        return capsProximos;
    }

    private void sumarUnoATodasLasPaginas(List<Capitulo> caps){
        for(Capitulo c: caps){
            for(Pagina p: c.paginasCapitulo()){
                int nroPag = p.verNumeroPagina();
                p.cambiarNumeroPagina(nroPag + 1 );
            }
        }
    }

    public void agregarPaginaACapitulo(String nombreCap , Pagina nuevaPagina){
        int posCap = buscarPosCap(nombreCap);
        if (posCap != -1){
            Capitulo c = capitulos.get(posCap);
            c.agregarPagina(nuevaPagina);
            sumarUnoATodasLasPaginas(capitulosSiguientes(c));
        }
    }

  

    public void borrarPaginaACapitulo(String nombreCap, int nroPag){
        int posCap = buscarPosCap(nombreCap);
        if (posCap != -1){
            Capitulo capituloBuscado = capitulos.get(posCap);
            List<Pagina> pagsDelCapitulo = capituloBuscado.paginasCapitulo(); 
            int posPag = buscarIndice(pagsDelCapitulo,nroPag);
            if (posPag  != -1){
                Pagina paginaABorrar = pagsDelCapitulo.get(posPag);
                capituloBuscado.borrarPagina(paginaABorrar);
                if (pagsDelCapitulo.isEmpty()){
                    capitulos.remove(posCap);
                }
                decrementarPaginasOtrosCapitulos(nombreCap);
            } 
        }  
    }

    private void decrementarPaginasOtrosCapitulos(String nombreCap){
        int posCap = buscarPosCap(nombreCap);
        if (posCap != -1){
            for(int i = 0; i< capitulos.size(); i++){
                if (i != posCap){
                    for (Pagina p: capitulos.get(i).paginasCapitulo()){
                        int valorViejo = p.verNumeroPagina();
                        p.cambiarNumeroPagina(valorViejo-1);
                    }
                }
            }
        }
    }

    private int buscarIndice(List<Pagina> pags, int nroPag) {
        int j = 0;
        boolean pagHallada = false;
        while( j < pags.size() && !pagHallada){
            pagHallada = nroPag == pags.get(j).verNumeroPagina();
            if (!pagHallada)
                j++;
        }
        if (j == pags.size())
            j= -1;
       
        return j;
    }


    




    

}


