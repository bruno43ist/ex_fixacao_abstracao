package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<TaxPayer> payers = new ArrayList<>();
		
		System.out.println("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + "data: ");
			System.out.println("Individual or Company (i/c)? ");
			char c = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Anual income: ");
			Double anualIncome = sc.nextDouble();
			if(c == 'i') {
				System.out.println("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				TaxPayer e = new Individual(name, anualIncome, healthExpenditures);
				payers.add(e);
			} else {
				System.out.println("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				TaxPayer e = new Company(name, anualIncome, numberOfEmployees);	
				payers.add(e);
			}
		}
		
		System.out.println();

		double sum = 0.0;
		System.out.println("TAXES PAID: ");
		
		for(TaxPayer c :  payers) {
			double tax = c.tax();
			System.out.println(c.getName() + ": $ " + String.format("%.2f", tax));
			sum += tax;
		}
		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();

	}

}
