package parte1.ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		double suma = 0;
		double media = 0;
		int cont = 0;
		
		try (Scanner sc = new Scanner(new FileReader("src\\parte1\\ejercicio1\\NumerosReales"))) {
			
			while (sc.hasNextDouble()) {
				
				suma += sc.nextDouble();
				cont++;
				
			}
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		media = suma / cont;
		
		System.out.println("Suma: " + suma);
		System.out.println("Media: " + media);

	}

}
