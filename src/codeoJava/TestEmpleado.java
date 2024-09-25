package codeoJava;

public class TestEmpleado {
    public static void main(String[] args) {
        Empleado e1 = new Empleado(0, "Pepe");
        Empleado e2 = new Empleado(0, "XXX");
        System.out.println(e1.getNumero());
        System.out.println(e2.getNumero());
        e2.setNumero(110);
        System.out.println(e1.verDatos());
        System.out.println(e2.verDatos());
        e2.setNombre("Chola");
        System.out.println(e2.verDatos());
       
    }
}
