package codeoJava.integradores;

public class TestCapitulo {
    public static void main(String[] args) {
        Pagina p1 = new Pagina(1,"Había una vez");
        Pagina p2 = new Pagina(2,"una oruga");
        Pagina p3 = new Pagina(3,"diminuta");
        Pagina nueva_p2 = new Pagina(2, "en una lejana galaxia");


        Capitulo c1 = new Capitulo("Intro", p1);
        System.out.println(c1);

        c1.agregarPagina(p2);
        c1.agregarPagina(p3);
        System.out.println(c1);

        c1.agregarPagina(nueva_p2);
        System.out.println(c1);

        c1.borrarPagina(p1);
        System.out.println(c1);

        System.out.println("Cant págs: " + c1.cantidadPaginasCapitulo());
        System.out.println("Página inic \n" + c1.paginaInicial());
        System.out.println("Página final \n" + c1.paginaFinal());



    }
}
