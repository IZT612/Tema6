package parte1.ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		String nombre;
		int numero;
		
		do {
			
			System.out.println("Introduzca alguna de las siguientes opciones:");
			System.out.println("1. Nuevo contacto.");
			System.out.println("2. Buscar por nombre.");
			System.out.println("3. Mostrar todos.");
			System.out.println("4. Salir.");
			opcion = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch(opcion) {
			
			case 1 -> {
				
				System.out.println("Introduzca el nombre.");
				nombre = sc.nextLine();
				System.out.println("Ahora el número.");
				numero = sc.nextInt();
				System.out.println();
				
				if(nuevoContacto(nombre, numero)) {
					
					System.out.println("Se ha creado el contacto correctamente.");
					
				} else {
					
					System.out.println("La agenda está llena o ese contacto ya existe.");
					
				}
				
				
			}
			
			case 2 -> {
				
				System.out.println("Introduzca el nombre del contacto a buscar.");
				nombre = sc.nextLine();
				numero = buscarNombre(nombre);
				
				if (numero != -1) {
					
					System.out.println(nombre + ": " + numero);
					
				} else {
					
					System.out.println("No se ha encontrado ningún contacto con ese nombre.");
					
				}
				
			}
			
			case 3 -> {
				
				System.out.println(mostrarTodos());
				
			}
			
			
			}
			
			System.out.println();
			
		} while (opcion != 4);
		
		System.out.println("Saliendo del programa.");
		
		sc.close();

	}
	
	static public String mostrarTodos() {
		
		String contactos = "";
		
		String linea;
		String[] datosLinea;
		
		try(BufferedReader out = new BufferedReader(new FileReader("src\\parte1\\ejercicio7\\agenda.txt"))) {
			
			linea = out.readLine();
			while (linea != null && !linea.equals("")) {
				
				datosLinea = linea.split(" ");
				contactos += datosLinea[0] + ": " + datosLinea[1] + "\n";
				linea = out.readLine();
				
			}
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		// Para eliminar el ultimo "\n"
		contactos = contactos.substring(0, (contactos.length() - 2));
		
		return contactos;
		
	}
	
	static public boolean nuevoContacto(String nombre, int numero) {
		
		boolean conseguido = true; 
		
		if (!estaLleno() && !nombreExistente(nombre)) {
			
			try(BufferedWriter in = new BufferedWriter(new FileWriter("src\\parte1\\ejercicio7\\agenda.txt", true))) {
				
				in.append(nombre + " " + numero);
				in.newLine();
				in.flush();
				in.close();
				
			} catch (IOException e) {
				
				System.out.println(e.getLocalizedMessage());
				conseguido = false;
			}
			
		} else {
			
			conseguido = false;
			
		}
		
		return conseguido;
		
	}
	
	static public int buscarNombre(String nombre) {
		
		int numero = -1;
		
		String linea;
		String[] datosLinea;
		
		try(BufferedReader out = new BufferedReader(new FileReader("src\\parte1\\ejercicio7\\agenda.txt"))) {
			
			linea = out.readLine();
			
			while(numero == -1 && linea != null && !linea.equals("")) {
				
				datosLinea = linea.split(" ");
				if (datosLinea[0].equals(nombre)) {
					
					numero = Integer.parseInt(datosLinea[1]);
					
				}
				linea = out.readLine();
				
			}
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		return numero;
		
	}
	
	static public boolean estaLleno() {
		
		boolean lleno = false;
		
		int contador = 0;
		String linea;
		
		try(BufferedReader out = new BufferedReader(new FileReader("src\\parte1\\ejercicio7\\agenda.txt"))) {
			
			linea = out.readLine();
			
			while(linea != null && !linea.equals("")) {
				
				contador++;
				linea = out.readLine();
				
			}
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		if (contador == 20) {
			
			lleno = true;
			
		}
		
		return lleno;
		
	}
	
	static public boolean nombreExistente(String nombre) {
		
		boolean encontrado = false;
		
		String linea;
		String[] datosLinea;
		
		try(BufferedReader out = new BufferedReader(new FileReader("src\\parte1\\ejercicio7\\agenda.txt"))) {
			
			linea = out.readLine();
			
			while(!encontrado && linea != null && !linea.equals("")) {
				
				datosLinea = linea.split(" ");
				if (datosLinea[0].equals(nombre)) {
					
					encontrado = true;
					
				}
				linea = out.readLine();
				
			}
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		return encontrado;
		
	}

}
