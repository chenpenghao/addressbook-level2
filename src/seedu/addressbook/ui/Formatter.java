package seedu.addressbook.ui;
import seedu.addressbook.commands.*;
import seedu.addressbook.data.person.ReadOnlyPerson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;
import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;

public class Formatter {
	
	private final PrintStream out;
	
	public Formatter(PrintStream out){
		this.out = out;
	}

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
	private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    public boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    

	
	/**
	 * Show methods, which takes in a String array and print out according to formats.
	 * @param message
	 */
    
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }
	
    /** Shows a list of strings to the user, formatted as an indexed list. */
    private void showToUserAsIndexedList(List<String> list) {
        showToUser(getIndexedListForViewing(list));
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    public static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Shows a list of persons to the user, formatted as an indexed list.
     * Private contact details are hidden.
     */
    public void showPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        showToUserAsIndexedList(formattedPersons);
    }
    
	
	/**
	 * Make use of the showToUser method, print out the messages to users.
	 * @param version
	 * @param storageFileInfo
	 */
	
	public void showStorageFileInfo(String storageFilePath){
		showToUser(String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath));
	}
	
	public void showWelcomeMessage(String version, String storageFileInfo) {
		showToUser(DIVIDER, DIVIDER, MESSAGE_WELCOME, version, 
				MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE, storageFileInfo, DIVIDER);
	}
	
	public void showGoodbyeMessage() {
		showToUser(MESSAGE_GOODBYE , DIVIDER , DIVIDER);
	}
	
	public void showCommand(String input){
		showToUser("[Command entered:" + input + "]");
	}
	
	public void showCommandEnter(){
		showToUser(LINE_PREFIX + "Enter command: ");
	}
	
	public void showFailedMessage(){
		showToUser(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
	}
	
	public void showResultToUser(CommandResult result) {
		showToUser(result.getFeedbackToUser(), DIVIDER);
	}

}
