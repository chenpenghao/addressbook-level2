package seedu.addressbook.data.tag;

import java.util.ArrayList;

import seedu.addressbook.data.person.Person;

public class Tagging {
	private Person personTagged;
	private Tag tag;
	private boolean isAdded;
	public static ArrayList<Tagging> totalTaggings;
	public enum TaggingType {ADD, DELETE}
	
	public Tagging(Person personTagged, Tag tag, boolean isAdded){
		this.personTagged = personTagged;
		this.tag = tag;
		this.isAdded = isAdded;
		Tagging.totalTaggings.add(this);
		
	}
}
