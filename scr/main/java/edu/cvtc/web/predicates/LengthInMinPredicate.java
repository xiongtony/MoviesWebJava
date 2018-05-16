/**
 * 
 */
package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;



/**
 * @author txiong55
 *
 */
public class LengthInMinPredicate implements Predicate<Movie> {
	
	private int lengthInMin;
	
	public LengthInMinPredicate(final int lengthInMin) {
		this.lengthInMin = lengthInMin;
	}

	@Override
	public boolean apply(final Movie movie) {
		
		return movie.getLengthInMin().equals(lengthInMin);
	}
	
	

}
