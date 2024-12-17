package com.aston.afspapp.controller.menu;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.context.EntityType;
import com.aston.afspapp.controller.AppController;
import com.aston.afspapp.util.validation.InputValidator;

import java.util.Scanner;

public class Menu {
    private final AppController appController;
    private Scanner sc;

    public Menu() {
        appController = new AppController();
        sc = new Scanner(System.in);
    }

    public void runMainMenu() {
        while (true) {
            System.out.println("Welcome to main menu.");
            System.out.println("1 - create collection.");
            System.out.println("2 - sort current collection by selection."); //todo collection is created -> sorted
            System.out.println("3 - sort current collection by selection and even number value.");//todo is created
            System.out.println("4 - perform binary search in the current collection."); //todo is created
            System.out.println("5 - write the sorted collection to a file."); //todo is sorted
            System.out.println("6 - write the found value to a file."); //todo is found
            System.out.println("7 - reset the resulting collections file.");
            System.out.println("8 - reset the resulting found values file.");
            System.out.println("9 - reset the current collection."); //todo is created -> false
            System.out.println("10 - reset the current found value."); //todo is found -> false
            System.out.println("11 - display the current collection to the terminal.");
            System.out.println("12 - display the current found value to the terminal.");
            System.out.println("0 - finish program execution");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    runCreateCollSubMenu1();
                    CustomContext.INSTANCE.setCreated(Boolean.TRUE);
                    break;
                case "2":
                    if (CustomContext.INSTANCE.isCreated()) {
                        appController.sortCurrentCollection();
                        CustomContext.INSTANCE.setSorted(Boolean.TRUE);
                        CustomContext.INSTANCE.setCustomSorted(Boolean.FALSE);
                    } else {
                        System.out.println("Created collection missing. Please create the collection first...");
                    }
                    break;
                case "3":
                    if (CustomContext.INSTANCE.isCreated()) {
                        appController.customSortCurrentCollection();
                        CustomContext.INSTANCE.setSorted(Boolean.FALSE);
                        CustomContext.INSTANCE.setCustomSorted(Boolean.TRUE);
                    } else {
                        System.out.println("Created collection missing. Please create the collection first...");
                    }
                    break;
                case "4":
                    if (CustomContext.INSTANCE.isSorted()) {
                        appController.findEntity();
                    } else {
                        System.out.println("Sorted collection missing. Please sort the collection first...");//todo
                    }
                    break;
                case "5":
                    if (CustomContext.INSTANCE.isSorted() || CustomContext.INSTANCE.isCustomSorted()) {
                        appController.writeFileCollection();
                    } else {
                        System.out.println("Sorted or custom sorted collection missing. " +
                                "Please sort the collection first...");
                    }
                    break;
                case "6":
                    if (CustomContext.INSTANCE.isFound()) {
                        appController.writeFileFoundValue();
                    } else {
                        System.out.println("The value found is missing. Please find the meaning first...");
                    }
                    break;
                case "7":
                    //todo controller call
                    break;
                case "8":
                    //todo controller call
                    break;
                case "9":
                    if (CustomContext.INSTANCE.isCreated()) {
                        //todo controller call
                    } else {
                        System.out.println("Nothing to reset. Collection not created.");
                    }
                    //todo controller call
                    break;
                case "10":
                    if (CustomContext.INSTANCE.isFound()) {
                        //todo controller call
                    } else {
                        System.out.println("Nothing to reset. Value not found.");
                    }
                    break;
                case "11":
                    if (CustomContext.INSTANCE.isCreated()) {
                        appController.printInTerminalCurrentCollection();
                    } else {
                        System.out.println("Current collection missing. Please create the collection first...");
                    }
                    break;
                case "12":
                    if (CustomContext.INSTANCE.isFound()) {
                        appController.printInTerminalCurrentFoundValue();
                    } else {
                        System.out.println("There is no current value found. Please find the value first.");
                    }
                    break;
                case "0":
                    this.sc.close();
                    return;
                default:
                    System.out.println("Incorrect input, try again...");
            }
            System.out.println("=============");
        }
    }

    public void runCreateCollSubMenu1() {
        while (true) {
            System.out.println("Welcome to the entity type selection sub menu 1 - 1 for creating a collection.");
            System.out.println("1 - select Bus type.");
            System.out.println("2 - select User type.");
            System.out.println("3 - select Student type.");
            System.out.println("0 - return to previous menu.");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    CustomContext.INSTANCE.setCurrentEntityType(EntityType.BUS);
                    runCreateCollSubMenu2();
                    return;
                case "2":
                    CustomContext.INSTANCE.setCurrentEntityType(EntityType.USER);
                    runCreateCollSubMenu2();
                    return;
                case "3":
                    CustomContext.INSTANCE.setCurrentEntityType(EntityType.STUDENT);
                    runCreateCollSubMenu2();
                    return;
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input, try again...");
            }
            System.out.println("=============");
        }
    }

    public void runCreateCollSubMenu2() {
        InputValidator inputValidator = new InputValidator(); // todo in field ?
        while (true) {
            System.out.println("Welcome to the collection size selection sub menu 1 - 2.");
            System.out.println("1 - input collection size.");
            System.out.println("0 - return to previous menu.");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("Please enter collection size:");
                    String sizeStr = sc.next();
                    if (inputValidator.isValidSizeStr(sizeStr)) {
                        CustomContext.INSTANCE.setCurrCollectionSize(Integer.parseInt(sizeStr));
                        runCreateCollSubMenu3();
                        return;
                    }
                    System.out.println("Incorrect size value format, try again...");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input, try again...");
            }
        }
    }

    public void runCreateCollSubMenu3() {
        while (true) {
            System.out.println("Welcome to the sub menu 1 - 3 for selecting the type of collection filling.");
            System.out.println("1 - manual filling.");
            System.out.println("2 - random filling.");
            System.out.println("3 - filling from file.");
            System.out.println("0 - return to previous menu.");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    appController.createCollectionManual();
                    return;
                case "2":
                    appController.createCollectionRandom();
                    return;
                case "3":
                    appController.createCollectionFile();
                    return;
                case "0":
                    return;
                default:
                    System.out.println("Incorrect input, try again...");
            }
        }
    }


}
