<!DOCTYPE html>
<html>
<head>
	<title>Movies Application: Success Page</title>
	<meta name="description" content="An success page we can send users to via the RequestDispatcher when the application encounters an success scenario">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Success</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<p>${success}</p>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>