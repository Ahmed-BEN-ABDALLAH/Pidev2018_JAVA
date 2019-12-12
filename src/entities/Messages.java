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
public class Messages {
         private static int id_courant_message ;

    public static int getId_courant_message() {
        return id_courant_message;
    }

    public static void setId_courant_message(int id_courant_message) {
        Messages.id_courant_message = id_courant_message;
    }

     public int id ;
     public int id_recepteur;
     public int idEmetteur ;
     public String objet;
     public String contenu_message;

    public Messages(int id, int id_recepteur, int idEmetteur, String objet, String contenu_message) {
        this.id = id;
        this.id_recepteur = id_recepteur;
        this.idEmetteur = idEmetteur;
        this.objet = objet;
        this.contenu_message = contenu_message;
    }

    public Messages() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_recepteur() {
        return id_recepteur;
    }

    public void setId_recepteur(int id_recepteur) {
        this.id_recepteur = id_recepteur;
    }

    public int getIdEmetteur() {
        return idEmetteur;
    }

    public void setIdEmetteur(int idEmetteur) {
        this.idEmetteur = idEmetteur;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu_message() {
        return contenu_message;
    }

    public void setContenu_message(String contenu_message) {
        this.contenu_message = contenu_message;
    }

    @Override
    public String toString() {
        return "Messages{" + "id=" + id + ", id_recepteur=" + id_recepteur + ", idEmetteur=" + idEmetteur + ", objet=" + objet + ", contenu_message=" + contenu_message + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id;
        hash = 31 * hash + this.id_recepteur;
        hash = 31 * hash + this.idEmetteur;
        hash = 31 * hash + Objects.hashCode(this.objet);
        hash = 31 * hash + Objects.hashCode(this.contenu_message);
        return hash;
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
        final Messages other = (Messages) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_recepteur != other.id_recepteur) {
            return false;
        }
        if (this.idEmetteur != other.idEmetteur) {
            return false;
        }
        if (!Objects.equals(this.objet, other.objet)) {
            return false;
        }
        if (!Objects.equals(this.contenu_message, other.contenu_message)) {
            return false;
        }
        return true;
    }
             
             
             
             
    
}
