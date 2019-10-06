package com.capstone.db;

import com.capstone.db.general.Database;
import com.capstone.db.implementations.Db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class Server {

    private CopyOnWriteArrayList<AtomicReference<Database>> dbs;
    private AtomicReference<Database> currentDatabase;
    private String host;
    private String port;

    public Server(String host, String port) {
        this.host = host;
        this.port = port;
//        currentDatabase = new AtomicReference<>(new Database("test") {});
        this.dbs = new CopyOnWriteArrayList<>();
        this.currentDatabase = new AtomicReference<>(new Database("test"));
        dbs.add(currentDatabase);
    }

    public void useDb(String dbName) {
        AtomicReference<Database> db = new AtomicReference<>(new Database(dbName));
        dbs.add(db);
    }

    public void dropDb(String dbName) {
        //kinda hack as the interface doesn't support removal of items
        Collection<AtomicReference<Database>> dbsToRemove = dbs.stream()
                                                                .filter(it -> it.get().getName().equals(dbName))
                                                                .collect(Collectors.toList());
        dbs.removeAll(dbsToRemove);
    }
}
