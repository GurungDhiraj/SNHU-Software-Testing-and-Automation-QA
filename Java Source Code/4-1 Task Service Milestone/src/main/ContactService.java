package main;

import java.util.HashMap;

public class ContactService {
    // Object of contact Service
    private static ContactService instance;

    // Create a hashmap to contain the contact list
    public HashMap<String, Contact> contactList = new HashMap<>();

    // private constructor
    private ContactService(){}

    public static ContactService getInstanceContactService()
    {
        // Create an instance of the ContactService if one doesn't already exist
        if (instance == null)
        {
            instance = new ContactService();
        }
        return instance;
    
    }

    public void addContact(Contact contact)
    {
        // Only add if the unique id is not already there
        contactList.putIfAbsent(contact.getId(), contact);
    }

    public void deleteContact(String id)
    {
        // Remove the given key value pairs from hashMap
        contactList.remove(id);
    }

    public void updateContact(String id, Contact newContact)
    {   
        // Store info from Hashmap into a temporary contact object
        Contact tempContact = contactList.get(id);
        
        // Check to see if the hashMap has the given id
        if(tempContact == null)
        {
            throw new IllegalArgumentException("Contact Does Not Exist");
        }
        else
        {
            // If hashMap does contain the given id then update the data
            contactList.replace(id, newContact);
        }

    }
}
