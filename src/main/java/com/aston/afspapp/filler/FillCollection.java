package com.aston.afspapp.filler;

import com.aston.afspapp.entity.BaseEntity;

import java.util.List;

public interface FillCollection<T extends BaseEntity> {
    void fillCollection(List<T> list);
}
