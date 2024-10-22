package codeoJava.integradores;

import java.util.Objects;

public class Empleado {
    private String nombre;
    private String apellido;
    private int nroEmpleado;
    
    
    public Empleado(String nombre, String apellido, int nroEmpleado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroEmpleado = nroEmpleado;
    }


    public String nombre(){
        return nombre;
    }


    public String apellido() {
        return apellido;
    }


    public int numeroEmpleado() {
        return nroEmpleado;
    }


    @Override
    public String toString() {
        String salida = "Número de Empleado: "+ nroEmpleado+"\n";
        salida += "Nombre: "+ nombre +"\n";
        salida += "Apellido: "+ apellido;
        return salida;
    }


    @Override
    public int hashCode() {
        return Objects.hash(nroEmpleado);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Empleado other = (Empleado) obj;

        return this.nroEmpleado == other.nroEmpleado;
    }

    



    
    

    
}
