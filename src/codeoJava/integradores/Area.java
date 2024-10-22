package codeoJava.integradores;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Area {
    private String nombre;
    private String codigo;
    private Set<Empleado> empleados;
    
    public Area(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.empleados = new HashSet<>();
    }

    public String nombreArea() {
        return nombre;
    }

    public String codigoArea() {
        return codigo;
    }

    public Set<Empleado> empleadosDelArea() {
        return empleados;
    }

    public void agregarEmpleado(Empleado e){
        empleados.add(e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        Area other = (Area) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Area [nombre=" + nombre + ", codigo=" + codigo + ", empleados=" + empleados + "]";
    }

    

    
    



    

    
}
