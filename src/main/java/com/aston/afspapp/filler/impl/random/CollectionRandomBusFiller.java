package com.aston.afspapp.filler.impl.random;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.service.Util.RandomPasswordUtil;
import com.aston.afspapp.entity.Bus;
import com.aston.afspapp.filler.FillCollection;

import java.math.BigDecimal;
import java.util.List;

public class CollectionRandomBusFiller implements FillCollection<Bus> {

    @Override
    public void fillCollection(List<Bus> list) {
        int number;
        String model;
        BigDecimal mileage;
        int size = CustomContext.INSTANCE.getCurrCollectionSize();
        for (int i = 0; i < size; i++) {
            number = (int) (Math.random() * 199999 + 100000); //todo const
            model = RandomPasswordUtil.createPassword();
            mileage = BigDecimal.valueOf(Math.random() * 10000001); //todo const
            list.add(new Bus(number, model, mileage));
        }
    }
}
