package seedu.addressbook.data.person;

public class AddressBlock {
	private String value;
	private boolean isPrivate;
	
	public AddressBlock(String block){
		this.value = block;
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddressBlock // instanceof handles nulls
                && this.value.equals(((AddressBlock) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
