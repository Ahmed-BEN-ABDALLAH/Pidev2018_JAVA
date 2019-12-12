/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author ikbel
 */
public class Avis {
    private int id;
    private float avis;
    private Date created;
    private int reponse;
    private int id_user;

    public Avis() {
    }

    public Avis(float avis, Date created) {
        this.avis = avis;
        this.created = created;
    }

}
