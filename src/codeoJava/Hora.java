package codeoJava;

public class Hora {
    private int horas;
    private int minutos;
    private int segundos;
    
    
    
    public Hora() {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }


    public Hora(int horas, int minutos, int segundos) {
        boolean horasValidas = horas <= 23 && horas >= 0;
        boolean minutosValidos = minutos <= 59 && minutos >= 0;  
        boolean segundosValidos = segundos <= 59 && segundos >= 0;

        if (!horasValidas || !minutosValidos || !segundosValidos){
            throw new RuntimeException("Horario no válido");
        }

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }


    @Override
    public String toString() {
        String strHora =  Integer.toString(horas);
        String strMinutos =  Integer.toString(minutos);
        String strSegundos =  Integer.toString(segundos);
        
        if (horas < 10)
            strHora = "0" + strHora;
        if (minutos < 10)
            strMinutos = "0" + strMinutos;
        if (segundos < 10)
            strSegundos = "0" + strSegundos;

        return strHora + ":" + strMinutos + ":" + strSegundos ;
    
    }

    public Hora sumarHorarios(Hora horario2){
        Hora nuevaHora = new Hora(this.horas, this.minutos, this.segundos);
        if (nuevaHora.segundos + horario2.segundos > 59){
            nuevaHora.minutos++;
            nuevaHora.segundos = (nuevaHora.segundos + horario2.segundos) % 60; 
        }
        
        if(nuevaHora.minutos + horario2.minutos > 59){
            nuevaHora.horas++;
            nuevaHora.minutos = (nuevaHora.minutos + horario2.minutos) % 60;
        }
        
        if (nuevaHora.horas + horario2.horas > 23)
            nuevaHora.horas = (nuevaHora.horas + horario2.horas) % 24;

        return nuevaHora;
    }

    public void cambiarConSumaHorarios(Hora horario2){
        Hora horariosSumados = sumarHorarios(horario2); 
        horas = horariosSumados.horas;
        minutos = horariosSumados.minutos;
        segundos = horariosSumados.segundos;
    }
    

    
}
