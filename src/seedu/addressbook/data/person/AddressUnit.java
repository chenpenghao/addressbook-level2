package seedu.addressbook.data.person;

public class AddressUnit {
	private String value;
	private boolean isPrivate;
	
	public AddressUnit(String block){
		this.value = block;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressUnit // instanceof handles nulls
                && this.value.equals(((AddressUnit) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

}
