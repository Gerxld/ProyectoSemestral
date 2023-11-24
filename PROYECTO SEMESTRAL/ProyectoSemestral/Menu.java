// Integrantes: Simon Espino, Gerald Ríos, Javier Reyes y Jirak Anria

import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException {
        try {
            LeerImprimir sistema = new LeerImprimir();
            Calculo cal = new Calculo();
             
            // Declaracion de variables
            char[][] tabFlotaP1, tabFlotaP2, tabAtaqueP1, tabAtaqueP2;
            String nombreP1, nombreP2;

            // Proceso
            sistema.darBienvenida();
            
            nombreP1 = sistema.ingresarNombre(1, "");
            tabFlotaP1 = cal.crearTablero();
            tabAtaqueP1 = cal.crearTablero();
            Jugador p1 = new Jugador(nombreP1, tabFlotaP1, tabAtaqueP1); // datos del jugador (num player, nombre, tableros)
            p1.ubicarFlota();
            
            cal.limpiarPantalla();
            
            nombreP2 = sistema.ingresarNombre(2, "");
            tabFlotaP2 = cal.crearTablero();
            tabAtaqueP2 = cal.crearTablero();
            Jugador p2 = new Jugador(nombreP2, tabFlotaP2, tabAtaqueP2); 
            p2.ubicarFlota();
            p1.realizarTurno(p2,sistema);

            while (!p1.haperdido() && !p2.haperdido()) {
                System.out.println("Turno de " + p1.getnombre());
                p1.realizarTurno(p2, sistema);

                if (p2.haperdido()){
                    System.out.println("Ganador: " + p1.getnombre());
                    break;
                }
                if (p1.haperdido()){
                    System.out.println("Ganador: " + p2.getnombre());
                    break;
                }
            }
            // Fin try
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error en Menu");
        }
    }
}