package com.aston.afspapp.rw.file;

import com.aston.afspapp.entity.Bus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BusRWriter implements ReaderWriter<Bus> {

    @Override
    public void writeToFile(List<Bus> entities, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Bus bus : entities) {
                String line = bus.getNumber() + "," + bus.getModel() + "," + bus.getMileage();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
    }

    @Override
    public void writeToFile(Bus bus, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String line = bus.getNumber() + "," + bus.getModel() + "," + bus.getMileage();
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
    }

    @Override
    public List<Bus> readFromFile(String file) {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Bus.Builder builder;
            while ((line = reader.readLine()) != null) {
                builder = new Bus.Builder();
                String[] data = line.split(",");
                //todo Index out of bound exception in catch
                Integer number = Integer.parseInt(data[0]);
                //todo validation
                builder.setNumber(number);
                String model = data[1];
                //todo validation
                builder.setModel(model);
                BigDecimal mileage = BigDecimal.valueOf(Double.parseDouble(data[2]));
                //todo validation
                builder.setMileage(mileage);
                buses.add(builder.build());
            }
        } catch (IOException e) {
            e.printStackTrace(); //todo
        }
        return buses;
    }
}
