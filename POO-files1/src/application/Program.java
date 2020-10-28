package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String path = sc.nextLine();
		
		File file = new File(path);
		path = file.getParent();
		
		boolean success = new File(path + "\\out").mkdir();
		
		String path2 = path + "\\out\\summary.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String item = br.readLine();
			while (item != null) {

				String[] fields = item.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				item = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {

				for (Product l : list) {
					bw.write(l.getName() + "," + String.format("%.2f", l.total()));
					bw.newLine();
				}

				System.out.println(path2 + " CREATED!");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		sc.close();
	}

}
