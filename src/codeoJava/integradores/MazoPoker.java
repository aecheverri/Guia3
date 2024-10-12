package codeoJava.integradores;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MazoPoker {
    private List<Carta> mazo;

    public MazoPoker() {
        this.mazo = new ArrayList<>();
        String[] palos ={"Pica","Corazón","Diamante","Trébol"};
        for(String palo: palos){
            for(int nro = 1; nro <= 13;nro++){
                mazo.add(new Carta(palo,nro));
            }
        }
        barajarMazo();
    }

    public List<String> verPalos(){
        String[] palos ={"Pica","Corazón","Diamante","Trébol"};
        return  new ArrayList<String>(Arrays.asList(palos));
    }

    public void barajarMazo(){
        Collections.shuffle(mazo);
    }

    public int cantidadCartasEnMazo(){
        return mazo.size();
    }

    public List<Carta> sacarCartasDeArriba(int cantidadCartas){
        List<Carta> cartasExtraidas = new ArrayList<>();
        while(cantidadCartas > 0){
            cartasExtraidas.add(mazo.remove(0));
            cantidadCartas--;
        }
        return cartasExtraidas;
    }

    public List<Carta> sacarCartasDeAbajo(int cantidadCartas){
        List<Carta> cartasExtraidas = new ArrayList<>();
        while(cantidadCartas > 0){
            cartasExtraidas.add(mazo.remove(mazo.size() -1));
            cantidadCartas--;
        }
        return cartasExtraidas;
    }

    public void colocarCartasArriba(List<Carta> cartas, int cantidadCartas){
            while (cantidadCartas > 0) {
                mazo.addFirst(cartas.remove(0));
                cantidadCartas--;
            }
    }

    public void colocarCartasAbajo(List<Carta> cartas, int cantidadCartas){
        while (cantidadCartas > 0) {
            mazo.addLast(cartas.remove(0));
            cantidadCartas--;
        }
    }


    private  void insertionSort(List<Carta> list) {
        for (int i = 1; i < list.size(); i++) {
            Carta key = list.get(i);
            int j = i - 1;

            // Mueve los elementos de list[0..i-1], que son mayores que key,
            // a una posición delante de su posición actual
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    public void ordenarMazo(List<String> palos){
        Map<String,List<Carta>> cartasPorPalo = new HashMap<>();
        for (String palo : palos){
            cartasPorPalo.put(palo, new ArrayList<>());
        }
        //Armo los buckets
        while(cantidadCartasEnMazo() > 0){
            Carta carta = mazo.remove(0);
            cartasPorPalo.get(carta.getPalo()).add(carta);
        }

        for (String key: cartasPorPalo.keySet()){
            //Ordenado cada palo en orden ascendente
            insertionSort(cartasPorPalo.get(key));
        }

        System.out.println(palos);
        for (String palo: palos){
            while(!cartasPorPalo.get(palo).isEmpty()){
                mazo.addLast(cartasPorPalo.get(palo).remove(0));
            }

        }
        
    }


    @Override
    public String toString() {
        
        return mazo.toString();
    }
    
}
