package dao;

import java.sql.Connection;
import java.sql.SQLException;



import model.*;

public interface ProductDAO {
	public void updateProducts(Connection connection) throws SQLException ;
	
	public  Product addLaptops(Connection connection, Product p) throws SQLException ;
	public  Product addClothes(Connection connection, Product p) throws SQLException ;
	public  Product addMobiles(Connection connection, Product p) throws SQLException ;
	//public  Product insertProduct(Connection connection, Product p) throws SQLException;
	public void insertUser(Connection connection,UserRegister ur)throws SQLException;
	public void getUserPassword(Connection connection,UserRegister ur) throws SQLException;
	public boolean isExistsId(Connection connection, int id) throws SQLException;
	public  boolean isExistsName(Connection connection, String name)throws SQLException;
	public void  viewProducts(Connection connection)throws SQLException;
	public void retrieveProducts(Connection connection)throws SQLException;
	public	void deleteProducts(Connection connection)throws SQLException;
}
