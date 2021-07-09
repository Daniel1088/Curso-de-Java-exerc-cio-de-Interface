package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Services.ContractService;
import Services.PayPalService;

public class Program {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Contract Data:");
		System.out.print("Number:");
		int number= sc.nextInt();
		
		System.out.print("Date (dd/MM/yyyy):");
		Date date=sdf.parse(sc.next());
		
		System.out.print("Contract Value:");
		Double contratcValue= sc.nextDouble();
		
		Contract contract= new Contract(number, date, contratcValue);
		ContractService  cs= new ContractService(new PayPalService());
		
		System.out.print("Enter number of installments:");
		int n= sc.nextInt();
		
		cs.processContract(contract,n);
		
		System.out.print("Intalments");
		
		for(Installment i: contract.getInstallment())
		{
			System.out.println(i);
		}
		
		
		
		
		sc.close();

	}

}
