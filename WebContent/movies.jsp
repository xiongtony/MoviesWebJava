<!DOCTYPE html>
<%@page import="java.io.File"%>
<%@page import="edu.cvtc.web.util.WorkbookUtility"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.cvtc.web.model.Movie"%>
<%@page import="java.util.List"%>
<html>
<head>
	<title>Java Web Programming: Movies</title>
	<meta name="description" content="This is a JSP example that demonstrates how to build a Java Web Application.">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Welcome to Java Web Programming!</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
	
	<%
	List<Movie> movies = new ArrayList<>();
	
	final String filePath = session.getServletContext().getRealPath("/assets/Movies.xlsx");
	final File inputFile = new File(filePath);
	movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
	
	for (final Movie movie : movies) {
		// Create a new HTML div with a h2 header for the person's name.
		// And a paragraph for the details about that Person.
		%>
		
		<div class="Movie">
			<h2><%=movie.getTitle() %></h2>
			<p>The movie <%=movie.getTitle() %> is directed by <%=movie.getDirector() %> and the length of the
			movie is <%=movie.getLengthInMin() %> minutes.</p>
		</div>
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