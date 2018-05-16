/**
 * 
 */
package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Person;

/**
 * @author txiong55
 *
 */
public class WorkbookUtility {
	
	// This method returns a list of Person objects from a File.
	public static List<Person> retrievePeropleFromWorkbook(final File inputFile) throws InvalidFormatException, IOException {
		
		// Empty list of Person Objects
		final List<Person> people = new ArrayList<>();
		
		// Getting the Workbook from our Excel spreadsheet
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		// Getting the first Worksheet in our Workbook
		final Sheet sheet = workbook.getSheetAt(0);
		
		// Iterate over each row in the Worksheet
		for (final Row row : sheet) {
			
			// Retrieve the values from each cell and use them to create a new person object
			final Cell firstNameCell = row.getCell(0);
			final Cell lastNameCell = row.getCell(1);
			final Cell ageCell = row.getCell(2);
			final Cell favoriteColorCell = row.getCell(3);
			
			// Creating local variables for our arguments
//			final String firstName = firstNameCell.getStringCellValue().trim();
//			final String lastName = lastNameCell.getStringCellValue().trim();
//			final int age = (int) ageCell.getNumericCellValue();
//			final String favoriteColor = favoriteColorCell.getStringCellValue().trim();
			
//			final Person person = new Person(firstName, lastName, age, favoriteColor);
			final Person person = new Person (
										firstNameCell.getStringCellValue().trim(),
										lastNameCell.getStringCellValue().trim(),
										(int) ageCell.getNumericCellValue(),
										favoriteColorCell.getStringCellValue().trim());
			
			// adding each new person to the list of Person Object
				people.add(person);
			}
		
		// Returns the populated list (but only if there were rows in the worksheet
		return people;
	}

}
