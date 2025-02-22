package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.ContactService;
import main.Contact;

public class ContactServiceTest {
    @Test
    void testGetInstanceContactService()
    {
        Assertions.assertNotNull(ContactService.getInstanceContactService());
    }

    @Test
    void testAddContact()
    {
         // Create a new contact object
        Contact contact = new Contact("Id10char12", "name10char", "lastname10", "2123459813", "30charslongatmost");
        // Add the contact object to hashMap
        ContactService.getInstanceContactService().addContact(contact);
        // Check if addContact is working correctly
        assertTrue(contact.equals(ContactService.getInstanceContactService().contactList.get("Id10char12")));
    }
    
    @Test
    void testDeleteContact()
    {
        // Create a new contact object
        Contact contact = new Contact("Id10char12", "name10char", "lastname10", "2123459813", "30charslongatmost");
        // Add the contact object to hashMap
        ContactService.getInstanceContactService().addContact(contact);
        
        //Delete the contact
        ContactService.getInstanceContactService().deleteContact("Id10char12");
        // Check if deleteContact is working correctly
        assertFalse(ContactService.getInstanceContactService().contactList.containsValue(contact));

    }
   
    @Test
    void testUpdateContact()
    {
        // Create a new contact object
        Contact contact = new Contact("12345", "name10char", "lastname10", "2123459813", "30charslongatmost");
        // Add the contact object to hashMap
        ContactService.getInstanceContactService().addContact(contact);

        // Create a new contact object with the same id to update the hashMap
        Contact newContact = new Contact("12345", "newfirst", "newlast", "1234567890", "NewAddress");
        // Update the hashMap
        ContactService.getInstanceContactService().updateContact("12345", newContact);
        //Check to see if hashMap updated correctly
        assertTrue(newContact.equals(ContactService.getInstanceContactService().contactList.get("12345")));
    }
    
}
