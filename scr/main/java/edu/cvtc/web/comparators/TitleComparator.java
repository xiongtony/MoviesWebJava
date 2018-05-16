/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;



/**
 * @author txiong55
 *
 */
public class TitleComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie firstPerson, Movie secondPerson) {
		
		return firstPerson.getTitle().compareTo(secondPerson.getTitle());
	}

}
