package com.example.hotel_transylvania;


import com.mongodb.client.*;
import org.bson.Document;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;

public class UserDB {
    String firstName, lastName , userName, contact, email, password;

    static MongoClient client = MongoClients.create("mongodb+srv://user0:qazwsxedc@cluster0.r2lhefx.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase database = client.getDatabase("Users");
    static MongoCollection<Document> collection = database.getCollection("UserCollections");



    public UserDB(String firstName, String lastName, String userName, String contact, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contact = contact;
        this.email = email;
        this.password = password;

        write();
    }
    public UserDB(){}

    public void write(){
        Document userDocument = new Document("First Name",firstName).append("Last Name",lastName)
                .append("User Name",userName).append("Contact",contact).append("Email",email).append("Password",password);
        collection.insertOne(userDocument);
    }

    public boolean checkLogin(String username,String password) {
        Document documents = collection.find(eq("User Name",username)).first();
        if(!(documents == null)){
            if(password.equals(documents.get("Password"))){
                return true;
            }
        }
        return false;
    }

    public boolean checkEmial(String email) {
        Document documents = collection.find(eq("Email",email)).first();
        return !(documents == null);
    }

    public void changePassword(String password, String email) {
        collection.updateOne(eq("Email",email),new Document("$set",new Document("Password",password)));

    }



    }
