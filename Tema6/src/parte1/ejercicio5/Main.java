package parte1.ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		String nombre;
		int edad;
		
		System.out.println("Introduzca su nombre.");
		nombre = sc.nextLine();
		
		System.out.println("Ahora su edad.");
		edad = sc.nextInt();
		sc.nextLine();
		
		try (BufferedWriter in = new BufferedWriter(new FileWriter("src\\parte1\\ejercicio5\\datos.txt", true))) {
			
			in.append(nombre + " " + edad);
			in.newLine();
			in.flush();
			in.close();
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}

		System.out.println("Saliendo del programa.");
		
		sc.close();
		
	}

}
