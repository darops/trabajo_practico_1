package ar.edu.unju.fi.ejercicio18Main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio18Model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18Model.Pais;

public class Main {
    private static final String[] CODIGOS_PAISES = {"Ar-0000", "Br-0001", "Mx-0002", "EC-0003", "PE-0004", "UR-0005"};

    private static ArrayList<Pais> paises = new ArrayList<>();
    private static ArrayList<DestinoTuristico> destinos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            inicializarPaises();

            int opcion;
            do {
                mostrarMenu();
                opcion = solicitarEntero("Ingrese una opción: ");
                switch (opcion) {
                    case 1:
                        altaDestino();
                        break;
                    case 2:
                        mostrarDestinos();
                        break;
                    case 3:
                        modificarPaisDestino();
                        break;
                    case 4:
                        limpiarDestinos();
                        break;
                    case 5:
                        eliminarDestino();
                        break;
                    case 6:
                        mostrarDestinosOrdenados();
                        break;
                    case 7:
                        mostrarPaises();
                        break;
                    case 8:
                        mostrarDestinosPorPais();
                        break;
                    case 9:
                        System.out.println("Fin del programa");
                        break;
                    default:
                        System.out.println("Opción fuera del rango");
                        break;
                }
            } while (opcion != 9);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void inicializarPaises() {
        for (String codigo : CODIGOS_PAISES) {
            paises.add(new Pais(codigo, obtenerNombrePais(codigo)));
        }
    }

    private static String obtenerNombrePais(String codigoPais) {
        switch (codigoPais) {
            case "Ar-0000":
                return "Argentina";
            case "Br-0001":
                return "Brasil";
            case "Mx-0002":
                return "México";
            case "EC-0003":
                return "Ecuador";
            case "PE-0004":
                return "Perú";
            case "UR-0005":
                return "Uruguay";
            default:
                return "Nombre del país";
        }
    }

    private static void mostrarMenu() {
        System.out.println("***Menu***");
        System.out.println("1-Alta de destino turístico");
        System.out.println("2-Mostrar todos los destinos turísticos.");
        System.out.println("3-Modificar el país de un destino turístico.");
        System.out.println("4-Limpiar el ArrayList de destino turísticos");
        System.out.println("5-Eliminar un destino turístico");
        System.out.println("6-Mostrar los destinos turísticos ordenados por nombre");
        System.out.println("7-Mostrar todos los países");
        System.out.println("8-Mostrar los destinos turísticos que pertenecen a un país");
        System.out.println("9-Salir");
    }

    private static int solicitarEntero(String mensaje) {
        int numero = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: entrada no válida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar el buffer del Scanner
            }
        } while (!entradaValida);
        return numero;
    }
    
    private static void altaDestino() {
        DestinoTuristico destino = new DestinoTuristico();

        try {
            System.out.println("Ingrese el nombre del destino turístico: ");
            scanner.nextLine(); // Consumir el salto de línea pendiente
            destino.setNombre(scanner.nextLine());

            System.out.println("Ingrese el código del destino turístico: ");
            destino.setCodigo(scanner.nextLine());

            System.out.println("Ingrese el precio del destino turístico: ");
            destino.setPrecio(scanner.nextDouble());
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.println("Seleccione el país del destino turístico: ");
            mostrarPaises();
            int indexPais = solicitarEntero("Ingrese el número correspondiente al país: ");
            destino.setPais(paises.get(indexPais - 1));

            boolean entradaValida = false;
            do {
                try {
                    System.out.println("Ingrese la cantidad de días del destino turístico: ");
                    scanner.nextLine(); // Consumir el salto de línea pendiente
                    int cantDias = Integer.parseInt(scanner.nextLine());
                    destino.setCantDias(cantDias);
                    entradaValida = true;
                } catch (NumberFormatException e) {
                    System.out.println("Error: entrada no válida. Por favor, ingrese un valor entero válido.");
                }
            } while (!entradaValida);

            destinos.add(destino);
            System.out.println("Destino turístico agregado correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: entrada no válida. Por favor, ingrese un valor válido.");
        }
    }


    private static void mostrarDestinos() {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos para mostrar.");
        } else {
            System.out.println("Destinos Turísticos:");
            for (int i = 0; i < destinos.size(); i++) {
                System.out.println((i + 1) + ". " + destinos.get(i).getNombre());
            }
        }
    }

    private static void modificarPaisDestino() {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos para modificar.");
        } else {
            mostrarDestinos();
            int indexDestino = solicitarEntero("Ingrese el número correspondiente al destino turístico a modificar: ");
            DestinoTuristico destino = destinos.get(indexDestino - 1);

            System.out.println("Seleccione el nuevo país del destino turístico: ");
            mostrarPaises();
            int indexPais = solicitarEntero("Ingrese el número correspondiente al país: ");
            destino.setPais(paises.get(indexPais - 1));

            System.out.println("País modificado correctamente para el destino turístico " + destino.getNombre());
        }
    }

    private static void limpiarDestinos() {
        destinos.clear();
        System.out.println("Lista de destinos turísticos limpiada correctamente.");
    }

    private static void eliminarDestino() {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos para eliminar.");
        } else {
            mostrarDestinos();
            int indexDestino = solicitarEntero("Ingrese el número correspondiente al destino turístico a eliminar: ");
            DestinoTuristico destino = destinos.remove(indexDestino - 1);
            System.out.println("Destino turístico \"" + destino.getNombre() + "\" eliminado correctamente.");
        }
    }

    private static void mostrarDestinosOrdenados() {
        if (destinos.isEmpty()) {
            System.out.println("No hay destinos turísticos para mostrar.");
        } else {
            destinos.sort(Comparator.comparing(DestinoTuristico::getNombre));
            System.out.println("Destinos Turísticos Ordenados por Nombre:");
            for (DestinoTuristico destino : destinos) {
                System.out.println("- " + destino.getNombre());
            }
        }
    }

    private static void mostrarPaises() {
        if (paises.isEmpty()) {
            System.out.println("No hay países para mostrar.");
        } else {
            System.out.println("Países Disponibles:");
            for (int i = 0; i < paises.size(); i++) {
                System.out.println((i + 1) + ". " + paises.get(i).getNombre());
            }
        }
    }

    private static void mostrarDestinosPorPais() {
        if (paises.isEmpty() || destinos.isEmpty()) {
            System.out.println("No hay países o destinos turísticos para mostrar.");
        } else {
            mostrarPaises();
            int indexPais = solicitarEntero("Ingrese el número correspondiente al país: ");
            Pais pais = paises.get(indexPais - 1);

            System.out.println("Destinos Turísticos en " + pais.getNombre() + ":");
            for (DestinoTuristico destino : destinos) {
                if (destino.getPais().equals(pais)) {
                    System.out.println("- " + destino.getNombre());
                }
            }
        }
    }
}