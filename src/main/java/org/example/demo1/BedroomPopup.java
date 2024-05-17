package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.Manage.*;
import org.example.demo1.otherClasses.Account;

public class BedroomPopup {
    @FXML
    private Button saveBtn;
    @FXML
    private RadioButton rsingleRoom;
    @FXML
    private ToggleGroup roomSize;
    @FXML
    private RadioButton rdoubleRoom;
    @FXML
    private RadioButton rlarge;
    @FXML
    private RadioButton rac;
    @FXML
    private RadioButton rbalcony;
    @FXML
    private RadioButton rattached;
    @FXML
    private AnchorPane anchorPane; // Add the AnchorPane

    public void handleSave(ActionEvent actionEvent) {
        Room room;
        if(rsingleRoom.isSelected()){
            room = new SingleRoom();
        }
        else if(rdoubleRoom.isSelected()){
            room = new DoubleRoom();
        }else {
            room = new LargeRoom();
        }
        if(rac.isSelected()){
            room = new AirConditioner(room);
        }
        if(rbalcony.isSelected()){
            room = new Balcony(room);
        }
        if(rattached.isSelected()){
            room = new AttachedBath(room);
        }
        Account.rooms.add(room);

        // Close the window
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        
        stage.close();
    }
}
