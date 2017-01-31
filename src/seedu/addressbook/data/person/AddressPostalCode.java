package seedu.addressbook.data.person;

public class AddressPostalCode {
	private String value;
	private boolean isPrivate;
	
	public AddressPostalCode(String postalCode){
		this.value = postalCode;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressPostalCode // instanceof handles nulls
                && this.value.equals(((AddressPostalCode) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}