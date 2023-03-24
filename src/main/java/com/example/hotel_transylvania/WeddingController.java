package com.example.hotel_transylvania;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WeddingController {

    @FXML
    private FontAwesomeIconView back;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private MFXTextField email;

    @FXML
    private MFXTextField emailPar;

    @FXML
    private MFXTextField guests;

    @FXML
    private MFXTextField name;

    @FXML
    private MFXTextField namePar;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void backClicked(MouseEvent event) {
        Main.changeScene(event,"Bookings.fxml");
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);
    }
    @FXML
    void submitClicked(MouseEvent event) {
        WeddingDB db = new WeddingDB(name.getText(),email.getText(),namePar.getText(),emailPar.getText(),guests.getText());
    }

    @FXML
    void aboutClicked(MouseEvent event) {
        Main.changeScene(event,"About.fxml");
    }




}
