package com.qikegu.demo;

public class User {
    private long id;
    private String name;
    
    public User(String name) {
        super();
        this.name = name;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}