// Matthew Eaton
// 05/19/2022
// SNHU CS-320
// Milestone 1
// this file tests ContactService.java to ensure it meets requirements


package contact;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	// variables with valid information in them
	protected String firstName = "Harry";
	protected String lastName = "Potter";
	protected String phoneNumber = "1234567890";
	protected String address = "4 Privet Drive, Surrey, London";
	
	//variables with invalid info in them
	protected String tooLongFirstName = "Clifford The Big Red Dog";
	protected String tooLongLastName = "Peter The Pepper Picker";
	protected String tooLongPhoneNumber = "354657687909";
	protected String tooLongAddress = "1234 The middle of nowhere, somewhere not on the earth";
	protected String tooShortPhoneNumber = "1234";
	
	// constructor tests for ContactService
	@Test
	void defaultContactServiceTest() {
		ContactService service = new ContactService();
		
		// get the hash table
		HashMap<String, Contact> map = service.getContactMap();
		
		// test default new contact
		service.newContact();
		assertAll("Default Constructor test for ContactService",
				() -> assertNotNull(map.get(service.getLastId()).getContactId()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getFirstName()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getLastName()),
				() -> assertEquals("5555555555", map.get(service.getLastId()).getPhoneNumber()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getAddress()));
		
		// test new contact with first name passed
		service.newContact(firstName);
		assertAll("1 argument Constructor test for ContactService",
				() -> assertNotNull(map.get(service.getLastId()).getContactId()),
				() -> assertEquals(firstName, map.get(service.getLastId()).getFirstName()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getLastName()),
				() -> assertEquals("5555555555", map.get(service.getLastId()).getPhoneNumber()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getAddress()));
		
		// test new contact with first and last name passed
		service.newContact(firstName, lastName);
		assertAll("2 argument Constructor test for ContactService",
				() -> assertNotNull(map.get(service.getLastId()).getContactId()),
				() -> assertEquals(firstName, map.get(service.getLastId()).getFirstName()),
				() -> assertEquals(lastName, map.get(service.getLastId()).getLastName()),
				() -> assertEquals("5555555555", map.get(service.getLastId()).getPhoneNumber()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getAddress()));
		
		// test new contact with 3 arguments
		service.newContact(firstName, lastName, phoneNumber);
		assertAll("3 argument Constructor test for ContactService",
				() -> assertNotNull(map.get(service.getLastId()).getContactId()),
				() -> assertEquals(firstName, map.get(service.getLastId()).getFirstName()),
				() -> assertEquals(lastName, map.get(service.getLastId()).getLastName()),
				() -> assertEquals(phoneNumber, map.get(service.getLastId()).getPhoneNumber()),
				() -> assertEquals("DEFAULT", map.get(service.getLastId()).getAddress()));
		
		// test new contat with 4 arguments
		service.newContact(firstName, lastName, phoneNumber, address);
		assertAll("4 argument Constructor test for ContactService",
				() -> assertNotNull(map.get(service.getLastId()).getContactId()),
				() -> assertEquals(firstName, map.get(service.getLastId()).getFirstName()),
				() -> assertEquals(lastName, map.get(service.getLastId()).getLastName()),
				() -> assertEquals(phoneNumber, map.get(service.getLastId()).getPhoneNumber()),
				() -> assertEquals(address, map.get(service.getLastId()).getAddress()));
	}
	
	// test deleting a contact from the hash table
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		String Id = service.getLastId();
		
		assertAll("delete contact test",
				() -> service.deleteContact(Id));
		// If it was deleted then it should throw an exception since it is not there anymore
		assertThrows(Exception.class,
				() -> service.deleteContact(Id));
	}
	
	// I could only get this to work with a throws exception or putting it in a try catch
	// I thought that a throws exception looked better
	// Test all of the update methods
	@Test
	void updateContactInfoTest() throws Exception{
		ContactService service = new ContactService();
		HashMap<String, Contact> map = service.getContactMap();
		service.newContact();
		
		// test updating the first name and ensure that invalid entries throw an error properly
		service.updateFirstName(service.getLastId(),firstName);
		assertAll("Test that firstName was changed",
				() -> assertEquals(firstName, map.get(service.getLastId()).getFirstName()),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getLastId(), tooLongFirstName)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(service.getLastId(), null)));
		
		// test updating the last name and ensure that invalid entries throw an error properly
		service.updateLastName(service.getLastId(),lastName);
		assertAll("Test that lastName was changed",
				() -> assertEquals(lastName, map.get(service.getLastId()).getLastName()),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getLastId(), tooLongLastName)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateLastName(service.getLastId(), null)));
		
		// test updating the phone number and ensure that invalid entries throw an error properly
		service.updatePhoneNumber(service.getLastId(),phoneNumber);
		assertAll("Test that phoneNumber was changed",
				() -> assertEquals(phoneNumber, map.get(service.getLastId()).getPhoneNumber()),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getLastId(), tooLongPhoneNumber)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getLastId(), null)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getLastId(), tooShortPhoneNumber)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(service.getLastId(), firstName)));
		
		// test updating the address and ensure that invalid entries throw an error properly
		service.updateAddress(service.getLastId(), address);
		assertAll("Test that address was changed",
				() -> assertEquals(address, map.get(service.getLastId()).getAddress()),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getLastId(), tooLongAddress)),
				() -> assertThrows(IllegalArgumentException.class, () -> service.updateAddress(service.getLastId(), null)));
	}
}
