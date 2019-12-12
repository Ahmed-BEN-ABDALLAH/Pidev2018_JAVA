/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import util.MyConnexion;
import entities.Produit;
import entities.User;
import entities.commande;
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
 * @author said
 */
public class ServiceCommande {
    User currentUser=Authentification.user;
    public void valide_btn(commande a) throws SQLException
    {
        String query="update commande set etat=? where id=? ";
        PreparedStatement ps;
            ps = MyConnexion.getInstance().getConnection().prepareStatement(query);
           
            ps.setInt(1,1);
            ps.setInt(2,a.getId());
           
        ps.executeUpdate();

    }
    public void AjoutCommande(Produit pr,int idp) 
    {
        String query="insert into commande (nom,prix,stock,quantite,image,categorie,description,age,genre,idp,etat,idc,idf,nomc) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            ps.setString(9, pr.getGenre());
            ps.setInt(10, idp);
            ps.setInt(11, 0);
           
            ps.setInt(12,currentUser.getId());
             ps.setInt(13, pr.getIdf());
                   ps.setString(14,currentUser.getNom());
        ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
    
     public List<commande> afficheCommande(int idf)
    {   List Allcommande = new ArrayList();
        try {  
           String query="select * FROM commande where idf="+idf+" AND etat=0 order by idc ASC";
           Statement st= MyConnexion.getInstance().getConnection().createStatement();

           ResultSet rest = st.executeQuery(query);  
             while(rest.next())
        {   
            
            commande pr = new commande();
            pr.setId(rest.getInt("id"));
            pr.setIdf(rest.getInt("idf"));
            pr.setIdc(rest.getInt("idc"));
            pr.setNom(rest.getString("nom"));
            pr.setPrix(rest.getInt("prix"));
            pr.setStock(rest.getInt("stock"));
            pr.setQuantite(rest.getInt("quantite"));
            pr.setImage(rest.getString("image"));
            pr.setCategorie(rest.getString("categorie"));
            pr.setDescription(rest.getString("description"));
            pr.setAge(rest.getInt("age"));
            pr.setGenre(rest.getString("genre"));
            Allcommande.add(pr);
        }
           
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return Allcommande;       
    
    }
    
    
}
