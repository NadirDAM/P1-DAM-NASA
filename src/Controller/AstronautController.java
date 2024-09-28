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
        addListeners();
    }

    private void populateAstronautDetails() {
        int usId = 1; // Assuming user ID is 1 for demonstration
        model.fetchAstronautDetails(usId);

        view.setName(model.getName());
        view.setGenre("Genre"); // Dummy data or implement getter in the model
        view.setAge("Age"); // Dummy data or implement getter in the model
        view.setAddress(model.getAddress());
        view.setFirstFly(model.getFirstFly());
        view.setSuccessMission(model.getSuccessMission());
        view.setFailMission(model.getFailMission());
        view.setRange(model.getRange());
    }

    private void addListeners() {
        view.getSendButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCoordinatesInput();
            }
        });

        view.getSendButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEncryptedMessage();
            }
        });
    }

    private void handleCoordinatesInput() {
        String coord1 = view.getCoordinateField1().getText();
        String coord2 = view.getCoordinateField2().getText();
        String coord3 = view.getCoordinateField3().getText();

        if (isValidCoordinate(coord1) && isValidCoordinate(coord2) && isValidCoordinate(coord3)) {
            String coordinates = coord1 + " " + coord2 + " " + coord3;
            JOptionPane.showMessageDialog(view, "Coordinates entered: " + coordinates);
        } else {
            JOptionPane.showMessageDialog(view, "Invalid coordinates format. Expected: GGG MM SS [NSEW]");
        }
    }

    private boolean isValidCoordinate(String coordinate) {
        return coordinate.matches("\\d{3} \\d{2} \\d{2} [NSEW]");
    }

    private void handleEncryptedMessage() {
        String message = view.getEncryptedMessageField().getText();
        String encryptedMessage = encryptMessage(message);
        JOptionPane.showMessageDialog(view, "Encrypted Message: " + encryptedMessage);
    }

    private String encryptMessage(String message) {
        return message.replaceAll("[AEIOUaeiou]", "");
    }
}