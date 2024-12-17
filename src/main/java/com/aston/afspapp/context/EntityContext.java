package com.aston.afspapp.context;

import  com.aston.afspapp.filler.FillCollection;

import java.util.List;

public class EntityContext {
    private FillCollection strategy;

    public void setStrategy(FillCollection strategy) {
        this.strategy = strategy;
    }

    public void createEntity(List<Object> listObject) {
        if (strategy != null) {
            strategy.fillCollection(listObject);
        } else
        {
            System.out.println("No strategy set");
        }
////        CustomContext.INSTANCE.setCurrentCollection
////        CustomContext.INSTANCE.setCreated(Boolean.);
//        Boolean x = true;
//        Boolean.TRUE
}}
