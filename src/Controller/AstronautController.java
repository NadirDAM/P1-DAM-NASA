package Controller;

import Model.AstronautModel;
import View.AstronautView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AstronautController {
    private AstronautModel model;
    private AstronautView view;

    public AstronautController(AstronautModel model, AstronautView view) {
        this.model = model;
        this.view = view;

        populateAstronautDetails();
        addListeners(); // Ensure this is called
    }

    private void populateAstronautDetails() {
        int usId = 1; // Assuming user ID is 1 for demonstration
        model.fetchAstronautDetails(usId); // Fetch astronaut details from the model

        view.setName(model.getName());
        view.setGenre(model.getGenre()); // Dummy data or implement getter in the model
        view.setAge(model.getAge()); // Dummy data or implement getter in the model
        view.setAddress(model.getAddress());
        view.setFirstFly(model.getFirstFly());
        view.setSuccessMission(model.getSuccessMissions());
        view.setFailMission(model.getFailMissions());
        view.setRange(model.getRange());
    }

    private void addListeners() {
        view.getSendButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Send button 1 clicked!"); // Debug output
                handleCoordinatesInput();
            }
        });

        view.getSendButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Send button 2 clicked!"); // Debug output
                handleEncryptedMessage();
            }
        });
    }

    private void handleCoordinatesInput() {
        String coord1 = view.getCoordinateField1().getText();
        String coord2 = view.getCoordinateField2().getText();
        String coord3 = view.getCoordinateField3().getText();
    
        // Combine the coordinates into a single string for validation
        String fullCoordinates = coord1 + " " + coord2 + " " + coord3;
    
        if (isValidCoordinate(fullCoordinates)) {
            JOptionPane.showMessageDialog(view, "Coordinates entered: " + fullCoordinates);
        } else {
            JOptionPane.showMessageDialog(view, "Invalid coordinates format. Expected: GGG MM SS [NSEW]");
        }

        view.getCoordinateField1().setText("");
        view.getCoordinateField2().setText("");
        view.getCoordinateField3().setText("");
    }
    

    private boolean isValidCoordinate(String coordinate) {
        return coordinate.matches("\\d{3} \\d{2} \\d{2}(\\.\\d{2})? [NSEW]");
    }

    private void handleEncryptedMessage() {
        String message = view.getEncryptedMessageField().getText();

        // Check if the message is empty
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter a message to encrypt.");
            return;
        }

        // Debugging output
        System.out.println("Original message: " + message);

        String encryptedMessage = encryptMessage(message);
        
        // Debugging output
        System.out.println("Encrypted message: " + encryptedMessage);

        JOptionPane.showMessageDialog(view, "Encrypted Message: " + encryptedMessage);

        view.getEncryptedMessageField().setText("");
    }

    private String encryptMessage(String message) {
        return message.replaceAll("[AEIOUaeiou]", ""); // Removes vowels from the message
    }
}
