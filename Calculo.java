public class Calculo {
    public String[][] crearTablero() {
        String[][] tablero = new String[9][9];
        return tablero;
    }

//Este método limpia la consola cada ve que sea llamado (Sólo funciona para Windows).
    public static void limpiarPantalla() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls")
        .inheritIO()
        .start()
        .waitFor();
    }
}
