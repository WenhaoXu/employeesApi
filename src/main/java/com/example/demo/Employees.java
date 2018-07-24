package com.example.demo;

public class Employees {
    public   String id;
    public  String name;
    public  int age;
    public  String gender;

     public Employees(){

     }

     public Employees(String id, String name, int age, String gender){
         this.id=id;
         this.name=name;
         this.age=age;
         this.gender =gender;
     }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }


}
