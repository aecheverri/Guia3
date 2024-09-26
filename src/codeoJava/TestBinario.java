package codeoJava;

public class TestBinario {
    public static void main(String[] args) {
        String cadenaBinaria = new String("101");
        NumeroBinario nroBin = new NumeroBinario(cadenaBinaria);
        System.out.println(nroBin.toString());
        System.out.println(nroBin.aDecimal());

        NumeroDecimal nroDec = new NumeroDecimal(64);
        System.out.println(nroDec.toString());
        System.out.println(nroDec.aBinaro());
    }
}
/*
 * La elección entre usar métodos de instancia o estáticos depende del contexto:

    Métodos de instancia: 
    Son más apropiados cuando la operación está vinculada a un estado específico de un objeto. 
    Permiten aprovechar el encapsulamiento y el polimorfismo.

    Métodos estáticos: 
    Son útiles para funciones que operan sin necesidad de una instancia específica. 
    Pueden hacer que el código sea más directo y accesible, especialmente para operaciones 
    que no dependen del estado de un objeto.

    En resumen, si la conversión depende del estado del objeto, métodos de instancia son preferibles.
    Si la conversión es una operación general, métodos estáticos son más apropiados.
 * 
 */