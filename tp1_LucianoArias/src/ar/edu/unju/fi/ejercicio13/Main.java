package ar.edu.unju.fi.ejercicio13;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		final int CantE=8;
		int[] Array=new int[CantE];
		Scanner scanner=new Scanner(System.in);
		
		for(int i=0; i<CantE; i++){
			Array[i]=scanner.nextInt();
		}
		for(int i=0; i<CantE; i++){
			System.out.println("En el indice numero " + (i+1) + " esta almacenado el valor: " + Array[i]);
		}
		scanner.close();
	}

}