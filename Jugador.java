public class Jugador {
    String nombre;
    char[][] tabFlota;
    char[][] tabAtaque;

    public Jugador(String nombre, char[][] tabFlota, char[][] tabAtaque) {
        this.nombre = nombre;
        this.tabFlota = tabFlota;
        this.tabAtaque = tabAtaque;
    }

    public void ubicarBarco(char ship, String orientacion, int x, int y) {
        tabFlota[x][y] = ship;
    }
}
