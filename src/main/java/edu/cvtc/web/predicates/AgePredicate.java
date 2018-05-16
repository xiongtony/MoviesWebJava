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
public class AgePredicate implements Predicate<Person> {
	
	private int age;
	
	public AgePredicate(final int age) {
		this.age = age;
	}
	
	@Override
	public boolean apply(final Person person) {
		
		return person.getAge().equals(age);
	}	

}
