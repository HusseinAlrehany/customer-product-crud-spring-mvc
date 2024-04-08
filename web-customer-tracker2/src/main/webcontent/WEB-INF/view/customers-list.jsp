<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<title>CUSTOMERS LIST</title>

<!-- REFERENCE OUR CSS FILES -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CUSTOMER PRODUCT MANAGER</h2>

		</div>



	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="view products"
				onClick="window.location.href='http://localhost:8080/web-customer-tracker2/product/listproducts';return false;"
				class="add-button" /><br> <input type="button"
				value="add customer"
				onClick="window.location.href='http://localhost:8080/web-customer-tracker2/customer/customerForm';return false;"
				class="add-button" /><br>

			<!-- adding the search button -->
			<form action="searchCustomer" method="GET">

				<input type="submit" value="Search" class="add-button" /> <input
					type="text" name="theSearchName" placeholder="enter name to search" />



			</form>

			<!-- ADDING HTML TABLE FOR DISPLAYING THE CUSTOMERS -->

			<table>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>

					<!-- LOOPING AND PRINTING CUSTOMERS  -->
					<c:forEach var="tempCustomer" items="${customers}">

						<!-- CONSTRUCT AN UPDATE LINK WITH CUSTMER ID -->
						<c:url var="updateLink" value="/customer/updateCustomer">

							<c:param name="customerId" value="${tempCustomer.customerId}" />



						</c:url>
						<!-- CONSTRUCT DELETE LINK WITH CUSTOMER ID -->
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.customerId}" />

						</c:url>
						<!-- CONSTRUCT ADD PRODUCT LINK WITH CUSTOMER ID -->
						<c:url var="addProductLink" value="/product/productForm">
							<c:param name="customerId" value="${tempCustomer.customerId}" />


						</c:url>

						<tr>
							<td>${tempCustomer.firstName }</td>
							<td>${tempCustomer.lastName }</td>
							<td>${tempCustomer.email}</td>
							<td>
								<!-- DISPLAY THE UPDATE LINK --> <a href="${updateLink}">update</a>
								<!-- DISPLAY THE DELETE LINK --> <a href="${deleteLink}"
								onClick="if(!(confirm('Are You Sure ?')))return false">delete</a>
								<!-- DISPLAY THE ADD PRODUCT LINK --><a href="${addProductLink}">add product</a>

							</td>




						</tr>


					</c:forEach>

				</tr>

			</table>


		</div>

	</div>




</body>




</html>