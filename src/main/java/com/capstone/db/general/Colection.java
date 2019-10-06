package com.capstone.db.general;

import com.capstone.db.indices.Index;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Colection {

    protected String name;
    protected CopyOnWriteArrayList<AtomicReference<Document>> documents;
    //protected CopyOnWriteArrayList<Document> documents;
    protected CopyOnWriteArrayList<Index> indices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colection() {}

    public Colection(String name) {
        this.name = name;
        this.documents = new CopyOnWriteArrayList<>();
        this.indices = new CopyOnWriteArrayList<>();
    }
}
