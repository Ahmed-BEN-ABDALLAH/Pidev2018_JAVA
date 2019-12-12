/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Categorie;
import util.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ikbel
 * 
 */
public class ServiceCategorie {
        public static void change () 
     {
          try {
         String req1 = " ALTER TABLE `categorie` ADD CONSTRAINT  FOREIGN KEY (`id_cat`) REFERENCES `categorie`(`id`) ON DELETE CASCADE ON UPDATE CASCADE";
             PreparedStatement ste1 = MyConnexion.getInstance().getConnection().prepareStatement(req1);
             ste1.execute();
             
             
              } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }
   
    public static void change1 () 
     {
          try {
         String req1 = "ALTER TABLE `publication` ADD CONSTRAINT FOREIGN KEY (`id_categorie`) REFERENCES `pidev`.`categorie`(`id`) ON DELETE CASCADE ON UPDATE CASCADE";
             PreparedStatement ste1 = MyConnexion.getInstance().getConnection().prepareStatement(req1);
             ste1.execute();
             
             
              } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }
      
     public static void insertCategorie(Categorie c){
        try {
        String req ="INSERT INTO categorie(`nom`,`nbr_publications`,`type`) VALUES(?,?,?)";
        
        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
          
        ste.setString(1,c.getNom());
         ste.setInt(2,c.getNbr_publication());
            ste.setString(3,c.getType());
            ste.executeUpdate();
             System.out.println("Insertion effectuée avec succés");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
   
    public static void deleteCategorie(int Id){
        try {
          
         
            String req ="DELETE FROM categorie WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,Id);
            ste.executeUpdate();
            ServiceCategorie.selectNomCategorie();
            
                     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            
        }
    
      public static List<Categorie> selectCategorie(){
            List <Categorie> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM categorie";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ResultSet result = ste.executeQuery();   
            while(result.next()){
                list.add(
                new Categorie(result.getInt("id"),
                             result.getString("nom"),
                             result.getInt("nbr_publications"),
                             result.getString("type")));
            }
            
        } catch (SQLException ex) {
                System.out.println("select erreur");
        }
            return list;
        }
            public static List<String> selectNomCategorie(){
            List <String> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT nom FROM categorie  WHERE type LIKE 'categorie'";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ResultSet result = ste.executeQuery();   
            while(result.next()){
                list.add(
                
                             result.getString("nom"));
            }
            
        } catch (SQLException ex) {
                System.out.println("select erreur");
        }
            return list;
        }
              public static List<String> selectCategories(){
            List <String> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT nom FROM categorie";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ResultSet result = ste.executeQuery();   
            while(result.next()){
                list.add(
                
                             result.getString("nom"));
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
      public static List<Categorie> selectNomCategorieM(){
            List <Categorie> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM categorie WHERE type LIKE 'categorie'";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ResultSet result = ste.executeQuery();   
            while(result.next()){
                list.add(
                
                             new Categorie(result.getInt("id"),
                             result.getInt("id_cat"),
                             result.getString("nom"),
                             result.getInt("nbr_publications"),
                             result.getString("type")));
            }
            
        } catch (SQLException ex) {
                System.out.println("select erreur");
        }
            return list;
        }
     public static void updateCategorie(String n, int d){
        try {
            String req ="UPDATE categorie SET nom=? WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setString(1,n);
            ste.setInt(2,d);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println("update erreur");
            
        }
            
        }
     
        public static int  getIdcat(String s) {
        int val = -1;
        try {

            String req = "SELECT id FROM categorie where nom=?";
            
           PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);

            ste.setString(1,s);
           
  ResultSet result = ste.executeQuery();
 while(result.next()){
     val=result.getInt("id");
 }
  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return val;
    }
   public static String  getTypecat(int b) {
        String val = "";
        try {

            String req = "SELECT type FROM categorie where id=?";
            
           PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);

            ste.setInt(1,b);
           
  ResultSet result = ste.executeQuery();
 while(result.next()){
     val=result.getString("type");
 }
  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return val;
    }
   
   
    public static void inserersouscategorie(Categorie c,int i){
        try {
        String req ="INSERT INTO categorie( `nom`, `nbr_publications`, `type`,`id_cat`) VALUES(?,?,?,?)";
        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setString(1,c.getNom());
            ste.setInt(2,c.getNbr_publication());
            ste.setString(3,c.getType());
          ste.setInt(4,i);
            ste.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        
    }
       public static List<Categorie> affichersouscategorie(int i){
           List <Categorie> list = new ArrayList<>();
        try {
        String req ="SELECT * FROM categorie WHERE id_cat = ?";
        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setInt(1,i);         
           
            ResultSet result = ste.executeQuery();   
            while(result.next()){
             list.add(
                new Categorie(result.getInt("id"),
                             result.getString("nom"),
                             result.getInt("nbr_publications"),
                             result.getString("type")));
            
        }}
        catch(SQLException e){
            System.out.println(e.getMessage());
            
        }
        return list;
        
       }
       public static void getCat(int i)
       {
             try {
            String req ="UPDATE categorie SET nbr_publications=nbr_publications + 1 WHERE id=? AND type LIKE 'categorie'";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setInt(1,i);
            ste.setInt(2,i);
            //ste.setInt(3,i);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
               try {
            String req1 ="UPDATE categorie SET nbr_publications=nbr_publications + 1 WHERE id=? AND type LIKE 'sous-categorie'";
            PreparedStatement ste1 = MyConnexion.getInstance().getConnection().prepareStatement(req1);
            
            ste1.setInt(1,i);
            
            ste1.executeUpdate();         
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
            
        }
        }
}