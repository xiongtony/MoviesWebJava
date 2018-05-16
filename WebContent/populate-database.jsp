<!DOCTYPE html>
<%@page import="edu.cvtc.web.dao.impl.MovieDaoImpl"%>
<%@page import="edu.cvtc.web.dao.MovieDao"%>
<html>
<head>
	<title>Movies: Index</title>
	<meta name="description" content="Populate a database">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Movie Search</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<%
		try {
			final String filePath = session.getServletContext().getRealPath("/assets/Movies.xlsx");
			
			final MovieDao movieDao = new MovieDaoImpl();
			movieDao.populateMovieTable(filePath);
			
			%>
			<p>Success: database populated!</p>
			<%
			
		} catch (final Exception e) {
			e.printStackTrace();
			%>
			<p>Error: Sorry, we were unable to populate the database at this time.</p>
			<%
		}
		%>
	
	
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>