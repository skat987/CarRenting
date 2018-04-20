/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrenting;

import java.util.ArrayList;

/**
 *
 * @author eleve2
 */
public class Customer {
    
    private String firstName;
    private String lastName;
    private int age;
    private int license;
    private ArrayList<Integer> debits;
    
    public Customer(String firstName, String lastName, int age, int license) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.license = license;
        this.debits = new ArrayList<Integer>();
        
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public void setAge(int newAge) {
        this.age = newAge;
    }
    
    public int getLicense() {
        return this.license;
    }
    
    public void setLicense(int value) {
        this.license = value;
    }
    
}
