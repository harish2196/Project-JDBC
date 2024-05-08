package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import dao.Validation;
import model.Product;

public class Viewproducts {

	public void viewById(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		ProductDbConnection db=new ProductDbConnection();
		CrudOperations crud=new CrudOperations();
		Product p = new Product();
		Validation v1 = new Validation();
		System.out.println("Enter 1 for View Laptops!");
		System.out.println("Enter 2 for View Mobiles!");
		System.out.println("Enter 3 for View Clothes!");
		System.out.println("Enter 0 to Exit!");
		System.out.println("Enter a Choice: ");
		int choice = sc.nextInt();
		switch ( choice) {

		case 1:
			crud.viewIndividual(1001, 1099);
			break;
		case 2:
			crud.viewIndividual(2001, 2099);
			break;
		case 3:
			crud.viewIndividual(3001, 3099);
			break;
		case 0:
			System.out.println("Exiting...");
			break;
		default:
			System.out.println("Invalid choice!");
			break;
		}
	}

}