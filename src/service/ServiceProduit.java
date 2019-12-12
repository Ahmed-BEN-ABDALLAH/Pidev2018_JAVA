/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import util.MyConnexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entities.Produit;
import entities.User;
import entities.commentaireP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Authentification;
import iserviceProduit.Produitinterface;

/**
 *
 * @author said
 */
public class ServiceProduit implements Produitinterface {

     private final User currentUser=Authentification.user;
     @Override
    public void AjoutProduit(Produit pr) 
    {
        String query="insert into produit (nom,prix,stock,quantite,image,categorie,description,age,genre,idf) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareStatement(query);
            ps.setString(1, pr.getNom());
            ps.setInt(2, pr.getPrix());
            ps.setInt(3, pr.getStock());
            ps.setInt(4, pr.getQuantite());
            ps.setString(5, pr.getImage());
            ps.setString(6, pr.getCategorie());
            ps.setString(7, pr.getDescription());
            ps.setInt(8, pr.getAge());
            ps.setInt(10,currentUser.getId());
            ps.setString(9, pr.getGenre());
            
        ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
      @Override
    public void SupprimerProduit(Produit pr)
    {
        
        String query2 = "delete from comment where produit_id = ? ";
        PreparedStatement ps2;
        try {
            ps2 = MyConnexion.getInstance().getConnection().prepareCall(query2);
            ps2.setInt(1,pr.getId());
        ps2.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String query = "delete from produit where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, pr.getId());
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @Override
    public List<Produit> AfficherProduit()
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from produit WHERE stock > 0 OR stock=null";
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            pr.setIdf(rest.getInt("idf"));
            ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return ALLproducts;       
    
    }
      @Override
     public List<Produit> AfficherProduitCategorie(String cat)
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from produit where categorie ='"+cat+"'";
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return ALLproducts;       
    
    }
      @Override
    public void UpdateProduit(Produit b) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update produit set nom=?,stock=?,age=?,description=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

                            System.out.println(b);
    pss.setString(1,b.getNom());
    
    
    pss.setInt(2,b.getStock());
    pss.setInt(3,b.getAge());
     pss.setString(4,b.getDescription());
    
     pss.setInt(5,b.getId());

    pss.executeUpdate();
}
    
      @Override
    public void UpdateProduitStock(Produit b) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update produit set stock=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

    pss.setInt(1,b.getStock());
     pss.setInt(2,b.getId());
    pss.executeUpdate();

}
      @Override
    public Produit GetProduitbyid(int b) throws SQLException{
                        //-------------------- Update ----------//
 Produit pr = new Produit();
      
            String query = "select * from produit where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1, b);
      ResultSet rest=  ps.executeQuery();
      
      
      while(rest.next())
        {   
           
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
        }
    
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
return pr;


}
      @Override
    public  Produit rechercherparid(int id) throws SQLException   {
    
        Produit p = new Produit();
    
        String query = "SELECT * FROM `Produit` WHERE id=?";
            PreparedStatement st= (PreparedStatement) MyConnexion.getInstance().getConnection().createStatement();
            st.setInt(1, id);
            ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            
        }

        return p;

    }
   
      @Override
    public List<commentaireP> AfficherCommentaireP(Produit P)
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from comment WHERE produit_id="+P.getId();
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            commentaireP pr = new commentaireP();
            
            pr.setId(rest.getInt("id"));
            pr.setProduit_id(rest.getInt("produit_id"));
            pr.setUser_id(rest.getInt("user_id"));
            pr.setContent(rest.getString("content"));
            pr.setCreatedAt(rest.getDate("createdAt"));
              ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return ALLproducts;       
    
    }
    
  @Override
            public void AjouterCommentaire(commentaireP c)
    {
       java.util.Date utiledate= new java.util.Date();
            java.sql.Date datnow= new java.sql.Date(utiledate.getTime());
   
        String query2="insert into comment (produit_id,user_id,content,createdAt) values (?,?,?,?)";
        PreparedStatement ps2;
        try {
            ps2 = MyConnexion.getInstance().getConnection().prepareStatement(query2);
           
            ps2.setInt(1,c.getProduit_id());
            ps2.setInt(2,c.getUser_id());
            ps2.setString(3,c.getContent());
            ps2.setDate(4,datnow);
           
        ps2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         @Override     
    public void AjouterRating(int r, int id, String nomP)
    {
      
        String query2="insert into rating (rating,nom_produit,idproduit) values (?,?,?)";
        PreparedStatement ps2;
        try {
            ps2 = MyConnexion.getInstance().getConnection().prepareStatement(query2);
           
            ps2.setInt(1,r);
            ps2.setString(2,nomP);
            ps2.setInt(3,id);
           
        ps2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @Override
    public int AfficherRating(int id) throws SQLException
    {  int rate = 0;
        
            Connection conn= (Connection) MyConnexion.getInstance().getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("select avg(rating) from rating where idproduit="+id);
   
        while (rs.next()) {
            rate= rs.getInt(1);
        }
            return rate;
        }
    
      @Override
    public List<Produit> RechercheProduitParNom(String recherche) {

List ALLproducts = new ArrayList();
        try {  
           String query="select * from produit WHERE nom LIKE '%"+recherche+"%' AND stock > 0 OR stock=null;";
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
    return ALLproducts;       
    
    }

      @Override
    public List<Produit> AfficherProduitstock() {

        List produitssansstock = new ArrayList();
        try {  
           String query="select * from produit WHERE stock =0 AND idf="+currentUser.getId();
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            produitssansstock.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return produitssansstock;       
    
    }
      @Override
public List<Produit> AfficherProduitstock2() {

        List produitssansstock = new ArrayList();
        try {  
           String query="select * from produit WHERE stock =-1 AND idf="+currentUser.getId();
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            produitssansstock.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return produitssansstock;       
    
    }
      @Override
   public void UpdateProduitstock(Produit b) throws SQLException{
                        //-------------------- Update ----------//

                String reqUp="update produit set nom=?,stock=?,quantite=? where id=?";
                    PreparedStatement pss = MyConnexion.getInstance().getConnection().prepareStatement(reqUp);

                    
    pss.setString(1,b.getNom());
    
    
    pss.setInt(2,b.getStock()-1);
    pss.setInt(3,b.getQuantite());
    
     pss.setInt(4,b.getId());

    pss.executeUpdate();
}  
 
      @Override
    public List<Produit> AfficherProduitfournisseur()
    {   List ALLproducts = new ArrayList();
        try {  
           String query="select * from produit WHERE idf="+currentUser.getId();
           Statement st= MyConnexion.getInstance().getConnection().createStatement();
           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            Produit pr = new Produit();
            
            pr.setId(rest.getInt("id"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            ALLproducts.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return ALLproducts;       
    
    }
  @Override
    public void deletecommentaire(int id) {
        

        String query = "delete from comment where id = ? ";
        PreparedStatement ps;
        try {
            ps = MyConnexion.getInstance().getConnection().prepareCall(query);
            ps.setInt(1,id);
        ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}