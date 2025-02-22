package main;

import java.util.Calendar;
public class Appointment {
    private String appointmentID;
    private Calendar appointmentDate;
    private String appointmentDescription;

    public Appointment(String appointmentID, Calendar appointmentDate, String appointmentDescription)
    {
        // set the parameters to be equal to the parameters of the object 
        setAppointmentID(appointmentID);
        setAppointmentDate(appointmentDate); 
        setAppointmentDescription(appointmentDescription);
    }

     // Getter for appointmentID 
     public String getAppointmentID(){return appointmentID;}

     // Setter for appointmentID = private so it can't be changed outside of the class
     private void setAppointmentID(String appointmentID)
    {
        // Check to see if the appointmentID meets the requirements
        if(appointmentID == null || appointmentID.isEmpty() || appointmentID.length() > 10)
        {
            throw new IllegalArgumentException("Invalid Appointment ID");
        }
 
        // set value for appointmentID
        this.appointmentID = appointmentID;
    }

    // Getter for appointmentDate
    public Calendar getAppointmentDate(){return appointmentDate;}

    // Setter for appointmentDate
    public void setAppointmentDate(Calendar appointmentDate) 
    {     
        // Check to see if the appointmentDate meets the requirements
        if(appointmentDate == null || appointmentDate.before(Calendar.getInstance()))
        {
            throw new IllegalArgumentException("Invalid Appointment Date");
        }
        // set value for appointmentDate
        this.appointmentDate = appointmentDate;
    }
    
    // Getter for appointmentDescription
    public String getAppointmentDescription(){return appointmentDescription;}

    // Setter for appointmentDescription
    public void setAppointmentDescription(String appointmentDescription) 
    {
        // Check to see if the appointmentDescription meets the requirements
        if(appointmentDescription == null || appointmentDescription.isEmpty() || appointmentDescription.length() > 50)
        {
            throw new IllegalArgumentException("Invalid Appointment Description");
        }

        // set value for appointmentDescription
        this.appointmentDescription = appointmentDescription;
    }
}





    