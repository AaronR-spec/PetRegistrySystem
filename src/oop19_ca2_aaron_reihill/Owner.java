/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_aaron_reihill;

import java.util.ArrayList;

/**
 *
 * @author D00222467
 */
public class Owner {
    private String name;
    private static int id;
    private String email;
    private String telephone;
    private String address;
    private ArrayList<Pet> pets;

    public Owner(String name,ArrayList<Pet> pets) 
    {
        this.name = name;
        this.pets = pets;
    }

    public Owner(String name, String email, String telephone, String address,ArrayList<Pet> pets) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.pets = pets;
    }

    public Owner(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setId(int id) {
        Owner.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
