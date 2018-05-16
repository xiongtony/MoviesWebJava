/**
 * 
 */
package edu.cvtc.web.model;

/**
 * @author txiong55
 *
 *
 */
public class Movie {

	
	private String title;
	private String director;
	private Integer lengthInMin;
	
	
	public Movie(final String title, final String director, final int lengthInMin) {
		this.title = title;
		this.director = director;
		this.lengthInMin = lengthInMin;
	}



	public String getTitle() {
		return title;
	}



	public String getDirector() {
		return director;
	}



	public Integer getLengthInMin() {
		return lengthInMin;
	}



	@Override
	public String toString() {

		return "Moives [title=" + title + ", director=" + director + ", lengthInMin=" + lengthInMin + "]";
		
	}



	
}
