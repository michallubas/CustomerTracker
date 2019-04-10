<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head> </head>

<!-- we will use cascade style sheets, css -->
	
	<link 
		type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" >
	
	<link 
		type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" >
	
<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Realtionship Manager</h2>
			</div>
		
		 </div>
		 
		 <div id=container>
		 	<h3>Save Customer</h3>

			<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			
			<!-- we need to associate data with customer id, we added hidden for field to provide customer id, when form is loaded: get customer id and placet it to hidden form, the way to track customer -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr> 
							<td><label>First name:</label> </td>
							<td><form:input path="firstName" /> </td>
					</tr>
				
					<tr> 
							<td><label>Last name:</label> </td>
							<td><form:input path="lastName" /> </td>
					</tr>
					
					<tr> 
							<td><label>Email:</label> </td>
							<td><form:input path="email" /> </td>
					</tr>
					
					<tr> 
							<td><label></label> </td>
							<td><input type="submit" value="Save" class="save" /> </td>
					</tr>
					
				
				</tbody>
			
			</table>
	
			</form:form>
			
					 <div style="clear;both;"></div>
		 </div>
		 
		 <p>
		 
		 <a href="${pageContext.request.contextPath}/customer/list">  Back to list</a> 
		 
		 
		 </p>
		 
<br>


</body>

</html>