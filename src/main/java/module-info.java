module com.example.hotel_transylvania {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;
    requires de.jensd.fx.glyphs.fontawesome;
    requires org.mongodb.driver.core;
    requires org.mongodb.bson;
    requires org.mongodb.driver.sync.client;
    requires java.mail;
    requires javafx.media;
//    requires mongo.java.driver;
//    requires org.mongodb.driver.sync.client;
//    requires org.mongodb.driver.core;
//    requires java.logging;
//    requires mongo.java.driver;


    opens com.example.hotel_transylvania to javafx.fxml;
    exports com.example.hotel_transylvania;
}