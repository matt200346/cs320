// Matthew Eaton
//05/19/2022
// SNHU CS-320
// Milestone 1
// this file is used as the basis for the contact object requirements were given and are below


// class requirements:
// 
// TODO The contact object shall have a required unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null and shall not be updatable.
// TODO The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
// TODO The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
// TODO The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.
// TODO The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.

package contact;

public class Contact {
   
   // ID max length is 10
   private static final int MAX_ID_LENGTH = 10;
   // first name max length is 10
   private static final int MAX_FIRST_NAME_LENGTH = 10;
   // last name max length is 10
   private static final int MAX_LAST_NAME_LENGTH = 10;
   // a phone number will always be 10 numbers in length (US only)
   private static final int PHONE_NUMBER_LENGTH = 10;
   // address max length is 30
   private static final int MAX_ADDRESS_LENGTH = 30;
   // Initial string value for strings containing letters and numbers
   private static final String DEFAULT_STRING = "DEFAULT";
   // Initial int value for strings containing numbers
   private static final String DEFAULT_INT = "5555555555";
   
   private String contactId;
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String address;
   
   // default constructor
   Contact(){
      this.contactId = DEFAULT_INT;
      this.firstName = DEFAULT_STRING;
      this.lastName = DEFAULT_STRING;
      this.phoneNumber = DEFAULT_INT;
      this.address = DEFAULT_STRING;
   }

   // below are overloaded constructors, because java does not support optional parameters
   // the constructors call the default constructor and then set the proper values to cut down on redundant code

   Contact(String contactId){
      // call default constructor
      this();
      // set passed argument
      setContactId(contactId);
   }
   
   Contact(String contactId, String firstName){
      // call default constructor
      this();
      // set passed arguments
      setContactId(contactId);
      setFirstName(firstName);
   }

   Contact(String contactId, String firstName, String lastName){
      // call default constructor
      this();
      // set passed arguments
      setContactId(contactId);
      setFirstName(firstName);
      setLastName(lastName);
   }

   Contact(String contactId, String firstName, String lastName, String phoneNumber){
      // call default constructor
      this();
      // set passed arguments
      setContactId(contactId);
      setFirstName(firstName);
      setLastName(lastName);
      setPhoneNumber(phoneNumber);
   }

   Contact(String contactId, String firstName, String lastName, String phoneNumber, String address){
      // set passed arguments
      setContactId(contactId);
      setFirstName(firstName);
      setLastName(lastName);
      setPhoneNumber(phoneNumber);
      setAddress(address);
   }

   //************************
   // start of getters
   //************************

   // using final prevents subclasses from overriding it, this helps with security

   protected final String getContactId() {
      return contactId;
   }

   protected final String getFirstName() {
      return firstName;
   }

   protected final String getLastName() {
      return lastName;
   }

   protected final String getPhoneNumber() {
      return phoneNumber;
   }

   protected final String getAddress() {
      return address;
   }

   //**************************
   // start of setters
   //**************************

   // throws an error if it is null or beyond MAX_ID_LENGTH
   // if all checks pass then sets contactId to the argument
   protected final void setContactId(String contactId) {
      if (contactId == null) {
         throw new IllegalArgumentException("contactId is not allowed to be null.");
      }
      else if (contactId.length() > MAX_ID_LENGTH) {
         throw new IllegalArgumentException("Contact Id is not allowed to be longer than " + MAX_ID_LENGTH);
      }
      else {
         this.contactId = contactId;
      }
   }

   // throws an error if it is null or beyond MAX_FIRST_NAME_LENGTH
   // if all checks pass then sets firstName to the argument
   protected final void setFirstName(String firstName) {
      if(firstName == null) {
         throw new IllegalArgumentException("First Name field is not allowed to be empty");
      }
      else if (firstName.length() > MAX_FIRST_NAME_LENGTH) {
         throw new IllegalArgumentException("First Name field is not allowed to exceed " + MAX_FIRST_NAME_LENGTH + " characters in length");
      }
      else {
         this.firstName = firstName;
      }
   }

   // throws an error if it is null or beyond MAX_LAST_NAME_LENGTH
   // if all checks pass then sets lastName to the argument
   protected final void setLastName(String lastName) {
      if(lastName == null) {
         throw new IllegalArgumentException("Last Name field is not allowed to be empty");
      }
      else if (lastName.length() > MAX_LAST_NAME_LENGTH) {
         throw new IllegalArgumentException("Last name field is not allowed to exceed " + MAX_LAST_NAME_LENGTH + " characters in length");
      }
      else {
         this.lastName = lastName;
      }
   }

   // throws an error if it is null, not equal to PHONE_NUMBER_LENGTH, or contains invalid characters
   // if all checks pass then sets phoneNumber to the argument
   protected final void setPhoneNumber(String phoneNumber) {
      if (phoneNumber == null) {
         throw new IllegalArgumentException("Phone Number field is not allowed to be empty");
      }
      else if (phoneNumber.length() != PHONE_NUMBER_LENGTH) {
         throw new IllegalArgumentException("Phone Number must be exactly " + PHONE_NUMBER_LENGTH + " digits in length");
      }
      else if (!(phoneNumber.matches("[0-9]+"))) {
         throw new IllegalArgumentException("Phone Number must only contain numbers");
      }
      else {
         this.phoneNumber = phoneNumber;
      }
   }

   // throws an error if it is null or beyond MAX_ADDRESS_LENGTH
   // if all checks pass then sets address to the argument
   protected final void setAddress(String address) {
      if (address == null) {
         throw new IllegalArgumentException("Address field is not allowed to be empty");
      }
      else if (address.length() > MAX_ADDRESS_LENGTH) {
         throw new IllegalArgumentException("Address is not allowed to exceed " + MAX_ADDRESS_LENGTH + " character in length");
      }
      else {
         this.address = address;
      }
   }
}