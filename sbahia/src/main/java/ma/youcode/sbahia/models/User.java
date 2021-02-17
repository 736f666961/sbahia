package ma.youcode.sbahia.models;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	
	public User() {
		super();
	}
	
	// testing constructor
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	public User(int id, String firstName, String lastName, String email, String password, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the id of user
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstName of user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName of user
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @return the email of user
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return the password of user
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the role of user
	 */
	public String getRole() {
		return role;
	}

}
