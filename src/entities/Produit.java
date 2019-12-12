/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author said
 */
public class Produit extends RecursiveTreeObject<Produit>
{
        private static int id_courant ;
        private static String categrie_courant ;

    public static String getCategrie_courant() {
        return categrie_courant;
    }

    public static void setCategrie_courant(String categrie_courant) {
        Produit.categrie_courant = categrie_courant;
    }
    public static ObservableList<Produit> Panier = FXCollections.observableArrayList();  

  
     
     
     
    public static ObservableList<Produit> getPanier() {
        return Panier;
    }

   
     public static boolean setPanier(Produit P) {
        Boolean Test=true;
        
    	for (int i = 0; i < Panier.size(); i++) {
        if(Panier.get(i).getId()==P.getId())
        {
                        Test=false;
                        Panier.get(i).setQuantite(Panier.get(i).getQuantite()+1);
                        P.setQuantite(P.getQuantite()+1);
                      //  System.out.println( Panier.get(i));
                     
        }
		}
       if(Test==true)
            {
             P.setQuantite(P.getQuantite()+1);
           Panier.add(P);
           
            }
     return Test;
    }
    public static int getId_courant() {
        return id_courant;
    }

    public static void setId_courant(int id_courant) {
        Produit.id_courant = id_courant;
    }
    
    private int id ;
    private int idf;
    private int prix;
    private int stock;
    private int quantite;
    private int rating;
    private int age;
    private String nom;
    private String image;
    private String categorie;
    private String description;
    private String genre;

    public Produit() {
    }

    public Produit(int id, int idf, int prix, int stock, int quantite, int rating, int age, String nom, String image, String categorie, String description, String genre) {
        this.id = id;
        this.idf = idf;
        this.prix = prix;
        this.stock = stock;
        this.quantite = quantite;
        this.rating = rating;
        this.age = age;
        this.nom = nom;
        this.image = image;
        this.categorie = categorie;
        this.description = description;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", idf=" + idf + ", prix=" + prix + ", stock=" + stock + ", quantite=" + quantite + ", rating=" + rating + ", age=" + age + ", nom=" + nom + ", image=" + image + ", categorie=" + categorie + ", description=" + description + ", genre=" + genre + '}';
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
