package com.example.hotel_transylvania;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RoomFile {

    File file = new File("src/main/resources/com/example/hotel_transylvania/Data Files/Room Details.csv");

    String username, roomName, checkinDate, nights, price;

    public RoomFile(String username, String roomName, String checkinDate, String nights, String price) {
        this.username = username;
        this.roomName = roomName;
        this.checkinDate = checkinDate;
        this.nights = nights;
        this.price = price;
    }

    public void writeFile () {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(String.format("%s, %s, %s, %s, %s",username,roomName,checkinDate,nights,price));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

