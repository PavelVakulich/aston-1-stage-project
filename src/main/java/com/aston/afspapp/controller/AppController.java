package com.aston.afspapp.controller;


import com.aston.afspapp.rw.terminal.TerminalResultWriter;
import com.aston.afspapp.service.AppService;

public class AppController {
    private final AppService appService;
    private final TerminalResultWriter resultWriter;

    public AppController() {
        appService = new AppService();
        resultWriter = new TerminalResultWriter();
    }

    public void createCollectionManual() {
        String result = appService.createCollectionManual();
        resultWriter.printResultMessage(result);
    }

    public void createCollectionRandom() {
        String result = appService.createCollectionRandom();
        resultWriter.printResultMessage(result);
    }

    public void createCollectionFile() {
        String result = appService.createCollectionFile();
        resultWriter.printResultMessage(result);
    }

    public void sortCurrentCollection() {
        String result = appService.sort();
        resultWriter.printResultMessage(result);
    }

    public void customSortCurrentCollection() {
        String result = appService.customSort();
        resultWriter.printResultMessage(result);
    }

    public void findEntity() {
        String result = appService.findElement();
        resultWriter.printResultMessage(result);
    }

    public void writeFileCollection() {
        String result = appService.writeCurrentSortedCollectionToFile();
        resultWriter.printResultMessage(result);
    }

    public void writeFileFoundValue() {
        String result = appService.writeCurrentFoundValueToFile();
        resultWriter.printResultMessage(result);
    }

    public void printInTerminalCurrentCollection() {
        String result = appService.printInTerminalCurrentCollection();
        resultWriter.printResultMessage(result);
    }

    public void printInTerminalCurrentFoundValue() {
        String result = appService.printInTerminalCurrentFoundValue();
        resultWriter.printResultMessage(result);
    }
}
