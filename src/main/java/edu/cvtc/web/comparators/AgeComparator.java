/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Person;

/**
 *
 * @author txiong55
 *
 */
public class AgeComparator implements Comparator<Person>{

	@Override
	public int compare(Person firstPerson, Person secondPerson) {
		return firstPerson.getAge().compareTo(secondPerson.getAge());
	}

}
