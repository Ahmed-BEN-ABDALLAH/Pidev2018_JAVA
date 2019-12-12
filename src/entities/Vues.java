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
public class Vues {
    private int id;
    private int iduser;
    private int idPublication;
    private int idcategorie;
    private int vue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getVue() {
        return vue;
    }

    public void setVue(int vue) {
        this.vue = vue;
    }

    public Vues(int vue) {
        this.vue = vue;
    }

    public Vues() {
    }

    public Vues(int id, int iduser, int idPublication, int vue) {
        this.id=id;
        this.iduser = iduser;
        this.idPublication = idPublication;
        this.vue = vue;
    }

}
