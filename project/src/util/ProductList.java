package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import dao.*;
import dao.Validation;
import model.Product;

public class ProductList {

	public void list(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		ProductDbConnection db=new ProductDbConnection();
		CrudOperations crud=new CrudOperations();
		Product p = new Product();
		Validation v1 = new Validation();
		System.out.println("Enter 1 for Add Laptops!");
		System.out.println("Enter 2 for Add Mobiles!");
		System.out.println("Enter 3 for Add Clothes!");
		System.out.println("Enter 0 to Exit!");
		System.out.println("Enter a Choice: ");
		int choice = sc.nextInt();
		switch ( choice) {
		
		case 1:
			crud.addLaptops(db.getConnection(), p);
			break;
		case 2:
			crud.addClothes(db.getConnection(), p);
			break;
		case 3:
			crud.addMobiles(db.getConnection(),p);
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