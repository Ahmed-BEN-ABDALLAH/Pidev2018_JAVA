/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Publication;
import entities.Publicationresolu;
import entities.Reponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.MyConnexion;

/**
 *
 * @author ikbel
 */
public class ServiceReponse {
      public static void change2 () 
     {
          try {
         String req1 = " ALTER TABLE `publicationresolu` ADD CONSTRAINT  FOREIGN KEY (`id_reponse`) REFERENCES `reponse`(`id`) ON DELETE CASCADE ON UPDATE CASCADE";
             PreparedStatement ste1 =  MyConnexion.getInstance().getConnection().prepareStatement(req1);
             ste1.execute();
             
             
              } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     }
    
     public static void insertReponse(Reponse r){
        try {
        String req ="INSERT INTO reponse(id_publication, id_user, created, contenu)VALUES(?,?,?,?)";

        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,r.getId_publication());
            ste.setInt(2,r.getId_user());
            ste.setDate(3,r.getCreated());
            ste.setString(4,r.getContenu());

            ste.executeUpdate();
            System.out.println("Reponse Insérée");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void deleteReponse(int Id){
        try {
            String req ="DELETE FROM reponse WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,Id);
            ste.executeUpdate();
                     
        } catch (SQLException e) {
            System.out.println("suppression failed");
        }
            
        }
    
      public static List<Reponse> selectReponse(int id){
            List <Reponse> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM reponse WHERE id= ?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Reponse(
                             result.getInt("id"),
                             result.getString("contenu"),
                             result.getDate("created"),
                             result.getInt("id_user")));
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
           public static List<Reponse> selectReponseUsr(int id){
            List <Reponse> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM reponse WHERE id_user= ?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Reponse(
                             result.getInt("id"),
                             result.getString("contenu"),
                             result.getDate("created"),
                             result.getInt("id_user")));
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
           public static List<Reponse> selectReponseUsr2(int id){
            List <Reponse> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT reponse.id_user , reponse.created , reponse.contenu , reponse.id FROM reponse JOIN publicationresolu ON reponse.id != publicationresolu.id_reponse WHERE id_user= ?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Reponse(
                       result.getString("reponse.contenu"),
                             result.getInt("reponse.id"),
                             
                             result.getDate("reponse.created"),
                             result.getInt("reponse.id_user")));
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
     public static void updateReponse(int Id, String c){
        try {
            String req ="UPDATE reponse SET contenu=? WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setString(1,c);
            ste.setInt(2,Id);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
     
    public static String getNomAuthor(int id)
    { 
        String val = "";
        try {
        String req ="SELECT nom FROM fos_user WHERE id=?";
         PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setInt(1,id);
             ResultSet result = ste.executeQuery();
 while(result.next()){
     val=result.getString("nom");
 }
             } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return val;
    }
     public static int getIdpub(int id){
           int val = -1;
        try {

            String req = "SELECT id_publication FROM reponse where id=?";
            
           PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);

            ste.setInt(1,id);
           
  ResultSet result = ste.executeQuery();
 while(result.next()){
     val=result.getInt("id_publication");
 }
  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return val;
     }
      public static int getIdpubR(int id){
           int val = -1;
        try {

            String req = "SELECT id FROM publicationresolu where id_reponse=?";
            
           PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);

            ste.setInt(1,id);
           
  ResultSet result = ste.executeQuery();
 while(result.next()){
     val=result.getInt("id");
 }
  
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return val;
     }
    public static void Myresolu(Publicationresolu p)
    {
      
     try {
        String req ="INSERT INTO `publicationresolu` (`id_publication`, `id_reponse`, `id_pub`) VALUES ( ?, ?, ?);";

        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
         
          ste.setInt(1,p.getIdpublication());
            ste.setInt(2,p.getId_reponse());
            ste.setInt(3,p.getId_pub());

            ste.executeUpdate();
            System.out.println("pub resolu Insérée");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
                try {
            String req ="UPDATE publication SET resolu=1 WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,p.getIdpublication());
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    public static void MyNonresolu(int pr, int p)
    {
      
     try {
        String req ="DELETE FROM `publicationresolu` WHERE id=?";

        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
         
          ste.setInt(1,pr);
            

            ste.executeUpdate();
            System.out.println("pub resolu Insérée");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
                try {
            String req ="UPDATE publication SET resolu=0 WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,p);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
          public static Reponse selectRepons(int id){
            Reponse r = new Reponse(); 
            
            try {
            String req ="SELECT * FROM reponse WHERE id= ?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
               
                            r.setId(result.getInt("id")); 
                             r.setContenu(result.getString("contenu"));
                             r.setId_user(result.getInt("id_user"));
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return r;
        }
}
