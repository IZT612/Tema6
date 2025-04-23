package parte1.ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		String linea;
		int edad;
		double estatura;
		String nombre;
		String todo[];
		String nombres = "";
		double edadMedia = 0;
		double estaturaMedia = 0;
		int cont = 0;
		
		try (BufferedReader out = new BufferedReader(new FileReader("src\\parte1\\ejercicio3\\Alumnos"))){
			
			linea = out.readLine();
			
			while (linea != null) {
				todo = linea.split(" ");
				nombre = todo[0];
				edad = Integer.parseInt(todo[1]);
				estatura = Double.parseDouble(todo[2]);
				
				nombres += nombre + " ";
				edadMedia += edad;
				estaturaMedia += estatura;
				
				cont++;
				
				linea = out.readLine();			
			} 
			 
			System.out.println("Nombres: " + nombres);
			System.out.println("Edad media: " + (edadMedia / cont));
			System.out.println("Estatura media: " + (estaturaMedia / cont));
		
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
	}

}
