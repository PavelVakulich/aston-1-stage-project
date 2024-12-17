package com.aston.afspapp.filler.impl;

import com.aston.afspapp.filler.FillCollection;

import java.math.BigDecimal;
import java.util.List;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.entity.Bus;
import com.aston.afspapp.entity.Student;
import com.aston.afspapp.entity.User;

import java.util.Scanner;

public class CollectionManualFiller implements FillCollection {
    @Override
    public void fillCollection(List list) {
        int size = CustomContext.INSTANCE.getCurrCollectionSize();
        switch (CustomContext.INSTANCE.getCurrentEntityType()) {
            case BUS:
                for (int i = 0; i < size; i++) { //todo size
                    list.add(createManualBus());
                }
                break;
            case USER:
                for (int i = 0; i < size; i++) { // todo size
                    list.add(createManualUser());
                }
                break;
            case STUDENT:
                for (int i = 0; i < size; i++) { // todo size
                    list.add(createManualStudent());
                }
                break;
        }
    }

    private Student createManualStudent() {
        System.out.println("Creating a new student:");
        Student.Builder builder = new Student.Builder();
        try (Scanner sc = new Scanner(System.in)) {
            boolean inProgress = Boolean.TRUE;
            while (inProgress) {
                System.out.println("Make the following choice:");
                System.out.println("1 - fill in the group number");
                System.out.println("2 - fill in the average score");
                System.out.println("3 - fill in the credit card number");
                System.out.println("0 - finish creating a student with the current status");
                //todo validation
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("enter the group number");
                        //todo validation
                        int groupNumber = sc.nextInt();
                        builder.setGroupNumber(groupNumber);
                        break;
                    case "2":
                        System.out.println("enter the average score");
                        //todo validation
                        BigDecimal averageScore = BigDecimal.valueOf(sc.nextInt());
                        builder.setAverageScore(averageScore);
                        break;
                    case "3":
                        System.out.println("enter the grade book number");
                        //todo validation
                        int gradeBookNumber = sc.nextInt();
                        builder.setGradebookNumber(gradeBookNumber);
                        break;
                    case "0":
                        inProgress = Boolean.FALSE;
                }
            }
            return builder.build();
        }
    }

    private User createManualUser() {
        System.out.println("Creating a new user:");
        User.Builder builder = new User.Builder();
        try (Scanner sc = new Scanner(System.in)) {
            boolean inProgress = Boolean.TRUE;
            while (inProgress) {
                System.out.println("Make the following choice:");
                System.out.println("1 - fill in the name field");
                System.out.println("2 - fill in the password");
                System.out.println("3 - fill in the name of the mail");
                System.out.println("0 - finish creating a user with the current state");
                //todo validation
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("enter a name");
                        //todo validation
                        String name = sc.next();
                        builder.setName(name);
                        break;
                    case "2":
                        System.out.println("enter the password");
                        //todo validation
                        String password = sc.next();
                        builder.setPassword(password);
                        break;
                    case "3":
                        System.out.println("enter the name of the mail");
                        //todo validation
                        String email = sc.next();
                        builder.setEmail(email);
                        break;
                    case "0":
                        inProgress = Boolean.FALSE;
                }
            }
            return builder.build();
        }
    }

    private Bus createManualBus() {
        System.out.println("Creating a new bus:");
        try (Scanner sc = new Scanner(System.in)) {
            Bus.Builder builder = new Bus.Builder();
            boolean inProgress = Boolean.TRUE;
            while (inProgress) {
                System.out.println("Make the following choice:");
                System.out.println("1 - fill in the bus number");
                System.out.println("2 - fill in the bus model");
                System.out.println("3 - fill in the mileage");
                System.out.println("0 - finish creating a bus with the current state");
                //todo validation
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        System.out.println("enter the bus number");
                        //todo validation
                        int numberBus = sc.nextInt();
                        builder.setNumber(numberBus);
                        break;
                    case "2":
                        System.out.println("enter the bus model");
                        //todo validation
                        String model = sc.next();
                        builder.setModel(model);
                        break;
                    case "3":
                        System.out.println("enter the mileage");
                        //todo validation
                        int mileage = sc.nextInt();
                        builder.setMileage(BigDecimal.valueOf(mileage));
                        break;
                    case "0":
                        inProgress = Boolean.FALSE;
                }
            }
            return builder.build();
        }
    }
}
