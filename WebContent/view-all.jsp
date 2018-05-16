<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Movies: View All</title>
	<meta name="description" content="Home page of the Movies app">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Movie Search</h1>
	</div>
	
	<%@ include file ="includes/navigation.jsp" %>
	
	<div class="container">
	
		<jsp:include page="includes/movie-view.jsp"></jsp:include>

	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>