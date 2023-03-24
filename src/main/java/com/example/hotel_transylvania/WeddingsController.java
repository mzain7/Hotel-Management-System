package com.example.hotel_transylvania;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WeddingsController {
    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);

    }
    @FXML
    void backClicked(MouseEvent event) {

        Main.changeScene(event,"Bookings.fxml");
    }

    @FXML
    void aboutClicked(MouseEvent event) {
        Main.changeScene(event,"About.fxml");
    }
}
