package test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import main.Contact;

public class ContactTest {
    @Test // Tests to see if the parameters being passed are accepted and stored
    public void testCorrectContactParameters()
    {
        Contact contact = new Contact("Id10char12", "name10char", "lastname10", "2123459813", "30charslongatmost");
        assertTrue(contact.getId().equals("Id10char12"));
        assertTrue(contact.getFirstName().equals("name10char"));
        assertTrue(contact.getLastName().equals("lastname10"));
        assertTrue(contact.getPhoneNumber().equals("2123459813"));
        assertTrue(contact.getAddress().equals("30charslongatmost"));
    }

    @Test // Tests to see if the setters are working correctly
    public void testCorrectSetters()
    {
        Contact contact = new Contact("Id10char12", "name10char", "lastname10", "2123459813", "30charslongatmost");
        contact.setFirstName("Naruto");
        contact.setLastName("Uzumaki");
        contact.setPhoneNumber("1112224444");
        contact.setAddress("HiddenLeafVillage");

        assertTrue(contact.getFirstName().equals("Naruto"));
        assertTrue(contact.getLastName().equals("Uzumaki"));
        assertTrue(contact.getPhoneNumber().equals("1112224444"));
        assertTrue(contact.getAddress().equals("HiddenLeafVillage"));
    }

    @CsvSource({
        // Testing the ID parameter
        ", First, Last, 1112224444, address", // Tests for Null ID value
        "'', First, Last, 1112224444, address", // Tests for Blank ID value
        "1234567890123, First, Last, 1112224444, address", // Tests for Too Long ID values
        //Testing the firstName parameter
        "123, , Last, 1112224444, address", // Tests for Null firstName value
        "123, '', Last, 1112224444, address", // Tests for Blank firstName value 
        "123, FirstNameTooLong, Last, 1112224444, address", // Tests for Too Long firstName values
        // Testing the lastName parameter
        "123, First, , 1112224444, address", // Tests for Null lastName value
        "123, First, '', 1112224444, address", // Tests for Blank lastName value
        "123, First, LastNameTooLong, 1112224444, address", // Tests for Too Long lastName values
        // Testing the phoneNumber parameter
        "123, First, Last, , address", // Tests for Null phoneNumber value
        "123, First, Last, ' ', address", // Tests for Blank phoneNumber value
        "123, First, Last, 11122244445555, address", // Tests for Too Long phoneNumber values
        "123, First, Last, abc2224444, address", // Tests for Letters in phoneNumber value
        "123, First, Last, 11-22-4444, address", // Tests for Punctuations in phoneNumber value
        "123, First, Last, 11 222 444, address", // Tests for Spaces in phoneNumber value
        // Testing the address parameter
        "123, First, Last, 1112224444, ", // Tests for Null address value
        "123, First, Last, 1112224444, ''", // Tests for Blank address value
        "123, First, Last, 1112224444, addressoneaddresstwoaddressthreeaddressfour", // Tests for Too Long address values (addressone = 10 chars long)
    })
    
    @ParameterizedTest // Tests to see if program handles null, blank, and incorrect values 
    public void testIncorrectValues(String id, String firstName, String lastName, String phoneNumber, String address)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(id, firstName, lastName, phoneNumber, address);
        });
    }


}
