<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Producto List</title>
</head>
<body>
	
	<div class = "container">
		
		<h1>Producto List</h1>
		<hr/>
		
		<div class="alert alert-info" role="alert">
			<p>${NOTIFICATION}</p>
		</div>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/producto-form.jsp'">Add Producto</button>
		</p>
	
		<table class = "table table-striped table-bordered table-hover">
			
			<tr class = "thead-light">
				<th>Name</th>
				<th>Precio</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach items="${list}" var="producto">
			
				<tr>
					<td>${product.name}</td>
					<td>${product.precio}€</td>
				
					<td> 
				
				
						<a href = "${pageContext.request.contextPath}/ProductoController?action=EDIT&id=${producto.id}"><span class="glyphicon glyphicon-pencil"></span></a>
				   		| 
						<a href = "${pageContext.request.contextPath}/ProductoController?action=DELETE&id=${producto.id}"><span class="glyphicon glyphicon-trash"></span></a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>