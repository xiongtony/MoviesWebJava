package edu.cvtc.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.dao.PersonDao;
import edu.cvtc.web.dao.impl.PersonDaoImpl;
import edu.cvtc.web.exceptions.PersonDatabaseException;
import edu.cvtc.web.model.Person;

/**
 * Servlet implementation class AddPersonController
 */
@WebServlet("/addPerson")
public class AddPersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			
			final String firstName = request.getParameter("firstName");
			final String lastName = request.getParameter("lastName");
			final int age = Integer.parseInt(request.getParameter("age"));
			final String favoriteColor = request.getParameter("favoriteColor");
			
			final Person person = new Person(firstName, lastName, age, favoriteColor);
			
			final PersonDao personDao = new PersonDaoImpl();
			personDao.insertPerson(person);
			
			request.setAttribute("success", "Success, a new person was added to the database.");
			target = "success.jsp";
			
		} catch (PersonDatabaseException e){
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
