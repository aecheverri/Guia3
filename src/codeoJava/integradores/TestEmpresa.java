package codeoJava.integradores;

public class TestEmpresa {

    public static void main(String[] args) {
        Area a1 = new Area("Seguridad", "S01");
        Area a2 = new Area("Logistica", "L41");
        Area a3 = new Area("Contabilidad", "C55");

        Empleado e1 = new Empleado("Alex", "Del Piero", 10);
        Empleado e2 = new Empleado("Pepa", "Perez", 939); 
    
    
    
    
        Empresa emp = new Empresa();
        
        emp.agregarArea(a3);
        emp.agregarArea(a1);
        emp.agregarArea(a2);

        emp.contratarEmpleado(e2, "S01");
        System.out.println(emp.areaDelEmpleado(e2));
        emp.contratarEmpleado(e1, "Logistica");
        System.out.println(emp.empleadosArea("Seguridad"));
        System.out.println(emp.empleadosArea("Logistica"));
        
        System.out.println(emp.areaDelEmpleado(e1));
        emp.despedirEmpleado(e1);
        System.out.println(emp.empleadosArea("Logistica"));

        emp.transferirEmpleado(e2, "L41");
        System.out.println(emp.empleadosArea("Logistica"));

        System.out.println(emp.areaDelEmpleado(e2));
        emp.transferirEmpleado(e2, "Contabilidad");
        System.out.println(emp.empleadosArea("C55"));

        System.out.println(emp.areaDelEmpleado(e2));
        emp.despedirEmpleado(e2);


    
    }
    

}
