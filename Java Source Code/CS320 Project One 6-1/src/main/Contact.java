package main;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String id, String firstName, String lastName, String phoneNumber, String address)
    {
        // set the parameters to be equal to the parameters of the object if the conditions pass
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    // Getter for id
    public String getId(){return id;}

    // Setter for id = private so it can't be changed outside of the class
    private void setId(String id)
    {
        // Check to see if the Id meets the requirements
        if(id == null || id.isEmpty() || id.length() > 10)
        {
            throw new IllegalArgumentException("Invalid Id");
        }

        // set value for id
        this.id = id;
    }

    // Getter for firstName
    public String getFirstName(){return firstName;}

    // Setter for firstName
    public void setFirstName(String firstName) 
    {
        // Check to see if the firstName meets the requirements
        if(firstName == null || firstName.isEmpty() || firstName.length() > 10)
        {
            throw new IllegalArgumentException("Invalid firstName");
        }
        // set value for firstName
        this.firstName = firstName;
    }

    // Getter for lastName
    public String getLastName(){return lastName;}

    // Setter for lastName
    public void setLastName(String lastName) 
    {
        // Check to see if the lastName meets the requirements
        if(lastName == null || lastName.isEmpty() || lastName.length() > 10)
        {
            throw new IllegalArgumentException("Invalid lastName");
        }

        // set value for lastName
        this.lastName = lastName;
    }

    // Getter for phoneNumber
    public String getPhoneNumber(){return phoneNumber;}

    // Setter for phoneNumber
    public void setPhoneNumber(String phoneNumber) 
    {
        // Check to see if the phoneNumber meets the requirements
        if(phoneNumber == null || phoneNumber.isEmpty() || phoneNumber.length() != 10 || phoneNumber.matches(".*\\D+.*"))
        {
            throw new IllegalArgumentException("Invalid phoneNumber");
        }

        // set value for phoneNumber
        this.phoneNumber = phoneNumber;
    }

    // Getter for address
    public String getAddress(){return address;}

    // Setter for address
    public void setAddress(String address) 
    {
        // Check to see if the address meets the requirements
        if(address == null || address.isEmpty() || address.length() > 30)
        {
            throw new IllegalArgumentException("Invalid address");
        }

        // set value for address
        this.address = address;
    }
    
}
