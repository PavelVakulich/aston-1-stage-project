package com.aston.afspapp.rw.terminal;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.context.EntityType;
import com.aston.afspapp.entity.BaseEntity;

import java.util.List;

public class TerminalResultWriter {

    public void printResultMessage(String message) {
        System.out.println(message);
    }

    public void printCurrentCollection() {
        System.out.println("Current collection:");
        List<? extends BaseEntity> list = CustomContext.INSTANCE.getCurrentCollection();
        for (BaseEntity entity : list) {
            System.out.println(entity);
        }
    }

    public void printCurrentFoundEntity() {
        System.out.println("Current founded entity:");
        System.out.println(CustomContext.INSTANCE.getCurrentFoundEntity());
    }

    public void printCurrentEntityType() {
        System.out.println("Current entity type:");
        EntityType entityType = CustomContext.INSTANCE.getCurrentEntityType();
        System.out.println(entityType.name());
    }

}
