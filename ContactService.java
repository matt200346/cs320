// Matthew Eaton
//05/19/2022
// SNHU CS-320
// Milestone 1
// this file is used as the basis for ContactService and relies and used Contact.java. I used a hash table, because of the fast lookup time. requirements were given and are below

//requirements:
//
//TODO The contact service shall be able to add contacts with a unique ID.
//TODO The contact service shall be able to delete contacts per contact ID.
//TODO The contact service shall be able to update contact fields per contact ID. The following fields are updatable:
//TODO    firstName
//TODO    lastName
//TODO    Number
//TODO    Address

package contact;

import java.util.Random;
import java.util.HashMap;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.lang.Math;
//import java.io.*;

public class ContactService {
    // initialize variables
    private final long ID_UPPERBOUND = 10000000000L;
    private String contactId;
    // create a random object to create random numbers for the id
    Random rand = new Random();
    // create a formatting object to ensure that the id is 10 characters long
    NumberFormat formatter = new DecimalFormat("0000000000");
    // create the hash table to store the contact objects
    // with the key being the Id of the contact
    private HashMap<String, Contact> contactMap = new HashMap<>();
    

    // creates and returns a random contactId
    private String newContactId() {

        // create a random long then modulus divide by ID_UPPERBOUND
        // then take the absolute value and format it to make sure it is 10 characters long
        contactId = formatter.format(Math.abs(rand.nextLong() % ID_UPPERBOUND));
        return contactId;
    }
    
    // default new contact with no arguments
    public void newContact() {
    	// generate new Id
    	contactId = newContactId();
    	
    	//check if the hash table is full
    	if (contactMap.size() >= ID_UPPERBOUND) {
    		throw new IllegalArgumentException("Hash table is currently full");
    	}
    	else {
    		// check if the key currently exists in the hash table
    		// if so generate a new id and check again
    		while (contactMap.containsKey(contactId)) {
    			contactId = newContactId();
    		}
    		// create a new contact object with the Id
    		Contact contact = new Contact(contactId);
    		// add the new contact to the hash table
    		contactMap.put(contactId, contact);
    	}
    }
    
    // new contact with 4 arguments passed to it
    public void newContact(String firstName, String lastName, String phoneNumber, String address) {
    	// generate new Id
    	contactId = newContactId();
    	
    	//check if the hash table is full
    	if (contactMap.size() >= ID_UPPERBOUND) {
    		throw new IllegalArgumentException("Hash table is currently full");
    	}
    	else {
    		// check if the key currently exists in the hash table
    		// if so generate a new id and check again
    		while (contactMap.containsKey(contactId)) {
    			contactId = newContactId();
    		}
    		// create a new contact object with the passed arguments
    		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber, address);
    		// add the new contact to the hash table
    		contactMap.put(contactId, contact);
    	}
    }
    
    // new contact with 3 arguments passed to it
    public void newContact(String firstName, String lastName, String phoneNumber) {
    	// generate new Id
    	contactId = newContactId();
    	
    	//check if the hash table is full
    	if (contactMap.size() >= ID_UPPERBOUND) {
    		throw new IllegalArgumentException("Hash table is currently full");
    	}
    	else {
    		// check if the key currently exists in the hash table
    		// if so generate a new id and check again
    		while (contactMap.containsKey(contactId)) {
    			contactId = newContactId();
    		}
    		// create a new contact object with the passed arguments
    		Contact contact = new Contact(contactId, firstName, lastName, phoneNumber);
    		// add the new contact to the hash table
    		contactMap.put(contactId, contact);
    	}
    }
    
    // new contact with 2 arguments passed to it
    public void newContact(String firstName, String lastName) {
    	// generate new Id
    	contactId = newContactId();
    	
    	//check if the hash table is full
    	if (contactMap.size() >= ID_UPPERBOUND) {
    		throw new IllegalArgumentException("Hash table is currently full");
    	}
    	else {
    		// check if the key currently exists in the hash table
    		// if so generate a new id and check again
    		while (contactMap.containsKey(contactId)) {
    			contactId = newContactId();
    		}
    		// create a new contact object with the passed arguments
    		Contact contact = new Contact(contactId, firstName, lastName);
    		// add the new contact to the hash table
    		contactMap.put(contactId, contact);
    	}
    }
    
    // new contact with 1 arguments passed to it
    public void newContact(String firstName) {
    	// generate new Id
    	contactId = newContactId();
    	
    	//check if the hash table is full
    	if (contactMap.size() >= ID_UPPERBOUND) {
    		throw new IllegalArgumentException("Hash table is currently full");
    	}
    	else {
    		// check if the key currently exists in the hash table
    		// if so generate a new id and check again
    		while (contactMap.containsKey(contactId)) {
    			contactId = newContactId();
    		}
    		// create a new contact object with the passed arguments
    		Contact contact = new Contact(contactId, firstName);
    		// add the new contact to the hash table
    		contactMap.put(contactId, contact);
    	}
    }
    
    // delete the contact with the passed Id from the hash table
    public void deleteContact(String id) {
    	if (contactMap.containsKey(id)) {
    		contactMap.remove(id);
    	}
    	else {
    		throw new IllegalArgumentException("The ID specified does not exist.");
    	}
    }
    
    // update the first name for the contact id given
    public void updateFirstName(String id, String firstName) throws Exception{
    	if (contactMap.containsKey(id)) {
    		contactMap.get(id).setFirstName(firstName);
    	}
    	else {
    		throw new IllegalArgumentException("The ID specified does not exist.");
    	}
    }
    
    // update the last name for the contact id given
    public void updateLastName(String id, String lastName) throws Exception{
    	if (contactMap.containsKey(id)) {
    		contactMap.get(id).setLastName(lastName);
    	}
    	else {
    		throw new IllegalArgumentException("The ID specified does not exist.");
    	}
    }
    
    // update the Phone number for the contact id given
    public void updatePhoneNumber(String id, String phoneNumber) throws Exception{
    	if (contactMap.containsKey(id)) {
    		contactMap.get(id).setPhoneNumber(phoneNumber);
    	}
    	else {
    		throw new IllegalArgumentException("The ID specified does not exist.");
    	}
    }
    
    // update the address for the contact id given
    public void updateAddress(String id, String address) throws Exception{
    	if (contactMap.containsKey(id)) {
    		contactMap.get(id).setAddress(address);
    	}
    	else {
    		throw new IllegalArgumentException("The ID specified does not exist.");
    	}
    }
    
    // getter for the hash table
    protected HashMap<String, Contact> getContactMap() {
    	return contactMap;
    }
    
    // getter for returning last created ID this is for testing, since
    // the Ids are made randomly and the test will not know the Id to find
    // the object in the hash table otherwise
    protected String getLastId() {
		return contactId;
    }

}
