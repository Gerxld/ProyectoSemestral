import java.io.*;

public class LeerImprimir {
    public void darBienvenida() {
        System.out.println("Bienvenido a Battleship!");
        System.out.println("Ubica tu flota, descubre las coordenadas de tu oponente y hunde sus barcos para ganar!");
    }

    public String ingresarNombre(int p) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nombre;
        System.out.println("Ingrese su nombre jugador " + p);
        nombre = reader.readLine();
        return nombre;
    }

    public void imprimirError() {
        System.out.println("Intentelo de nuevo!, las coordenadas se deben ingresar de esta manera: E,2");
    }

    public char imprimirUbicarFlota() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opcion;
        char ship;
        // boolean flotaLlena = false;
        System.out.println("Ubica tu flota\n¿Que deseas ubicar?");
        do {
            System.out.println("1. Lancha1 (tamaño 2)\n2. Lancha2 (tamaño 2)\n3. Buque (tamaño 3)\n4. Portaaviones (tamaño 4)");
            opcion = reader.readLine();
            switch (opcion) {
                case "1":
                case "2":
                    ship = '2';
                    break;

                case "3":
                    ship = '3';
                    break;

                case "4":
                    ship = '4';
                    break;

                default:
                    ship = '0';
                    System.out.println("La opción elegida no se encuentra");
                    break;
            }
        } while (ship == '0');
        return ship;
    }

    public String obtenerOrientacion() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String orientacion = "", op;
        do {
            System.out.println("Indique la orientación\n1. Vertical\n2. Horizontal");
            op = reader.readLine();
            if (op.equals("1")) {
                orientacion = "vertical";
            } else if (op.equals("2")) {
                orientacion = "horizontal";
            } else {
                System.out.println("Intentelo de Nuevo!");
            }
        } while (orientacion.equals(""));
        return orientacion;
    }

    public String obtenerCoordenadasBarco(String shipName, char ship, int tamaño) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculo cal = new Calculo();
        String coordenada;
        boolean esValido;
        System.out.println("Donde desea colocar su " + shipName + "?");
        System.out.println("Ingrese las coordenadas de esta manera: E,2");
        coordenada = reader.readLine();
        coordenada.substring(0, 2);
        esValido = cal.verificarCoordenadas(coordenada);
        while (esValido = false) {
            imprimirError();
            coordenada = reader.readLine();
        }
        return coordenada;
    }
}