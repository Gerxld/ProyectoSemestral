import java.io.IOException;
import java.util.ArrayList;

public class Jugador {
    String nombre;
    char[][] tabFlota;
    char[][] tabAtaque;

    public Jugador(String nombre, char[][] tabFlota, char[][] tabAtaque) {
        this.nombre = nombre;
        this.tabFlota = tabFlota;
        this.tabAtaque = tabAtaque;
    }

    public void ubicarFlota() throws IOException {
        LeerImprimir sistema = new LeerImprimir();
        Calculo cal = new Calculo();
        // Declaración de variables
        String opcionEliminada, coordenada, orientacion;
        char ship = '0';
        int x, y, tamaño = 0;
        boolean flotaLlena = false, esValido = true, espacioDisponible;
        ArrayList<String> opcionesDisponibles = cal.crearListaOpciones();

        do {
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
                espacioDisponible = cal.verificarDisponibilidad(this.tabFlota, x, y, tamaño, orientacion);

            } while (!espacioDisponible);

            ubicarBarco(ship, orientacion, x, y, tamaño);
            sistema.imprimirTablero(this.tabFlota);
            if (opcionesDisponibles.size() == 0)
                flotaLlena = true;

        } while (!flotaLlena);
    }

    public void ubicarBarco(char ship, String orientacion, int x, int y, int tamaño) {
        this.tabFlota[x][y] = ship;
        int cont = 1;

        for (int i = 1; i < tamaño; i++) {

            if (orientacion.equals("vertical") && this.tabFlota[x + cont][y] == '-' && x + cont < this.tabFlota.length) {
                this.tabFlota[x + cont][y] = ship;
            } else if (orientacion.equals("horizontal") && this.tabFlota[x][y + cont] == '-' && y + cont < this.tabFlota.length) {
                this.tabFlota[x][y + cont] = ship;
            }

            cont += 1;
        }
    }

}