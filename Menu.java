// Integrantes: Simon Espino, Gerald Ríos, Javier Reyes y Jirak Anria

import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException {
        try {
            // Tenemos 3 clases aparte del main: Jugador, LeerImprimir y Calculo
            // En este archivo solo se llaman a los metodos a partir de los objetos jugador,
            // sistema o cal
            // Declaracion de variables
            char[][] tablero;
            String nombre, shipName = "", coordenada, orientacion;
            char ship = '0';
            int x, y, tamaño = 0;
            boolean flotaLlena = false;
            // Objetos generales
            LeerImprimir sistema = new LeerImprimir();
            Calculo cal = new Calculo();

            // Proceso
            sistema.darBienvenida();
            tablero = cal.crearTablero();
            nombre = sistema.ingresarNombre(1);
            Jugador p1 = new Jugador(nombre, tablero, tablero); // datos del jugador (num player, nombre, tableros)
            do { // ubicar la flota de un jugador
                ship = sistema.imprimirUbicarFlota(); 
                switch (ship) {
                    case '2':
                        tamaño = 2;
                        shipName = "Lancha";
                        break;
                    case '3':
                        tamaño = 3;
                        shipName = "Buque";
                        break;
                    case '4':
                        tamaño = 4;
                        shipName = "Portaaviones";
                        break;
                    default:
                        System.out.println("Error en switch ship");
                        break;
                }
                // ARREGLAR LOGICA DE ORIENTACION Y UBICACION (No solo se acepta una coordenada)
                orientacion = sistema.obtenerOrientacion();
                coordenada = sistema.obtenerCoordenadasBarco(shipName, ship, tamaño);
                x = cal.obtenerX(coordenada);
                y = cal.obtenerY(coordenada);
                p1.ubicarBarco(ship, orientacion, x, y);
            } while (!flotaLlena);

            // Fin try
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en Menu");
        }
    }
}