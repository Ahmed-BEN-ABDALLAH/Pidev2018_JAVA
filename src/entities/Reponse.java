/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ikbel
 */
public class Reponse {
    private int id;
    private String contenu;
    private Date created;
    private int id_publication;
    private int id_user;
    private int avis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getId_publication() {
        return id_publication;
    }

    public void setId_publication(int id_publication) {
        this.id_publication = id_publication;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getAvis() {
        return avis;
    }

    public void setAvis(int avis) {
        this.avis = avis;
    }

    public Reponse() {
    }

    public Reponse(String contenu, Date created) {
        this.contenu = contenu;
        this.created = created;
    }

    public Reponse(String contenu, Date created, int id_user) {
        this.contenu = contenu;
        this.created = created;
        this.id_user = id_user;
    }
        public Reponse(int id_publication, String contenu, Date created, int id_user) {
            this.id_publication= id_publication;
        this.contenu = contenu;
        this.created = created;
        this.id_user = id_user;
    }
        public Reponse(String contenu,int id, Date created, int id_user) {
            this.id= id;
        this.contenu = contenu;
        this.created = created;
        this.id_user = id_user;
    }


    @Override
    public String toString() {
        return "";
    }
 
}
