package ma.youcode.sbahia.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.youcode.sbahia.impldao.UserDaoImpl;
import ma.youcode.sbahia.models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login/*")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		// Get data from user
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Instantiate UserDaoImpl	
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int isUserAuth = userDaoImpl.isAuth(email, password);

		// create session
        HttpSession session = request.getSession();

		 // Error Login Message
		String errorLoginMessage;
		
		// check if user is authenticated
		switch (isUserAuth) {
			// Wrong info AKA - email and password
			case 0: {
				// Set error login message
				errorLoginMessage = "<div class='login-error'><span>Incorrect email and password !</span></div>";
		        
				// send error login message to login page
		        session.setAttribute("errorLoginMessage", errorLoginMessage);
		        
		        // redirect to home page
		        response.sendRedirect("/sbahia/");
		        
		        break;
			}
			// Right info - User is Admin
			case 1: {				
		        // redirect to home page
		        response.sendRedirect("/sbahia/admin.jsp");
		        
		        break;
			}
			// Right info - User is Normal User
			case 2: {				
		        // redirect to home page
		        response.sendRedirect("/sbahia/products.jsp");
		        
		        break;
			}
			default: {
				// Set error login message
				errorLoginMessage = "<div class='login-error'><span>Incorrect email and password !</span></div>";
		        
				// send error login message to login page
		        session.setAttribute("errorLoginMessage", errorLoginMessage);
		        
		        // redirect to home page
		        response.sendRedirect("/sbahia/");
		        
		        break;
			}
		}
	}
}
