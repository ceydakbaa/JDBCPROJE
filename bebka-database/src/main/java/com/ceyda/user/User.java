package com.ceyda.user;

public class User {
    private int id;
    private String name;
    private int age;
//boş constructor
    public User(){

    }
    //dolu constructor
    public User (int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
//getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
