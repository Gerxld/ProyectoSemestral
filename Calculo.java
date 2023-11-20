import java.io.*;

public class Calculo {
    public char[][] crearTablero() {
        char[][] tablero = new char[9][9];
        return tablero;
    }

    public boolean verificarCoordenadas(String coordenada) {
        char x, y;
        boolean esValido;
        x = coordenada.charAt(0);
        y = coordenada.charAt(2);
        if ((x >= '1' && x <= '9') && ((y >= 'A' && y <= 'I') || (y >= 'a' && y <= 'i'))) {
            esValido = true;
        } else {
            esValido = false;
        }
        return esValido;
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
                x = -1;
                break;
        }
        return x;
    }

    public void limpiarPantalla() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls")
        .inheritIO()
        .start()
        .waitFor();
    }
    
}