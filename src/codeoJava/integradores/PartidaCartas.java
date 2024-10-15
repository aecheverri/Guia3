package codeoJava.integradores;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class PartidaCartas {
    private  String[] nombre_jugadores;
    private List<Set<Carta>> cartas_jugadores;

    public PartidaCartas(String jugador0, String jugador1) {
        nombre_jugadores = new String[2];
        nombre_jugadores[0] = jugador0;
        nombre_jugadores[1] = jugador1;
        cartas_jugadores =  new ArrayList<>();
        cartas_jugadores.add(new HashSet<>());
        cartas_jugadores.add(new HashSet<>());
    }


    public void repartirCartas(){
        MazoPoker mazo = new MazoPoker();
        cartas_jugadores.get(0).clear();
        cartas_jugadores.get(1).clear();
        int i = 0;
        while(i < 10){
            Carta carta = mazo.sacarCartasDeArriba(1).get(0);
            cartas_jugadores.get(i%2).add(carta);
            i+=1;
        }
    }
    
    private int sumarPuntosCartas(Set<Carta> manoCartas){
        int sum = 0;
        for (Carta c: manoCartas){
            sum += c.pasarNumeroCartaAEntero();
        }
        return sum;
    }

    public String versionSumaPuntos(){
        repartirCartas();
        System.out.println("Cartas de " + nombre_jugadores[0] + " : " + cartas_jugadores.get(0));
        System.out.println("Cartas de " + nombre_jugadores[1] + " : " + cartas_jugadores.get(1));
        String ganador = "";
        int puntosJugador0 = sumarPuntosCartas(cartas_jugadores.get(0));
        int puntosJugador1 = sumarPuntosCartas(cartas_jugadores.get(1));
        if (puntosJugador0 > puntosJugador1)
            ganador = nombre_jugadores[0];
        if (puntosJugador0 < puntosJugador1)
            ganador = nombre_jugadores[1];
        
        return ganador;   
    }



    public String versionDosDigitos(){
        repartirCartas();
        System.out.println("Cartas de " + nombre_jugadores[0] + " : " + cartas_jugadores.get(0));
        System.out.println("Cartas de " + nombre_jugadores[1] + " : " + cartas_jugadores.get(1));
        int nro_jugador0 = armarNumeroDosDigitos(new ArrayList<>(cartas_jugadores.get(0)));
        int nro_jugador1 = armarNumeroDosDigitos(new ArrayList<>(cartas_jugadores.get(1)));
        String ganador = "";
        if (nro_jugador0 > nro_jugador1){
            ganador = nombre_jugadores[0];
        }else if(nro_jugador0 < nro_jugador1){
            ganador = nombre_jugadores[1];
        }
        return ganador;
    }

    private int maxEnLista(List<Carta> lista_Cartas){
        int max = 0;
        int indiceMax = 0;
        for(int i=0; i< lista_Cartas.size(); i++){
            if (lista_Cartas.get(i).pasarNumeroCartaAEntero() > max && lista_Cartas.get(i).pasarNumeroCartaAEntero() < 10 ){
                max = lista_Cartas.get(i).pasarNumeroCartaAEntero();
                indiceMax = i;
            }
        }
        lista_Cartas.remove(indiceMax);

        return max;
    }

    private int armarNumeroDosDigitos(ArrayList<Carta> lista_Cartas) {
        int max = maxEnLista(lista_Cartas);
        int segundo_max = maxEnLista(lista_Cartas);
        return max * 10 + segundo_max;
    }


    private Integer maxConjunto(Collection<Integer> collection){
        Integer max = 0;
        for (Integer nro: collection){
            if (max < nro)
                max = nro;
        }
        return max;
    }

    private  Map<Integer, Integer> repeticionesPorCarta(Set<Carta> cartas){
        // Crea un map con la cantidad de repeticiones de carta de numero de carta del jugador
        Map<Integer, Integer> repeticionesNumero = new HashMap<>();
        for (Carta c: cartas){
            int numeroCarta = c.pasarNumeroCartaAEntero();
            if (repeticionesNumero.containsKey(numeroCarta)){
                int repeticiones = repeticionesNumero.get(numeroCarta);
                repeticionesNumero.put(numeroCarta, repeticiones + 1); 
            }else{
                repeticionesNumero.put(numeroCarta,1);
            }
        }
        return repeticionesNumero;
    } 

    private int maxCantidadCartasMismoNumero(Set<Carta> cartas) {
        return maxConjunto(repeticionesPorCarta(cartas).values());
    }

    private int numeroMasRepetido(Set<Carta> cartas){
        Set<Integer> nros = new HashSet<>();
        Integer maxCantidadCartasMismoNumero = maxCantidadCartasMismoNumero(cartas);
        Map<Integer, Integer> repeticionesXNumero = repeticionesPorCarta(cartas);
        for (Integer nro: repeticionesXNumero.keySet()){
            if (repeticionesXNumero.get(nro).equals(maxCantidadCartasMismoNumero)){
                nros.add(nro);
            }
        }
        return maxConjunto(nros);

    }

    public String versionMismoNumero(){
        repartirCartas();
        System.out.println("Cartas de " + nombre_jugadores[0] + " : " + cartas_jugadores.get(0));
        System.out.println("Cartas de " + nombre_jugadores[1] + " : " + cartas_jugadores.get(1));
        String ganador = "";
        int cantidadCartasMismoNumeroJugador0 = maxCantidadCartasMismoNumero(cartas_jugadores.get(0));
        int cantidadCartasMismoNumeroJugador1 = maxCantidadCartasMismoNumero(cartas_jugadores.get(1));
        // Busca el jugador que tiene más cartas con igual número
        if (cantidadCartasMismoNumeroJugador0 > cantidadCartasMismoNumeroJugador1){
            ganador = nombre_jugadores[0];
        }else if (cantidadCartasMismoNumeroJugador0 < cantidadCartasMismoNumeroJugador1){
            ganador = nombre_jugadores[1];
        }else{
            // En caso de empate se busca la carta más alta que tenga la mayor cantidad de repeticiones
            if (numeroMasRepetido(cartas_jugadores.get(0)) > numeroMasRepetido(cartas_jugadores.get(1)) ){
                ganador = nombre_jugadores[0];
            }
            else if(numeroMasRepetido(cartas_jugadores.get(0)) < numeroMasRepetido(cartas_jugadores.get(1))){
                ganador = nombre_jugadores[1];
            }
        }
        return ganador;
    }

    private Set<Integer> numerosCartas(Set<Carta> cartas){
        Set<Integer> nros = new HashSet<>();
        for (Carta c: cartas){
            nros.add(c.pasarNumeroCartaAEntero());
        }
        return nros;
    }

    public Set<Carta> cartasDelJugador(String j){
        repartirCartas();
        Set<Carta> cartas;
        if (j.equals(nombre_jugadores[0])){
            cartas = cartas_jugadores.get(0);
        }else{
            cartas = cartas_jugadores.get(1);
        }
        return cartas;
    }

    public boolean tieneEscalera(String jugador){
        Set<Carta> cartas = cartasDelJugador(jugador);
        System.out.println(cartas);

        return formanEscalera(cartas);
    }

    public boolean formanEscalera(Set<Carta> cartas){
        boolean escalera = true;
        Set<Integer> nrosEnCartas = numerosCartas(cartas);
        if (nrosEnCartas.contains(1)){
            // el 1 es el máx
            if(nrosEnCartas.contains(13)){
                int nro = 12;
                while (nro >= 10 && escalera){
                    escalera = nrosEnCartas.contains(nro);
                    nro -- ;
                }
            }else{
                // el 1 es el mín
                int nro = 2;
                while(nro <=5 && escalera){
                    escalera = nrosEnCartas.contains(nro);
                    nro++;
                }
            }
        }else{
            int maxNro = maxConjunto(nrosEnCartas);
            int nro = maxNro - 1;
            while(nro >= maxNro - 4 && escalera){
                escalera = nrosEnCartas.contains(nro);
                nro--;
            }
        }
        return escalera;
    }

    public boolean tieneEscaleraReal(String jugador){
        Set<Carta> cartas = cartasDelJugador(jugador);
        System.out.println(cartas);

        return formanEscalera(cartas) && todasMismoPalo(cartas);
        
    }


    private boolean todasMismoPalo(Set<Carta> cartas) {
        Map<String, Integer> cantidadPorPalo = new HashMap<>();
        for (Carta c: cartas){
         if (!cantidadPorPalo.containsKey(c.getPalo())){
            cantidadPorPalo.put(c.getPalo(),1);
         }else{
            cantidadPorPalo.put(c.getPalo(), cantidadPorPalo.get(c.getPalo())+1);
         }
        }
        return maxConjunto(cantidadPorPalo.values()).equals(Integer.valueOf(5));
    }

    public boolean tieneCartasMismoPalo(String jugador){
        Set<Carta> cartas=cartasDelJugador(jugador);
        Map<String, Integer> cantidadPorPalo = new HashMap<>();
        for (Carta c: cartas){
         if (!cantidadPorPalo.containsKey(c.getPalo())){
            cantidadPorPalo.put(c.getPalo(),1);
         }else{
            cantidadPorPalo.put(c.getPalo(), cantidadPorPalo.get(c.getPalo())+1);
         }
        }
        return maxConjunto(cantidadPorPalo.values()).equals(Integer.valueOf(5));

    }
    
    
}
