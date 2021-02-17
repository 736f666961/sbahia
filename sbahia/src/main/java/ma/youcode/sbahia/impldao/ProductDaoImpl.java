package ma.youcode.sbahia.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.youcode.sbahia.dao.ProductDao;
import ma.youcode.sbahia.database.Database;
import ma.youcode.sbahia.models.Product;

public class ProductDaoImpl implements ProductDao {
	private Database database = null;
	private Connection connection = null;
	private List<Product> product = null;

	public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addProduct(String productImage, String productName, String ProductDescription) {
		// Instantiate Database
		database = new Database();
		connection = database.makeConnection();
		
		// Query
		String addQuery = "INSERT INTO products (product_image, product_name, product_description) VALUES (?, ?, ?);";
		
        try {
            // Prepare query
            PreparedStatement preparedStatement = connection.prepareStatement(addQuery);
            preparedStatement.setString(1, productImage);
            preparedStatement.setString(2, productName);
            preparedStatement.setString(3, ProductDescription);

            // execute query
            int isProductAdded = preparedStatement.executeUpdate();
            
            // return 1 if product added successfully
            if (isProductAdded > 0) {
                // close database
                connection.close();
                
            	return 1;
            }

        } catch (SQLException throwables) {
        	 return 0;
        }
		
		return 0;
	}

	@Override
	public int editProduct(int id, String productImage, String productName, String ProductDescription) {
		// Query
		String query = "UPDATE products SET product_image = '" + productImage + "', product_name= '" + productName + "', product_description= '" + ProductDescription + "' WHERE id = " + id + ";";
//		System.out.println("Query Update: " + query);
		
		// Create connection to database
		database = new Database();
		connection = database.makeConnection();
		
		try {
			// prepare statment
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			int isEdited = preparedStatement.executeUpdate();
			
			// if data deleted
			if (isEdited > 0) {
				// close connection
				connection.close();
				
				return 1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteProduct(int id) {
		// Query
		String query = "DELETE FROM products WHERE id='" +  id + "';";
		
		// Create connection to database
		database = new Database();
		connection = database.makeConnection();
		
		try {
			// prepare statment
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			int isDeleted = preparedStatement.executeUpdate();
			
			// if data deleted
			if (isDeleted > 0) {
				// close connection
				connection.close();
				
				return 1;
			}
			
			
		} catch (SQLException e) {
			return 0;
		}
		
		return 0;
	}

	@Override
	public List<Product> getAllProducts() {
	    // Create articles
        product = new ArrayList<Product>();

        // Create connection to database
        database = new Database();
        connection = database.makeConnection();

        // Query
        String query = "SELECT * FROM products;";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            // Iterate through db rows
            while(queryResult.next()) {
                // Get data from db
                int product_id = queryResult.getInt("id");
                String product_image = queryResult.getString("product_image");
                String product_name = queryResult.getString("product_name");
        		String product_description = queryResult.getString("product_description");
				int product_likes = queryResult.getInt("product_likes");
				int product_dislikes = queryResult.getInt("product_dislikes");
				boolean isInteracted = queryResult.getBoolean("isInteracted");

                // Store products from db in product list
                product.add(new Product(product_id, product_image, product_name, product_description, product_likes, product_dislikes, isInteracted));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
		return product;
	}

	@Override
	public void like(int id) {
		// Query
		String query = "UPDATE products SET product_likes = ((select product_likes from products WHERE id = " + id + ")+1), isInteracted = TRUE WHERE id = " + id + "; ";
		
		// Create connection to database
		database = new Database();
		connection = database.makeConnection();
		
		try {
			// prepare statment
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			int isDeleted = preparedStatement.executeUpdate();
			
			// if data deleted
			if (isDeleted > 0) {
				// close connection
				connection.close();
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public void dislike(int id) {
		// Query
		String query = "UPDATE products SET product_dislikes = ((select product_dislikes from products WHERE id = " + id + ")+1), isInteracted = TRUE WHERE id = " + id + "; ";
		
		// Create connection to database
		database = new Database();
		connection = database.makeConnection();
		
		try {
			// prepare statment
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			int isDeleted = preparedStatement.executeUpdate();
			
			// if data deleted
			if (isDeleted > 0) {
				// close connection
				connection.close();
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public List<Product> getProductById(int productID) {
        // Create products
        product = new ArrayList<Product>();

        // Create connection to database
        Database database = new Database();
        Connection connection = database.makeConnection();

        // Query
        String query = "SELECT * FROM products WHERE id = '" + productID + "';";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            // Iterate through db rows
            while(queryResult.next()) {
                // Get data from db
                int id = queryResult.getInt(1);
                String product_image = queryResult.getString("product_image");
                String product_name = queryResult.getString("product_name");
                String product_description = queryResult.getString("product_description");

                // Store product from db in products list
                product.add(new Product(id, product_image, product_name, product_description));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
		return product;
	}

}
