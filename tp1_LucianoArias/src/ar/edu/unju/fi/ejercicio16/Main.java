package ar.edu.unju.fi.ejercicio16;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] nom=new String[5];
        for (int i=0; i<nom.length; i++){
            System.out.println("Ingrese un nombre " + (i + 1) + ":");
            nom[i]=scanner.nextLine();
        }
        System.out.println("Nombres ingresados: ");
        int ind=0;
        while (ind<nom.length){
            System.out.println("Nombre " + (ind + 1) + ": " + nom[ind]);
            ind++;
        }
        System.out.println("El array tiene un tamaño de: " + nom.length);
        byte indEliminar;
        do {
            System.out.println("Ingrese el índice del nombre a eliminar:");
            indEliminar=scanner.nextByte();
        } while (indEliminar<0 || indEliminar>=nom.length);
        for (int i=(int)indEliminar; i<nom.length-1; i++){
            nom[i]=nom[i+1];
        }
        nom[nom.length-1]=null; 
        System.out.println("Array después de eliminar el elemento:");
        for (String nombre : nom) {
            System.out.println(nombre);
        }
        scanner.close();
    }
}