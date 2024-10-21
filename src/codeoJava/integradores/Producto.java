package codeoJava.integradores;

import java.util.Objects;

public class Producto {
    private String nombre;
    private float precio;
    private int stock;
    
    
    public Producto(String nombre, float valor, int cantidad) {
        this.nombre = nombre;
        if (valor <= 0)
         throw new BusinessException("El precio del producto debe ser mayor que 0.");
        this.precio = valor;
        if (cantidad < 0){
            throw new BusinessException("El stock debe ser no negativo.");
        }
        this.stock = cantidad;
    }

    public Producto(Producto p){
        this.nombre = p.nombre;
        this.precio = p.precio;
        this.stock = p.stock;
        
    }


    public String nombreProducto() {
        return nombre;
    }


    public float precioProducto() {
        return precio;
    }


    public int stockProducto() {
        return stock;
    }


    public void sumarAStock(int stock){
        this.stock += stock;
    }




    @Override
    public String toString() {
        String salida = "Producto: " + nombre + "\n";
        salida += "Precio: $" + precio + "\n";
        salida += "Stock: " + stock ;
        return salida;
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
        Producto other = (Producto) obj;
        return this.nombre == other.nombre 
                && this.precio == other.precio;
    }
    
}
