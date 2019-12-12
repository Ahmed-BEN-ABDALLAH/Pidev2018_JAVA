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
public class Publicationresolu {
    private int id;
    private int id_pub;
    private int idpublication;
    private int id_reponse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public int getIdpublication() {
        return idpublication;
    }

    public void setIdpublication(int idpublication) {
        this.idpublication = idpublication;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public Publicationresolu(int id_pub, int idpublication, int id_reponse) {
        this.id_pub = id_pub;
        this.idpublication = idpublication;
        this.id_reponse = id_reponse;
    }

    public Publicationresolu() {
    }
  
}
