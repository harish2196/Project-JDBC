package dao;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

	public static int isNumeric(int input) throws IllegalArgumentException {
		Scanner sc=new Scanner(System.in);
		while (true) {
			try {
				input = sc.nextInt();
				if (input != 1 && input != 2 && input!=3) {
					System.out.println("Invalid Data");
					System.out.println("Please Re-enter Valid Choice:");
				}
				else
				{
					return input;
				}
			} catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("Enter Re-enter Admin ID:");
				sc.next(); 
			}
		}	
	}

	public static int isID() throws IllegalArgumentException {
		Scanner sc=new Scanner(System.in);
		while (true) {
			try {
				int input = sc.nextInt();
				if (input<=1000 || input>=10000) {
					System.out.println("Invalid Data");
					System.out.println("Please Re-enter Valid Choice:");
				}
				else
				{
					return input;
				}
			} catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("Enter Re-enter Admin ID:");
				sc.next(); 
			}
		}	
	}

	public static double isDouble(double input) throws IllegalArgumentException {
		Scanner sc=new Scanner(System.in);
		while (true) {
			try {
				input = sc.nextDouble();
				if (input<=500 || input>=1000000) {
					System.out.println("Price has been greater than >500");
					System.out.println("Please Re-enter Valid Choice:");
				}
				else
				{
					return input;
				}
			} catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("Enter Re-enter Admin ID:");
				sc.next(); 
			}
		}	
	}

	public static int isNumeric1(int input) throws IllegalArgumentException {
		Scanner sc=new Scanner(System.in);
		while (true) {
			try {
				input = sc.nextInt();
				if (input != 1 && input != 2) {
					System.out.println("Invalid Data");
					System.out.println("Please Re-enter Valid Choice:");
				}
				else
				{
					return input;
				}
			} catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("Enter Re-enter Admin ID:");
				sc.next(); 
			}
		}	
	}

	public boolean isNumerics(int input) {
		try {
			if(input<0) {
				System.out.println("Invalid Data");
				return false;
			}else {
				return true;
			}
		}catch(Exception e) {
			throw new IllegalArgumentException("Invalid Data. Please enter a valid numeric value.", e);
		}
	}


	public boolean isDle(double regNo1) {
		try {
			if(regNo1 < 0)
			{
				System.out.println("Invalid Data");
				return false;
			}else {
				return true;
			}
		}catch(Exception e) {
			throw new IllegalArgumentException("Invalid Data. Please enter a valid numeric value.", e);
		}
	}

	public static boolean validateString(String input) throws IllegalArgumentException {
		try {
			String regex = "^[a-zA-Z]+$";
			if(input.matches(regex)) {
				return true;
			}
		} catch(Exception e) {
			throw new IllegalArgumentException("Invalid Data. Please enter only letters (both uppercase and lowercase).", e);
		}
		return false;
	}


	public boolean longNumerics(long regNo1) {
		try {
			if(regNo1 < 0)
			{
				System.out.println("Invalid Data");
				return false;
			}else {
				return true;
			}
		}catch(Exception e){
			throw new IllegalArgumentException("Invalid Data. Please enter a valid numeric value.", e);
		}
	}

	public  boolean stringChecker(String s) 
	{
		try
		{
			Integer.parseInt(s);
			System.out.println("Dont use numbers");
			return false;
		}
		catch(Exception e){
			return true;
		}
	}

	public boolean isPassword(String password) {
		try {
			String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+.])(?=.*\\d).{8,}$";
			if (password.matches(regex)) {
				return true;
			} else {
				throw new IllegalArgumentException("Invalid Data. Please enter a valid Password.");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


	public boolean isSpecialChar(String input)
	{
		String specialCharRegex = "^[^a-zA-Z0-9]+[!@#$%^&*()]+$";
		if(Pattern.matches(specialCharRegex, input))
		{
			System.out.println("Invalid!.Dont use Special Characters");
			return false;
		}
		return true;
	}

	public boolean isLettersNumbers(String input) {
		try {
			String lettersNumbersPattern = "[a-zA-Z0-9]+";
			if (input.matches(lettersNumbersPattern)) {
				return true;
			} else {
				throw new IllegalArgumentException("Invalid! Don't use Special Characters");
			}
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
