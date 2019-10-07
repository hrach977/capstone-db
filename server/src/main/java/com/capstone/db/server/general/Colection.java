package com.capstone.db.server.general;

import com.capstone.db.server.indices.Index;

import java.util.Map;
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

    public AtomicReference<Document> findOne() {
        return null;
    }

    public AtomicReference<Document> find(Map<String, String> filters) {
        return null;
    }

    public AtomicReference<Database> find(Map<String, String> filters, Map<String, Integer> projectino) {
        return null;
    }
}
