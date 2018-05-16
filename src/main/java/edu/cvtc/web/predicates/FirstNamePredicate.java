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
public class FirstNamePredicate implements Predicate<Person>{

	private String firstName;
	
	public FirstNamePredicate(final String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public boolean apply(final Person person) {
		
		return person.getFirstName().equals(firstName);
	}


}
