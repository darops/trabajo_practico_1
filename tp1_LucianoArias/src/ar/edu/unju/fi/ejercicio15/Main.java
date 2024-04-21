package ar.edu.unju.fi.ejercicio15;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero que este entre el [5-10]: ");
        int tam=scanner.nextInt();
        if (tam>5 && tam<10){
            String[] Array=new String[tam];
            System.out.println("Ingrese un nombre con " + tam + " caracteres:");
            String entrada=scanner.next();
            if (entrada.length()==tam){
                for (int i=0; i<tam; i++){
                    Array[i]=Character.toString(entrada.charAt(i));
                }
                System.out.println("Nombre en Orden Normal");
                for (int i=0; i<tam; i++){
                    System.out.println("En el indice numero " + i + " esta almacenada la letra: " + Array[i]);
                }
                System.out.println("Nombre Al revez");
                for (int i=Array.length-1; i>=0; i--){	
                    System.out.println("En el indice " + i + " esta almacenada la letra: " + Array[i]);
                }
            }
            else {
            	System.out.println("Nombre fuera del rango");
            }
        } else {
            System.out.println("No esta dentro del rango del rango");
        }

     scanner.close();   
    }
}