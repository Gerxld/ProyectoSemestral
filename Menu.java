// Integrantes: Simon Espino, Gerald Ríos, Javier Reyes y Jirak Anria

import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException {
        try {
            // Tenemos 3 clases aparte del main: Jugador, LeerImprimir y Calculo
            // En este archivo solo se llaman a los metodos a partir de los objetos jugador, sistema o cal
            // Declaracion de variables
            String nombre;
            String[][] tablero;
            // Objetos generales
            LeerImprimir sistema = new LeerImprimir();
            Calculo cal = new Calculo();

            // Proceso
            sistema.darBienvenida();
            // creamos los datos para los dos jugadores (num player, nombre, tableros)
            tablero = cal.crearTablero();
            nombre = sistema.ingresarNombre(1);
            Jugador p1 = new Jugador(nombre, tablero, tablero);
            nombre = sistema.ingresarNombre(2);
            Jugador p2 = new Jugador(nombre, tablero, tablero);

            // Fin try
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
    }
}