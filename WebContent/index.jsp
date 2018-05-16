<!DOCTYPE html>
<html>
<head>
	<title>Movies: Index</title>
	<meta name="description" content="Home page of the Movies app">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Welcome to my Movies Application</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<p>Hello and welcome to my Movies Application Web site!</p>
		<p>If you need to populate (or re-populate) the database, <a href="populate-database.jsp">click here</a></p>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>