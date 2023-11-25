import java.io.*;
import java.util.ArrayList;

public class Calculo {

    public void limpiarPantalla() throws IOException, InterruptedException {
        Thread.sleep(1500); // Esperar 1.5 segundos antes de limpiar pantalla

        new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();
    }

    public char[][] crearTablero() {
        char[][] tablero = new char[9][9];

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '-';
            }
        }

        return tablero;
    }

    public ArrayList<String> crearListaOpciones() {
        ArrayList<String> opcionesDisponibles = new ArrayList<>();
        opcionesDisponibles.add("- Crucero (tamaño 2)");
        opcionesDisponibles.add("- Submarino (tamaño 2)");
        opcionesDisponibles.add("- Buque (tamaño 3)");
        opcionesDisponibles.add("- Portaaviones (tamaño 4)");
        return opcionesDisponibles;
    }

    public char obtenerBarco(String opcionEliminada) {
        char ship = '-';

        do {
            switch (opcionEliminada) {
                case "- Crucero (tamaño 2)":
                case "- Submarino (tamaño 2)":
                    ship = '2';
                    break;

                case "- Buque (tamaño 3)":
                    ship = '3';
                    break;

                case "- Portaaviones (tamaño 4)":
                    ship = '4';
                    break;
            }
        } while (ship == '-');

        return ship;
    }

    public int obtenerTamaño(char ship) {
        int tamaño = 0;

        switch (ship) {
            case '2':
                tamaño = 2;
                break;
            case '3':
                tamaño = 3;
                break;
            case '4':
                tamaño = 4;
                break;
        }

        return tamaño;
    }

    public int obtenerY(String coordenada) {
        char yChar;
        int y;

        yChar = coordenada.charAt(2);
        y = Character.getNumericValue(yChar);
        y -= 1;

        return y;
    }

    public int obtenerX(String coordenada) {
        char xChar;
        int x;

        xChar = coordenada.charAt(0);
        switch (xChar) {
            case 'a':
            case 'A':
                x = 0;
                break;

            case 'b':
            case 'B':
                x = 1;
                break;

            case 'c':
            case 'C':
                x = 2;
                break;

            case 'd':
            case 'D':
                x = 3;
                break;

            case 'e':
            case 'E':
                x = 4;
                break;

            case 'f':
            case 'F':
                x = 5;
                break;

            case 'g':
            case 'G':
                x = 6;
                break;

            case 'h':
            case 'H':
                x = 7;
                break;

            case 'i':
            case 'I':
                x = 8;
                break;

            default:
                System.out.println("Ingrese las coordenadas correctamente!");
                x = '-';
                break;
        }

        return x;
    }

    public boolean verificarEntradaCoordenadas(String coordenada, int tamaño, String orientacion) {
        char x, y;
        int limY, limX; // límites del barco
        boolean esValido = false;
        tamaño -= 1;

        if (coordenada.length() >= 3) {
            x = Character.toUpperCase(coordenada.charAt(0));
            y = coordenada.charAt(2);

            if ((x >= 'A' && x <= 'I') && (y >= '1' && y <= '9')) {
                limX = x - 'A' + 1; // Convertir letra a número (A=1...)
                limY = Character.getNumericValue(y);

                if (orientacion.equals("vertical")) {
                    limX += tamaño;
                } else {
                    limY += tamaño;
                }

                if (limX >= 1 && limX <= 9 && limY >= 1 && limY <= 9) {
                    esValido = true;
                }
            }
        }

        return esValido;
    }

    public boolean verificarEntradaCoordenadas(String coordenada) {
        char x, y;
        boolean esValido = false;

        if (coordenada.length() >= 3) {
            x = Character.toUpperCase(coordenada.charAt(0));
            y = coordenada.charAt(2);

            if ((x >= 'A' && x <= 'I') && (y >= '1' && y <= '9')) {
                esValido = true;
            }
        }

        return esValido;
    }

    public boolean verificarDisponibilidad(char[][] tabFlota, int x, int y, int tamaño, String orientacion) {
        boolean espacioDisponible = true;
        int limX, limY;
        limX = x;
        limY = y;

        if (orientacion.equals("vertical")) {
            limX += tamaño - 1;
        } else {
            limY += tamaño - 1;
        }

        for (int i = x; i <= limX; i++) { // verifica que no choque con otro barco
            for (int j = y; j <= limY; j++) {
                if (tabFlota[i][j] != '-') {
                    espacioDisponible = false;
                    System.out.println("En esta posición sus barcos colisionan!");
                    break;
                }
            }
        }

        return espacioDisponible;
    }

    public boolean verificarDisponibilidad(char[][] tablero, int x, int y) {
        boolean espacioDisponible = true;

        if (tablero[x][y] == 'X' || tablero[x][y] == '0') {
            espacioDisponible = false;
            System.out.println("Ya ataco en esta posición!");
            return espacioDisponible;
        }

        return espacioDisponible;
    }

    public boolean hayGanador(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {

                if (tablero[i][j] != 'X' && tablero[i][j] != '-') {
                    return false;
                }

            }
        }

        return true;
    }

}
