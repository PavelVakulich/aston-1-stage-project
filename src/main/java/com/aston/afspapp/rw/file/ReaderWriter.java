package com.aston.afspapp.rw.file;

import com.aston.afspapp.entity.BaseEntity;

import java.util.List;

public interface ReaderWriter<T extends BaseEntity> {

    /**
     * Метод для записи списка {#linK Base} в файл.
     *
     * @param entities список сущностей
     * @param fileName имя файла
     */
    void writeToFile(List<T> entities, String fileName);

    /**
     * Метод для записи одной сущности в файл.
     *
     * @param entity сущность
     * @param fileName имя файла
     */
    void writeToFile(T entity, String fileName);

    /**
     * Метод для чтения данных из файла.
     *
     * @param fileName имя файла
     * @return список сущностей
     */
    List<T> readFromFile(String fileName);

}
