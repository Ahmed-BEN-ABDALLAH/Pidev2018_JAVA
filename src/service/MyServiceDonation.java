/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.User;
import entities.evenement;
import entities.personne;
import entities.produit_donation;
import util.MyConnexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Authentification;

/**
 *
 * @author AHMED
 */

public class MyServiceDonation {
                   private final User currentUser=Authentification.user;

        /************************************************************************************************************************/

    
                   
                   
                   public void approuver(produit_donation e) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update produit_donation set etat=?,appro=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);
    
     pss.setString(1,e.getEtat());
      pss.setInt(2,e.getAppro());
     pss.setInt(3,e.getId());
    
    pss.executeUpdate();

}
                   
                   
                         
                   public void desapprouver(produit_donation e) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update produit_donation set etat=?,appro=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);
    
     pss.setString(1,e.getEtat());
      pss.setInt(2,e.getAppro());
     pss.setInt(3,e.getId());
    
    pss.executeUpdate();

}
                   
                   
    public void insertionProd(produit_donation pd) {
        
        
        try {
            String req= "insert into produit_donation (nom,adresse,idu,datenow,description,tel,genre,image,etat,nomuser,appro,categorie) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            java.util.Date utiledate= new java.util.Date();
            java.sql.Date datnow= new java.sql.Date(utiledate.getTime());
            
            
            PreparedStatement ps = MyConnexion.getInstance().getConnection().prepareStatement(req);
            
                ps.setString(1,pd.nom);
                ps.setString(2,pd.adresse);
                ps.setInt(3,pd.idu);
                 
                ps.setDate(4,datnow);
                ps.setString(5,pd.description);
                ps.setInt(6,pd.tel);
                ps.setString(7, pd.genre);
                ps.setString(8, pd.image);
                ps.setString(9, pd.etat);
               
                                ps.setString(10, pd.nomuser);
   ps.setInt(11, pd.appro);
    ps.setString(12, pd.categorie);
                ps.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MyServiceDonation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    /********************************************************************************/
     public List<produit_donation> afficheDo()
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from produit_donation  ";
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            produit_donation pr = new produit_donation();
            
          pr.setId(rest.getInt("id"));
            pr.setIdu(rest.getInt("idu"));
            pr.setAppro(rest.getInt("appro"));
            pr.setEtat(rest.getString("etat"));
             pr.setNom(rest.getString("nom"));
              pr.setAdresse(rest.getString("adresse"));
               pr.setDescription(rest.getString("description"));
                pr.setCategorie(rest.getString("categorie"));
                 pr.setTel(rest.getInt("tel"));
                 pr.setImage(rest.getString("image"));
                 pr.setNomuser(rest.getString("nomuser"));
                  pr.setDatenow(rest.getDate("datenow"));
                                   pr.setTel(rest.getInt("nbj"));
                                   pr.setGenre(rest.getString("genre"));
      
            ALLproducts.add(pr);
            System.out.println("");
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(MyServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
return ALLproducts;       
    
    }
    /************************************************************************************************************************/
    
    public void afficheProd() throws SQLException{
    
    
     String sel="select * from produit_donation";       
 
    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(sel);
   
   
        ResultSet rs = pss.executeQuery();
     System.err.println("ID"+" "+" NOM DE PROD"+"   "+"ADRESSE" + "DATE NOW");

   while (rs.next()) {
  String nomProd = rs.getString("nom");
    String adresseProd = rs.getString("adresse");
         String idProd = rs.getString("id");
                  Date datenow = rs.getDate("datenow");

  System.out.println(idProd+"|"+nomProd+"|"+adresseProd+"|"+datenow);
 
}}

    /************************************************************************************************************************/

    
    public void deleteProd(int id) throws SQLException{
    
    
    
    
                          
                 String reqD="delete from produit_donation  where id=?";
    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqD);
     pss.setInt(1,id);
     
      pss.executeUpdate();
  
    
    }
    
        /************************************************************************************************************************/

    
    public void updateProd(produit_donation D) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update produit_donation set nom=?,adresse=?,description=?,categorie=?,image=?,tel=?,genre=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

                    
    pss.setString(1,D.getNom());
  
    pss.setString(2,D.getAdresse());
     pss.setString(3,D.getDescription());
       pss.setString(4,D.getCategorie());
          pss.setString(5,D.getImage());
          pss.setInt(6,D.getTel());
             pss.setString(7,D.getGenre());
     pss.setInt(8,D.getId());

    pss.executeUpdate();



}
    
    
    
       public List<produit_donation> MesDo()
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from produit_donation  where appro="+1+" AND idu="+currentUser.getId();
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            produit_donation pr = new produit_donation();
            
            pr.setId(rest.getInt("id"));
                   pr.setTel(rest.getInt("tel"));
            pr.setNom(rest.getString("nom"));
            pr.setAdresse(rest.getString("adresse"));
         
            pr.setCategorie(rest.getString("categorie"));
      
            pr.setDescription(rest.getString("description"));
      
         pr.setImage(rest.getString("image"));
            pr.setGenre(rest.getString("genre"));
         pr.setDatenow(rest.getDate("datenow"));
             pr.setEtat(rest.getString("etat"));
         
            ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(MyServiceDonation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
return ALLproducts;       
    
    }
      
    
    
        /************************************************************************************************************************/

    
       
        public produit_donation GetDobyid(int b) throws SQLException{
                        //-------------------- Update ----------//
 produit_donation pr = new produit_donation();
      
            String  query = "select * from produit_donation where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, b);
      ResultSet rest=  ps.executeQuery();
      
      
      while(rest.next())
        {   
           pr.setId(rest.getInt("id"));
            pr.setIdu(rest.getInt("idu"));
            pr.setAppro(rest.getInt("appro"));
            pr.setEtat(rest.getString("etat"));
             pr.setNom(rest.getString("nom"));
              pr.setAdresse(rest.getString("adresse"));
               pr.setDescription(rest.getString("description"));
                pr.setCategorie(rest.getString("categorie"));
                 pr.setTel(rest.getInt("tel"));
                 pr.setImage(rest.getString("image"));
                 pr.setNomuser(rest.getString("nomuser"));
                  pr.setDatenow(rest.getDate("datenow"));
                                   pr.setTel(rest.getInt("nbj"));
                                   pr.setGenre(rest.getString("genre")
                                   );

                  
                 
                 
                 
        }
    
        } catch (SQLException ex) {
            Logger.getLogger(MyServiceEvenement.class.getName()).log(Level.SEVERE, null, ex);
        }
return pr;


} 
}
