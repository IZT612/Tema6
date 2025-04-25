package parte1.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		BufferedWriter out = new BufferedWriter(new FileWriter("src\\parte1\\ejercicio7\\agenda.txt", true));

		HashSet<String> agenda = new HashSet<String>();
		
		String linea;
		
		try (BufferedReader in = new BufferedReader(new FileReader("src\\parte1\\ejercicio7\\agenda.txt"))) {
			
			linea = in.readLine();			
			
			while (linea != null && !linea.equals("")) {
				
				agenda.add(linea);
				linea = in.readLine();
				
			}
			
		} catch (FileNotFoundException e) {
			
			FileWriter f;
			
			try {
				
				f = new FileWriter("src\\parte1\\ejercicio7d\\agenda.txt");
				f.close();
				
			} catch (IOException e1) {
				
				System.out.println(e.getLocalizedMessage());
				
			}
			
		}

		int opcion;
		String nombre;
		int numero;

		do {

			System.out.println("Introduzca alguna de las siguientes opciones:");
			System.out.println("1. Nuevo contacto.");
			System.out.println("2. Buscar por nombre.");
			System.out.println("3. Mostrar todos.");
			System.out.println("4. Guardar y salir.");
			opcion = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (opcion) {

			case 1 -> {

				String datos;
				boolean encontrado = false;

				System.out.println("Introduzca el nombre y el número respectivamente:");
				nombre = sc.nextLine();
				numero = sc.nextInt();
				sc.nextLine();

				for (String contacto : agenda) {

					if (contacto.substring(0, contacto.indexOf(' ')).equals(nombre)) {

						encontrado = true;

					}

				}

				if (!encontrado) {

					datos = nombre + " " + numero;

					agenda.add(datos);
					out.append(datos);
					out.newLine();
					
				} else if (encontrado) {
					
					System.out.println("Este contacto ya existe.");
					
				} else if (agenda.size() == 20) {
					
					System.out.println("La agenda está llena.");
					
				}
				
			}

			case 2 -> {

				String nombreBuscar;
				String nombreContacto;
				boolean encontrado = false;

				System.out.println("Introduzca el nombre a buscar.");
				nombreBuscar = sc.nextLine();

				for (String contacto : agenda) {

					nombreContacto = contacto.substring(0, contacto.indexOf(' '));

					if (nombreBuscar.equals(nombreContacto)) {

						System.out.println();
						System.out.println(nombreContacto + ": " + contacto.substring(contacto.indexOf(' ') + 1));
						encontrado = true;

					}

				}

				if (!encontrado) {

					System.out.println();
					System.out.println("No se ha encontrado el contacto.");

				}

			}

			case 3 -> {

				System.out.println();
				for (String contacto : agenda) {

					System.out.println(contacto.substring(0, contacto.indexOf(' ')) + ": "
							+ contacto.substring(contacto.indexOf(' ') + 1));

				}

			}

			}

			System.out.println();

		} while (opcion != 4);

		System.out.println("Saliendo del programa.");

		out.flush();
		out.close();

		sc.close();

	}

}
