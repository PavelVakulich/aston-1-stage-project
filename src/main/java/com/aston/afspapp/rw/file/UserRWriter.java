package com.aston.afspapp.rw.file;

import com.aston.afspapp.entity.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRWriter implements ReaderWriter<User> {

    @Override
    public void writeToFile(List<User> entities, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (User user : entities) {
                String line = user.getName() + "," + user.getPassword() + "," + user.getEmail();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
    }

    @Override
    public void writeToFile(User user, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = user.getName() + "," + user.getPassword() + "," + user.getEmail();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
    }

    @Override
    public List<User> readFromFile(String file) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            User.Builder builder;
            while ((line = reader.readLine()) != null) {
                builder = new User.Builder();
                String[] data = line.split(",");
                //todo validate index out of bound exception in catch
                String name = data[0];
                //todo validation
                builder.setName(name);
                String password = data[1];
                //todo validation
                builder.setPassword(password);
                String email = data[2];
                //todo validation
                builder.setEmail(email);
                users.add(builder.build());
            }
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
        return users;
    }
}
