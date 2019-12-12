/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iserviceProduit;

import entities.Produit;
import entities.commentaireP;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface Produitinterface {
    public void AjoutProduit(Produit pr);
        public void SupprimerProduit(Produit pr);
            public List<Produit> AfficherProduit();
                 public List<Produit> AfficherProduitCategorie(String cat);
                public void UpdateProduit(Produit b) throws SQLException;
                    public void UpdateProduitStock(Produit b) throws SQLException;
                  public Produit GetProduitbyid(int b) throws SQLException;
                public  Produit rechercherparid(int id) throws SQLException  ;
                      public List<commentaireP> AfficherCommentaireP(Produit P);
                      public void AjouterCommentaire(commentaireP c);
                       public void AjouterRating(int r, int id, String nomP);
 public int AfficherRating(int id) throws SQLException;
 public List<Produit> RechercheProduitParNom(String recherche);
                            public List<Produit> AfficherProduitstock();
                            public List<Produit> AfficherProduitstock2();
                                 public void UpdateProduitstock(Produit b) throws SQLException;
                                public List<Produit> AfficherProduitfournisseur();
                                public void deletecommentaire(int id) ;
    
    
}
