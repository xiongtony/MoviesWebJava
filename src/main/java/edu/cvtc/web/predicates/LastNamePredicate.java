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
public class LastNamePredicate implements Predicate<Person>{
	
	private String lastName;
	
	public LastNamePredicate(final String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public boolean apply(final Person person) {
		
		return person.getLastName().equals(lastName);
	}


}
