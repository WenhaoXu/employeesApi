package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeesController {

    List<Employees> list=new LinkedList<>();

    public EmployeesController (){
        Employees employees=new Employees("1","小明",20,"男");
        Employees employees1=new Employees("2","小红",19,"女");
        Employees employees2=new Employees("3","小智",15,"男");
        Employees employees3=new Employees("4","小刚",16,"男");
        Employees employees4=new Employees("5","小霞",15,"女");
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

    @PutMapping("/employees/{id}")
    public Employees putEmployee(@PathVariable  String id ,@RequestBody Employees e) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).id.equals(id)){
                list.remove(i);
                list.add(e);
                return e;
            }
        }
        return  null;
    }


      @PostMapping("/employees")
      public Employees postEmployees(@RequestBody  Employees employees){
          list.add(employees);
          return  employees;
      }


    @DeleteMapping ("/employees/{id}")
    public Employees deletEmployees(@PathVariable String id){
        for(int i=0;i<list.size();i++){
            if(list.get(i).id.equals(id)){
                return  list.remove(i);
            }
        }
        return  null;
    }
}
