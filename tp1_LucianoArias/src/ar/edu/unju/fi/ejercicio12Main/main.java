package ar.edu.unju.fi.ejercicio12Main;
import ar.edu.unju.fi.ejercicio12Model.Persona;
import java.util.Calendar;
import java.util.Scanner;

public class main {

	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		Persona Persona1 = new Persona();
		
		System.out.println("Ingresar nombre de la persona: ");
		String Nombre = scanner.nextLine();
		Persona1.setNombrePersona(Nombre);
		
		System.out.println("Ingresar fecha de nacimiento: ");
		String fechaStr = scanner.nextLine();
		
		 String[] partesFecha = fechaStr.split("/");
	     int dia = Integer.parseInt(partesFecha[0]);
	     int mes = Integer.parseInt(partesFecha[1])-1; 
	     int año = Integer.parseInt(partesFecha[2]);
	     Calendar fechaNacimiento = Calendar.getInstance();
	     fechaNacimiento.set(año, mes, dia);
	     
	     Persona1.setFechaNac(fechaNacimiento);
	     
	     Persona1.Mostradatos();
	     scanner.close();
	}

}
