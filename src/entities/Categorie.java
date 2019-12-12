/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
/**
 *
 * @author ikbel
 */
public class Categorie {
 private int id; 
 private int id_cat;
 private String nom;
 private int nbr_publication;
 private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbr_publication() {
        return nbr_publication;
    }

    public void setNbr_publication(int nbr_publication) {
        this.nbr_publication = nbr_publication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Categorie() {
    }

    public Categorie(int id, int id_cat, String nom, int nbr_publication, String type) {
        this.id = id;
        this.id_cat = id_cat;
        this.nom = nom;
        this.nbr_publication = nbr_publication;
        this.type = type;
    }
    public Categorie(String nom, int nbr_publication, String type,int id_cat) {
        
        this.id_cat = id_cat;
        this.nom = nom;
        this.nbr_publication = nbr_publication;
        this.type = type;
    }   
     public Categorie(  String nom, int nbr_publication, String type) {
       
        
        this.nom = nom;
        this.nbr_publication = nbr_publication;
        this.type = type;
    }
    
     public Categorie(int id, String nom, int nbr_publication, String type) {
        this.id = id;
        this.nom = nom;
        this.nbr_publication = nbr_publication;
        this.type = type;

     }

    @Override
    public String toString() {
        return "";
    }
     
    

    
    


}

    
