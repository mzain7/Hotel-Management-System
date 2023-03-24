package com.example.hotel_transylvania;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.Iterator;
import static com.mongodb.client.model.Filters.eq;

public class RoomDB {
    String userName, roomName, checkinDate, nights, price;

    static MongoClient client = MongoClients.create("mongodb+srv://user0:qazwsxedc@cluster0.r2lhefx.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase database = client.getDatabase("Room");
    static MongoCollection<Document> collection = database.getCollection("RoomCollection");

    public RoomDB(String username, String roomName, String checkinDate, String nights, String price) {
        this.userName = username;
        this.roomName = roomName;
        this.checkinDate = checkinDate;
        this.nights = nights;
        this.price = price;

        writeFile();
    }

    public RoomDB(){}

    public void writeFile () {
        Document roomDocument = new Document("User Name",userName).append("Room Name",roomName)
                .append("Check-in Date",checkinDate).append("Nights",nights).append("Price",price);
        collection.insertOne(roomDocument);
    }

    }
