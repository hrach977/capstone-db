package com.capstone.db.general;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Database {

    protected String name;
    protected CopyOnWriteArrayList<Colection> collections;

    public boolean addColletion(Colection collection) {
       return collections.add(collection);
    }

    public String showCollections() {
        return collections.stream().map(Colection::getName).collect(Collectors.toList()).toString();
    }

    public Database() {}

    public Database(String name) {
        this.name = name;
        this.collections = new CopyOnWriteArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CopyOnWriteArrayList<Colection> getCollections() {
        return collections;
    }

    public void setCollections(CopyOnWriteArrayList<Colection> collections) {
        this.collections = collections;
    }
}
