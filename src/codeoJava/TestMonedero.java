package codeoJava;

public class TestMonedero {
    public static void main(String[] args) {
        Monedero wallet =  new Monedero(100f);
        System.out.println("Saldo actual: "+ wallet.verMonto());
        wallet.sacarDinero(150f);
        System.out.println("Saldo actual: "+ wallet.verMonto());
        wallet.meterDinero(50f);
        System.out.println("Saldo actual: "+ wallet.verMonto());
        wallet.sacarDinero(150f);
        System.out.println("Saldo actual: "+ wallet.verMonto());
        
    }
}
