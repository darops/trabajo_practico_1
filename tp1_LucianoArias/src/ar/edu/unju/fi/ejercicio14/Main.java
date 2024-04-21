package ar.edu.unju.fi.ejercicio14;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Ingrese un numero que este entre el [3-10]: ");
		int Cant=scanner.nextInt();
		if (Cant>3 && Cant<8) {
			int[] Array=new int[Cant];
			for(int i=0; i<Cant; i++){
				Array[i]=scanner.nextInt();
			}
			
			for(int i=0; i<Cant; i++){
				System.out.println("En el indice numero " + (i+1) + " esta almacenado el valor: " + Array[i]);
			}
			int Suma=0;
			for(int i=0; i<Cant; i++){
				Suma+=Array[i];
			}
			System.out.println("La suma total es: " + Suma);
		}
		else {
			System.out.println("El numero no esta dentro del rango");
		}
		scanner.close();
	}

}