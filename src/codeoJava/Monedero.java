package codeoJava;

public class Monedero {
    private float saldoActual;

    public Monedero(float dineroInicial) {
        if (dineroInicial < 0)
            throw new RuntimeException("El saldo inicial a ingresar debe ser al menos 0");
        saldoActual = dineroInicial;

    }

    public void meterDinero(float dinero){
        saldoActual += dinero;
    }
    
    public void sacarDinero(float dinero){
        if (dinero <= saldoActual){
            saldoActual-=dinero;
            System.out.println("Extracción de dinero OK");
        }else{
            System.out.println("No tiene suficientes fondos para retirar esa cantidad");
        }
            
    }

    public float verMonto(){
        float copiaSaldoActual = saldoActual;
        return copiaSaldoActual;
    }

}
