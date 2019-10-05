package com.capstone.db.general;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Document {

    protected ConcurrentHashMap<String, String> values; //shouldn't it be atomic?

    public ConcurrentHashMap<String, String> getValues() {
        return values;
    }

    public void setValues(ConcurrentHashMap<String, String> values) {
        this.values = values;
    }
}
