package codeoJava.integradores;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Inventario {
    private Set<Producto> productos;

    public Inventario() {
        this.productos = new HashSet<>();
    }

    public void agregarProducto(Producto p){
        if (!productos.contains(p))
            productos.add(p);
        else{
            for(Producto q: productos){
                if (q.equals(p)){
                    q.sumarAStock( p.stockProducto());
                }
            }
        }

    }

    public void venderProducto(String nombre , int cantidad){
        Iterator<Producto> iterador = productos.iterator();
        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            if (producto.nombreProducto().equals(nombre)) {
                if (cantidad <= producto.stockProducto())
                    producto.sumarAStock(-cantidad); 
                else
                    throw new BusinessException("No se puede vender mayor cantidad de ese producto que el stock actual");
            }
        }
    
    }

    public float valorTotalInventario(){
        float valorTotal = 0;
        for (Producto p: productos){
            valorTotal += p.precioProducto()*p.stockProducto();
        }
        return valorTotal;
    }

    public void productoSinStock(){
        System.out.println("Productos agotados");
        System.out.println("******************************");
        for (Producto p : productos){
            if (p.stockProducto() == 0){
                System.out.println(p);
            }
        }
        
        System.out.println("******************************");
    }


    public Producto buscarProductoConNombre(String nombre){
        Iterator<Producto> iterador = productos.iterator();
        while (iterador.hasNext()) {
            Producto producto = iterador.next();
            if (producto.nombreProducto().equals(nombre)) {
                return producto; 
            }
        }
        
        throw new BusinessException("No existe un producto con ese nombre.");
    }

   public void busquedaPorNombreParcial(String nombre){
        for (Producto p: productos){
            if (esSubtring(nombre, p.nombreProducto())){
                System.out.println(p);
            }
        }
   }

   private boolean esSubtring(String subcadena, String cadena){
        return cadena.toLowerCase().contains(subcadena.toLowerCase());
   }
    
}
