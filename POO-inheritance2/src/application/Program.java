package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		List<TaxPayer> taxpayer = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if (c == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				taxpayer.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (c == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxpayer.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double sum = 0;
		for (TaxPayer p: taxpayer) {
			System.out.println(p);
			sum += p.tax();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f%n", sum);
		
		sc.close();
	}

}
