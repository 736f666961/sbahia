<%@page import="java.util.List"%>
<%@page import="ma.youcode.sbahia.impldao.ProductDaoImpl"%>
<%@ page import="ma.youcode.sbahia.models.Product" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Products</title>
		<link rel="stylesheet" href="./css/style.css" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	</head>
	<body>
		<a href="/sbahia/logout" class="logout">Logout</a>
		<div class="container">
			<%
		     	ProductDaoImpl productDaoImpl = new ProductDaoImpl();
	        	List<Product> products = productDaoImpl.getAllProducts();
	        	
	        	for(Product product : products) {
			%>
			<div class="card">
				<div class="card-body">
					<div class="product-image">
						<img alt="product image" width="100px" height="100px" src="<%= product.getProductImage() %>">
					</div>
					
					<div class="product-info">
						<h4><%= product.getProductName() %></h4>
						<p><%= product.getproductDescription() %></p>
					</div>
				</div>
				
				<div class="card-buttons">
					<a href="<%= request.getContextPath() + "/like/?id=" + product.getId() %>" class="like"  <%= product.isInteracted() ? "disabled" : "" %>>Like</a>
					<a href="<%= request.getContextPath() + "/dislike/?id=" + product.getId() %>"  class="dislike" <%= product.isInteracted() ? "disabled" : "" %>>Dislike</a>
				</div>
				
				<div class="card-footer">
					<div class="like">
						<img alt="like icon" width="15px" height="15px" src="./icons/like.png">
						<p style="margin-top: 0px">:<%= product.getProductLikes() %></p>
					</div>
					
					<div class="dislike">
						<img alt="dislike icon" width="15px" height="15px" src="./icons/dislike.png">
						<p style="margin-top: 0px">:<%= product.getProductDislikes() %></p>
					</div>
				</div>
			</div>
			
			<% } %>
			
		</div>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
		<script>
			var likes = document.querySelectorAll('.like');
	
			likes.forEach(function (element) { 
	
				$(element).on("click", function(event){
					var x = element.attributes.getNamedItem('disabled');;
					
			        if (x != null) {
			        	event.preventDefault();
			        	console.log("Disabled !");
			        }else {
			        	console.log("Not Disabled !"); 
			        }
			    })
	        });
			
			var dislikes = document.querySelectorAll('.dislike');

			dislikes.forEach(function (element) { 
				// console.log(element);
				$(element).on("click", function(event){
					var x = element.attributes.getNamedItem('disabled');;
					
			        if (x != null) {
			        	event.preventDefault();
			        	console.log("Disabled !");
			        }else {
			        	console.log("Not Disabled !"); 
			        } 
			    })
	        })
			
		</script>
	</body>
</html>