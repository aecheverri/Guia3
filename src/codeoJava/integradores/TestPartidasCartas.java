package codeoJava.integradores;

public class TestPartidasCartas {
    public static void main(String[] args) {
        PartidaCartas partida = new PartidaCartas("Ranchas", "Fatura");
        System.out.println(partida.versionSumaPuntos());
        System.out.println(partida.versionMismoNumero());
        System.out.println("tiene escalera: " + partida.tieneEscalera("Ranchas"));
        System.out.println("tiene escalera real: "+ partida.tieneEscaleraReal("Ranchas"));
    }
}
