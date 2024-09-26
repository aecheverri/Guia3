package codeoJava;

public class NumeroDecimal {
    private int decimal;

    public NumeroDecimal(int decimal) {
        this.decimal = decimal;
    }

    public String aBinaro(){
        String cadenaBin = "";
        int copiaDecimal = decimal;
        while( copiaDecimal / 2 != 0){
            cadenaBin = String.valueOf(copiaDecimal % 2) + cadenaBin;
            copiaDecimal /= 2;
        }
        cadenaBin = copiaDecimal + cadenaBin;
        return cadenaBin;
    }

    @Override
    public String toString() {
        return String.valueOf(decimal);
    }
    
    
}
