package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.search.MovieSearch;
import edu.cvtc.web.search.impl.MovieSearchImpl;



/**
 * Servlet implementation class SearchController
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7146804893798524255L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final List<Movie> movies = new ArrayList<>();
			final MovieSearch movieSearch = new MovieSearchImpl();
			
			final String searchType = request.getParameter("searchType");
			
			switch(searchType) {
			
				case "title":
					final String title = request.getParameter("title");
					movies.addAll(movieSearch.findMoviesByTitle(title));
					break;
					
				case "director":
					final String director = request.getParameter("director");
					movies.addAll(movieSearch.findMoviesByDirector(director));
					break;
				
				case "lengthInMin":
					final Integer lengthInMin = Integer.parseInt(request.getParameter("lengthInMin"));
					movies.addAll(movieSearch.findMoviesByLengthInMin(lengthInMin));
					break;

				default:
					movies.addAll(movieSearch.retrieveMovies(null));
					break;
			}
			
			request.setAttribute("movies", movies);
			
			target = "view-all.jsp";
			
		} catch (final MovieSearchException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
