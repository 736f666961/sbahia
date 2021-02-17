package ma.youcode.sbahia.impldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.youcode.sbahia.dao.UserDao;
import ma.youcode.sbahia.database.Database;
import ma.youcode.sbahia.models.User;

public class UserDaoImpl implements UserDao {
	private Database database;
	private Connection connection = null;
	private List<User> user;

	public UserDaoImpl() {
		super();
	}

	@Override
	public int isAuth(String email, String password) {     
        // Create connection to database
        database = new Database();
        connection = database.makeConnection();
        
        // Query
        String query = "SELECT email, password, role FROM Users;";

        try {
        	// execute query
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(query);

            // Iterate through db rows
            while(queryResult.next()) {
                // Get data from db
                String db_email = queryResult.getString("email");
                String db_pwd = queryResult.getString("password");
                String db_role = queryResult.getString("role");
                
                // check if login info are exists in db and role is admin
        		if (email.equals(db_email) && password.equals(db_pwd) && db_role.equals("admin")) {
        			
        			return 1;
        		}
        		
                // check if login info are exists in db and role is normal user
        		if (email.equals(db_email) && password.equals(db_pwd) && db_role.equals("user")) {
        			
        			return 2;
        		}
                
            }

        } catch (SQLException throwables) {
            return 0;
        }

		return 0;
	}

	@Override
	public int signup(String firstName, String lastName, String email, String password) {
        // Create connection to database
        Database database = new Database();
        Connection connection = database.makeConnection();
        
        // Query
        String query = "INSERT INTO users (first_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?);";
        
        try {
            // Prepare query
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(5, "user");

            // execute query
            int isSignedUp = preparedStatement.executeUpdate();
            
            // return 1
            if (isSignedUp > 0) {
            	return 1;
            }

            // close database
            connection.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return 0;
    }

}
