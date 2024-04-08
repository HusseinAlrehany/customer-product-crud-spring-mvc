<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<DOCTYPE ! html>
<html>
<head>
<title>PRODUCTS LIST</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">

			<h2>CUSTOMER PRODUCT MANAGEMENT</h2>


		</div>


	</div>

	<div id="container">
		<div id="content">


			<!-- ADDING HTML TABLE FOR DISPLAYING THE PRODUCTS -->
			<table>
				<tr>
					<th>description</th>
					<th>price</th>
					<th>quantity</th>
					<th>action</th>

					<!-- LOOPING AND PRINTING products  -->

					<c:forEach var="tempProduct" items="${products}">

						<!-- CONSTRUCT UPDATE LINK WITH PRODUCT ID -->
						<c:url var="updateLink" value="/product/updateProduct">
							<c:param name="productId" value="${tempProduct.productId}" />


						</c:url>

						<!-- CONSTRUCT DELETE LINK WITH PRODUCT ID -->
						<c:url var="deleteLink" value="/product/deleteProduct">
							<c:param name="productId" value="${tempProduct.productId}" />


						</c:url>

						<tr>
							<td>${tempProduct.description }</td>
							<td>${tempProduct.price }</td>
							<td>${tempProduct.quantity}</td>
							<td><a href="${updateLink }">update</a> <a
								href="${deleteLink }"
								onClick="if(!(confirm('Are You Sure ?')))return false">delete</a></td>

						</tr>

					</c:forEach>



				</tr>


			</table>

		</div>
	</div>

</body>

</html>