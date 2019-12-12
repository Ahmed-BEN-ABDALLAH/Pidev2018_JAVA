/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Publication;
import entities.Vues;
import util.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ikbel
 */
public class ServicePublication {
         public static void insertPublication(Publication p){
        try {
        String req ="INSERT INTO publication(id_categorie, id_user, idcategorie, titre_qestion, nbr_vue, created, location, contenu, nbr_reponse)VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,p.getId_categorie());
            ste.setInt(2,p.getIduser());
            ste.setInt(3,p.getId_categorie());
            ste.setString(4,p.getTitre());
            ste.setInt(5,p.getNbr_vue());
            ste.setInt(6,p.getCreated());
            ste.setString(7,p.getLocation());
             ste.setString(8,p.getContenu());
             ste.setInt(9,p.getNbrReponse());
            ste.executeUpdate();
            System.out.println("Publication Insérée");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public static void deleteCategorie(int Id){
        try {
            String req ="DELETE FROM publication WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,Id);
            ste.executeUpdate();
                     
        } catch (SQLException e) {
            System.out.println("modification failed");
        }
            
        }
    
      public static List<Publication> selectPublication(int id){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE id_user= ?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
       public static List<Publication> selectPublicationFor(int id){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE id_categorie= ?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
       public static List<Publication> selectPublicationF(int id){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT p.contenu , p.location , p.nbr_reponse , p.created , p.id_categorie , p.titre_qestion , p.nbr_vue , p.id FROM publication p JOIN categorie c ON p.id_categorie = c.id WHERE p.location LIKE 'approuver' AND (p.id_categorie=? OR c.id_cat =?) ORDER by p.created DESC";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ste.setInt(2,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
            public static List<Publication> selectPublicationAdmin(){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE location LIKE 'en attente'";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
         public static List<Publication> selectPublicationM(int id){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE id_user= ? AND location LIKE 'deapprouver'";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
       public static List<Publication> selectPublications(){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
     
     public static void updatePublication(String cont, String titr, int Id){
        try {
            String req ="UPDATE publication SET titre_qestion=? , contenu=? , location='en attente' WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setString(1,titr);
            ste.setString(2,cont);
            ste.setInt(3,Id);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
     public static Date convertirDate(int d){
         Timestamp stamp = new Timestamp(d);
         Date date = new Date(stamp.getTime());
         return(date);
     }
     public static String getNomcatt(int id){
           String val = "";
        try {

            String req = "SELECT nom FROM categorie where id=?";
            
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
        public static List<Publication> getSeeMore(int id){
      
List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
     }
         public static Publication getSeeMore2(int id){
      
         Publication p = new Publication(); 
            
            try {
            String req ="SELECT * FROM publication WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
               
                            p.setId(result.getInt("id")); 
                            p.setId_categorie(result.getInt("id_categorie"));
                            p.setResolu(result.getInt("resolu"));
                            p.setTitre(result.getString("titre_qestion"));
                            p.setNbr_vue(result.getInt("nbr_vue")); 
                            p.setCreated(result.getInt("created"));
                            p.setNbrReponse(result.getInt("nbr_reponse")); 
                            p.setLocation(result.getString("location")); 
                            p.setContenu(result.getString("contenu")); 
               
               
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return p;
     }
       public static void updatePublicationApprouver( int Id){
        try {
            String req ="UPDATE publication SET location='approuver' WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ste.setInt(1,Id);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
         public static void updatePublicationDesapprouver(int Id){
        try {
            String req ="UPDATE publication SET location='deapprouver' WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
           
            ste.setInt(1,Id);
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
         public static List<Publication> selectPublicationPop(){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE location LIKE 'approuver' ORDER BY nbr_vue DESC";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
         public static List<Publication> selectPublicationRec(){
            List <Publication> list = new ArrayList<>(); 
            
            try {
            String req ="SELECT * FROM publication WHERE location LIKE 'approuver' ORDER BY created DESC";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Publication(
                             result.getInt("id"),
                             result.getInt("id_categorie"),
                             result.getString("titre_qestion"),
                             result.getInt("nbr_vue"),
                       
                             result.getInt("created"),
                             result.getInt("nbr_reponse"),
                             result.getString("location"),
                             result.getString("contenu")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
        }
        public static void updateP(int Id){
        try {
            String req ="UPDATE publication SET nbr_reponse = nbr_reponse + 1 WHERE id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setInt(1,Id);
           
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
        
         
        public static List<Vues> selectViews(int idusr , int idpub)
        {
             List <Vues> list = new ArrayList<>(); 
            
            try {
            String req="SELECT * FROM vues WHERE iduser=? AND idPublication=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,idusr);
            ste.setInt(2,idpub);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                list.add(
               new Vues(
                             result.getInt("id"),
                             result.getInt("iduser"),
                             result.getInt("idPublication"),
                             result.getInt("vue")
               )
                );
 
            }
            
        } catch (SQLException ex) {
                System.out.println(ex.getMessage());
        }
            return list;
            }
        public static void updateView(int id){
        try {
            String req ="UPDATE publication SET nbr_vue = nbr_vue + 1 WHERE publication.id=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
            ste.setInt(1,id);
           
            ste.executeUpdate();         
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
        }
        public static void insertView(int idusr , int idpub){
        try {
        String req ="INSERT INTO vue(iduser, vue, idPublication)VALUES(?,1,?)";

        PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,idusr);
            ste.setInt(2,idpub);
            ste.executeUpdate();
            System.out.println("vue Insérée");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
      public static int selectRepRes(int id){
            int a=0;
            
            try {
            String req ="SELECT p.id_reponse FROM publicationresolu p JOIN publication c ON p.id_publication = c.id WHERE p.id_publication=?";
            PreparedStatement ste = MyConnexion.getInstance().getConnection().prepareStatement(req);
            ste.setInt(1,id);
            ResultSet result = ste.executeQuery();  
            while(result.next()){
                
                          a=   result.getInt("p.id_reponse")
               ;
                
            }
            
        } catch (SQLException ex) {
                System.out.println("77777777777777");
        }
            return a;
        }
}
