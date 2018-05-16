<!DOCTYPE html>
<html>
<head>
	<title>Movies Application: Add Movie</title>
	<meta name="description" content="Adding movies to the database.">
	<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Add Movie</h1>
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		
		<form action ="addMovie" method="post">
			<div class = "form-group">
				<label for ="title"><strong>Title Name</strong></label>
				<input name="title">
				
				<label for ="director"><strong>Director Name</strong></label>
				<input name="director">
				
				<label for ="lengthInMin"><strong>Length In Minutes</strong></label>
				<input name="lengthInMin">

				<input class="btn btn-primary btn-lg" type="submit" value="Add Movie">
				
			</div>
		</form>
		
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>


<%@ include file="includes/scripts.jsp" %>
</body>
</html>