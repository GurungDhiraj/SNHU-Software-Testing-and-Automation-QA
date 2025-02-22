package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Appointment;
import main.AppointmentService;

public class AppointmentServiceTest {
     @Test
    void testGetInstanceAppointmentService()
    {
        Assertions.assertNotNull(AppointmentService.getInstanceAppointmentService());
    }

    @Test
    void testAddappointment()
    {
        // Create a temp date variable
        Calendar tempDate = Calendar.getInstance(); 
        tempDate.set(2027, 04, 23);

        // Create a new Appointment object
        Appointment appointment = new Appointment("apptID123", tempDate, "LongLongAppointmentDescription");
        
        // Add the appointment object to hashMap
        AppointmentService.getInstanceAppointmentService().addAppointment(appointment);
        
        // Check if addAppointment is working correctly
        assertTrue(appointment.equals(AppointmentService.getInstanceAppointmentService().appointmentList.get("apptID123")));
    }
    
    @Test
    void testDeleteappointment()
    {
        // Create a temp date variable
        Calendar tempDate = Calendar.getInstance(); 
        tempDate.set(2027, 04, 23);

        // Create a new Appointment object
        Appointment appointment = new Appointment("apptID123", tempDate, "LongLongAppointmentDescription");
        
        // Add the appointment object to hashMap
        AppointmentService.getInstanceAppointmentService().addAppointment(appointment);
        
        //Delete the appointment
        AppointmentService.getInstanceAppointmentService().deleteAppointment("apptID123");
        
        // Check if deleteAppointment is working correctly
        assertFalse(AppointmentService.getInstanceAppointmentService().appointmentList.containsValue(appointment));

    }
   
   
}
