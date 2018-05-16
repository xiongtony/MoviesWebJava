/**
 * 
 */
package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;



/**
 * @author txiong55
 *
 */
public interface MovieSearch {
	
	List<Movie> retrieveMovies(String sortType) throws MovieSearchException;
	
	List<Movie> findMoviesByTitle(String title) throws MovieSearchException;
	
	List<Movie> findMoviesByDirector(String director) throws MovieSearchException;
	
	List<Movie> findMoviesByLengthInMin(int lengthInMin) throws MovieSearchException;


}
