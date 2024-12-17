package com.aston.afspapp.context;

import com.aston.afspapp.entity.BaseEntity;

import java.util.List;

public enum CustomContext {
    INSTANCE;
    private EntityType currentEntityType;
    private boolean isCreated;
    private boolean isFound;
    private boolean isSorted;
    private boolean isCustomSorted;
    private Integer currCollectionSize;
    private BaseEntity currentFoundEntity;
    private List<? extends BaseEntity> currentCollection;
    private String filePath; //todo to Path ?

    public EntityType getCurrentEntityType() {
        return currentEntityType;
    }

    public void setCurrentEntityType(EntityType currentEntityType) {
        this.currentEntityType = currentEntityType;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public void setCreated(boolean created) {
        isCreated = created;
    }

    public boolean isFound() {
        return isFound;
    }

    public void setFound(boolean found) {
        isFound = found;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }

    public boolean isCustomSorted() {
        return isCustomSorted;
    }

    public void setCustomSorted(boolean customSorted) {
        isCustomSorted = customSorted;
    }

    public Integer getCurrCollectionSize() {
        return currCollectionSize;
    }

    public void setCurrCollectionSize(Integer currCollectionSize) {
        this.currCollectionSize = currCollectionSize;
    }

    public BaseEntity getCurrentFoundEntity() {
        return currentFoundEntity;
    }

    public void setCurrentFoundEntity(BaseEntity currentFoundEntity) {
        this.currentFoundEntity = currentFoundEntity;
    }

    public List<? extends BaseEntity> getCurrentCollection() {
        return currentCollection;
    }

    public void setCurrentCollection(List<? extends BaseEntity> currentCollection) {
        this.currentCollection = currentCollection;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
