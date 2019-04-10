<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

NIC a nic
<br>

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Realtionship Manager</h2>
		</div>
	
	 </div>


	<div id="container">
		
		<div id="content"> 
	<!-- add out html taable here -->	
		
		<table>
			<tr>
				<th>First Name </th>
				<th>Last Name </th>	
				<th>Email </th>
			
			</tr>
				<!-- loop over and print our cusomer -->	
				<!-- if we want something from model, we use "${}" , th table head, tr table row, td table data-->		
		<c:forEach var="tempCustomer" items="${customers}"}>
			<tr>
				<td> ${tempCustomer.firstName} </td>
				<td> ${tempCustomer.lastName} </td>
				<td> ${tempCustomer.email} </td>
			</tr>
		
		</c:forEach>
		
		</table>
		
		</div>
	
	</div>


</body>
	

</html>