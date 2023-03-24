package com.example.hotel_transylvania;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GalleryController {


    @FXML
    private AnchorPane imagePane;
    @FXML
    private ImageView image;
    private ScrollPane scroll;
    private Stage stage;
    private Parent root;
    private Scene scene;


    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);

    }
@FXML
    public void aboutBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("About.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();
        }
    }
    @FXML
    void backClicked(MouseEvent event) {
        Main.changeScene(event,"Homepage.fxml");
    }

//    public void image1Clicked(ActionEvent event){
//        Image img = new Image("file:src/main/resources/com/example/hotel_transylvania/exterior-06.jpg");
//        image.setImage(img);
//        changeToImage(event);
//
//        image.setOnKeyReleased(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent keyEvent) {
//                if(keyEvent.getCode().equals(KeyCode.ESCAPE))
//                    changeToGallery(event);
//            }
//        });
//    }
//
//    void changeToImage(ActionEvent event){
//        scroll.setVisible(false);
//        imagePane.setVisible(true);
//    }
//
//    void changeToGallery(ActionEvent event){
//        scroll.setVisible(true);
//        imagePane.setVisible(false);
//    }



    @FXML
    void bookingBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Bookings.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();
        }
    }


    @FXML
    void image1Clicked(MouseEvent event) {

    }

    @FXML
    void servicesBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("Services.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
