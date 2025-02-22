package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import main.Appointment;

public class AppointmentTest {
    @Test // Check if parameters are being passed, accepted, and stored
    public void testCorrectAppointmentParameters()
    {
        // Create a temp date variable
        Calendar tempDate = Calendar.getInstance(); 
        tempDate.set(2027, 04, 23);
        
        Appointment appointment = new Appointment("apptID123", tempDate, "LongLongAppointmentDescription");
        assertTrue(appointment.getAppointmentID().equals("apptID123"));
        assertTrue(appointment.getAppointmentDate().equals(tempDate));
        assertTrue(appointment.getAppointmentDescription().equals("LongLongAppointmentDescription"));
    }

    @Test // Tests to see if the setters are working correctly
    public void testCorrectAppointmentSetters()
    {
        // Create a temp date variable
        Calendar tempDate = Calendar.getInstance(); 
        tempDate.set(2027, 04, 23);

        // Create new Date to set
        Calendar newDate = Calendar.getInstance();
        newDate.set(2040, 07, 19);

        Appointment appointment = new Appointment("apptID123", tempDate, "LongLongAppointmentDescription");
        // Use the setters to set new string values
        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentDescription("NEWLongLongAppointmentDescription");

        // Check if the new string values are set correctly
        assertTrue(appointment.getAppointmentDate().equals(newDate));
        assertTrue(appointment.getAppointmentDescription().equals("NEWLongLongAppointmentDescription"));
    }

    @Test // Tests to see if program handles null values
    public void testNullAppointmentValues()
    {
        // Create a temp date variable
        Calendar tempDate = Calendar.getInstance(); 
        tempDate.set(2027, 04, 23);
        

        // Test for null appointmentID
        IllegalArgumentException appointmentIDNullException = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, tempDate, "LongLongAppointmentDescription");
        });

        // Test for null appointmentDate
        IllegalArgumentException appointmentDateNullException = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("apptID123", null, "LongLongAppointmentDescription");
        });

        // Test for null appointmentDescription
        IllegalArgumentException appointmentDescriptionNullException = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("apptID123", tempDate, null);
        });

        // Check to see if the correct error message pops up
        assertTrue("Invalid Appointment ID".equals(appointmentIDNullException.getMessage()));
        assertTrue("Invalid Appointment Date".equals(appointmentDateNullException.getMessage()));
        assertTrue("Invalid Appointment Description".equals(appointmentDescriptionNullException.getMessage()));
    }

    @Test // Tests to see if program handles large values
    public void testLargeAppointmentValues()
    {
        // Create a temp date variable
        Calendar tempDate = Calendar.getInstance(); 
        tempDate.set(2027, 04, 23);

        // Test for large appointmentID 
        IllegalArgumentException largeAppointmentIDException = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ApptID123456789", tempDate, "LongLongAppointmentDescription");
        });

         // Test for large appointmentDescription
         IllegalArgumentException largeAppointmentDescriptionException = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("apptID123", tempDate, "TooLongLongAppointmentDescriptionTooLongLongAppointmentDescriptionTooLongLongAppointmentDescription");
        });

        // Check to see if the correct error message pops up
        assertTrue("Invalid Appointment ID".equals(largeAppointmentIDException.getMessage()));
        assertTrue("Invalid Appointment Description".equals(largeAppointmentDescriptionException.getMessage()));

    }

    @Test // Tests to see if program can handle incorrect date values
    public void testIncorrectAppointmentDates()
    {
        // Create a date variable with past date
        Calendar pastDate = Calendar.getInstance(); 
        pastDate.set(2023, 04, 23);
        
        // Test for null appointmentDate
        IllegalArgumentException wrongAppointmentDateException = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("apptID123", pastDate, "LongLongAppointmentDescription");
        });

        assertTrue("Invalid Appointment Date".equals(wrongAppointmentDateException.getMessage()));
    }
}
