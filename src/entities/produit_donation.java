/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author AHMED
 */
public class produit_donation {
     private static int id_courant_do ;

    public static int getId_courant_do() {
        return id_courant_do;
    }

    @Override
    public String toString() {
        return "produit_donation{" + "id=" + id + ", nom=" + nom + ", idu=" + idu + ", categorie=" + categorie + ", image=" + image + ", tel=" + tel + ", adresse=" + adresse + ", nomuser=" + nomuser + ", datenow=" + datenow + ", genre=" + genre + ", appro=" + appro + ", etat=" + etat + ", description=" + description + ", nbj=" + nbj + '}';
    }

    public static void setId_courant_do(int id_courant) {
        produit_donation.id_courant_do = id_courant;
    }
    
           public int id ;
           public String nom ;
           public int idu;
           public String categorie ;
           public String image  ;
           public int tel  ;  
           public String  adresse;
           public String nomuser;
           public java.util.Date datenow =new java.util.Date();
           public String genre;
           public int appro;
           public String etat;
             public String description;

           
           
    public produit_donation(int id, String nom, int idu, String categorie, String image, int tel, String adresse, String nomuser, String genre, int appro, String etat, int nbj) {
        this.id = id;
        this.nom = nom;
        this.idu = idu;
        this.categorie = categorie;
        this.image = image;
        this.tel = tel;
        this.adresse = adresse;
        this.nomuser = nomuser;
        this.genre = genre;
        this.appro = appro;
        this.etat = etat;
        this.nbj = nbj;
    }
           
    
    
       


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public produit_donation() {
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

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomuser() {
        return nomuser;
    }

    public void setNomuser(String nomuser) {
        this.nomuser = nomuser;
    }

    public java.util.Date getDatenow() {
        return datenow;
    }

    public void setDatenow(java.util.Date datenow) {
        this.datenow = datenow;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAppro() {
        return appro;
    }

    public void setAppro(int appro) {
        this.appro = appro;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNbj() {
        return nbj;
    }

    public void setNbj(int nbj) {
        this.nbj = nbj;
    }
           public int nbj;

    
}
