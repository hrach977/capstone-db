package com.capstone.db;

import com.capstone.db.general.Database;
import com.capstone.db.implementations.Db;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class Server {

    private CopyOnWriteArrayList<AtomicReference<Database>> dbs;
    //private AtomicReference<Database> currentDatabase;
//    private String host;
//    private String port;
    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
//        this.host = host;
//        this.port = port;
        this.serverSocket = new ServerSocket(port);
//        currentDatabase = new AtomicReference<>(new Database("test") {});
        this.dbs = new CopyOnWriteArrayList<>();
        dbs.add(new AtomicReference<>(new Database("test")));
        //this.currentDatabase = new AtomicReference<>(new Database("test"));
        ///dbs.add(currentDatabase);
    }

    public void useDb(String dbName) {

        AtomicBoolean contains = new AtomicBoolean(false);

        dbs.forEach(it -> {
            if (it.get().getName().equals(dbName)) {
                contains.set(true);
            }
        });

        if (!contains.get()) {
            AtomicReference<Database> db = new AtomicReference<>(new Database(dbName));
            dbs.add(db);
        }
        //todo maybe the db already exists and we only need to change the reference to current db
        //todo otherwise we create a new db, add it to the list of existing dbs and change the reference to the current db
    }

    public void dropDb(String dbName) {
        //kinda hack as the interface doesn't support removal of items
        Collection<AtomicReference<Database>> dbsToRemove = dbs.stream()
                                                                .filter(it -> it.get().getName().equals(dbName))
                                                                .collect(Collectors.toList());
        dbs.removeAll(dbsToRemove);
    }


}
