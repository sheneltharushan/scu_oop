package Controller;

import Code.Patient;

public class PatientArray {
    public Patient[] pArray; // Declare the array to store Patient objects
    private int maxSize;
    private int index;

    // Constructor to initialize the array
    public PatientArray(int maxSize) {
        this.maxSize = maxSize;
        this.pArray = new Patient[maxSize]; // Initialize the array
        this.index = 0; // Start with the first index
    }

    // Method to add a Patient object to the array
    public void addDetail(Patient s) {
        if (index < maxSize) {
            pArray[index] = s; // Store the Patient object in the array
            index++;
        } else {
            System.out.println("Patient array is full!");
        }
    }

    // Method to find and delete a Patient object by ID
    public boolean findAndDelete(int id) {
        for (int i = 0; i < index; i++) {
            if (pArray[i] != null && pArray[i].patientId == id) {
                // Shift elements to remove the patient
                for (int j = i; j < index - 1; j++) {
                    pArray[j] = pArray[j + 1];
                }
                pArray[index - 1] = null; // Clear the last element
                index--; // Decrease the count
                return true; // Deletion successful
            }
        }
        return false; // Patient not found
    }

    // Method to display all patients in the array
    public void displayPatients() {
        if (index == 0) {
            System.out.println("No patients available.");
            return;
        }
        for (int i = 0; i < index; i++) {
            if (pArray[i] != null) {
                System.out.println(pArray[i].toString());
            }
        }
    }
}
