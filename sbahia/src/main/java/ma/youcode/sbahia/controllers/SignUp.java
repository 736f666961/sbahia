package ma.youcode.sbahia.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.youcode.sbahia.database.Database;
import ma.youcode.sbahia.impldao.UserDaoImpl;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup/*")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDaoImpl userDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get session
		HttpSession session = request.getSession();
		session.invalidate();
		
		// Get form
		String form = (String) request.getParameter("form");
		
        // redirect to home page
        response.sendRedirect("/sbahia/?form=" + form);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Instantiate ArticleDaoImpl
		userDaoImpl = new UserDaoImpl();
        
		// Get data from user
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// make connection to database
		Database database = new Database();
		Connection connection = database.makeConnection();
		
        // add user to database
        int isSignedUp = userDaoImpl.signup(firstName, lastName, email, password);
		
        // redirect to home page
        response.sendRedirect("/sbahia/products.jsp");
	}

}
