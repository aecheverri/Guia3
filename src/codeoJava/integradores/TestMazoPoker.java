package codeoJava.integradores;

import java.util.Collections;
import java.util.List;

public class TestMazoPoker {
    public static void main(String[] args) {
        MazoPoker texas = new MazoPoker();
        System.out.println(texas.cantidadCartasEnMazo());
        System.out.println(texas.toString());

        List<Carta> misCartas = texas.sacarCartasDeArriba(2);
        System.out.println(misCartas.size());
        System.out.println(misCartas.toString());
        System.out.println(texas.cantidadCartasEnMazo());


        List<Carta> susCartas = texas.sacarCartasDeAbajo(3);
        System.out.println(susCartas.size());
        System.out.println(susCartas.toString());
        System.out.println(texas.cantidadCartasEnMazo());

        texas.colocarCartasArriba(susCartas, 2);
        System.out.println(susCartas.size());
        System.out.println(susCartas.toString());
        System.out.println(texas.cantidadCartasEnMazo());
        System.out.println(texas.toString());

        texas.colocarCartasAbajo(misCartas, misCartas.size());
        System.out.println(misCartas.size());
        System.out.println(misCartas.toString());
        System.out.println(texas.cantidadCartasEnMazo());
        System.out.println(texas.toString());

        List<String> palos = texas.verPalos();
        Collections.shuffle(palos);
        System.out.println(palos.toString());
        texas.ordenarMazo(palos);
        System.out.println(texas.toString());

    }
}
