package parte1.ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		String linea;
		
		try(BufferedReader out = new BufferedReader(new FileReader("src\\parte1\\ejercicio6\\numerosDesordenados.txt"))) {
			
			linea = out.readLine();
			
			while(linea != null) {
				
				nums.add(Integer.parseInt(linea));
				linea = out.readLine();				
			}
		
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		nums.sort(null);
		
		try(BufferedWriter in = new BufferedWriter(new FileWriter("src\\parte1\\ejercicio6\\numerosOrdenados.txt", true))) {
			
			for(int numero: nums) {
				
				in.append("" + numero);
				in.newLine();
				
			}
			
			in.flush();
			in.close();
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		} catch (IOException e) {
			
			System.out.println(e.getLocalizedMessage());
			
		}
		
		System.out.println("Saliendo del programa.");

	}

}
