/**
 * 
 */
package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.AgeComparator;
import edu.cvtc.web.comparators.FavoriteColorComparator;
import edu.cvtc.web.comparators.FirstNameComparator;
import edu.cvtc.web.comparators.LastNameComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.dao.PersonDao;
import edu.cvtc.web.dao.impl.PersonDaoImpl;
import edu.cvtc.web.exceptions.PersonSearchException;
import edu.cvtc.web.model.Person;
import edu.cvtc.web.predicates.AgePredicate;
import edu.cvtc.web.predicates.FavoriteColorPredicate;
import edu.cvtc.web.predicates.FirstNamePredicate;
import edu.cvtc.web.predicates.LastNamePredicate;
import edu.cvtc.web.search.PersonSearch;

/**
 * @author txiong55
 *
 */
public class PersonSearchImpl implements PersonSearch {

	private PersonDao personDao = new PersonDaoImpl();

	@Override
	public List<Person> retrievePeople(String sortType) throws PersonSearchException {
		
		try {
			
			final List<Person> people = personDao.retrievePeople();
			
			if (null != sortType) {
				sortPeople(people, sortType);
			}
			
			return people;
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new PersonSearchException("The list of people could not be retrieved from the database");
		}
		
	}
	
	private void sortPeople(final List<Person> people, final String sortType) {
		switch (sortType) {
			case SortBy.AGE:
				Collections.sort(people, new AgeComparator());
				break;
			case SortBy.LAST_NAME:
				Collections.sort(people, new LastNameComparator());
				break;
			case SortBy.FIRST_NAME:
				Collections.sort(people, new FirstNameComparator());
				break;
			case SortBy.FAVORITE_COLOR:
				Collections.sort(people, new FavoriteColorComparator());
				break;
			default:
				break;
		}
	}

	@Override
	public List<Person> findPeopleByLastName(final String lastName) throws PersonSearchException {
		
		try {
			
			
			/*
			//final List<Person> people = personDao.retrievePeople();
			//final Predicate<Person> predicate = new LastNamePredicate(lastName);
			
			//final Collection<Person> filteredPeople = Collections2.filter(people, predicate);
			//Lists.newArrayList(filteredPeople);
			*/
			
			final List<Person> people = personDao.retrievePeople();
			return Lists.newArrayList(Collections2.filter(people, new LastNamePredicate(lastName)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new PersonSearchException("Could not find person(s) by last name.");
		}
		
	}



	@Override
	public List<Person> findPeoplByFirstName(final String firstName) throws PersonSearchException {
		
		try {
			final List<Person> people = personDao.retrievePeople();
			return Lists.newArrayList(Collections2.filter(people, new FirstNamePredicate(firstName)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new PersonSearchException("Could not find person(s) by first name.");
		}
	}
	
	
	public List<Person> findPeopleByAge(final int age)  throws PersonSearchException {
		
		try {
			final List<Person> people = personDao.retrievePeople();
			return Lists.newArrayList(Collections2.filter(people, new AgePredicate(age)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new PersonSearchException("Could not find person(s) by age.");
		}
	}
	
	public List<Person> findPeopleByFavoriteColor(final String favoriteColor) throws PersonSearchException {
		try {
			final List<Person> people = personDao.retrievePeople();
			return Lists.newArrayList(Collections2.filter(people, new FavoriteColorPredicate(favoriteColor)));
			
		} catch (final Exception e) {
			e.printStackTrace();
			throw new PersonSearchException("Could not find person(s) by favorite color.");
		}
	}
	
}
		
		

