package GUI;

import Code.Patient;
import Controller.PatientArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePatient {
    private JPanel panelMain;
    private JTextField txtPatientID;
    private JTextField txtPatientName;
    private JTextField txtPatientEmail;
    private JButton removeButton;
    private JButton addButton;

    private PatientArray p1 = new PatientArray(10); // Initialize with array size 10

    // Constructor
    public ManagePatient() {
        // Initialize components manually if not using GUI Designer
        panelMain = new JPanel();
        txtPatientID = new JTextField(15);
        txtPatientName = new JTextField(15);
        txtPatientEmail = new JTextField(15);
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        // Add components to panel
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(new JLabel("Patient ID:"));
        panelMain.add(txtPatientID);
        panelMain.add(new JLabel("Patient Name:"));
        panelMain.add(txtPatientName);
        panelMain.add(new JLabel("Patient Email:"));
        panelMain.add(txtPatientEmail);
        panelMain.add(addButton);
        panelMain.add(removeButton);

        // Add button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtPatientID.getText());
                    String name = txtPatientName.getText();
                    String email = txtPatientEmail.getText();

                    Patient obj1 = new Patient(id, name, email);

                    p1.addDetail(obj1); // Add Patient to array
                    JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtPatientID.getText());

                    boolean isDeleted = p1.findAndDelete(id); // Call findAndDelete method
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(null, "Patient Removed Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Patient with ID " + id + " not found");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format");
                }
            }
        });
    }

    public JPanel getPanel() {
        return panelMain;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Manage Patient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ManagePatient().getPanel());
        frame.setSize(400, 300); // Adjust size as needed
        frame.setVisible(true);
    }
}
