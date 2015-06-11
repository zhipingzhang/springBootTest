package com.qf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")  
public class Person {  
   
    private int id;  
    private String name;  
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String toString(){  
        return "ID: "+id+" - Name: "+name;  
    }  
   
}  