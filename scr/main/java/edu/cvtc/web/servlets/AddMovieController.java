package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieDatabaseException;
import edu.cvtc.web.model.Movie;


/**
 * Servlet implementation class AddPersonController
 */
@WebServlet("/addMovie")
public class AddMovieController extends HttpServlet {
	
	private static final long serialVersionUID = -1126222621881223101L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final String title = request.getParameter("title");
			final String director = request.getParameter("director");
			final int lengthInMin = Integer.parseInt(request.getParameter("lengthInMin"));

			
			final Movie movie = new Movie(title, director, lengthInMin);
			
			final MovieDao movieDao = new MovieDaoImpl();
			movieDao.insertMovie(movie);
			
			request.setAttribute("success", "Success, a new movie was added to the database.");
			target = "success.jsp";
			
		} catch (MovieDatabaseException e){
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
