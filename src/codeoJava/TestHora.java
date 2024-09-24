package codeoJava;

public class TestHora {
    public static void main(String[] args) {
        Hora h1 = new Hora();
        System.out.println("Horario1: " + h1);
        
        Hora h2 = new Hora(23, 50, 59);
        System.out.println("Horario2: " + h2);
        
        Hora h3 = new Hora(22, 30, 59);
        System.out.println("Horario3: " + h3);
        
        h1 = h2.sumarHorarios(h3);
        System.out.println("Horario1 (Horario2 + Horario3): " + h1);
        System.out.println("Horario2: " + h2);
        System.out.println("Horario3: " + h3);
        
        h2.cambiarConSumaHorarios(h3);
        System.out.println("Horario2: " + h2);
        System.out.println("Horario3: " + h3);
        
    }
    
    
}
