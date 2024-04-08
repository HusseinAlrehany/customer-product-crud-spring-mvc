<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>CUSTOMER PRODUCTS MANAGER</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">


</head>
<body>

	<div id="wapper">
		<div id="header">

			<h3>CPRM- customer products relationship manager</h3>
		</div>

	</div>

	<div id="container">
		<form:form action="addProduct" modelAttribute="products"
			method="POST">
			
			<!-- for updating the product and associate data to the same product id -->
			<form:hidden path="productId"/>
			

			<table>
				<tbody>
					<tr>
						<td><label>description</label></td>
						<td><form:input path="description" />
					</tr>

					<tr>
						<td><label>price</label></td>
						<td><form:input path="price" /></td>

					</tr>

					<tr>
						<td><label>quantity</label></td>
						<td><form:input path="quantity" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save Product"
							class="add-button" ></td>
					</tr>

				</tbody>


			</table>




		</form:form>

	</div>




</body>


</html>