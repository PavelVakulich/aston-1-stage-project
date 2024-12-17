package com.aston.afspapp.service;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.context.EntityType;
import com.aston.afspapp.entity.BaseEntity;
import com.aston.afspapp.entity.Bus;
import com.aston.afspapp.entity.Student;
import com.aston.afspapp.entity.User;
import com.aston.afspapp.filler.FillCollection;
import com.aston.afspapp.filler.FillerService;
import com.aston.afspapp.filler.impl.CollectionFileFiller;
import com.aston.afspapp.filler.impl.CollectionManualFiller;
import com.aston.afspapp.filler.impl.random.CollectionRandomBusFiller;
import com.aston.afspapp.filler.impl.random.CollectionRandomStudentFiller;
import com.aston.afspapp.filler.impl.random.CollectionRandomUserFiller;
import com.aston.afspapp.filtration.SearchService;
import com.aston.afspapp.rw.file.BusRWriter;
import com.aston.afspapp.rw.file.ReaderWriter;
import com.aston.afspapp.rw.file.StudentRWriter;
import com.aston.afspapp.rw.file.UserRWriter;
import org.w3c.dom.ls.LSOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppService {

    public String createCollectionManual() {
        List list = createListByEntityType(CustomContext.INSTANCE.getCurrentEntityType(),
                CustomContext.INSTANCE.getCurrCollectionSize());
        FillerService fillerService = new FillerService(new CollectionManualFiller());
        fillerService.fillCollection(list);
        CustomContext.INSTANCE.setCurrentCollection(list);
        CustomContext.INSTANCE.setCreated(Boolean.TRUE);
        return "Collection created successfully";
    }

    public String createCollectionFile() {
        String filePath = "";
        switch (CustomContext.INSTANCE.getCurrentEntityType()) {
            case BUS:
                filePath = "data/in/buses.csv";
                break;
            case USER:
                filePath = "data/in/users.csv";
                break;
            case STUDENT:
                filePath = "data/in/students.csv";
                break;
        }
        CustomContext.INSTANCE.setFilePath(filePath);
        FillerService fillerService = new FillerService(new CollectionFileFiller());
        fillerService.fillCollection(createListByEntityType(CustomContext.INSTANCE.getCurrentEntityType(),
                CustomContext.INSTANCE.getCurrCollectionSize()));
        return "Collection created successfully";
    }

    public String createCollectionRandom() {
        List list = createListByEntityType(CustomContext.INSTANCE.getCurrentEntityType(), CustomContext.INSTANCE.getCurrCollectionSize());
        FillCollection filler = createRandomFiller(CustomContext.INSTANCE.getCurrentEntityType());
        FillerService fillerService = new FillerService(filler);
        fillerService.fillCollection(list);
        CustomContext.INSTANCE.setCurrentCollection(list);
        CustomContext.INSTANCE.setCreated(Boolean.TRUE);
        return "result"; //todo
    }

    public String findElement() {
        List list = CustomContext.INSTANCE.getCurrentCollection();
        SearchService searchService = new SearchService();
        Comparable searchCriteria = searchService.createSearchCriteria(CustomContext.INSTANCE.getCurrentEntityType());
        return searchService.findElement(list, searchCriteria);
    }

    public String sort() {
        List list = CustomContext.INSTANCE.getCurrentCollection();
        return sortCurrentCollectionBySelection(list);
    }

    public String customSort() {
        List list = CustomContext.INSTANCE.getCurrentCollection();
        return sortCurrentCollectionByCustomSelection(list);
    }

    public String writeCurrentSortedCollectionToFile() {
        if (!CustomContext.INSTANCE.isSorted()) {
            return "current collection is not sorted";
        }
        EntityType entityType = CustomContext.INSTANCE.getCurrentEntityType();
        switch (entityType) {
            case BUS:
                new BusRWriter().writeToFile((List<Bus>) CustomContext.INSTANCE.getCurrentCollection(),
                        "data/out/collectionFile.csv");
                break;
            case USER:
                new UserRWriter().writeToFile((List<User>) CustomContext.INSTANCE.getCurrentCollection(),
                        "data/out/collectionFile.csv");
                break;
            case STUDENT:
                new StudentRWriter().writeToFile((List<Student>) CustomContext.INSTANCE.getCurrentCollection(),
                        "data/out/collectionFile.csv");
                break;
            default:
                //todo error
        }
        //todo string as const
        return "collection successfully write in file: data/out/collectionFile.csv";
    }

    public String writeCurrentFoundValueToFile() {
        if (!CustomContext.INSTANCE.isFound()) {
            return "system haven't a found value";
        }
        EntityType entityType = CustomContext.INSTANCE.getCurrentEntityType();
        switch (entityType) {
            case BUS:
                new BusRWriter().writeToFile((Bus) CustomContext.INSTANCE.getCurrentFoundEntity(),
                        "data/out/entityFoundFile.csv");
                break;
            case USER:
                new UserRWriter().writeToFile((User) CustomContext.INSTANCE.getCurrentFoundEntity(),
                        "data/out/entityFoundFile.csv");
                break;
            case STUDENT:
                new StudentRWriter().writeToFile((Student) CustomContext.INSTANCE.getCurrentFoundEntity(),
                        "data/out/entityFoundFile.csv");
                break;
            default:
                //todo error
        }
        //todo string as const
        return "entity successfully write in file: data/out/entityFoundFile.csv";
    }

    public String printInTerminalCurrentCollection() {
        List list = CustomContext.INSTANCE.getCurrentCollection();
        if (list == null) {
            return "current collection is nullable";
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
        return "the collection was successfully output to the terminal";
    }

    public String printInTerminalCurrentFoundValue() {
        BaseEntity entity = CustomContext.INSTANCE.getCurrentFoundEntity();
        if (entity == null) {
            return "current found entity is nullable";
        }
        System.out.println(entity);
        return "entity was successfully output to the terminal";
    }

    private <T extends Comparable> String sortCurrentCollectionBySelection(List<T> list) {
        if (list == null) {
            return "List is nullable"; //todo
        }
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        CustomContext.INSTANCE.setCustomSorted(Boolean.FALSE);
        CustomContext.INSTANCE.setSorted(Boolean.TRUE);
        return "collection successfully sorted";
    }

    private <T extends Comparable> String sortCurrentCollectionByCustomSelection(List<T> list) {
        if (list == null) {
            return "List is nullable"; //todo
        }
        int size = list.size();
        EntityType entityType = CustomContext.INSTANCE.getCurrentEntityType();
        main:
        for (int i = 0; i < size - 1; i++) {
            switch (entityType) {
                case BUS:
                    if (((Bus) list.get(i)).getNumber() % 2 != 0) {
                        continue main;
                    }
                    break;
                case USER:
                    //todo user haven't numeric fields
                    if (list.get(i).hashCode() % 2 != 0) {
                        continue main;
                    }
                    break;
                case STUDENT:
                    if (((Student) list.get(i)).getGroupNumber() % 2 != 0) {
                        continue main;
                    }
                    break;
            }
            int minIndex = i;
            sub:
            for (int j = i + 1; j < size; j++) {
                switch (entityType) {
                    case BUS:
                        if (((Bus) list.get(j)).getNumber() % 2 != 0) {
                            continue sub;
                        }
                        break;
                    case USER:
                        //todo user haven't numeric fields
                        if (list.get(j).hashCode() % 2 != 0) {
                            continue sub;
                        }
                        break;
                    case STUDENT:
                        if (((Student) list.get(j)).getGroupNumber() % 2 != 0) {
                            continue sub;
                        }
                        break;
                }
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            T temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        CustomContext.INSTANCE.setCustomSorted(Boolean.TRUE);
        CustomContext.INSTANCE.setSorted(Boolean.FALSE);
        return "collection successfully custom sorted";
    }


    private FillCollection createRandomFiller(EntityType entityType) {
        switch (entityType) {
            case BUS:
                return new CollectionRandomBusFiller();
            case STUDENT:
                return new CollectionRandomStudentFiller();
            case USER:
                return new CollectionRandomUserFiller();
        }
        return null;
    }

    private List createListByEntityType(EntityType entityType, int size) {
        switch (entityType) {
            case BUS:
                return new ArrayList<Bus>(size);
            case STUDENT:
                return new ArrayList<Student>(size);
            case USER:
                return new ArrayList<User>(size);
        }
        return null;
    }


}
