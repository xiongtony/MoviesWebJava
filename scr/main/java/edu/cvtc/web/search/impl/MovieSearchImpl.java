/**
 * 
 */
package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.LengthInMinComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.comparators.TitleComparator;
import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.predicates.DirectorPredicate;
import edu.cvtc.web.predicates.LengthInMinPredicate;
import edu.cvtc.web.predicates.TitlePredicate;
import edu.cvtc.web.search.MovieSearch;


/**
 * @author txiong55
 *
 */
public class MovieSearchImpl implements MovieSearch {

	private MovieDao movieDao = new MovieDaoImpl();
	
	@Override
	public List<Movie> retrieveMovies(String sortType) throws MovieSearchException {

		try {
			
			final List<Movie> movies = movieDao.retrieveMovies();
			
			if (null != sortType) {
				sortMovies(movies, sortType);
			}
			
			return movies;
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("The list of movies could not be retrieved from the database");
		}
	}

		
	
	private void sortMovies(final List<Movie> movies, final String sortType) {
		switch (sortType) {
			case SortBy.LENGTH_IN_MIN:
				Collections.sort(movies, new LengthInMinComparator());
				break;
			case SortBy.DIRECTOR:
				Collections.sort(movies, new DirectorComparator());
				break;
			case SortBy.TITLE:
				Collections.sort(movies, new TitleComparator());
				break;
			default:
				break;
		}
	}

	@Override
	public List<Movie> findMoviesByTitle(final String title) throws MovieSearchException {
		
		try {
			
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new TitlePredicate(title)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by title name.");
		}
		
	}



	@Override
	public List<Movie> findMoviesByDirector(final String director) throws MovieSearchException {
		
		try {
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new DirectorPredicate(director)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by director name.");
		}
	}



	@Override
	public List<Movie> findMoviesByLengthInMin(int lengthInMin) throws MovieSearchException {
		
		try {
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new LengthInMinPredicate(lengthInMin)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new MovieSearchException("Could not find movie(s) by length in minutes.");
		}
	}

	
}
		
		

