<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ma.youcode.sbahia.impldao.ArticleDaoImpl" %>
<%@ page import="ma.youcode.sbahia.models.Article" %>

<html>
    <head>
        <title>title</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h2 class="text-center mt-4">Articles</h2>
            
            <!-- Table  -->
            <table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ArticleID</th>
			      <th scope="col">ArticleTitle</th>
			      <th scope="col">ArticleBody</th>
      		      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  		<div class="input-group rounded mb-2">
					  <input onkeyup="redirect()" type="search" name="search" id="search" class="form-control rounded" placeholder="Search by title of article" aria-label="Search"
					    aria-describedby="search-addon" />
					  <span class="input-group-text border-0" id="search-addon">
					    <!-- <a href="<%= request.getContextPath() + "/searchArticle" %>" class="btn">Search</a> -->
					    <a href="#" id="searchBtn" class="btn">Search</a>
					  </span>
					</div>      
	            <%
	            	if (session != null){
	            		String message=(String)session.getAttribute("message");  
	               		out.println(message);
	            	}
	            	ArticleDaoImpl art = new ArticleDaoImpl();
	            	List<Article> articles = art.getAllArticles();
	     
            		if (request.getParameter("q") == null){
            			for(Article article : articles) {
		            	%>
		       				<tr>
								<th scope="row"><%= article.getArticleID() %></th>
								<td><%= article.getArticleTitle() %></td>
								<td><%= article.getArticleBody() %></td>
								<td>
									<a href="<%= request.getContextPath() + "/editArticle/?id=" + article.getArticleID() %>" class="btn btn-secondary w-25" >Edit</a>
									<a href="<%= request.getContextPath() + "/deleteArticle/?id=" + article.getArticleID() %>" class="btn btn-secondary w-25">Delete</a>
								</td>
							</tr>
			        	<% } %>
			        <% } else { %>
			        	<% 
			        		String searchedQuery = request.getParameter("q");
	            			List<Article> searchArticle = art.searchArticleByTitle(searchedQuery);
         					for(Article article : searchArticle) {
		            	%>
		       				<tr>
								<th scope="row"><%= article.getArticleID() %></th>
								<td><%= article.getArticleTitle() %></td>
								<td><%= article.getArticleBody() %></td>
								<td>
									<a href="<%= request.getContextPath() + "/editArticle/?id=" + article.getArticleID() %>" class="btn btn-secondary w-25" >Edit</a>
									<a href="<%= request.getContextPath() + "/deleteArticle/?id=" + article.getArticleID() %>" class="btn btn-secondary w-25">Delete</a>
								</td>
							</tr>
			        	<% } %>
	             	<% } %>	
			  </tbody>
			</table>

        </div>
        <div class="container">
            <form action="/firstwebapp/addArticle" method="POST">
              <div class="form-group">
                <label for="exampleInputEmail1">Title of Article</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter title of article" name="articleTitle">
              </div>

              <div class="form-group mt-2">
                <label for="exampleInputPassword1">Article Body</label>
                 <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="articleBody"></textarea>
              </div>

              <button type="submit" class="btn btn-dark btn-block mt-2" style="width: 100%">Submit</button>
            </form>
        </div>
        <script type="text/javascript">
        	function redirect() {
        		var d = document.getElementById("search");
        		var url = window.location.origin + "/firstwebapp/searchArticle/?q=";
        		
        		var query = url + d.value;
        		
        		var searchBtn = document.getElementById("searchBtn");
        		searchBtn.setAttribute("href", query);
        		
        	}
        </script>
    </body>
</html>
