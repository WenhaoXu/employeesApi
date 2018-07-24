package com.example.demo;


import Model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeesController {

    List<Employees> list=new LinkedList<>();

    public EmployeesController (){
        Employees employees=new Employees("0","小明",20,"男");
        Employees employees1=new Employees("1","小红",19,"女");
        Employees employees2=new Employees("2","小智",15,"男");
        Employees employees3=new Employees("3","小刚",16,"男");
        Employees employees4=new Employees("4","小霞",15,"女");
        list.add(employees);
        list.add(employees1);
        list.add(employees2);
        list.add(employees3);
        list.add(employees4);

    }



      @GetMapping ("/employees")
    public List<Employees> getEmployees(){

          return  list;
      }


      @GetMapping("/employees/{id}")
    public Employees getEmployee(@PathVariable  String id){
           List<Employees> newlist=   list.stream().filter((em)->em.id.equals(id)).collect(Collectors.toList());
          System.out.println(newlist.size());
              if (newlist.size()!=0){
                  return  newlist.get(0);
              }
              else {
                  return  null;
              }
      }

//      @PostMapping("/employees")
//      public Employees postEmployees(@RequestBody  Employees employees){
//          list.add(employees);
//          return  employees;
//      }

}
