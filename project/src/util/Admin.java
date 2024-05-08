package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import dao.Validation;
import model.Product;
import model.UserRegister;
import util.ProductList;

public class Admin {
	public void admin() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Validation v1 = new Validation();
		Viewproducts view=new Viewproducts();
		Product p = new Product();
		String choose;
		ProductDbConnection db=new ProductDbConnection();
		CrudOperations crud=new CrudOperations();
		UserRegister ur=new UserRegister();
		ProductList productList=new ProductList();

		while (true) {
			System.out.println("Do you have any Account in our Store? (Yes or No)");
			choose = sc.nextLine().toLowerCase();
			while (!choose.equals("yes") && !choose.equals("no")) {
				System.err.println("Please Re-enter Valid Input:");
				choose = sc.nextLine().toLowerCase();
			}		

			int id = 0;
			System.out.println("Enter Admin ID:");
			id=v1.isNumeric1(id);

			if(id==1 || id==2) {
				if(choose.equals("yes")) {
					Connection connection = db.getConnection();
					System.out.println("Please Log In!");
					boolean validName = false;
					while (!validName) {
						System.out.println("Enter The Name: ");
						String name = sc.next();
						crud.getUserPassword(connection, ur);
						if (name.equals(ur.getName())) {
							validName = true;
						} else {
							System.out.println("Invalid name. Please re-enter.");
						}
					}

					boolean loggedIn = false;
					while (!loggedIn) {
						System.out.println("Enter The Password: ");
						String pass = sc.next();
						if (pass.equals(ur.getPassword())) {
							System.out.println("Login successful!");
							loggedIn = true;
						} else {
							System.out.println("Invalid password. Please try again.");
						}
					}

				}

				else if(choose.equals("no")) {
					System.out.println("Please Sign Up");	
					System.out.println("Enter UserName:");
					String userName = sc.next();
					while(!v1.isLettersNumbers(userName)) {
						System.out.println("Please Re-enter UserName:");
						userName = sc.next();
					}				
					ur.setName(userName);
					System.out.println("Enter PassWord:");
					String passWord = sc.next();
					while(!v1.isPassword(passWord)){
						System.out.println("Please Re-enter Password:");
						passWord = sc.next();
					}
					ur.setPassword(passWord);
					Connection connection = db.getConnection();
					crud.insertUser(connection,ur);
					System.out.println("Signed Successfully!");


					System.out.println("Please Log In!");
					boolean validName = false;
					String name = "";
					while (!validName) {
						System.out.println("Enter The Name: ");
						name = sc.next();

						crud.getUserPassword(connection, ur);
						if (name.equals(ur.getName())) {
							validName = true;
						} else {
							System.out.println("Invalid name. Please re-enter.");
						}
					}

					boolean loggedIn = false;
					while (!loggedIn) {
						System.out.println("Enter The Password: ");
						String pass = sc.next();
						crud.getUserPassword(connection, ur);
						if (pass.equals(ur.getPassword())) {
							System.out.println("Login successful!");
							loggedIn = true;
						} else {
							System.out.println("Invalid password. Please try again.");
						}
					}
				}
			}

			while(true) {
				System.out.println("Welcome to our store!");
				System.out.println("What product would you like to get?");
				System.out.println("Welcome to Product Manager");
				System.out.println("1. Add Product");
				System.out.println("2. View Products");
				System.out.println("3. Retrieve Product by ID");
				System.out.println("4  Update Products by ID");
				System.out.println("5. Deleting Products by ID");
				System.out.println("6. Exiting...");

				int choice;
				System.out.println("Enter your choice:");		
				choice = sc.nextInt();
				if(!v1.isNumerics(choice)) {
					System.out.println("Please Re-Enter your Choice:");
					choice = sc.nextInt();
				}
				sc.nextLine(); 

				switch (choice){
				case 1:
					productList.list(db.getConnection());
					break;
				case 2:
					view.viewById(db.getConnection());
					break;
				case 3:
					try {
						crud.retrieveProducts(db.getConnection());
					} catch(SQLException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					try {
						crud.updateProducts(db.getConnection());
					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						crud.deleteProducts(db.getConnection());
					}catch(SQLException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid choice!");
					return;
				}

			}
		}
	}
}
