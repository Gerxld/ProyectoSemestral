
// Integrantes: Simon Espino, Gerald Ríos, Javier Reyes y Jirak Anria
import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException {
        try {
            LeerImprimir sistema = new LeerImprimir();
            Calculo cal = new Calculo();
            // Declaracion de variables
            char[][] tabFlotaP1, tabFlotaP2, tabAtaqueP1, tabAtaqueP2;
            String nombreP1, nombreP2, ganador = "";
            boolean hayGanador = false;

            // Proceso
            sistema.darBienvenida();

            // Ubicación de flotas
            // Jugador 1
            nombreP1 = sistema.ingresarNombre(1, "");
            tabFlotaP1 = cal.crearTablero();
            tabAtaqueP1 = cal.crearTablero();
            Jugador p1 = new Jugador(nombreP1, tabFlotaP1, tabAtaqueP1); // datos del jugador (num player, nombre, tableros)
            p1.ubicarFlota();
            cal.limpiarPantalla();

            // Jugador 2
            nombreP2 = sistema.ingresarNombre(2, nombreP1);
            tabFlotaP2 = cal.crearTablero();
            tabAtaqueP2 = cal.crearTablero();
            Jugador p2 = new Jugador(nombreP2, tabFlotaP2, tabAtaqueP2);
            p2.ubicarFlota();
            cal.limpiarPantalla();

            // Ataque
            do {
                // Jugador 1
                sistema.imprimirAtacar();
                sistema.imprimirTurno(p1.nombre);
                ganador = p1.atacar(p2);

                if (!ganador.equals("")) {
                    break;
                }

                cal.limpiarPantalla();

                // Jugador 2
                sistema.imprimirTurno(p2.nombre);
                ganador = p2.atacar(p1);

                if (!ganador.equals("")) {
                    break;
                }

                cal.limpiarPantalla();
            } while (!hayGanador);

            sistema.imprimirGanador(ganador, p1, p2);

            // Fin try
        } catch (Exception e) {
            System.out.println("Ingrese los Valores correctamente!");
        }
    }
}