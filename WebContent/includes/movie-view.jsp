<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty movies}">
		<p>Sorry, the list of movies is empty.</p>
	</c:when>
	<c:otherwise>
		<c:forEach var="movie" items="${movies}">
			<div class="span4">
				<h2>${movie.getTitle}</h2>
				<p>The movie ${movie.getTitle} is directed by ${movie.getDirector} and the length of the movie is ${movie.getLenghtInMin} minutes.</p>
			</div>
		</c:forEach>	
	</c:otherwise>
</c:choose>
