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
    public void realizarTurno(Jugador oponente, LeerImprimir sistema) throws IOException{
        Calculo cal = new Calculo();

        System.out.println("Tablero de " + this.nombre+ " :");
        sistema.imprimirTablero(this.tabAtaque);

        String coordenadaAtaque = sistema.obtenerCoordAtaque();
        
        int resultado = oponente.recibirAtaque(coordenadaAtaque);

        if (resultado == 1){
            System.out.println("Has acertado!");
            this.tabAtaque[cal.obtenerX(coordenadaAtaque)][cal.obtenerY(coordenadaAtaque)] = 'X';
        } else if (resultado == 0){
            System.out.println("Has fallado!");
            this.tabAtaque[cal.obtenerX(coordenadaAtaque)][cal.obtenerY(coordenadaAtaque)] = 'O';
        } else if (resultado == 2){
            System.out.println("Has hundido un barco!");
            this.tabAtaque[cal.obtenerX(coordenadaAtaque)][cal.obtenerY(coordenadaAtaque)] = 'X';
        }
        
        int ResultadoAtaque= oponente.recibirAtaque(coordenadaAtaque);

        sistema.imprimirResultadoAtaque(ResultadoAtaque);
    }
    /*public int recibirAtaque(String coordenada){
        LeerImprimir sistema =new LeerImprimir();
        Calculo cal = new Calculo();
        String oponente, recibirAtaque;
        
        String coordenadaAtaque = sistema.obtenerCoordAtaque();
        //String coordenadaAtaque = recibirAtaque(coordenadaAtaque):
        int resultadoAtaque = oponente.recibirAtaque(coordenadaAtaque);
        char x,y;
        int resultado =0;
    
        int xCoord = cal.obtenerX(coordenadaAtaque);
        int yCoord = cal.obtenerY(coordenadaAtaque);

        x = Character.toUpperCase(coordenada.charAt(0));
        y = coordenada.charAt(2);

        int xCoordenada=cal.obtenerX(coordenada);
        int yCoordenada=cal.obtenerY(coordenada);
        

        if (this.tabFlota[xCoordenada][yCoordenada]=='-'){
            resultado = 0;}
        else if (this.tabFlota[xCoordenada][yCoordenada]=='X'){
            resultado = 1;

        boolean Bahundido = true;
        for (int i = 0; i < this.tabFlota.length; i++) {
            for (int j = 0; j < this.tabFlota[i].length; j++) {
                if (this.tabFlota[i][j] == this.tabFlota[xCoordenada][yCoordenada]) {
                    Bahundido = false;
                    break;
                }
            }
            if (!Bahundido){
                break;
            }
        }
        if (Bahundido){
            resultado = 2;//Fue hundido
        }
        this.tabFlota[xCoordenada][yCoordenada] = 'X'; // marca el ataque en el tablero
    }
    return resultadoAtaque;
    }*/
    public int recibirAtaque(String coordenada) {
        LeerImprimir sistema = new LeerImprimir();
        Calculo cal = new Calculo();
        
        // Obtener coordenadas de ataque usando el parámetro del método
        int xCoordenada = cal.obtenerX(coordenada);
        int yCoordenada = cal.obtenerY(coordenada);
    
        int resultado = 0;
    
        if (this.tabFlota[xCoordenada][yCoordenada] == '-') {
            resultado = 0;
        } else if (this.tabFlota[xCoordenada][yCoordenada] == 'X') {
            resultado = 1;
    
            boolean barcoHundido = true;
            for (int i = 0; i < this.tabFlota.length; i++) {
                for (int j = 0; j < this.tabFlota[i].length; j++) {
                    if (this.tabFlota[i][j] == this.tabFlota[xCoordenada][yCoordenada]) {
                        barcoHundido = false;
                        break;
                    }
                }
                if (!barcoHundido) {
                    break;
                }
            }
            if (barcoHundido) {
                resultado = 2; // Fue hundido
            }
            this.tabFlota[xCoordenada][yCoordenada] = 'X'; // Marcar el ataque en el tablero
        }
    
        return resultado;
    }
    
    public boolean haperdido(){
        for (int i = 0; i < this.tabFlota.length; i++) {
            for (int j = 0; j < this.tabFlota[i].length; j++) {
                if (this.tabFlota[i][j] != '-' && this.tabFlota[i][j] != 'X') {
                    return false; //Todaía tiene barcos
                }
            }
        }
        return true; //Ya no tiene barcos       
    }
    public String getnombre(){
        return this.nombre;
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