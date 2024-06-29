package ar.edu.unju.fi.ejercicio17Main;

import ar.edu.unju.fi.ejercicio17Model.Jugador;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner);

            try {
                switch (opcion) {
                    case 1:
                        altaJugador(scanner, jugadores);
                        break;
                    case 2:
                        mostrarDatosJugador(scanner, jugadores);
                        break;
                    case 3:
                        mostrarJugadoresOrdenadosPorApellido(jugadores);
                        break;
                    case 4:
                        modificarJugador(scanner, jugadores);
                        break;
                    case 5:
                        eliminarJugador(scanner, jugadores);
                        break;
                    case 6:
                        mostrarCantidadTotalJugadores(jugadores);
                        break;
                    case 7:
                        mostrarCantidadJugadoresPorNacionalidad(scanner, jugadores);
                        break;
                    case 8:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 8);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n*** Menú ***");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar datos del jugador");
        System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
        System.out.println("4 - Modificar datos de un jugador");
        System.out.println("5 - Eliminar un jugador");
        System.out.println("6 - Mostrar cantidad total de jugadores");
        System.out.println("7 - Mostrar cantidad de jugadores por nacionalidad");
        System.out.println("8 - Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.print("Ingrese un número entero válido: ");
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
    }

    private static void altaJugador(Scanner scanner, List<Jugador> jugadores) {
        System.out.println("\nAlta de jugador:");
        Jugador jugador = new Jugador();

        System.out.print("Nombre: ");
        jugador.setNombre(scanner.next());

        System.out.print("Apellido: ");
        jugador.setApellido(scanner.next());

        System.out.print("Fecha de Nacimiento (yyyy-MM-dd): ");
        jugador.setFechaNacimiento(LocalDate.parse(scanner.next()));

        System.out.print("Nacionalidad: ");
        jugador.setNacionalidad(scanner.next());

        System.out.print("Estatura (metros con ,): ");
        jugador.setEstatura(scanner.nextFloat());

        System.out.print("Peso (kg con ,): ");
        jugador.setPeso(scanner.nextFloat());

        System.out.print("Posición (delantero, medio, defensa, arquero): ");
        jugador.setPosicion(scanner.next());
        
        jugadores.add(jugador);
        System.out.println("Jugador agregado correctamente.");
    }

    private static void mostrarDatosJugador(Scanner scanner, List<Jugador> jugadores) {
        System.out.println("\nMostrar datos del jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        Jugador jugador = buscarJugador(nombre, apellido, jugadores);
        if (jugador != null) {
            System.out.println(jugador);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void mostrarJugadoresOrdenadosPorApellido(List<Jugador> jugadores) {
        System.out.println("\nJugadores ordenados por apellido:");
        jugadores.stream()
                .sorted(Comparator.comparing(Jugador::getApellido))
                .forEachOrdered(System.out::println);
    }

    private static void modificarJugador(Scanner scanner, List<Jugador> jugadores) {
        System.out.println("\nModificar datos de un jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        Jugador jugador = buscarJugador(nombre, apellido, jugadores);
        if (jugador != null) {
            jugadores.remove(jugador);
            altaJugador(scanner, jugadores);
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void eliminarJugador(Scanner scanner, List<Jugador> jugadores) {
        System.out.println("\nEliminar un jugador:");
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el apellido del jugador: ");
        String apellido = scanner.next();

        Jugador jugador = buscarJugador(nombre, apellido, jugadores);
        if (jugador != null) {
            jugadores.remove(jugador);
            System.out.println("Jugador eliminado correctamente.");
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    private static void mostrarCantidadTotalJugadores(List<Jugador> jugadores) {
        System.out.println("\nCantidad total de jugadores: " + jugadores.size());
    }

    private static void mostrarCantidadJugadoresPorNacionalidad(Scanner scanner, List<Jugador> jugadores) {
        System.out.print("\nIngrese la nacionalidad: ");
        String nacionalidad = scanner.next();
        long cantidad = jugadores.stream()
                                 .filter(jugador -> jugador.getNacionalidad().equalsIgnoreCase(nacionalidad))
                                 .count();

        System.out.println("Cantidad de jugadores de nacionalidad " + nacionalidad + ": " + cantidad);
    }
    
    private static Jugador buscarJugador(String nombre, String apellido, List<Jugador> jugadores) {
        try {
            return jugadores.stream()
                            .filter(jugador -> jugador.getNombre().equalsIgnoreCase(nombre)
                                           && jugador.getApellido().equalsIgnoreCase(apellido))
                            .findFirst()
                            .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }
}