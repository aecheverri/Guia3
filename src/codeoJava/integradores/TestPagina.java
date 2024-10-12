package codeoJava.integradores;

import java.util.ArrayList;
import java.util.List;

public class TestPagina {
    public static void main(String[] args) {
        List<String> refs = new ArrayList<>();
        refs.add("Muy emocionante");
        refs.add("El autor se contradice");
        System.out.println(refs);
        Pagina nuevaPagina = new Pagina("Mi vieja mula", refs);
        System.out.println("Texto: " + nuevaPagina.verContenido());
        System.out.println("Referencias: " + nuevaPagina.verRefencias());
        System.out.println("Cantidad de palabras: " + nuevaPagina.contarPalabras());
        System.out.println("Cantidad de carácteres: " + nuevaPagina.contarCaracteres());

        String txt = nuevaPagina.verContenido();
        txt = "hola";
        System.out.println("Texto: " + nuevaPagina.verContenido());
        System.out.println(nuevaPagina.toString());

        nuevaPagina.agregarReferencia("Descollante");
        System.out.println(nuevaPagina.toString());


        

    }
}
