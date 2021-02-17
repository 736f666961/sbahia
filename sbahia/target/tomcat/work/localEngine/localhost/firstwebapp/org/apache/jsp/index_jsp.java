package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import ma.youcode.firstwebapp.impldao.ArticleDaoImpl;
import ma.youcode.firstwebapp.models.Article;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>title</title>\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <h2 class=\"text-center mt-4\">Articles</h2>\n");
      out.write("            \n");
      out.write("            <!-- Table  -->\n");
      out.write("            <table class=\"table\">\n");
      out.write("\t\t\t  <thead>\n");
      out.write("\t\t\t    <tr>\n");
      out.write("\t\t\t      <th scope=\"col\">ArticleID</th>\n");
      out.write("\t\t\t      <th scope=\"col\">ArticleTitle</th>\n");
      out.write("\t\t\t      <th scope=\"col\">ArticleBody</th>\n");
      out.write("      \t\t      <th scope=\"col\">Actions</th>\n");
      out.write("\t\t\t    </tr>\n");
      out.write("\t\t\t  </thead>\n");
      out.write("\t\t\t  <tbody>\n");
      out.write("\t\t\t  \t\t<div class=\"input-group rounded mb-2\">\n");
      out.write("\t\t\t\t\t  <input onkeyup=\"redirect()\" type=\"search\" name=\"search\" id=\"search\" class=\"form-control rounded\" placeholder=\"Search by title of article\" aria-label=\"Search\"\n");
      out.write("\t\t\t\t\t    aria-describedby=\"search-addon\" />\n");
      out.write("\t\t\t\t\t  <span class=\"input-group-text border-0\" id=\"search-addon\">\n");
      out.write("\t\t\t\t\t    <!-- <a href=\"");
      out.print( request.getContextPath() + "/searchArticle" );
      out.write("\" class=\"btn\">Search</a> -->\n");
      out.write("\t\t\t\t\t    <a href=\"#\" id=\"searchBtn\" class=\"btn\">Search</a>\n");
      out.write("\t\t\t\t\t  </span>\n");
      out.write("\t\t\t\t\t</div>\t      \n");
      out.write("\t            ");

	            	if (session != null){
	            		String message=(String)session.getAttribute("message");  
	               		out.println(message);
	            	}
	            	ArticleDaoImpl art = new ArticleDaoImpl();
	            	List<Article> articles = art.getAllArticles();
	     
            		if (request.getParameter("q") == null){
            			for(Article article : articles) {
		            	
      out.write("\n");
      out.write("\t\t       \t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"row\">");
      out.print( article.getArticleID() );
      out.write("</th>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( article.getArticleTitle() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( article.getArticleBody() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print( request.getContextPath() + "/editArticle/?id=" + article.getArticleID() );
      out.write("\" class=\"btn btn-secondary w-25\" >Edit</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print( request.getContextPath() + "/deleteArticle/?id=" + article.getArticleID() );
      out.write("\" class=\"btn btn-secondary w-25\">Delete</a>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t        \t");
 } 
      out.write("\n");
      out.write("\t\t\t        ");
 } else { 
      out.write("\n");
      out.write("\t\t\t        \t");
 
			        		String searchedQuery = request.getParameter("q");
	            			List<Article> searchArticle = art.searchArticleByTitle(searchedQuery);
         					for(Article article : searchArticle) {
		            	
      out.write("\n");
      out.write("\t\t       \t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<th scope=\"row\">");
      out.print( article.getArticleID() );
      out.write("</th>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( article.getArticleTitle() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>");
      out.print( article.getArticleBody() );
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print( request.getContextPath() + "/editArticle/?id=" + article.getArticleID() );
      out.write("\" class=\"btn btn-secondary w-25\" >Edit</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"");
      out.print( request.getContextPath() + "/deleteArticle/?id=" + article.getArticleID() );
      out.write("\" class=\"btn btn-secondary w-25\">Delete</a>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t        \t");
 } 
      out.write("\n");
      out.write("\t             \t");
 } 
      out.write("\n");
      out.write("\t        \t\n");
      out.write("\t\t\t  </tbody>\n");
      out.write("\t\t\t</table>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <form action=\"/firstwebapp/addArticle\" method=\"POST\">\n");
      out.write("              <div class=\"form-group\">\n");
      out.write("                <label for=\"exampleInputEmail1\">Title of Article</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" aria-describedby=\"emailHelp\" placeholder=\"Enter title of article\" name=\"articleTitle\">\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("              <div class=\"form-group mt-2\">\n");
      out.write("                <label for=\"exampleInputPassword1\">Article Body</label>\n");
      out.write("                 <textarea class=\"form-control\" id=\"exampleFormControlTextarea1\" rows=\"3\" name=\"articleBody\"></textarea>\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("              <button type=\"submit\" class=\"btn btn-dark btn-block mt-2\" style=\"width: 100%\">Submit</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("        \tfunction redirect() {\n");
      out.write("        \t\tvar d = document.getElementById(\"search\");\n");
      out.write("        \t\tvar url = window.location.origin + \"/firstwebapp/searchArticle/?q=\";\n");
      out.write("        \t\t\n");
      out.write("        \t\tvar query = url + d.value;\n");
      out.write("        \t\t\n");
      out.write("        \t\tvar searchBtn = document.getElementById(\"searchBtn\");\n");
      out.write("        \t\tsearchBtn.setAttribute(\"href\", query);\n");
      out.write("        \t\t\n");
      out.write("        \t}\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
