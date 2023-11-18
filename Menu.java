// Integrantes: Simon Espino, Gerald Ríos, Javier Reyes y Jirak Anria

import java.io.*;

public class Menu {
    public static void main(String[] args) throws IOException  {
        try {
            // Tenemos 2 clases aparte del main: LeerImprimir y Calculo
            // En este archivo solo se llaman a los metodos a partir de los objetos sistema o cal

            // Declaracion de variables
            LeerImprimir sistema = new LeerImprimir();
            Calculo cal = new Calculo();

            // Proceso

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
        }
    }
}