<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<header>
	<title>Customer Form</title>


	<!-- REFERENCE OUR CSS FILES -->
	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">


	<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</header>

<body>

	<div id="wrapper">


		<div id="header">

			<h2>CUSTOMER RELATIONSHIP MANAGER</h2>

		</div>
	</div>

	<div id="cntainer">
		<h3>Save a Customer</h3>

		<form:form action="addCustomer" modelAttribute="customers"
			method="POST">

			<!-- FOR UPDATING A CUSTOMER ASSOCIATE THIS DATA TO THAT CUSTOMER ID -->

			<form:hidden path="customerId" />

			<table>
				<tbody>
					<tr>
						<td><label>first Name</label></td>
						<td><form:input path="firstName" />
						<form:errors path="firstName"/></td>

					</tr>

					<tr>
						<td><label>last Name</label></td>
						<td><form:input path="lastName" /></td>

					</tr>

					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email" /></td>

					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="add-button" /></td>
					</tr>

				</tbody>

			</table>


		</form:form>

		<div Style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/listCustomers">Back
				To List</a>
		</p>

	</div>


</body>



</html>