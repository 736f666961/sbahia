package ma.youcode.sbahia.controllers.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.youcode.sbahia.impldao.ProductDaoImpl;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDaoImpl productDaoImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get data from user
		String productImage = request.getParameter("product_image");
		String productName = request.getParameter("product_name");
		String productDescription = request.getParameter("product_description");
		
	    // Instantiate ProductDaoImpl
		productDaoImpl = new ProductDaoImpl();

        // add article to database
        int isProductAdded = productDaoImpl.addProduct(productImage, productName, productDescription);
  
        // flash message
        final String successMessage = "<div class='alert alert-success' role='alert'>Product added successfully...!</div>";
        final String errorMessage = "<div class='alert alert-danger' role='alert'>Product did not added</div>";
        
        // check if data added to database
        String message = isProductAdded == 1 ? successMessage : errorMessage;
        
        // set reacted message
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        
        // redirect to home page
        response.sendRedirect("/sbahia/admin.jsp");
	}

}
