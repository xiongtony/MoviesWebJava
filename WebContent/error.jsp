<!DOCTYPE html>
<html>
<head>
	<title>Movies Application: Error Page</title>
	<meta name="description" content="An error page we can send users to via the RequestDispatcher when the application encounters an error.">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Error</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<p>${error}</p>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>