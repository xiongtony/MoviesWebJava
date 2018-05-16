/**
 * 
 */
package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Person;

/**
 * @author txiong55
 *
 */
public class FavoriteColorPredicate implements Predicate<Person> {
	
	private String favoriteColor;
	
	public FavoriteColorPredicate(final String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}
	
	@Override
	public boolean apply(final Person person) {
		
		return person.getFavoriteColor().equals(favoriteColor);
	}

}
