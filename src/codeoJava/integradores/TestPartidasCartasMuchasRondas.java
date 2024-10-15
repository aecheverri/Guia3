package codeoJava.integradores;

import java.util.Scanner;

public class TestPartidasCartasMuchasRondas {

        private static int puntajeRonda(String jugador, String jugador_ganador ){
            int puntaje = 0;
            if (jugador.equals(jugador_ganador))
                puntaje = 1;
            return puntaje;
        }

        private static String resultadoRonda(String ganador){
            String msj = "Hubo empatante";
            if(!ganador.equals(""))
                msj = "El ganador de la ronda es ... " + ganador;
            return msj;
        }

        private static void infoRonda(String j1, String j2, int puntosJ1, int puntosJ2,String ganador){
            System.out.println(resultadoRonda(ganador));
            System.out.println("Puntaje de "+ j1 + " = " + puntosJ1);
            System.out.println("Puntaje de "+ j2 + " = " + puntosJ2);
        }


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String jugador1;
            String jugador2;
            boolean jugar = true;
            int puntosJugador1 = 0;
            int puntosJugador2 = 0;
            String vencedor= "";

            while (jugar) {
                // Primera iteración: pedir nombres de los jugadores
                System.out.print("¿Desea jugar? (si/no): ");
                String respuesta = scanner.nextLine().trim().toLowerCase();

                if (respuesta.equals("si")) {
                    System.out.print("Ingrese el nombre del Jugador 1: ");
                    jugador1 = scanner.nextLine();
                    System.out.print("Ingrese el nombre del Jugador 2: ");
                    jugador2 = scanner.nextLine();
                    PartidaCartas partida = new PartidaCartas(jugador1, jugador2);
    
                    boolean jugarNuevamente = true;
                    while (jugarNuevamente) {
                        System.out.println("\nOpciones:");
                        System.out.println("1. Partida con suma punto de las cartas de la mano");
                        System.out.println("2. Partida mayor número de 2 dígitos de la mano");
                        System.out.println("3. Partida mayor cantidad de cartas con el mismo número");
                        System.out.println("4. Salir del juego");
                        System.out.print("Seleccione una opción: ");
                        int opcion = scanner.nextInt();
                        scanner.nextLine();  // Consumir el salto de línea

                        switch (opcion) {
                            case 1:
                                System.out.println("1. Partida con suma punto de las cartas de la mano");
                                vencedor = partida.versionSumaPuntos();
                                puntosJugador1 += puntajeRonda(jugador1, vencedor);
                                puntosJugador2 += puntajeRonda(jugador2, vencedor);
                                infoRonda(jugador1, jugador2, puntosJugador1, puntosJugador2,vencedor);
                                
                                break;
                            case 2:
                                System.out.println("2. Partida mayor número de 2 dígitos de la mano");
                                vencedor = partida.versionDosDigitos();
                                puntosJugador1 += puntajeRonda(jugador1, vencedor);
                                puntosJugador2 += puntajeRonda(jugador2, vencedor);
                                infoRonda(jugador1, jugador2, puntosJugador1, puntosJugador2,vencedor);
                                
                                break;
                            case 3:
                               System.out.println("3. Partida mayor cantidad de cartas con el mismo número");
                               vencedor = partida.versionMismoNumero();
                               puntosJugador1 += puntajeRonda(jugador1, vencedor);
                               puntosJugador2 += puntajeRonda(jugador2, vencedor);
                               infoRonda(jugador1, jugador2, puntosJugador1, puntosJugador2,vencedor);
                               break;
                                
                            case 4:
                                jugarNuevamente = false;
                                break;
                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                        }
                    }
                } else if (respuesta.equals("no")) {
                    jugar = false;
                    System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                } else {
                    System.out.println("Respuesta no válida. Por favor, escriba 'si' o 'no'.");
                }
            }
    
            scanner.close();
        }
}




        
    