package com.aston.afspapp;

import com.aston.afspapp.controller.menu.Menu;

public class App {

    public static void main(String[] args) {
        startup();
    }

    public static void startup() {
        //todo files validation
        Menu menu = new Menu();
        menu.runMainMenu();
    }
}
