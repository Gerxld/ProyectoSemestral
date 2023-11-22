public class Jugador {
    String nombre;
    char[][] tabFlota;
    char[][] tabAtaque;

    public Jugador(String nombre, char[][] tabFlota, char[][] tabAtaque) {
        this.nombre = nombre;
        this.tabFlota = tabFlota;
        this.tabAtaque = tabAtaque;
    }

    public void ubicarBarco(char[][] tabFlota, char ship, String orientacion, int x, int y, int tamaño) {
            tabFlota[x][y] = ship;
            int cont = 1;

            for (int i = 1; i < tamaño; i++) {
                
                if (orientacion.equals("vertical") && tabFlota[x + cont][y] == '-' && x + cont < tabFlota.length) {
                    tabFlota[x + cont][y] = ship;
                } else if (orientacion.equals("horizontal") && tabFlota[x][y + cont] == '-' && y + cont < tabFlota.length) {
                    tabFlota[x][y + cont] = ship;
                }

                cont += 1;
            }
    }



}
