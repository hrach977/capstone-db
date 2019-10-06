package com.capstone.db.general;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class Document {

    protected final long _ID;
    protected AtomicLong version;
    private CopyOnWriteArrayList<String> indexedFields;
    private ConcurrentHashMap<String, String> values = new ConcurrentHashMap<>(); //todo: shouldn't it be wrapped into atomic reference?

    public ConcurrentHashMap<String, String> getValues() {
        return values;
    }

    public void update(String key, Object value) {
        version.incrementAndGet();
        values.put(key, String.valueOf(value));
    }

    public void setValues(ConcurrentHashMap<String, String> values) {
        this.values = values;
    }

    public Document() {
        version = new AtomicLong(0L);
        this._ID = ThreadLocalRandom.current().nextLong();
        values.put("_id", String.valueOf(_ID));
    }

}
