package codeoJava.integradores;

public class Carta implements Comparable<Carta> {
    private String palo;
    private int numero;
    
    
    public Carta(String palo, int numero) {
        this.palo = palo;
        this.numero = numero;
    }


    public String getPalo() {
        return palo;
    }


    public String getNumero() {
        return NumeroACadena(numero);
    }


    private String NumeroACadena(int nro){
        String numero_carta = "";
        switch (numero) {
            case 11:
                numero_carta = "J";
                break;
            case 12:
                numero_carta = "Q";
                break;
            case 13:
                numero_carta = "K";
                break;
            default:
                numero_carta = String.valueOf(numero);
                break;
        }
        return numero_carta;
    }

    private String paloADibujito(String palo){
        String dibujo = "";
        switch (palo) {
            case "Pica":
                dibujo = "♠";
                break;
            case "Corazón": 
                dibujo = "♥";
                break;
            case "Trébol":
                dibujo = "♣";
                break;    
            case "Diamante":
                dibujo = "♦";
        }
        return dibujo;
    }

    @Override
    public String toString() {
        return "(" + paloADibujito(palo) + "," + NumeroACadena(numero) + ")";
    }


    @Override
    public int compareTo(Carta otraCarta) {
        if (otraCarta instanceof Carta) {
            Carta otraCarta2 = (Carta) otraCarta;
            return this.numero - otraCarta2.numero; // Comparar según el atributo 'numero'
        }
        throw new ClassCastException("El objeto no es una Carta");
    }  
}
