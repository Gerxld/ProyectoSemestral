import java.io.*;
import java.util.ArrayList;

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

    public void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void imprimirError() {
        System.out.println("Por favor, ingrese una posición valida!");
    }

    public String imprimirUbicarFlota(ArrayList<String> opcionesDisponibles) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tamaño;
        String opcionEliminada = "";
        boolean encontrado;

        System.out.println("Ubica tu flota\nIngresa el tamaño del barco que deseas ubicar: ");
        do {
            for (int i = 0; i < opcionesDisponibles.size(); i++) { // mostramos las opciones
                System.out.println(opcionesDisponibles.get(i));
            }

            try {
                tamaño = Integer.parseInt(reader.readLine());
                if (tamaño >= 2 && tamaño <= 4) {
                    encontrado = false;
                    for (String barco : opcionesDisponibles) {
                        if (barco.contains("tamaño " + tamaño)) {
                            opcionEliminada = barco;
                            opcionesDisponibles.remove(opcionEliminada);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("La opción elegida ya no se encuentra disponible");
                    }
                } else {
                    System.out.println("Por favor, ingrese un tamaño válido");
                }
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un tamaño válido");
            }

        } while (opcionEliminada.equals(""));
        return opcionEliminada;
    }

    public String obtenerOrientacion() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String orientacion = "", op;
        do {
            System.out.println("Indique la orientación\n1. Vertical\n2. Horizontal");
            op = reader.readLine();
            if (op.equals("1")) {
                orientacion = "vertical";
            } else if (op.equals("2")) {
                orientacion = "horizontal";
            } else {
                System.out.println("Intentelo de Nuevo!");
            }
        } while (orientacion.equals(""));
        return orientacion;
    }

    public String obtenerCoordenadasBarco() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String coordenada;
        System.out.println("Donde desea colocar su barco?");
        System.out.println("Ingrese las coordenadas de esta manera: D,1");
        coordenada = reader.readLine();
        return coordenada;
    }

}
