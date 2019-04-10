<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head> HEAD </head>
<br>

<body>BODY</body>
<br>



<c:forEach items="${customers}" var="tempCustomer"> 

	<p>Student name= ${tempCustomer.firstName}</p>
	
</c:forEach>
<hr/>

<br><br>

<!-- http://localhost:8080/web-customer-tracker-ml = ${pageContext.request.contextPath} -->
<a href="${pageContext.request.contextPath}/customer/list"> Back to customer list</a>

</html>