import java.io.*;

public class LeerImprimir {
    public void darBienvenida() {
        System.out.println("Bienvenido a Battleship!");
        System.out.println("Ubica tu flota, descubre las coordenadas de tu oponente y hunde sus barcos para ganar!");
    }

    public String ingresarNombre(int p) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        System.out.println("Ingrese su nombre jugador " + p);
        nombre = reader.readLine();
        return nombre;
    }
}
