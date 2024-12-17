package com.aston.afspapp.filtration;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.context.EntityType;
import com.aston.afspapp.entity.BaseEntity;
import com.aston.afspapp.entity.Bus;
import com.aston.afspapp.entity.Student;
import com.aston.afspapp.entity.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class SearchService {

    public <T extends Comparable<T>> String findElement(List<T> list, T searchedItem) {
        int searchedIndex = doingBinarySearch(list, searchedItem);
        if (searchedIndex >= 0) {
            CustomContext.INSTANCE.setCurrentFoundEntity((BaseEntity) list.get(searchedIndex));
            CustomContext.INSTANCE.setFound(Boolean.TRUE);
            return "Element was found.";
        } else {
            CustomContext.INSTANCE.setFound(Boolean.FALSE);
            return "Element was not found.";
        }
    }

    private <T extends Comparable<T>> int doingBinarySearch(List<T> list, T searchedItem) {
        int leftSide = 0, rightSide = list.size() - 1;
        while (leftSide <= rightSide) {
            int mid = leftSide + (rightSide - leftSide) / 2;
            T midValue = list.get(mid);
            int comparison = midValue.compareTo(searchedItem);
            if (comparison == 0)
                return mid;
            if (comparison < 0)
                leftSide = mid + 1;
            else
                rightSide = mid - 1;
        }
        return -1;
    }

    public <T extends Comparable<T>> Comparable createSearchCriteria(EntityType entityType) {
        Comparable searchCriteria = null;
        switch (entityType) {
            case BUS:
                searchCriteria = createBusSearchCriteria();
                break;
            case USER:
                searchCriteria = createUserSearchCriteria();
                break;
            case STUDENT:
                searchCriteria = createStudentSearchCriteria();
                break;
            default:
                //todo error;
        }
        return searchCriteria;
    }

    private Comparable<Bus> createBusSearchCriteria() {
        try (Scanner sc = new Scanner(System.in)) {
            boolean inProgress = Boolean.TRUE;
            Bus.Builder builder = new Bus.Builder();
            while (inProgress) {
                System.out.println("Enter the criteria by which you want to search for a Bus");
                System.out.println("1 - number");
                System.out.println("2 - model");
                System.out.println("3 - mileage");
                System.out.println("0 - finish creating the search criteria");
                String choice = sc.next();
                switch (choice) {
                    case "1":
                        int number = sc.nextInt();
                        //todo validation
                        builder.setNumber(number);
                        break;
                    case "2":
                        String model = sc.next();
                        //todo validation
                        builder.setModel(model);
                        break;
                    case "3":
                        double mileage = sc.nextDouble();
                        //todo validation()
                        builder.setMileage(BigDecimal.valueOf(mileage));
                        break;
                    case "0":
                        inProgress = Boolean.FALSE;
                        break;
                }
            }
            return builder.build();
        }
    }

    private Comparable<User> createUserSearchCriteria() {
        try (Scanner sc = new Scanner(System.in)) {
            boolean inProgress = Boolean.TRUE;
            User.Builder builder = new User.Builder();
            while (inProgress) {
                System.out.println("Enter the criteria by which you want to search for a User");
                System.out.println("1 - name");
                System.out.println("2 - password");
                System.out.println("3 - email");
                System.out.println("0 - finish creating the search criteria");
                String choice = sc.next();
                switch (choice) {
                    case "1":
                        String name = sc.next();
                        //todo validation
                        builder.setName(name);
                        break;
                    case "2":
                        String password = sc.next();
                        //todo validation
                        builder.setPassword(password);
                        break;
                    case "3":
                        String email = sc.next();
                        //todo validation()
                        builder.setEmail(email);
                        break;
                    case "0":
                        inProgress = Boolean.FALSE;
                        break;
                }
            }
            return builder.build();
        }
    }

    private Comparable<Student> createStudentSearchCriteria() {
        try (Scanner sc = new Scanner(System.in)) {
            boolean inProgress = Boolean.TRUE;
            Student.Builder builder = new Student.Builder();
            while (inProgress) {
                System.out.println("Enter the criteria by which you want to search for a Student");
                System.out.println("1 - name");
                System.out.println("2 - password");
                System.out.println("3 - email");
                System.out.println("0 - finish creating the search criteria");
                String choice = sc.next();
                switch (choice) {
                    case "1":
                        int groupNumber = sc.nextInt();
                        //todo validation
                        builder.setGroupNumber(groupNumber);
                        break;
                    case "2":
                        float averageScore = sc.nextFloat();
                        //todo validation
                        builder.setAverageScore(BigDecimal.valueOf(averageScore));
                        break;
                    case "3":
                        int gradeBookNumber = sc.nextInt();
                        //todo validation()
                        builder.setGradebookNumber(gradeBookNumber);
                        break;
                    case "0":
                        inProgress = Boolean.FALSE;
                        break;
                }
            }
            return builder.build();
        }
    }

}
