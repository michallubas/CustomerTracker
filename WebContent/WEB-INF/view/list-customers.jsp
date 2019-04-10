<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>



<link type="text/css"
		 rel="stylesheet" 
		 href="${pageContext.request.contextPath}/resources/css/style.css" >


</head>

<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Realtionship Manager</h2>
			</div>
		 </div>

	<div id="container">
					
		<div id="content"> 
	
	<!-- put new button: Add Customer -->
	<input type="button" value="Add Customer"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"
		/>
	
	
	<!-- add out html taable here -->	
		
		<table>
			<tr>
				<th>First Name </th>
				<th>Last Name </th>	
				<th>Email </th>
				<th>Action</th>
			
			<c:forEach var="tempCustomer" items="${customers}">
			<!-- construct an "update" link with customer id, dla kazego updateLink nadajemy parametr customerId o wartosci ${temp.Customer.id}-->
			
			<c:url var="updateLink" value="/customer/showFormForUpdate"> 
				<c:param name="customerId" value="${tempCustomer.id}"/>
			</c:url>
			
			<!-- construct an "delete" link-->
			
			<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCustomer.id}" />
			
			</c:url>
			
			<tr>
				<td> ${tempCustomer.firstName} </td>
				<td> ${tempCustomer.lastName} </td>
				<td> ${tempCustomer.email} </td>
				<td> 
					<!-- display the update link -->
				<a href="${updateLink}">Update</a> 
				|
				<a href="${deleteLink}"
								
				onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false ">Delete </a> 
				
	
				
				</td>
				
				</tr>
		
		</c:forEach>
		
		
		</table>
		<br>
		
		</div>
	
	</div>
	
	<div>
	
	<input type="button" value="Testing side"
	onclick="window.location.href='testSide'; return false;"
	class="add-button"
	/>
	
	</div>
</body>
	

</html>