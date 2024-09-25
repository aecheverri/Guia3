package codeoJava;

public class Empleado {
    private int numero;
    private String nombre;

    public Empleado(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String verDatos(){
        String msj= "Id Empleado: " + numero + "\n";
        msj += ("Nombre Empleado: " + nombre);

        return msj;
    
    }



}
