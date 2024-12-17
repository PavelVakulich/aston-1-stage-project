package com.aston.afspapp.filler;

import com.aston.afspapp.entity.BaseEntity;

import java.util.List;

public class FillerService {

    private final FillCollection filler;

    public FillerService(FillCollection filler){
        this.filler = filler;
    }

    public void fillCollection(List<? extends BaseEntity> list) {
        filler.fillCollection(list);
    }
}
