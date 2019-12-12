/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author ghada
 */

import entities.User;
import entities.baby;
import entities.demande;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Authentification;
import util.MyConnexion;


public class serviceDemande {
   private final User currentUser=Authentification.user;
   
   
   
   
   
     public static demande GetBabybyid(int id_courant) {

      demande bb = new demande();
        try {
            //-------------------- Update ----------//
      
            
            String query = "select * from demande where id = ? ";
            PreparedStatement ps;
            
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, id_courant);
            ResultSet rest=  ps.executeQuery();
            
            
            while(rest.next())
            {
                
                
                bb.setId(rest.getInt("id"));
                bb.setNom(rest.getString("nom"));
                bb.setPrenom(rest.getString("prenom"));
                bb.setAdrese(rest.getString("adrese")); 
                 bb.setNumtel(rest.getInt("numtel"));
                
                   bb.setPrix(rest.getInt("prix")); 
                     bb.setEmail(rest.getString("email")); 
                       bb.setDescription(rest.getString("description")); 
                         bb.setDisponibilite(rest.getDate("disponibilite")); 
                           bb.setDatefin(rest.getDate("datefin"));
                           bb.setImage(rest.getString("image"));
                           bb.setLongitude(rest.getDouble("longitude"));
                           bb.setLatitude(rest.getDouble("latitude"));
            }
            
            
     
        } catch (SQLException ex) {
            Logger.getLogger(serviceDemande.class.getName()).log(Level.SEVERE, null, ex);
        }

       return bb;

    }
     
      public void updatebaby(demande b) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update demande set nom=?,prenom=?,adrese=?,disponibilite=?,email=?,prix=?,description=?,datefin=?,numtel=?,image=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

                    
    pss.setString(1,b.getNom());
     pss.setString(2,b.getPrenom());
            pss.setString(3,b.getAdrese());
             pss.setDate(4,b.getDisponibilite());
              
               pss.setString(5,b.getEmail());
               pss.setInt(6,b.getPrix());
               pss.setString(7,b.getDescription());
                pss.setDate(8, b.getDatefin());
                  pss.setInt(9,b.getNumtel());
                   pss.setString(10,b.getImage());
    

    
     pss.setInt(11,b.getId());

    pss.executeUpdate();



}
     
    public  void ajouterP (demande p){
    
        try {
            String req = " insert into demande (id,nom,prenom,adrese,disponibilite,idb,email,prix,description,datefin,numtel,image,longitude,latitude) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= MyConnexion.getInstance().getConnection().prepareStatement(req);
             ps.setInt(1, p.id);
            ps.setString(2,p.nom);
            ps.setString(3,p.prenom);
            ps.setString(4,p.adrese);
             ps.setDate(5, p.disponibilite);
              ps.setInt(6,p.idb);
               ps.setString(7,p.email);
               ps.setInt(8,p.prix);
               ps.setString(9,p.description);
                ps.setDate(10, p.datefin);
                  ps.setInt(11,p.numtel);
                   ps.setString(12,p.image);
                        ps.setDouble(13,p.longitude);
                     ps.setDouble(14,p.latitude);
           
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
                 
    }
    
          public void SupprimerBaby(demande b)
    {
        try {
            String query = "delete from demande where id = ? ";
            PreparedStatement ps;
            
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, b.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    public List<demande> Afficherbaby()
    {           List Allbabies = new ArrayList();

        
        try {
        
        String query="select * from demande";
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
        while(rest.next())
        {
            
            demande b  = new demande();
            
            b.setId(rest.getInt("id"));
            b.setNom(rest.getString("nom"));
            b.setPrenom(rest.getString("prenom"));
            b.setAdrese(rest.getString("adrese"));
           // b.setDisponibilite(rest.getDate("disponibilite"));
            b.setEmail(rest.getString("email"));
            b.setPrix(rest.getInt("prix"));
           // b.setDescription(rest.getString("description"));
           // b.setDatefin(rest.getDate("datefin"));
            b.setNumtel(rest.getInt("numtel"));
                   b.setImage(rest.getString("image"));
//                   System.out.println(b.getImage());
                        Allbabies.add(b);
            
            
            
            
     
            
        }   } catch (SQLException ex) {                 
            Logger.getLogger(serviceDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
                   return Allbabies;     
    }
    public List<demande> Affichermesbaby()
    {           List Allbabies = new ArrayList();

        
        try {
        
        String query="select * from demande where idb="+currentUser.getId();
        Statement st= MyConnexion.getInstance().getConnection().createStatement();
        ResultSet rest = st.executeQuery(query);
        baby b1  = new baby();

        while(rest.next())
        {
            
            
            demande b  = new demande();
            b.setId(rest.getInt("id"));
            System.out.println(b.getId());
            b.setNom(rest.getString("nom"));
            b.setPrenom(rest.getString("prenom"));
            b.setAdrese(rest.getString("adrese"));
           // b.setDisponibilite(rest.getDate("disponibilite"));
            b.setEmail(rest.getString("email"));
            b.setPrix(rest.getInt("prix"));
           // b.setDescription(rest.getString("description"));
           // b.setDatefin(rest.getDate("datefin"));
            b.setNumtel(rest.getInt("numtel"));
                   b.setImage(rest.getString("image"));
//                   System.out.println(b.getImage());

                        Allbabies.add(b);
            
            
            
            
     
            
        } 
        } catch (SQLException ex) {                 
            Logger.getLogger(serviceDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
                   return Allbabies;     
    }   
}
