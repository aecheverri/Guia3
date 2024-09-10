package codeoJava;
import java.lang.Character;

public class f <T> {
    private T contenido;

    public void f(T x){
        contenido = x;
    }

    public void f(){
        contenido = null;
    }

    public static void main(String[] args) {
        Character letra = 'a';
        f<Character> f1 = new f<Character>(letra);
    }
}
