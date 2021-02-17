package ma.youcode.sbahia.controllers.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.youcode.sbahia.impldao.ProductDaoImpl;

/**
 * Servlet implementation class Like
 */
@WebServlet("/like/*")
public class Like extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDaoImpl productDaoImpl;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Like() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get Product id and page
		int productID = Integer.parseInt(request.getParameter("id"));
		String page = request.getParameter("page");
		
		// Instantiate ProductDaoImpl
		productDaoImpl = new ProductDaoImpl();
		
		// Delete that product
		productDaoImpl.like(productID);
		
		if (page == "admin" && page != null) {
			// redirect to admin page
			response.sendRedirect("/sbahia/admin.jsp?page=admin");
			
		}else {
			// redirect to user page
			response.sendRedirect("/sbahia/products.jsp?page=user");
		}
	}
}
