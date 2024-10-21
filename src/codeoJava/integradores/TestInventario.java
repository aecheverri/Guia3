package codeoJava.integradores;

public class TestInventario {
    public static void main(String[] args) {
        Inventario i = new Inventario();
        Producto p = new Producto("queso", 1000, 22);
        i.agregarProducto(p);
        System.out.println(i.buscarProductoConNombre("queso"));
        i.productoSinStock();
        i.agregarProducto(new Producto("queso", 1000, 10));
        System.out.println(i.buscarProductoConNombre("queso"));
        i.productoSinStock();
        System.out.println(i.valorTotalInventario());
        i.venderProducto("queso", 5);
        System.out.println(i.buscarProductoConNombre("queso"));
        Producto t = new Producto("queso podrido", 10, 5);
        i.agregarProducto(t);
        i.venderProducto("queso podrido", 5);
        i.productoSinStock();
        i.busquedaPorNombreParcial("eso");
        
        

    }
}
