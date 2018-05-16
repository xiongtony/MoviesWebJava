/**
 * 
 */
package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.PersonDao;
import edu.cvtc.web.exceptions.PersonDatabaseException;
import edu.cvtc.web.model.Person;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author txiong55
 *
 */
public class PersonDaoImpl implements PersonDao {
	
	private static final String DROP_TABLE_PERSON = "drop table if exists person";
	private static final String CREATE_TABLE_PERSON = "create table person (id integer primary key autoincrement, firstName text, lastName text, "
			+ "age integer, favoriteColor text)";
	private static final String SELECT_ALL_FROM_PERSON = "select * from person";

	
	@Override
	public void populatePersonTable(final String filePath) throws Exception {
		
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try {
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_PERSON);
			statement.executeUpdate(CREATE_TABLE_PERSON);
			
			final File inputFile = new File(filePath);
			final List<Person> people = WorkbookUtility.retrievePeropleFromWorkbook(inputFile);
			
			for (final Person person : people) {
				String insertValues = "insert into person (firstName, lastName, age, favoriteColor) values ('"
						+ person.getFirstName() + "', '"
						+ person.getLastName() + "', "
						+ person.getAge() + ", '"
						+ person.getFavoriteColor() + "');";
				
				System.out.println(insertValues); // Log a message to Console so we can see data being added.
				
				statement.executeUpdate(insertValues); 			
			}
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
	}

	
	@Override
	public List<Person> retrievePeople() throws PersonDatabaseException {
		
		final List<Person> people = new ArrayList<>();
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			statement = connection.createStatement();
			
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet results = statement.executeQuery(SELECT_ALL_FROM_PERSON);
			
			while (results.next()) {
				final String firstName = results.getString("firstName");
				final String lastName = results.getString("lastName");
				final int age = results.getInt("age");
				final String favoriteColor = results.getString("favoriteColor");
				
				final Person person = new Person(firstName, lastName, age, favoriteColor);
				people.add(person);
			}
			
			results.close();
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new PersonDatabaseException("Error retrieving people from the database.");
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return people;
	}


	@Override
	public Integer insertPerson(final Person person) throws PersonDatabaseException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String insertSQL = "insert into person (firstName, lastName, age, favoriteColor) values (?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setInt(3, person.getAge());
			preparedStatement.setString(4, person.getFavoriteColor());
			
			preparedStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			return preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersonDatabaseException("Error adding this person to the database");
		} finally {
			DBUtility.closeConnections(connection, preparedStatement);
		}
		
	}

}
