package com.example.hotel_transylvania;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class WeddingDB {

    String name, email,namePar,emailPar,guests;

    public WeddingDB(String name, String email, String namePar, String emailPar, String guests) {
        this.name = name;
        this.email = email;
        this.namePar = namePar;
        this.emailPar = emailPar;
        this.guests = guests;
        write();
    }

    static MongoClient client = MongoClients.create("mongodb+srv://user0:qazwsxedc@cluster0.r2lhefx.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase database = client.getDatabase("Weddings");
    static MongoCollection<Document> collection = database.getCollection("WeddingCollections");

    public void write(){
        Document document = new Document("Name",name).append("Email",email).append("Partner's Name",namePar).append("Partner's email",emailPar).append("No. of Guests",guests);
        collection.insertOne(document);
    }


}
