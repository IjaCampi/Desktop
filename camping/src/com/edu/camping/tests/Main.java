/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.camping.tests;

import com.edu.camping.utils.DBconnection;

import com.edu.camping.models.Utilisateur;
import com.edu.camping.services.User_service;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import java.time.Month;






/**
 *
 * @author nmedia
 */
public class Main {
    public static void main(String[] args)   {
        

        
        Utilisateur e= new Utilisateur (29 ,25478556, "Ham", "jBELI","rue tunis","houssemjbeli","houssem1234","camper","2000-01-21");
        Utilisateur e1= new Utilisateur (25078556, "Hoem", "jBELI","rue tunis","amri","hou1234","camper", "1998-10-10");
                Utilisateur e3= new Utilisateur ( 25078556, "Hamd", "zgoli","rue tunis","hamd12","124","camper", "1997-10-10");
                               Utilisateur u3= new Utilisateur ( 25078556, "anis", "zgoli","rue tunis","hamd12","124","admin", "1998-10-11");

    User_service ps = new User_service();
        
        try {
           ps.addOne(u3);
           ps.deleteOne(e);
           ps.updateOne(e);
       } catch (SQLException ex) {
           System.out.println();
       };
        try {
            System.out.println(ps.rechercheParNom(e3));
         System.out.println(ps.trierNom());
         
       } catch (SQLException ex) {
        System.out.println(ex.getMessage());
       }
        
 } }  

    

