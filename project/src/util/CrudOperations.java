package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dao.ProductDAO;
import dao.Validation;
import model.Product;
import model.UserRegister;

public class CrudOperations implements ProductDAO{

	public  Product addLaptops(Connection connection, Product p) throws SQLException {
		String insertion = "INSERT INTO products (id, Name, Model, price) VALUES (?, ?, ?, ?)";
		Scanner sc = new Scanner(System.in);
		Validation v1 = new Validation();
		PreparedStatement preparedStatement = connection.prepareStatement(insertion);
		System.out.println("Enter ID:");
		
		int id= v1.isID();

		if (isExistsId(connection, id)) {
			System.out.println("ID already exists. Please Re-Enter your ID:");
			System.out.println("Please Re-Enter your ID:");
			id = sc.nextInt();

		}
		preparedStatement.setInt(1, id);
		p.setId(id);


		System.out.println("Enter Name:");
		String name = sc.next();
		while (!v1.validateString(name)) {
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		if(isExistsName(connection, name)) {
			System.out.println("Name already exists.Please use different Name.");
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		preparedStatement.setString(2, name);
		p.setName(name);

		System.out.println("Enter Model:");
		String model = sc.next();
		while (!v1.isLettersNumbers(model)) {
			System.out.println("Please Re-Enter your Model:");
			model = sc.next();
		}
		preparedStatement.setString(3, model);
		p.setModel(model);

		System.out.println("Enter Price:");
		double price = 0;
		price=v1.isDouble(price);
		preparedStatement.setDouble(4, price);
		p.setPrice(price);

		int executeUpdate = preparedStatement.executeUpdate();
		System.out.println(executeUpdate);
		System.out.println("Data inserted successfully.");
		System.out.println(p);
		return p;
	}


	public  Product addClothes(Connection connection, Product p) throws SQLException {
		String insertion = "INSERT INTO products (id, Name, Model, price) VALUES (?, ?, ?, ?)";
		Scanner sc = new Scanner(System.in);
		Validation v1 = new Validation();
		PreparedStatement preparedStatement = connection.prepareStatement(insertion);
		System.out.println("Enter ID:");
		
		int id= v1.isID();

		if (isExistsId1(connection, id)) {
			System.out.println("ID already exists. Please Re-Enter your ID:");
			System.out.println("Please Re-Enter your ID:");
			id = sc.nextInt();

		}
		preparedStatement.setInt(1, id);
		p.setId(id);


		System.out.println("Enter Name:");
		String name = sc.next();
		while (!v1.validateString(name)) {
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		if(isExistsName1(connection, name)) {
			System.out.println("Name already exists.Please use different Name.");
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		preparedStatement.setString(2, name);
		p.setName(name);

		System.out.println("Enter Model:");
		String model = sc.next();
		while (!v1.isLettersNumbers(model)) {
			System.out.println("Please Re-Enter your Model:");
			model = sc.next();
		}
		preparedStatement.setString(3, model);
		p.setModel(model);

		System.out.println("Enter Price:");
		double price = 0;
		price=v1.isDouble(price);
		preparedStatement.setDouble(4, price);
		p.setPrice(price);

		int executeUpdate = preparedStatement.executeUpdate();
		System.out.println(executeUpdate);
		System.out.println("Data inserted successfully.");
		System.out.println(p);
		return p;
	}

	public  Product addMobiles(Connection connection, Product p) throws SQLException {
		String insertion = "INSERT INTO products (id, Name, Model, price) VALUES (?, ?, ?, ?)";
		Scanner sc = new Scanner(System.in);
		Validation v1 = new Validation();
		PreparedStatement preparedStatement = connection.prepareStatement(insertion);
		System.out.println("Enter ID:");
		int id= v1.isID();

		if (isExistsId(connection, id)) {
			System.out.println("ID already exists. Please Re-Enter your ID:");
			System.out.println("Please Re-Enter your ID:");
			id = sc.nextInt();

		}
		preparedStatement.setInt(1, id);
		p.setId(id);


		System.out.println("Enter Name:");
		String name = sc.next();
		while (!v1.validateString(name)) {
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		if(isExistsName(connection, name)) {
			System.out.println("Name already exists.Please use different Name.");
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		preparedStatement.setString(2, name);
		p.setName(name);

		System.out.println("Enter Model:");
		String model = sc.next();
		while (!v1.isLettersNumbers(model)) {
			System.out.println("Please Re-Enter your Model:");
			model = sc.next();
		}
		preparedStatement.setString(3, model);
		p.setModel(model);

		System.out.println("Enter Price:");
		double price = 0;
		price=v1.isDouble(price);
		preparedStatement.setDouble(4, price);
		p.setPrice(price);

		int executeUpdate = preparedStatement.executeUpdate();
		System.out.println(executeUpdate);
		System.out.println("Data inserted successfully.");
		System.out.println(p);
		return p;
	}


	public void insertUser(Connection connection,UserRegister ur) throws SQLException {
		String user="insert into user_register(name,password)values(?,?)";
		PreparedStatement ps = connection.prepareStatement(user);
		ps.setString(1,ur.getName());
		ps.setString(2,ur.getPassword());
		int rows=ps.executeUpdate();
		System.out.println(rows + ":" +" inserted");
	}
	
    

	public void getUserPassword(Connection connection,UserRegister ur) throws SQLException {
		String userpass="select id,name,password from user_register";
		Statement stmt=connection.createStatement();
		ResultSet rs=stmt.executeQuery(userpass);
		while(rs.next()) {
			ur.setId(rs.getInt(1));
			ur.setName(rs.getString(2));
			ur.setPassword(rs.getString(3));
		}
	}

	public boolean isExistsId(Connection connection, int id) throws SQLException {
		String countID = "SELECT COUNT(*) FROM products WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(countID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int count = resultSet.getInt(1);
		return count > 0;
	}

	public  boolean isExistsName(Connection connection, String name) throws SQLException {
		String countName = "SELECT COUNT(*) FROM products WHERE name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(countName);
		preparedStatement.setString(1, name); 
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int count = resultSet.getInt(1); 
		return count > 0;
	}

	public boolean isUsernameExists(Connection connection, String username) throws SQLException {
	    String countUsername = "SELECT COUNT(*) FROM user_register WHERE name = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(countUsername);
	    preparedStatement.setString(1, username); 
	    ResultSet resultSet = preparedStatement.executeQuery();
	    resultSet.next();
	    int count = resultSet.getInt(1); 
	    return count > 0;
	}
	
	
	public void viewProducts(Connection connection) throws SQLException {
		String viewing ="Select id,name,model,price FROM products";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(viewing);
		while(resultSet.next()) {
			int id=resultSet.getInt(1);
			String name=resultSet.getString(2);
			String model=resultSet.getString(3);
			double price=resultSet.getDouble(4);	
			System.out.println("ID:" + id + "\n"+ " Name:" + name  + "\n" + " Model:" + model + "\n"  + " Price:" + price);
		}

	}

	public  void retrieveProducts(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the Product to be retrieve:");
		int id = sc.nextInt();
		String retrieve= "SELECT id, name, model, price FROM products WHERE id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(retrieve);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			String name=resultSet.getString("name");
			String model=resultSet.getString("model");
			double price=resultSet.getDouble("price");
			System.out.println("ID:" + id  + "\n"+ " Name:" + name  + "\n"+ " Model:" + model   + "\n"+ " Price:" + price);
		} 
		else {
			System.out.println("ID: " + id + " Not Found");
		}

	}


	public  void retrieveProducts1(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the Product to be retrieve:");
		int id = sc.nextInt();
		String retrieve= "SELECT id, name, model, price FROM products WHERE id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(retrieve);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			String name=resultSet.getString("name");
			String model=resultSet.getString("model");
			double price=resultSet.getDouble("price");
			double discountedPrice = applyDiscount(price);
			System.out.println("_________________Bill____________________");
			System.out.println("ID:" + id);
			System.out.println("Name: " + name);
			System.out.println("TotalPrice: "+ price);
			System.out.println("After 10% Discounted Price: " + discountedPrice);
			System.out.println("__________________________________________");
		} else {
			System.out.println("ID: " + id + " Not Found");
		}
	}


	public static double applyDiscount(double price) {
		double discountRate = 0.1;
		double discountedPrice = price - (price * discountRate);
		return discountedPrice;
	}


	public  void updateProducts(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Validation v1=new Validation();
		System.out.println("Enter the ID of the Product to update:");
		int id = sc.nextInt();
		if(!v1.isNumerics(id)){
			System.out.println("Please Re-Enter your ID:");
			id = sc.nextInt();
		}
		System.out.println("Enter New Name:");
		String name = sc.next();
		if(!v1.validateString(name)){
			System.out.println("Please Re-Enter your Name:");
			name = sc.next();
		}
		System.out.println("Enter New Model:");
		String model = sc.next(); 
		if(!v1.validateString(model)){
			System.out.println("Please Re-Enter your Model:");
			model = sc.next();
		}
		System.out.println("Enter new Price:");
		double price = sc.nextDouble();
		if(!v1.isDle(price)){
			System.out.println("Please Re-Enter your ID:");
			price = sc.nextDouble();
		}	    
		String updating = "UPDATE Products SET Name=?, Model=?, Price=? WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(updating);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, model);
		preparedStatement.setDouble(3, price);
		preparedStatement.setInt(4, id);	    
		int rows = preparedStatement.executeUpdate(); 
		if (rows > 0) {
			System.out.println("Product with ID " + id + " updated successfully.");
		} else {
			System.out.println("Failed to update product with ID " + id);
		}
	}

	public  void deleteProducts(Connection connection) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID of the Products to delete:");
		int id = sc.nextInt();
		String query = "DELETE FROM products WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		if (rows > 0) {
			System.out.println("Products with ID " + id + " deleted successfully.");
		} else {
			System.out.println("No Products found with ID " + id);
		}
	}

	public boolean isExistsId1(Connection connection, int id) throws SQLException {
		String countID = "SELECT COUNT(*) FROM products WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(countID);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int count = resultSet.getInt(1);
		return count > 0;
	}

	public boolean isExistsName1(Connection connection, String name) throws SQLException {
		String countName = "SELECT COUNT(*) FROM products WHERE name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(countName);
		preparedStatement.setString(1, name); 
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int count = resultSet.getInt(1); 
		return count > 0;
	}
	
	public void viewIndividual(int id1, int id2) throws SQLException {
		ProductDbConnection connect = new ProductDbConnection();
		Connection connection = connect.getConnection();		
		String viewList = "select id,name,model,price from products where id >= ? and id < ?";
		PreparedStatement prep = connection.prepareStatement(viewList);
		prep.setInt(1, id1);
		prep.setInt(2, id2);	
		ResultSet resultSet = prep.executeQuery();
		while(resultSet.next()) {
			int id=resultSet.getInt(1);
			String name=resultSet.getString(2);
			String model=resultSet.getString(3);
			double price=resultSet.getDouble(4);	 
			System.out.println("ID:" + id + "\n"+ " Name:" + name  + "\n" + " Model:" + model + "\n"  + " Price:" + price);
		}
	}


}
