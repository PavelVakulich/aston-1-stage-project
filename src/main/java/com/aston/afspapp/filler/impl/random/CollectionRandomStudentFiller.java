package com.aston.afspapp.filler.impl.random;


import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.entity.Student;
import com.aston.afspapp.filler.FillCollection;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class CollectionRandomStudentFiller implements FillCollection<Student> {

    @Override
    public void fillCollection(List<Student> list) {
        int groupNumber;
        BigDecimal gpa;
        int recordBookNumber;
        Random random = new Random();
        int size = CustomContext.INSTANCE.getCurrCollectionSize();
        for (int i = 0; i < size; i++) {
            groupNumber = random.nextInt(100000); //todo constant
            gpa = BigDecimal.valueOf(random.nextDouble(10)); //todo const
            recordBookNumber = random.nextInt(1000000); //todo const
            list.add(new Student(groupNumber, gpa, recordBookNumber));
        }
    }
}
