package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {
	
	public String value;
	private boolean isPrivate;
	
	public Contact(String contact, boolean isPrivate, String validationRegex, String constraintsMessage) throws IllegalValueException{
		this.isPrivate = isPrivate;
		String trimmedContact = contact.trim();
		if (!isValid(trimmedContact, validationRegex)){
			throw new IllegalValueException(constraintsMessage);
		}
		this.value = trimmedContact;
	}
	
	public static boolean isValid(String test, String validationRegex){
		return test.matches(validationRegex);
	}
	
	public String toString(){
		return value;
	}
	
	public boolean isPrivate(){
		return isPrivate;
	}
	
	public boolean equals(Object other) {
		return other == this 
				|| (other instanceof Contact  // instanceof handles nulls
						&& this.value.equals(((Contact) other).value));
	}
}
