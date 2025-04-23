package parte1.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		BufferedWriter in = new BufferedWriter(new FileWriter("src\\parte1\\ejercicio4\\ej4", true));
		
		String datos;
		
		boolean parar = false;
		
		System.out.println("Introduzca el dato a guardar.");
		datos = sc.nextLine();
		if (datos.equals("fin")) {
			
			parar = true;
			
		}
		
		while (!parar) {
			
			in.append(datos);
			System.out.println();
			
			System.out.println("Introduzca el dato a guardar.");
			datos = sc.nextLine();
			if (datos.equals("fin")) {
				
				parar = true;
				
			}
			in.newLine();
		}
		
		System.out.println("Saliendo del porgrama.");
		in.flush();
		in.close();
		sc.close();
		
	}

}
