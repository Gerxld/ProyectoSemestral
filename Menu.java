// Integrantes: Simon Espino, Gerald Ríos, Javier Reyes y Jirak Anria

import java.io.*;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) throws IOException {
        try {
            LeerImprimir sistema = new LeerImprimir();
            Calculo cal = new Calculo();

            // Declaracion de variables
            char[][] tablero;
            String nombre, opcionEliminada, coordenada, orientacion;
            char ship = '0';
            int x, y, tamaño = 0;
            boolean flotaLlena = false, esValido = true, espacioDisponible;
            ArrayList<String> opcionesDisponibles = cal.crearListaOpciones();

            // Proceso
            sistema.darBienvenida();
            tablero = cal.crearTablero();
            nombre = sistema.ingresarNombre(1);
            Jugador p1 = new Jugador(nombre, tablero, tablero); // datos del jugador (num player, nombre, tableros)

            do { // ubicar la flota de un jugador

                opcionEliminada = sistema.imprimirUbicarFlota(opcionesDisponibles);
                ship = cal.obtenerBarco(opcionEliminada);
                tamaño = cal.obtenerTamaño(ship);
                orientacion = sistema.obtenerOrientacion();

                do {
                    do {
                        coordenada = sistema.obtenerCoordenadasBarco();
                        esValido = cal.verificarEntradaCoordenadas(coordenada, tamaño, orientacion);
                        if (!esValido) {
                            sistema.imprimirError();
                        }
                    } while (!esValido);

                    x = cal.obtenerX(coordenada);
                    y = cal.obtenerY(coordenada);
                    espacioDisponible = cal.verificarDisponibilidad(p1.tabFlota, x, y, tamaño, orientacion);

                } while (!espacioDisponible);

                p1.ubicarBarco(p1.tabFlota, ship, orientacion, x, y, tamaño);
                sistema.imprimirTablero(p1.tabFlota);

            } while (!flotaLlena); // loop infinito arreglar

            // Fin try
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en Menu");
        }
    }
}