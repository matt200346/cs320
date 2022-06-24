// Matthew Eaton
// 05/19/2022
// SNHU CS-320
// Milestone 1
// this file tests Contact.java to ensure it meets requirements


package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

	// variables with valid information in them
	protected String contactId = "1111111111";
	protected String firstName = "Harry";
	protected String lastName = "Potter";
	protected String phoneNumber = "1234567890";
	protected String address = "4 Privet Drive, Surrey, London";
	
	//variables with invalid info in them
	protected String tooLongContactId = "10000000001";
	protected String tooLongFirstName = "Clifford The Big Red Dog";
	protected String tooLongLastName = "Peter The Pepper Picker";
	protected String tooLongPhoneNumber = "354657687909";
	protected String tooLongAddress = "1234 The middle of nowhere, somewhere not on the earth";
	protected String tooShortPhoneNumber = "1234";
	
	
	// test the default constructor with no arguments for null fields
	@Test
	void contactDefaultConstructorTest() {
		Contact contact = new Contact();
		assertAll("Default constructor", ()-> assertNotNull(contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	// test creating a new contact with a specified contactId
	@Test
	void contactIdConstructorTest() {
		Contact contact = new Contact(contactId);
		assertAll("Contact Constructor with Id as an argument test",
				// ensure that the stored value is the same that was given as an argument
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertNotNull(contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	// test for a new contact with Id and firstName given
	@Test
	void contactFirstNameConstructorTest() {
		Contact contact = new Contact(contactId, firstName);
		assertAll("Contact Constructor with Id and first name as an argument test",
				// ensure that the stored value is the same that was given as an argument
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstName, contact.getFirstName()),
				() -> assertNotNull(contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	// test for new contact with Id, firstName, and lastName given
	@Test
	void contactLastNameConstructorTest() {
		Contact contact = new Contact(contactId, firstName, lastName);
		assertAll("Contact Constructor with 3 arguments test",
				// ensure that the stored value is the same that was given as an argument
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstName, contact.getFirstName()),
				() -> assertEquals(lastName, contact.getLastName()),
				() -> assertNotNull(contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	// test for new contact with Id, firstName, lastName, and phoneNumber given
	@Test
	void contactPhoneNumberConstructorTest() {
		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber);
		assertAll("Contact Constructor with 4 arguments test",
				// ensure that the stored value is the same that was given as an argument
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstName, contact.getFirstName()),
				() -> assertEquals(lastName, contact.getLastName()),
				() -> assertEquals(phoneNumber, contact.getPhoneNumber()),
				() -> assertNotNull(contact.getAddress()));
	}
	
	// test for new contact with Id, firstName, lastName, phoneNumber, and address given
	@Test
	void contactAddressConstructorTest() {
		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
		assertAll("Contact Constructor with 5 arguments test",
				// ensure that the stored value is the same that was given as an argument
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertEquals(firstName, contact.getFirstName()),
				() -> assertEquals(lastName, contact.getLastName()),
				() -> assertEquals(phoneNumber, contact.getPhoneNumber()),
				() -> assertEquals(address, contact.getAddress()));
	}
	
	// Test to make sure that the Id is not allowed to be null and not exceed 10 characters
	@Test
	void setIdTest() {
		Contact contact = new Contact();
		contact.setContactId(contactId);
		// test that the id is the same and that it is not allowed to be null or longer than 10 characters
		assertAll("Id test",
				() -> assertEquals(contactId, contact.getContactId()),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setContactId(null)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setContactId(tooLongContactId)));
	}
	
	// Test to make sure that the firstName is not allowed to be null and not exceed 10 characters
	@Test
	void setFirstNameTest() {
		Contact contact = new Contact();
		contact.setFirstName(firstName);
		// test that the firstName is the same and that it is not allowed to be null or longer than 10 characters
		assertAll("firstName test",
				() -> assertEquals(firstName, contact.getFirstName()),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(null)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(tooLongFirstName)));
	}
	
	// Test to make sure that the lastName is not allowed to be null and not exceed 10 characters
	@Test
	void setLastNameTest() {
		Contact contact = new Contact();
		contact.setLastName(lastName);
		// test that the lastName is the same and that it is not allowed to be null or longer than 10 characters
		assertAll("lastName test",
				() -> assertEquals(lastName, contact.getLastName()),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(null)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(tooLongLastName)));
	}
	
	// Test to make sure that the phoneNumber is not allowed to be null and must be exactly 10 characters
	@Test
	void setPhoneNumberTest() {
		Contact contact = new Contact();
		contact.setPhoneNumber(phoneNumber);
		// test that the phoneNumber is not allowed to be null and must be exactly 10 characters
		assertAll("phoneNumber test",
				() -> assertEquals(phoneNumber, contact.getPhoneNumber()),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setPhoneNumber(null)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setPhoneNumber(tooLongPhoneNumber)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setPhoneNumber(tooShortPhoneNumber)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setPhoneNumber(firstName)));
	}
	
	// Test to make sure that the address is not allowed to be null and not exceed 30 characters
	@Test
	void setAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(address);
		// test that the address is the same and that it is not allowed to be null or longer than 30 characters
		assertAll("address test",
				() -> assertEquals(address, contact.getAddress()),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(null)),
				() -> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(tooLongAddress)));
	}
}
