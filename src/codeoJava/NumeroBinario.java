package codeoJava;

public class NumeroBinario {
    private String bin;

    public NumeroBinario(String cadenaBinaria) {
        bin = new String(cadenaBinaria);
    }

    @Override
    public String toString() {
        String salida = "[";
        for(int i = 0;i < bin.length(); i++){
            salida += bin.charAt(i);
            if (i != bin.length() - 1)
                salida += ","; 
        }
        salida+= "]";
        return salida;
    }

    public int aDecimal(){
        int decimal = 0;
        for(int i = 0;i < bin.length(); i++){
            decimal+=  Math.pow( 2, Character.getNumericValue(bin.charAt(i)));
        }
        return decimal;
    }

    
}
