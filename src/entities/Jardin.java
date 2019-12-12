/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author qyen
 */
public class Jardin {
     private static int id_courant_jardin ;

    public static int getId_courant_jardin() {
        return id_courant_jardin;
    }

    public static void setId_courant_jardin(int id_courant_jardin) {
        Jardin.id_courant_jardin = id_courant_jardin;
    }
   
    
     public int id;
    public String nom;
    public String description;
    public String adresse;
    public String logo;
    public int proprietaire;
    public int numtel;
    public int nbrnote;
    public int note;
    public String adresseemail;
    public String etat;

    public Jardin(int id, String nom, String description, String adresse, String logo, int proprietaire, int numtel, int nbrnote, int note, String adresseemail, String etat) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.adresse = adresse;
        this.logo = logo;
        this.proprietaire = proprietaire;
        this.numtel = numtel;
        this.nbrnote = nbrnote;
        this.note = note;
        this.adresseemail = adresseemail;
                this.etat = etat;

    }

    public Jardin() {
    }

    public Jardin(int id, String nom, String description, String adresse, String logo, int proprietaire, int numtel, String adresseemail) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.adresse = adresse;
        this.logo = logo;
        this.proprietaire = proprietaire;
        this.numtel = numtel;
        this.adresseemail = adresseemail;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public int getNbrnote() {
        return nbrnote;
    }

    public void setNbrnote(int nbrnote) {
        this.nbrnote = nbrnote;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getAdresseemail() {
        return adresseemail;
    }

    public void setAdresseemail(String adresseemail) {
        this.adresseemail = adresseemail;
    }

    @Override
    public String toString() {
        return "Jardin{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", adresse=" + adresse + ", logo=" + logo + ", proprietaire=" + proprietaire + ", numtel=" + numtel + ", nbrnote=" + nbrnote + ", note=" + note + ", adresseemail=" + adresseemail + '}';
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
        final Jardin other = (Jardin) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.proprietaire != other.proprietaire) {
            return false;
        }
        if (this.numtel != other.numtel) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.logo, other.logo)) {
            return false;
        }
        if (!Objects.equals(this.adresseemail, other.adresseemail)) {
            return false;
        }
        return true;
    }



    
}
