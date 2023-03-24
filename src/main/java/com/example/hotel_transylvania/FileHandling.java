package com.example.hotel_transylvania;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {
    String firstName, lastName , userName, contact, email, password;
    File file = new File("src/main/resources/com/example/hotel_transylvania/Data Files/User Details.csv");
    ArrayList<FileHandling> list = new ArrayList<>();


    public FileHandling(String firstName, String lastName, String userName, String contact, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.contact = contact;
        this.email = email;
        this.password = password;
    }
    public FileHandling(){};

    public void writeFile () {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(String.format("%s, %s, %s, %s, %s, %s",firstName,lastName,userName,contact,email,password));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void readFile(){
        String [] split;
        list.removeAll(list);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text = br.readLine();
            while (text != null){
                split = text.split(", ");
                list.add(new FileHandling(split[0],split[1],split[2],split[3],split[4],split[5]));
                text = br.readLine();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean checkLogin(String username,String password){
        readFile();
        for (FileHandling e : list) {
            if(e.userName.equalsIgnoreCase(username)){
                if(e.password.equals(password)){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }


    public boolean checkEmial(String email){
        readFile();
        for (FileHandling e : list) {
            if(e.email.equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
    public void changePassword(String password, String email){
        readFile();
        for (FileHandling e : list) {
            if(e.email.equalsIgnoreCase(email)){
                e.password = password;
                writeToFile();

            }
        }
    }

    public void writeToFile(){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (FileHandling e : list) {
                bw.write(String.format("%s, %s, %s, %s, %s, %s", e.firstName, e.lastName, e.userName, e.contact, e.email, e.password));
                bw.newLine();
            }
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
