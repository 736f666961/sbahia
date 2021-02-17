<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List" %>
<%@ page import="ma.youcode.sbahia.impldao.ArticleDaoImpl" %>
<%@ page import="ma.youcode.sbahia.models.Article" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

		<%
			int articleID = Integer.parseInt(request.getParameter("id"));
		
	     	ArticleDaoImpl art = new ArticleDaoImpl();
	    	List<Article> articles = art.getArticleById(articleID);
	
			for(Article article : articles) {
			
		%>        	
            	
        <div class="container">
           <form action="/firstwebapp/editArticle/?id=<%= request.getParameter("id") %>" method="POST">
             <div class="form-group">
               <label for="exampleInputEmail1">Title of Article</label>
              <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter title of article" name="articleTitle" value="<%= article.getArticleTitle() %>"> 
             </div>

             <div class="form-group mt-2">
               <label for="exampleInputPassword1">Article Body</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="articleBody"><%= article.getArticleBody() %></textarea>
             </div>

             <button type="submit" class="btn btn-dark btn-block mt-2" style="width: 100%">Submit</button>
           </form>
       </div>
       
       <% } %>
</body>
</html>