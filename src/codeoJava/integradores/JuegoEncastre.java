package codeoJava.integradores;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;


public class JuegoEncastre {
    
    public static void main(String[] args) {
        Bloque b1 = new Bloque(1f,2f,3f);
        Bloque b2 = new Bloque(0.5f, 0.5f,0.5f);
        Bloque b3 = new Bloque(10f, 5f,1f);
        Bloque b4 = new Bloque(6f, 7f,8f);
    
        Hueco h1  = new Hueco(10f, 5f,1f);
        Hueco h2 = new Hueco(0.5f, 0.5f,0.5f);
        
        Set<Bloque> conjBloques = new HashSet<>();
        conjBloques.add(b3);
        conjBloques.add(b2);
        conjBloques.add(b4);
        conjBloques.add(b1);
        
        Set<Hueco> conjHuecos = new HashSet<>();
        conjHuecos.add(h2);
        conjHuecos.add(h1);
        

        
        int huecosTapados = 0;
        int intentos = 0;

        while(!conjHuecos.isEmpty()){
            intentos++;
            Bloque[] bloques = conjBloques.toArray(new Bloque[0]);
            Hueco[] huecos = conjHuecos.toArray(new Hueco[0]);
            Random random = new Random();
            int indiceAleatorioBloque = random.nextInt(bloques.length);
            int indiceAleatorioHueco = random.nextInt(huecos.length);
            
            

            if (huecos[indiceAleatorioHueco].loTapa(bloques[indiceAleatorioBloque])){
                huecosTapados++;
                conjBloques.remove(bloques[indiceAleatorioBloque]);
                conjHuecos.remove(huecos[indiceAleatorioHueco]);
            }
        }
       
        System.out.println("Huecos tapados: " + huecosTapados);
        System.out.println("Intentos necesarios para tapar todos los huecos " + intentos);
      
    }

    
}
