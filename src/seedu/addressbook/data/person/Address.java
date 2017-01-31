package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    
    /**
     * indices for components of an address
     */
	private static final int COMPONENTS_BLOCK = 0;
	private static final int COMPONENTS_STREET = 1;
	private static final int COMPONENTS_UNIT = 2;
	private static final int COMPONENTS_POSTALCODE = 3;

    private boolean isPrivate;
    
    /**
     * Different components of the address
     */
    private static AddressBlock block;
    private static AddressStreet street;
    private static AddressUnit unit;
    private static AddressPostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        String[] components = trimmedAddress.split(",");
        createComponents(components);
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }

    private void createComponents(String[] components) {
        this.setBlock(new AddressBlock(components[COMPONENTS_BLOCK]));
        this.setStreet(new AddressStreet(components[COMPONENTS_STREET]));
        this.setUnit(new AddressUnit(components[COMPONENTS_UNIT]));
        this.setPostalCode(new AddressPostalCode(components[COMPONENTS_POSTALCODE]));
		
	}

	/**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        String res = this.getBlock().toString() + ","
        		+ this.getStreet().toString()
        		+ this.getUnit().toString()
        		+ this.getPostalCode().toString();
        return res;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.getBlock().equals(((Address) other).getBlock())
                && this.getStreet().equals(((Address) other).getStreet())
                && this.getUnit().equals(((Address) other).getUnit())
                && this.getPostalCode().equals(((Address) other).getPostalCode())); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }

	public AddressBlock getBlock() {
		return block;
	}

	public void setBlock(AddressBlock block) {
		Address.block = block;
	}

	public AddressStreet getStreet() {
		return street;
	}

	public void setStreet(AddressStreet street) {
		Address.street = street;
	}

	public AddressUnit getUnit() {
		return unit;
	}

	public void setUnit(AddressUnit unit) {
		Address.unit = unit;
	}

	public AddressPostalCode getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(AddressPostalCode postalCode) {
		Address.postalCode = postalCode;
	}
}
