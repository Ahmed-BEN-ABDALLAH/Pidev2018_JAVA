/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ghada
 */
public class demande {
     public int id;
    public String nom;
    public  String prenom;
    public  String adrese;
    public  Date disponibilite;
    public int idb ;
    public  String email;
    public int prix;
    public String description;
    public Date datefin;
    public  int numtel;
    public String image;
      private static int id_courant ;
        public double latitude;
    public double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdrese() {
        return adrese;
    }

    public void setAdrese(String adrese) {
        this.adrese = adrese;
    }

    public Date getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Date disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static int getId_courant() {
        return id_courant;
    }

    public static void setId_courant(int id_courant) {
        demande.id_courant = id_courant;
    }

    public demande(int id, String nom, String prenom, String adrese, Date disponibilite, int idb, String email, int prix, String description, Date datefin, int numtel, String image, double latitude, double longitude) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adrese = adrese;
        this.disponibilite = disponibilite;
        this.idb = idb;
        this.email = email;
        this.prix = prix;
        this.description = description;
        this.datefin = datefin;
        this.numtel = numtel;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public demande() {
    }

    @Override
    public String toString() {
        return "demande{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adrese=" + adrese + ", disponibilite=" + disponibilite + ", idb=" + idb + ", email=" + email + ", prix=" + prix + ", description=" + description + ", datefin=" + datefin + ", numtel=" + numtel + ", image=" + image + '}';
    }
      
      
    
    
}
