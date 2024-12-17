package com.aston.afspapp.filler.impl;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.context.EntityType;
import com.aston.afspapp.entity.BaseEntity;
import com.aston.afspapp.filler.FillCollection;
import com.aston.afspapp.rw.file.BusRWriter;
import com.aston.afspapp.rw.file.ReaderWriter;
import com.aston.afspapp.rw.file.StudentRWriter;
import com.aston.afspapp.rw.file.UserRWriter;

import java.util.List;

public class CollectionFileFiller<T extends BaseEntity> implements FillCollection<T> {
    @Override
    public void fillCollection(List list) {
        ReaderWriter<? extends BaseEntity> rw = getConcreteReadWriter(CustomContext.INSTANCE.getCurrentEntityType());
        int currentSize = CustomContext.INSTANCE.getCurrCollectionSize();
        //todo valid size
        List concreteList = rw.readFromFile(CustomContext.INSTANCE.getFilePath());
        concreteList.stream()
                .limit(currentSize)
                .forEach(o -> list.add(o));
    }

    public ReaderWriter<? extends BaseEntity> getConcreteReadWriter(EntityType entityType) {
        ReaderWriter rw = null;
        switch (entityType) {
            case BUS:
                rw = new BusRWriter();
            case STUDENT:
                rw = new StudentRWriter();
            case USER:
                rw = new UserRWriter();
            default:
                //todo error
        }
        return rw;
    }


}
