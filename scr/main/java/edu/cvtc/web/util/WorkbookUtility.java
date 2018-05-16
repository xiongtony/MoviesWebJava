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

import edu.cvtc.web.model.Movie;


/**
 * @author txiong55
 *
 */
public class WorkbookUtility {
	
	// This method returns a list of movie objects from a File.
	public static List<Movie> retrieveMoviesFromWorkbook(final File inputFile) throws InvalidFormatException, IOException {
		
		// Empty list of movies Objects
		final List<Movie> movies = new ArrayList<>();
		
		// Getting the Workbook from our Excel spreadsheet
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		// Getting the first Worksheet in our Workbook
		final Sheet sheet = workbook.getSheetAt(0);
		
		// Iterate over each row in the Worksheet
		for (final Row row : sheet) {
			
			// Retrieve the values from each cell and use them to create a new movie object
			final Cell titleCell = row.getCell(0);
			final Cell directorCell = row.getCell(1);
			final Cell lengthInMinCell = row.getCell(2);
			

			final Movie movie = new Movie (
										titleCell.getStringCellValue().trim(),
										directorCell.getStringCellValue().trim(),
										(int)lengthInMinCell.getNumericCellValue());
			// adding each new movies to the list of movie Object
				movies.add(movie);
			}
		
		// Returns the populated list (but only if there were rows in the worksheet
		return movies;
	}

}
