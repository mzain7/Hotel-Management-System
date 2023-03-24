package com.example.hotel_transylvania;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Booking{

    @FXML
    private FontAwesomeIconView back;

    @FXML
    private MFXButton bookNow;

    @FXML
    private MFXTextField card;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private MFXTextField code;

    @FXML
    private MFXDatePicker inDate;

    @FXML
    private MFXTextField month;

    @FXML
    private MFXButton next;

    @FXML
    private MFXTextField nights;

    @FXML
    private AnchorPane payment;

    @FXML
    private ImageView paymentImg;

    @FXML
    private Text roomName;

    @FXML
    private MFXScrollPane scroll;

    @FXML
    private Text text;

    @FXML
    private Text totalPayment;

    @FXML
    private MFXTextField year;

    String price;

    static String username;

    @FXML
    private Text cardError;

    @FXML
    private Text yearError;
    @FXML
    private Text monthError;
    @FXML
    private Text codeError;


    @FXML
    void backClicked(MouseEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Bookings.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Main.close(stage);
    }

    @FXML
    void bookClicked(MouseEvent event){
        ObservableList<Node> list = (((AnchorPane)((MFXButton)event.getSource()).getParent()).getChildren());
        paymentImg.setImage(((ImageView) list.get(1)).getImage());
        roomName.setText(((Text)list.get(2)).getText());
        price = ((Text)list.get(5)).getText().replace("$","");
        changeToPayment(event);
    }

    @FXML
    void back1Clicked(MouseEvent event) {
        scroll.setVisible(true);
        payment.setVisible(false);
    }


    void changeToPayment(MouseEvent event){
        scroll.setVisible(false);
        payment.setVisible(true);
    }

    @FXML
    void calculate(KeyEvent event) {
//        if()
        if(event.getCode().equals(KeyCode.ENTER)) {
            totalPayment.setText(String.valueOf(Float.parseFloat(price) * Integer.parseInt(nights.getText())));
        }
    }

    @FXML
    void nextClicked(MouseEvent event) {
        if(!card.getText().isEmpty()&&!month.getText().isEmpty()&&!year.getText().isEmpty()&&!code.getText().isEmpty() ){
            text.setVisible(true);

//            RoomFile file = new RoomFile(username, roomName.getText(), inDate.getText(), nights.getText(), String.valueOf(totalPayment.getText()));
//            file.writeFile();

            RoomDB database = new RoomDB(username, roomName.getText(), inDate.getText(), nights.getText(), String.valueOf(totalPayment.getText()));

            Main.changeScene(event, "Homepage.fxml");
        }else {
            text.setText("Fields are empty");
            text.setStyle("-fx-text-fill: red;");
            text.setVisible(true);
        }
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @FXML
    void checkCard(KeyEvent event) {

        String str = card.getText().replaceAll("[^0-9]+", "");
        if(CardValidation.validation(Long.parseLong(str))){
            cardError.setText("");
        }else{
            cardError.setText("Invalid Card");
        }
    }

    @FXML
    void codeCheck(KeyEvent event) {
    if(code.getText().length()==4){
        codeError.setText("");
    }else {
        codeError.setText("Invalid Code");
    }
    }

    @FXML
    void yearCheck(KeyEvent event) {
        int check = Integer.parseInt(year.getText());
        if(check >= LocalDate.now().getYear() && check < LocalDate.now().getYear()+10){
            yearError.setText("");
        }else {
            yearError.setText("Invalid");
        }
    }

    @FXML
    void monthCheck(KeyEvent event) {
        int check = Integer.parseInt(month.getText());
        if(check >= LocalDate.now().getMonthValue() && check <= 12){
            monthError.setText("");
        }else {
            monthError.setText("Invalid");
        }
    }
}
