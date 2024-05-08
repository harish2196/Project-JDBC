package test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;
import util.Admin;
import util.CrudOperations;
import util.Customer;
import util.ProductDbConnection;
import util.ProductList;
import dao.*;
public class ProductMain {
	public static void main(String[] args) throws SQLException{
		Scanner sc = new Scanner(System.in); 
		UserRegister ur=new UserRegister();
		Product p = new Product();
		String choose;
		Admin admin=new Admin();
		ProductList productlist=new ProductList();
		ProductDbConnection db=new ProductDbConnection();
		Validation v1=new Validation();
		CrudOperations crud=new CrudOperations();
		Customer customer=new Customer();
		int choice = 0;
		while(true) {
			System.out.println("1.Admin");
			System.out.println("2.Customer");
			System.out.println("3.Exiting...");
			System.out.println("Enter choice: ");
			choice = v1.isNumeric(choice);
				switch(choice) {
				case 1:
				admin.admin();
					break;
				case 2:
					customer.isCustomer();
					break;
				case 3:
					System.out.println("Exiting...");
					continue;
				default:
					System.out.println("Invalid choice!");
					break;
				}
			}
		}
	
}

