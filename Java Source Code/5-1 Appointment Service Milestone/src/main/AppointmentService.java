package main;

import java.util.HashMap;

public class AppointmentService {
    // Object of AppointmentService
    private static AppointmentService instance;

    // Create a hashmap to contain the Appointment list
    public HashMap<String, Appointment> appointmentList = new HashMap<>();

    // private constructor
    private AppointmentService(){}
    
    public static AppointmentService getInstanceAppointmentService()
    {
        // Create an instance of the AppointmentService if one doesn't already exist
        if (instance == null)
        {
            instance = new AppointmentService();
        }
        return instance;
    }

    public void addAppointment(Appointment appointment)
    {
        // Only add if the unique appointmentID is not already there
        appointmentList.putIfAbsent(appointment.getAppointmentID(), appointment);
    }

    public void deleteAppointment(String appointmentID)
    {
        // Remove the given key value pairs from hashMap
        appointmentList.remove(appointmentID);
    }
}
