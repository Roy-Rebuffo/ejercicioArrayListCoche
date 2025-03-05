/*
Tenemos una Clase Vehículo que contiene: 

Matrícula(4 núm 3 Dígitos) 
Marca 
Modelo
Año matriculación
Número reparación (cuántas veces ha entrado a reparación)

Estamos en un taller y lo que queremos saber es las reparaciones que tienen los coches.

Meter CUANDO ENTRA UN COCHE A REPARAR => La matrícula, modelo, marca. El NÚMERO DE REPARACIÓN es automática me tiene que decir cual es. (¿Contador?)

=====> Usamos ArrayList !!!

Si Matricula/marca/modelo/año matriculación son iguales => Numero de reparación ++

Significa que el coche ha venido otra vez entonces sumamos +1 al número de reparacion.
 */
package ejercicioarrayscoche;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioArraysCoche {

    //Usamos arraylist
    private static ArrayList<Vehiculo> reparacion = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void reparar(Scanner dato) {

        System.out.println("\n=================================");
        System.out.println("Introduzca los datos del vehiculo a reparar: ");
        System.out.println("=================================");
        System.out.print("Introduzca la MATRICULA de su vehiculo: ");
        String matricula = dato.next();
        System.out.print("Introduzca la MARCA de su vehiculo: ");
        String marca = dato.next();
        System.out.print("Introduzca el MODELO de su vehiculo: ");
        String modelo = dato.next();
        System.out.print("Introduzca el ano de matriculacion: ");
        String matriculacion = dato.next();

        // Buscar si el vehículo ya ha sido registrado
        boolean encontrado = false;

        for (Vehiculo vehiculo : reparacion) {
            if (vehiculo.getMatricula().equals(matricula)
                    && vehiculo.getMarca().equals(marca)
                    && vehiculo.getModelo().equals(modelo)
                    && vehiculo.getMatriculacion().equals(matriculacion)) {

                vehiculo.incrementarReparacion();//Metodo que tenemos para aumentar la reparacion
                System.out.println("\n Vehiculo ya registrado. Numero de "
                        + "reparaciones actualizado: " + vehiculo.getNumeroReparacion());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            // Si el vehículo no existe en la lista, lo agregamos con número de reparación = 1
            Vehiculo nuevoVehiculo = new Vehiculo(matricula, marca, modelo, matriculacion, 1);
            reparacion.add(nuevoVehiculo);
            System.out.println("\n Nuevo vehiculo registrado en el taller. "
                    + "Numero de reparaciones: 1");
        }

    }

    public static void verHistorial() {
        System.out.println("\n=================================");
        System.out.println(" HISTORIAL DE VEHICULOS REPARADOS ");
        System.out.println("=================================");

        if (reparacion.isEmpty()) {
            System.out.println("No hay vehiculos en el historial.");
        } else {
            for (Vehiculo v : reparacion) {
                System.out.println(v);
                System.out.println("---------------------------------");
            }
        }
    }

    //Menú principal
    public static void menu() {
        Scanner dato = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {//estructura MIENTRAS
            System.out.println("");
            System.out.println("");
            System.out.println("=================================");
            System.out.println("  BIENVENIDO AL TALLER MECANICO  ");
            System.out.println("=================================");
            System.out.println("  1. Reparar un coche");
            System.out.println("  2. Ver historial de reparaciones");
            System.out.println("  0. Salir");
            System.out.println("=================================");
            System.out.print("Seleccione una opcion: ");
            opcion = dato.nextInt();
            switch (opcion) {//estructura CONDICIONAL MÚLTIPLE
                case 1:
                    reparar(dato);
                    break;
                case 2:
                    verHistorial();
                    break;
                case 0:
                    System.out.println("\n[Saliendo del taller...]");
                    break;
                default:
                    System.out.println("Elija un número entre 1 y 2, en caso de salir 0.");
                    break;
            }
            for (int i = 1; i <= 3; i++) {//estructura PARA
                System.out.println("");
            }
        }
    }

}
