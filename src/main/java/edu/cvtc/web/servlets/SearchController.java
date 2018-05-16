package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exceptions.PersonSearchException;
import edu.cvtc.web.model.Person;
import edu.cvtc.web.search.PersonSearch;
import edu.cvtc.web.search.impl.PersonSearchImpl;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final List<Person> people = new ArrayList<>();
			final PersonSearch personSearch = new PersonSearchImpl();
			
			final String searchType = request.getParameter("searchType");
			
			switch(searchType) {
				case "firstName":
					final String firstName = request.getParameter("firstName");
					people.addAll(personSearch.findPeoplByFirstName(firstName));
					break;
				case "lastName":
					final String lastName = request.getParameter("lastName");
					people.addAll(personSearch.findPeopleByLastName(lastName));
					break;
				
				case "age":
					final Integer age = Integer.parseInt(request.getParameter("age"));
					people.addAll(personSearch.findPeopleByAge(age));
					break;
					
				case "favoriteColor":
					final String favoriteColor = request.getParameter("favoriteColor");
					people.addAll(personSearch.findPeopleByFavoriteColor(favoriteColor));
					break;
				default:
					people.addAll(personSearch.retrievePeople(null));
					break;
			}
			
			request.setAttribute("people", people);
			
			target = "view-all.jsp";
			
		} catch (final PersonSearchException e) {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
