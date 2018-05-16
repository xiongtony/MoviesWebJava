<!DOCTYPE html>
<html>
<head>
	<title>Movies Application: Movie Search</title>
	<meta name="description" content="How to use a form to search for a movie.">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Movie Search</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<form action="Search" method="post">
			<div class="form-group">
				<label for="title"><strong>Search by Title Name:</strong></label>
				<input name="title">
				<input name="searchType" type="hidden" value="title">
				<input class="btn btn-primary btn-lg" type="submit" value="Search">
			</div>
		</form>
	</div>
	<div class="container">
		<form action="Search" method="post">
			<div class="form-group">
				<label for="director"><strong>Search by Director Name:</strong></label>
				<input name="director">
				<input name="searchType" type="hidden" value="director">
				<input class="btn btn-primary btn-lg" type="submit" value="Search">
			</div>
		</form>
	</div>
	<div class="container">
		<form action="Search" method="post">
			<div class="form-group">
				<label for="lengthInMin"><strong>Search by Length In Minutes:</strong></label>
				<input name="lengthInMin">
				<input name="searchType" type="hidden" value="lengthInMin">
				<input class="btn btn-primary btn-lg" type="submit" value="Search">
			</div>
		</form>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>