package seedu.addressbook.data.person;

public class AddressStreet {
	private String value;
	private boolean isPrivate;
	
	public AddressStreet(String street) {
		this.value = street;
	}

	@Override
	public String toString(){
		return value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressStreet // instanceof handles nulls
                && this.value.equals(((AddressStreet) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
