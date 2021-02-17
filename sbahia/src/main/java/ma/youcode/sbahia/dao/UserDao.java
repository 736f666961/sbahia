package ma.youcode.sbahia.dao;

public interface UserDao {
	int isAuth(String email, String password);
	int signup(String firstName, String lastName, String email, String password);
}
