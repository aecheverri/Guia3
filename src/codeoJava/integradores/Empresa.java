package codeoJava.integradores;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class Empresa {
    private List<Area> areas;


    public Empresa() {
        this.areas = new ArrayList<>();
        
    }

    public void agregarArea(Area a){
        if (esAreaDeLaEmpresa(a.nombreArea()) || esAreaDeLaEmpresa(a.codigoArea()))
            throw new BusinessException("El área ya existe");
        this.areas.add(a);
    }

    private boolean esAreaDeLaEmpresa(String area){
        boolean esArea = false;
        int i = 0;
        while (i < areas.size() && !esArea){
            esArea = area == areas.get(i).nombreArea() || area == areas.get(i).codigoArea() ;
            i++;
        }
        return esArea;
    }

    public String areaDelEmpleado(Empleado e){
        for(int i = 0; i < areas.size(); i++){
            if (areas.get(i).empleadosDelArea().contains(e))
                return areas.get(i).nombreArea();   
        }    
        throw new BusinessException("El empleado no pertence a la empresa");
    }

 
    private int buscarIndice(String area){
        int i = 0;
        while(i < areas.size() && ( !area.equals(areas.get(i).nombreArea()) && !area.equals(areas.get(i).codigoArea())) )
            i++;
        return i;
    }
    
    public Set<Empleado> empleadosArea(String area){
        if (!esAreaDeLaEmpresa(area))
            throw new BusinessException("El área no pertence a la empresa");
        return new HashSet<>(areas.get(buscarIndice(area)).empleadosDelArea());       
    }

    public void contratarEmpleado(Empleado e, String area){
        if (!esAreaDeLaEmpresa(area))
            throw new BusinessException("El área no pertence a la empresa");
        if (esEmpleado(e))    
            throw new BusinessException("El empleado ya trabaja en la empresa");
        
        int indiceArea = buscarIndice(area);
        areas.get(indiceArea).agregarEmpleado(e);
        
    }



    public boolean esEmpleado(Empleado e){
        for(Area a: areas){
            if (a.empleadosDelArea().contains(e))
                return true;
        }
        return false;
    }

    public void despedirEmpleado(Empleado e){
        if(!esEmpleado(e))
            throw new BusinessException("El empleado no pertenece a la empresa");
        boolean hallado = false;
        int i=0;
        while(i < areas.size() && !hallado){
            Set<Empleado> empleadosArea = areas.get(i).empleadosDelArea(); 
            hallado = empleadosArea.contains(e);
            if (hallado)
                empleadosArea.remove(e);
            i++;
        }
    }
    
    public void transferirEmpleado(Empleado e, String area){
        if (area == areaDelEmpleado(e))
            throw new BusinessException("No se puede mover a un empleado a la misma área");
        despedirEmpleado(e);
        contratarEmpleado(e, area);
    }


}
